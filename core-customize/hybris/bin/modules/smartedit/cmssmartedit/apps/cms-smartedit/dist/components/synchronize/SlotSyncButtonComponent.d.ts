import { OnInit, OnDestroy, DoCheck } from '@angular/core';
import { CrossFrameEventService, PopupOverlayConfig, IPageInfoService, ContextualMenuItemData } from 'smarteditcommons';
import { SlotSynchronizationService } from '../../services/SlotSynchronizationService';
export declare class SlotSyncButtonComponent implements OnInit, OnDestroy, DoCheck {
    private contextualMenuItem;
    private slotSynchronizationService;
    private pageInfoService;
    private crossFrameEventService;
    isPopupOpened: boolean;
    isReady: boolean;
    isSlotInSync: boolean;
    newSlotIsNotSynchronized: boolean;
    popupConfig: PopupOverlayConfig;
    slotIsShared: boolean;
    private buttonName;
    private isPopupOpenedPreviousValue;
    private unregisterOuterFrameClicked;
    private unregisterSyncPolling;
    constructor(contextualMenuItem: ContextualMenuItemData, slotSynchronizationService: SlotSynchronizationService, pageInfoService: IPageInfoService, crossFrameEventService: CrossFrameEventService);
    ngOnInit(): Promise<void>;
    ngOnDestroy(): void;
    ngDoCheck(): void;
    get slotId(): string;
    dropdownToggle(): void;
    onPopupHide(): void;
    private getSyncStatus;
    private statusIsInSync;
    private slotHasBeenSynchronizedAtLeastOnce;
}
