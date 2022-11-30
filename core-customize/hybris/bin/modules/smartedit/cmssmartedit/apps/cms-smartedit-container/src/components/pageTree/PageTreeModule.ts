/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { PopupOverlayModule, TranslationModule } from 'smarteditcommons';
import { PageTreeComponent } from './PageTreeComponent/PageTreeComponent';
import {
    PageTreeMoreItemsComponent,
    PageTreeMenuItemOverlayComponent,
    PageTreeComponentMenuComponent
} from './PageTreeComponentMenu';
import { PageTreePanel } from './PageTreePanel/PageTreePanel';
import { PageTreeSlot } from './PageTreeSlot/PageTreeSlot';

@NgModule({
    imports: [CommonModule, PopupOverlayModule, TranslationModule.forChild()],
    declarations: [
        PageTreePanel,
        PageTreeSlot,
        PageTreeComponent,
        PageTreeMoreItemsComponent,
        PageTreeMenuItemOverlayComponent,
        PageTreeComponentMenuComponent
    ],
    entryComponents: [
        PageTreePanel,
        PageTreeSlot,
        PageTreeComponent,
        PageTreeMoreItemsComponent,
        PageTreeMenuItemOverlayComponent,
        PageTreeComponentMenuComponent
    ]
})
export class PageTreeModule {}
