/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint unused:false, undef:false */
describe('GenericEditor Media Upload', function () {
    const mediaUploadForm = e2e.componentObjects.MediaUploadForm;

    beforeEach(function () {
        browser.bootstrap(__dirname);
    });

    var path;

    beforeEach(function () {
        require('../commonFunctions.js');
        path = require('path');
    });

    var mediaErrorsSelector = 'se-media-errors';
    var PNG_FILE_PATH = 'more_bckg.png';
    var CLASS_SE_MEDIA_SELECTOR = 'se-media-selector';
    var CLASS_SE_MEDIA_UPLOAD_FORM = 'se-media-upload-form';
    var CSS_INPUT_NAME_CODE = 'input[name="code"]';

    it(
        'GIVEN a Media structure type is present in the Generic Editor ' +
            'WHEN I select an invalid image ' +
            'THEN I expect to see the file errors displayed',
        function () {
            selectFileToUpload('invalid.doc').then(function () {
                expect(getElementByCss(CLASS_SE_MEDIA_SELECTOR).isPresent()).toBe(true);
                expect(getElementByCssContainingText().isPresent()).toBe(true);
                browserWaitFor(CLASS_SE_MEDIA_UPLOAD_FORM);

                browser.waitForPresence(getElementByCss(mediaErrorsSelector));
                expect(getElementByCss(mediaErrorsSelector).getText()).toContain(
                    'se.upload.file.type.invalid'
                );
            });
        }
    );

    describe('GIVEN a Media structure type is present in the generic editor ', function () {
        it(
            'WHEN I select a valid image' + 'THEN I expect to see the media upload form populated',
            function () {
                selectFileToUpload(PNG_FILE_PATH).then(function () {
                    browser.waitUntil(
                        EC.presenceOf(getElementByCss('.se-media-upload-form__file-name')),
                        'Timed out waiting for presence of file name element'
                    );
                    expect(getElementByCss('.se-media-upload-form__file-name').getText()).toBe(
                        PNG_FILE_PATH
                    );
                    browser.waitUntil(
                        EC.presenceOf(getElementByCss(CSS_INPUT_NAME_CODE)),
                        'Timed out waiting for presence of code input element'
                    );
                    expect(getElementByCss(CSS_INPUT_NAME_CODE).getAttribute('value')).toBe(
                        PNG_FILE_PATH
                    );
                    browser.waitUntil(
                        EC.presenceOf(getElementByCss('input[name="description"]')),
                        'Timed out waiting for presence of description input element'
                    );
                    expect(getElementByCss('input[name="description"]').getAttribute('value')).toBe(
                        PNG_FILE_PATH
                    );

                    expect(
                        mediaUploadForm.elements.getField('alt-text').getAttribute('value')
                    ).toBe(PNG_FILE_PATH);
                });
            }
        );

        it(
            'WHEN I select a valid image AND upload with a missing code' +
                'THEN I expect to see a field error for code',
            function () {
                selectFileToUpload(PNG_FILE_PATH)
                    .then(function () {
                        return browser.waitForPresence(getElementByCss(CLASS_SE_MEDIA_UPLOAD_FORM));
                    })
                    .then(function () {
                        return clearCodeField();
                    })
                    .then(function () {
                        return clickUpload();
                    })
                    .then(function () {
                        browserWaitFor(CLASS_SE_MEDIA_SELECTOR);
                        browserWaitForContainingText();
                        browser.waitForPresence(getElementByCss(CLASS_SE_MEDIA_UPLOAD_FORM));

                        browserWaitFor(mediaErrorsSelector);

                        expect(getElementByCss('.upload-field-error--code').getText()).toContain(
                            'se.uploaded.image.code.is.required'
                        );
                    });
            }
        );

        it(
            'WHEN I select a valid image AND upload successfully ' +
                'THEN I expect to see the image selector dropdown with the newly uploaded image',
            function () {
                selectFileToUpload(PNG_FILE_PATH)
                    .then(function () {
                        browserWaitFor(CLASS_SE_MEDIA_SELECTOR);
                        browserWaitForContainingText();
                        expect(getElementByCss(CLASS_SE_MEDIA_UPLOAD_FORM).isPresent()).toBe(true);
                        browserWaitFor(mediaErrorsSelector);

                        return clickUpload();
                    })
                    .then(function () {
                        browser.waitForPresence(by.css(getCssForEnglish(CLASS_SE_MEDIA_SELECTOR)));
                        browserWaitForContainingText();
                        browserWaitFor(CLASS_SE_MEDIA_UPLOAD_FORM);
                        browserWaitFor(mediaErrorsSelector);

                        expect(
                            element(
                                by.css(getCssForEnglish('.se-media-preview__image-thumbnail'))
                            ).getAttribute('src')
                        ).toContain('apps/cms-smartedit-e2e/generated/images/more_bckg.png');
                        expect(
                            element(
                                by.css(getCssForEnglish('.se-media-preview__image-thumbnail'))
                            ).getAttribute('src')
                        ).toContain('apps/cms-smartedit-e2e/generated/images/more_bckg.png');
                    });
            }
        );
    });

    it('GIVEN a media is selected WHEN I click the preview button THEN I expect to see a popover with the image in it.', function () {
        const MY_CSS = '.se-media-preview__image';
        browser.click(by.css(getCssForEnglish('.se-media-preview__icon'))).then(function () {
            browser.waitUntil(EC.visibilityOf(element(by.css(MY_CSS))));
            expect(element(by.css(MY_CSS)).isDisplayed()).toBe(
                true,
                'Exepcted preview image container to be displayed'
            );
            expect(element(by.css(MY_CSS)).getAttribute('src')).toContain(
                'contextualmenu_delete_off.png',
                'Expected preview image to be displayed'
            );
            expect(element(by.css(MY_CSS)).getAttribute('src')).toContain(
                'contextualmenu_delete_off.png',
                'Expected preview image to be displayed'
            );
        });
    });

    it(
        'GIVEN a media is selected ' +
            'WHEN I click the advanced information ' +
            'THEN I expect to see a popover with the alt text, code and description in it.',
        function () {
            browser.click(by.css(getCssForEnglish('.se-media-advanced-info')));
            expect(element(by.css('.advanced-information-description'))).toBeDisplayed();
            expect(element(by.css('.advanced-information-code'))).toBeDisplayed();
            expect(element(by.css('.advanced-information-alt-text'))).toBeDisplayed();
            expectElementToContainText(
                '.advanced-information-description',
                'contextualmenu_delete_off'
            );
            expectElementToContainText('.advanced-information-code', 'contextualmenu_delete_off');
            expectElementToContainText(
                '.advanced-information-alt-text',
                'contextualmenu_delete_off'
            );
        }
    );

    function expectElementToContainText(selector, expectedText) {
        browser.waitUntil(function () {
            return element(by.css(selector))
                .getText()
                .then(
                    function (text) {
                        return text.indexOf(expectedText) >= 0;
                    },
                    function () {
                        return false;
                    }
                );
        }, 'Expected element with selector ' + selector + ' to contain text ' + expectedText);
    }

    function clearCodeField() {
        var keySeries = '';
        for (var i = 0; i < 20; i++) {
            keySeries += protractor.Key.BACK_SPACE;
        }
        return getElementByCss(CSS_INPUT_NAME_CODE).sendKeys(keySeries);
    }

    function clickUpload() {
        return browser.click(by.css(getCssForEnglish('.se-media-upload-btn__submit')));
    }

    function getCssForEnglish(css) {
        return "[tab-id='en'] " + css;
    }

    function getElementByCssContainingText() {
        return element(
            by.cssContainingText(
                getCssForEnglish('se-media-file-selector'),
                'se.upload.image.to.library'
            )
        );
    }

    function browserWaitFor(cssText) {
        browser.waitForAbsence(getElementByCss(cssText));
    }

    function browserWaitForContainingText() {
        browser.waitForAbsence(
            element(
                by.cssContainingText(
                    getCssForEnglish('se-media-file-selector'),
                    'se.upload.image.to.library'
                )
            )
        );
    }

    function getElementByCss(cssText) {
        return element(by.css(getCssForEnglish(cssText)));
    }

    function selectFileToUpload(fileName) {
        return browser
            .click(
                by.css(getCssForEnglish('.se-media-remove-btn')),
                5000,
                'Remove image button not present'
            )
            .then(function () {
                var absolutePath = path.resolve(__dirname, fileName);
                return browser.sendKeys(
                    by.css(getCssForEnglish('input[type="file"]')),
                    absolutePath,
                    'File input element not present after 5000ms'
                );
            });
    }
});
