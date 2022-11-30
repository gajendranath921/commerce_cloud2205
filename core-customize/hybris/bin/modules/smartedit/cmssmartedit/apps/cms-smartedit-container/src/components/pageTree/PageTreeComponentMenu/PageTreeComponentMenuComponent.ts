/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import {
    Component,
    Input,
    forwardRef,
    OnInit,
    ChangeDetectionStrategy,
    ChangeDetectorRef,
    ViewRef
} from '@angular/core';
import {
    ComponentAttributes,
    IContextualMenuButton,
    IContextualMenuConfiguration,
    PopupOverlayConfig,
    TypedMap
} from 'smarteditcommons';
import { ComponentNode } from '../../../services/pageTree/NodeInfoService';
import { PageTreeComponentMenuService } from '../../../services/pageTree/PageTreeComponentMenuService';
import { PageTreeMenuItemOverlayComponent } from './PageTreeMenuItemOverlayComponent';
import { PageTreeMoreItemsComponent } from './PageTreeMoreItemsComponent';
import { ParentMenu } from './ParentMenu';

@Component({
    selector: 'se-page-tree-component-menu',
    templateUrl: './PageTreeComponentMenuComponent.html',
    styleUrls: ['./PageTreeComponentMenuComponent.scss'],
    providers: [
        { provide: ParentMenu, useExisting: forwardRef(() => PageTreeComponentMenuComponent) }
    ],
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class PageTreeComponentMenuComponent implements ParentMenu, OnInit {
    @Input() component: ComponentNode;
    @Input() slotId: string;
    @Input() slotUuid: string;
    public componentAttributes: ComponentAttributes;
    public remainOpenMap: TypedMap<boolean> = {};
    public items: IContextualMenuButton[];
    public leftButton: IContextualMenuButton;
    public moreMenuIsOpen = false;

    public moreMenuPopupConfig: PopupOverlayConfig = {
        component: PageTreeMoreItemsComponent,
        halign: 'left'
    };
    public itemTemplateOverlayWrapper: PopupOverlayConfig = {
        component: PageTreeMenuItemOverlayComponent
    };
    public menuConfiguration: IContextualMenuConfiguration;

    private displayedItem: IContextualMenuButton;
    constructor(
        private readonly pageTreeComponentMenuService: PageTreeComponentMenuService,
        private readonly cdr: ChangeDetectorRef
    ) {}

    getItems(): IContextualMenuButton[] {
        return this.items;
    }
    async ngOnInit(): Promise<void> {
        this.componentAttributes = {
            smarteditCatalogVersionUuid: this.component.catalogVersion,
            smarteditComponentId: this.component.uid,
            smarteditComponentType: this.component.typeCode,
            smarteditComponentUuid: this.component.uuid,
            smarteditElementUuid: this.component.elementUuid
        };
        this.menuConfiguration = {
            componentType: this.component.typeCode,
            componentId: this.component.uid,
            componentUuid: this.component.uuid,
            containerType: this.component.containerType,
            containerId: this.component.containerId,
            componentAttributes: this.componentAttributes,
            slotId: this.slotId,
            slotUuid: this.slotUuid,
            isComponentHidden: this.component.isHidden
        };
        const newItems = await this.pageTreeComponentMenuService.getPageTreeComponentMenus(
            this.menuConfiguration
        );

        if (newItems && newItems.length > 0) {
            this.items = newItems.filter((item) => !!item);
            this.leftButton = this.items.shift();
        }

        if (!(this.cdr as ViewRef).destroyed) {
            this.cdr.detectChanges();
        }
    }

    setRemainOpen(key: string, remainOpen: boolean): void {
        this.remainOpenMap[key] = remainOpen;
    }

    showOverlay(active: boolean): boolean {
        if (active) {
            return true;
        }

        return Object.keys(this.remainOpenMap).reduce(
            (isOpen: boolean, key: string) => isOpen || this.remainOpenMap[key],
            false
        );
    }

    canShowTemplate(menuItem: IContextualMenuButton): boolean {
        return this.displayedItem === menuItem;
    }

    onHideItemPopup(hideMoreMenu = false): void {
        this.displayedItem = null;
        if (hideMoreMenu) {
            this.moreMenuIsOpen = false;
        }
    }

    triggerMenuItemAction(item: IContextualMenuButton, $event: Event): void {
        this.moreMenuIsOpen = false;
        if (item.action.component) {
            if (this.displayedItem === item) {
                this.displayedItem = null;
            } else {
                this.displayedItem = item;
            }
        } else if (item.action.callback) {
            item.action.callback(this.menuConfiguration, $event);
        }
    }

    toggleMoreMenu(): void {
        this.moreMenuIsOpen = !this.moreMenuIsOpen;
    }
}
