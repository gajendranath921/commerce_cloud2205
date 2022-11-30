/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { ChangeDetectorRef } from '@angular/core';
import {
    VersionItemMenuComponent,
    RollbackPageVersionService,
    ManagePageVersionService
} from 'cmssmarteditcontainer/components/versioning';
import {
    IPermissionService,
    PageVersionSelectionService,
    UserTrackingService
} from 'smarteditcommons';

describe('VersionItemMenuComponent', () => {
    let managePageVersionService: jasmine.SpyObj<ManagePageVersionService>;
    let pageVersionSelectionService: jasmine.SpyObj<PageVersionSelectionService>;
    let rollbackPageVersionService: jasmine.SpyObj<RollbackPageVersionService>;
    let permissionService: jasmine.SpyObj<IPermissionService>;
    let userTrackingService: jasmine.SpyObj<UserTrackingService>;

    const cdr = jasmine.createSpyObj<ChangeDetectorRef>('changeDetectorRef', ['detectChanges']);

    let component: VersionItemMenuComponent;
    beforeEach(() => {
        managePageVersionService = jasmine.createSpyObj<ManagePageVersionService>(
            'managePageVersionService',
            ['deletePageVersion', 'editPageVersion']
        );
        pageVersionSelectionService = jasmine.createSpyObj<PageVersionSelectionService>(
            'pageVersionSelectionService',
            ['selectPageVersion']
        );
        rollbackPageVersionService = jasmine.createSpyObj<RollbackPageVersionService>(
            'rollbackPageVersionService',
            ['rollbackPageVersion']
        );
        permissionService = jasmine.createSpyObj<IPermissionService>('permissionService', [
            'isPermitted'
        ]);

        userTrackingService = jasmine.createSpyObj<UserTrackingService>('userTrackingService', [
            'trackingUserAction'
        ]);

        component = new VersionItemMenuComponent(
            managePageVersionService,
            pageVersionSelectionService,
            rollbackPageVersionService,
            permissionService,
            cdr,
            userTrackingService
        );
    });

    it('WHEN component is initialized THEN it sets menu items properly', async () => {
        permissionService.isPermitted.and.returnValues(
            true as any,
            true as any,
            true as any,
            false as any
        );

        await component.ngOnInit();

        expect(component.menuItems.length).toBe(3);
    });

    it('toggles menu properly', () => {
        const mockClickEvent = new MouseEvent('click');
        const stopPropagationSpy = spyOn(mockClickEvent, 'stopPropagation');
        component.isMenuOpen = false;

        component.onButtonClick(mockClickEvent);
        expect(stopPropagationSpy).toHaveBeenCalled();
        expect(component.isMenuOpen).toBe(true);

        component.onButtonClick(mockClickEvent);
        expect(component.isMenuOpen).toBe(false);
    });

    it(`executes given item's callback AND closes the menu AND track user action`, () => {
        const mockMenuItem = {
            callback: jasmine.createSpy('callback'),
            i18nKey: undefined,
            permissions: undefined
        };

        component.executeItemCallback(mockMenuItem);

        expect(mockMenuItem.callback).toHaveBeenCalled();
        expect(component.isMenuOpen).toBe(false);
        expect(userTrackingService.trackingUserAction).toHaveBeenCalled();
    });
});
