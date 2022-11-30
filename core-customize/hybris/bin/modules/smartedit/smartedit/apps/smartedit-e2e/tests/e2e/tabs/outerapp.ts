/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* forbiddenNameSpaces angular.module:false */
import '../base/smarteditcontainer/base-container-app';
import { CommonModule } from '@angular/common';
import { Component, Inject, NgModule } from '@angular/core';
import {
    SeDowngradeComponent,
    SeEntryModule,
    SharedComponentsModule,
    Tab,
    TAB_DATA
} from 'smarteditcommons';

const SELECTOR_TAB_CONTENT = 'tab-content';
@SeDowngradeComponent()
@Component({
    selector: 'app-root',
    template: `
        <div class="smartedit-testing-overlay">
            <tabs-one></tabs-one>
            <tabs-two></tabs-two>
        </div>
    `
})
export class AppRootComponent {}

@Component({
    selector: 'tabs-one',
    template: `
        <div id="tabs-one">
            <se-tabs [tabsList]="tabs" [numTabsDisplayed]="3"> </se-tabs>
            <button id="add-error-0" (click)="addError(0)">Add error to tab one</button>
            <button id="add-error-2" (click)="addError(2)">Add error to tab three</button>
            <button id="reset-errors" (click)="resetErrors()">Reset errors</button>
        </div>
    `
})
export class TabsOneComponent {
    public tabs: Tab[] = [];

    ngOnInit() {
        this.buildTabs();
    }

    addError(ind: number) {
        this.tabs = this.tabs.map((tab, i) => ({ ...tab, hasErrors: i === ind }));
    }

    resetErrors() {
        this.tabs = this.tabs.map((tab) => ({ ...tab, hasErrors: false }));
    }

    private buildTabs(): void {
        this.tabs = [
            {
                id: 'tab1',
                title: 'tab1.name',
                component: TabContentComponent,
                hasErrors: false
            },
            {
                id: 'tab2',
                title: 'tab2.name',
                component: TabContent2Component,
                hasErrors: false
            },
            {
                id: 'tab3',
                title: 'tab3.name',
                component: TabContent3Component,
                hasErrors: false
            },
            {
                id: 'tab4',
                title: 'tab4.name',
                component: TabContent4Component,
                hasErrors: false
            }
        ];
    }
}

@Component({
    selector: SELECTOR_TAB_CONTENT,
    template: ` <div>Tab 1 Content</div> `
})
export class TabContentComponent {
    constructor(@Inject(TAB_DATA) public tabData: any) {}
}

@Component({
    selector: SELECTOR_TAB_CONTENT,
    template: ` <div>Tab 2 Content</div> `
})
export class TabContent2Component {
    constructor(@Inject(TAB_DATA) public tabData: any) {}
}

@Component({
    selector: SELECTOR_TAB_CONTENT,
    template: ` <div>Tab 3 Content</div> `
})
export class TabContent3Component {
    constructor(@Inject(TAB_DATA) public tabData: any) {}
}

@Component({
    selector: SELECTOR_TAB_CONTENT,
    template: ` <div>Tab 4 Content</div> `
})
export class TabContent4Component {
    constructor(@Inject(TAB_DATA) public tabData: any) {}
}

@Component({
    selector: 'tabs-two',
    template: `
        <div id="tabs-two">
            <se-tabs [tabsList]="tabs" [model]="model" [numTabsDisplayed]="3"> </se-tabs>
        </div>
    `
})
export class TabsTwoComponent {
    public model: any = {
        data: 'Tab Content'
    };

    public tabs: Tab[] = [
        {
            id: 'tab1',
            title: 'tab1.name',
            component: TabContentComponent,
            hasErrors: false
        },
        {
            id: 'tab2',
            title: 'tab2.name',
            component: TabContent2Component,
            hasErrors: false
        },
        {
            id: 'tab3',
            title: 'tab3.name',
            component: TabContent3Component,
            hasErrors: false
        },
        {
            id: 'tab4',
            title: 'tab4.name',
            component: TabContent4Component,
            hasErrors: false
        }
    ];
}

@SeEntryModule('tabsApp')
@NgModule({
    imports: [SharedComponentsModule, CommonModule],
    declarations: [
        AppRootComponent,
        TabsOneComponent,
        TabsTwoComponent,
        TabContentComponent,
        TabContent2Component,
        TabContent3Component,
        TabContent4Component
    ],
    entryComponents: [
        AppRootComponent,
        TabsOneComponent,
        TabsTwoComponent,
        TabContentComponent,
        TabContent2Component,
        TabContent3Component,
        TabContent4Component
    ]
})
export class TabsAppNg {}
