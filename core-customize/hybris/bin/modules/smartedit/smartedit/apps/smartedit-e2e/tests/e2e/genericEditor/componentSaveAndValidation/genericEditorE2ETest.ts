/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { browser, by, element } from 'protractor';
import { CommonFunctions } from '../commonFunctions';

describe('GenericEditor form save and validation', () => {
    beforeEach(async () => {
        await browser.driver.manage().timeouts().implicitlyWait(0);
        await browser.get(
            'smartedit-e2e/generated/e2e/genericEditor/componentSaveAndValidation/#!/ng'
        );
    });

    it('will display cancel button and not display submit button by default', async () => {
        await browser.waitForAbsence(element(by.id('cancel')));
        await browser.waitForAbsence(element(by.id('submit')));
    });

    it('will display cancel and submit buttons when component attribute is modified', async () => {
        await browser.waitForPresence(element(by.name('headline')));
        await element(by.name('headline')).sendKeys('I have changed');

        await browser.waitForPresence(element(by.id('cancel')));
        await browser.waitForPresence(element(by.id('submit')));
    });

    describe('Headline with two validation error', function () {
        beforeEach(async () => {
            await browser.waitForPresence(element(by.name('headline')));
            await element(by.name('headline')).clear();
            await element(by.name('headline')).sendKeys(
                'I have changed to an invalid headline with two validation errors, % and lots of text'
            );
            await CommonFunctions.clickSubmit();
        });

        it('will display validation errors for headline when headline is modified and saved', async () => {
            const elements = CommonFunctions.getValidationErrorElements('headline');
            expect(await elements.count()).toBe(2);
        });

        it('will display 2 validation errors, then on second save will display 1 validation error for headline', async () => {
            expect(await CommonFunctions.getValidationErrorElements('headline').count()).toBe(2);

            await browser.waitForPresence(element(by.name('headline')));
            await element(by.name('headline')).clear();
            await element(by.name('headline')).sendKeys(
                'I have changed to an invalid headline with one validation error, %'
            );
            await CommonFunctions.clickSubmit();

            expect(await CommonFunctions.getValidationErrorElements('headline').count()).toBe(1);
        });

        it('will remove validation errors when reset is clicked after contents are modified and saved', async () => {
            expect(await CommonFunctions.getValidationErrorElements('headline').count()).toBe(2);

            await browser.click(by.id('cancel'));

            expect(await CommonFunctions.getValidationErrorElements('headline').count()).toBe(0);
        });
    });

    // validation errors of localized fields could be moved to genericEditor_3.features.localizedElements
    it("will display a validation error for only 'en' and 'it' tab for content when content of 'en' and 'it' tab's are modified and saved", async () => {
        await CommonFunctions.switchToIframeForRichTextAndAddContent(
            '#cke_1_contents iframe',
            'I have changed to an invalid content with one validation error'
        );
        await browser.switchToParent();
        await CommonFunctions.selectLocalizedTab('it', 'content', false);
        await CommonFunctions.switchToIframeForRichTextAndAddContent(
            '#cke_3_contents iframe',
            'Ho cambiato ad un contenuto non valido con un errore di validazione'
        );
        await browser.switchToParent();
        await CommonFunctions.clickSubmit();
        await CommonFunctions.selectLocalizedTab('en', 'content', false);

        expect(
            await CommonFunctions.getValidationErrorElementByLanguage('content', 'en').getText()
        ).toEqual('This field is required and must to be between 1 and 255 characters long.');

        await CommonFunctions.selectLocalizedTab('it', 'content', false);
        expect(
            await CommonFunctions.getValidationErrorElementByLanguage('content', 'it').getText()
        ).toEqual('This field is required and must to be between 1 and 255 characters long.');

        await CommonFunctions.selectLocalizedTab('fr', 'content', false);
        await browser.waitForAbsence(
            CommonFunctions.getValidationErrorElementByLanguage('content', 'fr')
        );

        await CommonFunctions.selectLocalizedTab('pl', 'content', false);
        await browser.waitForAbsence(
            CommonFunctions.getValidationErrorElementByLanguage('content', 'pl')
        );

        await CommonFunctions.selectLocalizedTab('hi', 'content', false);
        await browser.waitForAbsence(
            CommonFunctions.getValidationErrorElementByLanguage('content', 'hi')
        );
    });

    it('will display no validation errors when submit is clicked and when API returns a field that does not exist', async () => {
        await browser.waitForPresence(element(by.name('headline')));
        await element(by.name('headline')).clear();
        await element(by.name('headline')).sendKeys('Checking unknown type');

        await CommonFunctions.clickSubmit();

        await browser.waitForAbsence(element(by.css("[id^='validation-error']")));
    });
});
