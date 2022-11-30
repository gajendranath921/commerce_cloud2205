/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.outboundservices.facade.impl

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.junit.WireMockRule
import com.github.tomakehurst.wiremock.stubbing.Scenario
import de.hybris.bootstrap.annotations.IntegrationTest
import de.hybris.platform.catalog.model.CatalogModel
import de.hybris.platform.catalog.model.CatalogVersionModel
import de.hybris.platform.core.Registry
import de.hybris.platform.integrationservices.util.ConfigurationRule
import de.hybris.platform.integrationservices.util.IntegrationObjectTestUtil
import de.hybris.platform.integrationservices.util.IntegrationTestUtil
import de.hybris.platform.integrationservices.util.timeout.IntegrationTimeoutException
import de.hybris.platform.outboundservices.ConsumedDestinationBuilder
import de.hybris.platform.outboundservices.client.impl.DefaultClientRequestFactory
import de.hybris.platform.outboundservices.config.DefaultOutboundServicesConfiguration
import de.hybris.platform.outboundservices.decorator.DecoratorContextErrorException
import de.hybris.platform.outboundservices.enums.OutboundSource
import de.hybris.platform.outboundservices.facade.OutboundServiceFacade
import de.hybris.platform.outboundservices.facade.SyncParameters
import de.hybris.platform.outboundservices.model.OutboundRequestModel
import de.hybris.platform.outboundservices.util.OutboundMonitoringRule
import de.hybris.platform.servicelayer.ServicelayerSpockSpecification
import org.junit.Rule
import org.junit.Test
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import rx.observers.TestSubscriber
import spock.lang.Issue

import javax.annotation.Resource

import static com.github.tomakehurst.wiremock.client.WireMock.badRequest
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo
import static com.github.tomakehurst.wiremock.client.WireMock.exactly
import static com.github.tomakehurst.wiremock.client.WireMock.get
import static com.github.tomakehurst.wiremock.client.WireMock.matching
import static com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import static com.github.tomakehurst.wiremock.client.WireMock.notFound
import static com.github.tomakehurst.wiremock.client.WireMock.ok
import static com.github.tomakehurst.wiremock.client.WireMock.okJson
import static com.github.tomakehurst.wiremock.client.WireMock.post
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import static com.github.tomakehurst.wiremock.client.WireMock.verify
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
import static de.hybris.platform.apiregistryservices.services.impl.DefaultApiRegistryClientService.CLIENT_SCOPE
import static de.hybris.platform.integrationservices.constants.IntegrationservicesConstants.SAP_PASSPORT_HEADER_NAME
import static de.hybris.platform.integrationservices.util.IntegrationTestUtil.assertModelDoesNotExist
import static de.hybris.platform.integrationservices.util.IntegrationTestUtil.assertModelExists
import static de.hybris.platform.integrationservices.util.IntegrationTestUtil.importImpEx
import static de.hybris.platform.integrationservices.util.IntegrationTestUtil.removeAll
import static de.hybris.platform.outboundservices.ConsumedDestinationBuilder.consumedDestinationBuilder
import static de.hybris.platform.outboundservices.ConsumedOAuthCredentialBuilder.consumedOAuthCredentialBuilder
import static de.hybris.platform.outboundservices.OAuthClientDetailsBuilder.oAuthClientDetailsBuilder
import static de.hybris.platform.outboundservices.client.impl.ContextConnectionPool.getPoolStats

@IntegrationTest
class OutboundServiceFacadeIntegrationTest extends ServicelayerSpockSpecification {

    private static final def TEST_NAME = "OutboundServiceFacade"
    private static final def DESTINATION_ENDPOINT = '/odata2webservices/OutboundCatalogVersion/CatalogVersions'
    private static final def OTHER_DESTINATION_ENDPOINT = "$DESTINATION_ENDPOINT/other"
    private static final def DESTINATION_ID = "${TEST_NAME}_Destination"
    private static final def OTHER_DESTINATION_ID = "other$DESTINATION_ID"
    private static final def OAUTH_ENDPOINT = '/authorizationserver/oauth/token'
    private static final def CSRF_ENDPOINT = '/csrf'
    private static final def CATALOG_VERSION_IO = "${TEST_NAME}_CatalogVersionIO"
    private static final def CATALOG_VERSION = 'facadeTestVersion'
    private static final def CATALOG_ID = "${TEST_NAME}_Catalog"
    private static final def CATALOG_VERSION_ITEM = new CatalogVersionModel(version: CATALOG_VERSION, catalog: new CatalogModel(id: CATALOG_ID))
    private static final def THREE_INDIVIDUAL_PARAMETERS = [CATALOG_VERSION_ITEM, CATALOG_VERSION_IO, DESTINATION_ID]
    private static final def ONE_PARAMETER_OBJECT = [syncParameters()]
    private static final def CLIENT_ID = "${TEST_NAME}_Client"
    private static final def CLIENT_SECRET = "${TEST_NAME}_Secret"
    private static final def SCOPE = "${TEST_NAME}_Scope"
    private static final def OAUTH_TOKEN = "${TEST_NAME}_OAuthToken"
    private static final def OTHER_OAUTH_TOKEN = "other$OAUTH_TOKEN"
    private static final def CREDENTIAL_ID = "${TEST_NAME}_CredentialId"
    private static final def GRANT_TYPE = 'client_credentials'
    private static final def PARAMS_WITH_SCOPE = [(CLIENT_SCOPE): SCOPE]

    @Rule
    WireMockRule wireMockRule = new WireMockRule(wireMockConfig()
            .dynamicHttpsPort()
            .keystorePath("resources/devcerts/platform.jks")
            .keystorePassword('123456'))
    @Rule
    OutboundMonitoringRule outboundMonitoringRule = OutboundMonitoringRule.enabled()
    @Rule
    ConfigurationRule configurationRule = ConfigurationRule.createFor 'defaultOutboundServicesConfiguration', DefaultOutboundServicesConfiguration
    @Rule
    ConsumedDestinationBuilder destinationBuilder = consumedDestinationBuilder().withId(DESTINATION_ID)

    @Resource
    private OutboundServiceFacade outboundServiceFacade

    private TestSubscriber<ResponseEntity<Map>> subscriber = new TestSubscriber<>()

    def setupSpec() {
        importImpEx(
                'INSERT_UPDATE IntegrationObject; code[unique = true]',
                "                               ; $CATALOG_VERSION_IO",
                'INSERT_UPDATE IntegrationObjectItem; integrationObject(code)[unique = true]; code[unique = true]; type(code)     ; root[default = false]',
                "                                   ; $CATALOG_VERSION_IO                   ; Catalog            ; Catalog        ;",
                "                                   ; $CATALOG_VERSION_IO                   ; CatalogVersion     ; CatalogVersion ; true",
                'INSERT_UPDATE IntegrationObjectItemAttribute; integrationObjectItem(integrationObject(code), code)[unique = true]; attributeName[unique = true]; attributeDescriptor(enclosingType(code), qualifier); returnIntegrationObjectItem(integrationObject(code), code); unique[default = false]',
                "                                            ; $CATALOG_VERSION_IO:Catalog                                        ; id                          ; Catalog:id",
                "                                            ; $CATALOG_VERSION_IO:CatalogVersion                                 ; catalog                     ; CatalogVersion:catalog                             ; $CATALOG_VERSION_IO:Catalog",
                "                                            ; $CATALOG_VERSION_IO:CatalogVersion                                 ; version                     ; CatalogVersion:version                             ;")
    }

    def setup() {
        destinationBuilder
                .withUrl(urlTo(DESTINATION_ENDPOINT))
                .build()
        setupDefaultRequestStubbing()
        resetHttpClientCache()
    }

    def cleanup() {
        removeAll OutboundRequestModel
    }

    def cleanupSpec() {
        IntegrationObjectTestUtil.cleanup()
    }

    @Test
    def "send a catalog version out with parameters #params succeeds when the destination respond within timeout limit"() {
        given: 'request timeout set to 1000 ms'
        configurationRule.configuration().requestExecutionTimeout = 1000

        and: 'stub destination server to return OK after 500 ms'
        stubFor(post(urlEqualTo(DESTINATION_ENDPOINT))
                .willReturn(ok().withFixedDelay(500)))

        when:
        outboundServiceFacade.send(*params).subscribe(subscriber)

        then: "destination server stub is called"
        verify(postRequestedFor(urlEqualTo(DESTINATION_ENDPOINT))
                .withRequestBody(matchVersion(CATALOG_VERSION))
                .withRequestBody(matchCatalogId(CATALOG_ID))
                .withHeader(SAP_PASSPORT_HEADER_NAME, matchPassport()))

        and: "observable contains response with OK HTTP status "
        subscriber.getOnNextEvents()[0].getStatusCode() == HttpStatus.OK

        where:
        params << [THREE_INDIVIDUAL_PARAMETERS, ONE_PARAMETER_OBJECT]
    }

    @Test
    def "send a catalog version out with parameters #params fails when the destination exceeds the timeout limit to respond"() {
        given: 'request timeout set to 500 ms'
        configurationRule.configuration().requestExecutionTimeout = 500

        and: 'the destination responds in over 500 ms'
        stubFor(post(urlEqualTo(DESTINATION_ENDPOINT)).willReturn(ok().withFixedDelay(600)))

        when:
        outboundServiceFacade.send(*params).subscribe(subscriber)

        then: "destination server stub is called"
        verify(postRequestedFor(urlEqualTo(DESTINATION_ENDPOINT)))

        and: "observable contains an error"
        subscriber.assertError(IntegrationTimeoutException)

        and: 'only one outbound request that contains a timeout error'
        def outboundRequests = IntegrationTestUtil.findAll(OutboundRequestModel)
        outboundRequests.size() == 1
        with(outboundRequests[0] as OutboundRequestModel) {
            error.contains 'Request timed out'
        }

        where:
        params << [THREE_INDIVIDUAL_PARAMETERS, ONE_PARAMETER_OBJECT]
    }

    @Test
    @Issue('https://jira.tools.sap/browse/CXEC-3611')
    def 'read timeout does not leak connections in the pool when called with #params'() {
        given: 'request timeout is half second'
        configurationRule.configuration().requestExecutionTimeout = 500
        and: 'and the destination responds in over half second'
        stubFor(post(urlEqualTo(DESTINATION_ENDPOINT)).willReturn(ok().withFixedDelay(600)))

        when:
        outboundServiceFacade.send(*params).subscribe(subscriber)

        then:
        subscriber.assertError(IntegrationTimeoutException)
        and:
        with (getPoolStats('localhost')) {
            leased == 0
            pending == 0
        }

        where:
        params << [THREE_INDIVIDUAL_PARAMETERS, ONE_PARAMETER_OBJECT]
    }

    @Test
    def "outbound request is logged when monitoring is enabled with parameters #params"() {
        given: 'stub destination server to return BAD REQUEST'
        stubFor(post(urlEqualTo(DESTINATION_ENDPOINT)).willReturn(badRequest()))

        and:
        def outboundRequestSample = new OutboundRequestModel(integrationKey: "$CATALOG_VERSION|$CATALOG_ID")
        assertModelDoesNotExist(outboundRequestSample)

        when:
        outboundServiceFacade.send(*params).subscribe(subscriber)

        then: "destination server stub is called"
        verify(postRequestedFor(urlEqualTo(DESTINATION_ENDPOINT)))

        and:
        assertModelExists(outboundRequestSample)

        where:
        params << [THREE_INDIVIDUAL_PARAMETERS, ONE_PARAMETER_OBJECT]
    }

    @Test
    def "outbound request is logged when monitoring is enabled and destination does not exist with parameters for ItemModel, IO code and Destination Id"() {
        given:
        def nonExistingDestination = 'non-existing-destination'
        noOutboundRequestExists()

        when:
        outboundServiceFacade.send(CATALOG_VERSION_ITEM, CATALOG_VERSION_IO, nonExistingDestination).subscribe(subscriber)

        then:
        thrown DecoratorContextErrorException
        and: 'only one outbound request that contains the destination ID'
        def outboundRequests = IntegrationTestUtil.findAll(OutboundRequestModel)
        outboundRequests.size() == 1
        with(outboundRequests[0] as OutboundRequestModel) {
            destination.contains nonExistingDestination
            error.contains nonExistingDestination
        }
    }

    @Test
    def "outbound request is logged when monitoring is enabled and destination does not exist with parameters as SyncParameters"() {
        given:
        def nonExistingDestination = 'non-existing-destination'
        noOutboundRequestExists()

        when:
        def params = SyncParameters.syncParametersBuilder()
                .withItem(CATALOG_VERSION_ITEM)
                .withIntegrationObjectCode(CATALOG_VERSION_IO)
                .withDestinationId(nonExistingDestination)
                .build()
        outboundServiceFacade.send(params).subscribe(subscriber)

        then:
        thrown DecoratorContextErrorException
        and:'only one outbound request that contains the destination ID'
        def outboundRequests = IntegrationTestUtil.findAll(OutboundRequestModel)
        outboundRequests.size() == 1
        with(outboundRequests[0] as OutboundRequestModel) {
            destination.contains nonExistingDestination
            error.contains nonExistingDestination
        }
    }

    @Test
    def "outbound request is logged when monitoring is enabled and integration object does not exist with parameters as SyncParameters"() {
        given:
        noOutboundRequestExists()

        when:
        def params = SyncParameters.syncParametersBuilder()
                .withItem(CATALOG_VERSION_ITEM)
                .withIntegrationObject(null)
                .withDestinationId(DESTINATION_ID)
                .build()
        outboundServiceFacade.send(params).subscribe(subscriber)

        then: 'only one outbound request that contains the decorator context error'
        def outboundRequests = IntegrationTestUtil.findAll(OutboundRequestModel)
        outboundRequests.size() == 1
        with(outboundRequests[0] as OutboundRequestModel) {
            error.contains "[Provided integration object 'null' was not found.]"
        }
    }

    @Test
    def "CSRF token should be retrieved and injected into the request if the destination is configured so with parameters #params"() {
        given: 'a destination with the CSRF URL specified'
        defaultCSRFDestination().build()

        and: 'CSRF request returns valid token'
        stubFor get(CSRF_ENDPOINT)
                .willReturn(ok().withHeader('X-CSRF-Token', 'x-token').withHeader('Set-Cookie', 'trusted', 'alive'))

        when:
        outboundServiceFacade.send(*params).subscribe(subscriber)

        then: 'retrieved CSRF token is sent to the destination'
        verify postRequestedFor(urlEqualTo(DESTINATION_ENDPOINT))
                .withHeader('X-CSRF-Token', equalTo('x-token'))
                .withCookie('trusted', equalTo(''))
                .withCookie('alive', equalTo(''))

        where:
        params << [THREE_INDIVIDUAL_PARAMETERS, ONE_PARAMETER_OBJECT]
    }

    @Test
    def "CSRF token should be cached for subsequent calls to the same destination with parameters #params"() {
        def scenario = 'caching test'
        def nextState = 'csrf returned'

        given: 'a destination with the CSRF URL specified'
        defaultCSRFDestination().build()

        and: 'first CSRF request is successful'
        stubFor get(CSRF_ENDPOINT).inScenario(scenario).whenScenarioStateIs(Scenario.STARTED)
                .willReturn(ok().withHeader('X-CSRF-Token', 'received').withHeader('Set-Cookie', 'token=cached'))
                .willSetStateTo(nextState)

        and: 'second CSRF request returns different token'
        stubFor get(CSRF_ENDPOINT).inScenario(scenario).whenScenarioStateIs('csrf returned')
                .willReturn(ok().withHeader('X-CSRF-Token', 'never called'))

        when:
        outboundServiceFacade.send(*params).subscribe TestSubscriber.create()
        and:
        outboundServiceFacade.send(*params).subscribe TestSubscriber.create()

        then: 'first CSRF token is sent with both destination request'
        verify exactly(2), postRequestedFor(urlEqualTo(DESTINATION_ENDPOINT))
                .withHeader('X-CSRF-Token', equalTo('received'))
                .withCookie('token', equalTo('cached'))

        where:
        params << [THREE_INDIVIDUAL_PARAMETERS, ONE_PARAMETER_OBJECT]
    }

    @Test
    def "cached CSRF token must not be used for calls to a different destination with parameters #params1 and then #params2"() {
        def scenario = 'caching test'
        def nextState = 'destination 2'

        given: 'two different destinations with the same CSRF URL'
        defaultCSRFDestination().build()

        defaultCSRFDestination()
                .withId(OTHER_DESTINATION_ID)
                .withUrl(urlTo(OTHER_DESTINATION_ENDPOINT))
                .build()

        and: 'first CSRF request is successful'
        stubFor get(CSRF_ENDPOINT).inScenario(scenario).whenScenarioStateIs(Scenario.STARTED)
                .willReturn(ok().withHeader('X-CSRF-Token', 'token1').withHeader('Set-Cookie', 'token1=fresh'))
                .willSetStateTo(nextState)

        and: 'second CSRF request returns different token'
        stubFor get(CSRF_ENDPOINT).inScenario(scenario).whenScenarioStateIs(nextState)
                .willReturn(ok().withHeader('X-CSRF-Token', 'token2').withHeader('Set-Cookie', 'token2=fresh'))

        when:
        outboundServiceFacade.send(*params1).subscribe TestSubscriber.create()
        and:
        outboundServiceFacade.send(*params2).subscribe TestSubscriber.create()

        then: 'first CSRF token is sent with both destination request'
        verify postRequestedFor(urlEqualTo(DESTINATION_ENDPOINT))
                .withHeader('X-CSRF-Token', equalTo('token1'))
                .withCookie('token1', equalTo('fresh'))
        verify postRequestedFor(urlEqualTo(OTHER_DESTINATION_ENDPOINT))
                .withHeader('X-CSRF-Token', equalTo('token2'))
                .withCookie('token2', equalTo('fresh'))

        where:
        params1                                                    | params2
        [CATALOG_VERSION_ITEM, CATALOG_VERSION_IO, DESTINATION_ID] | [CATALOG_VERSION_ITEM, CATALOG_VERSION_IO, OTHER_DESTINATION_ID]
        [syncParameters(DESTINATION_ID)]                           | [syncParameters(OTHER_DESTINATION_ID)]
    }

    @Test
    def "item is not sent to the destination when CSRF token not retrieved and outbound request is logged with parameters #params"() {
        given:
        noOutboundRequestExists()
        and: 'a destination with the CSRF URL specified'
        defaultCSRFDestination().build()
        and: 'CSRF request fails'
        stubFor get(CSRF_ENDPOINT).willReturn(notFound())

        when:
        outboundServiceFacade.send(*params).subscribe(subscriber)

        then: 'CSRF response status code is reported back'
        subscriber.onErrorEvents[0].statusCode == HttpStatus.NOT_FOUND
        and: 'only one outbound request that contains the destination'
        IntegrationTestUtil.findAll(OutboundRequestModel).findAll {
            (it as OutboundRequestModel).destination.contains(DESTINATION_ENDPOINT)
        }.size() == 1

        where:
        params << [THREE_INDIVIDUAL_PARAMETERS, ONE_PARAMETER_OBJECT]
    }


    @Test
    def "OAuth access token should be retrieved and injected into the request to a destination"() {
        given: 'a destination with the OAuth URL specified'
        defaultOAuthDestination().build()

        and: 'OAuth endpoint returns a valid token only if authorized client details are provided'
        stubFor oAuthTokenRetrieval(OAUTH_TOKEN)

        when:
        outboundServiceFacade.send(*THREE_INDIVIDUAL_PARAMETERS).subscribe subscriber

        then: 'retrieved OAuth token is sent to the destination'
        verify postRequestedFor(urlEqualTo(DESTINATION_ENDPOINT))
                .withHeader('Authorization', equalTo("Bearer $OAUTH_TOKEN"))
    }

    @Test
    def "OAuth access token should be cached for subsequent calls to the same destination"() {
        def scenario = 'caching test'
        def nextState = 'oauth returned'

        given: 'a destination with the OAuth URL specified'
        defaultOAuthDestination().build()

        and: 'first OAuth access token request is successful'
        stubFor oAuthTokenRetrieval(OAUTH_TOKEN).inScenario(scenario).whenScenarioStateIs(Scenario.STARTED)
                .willSetStateTo(nextState)

        and: 'second OAuth access token request returns different token'
        stubFor oAuthTokenRetrieval(OTHER_OAUTH_TOKEN).inScenario(scenario).whenScenarioStateIs(nextState)

        when:
        outboundServiceFacade.send(*THREE_INDIVIDUAL_PARAMETERS).subscribe TestSubscriber.create()
        and:
        outboundServiceFacade.send(*THREE_INDIVIDUAL_PARAMETERS).subscribe TestSubscriber.create()

        then: 'first OAuth token is sent to the destination for both requests'
        verify exactly(2), postRequestedFor(urlEqualTo(DESTINATION_ENDPOINT))
                .withHeader('Authorization', equalTo("Bearer $OAUTH_TOKEN"))
    }

    @Test
    def "cached OAuth token must not be used for calls to a different destination"() {
        def scenario = 'caching test'
        def nextState = 'other destination'

        given: 'two destinations with the same OAuth URL specified'
        defaultOAuthDestination().build()

        defaultOAuthDestination()
                .withId(OTHER_DESTINATION_ID)
                .withUrl(urlTo(OTHER_DESTINATION_ENDPOINT))
                .build()

        and: 'first OAuth access token request is successful'
        stubFor oAuthTokenRetrieval(OAUTH_TOKEN).inScenario(scenario).whenScenarioStateIs(Scenario.STARTED)
                .willSetStateTo(nextState)

        and: 'second OAuth access token request returns different token'
        stubFor oAuthTokenRetrieval(OTHER_OAUTH_TOKEN).inScenario(scenario).whenScenarioStateIs(nextState)

        when:
        outboundServiceFacade.send(*THREE_INDIVIDUAL_PARAMETERS).subscribe TestSubscriber.create()
        and:
        outboundServiceFacade.send(CATALOG_VERSION_ITEM, CATALOG_VERSION_IO, OTHER_DESTINATION_ID).subscribe TestSubscriber.create()

        then: 'first OAuth token is sent to the first destination'
        verify postRequestedFor(urlEqualTo(DESTINATION_ENDPOINT))
                .withHeader('Authorization', equalTo("Bearer $OAUTH_TOKEN"))

        and: 'second OAuth token is sent to the second destination'
        verify postRequestedFor(urlEqualTo(OTHER_DESTINATION_ENDPOINT))
                .withHeader('Authorization', equalTo("Bearer $OTHER_OAUTH_TOKEN"))
    }

    @Test
    def "cached OAuth token must not be used for calls to the same destination after #attribute is modified"() {
        def scenario = 'caching test'
        def nextState = 'modified credentials'

        given: 'destination with OAuthCredential'
        def destination = defaultOAuthDestination()
        destination.build()

        and: 'first OAuth access token request is successful'
        stubFor successfulPostTo(OAUTH_ENDPOINT).inScenario(scenario).whenScenarioStateIs(Scenario.STARTED)
                .withHeader('Authorization', equalTo(encodeClientDetails(CLIENT_ID, CLIENT_SECRET)))
                .withRequestBody(equalTo("grant_type=$GRANT_TYPE&scope=$SCOPE"))
                .willReturn(okJson(oAuthResponseBodyWith(OAUTH_TOKEN)))
                .willSetStateTo(nextState)

        and: 'second OAuth access token request returns different token'
        stubFor successfulPostTo(otherOAuthEndpoint).inScenario(scenario).whenScenarioStateIs(nextState)
                .withHeader('Authorization', equalTo(encodeClientDetails(CLIENT_ID, otherClientSecret)))
                .withRequestBody(equalTo("grant_type=$GRANT_TYPE&scope=$otherScope"))
                .willReturn(okJson(oAuthResponseBodyWith(OTHER_OAUTH_TOKEN)))

        when:
        outboundServiceFacade.send(*THREE_INDIVIDUAL_PARAMETERS).subscribe TestSubscriber.create()

        and: 'credentials are modified'
        def modifiedClientDetails = defaultOAuthClientDetails()
                .withOAuthUrl(urlTo(otherOAuthEndpoint))
                .withScopes([otherScope] as Set)
        def modifiedCredentials = defaultCredentials()
                .withPassword(otherClientSecret)
                .withClientDetails modifiedClientDetails
        destination
                .withCredential(modifiedCredentials)
                .withAdditionalParameters(otherParams)
                .build()

        and:
        outboundServiceFacade.send(*THREE_INDIVIDUAL_PARAMETERS).subscribe TestSubscriber.create()

        then: 'first OAuth token is sent for original POST request'
        verify postRequestedFor(urlEqualTo(DESTINATION_ENDPOINT))
                .withHeader('Authorization', equalTo("Bearer $OAUTH_TOKEN"))

        then: 'other OAuth token is sent for second POST request'
        verify postRequestedFor(urlEqualTo(DESTINATION_ENDPOINT))
                .withHeader('Authorization', equalTo("Bearer $OTHER_OAUTH_TOKEN"))

        where:
        attribute       | otherClientSecret     | otherOAuthEndpoint      | otherScope    | otherParams
        'CLIENT_SECRET' | "other$CLIENT_SECRET" | OAUTH_ENDPOINT          | SCOPE         | PARAMS_WITH_SCOPE
        'OAUTH_URL'     | CLIENT_SECRET         | "$OAUTH_ENDPOINT/other" | SCOPE         | PARAMS_WITH_SCOPE
        'SCOPE'         | CLIENT_SECRET         | OAUTH_ENDPOINT          | "other$SCOPE" | [(CLIENT_SCOPE): otherScope]
    }

    private static MappingBuilder oAuthTokenRetrieval(String tokenValue) {
        successfulPostTo(OAUTH_ENDPOINT)
                .withHeader('Authorization', equalTo(encodeClientDetails(CLIENT_ID, CLIENT_SECRET)))
                .withRequestBody(equalTo("grant_type=$GRANT_TYPE&scope=$SCOPE"))
                .willReturn(okJson(oAuthResponseBodyWith(tokenValue)))
    }

    private static SyncParameters syncParameters(def destination = DESTINATION_ID) {
        SyncParameters.syncParametersBuilder()
                .withItem(CATALOG_VERSION_ITEM)
                .withSource(OutboundSource.OUTBOUNDSYNC)
                .withDestinationId(destination)
                .withIntegrationObjectCode(CATALOG_VERSION_IO)
                .build()
    }

    private def defaultCSRFDestination() {
        destinationBuilder
                .withAdditionalParameters([csrfURL: urlTo(CSRF_ENDPOINT)])
    }

    private def defaultOAuthDestination() {
        destinationBuilder
                .withCredential(defaultCredentials())
                .withAdditionalParameters(PARAMS_WITH_SCOPE)
    }

    private def defaultCredentials() {
        consumedOAuthCredentialBuilder()
                .withId(CREDENTIAL_ID)
                .withPassword(CLIENT_SECRET)
                .withClientDetails(defaultOAuthClientDetails())
    }

    private def defaultOAuthClientDetails() {
        oAuthClientDetailsBuilder()
                .withClientId(CLIENT_ID)
                .withScope(SCOPE)
                .withOAuthUrl urlTo(OAUTH_ENDPOINT)
    }

    private def urlTo(String endpoint) {
        "https://localhost:${wireMockRule.httpsPort()}$endpoint"
    }

    def setupDefaultRequestStubbing() {
        stubFor successfulPostTo(DESTINATION_ENDPOINT)
        stubFor successfulPostTo(OTHER_DESTINATION_ENDPOINT)
    }

    private static MappingBuilder get(String endpoint) {
        get(urlEqualTo(endpoint))
    }

    private static def successfulPostTo(String destination) {
        post(urlEqualTo(destination)).willReturn ok()
    }

    private static def oAuthResponseBodyWith(String oAuthToken) {
        """
        {
          "access_token": "$oAuthToken",
          "token_type": "Bearer"
        }
        """
    }

    private static String encodeClientDetails(String clientId, String password) {
        def binContent = Base64.getEncoder().encode("$clientId:$password".getBytes("UTF-8"))
        def txtContent = new String(binContent, "UTF-8")
        "Basic $txtContent"
    }

    private static def matchVersion(String version) {
        matchingJsonPath("\$.[?(@.version == '$version')]")
    }

    private static def matchCatalogId(String catalogId) {
        matchingJsonPath("\$.catalog[?(@.id == '$catalogId')]")
    }

    private static def matchPassport() {
        matching('[\\w]+')
    }

    private static def noOutboundRequestExists() {
        IntegrationTestUtil.findAll(OutboundRequestModel).isEmpty()
    }

    private static def resetHttpClientCache() {
        def appContext = Registry.applicationContext
        def factory = appContext.getBean 'defaultOutboundClientHttpRequestFactory', DefaultClientRequestFactory
        factory.clear()
    }
}
