/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {
    GenericEditorDropdownModule,
    SelectModule,
    SpinnerModule,
    TooltipModule,
    TranslationModule,
    MessageModule,
    MEDIA_SELECTOR_I18N_KEY_TOKEN,
    MEDIA_SELECTOR_I18N_KEY,
    IFileValidation,
    moduleUtils
} from 'smarteditcommons';
import {
    MediaPreviewComponent,
    MediaAdvancedPropertiesComponent,
    MediaErrorsComponent,
    MediaFileSelectorComponent,
    MediaSelectorComponent,
    MediaPrinterComponent,
    MediaActionLabelComponent,
    MediaRemoveButtonComponent,
    MediaFormatComponent,
    MediaFormatUploadedComponent,
    MediaUploadFormComponent,
    MediaUploadFieldComponent,
    MediaComponent,
    MediaContainerComponent,
    MediaContainerSelectorItemComponent,
    MediaContainerSelectorComponent
} from './components';

import {
    MediaBackendValidationHandler,
    MediaService,
    MediaUploaderService,
    MediaFolderService,
    MediaUtilService
} from './services';

import './media.scss';

@NgModule({
    imports: [
        TranslationModule.forChild(),
        CommonModule,
        FormsModule,
        TooltipModule,
        SelectModule,
        SpinnerModule,
        GenericEditorDropdownModule,
        MessageModule
    ],
    providers: [
        MediaService,
        MediaUploaderService,
        MediaBackendValidationHandler,
        MediaFolderService,
        MediaUtilService,
        {
            provide: MEDIA_SELECTOR_I18N_KEY_TOKEN,
            useValue: MEDIA_SELECTOR_I18N_KEY
        },
        moduleUtils.bootstrap((_fileValidation: IFileValidation) => {}, [IFileValidation])
    ],
    declarations: [
        MediaErrorsComponent,
        MediaFileSelectorComponent,
        MediaPreviewComponent,
        MediaAdvancedPropertiesComponent,
        MediaSelectorComponent,
        MediaPrinterComponent,
        MediaActionLabelComponent,
        MediaRemoveButtonComponent,
        MediaFormatComponent,
        MediaFormatUploadedComponent,
        MediaUploadFormComponent,
        MediaUploadFieldComponent,
        MediaComponent,
        MediaContainerComponent,
        MediaContainerSelectorComponent,
        MediaContainerSelectorItemComponent
    ],
    entryComponents: [
        MediaErrorsComponent,
        MediaFileSelectorComponent,
        MediaPreviewComponent,
        MediaAdvancedPropertiesComponent,
        MediaSelectorComponent,
        MediaPrinterComponent,
        MediaActionLabelComponent,
        MediaRemoveButtonComponent,
        MediaFormatComponent,
        MediaFormatUploadedComponent,
        MediaUploadFormComponent,
        MediaUploadFieldComponent,
        MediaComponent,
        MediaContainerComponent,
        MediaContainerSelectorItemComponent
    ]
})
export class MediaModule {}
