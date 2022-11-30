/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/* forbiddenNameSpaces useClass:false */
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { UpgradeModule } from '@angular/upgrade/static';
import {
    CmsCommonsModule,
    IPageContentSlotsComponentsRestService,
    IRemoveComponentService,
    VersionExperienceInterceptor,
    TRASHED_PAGE_LIST_PATH,
    IContextAwareEditableItemService,
    IComponentVisibilityAlertService,
    IComponentSharedService,
    ISlotVisibilityService,
    IEditorEnablerService,
    IComponentMenuConditionAndCallbackService,
    PAGE_LIST_PATH,
    NAVIGATION_MANAGEMENT_PAGE_PATH
} from 'cmscommons';
import {
    IToolbarServiceFactory,
    L10nPipeModule,
    MessageModule,
    moduleUtils,
    NG_ROUTE_PREFIX,
    ResponseAdapterInterceptor,
    SeEntryModule,
    SeGenericEditorModule,
    SeRouteService,
    SeTranslationModule,
    SharedComponentsModule,
    ToolbarItemType,
    ToolbarSection,
    TooltipModule,
    IFeatureService,
    SystemEventService,
    CATALOG_DETAILS_COLUMNS,
    ICatalogDetailsService,
    ToolbarDropDownPosition,
    IPerspectiveService,
    COMPONENT_CLASS,
    InViewElementObserver,
    ShortcutLinkComponent,
    CMSModesService,
    ISlotRestrictionsService,
    IPageService,
    ISyncPollingService,
    IEditorModalService,
    IPageTreeService,
    EVENT_PAGE_TREE_PANEL_SWITCH,
    CrossFrameEventService,
    ISettingsService
} from 'smarteditcommons';
import {
    CmsComponentsModule,
    ComponentMenuComponent,
    OPEN_COMPONENT_EVENT,
    GenericEditorWidgetsModule,
    MediaModule,
    CmsGenericEditorConfigurationService,
    NavigationEditorLinkComponent,
    NavigationManagementPageComponent,
    NavigationModule,
    ClonePageWizardService,
    DeletePageToolbarItemComponent,
    PageComponentsModule,
    PageInfoMenuComponent,
    PageListComponent,
    PageListLinkComponent,
    PagesLinkComponent,
    TrashedPageListComponent,
    TrashedPageListModule,
    TrashLinkComponent,
    RestrictionsModule,
    SynchronizationModule,
    PageSyncMenuToolbarItemComponent,
    CatalogDetailsSyncComponent,
    VersioningModule,
    ManagePageVersionService,
    RollbackPageVersionService,
    PageVersionMenuComponent,
    VersionItemContextComponent,
    PageApprovalSelectorComponent,
    PageDisplayStatusWrapperComponent,
    PageWorkflowMenuComponent,
    WorkflowInboxComponent,
    WorkflowModule,
    PageTreePanel,
    PageTreeModule
} from './components';
import {
    CatalogVersionRestService,
    PageRestrictionsRestService,
    PageTypesRestrictionTypesRestService,
    PageContentSlotsComponentsRestService,
    PagesFallbacksRestService,
    PagesRestService,
    PagesVariationsRestService,
    PageTypeService,
    RestrictionTypesRestService,
    StructureModeManagerFactory,
    StructuresRestService,
    TypeStructureRestService
} from './dao';
import { DisplayConditionsFacade, PageFacade } from './facades';
import {
    EditorModalService,
    HomepageService,
    ComponentVisibilityAlertService,
    CmsDragAndDropService,
    ContextAwareCatalogService,
    RulesAndPermissionsRegistrationService,
    PageRestoredAlertService,
    ActionableAlertService,
    ClonePageAlertComponent,
    ClonePageAlertService,
    PageRestoredAlertComponent,
    ComponentSharedService,
    GenericEditorModalComponent,
    ContextAwareEditableItemService,
    GenericEditorModalService,
    ExperienceGuard,
    DisplayConditionsEditorModel,
    PageDisplayConditionsService,
    PageRestrictionsCriteriaService,
    PageRestrictionsService,
    PageTypesRestrictionTypesService,
    RestrictionTypesService,
    PageService,
    PageTreeComponentMenuService,
    AddPageWizardService,
    ManagePageService,
    RestrictionsStepHandlerFactory,
    PageTemplateService,
    ProductCategoryService,
    RemoveComponentService,
    RestrictionsService,
    SlotRestrictionsService,
    SlotVisibilityService,
    SyncPollingService,
    EditorEnablerService,
    ComponentMenuConditionAndCallbackService,
    PageRestoreModalService,
    NodeInfoService
} from './services';

@SeEntryModule('cmssmarteditContainer')
@NgModule({
    imports: [
        CmsCommonsModule,
        BrowserModule,
        UpgradeModule,
        SharedComponentsModule,
        SeGenericEditorModule,
        MessageModule,
        TooltipModule,
        WorkflowModule,
        VersioningModule,
        SynchronizationModule,
        SeTranslationModule.forChild(),
        L10nPipeModule,
        NavigationModule,
        GenericEditorWidgetsModule,
        MediaModule,
        PageComponentsModule,
        TrashedPageListModule,
        RestrictionsModule,
        CmsComponentsModule,
        PageTreeModule,
        FormsModule,
        // Routes are "flat" because there are routes registered also in smarteditcontainer.ts
        // And they conflict each (overriding themselves)
        SeRouteService.provideNgRoute(
            [
                {
                    path: `${NG_ROUTE_PREFIX}${TRASHED_PAGE_LIST_PATH}`,
                    component: TrashedPageListComponent,
                    canActivate: [ExperienceGuard]
                },
                {
                    path: `${NG_ROUTE_PREFIX}${PAGE_LIST_PATH}`,
                    component: PageListComponent,
                    canActivate: [ExperienceGuard],
                    titleI18nKey: 'se.cms.pagelist.title',
                    priority: 20
                },
                {
                    path: `${NG_ROUTE_PREFIX}${NAVIGATION_MANAGEMENT_PAGE_PATH}`,
                    component: NavigationManagementPageComponent,
                    titleI18nKey: 'se.cms.toolbaritem.navigationmenu.name',
                    canActivate: [ExperienceGuard],
                    priority: 10
                }
            ],
            { useHash: true, initialNavigation: true, onSameUrlNavigation: 'reload' }
        )
    ],
    providers: [
        PageRestrictionsRestService,
        PageRestrictionsCriteriaService,
        ExperienceGuard,
        ActionableAlertService,
        PageRestrictionsCriteriaService,
        PageRestoredAlertService,
        PageRestoreModalService,
        HomepageService,
        ManagePageService,
        PageTypesRestrictionTypesRestService,
        PageTypesRestrictionTypesService,
        RestrictionTypesRestService,
        RestrictionTypesService,
        ProductCategoryService,
        CatalogVersionRestService,
        PagesRestService,
        PagesVariationsRestService,
        PagesFallbacksRestService,
        PageTypeService,
        StructuresRestService,
        StructureModeManagerFactory,
        TypeStructureRestService,
        RestrictionsService,
        PageRestrictionsService,
        GenericEditorModalService,
        RestrictionsStepHandlerFactory,
        PageFacade,
        PageDisplayConditionsService,
        PageTemplateService,
        DisplayConditionsFacade,
        CmsDragAndDropService,
        DisplayConditionsEditorModel,
        ContextAwareCatalogService,
        RulesAndPermissionsRegistrationService,
        AddPageWizardService,
        ClonePageAlertService,
        NodeInfoService,
        PageTreeComponentMenuService,
        {
            provide: HTTP_INTERCEPTORS,
            useClass: VersionExperienceInterceptor,
            multi: true
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: ResponseAdapterInterceptor,
            multi: true
        },
        {
            provide: IPageContentSlotsComponentsRestService,
            useClass: PageContentSlotsComponentsRestService
        },
        {
            provide: ISyncPollingService,
            useClass: SyncPollingService
        },
        {
            provide: IRemoveComponentService,
            useClass: RemoveComponentService
        },
        {
            provide: IPageService,
            useClass: PageService
        },
        {
            provide: IContextAwareEditableItemService,
            useClass: ContextAwareEditableItemService
        },
        {
            provide: IEditorModalService,
            useClass: EditorModalService
        },
        {
            provide: IComponentVisibilityAlertService,
            useClass: ComponentVisibilityAlertService
        },
        {
            provide: IComponentSharedService,
            useClass: ComponentSharedService
        },
        {
            provide: ISlotRestrictionsService,
            useClass: SlotRestrictionsService
        },
        {
            provide: ISlotVisibilityService,
            useClass: SlotVisibilityService
        },
        {
            provide: IEditorEnablerService,
            useClass: EditorEnablerService
        },
        {
            provide: IComponentMenuConditionAndCallbackService,
            useClass: ComponentMenuConditionAndCallbackService
        },
        moduleUtils.bootstrap(
            async (
                toolbarServiceFactory: IToolbarServiceFactory,
                rulesAndPermissionsRegistrationService: RulesAndPermissionsRegistrationService,
                cmsGenericEditorConfigurationService: CmsGenericEditorConfigurationService,
                featureService: IFeatureService,
                systemEventService: SystemEventService,
                clonePageWizardService: ClonePageWizardService,
                managePageVersionService: ManagePageVersionService,
                rollbackPageVersionService: RollbackPageVersionService,
                catalogDetailsService: ICatalogDetailsService,
                cmsDragAndDropService: CmsDragAndDropService,
                perspectiveService: IPerspectiveService,
                inViewElementObserver: InViewElementObserver,
                // Iframe does not work properly without it. Nothing happens when you click on "Edit" component button.
                editorModalService: IEditorModalService,
                // Need to inject for gatewayProxy initialization of componentVisibilityAlertService.
                componentVisibilityAlertService: IComponentVisibilityAlertService,
                nodeInfoService: NodeInfoService,
                crossFrameEventService: CrossFrameEventService,
                pageTreeService: IPageTreeService,
                settingsService: ISettingsService
            ) => {
                const smartEditTrashPageToolbarService = toolbarServiceFactory.getToolbarService(
                    'smartEditTrashPageToolbar'
                );
                smartEditTrashPageToolbarService.addItems([
                    {
                        key: 'se.cms.pages.list.link',
                        type: ToolbarItemType.TEMPLATE,
                        component: PagesLinkComponent,
                        priority: 1,
                        section: ToolbarSection.left
                    }
                ]);

                rulesAndPermissionsRegistrationService.register();

                cmsGenericEditorConfigurationService.setDefaultEditorFieldMappings();
                cmsGenericEditorConfigurationService.setDefaultTabFieldMappings();
                cmsGenericEditorConfigurationService.setDefaultTabsConfiguration();

                const pageTreeEnabled = await settingsService.get('smartedit.pagetree.enabled');
                if (pageTreeEnabled === 'true') {
                    featureService.addToolbarItem({
                        toolbarId: 'smartEditPerspectiveToolbar',
                        key: 'se.cms.pageTreeMenu',
                        nameI18nKey: 'se.cms.toolbaritem.pagetreemenu.name',
                        type: 'ACTION',
                        iconClassName: 'icon-tree se-toolbar-menu-ddlb--button__icon',
                        priority: 100,
                        section: 'left',
                        callback: () => {
                            crossFrameEventService.publish(EVENT_PAGE_TREE_PANEL_SWITCH);
                        },
                        permissions: ['se.read.page']
                    });

                    pageTreeService.registerTreeComponent({
                        component: PageTreePanel
                    });
                }

                featureService.addToolbarItem({
                    toolbarId: 'smartEditPerspectiveToolbar',
                    key: 'se.cms.componentMenuTemplate',
                    type: 'HYBRID_ACTION',
                    nameI18nKey: 'se.cms.componentmenu.btn.label.addcomponent',
                    descriptionI18nKey: 'cms.toolbaritem.componentmenutemplate.description',
                    priority: 101,
                    section: 'left',
                    dropdownPosition: 'left',
                    iconClassName: 'icon-add se-toolbar-menu-ddlb--button__icon',
                    callback: () => {
                        systemEventService.publish(OPEN_COMPONENT_EVENT, {});
                    },
                    component: ComponentMenuComponent,
                    permissions: ['se.add.component'],
                    keepAliveOnClose: true
                });

                featureService.addToolbarItem({
                    toolbarId: 'smartEditPerspectiveToolbar',
                    key: 'se.cms.pageInfoMenu',
                    type: 'TEMPLATE',
                    nameI18nKey: 'se.cms.pageinfo.menu.btn.label',
                    priority: 140,
                    section: 'left',
                    component: PageInfoMenuComponent,
                    permissions: ['se.read.page']
                });

                featureService.addToolbarItem({
                    toolbarId: 'smartEditPerspectiveToolbar',
                    key: 'se.cms.clonePageMenu',
                    type: 'ACTION',
                    nameI18nKey: 'se.cms.clonepage.menu.btn.label',
                    iconClassName: 'icon-duplicate se-toolbar-menu-ddlb--button__icon',
                    callback: () => {
                        clonePageWizardService.openClonePageWizard();
                    },
                    priority: 130,
                    section: 'left',
                    permissions: ['se.clone.page']
                });

                // sync 120
                featureService.addToolbarItem({
                    toolbarId: 'smartEditPerspectiveToolbar',
                    key: 'se.cms.pageSyncMenu',
                    nameI18nKey: 'se.cms.toolbaritem.pagesyncmenu.name',
                    type: 'TEMPLATE',
                    component: PageSyncMenuToolbarItemComponent,
                    priority: 102,
                    section: 'left',
                    permissions: ['se.sync.page']
                });

                featureService.addToolbarItem({
                    toolbarId: 'smartEditPerspectiveToolbar',
                    key: 'deletePageMenu',
                    nameI18nKey: 'se.cms.actionitem.page.trash',
                    type: 'TEMPLATE',
                    component: DeletePageToolbarItemComponent,
                    priority: 150,
                    section: 'left',
                    permissions: ['se.delete.page.menu']
                });

                // versions 102
                featureService.addToolbarItem({
                    toolbarId: 'smartEditPerspectiveToolbar',
                    key: 'se.cms.pageVersionsMenu',
                    type: 'HYBRID_ACTION',
                    nameI18nKey: 'se.cms.actionitem.page.versions',
                    priority: 104,
                    section: 'left',
                    iconClassName: 'icon-timesheet se-toolbar-menu-ddlb--button__icon',
                    component: PageVersionMenuComponent,
                    contextComponent: VersionItemContextComponent,
                    permissions: ['se.version.page'],
                    keepAliveOnClose: true
                });

                featureService.addToolbarItem({
                    toolbarId: 'smartEditPerspectiveToolbar',
                    key: 'se.cms.createVersionMenu',
                    type: 'ACTION',
                    nameI18nKey: 'se.cms.actionitem.page.versions.create',
                    iconClassName: 'icon-add se-toolbar-menu-ddlb--button__icon',
                    callback: () => {
                        managePageVersionService.createPageVersion();
                    },
                    priority: 120,
                    section: 'left',
                    permissions: ['se.version.page', 'se.create.version.page']
                });

                featureService.addToolbarItem({
                    toolbarId: 'smartEditPerspectiveToolbar',
                    key: 'se.cms.rollbackVersionMenu',
                    type: 'ACTION',
                    nameI18nKey: 'se.cms.actionitem.page.versions.rollback',
                    iconClassName: 'hyicon hyicon-rollback se-toolbar-menu-ddlb--button__icon',
                    callback: () => {
                        rollbackPageVersionService.rollbackPageVersion();
                    },
                    priority: 120,
                    section: 'left',
                    permissions: ['se.version.page', 'se.rollback.version.page']
                });

                featureService.addToolbarItem({
                    toolbarId: 'smartEditPerspectiveToolbar',
                    key: 'se.cms.pageWorkflowMenu',
                    type: 'TEMPLATE',
                    nameI18nKey: 'se.cms.workflow.toolbar.view.workflow.menu',
                    component: PageWorkflowMenuComponent,
                    priority: 110,
                    section: 'right'
                });

                featureService.addToolbarItem({
                    toolbarId: 'smartEditPerspectiveToolbar',
                    key: 'se.cms.pageDisplayStatus',
                    type: 'TEMPLATE',
                    nameI18nKey: 'se.cms.page.display.status',
                    component: PageDisplayStatusWrapperComponent,
                    priority: 120,
                    section: 'right',
                    permissions: ['se.show.page.status']
                });

                featureService.addToolbarItem({
                    toolbarId: 'smartEditPerspectiveToolbar',
                    key: 'se.cms.pageApprovalSelector',
                    type: 'TEMPLATE',
                    nameI18nKey: 'se.cms.page.approval.selector',
                    component: PageApprovalSelectorComponent,
                    priority: 165,
                    section: 'right',
                    permissions: ['se.force.page.approval']
                });

                const smartEditHeaderToolbarService = toolbarServiceFactory.getToolbarService(
                    'smartEditHeaderToolbar'
                );
                smartEditHeaderToolbarService.addItems([
                    {
                        key: 'se.cms.workflowInbox',
                        type: ToolbarItemType.TEMPLATE,
                        component: WorkflowInboxComponent,
                        priority: 5,
                        section: ToolbarSection.right,
                        dropdownPosition: ToolbarDropDownPosition.right
                    }
                ]);

                const smartEditNavigationToolbarService = toolbarServiceFactory.getToolbarService(
                    'smartEditNavigationToolbar'
                );
                smartEditNavigationToolbarService.addItems([
                    {
                        key: 'se.cms.shortcut',
                        type: ToolbarItemType.TEMPLATE,
                        component: ShortcutLinkComponent,
                        priority: 1,
                        section: ToolbarSection.left
                    }
                ]);

                const smartEditPagesToolbarService = toolbarServiceFactory.getToolbarService(
                    'smartEditPagesToolbar'
                );
                smartEditPagesToolbarService.addItems([
                    {
                        key: 'se.cms.shortcut',
                        type: ToolbarItemType.TEMPLATE,
                        component: ShortcutLinkComponent,
                        priority: 1,
                        section: ToolbarSection.left
                    },
                    {
                        key: 'se.cms.trash.page.link',
                        type: ToolbarItemType.TEMPLATE,
                        component: TrashLinkComponent,
                        priority: 1,
                        section: ToolbarSection.right
                    }
                ]);

                catalogDetailsService.addItems([
                    {
                        component: PageListLinkComponent
                    },
                    {
                        component: NavigationEditorLinkComponent
                    }
                ]);

                catalogDetailsService.addItems(
                    [
                        {
                            component: CatalogDetailsSyncComponent
                        }
                    ],
                    CATALOG_DETAILS_COLUMNS.RIGHT
                );

                featureService.register({
                    key: 'se.cms.html5DragAndDrop.outer',
                    nameI18nKey: 'se.cms.dragAndDrop.name',
                    descriptionI18nKey: 'se.cms.dragAndDrop.description',
                    enablingCallback: () => {
                        cmsDragAndDropService.register();
                        cmsDragAndDropService.apply();
                    },
                    disablingCallback: () => {
                        cmsDragAndDropService.unregister();
                    }
                });

                perspectiveService.register({
                    key: CMSModesService.BASIC_PERSPECTIVE_KEY,
                    nameI18nKey: 'se.cms.perspective.basic.name',
                    descriptionI18nKey: 'se.hotkey.tooltip',
                    features: [
                        'se.contextualMenu',
                        'se.cms.dragandropbutton',
                        'se.cms.remove',
                        'se.cms.edit',
                        'se.cms.componentMenuTemplate',
                        'se.cms.clonePageMenu',
                        'se.cms.pageInfoMenu',
                        'se.emptySlotFix',
                        'se.cms.html5DragAndDrop',
                        'disableSharedSlotEditing',
                        'sharedSlotDisabledDecorator',
                        'se.cms.html5DragAndDrop.outer',
                        'externalComponentDecorator',
                        'externalcomponentbutton',
                        'externalSlotDisabledDecorator',
                        'clonecomponentbutton',
                        'deletePageMenu',
                        'se.cms.pageWorkflowMenu',
                        'se.cms.pageDisplayStatus',
                        'se.cms.pageApprovalSelector',
                        'se.cms.sharedcomponentbutton'
                    ],
                    perspectives: []
                });

                /* Note: For advance edit mode, the ordering of the entries in the features list will determine the order the buttons will show in the slot contextual menu */
                /* externalSlotDisabledDecorator will be removed after 2105 release */
                perspectiveService.register({
                    key: CMSModesService.ADVANCED_PERSPECTIVE_KEY,
                    nameI18nKey: 'se.cms.perspective.advanced.name',
                    descriptionI18nKey: 'se.hotkey.tooltip',
                    features: [
                        'se.slotContextualMenu',
                        'se.slotSyncButton',
                        'se.slotSharedButton',
                        'se.slotContextualMenuVisibility',
                        'se.contextualMenu',
                        'se.cms.dragandropbutton',
                        'se.cms.remove',
                        'se.cms.edit',
                        'se.cms.componentMenuTemplate',
                        'se.cms.clonePageMenu',
                        'se.cms.pageInfoMenu',
                        'se.cms.pageSyncMenu',
                        'se.emptySlotFix',
                        'se.cms.html5DragAndDrop',
                        'se.cms.html5DragAndDrop.outer',
                        'syncIndicator',
                        'externalComponentDecorator',
                        'externalcomponentbutton',
                        'clonecomponentbutton',
                        'slotUnsharedButton',
                        'deletePageMenu',
                        'se.cms.pageVersionsMenu',
                        'se.cms.pageWorkflowMenu',
                        'se.cms.pageDisplayStatus',
                        'se.cms.pageApprovalSelector',
                        'se.cms.sharedcomponentbutton',
                        'se.cms.pageTreeMenu',
                        'se.cms.openInPageTreeButton'
                    ],
                    perspectives: []
                });

                perspectiveService.register({
                    key: CMSModesService.VERSIONING_PERSPECTIVE_KEY,
                    nameI18nKey: 'se.cms.perspective.versioning.name',
                    descriptionI18nKey: 'se.cms.perspective.versioning.description',
                    features: [
                        'se.cms.pageVersionsMenu',
                        'se.cms.createVersionMenu',
                        'se.cms.rollbackVersionMenu',
                        'se.cms.pageInfoMenu',
                        'disableSharedSlotEditing',
                        'sharedSlotDisabledDecorator',
                        'externalSlotDisabledDecorator',
                        'externalComponentDecorator'
                    ],
                    perspectives: [],
                    permissions: ['se.version.page'],
                    isHotkeyDisabled: true
                });

                inViewElementObserver.addSelector(`.${COMPONENT_CLASS}`, () => {
                    cmsDragAndDropService.update();
                });
            },
            [
                IToolbarServiceFactory,
                RulesAndPermissionsRegistrationService,
                CmsGenericEditorConfigurationService,
                IFeatureService,
                SystemEventService,
                ClonePageWizardService,
                ManagePageVersionService,
                RollbackPageVersionService,
                ICatalogDetailsService,
                CmsDragAndDropService,
                IPerspectiveService,
                InViewElementObserver,
                IEditorModalService,
                IComponentVisibilityAlertService,
                NodeInfoService,
                CrossFrameEventService,
                IPageTreeService,
                ISettingsService
            ]
        )
    ],
    declarations: [
        GenericEditorModalComponent,
        PageRestoredAlertComponent,
        ClonePageAlertComponent
    ],
    entryComponents: [
        GenericEditorModalComponent,
        PageRestoredAlertComponent,
        ClonePageAlertComponent
    ]
})
export class CmssmarteditContainerModule {}
