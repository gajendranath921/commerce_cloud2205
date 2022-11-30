/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { IContentCatalog } from 'fixtures/entities/catalogs';
import { apparelContentCatalogGlobal } from './apparelContentCatalogGlobal.constant';
const LABEL_PAGE_DISPLAYCONDITION_VARIATION = 'page.displaycondition.variation';
export const apparelContentCatalogDE: IContentCatalog = {
    catalogId: 'apparel-deContentCatalog',
    name: {
        en: 'Apparel DE Content Catalog'
    },
    parents: [apparelContentCatalogGlobal],
    versions: [
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
            uuid: 'apparel-deContentCatalog/Staged',
            version: 'Staged'
        },
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
            uuid: 'apparel-deContentCatalog/Online',
            version: 'Online'
        }
    ]
};
