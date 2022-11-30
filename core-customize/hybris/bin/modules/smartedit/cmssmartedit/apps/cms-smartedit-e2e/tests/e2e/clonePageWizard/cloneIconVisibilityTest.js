/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint unused:false, undef:false */
describe('Clone Page Toolbar Icon: ', function () {
    var clonePageWizard = e2e.pageObjects.clonePageWizard;
    var storefrontPage = e2e.pageObjects.StorefrontPage;
    var perspective = e2e.componentObjects.modeSelector;
    var sfBuilder = e2e.se.componentObjects.sfBuilder;
    const CATALOG_ONLINE = 'apparelContentCatalog/Online';
    const APPAREL_SITE_ID = 'apparel';
    const APPAREL_UK_SITE_ID = 'apparel-uk';

    beforeEach(function (done) {
        browser.bootstrap(__dirname).then(function () {
            browser.waitForWholeAppToBeReady().then(function () {
                perspective.select(perspective.BASIC_CMS_PERSPECTIVE);
                done();
            });
        });
    });

    it('GIVEN a page belongs to a writable non-active catalog version that has cloneable targets THEN clone icon is visible', function () {
        clonePageWizard.assertions.cloneIconIsDisplayed();
    });

    it('GIVEN a page belongs to a writable active catalog version that has no targets THEN clone icon is not visible', function () {
        sfBuilder.actions.changePageIdAndCatalogVersion(
            'homepage_uk_online',
            'apparel-ukContentCatalog/Online'
        );
        clonePageWizard.assertions.cloneIconIsNotDisplayed();
    });

    it('GIVEN a variation page belongs to a writable active catalog version that has targets THEN clone icon is visible', function () {
        storefrontPage.actions.setSelectedSiteId(APPAREL_SITE_ID).then(function () {
            sfBuilder.actions.changePageIdAndCatalogVersion(
                'homepage_gloabl_online_variation',
                CATALOG_ONLINE
            );
            clonePageWizard.assertions.cloneIconIsDisplayed();
            storefrontPage.actions.setSelectedSiteId(APPAREL_UK_SITE_ID);
        });
    });

    it('GIVEN a primary page whose copyToCatalogDisabled is set to true and that the page belongs to a writable active catalog version that has targets THEN clone icon is not visible', function () {
        storefrontPage.actions.setSelectedSiteId(APPAREL_SITE_ID).then(function () {
            sfBuilder.actions.changePageIdAndCatalogVersion(
                'homepage_gloabl_online_copy_disabled',
                CATALOG_ONLINE
            );
            clonePageWizard.assertions.cloneIconIsNotDisplayed();
            storefrontPage.actions.setSelectedSiteId(APPAREL_UK_SITE_ID);
        });
    });

    it('GIVEN a primary page whose copyToCatalogDisabled is set to false and the page belongs to a writable active catalog version that has targets THEN clone icon is visible', function () {
        storefrontPage.actions.setSelectedSiteId(APPAREL_SITE_ID).then(function () {
            sfBuilder.actions.changePageIdAndCatalogVersion(
                'homepage_global_online',
                CATALOG_ONLINE
            );
            clonePageWizard.assertions.cloneIconIsDisplayed();
            storefrontPage.actions.setSelectedSiteId(APPAREL_UK_SITE_ID);
        });
    });
});
