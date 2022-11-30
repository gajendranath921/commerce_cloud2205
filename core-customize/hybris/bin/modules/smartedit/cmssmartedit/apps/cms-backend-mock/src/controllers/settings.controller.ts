/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { Controller, Get } from '@nestjs/common';

@Controller()
export class SettingsController {
    @Get('smartedit/settings')
    getSettings() {
        return { 'smartedit.pagetree.enabled': 'false' };
    }
}
