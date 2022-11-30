/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { PageListLinkComponent } from 'cmssmarteditcontainer/components/pages/pageListLink/PageListLinkComponent';
import { CatalogDetailsItemData, UserTrackingService } from 'smarteditcommons';

describe('PageListLinkComponent', () => {
    let component: PageListLinkComponent;
    let userTrackingService: jasmine.SpyObj<UserTrackingService>;

    const mockCatalogDetails = {
        catalog: { catalogId: 'catalogId' },
        catalogVersion: { version: 'Online' },
        siteId: 'siteId'
    } as CatalogDetailsItemData;

    beforeEach(() => {
        userTrackingService = jasmine.createSpyObj<UserTrackingService>('userTrackingService', [
            'trackingUserAction'
        ]);

        component = new PageListLinkComponent(mockCatalogDetails, userTrackingService);
    });

    it('should return proper link to pages', () => {
        const actual = component.getLink();

        expect(actual).toEqual('#!/ng/pages/siteId/catalogId/Online');
    });

    it('should track user action when click this link', () => {
        component.onClick();

        expect(userTrackingService.trackingUserAction).toHaveBeenCalled();
    });
});
