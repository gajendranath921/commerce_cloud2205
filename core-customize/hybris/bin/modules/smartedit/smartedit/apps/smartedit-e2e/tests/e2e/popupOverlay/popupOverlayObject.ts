/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { browser, by, element, ElementFinder } from 'protractor';

export namespace PopupOverlayObject {
    export const Elements = {
        getPopupOverlayAnchor(): ElementFinder {
            return element(by.css(`#angularPopup #anchor`));
        },

        getPopup(text: string): ElementFinder {
            return element(by.cssContainingText('#popup', text));
        },

        getAngularRadioButton(): ElementFinder {
            return element(by.css('#type-angular'));
        },

        getTriggerClickRadioButton(): ElementFinder {
            return element(by.css('#trigger-click'));
        },

        getTriggerAlwaysDisplayedButton(): ElementFinder {
            return element(by.css('#trigger-displayed'));
        },

        getTriggerHoverButton(): ElementFinder {
            return element(by.css('#trigger-hover'));
        },

        getTriggerAlwaysHiddenButton(): ElementFinder {
            return element(by.css('#trigger-hidden'));
        },
        getMessage(text: string): ElementFinder {
            return element(by.cssContainingText('#message', text));
        }
    };

    export const Actions = {
        async navigate(): Promise<void> {
            await browser.get('smartedit-e2e/generated/e2e/popupOverlay/#!/ng/storefront');
            await browser.waitUntilNoModal();
        },

        async clickPopupOverlayAnchor(): Promise<void> {
            await browser.click(Elements.getPopupOverlayAnchor());
        },

        async setTriggerToAlwaysDisplayed(): Promise<void> {
            await browser.click(Elements.getTriggerAlwaysDisplayedButton());
        },

        async setTriggerToAlwaysHidden(): Promise<void> {
            await browser.click(Elements.getTriggerAlwaysHiddenButton());
        },

        async setTriggerToClick(): Promise<void> {
            await browser.click(Elements.getTriggerClickRadioButton());
        },

        async setTriggerToHover(): Promise<void> {
            await browser.click(Elements.getTriggerHoverButton());
        },

        async hoverOverAnchor(): Promise<void> {
            await browser.actions().mouseMove(Elements.getPopupOverlayAnchor()).perform();
        },

        async hoverAwayAnchor(): Promise<void> {
            await browser
                .actions()
                .mouseMove(Elements.getPopupOverlayAnchor(), { x: -100, y: 0 })
                .perform();
        }
    };

    export const Assertions = {
        async popupIsPresent(text: string): Promise<void> {
            await browser.waitForPresence(Elements.getPopup(text));
        },

        async popupIsAbsent(text: string): Promise<void> {
            await browser.waitForAbsence(Elements.getPopup(text));
        },

        async messageIsDisplayed(text: string): Promise<void> {
            await browser.waitForPresence(Elements.getMessage(text));
        }
    };
}
