/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint unused:false, undef:false */
angular
    .module('customViewModule', [
        'templateCacheDecoratorModule',
        'coretemplates',
        'genericEditorModule',
        'resourceLocationsModule'
    ])
    .constant('PATH_TO_CUSTOM_VIEW', '../e2e/editorModal/customView.html')
    .controller('customViewController', function (
        editorModalService,
        editorFieldMappingService,
        sharedDataService,
        restServiceFactory,
        $window,
        httpBackendService,
        $q,
        $log
    ) {
        const ERROR_MSG = 'This field cannot contain special characters';
        sharedDataService.set('experience', {
            siteDescriptor: {
                uid: 'someSiteUid'
            },
            catalogDescriptor: {
                catalogId: 'somecatalogId',
                catalogVersion: 'someCatalogVersion'
            }
        });

        this.clickEditButton = function (componentType, componentId) {
            var componentAttributes = {
                smarteditComponentType: componentType,
                smarteditComponentId: componentId,
                smarteditComponentUuid: componentId,
                catalogVersionUuid: 'somecatalogId/someCatalogVersion'
            };
            editorModalService.open(componentAttributes).then(
                function () {
                    $log.debug('Editor modal closed.');
                },
                function () {
                    $log.debug('Editor modal dismissed.');
                }
            );
        };

        this.mockBackendToPassSave = function () {
            window.itemPUT.respond(window.itemPUTDefaultResponse);
        };

        this.mockBackendToFailSave = function () {
            window.itemPUT.respond(function (method, url, data, headers) {
                var errors = {
                    errors: [
                        {
                            message: ERROR_MSG,
                            reason: 'missing',
                            subject: 'headline',
                            subjectType: 'parameter',
                            type: 'ValidationError'
                        },
                        {
                            message: ERROR_MSG,
                            reason: 'missing',
                            subject: 'name',
                            subjectType: 'parameter',
                            type: 'ValidationError'
                        },
                        {
                            message: ERROR_MSG,
                            reason: 'missing',
                            subject: 'uid',
                            subjectType: 'parameter',
                            type: 'ValidationError'
                        }
                    ]
                };
                return [400, errors];
            });
        };

        this.mockBackendToTriggerUnrelatedValidationErrors = function () {
            window.itemPUT.respond(function (method, url, data, headers) {
                var errors = {
                    errors: [
                        {
                            message: 'This is an unrelated validation error',
                            reason: 'missing',
                            subject: 'headline',
                            subjectType: 'parameter',
                            type: 'ValidationError'
                        }
                    ]
                };
                return [400, errors];
            });
        };

        editorFieldMappingService.addFieldTabMapping(null, null, 'visible', 'visibility');
        editorFieldMappingService.addFieldTabMapping(null, null, 'id', 'visibility');
    });
angular.module('smarteditcontainer').requires.push('customViewModule');
