/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint unused:false, undef:false */
module.exports = (function () {
    var pageStatus = require('../componentObjects/pageStatusComponentObject');

    var NUMBER_OF_ARROWS_IN_PAGINATION_LIST = 2;
    var confirmationModal = e2e.componentObjects.confirmationModal;
    var pageList = {};
    const PAGE_COUNT_CSS = '.se-page-list__page-count';
    const DROPDOWN_CSS = '.se-dropdown-menu__list li';

    pageList.selectors = {
        getColumnHeaderForKeySelector: function (key) {
            return by.css(
                '.se-paged-list-table thead tr:first-child .se-paged-list__header-' + key
            );
        },

        getFirstRowForKeySelector: function (key) {
            return by.css('.se-paged-list-table tbody tr:first-child .se-paged-list-item-' + key);
        },

        getLastRowForKeySelector: function (key) {
            return by.css('.se-paged-list-table tbody tr:last-child .se-paged-list-item-' + key);
        },
        getTotalPageCountSelector: function () {
            return by.css(PAGE_COUNT_CSS);
        },

        getRestrictionsTooltipSelector: function () {
            return by.css('.se-popover');
        }
    };

    pageList.elements = {
        getTotalPageCount: function () {
            browser.waitForPresence(
                element(by.css('.se-paged-list__page-count-wrapper')),
                'cannot find page list count item'
            );
            return element(by.css(PAGE_COUNT_CSS));
        },

        getTotalPageCountByValue: function (value) {
            return element(by.cssContainingText(PAGE_COUNT_CSS, `(${value.toString()})`));
        },

        getDisplayedPageCount: function () {
            return element.all(by.css('.se-paged-list-table tbody tr')).count();
        },

        getPaginationCount: function () {
            return element
                .all(by.css('.fd-pagination__link'))
                .count()
                .then(function (count) {
                    return count - NUMBER_OF_ARROWS_IN_PAGINATION_LIST;
                });
        },

        getPageDropdownMenu: function () {
            return element(by.css('ul.dropdown-menu'));
        },

        getDropdownSyncButton: function () {
            return element(by.cssContainingText(DROPDOWN_CSS, 'Sync'));
        },

        getDropdownEditButton: function () {
            return element(by.cssContainingText(DROPDOWN_CSS, 'Edit'));
        },

        getDropdownCloneButton: function () {
            return element(by.cssContainingText(DROPDOWN_CSS, 'Clone'));
        },

        getDropdownMoveToTrashButton: function () {
            return element(by.cssContainingText(DROPDOWN_CSS, 'Move to Trash'));
        },

        getModalDialog: function () {
            return element(by.css('.fd-modal'));
        },

        getConfirmationDialog: function () {
            return element(by.css('.se-confirmation-dialog'));
        },

        getModalSyncPanel: function () {
            return element(by.css('se-synchronization-panel'));
        },

        getSynchronizableItemsForPage: function () {
            return element.all(by.css('.se-sync-panel .se-sync-panel__row'));
        },

        getModalSyncPanelSyncButton: function () {
            return pageList.elements.getModalDialog().element(by.css('#sync'));
        },

        getClickableModalSyncPanelSyncButton: function () {
            return pageList.elements.getModalDialog().element(by.css('#sync:not([disabled])'));
        },

        getSearchInput: function () {
            return element(by.css('.ySEPage-list-search-input'));
        },

        clearSearchFilter: function () {
            return browser.click(element(by.css('.se-input-group__clear-btn')));
        },

        getColumnHeaderForKey: function (key) {
            return element(pageList.selectors.getColumnHeaderForKeySelector(key));
        },

        getFirstRowForKey: function (key) {
            return element(pageList.selectors.getFirstRowForKeySelector(key));
        },

        getLastRowForKey: function (key) {
            return element(pageList.selectors.getLastRowForKeySelector(key));
        },

        getLinkForKeyAndRow: function (key, row, selector) {
            return element(
                by.css(
                    '.se-paged-list-table tbody tr:nth-child(' +
                        row +
                        ') .se-paged-list-item-' +
                        key +
                        ' ' +
                        selector
                )
            );
        },

        getCatalogName: function () {
            return element(by.css('.se-page-list__sub-title'));
        },

        getRestrictionsIconForHomePage: function () {
            return element(by.cssContainingText('tr', 'homepage')).element(
                by.css('.restrictionPageListIcon')
            );
        },

        getRestrictionsIconForPageById: function (id) {
            return element(by.cssContainingText('tr', id)).element(
                by.css('img.restrictionPageListIcon')
            );
        },

        getRestrictionsTooltip: function () {
            return element(pageList.selectors.getRestrictionsTooltipSelector());
        },

        getAddNewPageButton: function () {
            return browser.element(by.css('.se-page-list__add'));
        },

        getPageListTrashLink: function () {
            return element(by.css('.se-page-list__page-link--right '));
        },

        getRowByPageName: function (pageName) {
            return browser.findElement(pageList.utils.getPageRowQuery(pageName));
        },

        getDropDownButtonByPageName: function (pageName) {
            return pageList.elements
                .getRowByPageName(pageName)
                .element(by.css('.se-dropdown-more-menu__toggle'));
        },

        getTrashViewLink: function () {
            return browser.findElement(by.css('.se-page-list__page-link--right a'), true);
        },

        getFailureAlert: function () {
            return element(by.css('.fd-alert.fd-alert--error'));
        },

        getDropdownButtonByName: function (buttonName) {
            return element(by.cssContainingText(DROPDOWN_CSS, buttonName));
        },

        // Trashed Page List Items
        getDropdownPermanentlyDeleteButton: function () {
            return element(by.cssContainingText(DROPDOWN_CSS, 'Permanently Delete'));
        },

        getDropdownRestoreButton: function () {
            var item = element(by.cssContainingText(DROPDOWN_CSS, 'Restore'));
            browser.waitForPresence(
                item,
                'Expected Restore option to be available in the dropdown.'
            );

            return item;
        },

        getDropdownSyncPageStatusButton: function () {
            return element(by.cssContainingText(DROPDOWN_CSS, 'Sync'));
        },

        getRestrictionsForPage: function (pageName) {
            return pageList.elements
                .getRowByPageName(pageName)
                .element(by.css('se-restrictions-viewer .show-restrictions-btn'));
        },

        getRestrictionsInViewer: function () {
            return element.all(by.css('.se-restrictions-list .se-restriction__item'));
        }
    };

    pageList.actions = {
        moveToRestrictionsIconForAdvertisePage: function () {
            return browser
                .actions()
                .mouseMove(pageList.elements.getRestrictionsIconForAdvertisePage())
                .perform();
        },

        moveToRestrictionsIconForHomePage: function () {
            browser.waitForPresence(pageList.elements.getRestrictionsIconForHomePage());
            return browser
                .actions()
                .mouseMove(pageList.elements.getRestrictionsIconForHomePage())
                .perform();
        },

        moveToRestrictionsIconForPageById: function (id) {
            browser.waitForPresence(pageList.elements.getRestrictionsIconForPageById(id));
            return browser
                .actions()
                .mouseMove(pageList.elements.getRestrictionsIconForPageById(id))
                .perform();
        },

        openPageDropdownByPageName: function (pageName) {
            return browser
                .click(pageList.elements.getDropDownButtonByPageName(pageName))
                .then(function () {
                    return browser.waitForPresence(element(by.css('.se-dropdown-menu__list')));
                });
        },

        closePageDropdownByPageName: function (pageName) {
            return browser
                .actions()
                .mouseMove(pageList.elements.getDropDownButtonByPageName(pageName))
                .mouseMove({ x: -10, y: -10 })
                .click()
                .perform();
        },

        navigateToIndex: function (index) {
            return browser
                .executeScript('window.scrollTo(0,document.body.scrollHeight);')
                .then(function () {
                    return browser
                        .click(
                            element(by.cssContainingText('.fd-pagination__link', index.toString()))
                        )
                        .then(function () {
                            return browser.waitUntilNoModal();
                        });
                });
        },

        searchForPage: function (query, columnHeader, expectedNumber) {
            pageList.elements.getSearchInput().clear();
            pageList.elements.getSearchInput().sendKeys(query);

            pageList.assertions.totalPageCount(expectedNumber);
            expect(pageList.elements.getDisplayedPageCount()).toBe(expectedNumber);

            pageList.elements
                .getFirstRowForKey(columnHeader)
                .getText()
                .then(function (text) {
                    expect(text.toLowerCase().indexOf(query) >= 0).toBeTruthy();
                });
        },

        clickOnColumnHeader: function (key) {
            return browser
                .click(pageList.selectors.getColumnHeaderForKeySelector(key))
                .then(function () {
                    return browser.waitUntilNoModal();
                });
        },

        clickSyncPageModalSyncButton: function () {
            browser.click(pageList.elements.getClickableModalSyncPanelSyncButton());
        },

        openSyncModalFromActiveDropdown: function () {
            browser.waitForPresence(
                pageList.elements.getDropdownSyncButton(),
                'Expected sync option to be available in the dropdown.'
            );
            browser.click(
                pageList.elements.getDropdownSyncButton(),
                'Could not click on the sync option in the dropdown.'
            );
            browser.waitForPresence(
                pageList.elements.getModalDialog(),
                'Expected the presence of a modal window.'
            );
            browser.waitForPresence(
                pageList.elements.getModalSyncPanel(),
                'Expected the presence of a synchronization panel inside the modal.'
            );
        },

        openTrashedPageList: function () {
            return browser.click(pageList.elements.getPageListTrashLink());
        },

        clickOnTrashViewLink: function () {
            return browser.click(pageList.elements.getTrashViewLink());
        },

        bringTrashViewLinkIntoView: function () {
            return browser.bringElementIntoView(pageList.elements.getTrashViewLink());
        },

        // Trashed Page List Items
        permanentlyDeletePageByName: function (pageName) {
            pageList.actions.openPageDropdownByPageName(pageName);
            pageList.actions.showConfirmationModalForPermanentDelete();
            browser.waitForAbsence(element(by.css('body > .modal.ng-animate')));
            confirmationModal.actions.confirmConfirmationModal();
        },

        showConfirmationModalForPermanentDelete: function () {
            browser.waitForPresence(
                pageList.elements.getDropdownPermanentlyDeleteButton(),
                'Expected Permanently Delete option to be available in the dropdown.'
            );
            browser.click(
                pageList.elements.getDropdownPermanentlyDeleteButton(),
                'Could not click on the Permanently Delete option in the dropdown.'
            );
            browser.waitForPresence(
                pageList.elements.getConfirmationDialog(),
                'Expected the presence of confirmation modal window.'
            );
        },

        restorePageByName: function (pageName) {
            return pageList.actions.openPageDropdownByPageName(pageName).then(function () {
                return browser.click(
                    pageList.elements.getDropdownRestoreButton(),
                    'Could not click on the Restore option in the dropdown.'
                );
            });
        },

        //
        syncPageStatus: function (pageName) {
            pageList.actions.openPageDropdownByPageName(pageName);
            pageList.actions.clickSyncPageStatusButton();
            confirmationModal.actions.confirmConfirmationModal();
            browser.waitUntilNoModal();
        },

        clickSyncPageStatusButton: function () {
            browser.waitForPresence(
                pageList.elements.getDropdownSyncPageStatusButton(),
                'Expected Sync Page Status option to be available in the dropdown.'
            );
            browser.click(
                pageList.elements.getDropdownSyncPageStatusButton(),
                'Could not click on the Sync Page Status option in the dropdown.'
            );
            browser.waitForPresence(
                pageList.elements.getConfirmationDialog(),
                'Expected the presence of confirmation modal window.'
            );
        },
        // Restrictions Viewer
        openRestrictionsViewer: function (pageName) {
            return browser.click(pageList.elements.getRestrictionsForPage(pageName));
        }
    };

    pageList.assertions = {
        assertRestrictionIconForHomePageIsDisabled: function () {
            expect(
                pageList.elements.getRestrictionsIconForHomePage().getAttribute('data-ng-src')
            ).toContain('icon_restriction_small_grey.png');
        },
        assertPageListIsDisplayed: function () {
            expect(pageList.elements.getAddNewPageButton().isPresent()).toBe(true);
        },
        assertHasSynchronizableItems: function () {
            browser.waitUntil(function () {
                return pageList.elements
                    .getSynchronizableItemsForPage()
                    .count()
                    .then(function (count) {
                        return count > 0;
                    });
            }, 'Expected at least one synchronizable item for the page.');
        },
        assertHasSyncOptionAvailableOnDropdown: function () {
            browser.waitForPresence(
                pageList.elements.getDropdownSyncButton(),
                'Expected sync option to be available in the dropdown.'
            );
            expect(pageList.elements.getDropdownSyncButton().isPresent()).toBe(
                true,
                'Expected the presence of sync option in the dropdown menu'
            );
        },
        searchAndAssertCount: function (query, displayedResults, totalResults) {
            const input = pageList.elements.getSearchInput();
            browser.clearInput(input);
            input.sendKeys(query);

            browser.waitUntilNoModal().then(function () {
                browser.waitForPresence(pageList.elements.getTotalPageCountByValue(totalResults));
                browser.waitUntil(function () {
                    return pageList.elements
                        .getTotalPageCount()
                        .isPresent()
                        .then(function (isPresent) {
                            if (isPresent) {
                                return pageList.elements
                                    .getTotalPageCount()
                                    .getText()
                                    .then(function (text) {
                                        return text.indexOf(totalResults) !== -1;
                                    });
                            }
                            return false;
                        });
                });
                pageList.assertions.totalPageCount(totalResults);
                expect(pageList.elements.getDisplayedPageCount()).toBe(displayedResults);
            });
        },
        assertTotalTrashedpagesCountInButtonText: function (totalCount) {
            return browser.waitUntil(function () {
                return pageList.elements
                    .getPageListTrashLink()
                    .getText()
                    .then(function (buttonText) {
                        return buttonText.indexOf(totalCount);
                    });
            }, 'unexpected count of trashed pages');
        },
        trashPagesCountEquals: function (expectedCount) {
            expect(pageList.elements.getTrashViewLink().getText()).toBe(
                'TRASH (' + expectedCount + ' PAGES)'
            );
        },
        pageRowIsRenderedByPageName: function (pageName) {
            expect(pageList.elements.getRowByPageName(pageName)).toBeDisplayed();
        },
        pageRowIsNotRenderedByPageName: function (pageName) {
            expect(pageList.utils.getPageRowQuery(pageName)).toBeAbsent();
        },
        assertTrashFailure: function () {
            browser.waitToBeDisplayed(pageList.elements.getFailureAlert());
        },

        firstRowColumnContainText: function (column, value) {
            browser.waitForSelectorToContainText(
                pageList.selectors.getFirstRowForKeySelector(column),
                value
            );
        },

        lastRowColumnContainText: function (column, value) {
            browser.waitForSelectorToContainText(
                pageList.selectors.getLastRowForKeySelector(column),
                value
            );
        },

        totalPageCount: function (count) {
            browser.waitForPresence(
                element(by.css('.se-paged-list__page-count-wrapper')),
                'cannot find page list count item'
            );
            browser.waitForSelectorToContainText(
                pageList.selectors.getTotalPageCountSelector(),
                count
            );
        },

        restrictionTooltipToContain: function (count) {
            browser.waitForSelectorToContainText(
                pageList.selectors.getRestrictionsTooltipSelector(),
                count + ' restrictions'
            );
        },
        permanentlyDeleteButtonCanNotBeClicked: function (pageName) {
            pageList.actions.openPageDropdownByPageName(pageName);
            browser.waitForPresence(
                pageList.elements
                    .getDropdownPermanentlyDeleteButton()
                    .element(by.css('a.se-dropdown-item--disabled'))
            );
        },
        permanentlyDeleteButtonCanBeClicked: function (pageName) {
            pageList.actions.openPageDropdownByPageName(pageName);
            browser.waitForAbsence(
                pageList.elements
                    .getDropdownPermanentlyDeleteButton()
                    .element(by.css('a.se-dropdown-item--disabled'))
            );
        },
        assertOptionNotAvailableOnDropdown: function (buttonName) {
            browser.waitForAbsence(pageList.elements.getDropdownButtonByName(buttonName));
        },
        pageStatusComponentIsDisplayedInPageRow: function (pageName) {
            var pageRow = pageList.elements.getRowByPageName(pageName);
            pageStatus.assertions.pageStatusComponentIsDisplayed(pageRow);
        },
        pageStatusComponentIsNotDisplayedInPageRow: function (pageName) {
            var pageRow = pageList.elements.getRowByPageName(pageName);
            pageStatus.assertions.pageStatusComponentIsNotDisplayed(pageRow);
        },
        assertSyncStatusButtonNotAvailable: function (pageName) {
            pageList.actions.openPageDropdownByPageName(pageName);
            browser.waitForAbsence(pageList.elements.getDropdownSyncButton());
        },
        // Restrictions Viewer
        assertRestrictionsCountInViewer: function (pageName, expectedCount) {
            pageList.actions.openRestrictionsViewer(pageName);
            pageList.elements
                .getRestrictionsInViewer()
                .count()
                .then(function (count) {
                    expect(count).toBe(expectedCount);
                });
        }
    };

    pageList.utils = {
        getPageRowQuery: function (pageName) {
            return by.cssContainingText('.se-paged-list-item', pageName);
        }
    };

    return pageList;
})();
