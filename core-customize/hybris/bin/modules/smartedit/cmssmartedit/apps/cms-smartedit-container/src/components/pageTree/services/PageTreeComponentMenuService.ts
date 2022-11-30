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
    PriorityService
} from 'smarteditcommons';

@SeDowngradeService()
export class PageTreeComponentMenuService {
    private readonly menus: IContextualMenuButton[];

    constructor(
        private readonly priorityService: PriorityService,
        private readonly editorEnablerService: IEditorEnablerService,
        private readonly componentMenuConditionAndCallbackService: IComponentMenuConditionAndCallbackService
    ) {
        this.menus = [];
        this.menus.push({
            key: 'externalcomponentbutton',
            i18nKey: 'se.cms.contextmenu.title.externalcomponent',
            displayIconClass: 'sap-icon--globe',
            condition: async (configuration: IContextualMenuConfiguration): Promise<boolean> => {
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
        });
        this.menus.push({
            key: 'se.cms.sharedcomponentbutton',
            i18nKey: 'se.cms.contextmenu.title.shared.component',
            displayIconClass: 'sap-icon--chain-link',
            condition: async (configuration: IContextualMenuConfiguration): Promise<boolean> => {
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
        });
        this.menus.push({
            key: 'se.cms.edit',
            i18nKey: 'se.cms.contextmenu.title.edit',
            displayIconClass: 'sap-icon--edit',
            action: {
                callback: this.editorEnablerService.onClickEditButton
            },
            condition: async (configuration: IContextualMenuConfiguration): Promise<boolean> => {
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
        });
        this.menus.push({
            key: 'se.cms.remove',
            i18nKey: 'se.cms.contextmenu.title.remove',
            displayIconClass: 'sap-icon--decline',
            permissions: ['se.se.context.menu.remove.component'],
            action: {
                callback: this.componentMenuConditionAndCallbackService.removeCallback
            },
            condition: this.componentMenuConditionAndCallbackService.removeCondition
        });

        this.menus.push({
            key: 'clonecomponentbutton',
            i18nKey: 'se.cms.contextmenu.title.clone.component',
            displayIconClass: 'sap-icon--duplicate',
            permissions: ['se.clone.component'],
            action: {
                callback: this.componentMenuConditionAndCallbackService.cloneCallback
            },
            condition: this.componentMenuConditionAndCallbackService.cloneCondition
        });
    }

    public async getPageTreeComponentMenus(
        configuration: IContextualMenuConfiguration
    ): Promise<IContextualMenuButton[]> {
        const promises = this.menus.map(async (item: IContextualMenuButton) => {
            if (!item.condition) {
                return item;
            }
            const isItemEnabled = await item.condition(configuration);
            return isItemEnabled ? item : null;
        });

        return Promise.all(promises);
    }
}
