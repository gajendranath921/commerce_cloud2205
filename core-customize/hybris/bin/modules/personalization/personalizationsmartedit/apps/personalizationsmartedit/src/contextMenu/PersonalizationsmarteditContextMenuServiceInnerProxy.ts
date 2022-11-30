/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */

import { IPersonalizationsmarteditContextMenuServiceProxy } from 'personalizationcommons';
import { GatewayProxied, SeDowngradeService } from 'smarteditcommons';

@GatewayProxied('openDeleteAction', 'openAddAction', 'openEditAction', 'openEditComponentAction')
@SeDowngradeService(IPersonalizationsmarteditContextMenuServiceProxy)
export class PersonalizationsmarteditContextMenuServiceProxy extends IPersonalizationsmarteditContextMenuServiceProxy {
    constructor() {
        super();
    }
}
