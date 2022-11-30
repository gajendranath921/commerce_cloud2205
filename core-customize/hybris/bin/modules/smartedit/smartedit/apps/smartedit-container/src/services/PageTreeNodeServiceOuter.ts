/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { GatewayProxied, IPageTreeNodeService, SeDowngradeService } from 'smarteditcommons';

@SeDowngradeService(IPageTreeNodeService)
@GatewayProxied('getSlotNodes', 'scrollToElement', 'existedSmartEditElement')
export class PageTreeNodeService extends IPageTreeNodeService {
    constructor() {
        super();
    }
}
