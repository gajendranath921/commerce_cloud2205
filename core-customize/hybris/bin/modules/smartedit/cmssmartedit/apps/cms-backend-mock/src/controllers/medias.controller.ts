/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { Controller, Get, Query } from '@nestjs/common';
import { MediaService } from '../services';

@Controller()
export class MediasController {
    constructor(private readonly mediaService: MediaService) {}

    @Get('cmswebservices/v1/catalogs/:catalogId/versions/:versionId/medias')
    findMedias(@Query() query: any) {
        return { media: this.mediaService.filterMediaByInput(query.mask), pagination: {} };
    }
}
