/*
 *  Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.webhookservices


import com.github.tomakehurst.wiremock.junit.WireMockRule
import de.hybris.bootstrap.annotations.IntegrationTest
import de.hybris.platform.apiregistryservices.enums.DestinationChannel
import de.hybris.platform.apiregistryservices.model.DestinationTargetModel
import de.hybris.platform.apiregistryservices.model.events.EventConfigurationModel
import de.hybris.platform.core.model.c2l.CurrencyModel
import de.hybris.platform.core.model.user.CustomerModel
import de.hybris.platform.integrationservices.IntegrationObjectModelBuilder
import de.hybris.platform.integrationservices.util.IntegrationTestUtil
import de.hybris.platform.integrationservices.util.ItemTracker
import de.hybris.platform.integrationservices.util.impex.ModuleEssentialData
import de.hybris.platform.servicelayer.ServicelayerSpockSpecification
import de.hybris.platform.servicelayer.model.ModelService
import de.hybris.platform.webhookservices.event.ItemCreatedEvent
import de.hybris.platform.webhookservices.event.ItemSavedEvent
import de.hybris.platform.webhookservices.event.ItemUpdatedEvent
import de.hybris.platform.webhookservices.util.WebhookServicesEssentialData
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import spock.lang.AutoCleanup
import spock.lang.Issue
import spock.lang.Shared

import javax.annotation.Resource
import java.time.Duration

import static com.github.tomakehurst.wiremock.client.WireMock.*
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
import static de.hybris.platform.integrationservices.IntegrationObjectItemAttributeModelBuilder.integrationObjectItemAttribute
import static de.hybris.platform.integrationservices.IntegrationObjectItemModelBuilder.integrationObjectItem
import static de.hybris.platform.integrationservices.util.EventualCondition.eventualCondition
import static de.hybris.platform.outboundservices.ConsumedDestinationBuilder.consumedDestinationBuilder
import static de.hybris.platform.webhookservices.WebhookConfigurationBuilder.webhookConfiguration

@IntegrationTest
@Issue('https://cxjira.sap.com/browse/IAPI-4552')
class WebhookE2EIntegrationTest extends ServicelayerSpockSpecification {
    private static final String TEST_NAME = "WebhookConfigurationModeling"
    private static final String IO = "${TEST_NAME}_CustomerIO"
    private static final String UID = "${TEST_NAME.toLowerCase()}_tester"
    private static final String CURRENCY = 'CAD'
    private static final Duration REASONABLE_TIME = Duration.ofSeconds(7)
    private static final Duration TIME_FOR_EVENT_TO_PASS = Duration.ofSeconds(1)
    private static final String WEBHOOK_ENDPOINT = "${TEST_NAME}_WebhookEndpoint"
    private static final String DESTINATION_ID = "${TEST_NAME}_Destination"
    private static final def CLOUD_EVENT_TYPE_CREATED_OPERATION_VALUE = "Created"
    private static final def CLOUD_EVENT_TYPE_UPDATED_OPERATION_VALUE = "Updated"
    private static final def NAMESPACE_VALUE = "sap.cx.commerce"
    private static final def CE_ID_HEADER = "ce-id"
    private static final def CE_TYPE_HEADER = "ce-type"
    private static final def CE_SOURCE_HEADER = "ce-source"
    private static final def CE_SPECVERSION_HEADER = "ce-specversion"

    @Resource
    private ModelService modelService

    @Shared
    @ClassRule
    ModuleEssentialData essentialData = WebhookServicesEssentialData.webhookServicesEssentialData()
    @Shared
    @ClassRule
    IntegrationObjectModelBuilder io = IntegrationObjectModelBuilder.integrationObject().withCode(IO)
            .withItem(integrationObjectItem().withCode('Customer').root()
                    .withAttribute(integrationObjectItemAttribute('id').withQualifier('uid'))
                    .withAttribute(integrationObjectItemAttribute('forbidden').withQualifier('loginDisabled'))
                    .withAttribute(integrationObjectItemAttribute('currency').withQualifier('sessionCurrency').withReturnItem('Currency'))
                    .withAttribute(integrationObjectItemAttribute('addresses').withReturnItem('Email')))
            .withItem(integrationObjectItem().withCode('Currency')
                    .withAttribute(integrationObjectItemAttribute('code').withQualifier('isocode'))
                    .withAttribute(integrationObjectItemAttribute('symbol')))
            .withItem(integrationObjectItem().withCode('Email').withType('Address')
                    .withAttribute(integrationObjectItemAttribute('address').withQualifier('email').unique())
                    .withAttribute(integrationObjectItemAttribute('company'))
                    .withAttribute(integrationObjectItemAttribute('owner').withReturnItem('Customer').unique()))
    @Rule
    WireMockRule wireMockRule = new WireMockRule(wireMockConfig()
            .dynamicHttpsPort()
            .keystorePath("resources/devcerts/platform.jks")
            .keystorePassword('123456'))
    @Rule
    ItemTracker tracker = ItemTracker.track(CurrencyModel, CustomerModel)
    @AutoCleanup('cleanup')
    def webhookBuilder = webhookConfiguration().withIntegrationObject(IO)

    def setup() {
        stubFor(post(anyUrl()).willReturn(ok()))
    }

    @Test
    def 'notification payload contains all nested items when root integration object item is created'() {
        given: 'webhook configuration exists'
        webhookBuilder
                .withDestination(webhookDestination(WEBHOOK_ENDPOINT))
                .build()

        when: 'an item of the integration object root type is created'
        IntegrationTestUtil.importImpEx(
                'INSERT Currency; isocode[unique = true]; symbol',
                "               ; $CURRENCY             ; CAD",
                'INSERT Customer; uid[unique = true]; sessionCurrency(isocode); addresses(&addrPk)',
                "               ; $UID              ; $CURRENCY               ; email",
                'INSERT Address; &addrPk; owner(Customer.uid)[unique = true]; email[unique = true]',
                "              ; email  ; $UID                              ; $UID@company.net"
        )

        then: 'the payload contains root and the nested items'
        eventualCondition().within(REASONABLE_TIME).expect {
            verify postRequestedFor(urlPathEqualTo("/$WEBHOOK_ENDPOINT"))
                    .withRequestBody(matchingJsonPath("\$.[?(@.id == '$UID')]"))
                    .withRequestBody(matchingJsonPath("\$.[?(@.currency.code == '$CURRENCY')]"))
                    .withRequestBody(matchingJsonPath("\$.[?(@.addresses[0].address == '$UID@company.net')]"))
        }
    }

    @Test
    def 'notification payload contains final state of the root integration object item updates'() {
        given: 'a webhook configuration exists'
        webhookBuilder
                .withDestination(webhookDestination(WEBHOOK_ENDPOINT))
                .build()

        when: 'item of root integration object type is created'
        IntegrationTestUtil.importImpEx(
                'INSERT Customer; uid[unique = true]',
                "               ; $UID")
        and: 'the root item is updated once'
        IntegrationTestUtil.importImpEx(
                'INSERT Currency; isocode[unique = true]; symbol',
                "               ; $CURRENCY             ; CAD",
                'UPDATE Customer; uid[unique = true]; sessionCurrency(isocode)',
                "               ; $UID              ; $CURRENCY")
        and: 'the root item is updated twice'
        IntegrationTestUtil.importImpEx(
                'UPDATE Customer; uid[unique = true]; loginDisabled',
                "               ; $UID              ; true")

        then: 'the notification payload contains the combined state of all updates'
        eventualCondition().within(REASONABLE_TIME).expect {
            verify postRequestedFor(urlPathEqualTo("/$WEBHOOK_ENDPOINT"))
                    .withRequestBody(matchingJsonPath("\$.[?(@.id == '$UID')]"))
                    .withRequestBody(matchingJsonPath("\$.[?(@.currency.code == '$CURRENCY')]"))
                    .withRequestBody(matchingJsonPath("\$.[?(@.forbidden == true)]"))
        }
    }

    @Test
    def 'notification payload contains integration key for every item in the payload'() {
        given: 'a webhook configuration exists'
        webhookBuilder
                .withDestination(webhookDestination(WEBHOOK_ENDPOINT))
                .build()

        when: 'the root and the nested items are created'
        IntegrationTestUtil.importImpEx(
                'INSERT Currency; isocode[unique = true]; symbol',
                "               ; $CURRENCY             ; \$",
                'INSERT Customer; uid[unique = true]; sessionCurrency(isocode)',
                "               ; $UID              ; $CURRENCY")

        then: 'the payload contains integrationKey calculated for the items'
        eventualCondition().within(REASONABLE_TIME).expect {
            verify postRequestedFor(urlPathEqualTo("/$WEBHOOK_ENDPOINT"))
                    .withRequestBody(matchingJsonPath("\$.[?(@.integrationKey == '$UID')]"))
                    .withRequestBody(matchingJsonPath("\$.[?(@.currency.integrationKey == '$CURRENCY')]"))
        }
    }

    @Test
    def 'notification contains SAP passport headers'() {
        given: 'a webhook configuration exists'
        webhookBuilder
                .withDestination(webhookDestination(WEBHOOK_ENDPOINT))
                .build()

        when: 'a root item is created'
        IntegrationTestUtil.importImpEx(
                'INSERT Customer; uid[unique = true]',
                "               ; $UID")

        then: 'the web hook is notified with the SAP-Passport header'
        eventualCondition().within(REASONABLE_TIME).expect {
            verify postRequestedFor(urlPathEqualTo("/$WEBHOOK_ENDPOINT"))
                    .withHeader('sap-passport', matching('\\w+'))
        }
    }

    @Issue('https://cxjira.sap.com/browse/IAPI-5118')
    def 'notification is sent to the webhook with CloudEvent headers'() {
        given: 'webhook configuration created'
        webhookBuilder
                .withDestination(webhookDestination(WEBHOOK_ENDPOINT))
                .build()

        when: 'item is created'
        IntegrationTestUtil.importImpEx(
                'INSERT Customer; uid[unique = true]',
                "               ; $UID")

        then: 'the web hook is notified and contains CloudEvent headers'
        eventualCondition().within(REASONABLE_TIME).expect {
            verify postRequestedFor(urlPathEqualTo("/$WEBHOOK_ENDPOINT"))
                    .withHeader(CE_SPECVERSION_HEADER, equalTo("1.0"))
                    .withHeader(CE_TYPE_HEADER, containing("$NAMESPACE_VALUE.$IO"))
                    .withHeader(CE_SOURCE_HEADER, containing(NAMESPACE_VALUE))
                    .withHeader(CE_ID_HEADER, matching('^.{1,64}$'))
        }
    }

    @Test
    @Issue('https://cxjira.sap.com/browse/IAPI-5120')
    def 'notification is sent to the webhook when WebhookConfiguration event type is ItemCreatedEvent'() {
        given: 'webhook configuration exists'
        webhookBuilder
                .withDestination(webhookDestination(WEBHOOK_ENDPOINT))
                .withEvent(ItemCreatedEvent)
                .build()

        when: 'an item of the integration object root type is created'
        IntegrationTestUtil.importImpEx(
                'INSERT Customer; uid[unique = true]',
                "               ; $UID              "
        )

        then: 'the web hook is notified'
        eventualCondition().within(REASONABLE_TIME).expect {
            verify postRequestedFor(urlPathEqualTo("/$WEBHOOK_ENDPOINT"))
                    .withHeader(CE_TYPE_HEADER, containing("$CLOUD_EVENT_TYPE_CREATED_OPERATION_VALUE"))
        }
    }

    @Test
    @Issue('https://cxjira.sap.com/browse/IAPI-5121')
    def 'notification is sent to the webhook when WebhookConfiguration event type is ItemUpdatedEvent'() {
        given: 'ItemSavedEvent is not exported'
        def eventConfig = contextEventConfig ItemSavedEvent
        eventConfig.exportFlag = false
        modelService.save(eventConfig)
        and: 'an item of the integration object root type is created'
        IntegrationTestUtil.importImpEx(
                'INSERT Customer; uid[unique = true]; loginDisabled',
                "               ; $UID              ; false"
        )
        and: 'wait for the ItemSavedEvent to pass'
        eventualCondition()
                .within(TIME_FOR_EVENT_TO_PASS)
                .retains { eventConfig.exportFlag }
        and: 'ItemSavedEvent is exported again'
        eventConfig.exportFlag = true
        modelService.save(eventConfig)
        and: 'webhook configuration exists for ItemUpdatedEvent'
        webhookBuilder
                .withDestination(webhookDestination(WEBHOOK_ENDPOINT))
                .withEvent(ItemUpdatedEvent)
                .build()

        when: 'item is updated'
        IntegrationTestUtil.importImpEx(
                'UPDATE Customer; uid[unique = true]; loginDisabled',
                "               ; $UID              ; true")

        then: 'the web hook is notified'
        eventualCondition().within(REASONABLE_TIME).expect {
            verify postRequestedFor(urlPathEqualTo("/$WEBHOOK_ENDPOINT"))
                   .withHeader(CE_TYPE_HEADER, containing("$CLOUD_EVENT_TYPE_UPDATED_OPERATION_VALUE"))
        }
    }

    def webhookDestination(String uri, String id = DESTINATION_ID) {
        consumedDestinationBuilder()
                .withId(id)
                .withUrl("https://localhost:${wireMockRule.httpsPort()}/$uri")
                .withDestinationTarget('webhookServices') // created in essential data
    }

    EventConfigurationModel contextEventConfig(Class eventType) {
        def eventConfigs = IntegrationTestUtil.findAny(DestinationTargetModel, { it.destinationChannel == DestinationChannel.WEBHOOKSERVICES })
                .map({ it.eventConfigurations })
                .orElse([]) as List<EventConfigurationModel>
        eventConfigs.find {it.eventClass == eventType.canonicalName }
    }
}
