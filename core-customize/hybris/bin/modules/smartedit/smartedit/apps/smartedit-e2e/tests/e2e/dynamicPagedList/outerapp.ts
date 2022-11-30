/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import '../base/smarteditcontainer/base-container-app';

import { CommonModule } from '@angular/common';
import { Component, NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import {
    moduleUtils,
    DynamicPagedListConfig,
    DynamicPagedListModule,
    IDropdownMenuItem,
    IPermissionService,
    SeDowngradeComponent,
    SeEntryModule,
    HasOperationPermissionDirectiveModule,
    DropdownMenuModule
} from 'smarteditcommons';

@SeDowngradeComponent()
@Component({
    selector: 'mock-dropdown-items',
    template: `
        <div
            *seHasOperationPermission="'se.edit.page'"
            class="paged-list-table__body__td paged-list-table__body__td-menu"
        >
            <se-dropdown-menu
                [dropdownItems]="dropdownItems"
                class="pull-right"
                [ngClass]="{ 'dropdown-item-clicked': isClicked }"
            ></se-dropdown-menu>
        </div>
    `
})
class MockDropdownItemsComponent {
    public dropdownItems: IDropdownMenuItem[];
    public isClicked: boolean;

    constructor() {
        this.dropdownItems = [
            {
                key: 'pagelist.dropdown.edit',
                callback: () => {
                    this.isClicked = true;
                }
            }
        ];
        this.isClicked = false;
    }
}

@SeDowngradeComponent()
@Component({
    selector: 'app-root',
    template: `
        <div class="page-list-search form-group smartedit-testing-overlay">
            <input type="text" class="form-control" [(ngModel)]="query.value" name="query" />
        </div>

        <se-dynamic-paged-list
            [config]="pagedListConfig"
            [mask]="query.value"
        ></se-dynamic-paged-list>
    `
})
export class AppRootComponent {
    public query = {
        value: ''
    };

    public pagedListConfig: DynamicPagedListConfig = {
        sortBy: 'name',
        queryParams: null,
        reversed: false,
        itemsPerPage: 10,
        displayCount: true,
        uri: '/pagedItems',
        keys: [
            {
                property: 'name',
                i18n: 'pagelist.headerpagetitle',
                sortable: true
            },
            {
                property: 'uid',
                i18n: 'pagelist.headerpageid',
                sortable: false
            },
            {
                property: 'typeCode',
                i18n: 'pagelist.headerpagetype',
                sortable: false
            },
            {
                property: 'dropdownitems',
                i18n: '',
                sortable: false,
                component: MockDropdownItemsComponent
            }
        ]
    };
}
@SeEntryModule('OuterApp')
@NgModule({
    imports: [
        CommonModule,
        DynamicPagedListModule,
        FormsModule,
        HasOperationPermissionDirectiveModule,
        DropdownMenuModule
    ],
    declarations: [AppRootComponent, MockDropdownItemsComponent],
    entryComponents: [AppRootComponent, MockDropdownItemsComponent],
    providers: [
        moduleUtils.bootstrap(
            (permissionService: IPermissionService) => {
                const urlParams = new URLSearchParams(window.location.search);
                window.sessionStorage.setItem(
                    'PERSPECTIVE_SERVICE_RESULT',
                    urlParams.get('perspectiveServiceResult')
                );

                permissionService.registerRule({
                    names: ['se.some.rule'],
                    verify() {
                        return Promise.resolve(
                            window.sessionStorage.getItem('PERSPECTIVE_SERVICE_RESULT') === 'true'
                        );
                    }
                });

                permissionService.registerPermission({
                    aliases: ['se.edit.page'],
                    rules: ['se.some.rule']
                });
            },
            [IPermissionService]
        )
    ]
})
export class OuterApp {}

window.pushModules(OuterApp);
