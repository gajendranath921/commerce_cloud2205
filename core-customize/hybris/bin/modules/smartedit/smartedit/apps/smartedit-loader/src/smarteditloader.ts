/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* forbiddenNameSpaces useClass:false */
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CUSTOM_ELEMENTS_SCHEMA, ErrorHandler, NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { UpgradeModule } from '@angular/upgrade/static';
import {
    commonNgZone,
    diBridgeUtils,
    moduleUtils,
    nodeUtils,
    AuthenticationService,
    DEFAULT_AUTHENTICATION_CLIENT_ID,
    HttpInterceptorModule,
    IAuthenticationService,
    ISessionService,
    ISharedDataService,
    IStorageService,
    LanguageService,
    ResourceNotFoundErrorInterceptor,
    RestServiceFactory,
    RetryInterceptor,
    SeTranslationModule,
    SharedComponentsModule,
    SmarteditCommonsModule,
    SmarteditErrorHandler,
    SETTINGS_URI,
    SMARTEDITLOADER_COMPONENT_NAME,
    SSOAuthenticationHelper,
    UnauthorizedErrorInterceptor,
    L10nPipe
} from 'smarteditcommons';
import {
    AlertServiceModule,
    ConfigurationExtractorService,
    DelegateRestService,
    LoadConfigManagerService,
    SessionService,
    SharedDataService,
    StorageService,
    TranslationsFetchService
} from 'smarteditcontainer';
import { SmarteditloaderComponent } from './SmarteditloaderComponent';

export const SmarteditLoaderFactory = (modules: any[]): any => {
    @NgModule({
        schemas: [CUSTOM_ELEMENTS_SCHEMA],
        imports: [
            BrowserModule,
            FormsModule,
            ReactiveFormsModule,
            HttpClientModule,
            UpgradeModule,
            SmarteditCommonsModule,
            SharedComponentsModule,
            ...modules,
            AlertServiceModule,
            HttpInterceptorModule.forRoot(
                UnauthorizedErrorInterceptor,
                RetryInterceptor,
                ResourceNotFoundErrorInterceptor
            ),
            SeTranslationModule.forRoot(TranslationsFetchService)
        ],
        providers: [
            moduleUtils.provideValues({ SSO_CLIENT_ID: DEFAULT_AUTHENTICATION_CLIENT_ID }),
            SSOAuthenticationHelper,
            ConfigurationExtractorService,
            {
                provide: ErrorHandler,
                useClass: SmarteditErrorHandler
            },
            DelegateRestService,
            RestServiceFactory,
            {
                provide: IAuthenticationService,
                useClass: AuthenticationService
            },
            {
                provide: ISessionService,
                useClass: SessionService
            },
            {
                provide: ISharedDataService,
                useClass: SharedDataService
            },
            {
                provide: IStorageService,
                useClass: StorageService
            },
            LoadConfigManagerService,
            moduleUtils.initialize(() => {
                diBridgeUtils.downgradeService('languageService', LanguageService);
                diBridgeUtils.downgradeService('httpClient', HttpClient);
                diBridgeUtils.downgradeService('restServiceFactory', RestServiceFactory);
                diBridgeUtils.downgradeService('ssoAuthenticationHelper', SSOAuthenticationHelper);
                diBridgeUtils.downgradeService(
                    'authenticationService',
                    AuthenticationService,
                    IAuthenticationService
                );
                diBridgeUtils.downgradeService('l10nPipe', L10nPipe);
            })
        ],
        declarations: [SmarteditloaderComponent],
        entryComponents: [SmarteditloaderComponent],
        bootstrap: [SmarteditloaderComponent]
    })
    class Smarteditloader {}
    return Smarteditloader;
};

const setGlobalBasePathURL = async (): Promise<void> => {
    try {
        const settings = await window.fetch(SETTINGS_URI);
        const settingsJSON = await settings.json();
        if (settingsJSON['smartedit.globalBasePath']) {
            RestServiceFactory.setGlobalBasePath(String(settingsJSON['smartedit.globalBasePath']));
        }
    } catch (err) {
        console.log('Failure on loading Settings URL');
    }
    return Promise.resolve();
};

window.smarteditJQuery(document).ready(() => {
    if (!nodeUtils.hasLegacyAngularJSBootsrap()) {
        if (!document.querySelector(SMARTEDITLOADER_COMPONENT_NAME)) {
            document.body.appendChild(document.createElement(SMARTEDITLOADER_COMPONENT_NAME));
        }

        const modules = [...window.__smartedit__.pushedModules];

        setGlobalBasePathURL().then(() => {
            platformBrowserDynamic()
                .bootstrapModule(SmarteditLoaderFactory(modules), { ngZone: commonNgZone })
                .catch((err) => console.log(err));
        });
    }
});
