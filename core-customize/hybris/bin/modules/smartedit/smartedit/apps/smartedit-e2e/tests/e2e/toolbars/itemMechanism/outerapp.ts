/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import '../../base/smarteditcontainer/base-container-app';
import { CommonModule } from '@angular/common';
import { Component, NgModule } from '@angular/core';

import {
    CrossFrameEventService,
    HttpBackendService,
    HIDE_TOOLBAR_ITEM_CONTEXT,
    IToolbarServiceFactory,
    SeDowngradeComponent,
    SeEntryModule,
    SHOW_TOOLBAR_ITEM_CONTEXT,
    ToolbarItemType,
    WindowUtils,
    IToolbarService
} from 'smarteditcommons';

@SeDowngradeComponent()
@Component({
    selector: 'action-context',
    template: ` <div>Action 5 - Context</div> `
})
export class ActionContextComponent {}
@SeDowngradeComponent()
@Component({
    selector: 'hybrid-action-context',
    template: `<div>Hybrid Action 6 - Context</div>`
})
export class HybridActionContextComponent {}

@SeDowngradeComponent()
@Component({
    selector: 'standard',
    template: ` <span id="standardTemplate">STANDARD TEMPLATE</span> `
})
export class StandardComponent {}

@SeDowngradeComponent()
@Component({
    selector: 'hybrid-action',
    template: ` <span id="hybridActiontemplate">HYBRID ACTION TEMPLATE</span> `
})
export class HybridActionComponent {}
@SeDowngradeComponent()
@Component({
    selector: 'outer-app-root',
    template: `
        <div class="outer-app-root">
            <label>Smart edit container</label>
            <button class="click-outside-target">Click outside target</button>
            <button id="clear-toolbar" (click)="clearToolbar()">Clear toolbar</button>
            <button id="sendActionsOuter" class="btg btg-default" (click)="sendActions()">
                Send actions from outer to outer
            </button>
            <label id="message">{{ message }}</label>

            <br />
            <button id="removeActionsOuter" class="btg btg-default" (click)="removeActions()">
                Remove actions from outer
            </button>

            <button
                id="showActionToolbarContext5"
                class="btg btg-default"
                (click)="showActionToolbarContext5()"
            >
                Hide Hybrid Action Toolbar Context 5
            </button>

            <button
                id="showHybridActionToolbarContext"
                class="btg btg-default"
                (click)="showHybridActionToolbarContext()"
            >
                Show Hybrid Action Toolbar Context
            </button>

            <button
                id="hideHybridActionToolbarContext"
                class="btg btg-default"
                (click)="hideHybridActionToolbarContext()"
            >
                Hide Hybrid Action Toolbar Context
            </button>
        </div>
    `
})
export class AppRootComponent {
    public message: string;
    public toolbarService: IToolbarService;
    public testRoot: string;
    private readonly KEY_TOOLBAR_ACTION5 = 'toolbar.action.action5';
    private readonly KEY_TOOLBAR_ACTION6 = 'toolbar.action.action6';
    constructor(
        public toolbarServiceFactory: IToolbarServiceFactory,
        public httpBackendService: HttpBackendService,
        public crossFrameEventService: CrossFrameEventService,
        public windowUtils: WindowUtils
    ) {
        this.toolbarService = toolbarServiceFactory.getToolbarService('smartEditHeaderToolbar');
        this.testRoot = '../../test/e2e/toolbars/itemMechanism/';
    }

    clearToolbar() {
        (this.toolbarService as any).aliases = [];
        this.toolbarService.removeItemByKey('headerToolbar.logoTemplate');
    }
    sendActions() {
        this.toolbarService.addItems([
            {
                key: this.KEY_TOOLBAR_ACTION5,
                type: ToolbarItemType.ACTION,
                nameI18nKey: this.KEY_TOOLBAR_ACTION5,
                callback: () => {
                    this.message = 'Action 5 called';
                },
                icons: [this.testRoot + 'icon5.png'],
                component: StandardComponent,
                contextComponent: ActionContextComponent
            },
            {
                key: 'toolbar.standardTemplate',
                type: ToolbarItemType.TEMPLATE,
                component: StandardComponent
            },
            {
                key: this.KEY_TOOLBAR_ACTION6,
                type: ToolbarItemType.HYBRID_ACTION,
                nameI18nKey: this.KEY_TOOLBAR_ACTION6,
                callback: () => {
                    this.message = 'Action 6 called';
                },
                icons: [this.testRoot + 'icon6.png'],
                component: HybridActionComponent,
                contextComponent: HybridActionContextComponent
            },
            {
                key: 'toolbar.action.action8',
                type: ToolbarItemType.ACTION,
                nameI18nKey: 'Icon Test',
                callback: () => {
                    this.message = 'Action 8 called';
                },
                iconClassName: 'hyicon hyicon-clone se-toolbar-menu-ddlb--button__icon'
            }
        ]);
    }

    removeActions() {
        this.toolbarService.removeItemByKey('toolbar.standardTemplate');
        this.toolbarService.removeItemByKey(this.KEY_TOOLBAR_ACTION5);
    }

    showActionToolbarContext5() {
        this.crossFrameEventService.publish(SHOW_TOOLBAR_ITEM_CONTEXT, this.KEY_TOOLBAR_ACTION5);
    }

    showHybridActionToolbarContext() {
        this.crossFrameEventService.publish(SHOW_TOOLBAR_ITEM_CONTEXT, this.KEY_TOOLBAR_ACTION6);
    }

    hideHybridActionToolbarContext() {
        this.crossFrameEventService.publish(HIDE_TOOLBAR_ITEM_CONTEXT, this.KEY_TOOLBAR_ACTION6);
    }
}

@SeEntryModule('Outerapp')
@NgModule({
    imports: [CommonModule],
    declarations: [
        AppRootComponent,
        HybridActionComponent,
        StandardComponent,
        ActionContextComponent,
        HybridActionContextComponent
    ],
    entryComponents: [
        AppRootComponent,
        HybridActionComponent,
        StandardComponent,
        ActionContextComponent,
        HybridActionContextComponent
    ],
    providers: []
})
export class Outerapp {}
