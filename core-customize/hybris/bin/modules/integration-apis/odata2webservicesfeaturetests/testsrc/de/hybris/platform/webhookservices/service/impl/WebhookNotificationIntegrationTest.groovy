/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.webhookservices.service.impl

import de.hybris.bootstrap.annotations.IntegrationTest
import de.hybris.platform.core.model.ItemModel
import de.hybris.platform.core.model.user.AddressModel
import de.hybris.platform.core.model.user.CustomerModel
import de.hybris.platform.core.model.user.UserModel
import de.hybris.platform.integrationservices.IntegrationObjectModelBuilder
import de.hybris.platform.integrationservices.util.IntegrationTestUtil
import de.hybris.platform.integrationservices.util.Log
import de.hybris.platform.integrationservices.util.impex.ModuleEssentialData
import de.hybris.platform.odata2webservicesfeaturetests.model.TestIntegrationItemModel
import de.hybris.platform.outboundservices.enums.OutboundSource
import de.hybris.platform.outboundservices.event.EventType
import de.hybris.platform.outboundservices.event.impl.DefaultEventType
import de.hybris.platform.outboundservices.facade.OutboundServiceFacade
import de.hybris.platform.outboundservices.facade.SyncParameters
import de.hybris.platform.outboundservices.util.TestOutboundFacade
import de.hybris.platform.servicelayer.ServicelayerSpockSpecification
import de.hybris.platform.webhookservices.WebhookConfigurationBuilder
import de.hybris.platform.webhookservices.util.WebhookServicesEssentialData
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import spock.lang.AutoCleanup
import spock.lang.Issue
import spock.lang.Shared

import javax.annotation.Resource
import java.time.Duration

import static de.hybris.platform.integrationservices.IntegrationObjectItemAttributeModelBuilder.integrationObjectItemAttribute
import static de.hybris.platform.integrationservices.IntegrationObjectItemModelBuilder.integrationObjectItem
import static de.hybris.platform.integrationservices.IntegrationObjectModelBuilder.integrationObject
import static de.hybris.platform.integrationservices.util.EventualCondition.eventualCondition
import static de.hybris.platform.outboundservices.ConsumedDestinationBuilder.consumedDestinationBuilder
import static de.hybris.platform.webhookservices.WebhookConfigurationBuilder.webhookConfiguration

/**
 * Tests corner cases with contrived types, which otherwise would be difficult to test in webhookservices
 * The type hierarchy that is used is: User <- Customer
 */
@IntegrationTest
@Issue('CXEC-1387')
class WebhookNotificationIntegrationTest extends ServicelayerSpockSpecification {
    private static final def LOG = Log.getLogger WebhookNotificationIntegrationTest
    private static final def TEST_NAME = 'WebhookNotification'
    private static final def DESTINATION = "${TEST_NAME}_Items"
    private static final def IO = "${TEST_NAME}_CustomerIO"
    private static final def CUSTOMER = TEST_NAME.toLowerCase()
    private static final def ADDRESS_KEY = "${TEST_NAME}_Address"
    private static final def REASONABLE_TIME = Duration.ofSeconds(6)
    private static final def WAIT_AFTER_CHANGES_SENT = Duration.ofSeconds(3)
    private OutboundServiceFacade originalOutboundServiceFacade
    @Resource(name ="webhookEventToItemSender")
    private WebhookEventToItemSender webhookEventSender

    @Shared
    @ClassRule
    ModuleEssentialData essentialData = WebhookServicesEssentialData.webhookServicesEssentialData()
    @Rule
    IntegrationObjectModelBuilder io = integrationObject().withCode(IO)

    @Rule
    TestOutboundFacade testOutboundServiceFacade = new TestOutboundFacade().respondWithCreated()
    @AutoCleanup('cleanup')
    WebhookConfigurationBuilder webhookBuilder = webhookConfiguration()
            .withIntegrationObject(IO)
            .withDestination consumedDestinationBuilder()
            .withId(DESTINATION)
            .withUrl('https://does/not/matter')
            .withDestinationTarget('webhookServices') // created in essential data


    def setup() {
        originalOutboundServiceFacade = webhookEventSender.outboundServiceFacade
        webhookEventSender.outboundServiceFacade = testOutboundServiceFacade
    }

    def cleanup() {
        webhookEventSender.outboundServiceFacade = originalOutboundServiceFacade
        IntegrationTestUtil.remove(UserModel) { it.uid == CUSTOMER }
        IntegrationTestUtil.remove(AddressModel) { it.publicKey == ADDRESS_KEY }
    }

    @Test
    def 'notification is not sent when a supertype of the root item created'() {
        given: 'an IntegrationObject exists with Customer as root'
        io.withItem(integrationObjectItem().withCode('Customer').root()
                .withAttribute(integrationObjectItemAttribute('id')
                        .withQualifier('uid')
                        .unique())).build()

        and: 'a webhook config exists'
        webhookBuilder.build()

        when: 'supertype of the root type is created'
        createUser()

        then:
        noChangesSentToWebhooks()
    }

    @Test
    def 'notification is sent when a subtype of the root item created'() {
        given: 'an IntegrationObject exists with User as root'
        io.withItem(integrationObjectItem().withCode('User').root()
                .withAttribute(integrationObjectItemAttribute('id')
                        .withQualifier('uid').unique())).build()

        and: 'a webhook config exists'
        webhookBuilder.build()

        when: 'subtype of the root item type is created'
        def customer = createCustomer()

        then:
        changesSentToWebhooksAre created(customer)
    }

    @Test
    def 'changes not sent when the referenced item has no navigation path to the root in the integration object'() {
        given: 'an IntegrationObject exists with User as root'
        io.withItem(integrationObjectItem().withCode('User').root()
                .withAttribute(integrationObjectItemAttribute('id').withQualifier('uid').unique())
                .withAttribute(integrationObjectItemAttribute('paymentAddress').withQualifier('defaultPaymentAddress').withReturnItem('Address')))
                .withItem(integrationObjectItem().withCode('Address')
                        .withAttribute(integrationObjectItemAttribute('key').withQualifier('publicKey').unique())).build()

        and: 'a root item exist'
        def user = createUser()
        and:
        waitForChangesToBeProcessedByListener()
        and: 'a webhook config exists'
        webhookBuilder.build()

        when: 'a child item is added to the root item'
        createAddress(user)

        then:
        noChangesSentToWebhooks()
    }

    @Test
    def 'root item is sent when a child of the root item subtype is updated'() {
        given: 'an IntegrationObject exists with User as root'
        io.withItem(integrationObjectItem().withCode('User').root()
                .withAttribute(integrationObjectItemAttribute('id').withQualifier('uid').unique())
                .withAttribute(integrationObjectItemAttribute('paymentAddress').withQualifier('defaultPaymentAddress').withReturnItem('Address')))
            .withItem(integrationObjectItem().withCode('Address')
                        .withAttribute(integrationObjectItemAttribute('key').withQualifier('publicKey').unique())
                        .withAttribute(integrationObjectItemAttribute('owner').withQualifier('owner').withReturnItem('User'))).build()

        and: 'a subtype of the root item type exists'
        def customer = createCustomerWithAddress()
        and:
        waitForChangesToBeProcessedByListener()
        and: 'a webhook config exists'
        webhookBuilder.build()

        when: "the Customer address is updated"
        updateAddress(customer)

        then:
        changesSentToWebhooksAre updated(customer)
    }

    @Test
    def 'only changed item is sent when root item references itself in the integration object'() {
        given: 'root item contains self-reference to the same type in the integration object'
        io.withItem(integrationObjectItem().withCode('TestIntegrationItem').root()
                .withAttribute(integrationObjectItemAttribute().withName('code').unique())
                .withAttribute(integrationObjectItemAttribute().withName('otherItem').withReturnItem('TestIntegrationItem')))
                .build()

        and: 'two items exist'
        def childCode = "${TEST_NAME}_Child"
        def parentCode = "${TEST_NAME}_Parent"
        def child = createParentItem childCode
        createParentItem parentCode, child

        and:
        waitForChangesToBeProcessedByListener()
        and: 'a webhook config exists'
        webhookBuilder.build()

        when: 'the "child" item is changed'
        updateItemName(child, 'some value - does not matter')

        then:
        changesSentToWebhooksAre updated(child)

        cleanup:
        IntegrationTestUtil.remove(TestIntegrationItemModel) { it.code == childCode || it.code == parentCode }
    }

    private static TestIntegrationItemModel createParentItem(String code, TestIntegrationItemModel refItem = null) {
        def refItemPk = refItem ? String.valueOf(refItem.pk) : ''

        IntegrationTestUtil.importImpEx(
                'INSERT TestIntegrationItem; code[unique = true]; otherItem',
                "                          ; $code              ; $refItemPk")
        IntegrationTestUtil.findAny(TestIntegrationItemModel, { it.code == code }).orElse(null)
                .tap { LOG.info('Created {}', it) }
    }

    private static void updateItemName(TestIntegrationItemModel item, String name) {
        IntegrationTestUtil.importImpEx(
                'UPDATE TestIntegrationItem; pk[unique = true]; string',
                "                          ; $item.pk         ; $name")
    }

    private static AddressModel createAddress(UserModel user) {
        IntegrationTestUtil.importImpEx(
                'INSERT_UPDATE Address; &addrID   ; email[unique = true] ; owner   ; company',
                "                     ; $ADDRESS_KEY; user123@some.net     ; $user.pk; hybris")
        IntegrationTestUtil.findAny(AddressModel, { it.owner.pk == user.pk }).orElse(null)
                .tap { LOG.info 'Created {}', it }
    }

    private static AddressModel updateAddress(UserModel user) {
        IntegrationTestUtil.importImpEx(
                'INSERT_UPDATE Address; &addrID   ; email[unique = true] ; owner   ; company',
                "                     ; $ADDRESS_KEY; newEmail@some.net     ; $user.pk; hybris")
        IntegrationTestUtil.findAny(AddressModel, { it.owner.pk == user.pk }).orElse(null)
                .tap { LOG.info 'Created {}', it }
    }

    private static CustomerModel createCustomerWithAddress() {
        IntegrationTestUtil.importImpEx(
                'INSERT_UPDATE Customer; uid[unique = true]; defaultPaymentAddress( &addrID )',
                "                      ; $CUSTOMER           ; $ADDRESS_KEY",
                'INSERT_UPDATE Address; &addrID   ; email[unique = true] ; owner(Customer.uid); company',
                "                     ; $ADDRESS_KEY; user123@some.net     ; $CUSTOMER          ; hybris")
        IntegrationTestUtil.findAny(CustomerModel, { it.uid == CUSTOMER }).orElse(null)
                .tap { LOG.info 'Created {}', it }
    }

    private static CustomerModel createCustomer(String uid = CUSTOMER) {
        IntegrationTestUtil.importImpEx(
                'INSERT Customer; uid[unique = true]',
                "               ; $uid")
        IntegrationTestUtil.findAny(CustomerModel, { it.uid == uid }).orElse(null)
                .tap { LOG.info 'Created {}', it }
    }

    private static UserModel createUser(String uid = CUSTOMER) {
        IntegrationTestUtil.importImpEx(
                'INSERT User; uid[unique = true]',
                "               ; $uid")
        IntegrationTestUtil.findAny(UserModel, { it.uid == uid }).orElse(null)
                .tap { LOG.info 'Created {}', it }
    }

    private static SyncParameters created(ItemModel item, String dest = DESTINATION, String io = IO) {
        change(item, DefaultEventType.CREATED, dest, io)
    }

    private static SyncParameters updated(ItemModel item, String dest = DESTINATION, String io = IO) {
        change(item, DefaultEventType.UPDATED, dest, io)
    }

    private static SyncParameters change(ItemModel item, EventType change, String dest, String io) {
        SyncParameters.syncParametersBuilder()
                .withItem(item)
                .withDestinationId(dest)
                .withIntegrationObjectCode(io)
                .withSource(OutboundSource.WEBHOOKSERVICES)
                .withEventType(change)
                .build()
    }

    private static void waitForChangesToBeProcessedByListener() {
        eventualCondition().within(WAIT_AFTER_CHANGES_SENT).retains { assert true }
    }

    private void noChangesSentToWebhooks() {
        eventualCondition().within(REASONABLE_TIME).retains {
            assert testOutboundServiceFacade.allInvocations.empty
        }
    }

    private void changesSentToWebhooksAre(SyncParameters... changes) {
        eventualCondition().expect { sent changes as List }
    }

    private void sent(List<SyncParameters> expected) {
        def actual = testOutboundServiceFacade.allInvocations
        assert actual.containsAll(expected)
        assert actual.size() == expected.size()
    }
}
