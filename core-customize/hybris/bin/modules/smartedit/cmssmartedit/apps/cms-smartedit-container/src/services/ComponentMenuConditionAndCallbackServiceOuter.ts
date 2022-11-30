/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { IComponentMenuConditionAndCallbackService } from 'cmscommons';
import { GatewayProxied, SeDowngradeService } from 'smarteditcommons';

@SeDowngradeService(IComponentMenuConditionAndCallbackService)
@GatewayProxied(
    'externalCondition',
    'removeCondition',
    'removeCallback',
    'cloneCondition',
    'cloneCallback',
    'sharedCondition',
    'editConditionForHiddenComponent'
)
export class ComponentMenuConditionAndCallbackService extends IComponentMenuConditionAndCallbackService {}
