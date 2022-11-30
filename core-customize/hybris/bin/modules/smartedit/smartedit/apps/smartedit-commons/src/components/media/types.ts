/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { InjectionToken, Type } from '@angular/core';

export interface MediaFileSelectorCustom {
    component: Type<any>;
}

export interface MediaFileSelectorCustomInjector {
    onSelect: (fileList: FileList) => void;
}

export const MEDIA_FILE_SELECTOR_CUSTOM_TOKEN = new InjectionToken<MediaFileSelectorCustom>(
    'MEDIA_FILE_SELECTOR_CUSTOM_TOKEN'
);

export const MEDIA_FILE_SELECTOR_CUSTOM_INJECTOR_TOKEN = new InjectionToken<
    MediaFileSelectorCustomInjector
>('MEDIA_FILE_SELECTOR_CUSTOM_INJECTOR_TOKEN');

export const MEDIA_SELECTOR_I18N_KEY = {
    UPLOAD: 'se.media.format.upload',
    REPLACE: 'se.media.format.replace',
    UNDER_EDIT: 'se.media.format.under.edit',
    REMOVE: 'se.media.format.remove'
};

export type MediaSelectorI18nKey = typeof MEDIA_SELECTOR_I18N_KEY;

export const MEDIA_SELECTOR_I18N_KEY_TOKEN = new InjectionToken<MediaSelectorI18nKey>(
    'MEDIA_SELECTOR_I18N_KEY_TOKEN'
);
