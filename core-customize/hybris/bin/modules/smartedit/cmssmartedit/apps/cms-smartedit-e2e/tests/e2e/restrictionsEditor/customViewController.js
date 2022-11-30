/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* jshint unused:false, undef:false */
angular
    .module('customViewModule', ['backendMocksUtilsModule', 'yLoDashModule', 'genericEditorModule'])
    .constant('PATH_TO_CUSTOM_VIEW', '../e2e/restrictionsEditor/customView.html')
    .controller('customViewController', function (
        $q,
        $filter,
        sharedDataService,
        backendMocksUtils,
        lodash,
        restrictionTypesService,
        GENERIC_EDITOR_UNRELATED_VALIDATION_MESSAGES_EVENT,
        systemEventService
    ) {
        var EDIT_ADDRESS = 'add-edit-address';
        var TIMESTAMP = 'MM/dd/yy HH:mm a';
        this.pageType = sessionStorage.getItem('pageType');

        this.editable = true;
        this.page = {
            type: 'contentPageData',
            uid: EDIT_ADDRESS,
            uuid: EDIT_ADDRESS,
            typeCode: this.pageType,
            onlyOneRestrictionMustApply: false,
            creationtime: '2016-07-15T23:35:21+0000',
            defaultPage: true,
            modifiedtime: '2016-07-15T23:38:01+0000',
            name: 'Add Edit Address Page',
            pk: '8796095743024',
            template: 'AccountPageTemplate',
            title: {
                de: 'Adresse hinzufügen/bearbeiten'
            },
            label: EDIT_ADDRESS,
            restrictions: ['timeRestrictionIdA', 'catalogRestrictionIdD']
        };

        this.restrictionsResult = function (data) {
            this.page.onlyOneRestrictionMustApply = data.onlyOneRestrictionMustApply;
            this.page.restrictions = data.restrictionUuids;
        }.bind(this);

        this.getRestrictionTypes = function () {
            return restrictionTypesService.getRestrictionTypesByPageType(this.page.typeCode);
        }.bind(this);

        this.getSupportedRestrictionTypes = function () {
            return $q.when([
                'CMSTimeRestriction',
                'CMSCategoryRestriction',
                'CMSUserGroupRestriction'
            ]);
        };
        fillIncludeRestrictions(this);
        handlePOSTMock();
        handlePUTMock();
        function fillIncludeRestrictions(context) {
            context.includeRestrictions = sessionStorage.getItem('existingRestrictions');
            if (context.includeRestrictions === null || context.includeRestrictions === 'false') {
                var items = JSON.parse(sessionStorage.getItem('componentMocks'));

                items.componentItems.forEach(
                    function (item) {
                        if (item.uuid === EDIT_ADDRESS) {
                            item.restrictions = [];
                        }
                        this.page.restrictions = [];
                    }.bind(context)
                );

                sessionStorage.setItem('componentMocks', JSON.stringify(items));
            }
        }
        // Helpers
        function handlePUTMock() {
            backendMocksUtils
                .getBackendMock('componentPUTMock')
                .respond(function (method, url, data) {
                    var parsedData = JSON.parse(data);
                    if (
                        url.indexOf('dryRun=true') &&
                        parsedData.itemtype === 'CMSTimeRestriction' &&
                        parsedData.activeUntil < parsedData.activeFrom
                    ) {
                        return get400Error();
                    }

                    switch (parsedData.itemtype) {
                        case 'CMSTimeRestriction':
                            var dateFrom = $filter('date')(parsedData.activeFrom, TIMESTAMP);
                            var dateUntil = $filter('date')(parsedData.activeUntil, TIMESTAMP);
                            parsedData.description =
                                'Page only applies from ' + dateFrom + ' to ' + dateUntil;
                            break;
                        case 'CMSCategoryRestriction':
                            parsedData.description = getCategoryRestrictionDescription(
                                parsedData.categories
                            );
                            break;
                        case 'CMSUserGroupRestriction':
                            parsedData.description = getUserGroupRestrictionDescription(
                                parsedData.userGroups
                            );
                            break;
                    }

                    addRestrictionToList(parsedData);

                    return [201, parsedData];
                });
        }
        function handlePOSTMock() {
            backendMocksUtils
                .getBackendMock('componentPOSTMock')
                .respond(function (method, url, data) {
                    var parsedData = JSON.parse(data);

                    if (
                        url.indexOf('dryRun=true') &&
                        parsedData.itemtype === 'CMSTimeRestriction' &&
                        parsedData.activeUntil < parsedData.activeFrom
                    ) {
                        return get400Error();
                    }

                    switch (parsedData.itemtype) {
                        case 'CMSTimeRestriction':
                            var dateFrom = $filter('date')(parsedData.activeFrom, TIMESTAMP);
                            var dateUntil = $filter('date')(parsedData.activeUntil, TIMESTAMP);
                            parsedData.uid = 'restriction-time-1';
                            parsedData.uuid = 'restriction-time-1';
                            parsedData.description =
                                'Page only applies from ' + dateFrom + ' to ' + dateUntil;
                            break;
                        case 'CMSCategoryRestriction':
                            parsedData.uid = 'restriction-category-1';
                            parsedData.uuid = 'restriction-category-1';
                            parsedData.description = getCategoryRestrictionDescription(
                                parsedData.categories
                            );
                            break;
                        case 'CMSUserGroupRestriction':
                            parsedData.uid = 'restriction-usergroup-1';
                            parsedData.uuid = 'restriction-usergroup-1';
                            parsedData.description = getUserGroupRestrictionDescription(
                                parsedData.userGroups
                            );
                            break;
                    }

                    addRestrictionToList(parsedData);

                    return [201, parsedData];
                });
        }
        function get400Error() {
            return [
                400,
                {
                    errors: [
                        {
                            message:
                                'The dates and times provided are not valid. The Active until date/time must be after/later than the Active from date/time.',
                            reason: 'missing',
                            subject: 'activeUntil',
                            subjectType: 'parameter',
                            type: 'ValidationError'
                        }
                    ]
                }
            ];
        }
        function addRestrictionToList(newRestriction) {
            var cmpItems = JSON.parse(sessionStorage.getItem('componentMocks'));

            lodash.remove(cmpItems.componentItems, function (item) {
                return item.uuid === newRestriction.uuid;
            });

            cmpItems.componentItems.push(newRestriction);

            sessionStorage.setItem('componentMocks', JSON.stringify(cmpItems));
        }

        this.dialogSaveFn = function () {
            this.saveResult = this.isDirtyFn()
                ? 'Save executed.'
                : 'Save cannot be executed. Editor not dirty.';

            var returnError = JSON.parse(window.sessionStorage.getItem('returnErrors'));
            if (returnError) {
                var unrelatedValidationErrors = [
                    {
                        message: 'Error message activeFrom',
                        reason: 'invalid',
                        subject: 'restrictions.activeFrom',
                        position: '0',
                        type: 'ValidationError'
                    },
                    {
                        message: 'Error message name',
                        reason: 'invalid',
                        subject: 'restrictions.name',
                        position: '2',
                        type: 'ValidationError'
                    }
                ];

                systemEventService.publishAsync(
                    GENERIC_EDITOR_UNRELATED_VALIDATION_MESSAGES_EVENT,
                    {
                        messages: unrelatedValidationErrors
                    }
                );
            }
        };
    });

try {
    angular.module('smarteditcontainer').requires.push('customViewModule');
} catch (e) {}
