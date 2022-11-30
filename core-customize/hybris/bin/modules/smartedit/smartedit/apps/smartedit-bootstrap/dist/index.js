'use strict';

var angular = require('angular');
var platformBrowserDynamic = require('@angular/platform-browser-dynamic');
var smarteditcommons = require('smarteditcommons');

class BootstrapService {
    bootstrap() {
        const smarteditNamespace = window.smartedit;
        // for legacy requires.push
        const modules = (smarteditNamespace.applications || [])
            .map((application) => {
            smarteditcommons.moduleUtils.addModuleToAngularJSApp('legacySmartedit', application);
            return {
                application,
                module: smarteditcommons.moduleUtils.getNgModule(application)
            };
        })
            .filter((data) => {
            if (!data.module) {
                console.log(`WARNING: Unable to find @NgModule for application ${data.application}`);
                console.log('Here is the list of registered @NgModule:');
                console.log(window.__smartedit__.modules);
            }
            return !!data.module;
        })
            .map((data) => data.module);
        /* forbiddenNameSpaces angular.module:false */
        angular.module('legacySmartedit')
            .constant(smarteditcommons.DOMAIN_TOKEN, smarteditNamespace.domain)
            .constant('smarteditroot', smarteditNamespace.smarteditroot);
        const constants = {
            [smarteditcommons.DOMAIN_TOKEN]: smarteditNamespace.domain,
            smarteditroot: smarteditNamespace.smarteditroot
        };
        /*
         * Bootstrap needs a reference ot the module hence cannot be achieved
         * in smarteditbootstrap.js that would then pull dependencies since it is an entry point.
         * We would then duplicate code AND kill overriding capabilities of "plugins"
         */
        document.body.appendChild(document.createElement(smarteditcommons.SMARTEDIT_COMPONENT_NAME));
        /* forbiddenNameSpaces window._:false */
        platformBrowserDynamic.platformBrowserDynamic()
            .bootstrapModule(window.__smartedit__.SmarteditFactory({ modules, constants }))
            .then(() => {
            delete window.__smartedit__.SmarteditFactory;
        })
            .catch((err) => console.log(err));
    }
}
/** @internal */
const bootstrapService = new BootstrapService();

/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* forbiddenNameSpaces angular.module:false */
angular.element(document).ready(() => {
    bootstrapService.bootstrap();
});
