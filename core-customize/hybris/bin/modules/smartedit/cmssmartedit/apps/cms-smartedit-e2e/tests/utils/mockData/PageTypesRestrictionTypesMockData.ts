/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
export class MockPageTypesRestrictionTypes {
    getTypeCodesForContentPageMocks() {
        return [
            'CMSTimeRestriction',
            'CMSUserRestriction',
            'CMSUserGroupRestriction',
            'CMSUiExperienceRestriction'
        ];
    }

    getMocksForContentPages() {
        return [
            {
                pageType: 'ContentPage',
                restrictionType: 'CMSTimeRestriction'
            },
            {
                pageType: 'ContentPage',
                restrictionType: 'CMSUserRestriction'
            },
            {
                pageType: 'ContentPage',
                restrictionType: 'CMSUserGroupRestriction'
            },
            {
                pageType: 'ContentPage',
                restrictionType: 'CMSUiExperienceRestriction'
            }
        ];
    }

    getMocks() {
        return {
            pageTypeRestrictionTypeList: [
                {
                    pageType: 'CatalogPage',
                    restrictionType: 'CMSCatalogRestriction'
                },
                {
                    pageType: 'CatalogPage',
                    restrictionType: 'CMSTimeRestriction'
                },
                {
                    pageType: 'CatalogPage',
                    restrictionType: 'CMSUserRestriction'
                },
                {
                    pageType: 'CatalogPage',
                    restrictionType: 'CMSUserGroupRestriction'
                },
                {
                    pageType: 'CatalogPage',
                    restrictionType: 'CMSUiExperienceRestriction'
                },
                {
                    pageType: 'CategoryPage',
                    restrictionType: 'CMSCategoryRestriction'
                },
                {
                    pageType: 'CategoryPage',
                    restrictionType: 'CMSTimeRestriction'
                },
                {
                    pageType: 'CategoryPage',
                    restrictionType: 'CMSUserRestriction'
                },
                {
                    pageType: 'CategoryPage',
                    restrictionType: 'CMSUserGroupRestriction'
                },
                {
                    pageType: 'CategoryPage',
                    restrictionType: 'CMSUiExperienceRestriction'
                },
                {
                    pageType: 'ContentPage',
                    restrictionType: 'CMSTimeRestriction'
                },
                {
                    pageType: 'ContentPage',
                    restrictionType: 'CMSUserRestriction'
                },
                {
                    pageType: 'ContentPage',
                    restrictionType: 'CMSUserGroupRestriction'
                },
                {
                    pageType: 'ContentPage',
                    restrictionType: 'CMSUiExperienceRestriction'
                },
                {
                    pageType: 'ProductPage',
                    restrictionType: 'CMSCategoryRestriction'
                },
                {
                    pageType: 'ProductPage',
                    restrictionType: 'CMSProductRestriction'
                },
                {
                    pageType: 'ProductPage',
                    restrictionType: 'CMSTimeRestriction'
                },
                {
                    pageType: 'ProductPage',
                    restrictionType: 'CMSUserRestriction'
                },
                {
                    pageType: 'ProductPage',
                    restrictionType: 'CMSUserGroupRestriction'
                },
                {
                    pageType: 'ProductPage',
                    restrictionType: 'CMSUiExperienceRestriction'
                }
            ]
        };
    }
}
