/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { Inject } from '@angular/core';
import {
    PageTreeNode,
    IPageTreeNodeService,
    YJQUERY_TOKEN,
    ID_ATTRIBUTE,
    TYPE_ATTRIBUTE,
    CONTAINER_ID_ATTRIBUTE,
    CATALOG_VERSION_UUID_ATTRIBUTE,
    UUID_ATTRIBUTE,
    CONTAINER_TYPE_ATTRIBUTE,
    SeDowngradeService,
    GatewayProxied,
    ComponentHandlerService,
    stringUtils,
    ELEMENT_UUID_ATTRIBUTE,
    LogService,
    EVENT_PART_REFRESH_TREE_NODE,
    CrossFrameEventService,
    AggregatedNode,
    EVENT_OVERALL_REFRESH_TREE_NODE,
    WindowUtils,
    Payload
} from 'smarteditcommons';

@SeDowngradeService(IPageTreeNodeService)
@GatewayProxied('getSlotNodes', 'scrollToElement', 'existedSmartEditElement')
export class PageTreeNodeService extends IPageTreeNodeService {
    constructor(
        private readonly componentHandlerService: ComponentHandlerService,
        @Inject(YJQUERY_TOKEN) private readonly yjQuery: JQueryStatic,
        private readonly crossFrameEventService: CrossFrameEventService,
        private readonly windowUtils: WindowUtils,
        private readonly logService: LogService
    ) {
        super();
    }

    buildSlotNodes(): void {
        this.slotNodes = this.buildSlotNodesByElement(this.yjQuery('body'));
        this.crossFrameEventService.publish(EVENT_OVERALL_REFRESH_TREE_NODE);
    }

    updateSlotNodes(nodes: AggregatedNode[]): void {
        if (this.slotNodes && nodes.length > 0) {
            const parentSet = new Set();
            const updatedSlotNodes: Payload = {};
            nodes.forEach((node) => {
                if (parentSet.has(node.parent)) {
                    return;
                }
                parentSet.add(node.parent);
                const element: JQuery = this.yjQuery(node.parent);
                const parentUUid = element.attr(ELEMENT_UUID_ATTRIBUTE);

                if (!parentUUid) {
                    return;
                }
                const childrenNode = this.buildSlotNodesByElement(element);
                updatedSlotNodes[parentUUid] = childrenNode as Payload[];
                this.slotNodes.forEach((item) => {
                    if (item.elementUuid === parentUUid) {
                        item.childrenNode = childrenNode;
                    }
                });
            });
            this.crossFrameEventService.publish(EVENT_PART_REFRESH_TREE_NODE, updatedSlotNodes);
        }
    }

    getSlotNodes(): Promise<PageTreeNode[]> {
        return Promise.resolve(this.slotNodes);
    }

    /*
     * If element is not in viewport or element bottom is in viewport scroll element into view
     */
    scrollToElement(elementUuid: string): Promise<void> {
        const element = this.yjQuery(`[data-smartedit-element-uuid="${elementUuid}"]`)
            .get()
            .shift();
        if (element) {
            if (this.elementTopInViewport(element) || this.elementCenterInViewport(element)) {
                return;
            }
            element.scrollIntoView({ behavior: 'smooth', block: 'center' });
        } else {
            this.logService.error(`data-smartedit-element-uuid="${elementUuid}" is not existed!`);
        }
    }

    existedSmartEditElement(elementUuid: string): Promise<boolean> {
        const element = this.yjQuery(
            `smartedit-element[data-smartedit-element-uuid="${elementUuid}"]`
        )
            .get()
            .shift();
        return Promise.resolve(!!element);
    }

    protected _buildSlotNode(node: HTMLElement): PageTreeNode {
        const element: JQuery = this.yjQuery(node);
        const childrenNode: PageTreeNode[] = Array.from(
            this.componentHandlerService.getFirstSmartEditComponentChildren(element) as any
        )
            .filter((child: HTMLElement) => this._isValidElement(child))
            .map((firstLevelComponent: HTMLElement) => this._buildSlotNode(firstLevelComponent));

        if (!element.attr(ELEMENT_UUID_ATTRIBUTE)) {
            element.attr(ELEMENT_UUID_ATTRIBUTE, stringUtils.generateIdentifier());
        }

        return {
            componentId: element.attr(ID_ATTRIBUTE),
            componentUuid: element.attr(UUID_ATTRIBUTE),
            componentTypeFromPage: element.attr(TYPE_ATTRIBUTE),
            catalogVersionUuid: element.attr(CATALOG_VERSION_UUID_ATTRIBUTE),
            containerId: element.attr(CONTAINER_ID_ATTRIBUTE),
            containerType: element.attr(CONTAINER_TYPE_ATTRIBUTE),
            elementUuid: element.attr(ELEMENT_UUID_ATTRIBUTE),
            isExpanded: false,
            childrenNode
        };
    }

    protected _isValidElement(ele: HTMLElement): boolean {
        const element: JQuery = this.yjQuery(ele);

        if (!element || !element.is(':visible')) {
            return false;
        }

        return !(
            !element.attr(ID_ATTRIBUTE) ||
            !element.attr(UUID_ATTRIBUTE) ||
            !element.attr(TYPE_ATTRIBUTE) ||
            !element.attr(CATALOG_VERSION_UUID_ATTRIBUTE)
        );
    }

    private elementTopInViewport(element): boolean {
        const rect = element.getBoundingClientRect();
        return (
            rect.top >= 0 &&
            rect.left >= 0 &&
            rect.top <
                (this.windowUtils.getWindow().innerHeight ||
                    document.documentElement.clientHeight) &&
            rect.left <
                (this.windowUtils.getWindow().innerWidth || document.documentElement.clientWidth)
        );
    }

    private elementCenterInViewport(element): boolean {
        const rect = element.getBoundingClientRect();
        return (
            rect.top < 0 &&
            rect.left < 0 &&
            rect.bottom >
                (this.windowUtils.getWindow().innerHeight ||
                    document.documentElement.clientHeight) &&
            rect.right >
                (this.windowUtils.getWindow().innerWidth || document.documentElement.clientWidth)
        );
    }

    private buildSlotNodesByElement(element): PageTreeNode[] {
        return Array.from(
            this.componentHandlerService.getFirstSmartEditComponentChildren(element) as any
        )
            .filter((child: HTMLElement) => this._isValidElement(child))
            .map((firstLevelComponent: HTMLElement) => this._buildSlotNode(firstLevelComponent));
    }
}
