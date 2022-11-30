/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { ICatalogVersion } from 'fixtures/entities/versions';
import { cloneDeep } from 'lodash';
const myOption = {
    label: 'page.displaycondition.variation',
    id: 'VARIATION'
};
export const apparelUkContentCatalogOnlineVersion: ICatalogVersion = {
    active: true,
    pageDisplayConditions: [
        {
            options: [cloneDeep(myOption)],
            typecode: 'ProductPage'
        },
        {
            options: [cloneDeep(myOption)],
            typecode: 'CategoryPage'
        },
        {
            options: [
                {
                    label: 'page.displaycondition.primary',
                    id: 'PRIMARY'
                },
                cloneDeep(myOption)
            ],
            typecode: 'ContentPage'
        }
    ],
    uuid: 'apparel-ukContentCatalog/Online',
    version: 'Online'
};
