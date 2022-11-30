/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import '../base/smarteditcontainer/base-container-app';

import { CommonModule } from '@angular/common';
import { Component, NgModule } from '@angular/core';

import { IAnnouncementService, SeDowngradeComponent, SeEntryModule } from 'smarteditcommons';

@Component({
    selector: 'announcement-mock',
    template: ` <div>This is an announcement component<br />message: {{ message }}</div> `
})
class MockAnnouncementComponent {
    message = 'Component Based Announcement Message';
}

@SeDowngradeComponent()
@Component({
    selector: 'app-root',
    template: `
        <div class="btn-group" class="smartedit-testing-overlay">
            <h2>Announcement Tester</h2>
            <button
                id="test-announcement-non-closeable-button"
                (click)="showNonCloseableAnnouncement()"
            >
                Show Non Closeable announcement
            </button>
            <button id="test-announcement-simple-button" (click)="showSimpleAnnouncement()">
                Show Simple Announcement
            </button>
            <button
                id="test-announcement-component-button"
                (click)="showComponentBasedAnnouncement()"
            >
                Show Component Based Announcement
            </button>
        </div>
    `,
    styles: [
        `
            .btn-group button {
                background-color: #4caf50;
                color: white;
                padding: 10px 24px;
                cursor: pointer;
                width: 80%;
                display: block;
                margin-top: 10px;
            }

            .btn-group button:hover {
                background-color: #3e8e41;
            }
        `
    ]
})
export class AppRootComponent {
    constructor(private announcementService: IAnnouncementService) {}

    public showSimpleAnnouncement(): void {
        this.announcementService.showAnnouncement({
            messageTitle: 'This is the message title',
            message: 'This is a simple announcement',
            timeout: 5000
        });
    }

    public showNonCloseableAnnouncement(): void {
        this.announcementService.showAnnouncement({
            message: 'This is a non closeable announcement',
            closeable: false,
            timeout: 5000
        });
    }

    public showComponentBasedAnnouncement(): void {
        this.announcementService.showAnnouncement({
            component: MockAnnouncementComponent
        });
    }
}

window.__smartedit__.smartEditContainerAngularApps = [];

@SeEntryModule('annoucementApp')
@NgModule({
    imports: [CommonModule],
    declarations: [AppRootComponent, MockAnnouncementComponent],
    entryComponents: [AppRootComponent, MockAnnouncementComponent]
})
export class AnnoucementAppNg {}

window.pushModules(AnnoucementAppNg);
