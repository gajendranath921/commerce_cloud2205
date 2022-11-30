/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.odata2services.odata.schema

import de.hybris.bootstrap.annotations.UnitTest
import de.hybris.platform.integrationservices.model.DescriptorFactory
import de.hybris.platform.integrationservices.model.IntegrationObjectItemModel
import de.hybris.platform.integrationservices.model.TypeDescriptor
import de.hybris.platform.integrationservices.util.TestApplicationContext
import de.hybris.platform.odata2services.odata.InvalidODataSchemaException
import de.hybris.platform.odata2services.odata.schema.association.AssociationListGeneratorRegistry
import de.hybris.platform.odata2services.odata.schema.entity.EntityContainerGenerator
import de.hybris.platform.testframework.JUnitPlatformSpecification
import org.apache.olingo.odata2.api.commons.HttpStatusCodes
import org.apache.olingo.odata2.api.edm.provider.Association
import org.apache.olingo.odata2.api.edm.provider.EntityContainer
import org.apache.olingo.odata2.api.edm.provider.EntityType
import org.junit.Rule
import org.junit.Test

@UnitTest
class DefaultSchemaGeneratorUnitTest extends JUnitPlatformSpecification {
    private static final def NO_ITEMS = []
    private static final def IO_ITEM = new IntegrationObjectItemModel()
	private static final def ENTITY_TYPES = [new EntityType()]
	private static final def ASSOCIATIONS = [new Association()]
	private static final def ENTITY_CONTAINERS = [new EntityContainer()]

    @Rule
    TestApplicationContext applicationContext = new TestApplicationContext()

	private SchemaElementGenerator<List<EntityType>, Collection<IntegrationObjectItemModel>> entityTypeListGenerator = Stub(SchemaElementGenerator) {
        generate(_) >> { List args -> args[0] ? ENTITY_TYPES : [] }
    }
	private def associationListGeneratorRegistry = Stub(AssociationListGeneratorRegistry) {
        generateFor(_ as Collection<TypeDescriptor>) >> { List args -> args[0] ? ASSOCIATIONS : [] }
    }
	private def entityContainerGenerator = Stub(EntityContainerGenerator) {
        generate(ENTITY_TYPES, ASSOCIATIONS) >> ENTITY_CONTAINERS
    }
    private DefaultSchemaGenerator schemaGenerator = new DefaultSchemaGenerator(
            entityTypesGenerator: entityTypeListGenerator,
            associationListGeneratorRegistry: associationListGeneratorRegistry,
            entityContainerGenerator: entityContainerGenerator,
            descriptorFactory: Stub(DescriptorFactory))

    @Test
    def 'generate schema delegates to the default createItemTypeDescriptor when descriptor factory is not injected'() {
        given: 'descriptor factory is not injected'
        schemaGenerator.descriptorFactory = null

        and: 'descriptor factory is present in the application context'
        def contextDescriptorFactory = Mock DescriptorFactory
        applicationContext.addBean 'integrationServicesDescriptorFactory', contextDescriptorFactory

        when:
        schemaGenerator.generateSchema([IO_ITEM])

        then:
        1 * contextDescriptorFactory.createItemTypeDescriptor(_)
    }

	@Test
	def 'generate with null collection throws exception'() {
        when:
        schemaGenerator.generateSchema null

        then:
        def e = thrown InvalidODataSchemaException
        e.message == 'The EDMX schema could not be generated. Please make sure that your Integration Object is defined correctly.'
        e.cause instanceof IllegalArgumentException
        e.code == 'schema_generation_error'
        e.httpStatus == HttpStatusCodes.INTERNAL_SERVER_ERROR
	}

	@Test
	def 'generated schema has empty elements when collection of items is empty'() {
        given:
		def schema = schemaGenerator.generateSchema NO_ITEMS

        expect:
        with(schema) {
            namespace == 'HybrisCommerceOData'
            entityTypes.empty
            associations.empty
            entityContainers.empty
        }
    }

	@Test
	def 'generated schema contains non-empty elements when collection of items is not empty'() {
        given:
		def schema = schemaGenerator.generateSchema([IO_ITEM])

        expect:
        with(schema) {
            namespace == 'HybrisCommerceOData'
            entityTypes == ENTITY_TYPES
            associations == ASSOCIATIONS
            entityContainers == ENTITY_CONTAINERS
        }
	}

	@Test
	def testAnnotationAttributesContainsSapCommerceNamespace() {
        given:
		def schema = schemaGenerator.generateSchema NO_ITEMS

        expect:
		schema.annotationAttributes.size() == 1
		with(schema.annotationAttributes[0]) {
            name == 'schema-version'
            namespace == 'http://schemas.sap.com/commerce'
            prefix == 's'
            text == '1'
        }
	}
}
