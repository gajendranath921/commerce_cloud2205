/// <reference types="angular" />
/// <reference types="jquery" />
import { PageTreeNode, IPageTreeNodeService, ComponentHandlerService, LogService, CrossFrameEventService, AggregatedNode, WindowUtils } from 'smarteditcommons';
export declare class PageTreeNodeService extends IPageTreeNodeService {
    private readonly componentHandlerService;
    private readonly yjQuery;
    private readonly crossFrameEventService;
    private readonly windowUtils;
    private readonly logService;
    constructor(componentHandlerService: ComponentHandlerService, yjQuery: JQueryStatic, crossFrameEventService: CrossFrameEventService, windowUtils: WindowUtils, logService: LogService);
    buildSlotNodes(): void;
    updateSlotNodes(nodes: AggregatedNode[]): void;
    getSlotNodes(): Promise<PageTreeNode[]>;
    scrollToElement(elementUuid: string): Promise<void>;
    existedSmartEditElement(elementUuid: string): Promise<boolean>;
    protected _buildSlotNode(node: HTMLElement): PageTreeNode;
    protected _isValidElement(ele: HTMLElement): boolean;
    private elementTopInViewport;
    private elementCenterInViewport;
    private buildSlotNodesByElement;
}
