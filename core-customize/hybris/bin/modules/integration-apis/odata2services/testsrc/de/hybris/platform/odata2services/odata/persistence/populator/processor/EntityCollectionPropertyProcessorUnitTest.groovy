/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.odata2services.odata.persistence.populator.processor

import de.hybris.bootstrap.annotations.UnitTest
import de.hybris.platform.core.HybrisEnumValue
import de.hybris.platform.core.model.ItemModel
import de.hybris.platform.integrationservices.model.AttributeValueAccessor
import de.hybris.platform.integrationservices.model.TypeAttributeDescriptor
import de.hybris.platform.integrationservices.model.TypeDescriptor
import de.hybris.platform.integrationservices.service.ItemTypeDescriptorService
import de.hybris.platform.odata2services.odata.persistence.ItemConversionRequest
import de.hybris.platform.odata2services.odata.persistence.ModelEntityService
import de.hybris.platform.testframework.JUnitPlatformSpecification
import org.apache.olingo.odata2.api.ep.entry.ODataEntry
import org.apache.olingo.odata2.core.ep.entry.EntryMetadataImpl
import org.apache.olingo.odata2.core.ep.entry.MediaMetadataImpl
import org.apache.olingo.odata2.core.ep.entry.ODataEntryImpl
import org.apache.olingo.odata2.core.uri.ExpandSelectTreeNodeImpl
import org.junit.Test
import spock.lang.Unroll

@UnitTest
class EntityCollectionPropertyProcessorUnitTest extends JUnitPlatformSpecification {
    private static final String INTEGRATION_OBJECT_CODE = 'IntegrationObjectType'
    private static final String ITEM_TYPE = 'TypeA'
    private static final String TEST_ATTRIBUTE = 'attributeName'

    def entityService = Stub ModelEntityService
    def valueAccessor = Stub AttributeValueAccessor
    def itemTypeDescriptorService = Stub(ItemTypeDescriptorService) {
        getTypeDescriptorByTypeCode(_ as String, _ as String) >> Optional.of(
                Stub(TypeDescriptor) {
                    getAttribute(TEST_ATTRIBUTE) >> Optional.of(applicableDescriptor())
                }
        )
    }

    protected EntityCollectionPropertyProcessor propertyProcessor = new EntityCollectionPropertyProcessor(
            modelEntityService: entityService,
            itemTypeDescriptorService: itemTypeDescriptorService)

    @Test
    @Unroll
    def "populates OData entry attribute when #objDesc has empty collection value and should be converted"() {
        given: "#objDesc is being converted has empty collection value for #TEST_ATTRIBUTE attribute"
        valueAccessor.getValue(obj) >> []
        and: 'request should convert the attribute'
        def request = conversionRequest(obj)
        request.isPropertyValueShouldBeConverted(TEST_ATTRIBUTE) >> true
        and: 'an ODataEntry to be populated'
        def entry = oDataEntry()

        when:
        propertyProcessor.processEntity entry, request

        then: 'the converted entry contains empty feed for the attribute'
        entry.properties.containsKey TEST_ATTRIBUTE
        entry.properties[TEST_ATTRIBUTE].entries.empty

        where:
        objDesc      | obj
        'item model' | item()
        'enum value' | enumValue()
    }

    @Test
    @Unroll
    def "populates OData entry attribute when its value should be converted and contains a collection of #elDesc"() {
        given: "item model being converted contains a collection with nested #elDesc for the attribute"
        def item = item()
        valueAccessor.getValue(item) >> [element]
        and: 'the collection element converts to an OData entry in its turn'
        def elementConvertedToEntry = Stub ODataEntry
        entityService.getODataEntry({ it.value.is element}) >> elementConvertedToEntry
        and: 'request should convert the attribute'
        def request = conversionRequest(item)
        request.isPropertyValueShouldBeConverted(TEST_ATTRIBUTE) >> true
        and: 'an ODataEntry to be populated'
        def entry = oDataEntry()

        when:
        propertyProcessor.processEntity entry, request

        then:
        entry.properties[TEST_ATTRIBUTE]?.entries == [elementConvertedToEntry]

        where:
        elDesc        | element
        'item models' | Stub(ItemModel)
        'enum values' | enumValue()
    }

    @Test
    def 'does not populate OData entry attribute when request should not convert attribute value'() {
        given: "item model being converted contains a collection with nested #elDesc for the attribute"
        def item = item()
        valueAccessor.getValue(item) >> [Stub(ItemModel)]
        and: 'the conversion request contains navigation segment for a different attribute'
        def request = conversionRequest(item)
        request.isPropertyValueShouldBeConverted(TEST_ATTRIBUTE) >> false
        and: 'an ODataEntry to be populated'
        def entry = oDataEntry()

        when:
        propertyProcessor.processEntity entry, request

        then:
        entry.properties.isEmpty()
    }

    @Test
    def 'does not populate OData entry attribute when its value is not a collection in the item model'() {
        given: 'item model being converted contains a non-collection value for the attribute'
        def item = item()
        and: 'an ODataEntry to be populated'
        def entry = oDataEntry()

        when:
        propertyProcessor.processEntity entry, conversionRequest(item)

        then:
        entry.properties.isEmpty()
    }

    private TypeAttributeDescriptor applicableDescriptor() {
        descriptor(collection: true, primitive: false, readable: true)
    }

    private TypeAttributeDescriptor descriptor(Map<String, Boolean> params) {
        Stub(TypeAttributeDescriptor) {
            isCollection() >> params['collection']
            isPrimitive() >> params['primitive']
            isReadable() >> params['readable']
            accessor() >> valueAccessor
        }
    }

    private static ODataEntry oDataEntry() {
        new ODataEntryImpl([:], new MediaMetadataImpl(), new EntryMetadataImpl(), new ExpandSelectTreeNodeImpl())
    }

    private ItemConversionRequest conversionRequest(def value) {
        Stub(ItemConversionRequest) {
            getIntegrationObjectCode() >> INTEGRATION_OBJECT_CODE
            getAcceptLocale() >> Locale.ENGLISH
            getValue() >> value
            getAllPropertyNames() >> [TEST_ATTRIBUTE]
        }
    }

    private ItemModel item() {
        Stub(ItemModel) {
            getItemtype() >> ITEM_TYPE
        }
    }

    private HybrisEnumValue enumValue() {
        Stub(HybrisEnumValue) {
            getType() >> ITEM_TYPE
        }
    }
}
