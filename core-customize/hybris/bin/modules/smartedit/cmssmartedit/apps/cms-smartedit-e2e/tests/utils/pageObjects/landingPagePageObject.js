/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint unused:false, undef:false */
module.exports = (function () {
    var landingPage = {};

    landingPage.constants = {
        // Sites
        APPAREL_UK_SITE: 'Apparels',
        ELECTRONICS_SITE: 'Electronics',
        TOYS_SITE: 'Toys',

        // Catalogs
        APPAREL_UK_CATALOG: 'Apparel UK Content Catalog',

        // Catalog Versions
        ACTIVE_CATALOG_VERSION: 'Online',
        STAGED_CATALOG_VERSION: 'Staged',

        // Sync Status
        SYNC_STATUS_FAILED: 'Failed',
        SYNC_STATUS_FINISHED: 'Finished',
        SYNC_STATUS_IN_PROGRESS: 'In Progress'
    };

    landingPage.elements = {
        // Catalogs
        getCatalogsDisplayed: function () {
            return element.all(by.css('se-catalog-details'));
        },
        getCatalogByIndex: function (index) {
            return this.getCatalogsDisplayed().get(index);
        },
        getCatalogVersion: function (catalogName, catalogVersion) {
            return element(
                by.css(
                    '[data-catalog="' +
                        catalogName +
                        '"] [data-catalog-version="' +
                        catalogVersion +
                        '"]'
                )
            );
        },
        getPageListLink: function (catalogName, catalogVersion) {
            return this.getCatalogVersion(catalogName, catalogVersion).element(
                by.css('.page-list-link-item__link')
            );
        },
        getHomepageLink: function (catalogName, catalogVersion) {
            return this.getCatalogVersion(catalogName, catalogVersion).element(
                by.css('se-home-page-link')
            );
        },
        getNavigationManagementLink: function (catalogName, catalogVersion) {
            return this.getCatalogVersion(catalogName, catalogVersion).element(
                by.css('.nav-management-link-item__link')
            );
        },

        // Sync
        getSyncButtonForCatalogVersion: function (catalogName, catalogVersion) {
            return this.getCatalogVersion(catalogName, catalogVersion).element(
                by.css('.se-synchronize-catalog__sync-btn')
            );
        },
        getSyncTimestampForCatalogVersion: function (catalogName, catalogVersion) {
            return this.getCatalogVersion(catalogName, catalogVersion).element(
                by.css('.se-synchronize-catalog__sync-info__last-synched')
            );
        },
        getSyncSourceForCatalogVersion: function (catalogName, catalogVersion) {
            return this.getCatalogVersion(catalogName, catalogVersion).element(
                by.css('.se-synchronize-catalog__sync-info__sync-label')
            );
        },
        getSyncFailedMessage: function (catalogName, catalogVersion) {
            return this.getCatalogVersion(catalogName, catalogVersion).element(
                by.css('.se-synchronize-catalog__sync-failed')
            );
        },
        getSyncInProgressMessage: function (catalogName, catalogVersion) {
            return this.getCatalogVersion(catalogName, catalogVersion).element(
                by.css('.se-synchronize-catalog__in-progress')
            );
        },

        // Sync Confirmation Dialog
        getSyncConfirmationDialogOkButton: function () {
            return browser.findElement(by.css('button#confirmOk'));
        }
    };

    landingPage.actions = {
        // Navigation
        navigateToFirstOnlineCatalogPageList: function () {
            return this.navigateToCatalogPageList(
                landingPage.constants.APPAREL_UK_CATALOG,
                landingPage.constants.ACTIVE_CATALOG_VERSION
            );
        },
        navigateToFirstStagedCatalogPageList: function () {
            return this.navigateToCatalogPageList(
                landingPage.constants.APPAREL_UK_CATALOG,
                landingPage.constants.STAGED_CATALOG_VERSION
            );
        },
        navigateToFirstNavigationManagementPage: function () {
            return this.navigateToCatalogNavigationManagementPage(
                landingPage.constants.APPAREL_UK_CATALOG,
                landingPage.constants.ACTIVE_CATALOG_VERSION
            );
        },
        navigateToCatalogPageList: function (catalogName, catalogVersion) {
            return browser.click(landingPage.elements.getPageListLink(catalogName, catalogVersion));
        },
        navigateToCatalogHomepage: function (catalogName, catalogVersion) {
            return browser.click(landingPage.elements.getHomepageLink(catalogName, catalogVersion));
        },
        navigateToCatalogNavigationManagementPage: function (catalogName, catalogVersion) {
            return browser.click(
                landingPage.elements.getNavigationManagementLink(catalogName, catalogVersion)
            );
        },
        synchronizeCatalogVersion: function (catalogName, catalogVersion) {
            return browser
                .click(
                    landingPage.elements.getSyncButtonForCatalogVersion(catalogName, catalogVersion)
                )
                .then(function () {
                    return browser.click(landingPage.elements.getSyncConfirmationDialogOkButton());
                });
        }
    };

    landingPage.assertions = {
        // Sync
        syncButtonIsDisplayedIfNecessary: function (
            catalogName,
            catalogVersion,
            syncJobExpectedInfo
        ) {
            var isButtonExpectedToBeDisplayed = syncJobExpectedInfo.buttonIsVisible;
            var errorMessage = isButtonExpectedToBeDisplayed
                ? 'Expected sync button to be displayed'
                : 'Expected sync button not to be displayed';
            expect(
                landingPage.elements
                    .getSyncButtonForCatalogVersion(catalogName, catalogVersion)
                    .isPresent()
            ).toBe(isButtonExpectedToBeDisplayed, errorMessage);
        },
        syncButtonIsEnabledIfNecessary: function (
            catalogName,
            catalogVersion,
            syncJobExpectedInfo
        ) {
            if (syncJobExpectedInfo.buttonIsVisible) {
                var isButtonExpectedToBeEnabled = syncJobExpectedInfo.buttonIsEnabled;
                var errorMessage = isButtonExpectedToBeEnabled
                    ? 'Expected sync button to be enabled'
                    : 'Expected sync button not to be enabled';
                expect(
                    landingPage.elements
                        .getSyncButtonForCatalogVersion(catalogName, catalogVersion)
                        .isEnabled()
                ).toBe(isButtonExpectedToBeEnabled, errorMessage);
            }
        },
        hasRightTimestampIfNecessary: function (catalogName, catalogVersion, syncJobExpectedInfo) {
            if (syncJobExpectedInfo.timestamp) {
                expect(
                    landingPage.elements
                        .getSyncTimestampForCatalogVersion(catalogName, catalogVersion)
                        .getText()
                ).toEqual(syncJobExpectedInfo.timestamp, 'Invalid sync timestamp');
            }
        },
        hasRightSourceVersionIfNecessary: function (
            catalogName,
            catalogVersion,
            syncJobExpectedInfo
        ) {
            if (syncJobExpectedInfo.fromVersion) {
                expect(
                    landingPage.elements
                        .getSyncSourceForCatalogVersion(catalogName, catalogVersion)
                        .getText()
                ).toContain(syncJobExpectedInfo.fromVersion, 'Invalid sync source');
            }
        },
        hasRightStatus: function (catalogName, catalogVersion, syncJobExpectedInfo) {
            if (syncJobExpectedInfo.status === landingPage.constants.SYNC_STATUS_FAILED) {
                browser.waitForPresence(
                    landingPage.elements.getSyncFailedMessage(catalogName, catalogVersion),
                    'Expected failed sync message to be shown'
                );
            } else if (
                syncJobExpectedInfo.status === landingPage.constants.SYNC_STATUS_IN_PROGRESS
            ) {
                browser.waitForPresence(
                    landingPage.elements.getSyncInProgressMessage(catalogName, catalogVersion),
                    'Expected in progress sync message to be shown'
                );
            }
        },
        catalogVersionSyncWidgetHasRightInfo: function (
            catalogName,
            catalogVersion,
            syncJobExpectedInfo
        ) {
            this.syncButtonIsDisplayedIfNecessary(catalogName, catalogVersion, syncJobExpectedInfo);
            this.syncButtonIsEnabledIfNecessary(catalogName, catalogVersion, syncJobExpectedInfo);
            this.hasRightTimestampIfNecessary(catalogName, catalogVersion, syncJobExpectedInfo);
            this.hasRightSourceVersionIfNecessary(catalogName, catalogVersion, syncJobExpectedInfo);
            this.hasRightStatus(catalogName, catalogVersion, syncJobExpectedInfo);
        }
    };

    landingPage.utils = {
        markSyncAsComplete: function () {
            return browser
                .executeScript(function () {
                    window.localStorage.syncResult = 'Finished';
                })
                .then(
                    function () {
                        return this.waitUntilSyncProcessed();
                    }.bind(this)
                );
        },
        markSyncAsFailed: function () {
            return browser
                .executeScript(function () {
                    window.localStorage.syncResult = 'Failed';
                })
                .then(
                    function () {
                        return this.waitUntilSyncProcessed();
                    }.bind(this)
                );
        },
        waitUntilSyncProcessed: function () {
            return browser.waitUntil(function () {
                return browser
                    .executeScript("return window.localStorage.getItem('syncResult');")
                    .then(function (isSyncProcessed) {
                        return isSyncProcessed === 'ACK';
                    });
            });
        }
    };

    return landingPage;
})();
