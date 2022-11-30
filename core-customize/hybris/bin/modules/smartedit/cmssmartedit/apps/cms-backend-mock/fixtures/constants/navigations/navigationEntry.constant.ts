/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { INavigationEntry } from '../../entities/navigations/navigationEntry.entity';
const APPAREL_UK_ONLINE = 'apparel-ukContentCatalog/Online';
export const navigationNodes: INavigationEntry[] = [
    {
        name: 'name-HomepageNavLink',
        itemId: 'HomepageNavLink',
        itemType: 'CMSLinkComponent',
        itemSuperType: 'AbstractCMSComponent',
        navigationNodeUid: '1',
        uid: '1',
        catalogVersion: APPAREL_UK_ONLINE
    },
    {
        name: 'name-69SlamLink',
        itemId: '69SlamLink',
        itemType: 'CMSParagraphComponent',
        itemSuperType: 'AbstractCMSComponent',
        navigationNodeUid: '1',
        uid: '2',
        catalogVersion: APPAREL_UK_ONLINE
    },
    {
        name: 'name-DakineLink',
        itemId: 'DakineLink',
        itemType: 'CMSLinkComponent',
        itemSuperType: 'AbstractCMSComponent',
        navigationNodeUid: '1',
        uid: '6',
        catalogVersion: APPAREL_UK_ONLINE
    },
    {
        name: 'Entry 4.1',
        itemId: 'Item-ID-4.1',
        itemType: 'ItemType 4.1',
        itemSuperType: 'AbstractCMSComponent',
        navigationNodeUid: '4',
        uid: '3',
        catalogVersion: APPAREL_UK_ONLINE
    },
    {
        name: 'name-Item-ID-4.2',
        itemId: 'Item-ID-4.2',
        itemType: 'ItemType 4.2',
        itemSuperType: 'AbstractCMSComponent',
        navigationNodeUid: '4',
        uid: '4',
        catalogVersion: APPAREL_UK_ONLINE
    },
    {
        name: 'name-Item-ID-6.1',
        itemId: 'Item-ID-6.1',
        itemType: 'ItemType 6.1',
        itemSuperType: 'AbstractCMSComponent',
        navigationNodeUid: '6',
        uid: '5',
        catalogVersion: APPAREL_UK_ONLINE
    },
    {
        name: 'name-Item-ID-8.1',
        itemId: 'Item-ID-8.1',
        itemType: 'CMSLinkComponent',
        itemSuperType: 'AbstractCMSComponent',
        navigationNodeUid: '8',
        uid: '6',
        catalogVersion: APPAREL_UK_ONLINE
    },
    {
        name: 'name-Item-ID-8.2',
        itemId: 'Item-ID-8.2',
        itemType: 'CMSParagraphComponent',
        itemSuperType: 'AbstractCMSComponent',
        navigationNodeUid: '8',
        uid: '7',
        catalogVersion: APPAREL_UK_ONLINE
    }
];
