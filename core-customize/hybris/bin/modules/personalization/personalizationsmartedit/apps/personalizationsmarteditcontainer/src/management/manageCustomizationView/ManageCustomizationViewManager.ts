/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { SeDowngradeService, IModalService } from 'smarteditcommons';
import { ManageCustomizationViewComponent } from './ManageCustomizationViewComponent';
import { ManageCustomizationViewModalData } from './types';

@SeDowngradeService()
export class ManageCustomizationViewManager {
    private readonly className = 'sliderPanelParentModal';
    private readonly modalTitle = 'personalization.modal.customizationvariationmanagement.title';

    constructor(private modalService: IModalService) {}

    public openCreateCustomizationModal(): void {
        this.modalService.open({
            component: ManageCustomizationViewComponent,
            config: {
                modalPanelClass: `lg ${this.className}`,
                width: '650px',
                focusTrapped: false,
                backdropClickCloseable: false
            },
            templateConfig: {
                title: this.modalTitle,
                isDismissButtonVisible: true
            }
        });
    }

    public openEditCustomizationModal(
        customizationCode: ManageCustomizationViewModalData['customizationCode'],
        variationCode: ManageCustomizationViewModalData['variationCode']
    ): void {
        this.modalService.open({
            component: ManageCustomizationViewComponent,
            data: {
                customizationCode,
                variationCode
            },
            config: {
                modalPanelClass: `lg ${this.className}`,
                width: '650px',
                focusTrapped: false,
                backdropClickCloseable: false
            },
            templateConfig: {
                title: this.modalTitle,
                isDismissButtonVisible: true
            }
        });
    }
}
