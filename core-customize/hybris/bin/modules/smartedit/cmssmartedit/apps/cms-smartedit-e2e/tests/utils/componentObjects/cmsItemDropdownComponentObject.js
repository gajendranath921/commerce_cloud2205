/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint esversion: 6 */

var genericEditorCommons;
var select;
var TEXT_EXPECTED_DROPDOWN = 'Expected dropdown ';
if (typeof require !== 'undefined') {
    genericEditorCommons = require('./commonGenericEditorComponentObject');
    select = require('./SelectComponentObject');
}

module.exports = (function () {
    var componentObject = {};

    componentObject.constants = {
        DROPDOWN_TYPE: {
            SINGLE_SELECT: 'single select',
            MULTI_SELECT: 'multi select'
        }
    };

    componentObject.elements = {
        // -- Common --
        getDropdownByQualifier: function (fieldQualifier) {
            return genericEditorCommons.elements
                .getFieldByQualifier(fieldQualifier)
                .element(by.css('se-cms-component-dropdown'));
        },

        // -- Single Select Dropdown --

        getSelectedItemById: function (fieldQualifier, itemId) {
            const itemSelector = `${select.selectors.selectedOption(
                fieldQualifier
            )} se-cms-dropdown-item [data-component-id="${itemId}"]`;
            return element(by.css(itemSelector));
        },
        getSingleSelectSelectedItemImageById: function (fieldQualifier, itemId) {
            return this.getSelectedItemById(fieldQualifier, itemId)
                .all(by.css('.cms-nested-component__item-icon'))
                .last();
        },
        getSearchBox: function (fieldQualifier) {
            return select.elements.getSearchInput(fieldQualifier);
        },
        getLastFoundSearchBox: function (fieldQualifier) {
            return element.all(by.css(select.selectors.searchInput(fieldQualifier))).last();
        },
        getCreateNewComponentButton: function (fieldQualifier) {
            return this.getDropdownByQualifier(fieldQualifier).element(
                by.css('.se-actionable-search-item__action-btn')
            );
        },
        getComponentSubType: function (componentType) {
            return element(
                by.cssContainingText(
                    'se-sub-type-selector .cms-sub-type__selector-link',
                    componentType
                )
            );
        },

        // -- Multiple Select Dropdown --
        getDropdownLabel: function (fieldQualifier) {
            return this.getDropdownByQualifier(fieldQualifier).element(
                by.css('.se-generic-editor-dropdown')
            );
        },
        getRemoveButton: function (fieldQualifier) {
            return select.elements.getRemoveButton(fieldQualifier);
        },
        getSelectedItemsList: function (fieldQualifier) {
            return this.getDropdownByQualifier(fieldQualifier).all(
                by.css('.select2-choices li.ui-select-match-item se-cms-dropdown-item')
            );
        },
        getMultiSelectSelectedItem: function (fieldQualifier, componentId) {
            return this.getDropdownByQualifier(fieldQualifier).element(
                by.css(
                    '.select2-choices li.ui-select-match-item se-cms-dropdown-item [data-component-id="' +
                        componentId +
                        '"]'
                )
            );
        },
        getSelectedItemRemoveButton: function (fieldQualifier, componentId) {
            // Note: The xPath expression is complicated because it's necessary to check which link has a 'nested-component' with the right id.
            var xPathExpression =
                '//se-cms-dropdown-item/*[@data-component-id="' +
                componentId +
                '"]/../../../span[contains(@class, "selected-item__remove-button")]';
            return this.getDropdownByQualifier(fieldQualifier).element(by.xpath(xPathExpression));
        }
    };

    componentObject.actions = {
        // -- Common --

        // -- Single Select Dropdown --

        openDropdown: function (fieldQualifier, selectType) {
            if (selectType === componentObject.constants.DROPDOWN_TYPE.SINGLE_SELECT) {
                return select.actions.toggleSelector(fieldQualifier);
            } else if (selectType === componentObject.constants.DROPDOWN_TYPE.MULTI_SELECT) {
                return browser.click(
                    componentObject.elements.getLastFoundSearchBox(fieldQualifier)
                );
            }
        },
        searchComponentInDropdown: function (fieldQualifier, selectType, componentNameToSearch) {
            return this.openDropdown(fieldQualifier, selectType).then(function () {
                return componentObject.elements
                    .getLastFoundSearchBox(fieldQualifier)
                    .clear()
                    .sendKeys(componentNameToSearch);
            });
        },
        selectItemInDropdown: function (fieldQualifier, selectType, itemId) {
            return this.openDropdown(fieldQualifier, selectType).then(function () {
                return select.actions.selectOptionByComponentId(fieldQualifier, itemId);
            });
        },
        clickSelectedItem: function (fieldQualifier, itemId) {
            return browser.click(
                componentObject.elements.getSingleSelectSelectedItemImageById(
                    fieldQualifier,
                    itemId
                )
            );
        },
        clickCreateNewComponentButton: function (fieldQualifier) {
            return browser.click(
                componentObject.elements.getCreateNewComponentButton(fieldQualifier)
            );
        },
        selectComponentType: function (componentType) {
            return browser.click(componentObject.elements.getComponentSubType(componentType));
        },
        openNewNestedComponentOfTypeFromDropdown: function (
            fieldQualifier,
            newComponentName,
            componentType
        ) {
            var selectType = componentObject.constants.DROPDOWN_TYPE.SINGLE_SELECT;
            return this.searchComponentInDropdown(
                fieldQualifier,
                selectType,
                newComponentName
            ).then(
                function () {
                    return this.clickCreateNewComponentButton(fieldQualifier).then(
                        function () {
                            return this.selectComponentType(componentType);
                        }.bind(this)
                    );
                }.bind(this)
            );
        },
        openNewNestedComponentFromDropdown: function (fieldQualifier, newComponentName) {
            var selectType = componentObject.constants.DROPDOWN_TYPE.MULTI_SELECT;
            return this.searchComponentInDropdown(
                fieldQualifier,
                selectType,
                newComponentName
            ).then(
                function () {
                    return this.clickCreateNewComponentButton(fieldQualifier);
                }.bind(this)
            );
        },

        // -- Multiple Select Dropdown --
        removeSelectedItemInDropdown: function (fieldQualifier, componentId) {
            return browser.click(
                componentObject.elements.getSelectedItemRemoveButton(fieldQualifier, componentId)
            );
        },

        removeSelectedItem: function (fieldQualifier) {
            this.waitForDebounceToPass();
            return browser.click(componentObject.elements.getRemoveButton(fieldQualifier));
        },

        waitForDebounceToPass: async (timeout) => {
            if (timeout) {
                await browser.sleep(timeout);
            } else {
                await browser.sleep(1000);
            }
        }
    };

    componentObject.assertions = {
        // -- Common --
        isEmpty: function (fieldQualifier, selectType) {
            selectType = selectType
                ? selectType
                : componentObject.constants.DROPDOWN_TYPE.SINGLE_SELECT;

            if (selectType === componentObject.constants.DROPDOWN_TYPE.SINGLE_SELECT) {
                expect(select.assertions.isNotSelected(fieldQualifier)).toBe(
                    true,
                    `${TEXT_EXPECTED_DROPDOWN}${fieldQualifier} to be empty`
                );
            } else {
                expect(componentObject.elements.getSelectedItemsList(fieldQualifier).count()).toBe(
                    0,
                    `${TEXT_EXPECTED_DROPDOWN}${fieldQualifier} to be empty`
                );
            }
        },
        isNotEmpty: function (fieldQualifier, selectType) {
            selectType = selectType
                ? selectType
                : componentObject.constants.DROPDOWN_TYPE.SINGLE_SELECT;

            if (selectType === componentObject.constants.DROPDOWN_TYPE.SINGLE_SELECT) {
                expect(
                    browser.isAbsent(select.elements.getSelectedPlaceholder(fieldQualifier))
                ).toBe(true, `${TEXT_EXPECTED_DROPDOWN}${fieldQualifier} to be empty`);
            } else {
                expect(select.elements.getAllSelectedOptions(fieldQualifier).count()).not.toBe(
                    0,
                    `${TEXT_EXPECTED_DROPDOWN}${fieldQualifier} to be empty`
                );
            }
        },
        hasRemoveButton: function (fieldQualifier) {
            return browser.isPresent(componentObject.elements.getRemoveButton(fieldQualifier));
        },
        itemIsSelected: function (fieldQualifier, selectType, itemId) {
            if (selectType === componentObject.constants.DROPDOWN_TYPE.SINGLE_SELECT) {
                expect(
                    componentObject.elements.getSelectedItemById(fieldQualifier, itemId).isPresent()
                ).toBe(true, 'Expected item ' + itemId + ' to be selected');
            }
        }

        // -- Single Select Dropdown --

        // -- Multiple Select Dropdown --
    };

    componentObject.utils = {};

    return componentObject;
})();
