/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { ChangeDetectorRef } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { SlotUnsharedButtonComponent } from 'cmssmartedit/components';
import { SlotUnsharedService } from 'cmssmartedit/services/SlotUnsharedService';
import {
    CrossFrameEventService,
    ICatalogService,
    IConfirmationModalService,
    ISharedDataService,
    LogService,
    ContextualMenuItemData,
    ComponentHandlerService,
    SlotSharedService,
    IPageInfoService
} from 'smarteditcommons';

describe('SlotUnsharedButtonComponent', () => {
    let contextualMenuItem: ContextualMenuItemData;
    let catalogService: jasmine.SpyObj<ICatalogService>;
    let confirmationModalService: jasmine.SpyObj<IConfirmationModalService>;
    let componentHandlerService: jasmine.SpyObj<ComponentHandlerService>;
    let crossFrameEventService: jasmine.SpyObj<CrossFrameEventService>;
    let slotUnsharedService: jasmine.SpyObj<SlotUnsharedService>;
    let sharedDataService: jasmine.SpyObj<ISharedDataService>;
    let slotSharedService: jasmine.SpyObj<SlotSharedService>;
    let translateService: jasmine.SpyObj<TranslateService>;
    let logService: jasmine.SpyObj<LogService>;
    let pageInfoService: jasmine.SpyObj<IPageInfoService>;
    const cdr = jasmine.createSpyObj<ChangeDetectorRef>('changeDetectorRef', ['detectChanges']);

    let component: SlotUnsharedButtonComponent;
    let componentAny: any;
    beforeEach(() => {
        contextualMenuItem = {
            componentAttributes: {
                smarteditComponentId: 'ApparelUKHomepageFreeDelBannerComponent',
                smarteditCatalogVersionUuid: null,
                smarteditComponentType: null,
                smarteditComponentUuid: null,
                smarteditElementUuid: null
            },
            setRemainOpen: jasmine.createSpy('setRemainOpen')
        };

        catalogService = jasmine.createSpyObj<ICatalogService>('catalogService', [
            'isCurrentCatalogMultiCountry'
        ]);

        confirmationModalService = jasmine.createSpyObj<IConfirmationModalService>(
            'confirmationModalService',
            ['confirm']
        );

        componentHandlerService = jasmine.createSpyObj<ComponentHandlerService>(
            'componentHandlerService',
            ['isExternalComponent']
        );

        crossFrameEventService = jasmine.createSpyObj<CrossFrameEventService>(
            'crossFrameEventService',
            ['subscribe']
        );

        slotUnsharedService = jasmine.createSpyObj<SlotUnsharedService>('slotUnsharedService', [
            'isSlotShared',
            'isSlotUnshared',
            'revertToSharedSlot'
        ]);

        sharedDataService = jasmine.createSpyObj<ISharedDataService>('sharedDataService', ['get']);

        translateService = jasmine.createSpyObj<TranslateService>('translateService', ['instant']);

        logService = jasmine.createSpyObj<LogService>('logService', ['log']);

        pageInfoService = jasmine.createSpyObj<IPageInfoService>('pageInfoService', [
            'isSameCatalogVersionOfPageAndPageTemplate'
        ]);

        component = new SlotUnsharedButtonComponent(
            contextualMenuItem,
            catalogService,
            confirmationModalService,
            componentHandlerService,
            crossFrameEventService,
            slotUnsharedService,
            sharedDataService,
            slotSharedService,
            translateService,
            pageInfoService,
            logService,
            cdr
        );
        componentAny = component;
        componentAny.reload = jasmine.createSpy('reload');
    });

    it('isPopupOpened is initialized to false', () => {
        expect(component.isPopupOpened).toEqual(false);
    });

    it(`GIVEN catalog is multi country
         AND IS NOT external component
         AND current page is not from parent
         AND is not same catalog version of page and page template
         AND slot is shared
         THEN it is a local slot`, async () => {
        catalogService.isCurrentCatalogMultiCountry.and.returnValue(Promise.resolve(true));
        componentHandlerService.isExternalComponent.and.returnValue(false);
        sharedDataService.get.and.returnValue(
            Promise.resolve({
                pageContext: {
                    catalogVersionUuid: 'apparel-ukContentCatalog/Staged'
                },
                catalogDescriptor: {
                    catalogVersionUuid: 'apparel-ukContentCatalog/Staged'
                }
            })
        );
        slotUnsharedService.isSlotShared.and.returnValue(Promise.resolve(true));

        pageInfoService.isSameCatalogVersionOfPageAndPageTemplate.and.returnValue(
            Promise.resolve(false)
        );

        await component.ngOnInit();

        expect(component.isLocalSlot).toBe(true);
    });

    it(`GIVEN catalog is multi country
         AND IS NOT external component
         AND current page is not from parent
         AND is same catalog version of page and page template
         AND slot is shared
         THEN it is not a local slot`, async () => {
        catalogService.isCurrentCatalogMultiCountry.and.returnValue(Promise.resolve(true));
        componentHandlerService.isExternalComponent.and.returnValue(false);
        sharedDataService.get.and.returnValue(
            Promise.resolve({
                pageContext: {
                    catalogVersionUuid: 'apparel-ukContentCatalog/Staged'
                },
                catalogDescriptor: {
                    catalogVersionUuid: 'apparel-ukContentCatalog/Staged'
                }
            })
        );
        slotUnsharedService.isSlotShared.and.returnValue(Promise.resolve(true));

        pageInfoService.isSameCatalogVersionOfPageAndPageTemplate.and.returnValue(
            Promise.resolve(true)
        );

        await component.ngOnInit();

        expect(component.isLocalSlot).toBe(false);
    });

    it(`GIVEN non external compnent
            AND slot is not shared
            AND slot is unshared       
            THEN it is a non-shared slot
         `, async () => {
        componentHandlerService.isExternalComponent.and.returnValue(false);
        slotUnsharedService.isSlotShared.and.returnValue(Promise.resolve(false));
        slotUnsharedService.isSlotUnshared.and.returnValue(Promise.resolve(true));

        await component.ngOnInit();
        expect(component.isNonSharedSlot).toBe(true);
    });

    it(`GIVEN slot is local slot THEN it sets header properly`, () => {
        component.isLocalSlot = true;
        expect(component.getHeader()).toBe('se.localslot.decorator.label');
    });

    it(`GIVEN slot is not local slot THEN it sets header properly`, () => {
        component.isLocalSlot = false;
        expect(component.getHeader()).toBe('se.nonshared.decorator.label');
    });

    describe('removeSlot', () => {
        it('GIVEN modal has been confirmed THEN it remove the slot properly', async () => {
            confirmationModalService.confirm.and.returnValue(Promise.resolve(true));
            slotUnsharedService.revertToSharedSlot.and.returnValue(Promise.resolve<any>(true));

            await component.removeSlot();

            expect(component.isPopupOpened).toBe(false);
            expect(componentAny.reload).toHaveBeenCalled();
        });

        it('GIVEN modal has been cancelled THEN it does not remove the slot', async () => {
            confirmationModalService.confirm.and.returnValue(Promise.resolve(false));

            await component.removeSlot();

            expect(slotUnsharedService.revertToSharedSlot).not.toHaveBeenCalled();
        });
    });

    describe('isPopupOpened', () => {
        it('GIVEN isPopupOpened is set to false WHEN ngDoCheck lifecycle call THEN it sets isPopupOpenedPreviousValue to false', () => {
            // GIVEN
            componentAny.isPopupOpenedPreviousValue = true;
            component.isPopupOpened = false;

            // WHEN
            component.ngDoCheck();

            // THEN
            expect(componentAny.isPopupOpenedPreviousValue).toEqual(false);
        });

        it('GIVEN isPopupOpened is set to false AND isPopupOpenedPreviousValue is set to true WHEN ngDoCheck lifecycle call THEN it sets isPopupOpenedPreviousValue to false', () => {
            // GIVEN
            componentAny.isPopupOpenedPreviousValue = true;
            component.isPopupOpened = false;

            // WHEN
            component.ngDoCheck();

            // THEN
            expect(componentAny.isPopupOpenedPreviousValue).toEqual(false);
        });

        it('GIVEN isPopupOpenedPreviousValue and isPopupOpened are both true WHEN ngDoCheck is called THEN isPopupOpenedPreviousValue will not change', () => {
            // GIVEN
            componentAny.isPopupOpenedPreviousValue = true;
            component.isPopupOpened = true;

            // WHEN
            component.ngDoCheck();

            // THEN
            expect(componentAny.isPopupOpenedPreviousValue).toEqual(true);
        });

        it('GIVEN isPopupOpenedPreviousValue and isPopupOpened are both false WHEN ngDoCheck is called THEN isPopupOpenedPreviousValue will not change', () => {
            // GIVEN
            componentAny.isPopupOpenedPreviousValue = false;
            component.isPopupOpened = false;

            // WHEN
            component.ngDoCheck();

            // THEN
            expect(componentAny.isPopupOpenedPreviousValue).toEqual(false);
        });
    });
});
