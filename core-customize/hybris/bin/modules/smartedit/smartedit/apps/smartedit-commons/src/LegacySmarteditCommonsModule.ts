/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
// eslint-disable-next-line import/order
import { deprecate } from './deprecate';
import './services/forcedImport';
// TODO refactor: https://cxjira.sap.com/browse/CMSX-11518
import './components/treeModule/Ytree.scss';

// These modules do not support ES6 modules. Therefore, need special imports.
import 'ui-select/dist/select';

import { SeModule } from 'smarteditcommons/di';
import { TranslationServiceModule } from 'smarteditcommons/modules/translations/translationServiceModule';

import { ConfigModule, LanguageServiceGateway } from 'smarteditcommons/services';
import { SmarteditRootModule } from 'smarteditcommons/services/SmarteditRootModule';
// eslint-disable-next-line @typescript-eslint/no-var-requires
const NgSanitizeModule = require('angular-sanitize'); // Only supports CommonJS
// eslint-disable-next-line @typescript-eslint/no-var-requires
const NgUiBootstrapModule = require('angular-ui-bootstrap'); // Only supports CommonJS
// eslint-disable-next-line @typescript-eslint/no-var-requires
const NgTreeModule = require('angular-ui-tree'); // Only supports CommonJS
// eslint-disable-next-line @typescript-eslint/no-var-requires
const NgInfiniteScrollModule = require('ng-infinite-scroll'); // Only supports CommonJS

deprecate();

/**
 * Module containing all the services shared within the smartedit commons.
 */
@SeModule({
    imports: [
        SmarteditRootModule,
        NgTreeModule,
        NgInfiniteScrollModule,
        NgUiBootstrapModule,
        'resourceLocationsModule',
        'seConstantsModule',
        'yLoDashModule',
        TranslationServiceModule,
        ConfigModule,
        'ui.select',
        NgSanitizeModule
    ],
    providers: [LanguageServiceGateway]
})
export class LegacySmarteditCommonsModule {}
