/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
angular
    .module('ConfigurationsMockModule', ['resourceLocationsModule', 'AuthorizationMockModule'])
    .constant('SMARTEDIT_RESOURCE_URI_REGEXP', /^(.*)\/apps\/smartedit-e2e\/generated\/e2e/)
    .constant('SMARTEDIT_ROOT', 'web/webroot')
    .value('CONFIGURATION_MOCK', [])
    .value('CONFIGURATION_AUTHORIZED', false)
    .value('CONFIGURATION_FORBIDDEN', false)
    .run(function (
        httpBackendService,
        resourceLocationToRegex,
        CONFIGURATION_MOCK,
        CONFIGURATION_URI,
        ADMIN_AUTH_TOKEN,
        CMSMANAGER_AUTH_TOKEN,
        CONFIGURATION_AUTHORIZED,
        CONFIGURATION_FORBIDDEN
    ) {
        var CONFIGURATIONS = angular.copy(CONFIGURATION_MOCK);

        httpBackendService
            .whenGET(resourceLocationToRegex(CONFIGURATION_URI))
            .respond(function (method, url, data, headers) {
                if (
                    !CONFIGURATION_AUTHORIZED ||
                    headers.Authorization === 'bearer ' + ADMIN_AUTH_TOKEN.access_token ||
                    headers.Authorization === 'bearer ' + CMSMANAGER_AUTH_TOKEN.access_token
                ) {
                    return [200, CONFIGURATIONS];
                } else {
                    return [401];
                }
            });

        httpBackendService
            .whenPUT(resourceLocationToRegex(CONFIGURATION_URI))
            .respond(function (method, url, data) {
                if (CONFIGURATION_FORBIDDEN) {
                    return [403];
                }
                var key = getConfigurationKeyFromUrl(url);
                data = JSON.parse(data);
                var entry = CONFIGURATIONS.find(function (configuration) {
                    return configuration.key === key;
                });
                entry.value = data.value;
                return [200, data];
            });

        httpBackendService
            .whenPOST(resourceLocationToRegex(CONFIGURATION_URI))
            .respond(function (method, url, data) {
                if (CONFIGURATION_FORBIDDEN) {
                    return [403];
                }
                data = JSON.parse(data);
                data.id = Math.random();
                CONFIGURATIONS.push(data);
                return [200, data];
            });

        httpBackendService
            .whenDELETE(resourceLocationToRegex(CONFIGURATION_URI))
            .respond(function (method, url) {
                if (CONFIGURATION_FORBIDDEN) {
                    return [403];
                }
                var key = getConfigurationKeyFromUrl(url);
                CONFIGURATIONS = CONFIGURATIONS.filter(function (entry) {
                    return entry.key !== key;
                });
                return [200];
            });

        function getConfigurationKeyFromUrl(url) {
            return /configuration\/(.+)/.exec(url)[1];
        }
    });

try {
    angular.module('smarteditloader').requires.push('ConfigurationsMockModule');
    angular.module('smarteditcontainer').requires.push('ConfigurationsMockModule');
} catch (ex) {}
