/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { GatewayProxied, IPreviewService, SeDowngradeService, UrlUtils } from 'smarteditcommons';

/** @internal */
@SeDowngradeService(IPreviewService)
@GatewayProxied()
export class PreviewService extends IPreviewService {
    constructor(urlUtils: UrlUtils) {
        super(urlUtils);
    }
}
