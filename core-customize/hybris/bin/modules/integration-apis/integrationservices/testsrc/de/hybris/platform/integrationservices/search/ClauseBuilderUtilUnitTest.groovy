/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.integrationservices.search

import de.hybris.bootstrap.annotations.UnitTest
import de.hybris.platform.core.enums.RelationEndCardinalityEnum
import de.hybris.platform.core.model.type.AttributeDescriptorModel
import de.hybris.platform.core.model.type.ComposedTypeModel
import de.hybris.platform.core.model.type.RelationDescriptorModel
import de.hybris.platform.core.model.type.RelationMetaTypeModel
import de.hybris.platform.integrationservices.model.IntegrationObjectItemModel
import de.hybris.platform.testframework.JUnitPlatformSpecification
import org.junit.Test
import spock.lang.Unroll

@UnitTest
class ClauseBuilderUtilUnitTest extends JUnitPlatformSpecification {

    @Test
    @Unroll
    def "get AttributeDescriptorModel from filter #filter returns an Optional with isPresent equals #present"() {
        when:
        def result = ClauseBuilderUtil.getAttributeDescriptorModelFromFilterAndType(filter, item.getType())

        then:
        result.isPresent() == present

        where:
        filter                                                                 | item                        | present
        null                                                                   | itemWithDeclaredRelation()  | false
        new SimplePropertyWhereClauseCondition('source', '=', '1234')          | itemWithNoRelation()        | false
        new SimplePropertyWhereClauseCondition('target', '=', '1234')          | itemWithDeclaredRelation()  | true
        new SimplePropertyWhereClauseCondition('source', '=', '1234')          | itemWithDeclaredRelation()  | true
        new SimplePropertyWhereClauseCondition('inheritedTarget', '=', '1234') | itemWithInheritedRelation() | true
        new SimplePropertyWhereClauseCondition('inheritedSource', '=', '1234') | itemWithInheritedRelation() | true
    }

    @Test
    @Unroll
    def "attribute '#attr' is source equals #isSource"() {
        given:
        def relationModel = manyToManyRelation("source", "target")

        expect:
        ClauseBuilderUtil.isAttributeSource(relationModel, attr) == isSource

        where:
        attr     | isSource
        "source" | true
        "target" | false
    }

    @Test
    def "get relation name alias"() {
        given:
        def relationModel = manyToManyRelation("source", "target")

        when:
        def alias = ClauseBuilderUtil.getRelationAlias(relationModel)

        then:
        "relationname" == alias
    }

    @Test
    def "get item alias"() {
        when:
        def alias = ClauseBuilderUtil.getItemAlias(itemWithDeclaredRelation())

        then:
        "item" == alias
    }

    @Test
    @Unroll
    def "is many to many relation is #isManyToMany when attribute descriptor is #descriptor"() {
        expect:
        ClauseBuilderUtil.isManyToManyRelation(descriptor) == isManyToMany

        where:
        descriptor                             | isManyToMany
        manyToManyRelation("source", "target") | true
        oneToManyRelation("source", 'target')  | false
    }

    @Test
    def "get relation name"() {
        expect:
        "RelationName" == ClauseBuilderUtil.getRelationName(oneToManyRelation("source", "target"))
    }

    RelationDescriptorModel manyToManyRelation(def source, def target) {
        relation(source, RelationEndCardinalityEnum.MANY, target, RelationEndCardinalityEnum.MANY)
    }

    RelationDescriptorModel oneToManyRelation(def source, def target) {
        relation(source, RelationEndCardinalityEnum.ONE, target, RelationEndCardinalityEnum.MANY)
    }

    RelationDescriptorModel relation(def source, def sourceCardinality, def target, def targetCardinality) {
        Stub(RelationDescriptorModel) {
            getRelationType() >> Stub(RelationMetaTypeModel) {
                getSourceTypeRole() >> source
                getTargetTypeRole() >> target
                getSourceTypeCardinality() >> sourceCardinality
                getTargetTypeCardinality() >> targetCardinality
            }
            getRelationName() >> "RelationName"
        }
    }

    IntegrationObjectItemModel itemWithDeclaredRelation() {
        def itemModel = createItemModel()
        itemModel.getType().getDeclaredattributedescriptors() >> [manyToManyRelation("source", "target")]
        itemModel
    }

    IntegrationObjectItemModel itemWithInheritedRelation() {
        def itemModel = createItemModel()
        itemModel.getType().getInheritedattributedescriptors() >> [manyToManyRelation("inheritedSource", "inheritedTarget")]
        itemModel
    }

    private IntegrationObjectItemModel createItemModel() {
        def stub = Stub(IntegrationObjectItemModel) {
            getType() >> Stub(ComposedTypeModel) {
                getCode() >> "Item"
            }
        }
        stub
    }

    IntegrationObjectItemModel itemWithNoRelation() {
        Stub(IntegrationObjectItemModel) {
            getType() >> Stub(ComposedTypeModel) {
                getDeclaredattributedescriptors() >> [Mock(AttributeDescriptorModel)]
            }
        }
    }
}
