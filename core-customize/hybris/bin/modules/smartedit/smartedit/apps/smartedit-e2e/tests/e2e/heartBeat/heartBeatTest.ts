/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { browser } from 'protractor';
import { AlertsComponentObject } from '../../utils/components/AlertsComponentObject';
import { Page } from '../../utils/components/Page';
import { Perspectives } from '../../utils/components/Perspectives';

describe('Storefront FrontEnd <-> SmartEdit FrontEnd connectivity E2E', () => {
    const storfrontentUrl =
        'smartedit-e2e/generated/e2e/heartBeat/reconnectingHeartBeatMocks/#!/ng/storefront';
    beforeEach(async () => {
        await Page.Actions.getAndWaitForWholeApp(storfrontentUrl);
    });
    it('shows info popup when storefront is not sending a heartbeat and provides a link to switch to preview mode', async () => {
        await browser.waitForAngularEnabled(false);
        await browser.waitUntilNoModal();

        await AlertsComponentObject.Assertions.assertAlertMessageByIndex(0, 'Heart beat failed');
        await AlertsComponentObject.Assertions.assertAlertMessageLinkByIndex(0, 'Preview mode');

        await AlertsComponentObject.Actions.clickOnLinkInAlertByIndex(0);
        await Perspectives.Assertions.assertPerspectiveSelectorButtonIsDisabled();

        await Perspectives.Assertions.assertPerspectiveSelectorToolTipIsPresent();
    });

    it('shows info popup when storefront is responding after unresponsive period', async () => {
        await browser.waitForAngularEnabled(false);
        await Page.Actions.getAndWaitForWholeApp(storfrontentUrl);
        await browser.waitUntilNoModal();

        const expected = new RegExp('Heart beat reconnected', 'i');

        await browser.waitUntil(async () => {
            const text = await browser
                .findElement(AlertsComponentObject.Elements.alertByIndex(0))
                .getText();

            return expected.test(text);
        }, "was expecting to see an alert with text: 'Heart beat reconnected'");
    });

    it('shows info popup to switch to preview mode when there is no web application injector in storefront', async () => {
        await browser.waitForAngularEnabled(false);
        await Page.Actions.getAndWaitForWholeApp(storfrontentUrl);

        await AlertsComponentObject.Assertions.assertAlertMessageByIndex(0, 'Heart beat failed');
        await AlertsComponentObject.Assertions.assertAlertMessageLinkByIndex(0, 'Preview mode');
        browser.sleep(1000);

        await AlertsComponentObject.Actions.clickOnLinkInAlertByIndex(0);
        await Perspectives.Assertions.assertPerspectiveSelectorButtonIsDisabled();

        await Perspectives.Assertions.assertPerspectiveSelectorToolTipIsPresent();
    });
});
