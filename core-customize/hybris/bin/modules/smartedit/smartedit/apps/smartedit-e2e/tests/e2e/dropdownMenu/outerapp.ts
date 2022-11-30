/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import '../base/smarteditcontainer/base-container-app';

import { Component, NgModule } from '@angular/core';
import '../../utils/commonMockedModules/outerGlobalBasePathFetchMock';

import {
    IDropdownMenuItem,
    SeDowngradeComponent,
    SeEntryModule,
    SharedComponentsModule
} from 'smarteditcommons';

@Component({
    selector: 'dropdown-menu-item-mock',
    template: ` <div>{{ key }}</div> `
})
export class MockDropdownMenuItemComponent {
    key = 'Mock Item Key';
}

@SeDowngradeComponent()
@Component({
    selector: 'app-root',
    template: `
        <div class="smartedit-testing-overlay">
            <h2>DropdownMenu Tester</h2>
            <div class="btn-group">
                <button
                    id="test-dropdown-menu-item-component-button"
                    (click)="openComponentBasedDropdownMenuItem()"
                >
                    Open with Component Based Dropdown Menu Item
                </button>
                <button
                    id="test-dropdown-menu-item-default-component-button"
                    (click)="openDefaultComponentBasedDropdownMenuItem()"
                >
                    Open with Default Component Based Dropdown Menu Item
                </button>
            </div>
            <se-dropdown-menu
                [dropdownItems]="dropdownItems"
                [selectedItem]="selectedItem"
            ></se-dropdown-menu>
        </div>
    `,
    styles: [
        `
            se-dropdown-menu {
                display: block;
                margin: 0 auto;
                width: 20px;
            }
        `
    ]
})
export class AppRootComponent {
    dropdownItems: IDropdownMenuItem[] = [];
    selectedItem: any;

    public openComponentBasedDropdownMenuItem(): void {
        this.dropdownItems = [
            {
                component: MockDropdownMenuItemComponent
            }
        ];
    }

    public openDefaultComponentBasedDropdownMenuItem(): void {
        this.dropdownItems = [
            {
                key: 'Default Component Item Key',
                callback() {
                    //
                }
            }
        ];
    }
}

@SeEntryModule('dropdownMenuApp')
@NgModule({
    imports: [SharedComponentsModule],
    declarations: [AppRootComponent, MockDropdownMenuItemComponent],
    entryComponents: [AppRootComponent, MockDropdownMenuItemComponent]
})
export class DropdownMenuApp {}
