/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { NgModule } from '@angular/core';

import { moduleUtils, urlUtils, HttpBackendService, SeEntryModule } from 'smarteditcommons';
import { OuterAuthorizationMocks } from '../../utils/commonMockedModules/outerAuthorizationMock';
import { OuterConfigurationMocks } from '../../utils/commonMockedModules/outerConfigurationMock';
import { i18nMocks } from '../../utils/commonMockedModules/outerI18nMock';
import { OuterLanguagesMocks } from '../../utils/commonMockedModules/outerLanguagesMock';
import { OuterOtherMocks } from '../../utils/commonMockedModules/outerOtherMock';
import { OuterPermissionMocks } from '../../utils/commonMockedModules/outerPermissionMocks';
import { OuterPreviewMocks } from '../../utils/commonMockedModules/outerPreviewMock';
import { OuterSitesMocks } from '../../utils/commonMockedModules/outerSitesMock';
import { OuterWhoAmIMocks } from '../../utils/commonMockedModules/outerWhoAmIMocks';
import '../../utils/commonMockedModules/outerGlobalBasePathFetchMock';

@SeEntryModule('OuterMocksModule')
@NgModule({
    imports: [
        OuterAuthorizationMocks,
        OuterWhoAmIMocks,
        OuterConfigurationMocks,
        i18nMocks,
        OuterLanguagesMocks,
        OuterOtherMocks,
        OuterPreviewMocks,
        OuterSitesMocks,
        OuterPermissionMocks
    ],

    providers: [
        moduleUtils.provideValues({
            SMARTEDIT_ROOT: 'web/webroot',
            SMARTEDIT_RESOURCE_URI_REGEXP: /^(.*)\/apps\/smartedit-e2e\/generated\/e2e/,
            SMARTEDIT_INNER_FILES: [
                '/apps/smartedit-e2e/node_modules/ckeditor4/ckeditor.js',
                '/apps/smartedit-e2e/generated/e2e/base/smartedit/vendor.js',
                '/apps/smartedit-e2e/generated/e2e/base/smartedit/base-inner-app.js',
                '/apps/smartedit-e2e/generated/e2e/base/smartedit/inner-app.js'
            ]
        }),
        moduleUtils.bootstrap(
            (httpBackendService: HttpBackendService) => {
                httpBackendService.matchLatestDefinitionEnabled(true);
                const map = [
                    {
                        value: '"thepreviewTicketURI"',
                        key: 'previewTicketURI'
                    },
                    {
                        value:
                            '{"smartEditContainerLocation":"/apps/smartedit-e2e/generated/e2e/treeModule/outerapp.js"}',
                        key: 'applications.treeModuleApp'
                    },
                    {
                        value: '"/cmswebservices/v1/i18n/languages"',
                        key: 'i18nAPIRoot'
                    }
                ];

                httpBackendService.whenGET(/configuration$/).respond(function () {
                    return [200, map];
                });

                httpBackendService.whenGET(/cmswebservices\/v1\/sites\/.*\/languages/).respond({
                    languages: [
                        {
                            nativeName: 'English',
                            isocode: 'en',
                            name: 'English',
                            required: true
                        }
                    ]
                });

                let nodes = [
                    {
                        uid: '1',
                        name: 'node1',
                        title: {
                            en: 'node1_en',
                            fr: 'node1_fr'
                        },
                        parentUid: 'root',
                        hasChildren: true
                    },
                    {
                        uid: '2',
                        name: 'node2',
                        title: {
                            en: 'node2_en',
                            fr: 'node2_fr'
                        },
                        parentUid: 'root',
                        hasChildren: true
                    },
                    {
                        uid: '4',
                        name: 'node4',
                        title: {
                            en: 'nodeA',
                            fr: 'nodeA'
                        },
                        parentUid: '1',
                        hasChildren: false
                    },
                    {
                        uid: '5',
                        name: 'node5',
                        title: {
                            en: 'nodeB',
                            fr: 'nodeB'
                        },
                        parentUid: '1',
                        hasChildren: false
                    },
                    {
                        uid: '3',
                        name: 'node3',
                        title: {
                            en: 'nodeF',
                            fr: 'nodeF'
                        },
                        parentUid: '1',
                        hasChildren: false
                    },
                    {
                        uid: '6',
                        name: 'node6',
                        title: {
                            en: 'nodeC',
                            fr: 'nodeC'
                        },
                        parentUid: '2',
                        hasChildren: false
                    }
                ];

                httpBackendService.whenGET(/someNodeURI/).respond(function (method, url, data) {
                    const query = urlUtils.parseQuery(data) as any;
                    const parentUID = query.parentUid;

                    return [
                        200,
                        {
                            navigationNodes: nodes.filter(function (node) {
                                return node.parentUid === parentUID;
                            })
                        }
                    ];
                });

                httpBackendService.whenPOST(/someNodeURI/).respond(function (method, url, data) {
                    const payload = JSON.parse(data);
                    const uid = new Date().getTime().toString();
                    const node = {
                        uid,
                        title: { en: '', fr: '' },
                        name: payload.name,
                        parentUid: payload.parentUid,
                        hasChildren: false
                    };
                    nodes.push(node);
                    return [200, node];
                });

                httpBackendService.whenDELETE(/someNodeURI/).respond(function (method, url) {
                    const uid = /someNodeURI\/(.*)/.exec(url)[1];
                    nodes = nodes.filter(function (node) {
                        return node.uid !== uid;
                    });
                    return [204, {}];
                });

                httpBackendService.whenGET('/smarteditwebservices/v1/i18n/languages').respond({});

                httpBackendService.whenGET(/tree/).passThrough();
            },
            [HttpBackendService]
        )
    ]
})
export class OuterMocksModule {}

window.pushModules(OuterMocksModule);
