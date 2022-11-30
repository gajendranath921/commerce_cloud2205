/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
angular
    .module('customMediaMocksModule', ['backendMocksUtilsModule'])
    .run(function (httpBackendService) {
        httpBackendService.whenGET(/smartedit\/settings/).respond({
            'smartedit.validFileMimeTypeCodes': [
                'FFD8FFDB',
                'FFD8FFE0',
                'FFD8FFE1',
                '474946383761',
                '474946383961',
                '424D',
                '49492A00',
                '4D4D002A',
                '89504E470D0A1A0A'
            ]
        });
        httpBackendService
            .whenPOST(
                /permissionswebservices\/v1\/permissions\/types\/search\?permissionNames=create,change,read,remove&types=(.*)/
            )
            .respond({
                permissionsList: [
                    {
                        id: 'MediaContainer',
                        permissions: [
                            {
                                key: 'read',
                                value: 'true'
                            },
                            {
                                key: 'change',
                                value: 'true'
                            },
                            {
                                key: 'create',
                                value: 'true'
                            },
                            {
                                key: 'remove',
                                value: 'true'
                            }
                        ]
                    },
                    {
                        id: 'MediaFormat',
                        permissions: [
                            {
                                key: 'read',
                                value: 'true'
                            },
                            {
                                key: 'change',
                                value: 'true'
                            },
                            {
                                key: 'create',
                                value: 'true'
                            },
                            {
                                key: 'remove',
                                value: 'true'
                            }
                        ]
                    }
                ]
            });

        const medias = [
            {
                id: '1',
                code: 'contextualmenu_delete_off',
                description: 'contextualmenu_delete_off',
                altText: 'contextualmenu_delete_off alttext',
                realFileName: 'contextualmenu_delete_off.png',
                mime: 'image/png',
                url: '/test/e2e/genericEditor/images/contextualmenu_delete_off.png'
            },
            {
                id: '2',
                code: 'contextualmenu_delete_on',
                description: 'contextualmenu_delete_on',
                altText: 'contextualmenu_delete_on alttext',
                realFileName: 'contextualmenu_delete_on.png',
                mime: 'image/png',
                url: '/test/e2e/genericEditor/images/contextualmenu_delete_on.png'
            },
            {
                id: '3',
                code: 'contextualmenu_edit_off',
                description: 'contextualmenu_edit_off',
                altText: 'contextualmenu_edit_off alttext',
                realFileName: 'contextualmenu_edit_off.png',
                mime: 'image/png',
                url: '/test/e2e/genericEditor/images/contextualmenu_edit_off.png'
            },
            {
                id: '3',
                code: 'contextualmenu_edit_on',
                description: 'contextualmenu_edit_on',
                altText: 'contextualmenu_edit_on alttext',
                realFileName: 'contextualmenu_edit_on.png',
                mime: 'image/png',
                url: '/test/e2e/genericEditor/images/contextualmenu_edit_on.png'
            }
        ];

        httpBackendService
            .whenGET(/cmswebservices\/v1\/catalogs\/apparel-ukContentCatalog\/versions\/staged\/medias/)
            .respond({
                media: medias,
                pagination: {
                    count: 4,
                    page: 0,
                    totalCount: 4,
                    totalPages: 1
                }
            });
    });
try {
    angular.module('smarteditloader').requires.push('customMediaMocksModule');
} catch (e) {}
try {
    angular.module('smarteditcontainer').requires.push('customMediaMocksModule');
} catch (e) {}
