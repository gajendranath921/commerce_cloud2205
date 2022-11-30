/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { Component, DoCheck, Inject, OnDestroy, OnInit } from '@angular/core';
import {
    ComponentAttributes,
    CrossFrameEventService,
    EVENT_OUTER_FRAME_CLICKED,
    ICatalogService,
    PopupOverlayConfig,
    windowUtils,
    ContextualMenuItemData,
    CONTEXTUAL_MENU_ITEM_DATA,
    ComponentHandlerService,
    SlotSharedService,
    IPageInfoService
} from 'smarteditcommons';

@Component({
    selector: 'slot-shared-button',
    templateUrl: './SlotSharedButtonComponent.html'
})
export class SlotSharedButtonComponent implements OnInit, OnDestroy, DoCheck {
    public isExternalSlot: boolean;
    /**
     * Is slot shared by current content catalog version?
     * Checks only slots on the page (both page and template slots but not multicountry external slots)
     */
    public isSlotShared: boolean;
    public isGlobalSlot: boolean;
    public isPopupOpened: boolean;
    public popupConfig: PopupOverlayConfig;
    public labelL10nKey: string;
    public descriptionL10nKey: string;

    private isPopupOpenedPreviousValue: boolean;
    private readonly buttonName: string;
    private unRegOuterFrameClicked: () => void;

    constructor(
        @Inject(CONTEXTUAL_MENU_ITEM_DATA) private contextualMenuItem: ContextualMenuItemData,
        private catalogService: ICatalogService,
        private componentHandlerService: ComponentHandlerService,
        private crossFrameEventService: CrossFrameEventService,
        private pageInfoService: IPageInfoService,
        private slotSharedService: SlotSharedService
    ) {
        this.popupConfig = {
            halign: 'left',
            valign: 'bottom',
            additionalClasses: [
                'se-slot-ctx-menu__divider',
                'se-slot-ctx-menu__dropdown-toggle-wrapper'
            ]
        };
        this.buttonName = 'slotSharedButton';
        this.isPopupOpened = false;
        this.isPopupOpenedPreviousValue = false;
    }

    async ngOnInit(): Promise<void> {
        this.isExternalSlot = this.componentHandlerService.isExternalComponent(
            this.slotId,
            this.componentAttributes.smarteditComponentType
        );

        // close popup when smarteditcontainer is clicked
        this.unRegOuterFrameClicked = this.crossFrameEventService.subscribe(
            EVENT_OUTER_FRAME_CLICKED,
            () => {
                this.isPopupOpened = false;
            }
        );

        const [
            isSlotShared,
            isCurrentCatalogMultiCountry,
            isGlobalSlot,
            isSameCatalogVersionOfPageAndPageTemplate
        ] = await Promise.all([
            this.slotSharedService.isSlotShared(this.slotId),
            this.catalogService.isCurrentCatalogMultiCountry(),
            this.slotSharedService.isGlobalSlot(
                this.slotId,
                this.componentAttributes.smarteditComponentType
            ),
            this.pageInfoService.isSameCatalogVersionOfPageAndPageTemplate()
        ]);
        // Has the current site with current catalog have any parent catalog
        const isMultiCountry = isCurrentCatalogMultiCountry;

        this.isSlotShared =
            (!isMultiCountry || (isMultiCountry && isSameCatalogVersionOfPageAndPageTemplate)) &&
            !this.isExternalSlot &&
            isSlotShared;

        this.isGlobalSlot = isGlobalSlot;
        this.labelL10nKey = this.isGlobalSlot
            ? 'se.parentslot.decorator.label'
            : 'se.sharedslot.decorator.label';
        this.descriptionL10nKey = this.isGlobalSlot
            ? 'se.cms.slot.shared.parent.popover.message'
            : 'se.cms.slot.shared.popover.message';
    }

    ngOnDestroy(): void {
        if (this.unRegOuterFrameClicked) {
            this.unRegOuterFrameClicked();
        }
    }

    ngDoCheck(): void {
        if (this.isPopupOpenedPreviousValue !== this.isPopupOpened) {
            // See ContextualMenuItemData#setRemainOpen comment
            this.contextualMenuItem.setRemainOpen(this.buttonName, this.isPopupOpened);
            this.isPopupOpenedPreviousValue = this.isPopupOpened;
        }
    }

    get componentAttributes(): ComponentAttributes {
        return this.contextualMenuItem.componentAttributes;
    }

    get slotId(): string {
        return this.componentAttributes.smarteditComponentId;
    }

    public onButtonClick(): void {
        this.isPopupOpened = !this.isPopupOpened;
    }

    public hidePopup(): void {
        this.isPopupOpened = false;
    }

    public async replaceSlot(event: MouseEvent): Promise<void> {
        event.preventDefault();

        let replaceSlotPromise: Promise<any>;
        if (this.isGlobalSlot) {
            // Multi Country scenario
            replaceSlotPromise = this.slotSharedService.replaceGlobalSlot(this.componentAttributes);
        } else {
            // Non Multi Country scenario
            replaceSlotPromise = this.slotSharedService.replaceSharedSlot(this.componentAttributes);
        }
        await replaceSlotPromise;

        this.hidePopup();
        this.reload();
    }

    private reload(): void {
        windowUtils.getWindow().location.reload();
    }
}
