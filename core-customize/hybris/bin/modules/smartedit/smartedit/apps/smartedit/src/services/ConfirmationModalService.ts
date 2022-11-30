/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { GatewayProxied, IConfirmationModalService, SeDowngradeService } from 'smarteditcommons';

@SeDowngradeService(IConfirmationModalService)
@GatewayProxied('confirm')
export class ConfirmationModalService extends IConfirmationModalService {}
