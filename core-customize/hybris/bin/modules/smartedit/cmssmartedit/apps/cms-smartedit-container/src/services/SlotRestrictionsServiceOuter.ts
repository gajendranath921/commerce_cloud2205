/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { GatewayProxied, SeDowngradeService, ISlotRestrictionsService } from 'smarteditcommons';

@SeDowngradeService(ISlotRestrictionsService)
@GatewayProxied('getAllComponentTypesSupportedOnPage', 'getSlotRestrictions')
export class SlotRestrictionsService extends ISlotRestrictionsService {}
