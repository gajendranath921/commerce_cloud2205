import { Dictionary } from 'lodash';
import { PersonalizationsmarteditCustomizeViewHelper } from 'personalizationsmartedit/service/PersonalizationsmarteditCustomizeViewHelper';
import { GatewayProxied, SeDowngradeService } from 'smarteditcommons';
@SeDowngradeService()
@GatewayProxied('getSourceContainersInfo')
export class CustomizeViewServiceProxy {
    constructor(
        protected personalizationsmarteditCustomizeViewHelper: PersonalizationsmarteditCustomizeViewHelper
    ) {}

    public getSourceContainersInfo(): Dictionary<number> {
        return this.personalizationsmarteditCustomizeViewHelper.getSourceContainersInfo();
    }
}
