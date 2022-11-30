/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* tslint:disable:max-classes-per-file */
import '../base/smarteditcontainer/base-container-app';

import { CommonModule } from '@angular/common';
import { Component, NgModule } from '@angular/core';

import {
    ConfirmationModalConfig,
    IConfirmationModalService,
    SeDowngradeComponent,
    SeEntryModule
} from 'smarteditcommons';

@SeDowngradeComponent()
@Component({
    selector: 'app-root',
    template: `
        <div class="smartedit-testing-overlay">
            <button id="confirmation-modal-trigger" (click)="openConfirmationModal()">
                Open confirmation modal with description
            </button>
        </div>
    `
})
export class AppRootComponent {
    private modalConfig: ConfirmationModalConfig = {
        title: 'my.confirmation.title',
        description: 'my.confirmation.message'
    };

    constructor(private confirmationModalService: IConfirmationModalService) {}

    public openConfirmationModal() {
        this.confirmationModalService.confirm(this.modalConfig);
    }
}

@SeEntryModule('ConfirmationModalApp')
@NgModule({
    imports: [CommonModule],
    declarations: [AppRootComponent],
    entryComponents: [AppRootComponent]
})
export class ConfirmationModalApp {}
