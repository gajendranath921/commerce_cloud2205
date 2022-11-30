/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
window.smartedit = {
    i18nAPIRoot: 'somepath'
};

angular.module('smarteditServicesModule').factory('renderService', function () {
    return {
        renderComponent: function () {
            // This is intentional
        }
    };
});

angular.module('decoratortemplates', []);
