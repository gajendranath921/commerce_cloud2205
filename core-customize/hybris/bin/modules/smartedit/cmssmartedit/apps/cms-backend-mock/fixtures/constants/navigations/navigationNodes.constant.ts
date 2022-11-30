/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { INavigationNode } from '../../entities/navigations/navigationNode.entity';

const CMS_NAVIGATION_NODE_ROOT = 'CMSNavigationNode-root';
const CMS_NAVIGATION_NODE1 = 'CMSNavigationNode-1';
const CMS_NAVIGATION_NODE2 = 'CMSNavigationNode-2';
const CMS_NAVIGATION_NODE4 = 'CMSNavigationNode-4';
const CMS_NAVIGATION_NODE8 = 'CMSNavigationNode-8';
const APRAREL_UK_ONLINE = 'apparel-ukContentCatalog/Online';
export const navigationNodes: INavigationNode[] = [
    {
        uid: 'root',
        name: 'ROOT',
        uuid: CMS_NAVIGATION_NODE_ROOT,
        itemtype: 'CMSNavigationNode',
        position: 0,
        hasChildren: true,
        children: [CMS_NAVIGATION_NODE1, CMS_NAVIGATION_NODE2],
        catalogVersion: APRAREL_UK_ONLINE
    },
    {
        uid: '1',
        name: 'node1',
        title: {
            en: 'node1_en',
            fr: 'node1_fr'
        },
        uuid: CMS_NAVIGATION_NODE1,
        itemtype: 'CMSNavigationNode',
        parent: CMS_NAVIGATION_NODE_ROOT,
        parentUid: 'root',
        position: 0,
        hasChildren: true,
        hasEntries: true,
        children: [CMS_NAVIGATION_NODE4, 'CMSNavigationNode-5', 'CMSNavigationNode-7'],
        catalogVersion: APRAREL_UK_ONLINE
    },
    {
        uid: '2',
        name: 'node2',
        title: {
            en: 'node2_en',
            fr: 'node2_fr'
        },
        uuid: CMS_NAVIGATION_NODE2,
        itemtype: 'CMSNavigationNode',
        parent: CMS_NAVIGATION_NODE_ROOT,
        parentUid: 'root',
        position: 1,
        hasChildren: true,
        hasEntries: false,
        children: ['CMSNavigationNode-6'],
        catalogVersion: APRAREL_UK_ONLINE
    },
    {
        uid: '4',
        name: 'node4',
        title: {
            en: 'node4_en',
            fr: 'node4_fr'
        },
        uuid: CMS_NAVIGATION_NODE4,
        itemtype: 'CMSNavigationNode',
        parent: CMS_NAVIGATION_NODE1,
        parentUid: '1',
        position: 0,
        hasChildren: true,
        hasEntries: true,
        children: [CMS_NAVIGATION_NODE8],
        catalogVersion: APRAREL_UK_ONLINE
    },
    {
        uid: '5',
        name: 'node5',
        title: {
            en: 'node5_en',
            fr: 'node5_fr'
        },
        uuid: 'CMSNavigationNode-5',
        itemtype: 'CMSNavigationNode',
        parent: CMS_NAVIGATION_NODE1,
        parentUid: '1',
        position: 1,
        hasChildren: false,
        hasEntries: false,
        children: [],
        catalogVersion: APRAREL_UK_ONLINE
    },
    {
        uid: '6',
        name: 'node6',
        title: {
            en: 'node6_en',
            fr: 'node6_fr'
        },
        uuid: 'CMSNavigationNode-6',
        itemtype: 'CMSNavigationNode',
        parent: CMS_NAVIGATION_NODE2,
        parentUid: '2',
        position: 0,
        hasChildren: false,
        hasEntries: false,
        children: [],
        catalogVersion: APRAREL_UK_ONLINE
    },
    {
        uid: '7',
        name: 'node7',
        title: {
            en: 'node7_en',
            fr: 'node7_fr'
        },
        uuid: 'CMSNavigationNode-7',
        itemtype: 'CMSNavigationNode',
        parent: CMS_NAVIGATION_NODE1,
        parentUid: '1',
        position: 2,
        hasChildren: false,
        hasEntries: false,
        children: [],
        catalogVersion: APRAREL_UK_ONLINE
    },
    {
        uid: '8',
        name: 'node8',
        title: {
            en: 'node8_en',
            fr: 'node8_fr'
        },
        uuid: CMS_NAVIGATION_NODE8,
        itemtype: 'CMSNavigationNode',
        parent: CMS_NAVIGATION_NODE4,
        parentUid: '4',
        position: 0,
        hasChildren: true,
        hasEntries: true,
        children: ['CMSNavigationNode-9'],
        catalogVersion: APRAREL_UK_ONLINE
    },
    {
        uid: '9',
        name: 'node9',
        title: {
            en: 'node9_en',
            fr: 'node9_fr'
        },
        uuid: 'CMSNavigationNode-9',
        itemtype: 'CMSNavigationNode',
        parent: CMS_NAVIGATION_NODE8,
        parentUid: '8',
        position: 0,
        hasChildren: false,
        hasEntries: false,
        children: [],
        catalogVersion: APRAREL_UK_ONLINE
    },
    {
        uuid: 'navigationComponent',
        uid: 'navigationComponent',
        navigationComponent: CMS_NAVIGATION_NODE8,
        catalogVersion: APRAREL_UK_ONLINE
    }
];
