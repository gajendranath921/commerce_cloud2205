/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { IPageContentSlotsComponentsRestService } from 'cmscommons';
import { GatewayProxied, SeDowngradeService } from 'smarteditcommons';

@GatewayProxied('clearCache', 'getSlotsToComponentsMapForPageUid')
@SeDowngradeService(IPageContentSlotsComponentsRestService)
export class PageContentSlotsComponentsRestService extends IPageContentSlotsComponentsRestService {
    constructor() {
        super();
    }
}
