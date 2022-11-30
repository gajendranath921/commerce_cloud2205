import { OnDestroy, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { SettingsService, UserTrackingService } from 'smarteditcommons';
import './cx-qtx-survey-button.bundle.js';
export declare class QualtricsComponent implements OnInit, OnDestroy {
    private translateService;
    private settingService;
    private userTrackingService;
    interceptUrl: string;
    contextParamsString: string;
    private contextParams;
    constructor(translateService: TranslateService, settingService: SettingsService, userTrackingService: UserTrackingService);
    ngOnDestroy(): void;
    ngOnInit(): void;
    onClick(): void;
    private _getFixedContextParams;
}
