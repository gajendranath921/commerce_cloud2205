/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import '../base/smarteditcontainer/base-container-app';

import { CommonModule } from '@angular/common';
import { Component, NgModule } from '@angular/core';
import { FormsModule, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

import {
    IAlertConfig,
    IAlertService,
    IAlertServiceType,
    SeDowngradeComponent,
    SeEntryModule
} from 'smarteditcommons';

@SeDowngradeComponent()
@Component({
    selector: 'app-root',
    template: `
        <div
            class="container"
            style="position: fixed; z-index: 1000; top: 150px; left: 0; width: 100vw; height: 100vh; background-color: white"
        >
            <h2>Show a system alert</h2>
            <div class="row">
                <div class="col-xs-6">
                    <form [formGroup]="form">
                        <div class="form-group">
                            <h5>Message</h5>
                            <textarea
                                id="test-alert-message"
                                class="form-control"
                                type="text"
                                name="alert-message"
                                formControlName="message"
                            ></textarea>
                        </div>
                        <div class="form-group">
                            <h5>Message Placeholder (evaluated to object)</h5>
                            <input
                                id="test-alert-message-placeholder"
                                class="form-control"
                                type="text"
                                name="message-placeholders"
                                formControlName="messagePlaceholders"
                            />
                        </div>
                        <div class="form-group">
                            <h5>Type</h5>
                            <select
                                id="test-alert-type"
                                class="form-control"
                                name="mySelect"
                                formControlName="type"
                            >
                                <option *ngFor="let type of types" [value]="type">
                                    {{ type }}
                                </option>
                            </select>
                        </div>
                        <div class="form-group">
                            <h5>Closeable</h5>
                            <input
                                id="test-alert-closeable"
                                class="form-control"
                                type="checkbox"
                                name="closeable"
                                formControlName="closeable"
                            />
                        </div>
                        <div class="form-group">
                            <h5>Timeout</h5>
                            <input
                                id="test-alert-timeout"
                                class="form-control"
                                type="number"
                                step="1"
                                name="timeout"
                                formControlName="timeout"
                            />
                        </div>
                        <div class="form-group">
                            <h5>Create multiple (not for automation)</h5>
                            <input
                                class="form-control"
                                type="number"
                                step="1"
                                name="count"
                                formControlName="count"
                            />
                        </div>
                    </form>
                </div>
            </div>
            <button id="test-alert-add-button" class="btn btn-primary" (click)="addAlert()">
                Show Alert
            </button>
            <button id="test-alert-reset-button" class="btn btn-secondary" (click)="reset()">
                Reset
            </button>
        </div>
    `
})
export class AppRootComponent {
    public form: FormGroup = new FormGroup({
        message: new FormControl(undefined),
        type: new FormControl(IAlertServiceType.INFO),
        messagePlaceholders: new FormControl(),
        closeable: new FormControl(true),
        count: new FormControl(1),
        timeout: new FormControl(),
        template: new FormControl(),
        templateUrl: new FormControl(),
        controller: new FormControl()
    });

    public types: IAlertServiceType[] = [
        IAlertServiceType.INFO,
        IAlertServiceType.WARNING,
        IAlertServiceType.DANGER,
        IAlertServiceType.SUCCESS
    ];

    constructor(private alertService: IAlertService) {}

    ngOnInit() {
        this.form.valueChanges.subscribe(() => {
            this.composeConfig();
        });
    }

    public addAlert(): void {
        this.showAlert(this.composeConfig());
    }

    public reset(): void {
        this.form.reset();
    }

    private composeConfig(): IAlertConfig {
        const placeholders = this.form.get('messagePlaceholders').value;

        return {
            message: this.form.get('message').value,
            type: this.form.get('type').value,
            dismissible: this.form.get('closeable').value,
            duration: this.form.get('timeout').value,
            messagePlaceholders: placeholders ? JSON.parse(placeholders) : null
        };
    }

    private get count(): number {
        return (this.form.get('count').value as number) || 1;
    }

    private showAlert(config: IAlertConfig): void {
        for (let i = 0; i < this.count; i++) {
            this.alertService.showAlert(config);
        }
    }
}

@SeEntryModule('OuterappModule')
@NgModule({
    imports: [CommonModule, FormsModule, ReactiveFormsModule],
    declarations: [AppRootComponent],
    entryComponents: [AppRootComponent]
})
export class OuterappModule {}

window.__smartedit__.smartEditContainerAngularApps = [];
window.__smartedit__.smartEditInnerAngularApps = [];

window.pushModules(OuterappModule);
