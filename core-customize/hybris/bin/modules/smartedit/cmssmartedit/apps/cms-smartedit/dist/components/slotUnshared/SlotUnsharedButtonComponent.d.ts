import { ChangeDetectorRef, DoCheck, OnDestroy, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { SlotUnsharedService } from 'cmssmartedit/services/SlotUnsharedService';
import { ComponentAttributes, CrossFrameEventService, ICatalogService, IConfirmationModalService, ISharedDataService, PopupOverlayConfig, LogService, ContextualMenuItemData, ComponentHandlerService, IPageInfoService, SlotSharedService } from 'smarteditcommons';
export declare class SlotUnsharedButtonComponent implements OnInit, OnDestroy, DoCheck {
    private contextualMenuItem;
    private catalogService;
    private confirmationModalService;
    private componentHandlerService;
    private crossFrameEventService;
    private slotUnsharedService;
    private sharedDataService;
    private slotSharedService;
    private translateService;
    private pageInfoService;
    private logService;
    private cdr;
    isPopupOpened: boolean;
    isExternalSlot: boolean;
    popupConfig: PopupOverlayConfig;
    removeSlotLinkLabel?: string;
    isSlotShared?: boolean;
    isSlotUnshared?: boolean;
    isCurrentPageFromParent?: boolean;
    isMultiCountry?: boolean;
    isLocalSlot?: boolean;
    isNonSharedSlot?: boolean;
    private isPopupOpenedPreviousValue;
    private readonly buttonName;
    private unRegOuterFrameClicked;
    constructor(contextualMenuItem: ContextualMenuItemData, catalogService: ICatalogService, confirmationModalService: IConfirmationModalService, componentHandlerService: ComponentHandlerService, crossFrameEventService: CrossFrameEventService, slotUnsharedService: SlotUnsharedService, sharedDataService: ISharedDataService, slotSharedService: SlotSharedService, translateService: TranslateService, pageInfoService: IPageInfoService, logService: LogService, cdr: ChangeDetectorRef);
    ngOnInit(): Promise<void>;
    ngOnDestroy(): void;
    ngDoCheck(): void;
    get componentAttributes(): ComponentAttributes;
    get slotId(): string;
    getHeader(): string;
    toggle(): void;
    hidePopup(): void;
    removeSlot(): Promise<void>;
    replaceSlot(event: MouseEvent): Promise<void>;
    private getRemoveSlotLinkLabel;
    private reload;
}
