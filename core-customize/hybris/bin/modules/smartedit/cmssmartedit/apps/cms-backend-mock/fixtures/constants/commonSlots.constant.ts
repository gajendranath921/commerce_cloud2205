/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { ICommonSlot } from '../entities/commonSlot.entity';
const APPAREL_UK_CONTENT_CATALOG_STAGE = 'apparel-ukContentCatalog/Staged';
export const commonSlots: ICommonSlot[] = [
    {
        uid: 'component1',
        uuid: 'component1',
        name: 'Component 1',
        visible: true,
        typeCode: 'SimpleResponsiveBannerComponent',
        catalogVersion: APPAREL_UK_CONTENT_CATALOG_STAGE,
        slots: []
    },
    {
        uid: 'component2',
        uuid: 'component2',
        name: 'Component 2',
        visible: true,
        typeCode: 'componentType2',
        catalogVersion: APPAREL_UK_CONTENT_CATALOG_STAGE,
        slots: []
    },
    {
        uid: 'component3',
        uuid: 'component3',
        name: 'Component 3',
        visible: true,
        typeCode: 'componentType3',
        catalogVersion: APPAREL_UK_CONTENT_CATALOG_STAGE,
        slots: []
    },
    {
        uid: 'component4',
        uuid: 'component4',
        name: 'Component 4',
        visible: true,
        typeCode: 'componentType4',
        catalogVersion: APPAREL_UK_CONTENT_CATALOG_STAGE,
        slots: []
    },
    {
        uid: 'component5',
        uuid: 'component5',
        name: 'Component 5',
        visible: true,
        typeCode: 'componentType5',
        catalogVersion: APPAREL_UK_CONTENT_CATALOG_STAGE,
        slots: []
    },
    {
        uid: 'hiddenComponent1',
        uuid: 'hiddenComponent1',
        name: 'Hidden Component 1',
        visible: false,
        typeCode: 'AbstractCMSComponent',
        catalogVersion: APPAREL_UK_CONTENT_CATALOG_STAGE,
        slots: []
    },
    {
        uid: 'hiddenComponent2',
        uuid: 'hiddenComponent2',
        name: 'Hidden Component 2',
        visible: false,
        typeCode: 'AbstractCMSComponent',
        catalogVersion: APPAREL_UK_CONTENT_CATALOG_STAGE,
        slots: ['bottomHeaderSlot', 'footerSlot']
    },
    {
        uid: 'hiddenComponent3',
        uuid: 'hiddenComponent3',
        name: 'Hidden Component 3',
        visible: false,
        typeCode: 'AbstractCMSComponent',
        catalogVersion: APPAREL_UK_CONTENT_CATALOG_STAGE,
        slots: []
    }
];
