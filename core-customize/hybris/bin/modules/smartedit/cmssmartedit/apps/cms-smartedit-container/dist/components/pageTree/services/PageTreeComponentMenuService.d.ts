import { IEditorEnablerService, IComponentMenuConditionAndCallbackService } from 'cmscommons';
import { IContextualMenuButton, IContextualMenuConfiguration, PriorityService } from 'smarteditcommons';
export declare class PageTreeComponentMenuService {
    private readonly priorityService;
    private readonly editorEnablerService;
    private readonly componentMenuConditionAndCallbackService;
    private readonly menus;
    constructor(priorityService: PriorityService, editorEnablerService: IEditorEnablerService, componentMenuConditionAndCallbackService: IComponentMenuConditionAndCallbackService);
    getPageTreeComponentMenus(configuration: IContextualMenuConfiguration): Promise<IContextualMenuButton[]>;
}
