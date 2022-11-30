/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { browser, by, element, ElementFinder } from 'protractor';

export namespace MoreTextPageObject {
    const Constants = {
        BUTTON_ID: 'y-more-text-toggle',
        TEXT_PAYLOAD_ID: 'y-more-text-payload'
    };

    export const Elements = {
        getMoreTextById(componentId: string): ElementFinder {
            return element(by.css('#' + componentId));
        },
        getButton(componentId: string): ElementFinder {
            const el = Elements.getMoreTextById(componentId);
            return el.element(by.css('#' + Constants.BUTTON_ID));
        },
        async getComponentText(componentId: string): Promise<string> {
            const el = Elements.getMoreTextById(componentId);
            return await el.element(by.css('#' + Constants.TEXT_PAYLOAD_ID)).getText();
        },
        async getButtonTitle(componentId: string): Promise<string> {
            return await Elements.getButton(componentId).getText();
        }
    };

    export const Actions = {
        async openAndBeReady(): Promise<void> {
            await browser.get('smartedit-e2e/generated/e2e/moreText/#!/ng/storefront');
            await browser.waitForContainerToBeReady();
        },

        async clickOnButton(componentId: string): Promise<void> {
            await browser.click(Elements.getButton(componentId));
        }
    };

    export const Assertions = {
        async assertComponentContainsText(componentId: string, text: string): Promise<void> {
            await browser.waitForSelectorToContainText(
                Elements.getMoreTextById(componentId).element(
                    by.css(`#${Constants.TEXT_PAYLOAD_ID}`)
                ),
                text
            );
        },
        async assertButtonContainsTitle(componentId: string, title: string): Promise<void> {
            await browser.waitForSelectorToContainText(Elements.getButton(componentId), title);
        },
        async assertButtonIsAbsent(componentId: string): Promise<void> {
            await browser.isAbsent(Elements.getButton(componentId));
        }
    };
}
