/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { ISyncItem } from './syncItem.entity';

export interface ISyncDependency {
    itemId: string;
    itemType: string;
    name: string;
    lastSyncStatus?: number;
    status: string;
    dependentItemTypesOutOfSync?: ISyncItem[];
    catalogVersionUuid: string;
}
