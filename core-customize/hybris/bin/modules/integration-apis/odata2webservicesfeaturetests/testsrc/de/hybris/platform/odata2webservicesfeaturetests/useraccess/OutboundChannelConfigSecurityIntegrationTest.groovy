/*
 *  Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.odata2webservicesfeaturetests.useraccess

import de.hybris.bootstrap.annotations.IntegrationTest
import de.hybris.platform.core.model.user.EmployeeModel
import de.hybris.platform.integrationservices.IntegrationObjectModelBuilder
import de.hybris.platform.integrationservices.util.IntegrationTestUtil
import de.hybris.platform.integrationservices.util.JsonBuilder
import de.hybris.platform.integrationservices.util.impex.ModuleEssentialData
import de.hybris.platform.odata2webservices.constants.Odata2webservicesConstants
import de.hybris.platform.odata2webservicesfeaturetests.ws.BasicAuthRequestBuilder
import de.hybris.platform.outboundservices.BasicCredentialBuilder
import de.hybris.platform.outboundservices.ConsumedDestinationBuilder
import de.hybris.platform.outboundservices.ConsumedOAuthCredentialBuilder
import de.hybris.platform.outboundservices.DestinationTargetBuilder
import de.hybris.platform.outboundservices.EndpointBuilder
import de.hybris.platform.outboundservices.OAuthClientDetailsBuilder
import de.hybris.platform.outboundsync.OutboundChannelConfigurationBuilder
import de.hybris.platform.outboundsync.OutboundSyncCronJobBuilder
import de.hybris.platform.outboundsync.OutboundSyncJobBuilder
import de.hybris.platform.outboundsync.OutboundSyncStreamConfigurationBuilder
import de.hybris.platform.outboundsync.OutboundSyncStreamConfigurationContainerBuilder
import de.hybris.platform.outboundsync.TriggerBuilder
import de.hybris.platform.outboundsync.util.OutboundSyncEssentialData
import de.hybris.platform.servicelayer.ServicelayerSpockSpecification
import de.hybris.platform.webservicescommons.testsupport.server.NeedsEmbeddedServer
import org.apache.olingo.odata2.api.commons.HttpStatusCodes
import org.junit.ClassRule
import org.junit.Test
import spock.lang.AutoCleanup
import spock.lang.Shared

import javax.ws.rs.client.Entity

import static de.hybris.platform.odata2webservices.util.Odata2WebServicesEssentialData.odata2WebservicesEssentialData
import static de.hybris.platform.odata2webservicesfeaturetests.useraccess.UserAccessTestUtils.givenUserExistsWithUidAndGroups

@NeedsEmbeddedServer(webExtensions = [Odata2webservicesConstants.EXTENSIONNAME])
@IntegrationTest
class OutboundChannelConfigSecurityIntegrationTest extends ServicelayerSpockSpecification {
    private static final String TEST_NAME = "OutboundChannelConfigSecurity"
    private static final String OUTBOUND_CHANNEL_CONFIG = "OutboundChannelConfig"
    private static final String USER = "${TEST_NAME}_tester"
    private static final String PASSWORD = 'password'
    private static final String GROUP_ADMIN = 'integrationadmingroup'
    private static final String GROUP_SERVICE = 'integrationservicegroup'
    private static final String GROUP_MONITOR = 'integrationmonitoringgroup'
    private static final String GROUP_CREATE = 'integrationcreategroup'
    private static final String GROUP_VIEW = 'integrationviewgroup'
    private static final String GROUP_DELETE = 'integrationdeletegroup'
    private static final String GROUP_OUTBOUNDSYNC = 'outboundsyncgroup'
    private static final String GROUP_OUTBOUNDSYNC_ADMIN = "$GROUP_ADMIN, $GROUP_OUTBOUNDSYNC"
    private static final String MONITOR_AND_SERVICE_ADMIN = "$GROUP_ADMIN, $GROUP_MONITOR, $GROUP_SERVICE"

    private static final String ADMIN_USER = "$TEST_NAME-integrationadmingroup-user"
    private static final String MONITOR_USER = "$TEST_NAME-integrationmonitoringgroup-user"
    private static final String SERVICE_USER = "$TEST_NAME-integrationservicegroup-user"
    private static final String OUTBOUNDSYNC_USER = "$TEST_NAME-outboundsyncgroup-user"
    private static final String CREATE_USER = "$TEST_NAME-integrationcreategroup-user"
    private static final String VIEW_USER = "$TEST_NAME-integrationviewgroup-user"
    private static final String DELETE_USER = "$TEST_NAME-integrationdeletegroup-user"
    private static final String ADMIN_OUTBOUNDSYNC_USER = "$TEST_NAME-integrationadmingroup+outboundsyncgroup-user"
    private static final String ADMIN_MONITOR_SERVICE_USER = "$TEST_NAME-integrationadmingroup+integrationmonitoringgroup-user"

    private static final Set users = [ADMIN_USER, MONITOR_USER, SERVICE_USER, CREATE_USER, VIEW_USER, DELETE_USER, ADMIN_OUTBOUNDSYNC_USER]

    private static final String OAUTH_ID = "${TEST_NAME}_OAuthCredentials"
    private static final String BASIC_ID = "${TEST_NAME}_BasicCredentials"
    private static final String ENDPOINT_ID = "${TEST_NAME}_existingEndpoint"
    private static final String REGISTERED_ENDPOINT_ID = "${TEST_NAME}_existingEndpointRegistered"
    private static final String ENDPOINT_VERSION = "v7"
    private static final String DEST_TARGET_ID = "${TEST_NAME}_existingDestinationTarget"
    private static final String REGISTERED_DESTINATION_ID = "${TEST_NAME}_existingDestinationRegistered"
    private static final String DESTINATION_ID = "${TEST_NAME}_existingDestination"
    private static final String CONTAINER_ID = "${TEST_NAME}_existingStreamContainer"
    private static final String STREAM_ID = "${TEST_NAME}_existingStream"
    private static final String JOB_CODE = "${TEST_NAME}_existingJob"
    private static final String CRONJOB_CODE = "${TEST_NAME}_existingCronJob"
    private static final String CRONJOB_EXPRESSION = "0 0 0 * * ?"
    private static final String CHANNEL_CODE = "${TEST_NAME}_existingChannel"
    private static final String REGISTERED_IOBJECT_CODE = "${TEST_NAME}_SpecialProductRegistered"
    private static final String IOBJECT_CODE = "${TEST_NAME}_SpecialProduct"
    private static final String STREAM_ITEM_CODE = "Product"

    private static final String DEFAULT_CHANNEL_CONFIG_JSON = defaultOutboundChannelConfigurationsJsonBody()
    private static final String DEFAULT_ENDPOINT_JSON = defaultEndpointJsonBody()
    private static final String DEFAULT_DESTINATION_TARGET_JSON = defaultDestinationTargetJsonBody()
    private static final String DEFAULT_JOB_JSON = defaultOutboundSyncJobJsonBody()
    private static final String DEFAULT_CRONJOB_JSON = defaultOutboundSyncCronJobJsonBody()
    private static final String DEFAULT_BASIC_CREDENTIAL_JSON = defaultBasicCredentialJsonBody()
    private static final String DEFAULT_OAUTH_CREDENTIAL_JSON = defaultOAuthCredentialJsonBody()
    private static final String DEFAULT_STREAM_CONTAINER_JSON = defaultOutboundSyncStreamConfigurationContainerJsonBody()
    private static final String DEFAULT_INTEGRATION_OBJECT_JSON = defaultIntegrationObjectJsonBody()
    private static final String DEFAULT_STREAM_JSON = defaultOutboundSyncStreamConfigurationJsonBody()
    private static final String DEFAULT_CONSUMED_DESTINATION_JSON = defaultConsumedDestinationJsonBody()
    private static final String DEFAULT_TRIGGER_JSON = defaultTriggerJsonBody()

    @Shared
    @ClassRule
    ModuleEssentialData inboundEssentialData = odata2WebservicesEssentialData().withDependencies()
    @Shared
    @ClassRule
    ModuleEssentialData outboundEssentialData = OutboundSyncEssentialData.outboundSyncEssentialData()

    @AutoCleanup('cleanup')
    final var outboundSyncCronJobBuilder = OutboundSyncCronJobBuilder.outboundSyncCronJobBuilder()

    @AutoCleanup('cleanup')
    final def consumedDestinationBuilder = ConsumedDestinationBuilder.consumedDestinationBuilder().withId(DESTINATION_ID)

    @AutoCleanup('cleanup')
    final def integrationObjectBuilder = IntegrationObjectModelBuilder.integrationObject().withCode(IOBJECT_CODE)

    @AutoCleanup('cleanup')
    final def consumedOAuthCredentialBuilder =
            ConsumedOAuthCredentialBuilder.consumedOAuthCredentialBuilder()

    def setupSpec() {
        userInGroups(ADMIN_USER, GROUP_ADMIN)
        userInGroups(MONITOR_USER, GROUP_MONITOR)
        userInGroups(SERVICE_USER, GROUP_SERVICE)
        userInGroups(OUTBOUNDSYNC_USER, GROUP_OUTBOUNDSYNC)
        userInGroups(CREATE_USER, GROUP_CREATE)
        userInGroups(VIEW_USER, GROUP_VIEW)
        userInGroups(DELETE_USER, GROUP_DELETE)
        userInGroups(ADMIN_OUTBOUNDSYNC_USER, GROUP_OUTBOUNDSYNC_ADMIN)
        userInGroups(ADMIN_MONITOR_SERVICE_USER, MONITOR_AND_SERVICE_ADMIN)
    }

    def cleanupSpec() {
        IntegrationTestUtil.remove(EmployeeModel) { it.uid == USER }
        IntegrationTestUtil.remove(EmployeeModel) { users.contains it.uid }
    }

    @Test
    def "User must be authenticated in order to #method /OutboundChannelConfig"() {
        when:
        def response = basicAuthRequest()
                .path(OUTBOUND_CHANNEL_CONFIG)
                .build()
                .method method

        then:
        response.status == HttpStatusCodes.UNAUTHORIZED.statusCode

        where:
        method << ['GET', 'POST', 'DELETE', 'PATCH']
    }

    @Test
    def "User must be authenticated in order to GET /OutboundChannelConfig/someFeedNameThatDoesNotMatter"() {
        when:
        def response = basicAuthRequest()
                .path(OUTBOUND_CHANNEL_CONFIG)
                .path('someFeedNameThatDoesNotMatter')
                .build()
                .get()

        then:
        response.status == HttpStatusCodes.UNAUTHORIZED.statusCode
    }

    @Test
    def "User in groups outboundsyncgroup & integrationadmingroup gets Forbidden when requesting with unsupported HTTP verb at /OutboundChannelConfig/someFeedNameThatDoesNotMatter"() {
        when:
        def response = basicAuthRequest()
                .path(OUTBOUND_CHANNEL_CONFIG)
                .path('someFeedNameThatDoesNotMatter')
                .credentials(ADMIN_OUTBOUNDSYNC_USER, PASSWORD)
                .build()
                .method 'COPY'

        then:
        response.status == HttpStatusCodes.FORBIDDEN.statusCode
    }

    @Test
    def "#user gets #status for GET /OutboundChannelConfig"() {
        when:
        def response = basicAuthRequest()
                .path(OUTBOUND_CHANNEL_CONFIG)
                .credentials(user, PASSWORD)
                .build()
                .get()

        then:
        response.status == status.statusCode

        where:
        user                       | status
        ADMIN_USER                 | HttpStatusCodes.NOT_FOUND
        ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        CREATE_USER                | HttpStatusCodes.FORBIDDEN
        VIEW_USER                  | HttpStatusCodes.FORBIDDEN
        DELETE_USER                | HttpStatusCodes.FORBIDDEN
        OUTBOUNDSYNC_USER          | HttpStatusCodes.FORBIDDEN
        ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
    }

    @Test
    def "#user gets Forbidden for GET /OutboundChannelConfig/doesNotMatter"() {
        when:
        def response = basicAuthRequest()
                .path(OUTBOUND_CHANNEL_CONFIG)
                .path('doesNotMatter')
                .credentials(user, PASSWORD)
                .build()
                .get()

        then:
        response.status == HttpStatusCodes.FORBIDDEN.statusCode

        where:
        user << [CREATE_USER, VIEW_USER, DELETE_USER, OUTBOUNDSYNC_USER]
    }

    @Test
    def "#user gets #status for GET /OutboundChannelConfig/#feed"() {
        when:
        def response = basicAuthRequest()
                .path(OUTBOUND_CHANNEL_CONFIG)
                .path(feed)
                .credentials(user, PASSWORD)
                .build()
                .get()

        then:
        response.status == status.statusCode

        where:
        feed                                        | user                       | status
        'ConsumedDestinations'                      | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        'DestinationTargets'                        | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        'Endpoints'                                 | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        'BasicCredentials'                          | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        'ConsumedOAuthCredentials'                  | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        'OutboundChannelConfigurations'             | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        'IntegrationObjects'                        | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        'OutboundSyncStreamConfigurationContainers' | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        'OutboundSyncStreamConfigurations'          | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        'OutboundSyncJobs'                          | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        'OutboundSyncCronJobs'                      | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        'ComposedTypes'                             | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        'Triggers'                                  | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND

        'ConsumedDestinations'                      | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        'DestinationTargets'                        | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        'Endpoints'                                 | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        'BasicCredentials'                          | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        'ConsumedOAuthCredentials'                  | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        'OutboundChannelConfigurations'             | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        'IntegrationObjects'                        | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        'OutboundSyncStreamConfigurationContainers' | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        'OutboundSyncStreamConfigurations'          | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        'OutboundSyncJobs'                          | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        'OutboundSyncCronJobs'                      | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        'ComposedTypes'                             | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        'Triggers'                                  | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
    }

    @Test
    def "#user is Forbidden to #httpMethod to /OutboundChannelConfig/*"() {
        when:
        def response = basicAuthRequest()
                .path(OUTBOUND_CHANNEL_CONFIG)
                .credentials(user, PASSWORD)
                .build()
                .method(httpMethod, Entity.json('{}'))

        then: 'the user is forbidden by spring security'
        response.status == HttpStatusCodes.FORBIDDEN.statusCode

        where:
        user              | httpMethod
        CREATE_USER       | 'POST'
        VIEW_USER         | 'POST'
        DELETE_USER       | 'POST'
        OUTBOUNDSYNC_USER | 'POST'

        CREATE_USER       | 'PATCH'
        VIEW_USER         | 'PATCH'
        DELETE_USER       | 'PATCH'
        OUTBOUNDSYNC_USER | 'PATCH'

        CREATE_USER       | 'DELETE'
        VIEW_USER         | 'DELETE'
        DELETE_USER       | 'DELETE'
        OUTBOUNDSYNC_USER | 'DELETE'
    }

    @Test
    def "#user gets #status when sending a POST to /OutboundChannelConfig/#feed"() {
        given:
        defaultChannelConfigurationExist()

        when:
        def response = basicAuthRequest()
                .path(OUTBOUND_CHANNEL_CONFIG)
                .path(feed)
                .credentials(user, PASSWORD)
                .build()
                .post Entity.json(jsonBody)

        then:
        response.status == status.statusCode

        where:
        feed                                        | user                       | status                    | jsonBody
        'ConsumedDestinations'                      | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_CONSUMED_DESTINATION_JSON
        'DestinationTargets'                        | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_DESTINATION_TARGET_JSON
        'Endpoints'                                 | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_ENDPOINT_JSON
        'BasicCredentials'                          | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_BASIC_CREDENTIAL_JSON
        'ConsumedOAuthCredentials'                  | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_OAUTH_CREDENTIAL_JSON
        'OutboundSyncStreamConfigurationContainers' | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_STREAM_CONTAINER_JSON
        'OutboundSyncJobs'                          | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_JOB_JSON
        'OutboundSyncCronJobs'                      | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_CRONJOB_JSON
        'IntegrationObjects'                        | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_INTEGRATION_OBJECT_JSON
        'OutboundChannelConfigurations'             | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_CHANNEL_CONFIG_JSON
        'OutboundSyncStreamConfigurations'          | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_STREAM_JSON
        'Triggers'                                  | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_TRIGGER_JSON

        'ConsumedDestinations'                      | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.CREATED   | DEFAULT_CONSUMED_DESTINATION_JSON
        'DestinationTargets'                        | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.CREATED   | DEFAULT_DESTINATION_TARGET_JSON
        'Endpoints'                                 | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.CREATED   | DEFAULT_ENDPOINT_JSON
        'BasicCredentials'                          | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.CREATED   | DEFAULT_BASIC_CREDENTIAL_JSON
        'ConsumedOAuthCredentials'                  | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.CREATED   | DEFAULT_OAUTH_CREDENTIAL_JSON
        'OutboundSyncStreamConfigurationContainers' | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.CREATED   | DEFAULT_STREAM_CONTAINER_JSON
        'OutboundSyncJobs'                          | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.CREATED   | DEFAULT_JOB_JSON
        'OutboundSyncCronJobs'                      | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.CREATED   | DEFAULT_CRONJOB_JSON
        'IntegrationObjects'                        | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.CREATED   | DEFAULT_INTEGRATION_OBJECT_JSON
        'OutboundChannelConfigurations'             | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.CREATED   | DEFAULT_CHANNEL_CONFIG_JSON
        'OutboundSyncStreamConfigurations'          | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.CREATED   | DEFAULT_STREAM_JSON
        'Triggers'                                  | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.CREATED   | DEFAULT_TRIGGER_JSON
    }

    @Test
    def "#user gets #status when sending a PATCH to /OutboundChannelConfig/#feed"() {
        given:
        defaultChannelConfigurationExist()

        when:
        def response = basicAuthRequest()
                .path(OUTBOUND_CHANNEL_CONFIG)
                .path(feed)
                .credentials(user, PASSWORD)
                .build()
                .patch(Entity.json(jsonBody))

        then:
        response.status == status.statusCode

        where:
        feed                                                         | user                       | status                    | jsonBody
        "ConsumedDestinations('$DESTINATION_ID|$DEST_TARGET_ID')"    | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_CONSUMED_DESTINATION_JSON
        "DestinationTargets('$DEST_TARGET_ID')"                      | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_DESTINATION_TARGET_JSON
        "Endpoints('$ENDPOINT_ID|$ENDPOINT_VERSION')"                | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_ENDPOINT_JSON
        "BasicCredentials('$BASIC_ID')"                              | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_BASIC_CREDENTIAL_JSON
        "ConsumedOAuthCredentials('$OAUTH_ID')"                      | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_OAUTH_CREDENTIAL_JSON
        "OutboundSyncStreamConfigurationContainers('$CONTAINER_ID')" | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_STREAM_CONTAINER_JSON
        "OutboundSyncJobs('$JOB_CODE')"                              | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_JOB_JSON
        "OutboundSyncCronJobs('$CRONJOB_CODE')"                      | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_CRONJOB_JSON
        "IntegrationObjects('$IOBJECT_CODE')"                        | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_INTEGRATION_OBJECT_JSON
        "OutboundChannelConfigurations('$CHANNEL_CODE')"             | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_CHANNEL_CONFIG_JSON
        "OutboundSyncStreamConfigurations('$STREAM_ID')"             | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_STREAM_JSON
        "Triggers('$CRONJOB_CODE|$CRONJOB_EXPRESSION')"              | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND | DEFAULT_TRIGGER_JSON

        "ConsumedDestinations('$DESTINATION_ID|$DEST_TARGET_ID')"    | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK        | DEFAULT_CONSUMED_DESTINATION_JSON
        "DestinationTargets('$DEST_TARGET_ID')"                      | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK        | DEFAULT_DESTINATION_TARGET_JSON
        "Endpoints('$ENDPOINT_ID|$ENDPOINT_VERSION')"                | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK        | DEFAULT_ENDPOINT_JSON
        "BasicCredentials('$BASIC_ID')"                              | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK        | DEFAULT_BASIC_CREDENTIAL_JSON
        "ConsumedOAuthCredentials('$OAUTH_ID')"                      | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK        | DEFAULT_OAUTH_CREDENTIAL_JSON
        "OutboundSyncStreamConfigurationContainers('$CONTAINER_ID')" | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK        | DEFAULT_STREAM_CONTAINER_JSON
        "OutboundSyncJobs('$JOB_CODE')"                              | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK        | DEFAULT_JOB_JSON
        "OutboundSyncCronJobs('$CRONJOB_CODE')"                      | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK        | DEFAULT_CRONJOB_JSON
        "IntegrationObjects('$IOBJECT_CODE')"                        | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK        | DEFAULT_INTEGRATION_OBJECT_JSON
        "OutboundChannelConfigurations('$CHANNEL_CODE')"             | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK        | DEFAULT_CHANNEL_CONFIG_JSON
        "OutboundSyncStreamConfigurations('$STREAM_ID')"             | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK        | DEFAULT_STREAM_JSON
        "Triggers('$CRONJOB_CODE|$CRONJOB_EXPRESSION')"              | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK        | DEFAULT_TRIGGER_JSON
    }

    @Test
    def "#user gets #status when sending a DELETE to /OutboundChannelConfig/#existingItem"() {
        given:
        defaultChannelConfigurationExist()

        when:
        def response = basicAuthRequest()
                .path(OUTBOUND_CHANNEL_CONFIG)
                .path(existingItem)
                .credentials(user, PASSWORD)
                .build()
                .delete()

        then:
        response.status == status.statusCode

        where:
        existingItem                                                 | user                       | status
        "ConsumedDestinations('$DESTINATION_ID|$DEST_TARGET_ID')"    | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        "DestinationTargets('$DEST_TARGET_ID')"                      | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        "Endpoints('$ENDPOINT_ID|$ENDPOINT_VERSION')"                | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        "BasicCredentials('$BASIC_ID')"                              | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        "ConsumedOAuthCredentials('$OAUTH_ID')"                      | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        "OutboundSyncStreamConfigurationContainers('$CONTAINER_ID')" | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        "OutboundSyncJobs('$JOB_CODE')"                              | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        "OutboundSyncCronJobs('$CRONJOB_CODE')"                      | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        "IntegrationObjects('$IOBJECT_CODE')"                        | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        "OutboundChannelConfigurations('$CHANNEL_CODE')"             | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        "OutboundSyncStreamConfigurations('$STREAM_ID')"             | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK
        "Triggers('$CRONJOB_CODE|$CRONJOB_EXPRESSION')"              | ADMIN_OUTBOUNDSYNC_USER    | HttpStatusCodes.OK

        "ConsumedDestinations('$DESTINATION_ID|$DEST_TARGET_ID')"    | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        "DestinationTargets('$DEST_TARGET_ID')"                      | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        "Endpoints('$ENDPOINT_ID|$ENDPOINT_VERSION')"                | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        "BasicCredentials('$BASIC_ID')"                              | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        "ConsumedOAuthCredentials('$OAUTH_ID')"                      | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        "OutboundSyncStreamConfigurationContainers('$CONTAINER_ID')" | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        "OutboundSyncJobs('$JOB_CODE')"                              | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        "OutboundSyncCronJobs('$CRONJOB_CODE')"                      | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        "IntegrationObjects('$IOBJECT_CODE')"                        | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        "OutboundChannelConfigurations('$CHANNEL_CODE')"             | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        "OutboundSyncStreamConfigurations('$STREAM_ID')"             | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
        "Triggers('$CRONJOB_CODE|$CRONJOB_EXPRESSION')"              | ADMIN_MONITOR_SERVICE_USER | HttpStatusCodes.NOT_FOUND
    }

    def defaultChannelConfigurationExist() {
        final var destinationTargetBuilder =
                DestinationTargetBuilder.destinationTarget()
                        .withId(DEST_TARGET_ID)

        final var basicCredentialBuilder =
                BasicCredentialBuilder.basicCredentialBuilder()
                        .withId(BASIC_ID)

        final var outboundChannelConfigurationBuilder =
                OutboundChannelConfigurationBuilder.outboundChannelConfigurationBuilder()
                        .withCode(CHANNEL_CODE)
                        .withIntegrationObject(
                                IntegrationObjectModelBuilder.integrationObject()
                                        .withCode(REGISTERED_IOBJECT_CODE)
                        )
                        .withConsumedDestination(
                                ConsumedDestinationBuilder.consumedDestinationBuilder()
                                        .withId(REGISTERED_DESTINATION_ID)
                                        .withEndpoint(
                                                EndpointBuilder.endpointBuilder()
                                                        .withId(REGISTERED_ENDPOINT_ID)
                                                        .withVersion(ENDPOINT_VERSION)
                                        )
                                        .withDestinationTarget(destinationTargetBuilder)
                                        .withCredential(basicCredentialBuilder)
                        )

        final var outboundSyncStreamConfigurationContainerBuilder =
                OutboundSyncStreamConfigurationContainerBuilder.outboundSyncStreamConfigurationContainer()
                        .withId(CONTAINER_ID)
                        .withStream(OutboundSyncStreamConfigurationBuilder.outboundSyncStreamConfigurationBuilder()
                                .withId(STREAM_ID)
                                .withOutboundChannelConfiguration(outboundChannelConfigurationBuilder)
                                .withItemType(STREAM_ITEM_CODE))

        final var outboundSyncJobBuilder =
                OutboundSyncJobBuilder.outboundSyncJob()
                        .withJobCode(JOB_CODE)
                        .withOutboundSyncStreamConfigurationContainer(outboundSyncStreamConfigurationContainerBuilder)

        outboundSyncCronJobBuilder
                .withCronJobCode(CRONJOB_CODE)
                .withSyncJob(outboundSyncJobBuilder)
                .withTrigger(TriggerBuilder.triggerBuilder()
                        .withCronJobExpression(CRONJOB_EXPRESSION))
                .build()

        final var endpointBuilder =
                EndpointBuilder.endpointBuilder()
                        .withId(ENDPOINT_ID)
                        .withVersion(ENDPOINT_VERSION)

        consumedDestinationBuilder
                .withEndpoint(endpointBuilder)
                .withDestinationTarget(destinationTargetBuilder)
                .withCredential(basicCredentialBuilder)
                .build()

        integrationObjectBuilder.build()

        consumedOAuthCredentialBuilder
                .withClientDetails(OAuthClientDetailsBuilder.oAuthClientDetailsBuilder())
                .withId(OAUTH_ID)
                .build()
    }

    def static consumedDestinationJsonBodyWith(final String destinationId, final String endpointJson) {
        JsonBuilder.json()
                .withId(destinationId)
                .withField('url', 'https://localhost9')
                .withField('endpoint', endpointJson)
                .withField('destinationTarget', defaultDestinationTargetJsonBody())
                .withField('credentialBasic', defaultBasicCredentialJsonBody())
                .build()
    }

    def static defaultConsumedDestinationJsonBody() {
        consumedDestinationJsonBodyWith(DESTINATION_ID, defaultEndpointJsonBody())
    }

    def static registeredConsumedDestinationJsonBody() {
        consumedDestinationJsonBodyWith(REGISTERED_DESTINATION_ID, registeredEndpointJsonBody())
    }

    def static defaultOutboundSyncStreamConfigurationJsonBody() {
        JsonBuilder.json()
                .withField('streamId', STREAM_ID)
                .withField('outboundChannelConfiguration', defaultOutboundChannelConfigurationsJsonBody())
                .withField('container', defaultOutboundSyncStreamConfigurationContainerJsonBody())
                .withField('itemTypeForStream', JsonBuilder.json()
                        .withCode(STREAM_ITEM_CODE))
                .build()
    }

    def static defaultOutboundChannelConfigurationsJsonBody() {
        JsonBuilder.json()
                .withCode(CHANNEL_CODE)
                .withField('integrationObject', registeredIntegrationObjectJsonBody())
                .withField('destination', registeredConsumedDestinationJsonBody())
                .withField('autoGenerate', true)
                .build()
    }

    def static endpointJsonBodyWith(final endpointId) {
        JsonBuilder.json()
                .withId(endpointId)
                .withField('version', ENDPOINT_VERSION)
                .withField('name', 'newEndpointName')
                .build()
    }

    def static defaultEndpointJsonBody() {
        endpointJsonBodyWith(ENDPOINT_ID)
    }

    def static registeredEndpointJsonBody() {
        endpointJsonBodyWith(REGISTERED_ENDPOINT_ID)
    }

    def static defaultDestinationTargetJsonBody() {
        JsonBuilder.json()
                .withId(DEST_TARGET_ID)
                .build()
    }

    def static defaultOutboundSyncJobJsonBody() {
        JsonBuilder.json()
                .withCode(JOB_CODE)
                .withField('streamConfigurationContainer', defaultOutboundSyncStreamConfigurationContainerJsonBody())
                .build()
    }

    def static defaultOutboundSyncCronJobJsonBody() {
        JsonBuilder.json()
                .withCode(CRONJOB_CODE)
                .withField('job', defaultOutboundSyncJobJsonBody())
                .build()
    }

    def static defaultBasicCredentialJsonBody() {
        JsonBuilder.json()
                .withId(BASIC_ID)
                .withField('username', 'basicUn')
                .withField('password', 'pwdOfSomeSort')
                .build()
    }

    def static defaultOAuthCredentialJsonBody() {
        JsonBuilder.json()
                .withId(OAUTH_ID)
                .withField('clientId', 'secretId')
                .withField('clientSecret', 'secretSecret')
                .build()
    }

    def static defaultOutboundSyncStreamConfigurationContainerJsonBody() {
        JsonBuilder.json()
                .withId(CONTAINER_ID)
                .build()
    }

    def static integrationObjectJsonBodyWith(final String iOCode) {
        JsonBuilder.json()
                .withCode(iOCode)
                .build()
    }

    def static defaultIntegrationObjectJsonBody() {
        integrationObjectJsonBodyWith(IOBJECT_CODE)
    }

    def static registeredIntegrationObjectJsonBody() {
        integrationObjectJsonBodyWith(REGISTERED_IOBJECT_CODE)
    }


    def static defaultTriggerJsonBody() {
        JsonBuilder.json()
                .withField('cronExpression', CRONJOB_EXPRESSION)
                .withField('cronJob', JsonBuilder.json()
                        .withCode(CRONJOB_CODE))
                .build()
    }

    def basicAuthRequest() {
        new BasicAuthRequestBuilder()
                .extensionName(Odata2webservicesConstants.EXTENSIONNAME)
                .accept('application/json')
    }

    def userInGroups(final String user, final String groups) {
        givenUserExistsWithUidAndGroups(user, PASSWORD, groups)
    }
}
