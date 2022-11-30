/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SeTranslationModule, HelpModule } from 'smarteditcommons';

import { DatetimePickerRangeComponent } from './DatetimePickerRangeComponent';

@NgModule({
    imports: [CommonModule, FormsModule, SeTranslationModule.forChild(), HelpModule],
    declarations: [DatetimePickerRangeComponent],
    entryComponents: [DatetimePickerRangeComponent],
    exports: [DatetimePickerRangeComponent]
})
export class DatetimePickerRangeModule {}
