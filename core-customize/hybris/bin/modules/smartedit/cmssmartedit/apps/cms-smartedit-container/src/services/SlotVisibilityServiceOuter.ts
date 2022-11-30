/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { ISlotVisibilityService } from 'cmscommons';
import { GatewayProxied, SeDowngradeService } from 'smarteditcommons';

@SeDowngradeService(ISlotVisibilityService)
@GatewayProxied('getHiddenComponents')
export class SlotVisibilityService extends ISlotVisibilityService {}
