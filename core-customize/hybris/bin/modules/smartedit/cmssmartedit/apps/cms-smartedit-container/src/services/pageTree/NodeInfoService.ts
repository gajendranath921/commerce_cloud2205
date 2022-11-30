/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { ICMSComponent, ISlotVisibilityService } from 'cmscommons';
import {
    LogService,
    SeDowngradeService,
    PageTreeNode,
    CmsitemsRestService,
    stringUtils,
    CrossFrameEventService,
    IPageTreeNodeService,
    Payload,
    EVENT_PAGE_TREE_SLOT_SELECTED,
    EVENT_PAGE_TREE_COMPONENT_SELECTED,
    EVENT_PAGE_TREE_SLOT_NEED_UPDATE
} from 'smarteditcommons';

export const INTERVAL_RETRIES = 20;
export const INTERVAL_MILLISEC = 300;
export interface SlotNode extends PageTreeNode {
    componentNodes: ComponentNode[];
}

export interface ComponentNode extends ICMSComponent {
    isHidden: boolean;
    isExpanded: boolean;
    componentNodes?: ComponentNode[];
    componentId?: string;
    componentUuid?: string;
    componentTypeFromPage?: string;
    containerId?: string;
    containerType?: string;
    catalogVersionUuid?: string;
    elementUuid?: string;
}

/**
 * Used to build extra information for page tree nodes such as get slot node's hidden components,
 *  get component node's information from backend by uuid
 * */

@SeDowngradeService()
export class NodeInfoService {
    protected treeNodes: SlotNode[];
    constructor(
        private readonly crossFrameEventService: CrossFrameEventService,
        private readonly cmsitemsRestService: CmsitemsRestService,
        private readonly logService: LogService,
        private readonly slotVisibilityService: ISlotVisibilityService,
        private readonly pageTreeNodeService: IPageTreeNodeService
    ) {
        this.treeNodes = [];
        this.crossFrameEventService.subscribe(
            EVENT_PAGE_TREE_SLOT_NEED_UPDATE,
            (_eventId: string, eventData?: string) =>
                this.updatePartTreeNodesInfoBySlotUuid(eventData)
        );
    }

    public async buildNodesInfo(): Promise<SlotNode[]> {
        const nodes = await this.pageTreeNodeService.getSlotNodes();
        this.treeNodes = await Promise.all(
            nodes.map(async (node) => this.addMoreInfoToOneNode(node))
        );

        return this.treeNodes;
    }

    public async updatePartTreeNodesInfo(updatedNodes: Payload): Promise<SlotNode[]> {
        this.treeNodes = await Promise.all(
            this.treeNodes.map(async (node) => {
                if (Object.keys(updatedNodes).includes(node.elementUuid)) {
                    node.childrenNode = updatedNodes[node.elementUuid] as PageTreeNode[];
                    return this.addMoreInfoToOneNode(node);
                } else {
                    return node;
                }
            })
        );
        return this.treeNodes;
    }

    public async updatePartTreeNodesInfoBySlotUuid(slotUuid: string): Promise<SlotNode[]> {
        this.treeNodes = await Promise.all(
            this.treeNodes.map(async (node) => {
                if (node.componentUuid === slotUuid) {
                    return this.addMoreInfoToOneNode(node);
                } else {
                    return node;
                }
            })
        );
        return this.treeNodes;
    }

    public publishComponentSelected(
        component: ComponentNode,
        activeSlot: boolean,
        slotElementUuid: string
    ): void {
        // Should active the slot of this component
        if (activeSlot) {
            this.crossFrameEventService.publish(EVENT_PAGE_TREE_SLOT_SELECTED, {
                elementUuid: slotElementUuid,
                active: true
            });
        }

        // Active the component itself
        this.crossFrameEventService.publish(EVENT_PAGE_TREE_COMPONENT_SELECTED, {
            elementUuid: component.elementUuid,
            active: component.isExpanded
        });
    }

    public publishSlotSelected(slot: SlotNode): void {
        // Active the slot itself
        this.crossFrameEventService.publish(EVENT_PAGE_TREE_SLOT_SELECTED, {
            elementUuid: slot.elementUuid,
            active: slot.isExpanded
        });

        // To make other active component become inactive
        this.crossFrameEventService.publish(EVENT_PAGE_TREE_COMPONENT_SELECTED, {
            elementUuid: slot.elementUuid,
            active: slot.isExpanded
        });
    }

    private async addMoreInfoToOneNode(node: PageTreeNode): Promise<SlotNode> {
        const hiddenComponents = await this.slotVisibilityService.getHiddenComponents(
            node.componentId
        );
        const childUuids = node.childrenNode.map((child) => child.componentUuid);
        const displayComponents = await this.getComponentsDataByUUIDs(childUuids);
        let componentNodes = displayComponents.map((component) =>
            this.buildDisplayComponentNode(component, node)
        );
        componentNodes = componentNodes.concat(
            hiddenComponents.map((component) => this.buildHiddenComponentNode(component))
        );
        return { ...node, componentNodes };
    }

    private async getComponentsDataByUUIDs(uuids: string[]): Promise<ICMSComponent[]> {
        try {
            const data = await this.cmsitemsRestService.getByIds<ICMSComponent>(uuids, 'DEFAULT');
            return Promise.resolve((data.response ? data.response : [data]) as ICMSComponent[]);
        } catch (error) {
            this.logService.error('SlotInfoService:: getSlotsDataByUUIDs error:', error.message);
        }
    }

    private buildHiddenComponentNode(component: ICMSComponent): ComponentNode {
        const elementUuid = stringUtils.generateIdentifier();
        return {
            isHidden: true,
            isExpanded: false,
            componentNodes: [],
            elementUuid,
            ...component
        };
    }

    private buildDisplayComponentNode(component: ICMSComponent, slot: PageTreeNode): ComponentNode {
        const node = slot.childrenNode.find((child) => child.componentUuid === component.uuid);
        const {
            componentId,
            componentUuid,
            componentTypeFromPage,
            containerId,
            containerType,
            catalogVersionUuid,
            elementUuid
        } = node;
        return {
            isHidden: false,
            isExpanded: false,
            componentId,
            componentUuid,
            componentTypeFromPage,
            containerId,
            containerType,
            catalogVersionUuid,
            elementUuid,
            componentNodes: [],
            ...component
        };
    }
}
