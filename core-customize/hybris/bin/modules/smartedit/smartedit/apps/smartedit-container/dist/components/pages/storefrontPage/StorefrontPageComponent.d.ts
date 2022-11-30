/// <reference types="angular" />
/// <reference types="jquery" />
import { OnInit } from '@angular/core';
import { BrowserService, IExperienceService, CrossFrameEventService, IStorageService, IPermissionService } from 'smarteditcommons';
import { IframeManagerService } from '../../../services/iframe/IframeManagerService';
export declare class StorefrontPageComponent implements OnInit {
    private readonly browserService;
    private readonly iframeManagerService;
    private readonly experienceService;
    private readonly yjQuery;
    private readonly crossFrameEventService;
    private readonly storageService;
    private readonly permissionService;
    private readonly PAGE_TREE_PANEL_OPEN_COOKIE_NAME;
    private isPageTreePanelOpen;
    constructor(browserService: BrowserService, iframeManagerService: IframeManagerService, experienceService: IExperienceService, yjQuery: JQueryStatic, crossFrameEventService: CrossFrameEventService, storageService: IStorageService, permissionService: IPermissionService);
    ngOnInit(): Promise<void>;
    showPageTreeList(): boolean;
    private updateStorage;
}
