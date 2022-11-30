/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { Dictionary } from 'lodash';
import { GatewayProxied, SeDowngradeService } from 'smarteditcommons';
@SeDowngradeService()
@GatewayProxied('getSourceContainersInfo')
export class CustomizeViewServiceProxy {
    getSourceContainersInfo(): Dictionary<number> {
        'proxyFunction';
        return null;
    }
}
