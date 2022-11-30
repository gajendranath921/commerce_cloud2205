/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import '../base/smarteditcontainer/base-container-app';
import { CommonModule } from '@angular/common';
import { Component, NgModule } from '@angular/core';
import { ModalRef } from '@fundamental-ngx/core';
import { of } from 'rxjs';
import {
    SeEntryModule,
    SmarteditCommonsModule,
    SeDowngradeComponent,
    ModalButtonAction,
    ModalButtonStyle,
    ModalService,
    ModalManagerService
} from 'smarteditcommons';

const AppModalBaseComponentTemplate = `
    <div id="fundamentalModal">
        <div>
            <h1>Buttons</h1>
            <button id="addButton" (click)="addButton()">Add button</button>
            <button id="removeButton" (click)="removeButton()">Remove button</button>
            <button id="removeAllButtons" (click)="removeAllButtons()">
                Remove all buttons
            </button>
        </div>

        <div>
            <h1>Title</h1>
            <button id="setTitle" (click)="setTitle()">Add title</button>
        </div>

        <div>
            <h1>Dismiss Button</h1>
            <button id="showDismissButton" (click)="showDismissButton()">
                Show dismiss button
            </button>
            <button id="hideDismissButton" (click)="hideDismissButton()">
                Hide dismiss button
            </button>
        </div>
    </div>
`;

abstract class AppModalBaseComponent {
    constructor(private modalManager: ModalManagerService) {}

    public addButton(): void {
        this.modalManager.addButton({
            id: 'id',
            label: 'my_label',
            action: ModalButtonAction.Dismiss,
            style: ModalButtonStyle.Default,
            compact: false,
            disabled: false
        });
    }

    public removeButton(): void {
        this.modalManager.removeButton('id');
    }

    public removeAllButtons(): void {
        this.modalManager.removeAllButtons();
    }

    public setTitle(): void {
        this.modalManager.setTitle('New Title');
    }

    public showDismissButton(): void {
        this.modalManager.setDismissButtonVisibility(true);
    }

    public hideDismissButton(): void {
        this.modalManager.setDismissButtonVisibility(false);
    }
}

@Component({
    selector: 'app-template-modal-predefined',
    template: AppModalBaseComponentTemplate
})
export class AppTemplateModalPredefinedComponent extends AppModalBaseComponent {
    constructor(modalManager: ModalManagerService) {
        super(modalManager);
    }
}

@Component({
    selector: 'app-template-modal-default',
    template: AppModalBaseComponentTemplate
})
export class AppTemplateModalDefaultComponent extends AppModalBaseComponent {
    constructor(modalManager: ModalManagerService) {
        super(modalManager);
    }
}

@SeDowngradeComponent()
@Component({
    selector: 'app-root',
    template: `
        <div class="smartedit-testing-overlay">
            <button id="openModal" (click)="openModal()">Open Modal</button>
            <button id="openModalWithPredefinedConfig" (click)="openModalWithPredefinedConfig()">
                Open Modal With Predefined Config
            </button>

            <div id="returnedData" *ngIf="returnedData">{{ returnedData }}</div>
        </div>
    `
})
export class AppRootComponent {
    public returnedData: string;

    constructor(private modalService: ModalService) {}

    public openModal(): void {
        // Set templateConfig to empty object so it is resolved as Modal Template Component that will be rendered within ModalTemplateComponent.
        // By providing templateConfig, the component can access ModalManagerService.
        this.modalService.open({ component: AppTemplateModalDefaultComponent, templateConfig: {} });
    }

    public openModalWithPredefinedConfig(): void {
        const ref: ModalRef = this.modalService.open({
            component: AppTemplateModalPredefinedComponent,
            templateConfig: {
                title: 'My Title',
                isDismissButtonVisible: true,
                buttons: [
                    {
                        id: 'id_0',
                        label: 'my_label_0',
                        action: ModalButtonAction.Close,
                        style: ModalButtonStyle.Default,
                        callback: () => of('My Returned Data'),
                        compact: false,
                        disabled: false
                    },
                    {
                        id: 'id_1',
                        label: 'my_label_1',
                        action: ModalButtonAction.Dismiss,
                        style: ModalButtonStyle.Primary,
                        compact: false,
                        disabled: true
                    }
                ]
            }
        });

        ref.afterClosed.subscribe(
            (returnedData: string) => {
                this.returnedData = returnedData;
            },
            () => (this.returnedData = 'Modal dismissed')
        );
    }
}

@SeEntryModule('ModalApp')
@NgModule({
    imports: [SmarteditCommonsModule, CommonModule],
    declarations: [
        AppRootComponent,
        AppTemplateModalDefaultComponent,
        AppTemplateModalPredefinedComponent
    ],
    entryComponents: [
        AppRootComponent,
        AppTemplateModalDefaultComponent,
        AppTemplateModalPredefinedComponent
    ]
})
export class ModalApp {}
