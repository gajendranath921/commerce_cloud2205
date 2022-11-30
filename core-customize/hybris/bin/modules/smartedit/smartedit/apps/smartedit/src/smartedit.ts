/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* forbiddenNameSpaces useClass:false */
import './modules/system/features/contextualMenu.scss';

import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CUSTOM_ELEMENTS_SCHEMA, ErrorHandler, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { UpgradeModule } from '@angular/upgrade/static';
import * as lo from 'lodash';
import {
    AuthenticationService,
    ConfirmationModalService,
    ContextualMenuService,
    DecoratorService,
    IframeClickDetectionService,
    LegacyDecoratorToCustomElementConverter,
    ResizeComponentService,
    SeNamespaceService,
    SharedDataService,
    SmarteditServicesModule,
    StorageService,
    TranslationsFetchService,
    UrlService
} from 'smartedit/services';
import { SakExecutorService } from 'smartedit/services/sakExecutor/SakExecutorService';
import {
    diBridgeUtils,
    moduleUtils,
    AngularJSBootstrapIndicatorService,
    AuthenticationManager,
    BootstrapPayload,
    CompileHtmlModule,
    CrossFrameEventService,
    EVENTS,
    GatewayFactory,
    HttpInterceptorModule,
    IAuthenticationManagerService,
    IAuthenticationService,
    ICatalogService,
    IConfirmationModalService,
    IContextualMenuService,
    IDecoratorService,
    IExperienceService,
    IFeatureService,
    IIframeClickDetectionService,
    ILegacyDecoratorToCustomElementConverter,
    IPageInfoService,
    IPerspectiveService,
    IRenderService,
    ISessionService,
    ISharedDataService,
    ISmartEditContractChangeListener,
    IPageTreeNodeService,
    IStorageService,
    ITemplateCacheService,
    IToolbarServiceFactory,
    IUrlService,
    LanguageService,
    OVERLAY_RERENDERED_EVENT,
    PolyfillService,
    PopupOverlayModule,
    RetryInterceptor,
    SeTranslationModule,
    SmarteditErrorHandler,
    SmarteditRoutingService,
    SystemEventService,
    SMARTEDIT_DRAG_AND_DROP_EVENTS,
    TypedMap,
    L10nService,
    L10nPipe,
    UserTrackingService
} from 'smarteditcommons';
import { ContextualMenuItemComponent } from './components/contextualMenuItem/ContextualMenuItemComponent';
import { SmarteditComponent } from './components/SmarteditComponent';
import {
    ContextualMenuDecoratorComponent,
    ContextualMenuItemOverlayComponent,
    MoreItemsComponent
} from './modules/system/features/contextualMenu/ContextualMenuDecoratorComponent';
import { SlotContextualMenuDecoratorComponent } from './modules/system/features/slotContextualMenu/SlotContextualMenuDecoratorComponent';
import { SlotContextualMenuItemComponent } from './modules/system/features/slotContextualMenu/SlotContextualMenuItemComponent';
import { CatalogService, ExperienceService, SessionService } from './services';
import { SmarteditElementComponent } from './services/sakExecutor/SmarteditElementComponent';
import { StorageModule } from './services/storage/StorageModuleInner';
import { ToolbarServiceFactory } from './services/ToolbarServiceFactory';

export const SmarteditFactory = (payload: BootstrapPayload): any => {
    @NgModule({
        schemas: [CUSTOM_ELEMENTS_SCHEMA],
        imports: [
            BrowserModule,
            UpgradeModule,
            HttpClientModule,
            StorageModule,
            SmarteditServicesModule,
            PopupOverlayModule,
            CompileHtmlModule,
            HttpInterceptorModule.forRoot(RetryInterceptor),
            SeTranslationModule.forRoot(TranslationsFetchService),
            ...payload.modules

            /* TODO: create a function and dynamic add of extensions NgModule(s) */
        ],
        declarations: [
            SmarteditComponent,
            SmarteditElementComponent,
            ContextualMenuDecoratorComponent,
            ContextualMenuItemComponent,
            MoreItemsComponent,
            ContextualMenuItemOverlayComponent,
            SlotContextualMenuDecoratorComponent,
            SlotContextualMenuItemComponent
        ],
        entryComponents: [
            SmarteditComponent,
            SmarteditElementComponent,
            ContextualMenuDecoratorComponent,
            ContextualMenuItemComponent,
            MoreItemsComponent,
            ContextualMenuItemOverlayComponent,
            SlotContextualMenuDecoratorComponent,
            SlotContextualMenuItemComponent
        ],
        providers: [
            { provide: IAuthenticationManagerService, useClass: AuthenticationManager },
            {
                provide: IConfirmationModalService,
                useClass: ConfirmationModalService
            },
            {
                provide: IAuthenticationService,
                useClass: AuthenticationService
            },
            {
                provide: ErrorHandler,
                useClass: SmarteditErrorHandler
            },
            {
                provide: ILegacyDecoratorToCustomElementConverter,
                useClass: LegacyDecoratorToCustomElementConverter
            },
            {
                provide: IDecoratorService,
                useClass: DecoratorService
            },
            { provide: IContextualMenuService, useClass: ContextualMenuService },
            SakExecutorService,
            {
                provide: ISessionService,
                useClass: SessionService
            },
            {
                provide: IToolbarServiceFactory,
                useClass: ToolbarServiceFactory
            },
            {
                provide: ISharedDataService,
                useClass: SharedDataService
            },
            {
                provide: IStorageService,
                useClass: StorageService
            },
            {
                provide: IUrlService,
                useClass: UrlService
            },
            {
                provide: IIframeClickDetectionService,
                useClass: IframeClickDetectionService
            },
            {
                provide: ICatalogService,
                useClass: CatalogService
            },
            {
                provide: IExperienceService,
                useClass: ExperienceService
            },
            SmarteditRoutingService,
            moduleUtils.provideValues(payload.constants),
            // temporary upgrades
            diBridgeUtils.upgradeProvider('EVENT_PERSPECTIVE_CHANGED'),
            diBridgeUtils.upgradeProvider('EVENT_PERSPECTIVE_REFRESHED'),
            diBridgeUtils.upgradeProvider('EVENT_SMARTEDIT_COMPONENT_UPDATED'),
            diBridgeUtils.upgradeProvider('SMARTEDIT_DRAG_AND_DROP_EVENTS'),
            diBridgeUtils.upgradeProvider('$templateCache', ITemplateCacheService),
            moduleUtils.bootstrap(
                (
                    gatewayFactory: GatewayFactory,
                    smartEditContractChangeListener: ISmartEditContractChangeListener,
                    seNamespaceService: SeNamespaceService,
                    resizeComponentService: ResizeComponentService,
                    renderService: IRenderService,
                    systemEventService: SystemEventService,
                    pageInfoService: IPageInfoService,
                    experienceService: IExperienceService,
                    polyfillService: PolyfillService,
                    crossFrameEventService: CrossFrameEventService,
                    perspectiveService: IPerspectiveService,
                    languageService: LanguageService,
                    featureService: IFeatureService,
                    angularJSBootstrapIndicatorService: AngularJSBootstrapIndicatorService,
                    pageTreeNodeService: IPageTreeNodeService,
                    userTrackingService: UserTrackingService
                ) => {
                    angularJSBootstrapIndicatorService.onSmarteditReady().subscribe(() => {
                        gatewayFactory.initListener();

                        smartEditContractChangeListener.onComponentsAdded(
                            (components: HTMLElement[], isEconomyMode: boolean) => {
                                if (!isEconomyMode) {
                                    seNamespaceService.reprocessPage();
                                    resizeComponentService.resizeComponents(true);
                                }
                                components.forEach((component) =>
                                    renderService.createComponent(component)
                                );
                                systemEventService.publishAsync(OVERLAY_RERENDERED_EVENT, {
                                    addedComponents: components
                                });
                            }
                        );

                        smartEditContractChangeListener.onComponentsRemoved(
                            (
                                components: {
                                    component: HTMLElement;
                                    parent: HTMLElement;
                                    oldAttributes: TypedMap<string>;
                                }[],
                                isEconomyMode: boolean
                            ) => {
                                if (!isEconomyMode) {
                                    seNamespaceService.reprocessPage();
                                }
                                components.forEach((entry) =>
                                    renderService.destroyComponent(
                                        entry.component,
                                        entry.parent,
                                        entry.oldAttributes
                                    )
                                );
                                systemEventService.publishAsync(OVERLAY_RERENDERED_EVENT, {
                                    removedComponents: lo.map(components, 'component')
                                });
                            }
                        );

                        smartEditContractChangeListener.onComponentResized(
                            (component: HTMLElement) => {
                                seNamespaceService.reprocessPage();
                                renderService.updateComponentSizeAndPosition(component);
                            }
                        );

                        smartEditContractChangeListener.onComponentRepositioned(
                            (component: HTMLElement) => {
                                renderService.updateComponentSizeAndPosition(component);
                            }
                        );

                        smartEditContractChangeListener.onComponentChanged(
                            (component: any, oldAttributes: TypedMap<string>) => {
                                seNamespaceService.reprocessPage();

                                renderService.destroyComponent(
                                    component,
                                    component.parent,
                                    oldAttributes
                                );
                                renderService.createComponent(component);
                            }
                        );

                        smartEditContractChangeListener.onPageChanged((pageUUID: string) => {
                            pageInfoService
                                .getCatalogVersionUUIDFromPage()
                                .then((catalogVersionUUID: string) => {
                                    pageInfoService.getPageUID().then((pageUID: string) => {
                                        experienceService.updateExperiencePageContext(
                                            catalogVersionUUID,
                                            pageUID
                                        );
                                    });
                                });
                            pageTreeNodeService.buildSlotNodes();
                        });

                        if (polyfillService.isEligibleForEconomyMode()) {
                            systemEventService.subscribe(
                                SMARTEDIT_DRAG_AND_DROP_EVENTS.DRAG_DROP_START,
                                function () {
                                    smartEditContractChangeListener.setEconomyMode(true);
                                }
                            );

                            systemEventService.subscribe(
                                SMARTEDIT_DRAG_AND_DROP_EVENTS.DRAG_DROP_END,
                                function () {
                                    seNamespaceService.reprocessPage();
                                    resizeComponentService.resizeComponents(true);
                                    smartEditContractChangeListener.setEconomyMode(false);
                                }
                            );
                        }

                        crossFrameEventService.subscribe(EVENTS.PAGE_CHANGE, () => {
                            perspectiveService.refreshPerspective();
                            languageService.registerSwitchLanguage();
                        });

                        smartEditContractChangeListener.initListener();

                        pageTreeNodeService.buildSlotNodes();

                        userTrackingService.initConfiguration();

                        // Feature registration
                        featureService.register({
                            key: 'se.emptySlotFix',
                            nameI18nKey: 'se.emptyslotfix',
                            enablingCallback: () => {
                                resizeComponentService.resizeComponents(true);
                            },
                            disablingCallback: () => {
                                resizeComponentService.resizeComponents(false);
                            }
                        });

                        featureService.addDecorator({
                            key: 'se.contextualMenu',
                            nameI18nKey: 'contextualMenu'
                        });

                        featureService.addDecorator({
                            key: 'se.slotContextualMenu',
                            nameI18nKey: 'se.slot.contextual.menu'
                        });
                    });
                },
                [
                    GatewayFactory,
                    ISmartEditContractChangeListener,
                    SeNamespaceService,
                    ResizeComponentService,
                    IRenderService,
                    SystemEventService,
                    IPageInfoService,
                    IExperienceService,
                    PolyfillService,
                    CrossFrameEventService,
                    IPerspectiveService,
                    LanguageService,
                    IFeatureService,
                    AngularJSBootstrapIndicatorService,
                    IPageTreeNodeService,
                    UserTrackingService
                ]
            ),
            moduleUtils.initialize(
                (
                    httpClient: HttpClient,
                    iframeClickDetectionService: IIframeClickDetectionService, // initializes mousedown event listener for the iframe
                    l10nService: L10nService
                ) => {
                    diBridgeUtils.downgradeService('languageService', LanguageService);
                    diBridgeUtils.downgradeService('httpClient', HttpClient);
                    diBridgeUtils.downgradeService('l10nPipe', L10nPipe);
                    return l10nService.resolveLanguage();
                },
                [HttpClient, IIframeClickDetectionService, L10nService]
            )
        ],
        bootstrap: [SmarteditComponent]
    })
    class Smartedit {}
    return Smartedit;
};
/* forbiddenNameSpaces window._:false */
window.__smartedit__.SmarteditFactory = SmarteditFactory;
