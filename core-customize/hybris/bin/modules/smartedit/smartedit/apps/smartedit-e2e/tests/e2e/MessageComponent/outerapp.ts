/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { Component, NgModule } from '@angular/core';
import { MessageModule, SeDowngradeComponent, SeEntryModule } from 'smarteditcommons';

@SeDowngradeComponent()
@Component({
    selector: 'app-root',
    template: `
        <se-message [type]="'info'">
            <ng-container se-message-title>Message Title</ng-container>
            <ng-container se-message-description>Message Description</ng-container>
        </se-message>
    `
})
class AppRootComponent {}

@SeEntryModule('OuterApp')
@NgModule({
    imports: [MessageModule],
    declarations: [AppRootComponent],
    entryComponents: [AppRootComponent]
})
export class OuterApp {}

window.pushModules(OuterApp);
