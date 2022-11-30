/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { DatetimePickerRangeModule } from 'personalizationcommons';
import {
    TranslationModule,
    SliderPanelModule,
    TabsModule,
    TooltipModule,
    DropdownMenuModule
} from 'smarteditcommons';
import { BasicInfoTabComponent } from './basicInfoTab';
import { CustomizationViewService } from './CustomizationViewService';
import { ManageCustomizationViewComponent } from './ManageCustomizationViewComponent';
import { ManageCustomizationViewManager } from './ManageCustomizationViewManager';
import { SegmentExpressionAsHtmlModule } from './segmentExpressionAsHtml';
import { PersonalizationsmarteditSegmentViewModule } from './segmentView/PersonalizationsmarteditSegmentViewModule';
import {
    TargetGroupTabComponent,
    TargetGroupVariationListComponent,
    ToggleVariationActiveItemComponent,
    EditVariationItemComponent,
    MoveVariationUpItemComponent,
    MoveVariationDownItemComponent,
    RemoveVariationItemComponent,
    ModalFullScreenButtonModule
} from './targetGroupTab';
import { TriggerService } from './TriggerService';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        TranslationModule.forChild(),
        DatetimePickerRangeModule,
        TabsModule,
        TooltipModule,
        SliderPanelModule,
        DropdownMenuModule,
        SegmentExpressionAsHtmlModule,
        PersonalizationsmarteditSegmentViewModule,
        ModalFullScreenButtonModule
    ],
    providers: [ManageCustomizationViewManager, CustomizationViewService, TriggerService],
    declarations: [
        BasicInfoTabComponent,
        TargetGroupTabComponent,
        TargetGroupVariationListComponent,
        EditVariationItemComponent,
        ToggleVariationActiveItemComponent,
        MoveVariationUpItemComponent,
        MoveVariationDownItemComponent,
        RemoveVariationItemComponent,
        ManageCustomizationViewComponent
    ],
    entryComponents: [
        BasicInfoTabComponent,
        TargetGroupTabComponent,
        EditVariationItemComponent,
        ToggleVariationActiveItemComponent,
        MoveVariationUpItemComponent,
        MoveVariationDownItemComponent,
        RemoveVariationItemComponent,
        ManageCustomizationViewComponent
    ],
    exports: [BasicInfoTabComponent, TargetGroupTabComponent]
})
export class ManageCustomizationViewModule {}
