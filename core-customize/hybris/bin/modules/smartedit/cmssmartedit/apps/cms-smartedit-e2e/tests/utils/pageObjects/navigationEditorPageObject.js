/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint unused:false, undef:false */
var navigationEditor = function () {
    this.pageURI =
        'jsTests/tests/cmssmarteditContainer/e2e/features/navigation/navigationEditor/navigationEditorTest.html';
    browser.get(this.pageURI);
};
const MY_CSS = '.angular-ui-tree-nodes .angular-ui-tree-node:nth-child(';
navigationEditor.prototype = {
    totalNodesCount: function () {
        return element.all(by.css('.angular-ui-tree-nodes .angular-ui-tree-node')).count();
    },
    getChildrenNodes: function (key) {
        var index = parseInt(key, 10) + 1;
        return element.all(by.css(`${MY_CSS}${index}) > ol > li`)).count();
    },
    getMoreMenu: function (key) {
        var index = parseInt(key, 10) + 1;
        return element(by.css(`${MY_CSS}${index}) [data-dropdown-menu]`));
    },
    getMoreMenuOptionsCount: function (key) {
        var index = parseInt(key, 10) + 1;
        return element
            .all(by.css(`${MY_CSS}${index}) [data-dropdown-menu] > li:not(.divider)`))
            .count();
    },
    getMoreMenuOptionByText: function (key, text) {
        var index = parseInt(key, 10) + 1;
        var dropDown = element(by.css(`${MY_CSS}${index}) [data-dropdown-menu]`));
        return dropDown.element(by.cssContainingText('li > a', text));
    },
    getNodeName: function (key) {
        var index = parseInt(key, 10) + 1;
        return element(by.css(`${MY_CSS}${index}) > div > span`)).getText();
    }
};

module.exports = navigationEditor;
