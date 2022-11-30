/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { browser, by, element, ElementFinder } from 'protractor';

export namespace AlertsTestPageObject {
    export const Elements = {
        showButton(): ElementFinder {
            return element(by.css('#test-alert-add-button'));
        },
        resetButton(): ElementFinder {
            return element(by.css('#test-alert-reset-button'));
        },
        alertMessage(): ElementFinder {
            return element(by.css('#test-alert-message'));
        },
        alertMessagePlaceholders(): ElementFinder {
            return element(by.css('#test-alert-message-placeholder'));
        },
        alertType(type: string): ElementFinder {
            return element(by.css(`#test-alert-type option[value="${type || 'information'}"]`));
        },
        alertCloseable(): ElementFinder {
            return element(by.css('#test-alert-closeable'));
        },
        alertTimeout(): ElementFinder {
            return element(by.css('#test-alert-timeout'));
        },
        alertController(): ElementFinder {
            return element(by.css('#test-alert-controller'));
        }
    };

    export const Actions = {
        async navigate(): Promise<void> {
            await browser.get('smartedit-e2e/generated/e2e/alerts/#!/ng');
            await browser.waitForContainerToBeReady();

            /**
             * Don't wait below: container looks for toolbars, but this setup doesn't load them
             */
        },

        async setMessage(message: string): Promise<void> {
            await browser.sendKeys(Elements.alertMessage(), message);
        },

        async setMessagePlaceholders(messagePlaceholders: string): Promise<void> {
            await browser.sendKeys(Elements.alertMessagePlaceholders(), messagePlaceholders);
        },

        async setType(type: string): Promise<void> {
            await browser.click(Elements.alertType(type));
        },

        async setTimeout(millis: number): Promise<void> {
            await browser.sendKeys(Elements.alertTimeout(), millis);
        },

        async setCloseable(closeable: boolean): Promise<void> {
            const isSelected = await Elements.alertCloseable().isSelected();

            if (closeable !== isSelected) {
                await browser.click(Elements.alertCloseable());
            }
        },

        async clickShowAlert(): Promise<void> {
            await browser.click(Elements.showButton());
        },

        async resetForm(): Promise<void> {
            await browser.waitUntilNoModal();
            await browser.click(Elements.resetButton());
        },

        async showAlert(config: {
            message?: string;
            messagePlaceholders?: string;
            type?: string;
            closeable?: boolean;
            timeout?: number;
        }) {
            await Actions.resetForm();
            if (config.message) {
                await Actions.setMessage(config.message);
            }
            if (config.messagePlaceholders) {
                await Actions.setMessagePlaceholders(config.messagePlaceholders);
            }
            if (config.type) {
                await Actions.setType(config.type);
            }
            if (typeof config.closeable === 'boolean') {
                await Actions.setCloseable(config.closeable);
            }
            if (config.timeout) {
                await Actions.setTimeout(config.timeout);
            }

            await Actions.clickShowAlert();
            await browser.sleep(500);
        }
    };
}
