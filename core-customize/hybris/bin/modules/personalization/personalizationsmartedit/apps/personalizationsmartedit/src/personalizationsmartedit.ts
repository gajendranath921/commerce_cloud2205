/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { UpgradeModule } from '@angular/upgrade/static';
import {
    BaseSiteHeaderInterceptor,
    IPersonalizationsmarteditContextMenuServiceProxy,
    PersonalizationsmarteditCommonsComponentsModule,
    IPersonalizationsmarteditContextServiceProxy
} from 'personalizationcommons';
import {
    ISharedDataService,
    SeEntryModule,
    PopupOverlayModule,
    SeTranslationModule,
    IContextualMenuButton,
    IFeatureService,
    IDecoratorService,
    moduleUtils
} from 'smarteditcommons';
import { PersonalizationsmarteditCombinedViewComponentLightUpDecorator } from './combinedView';
import { PersonalizationsmarteditComponentLightUpDecorator } from './componentLightUpDecorator';
import {
    ShowComponentInfoListModule,
    PersonalizationsmarteditContextMenuServiceProxy
} from './contextMenu';
import { ShowActionListComponent } from './contextMenu/ShowActionList/ShowActionListComponent';
import { ShowActionListModule } from './contextMenu/ShowActionListModule';
import { ShowComponentInfoListComponent } from './contextMenu/ShowComponentInfoList/ShowComponentInfoListComponent';
import { CustomizeViewModule } from './customizeView/CustomizeViewModule';
import { CustomizeViewServiceProxy } from './customizeView/CustomizeViewServiceInnerProxy';
import { PersonalizationsmarteditComponentHandlerService } from './service/PersonalizationsmarteditComponentHandlerService';
import { PersonalizationsmarteditContextualMenuService } from './service/PersonalizationsmarteditContextualMenuService';
import { servicesModule } from './service/servicesModule';
import { SharedSlotComponent } from './sharedSlotDecorator/SharedSlotComponent';

import '../../styling/style.less';

@SeEntryModule('personalizationsmartedit')
@NgModule({
    imports: [
        SeTranslationModule.forChild(),
        BrowserModule,
        UpgradeModule,
        PersonalizationsmarteditCommonsComponentsModule,
        ShowComponentInfoListModule,
        CustomizeViewModule,
        ShowActionListModule,
        PopupOverlayModule,
        servicesModule
    ],
    providers: [
        PersonalizationsmarteditContextualMenuService,
        PersonalizationsmarteditComponentHandlerService,
        {
            provide: HTTP_INTERCEPTORS,
            useClass: BaseSiteHeaderInterceptor,
            multi: true,
            deps: [ISharedDataService]
        },
        {
            provide: IPersonalizationsmarteditContextMenuServiceProxy,
            useClass: PersonalizationsmarteditContextMenuServiceProxy
        },
        moduleUtils.bootstrap(
            (
                decoratorService: IDecoratorService,
                featureService: IFeatureService,
                personalizationsmarteditContextualMenuService: PersonalizationsmarteditContextualMenuService
            ) => {
                decoratorService.addMappings({
                    '^.*Slot$': ['personalizationsmarteditSharedSlot', 'se.slotContextualMenu']
                });

                decoratorService.addMappings({
                    '^.*Component$': [
                        'personalizationsmarteditComponentLightUp',
                        'personalizationsmarteditCombinedViewComponentLightUp'
                    ]
                });

                featureService.addDecorator({
                    key: 'personalizationsmarteditComponentLightUp',
                    nameI18nKey: 'personalizationsmarteditComponentLightUp'
                });

                featureService.addDecorator({
                    key: 'personalizationsmarteditCombinedViewComponentLightUp',
                    nameI18nKey: 'personalizationsmarteditCombinedViewComponentLightUp'
                });

                featureService.addDecorator({
                    key: 'personalizationsmarteditSharedSlot',
                    nameI18nKey: 'personalizationsmarteditSharedSlot'
                });

                featureService.addContextualMenuButton({
                    key: 'personalizationsmartedit.context.show.action.list',
                    i18nKey: 'personalization.context.action.list.show',
                    nameI18nKey: 'personalization.context.action.list.show',
                    regexpKeys: ['^.*Component$'],
                    condition: (config: any) =>
                        personalizationsmarteditContextualMenuService.isContextualMenuShowActionListEnabled(
                            config
                        ),
                    action: {
                        component: ShowActionListComponent
                    },
                    displayClass: 'showactionlistbutton',
                    displayIconClass:
                        'hyicon hyicon-combinedview cmsx-ctx__icon personalization-ctx__icon',
                    displaySmallIconClass: 'hyicon hyicon-combinedview cmsx-ctx__icon--small',
                    permissions: ['se.read.page'],
                    priority: 500
                } as IContextualMenuButton);

                featureService.addContextualMenuButton({
                    key: 'personalizationsmartedit.context.info.action',
                    i18nKey: 'personalization.context.action.info',
                    nameI18nKey: 'personalization.context.action.info',
                    regexpKeys: ['^.*Component$'],
                    condition: () =>
                        personalizationsmarteditContextualMenuService.isContextualMenuInfoItemEnabled(),
                    action: {
                        component: ShowComponentInfoListComponent
                    },
                    displayClass: 'infoactionbutton',
                    displayIconClass:
                        'hyicon hyicon-msginfo cmsx-ctx__icon personalization-ctx__icon',
                    displaySmallIconClass: 'hyicon hyicon-msginfo cmsx-ctx__icon--small',
                    permissions: ['se.edit.page'],
                    priority: 510
                } as IContextualMenuButton);

                featureService.addContextualMenuButton({
                    key: 'personalizationsmartedit.context.add.action',
                    i18nKey: 'personalization.context.action.add',
                    nameI18nKey: 'personalization.context.action.add',
                    regexpKeys: ['^.*Component$'],
                    condition: (config: any) =>
                        personalizationsmarteditContextualMenuService.isContextualMenuAddItemEnabled(
                            config
                        ),
                    action: {
                        callback: (config: any): any => {
                            personalizationsmarteditContextualMenuService.openAddAction(config);
                        }
                    },
                    displayClass: 'addactionbutton',
                    displayIconClass:
                        'hyicon hyicon-addlg cmsx-ctx__icon personalization-ctx__icon',
                    displaySmallIconClass: 'hyicon hyicon-addlg cmsx-ctx__icon--small',
                    permissions: ['se.edit.page'],
                    priority: 520
                } as IContextualMenuButton);

                featureService.addContextualMenuButton({
                    key: 'personalizationsmartedit.context.component.edit.action',
                    i18nKey: 'personalization.context.component.action.edit',
                    nameI18nKey: 'personalization.context.component.action.edit',
                    regexpKeys: ['^.*Component$'],
                    condition: (config: any) =>
                        personalizationsmarteditContextualMenuService.isContextualMenuEditComponentItemEnabled(
                            config
                        ),
                    action: {
                        callback: (config: any): any => {
                            personalizationsmarteditContextualMenuService.openEditComponentAction(
                                config
                            );
                        }
                    },
                    displayClass: 'editbutton',
                    displayIconClass: 'sap-icon--edit cmsx-ctx__icon',
                    displaySmallIconClass: 'sap-icon--edit cmsx-ctx__icon--small',
                    permissions: ['se.edit.page'],
                    priority: 530
                } as IContextualMenuButton);

                featureService.addContextualMenuButton({
                    key: 'personalizationsmartedit.context.edit.action',
                    i18nKey: 'personalization.context.action.edit',
                    nameI18nKey: 'personalization.context.action.edit',
                    regexpKeys: ['^.*Component$'],
                    condition: (config: any) =>
                        personalizationsmarteditContextualMenuService.isContextualMenuEditItemEnabled(
                            config
                        ),
                    action: {
                        callback: (config: any): any => {
                            personalizationsmarteditContextualMenuService.openEditAction(config);
                        }
                    },
                    displayClass: 'replaceactionbutton',
                    displayIconClass:
                        'hyicon hyicon-change cmsx-ctx__icon personalization-ctx__icon',
                    displaySmallIconClass: 'hyicon hyicon-change cmsx-ctx__icon--small',
                    permissions: ['se.edit.page'],
                    priority: 540
                } as IContextualMenuButton);

                featureService.addContextualMenuButton({
                    key: 'personalizationsmartedit.context.delete.action',
                    i18nKey: 'personalization.context.action.delete',
                    nameI18nKey: 'personalization.context.action.delete',
                    regexpKeys: ['^.*Component$'],
                    condition: (config: any) =>
                        personalizationsmarteditContextualMenuService.isContextualMenuDeleteItemEnabled(
                            config
                        ),
                    action: {
                        callback: (config: any): any => {
                            personalizationsmarteditContextualMenuService.openDeleteAction(config);
                        }
                    },
                    displayClass: 'removeactionbutton',
                    displayIconClass:
                        'hyicon hyicon-removelg cmsx-ctx__icon personalization-ctx__icon',
                    displaySmallIconClass: 'hyicon hyicon-removelg cmsx-ctx__icon--small',
                    permissions: ['se.edit.page'],
                    priority: 550
                } as IContextualMenuButton);

                featureService.addContextualMenuButton({
                    key: 'personalizationsmarteditSharedSlot',
                    nameI18nKey: 'slotcontextmenu.title.shared.button',
                    regexpKeys: ['^.*Slot$'],
                    action: {
                        component: SharedSlotComponent
                    },
                    permissions: ['se.read.page']
                });
            },
            [
                IDecoratorService,
                IFeatureService,
                PersonalizationsmarteditContextualMenuService,
                PersonalizationsmarteditComponentHandlerService,
                IPersonalizationsmarteditContextServiceProxy,
                CustomizeViewServiceProxy
            ]
        )
    ],
    declarations: [
        PersonalizationsmarteditComponentLightUpDecorator,
        PersonalizationsmarteditCombinedViewComponentLightUpDecorator,
        SharedSlotComponent
    ],
    entryComponents: [
        PersonalizationsmarteditComponentLightUpDecorator,
        PersonalizationsmarteditCombinedViewComponentLightUpDecorator,
        SharedSlotComponent
    ]
})
export class PersonalizationsmarteditModule {}
