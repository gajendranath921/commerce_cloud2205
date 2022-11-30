/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
export interface ISyncPermission {
    canSynchronize: boolean;
    targetCatalogVersion: string;
}
