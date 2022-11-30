/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { IContentCatalog } from 'fixtures/entities/catalogs';
const LABEL_PAGE_DISPLAYCONDITION_VARIATION = 'page.displaycondition.variation';
export const apparelContentCatalogGlobal: IContentCatalog = {
    catalogId: 'apparelContentCatalog',
    name: {
        en: 'Apparel Content Catalog'
    },
    catalogName: {
        en: 'Apparel Content Catalog'
    },
    versions: [
        {
            active: true,
            pageDisplayConditions: [
                {
                    options: [
                        {
                            label: LABEL_PAGE_DISPLAYCONDITION_VARIATION,
                            id: 'VARIATION'
                        }
                    ],
                    typecode: 'ProductPage'
                },
                {
                    options: [
                        {
                            label: LABEL_PAGE_DISPLAYCONDITION_VARIATION,
                            id: 'VARIATION'
                        }
                    ],
                    typecode: 'CategoryPage'
                },
                {
                    options: [
                        {
                            label: 'page.displaycondition.primary',
                            id: 'PRIMARY'
                        },
                        {
                            label: LABEL_PAGE_DISPLAYCONDITION_VARIATION,
                            id: 'VARIATION'
                        }
                    ],
                    typecode: 'ContentPage'
                }
            ],
            thumbnailUrl: '/medias/Homepage.png',
            uuid: 'apparelContentCatalog/Online',
            version: 'Online'
        },
        {
            active: false,
            pageDisplayConditions: [
                {
                    options: [
                        {
                            label: LABEL_PAGE_DISPLAYCONDITION_VARIATION,
                            id: 'VARIATION'
                        }
                    ],
                    typecode: 'ProductPage'
                },
                {
                    options: [
                        {
                            label: LABEL_PAGE_DISPLAYCONDITION_VARIATION,
                            id: 'VARIATION'
                        }
                    ],
                    typecode: 'CategoryPage'
                },
                {
                    options: [
                        {
                            label: 'page.displaycondition.primary',
                            id: 'PRIMARY'
                        },
                        {
                            label: LABEL_PAGE_DISPLAYCONDITION_VARIATION,
                            id: 'VARIATION'
                        }
                    ],
                    typecode: 'ContentPage'
                }
            ],
            thumbnailUrl: '/medias/Homepage.png',
            uuid: 'apparelContentCatalog/Staged',
            version: 'Staged'
        }
    ]
};
