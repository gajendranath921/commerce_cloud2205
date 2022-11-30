/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
describe('Test Routing', function () {
    const EXPERIENCE_TOOBAR_CSS = '.se-toolbar--experience';
    const CUSTOMVIEW_PATH = '/customView';
    const CUSTOMVIEW2 = 'custom view 2';
    beforeEach(function (done) {
        var page = require('../../utils/components/Page.js');
        var perspectives = require('../../utils/components/Perspectives.js');

        return page.actions
            .getAndWaitForWholeApp('smartedit-e2e/generated/e2e/routing/#!/ng/storefront')
            .then(function () {
                return perspectives.actions
                    .selectPerspective(perspectives.constants.DEFAULT_PERSPECTIVES.ALL)
                    .then(function () {
                        return browser.waitForWholeAppToBeReady();
                    })
                    .then(function () {
                        done();
                    });
            });
    });
    afterEach(function () {
        browser.ignoreSynchronization = false;
    });

    it('navigates to a custom view from the smartedit container', function () {
        expect(element(by.css(EXPERIENCE_TOOBAR_CSS)).isPresent()).toBe(true);
        browser.click(by.id('navigateToJSView')).then(function () {
            expect(browser.getCurrentUrl()).toContain(CUSTOMVIEW_PATH);
            browser.waitForAbsence(element(by.css('se-toolbar-group')));
            expect(element(by.css('.content')).getText()).toBe(CUSTOMVIEW2);
        });
    });

    it('navigates to custom view from the inner smartedit iframe', function () {
        expect(element(by.css(EXPERIENCE_TOOBAR_CSS)).isPresent()).toBe(true);
        browser.switchToIFrame().then(function () {
            browser.click(by.id('navigateToJSViewInner')).then(function () {
                expect(browser.getCurrentUrl()).toContain(CUSTOMVIEW_PATH);
                browser.waitForAbsence(element(by.css(EXPERIENCE_TOOBAR_CSS)));

                browser.switchToParent();
                expect(element(by.css('.content')).getText()).toBe(CUSTOMVIEW2);
            });
        });
    });

    it('navigates to custom view from another view from the container', function () {
        browser.setLocation('smartedit-e2e/generated/e2e/routing/#!/test').then(function () {
            browser.click(by.id('navigateToJSView')).then(function () {
                expect(browser.getCurrentUrl()).toContain(CUSTOMVIEW_PATH);
                expect(element(by.css('.content')).getText()).toBe(CUSTOMVIEW2);
            });
        });
    });

    it('navigates to new view from the custom non smartedit iframe', function () {
        browser.setLocation('smartedit-e2e/generated/e2e/routing/#!/test').then(function () {
            browser.waitForAngularEnabled(false);
            browser.waitUntilNoModal();
            browser.switchToIFrame(false).then(function () {
                browser.click(by.id('navigateToJSViewInner')).then(function () {
                    expect(browser.getCurrentUrl()).toContain(CUSTOMVIEW_PATH);

                    browser.switchToParent();
                    expect(element(by.css('.content')).getText()).toBe(CUSTOMVIEW2);
                });
            });
        });
    });

    it('should navigate to legacy url through shortcut link', function () {
        browser
            .click(by.cssContainingText('.se-shortcut-link__item', 'CustomViewShortcutLink'))
            .then(function () {
                expect(browser.getCurrentUrl()).toContain(CUSTOMVIEW_PATH);
                expect(element(by.css('.content')).getText()).toBe(CUSTOMVIEW2);
            });
    });

    it('should navigate to ng url through shortcut link', function () {
        browser
            .click(by.cssContainingText('.se-shortcut-link__item', 'ng test page link'))
            .then(function () {
                expect(browser.getCurrentUrl()).toContain('/ng/a');
                expect(element(by.css('.content')).getText()).toBe('This is a test page');
            });
    });

    it('navigates to same storefront page from storefront from container', function () {
        browser
            .setLocation('smartedit-e2e/generated/e2e/routing/#!/ng/storefront')
            .then(function () {
                expect(element(by.css('.se-perspective-selector__btn')).getText()).toBe('All');
            });
    });
});
