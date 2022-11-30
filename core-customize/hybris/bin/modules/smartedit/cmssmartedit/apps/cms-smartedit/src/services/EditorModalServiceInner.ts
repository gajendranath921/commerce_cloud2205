/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { GatewayProxied, SeDowngradeService, IEditorModalService } from 'smarteditcommons';

@SeDowngradeService(IEditorModalService)
@GatewayProxied('open', 'openAndRerenderSlot', 'openGenericEditor')
export class EditorModalService extends IEditorModalService {}
