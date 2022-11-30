/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import {
    IEditorEnablerService,
    IComponentMenuConditionAndCallbackService,
    SharedComponentButtonComponent,
    ExternalComponentButtonComponent
} from 'cmscommons';
import {
    SeDowngradeService,
    IContextualMenuButton,
    IContextualMenuConfiguration,
    IPermissionService
} from 'smarteditcommons';

@SeDowngradeService()
export class PageTreeComponentMenuService {
    private readonly originalMenus: IContextualMenuButton[];

    constructor(
        private readonly editorEnablerService: IEditorEnablerService,
        private readonly componentMenuConditionAndCallbackService: IComponentMenuConditionAndCallbackService,
        private readonly permissionService: IPermissionService
    ) {
        // Menus are displayed from left to right in the order in array
        this.originalMenus = [
            {
                key: 'externalcomponentbutton',
                i18nKey: 'se.cms.contextmenu.title.externalcomponent',
                displayIconClass: 'sap-icon--globe',
                permissions: [],
                condition: async (
                    configuration: IContextualMenuConfiguration
                ): Promise<boolean> => {
                    if (configuration.isComponentHidden) {
                        return Promise.resolve(false);
                    } else {
                        return this.componentMenuConditionAndCallbackService.externalCondition(
                            configuration
                        );
                    }
                },
                action: {
                    component: ExternalComponentButtonComponent
                }
            },
            {
                key: 'se.cms.sharedcomponentbutton',
                i18nKey: 'se.cms.contextmenu.title.shared.component',
                displayIconClass: 'sap-icon--chain-link',
                permissions: [],
                condition: async (
                    configuration: IContextualMenuConfiguration
                ): Promise<boolean> => {
                    if (configuration.isComponentHidden) {
                        return Promise.resolve(false);
                    } else {
                        return this.componentMenuConditionAndCallbackService.sharedCondition(
                            configuration
                        );
                    }
                },
                action: {
                    component: SharedComponentButtonComponent
                }
            },
            {
                key: 'se.cms.edit',
                i18nKey: 'se.cms.contextmenu.title.edit',
                displayIconClass: 'sap-icon--edit',
                permissions: ['se.context.menu.edit.component'],
                action: {
                    callback: this.editorEnablerService.onClickEditButton
                },
                condition: async (
                    configuration: IContextualMenuConfiguration
                ): Promise<boolean> => {
                    if (configuration.isComponentHidden) {
                        return this.componentMenuConditionAndCallbackService.editConditionForHiddenComponent(
                            configuration
                        );
                    } else {
                        return this.editorEnablerService.isSlotEditableForNonExternalComponent(
                            configuration
                        );
                    }
                }
            },
            {
                key: 'se.cms.remove',
                i18nKey: 'se.cms.contextmenu.title.remove',
                displayIconClass: 'sap-icon--decline',
                permissions: ['se.context.menu.remove.component'],
                action: {
                    callback: this.componentMenuConditionAndCallbackService.removeCallback
                },
                condition: this.componentMenuConditionAndCallbackService.removeCondition
            },
            {
                key: 'clonecomponentbutton',
                i18nKey: 'se.cms.contextmenu.title.clone.component',
                displayIconClass: 'sap-icon--duplicate',
                permissions: ['se.clone.component'],
                action: {
                    callback: this.componentMenuConditionAndCallbackService.cloneCallback
                },
                condition: this.componentMenuConditionAndCallbackService.cloneCondition
            }
        ];
    }

    public async getPageTreeComponentMenus(
        configuration: IContextualMenuConfiguration
    ): Promise<IContextualMenuButton[]> {
        const menus = await this.buildMenusByPermission();
        const promises = menus.map(async (item: IContextualMenuButton) => {
            if (!item.condition) {
                return item;
            }
            const isItemEnabled = await item.condition(configuration);
            return isItemEnabled ? item : null;
        });

        return Promise.all(promises);
    }

    private async buildMenusByPermission(): Promise<IContextualMenuButton[]> {
        const menus = await Promise.all(
            this.originalMenus.map(async (item) => {
                if (!item.permissions || item.permissions.length === 0) {
                    return item;
                }

                const allowed = await this.permissionService.isPermitted([
                    {
                        names: item.permissions
                    }
                ]);
                if (allowed) {
                    return item;
                }
                return null;
            })
        );
        return menus.filter((menu) => !!menu);
    }
}
