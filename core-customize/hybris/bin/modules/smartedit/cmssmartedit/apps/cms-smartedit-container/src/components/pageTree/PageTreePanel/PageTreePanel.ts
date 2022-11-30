/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { ChangeDetectorRef, Component, Inject, OnInit } from '@angular/core';
import {
    CrossFrameEventService,
    SeDowngradeComponent,
    EVENT_OPEN_IN_PAGE_TREE,
    YJQUERY_TOKEN,
    LogService,
    EVENT_OVERALL_REFRESH_TREE_NODE,
    EVENT_PART_REFRESH_TREE_NODE,
    Payload
} from 'smarteditcommons';
import {
    SlotNode,
    NodeInfoService,
    INTERVAL_RETRIES,
    INTERVAL_MILLISEC
} from '../../../services/pageTree/NodeInfoService';
@SeDowngradeComponent()
@Component({
    selector: 'se-page-tree',
    templateUrl: './PageTreePanel.html',
    styleUrls: ['./PageTreePanel.scss']
})
export class PageTreePanel implements OnInit {
    private slotNodes: SlotNode[] = null;
    private scrollToNodeInterval: any = null;
    private expandComponentNodeInterval: any = null;

    constructor(
        private readonly crossFrameEventService: CrossFrameEventService,
        private readonly nodeInfoService: NodeInfoService,
        @Inject(YJQUERY_TOKEN) private readonly yjQuery: JQueryStatic,
        private readonly cdr: ChangeDetectorRef,
        private readonly logService: LogService
    ) {
        this.crossFrameEventService.subscribe(
            EVENT_OPEN_IN_PAGE_TREE,
            this.handleEventOpenInPageTree.bind(this)
        );

        this.crossFrameEventService.subscribe(
            EVENT_PART_REFRESH_TREE_NODE,
            async (_eventId: string, eventData?: Payload) =>
                (this.slotNodes = await this.nodeInfoService.updatePartTreeNodesInfo(eventData))
        );

        this.crossFrameEventService.subscribe(
            EVENT_OVERALL_REFRESH_TREE_NODE,
            async () => (this.slotNodes = await this.nodeInfoService.buildNodesInfo())
        );
    }

    async ngOnInit(): Promise<void> {
        this.slotNodes = await this.nodeInfoService.buildNodesInfo();
    }

    onSlotExpanded(slot: SlotNode): void {
        this.slotNodes
            .filter((node) => slot.elementUuid !== node.elementUuid)
            .forEach((node) => {
                node.isExpanded = false;
                node.componentNodes.forEach((component) => (component.isExpanded = false));
            });
    }

    handleEventOpenInPageTree(eventId: string, elementUuid: string): void {
        clearInterval(this.expandComponentNodeInterval);
        if (!this.expandComponentNode(elementUuid)) {
            let retries = 0;
            this.expandComponentNodeInterval = setInterval(() => {
                if (this.expandComponentNode(elementUuid)) {
                    clearInterval(this.expandComponentNodeInterval);
                }

                if (retries > INTERVAL_RETRIES) {
                    this.logService.error(
                        `PageTreeComponent:: handleEventOpenInPageTree error: expand component node ${elementUuid} failed`
                    );
                    clearInterval(this.expandComponentNodeInterval);
                }
                retries++;
            }, INTERVAL_MILLISEC);
        }
    }

    private expandComponentNode(elementUuid: string): boolean {
        if (this.slotNodes) {
            this.slotNodes.forEach((slot) => {
                let componentNode = null;

                slot.componentNodes.forEach((component) => {
                    if (component.elementUuid === elementUuid) {
                        component.isExpanded = true;
                        componentNode = component;
                    } else {
                        component.isExpanded = false;
                    }
                });

                if (componentNode) {
                    slot.isExpanded = true;
                    this.scrollToNodeByInterval(componentNode.elementUuid);
                } else {
                    slot.isExpanded = false;
                }
            });
            return true;
        }
        return false;
    }

    private scrollToNode(elementUuid: string): boolean {
        const element = this.yjQuery(`div[node-smartedit-element-uuid="${elementUuid}"]`)
            .get()
            .shift();
        if (element) {
            element.scrollIntoView({ behavior: 'smooth', block: 'center' });
            return true;
        }
        return false;
    }
    /*
     * Try to check if element is in viewport
     */
    private scrollToNodeByInterval(elementUuid: string): void {
        clearInterval(this.scrollToNodeInterval);
        if (!this.scrollToNode(elementUuid)) {
            let retries = 0;
            this.scrollToNodeInterval = setInterval(() => {
                if (this.scrollToNode(elementUuid)) {
                    clearInterval(this.scrollToNodeInterval);
                }
                if (retries > INTERVAL_RETRIES) {
                    this.logService.error(
                        `PageTreeComponent:: scrollToNodeByInterval error: scroll to tree node ${elementUuid} failed!`
                    );
                    clearInterval(this.scrollToNodeInterval);
                }
                retries++;
            }, INTERVAL_MILLISEC);
        }
    }
}
