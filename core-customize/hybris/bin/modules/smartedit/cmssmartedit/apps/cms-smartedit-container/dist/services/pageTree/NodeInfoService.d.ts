import { ICMSComponent, ISlotVisibilityService } from 'cmscommons';
import { LogService, PageTreeNode, CmsitemsRestService, CrossFrameEventService, IPageTreeNodeService, Payload } from 'smarteditcommons';
export declare const INTERVAL_RETRIES = 20;
export declare const INTERVAL_MILLISEC = 300;
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
export declare class NodeInfoService {
    private readonly crossFrameEventService;
    private readonly cmsitemsRestService;
    private readonly logService;
    private readonly slotVisibilityService;
    private readonly pageTreeNodeService;
    protected treeNodes: SlotNode[];
    constructor(crossFrameEventService: CrossFrameEventService, cmsitemsRestService: CmsitemsRestService, logService: LogService, slotVisibilityService: ISlotVisibilityService, pageTreeNodeService: IPageTreeNodeService);
    buildNodesInfo(): Promise<SlotNode[]>;
    updatePartTreeNodesInfo(updatedNodes: Payload): Promise<SlotNode[]>;
    updatePartTreeNodesInfoBySlotUuid(slotUuid: string): Promise<SlotNode[]>;
    publishComponentSelected(component: ComponentNode, activeSlot: boolean, slotElementUuid: string): void;
    publishSlotSelected(slot: SlotNode): void;
    private addMoreInfoToOneNode;
    private getComponentsDataByUUIDs;
    private buildHiddenComponentNode;
    private buildDisplayComponentNode;
}
