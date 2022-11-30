/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.outboundsync.activator.impl

import de.hybris.bootstrap.annotations.UnitTest
import de.hybris.platform.apiregistryservices.model.ConsumedDestinationModel
import de.hybris.platform.core.PK
import de.hybris.platform.core.model.ItemModel
import de.hybris.platform.cronjob.enums.CronJobStatus
import de.hybris.platform.integrationservices.exception.IntegrationAttributeException
import de.hybris.platform.integrationservices.exception.IntegrationAttributeProcessingException
import de.hybris.platform.integrationservices.model.IntegrationObjectDescriptor
import de.hybris.platform.integrationservices.service.ItemModelSearchService
import de.hybris.platform.outboundservices.enums.OutboundSource
import de.hybris.platform.outboundservices.facade.OutboundServiceFacade
import de.hybris.platform.outboundservices.facade.SyncParameters
import de.hybris.platform.outboundsync.activator.OutboundItemConsumer
import de.hybris.platform.outboundsync.dto.OutboundChangeType
import de.hybris.platform.outboundsync.dto.OutboundItem
import de.hybris.platform.outboundsync.dto.OutboundItemChange
import de.hybris.platform.outboundsync.dto.OutboundItemDTO
import de.hybris.platform.outboundsync.dto.OutboundItemDTOGroup
import de.hybris.platform.outboundsync.events.AbortedOutboundSyncEvent
import de.hybris.platform.outboundsync.events.CompletedOutboundSyncEvent
import de.hybris.platform.outboundsync.events.SystemErrorOutboundSyncEvent
import de.hybris.platform.outboundsync.job.OutboundItemFactory
import de.hybris.platform.outboundsync.job.impl.DefaultOutboundSyncJobRegister
import de.hybris.platform.outboundsync.job.impl.OutboundSyncJob
import de.hybris.platform.outboundsync.job.impl.OutboundSyncJobRegister
import de.hybris.platform.outboundsync.model.OutboundChannelConfigurationModel
import de.hybris.platform.outboundsync.model.OutboundSyncCronJobModel
import de.hybris.platform.outboundsync.model.OutboundSyncRetryModel
import de.hybris.platform.outboundsync.retry.RetryUpdateException
import de.hybris.platform.outboundsync.retry.SyncRetryService
import de.hybris.platform.servicelayer.event.EventService
import de.hybris.platform.testframework.JUnitPlatformSpecification
import org.junit.Test
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import rx.Observable

import static de.hybris.platform.outboundsync.job.impl.OutboundSyncStateBuilder.initialOutboundSyncState

@UnitTest
class DefaultOutboundSyncServiceUnitTest extends JUnitPlatformSpecification {
    private static final def CHANGED_ITEM = new ItemModel()
    private static final int ROOT_ITEM_PK = 123
    private static final PK CRON_JOB_PK = PK.fromLong(456)
    private static final String TEST_INTEGRATION_OBJECT = "TestIntegrationObject"
    private static final String TEST_DESTINATION = "TestDestination"
    private static final def SYNC_PARAMETERS = syncParametersFor CHANGED_ITEM


    def outboundServiceFacade = Mock(OutboundServiceFacade)
    def outboundItemConsumer = Mock(OutboundItemConsumer)
    def syncRetryService = Mock(SyncRetryService)
    def eventService = Mock(EventService)
    def itemModelSearchService = Mock ItemModelSearchService
    def jobRegister = Mock DefaultOutboundSyncJobRegister
    def itemFactory = Stub(OutboundItemFactory) {
        createItem(_ as OutboundItemDTO) >> Stub(OutboundItem) {
            getIntegrationObject() >> Stub(IntegrationObjectDescriptor) {
                getCode() >> TEST_INTEGRATION_OBJECT
            }
            getChannelConfiguration() >> Stub(OutboundChannelConfigurationModel) {
                getDestination() >> Stub(ConsumedDestinationModel) {
                    getId() >> TEST_DESTINATION
                }
            }
        }
    }

    def defaultOutboundSyncService = new DefaultOutboundSyncService(
            itemModelSearchService, itemFactory, jobRegister, outboundServiceFacade)

    def setup() {
        defaultOutboundSyncService.syncRetryService = syncRetryService
        defaultOutboundSyncService.eventService = eventService
        defaultOutboundSyncService.outboundItemConsumer = outboundItemConsumer
    }

    @Test
    def "cannot be instantiated with null #param"() {
        when:
        new DefaultOutboundSyncService(search, factory, register, facade)

        then:
        def e = thrown IllegalArgumentException
        e.message == "$param cannot be null"

        where:
        param                     | search                       | factory                   | register                      | facade
        'ItemModelSearchService'  | null                         | Stub(OutboundItemFactory) | Stub(OutboundSyncJobRegister) | Stub(OutboundServiceFacade)
        'OutboundItemFactory'     | Stub(ItemModelSearchService) | null                      | Stub(OutboundSyncJobRegister) | Stub(OutboundServiceFacade)
        'OutboundSyncJobRegister' | Stub(ItemModelSearchService) | Stub(OutboundItemFactory) | null                          | Stub(OutboundServiceFacade)
        'OutboundServiceFacade'   | Stub(ItemModelSearchService) | Stub(OutboundItemFactory) | Stub(OutboundSyncJobRegister) | null
    }

    @Test
    def "item is synced successfully when httpStatus is #status"() {
        given: 'cronjob is running'
        def jobModel = notAbortedCronJob()
        cronJobByPkFound jobModel
        jobRegister.getJob(jobModel) >> outboundSyncJob()

        and: 'synchronization is successful'
        def outboundItemDTO = outboundItemDto(CHANGED_ITEM)
        outboundServiceFacade.send(SYNC_PARAMETERS) >> stubObservable(status)

        when:
        defaultOutboundSyncService.sync([outboundItemDTO])

        then:
        1 * outboundItemConsumer.consume(outboundItemDTO)
        1 * syncRetryService.handleSyncSuccess(_ as OutboundItemDTOGroup)

        where:
        status << [HttpStatus.CREATED, HttpStatus.OK]
    }

    @Test
    def "item is synced successfully when optional dependencies are not injected"() {
        given: 'optional dependencies are not injected'
        defaultOutboundSyncService.eventService = null
        defaultOutboundSyncService.outboundItemConsumer = null
        and: 'cronjob is running'
        def jobModel = notAbortedCronJob()
        cronJobByPkFound jobModel
        jobRegister.getJob(jobModel) >> outboundSyncJob()

        when:
        defaultOutboundSyncService.sync([outboundItemDto(CHANGED_ITEM)])

        then:
        1 * outboundServiceFacade.send(SYNC_PARAMETERS) >> stubObservable(HttpStatus.CREATED)
        1 * syncRetryService.handleSyncSuccess(_ as OutboundItemDTOGroup)
    }

    @Test
    def "item is not synced successfully when the outbound facade resulted in error"() {
        given: 'cronjob is running'
        def jobModel = notAbortedCronJob()
        cronJobByPkFound jobModel
        jobRegister.getJob(jobModel) >> outboundSyncJob()

        and: 'synchronization failed'
        def outboundItemDTO = outboundItemDto(CHANGED_ITEM)
        outboundServiceFacade.send(SYNC_PARAMETERS) >> stubObservableError()


        when:
        defaultOutboundSyncService.sync([outboundItemDTO])

        then:
        0 * outboundItemConsumer.consume(_)
        1 * eventService.publishEvent(new CompletedOutboundSyncEvent(CRON_JOB_PK, false, 1))
        and:
        1 * syncRetryService.handleSyncFailure({ it.outboundItemDTOs == [outboundItemDTO] })
    }

    @Test
    def 'change is not consumed when outbound sync facade crashes while sending the item'() {
        given: 'cronjob is running'
        def jobModel = notAbortedCronJob()
        cronJobByPkFound jobModel
        jobRegister.getJob(jobModel) >> outboundSyncJob()

        and: 'an item for the change'
        def outboundItemDTO = outboundItemDto(CHANGED_ITEM)

        and: 'the item send crashes'
        outboundServiceFacade.send(SYNC_PARAMETERS) >> { throw new RuntimeException() }

        and: 'more synchronization attempts are possible in future'
        syncRetryService.handleSyncFailure(_ as OutboundItemDTOGroup) >> false

        when:
        defaultOutboundSyncService.sync([outboundItemDTO])

        then:
        0 * outboundItemConsumer.consume(_)
        1 * eventService.publishEvent(new CompletedOutboundSyncEvent(CRON_JOB_PK, false, 1))
    }

    @Test
    def "facade returns error and it is the last retry"() {
        given: 'cronjob is running'
        def jobModel = notAbortedCronJob()
        cronJobByPkFound jobModel
        jobRegister.getJob(jobModel) >> outboundSyncJob()

        and: 'synchronization failed'
        def outboundItemDTO = outboundItemDto(CHANGED_ITEM)
        outboundServiceFacade.send(SYNC_PARAMETERS) >> stubObservableError()

        and: 'it was last synchronization attempt possible'
        syncRetryService.handleSyncFailure(_ as OutboundItemDTOGroup) >> true

        when:
        defaultOutboundSyncService.sync([outboundItemDTO])

        then:
        1 * outboundItemConsumer.consume(outboundItemDTO)
        1 * eventService.publishEvent(new CompletedOutboundSyncEvent(CRON_JOB_PK, false, 1))
    }

    @Test
    def "changes are not consumed when RetryUpdateException is thrown on last retry"() {
        given: 'cronjob is running'
        def jobModel = notAbortedCronJob()
        cronJobByPkFound jobModel
        jobRegister.getJob(jobModel) >> outboundSyncJob()

        and: 'synchronization failed'
        def outboundItemDTO = outboundItemDto(CHANGED_ITEM)
        outboundServiceFacade.send(SYNC_PARAMETERS) >> stubObservableError()

        and: 'an exception is thrown while handling the failure'
        syncRetryService.handleSyncFailure(_ as OutboundItemDTOGroup) >> { throw new RetryUpdateException(Stub(OutboundSyncRetryModel)) }

        when:
        defaultOutboundSyncService.sync([outboundItemDTO])

        then:
        0 * outboundItemConsumer.consume(_)
        1 * eventService.publishEvent(new CompletedOutboundSyncEvent(CRON_JOB_PK, false, 1))
    }

    @Test
    def "change not consumed on success case when a RetryUpdateException occurs"() {
        given: 'cronjob is running'
        def jobModel = notAbortedCronJob()
        cronJobByPkFound jobModel
        jobRegister.getJob(jobModel) >> outboundSyncJob()

        and: 'synchronization is successful'
        def outboundItemDTO = outboundItemDto(CHANGED_ITEM)
        outboundServiceFacade.send(SYNC_PARAMETERS) >> stubObservable(HttpStatus.CREATED)

        and: 'an exception is thrown while handling the success'
        syncRetryService.handleSyncSuccess(_ as OutboundItemDTOGroup) >> {
            throw new RetryUpdateException(new OutboundSyncRetryModel())
        }

        when:
        defaultOutboundSyncService.sync([outboundItemDTO])

        then:
        0 * outboundItemConsumer.consume(_)
        1 * eventService.publishEvent(new CompletedOutboundSyncEvent(CRON_JOB_PK, false, 1))
    }

    @Test
    def "CREATED item change is received, item is not found"() {
        given:
        def outboundItemDTO = Stub(OutboundItemDTO) {
            getItem() >> Stub(OutboundItemChange) {
                getChangeType() >> OutboundChangeType.CREATED
            }
            getRootItemPK() >> ROOT_ITEM_PK
            getCronJobPK() >> CRON_JOB_PK
        }

        and: 'cronjob is running'
        def jobModel = notAbortedCronJob()
        cronJobByPkFound jobModel
        jobRegister.getJob(jobModel) >> outboundSyncJob()

        and:
        itemModelSearchService.nonCachingFindByPk(PK.fromLong(ROOT_ITEM_PK)) >> Optional.empty()

        when:
        defaultOutboundSyncService.sync([outboundItemDTO])

        then:
        0 * outboundServiceFacade.send(_)
        0 * outboundItemConsumer.consume(_)
    }

    @Test
    def 'abort event is published when cronjob is aborting and item is not synchronized'() {
        given: 'aborting cronjob'
        def cronJob = Stub(OutboundSyncCronJobModel) {
            getPk() >> CRON_JOB_PK
            getRequestAbort() >> true
            getStatus() >> CronJobStatus.RUNNING
        }

        and: 'cronjob is found'
        cronJobByPkFound cronJob
        jobRegister.getJob(cronJob) >> outboundSyncJob()

        and: 'root item is found'
        itemModelSearchService.nonCachingFindByPk(PK.fromLong(ROOT_ITEM_PK)) >> Optional.of(Stub(ItemModel))

        and: 'a changed item'
        def outboundItemDto = outboundItemDto CHANGED_ITEM

        when:
        defaultOutboundSyncService.sync([outboundItemDto])

        then: 'abort event is published'
        1 * eventService.publishEvent(new AbortedOutboundSyncEvent(CRON_JOB_PK, 1))

        and: 'item is not synchronized'
        0 * outboundServiceFacade.send(_)
    }

    @Test
    def 'abort event is not published again when cronjob is aborted already and item is not synchronized'() {
        given: 'aborting cronjob'
        def cronJob = Stub(OutboundSyncCronJobModel) {
            getPk() >> CRON_JOB_PK
            getRequestAbort() >> null
            getStatus() >> CronJobStatus.ABORTED
        }

        and: 'cronjob is found'
        cronJobByPkFound cronJob

        and: 'the job is aborted'
        jobRegister.getJob(cronJob) >> abortedOutboundSyncJob()

        and: 'root item is found'
        itemModelSearchService.nonCachingFindByPk(PK.fromLong(ROOT_ITEM_PK)) >> Optional.of(Stub(ItemModel))

        and: 'a changed item'
        def outboundItemDto = outboundItemDto CHANGED_ITEM

        when:
        defaultOutboundSyncService.sync([outboundItemDto])

        then: 'no abort event published'
        0 * eventService.publishEvent(_ as AbortedOutboundSyncEvent)

        and: 'item is not synchronized'
        0 * outboundServiceFacade.send(_)
    }

    @Test
    def "completedOutboundSyncEvent is published when synchronization is successful"() {
        given: 'cronjob is running'
        def jobModel = notAbortedCronJob()
        cronJobByPkFound jobModel
        jobRegister.getJob(jobModel) >> outboundSyncJob()

        and: 'synchronization is successful'
        def outboundItemDTO1 = outboundItemDto(CHANGED_ITEM)
        def outboundItemDTO2 = outboundItemDto(CHANGED_ITEM)

        outboundServiceFacade.send(SYNC_PARAMETERS) >> stubObservable(HttpStatus.CREATED)

        when:
        defaultOutboundSyncService.sync([outboundItemDTO1, outboundItemDTO2])

        then:
        1 * eventService.publishEvent(new CompletedOutboundSyncEvent(CRON_JOB_PK, true, 2))
    }

    @Test
    def 'SystemErrorOutboundSyncEvent is published when there is a systemic error'() {
        given: 'cronJob is running'
        def jobModel = notAbortedCronJob()
        cronJobByPkFound jobModel
        jobRegister.getJob(jobModel) >> outboundSyncJob()

        and: 'a changed item'
        def outboundItemDto = outboundItemDto CHANGED_ITEM

        and: 'systemic error occurs'
        outboundServiceFacade.send(SYNC_PARAMETERS) >> { throw Mock(IntegrationAttributeException) }

        when:
        defaultOutboundSyncService.sync([outboundItemDto])

        then:
        1 * eventService.publishEvent(new SystemErrorOutboundSyncEvent(CRON_JOB_PK, 1))
    }

    @Test
    def 'no more items are synchronized when a systemic error occurs'() {
        given: 'cronJob is found'
        def jobModel = notAbortedCronJob()
        cronJobByPkFound jobModel

        and: 'cronJob with systemic error'
        jobRegister.getJob(jobModel) >> sysErrorOutboundSyncJob()

        and: 'a changed item'
        def outboundItemDto = outboundItemDto CHANGED_ITEM

        when:
        defaultOutboundSyncService.sync([outboundItemDto])

        then: 'no item sent'
        0 * outboundServiceFacade.send(_ as SyncParameters)
        and: 'SystemErrorOutboundSyncEvent is fired'
        0 * eventService.publishEvent(new SystemErrorOutboundSyncEvent(CRON_JOB_PK, 1))
    }

    @Test
    def 'only the item fails when a processing exception occurs'() {
        given: 'cronJob is running'
        def jobModel = notAbortedCronJob()
        cronJobByPkFound jobModel
        jobRegister.getJob(jobModel) >> outboundSyncJob()

        and: 'a changed item'
        def dtos = [outboundItemDto(CHANGED_ITEM)]

        and: 'failed processing item'
        outboundServiceFacade.send(SYNC_PARAMETERS) >> { throw Mock(IntegrationAttributeProcessingException) }

        when:
        defaultOutboundSyncService.sync dtos

        then: 'event fired to indicate the item failed'
        1 * eventService.publishEvent(new CompletedOutboundSyncEvent(CRON_JOB_PK, false, dtos.size()))
        and: 'no event fired to indicate a systemic error occurred'
        0 * eventService.publishEvent(_ as SystemErrorOutboundSyncEvent)
    }

    @Test
    def 'only the item fails when job register crashes'() {
        given: 'cronJob is running'
        def jobModel = notAbortedCronJob()
        cronJobByPkFound jobModel

        and: 'failed retrieving the job aggregate'
        jobRegister.getJob(jobModel) >> { throw new RuntimeException() }

        and:
        def itemDTOs = [outboundItemDto(CHANGED_ITEM)]

        when:
        defaultOutboundSyncService.sync itemDTOs

        then: 'event fired to indicate the item failed'
        1 * eventService.publishEvent(new CompletedOutboundSyncEvent(CRON_JOB_PK, false, itemDTOs.size()))
    }

    @Test
    def 'only the item fails when job item search by PK crashes'() {
        given: 'cronJob is running'
        def jobModel = notAbortedCronJob()
        cronJobByPkFound jobModel
        jobRegister.getJob(jobModel) >> outboundSyncJob()

        and: 'failed retrieving the root item'
        itemModelSearchService.nonCachingFindByPk(PK.fromLong(ROOT_ITEM_PK)) >> { throw new RuntimeException() }

        and:
        def itemDTOs = [outboundItemDto(CHANGED_ITEM)]

        when:
        defaultOutboundSyncService.sync itemDTOs

        then: 'event fired to indicate the item failed'
        1 * eventService.publishEvent(new CompletedOutboundSyncEvent(CRON_JOB_PK, false, itemDTOs.size()))
    }

    def stubObservable(HttpStatus httpStatus) {
        Observable.just Stub(ResponseEntity) {
            getStatusCode() >> httpStatus
        }
    }

    def stubObservableError() {
        stubObservable(HttpStatus.INTERNAL_SERVER_ERROR)
    }

    OutboundItemDTO outboundItemDto(itemModel) {
        itemModelSearchService.nonCachingFindByPk(PK.fromLong(ROOT_ITEM_PK)) >> Optional.of(itemModel)
        Stub(OutboundItemDTO) {
            getRootItemPK() >> ROOT_ITEM_PK
            getCronJobPK() >> CRON_JOB_PK
        }
    }

    private OutboundSyncCronJobModel notAbortedCronJob() {
        Stub(OutboundSyncCronJobModel) {
            getPk() >> CRON_JOB_PK
        }
    }

    private void cronJobByPkFound(OutboundSyncCronJobModel outboundSyncCronJobModel) {
        itemModelSearchService.nonCachingFindByPk(CRON_JOB_PK) >> Optional.of(outboundSyncCronJobModel)
    }

    private OutboundSyncJob outboundSyncJob() {
        Stub(OutboundSyncJob) {
            getCurrentState() >> initialOutboundSyncState().build()
        }
    }

    private OutboundSyncJob abortedOutboundSyncJob() {
        Stub(OutboundSyncJob) {
            getCurrentState() >> initialOutboundSyncState()
                    .withTotalItems(1)
                    .withUnprocessedCount(1)
                    .withAborted(true)
                    .build()
        }
    }

    private OutboundSyncJob sysErrorOutboundSyncJob() {
        Stub(OutboundSyncJob) {
            getCurrentState() >> initialOutboundSyncState()
                    .withSystemicError(true)
                    .build()
        }
    }

    private static SyncParameters syncParametersFor(ItemModel item) {
        SyncParameters.syncParametersBuilder()
                .withItem(item)
                .withIntegrationObjectCode(TEST_INTEGRATION_OBJECT)
                .withDestinationId(TEST_DESTINATION)
                .withSource(OutboundSource.OUTBOUNDSYNC)
                .build()
    }
}