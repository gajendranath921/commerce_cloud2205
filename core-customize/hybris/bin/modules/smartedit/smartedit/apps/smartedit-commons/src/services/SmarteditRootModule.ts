/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { CloneableUtils, FunctionsUtils, LogService } from '@smart/utils';
import { DIBridgeModule, SeModule } from '../di';
import { ModuleUtils, PromiseUtils, StringUtils } from '../utils';
import { SeConstantsModule } from './SeConstantsModule';

/**
 * Module acts as a root module of smartedit commons module.
 */
@SeModule({
    imports: [DIBridgeModule, 'resourceLocationsModule', 'yLoDashModule', SeConstantsModule],
    providers: [CloneableUtils, LogService, ModuleUtils, PromiseUtils, StringUtils, FunctionsUtils]
})
/** @internal */
export class SmarteditRootModule {}
