import { PersonalizationsmarteditContextService } from 'personalizationsmarteditcontainer/service/PersonalizationsmarteditContextServiceOuter';
import {
    GatewayProxied,
    SeDowngradeService,
    IPageInfoService,
    WorkflowService
} from 'smarteditcommons';

@GatewayProxied('applySynchronization', 'isCurrentPageActiveWorkflowRunning')
@SeDowngradeService()
export class PersonalizationsmarteditContextServiceReverseProxy {
    public static readonly WORKFLOW_RUNNING_STATUS = 'RUNNING';

    constructor(
        protected personalizationsmarteditContextService: PersonalizationsmarteditContextService,
        protected workflowService: WorkflowService,
        protected pageInfoService: IPageInfoService
    ) {}

    public applySynchronization(): void {
        this.personalizationsmarteditContextService.applySynchronization();
    }

    public isCurrentPageActiveWorkflowRunning(): Promise<boolean> {
        return this.pageInfoService.getPageUUID().then((pageUuid: string) =>
            this.workflowService.getActiveWorkflowForPageUuid(pageUuid).then((workflow: any) => {
                if (workflow == null) {
                    return false;
                }
                return (
                    workflow.status ===
                    PersonalizationsmarteditContextServiceReverseProxy.WORKFLOW_RUNNING_STATUS
                );
            })
        );
    }
}
