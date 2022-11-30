/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { SeDowngradeService, IAlertService } from 'smarteditcommons';

@SeDowngradeService()
export class PersonalizationsmarteditMessageHandler {
    constructor(private alertService: IAlertService) {}

    public sendInformation(informationMessage: any): any {
        this.alertService.showInfo(informationMessage);
    }

    public sendError(errorMessage: any): any {
        this.alertService.showDanger(errorMessage);
    }

    public sendWarning(warningMessage: any): any {
        this.alertService.showWarning(warningMessage);
    }

    public sendSuccess(successMessage: any): any {
        this.alertService.showSuccess(successMessage);
    }
}
