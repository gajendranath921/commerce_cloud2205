"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.apparelContentCatalogUK = void 0;
const versions_1 = require("../versions");
const catalogs_1 = require("../../entities/catalogs");
const apparelContentCatalogGlobal_constant_1 = require("./apparelContentCatalogGlobal.constant");
const LABEL_PAGE_DISPLAYCONDITION_VARIATION = 'page.displaycondition.variation';
const APPAREL_UK_CONTENT_CATALOG_STAGE = 'apparel-ukContentCatalog/Staged';
exports.apparelContentCatalogUK = {
    catalogId: 'apparel-ukContentCatalog',
    name: {
        en: 'Apparel UK Content Catalog'
    },
    parents: [apparelContentCatalogGlobal_constant_1.apparelContentCatalogGlobal],
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
        versions_1.apparelUkContentCatalogOnlineVersion
    ]
};
//# sourceMappingURL=apparelContentCatalogUK.constant.js.map