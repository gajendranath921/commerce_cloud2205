/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { ChangeDetectorRef } from '@angular/core';
import { MediaComponent } from 'cmssmarteditcontainer/components/genericEditor';
import {
    MediaService,
    MediaUtilService
} from 'cmssmarteditcontainer/components/genericEditor/media/services';
import {
    FileValidationService,
    GenericEditorWidgetData,
    ISharedDataService,
    LogService,
    TypedMap
} from 'smarteditcommons';

describe('MediaComponent', () => {
    let fileValidationService: jasmine.SpyObj<FileValidationService>;
    let logService: jasmine.SpyObj<LogService>;
    let widgetData: GenericEditorWidgetData<TypedMap<string>>;
    let mediaUtilService: jasmine.SpyObj<MediaUtilService>;
    let mediaService: jasmine.SpyObj<MediaService>;
    let sharedDataService: jasmine.SpyObj<ISharedDataService>;
    const cdr = jasmine.createSpyObj<ChangeDetectorRef>('changeDetectorRef', ['detectChanges']);

    let component: MediaComponent;
    beforeEach(() => {
        fileValidationService = jasmine.createSpyObj<FileValidationService>(
            'fileValidationService',
            ['validate']
        );

        logService = jasmine.createSpyObj<LogService>('logService', ['warn']);
        mediaUtilService = jasmine.createSpyObj<MediaUtilService>('mediaUtilService', [
            'getAcceptedFileTypes'
        ]);

        mediaService = jasmine.createSpyObj<MediaService>('mediaService', ['getMedia']);

        sharedDataService = jasmine.createSpyObj<ISharedDataService>('sharedDataService', ['get']);

        widgetData = {
            model: {
                en: undefined
            },
            qualifier: 'en',
            field: {
                initiated: ['1', '2']
            },
            isFieldDisabled: () => false
        } as any;

        component = new MediaComponent(
            cdr,
            fileValidationService,
            logService,
            mediaUtilService,
            mediaService,
            sharedDataService,
            widgetData
        );
    });

    describe('onFileSelect', () => {
        it('GIVEN selected file is valid THEN it sets the image properly', async () => {
            const files = ([
                {
                    name: 'someName'
                }
            ] as unknown) as FileList;
            fileValidationService.validate.and.returnValue(Promise.resolve());

            await component.onFileSelect(files);

            expect(component.fileErrors).toEqual([]);
            expect(component.image).toBe(files[0]);
        });

        it('GIVEN selected file is not valid THEN it resets the image AND logs the message about failure', async () => {
            const files = ([
                {
                    name: 'someName'
                }
            ] as unknown) as FileList;
            fileValidationService.validate.and.returnValue(Promise.reject());

            await component.onFileSelect(files);

            expect(logService.warn).toHaveBeenCalled();
            expect(component.image).toBeNull();
        });
    });

    describe('onMediaUploaded', () => {
        it('sets given id as media id by the language', () => {
            const id = '123';
            component.onMediaUploaded(id);

            expect(widgetData.model.en).toBe(id);
        });

        it('GIVEN Generic Editor Field initiated array exists THEN it clears the array', async () => {
            const id = '123';
            await component.onMediaUploaded(id);

            expect(widgetData.field.initiated.length).toBe(0);
        });
    });

    describe('canShowFileSelector', () => {
        it('GIVEN model exists AND there is no id for given language AND there is no image THEN it returns true', () => {
            expect(component.canShowFileSelector()).toBe(true);
        });
    });
});
