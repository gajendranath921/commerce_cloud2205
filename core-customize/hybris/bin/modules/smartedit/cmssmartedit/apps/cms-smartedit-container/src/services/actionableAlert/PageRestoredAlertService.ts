/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import {
    IAlertServiceType,
    ICatalogService,
    ICatalogVersion,
    SeDowngradeService,
    ICMSPage
} from 'smarteditcommons';
import { ActionableAlertService } from './ActionableAlertService';
import { PageRestoredAlertComponent } from './PageRestoredAlertComponent';

@SeDowngradeService()
export class PageRestoredAlertService {
    constructor(
        private catalogService: ICatalogService,
        private actionableAlertService: ActionableAlertService
    ) {}

    public async displayPageRestoredSuccessAlert(pageInfo: ICMSPage): Promise<void> {
        if (!pageInfo) {
            throw new Error('[pageRestoredAlertService] - page info not provided.');
        }

        const catalogVersion: ICatalogVersion = await this.catalogService.getCatalogVersionByUuid(
            pageInfo.catalogVersion
        );
        const alertConfig = {
            component: PageRestoredAlertComponent,
            data: {
                catalogVersion,
                pageInfo
            }
        };
        return this.actionableAlertService.displayActionableAlert(
            alertConfig,
            IAlertServiceType.SUCCESS
        );
    }
}
