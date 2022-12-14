/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import '../base/smarteditcontainer/outer-app';

import { NgModule } from '@angular/core';
import { moduleUtils, IFeatureService, IPerspectiveService, SeEntryModule } from 'smarteditcommons';

@SeEntryModule('OuterDummyToolbars')
@NgModule({
    providers: [
        moduleUtils.bootstrap(
            (featureService: IFeatureService, perspectiveService: IPerspectiveService) => {
                featureService.addToolbarItem({
                    toolbarId: 'smartEditPerspectiveToolbar',
                    key: 'dummyToolbar',
                    type: 'HYBRID_ACTION',
                    nameI18nKey: 'DUMMYTOOLBAR',
                    priority: 1,
                    section: 'left',
                    iconClassName: 'hyicon hyicon-addlg se-toolbar-menu-ddlb--button__icon',
                    callback() {
                        //
                    }
                });

                perspectiveService.register({
                    key: 'se.cms.perspective.basic',
                    nameI18nKey: 'se.cms.perspective.basic.name',
                    features: ['dummyToolbar'],
                    perspectives: []
                });
            },
            [IFeatureService, IPerspectiveService]
        )
    ]
})
export class OuterDummyToolbars {}
