import { SeDowngradeService, PageVersionSelectionService, IPageVersion } from 'smarteditcommons';
import { PersonalizationsmarteditRestService } from './PersonalizationsmarteditRestService';

@SeDowngradeService()
export class PersonalizationsmarteditVersionCheckerService {
    private version: IPageVersion;
    constructor(
        protected restService: PersonalizationsmarteditRestService,
        protected pageVersionSelectionService: PageVersionSelectionService
    ) {}

    public setVersion(version: IPageVersion): void {
        this.version = version;
    }

    public provideTranlationKey(key: string): Promise<string> {
        const TRANSLATE_NS = 'personalization.se.cms.actionitem.page.version.rollback.confirmation';

        this.version = this.version || this.pageVersionSelectionService.getSelectedPageVersion();

        if (!!this.version) {
            return this.restService.checkVersionConflict(this.version.uid).then(
                (response: any) => (response.result ? key : TRANSLATE_NS),
                () => key
            );
        } else {
            return Promise.resolve(key);
        }
    }
}
