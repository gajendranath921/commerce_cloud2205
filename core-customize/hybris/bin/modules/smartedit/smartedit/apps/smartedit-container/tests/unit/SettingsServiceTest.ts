/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { IRestService, RestServiceFactory, TypedMap, SettingsService } from 'smarteditcommons';

describe('settingsService', () => {
    // Service under test
    let settingsService: SettingsService;

    // Create Mocks
    const mockRestServiceFactory: jasmine.SpyObj<RestServiceFactory> = jasmine.createSpyObj<
        RestServiceFactory
    >('mockRestServiceFactory', ['get']);
    const mockRestService: jasmine.SpyObj<IRestService<
        TypedMap<string | boolean | string[]>
    >> = jasmine.createSpyObj<IRestService<TypedMap<string | boolean | string[]>>>(
        'mockRestService',
        ['get']
    );

    beforeEach(() => {
        mockRestServiceFactory.get.and.returnValue(mockRestService);
        settingsService = new SettingsService(mockRestServiceFactory);
    });

    it('returns the string returned by the restService when called with it get() function', async () => {
        // Given
        const restServiceResponsePromise = Promise.resolve({ key: 'value' });
        mockRestService.get.and.returnValue(restServiceResponsePromise);

        // When
        const result = await settingsService.get('key');

        // Then
        expect(result).toEqual('value');
    });

    it('returns true from its getBoolean() function when RestService returns a true string', async () => {
        // Given
        const restServiceResponsePromise = Promise.resolve({ key: 'true' });
        mockRestService.get.and.returnValue(restServiceResponsePromise);

        // When
        const result = await settingsService.getBoolean('key');

        // Then
        expect(result).toEqual(true);
    });

    it('returns true from its getBoolean() function when RestService returns a true boolean', async () => {
        // Given
        const restServiceResponsePromise = Promise.resolve({ key: true });
        mockRestService.get.and.returnValue(restServiceResponsePromise);

        // When
        const result = await settingsService.getBoolean('key');

        // Then
        expect(result).toEqual(true);
    });

    it('returns false from its getBoolean() function when RestService returns a false string', async () => {
        // Given
        const restServiceResponsePromise = Promise.resolve({ key: 'false' });
        mockRestService.get.and.returnValue(restServiceResponsePromise);

        // When
        const result = await settingsService.getBoolean('key');

        // Then
        expect(result).toEqual(false);
    });

    it('returns false from its getBoolean() function when RestService returns a false boolean', async () => {
        // Given
        const restServiceResponsePromise = Promise.resolve({ key: false });
        mockRestService.get.and.returnValue(restServiceResponsePromise);

        // When
        const result = await settingsService.getBoolean('key');

        // Then
        expect(result).toEqual(false);
    });

    it('returns false from its getBoolean() function when RestService returns a string which is different than true', async () => {
        // Given
        const restServiceResponsePromise = Promise.resolve({ key: 'someString' });
        mockRestService.get.and.returnValue(restServiceResponsePromise);

        // When
        const result = await settingsService.getBoolean('key');

        // Then
        expect(result).toEqual(false);
    });

    it('returns the string list returned by the restService', async () => {
        // Given
        const restServiceResponsePromise = Promise.resolve({ key: ['string1', 'string2'] });
        mockRestService.get.and.returnValue(restServiceResponsePromise);

        // When
        const result = await settingsService.getStringList('key');

        // Then
        expect(result).toEqual(['string1', 'string2']);
    });
});
