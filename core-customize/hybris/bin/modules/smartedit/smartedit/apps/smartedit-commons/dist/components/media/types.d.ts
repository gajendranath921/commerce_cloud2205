import { InjectionToken, Type } from '@angular/core';
export interface MediaFileSelectorCustom {
    component: Type<any>;
}
export interface MediaFileSelectorCustomInjector {
    onSelect: (fileList: FileList) => void;
}
export declare const MEDIA_FILE_SELECTOR_CUSTOM_TOKEN: InjectionToken<MediaFileSelectorCustom>;
export declare const MEDIA_FILE_SELECTOR_CUSTOM_INJECTOR_TOKEN: InjectionToken<MediaFileSelectorCustomInjector>;
export declare const MEDIA_SELECTOR_I18N_KEY: {
    UPLOAD: string;
    REPLACE: string;
    UNDER_EDIT: string;
    REMOVE: string;
};
export declare type MediaSelectorI18nKey = typeof MEDIA_SELECTOR_I18N_KEY;
export declare const MEDIA_SELECTOR_I18N_KEY_TOKEN: InjectionToken<{
    UPLOAD: string;
    REPLACE: string;
    UNDER_EDIT: string;
    REMOVE: string;
}>;
