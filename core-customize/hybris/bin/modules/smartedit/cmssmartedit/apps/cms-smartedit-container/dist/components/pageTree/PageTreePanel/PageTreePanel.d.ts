/// <reference types="angular" />
/// <reference types="jquery" />
import { ChangeDetectorRef, OnInit } from '@angular/core';
import { CrossFrameEventService, LogService } from 'smarteditcommons';
import { SlotNode, NodeInfoService } from '../../../services/pageTree/NodeInfoService';
export declare class PageTreePanel implements OnInit {
    private readonly crossFrameEventService;
    private readonly nodeInfoService;
    private readonly yjQuery;
    private readonly cdr;
    private readonly logService;
    private slotNodes;
    private scrollToNodeInterval;
    private expandComponentNodeInterval;
    constructor(crossFrameEventService: CrossFrameEventService, nodeInfoService: NodeInfoService, yjQuery: JQueryStatic, cdr: ChangeDetectorRef, logService: LogService);
    ngOnInit(): Promise<void>;
    onSlotExpanded(slot: SlotNode): void;
    handleEventOpenInPageTree(eventId: string, elementUuid: string): void;
    private expandComponentNode;
    private scrollToNode;
    private scrollToNodeByInterval;
}
