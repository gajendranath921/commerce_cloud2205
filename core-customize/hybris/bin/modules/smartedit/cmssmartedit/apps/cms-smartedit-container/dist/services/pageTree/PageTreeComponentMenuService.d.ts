import { IEditorEnablerService, IComponentMenuConditionAndCallbackService } from 'cmscommons';
import { IContextualMenuButton, IContextualMenuConfiguration, IPermissionService } from 'smarteditcommons';
export declare class PageTreeComponentMenuService {
    private readonly editorEnablerService;
    private readonly componentMenuConditionAndCallbackService;
    private readonly permissionService;
    private readonly originalMenus;
    constructor(editorEnablerService: IEditorEnablerService, componentMenuConditionAndCallbackService: IComponentMenuConditionAndCallbackService, permissionService: IPermissionService);
    getPageTreeComponentMenus(configuration: IContextualMenuConfiguration): Promise<IContextualMenuButton[]>;
    private buildMenusByPermission;
}
