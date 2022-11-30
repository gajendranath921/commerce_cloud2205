/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
// eslint-disable-next-line import/order
import { deprecate } from 'smarteditcontainer/deprecate';
deprecate();

import * as angular from 'angular';
import {
    instrument,
    Cloneable,
    GenericEditorModule,
    NG_ROUTE_PREFIX,
    SeModule,
    SeRouteService,
    TemplateCacheDecoratorModule,
    TypedMap,
    objectUtils
} from 'smarteditcommons';
// eslint-disable-next-line @typescript-eslint/no-var-requires
const NgRouteModule = require('angular-route'); // Only supports CommonJS
// eslint-disable-next-line @typescript-eslint/no-var-requires
const NgUiBootstrapModule = require('angular-ui-bootstrap'); // Only supports CommonJS

declare global {
    /* @internal */
    interface InternalSmartedit {
        smartEditBootstrapped: TypedMap<boolean>;
    }
}

const TOP_LEVEL_MODULE_NAME = 'smarteditcontainer';

// eslint-disable-next-line @typescript-eslint/ban-ts-comment
// @ts-ignore
@SeModule({
    imports: [
        TemplateCacheDecoratorModule,
        NgRouteModule,
        NgUiBootstrapModule,
        'coretemplates',
        'paginationFilterModule',
        'resourceLocationsModule',
        'seConstantsModule',
        GenericEditorModule
    ],
    providers: [],
    config: (
        $provide: angular.auto.IProvideService,
        LANDING_PAGE_PATH: string,
        STORE_FRONT_CONTEXT: string,
        $routeProvider: angular.route.IRouteProvider,
        $logProvider: angular.ILogProvider
    ) => {
        'ngInject';

        instrument(
            $provide,
            (arg: Cloneable) => objectUtils.readObjectStructure(arg),
            TOP_LEVEL_MODULE_NAME
        );

        // Due to not working Angular <-> AngularJS navigation (issues with $locationShim),
        // it is not possible to register unified routes that will handle the navigation properly.
        // Routes must be registered as an Angular routes at once, when each route component has been migrated to Angular.
        // Until then, each route must register downgraded component.
        SeRouteService.init($routeProvider);

        SeRouteService.provideLegacyRoute({
            path: LANDING_PAGE_PATH,
            route: {
                redirectTo: NG_ROUTE_PREFIX
            }
        });

        SeRouteService.provideLegacyRoute({
            path: `${LANDING_PAGE_PATH}sites/:siteId`,
            route: {
                redirectTo: `${NG_ROUTE_PREFIX}/sites/:siteId`
            }
        });

        SeRouteService.provideLegacyRoute({
            path: STORE_FRONT_CONTEXT,
            route: {
                redirectTo: `${NG_ROUTE_PREFIX}${STORE_FRONT_CONTEXT}`
            }
        });

        $logProvider.debugEnabled(false);
    }
})
/** @internal */
export class Smarteditcontainer {}
