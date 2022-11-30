/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import * as angular from 'angular';
import { urlUtils } from '../../../../smart-utils/dist';

angular
    .module('AuthorizationMockModule', ['resourceLocationsModule'])
    .constant('ADMIN_AUTH_TOKEN', {
        access_token: 'admin-access-token',
        token_type: 'bearer'
    })
    .constant('CMSMANAGER_AUTH_TOKEN', {
        access_token: 'cmsmanager-access-token',
        token_type: 'bearer'
    })
    .run(function (
        httpBackendService,
        resourceLocationToRegex,
        DEFAULT_AUTHENTICATION_ENTRY_POINT,
        ADMIN_AUTH_TOKEN,
        CMSMANAGER_AUTH_TOKEN
    ) {
        httpBackendService.whenGET(/smartedit\/settings/).respond({
            'smartedit.sso.enabled': 'false'
        });

        httpBackendService
            .whenPOST(resourceLocationToRegex(DEFAULT_AUTHENTICATION_ENTRY_POINT))
            .respond(function (method, url, data) {
                data = urlUtils.parseQuery(data);
                if (
                    data.client_id === 'smartedit' &&
                    data.client_secret === undefined &&
                    data.grant_type === 'password' &&
                    data.username === 'admin' &&
                    data.password === '1234'
                ) {
                    return [200, ADMIN_AUTH_TOKEN];
                } else if (
                    data.client_id === 'smartedit' &&
                    data.client_secret === undefined &&
                    data.grant_type === 'password' &&
                    data.username === 'cmsmanager' &&
                    data.password === '1234'
                ) {
                    return [200, CMSMANAGER_AUTH_TOKEN];
                } else {
                    return [401];
                }
            });
    });

try {
    angular.module('smarteditloader').requires.push('AuthorizationMockModule');
    angular.module('smarteditcontainer').requires.push('AuthorizationMockModule');
} catch (ex) {}
