/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { deprecate } from 'smartedit/deprecate';
deprecate();

// eslint-disable-next-line import/order
import * as angular from 'angular';
// eslint-disable-next-line import/order
import { setAngularJSGlobal } from '@angular/upgrade/static';
import { LegacySmarteditServicesModule } from 'smartedit/services';
import { instrument, Cloneable, SeModule, objectUtils } from 'smarteditcommons';

setAngularJSGlobal(angular);
@SeModule({
    imports: [
        LegacySmarteditServicesModule,
        'templateCacheDecoratorModule',
        'ui.bootstrap',
        'ui.select'
    ],
    config: ($provide: angular.auto.IProvideService, $logProvider: angular.ILogProvider) => {
        'ngInject';

        instrument($provide, (arg: Cloneable) => objectUtils.readObjectStructure(arg), 'smartedit');

        $logProvider.debugEnabled(false);
    }
})
export class LegacySmartedit {}
