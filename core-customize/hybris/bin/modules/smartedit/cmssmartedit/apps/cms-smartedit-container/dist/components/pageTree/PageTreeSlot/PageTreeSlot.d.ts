import { EventEmitter } from '@angular/core';
import { IPageTreeNodeService, LogService, UserTrackingService } from 'smarteditcommons';
import { SlotNode, ComponentNode, NodeInfoService } from '../../../services/pageTree/NodeInfoService';
export declare class PageTreeSlot {
    private readonly pageTreeNodeService;
    private readonly nodeInfoService;
    private readonly logService;
    private readonly userTrackingService;
    node: SlotNode;
    onSlotExpanded: EventEmitter<SlotNode>;
    private publishSlotInterval;
    constructor(pageTreeNodeService: IPageTreeNodeService, nodeInfoService: NodeInfoService, logService: LogService, userTrackingService: UserTrackingService);
    onClickSlotNode($event: Event): Promise<void>;
    onComponentExpanded(component: ComponentNode): void;
    private checkSlotAndPublishSelected;
}
