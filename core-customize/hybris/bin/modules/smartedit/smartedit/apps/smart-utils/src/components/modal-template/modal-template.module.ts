/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ButtonModule, ModalModule } from '@fundamental-ngx/core';

import { TranslationModule } from '../../services/translations';
import { ModalTemplateComponent } from './modal-template.component';

@NgModule({
    imports: [CommonModule, ModalModule, ButtonModule, TranslationModule.forChild()],
    declarations: [ModalTemplateComponent],
    entryComponents: [ModalTemplateComponent],
    exports: [ModalTemplateComponent]
})
export class FundamentalModalTemplateModule {}
