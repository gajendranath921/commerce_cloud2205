/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { TranslateModule } from '@ngx-translate/core';
import { SpinnerModule } from 'smarteditcommons';
import {
    ActionableAlertComponent,
    SharedComponentButtonComponent,
    ExternalComponentButtonComponent
} from './components';
import { SynchronizationResourceService } from './dao';
import { ComponentVisibilityAlertModule, SynchronizationPanelModule } from './modules';
import { AssetsService } from './services/AssetsService';
import { AttributePermissionsRestService } from './services/AttributePermissionsRestService';
import { CMSTimeService } from './services/CMSTimeService';
import { ComponentService } from './services/ComponentService';
import { SynchronizationService } from './services/synchronizationService';
import { TypePermissionsRestService } from './services/TypePermissionsRestService';

@NgModule({
    imports: [
        CommonModule,
        SpinnerModule,
        TranslateModule.forChild(),
        SynchronizationPanelModule,
        ComponentVisibilityAlertModule
    ],
    providers: [
        AttributePermissionsRestService,
        CMSTimeService,
        SynchronizationService,
        TypePermissionsRestService,
        ComponentService,
        SynchronizationResourceService,
        AssetsService
    ],
    declarations: [
        ActionableAlertComponent,
        SharedComponentButtonComponent,
        ExternalComponentButtonComponent
    ],
    entryComponents: [SharedComponentButtonComponent, ExternalComponentButtonComponent],
    exports: [
        ActionableAlertComponent,
        SharedComponentButtonComponent,
        ExternalComponentButtonComponent,
        SynchronizationPanelModule,
        ComponentVisibilityAlertModule
    ]
})
export class CmsCommonsModule {}
