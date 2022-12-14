/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { GatewayProxied, ICatalogService, SeDowngradeService } from 'smarteditcommons';

/** @internal */
@SeDowngradeService(ICatalogService)
@GatewayProxied()
export class CatalogService extends ICatalogService {}
