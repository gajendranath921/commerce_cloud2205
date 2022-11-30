/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { IPersonalizationsmarteditContextServiceProxy } from 'personalizationcommons';
import { SeDowngradeService, GatewayProxied } from 'smarteditcommons';

@GatewayProxied('setPersonalization', 'setCustomize', 'setCombinedView', 'setSeData')
@SeDowngradeService(IPersonalizationsmarteditContextServiceProxy)
export class PersonalizationsmarteditContextServiceProxy extends IPersonalizationsmarteditContextServiceProxy {
    constructor() {
        super();
    }
}
