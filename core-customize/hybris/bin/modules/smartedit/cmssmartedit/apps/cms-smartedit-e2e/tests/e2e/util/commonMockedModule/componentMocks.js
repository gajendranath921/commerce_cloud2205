/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint unused:false */
var UUID_NAVIGATION_ROOT = 'CMSNavigationNode-root';
var UUID_NAVIGATION_NODE_1 = 'CMSNavigationNode-1';
var UUID_NAVIGATION_NODE_2 = 'CMSNavigationNode-2';
var UUID_NAVIGATION_NODE_4 = 'CMSNavigationNode-4';
var UUID_NAVIGATION_NODE_8 = 'CMSNavigationNode-8';
var UUID_ADD_EDIT_ADDRESS = 'add-edit-address';

var ITEM_ID_4_1 = 'Item-ID-4.1';
var ITEM_ID_4_2 = 'Item-ID-4.2';
var ITEM_ID_8_1 = 'Item-ID-8.1';
var ITEM_ID_8_2 = 'Item-ID-8.2';
var HEADLINE = 'The Headline';
var CONTENT_EN = 'the content to edit';
var PRIMARY_TITLE_EN = 'Primary Content Page';
var VARIATION_TITLE_EN = 'Variation Content Page';
var LABEL_I_HATE_PANDAS = 'i-hate-pandas';
var SOME_DESCRIPTION = 'some description';

var CATALOG_VERSION_APPAREL_UK_ONLINE = 'apparel-ukContentCatalog/Online';
var CATALOG_VERSION_APPAREL_UK_STAGE = 'apparel-ukContentCatalog/Staged';
var CATALOG_VERSION_APPAREL_ONLINE = 'apparelContentCatalog/Online';

angular
    .module('componentMocks', ['backendMocksUtilsModule'])
    .constant('navigationNodeNodes', [
        {
            uid: 'root',
            name: 'ROOT',
            uuid: UUID_NAVIGATION_ROOT,
            itemtype: 'CMSNavigationNode',
            position: 0,
            hasChildren: true,
            children: [UUID_NAVIGATION_NODE_1, UUID_NAVIGATION_NODE_2],
            catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
        },
        {
            uid: '1',
            name: 'node1',
            title: {
                en: 'node1_en',
                fr: 'node1_fr'
            },
            uuid: UUID_NAVIGATION_NODE_1,
            itemtype: 'CMSNavigationNode',
            parent: UUID_NAVIGATION_ROOT,
            parentUid: 'root',
            position: 0,
            hasChildren: true,
            hasEntries: true,
            children: [UUID_NAVIGATION_NODE_4, 'CMSNavigationNode-5', 'CMSNavigationNode-7'],
            catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
        },
        {
            uid: '2',
            name: 'node2',
            title: {
                en: 'node2_en',
                fr: 'node2_fr'
            },
            uuid: UUID_NAVIGATION_NODE_2,
            itemtype: 'CMSNavigationNode',
            parent: UUID_NAVIGATION_ROOT,
            parentUid: 'root',
            position: 1,
            hasChildren: true,
            hasEntries: false,
            children: ['CMSNavigationNode-6'],
            catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
        },
        {
            uid: '4',
            name: 'node4',
            title: {
                en: 'node4_en',
                fr: 'node4_fr'
            },
            uuid: UUID_NAVIGATION_NODE_4,
            itemtype: 'CMSNavigationNode',
            parent: UUID_NAVIGATION_NODE_1,
            parentUid: '1',
            position: 0,
            hasChildren: true,
            hasEntries: true,
            children: [UUID_NAVIGATION_NODE_8],
            catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
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
            parent: UUID_NAVIGATION_NODE_1,
            parentUid: '1',
            position: 1,
            hasChildren: false,
            hasEntries: false,
            children: [],
            catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
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
            parent: UUID_NAVIGATION_NODE_2,
            parentUid: '2',
            position: 0,
            hasChildren: false,
            hasEntries: false,
            children: [],
            catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
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
            parent: UUID_NAVIGATION_NODE_1,
            parentUid: '1',
            position: 2,
            hasChildren: false,
            hasEntries: false,
            children: [],
            catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
        },
        {
            uid: '8',
            name: 'node8',
            title: {
                en: 'node8_en',
                fr: 'node8_fr'
            },
            uuid: UUID_NAVIGATION_NODE_8,
            itemtype: 'CMSNavigationNode',
            parent: UUID_NAVIGATION_NODE_4,
            parentUid: '4',
            position: 0,
            hasChildren: true,
            hasEntries: true,
            children: ['CMSNavigationNode-9'],
            catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
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
            parent: UUID_NAVIGATION_NODE_8,
            parentUid: '8',
            position: 0,
            hasChildren: false,
            hasEntries: false,
            children: [],
            catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
        },
        {
            uuid: 'navigationComponent',
            uid: 'navigationComponent',
            navigationComponent: UUID_NAVIGATION_NODE_8,
            catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
        }
    ])
    .constant('navigationNodeEntries', [
        {
            name: 'name-HomepageNavLink',
            itemId: 'HomepageNavLink',
            itemType: 'CMSLinkComponent',
            itemSuperType: 'AbstractCMSComponent',
            navigationNodeUid: '1',
            uid: '1',
            catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
        },
        {
            name: 'name-69SlamLink',
            itemId: '69SlamLink',
            itemType: 'CMSParagraphComponent',
            itemSuperType: 'AbstractCMSComponent',
            navigationNodeUid: '1',
            uid: '2',
            catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
        },
        {
            name: 'name-DakineLink',
            itemId: 'DakineLink',
            itemType: 'CMSLinkComponent',
            itemSuperType: 'AbstractCMSComponent',
            navigationNodeUid: '1',
            uid: '6',
            catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
        },
        {
            name: 'Entry 4.1',
            itemId: ITEM_ID_4_1,
            itemType: 'ItemType 4.1',
            itemSuperType: 'AbstractCMSComponent',
            navigationNodeUid: '4',
            uid: '3',
            catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
        },
        {
            name: 'name-Item-ID-4.2',
            itemId: ITEM_ID_4_2,
            itemType: 'ItemType 4.2',
            itemSuperType: 'AbstractCMSComponent',
            navigationNodeUid: '4',
            uid: '4',
            catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
        },
        {
            name: 'name-Item-ID-6.1',
            itemId: 'Item-ID-6.1',
            itemType: 'ItemType 6.1',
            itemSuperType: 'AbstractCMSComponent',
            navigationNodeUid: '6',
            uid: '5',
            catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
        },
        {
            name: 'name-Item-ID-8.1',
            itemId: ITEM_ID_8_1,
            itemType: 'CMSLinkComponent',
            itemSuperType: 'AbstractCMSComponent',
            navigationNodeUid: '8',
            uid: '6',
            catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
        },
        {
            name: 'name-Item-ID-8.2',
            itemId: ITEM_ID_8_2,
            itemType: 'CMSParagraphComponent',
            itemSuperType: 'AbstractCMSComponent',
            navigationNodeUid: '8',
            uid: '7',
            catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
        }
    ])
    .factory('navigationNodePOST', function (navigationNodeNodes) {
        return function (data) {
            var payload = JSON.parse(data);
            var uid = '' + new Date().getTime();

            var parent = navigationNodeNodes.find(function (node) {
                return node.uuid === payload.parent;
            });
            if (parent) {
                payload.parentUid = parent.uid;
            }

            var nodeCountWithSameParent = navigationNodeNodes.filter(function (node) {
                return node.parentUid === payload.parentUid;
            }).length;

            if (!payload.name) {
                return [
                    400,
                    {
                        errors: [
                            {
                                message: 'name cannot be empty',
                                subject: 'name',
                                type: 'ValidationError'
                            }
                        ]
                    }
                ];
            }

            payload.uid = uid;
            payload.uuid = 'CMSNavigationNode-' + uid;
            payload.itemtype = 'CMSNavigationNode';
            payload.hasChildren = false;
            payload.entries = payload.entries || [];
            payload.position = nodeCountWithSameParent;

            if (parent) {
                parent.children = parent.children || [];
                parent.children.push(payload.uuid);
            }

            navigationNodeNodes.push(payload);
            return [200, payload];
        };
    })
    .run(function (
        httpBackendService,
        parseQuery,
        backendMocksUtils,
        navigationNodePOST,
        navigationNodeNodes
    ) {
        var items = {
            componentItems: navigationNodeNodes.concat([
                {
                    name: 'SomePageTemplate',
                    typeCode: 'Template',
                    itemtype: 'Template',
                    uid: 'SomePageTemplate',
                    uuid: 'SomePageTemplate'
                },
                {
                    creationtime: '2016-08-17T16:05:47+0000',
                    modifiedtime: '2016-08-17T16:05:47+0000',
                    name: 'Component1',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'component1',
                    uuid: 'component1',
                    visible: true,
                    slots: []
                },
                {
                    creationtime: '2016-08-17T16:05:47+0000',
                    modifiedtime: '2016-08-17T16:05:47+0000',
                    name: 'Component2',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'component2',
                    uuid: 'component2',
                    visible: true,
                    slots: []
                },
                {
                    creationtime: '2016-08-17T16:05:47+0000',
                    modifiedtime: '2016-08-17T16:05:47+0000',
                    name: 'Component3',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'component3',
                    uuid: 'component3',
                    visible: true,
                    slots: []
                },
                {
                    creationtime: '2016-08-17T16:05:47+0000',
                    modifiedtime: '2016-08-17T16:05:47+0000',
                    name: 'Component4',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'component4',
                    uuid: 'component4',
                    visible: true,
                    slots: []
                },
                {
                    creationtime: '2016-08-17T16:05:47+0000',
                    modifiedtime: '2016-08-17T16:05:47+0000',
                    name: 'Component5',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'component5',
                    uuid: 'component5',
                    visible: true,
                    slots: []
                },
                {
                    name: 'Component6',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'Component6',
                    uuid: 'Component6',
                    slots: []
                },
                {
                    name: 'Component7',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'Component7',
                    uuid: 'Component7',
                    slots: []
                },
                {
                    name: 'Component8',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'Component8',
                    uuid: 'Component8',
                    slots: ['bottomHeaderSlot', 'footerSlot'] // This component is used as a shared component test
                },
                {
                    name: 'Component9',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'Component9',
                    uuid: 'Component9',
                    slots: []
                },
                {
                    name: 'Component10',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'Component10',
                    uuid: 'Component10',
                    cloneable: true,
                    slots: []
                },
                {
                    name: 'Component11',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'Component11',
                    uuid: 'Component11',
                    slots: []
                },
                {
                    name: 'Component12',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'Component12',
                    uuid: 'Component12',
                    slots: []
                },
                {
                    name: 'Component13',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'Component13',
                    uuid: 'Component13'
                },
                {
                    name: 'Component14',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'Component14',
                    uuid: 'Component14',
                    slots: []
                },
                {
                    name: 'Component15',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'Component15',
                    uuid: 'Component15',
                    slots: []
                },
                {
                    name: 'Component16',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'Component16',
                    uuid: 'Component16',
                    slots: []
                },
                {
                    name: 'Component17',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'Component17',
                    uuid: 'Component6',
                    slots: []
                },
                {
                    name: 'Component18',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'Component18',
                    uuid: 'Component18',
                    slots: []
                },
                {
                    name: 'Component19',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'Component19',
                    uuid: 'Component19',
                    slots: []
                },
                {
                    name: 'Component20',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'Component20',
                    uuid: 'Component20',
                    slots: []
                },
                {
                    name: 'Component21',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'Component21',
                    uuid: 'Component21',
                    slots: []
                },
                {
                    name: 'Component22',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'Component22',
                    uuid: 'Component22',
                    slots: []
                },
                {
                    name: 'Component23',
                    typeCode: 'AbstractCMSComponent',
                    uid: 'Component23',
                    uuid: 'Component23',
                    slots: []
                },
                {
                    id: 'MyParagraph',
                    uid: 'Comp_0006456345634',
                    uuid: 'Comp_0006456345634',
                    name: 'Custom Paragraph Component',
                    headline: HEADLINE,
                    active: true,
                    content: CONTENT_EN,
                    activationDate: new Date().getTime(),
                    creationtime: new Date().getTime(),
                    modifiedtime: new Date().getTime(),
                    media: '4',
                    external: false,
                    visible: true,
                    restrictions: [],
                    onlyOneRestrictionMustApply: false,
                    slots: ['mocked_slot_id']
                },
                {
                    uid: 'componentWithMedia',
                    uuid: 'componentWithMedia',
                    media: {
                        en: 'contextualmenu_delete_off'
                    },
                    slots: []
                },
                {
                    uid: 'componentWithMediaContainer',
                    uuid: 'componentWithMediaContainer',
                    media: {
                        en: {
                            medias: {
                                widescreen: 'clone4',
                                desktop: 'dnd5'
                            },
                            qualifier: 'media container name'
                        }
                    },
                    slots: []
                },
                {
                    uid: 'componentToValidateId',
                    uuid: 'componentToValidateId',
                    headline: HEADLINE,
                    active: true,
                    content: {
                        en: CONTENT_EN,
                        fr: 'le contenu a editer',
                        pl: 'tresc edytowac',
                        it: 'il contenuto da modificare',
                        hi: 'Sampaadit karanee kee liee saamagree'
                    },
                    media: {
                        en: 'contextualmenu_delete_off',
                        hi: 'contextualmenu_delete_on'
                    },
                    orientation: 'vertical',
                    linkToggle: {
                        external: false,
                        urlLink: '/url-link'
                    },
                    slots: []
                },
                {
                    uid: '8',
                    uuid: '8',
                    navigationComponent: '8',
                    slots: []
                },
                {
                    uid: '8',
                    uuid: 'navigationComponent',
                    navigationComponent: '8',
                    slots: []
                },
                {
                    uid: '4',
                    uuid: 'node4'
                },
                {
                    uid: 'HomepageNavLink',
                    uuid: 'HomepageNavLink',
                    typeCode: 'CMSLinkComponent',
                    linkName: {
                        en: 'ABC Entry'
                    },
                    slots: []
                },
                {
                    uid: '69SlamLink',
                    typeCode: '69SlamLink',
                    name: {
                        en: 'DEF Entry'
                    },
                    slots: []
                },
                {
                    uid: 'DakineLink',
                    uuid: 'DakineLink',
                    typeCode: 'CMSParagraphComponent',
                    name: 'GHI Entry',
                    slots: []
                },
                {
                    uid: 'AlMerrickLink',
                    uuid: 'AlMerrickLink',
                    typeCode: 'CMSParagraphComponent',
                    name: 'XYZ Entry',
                    slots: []
                },
                {
                    uid: ITEM_ID_8_1,
                    uuid: ITEM_ID_8_1,
                    typeCode: 'CMSLinkComponent',
                    linkName: {
                        en: 'JKL Entry'
                    },
                    slots: []
                },
                {
                    uid: ITEM_ID_8_2,
                    uuid: ITEM_ID_8_2,
                    typeCode: 'CMSParagraphComponent',
                    name: 'MNO Entry',
                    slots: []
                },
                {
                    uid: ITEM_ID_4_1,
                    uuid: ITEM_ID_4_1,
                    typeCode: 'CMSParagraphComponent',
                    name: 'PQR Entry',
                    slots: []
                },
                {
                    uid: ITEM_ID_4_2,
                    uuid: ITEM_ID_4_2,
                    typeCode: 'CMSParagraphComponent',
                    name: 'STU Entry',
                    slots: []
                },
                {
                    name: 'Home Page Nav Link',
                    typeCode: 'CMSLinkComponent',
                    uid: 'HomepageNavLink',
                    uuid: 'HomepageNavLink',
                    visible: true,
                    slots: []
                },
                {
                    name: 'Al Merrick Link',
                    typeCode: 'CMSLinkComponent',
                    uid: 'AlMerrickLink',
                    uuid: 'AlMerrickLink',
                    visible: true,
                    slots: []
                },
                {
                    name: 'Nike Link',
                    typeCode: 'CMSLinkComponent',
                    uid: 'NikeLink',
                    uuid: 'NikeLink',
                    visible: true,
                    slots: []
                },
                {
                    name: '69 Slam Link',
                    typeCode: 'CMSLinkComponent',
                    uid: '69SlamLink',
                    uuid: '69SlamLink',
                    visible: true,
                    slots: []
                },
                {
                    name: 'Dakine Link',
                    typeCode: 'CMSLinkComponent',
                    uid: 'DakineLink',
                    uuid: 'DakineLink',
                    slots: []
                },
                {
                    typeCode: 'SingleOnlineProductSelector',
                    uid: 'singleOnlineProductSelectorEditComponentId',
                    uuid: 'singleOnlineProductSelectorEditComponentId',
                    product: '300738116',
                    slots: []
                },
                {
                    type: 'contentPageData',
                    creationtime: '2016-06-28T15:23:37+0000',
                    defaultPage: false,
                    approvalStatus: 'APPROVED',
                    displayStatus: 'READY_TO_SYNC',
                    modifiedtime: '2016-06-28T15:25:51+0000',
                    name: 'Homepage',
                    masterTemplate: 'AccountPageTemplateUuid',
                    masterTemplateId: 'AccountPageTemplate',
                    title: {
                        de: 'Mes lovens pendas',
                        en: 'I love pandas'
                    },
                    typeCode: 'ContentPage',
                    itemtype: 'ContentPage',
                    uid: 'homepage',
                    uuid: 'homepage',
                    label: 'i-love-pandas',
                    restrictions: ['timeRestrictionIdA', 'timeRestrictionIdB'],
                    pageStatus: 'ACTIVE',
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE
                },
                {
                    type: 'contentPageData',
                    creationtime: '2016-06-28T15:23:37+0000',
                    defaultPage: true,
                    modifiedtime: '2016-06-28T15:25:51+0000',
                    name: 'Some Other Page',
                    masterTemplate: 'ProductPageTemplateUuid',
                    masterTemplateId: 'ProductPageTemplate',
                    title: {
                        de: 'Mes hatens pendas',
                        en: 'I hate pandas'
                    },
                    typeCode: 'ProductPage',
                    itemtype: 'ProductPage',
                    uid: 'secondpage',
                    uuid: 'secondpage',
                    approvalStatus: 'APPROVED',
                    displayStatus: 'READY_TO_SYNC',
                    label: LABEL_I_HATE_PANDAS,
                    pageStatus: 'ACTIVE',
                    restrictions: [],
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE
                },
                {
                    type: 'contentPageData',
                    creationtime: '2018-06-28T15:23:37+0000',
                    defaultPage: true,
                    modifiedtime: '2018-06-28T15:25:51+0000',
                    name: 'Third Page',
                    masterTemplate: 'ProductPageTemplateUuid',
                    masterTemplateId: 'ProductPageTemplate',
                    title: {
                        en: 'Third page'
                    },
                    typeCode: 'ProductPage',
                    itemtype: 'ProductPage',
                    uid: 'thirdpage',
                    uuid: 'thirdpage',
                    label: 'third-page',
                    approvalStatus: 'APPROVED',
                    displayStatus: 'READY_TO_SYNC',
                    pageStatus: 'ACTIVE',
                    restrictions: [],
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE
                },
                {
                    type: 'contentPageData',
                    creationtime: '2016-06-28T15:23:37+0000',
                    defaultPage: false,
                    approvalStatus: 'CHECK',
                    displayStatus: 'IN_PROGRESS',
                    modifiedtime: '2016-06-28T15:25:51+0000',
                    name: 'otherpage',
                    masterTemplate: 'AccountPageTemplateUuid',
                    masterTemplateId: 'AccountPageTemplate',
                    title: {
                        de: 'other page - de',
                        en: 'other page - en'
                    },
                    typeCode: 'ContentPage',
                    itemtype: 'ContentPage',
                    uid: 'otherpage',
                    uuid: 'otherpage',
                    label: '/otherpage',
                    restrictions: [],
                    pageStatus: 'ACTIVE',
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE
                },
                {
                    type: 'contentPageData',
                    creationtime: '2016-06-28T15:23:37+0000',
                    defaultPage: true,
                    modifiedtime: '2016-06-28T15:25:51+0000',
                    name: 'Synched Page',
                    masterTemplate: 'ProductPageTemplateUuid',
                    masterTemplateId: 'ProductPageTemplate',
                    title: {
                        en: 'synched page'
                    },
                    typeCode: 'ProductPage',
                    itemtype: 'ProductPage',
                    uid: 'synchedPage',
                    uuid: 'synchedPage',
                    label: 'synched page',
                    pageStatus: 'ACTIVE',
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE
                },
                {
                    type: 'contentPageData',
                    creationtime: '2016-04-08T21:16:41+0000',
                    modifiedtime: '2016-04-08T21:16:41+0000',
                    masterTemplate: 'PageTemplate',
                    masterTemplateId: 'PageTemplate',
                    name: 'productPage1',
                    label: 'productPage1',
                    typeCode: 'ProductPage',
                    title: {
                        en: 'productPage1'
                    },
                    uid: 'auid2',
                    uuid: 'auid2',
                    defaultPage: true,
                    pageStatus: 'ACTIVE',
                    itemtype: 'ProductPage',
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE
                },
                {
                    type: 'contentPageData',
                    creationtime: '2016-04-08T21:16:41+0000',
                    modifiedtime: '2016-04-08T21:16:41+0000',
                    masterTemplate: 'PageTemplate',
                    masterTemplateId: 'PageTemplate',
                    name: 'productPage1',
                    label: 'productPage1',
                    typeCode: 'ProductPage',
                    title: {
                        en: 'productPage1'
                    },
                    uid: 'auid2',
                    uuid: 'auid2',
                    defaultPage: true,
                    pageStatus: 'ACTIVE',
                    itemtype: 'ProductPage',
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE
                },
                {
                    uid: 'AccountPageTemplate',
                    uuid: 'AccountPageTemplateUuid'
                },
                {
                    uid: 'ProductPageTemplate',
                    uuid: 'ProductPageTemplateUuid'
                },
                {
                    // RESTRICTIONS
                    uid: 'timeRestrictionIdA',
                    uuid: 'timeRestrictionIdA',
                    name: 'Some Time restriction A',
                    typeCode: 'CMSTimeRestriction',
                    itemtype: 'CMSTimeRestriction',
                    description: SOME_DESCRIPTION
                },
                {
                    uid: 'timeRestrictionIdB',
                    uuid: 'timeRestrictionIdB',
                    name: 'another time B',
                    typeCode: 'CMSTimeRestriction',
                    itemtype: 'CMSTimeRestriction',
                    description: SOME_DESCRIPTION
                },
                {
                    uid: 'timeRestrictionIdC',
                    uuid: 'timeRestrictionIdC',
                    name: 'yet another',
                    typeCode: 'CMSTimeRestriction',
                    itemtype: 'CMSTimeRestriction',
                    description: SOME_DESCRIPTION
                },
                {
                    uid: 'catalogRestrictionIdD',
                    uuid: 'catalogRestrictionIdD',
                    name: 'some cat restriction',
                    typeCode: 'CMSCategoryRestriction',
                    itemtype: 'CMSCategoryRestriction',
                    description: SOME_DESCRIPTION,
                    categories: ['categoryA']
                },
                {
                    uid: 'catalogRestrictionIdE',
                    uuid: 'catalogRestrictionIdE',
                    name: "I'm a skatman",
                    typeCode: 'CMSCatalogRestriction',
                    itemtype: 'CMSCatalogRestriction',
                    description: SOME_DESCRIPTION
                },
                {
                    uid: 'catalogRestrictionIdF',
                    uuid: 'catalogRestrictionIdF',
                    name: 'Cat restriction E',
                    typeCode: 'CMSCatalogRestriction',
                    itemtype: 'CMSCatalogRestriction',
                    description: SOME_DESCRIPTION
                },
                {
                    uid: 'catalogRestrictionIdG',
                    uuid: 'catalogRestrictionIdG',
                    name: 'catalogRestrictionNameG',
                    typeCode: 'CMSCatalogRestriction',
                    itemtype: 'CMSCatalogRestriction',
                    description: SOME_DESCRIPTION
                },
                {
                    uid: 'catalogRestrictionIdH',
                    uuid: 'catalogRestrictionIdH',
                    name: 'Some User restriciton 1',
                    typeCode: 'CMSCatalogRestriction',
                    itemtype: 'CMSCatalogRestriction',
                    description: SOME_DESCRIPTION
                },
                {
                    uid: 'userRestrictionIdI',
                    uuid: 'userRestrictionIdI',
                    name: 'User restriction 2',
                    typeCode: 'CMSUserRestriction',
                    itemtype: 'CMSUserRestriction',
                    description: SOME_DESCRIPTION
                },
                {
                    uid: 'userGroupRestrictionId1',
                    uuid: 'userGroupRestrictionId1',
                    name: 'User Group Restriction 1',
                    typeCode: 'CMSUserGroupRestriction',
                    itemtype: 'CMSUserGroupRestriction',
                    description: SOME_DESCRIPTION
                },
                {
                    // page for restrictions
                    type: 'contentPageData',
                    uid: UUID_ADD_EDIT_ADDRESS,
                    uuid: UUID_ADD_EDIT_ADDRESS,
                    onlyOneRestrictionMustApply: false,
                    creationtime: '2016-07-15T23:35:21+0000',
                    defaultPage: true,
                    modifiedtime: '2016-07-15T23:38:01+0000',
                    name: 'Add Edit Address Page',
                    template: 'AccountPageTemplate',
                    title: {
                        de: 'Adresse hinzufügen/bearbeiten'
                    },
                    label: UUID_ADD_EDIT_ADDRESS,
                    restrictions: ['timeRestrictionIdA', 'catalogRestrictionIdD']
                },
                {
                    // PAGES
                    creationtime: '2016-04-08T21:16:41+0000',
                    modifiedtime: '2016-04-08T21:16:41+0000',
                    template: 'PageTemplate',
                    name: 'page1TitleSuffix',
                    label: 'page1TitleSuffix',
                    typeCode: 'ContentPage',
                    uid: 'auid1',
                    uuid: 'auid1',
                    defaultPage: true,
                    pageStatus: 'ACTIVE',
                    itemtype: 'ContentPage',
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE
                },
                {
                    creationtime: '2016-04-08T21:16:41+0000',
                    modifiedtime: '2016-04-08T21:16:41+0000',
                    template: 'ActionTemplate',
                    name: 'welcomePage',
                    typeCode: 'ActionPage',
                    uid: 'uid2',
                    uuid: 'uid2'
                },
                {
                    creationtime: '2016-04-08T21:16:41+0000',
                    modifiedtime: '2016-04-08T21:16:41+0000',
                    template: 'PageTemplate',
                    name: 'Advertise',
                    typeCode: 'MyCustomType',
                    uid: 'uid3',
                    uuid: 'uid3'
                },
                {
                    creationtime: '2016-04-08T21:16:41+0000',
                    modifiedtime: '2016-04-08T21:16:41+0000',
                    template: 'MyCustomPageTemplate',
                    name: 'page2TitleSuffix',
                    typeCode: 'HomePage',
                    uid: 'uid4',
                    uuid: 'uid4'
                },
                {
                    creationtime: '2016-04-08T21:16:41+0000',
                    modifiedtime: '2016-04-08T21:16:41+0000',
                    template: 'ZTemplate',
                    name: 'page3TitleSuffix',
                    typeCode: 'ProductPage',
                    uid: 'uid5',
                    uuid: 'uid5'
                },
                {
                    creationtime: '2016-07-07T14:33:37+0000',
                    defaultPage: true,
                    modifiedtime: '2016-07-12T01:23:41+0000',
                    name: 'My Little Primary Content Page',
                    onlyOneRestrictionMustApply: true,
                    masterTemplate: 'SomePageTemplate',
                    masterTemplateId: 'SomePageTemplate',
                    title: {
                        en: PRIMARY_TITLE_EN
                    },
                    typeCode: 'ContentPage',
                    itemtype: 'ContentPage',
                    uid: 'primaryContentPage',
                    uuid: 'primaryContentPage',
                    label: 'primary-content-page',
                    pageStatus: 'ACTIVE',
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE
                },
                {
                    creationtime: '2016-07-03T14:33:37+0000',
                    defaultPage: true,
                    modifiedtime: '2016-07-11T01:23:41+0000',
                    name: 'Some Other Primary Content Page',
                    onlyOneRestrictionMustApply: true,
                    masterTemplate: 'SomePageTemplate',
                    masterTemplateId: 'SomePageTemplate',
                    title: {
                        en: PRIMARY_TITLE_EN
                    },
                    typeCode: 'ContentPage',
                    itemtype: 'ContentPage',
                    uid: 'someOtherPrimaryPageContent',
                    uuid: 'someOtherPrimaryPageContent',
                    label: 'some-other-primary-page-content',
                    pageStatus: 'ACTIVE',
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE
                },
                {
                    creationtime: '2016-07-02T14:33:37+0000',
                    defaultPage: true,
                    modifiedtime: '2016-07-10T01:23:41+0000',
                    name: 'Special Primary Content Page',
                    onlyOneRestrictionMustApply: true,
                    masterTemplate: 'SomePageTemplate',
                    masterTemplateId: 'SomePageTemplate',
                    title: {
                        en: PRIMARY_TITLE_EN
                    },
                    typeCode: 'ContentPage',
                    itemtype: 'ContentPage',
                    uid: 'specialPrimaryPageContent',
                    uuid: 'specialPrimaryPageContent',
                    label: 'special-primary-page-content',
                    pageStatus: 'ACTIVE',
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE
                },
                {
                    creationtime: '2016-07-07T14:33:37+0000',
                    defaultPage: true,
                    modifiedtime: '2016-07-12T01:23:41+0000',
                    name: 'My Little Variation Content Page',
                    onlyOneRestrictionMustApply: true,
                    masterTemplate: 'SomePageTemplate',
                    masterTemplateId: 'SomePageTemplate',
                    title: {
                        en: VARIATION_TITLE_EN
                    },
                    typeCode: 'ContentPage',
                    itemtype: 'ContentPage',
                    uid: 'variationContentPage',
                    uuid: 'variationContentPage',
                    label: 'variation-content-page',
                    pageStatus: 'ACTIVE',
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE
                },
                {
                    creationtime: '2016-07-07T14:33:37+0000',
                    defaultPage: true,
                    modifiedtime: '2016-07-12T01:23:41+0000',
                    name: 'My Little Primary Category Page',
                    onlyOneRestrictionMustApply: true,
                    masterTemplate: 'SomePageTemplate',
                    masterTemplateId: 'SomePageTemplate',
                    title: {
                        en: 'Primary Category Page'
                    },
                    typeCode: 'CategoryPage',
                    itemtype: 'CategoryPage',
                    uid: 'primaryCategoryPage',
                    uuid: 'primaryCategoryPage',
                    label: 'primary-category-page',
                    pageStatus: 'ACTIVE',
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE
                },
                {
                    creationtime: '2016-07-07T14:33:37+0000',
                    defaultPage: true,
                    modifiedtime: '2016-07-12T01:23:41+0000',
                    name: 'My Little Variation Category Page',
                    onlyOneRestrictionMustApply: true,
                    masterTemplate: 'SomePageTemplate',
                    masterTemplateId: 'SomePageTemplate',
                    title: {
                        en: 'Variation Category Page'
                    },
                    typeCode: 'CategoryPage',
                    itemtype: 'CategoryPage',
                    uid: 'variationCategoryPage',
                    uuid: 'variationCategoryPage',
                    label: 'variation-category-page',
                    pageStatus: 'ACTIVE',
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE
                },
                {
                    creationtime: '2016-07-07T14:33:37+0000',
                    defaultPage: true,
                    modifiedtime: '2016-07-12T01:23:41+0000',
                    name: 'My Little Primary Product Page',
                    onlyOneRestrictionMustApply: true,
                    masterTemplate: 'SomePageTemplate',
                    masterTemplateId: 'SomePageTemplate',
                    title: {
                        en: 'Primary Product Page'
                    },
                    typeCode: 'ProductPage',
                    itemtype: 'ProductPage',
                    uid: 'primaryProductPage',
                    uuid: 'primaryProductPage',
                    label: 'primary-product-page',
                    pageStatus: 'ACTIVE',
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE
                },
                {
                    creationtime: '2016-07-07T14:33:37+0000',
                    defaultPage: true,
                    modifiedtime: '2016-07-12T01:23:41+0000',
                    name: 'My Little Variation Product Page',
                    onlyOneRestrictionMustApply: true,
                    masterTemplate: 'SomePageTemplate',
                    masterTemplateId: 'SomePageTemplate',
                    title: {
                        en: 'Variation Product Page'
                    },
                    typeCode: 'ProductPage',
                    itemtype: 'ProductPage',
                    uid: 'variationProductPage',
                    uuid: 'variationProductPage',
                    label: 'variation-product-page',
                    pageStatus: 'ACTIVE',
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE
                },
                {
                    type: 'contentPageData',
                    defaultPage: true,
                    name: 'Homepage_uk_online',
                    typeCode: 'ContentPage',
                    itemtype: 'ContentPage',
                    uid: 'homepage_uk_online',
                    uuid: 'homepage_uk_online',
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE,
                    label: LABEL_I_HATE_PANDAS,
                    restrictions: [],
                    pageStatus: 'ACTIVE'
                },
                {
                    type: 'contentPageData',
                    defaultPage: true,
                    name: 'Homepage_global_online',
                    typeCode: 'ContentPage',
                    itemtype: 'ContentPage',
                    uid: 'homepage_global_online',
                    uuid: 'homepage_global_online',
                    catalogVersion: CATALOG_VERSION_APPAREL_ONLINE,
                    label: LABEL_I_HATE_PANDAS,
                    restrictions: [],
                    pageStatus: 'ACTIVE'
                },
                {
                    type: 'contentPageData',
                    defaultPage: true,
                    name: 'Homepage_global_online',
                    typeCode: 'ContentPage',
                    itemtype: 'ContentPage',
                    uid: 'homepage_global_online',
                    uuid: 'homepage_global_online',
                    catalogVersion: 'apparel-deContentCatalog/Online',
                    label: LABEL_I_HATE_PANDAS,
                    restrictions: [],
                    pageStatus: 'ACTIVE'
                },
                {
                    type: 'contentPageData',
                    defaultPage: true,
                    name: 'Homepage_global_staged',
                    typeCode: 'ContentPage',
                    itemtype: 'ContentPage',
                    uid: 'homepage_global_staged',
                    uuid: 'homepage_global_staged',
                    catalogVersion: 'apparelContentCatalog/Staged',
                    restrictions: [],
                    pageStatus: 'ACTIVE'
                },
                {
                    type: 'contentPageData',
                    defaultPage: false,
                    name: 'Homepage_gloabl_online_variation',
                    typeCode: 'ContentPage',
                    itemtype: 'ContentPage',
                    uid: 'homepage_gloabl_online_variation',
                    uuid: 'homepage_gloabl_online_variation',
                    catalogVersion: CATALOG_VERSION_APPAREL_ONLINE,
                    restrictions: [],
                    pageStatus: 'ACTIVE'
                },
                {
                    type: 'contentPageData',
                    defaultPage: true,
                    name: 'Homepage_gloabl_online_copy_disabled',
                    copyToCatalogsDisabled: true,
                    typeCode: 'ContentPage',
                    itemtype: 'ContentPage',
                    uid: 'homepage_gloabl_online_copy_disabled',
                    uuid: 'homepage_gloabl_online_copy_disabled',
                    catalogVersion: CATALOG_VERSION_APPAREL_ONLINE,
                    restrictions: [],
                    pageStatus: 'ACTIVE'
                },
                {
                    id: 'MyParagraph',
                    uid: 'staticDummyComponent',
                    uuid: 'staticDummyComponent',
                    name: 'Static Dummy Component',
                    headline: HEADLINE,
                    active: true,
                    content: CONTENT_EN,
                    creationtime: new Date().getTime(),
                    modifiedtime: new Date().getTime(),
                    type: 'componentType1',
                    media: '4',
                    external: false,
                    visible: true,
                    cloneable: true,
                    restrictions: [],
                    onlyOneRestrictionMustApply: false,
                    slots: ['mocked_slot_id']
                },
                {
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE,
                    creationtime: '2016-07-07T14:33:37+0000',
                    modifiedtime: '2016-07-12T01:23:41+0000',
                    name: 'Trashed Content Page',
                    masterTemplate: 'SomePageTemplate',
                    masterTemplateId: 'SomePageTemplate',
                    title: {
                        en: VARIATION_TITLE_EN
                    },
                    typeCode: 'ContentPage',
                    itemtype: 'ContentPage',
                    uid: 'trashedContentPage',
                    uuid: 'trashedContentPage',
                    label: 'trashedContentPage',
                    pageStatus: 'DELETED',
                    restrictions: []
                },
                {
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE,
                    creationtime: '2016-07-07T14:33:37+0000',
                    modifiedtime: '2016-06-28T15:25:51+0000',
                    name: 'Trashed Category Page',
                    masterTemplate: 'SomePageTemplate',
                    masterTemplateId: 'SomePageTemplate',
                    approvalStatus: 'APPROVED',
                    title: {
                        en: VARIATION_TITLE_EN
                    },
                    typeCode: 'CategoryPage',
                    itemtype: 'CategoryPage',
                    uid: 'trashedCategoryPage',
                    uuid: 'trashedCategoryPage',
                    label: 'trashedCategoryPage',
                    pageStatus: 'DELETED',
                    restrictions: []
                },
                {
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_ONLINE,
                    creationtime: '2016-07-07T14:33:37+0000',
                    modifiedtime: '2016-06-28T15:25:51+0000',
                    name: 'Trashed Category Page',
                    template: 'SomePageTemplate',
                    approvalStatus: 'APPROVED',
                    title: {
                        en: VARIATION_TITLE_EN
                    },
                    typeCode: 'CategoryPage',
                    itemtype: 'CategoryPage',
                    uid: 'trashedCategoryPage',
                    uuid: 'trashedCategoryPage',
                    label: 'trashedCategoryPage',
                    pageStatus: 'ACTIVE',
                    restrictions: []
                },
                {
                    creationtime: '2016-07-07T14:33:37+0000',
                    modifiedtime: '2017-09-26T15:22:37+0000',
                    name: 'Trashed Product Page',
                    masterTemplate: 'SomePageTemplate',
                    masterTemplateId: 'SomePageTemplate',
                    title: {
                        en: VARIATION_TITLE_EN
                    },
                    typeCode: 'ProductPage',
                    itemtype: 'ProductPage',
                    uid: 'trashedProductPage',
                    uuid: 'trashedProductPage',
                    label: 'trashedProductPage',
                    pageStatus: 'DELETED',
                    restrictions: [],
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE
                },
                {
                    uid: 'hiddenComponent1',
                    uuid: 'hiddenComponent1',
                    name: 'Hidden Component 1',
                    visible: false,
                    cloneable: true,
                    typeCode: 'AbstractCMSComponent',
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE,
                    restrictions: [],
                    slots: []
                },
                {
                    uid: 'hiddenComponent2',
                    uuid: 'hiddenComponent2',
                    name: 'Hidden Component 2',
                    visible: false,
                    cloneable: true,
                    typeCode: 'AbstractCMSComponent',
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE,
                    slots: ['bottomHeaderSlot', 'footerSlot']
                },
                {
                    uid: 'hiddenComponent3',
                    uuid: 'hiddenComponent3',
                    name: 'Hidden Component 3',
                    visible: false,
                    cloneable: false,
                    typeCode: 'AbstractCMSComponent',
                    catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE,
                    slots: []
                }
            ])
        };

        var commonSlots = [
            {
                uid: 'component1',
                uuid: 'component1',
                name: 'Component 1',
                visible: true,
                typeCode: 'SimpleResponsiveBannerComponent',
                catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE,
                slots: []
            },
            {
                uid: 'component2',
                uuid: 'component2',
                name: 'Component 2',
                visible: true,
                typeCode: 'componentType2',
                catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE,
                slots: []
            },
            {
                uid: 'component3',
                uuid: 'component3',
                name: 'Component 3',
                visible: true,
                typeCode: 'componentType3',
                catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE,
                slots: []
            },
            {
                uid: 'component4',
                uuid: 'component4',
                name: 'Component 4',
                visible: true,
                typeCode: 'componentType4',
                catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE,
                slots: []
            },
            {
                uid: 'component5',
                uuid: 'component5',
                name: 'Component 5',
                visible: true,
                typeCode: 'componentType5',
                catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE,
                slots: []
            },
            {
                uid: 'hiddenComponent1',
                uuid: 'hiddenComponent1',
                name: 'Hidden Component 1',
                visible: false,
                typeCode: 'AbstractCMSComponent',
                catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE,
                slots: []
            },
            {
                uid: 'hiddenComponent2',
                uuid: 'hiddenComponent2',
                name: 'Hidden Component 2',
                visible: false,
                typeCode: 'AbstractCMSComponent',
                catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE,
                slots: ['bottomHeaderSlot', 'footerSlot']
            },
            {
                uid: 'hiddenComponent3',
                uuid: 'hiddenComponent3',
                name: 'Hidden Component 3',
                visible: false,
                typeCode: 'AbstractCMSComponent',
                catalogVersion: CATALOG_VERSION_APPAREL_UK_STAGE,
                slots: []
            }
        ];

        sessionStorage.setItem('componentMocks', JSON.stringify(items));

        // FIXME: ids are the components in pagesContentSlotsComponentsMocks
        httpBackendService
            .whenGET(
                /cmswebservices\/v1\/sites\/apparel-uk\/cmsitems\?catalogId=apparel-ukContentCatalog&catalogVersion=Staged&uuids=component1,component2,component3,hiddenComponent1,hiddenComponent2,component4,component5,hiddenComponent3/
            )
            .respond({
                response: commonSlots
            });

        var componentGETMock = httpBackendService.whenGET(
            /\/cmswebservices\/v1\/sites\/.*\/cmsitems\/((?!\/).)*$/
        );
        componentGETMock.respond(function (method, url, data, headers) {
            var uuid = /cmsitems\/(.*)/.exec(url)[1];
            return [
                200,
                JSON.parse(sessionStorage.getItem('componentMocks')).componentItems.find(function (
                    item
                ) {
                    return item.uuid === uuid;
                })
            ];
        });
        backendMocksUtils.storeBackendMock('componentGETMock', componentGETMock);

        // old mock to be removed with navigation refactoring
        httpBackendService
            .whenGET(/\/cmswebservices\/v1\/sites\/.*\/catalogs\/.*\/versions\/.*\/items\/.*/)
            .respond(function (method, url, data, headers) {
                var uid = /items\/(.*)/.exec(url)[1];
                return [
                    200,
                    JSON.parse(sessionStorage.getItem('componentMocks')).componentItems.find(
                        function (item) {
                            return item.uid === uid;
                        }
                    )
                ];
            });

        var validationErrorsNoMedia = {
            errors: [
                {
                    message: 'A Media must be selected. Language: [en]',
                    reason: 'missing',
                    subject: 'media',
                    subjectType: 'parameter',
                    type: 'ValidationError'
                }
            ]
        };

        var validationErrorsCannotDeletePage = {
            errors: [
                {
                    message: 'This field is required.',
                    reason: 'missing',
                    subject: 'title',
                    subjectType: 'parameter',
                    type: 'ValidationError'
                }
            ]
        };

        // pushed to global namespace for easy override by specific mocks
        var componentPUTMock = httpBackendService.whenPUT(
            /\/cmswebservices\/v1\/sites\/.*\/cmsitems\/((?!\/).)*$/
        );
        window.itemPUTDefaultResponse = function (_method, url, data, headers) {
            var uuid = /cmsitems\/(.*)/.exec(url)[1];

            var payload = JSON.parse(data);

            var key = Object.keys(payload).find(function (objKey) {
                return JSON.stringify(payload[objKey]).indexOf('trump') > -1;
            });

            if (key) {
                return [
                    400,
                    {
                        errors: [
                            {
                                language: 'en',
                                message: 'No Trump jokes plz.',
                                reason: 'invalid',
                                subject: 'media',
                                subjectType: 'parameter',
                                type: 'ValidationError'
                            }
                        ]
                    }
                ];
            }

            items.componentItems = items.componentItems.map(function (item) {
                if (item.uuid === payload.uuid) {
                    return payload;
                } else {
                    return item;
                }
            });

            sessionStorage.setItem('componentMocks', JSON.stringify(items));

            if (uuid === 'componentToValidateId' && !payload.media.en) {
                return [400, validationErrorsNoMedia];
            } else if (uuid === 'primaryCategoryPage') {
                return [400, validationErrorsCannotDeletePage];
            } else {
                return [204];
            }
        };

        window.itemPUT = componentPUTMock;
        componentPUTMock.respond(window.itemPUTDefaultResponse);
        backendMocksUtils.storeBackendMock('componentPUTMock', componentPUTMock);

        // DELETE Mocks
        var componentDELETEMock = httpBackendService.whenDELETE(
            /\/cmswebservices\/v1\/sites\/.*\/cmsitems\/((?!\/).)*$/
        );
        componentDELETEMock.respond(function (_method, url, data, headers) {
            var uuid = /cmsitems\/(.*)/.exec(url)[1];

            var item = JSON.parse(sessionStorage.getItem('componentMocks')).componentItems.find(
                function (cmpItem) {
                    return cmpItem.uuid === uuid;
                }
            );

            if (item) {
                items.componentItems = items.componentItems.filter(function (cmpItem) {
                    return cmpItem.uuid !== uuid;
                });
                sessionStorage.setItem('componentMocks', JSON.stringify(items));
                return [200];
            } else {
                return [400];
            }
        });
        backendMocksUtils.storeBackendMock('componentDELETEMock', componentDELETEMock);

        // "/cmswebservices/v1/sites/CURRENT_CONTEXT_SITE_ID/cmsitems"
        // cmsitems/?dryRun=true
        var componentPOSTMock = httpBackendService.whenPOST(
            /\/cmswebservices\/v1\/sites\/.*\/cmsitems\/?(?!uuids)((?!\/).)*$/
        );
        componentPOSTMock.respond(function (method, url, data, headers) {
            var dataObject = angular.fromJson(data);
            if (dataObject.uid === 'trump') {
                return [
                    400,
                    {
                        errors: [
                            {
                                message: 'No Trump jokes plz.',
                                reason: 'invalid',
                                subject: 'uid',
                                subjectType: 'parameter',
                                type: 'ValidationError'
                            }
                        ]
                    }
                ];
            } else if (dataObject.itemtype === 'CMSNavigationNode') {
                return navigationNodePOST(data);
            } else {
                return [
                    200,
                    {
                        uid: 'valid'
                    }
                ];
            }
        });
        backendMocksUtils.storeBackendMock('componentPOSTMock', componentPOSTMock);

        var getComponentsByUuidsPOSTMock = httpBackendService.whenPOST(
            /\/cmswebservices\/v1\/sites\/.*\/cmsitems\/uuids/
        );
        getComponentsByUuidsPOSTMock.respond(function (method, url, data, headers) {
            var dataObject = angular.fromJson(data);
            var cmpItems = JSON.parse(sessionStorage.getItem('componentMocks'));
            cmpItems = cmpItems && cmpItems.componentItems ? cmpItems.componentItems : [];
            var response = cmpItems.concat(commonSlots).filter(function (item) {
                return dataObject.uuids.indexOf(item.uuid) > -1;
            });
            return [
                200,
                {
                    response: response
                }
            ];
        });
        backendMocksUtils.storeBackendMock(
            'getComponentsByUuidsPOSTMock',
            getComponentsByUuidsPOSTMock
        );

        var componentsListGETMock = httpBackendService
            .whenGET(/\/cmswebservices\/v1\/sites\/.*\/cmsitems((?!\/).)*$/)
            .respond(function (method, url, data, headers) {
                var params = parseQuery(data);
                var currentPage = params.currentPage;
                var mask = params.mask;
                var typeCode = params.typeCode;
                var catalogId = params.catalogId;
                var catalogVersion = params.catalogVersion;
                var uuids = params.uuids && params.uuids.split(',');
                var itemSearchParams =
                    params.itemSearchParams && params.itemSearchParams.split(',');
                var sort = params.sort;
                var catalogVersionUUID;

                if (catalogId && catalogVersion) {
                    catalogVersionUUID = catalogId + '/' + catalogVersion;
                }

                var filteredItems = JSON.parse(sessionStorage.getItem('componentMocks'))
                    .componentItems;

                if (uuids) {
                    filteredItems = items.componentItems.filter(function (item) {
                        return uuids.indexOf(item.uuid) > -1;
                    });

                    return [
                        200,
                        {
                            response: filteredItems
                        }
                    ];
                }

                filteredItems = filterItemsByTypeCode(filteredItems, typeCode, items);
                filteredItems = filterItemsByItemSearchParams(
                    filteredItems,
                    itemSearchParams,
                    catalogVersionUUID
                );
                filteredItems = filterItemsBySort(filteredItems, sort);
                filteredItems = filteredItems.filter(function (item) {
                    isItemContainsMask(item, mask);
                });
                var results = filteredItems.slice(currentPage * 10, currentPage * 10 + 10);

                var pagedResults = {
                    pagination: {
                        count: 10,
                        page: currentPage,
                        totalCount: filteredItems.length,
                        totalPages: 3
                    },
                    response: results
                };

                return [200, pagedResults];
            });
        backendMocksUtils.storeBackendMock('componentsListGETMock', componentsListGETMock);

        // old mock to be removed with navigation refactoring
        httpBackendService
            .whenGET(/\/cmswebservices\/v1\/sites\/.*\/catalogs\/.*\/versions\/.*\/items/)
            .respond(function (method, url, data, headers) {
                var params = parseQuery(data);
                var currentPage = params.currentPage;
                var mask = params.mask;
                var pageSize = params.pageSize;

                var filtered = items.componentItems.filter(function (item) {
                    return mask
                        ? (item.name &&
                              typeof item.name === 'string' &&
                              item.name.toUpperCase().indexOf(mask.toUpperCase()) > -1) ||
                              item.uid.toUpperCase().indexOf(mask.toUpperCase()) > -1
                        : true;
                });

                var results = filtered.slice(currentPage * 10, currentPage * 10 + 10);

                var pagedResults = {
                    pagination: {
                        count: 10,
                        page: currentPage,
                        totalCount: filtered.length,
                        totalPages: 3
                    },
                    componentItems: results
                };

                return [200, pagedResults];
            });

        httpBackendService.whenGET(/cmssmartedit\/images\/component_default.png/).respond({});
    });
try {
    angular.module('smarteditloader').requires.push('componentMocks');
} catch (e) {}
try {
    angular.module('smarteditcontainer').requires.push('componentMocks');
} catch (e) {}

function filterItemsByTypeCode(filteredItems, typeCode, items) {
    if (typeCode) {
        return typeCode === 'AbstractPage'
            ? items.componentItems.filter(function (item) {
                  return (
                      item.typeCode === 'ContentPage' ||
                      item.typeCode === 'ProductPage' ||
                      item.typeCode === 'CategoryPage'
                  );
              })
            : items.componentItems.filter(function (item) {
                  return item.typeCode === typeCode || item.itemtype === typeCode;
              });
    }
    return filteredItems;
}

function filterItemsByItemSearchParams(filteredItems, itemSearchParams, catalogVersionUUID) {
    if (itemSearchParams) {
        filteredItems = filteredItems.filter(function (item) {
            var filtered = false;
            itemSearchParams.forEach(function (param) {
                var paramParsed = param.split(':');
                if (
                    paramParsed.length === 2 &&
                    item[paramParsed[0]] &&
                    item[paramParsed[0]].toString().toUpperCase() === paramParsed[1].toUpperCase()
                ) {
                    filtered = true;
                }
            });

            return filtered;
        });

        if (catalogVersionUUID) {
            filteredItems = filteredItems.filter(function (item) {
                return item.catalogVersion === catalogVersionUUID;
            });
        }
    }
    return filteredItems;
}

function filterItemsBySort(filteredItems, sort) {
    if (sort) {
        var sortColumn = sort.split(':')[0];
        var sortdirection = sort.split(':')[1];

        filteredItems = filteredItems.sort(function (a, b) {
            var nameA = a[sortColumn].toUpperCase(); // ignore upper and lowercase
            var nameB = b[sortColumn].toUpperCase(); // ignore upper and lowercase
            if (nameA < nameB) {
                return sortdirection === 'asc' ? -1 : 1;
            }
            if (nameA > nameB) {
                return sortdirection === 'asc' ? 1 : -1;
            }
            return 0;
        });
    }
    return filteredItems;
}

function isItemContainsMask(item, mask) {
    let flag;
    if (typeof item.name === 'string') {
        flag = item.name.toUpperCase().indexOf(mask.toUpperCase()) > -1;
    }

    if (typeof item.uid === 'string') {
        flag = flag || item.uid.toUpperCase().indexOf(mask.toUpperCase()) > -1;
    }

    return flag;
}
