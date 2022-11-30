/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { IEditorEnablerService } from 'cmscommons';
import { GatewayProxied, SeDowngradeService } from 'smarteditcommons';

@SeDowngradeService(IEditorEnablerService)
@GatewayProxied('onClickEditButton', 'isSlotEditableForNonExternalComponent')
export class EditorEnablerService extends IEditorEnablerService {}
