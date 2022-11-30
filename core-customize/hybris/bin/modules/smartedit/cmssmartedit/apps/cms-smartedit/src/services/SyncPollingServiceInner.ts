/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { DEFAULT_SYNCHRONIZATION_POLLING } from 'cmscommons';
import {
    GatewayProxied,
    SeDowngradeService,
    SystemEventService,
    ISyncPollingService
} from 'smarteditcommons';

@SeDowngradeService(ISyncPollingService)
@GatewayProxied(
    'getSyncStatus',
    'fetchSyncStatus',
    'changePollingSpeed',
    'registerSyncPollingEvents',
    'performSync'
)
export class SyncPollingService extends ISyncPollingService {
    constructor(private systemEventService: SystemEventService) {
        super();

        this.registerSyncPollingEvents();
    }

    public registerSyncPollingEvents(): void {
        this.systemEventService.subscribe(
            DEFAULT_SYNCHRONIZATION_POLLING.SPEED_UP,
            this.changePollingSpeed.bind(this)
        );
        this.systemEventService.subscribe(
            DEFAULT_SYNCHRONIZATION_POLLING.SLOW_DOWN,
            this.changePollingSpeed.bind(this)
        );
    }
}
