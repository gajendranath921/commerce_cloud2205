/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { Injectable } from '@angular/core';
import { UpgradeModule } from '@angular/upgrade/static';
import { ITemplateCacheService } from './interfaces';

/**
 * A service responsible for delivering AngularJS dependencies lazily.
 * This is needed because if Angular service uses AngularJS dependencies, and the service is bootstrapped before the initialization of
 * AngularJS the injector error will occur.
 *
 * With AngularJSLazyDependenciesService we request the dependencies only when they are needed.
 */
@Injectable()
export class AngularJSLazyDependenciesService {
    constructor(private upgrade: UpgradeModule) {}

    public $injector(): angular.auto.IInjectorService {
        return this.upgrade.$injector;
    }

    /**
     * Returns $templateCache when the module is hybridized.
     * $injector might be undefined for an extension that has only Angular modules.
     */
    public $templateCache(): ITemplateCacheService | undefined {
        return this.$injector()?.get('$templateCache');
    }

    public $rootScope(): angular.IRootScopeService {
        return this.$injector().get('$rootScope');
    }

    public $location(): angular.ILocationService {
        return this.$injector().get('$location');
    }
}
