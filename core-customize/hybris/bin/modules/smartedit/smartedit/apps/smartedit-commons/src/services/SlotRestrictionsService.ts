/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { SeDowngradeService } from '../di';
import { GatewayProxied } from './gatewayProxiedAnnotation';
import { ISlotRestrictionsService, COMPONENT_IN_SLOT_STATUS } from './interfaces';

@SeDowngradeService(ISlotRestrictionsService)
@GatewayProxied(
    'getAllComponentTypesSupportedOnPage',
    'getSlotRestrictions',
    'isSlotEditable',
    'isComponentAllowedInSlot'
)
export class SlotRestrictionsService extends ISlotRestrictionsService {
    public getAllComponentTypesSupportedOnPage(): Promise<any[] | void> {
        return null;
    }

    public getSlotRestrictions(slotId: string): Promise<string[] | void> {
        return null;
    }

    public isSlotEditable(slotId: string): Promise<boolean> {
        return null;
    }

    public isComponentAllowedInSlot(slot: any, dragInfo: any): Promise<COMPONENT_IN_SLOT_STATUS> {
        return null;
    }
}
