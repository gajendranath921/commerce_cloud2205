import { ManagerViewComponent } from 'personalizationsmarteditcontainer/management/managerView';
import { IModalService, SeDowngradeService } from 'smarteditcommons';

@SeDowngradeService()
export class ManagerViewService {
    constructor(private modalService: IModalService) {}

    public openManagerAction(): void {
        this.modalService.open({
            templateConfig: {
                title: 'personalization.modal.manager.title',
                isDismissButtonVisible: true
            },
            config: {
                height: window.innerHeight + 'px',
                width: window.innerWidth + 'px',
                modalPanelClass: 'perso-library'
            },
            component: ManagerViewComponent
        });
    }
}
