/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint esversion: 6, unused:false, undef:false */

var TEXT_NOT_CLICKABLE = "'not clickable";
var navigationNodeEditor = function () {
    // This is intentional
};

navigationNodeEditor.prototype = {
    getAllEntryNames: function () {
        return element.all(by.css('.nav-node-editor-entry-item .nav-node-editor-entry-item__name'));
    },
    getEntryTitle: function (entryPosition) {
        return element(
            by.css(
                '.nav-node-editor-entry-item:nth-child(' +
                    (entryPosition + 2) +
                    ') .nav-node-editor-entry-item__text .nav-node-editor-entry-item__name'
            )
        ).getText();
    },
    clickItemSuperTypeDropdown: function () {
        return browser.click(element(by.id('itemSuperType')));
    },
    clickItemIdDropdown: function () {
        var el = browser.click(by.css('#itemId .ui-select-match'));
        this.waitForDropdownToBeLoaded('itemId');
        return el;
    },
    getItemIdDropdown: function () {
        return element(by.id('itemId-selector'));
    },
    getItemIdDropdownOptions: function () {
        return element.all(by.css("[id='itemId'] ul[role='listbox'] li[role='option']"));
    },
    getItemIdScrollElement: function () {
        return element(by.xpath("//ul[@id='itemId-list']//se-infinite-scrolling/div"));
    },
    getAddNewEntryButton: function () {
        return element(by.id('navigation-node-editor-add-entry'));
    },
    _saveEntryButtonLocator: function () {
        return by.id('navigation-node-editor-save-entry');
    },
    getSaveEntryButton: function () {
        return element(this._saveEntryButtonLocator());
    },
    getCancelEntryButton: function () {
        return element(by.id('navigation-node-editor-cancel'));
    },
    getEntrySearchDropdown: function () {
        return element(by.xpath("//div[@id='itemId-selector']/a"));
    },
    getValidationErrorElements: function (qualifier) {
        return element(
            by.css(
                '[id="' +
                    qualifier +
                    '"] se-generic-editor-field-messages span.se-help-block--has-error'
            )
        );
    },
    waitForDropdownToBeLoaded: function (dropdown) {
        var el = element(
            by.xpath("//ul[@id = '" + dropdown + "-list']//se-infinite-scrolling//li")
        );
        browser.waitForPresence(el);
    },
    sendKeys: function (keys) {
        return browser.sendKeys(by.css("entry-search-selector input[type='Search']"), keys);
    },
    selectTypeOption: function (dropdown, type) {
        var option;
        const XPATH_PREFIX = "//*[@id = '";
        if (dropdown === 'itemId') {
            option = element
                .all(
                    by.xpath(
                        `${XPATH_PREFIX}${dropdown}-list']//se-infinite-scrolling//*[contains(text(),'${type}')]`
                    )
                )
                .first();
        } else {
            option = element
                .all(by.xpath(`${XPATH_PREFIX}${dropdown}-list']//*[contains(text(),'${type}')]`))
                .first();
        }

        browser.waitUntil(function () {
            return option
                .click()
                .then(
                    function () {
                        return true;
                    },
                    function () {
                        return false;
                    }
                )
                .then(function (clickable) {
                    return clickable;
                });
        }, `Option type ${type}${TEXT_NOT_CLICKABLE}`);
    },
    selectOption: function (dropdown, index) {
        var option;
        const XPATH_PREFIX = "//ul[@id = '";
        if (dropdown === 'itemId') {
            option = element(
                by.xpath(`${XPATH_PREFIX}${dropdown}-list']//se-infinite-scrolling//li[${index}]`)
            );
        } else {
            option = element(by.xpath(`${XPATH_PREFIX}${dropdown}-list']/li/ul/li[${index}]`));
        }

        browser.waitUntil(function () {
            return option
                .click()
                .then(
                    function () {
                        return true;
                    },
                    function () {
                        return false;
                    }
                )
                .then(function (clickable) {
                    return clickable;
                });
        }, `Option at index ${index}${TEXT_NOT_CLICKABLE}`);
    },
    selectOptionByLabel: function (dropdown, label, isNotPaged) {
        var option;
        const XPATH_PREFIX = "//*[@id = '";
        if (!isNotPaged) {
            option = element
                .all(
                    by.xpath(
                        `${XPATH_PREFIX}${dropdown}-list']//se-infinite-scrolling//*[contains(text(),'${label}')]`
                    )
                )
                .first();
        } else {
            option = element
                .all(by.xpath(`${XPATH_PREFIX}${dropdown}-list']//*[contains(text(),'${label}')]`))
                .first();
        }

        return browser.waitUntil(function () {
            return browser
                .click(option)
                .then(
                    function () {
                        return true;
                    },
                    function () {
                        return false;
                    }
                )
                .then(function (clickable) {
                    return clickable;
                });
        }, `Option containing ${label}${TEXT_NOT_CLICKABLE}`);
    },
    clickSaveButton: function () {
        return browser.click(element(by.id('save')));
    },
    clickCancelButton: function () {
        return browser.click(element(by.id('cancel')));
    },
    saveNodeEntry: function () {
        return browser.click(this._saveEntryButtonLocator());
    },
    editNodeName: function (text) {
        return browser.sendKeys(by.css('[id="name-shortstring"]'), text);
    },
    editNodeTitle: function (text) {
        return browser.sendKeys(element.all(by.css('[id="title-shortstring"]')).first(), text);
    },
    getErrorProneEntriesCount: function () {
        return element
            .all(
                by.xpath(
                    '//div[contains(@class, "nav-node-editor-entry-item")]//div[@class="nav-node-editor-entry-item__name"]/span[contains(@class, " error-input")]'
                )
            )
            .count();
    },
    assertNumberOfEntryElements: function (expectedNumber) {
        browser.waitUntil(
            function () {
                return this.getAllEntryNames()
                    .count()
                    .then(function (cnt) {
                        return cnt === expectedNumber;
                    });
            }.bind(this)
        );
        this.getAllEntryNames()
            .count()
            .then(function (cnt) {
                expect(cnt).toEqual(expectedNumber);
            });
    }
};

module.exports = navigationNodeEditor;
