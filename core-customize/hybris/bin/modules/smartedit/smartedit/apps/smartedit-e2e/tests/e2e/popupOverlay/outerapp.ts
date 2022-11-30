/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import '../base/smarteditcontainer/base-container-app';
import { CommonModule } from '@angular/common';
import { Component, Inject, NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import {
    PopupOverlayConfig,
    PopupOverlayModule,
    POPUP_OVERLAY_DATA,
    SeDowngradeComponent,
    SeEntryModule,
    TypedMap
} from 'smarteditcommons';

@Component({
    selector: 'se-popup-content',
    template: ` <div id="popup">{{ data.message }}</div> `
})
export class PopupOverlayContentComponent {
    constructor(@Inject(POPUP_OVERLAY_DATA) public data: TypedMap<string>) {}
}

@SeDowngradeComponent()
@Component({
    selector: 'app-root',
    template: `
        <div>
            <form>
                <h2>Trigger</h2>

                <label for="trigger-click">Click</label>
                <input
                    type="radio"
                    name="trigger"
                    id="trigger-click"
                    [(ngModel)]="trigger"
                    [value]="'click'"
                />

                <label for="trigger-hover">Hover</label>
                <input
                    type="radio"
                    name="trigger"
                    id="trigger-hover"
                    [(ngModel)]="trigger"
                    [value]="'hover'"
                />

                <label for="trigger-displayed">Always displayed</label>
                <input
                    type="radio"
                    name="trigger"
                    id="trigger-displayed"
                    [(ngModel)]="trigger"
                    [value]="true"
                />

                <label for="trigger-hidden">Always hidden</label>
                <input
                    type="radio"
                    name="trigger"
                    id="trigger-hidden"
                    [(ngModel)]="trigger"
                    [value]="false"
                />
            </form>

            <div id="angularPopup">
                <se-popup-overlay
                    [popupOverlay]="angularConfig"
                    [popupOverlayData]="{ message: 'Hello from component!' }"
                    [popupOverlayTrigger]="trigger"
                    (popupOverlayOnHide)="handleOnHide()"
                    (popupOverlayOnShow)="handleOnShow()"
                >
                    <div id="anchor">Angular</div>
                </se-popup-overlay>
            </div>
            <div id="message">{{ message }}</div>
        </div>
    `
})
export class AppRootComponent {
    public message: string;
    public trigger: string | boolean = 'click';

    public angularConfig: PopupOverlayConfig = {
        component: PopupOverlayContentComponent,
        valign: 'bottom',
        halign: 'left'
    };

    handleOnHide() {
        this.message = 'On Hide';
    }

    handleOnShow() {
        this.message = 'On Show';
    }
}

@SeEntryModule('popupOverlayApp')
@NgModule({
    imports: [PopupOverlayModule, CommonModule, FormsModule],
    providers: [{ provide: POPUP_OVERLAY_DATA, useValue: null }],
    declarations: [AppRootComponent, PopupOverlayContentComponent],
    entryComponents: [AppRootComponent, PopupOverlayContentComponent]
})
export class MoreTextAppNg {}
