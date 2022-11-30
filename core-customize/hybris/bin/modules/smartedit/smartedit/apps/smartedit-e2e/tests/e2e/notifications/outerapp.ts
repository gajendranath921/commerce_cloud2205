/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import '../base/smarteditcontainer/base-container-app';
import { Component, NgModule, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

import {
    IExperienceService,
    INotificationConfiguration,
    INotificationService,
    SeCustomComponent,
    SeDowngradeComponent,
    SeEntryModule
} from 'smarteditcommons';

@SeCustomComponent()
@Component({
    selector: 'notification-mock',
    template: ` <div>This is a test component based notification</div> `
})
export class MockNotificationComponent {}

@SeDowngradeComponent()
@Component({
    selector: 'app-root',
    template: `
        <div style="position: absolute; top: 0px; left: 0; background-color: white; z-index: 10000">
            <div class="se-notification-tester">
                <h2>Notification Tester</h2>
                <div class="row">
                    <div class="col-xs-6">
                        <form>
                            <div class="form-group">
                                <h5>ID</h5>
                                <input
                                    id="test-notification-id"
                                    class="form-control"
                                    type="text"
                                    name="id"
                                    [(ngModel)]="configuration.id"
                                />
                            </div>
                        </form>
                    </div>
                </div>
                <button
                    id="test-notification-push-button"
                    class="btn btn-primary"
                    (click)="pushNotification()"
                >
                    Push
                </button>
                <button
                    id="test-notification-remove-button"
                    class="btn btn-secondary"
                    (click)="removeNotification()"
                >
                    Remove
                </button>
                <button
                    id="test-notification-remove-all-button"
                    class="btn btn-secondary"
                    (click)="removeAllNotifications()"
                >
                    Remove All
                </button>
                <button
                    id="test-notification-reset-button"
                    class="btn btn-secondary"
                    (click)="reset()"
                >
                    Reset
                </button>
            </div>

            <button
                id="test-notification-goto-storefront"
                class="btn btn-secondary"
                (click)="goToStorefront()"
            >
                Go to Storefront
            </button>
        </div>

        <div class="se-notification-clickthrough">
            Clickthrough Tester
            <input type="checkbox" id="test-notification-clickthrough-checkbox" />
        </div>
    `,
    styles: [
        `
            .se-notification-tester {
                padding: 8pt;
            }

            .se-notification-clickthrough {
                position: fixed;
                bottom: 89px;
                right: 89px;
                z-index: 50;
            }

            .se-notification-panel {
                z-index: 1010;
            }
        `
    ]
})
export class AppRootComponent implements OnInit {
    public configuration: INotificationConfiguration;

    private MOCK_NOTIFICATION_ID = 'MOCK_NOTIFICATION';
    private MOCK_NOTIFICATION_COMPONENT_NAME = MockNotificationComponent.name;

    constructor(
        private notificationService: INotificationService,
        private experienceService: IExperienceService
    ) {}

    ngOnInit() {
        this.reset();

        const MOCK_NOTIFICATION_COUNT = 5;

        let mockNotificationIndex = 0;
        // without setTimeout "ExpressionChangedAfterItHasBeenCheckedError" is thrown. Only for e2e
        setTimeout(() => {
            while (mockNotificationIndex++ < MOCK_NOTIFICATION_COUNT) {
                this.notificationService.pushNotification({
                    id: this.MOCK_NOTIFICATION_ID + mockNotificationIndex,
                    componentName: this.MOCK_NOTIFICATION_COMPONENT_NAME
                });
            }
        });
    }

    public pushNotification(): void {
        this.notificationService.pushNotification({
            ...this.configuration,
            componentName: this.MOCK_NOTIFICATION_COMPONENT_NAME
        });

        this.reset();
    }

    public removeNotification(): void {
        this.notificationService.removeNotification(this.configuration.id);
    }

    public removeAllNotifications(): void {
        this.notificationService.removeAllNotifications();
    }

    public reset(): void {
        this.configuration = {
            id: '',
            componentName: ''
        };
    }

    public goToStorefront(): void {
        this.experienceService.loadExperience({
            siteId: 'apparel-uk',
            catalogId: 'apparel-ukContentCatalog',
            catalogVersion: 'Staged'
        });
    }
}

@SeEntryModule('notificationApp')
@NgModule({
    imports: [FormsModule],
    declarations: [AppRootComponent, MockNotificationComponent],
    entryComponents: [AppRootComponent, MockNotificationComponent]
})
export class NotificationAppNg {}
