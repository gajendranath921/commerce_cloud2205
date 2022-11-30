/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import '../../node_modules/zone.js/dist/zone-testing';
import '../../node_modules/zone.js/dist/zone.js'; // 1st
import '../../node_modules/zone.js/dist/async-test'; // 2nd
import '../../node_modules/zone.js/dist/fake-async-test'; // 3rd
import '../../node_modules/zone.js/dist/long-stack-trace-zone'; // 4th
import '../../node_modules/zone.js/dist/sync-test'; // 5th
import '../../node_modules/zone.js/dist/proxy.js'; // 6th
import { CUSTOM_ELEMENTS_SCHEMA, VERSION } from '@angular/core';
import { ComponentFixture, fakeAsync, TestBed, tick } from '@angular/core/testing';
import {
    BrowserDynamicTestingModule,
    platformBrowserDynamicTesting
} from '@angular/platform-browser-dynamic/testing';
import { TranslateModule, TranslateService } from '@ngx-translate/core';
import { SettingsService, UserTrackingService } from 'smarteditcommons';
import { QualtricsComponent } from 'smarteditcontainer/components';

describe('QualtricsComponent', () => {
    let component: QualtricsComponent;
    let fixture: ComponentFixture<QualtricsComponent>;
    let translateService: TranslateService;
    let settingsServiceStub: jasmine.SpyObj<SettingsService>;
    let userTrackingServiceStub: jasmine.SpyObj<UserTrackingService>;
    const INTERCEPT_URL = 'https://dev';

    beforeEach(() => {
        TestBed.resetTestEnvironment();
        TestBed.initTestEnvironment(BrowserDynamicTestingModule, platformBrowserDynamicTesting());
        settingsServiceStub = jasmine.createSpyObj<SettingsService>('settingsService', ['load']);
        userTrackingServiceStub = jasmine.createSpyObj<UserTrackingService>('userTrackingService', [
            'trackingUserAction'
        ]);

        TestBed.configureTestingModule({
            declarations: [QualtricsComponent],
            providers: [
                { provide: UserTrackingService, useValue: userTrackingServiceStub },
                { provide: TranslateService, useClass: TranslateService },
                { provide: SettingsService, useValue: settingsServiceStub }
            ],
            schemas: [CUSTOM_ELEMENTS_SCHEMA],
            imports: [TranslateModule.forRoot()]
        });
        fixture = TestBed.createComponent(QualtricsComponent);
        component = fixture.componentInstance;
        translateService = fixture.debugElement.injector.get(TranslateService);
    });

    it('Should create Qualtrics component correctly', () => {
        expect(component).toBeDefined();
    });

    it('Product: The contextParamsString and interceptUrl property are set successfully', fakeAsync(() => {
        settingsServiceStub.load.and.returnValue(
            Promise.resolve({
                'modelt.customer.code': 'cg79x9wuu9',
                'modelt.project.code': 'eccommerc1',
                'modelt.environment.code': 'p1',
                'modelt.environment.type': 'development',
                'build.version.api': 'testApi',
                'smartedit.qualtrics.interceptUrl': INTERCEPT_URL
            })
        );
        component.ngOnInit();
        tick();
        fixture.detectChanges();
        const qualtricControl = fixture.nativeElement.querySelector('cx-qtx-survey-button');
        expect(qualtricControl.contextParams).toEqualData({
            appFrameworkId: 4,
            appFrameworkVersion: VERSION.full,
            appId: 'SmartEdit',
            appSupportInfo: 'CEC-COM-ADM-SEDIT',
            appTitle: 'SmartEdit',
            pushSrcType: 2,
            tenantId: 'cg79x9wuu9-eccommerc1-p1',
            tenantRole: 'development',
            appVersion: 'testApi'
        });

        expect(qualtricControl.interceptUrl).toEqual(INTERCEPT_URL);
    }));

    it('When the language changed, the contextParamsString could be set correctly', fakeAsync(() => {
        settingsServiceStub.load.and.returnValue(
            Promise.resolve({
                'modelt.customer.code': 'cg79x9wuu9',
                'modelt.project.code': 'eccommerc1',
                'modelt.environment.code': 'p1',
                'modelt.environment.type': 'production',
                'build.version.api': 'testApi',
                'smartedit.qualtrics.interceptUrl': INTERCEPT_URL
            })
        );
        component.ngOnInit();
        tick();
        translateService.use('zh');
        tick();
        fixture.detectChanges();
        const qualtricControl = fixture.nativeElement.querySelector('cx-qtx-survey-button');
        expect(qualtricControl.contextParams.language).toEqual('zh');
        expect(qualtricControl.interceptUrl).toEqual(INTERCEPT_URL);
    }));

    it('When click button, track user action', () => {
        component.onClick();

        expect(userTrackingServiceStub.trackingUserAction).toHaveBeenCalled();
    });
});
