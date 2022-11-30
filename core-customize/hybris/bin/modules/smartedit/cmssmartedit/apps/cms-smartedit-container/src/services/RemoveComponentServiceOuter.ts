/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { IRemoveComponentService } from 'cmscommons';
import { GatewayProxied, SeDowngradeService } from 'smarteditcommons';

@GatewayProxied('removeComponent')
@SeDowngradeService(IRemoveComponentService)
export class RemoveComponentService extends IRemoveComponentService {}
