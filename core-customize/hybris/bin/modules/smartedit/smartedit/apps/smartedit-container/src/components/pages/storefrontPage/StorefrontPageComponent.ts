/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { Component, Inject, OnInit } from '@angular/core';
import {
    BrowserService,
    IExperienceService,
    SeDowngradeComponent,
    YJQUERY_TOKEN,
    CrossFrameEventService,
    EVENT_PERSPECTIVE_UNLOADING,
    EVENT_PAGE_TREE_PANEL_SWITCH,
    EVENT_OPEN_IN_PAGE_TREE,
    IStorageService,
    IPermissionService
} from 'smarteditcommons';
import { IframeManagerService } from '../../../services/iframe/IframeManagerService';

/**
 * Component responsible of displaying the SmartEdit storefront page.
 *
 * @internal
 * @ignore
 */
@SeDowngradeComponent()
@Component({
    selector: 'se-storefront-page',
    templateUrl: './StorefrontPageComponent.html',
    styleUrls: ['./StorefrontPageComponent.scss']
})
export class StorefrontPageComponent implements OnInit {
    private readonly PAGE_TREE_PANEL_OPEN_COOKIE_NAME: string = 'smartedit-page-tree-panel-open';
    private isPageTreePanelOpen = false;

    constructor(
        private readonly browserService: BrowserService,
        private readonly iframeManagerService: IframeManagerService,
        private readonly experienceService: IExperienceService,
        @Inject(YJQUERY_TOKEN) private readonly yjQuery: JQueryStatic,
        private readonly crossFrameEventService: CrossFrameEventService,
        private readonly storageService: IStorageService,
        private readonly permissionService: IPermissionService
    ) {}

    async ngOnInit(): Promise<void> {
        this.iframeManagerService.applyDefault();
        await this.experienceService.initializeExperience();
        this.yjQuery(document.body).addClass('is-storefront');

        if (this.browserService.isSafari()) {
            this.yjQuery(document.body).addClass('is-safari');
        }

        const pageTreePanelStatus = await this.storageService.getValueFromLocalStorage(
            this.PAGE_TREE_PANEL_OPEN_COOKIE_NAME,
            true
        );

        const allowed = await this.permissionService.isPermitted([
            {
                names: ['se.read.page']
            }
        ]);

        this.isPageTreePanelOpen = pageTreePanelStatus && allowed;

        this.crossFrameEventService.subscribe(EVENT_PAGE_TREE_PANEL_SWITCH, () => {
            this.isPageTreePanelOpen = !this.isPageTreePanelOpen;
            this.updateStorage();
        });
        this.crossFrameEventService.subscribe(EVENT_OPEN_IN_PAGE_TREE, () => {
            if (!this.isPageTreePanelOpen) {
                this.isPageTreePanelOpen = true;
                this.updateStorage();
            }
        });
        this.crossFrameEventService.subscribe(EVENT_PERSPECTIVE_UNLOADING, () => {
            this.isPageTreePanelOpen = false;
            this.updateStorage();
        });
    }

    showPageTreeList(): boolean {
        return this.isPageTreePanelOpen;
    }

    private updateStorage(): void {
        this.storageService.setValueInLocalStorage(
            this.PAGE_TREE_PANEL_OPEN_COOKIE_NAME,
            this.isPageTreePanelOpen,
            true
        );
    }
}
