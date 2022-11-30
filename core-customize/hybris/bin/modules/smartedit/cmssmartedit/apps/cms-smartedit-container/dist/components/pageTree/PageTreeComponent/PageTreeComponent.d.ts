import { EventEmitter } from '@angular/core';
import { IPageTreeNodeService, LogService } from 'smarteditcommons';
import { NodeInfoService, ComponentNode } from '../../../services/pageTree/NodeInfoService';
export declare class PageTreeComponent {
    private readonly pageTreeNodeService;
    private readonly nodeInfoService;
    private readonly logService;
    component: ComponentNode;
    slotId: string;
    slotUuid: string;
    slotElementUuid: string;
    onComponentExpanded: EventEmitter<ComponentNode>;
    private publishComponentInterval;
    constructor(pageTreeNodeService: IPageTreeNodeService, nodeInfoService: NodeInfoService, logService: LogService);
    onClickComponentNode($event: Event): Promise<void>;
    private checkComponentAndPublishSelected;
}
