import { Customization, CustomizationVariation } from 'personalizationcommons';
import { IModalService, SeDowngradeService } from 'smarteditcommons';
import {
    CommerceCustomizationViewComponent,
    CommerceCustomizationViewData
} from './CommerceCustomizationViewComponent';

@SeDowngradeService()
export class PersonalizationsmarteditCommerceCustomizationView {
    constructor(private modalService: IModalService) {}

    openCommerceCustomizationAction = (
        customization: Customization,
        variation: CustomizationVariation
    ): void => {
        this.modalService.open<CommerceCustomizationViewData>({
            component: CommerceCustomizationViewComponent,
            data: {
                customization,
                variation
            },
            templateConfig: {
                title: 'personalization.modal.commercecustomization.title',
                isDismissButtonVisible: true
            },
            config: {
                width: '700px',
                focusTrapped: false,
                backdropClickCloseable: false
            }
        });
    };
}
