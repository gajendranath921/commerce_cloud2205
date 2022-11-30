/// <reference types="angular" />
import { UpgradeModule } from '@angular/upgrade/static';
import { ITemplateCacheService } from './interfaces';
/**
 * A service responsible for delivering AngularJS dependencies lazily.
 * This is needed because if Angular service uses AngularJS dependencies, and the service is bootstrapped before the initialization of
 * AngularJS the injector error will occur.
 *
 * With AngularJSLazyDependenciesService we request the dependencies only when they are needed.
 */
export declare class AngularJSLazyDependenciesService {
    private upgrade;
    constructor(upgrade: UpgradeModule);
    $injector(): angular.auto.IInjectorService;
    /**
     * Returns $templateCache when the module is hybridized.
     * $injector might be undefined for an extension that has only Angular modules.
     */
    $templateCache(): ITemplateCacheService | undefined;
    $rootScope(): angular.IRootScopeService;
    $location(): angular.ILocationService;
}
