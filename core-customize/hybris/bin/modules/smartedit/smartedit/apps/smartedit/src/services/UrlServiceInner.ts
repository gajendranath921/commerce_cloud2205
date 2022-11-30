/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { GatewayProxied, IUrlService, SeDowngradeService } from 'smarteditcommons';

/** @internal */
@SeDowngradeService(IUrlService)
@GatewayProxied('openUrlInPopup', 'path')
export class UrlService extends IUrlService {}
