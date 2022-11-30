/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint esversion: 6 */
angular
    .module('RenderDecoratorsModule', [
        'renderComponentDecoratorModule',
        'renderSlotDecoratorModule',
        'dirtyContentDecoratorModule'
    ])
    .run(function (decoratorService) {
        decoratorService.addMappings({
            'componentType*': ['renderComponentDecorator', 'dirtyContentDecorator'],
            ContentSlot: ['renderSlotDecorator']
        });

        decoratorService.enable('renderComponentDecorator');
        decoratorService.enable('dirtyContentDecorator');
        decoratorService.enable('renderSlotDecorator');
    });

angular
    .module('dirtyContentDecoratorModule', ['renderDecoratorsTemplatesModule'])
    .controller('dirtyContentDecoratorController', function (componentHandlerService) {
        this.buttonDisplayContent = 'Dirty Component';
        this.dirtyContent = function () {
            var element = componentHandlerService.getComponent(
                this.smarteditComponentId,
                this.smarteditComponentType
            );
            element.find('p').html('Some dirtied content');
        };
    })
    .directive('dirtyContentDecorator', function () {
        return {
            templateUrl: 'dirtyContentDecoratorTemplate.html',
            restrict: 'C',
            transclude: true,
            replace: false,
            scope: {},
            bindToController: {
                smarteditComponentId: '@',
                smarteditComponentType: '@',
                active: '='
            },
            controller: 'dirtyContentDecoratorController',
            controllerAs: 'ctrl'
        };
    });

angular
    .module('renderComponentDecoratorModule', ['renderDecoratorsTemplatesModule'])
    .controller('renderDecoratorController', function (renderService) {
        this.buttonDisplayContent = 'Re-render Component';
        this.renderNewContent = function () {
            renderService.renderComponent(this.smarteditComponentId, this.smarteditComponentType);
        };
    })
    .directive('renderComponentDecorator', function () {
        return {
            templateUrl: 'renderComponentDecoratorTemplate.html',
            restrict: 'C',
            transclude: true,
            replace: false,
            scope: {},
            bindToController: {
                smarteditComponentId: '@',
                smarteditComponentType: '@',
                active: '='
            },
            controller: 'renderDecoratorController',
            controllerAs: 'ctrl'
        };
    });

angular
    .module('renderSlotDecoratorModule', ['renderDecoratorsTemplatesModule'])
    .controller('renderSlotDecoratorController', function (renderService) {
        this.buttonDisplayContent = 'Re-render Slot';
        this.renderNewContent = function () {
            renderService.renderSlots([this.smarteditComponentId]);
        };
    })
    .directive('renderSlotDecorator', function () {
        return {
            templateUrl: 'renderSlotDecoratorTemplate.html',
            restrict: 'C',
            transclude: true,
            replace: false,
            scope: {},
            bindToController: {
                smarteditComponentId: '@',
                smarteditComponentType: '@',
                active: '='
            },
            controller: 'renderSlotDecoratorController',
            controllerAs: 'ctrl'
        };
    });

angular.module('renderDecoratorsTemplatesModule', []).run(function ($templateCache) {
    const COMMON_ELEMENT =
        '{{ctrl.buttonDisplayContent}}' +
        '</button>\n' +
        '<div data-ng-transclude></div>\n' +
        '</div>';
    const DIV_DIRTY_CONTENT_BUTTON =
        "<button style='position: absolute; z-index: 20; right: 250px' id='{{::ctrl.smarteditComponentId}}-dirty-content-button' ng-click='ctrl.dirtyContent()'>";
    const DIV_RENDER_BUTTON_INNER =
        "<button style='position: absolute; z-index: 20; right: 125px' id='{{::ctrl.smarteditComponentId}}-render-button-inner' ng-click='ctrl.renderNewContent()'>";
    const DIV_RENDER_SLOT_BUTTON_INNER =
        "<button style='position: absolute; z-index: 20; right: 0px' id='{{::ctrl.smarteditComponentId}}-render-slot-button-inner' ng-click='ctrl.renderNewContent()'>";
    $templateCache.put(
        'dirtyContentDecoratorTemplate.html',
        `<div>\n${DIV_DIRTY_CONTENT_BUTTON}${COMMON_ELEMENT}`
    );

    $templateCache.put(
        'renderComponentDecoratorTemplate.html',
        `<div>\n${DIV_RENDER_BUTTON_INNER}${COMMON_ELEMENT}`
    );

    $templateCache.put(
        'renderSlotDecoratorTemplate.html',
        `<div>\n${DIV_RENDER_SLOT_BUTTON_INNER}${COMMON_ELEMENT}`
    );
});
