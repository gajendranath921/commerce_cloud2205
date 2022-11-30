/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { IPageTreeNodeService, SeDowngradeComponent, LogService } from 'smarteditcommons';
import {
    NodeInfoService,
    ComponentNode,
    INTERVAL_RETRIES,
    INTERVAL_MILLISEC
} from '../../../services/pageTree/NodeInfoService';

@SeDowngradeComponent()
@Component({
    selector: 'se-page-tree-component',
    templateUrl: './PageTreeComponent.html',
    styleUrls: ['./PageTreeComponent.scss', '../PageTreeSlot/PageTreeSlot.scss']
})
export class PageTreeComponent {
    @Input() component: ComponentNode;
    @Input() slotId: string;
    @Input() slotUuid: string;
    @Input() slotElementUuid: string;
    @Output() onComponentExpanded: EventEmitter<ComponentNode> = new EventEmitter();

    private publishComponentInterval: any = null;

    constructor(
        private readonly pageTreeNodeService: IPageTreeNodeService,
        private readonly nodeInfoService: NodeInfoService,
        private readonly logService: LogService
    ) {}

    async onClickComponentNode($event: Event): Promise<void> {
        clearInterval(this.publishComponentInterval);
        this.component.isExpanded = !this.component.isExpanded;

        if (this.component.isExpanded) {
            this.onComponentExpanded.emit(this.component);

            // In case the active component is not in viewport
            await this.pageTreeNodeService.scrollToElement(this.component.elementUuid);

            if (!(await this.checkComponentAndPublishSelected())) {
                let retries = 0;
                this.publishComponentInterval = setInterval(async () => {
                    if (await this.checkComponentAndPublishSelected()) {
                        clearInterval(this.publishComponentInterval);
                    }
                    if (retries > INTERVAL_RETRIES) {
                        this.logService.error(
                            `PageTreeComponent:: onClickComponentNode error: smartedit-element ${this.component.elementUuid} is not existed`
                        );
                        clearInterval(this.publishComponentInterval);
                    }
                    retries++;
                }, INTERVAL_MILLISEC);
            }
        } else {
            this.nodeInfoService.publishComponentSelected(
                this.component,
                false,
                this.slotElementUuid
            );
        }
    }

    private async checkComponentAndPublishSelected(): Promise<boolean> {
        const existedSmartEditElement = await this.pageTreeNodeService.existedSmartEditElement(
            this.component.elementUuid
        );
        if (existedSmartEditElement) {
            this.nodeInfoService.publishComponentSelected(
                this.component,
                true,
                this.slotElementUuid
            );
            return true;
        }
        return false;
    }
}
