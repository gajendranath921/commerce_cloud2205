/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { IPageTreeService, SeDowngradeService, GatewayProxied } from 'smarteditcommons';

@SeDowngradeService(IPageTreeService)
@GatewayProxied('registerTreeComponent', 'getTreeComponent')
export class PageTreeService extends IPageTreeService {
    constructor() {
        super();
    }
}
