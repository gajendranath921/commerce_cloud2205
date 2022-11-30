import { GatewayProxied, SeDowngradeService } from 'smarteditcommons';

@SeDowngradeService()
@GatewayProxied('applySynchronization', 'isCurrentPageActiveWorkflowRunning')
export class PersonalizationsmarteditContextServiceReverseProxy {
    public applySynchronization(): void {
        'proxyFunction';
        return undefined;
    }

    public isCurrentPageActiveWorkflowRunning(): Promise<boolean> {
        'proxyFunction';
        return undefined;
    }
}
