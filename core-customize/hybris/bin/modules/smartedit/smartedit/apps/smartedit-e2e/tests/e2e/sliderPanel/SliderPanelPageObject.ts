/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { browser, by, element, ElementFinder } from 'protractor';
import { SliderPanelComponentObjects } from '../../utils/components/SliderPanelComponentObjects';

export namespace SliderPanelPageObject {
    export const Elements = {
        getOpenModalButton(): ElementFinder {
            return element(by.css('#button_openModal'));
        },

        getShowSliderPanelButton(): ElementFinder {
            return element(by.css('#button_showSliderPanel'));
        },

        getIsDirtySwitch(): ElementFinder {
            return element(by.css("label[for='isDirtySwitch']"));
        }
    };

    export const Actions = {
        async navigate() {
            await browser.get('smartedit-e2e/generated/e2e/sliderPanel/#!/ng/storefront');
        },
        async clickOnIsDirtySwitch() {
            await browser.waitForPresence(Elements.getIsDirtySwitch());
            await browser.click(Elements.getIsDirtySwitch());
        },

        async showModal() {
            await Elements.getOpenModalButton().click();
        },

        async showSliderPanel() {
            await Actions.showModal();
            await browser.click(Elements.getShowSliderPanelButton(), 'Could not click');
        }
    };

    export const Assertions = {
        async modalSliderPanelIsOverflowing() {
            const scroll = await SliderPanelComponentObjects.Elements.getModalSliderPanelBody().getAttribute(
                'scrollHeight'
            );
            const client = await SliderPanelComponentObjects.Elements.getModalSliderPanelBody().getAttribute(
                'clientHeight'
            );
            expect(Number(scroll)).toBeGreaterThan(Number(client));
        }
    };
}
