/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/**
 * @ngdoc overview
 * @name DecoratorsModule
 * @description
 * Wires dummy decorators to dummy components provided in the dummy storefront.
 */
/* jshint esversion: 6 */
const TEXT_TEMPLATE_URL = 'textDisplayDecoratorTemplate.html';
const BUTTON_TEMPLATE_URL = 'buttonDisplayDecoratorTemplate.html';

angular
    .module('DummyDecoratorsModule', [
        'textDisplayDecorator',
        'slotTextDisplayDecorator',
        'buttonDisplayDecorator',
        'slotButtonDisplayDecorator',
        'pageSpecificDecorator',
        'buttonDisplayAndRefreshDecorator'
    ])
    .run(function (decoratorService) {
        decoratorService.addMappings({
            componentType1: ['textDisplay', 'pageSpecific'],
            componentType2: ['buttonDisplay'],
            SimpleResponsiveBannerComponent: ['textDisplay', 'buttonDisplay'],
            componentType4: ['textDisplay', 'buttonDisplayAndRefresh'],
            ContentSlot: ['slotTextDisplay', 'slotButtonDisplay']
        });

        decoratorService.enable('textDisplay');
        decoratorService.enable('buttonDisplay');
        decoratorService.enable('slotTextDisplay');
        decoratorService.enable('slotButtonDisplay');
        decoratorService.enable('pageSpecific');
        decoratorService.enable('buttonDisplayAndRefresh');
    });

/*
 * Provides a simple text display decorator for components.
 */
angular
    .module('textDisplayDecorator', ['DummyDecoratorTemplatesModule', 'translationServiceModule'])
    .directive('textDisplay', function () {
        return {
            templateUrl: TEXT_TEMPLATE_URL,
            restrict: 'C',
            transclude: true,
            replace: false,
            scope: {
                smarteditComponentId: '@',
                smarteditComponentType: '@',
                active: '='
            },
            link: function ($scope) {
                $scope.textDisplayContent = 'Text_is_been_displayed_TextDisplayDecorator';
            }
        };
    });

/*
 * Provides a simple text display decorator for slots.
 */
angular
    .module('slotTextDisplayDecorator', [
        'DummyDecoratorTemplatesModule',
        'translationServiceModule'
    ])
    .directive('slotTextDisplay', function () {
        return {
            templateUrl: TEXT_TEMPLATE_URL,
            restrict: 'C',
            transclude: true,
            replace: false,
            scope: {
                smarteditComponentId: '@',
                smarteditComponentType: '@',
                active: '='
            },
            link: function ($scope) {
                $scope.textDisplayContent = 'slot_text_is_been_displayed_SlotTextDisplayDecorator';
            }
        };
    });

/*
 * Provides a simple button display decorator for components.
 */
angular
    .module('buttonDisplayDecorator', ['DummyDecoratorTemplatesModule', 'translationServiceModule'])
    .directive('buttonDisplay', function () {
        return {
            templateUrl: BUTTON_TEMPLATE_URL,
            restrict: 'C',
            transclude: true,
            replace: false,
            scope: {
                smarteditComponentId: '@',
                smarteditComponentType: '@',
                active: '='
            },
            link: function ($scope) {
                $scope.buttonDisplayContent = 'Button_is_been_Displayed';
            }
        };
    });

/*
 * Provides a simple button display decorator for slots.
 */
angular
    .module('slotButtonDisplayDecorator', [
        'DummyDecoratorTemplatesModule',
        'translationServiceModule'
    ])
    .directive('slotButtonDisplay', function () {
        return {
            templateUrl: BUTTON_TEMPLATE_URL,
            restrict: 'C',
            transclude: true,
            replace: false,
            scope: {
                smarteditComponentId: '@',
                smarteditComponentType: '@',
                active: '='
            },
            link: function ($scope) {
                $scope.buttonDisplayContent = 'Slot_button_is_been_Displayed';
            }
        };
    });

/*
 * Provides a simple button display decorator for slots.
 */
angular.module('pageSpecificDecorator', []).directive('pageSpecific', function (pageInfoService) {
    return {
        templateUrl: 'pageSpecificDecoratorTemplate.html',
        restrict: 'C',
        transclude: true,
        replace: false,
        scope: {
            smarteditComponentId: '@',
            smarteditComponentType: '@',
            active: '='
        },
        link: function ($scope) {
            pageInfoService.getPageUUID().then(function (pageUUID) {
                $scope.pageUUID = pageUUID;
            });
        }
    };
});

/* Provides text that can be changed by clicking a button. There's another button that will replay the decorator. */
angular
    .module('buttonDisplayAndRefreshDecorator', [
        'DummyDecoratorTemplatesModule',
        'translationServiceModule'
    ])
    .directive('buttonDisplayAndRefresh', function (
        crossFrameEventService,
        EVENT_SMARTEDIT_COMPONENT_UPDATED
    ) {
        return {
            templateUrl: 'buttonAndRefreshDecoratorTemplate.html',
            restrict: 'C',
            transclude: true,
            replace: false,
            scope: {
                smarteditComponentId: '@',
                smarteditComponentType: '@',
                active: '='
            },
            link: function ($scope) {
                $scope.buttonDisplayContent = 'Button_is_been_Displayed';
                $scope.onButtonClicked = function () {
                    $scope.buttonDisplayContent = 'Button_has_been_Clicked';
                };

                $scope.onRefreshButtonClicked = function () {
                    crossFrameEventService.publish(EVENT_SMARTEDIT_COMPONENT_UPDATED, {
                        componentId: $scope.smarteditComponentId,
                        componentType: $scope.smarteditComponentType,
                        requiresReplayingDecorators: true
                    });
                };
            }
        };
    });

/*
 * Provides templates for the dummy decorators.
 */
angular.module('DummyDecoratorTemplatesModule', []).run(function ($templateCache) {
    const DIV_ELEMENT = '<div data-ng-transclude></div>\n';
    const DIV_MAIN_BUTTON =
        "<button class='main-button' data-ng-click='onButtonClicked()'>{{buttonDisplayContent}}</button>\n";
    const DIV_REFRESH_BUTTON =
        "<button class='refresh-button' data-ng-click='onRefreshButtonClicked()'>Refresh Content</button>\n";
    $templateCache.put(TEXT_TEMPLATE_URL, `<div>\n${DIV_ELEMENT}{{textDisplayContent}}\n</div>`);

    $templateCache.put(
        BUTTON_TEMPLATE_URL,
        `<div>\n${DIV_ELEMENT}<button>{{buttonDisplayContent}}</button>\n</div>`
    );

    $templateCache.put(
        'pageSpecificDecoratorTemplate.html',
        `<div>\n${DIV_ELEMENT}<label>pageUUID: {{pageUUID}}</label>\n</div>`
    );

    $templateCache.put(
        'buttonAndRefreshDecoratorTemplate.html',
        `<div>\n${DIV_ELEMENT}${DIV_MAIN_BUTTON}${DIV_REFRESH_BUTTON}</div>`
    );
});
