/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { apparelUkContentCatalogOnlineVersion } from 'fixtures/constants/versions';
import { IContentCatalog } from 'fixtures/entities/catalogs';
import { apparelContentCatalogGlobal } from './apparelContentCatalogGlobal.constant';
const LABEL_PAGE_DISPLAYCONDITION_VARIATION = 'page.displaycondition.variation';
const APPAREL_UK_CONTENT_CATALOG_STAGE = 'apparel-ukContentCatalog/Staged';
export const apparelContentCatalogUK: IContentCatalog = {
    catalogId: 'apparel-ukContentCatalog',
    name: {
        en: 'Apparel UK Content Catalog'
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
            uuid: APPAREL_UK_CONTENT_CATALOG_STAGE,
            version: 'Staged',
            homepage: {
                current: {
                    uid: 'homepage',
                    name: 'Homepage',
                    catalogVersionUuid: APPAREL_UK_CONTENT_CATALOG_STAGE
                },
                old: {
                    uid: 'thirdpage',
                    name: 'Some Other Page',
                    catalogVersionUuid: APPAREL_UK_CONTENT_CATALOG_STAGE
                }
            }
        },
        apparelUkContentCatalogOnlineVersion
    ]
};
