/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { IContextAwareEditableItemService } from 'cmscommons';
import { GatewayProxied, SeDowngradeService } from 'smarteditcommons';

@SeDowngradeService(IContextAwareEditableItemService)
@GatewayProxied()
export class ContextAwareEditableItemService extends IContextAwareEditableItemService {
    constructor() {
        super();
    }
}
