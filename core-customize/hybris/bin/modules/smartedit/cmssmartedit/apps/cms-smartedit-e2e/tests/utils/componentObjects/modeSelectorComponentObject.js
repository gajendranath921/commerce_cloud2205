/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
const SELECTOR1 = '.se-perspective-selector__btn';
const SELECTOR2 = '.se-perspective-selector';
module.exports = (function () {
    var componentObject = {
        PREVIEW_PERSPECTIVE: 'PREVIEW',
        VERSIONING_PERSPECTIVE: 'VERSIONING',
        ADVANCED_CMS_PERSPECTIVE: 'Advanced CMS',
        BASIC_CMS_PERSPECTIVE: 'Basic CMS',
        OVERLAY_SELECTOR: '#smarteditoverlay',

        modeSelectorBtn: function () {
            return element(by.css(SELECTOR1));
        },

        select: function (perspectiveName) {
            function generateSelectPromise(perspectiveSelected) {
                if (perspectiveSelected.toUpperCase() === perspectiveName.toUpperCase()) {
                    browser.waitForWholeAppToBeReady();
                    return browser.switchToIFrame().then(
                        function () {
                            return perspectiveName === this.PREVIEW_PERSPECTIVE
                                ? true
                                : browser.waitForVisibility(this.OVERLAY_SELECTOR);
                        }.bind(this)
                    );
                }

                browser.waitForWholeAppToBeReady();
                browser.waitForVisibility(SELECTOR2);
                return browser
                    .click(browser.findElement(by.css(SELECTOR2)), true)
                    .then(
                        function () {
                            var element = browser.findElement(
                                by.cssContainingText('.se-perspective__list-item', perspectiveName),
                                true
                            );
                            var description = `perspective ${perspectiveName} is not clickable`;
                            return browser.click(element, description);
                        }.bind(this)
                    )
                    .then(
                        function () {
                            return browser.waitForContainerToBeReady();
                        }.bind(this)
                    )
                    .then(
                        function () {
                            return browser.switchToIFrame();
                        }.bind(this)
                    )
                    .then(
                        function () {
                            return perspectiveName === this.PREVIEW_PERSPECTIVE
                                ? true
                                : browser.waitForVisibility(this.OVERLAY_SELECTOR);
                        }.bind(this)
                    );
            }

            return browser
                .waitUntilNoModal()
                .then(
                    function () {
                        return browser.switchToParent();
                    }.bind(this)
                )
                .then(
                    function () {
                        return browser.findElement(by.css(SELECTOR1), true).getText();
                    }.bind(this)
                )
                .then(
                    function (perspectiveSelected) {
                        return generateSelectPromise.apply(this, [perspectiveSelected]);
                    }.bind(this)
                )
                .then(
                    function () {
                        return browser.switchToParent();
                    }.bind(this)
                );
        },

        selectPreviewPerspective: function () {
            return this.select(this.PREVIEW_PERSPECTIVE);
        },

        selectVersioningPerspective: function () {
            return this.select(this.VERSIONING_PERSPECTIVE);
        },

        selectBasicPerspective: function () {
            return this.select(this.BASIC_CMS_PERSPECTIVE);
        },

        selectAdvancedPerspective: function () {
            return this.select(this.ADVANCED_CMS_PERSPECTIVE);
        },

        actions: {
            openPerspectiveList: function () {
                return browser.click(browser.findElement(by.css(SELECTOR2)));
            }
        },

        elements: {
            getSelectedModeName: function () {
                return browser.findElement(by.css(SELECTOR1)).getText();
            },
            getPerspectiveModeByName: function (perspectiveName) {
                return element(
                    by.cssContainingText('.se-perspective__list-item-text', perspectiveName)
                );
            }
        },

        assertions: {
            expectedModeIsSelected: function (perspectiveName) {
                expect(componentObject.elements.getSelectedModeName()).toBe(
                    perspectiveName,
                    'Expected current mode (perspective) name to be ' + perspectiveName
                );
            },
            expectVersioningModeIsAbsent: function () {
                expect(
                    componentObject.elements.getPerspectiveModeByName(
                        componentObject.VERSIONING_PERSPECTIVE
                    )
                ).toBeAbsent();
            },
            expectVersioningModeIsPresent: function () {
                expect(
                    componentObject.elements.getPerspectiveModeByName(
                        componentObject.VERSIONING_PERSPECTIVE
                    )
                ).toBeDisplayed();
            }
        }
    };

    return componentObject;
})();
