/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { browser, by, element } from 'protractor';

describe('MessageComponent', () => {
    beforeEach(async () => {
        await browser.get('smartedit-e2e/generated/e2e/MessageComponent/index.html');
    });

    it('renders component properly', async () => {
        const messageCmp = element(by.css('se-message'));
        await browser.waitForPresence(messageCmp);

        const messageTitle = await messageCmp.element(by.css('.y-message-info-title'));
        const messageDesc = await messageCmp.element(by.css('.y-message-info-description'));

        expect(await messageTitle.getText()).toContain('Message Title');
        expect(await messageDesc.getText()).toContain('Message Description');
    });
});
