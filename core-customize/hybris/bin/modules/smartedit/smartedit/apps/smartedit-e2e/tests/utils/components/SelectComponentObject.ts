/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import {
    browser,
    by,
    element,
    ElementArrayFinder,
    ElementFinder,
    Key,
    WebElement
} from 'protractor';

export namespace SelectComponentObject {
    export const Constants = {
        VALIDATION_MESSAGE_TYPE: {
            VALIDATION_ERROR: 'has-error',
            WARNING: 'has-warning'
        }
    };

    export const Elements = {
        getComponent: (hostId: string): ElementFinder => {
            return element(by.css(`se-select#${hostId}`));
        },
        getDropdown: (hostId: string): ElementFinder => {
            return Elements.getComponent(hostId).element(by.css('.fd-menu'));
        },
        getSelectorContainer: (hostId: string): ElementFinder => {
            return Elements.getComponent(hostId).element(by.id(hostId + '-selector'));
        },
        getSelectorContainerByClassName: (hostId: string, className: string): ElementFinder => {
            return Elements.getComponent(hostId).element(
                by.css(`#${hostId}-selector.${className}`)
            );
        },
        getSingleDropdownToggle: (hostId: string): ElementFinder => {
            return Elements.getComponent(hostId).element(by.css('.toggle-button'));
        },
        getMultiDropdownToggle: (hostId: string): ElementFinder => {
            return Elements.getComponent(hostId).element(by.css('.search__input'));
        },
        getOptionByText: (hostId: string, text: string): ElementFinder => {
            return Elements.getComponent(hostId).element(
                by.cssContainingText('.menu-option', text)
            );
        },
        getOptionByIndex: (hostId: string, index: number): ElementFinder => {
            return Elements.getAllOptions(hostId).get(index);
        },
        getAllOptions: (hostId: string): ElementArrayFinder => {
            return Elements.getComponent(hostId).all(by.css('.se-select-list__item'));
        },
        getAllSelectedOptions: (hostId: string): ElementArrayFinder => {
            return Elements.getComponent(hostId).all(
                by.css('.selected-container .se-item-printer')
            );
        },
        getAllRemoveButtons: (hostId: string): ElementArrayFinder => {
            return Elements.getComponent(hostId).all(
                by.css('.selected-container .se-item-printer .selected-item__remove-button')
            );
        },
        getSelectedOptionByText: (hostId: string, text: string): ElementFinder => {
            return Elements.getComponent(hostId).element(
                by.cssContainingText('.selected-item', text)
            );
        },
        getSelectedOptionByIndex: (hostId: string, index: number): ElementFinder => {
            return Elements.getAllSelectedOptions(hostId).get(index);
        },
        getSelectedRemoveButtonByIndex: (hostId: string, index: number): ElementFinder => {
            return Elements.getAllRemoveButtons(hostId).get(index);
        },
        getRemoveSelectedOptionButtonByText: (hostId: string, text: string): ElementFinder => {
            return Elements.getSelectedOptionByText(hostId, text).element(
                by.css('.selected-item__remove-button')
            );
        },
        getSelectedPlaceholder: (hostId: string): ElementFinder => {
            return Elements.getComponent(hostId).element(by.css('.selected-placeholder'));
        },
        getSearchInput: (hostId: string): ElementFinder => {
            return Elements.getComponent(hostId).element(by.css('.search__input'));
        },
        getSearchInputPlaceholderByText: (hostId: string, text: string): ElementFinder => {
            return Elements.getComponent(hostId).element(
                by.css(`.search__input[placeholder="${text}"]`)
            );
        },
        getResultsHeader: (hostId: string): ElementFinder => {
            return Elements.getComponent(hostId).element(by.css('.results-header'));
        },
        getActionableSearchItemActionButton: (hostId: string): ElementFinder => {
            return Elements.getComponent(hostId).element(
                by.css('.se-actionable-search-item__action-btn')
            );
        },
        getScrollContainer: (hostId: string): ElementFinder => {
            return Elements.getComponent(hostId).element(
                by.css('.se-infinite-scrolling__container')
            );
        }
    };

    export const Actions = {
        toggleSingleSelector: async (hostId: string): Promise<void> => {
            await browser.click(
                Elements.getSingleDropdownToggle(hostId),
                `Could not click on dropdown with id=${hostId}`
            );
        },
        toggleMultiSelector: async (hostId: string): Promise<void> => {
            await browser.click(
                Elements.getMultiDropdownToggle(hostId),
                `Could not click on dropdown with id=${hostId}`
            );
        },
        selectOptionByText: async (hostId: string, text: string): Promise<void> => {
            await browser.click(
                Elements.getOptionByText(hostId, text),
                `Could not click on dropdown option with text=${text}`
            );
        },
        removeSelectedOptionByText: async (hostId: string, text: string): Promise<void> => {
            await browser.click(Elements.getRemoveSelectedOptionButtonByText(hostId, text));
        },
        clickActionableSearchItemActionButton: async (hostId: string): Promise<void> => {
            await browser.click(Elements.getActionableSearchItemActionButton(hostId));
        },
        setSearchInputValue: async (hostId: string, text: string): Promise<void> => {
            await browser.sendKeys(Elements.getSearchInput(hostId), text);
        },
        clearAndsetSearchInputValue: async (hostId: string, text: string): Promise<void> => {
            const searchInput = Elements.getSearchInput(hostId);
            const currentText = await searchInput.getAttribute('value');
            await searchInput.sendKeys(Key.chord(Key.CONTROL, 'a'));
            const currentTextLen = currentText.length;

            for (let i = 0; i < currentTextLen; i++) {
                await searchInput.sendKeys(Key.BACK_SPACE);
            }

            await SelectComponentObject.Actions.setSearchInputValue(hostId, text);
        },
        scrollToBottom: async (hostId: string): Promise<void> => {
            const dropdown = await Elements.getScrollContainer(hostId);
            await browser.scrollToBottom(dropdown);
        },
        arrowUp: async (): Promise<void> => {
            await browser.actions().sendKeys(Key.ARROW_UP).perform();
        },
        arrowDown: async (): Promise<void> => {
            await browser.actions().sendKeys(Key.ARROW_DOWN).perform();
        },
        enter: async (): Promise<void> => {
            await browser.actions().sendKeys(Key.ENTER).perform();
        },
        esc: async (): Promise<void> => {
            await browser.actions().sendKeys(Key.ESCAPE).perform();
        }
    };

    export const Assertions = {
        selectorHasValidationType: async (
            hostId: string,
            validationMessageType: string
        ): Promise<void> => {
            await browser.waitForPresence(
                Elements.getSelectorContainerByClassName(hostId, validationMessageType)
            );
        },
        selectorHasNoValidationType: async (hostId: string): Promise<void> => {
            const classNames = await Elements.getSelectorContainer(hostId).getAttribute('class');
            const classRegexp = new RegExp(
                '(' +
                    SelectComponentObject.Constants.VALIDATION_MESSAGE_TYPE.VALIDATION_ERROR +
                    '|' +
                    SelectComponentObject.Constants.VALIDATION_MESSAGE_TYPE.WARNING +
                    ')',
                'g'
            );

            expect(!classNames.match(classRegexp)).toBeTruthy();
        },
        multiSelectorHasSelectedOptionsEqualTo: async (
            hostId: string,
            expectedOptions: string[]
        ): Promise<void> => {
            const multiSelectors = await Elements.getAllSelectedOptions(hostId).getWebElements();

            await Assertions.webElementsHasExpectedOptions(multiSelectors, expectedOptions);
        },
        selectorContainsListOfOptions: async (
            hostId: string,
            expectedOptions: string[]
        ): Promise<void> => {
            await browser.waitUntil(async () => {
                const actualOptions = await Elements.getAllOptions(hostId).map<string>(
                    async (item) => {
                        let text: string;
                        try {
                            text = await item.getText();
                        } catch (err) {
                            text = '';
                        }
                        return text;
                    }
                );
                return actualOptions.join(',') === expectedOptions.join(',');
            }, `Expected dropdown options for ${hostId} to be ${expectedOptions}`);
        },
        webElementsHasExpectedOptions: async (
            elements: WebElement[],
            expectedOptions: string[]
        ): Promise<void> => {
            const whenOptions = elements.map(async (ele) => await ele.getText());
            const options = await Promise.all(whenOptions);

            expect(options).toEqual(expectedOptions);
        },
        optionContainsTextByIndex: async (
            hostId: string,
            expectedText: string,
            index: number
        ): Promise<void> => {
            const whenOption = Elements.getOptionByIndex(hostId, index);
            await browser.waitForPresence(whenOption, `Failed to find option with index=${index}`);

            const actual = await whenOption.getText();

            expect(actual).toContain(expectedText);
        },
        selectedOptionContainsTextByIndex: async (
            hostId: string,
            expectedText: string,
            index: number
        ): Promise<void> => {
            const whenOption = Elements.getSelectedOptionByIndex(hostId, index);
            await browser.waitForPresence(whenOption);

            const actual = await whenOption.getText();

            expect(actual).toContain(expectedText, `Selected site doesn't match expected one.`);
        },
        dropdownIsEmpty: async (hostId: string): Promise<void> => {
            const count = await Elements.getAllOptions(hostId).count();

            expect(count).toBe(0);
        },
        dropdownIsClosed: async (hostId: string): Promise<void> => {
            await browser.waitForAbsence(Elements.getDropdown(hostId));
        },
        dropdownIsOpened: async (hostId: string): Promise<void> => {
            await browser.waitForPresence(
                Elements.getDropdown(hostId),
                `Failed to find dropdown with id=${hostId}`
            );
        },
        selectedPlaceholderIsDisplayed: async (hostId: string): Promise<void> => {
            await browser.waitForPresence(Elements.getSelectedPlaceholder(hostId));
        },
        resultsHeaderContainsText: async (hostId: string, expectedText: string): Promise<void> => {
            await browser.waitForSelectorToContainText(
                Elements.getResultsHeader(hostId),
                expectedText
            );
        },
        searchInputPlaceholderIsEqualToText: async (
            hostId: string,
            expectedText: string
        ): Promise<void> => {
            await browser.waitForPresence(
                Elements.getSearchInputPlaceholderByText(hostId, expectedText)
            );
        },
        searchInputIsPresent: async (hostId: string): Promise<void> => {
            await browser.waitForPresence(Elements.getSearchInput(hostId));
        },
        searchInputIsNotPresent: async (hostId: string): Promise<void> => {
            await browser.waitForAbsence(Elements.getSearchInput(hostId));
        },
        actionableSearchItemActionButtonIsDisplayed: async (hostId: string): Promise<void> => {
            await browser.waitForPresence(Elements.getActionableSearchItemActionButton(hostId));
        },
        dropdownNotClickable: async (hostId: string): Promise<void> => {
            await browser.elementNotClickable(Elements.getSingleDropdownToggle(hostId));
        },
        searchInputNotClickable: async (hostId: string): Promise<void> => {
            await browser.elementNotClickable(Elements.getSearchInput(hostId));
        },
        selectOptionIsSelectedByText: async (
            hostId: string,
            expectedText: string
        ): Promise<void> => {
            const whenParent = Elements.getOptionByText(hostId, expectedText).element(
                by.xpath('..')
            );
            await browser.waitForPresence(whenParent);

            (expect(whenParent) as any).toContainClass('is-selected');

            return Promise.resolve();
        },
        searchInputValueIsEqualTo: async (hostId: string, expectedText: string): Promise<void> => {
            const whenInput = Elements.getSearchInput(hostId);
            await browser.waitForPresence(whenInput);

            const actual = await whenInput.getAttribute('value');
            expect(actual).toBe(expectedText);
        },
        selectedOptionNotClickableByIndex: async (hostId: string, index: number): Promise<void> => {
            await browser.elementNotClickable(
                Elements.getSelectedRemoveButtonByIndex(hostId, index)
            );
        },
        optionNotInDropdownByText: async (hostId: string, text: string): Promise<void> => {
            await browser.waitForAbsence(Elements.getOptionByText(hostId, text));
        },
        optionIsActiveByIndex: async (hostId: string, index: number): Promise<void> => {
            const whenElement = Elements.getOptionByIndex(hostId, index);
            await browser.waitForPresence(whenElement, `failed to find option by index: ${index}`);

            const className = await whenElement.getAttribute('class');
            expect(className).toContain('is-active');
        }
    };
}
