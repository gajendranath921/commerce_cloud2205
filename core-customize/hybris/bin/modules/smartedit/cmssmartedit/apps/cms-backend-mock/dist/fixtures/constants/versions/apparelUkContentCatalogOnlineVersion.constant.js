"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.apparelUkContentCatalogOnlineVersion = void 0;
const versions_1 = require("../../entities/versions");
const lodash_1 = require("lodash");
const myOption = {
    label: 'page.displaycondition.variation',
    id: 'VARIATION'
};
exports.apparelUkContentCatalogOnlineVersion = {
    active: true,
    pageDisplayConditions: [
        {
            options: [lodash_1.cloneDeep(myOption)],
            typecode: 'ProductPage'
        },
        {
            options: [lodash_1.cloneDeep(myOption)],
            typecode: 'CategoryPage'
        },
        {
            options: [
                {
                    label: 'page.displaycondition.primary',
                    id: 'PRIMARY'
                },
                lodash_1.cloneDeep(myOption)
            ],
            typecode: 'ContentPage'
        }
    ],
    uuid: 'apparel-ukContentCatalog/Online',
    version: 'Online'
};
//# sourceMappingURL=apparelUkContentCatalogOnlineVersion.constant.js.map