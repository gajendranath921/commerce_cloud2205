/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { GatewayProxied, SeDowngradeService, IPageService } from 'smarteditcommons';

@SeDowngradeService(IPageService)
@GatewayProxied()
export class PageService extends IPageService {
    constructor() {
        super();
    }
}
