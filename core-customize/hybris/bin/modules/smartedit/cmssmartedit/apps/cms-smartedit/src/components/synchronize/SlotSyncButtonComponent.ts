/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { Component, OnInit, OnDestroy, Inject, ViewEncapsulation, DoCheck } from '@angular/core';
import {
    DEFAULT_SYNCHRONIZATION_POLLING,
    DEFAULT_SYNCHRONIZATION_STATUSES,
    ISyncStatus
} from 'cmscommons';
import {
    CrossFrameEventService,
    EVENT_OUTER_FRAME_CLICKED,
    PopupOverlayConfig,
    IPageInfoService,
    CONTEXTUAL_MENU_ITEM_DATA,
    ContextualMenuItemData
} from 'smarteditcommons';
import { SlotSynchronizationService } from '../../services/SlotSynchronizationService';

@Component({
    selector: 'slot-sync-button',
    templateUrl: './SlotSyncButtonComponent.html',
    styleUrls: ['./SlotSyncButtonComponent.scss'],
    encapsulation: ViewEncapsulation.None
})
export class SlotSyncButtonComponent implements OnInit, OnDestroy, DoCheck {
    public isPopupOpened: boolean;
    public isReady: boolean;
    public isSlotInSync: boolean;
    public newSlotIsNotSynchronized: boolean;
    public popupConfig: PopupOverlayConfig;
    public slotIsShared: boolean;

    private buttonName: string;
    private isPopupOpenedPreviousValue: boolean;
    private unregisterOuterFrameClicked: () => void;
    private unregisterSyncPolling: () => void;

    constructor(
        @Inject(CONTEXTUAL_MENU_ITEM_DATA) private contextualMenuItem: ContextualMenuItemData,
        private slotSynchronizationService: SlotSynchronizationService,
        private pageInfoService: IPageInfoService,
        private crossFrameEventService: CrossFrameEventService
    ) {
        this.buttonName = 'slotSyncButton';
        this.isPopupOpened = false;
        this.isReady = false;
        this.isSlotInSync = true;
        this.newSlotIsNotSynchronized = false;
        this.slotIsShared = false;

        this.popupConfig = {
            halign: 'left',
            valign: 'bottom',
            additionalClasses: [
                'se-slot-ctx-menu__divider',
                'se-slot-ctx-menu__dropdown-toggle-wrapper'
            ]
        };
    }

    ngOnInit(): Promise<void> {
        this.unregisterSyncPolling = this.crossFrameEventService.subscribe(
            DEFAULT_SYNCHRONIZATION_POLLING.FAST_FETCH,
            () => this.getSyncStatus()
        );

        this.unregisterOuterFrameClicked = this.crossFrameEventService.subscribe(
            EVENT_OUTER_FRAME_CLICKED,
            () => {
                this.isPopupOpened = false;
            }
        );

        return this.getSyncStatus();
    }

    ngOnDestroy(): void {
        this.unregisterSyncPolling();
        this.unregisterOuterFrameClicked();
    }

    ngDoCheck(): void {
        if (this.isPopupOpenedPreviousValue !== this.isPopupOpened) {
            // When I click on button so that the popover is displayed and then I move the cursor outside the decorator, the current decorator disappears and removes the popover from the DOM.
            // When the popover is opened, the decorator must be displayed unless I click outside.
            this.contextualMenuItem.setRemainOpen(this.buttonName, this.isPopupOpened);
            this.isPopupOpenedPreviousValue = this.isPopupOpened;
        }
    }

    public get slotId(): string {
        return this.contextualMenuItem.componentAttributes.smarteditComponentId;
    }

    public dropdownToggle(): void {
        this.isPopupOpened = !this.isPopupOpened;
    }

    public onPopupHide(): void {
        this.isPopupOpened = false;
    }

    private async getSyncStatus(): Promise<void> {
        const pageUUID = await this.pageInfoService.getPageUUID();
        const syncStatus = await this.slotSynchronizationService.getSyncStatus(
            pageUUID,
            this.slotId
        );
        if (this.slotSynchronizationService.syncStatusExists(syncStatus)) {
            this.isSlotInSync = this.statusIsInSync(syncStatus);
            this.newSlotIsNotSynchronized = this.slotHasBeenSynchronizedAtLeastOnce(syncStatus);
            this.slotIsShared = syncStatus.fromSharedDependency;

            this.isReady = true;
        } else {
            this.isReady = false;
        }
    }

    private statusIsInSync(syncStatus: ISyncStatus): boolean {
        return syncStatus?.status === DEFAULT_SYNCHRONIZATION_STATUSES.IN_SYNC;
    }

    private slotHasBeenSynchronizedAtLeastOnce(syncStatus: ISyncStatus): boolean {
        return !syncStatus.lastSyncStatus;
    }
}
