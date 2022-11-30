/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* eslint-disable @typescript-eslint/no-unsafe-return */
/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* tslint:disable:max-classes-per-file */

import { NgModule } from '@angular/core';

import { moduleUtils, HttpBackendService, Payload, SeEntryModule } from 'smarteditcommons';
import { STOREFRONT_URI } from '../../utils/outerConstants';
const APPAREL_UK_CATALOG = 'apparel-ukContentCatalog';
class PreviewTicketDataService {
    private currentPreviewTicket = 'defaultTicket';

    setCurrentPreviewTicket(previewTicket: string): void {
        this.currentPreviewTicket = previewTicket;
    }
    getCurrentPreviewTicket(): string {
        return this.currentPreviewTicket;
    }
}

@SeEntryModule('OuterBackendMocks')
@NgModule({
    providers: [
        PreviewTicketDataService,

        moduleUtils.bootstrap(
            (
                httpBackendService: HttpBackendService,
                previewTicketDataService: PreviewTicketDataService
            ) => {
                httpBackendService.matchLatestDefinitionEnabled(true);
                httpBackendService.whenGET(/fragments/).passThrough();

                httpBackendService.whenPUT(/smartedit\/configuration/).respond(() => [404, null]);

                mockLanguage(httpBackendService);
                mockPreview(httpBackendService, previewTicketDataService);

                httpBackendService
                    .whenGET(/storefront\.html/)
                    .respond(() => [200, ('<somehtml/>' as any) as Payload]);

                httpBackendService.whenGET(/\/dummystorefrontOtherPage.html/).respond(() => {
                    // Test if we already loaded the homepage of the initial experience with a valid ticket
                    if (previewTicketDataService.getCurrentPreviewTicket() === 'validTicketId') {
                        previewTicketDataService.setCurrentPreviewTicket('');
                        return [404, null];
                    } else {
                        return [200, {}];
                    }
                });
            },

            [HttpBackendService, PreviewTicketDataService]
        )
    ]
})
export class OuterBackendMocks {}
function mockLanguage(httpBackendService: HttpBackendService) {
    httpBackendService.whenGET(/cmswebservices\/v1\/sites\/electronics\/languages/).respond({
        languages: [
            {
                nativeName: 'English',
                isocode: 'en',
                required: true
            },
            {
                nativeName: 'Polish',
                isocode: 'pl',
                required: true
            },
            {
                nativeName: 'Italian',
                isocode: 'it'
            }
        ]
    });
}

function mockPreview(
    httpBackendService: HttpBackendService,
    previewTicketDataService: PreviewTicketDataService
) {
    httpBackendService
        .whenPOST(/previewwebservices\/v1\/preview/)
        .respond((_method, _url, data) => {
            const postedData = JSON.parse(data);

            const contentCatalogObject = postedData.catalogVersions.find((catalogVersion: any) => {
                return catalogVersion.catalog.indexOf('ContentCatalog') > -1;
            });
            if (
                contentCatalogObject.catalog === 'electronicsContentCatalog' &&
                contentCatalogObject.catalogVersion === 'Online'
            ) {
                return electronicsContentCatalogOnline(postedData);
            }

            if (
                contentCatalogObject.catalog === 'electronicsContentCatalog' &&
                contentCatalogObject.catalogVersion === 'Staged'
            ) {
                return electronicsContentCatalogStageg(postedData);
            }

            return getNoElectronicsContentCatalogData(
                contentCatalogObject,
                postedData,
                previewTicketDataService
            );
        });
}

function getNoElectronicsContentCatalogData(
    contentCatalogObject: any,
    postedData: any,
    previewTicketDataService: PreviewTicketDataService
): [number, Payload | Payload[]] {
    if (
        contentCatalogObject.catalog === APPAREL_UK_CATALOG &&
        contentCatalogObject.catalogVersion === 'Staged' &&
        // postedData.resourcePath === STOREFRONT_URI &&
        postedData.language === 'en'
    ) {
        return [
            200,
            {
                catalog: APPAREL_UK_CATALOG,
                catalogVersion: 'Staged',
                resourcePath: STOREFRONT_URI,
                language: 'en',
                ticketId: 'apparel-ukContentCatalogStagedValidTicket'
            }
        ];
    }

    // We can not check hours and minutes  here because of the difference between developer's time zone
    // and the timezone of the pipeline.
    if (
        contentCatalogObject.catalog === APPAREL_UK_CATALOG &&
        contentCatalogObject.catalogVersion === 'Online'
    ) {
        return apparelUKOnline(postedData);
    }

    if (previewTicketDataService.getCurrentPreviewTicket() !== '') {
        previewTicketDataService.setCurrentPreviewTicket('validTicketId');
    }

    return retrurnDefaultData(postedData);
}

function retrurnDefaultData(postedData: any): [number, Payload | Payload[]] {
    return [
        200,
        {
            ...postedData,
            resourcePath: STOREFRONT_URI,
            ticketId: 'validTicketId'
        }
    ];
}

function electronicsContentCatalogOnline(postedData: any): [number, Payload | Payload[]] {
    switch (postedData.language) {
        case 'fr':
            return [
                400,
                {
                    errors: [
                        {
                            message:
                                "CatalogVersion with catalogId 'electronicsContentCatalog' and version 'Online' not found!",
                            type: 'UnknownIdentifierError'
                        }
                    ]
                }
            ];
        case 'pl':
            if (postedData.time && postedData.time.indexOf('2016-01-01T13:00') >= 0) {
                return [
                    200,
                    {
                        catalog: 'electronicsContentCatalog',
                        catalogVersion: 'Online',
                        resourcePath: STOREFRONT_URI,
                        language: 'pl',
                        time: '1/1/16 1:00 PM',
                        ticketId: 'validTicketId2'
                    }
                ];
            }
            return [
                200,
                {
                    catalog: 'electronicsContentCatalog',
                    catalogVersion: 'Online',
                    resourcePath: STOREFRONT_URI,
                    language: 'pl',
                    ticketId: 'validTicketId1'
                }
            ];
        default:
            return retrurnDefaultData(postedData);
    }
}

function electronicsContentCatalogStageg(postedData: any): [number, Payload | Payload[]] {
    if (
        postedData.time &&
        postedData.time.indexOf('2016-01-01T00:00:00') >= 0 &&
        postedData.language === 'it'
    ) {
        if (postedData.newField === 'New Data For Preview') {
            return [
                200,
                {
                    catalog: 'electronicsContentCatalog',
                    catalogVersion: 'Staged',
                    resourcePath: STOREFRONT_URI,
                    language: 'it',
                    newField: 'New Data For Preview',
                    time: '1/1/16 12:00 AM',
                    ticketId: 'validTicketId2'
                }
            ];
        }

        return [
            200,
            {
                catalog: 'electronicsContentCatalog',
                catalogVersion: 'Staged',
                resourcePath: STOREFRONT_URI,
                language: 'it',
                time: '1/1/16 12:00 AM',
                ticketId: 'validTicketId2'
            }
        ];
    }

    return retrurnDefaultData(postedData);
}

function apparelUKOnline(postedData): [number, Payload | Payload[]] {
    if (postedData.language === 'fr') {
        if (postedData.time && postedData.time.indexOf('2016-01-01T') >= 0) {
            return [
                200,
                {
                    catalog: APPAREL_UK_CATALOG,
                    catalogVersion: 'Online',
                    resourcePath: STOREFRONT_URI,
                    language: 'fr',
                    time: '1/1/16 1:00 PM',
                    ticketId: 'apparel-ukContentCatalogOnlineValidTicket'
                }
            ];
        }
        return [
            200,
            {
                catalog: APPAREL_UK_CATALOG,
                catalogVersion: 'Online',
                resourcePath: STOREFRONT_URI,
                language: 'fr',
                ticketId: 'apparel-ukContentCatalogOnlineValidTicket'
            }
        ];
    }

    return retrurnDefaultData(postedData);
}
