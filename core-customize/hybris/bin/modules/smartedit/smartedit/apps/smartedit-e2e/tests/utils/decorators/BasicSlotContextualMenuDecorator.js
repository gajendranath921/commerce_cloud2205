/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/**
 * @ngdoc overview
 * @name basicContextualMenuDecoratorModule
 * @description
 * Provides decorator for basic slot contextual menu.
 */
angular.module('basicContextualMenuDecoratorModule', []).run(function (decoratorService) {
    decoratorService.addMappings({
        '^.*Slot$': ['se.basicSlotContextualMenu']
    });
    decoratorService.enable('se.basicSlotContextualMenu');
});
