/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { ISlotSyncStatus } from '../../../entities/synchronization';
const catalogVersionUuid = 'apparel-ukContentCatalog/Staged';
export const bottomHeaderSlotSyncStatus: ISlotSyncStatus = {
    itemId: 'bottomHeaderSlot',
    itemType: 'bottomHeaderSlotContentSlot',
    name: 'bottomHeaderSlot',
    lastSyncStatus: new Date().getTime(),
    status: 'NOT_SYNC',
    catalogVersionUuid,
    selectedDependencies: [
        {
            itemId: 'component3',
            itemType: 'ContentSlot',
            name: 'component3',
            lastSyncStatus: new Date().getTime(),
            status: 'IN_SYNC',
            catalogVersionUuid
        },
        {
            itemId: 'component4',
            itemType: 'ContentSlot',
            name: 'component4',
            lastSyncStatus: new Date().getTime(),
            status: 'NOT_SYNC',
            dependentItemTypesOutOfSync: [
                {
                    type: 'Component',
                    i18nKey: 'some.key.for.Component'
                }
            ],
            catalogVersionUuid
        }
    ],
    dependentItemTypesOutOfSync: [
        {
            type: 'ContentSlot',
            i18nKey: 'some.key.for.component4'
        }
    ],
    unavailableDependencies: []
};
