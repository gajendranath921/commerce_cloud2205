/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import '../base/smartedit/base-inner-app';
import { CommonModule } from '@angular/common';
import { Component, NgModule } from '@angular/core';

import {
    moduleUtils,
    IContextualMenuService,
    IDecoratorService,
    SeDowngradeComponent,
    SeEntryModule
} from 'smarteditcommons';

const smarteditroot = 'web/webroot';
const iconIdleOff =
    smarteditroot +
    '/../../apps/smartedit-e2e/generated/e2e/contextualMenu/icons/contextualmenu_edit_off.png';
const iconIdleOn =
    smarteditroot +
    '/../../apps/smartedit-e2e/generated/e2e/contextualMenu/icons/contextualmenu_edit_on.png';
const iconIdleInfo =
    smarteditroot + '/../../apps/smartedit-e2e/generated/e2e/contextualMenu/icons/info_small.png';
const iconIdleMoveOff =
    smarteditroot +
    '/../../apps/smartedit-e2e/generated/e2e/contextualMenu/icons/contextualmenu_move_off_test.png';
const iconIdleMoveOn =
    smarteditroot +
    '/../../apps/smartedit-e2e/generated/e2e/contextualMenu/icons/contextualmenu_move_on_test.png';
const CLASS_HYICON_DRAGDROPLG = 'hyicon hyicon-dragdroplg';
const CLASS_HYICON_REMOVELG = 'hyicon hyicon-removelg';
const CLASS_HYICON_EDIT = 'hyicon hyicon-edit';
@SeDowngradeComponent()
@Component({
    selector: 'ctx',
    template: ` <div id="ctx-template-url">Some template file</div> `
})
export class CtxComponent {}

@SeDowngradeComponent()
@Component({
    selector: 'testing-1-2',
    template: ` <div id="ctx-template">testing 1,2...</div>`
})
export class TestingComponent {}

@SeEntryModule('Innerapp')
@NgModule({
    imports: [CommonModule],
    declarations: [CtxComponent, TestingComponent],
    entryComponents: [CtxComponent, TestingComponent],
    providers: [
        moduleUtils.bootstrap(
            (
                contextualMenuService: IContextualMenuService,
                decoratorService: IDecoratorService
            ) => {
                decoratorService.addMappings({
                    '^((?!Slot).)*$': ['contextualMenu']
                });

                decoratorService.enable('contextualMenu');

                let areItemsEnabled = false;
                contextualMenuService.addItems({
                    componentType1: [
                        {
                            key: 'infoFeature',
                            i18nKey: 'INFO',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('whatever');
                                }
                            },
                            displayClass: 'editbutton',
                            iconIdle: iconIdleOff,
                            iconNonIdle: iconIdleOn
                        },
                        {
                            key: 'infoFeature1',
                            i18nKey: 'INFO',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('whatever');
                                }
                            },
                            displayClass: 'editbutton',
                            iconIdle: iconIdleOff,
                            iconNonIdle: iconIdleOn
                        },
                        {
                            key: 'infoFeature2',
                            i18nKey: 'INFO',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('whatever');
                                }
                            },
                            displayClass: 'editbutton',
                            iconIdle: iconIdleOff,
                            iconNonIdle: iconIdleOn
                        },
                        {
                            key: 'infoFeature3',
                            i18nKey: 'INFO',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('whatever');
                                }
                            },
                            displayClass: 'editbutton',
                            iconIdle: iconIdleOff,
                            iconNonIdle: iconIdleOn
                        },
                        {
                            key: 'infoFeature4',
                            i18nKey: 'INFO',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('whatever');
                                }
                            },
                            displayClass: 'editbutton',
                            iconIdle: iconIdleOff,
                            iconNonIdle: iconIdleOn
                        },
                        {
                            key: 'templateString',
                            i18nKey: 'TEMPLATE',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                component: TestingComponent
                            },
                            displayClass: 'editbutton',
                            iconIdle: iconIdleOff,
                            iconNonIdle: iconIdleOn
                        }
                    ],
                    componentType2: [
                        {
                            key: 'deleteFeature',
                            i18nKey: 'DELETE',
                            condition() {
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('delete for paragraph component');
                                }
                            },
                            displayClass: 'hyicon hyicon-remove',
                            iconIdle:
                                smarteditroot +
                                '/../../apps/smartedit-e2e/generated/e2e/contextualMenu/icons/trash_small.png',
                            iconNonIdle:
                                smarteditroot +
                                '/../../apps/smartedit-e2e/generated/e2e/contextualMenu/icons/trash_small.png'
                        },
                        {
                            key: 'templateString',
                            i18nKey: 'TEMPLATEURL',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                component: CtxComponent
                            },
                            displayClass: 'editbutton',
                            iconIdle: iconIdleOff,
                            iconNonIdle: iconIdleOn
                        }
                    ],
                    SimpleResponsiveBannerComponent: [
                        {
                            key: 'enableDisableContextualMenuItems',
                            i18nKey: 'enable',
                            action: {
                                callback() {
                                    if (!areItemsEnabled) {
                                        addContextualMenuItems();
                                    } else {
                                        removeContextualMenuItems();
                                    }

                                    contextualMenuService.refreshMenuItems();
                                    areItemsEnabled = !areItemsEnabled;
                                }
                            },
                            displayClass: 'editbutton',
                            iconIdle: iconIdleInfo,
                            iconNonIdle: iconIdleInfo
                        }
                    ],
                    componentType7: [
                        {
                            key: 'se.cms.draganddrop',
                            i18nKey: 'Drag-Drop',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('DnD image icon');
                                }
                            },
                            displayClass: 'movebutton',
                            iconIdle: iconIdleMoveOff,
                            iconNonIdle: iconIdleMoveOn
                        },
                        {
                            key: 'se.cms.remove',
                            i18nKey: 'Remove',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('Remove image icon');
                                }
                            },
                            displayClass: 'removebutton',
                            iconIdle:
                                smarteditroot +
                                '/../../apps/smartedit-e2e/generated/e2e/contextualMenu/icons/contextualmenu_delete_off.png',
                            iconNonIdle:
                                smarteditroot +
                                '/../../apps/smartedit-e2e/generated/e2e/contextualMenu/icons/contextualmenu_delete_on.png'
                        },
                        {
                            key: 'se.cms.edit',
                            i18nKey: 'Edit',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('Edit image icon');
                                }
                            },
                            displayClass: 'editbutton',
                            iconIdle: iconIdleOff,
                            iconNonIdle: iconIdleOn
                        },
                        {
                            key: 'se.cms.draganddropsmall',
                            i18nKey: 'Drag-Drop',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('Small DnD image icon');
                                }
                            },
                            displayClass: 'editbutton',
                            iconNonIdle:
                                smarteditroot +
                                '/../../apps/smartedit-e2e/generated/e2e/contextualMenu/icons/contextualmenu_move_on_s.png'
                        },
                        {
                            key: 'se.cms.removesmall',
                            i18nKey: 'Remove',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('Small remove image icon');
                                }
                            },
                            displayClass: 'removebutton'
                        },
                        {
                            key: 'se.cms.editsmall',
                            i18nKey: 'Edit',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('Small edit image icon');
                                }
                            },
                            displayClass: 'editbutton',
                            iconIdle: iconIdleOff,
                            iconNonIdle: iconIdleOn
                        }
                    ],
                    componentType8: [
                        {
                            key: 'se.cms.draganddropFeature2',
                            i18nKey: 'Drag-Drop',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('DnD techne icon');
                                }
                            },
                            displayClass: 'movebutton',
                            displayIconClass: CLASS_HYICON_DRAGDROPLG,
                            displaySmallIconClass: CLASS_HYICON_DRAGDROPLG
                        },
                        {
                            key: 'se.cms.removeFeature2',
                            i18nKey: 'Remove',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('Remove techne icon');
                                }
                            },
                            displayClass: 'removebutton',
                            displayIconClass: CLASS_HYICON_REMOVELG,
                            displaySmallIconClass: CLASS_HYICON_REMOVELG
                        },
                        {
                            key: 'se.cms.editFeature2',
                            i18nKey: 'Edit',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('Edit techne icon');
                                }
                            },
                            displayClass: 'editbutton',
                            displayIconClass: CLASS_HYICON_EDIT,
                            displaySmallIconClass: CLASS_HYICON_EDIT
                        },
                        {
                            key: 'se.cms.draganddropSmallFeature2',
                            i18nKey: 'Drag-Drop',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('DnD small techne icon');
                                }
                            },
                            displayClass: 'movebutton',
                            displayIconClass: CLASS_HYICON_DRAGDROPLG,
                            displaySmallIconClass: CLASS_HYICON_DRAGDROPLG
                        },
                        {
                            key: 'se.cms.removeSmallFeature2',
                            i18nKey: 'Remove',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('Remove small techne icon');
                                }
                            },
                            displayClass: 'removebutton',
                            displayIconClass: CLASS_HYICON_REMOVELG,
                            displaySmallIconClass: CLASS_HYICON_REMOVELG
                        },
                        {
                            key: 'se.cms.editSmallFeature2',
                            i18nKey: 'Edit',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('Edit small techne icon');
                                }
                            },
                            displayClass: 'editbutton',
                            displayIconClass: CLASS_HYICON_EDIT,
                            displaySmallIconClass: CLASS_HYICON_EDIT
                        }
                    ],
                    componentType9: [
                        {
                            key: 'se.cms.draganddropFeature3',
                            i18nKey: 'Drag-Drop',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('DnD image icon -- mixed');
                                }
                            },
                            displayClass: 'movebutton',
                            iconIdle: iconIdleMoveOff,
                            iconNonIdle: iconIdleMoveOn
                        },
                        {
                            key: 'se.cms.removeFeature3',
                            i18nKey: 'Remove',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('Remove techne icon -- mixed');
                                }
                            },
                            displayClass: 'removebutton',
                            displayIconClass: CLASS_HYICON_REMOVELG,
                            displaySmallIconClass: CLASS_HYICON_REMOVELG
                        },
                        {
                            key: 'se.cms.editFeature3',
                            i18nKey: 'Edit',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('Edit techne icon -- mixed');
                                }
                            },
                            displayClass: 'editbutton',
                            displayIconClass: CLASS_HYICON_EDIT,
                            displaySmallIconClass: CLASS_HYICON_EDIT
                        },
                        {
                            key: 'se.cms.draganddropSmallFeature3',
                            i18nKey: 'Drag-Drop',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('DnD small image icon -- mixed');
                                }
                            },
                            displayClass: 'movebutton',
                            iconIdle:
                                smarteditroot +
                                '/../../apps/smartedit-e2e/generated/e2e/contextualMenu/icons/contextualmenu_move_off_s.png',
                            iconNonIdle:
                                smarteditroot +
                                '/../../apps/smartedit-e2e/generated/e2e/contextualMenu/icons/contextualmenu_move_on_s.png'
                        },
                        {
                            key: 'se.cms.removeSmallFeature3',
                            i18nKey: 'Remove',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('Remove small techne icon -- mixed');
                                }
                            },
                            displayClass: 'removebutton',
                            displayIconClass: CLASS_HYICON_REMOVELG,
                            displaySmallIconClass: CLASS_HYICON_REMOVELG
                        },
                        {
                            key: 'se.cms.editSmallFeature3',
                            i18nKey: 'Edit',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('Edit small techne icon -- mixed');
                                }
                            },
                            displayClass: 'editbutton',
                            displayIconClass: CLASS_HYICON_EDIT,
                            displaySmallIconClass: CLASS_HYICON_EDIT
                        }
                    ],
                    componentType10: [
                        {
                            key: 'se.cms.draganddropSmallFeature4',
                            i18nKey: 'Drag-Drop',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('DnD small image icon -- more menu');
                                }
                            },
                            displayClass: 'movebutton',
                            iconIdle: iconIdleMoveOff,
                            iconNonIdle: iconIdleMoveOn
                        },
                        {
                            key: 'se.cms.removeSmallFeature4',
                            i18nKey: 'Remove',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('Remove small techne icon -- more menu');
                                }
                            },
                            displayClass: 'removebutton',
                            displayIconClass: CLASS_HYICON_REMOVELG,
                            displaySmallIconClass: CLASS_HYICON_REMOVELG
                        },
                        {
                            key: 'se.cms.editSmallFeature4',
                            i18nKey: 'Edit',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('Edit small techne icon -- more menu');
                                }
                            },
                            displayClass: 'editbutton',
                            displayIconClass: CLASS_HYICON_EDIT,
                            displaySmallIconClass: CLASS_HYICON_EDIT
                        }
                    ],
                    componentType11: [
                        {
                            key: 'se.cms.draganddropSmallFeature5',
                            i18nKey: 'Drag-Drop',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('DnD small image icon -- more menu');
                                }
                            },
                            displayClass: 'movebutton',
                            iconIdle: iconIdleMoveOff,
                            iconNonIdle: iconIdleMoveOn
                        },
                        {
                            key: 'se.cms.removeSmallFeature5',
                            i18nKey: 'Remove',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('Remove small techne icon -- more menu');
                                }
                            },
                            displayClass: 'removebutton',
                            displayIconClass: CLASS_HYICON_REMOVELG,
                            displaySmallIconClass: CLASS_HYICON_REMOVELG
                        },
                        {
                            key: 'se.cms.editSmallFeature5',
                            i18nKey: 'Edit',
                            condition(configuration) {
                                configuration.element.addClass('conditionClass1');
                                return true;
                            },
                            action: {
                                callback() {
                                    alert('Edit small techne icon -- more menu');
                                }
                            },
                            displayClass: 'editbutton',
                            displayIconClass: CLASS_HYICON_EDIT,
                            displaySmallIconClass: CLASS_HYICON_EDIT
                        }
                    ]
                });

                const addContextualMenuItems = function () {
                    contextualMenuService.addItems({
                        componentType4: [
                            {
                                key: 'newFeature',
                                i18nKey: 'INFO',
                                condition(configuration) {
                                    configuration.element.addClass('conditionClass1');
                                    return true;
                                },
                                action: {
                                    callback() {
                                        alert('new Feature called');
                                    }
                                },
                                displayClass: 'editbutton',
                                iconIdle: iconIdleInfo,
                                iconNonIdle: iconIdleInfo
                            }
                        ]
                    });
                };

                const removeContextualMenuItems = function () {
                    contextualMenuService.removeItemByKey('newFeature');
                };
            },
            [IContextualMenuService, IDecoratorService]
        )
    ]
})
export class Innerapp {}
