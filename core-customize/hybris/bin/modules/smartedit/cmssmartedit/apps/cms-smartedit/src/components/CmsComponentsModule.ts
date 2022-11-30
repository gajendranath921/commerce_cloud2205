/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SynchronizationPanelModule } from 'cmscommons';
import {
    HasOperationPermissionDirectiveModule,
    PopupOverlayModule,
    TooltipModule,
    TranslationModule
} from 'smarteditcommons';
import { ExternalComponentDecoratorComponent } from './externalComponent';
import { SlotSharedButtonComponent } from './slotShared';
import {
    SlotDisabledComponent,
    ExternalSlotDisabledDecoratorComponent,
    SharedSlotDisabledDecoratorComponent
} from './slotSharedDisabled';
import { SlotUnsharedButtonComponent } from './slotUnshared';
import {
    HiddenComponentMenuComponent,
    SlotVisibilityButtonComponent,
    SlotVisibilityComponent
} from './slotVisibility';
import {
    SlotSyncButtonComponent,
    SlotSynchronizationPanelWrapperComponent,
    SyncIndicatorDecorator
} from './synchronize';

import './contextualSlotDropdown.scss';

@NgModule({
    imports: [
        CommonModule,
        SynchronizationPanelModule,
        TooltipModule,
        TranslationModule.forChild(),
        PopupOverlayModule,
        HasOperationPermissionDirectiveModule
    ],
    declarations: [
        ExternalComponentDecoratorComponent,
        SlotSynchronizationPanelWrapperComponent,
        SlotDisabledComponent,
        ExternalSlotDisabledDecoratorComponent,
        SharedSlotDisabledDecoratorComponent,
        SlotSharedButtonComponent,
        SlotSyncButtonComponent,
        SlotUnsharedButtonComponent,
        HiddenComponentMenuComponent,
        SlotVisibilityComponent,
        SlotVisibilityButtonComponent,
        SyncIndicatorDecorator
    ],
    entryComponents: [
        ExternalComponentDecoratorComponent,
        SlotSynchronizationPanelWrapperComponent,
        SlotDisabledComponent,
        ExternalSlotDisabledDecoratorComponent,
        SharedSlotDisabledDecoratorComponent,
        SlotSharedButtonComponent,
        SlotSyncButtonComponent,
        SlotUnsharedButtonComponent,
        HiddenComponentMenuComponent,
        SlotVisibilityComponent,
        SlotVisibilityButtonComponent,
        SyncIndicatorDecorator
    ]
})
export class CmsComponentsModule {}
