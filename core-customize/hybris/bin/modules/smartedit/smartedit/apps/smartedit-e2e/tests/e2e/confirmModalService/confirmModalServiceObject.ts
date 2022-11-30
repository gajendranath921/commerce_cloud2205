/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { browser, by, element, ElementFinder } from 'protractor';

export namespace ConfirmModalServiceObject {
    export const Elements = {
        getModal(): ElementFinder {
            return element(by.css('.se-confirmation-dialog'));
        },

        getTriggerButton(): ElementFinder {
            return element(by.css(`#confirmation-modal-trigger`));
        },

        getModalTitle(text: string): ElementFinder {
            return element(by.cssContainingText('.fd-modal__title', text));
        },

        getModalBody(text: string): ElementFinder {
            return element(by.cssContainingText('.fd-modal__body', text));
        },

        getCancelButton(): ElementFinder {
            return element(by.id('confirmCancel'));
        },

        getConfirmButton(): ElementFinder {
            return element(by.id('confirmOk'));
        }
    };

    export const Actions = {
        async clickTriggerButton(): Promise<void> {
            await browser.click(Elements.getTriggerButton());
        },

        async navigateToTestPage(): Promise<void> {
            await browser.get('smartedit-e2e/generated/e2e/confirmModalService/#!/ng/storefront');
        },

        async clickCancel(): Promise<void> {
            await browser.click(Elements.getCancelButton());
        },

        async clickConfirm(): Promise<void> {
            await browser.click(Elements.getConfirmButton());
        }
    };

    export const Assertions = {
        async modalIsPresent(): Promise<void> {
            await browser.waitForPresence(Elements.getModal());
        },

        async modalHasCorrectTitle(text: string): Promise<void> {
            await browser.waitForPresence(Elements.getModalTitle(text));
        },

        async modalHasCorrectBody(text: string): Promise<void> {
            await browser.waitForPresence(Elements.getModalBody(text));
        }
    };
}
