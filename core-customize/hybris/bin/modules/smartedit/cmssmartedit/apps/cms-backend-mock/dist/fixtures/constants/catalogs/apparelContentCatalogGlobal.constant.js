"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.apparelContentCatalogGlobal = void 0;
const catalogs_1 = require("../../entities/catalogs");
const LABEL_PAGE_DISPLAYCONDITION_VARIATION = 'page.displaycondition.variation';
exports.apparelContentCatalogGlobal = {
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
//# sourceMappingURL=apparelContentCatalogGlobal.constant.js.map