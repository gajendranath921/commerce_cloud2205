/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
export interface IPageContentSlot {
    pageId: string;
    position: string;
    slotId: string;
    slotShared?: boolean;
    slotStatus?: string;
}

export const bottomHeaderSlot: IPageContentSlot = {
    pageId: 'homepage',
    position: 'topHeader',
    slotId: 'bottomHeaderSlot'
};
