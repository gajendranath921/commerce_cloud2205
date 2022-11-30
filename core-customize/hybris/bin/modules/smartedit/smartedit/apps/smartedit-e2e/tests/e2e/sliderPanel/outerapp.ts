/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import '../base/smarteditcontainer/base-container-app';
import { CommonModule } from '@angular/common';
import { Component, NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import {
    IConfirmationModalService,
    IModalService,
    SeDowngradeComponent,
    SeEntryModule,
    SliderPanelModule
} from 'smarteditcommons';

@SeDowngradeComponent()
@Component({
    selector: 'app-root',
    template: `
        <div class="smartedit-testing-overlay">
            <button id="button_openModal" class="btn btn-default" (click)="openModal()">
                Open Modal
            </button>

            <button class="btn btn-default" (click)="sliderPanelShow1()">Show primary panel</button>

            <se-slider-panel
                [(sliderPanelShow)]="sliderPanelShow1"
                [(sliderPanelHide)]="sliderPanelHide1"
                [sliderPanelConfiguration]="sliderPanelConfiguration1"
            >
                <p>This is the content of the primary slider panel</p>
                <button class="btn btn-default" (click)="sliderPanelShow2()">
                    Show secondary panel
                </button>
            </se-slider-panel>

            <se-slider-panel
                [(sliderPanelShow)]="sliderPanelShow2"
                [(sliderPanelHide)]="sliderPanelHide2"
                [sliderPanelConfiguration]="sliderPanelConfiguration2"
            >
                <p>This is the content of the secondary slider panel</p>
            </se-slider-panel>
        </div>
    `
})
export class AppRootComponent {
    paragraphs = Array(4).fill(0);

    sliderPanelConfiguration1 = {
        modal: {
            showDismissButton: true,
            title: 'Primary panel'
        }
    };

    sliderPanelConfiguration2 = {
        modal: {
            showDismissButton: true,
            cancel: {
                onClick: () => {
                    this.sliderPanelHide2();
                },
                label: 'se.cms.component.confirmation.modal.cancel'
            },
            save: {
                onClick: () => {
                    this.sliderPanelHide2();
                },
                label: 'se.cms.component.confirmation.modal.save'
            },
            title: 'Awesome, a secondary panel!'
        }
    };

    public sliderPanelHide1: () => void;
    public sliderPanelHide2: () => void;

    public sliderPanelShow1: () => void;
    public sliderPanelShow2: () => void;

    constructor(private modalService: IModalService) {
        this.sliderPanelHide1 = this.sliderPanelHide2 = function () {
            //
        };
        this.sliderPanelShow1 = this.sliderPanelShow2 = function () {
            //
        };
    }

    openModal() {
        this.modalService.open({
            component: SliderPanelModalComponent,
            templateConfig: {
                title: 'Modal Title',
                isDismissButtonVisible: true
            },
            config: { focusTrapped: false }
        });
    }
}

@Component({
    selector: 'slider-panel-modal',
    template: `
        <div>
            <div>
                <button
                    id="button_showSliderPanel"
                    class="btn btn-default"
                    type="button"
                    (click)="sliderPanelShowModal()"
                >
                    Show Slider Panel
                </button>
            </div>

            <se-slider-panel
                [(sliderPanelShow)]="sliderPanelShowModal"
                [(sliderPanelHide)]="sliderPanelHideModal"
                [sliderPanelConfiguration]="sliderPanelConfigurationModal"
            >
                <form>
                    <p>
                        <span class="y-toggle y-toggle-lg">
                            <input
                                type="checkbox"
                                name="isDirtySwitch"
                                id="isDirtySwitch"
                                [(ngModel)]="isDirtyStatus"
                            />
                            <label
                                for="isDirtySwitch"
                                data-activelabel="On"
                                data-inactivelabel="Off"
                                >Switch isDirty</label
                            >
                        </span>
                    </p>
                    <p>
                        <span class="y-toggle y-toggle-lg">
                            <button
                                class="btn btn-default"
                                (click)="sliderPanelShowModalSecondary()"
                            >
                                Show secondary panel
                            </button>
                        </span>
                    </p>
                </form>

                <p *ngFor="let p of paragraphs">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed interdum mi ut
                    pellentesque scelerisque. Phasellus fermentum est sed luctus maximus. Sed
                    porttitor lobortis molestie. Nullam vel imperdiet enim. Maecenas maximus, arcu
                    non commodo rutrum, dolor augue posuere tellus, a iaculis libero mi ut arcu.
                    Integer maximus pretium urna, ac hendrerit dui sollicitudin a. Morbi eget justo
                    id augue feugiat placerat in vitae sem.
                </p>

                <img src="gliphy.gif" />
            </se-slider-panel>

            <se-slider-panel
                [(sliderPanelShow)]="sliderPanelShowModalSecondary"
                [(sliderPanelHide)]="sliderPanelHideModalSecondary"
                [sliderPanelConfiguration]="sliderPanelConfigurationModalSecondary"
            >
                <img src="gliphy.gif" />
            </se-slider-panel>
        </div>
    `
})
export class SliderPanelModalComponent {
    isDirtyStatus = false;
    sliderPanelShowModal: () => void;
    sliderPanelHideModal: () => void;
    sliderPanelShowModalSecondary: () => void;
    sliderPanelHideModalSecondary: () => void;
    paragraphs = Array(10).fill(0);
    sliderPanelConfigurationModal = {
        modal: {
            showDismissButton: true,
            cancel: {
                onClick: () => {
                    this.cancelSliderPanel();
                },
                label: 'Cancel'
            },
            save: {
                onClick: () => {
                    this.saveSliderPanel();
                },
                label: 'Save',
                isDisabledFn: () => {
                    return this.isSaveDisabled();
                }
            },
            dismiss: {
                onClick: () => {
                    this.dismissSliderPanel();
                }
            },
            title: 'Slider Panel Title'
        }
    };

    sliderPanelConfigurationModalSecondary = {
        modal: {
            showDismissButton: true,
            title: 'Secondary Slider Panel'
        }
    };

    constructor(private confirmationModalService: IConfirmationModalService) {}
    saveSliderPanel() {
        this.sliderPanelHideModal();
    }

    cancelSliderPanel() {
        this.sliderPanelHideModal();
    }

    dismissSliderPanel() {
        const message = {
            title: 'Dismiss',
            description: 'Do you want to dismiss ?'
        };

        (this.confirmationModalService.confirm(message) as Promise<any>).then(() => {
            this.sliderPanelHideModal();
        });
    }

    isSaveDisabled() {
        return !this.isDirtyStatus;
    }
}
@SeEntryModule('sliderPanelApp')
@NgModule({
    imports: [SliderPanelModule, CommonModule, FormsModule],
    declarations: [AppRootComponent, SliderPanelModalComponent],
    entryComponents: [AppRootComponent, SliderPanelModalComponent]
})
export class SliderPanelAppNg {}
