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

const smarteditroot = '../e2e/slotContextualMenu';
const OFF_IMAGE = '/images/slot_contextualmenu_placeholder_off.png';
const ON_IMAGE = '/images/slot_contextualmenu_placeholder_on.png';
const DISPLAY_CLASS = 'editbutton se-ctx-menu-element__btn';

@SeDowngradeComponent()
@Component({
    selector: 'dummy',
    template: `
        <div>
            ..... Dummy Template
            <img src="../e2e/slotContextualMenu/images/slot_contextualmenu_placeholder_off.png" />
            .....
        </div>
    `
})
export class DummyComponent {}

@SeEntryModule('Innerapp')
@NgModule({
    imports: [CommonModule],
    declarations: [DummyComponent],
    entryComponents: [DummyComponent],
    providers: [
        moduleUtils.bootstrap(
            (
                contextualMenuService: IContextualMenuService,
                decoratorService: IDecoratorService
            ) => {
                const addContextualMenuItem = (key: string) => {
                    contextualMenuService.addItems({
                        '^.*Slot$': [
                            {
                                key: 'slot.context.menu.title' + key,
                                displayClass: DISPLAY_CLASS,
                                i18nKey: 'slot.context.menu.title.' + key,
                                iconIdle: smarteditroot + OFF_IMAGE,

                                iconNonIdle: smarteditroot + ON_IMAGE,

                                action: {
                                    callback() {
                                        addContextualMenuItem('dummy5');
                                    }
                                }
                            }
                        ]
                    });
                };

                decoratorService.addMappings({
                    '^.*Slot$': ['se.slotContextualMenu']
                });

                decoratorService.enable('se.slotContextualMenu');

                contextualMenuService.addItems({
                    '^.*Slot$': [
                        {
                            key: 'slot.context.menu.title.dummy1',
                            displayClass: DISPLAY_CLASS,
                            i18nKey: 'slot.context.menu.title.dummy1',
                            iconIdle: smarteditroot + OFF_IMAGE,
                            iconNonIdle: smarteditroot + ON_IMAGE,

                            action: {
                                callback() {
                                    addContextualMenuItem('dummy3');
                                }
                            }
                        },
                        {
                            key: 'slot.context.menu.title.dummy2',
                            displayClass: DISPLAY_CLASS,
                            i18nKey: 'slot.context.menu.title.dummy2',
                            iconIdle: smarteditroot + OFF_IMAGE,
                            iconNonIdle: smarteditroot + ON_IMAGE,

                            action: {
                                callback() {
                                    addContextualMenuItem('dummy4');
                                }
                            }
                        },
                        {
                            key: 'slot.context.menu.title.dummy6',
                            action: {
                                component: DummyComponent,
                                callback() {
                                    addContextualMenuItem('dummy6');
                                }
                            }
                        }
                    ]
                });
            },
            [IContextualMenuService, IDecoratorService]
        )
    ]
})
export class Innerapp {}
