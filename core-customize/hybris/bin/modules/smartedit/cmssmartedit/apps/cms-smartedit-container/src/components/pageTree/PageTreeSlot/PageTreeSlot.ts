/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { Component, EventEmitter, Input, Output } from '@angular/core';
import {
    IPageTreeNodeService,
    SeDowngradeComponent,
    LogService,
    UserTrackingService,
    USER_TRACKING_FUNCTIONALITY
} from 'smarteditcommons';
import {
    SlotNode,
    INTERVAL_RETRIES,
    INTERVAL_MILLISEC,
    ComponentNode,
    NodeInfoService
} from '../../../services/pageTree/NodeInfoService';

@SeDowngradeComponent()
@Component({
    selector: 'se-page-tree-slot',
    templateUrl: './PageTreeSlot.html',
    styleUrls: ['./PageTreeSlot.scss']
})
export class PageTreeSlot {
    @Input() node: SlotNode;
    @Output() onSlotExpanded: EventEmitter<SlotNode> = new EventEmitter();
    private publishSlotInterval: any = null;

    constructor(
        private readonly pageTreeNodeService: IPageTreeNodeService,
        private readonly nodeInfoService: NodeInfoService,
        private readonly logService: LogService,
        private readonly userTrackingService: UserTrackingService
    ) {}

    async onClickSlotNode($event: Event): Promise<void> {

        this.userTrackingService.trackingUserAction(
            USER_TRACKING_FUNCTIONALITY.PAGE_STRUCTURE,
            'Slot'
        );

        clearInterval(this.publishSlotInterval);
        this.node.isExpanded = !this.node.isExpanded;

        if (!this.node.isExpanded) {
            this.node.componentNodes.forEach((component) => (component.isExpanded = false));
            this.nodeInfoService.publishSlotSelected(this.node);
        } else {
            this.onSlotExpanded.emit(this.node);
            // In case the active slot is not in viewport
            await this.pageTreeNodeService.scrollToElement(this.node.elementUuid);

            if (!(await this.checkSlotAndPublishSelected())) {
                let retries = 0;
                this.publishSlotInterval = setInterval(async () => {
                    if (await this.checkSlotAndPublishSelected()) {
                        clearInterval(this.publishSlotInterval);
                    }
                    if (retries > INTERVAL_RETRIES) {
                        this.logService.error(
                            `PageTreeComponent:: onClickSlotNode error: smartedit-element ${this.node.elementUuid} is not existed`
                        );
                        clearInterval(this.publishSlotInterval);
                    }
                    retries++;
                }, INTERVAL_MILLISEC);
            }
        }
    }

    onComponentExpanded(component: ComponentNode): void {
        this.node.componentNodes
            .filter((node) => node.elementUuid !== component.elementUuid)
            .forEach((node) => {
                if (node.isExpanded) {
                    node.isExpanded = false;
                    this.nodeInfoService.publishComponentSelected(
                        node,
                        false,
                        this.node.elementUuid
                    );
                }
            });
    }

    private async checkSlotAndPublishSelected(): Promise<boolean> {
        const existedSmartEditElement = await this.pageTreeNodeService.existedSmartEditElement(
            this.node.elementUuid
        );
        if (existedSmartEditElement) {
            this.nodeInfoService.publishSlotSelected(this.node);
            return true;
        }
        return false;
    }
}
