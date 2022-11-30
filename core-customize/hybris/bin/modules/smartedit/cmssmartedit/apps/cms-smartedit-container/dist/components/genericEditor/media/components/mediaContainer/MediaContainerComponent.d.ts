import { OnInit } from '@angular/core';
import { TypePermissionsRestService } from 'cmscommons';
import { ErrorContext, GenericEditorField, GenericEditorWidgetData, LogService, SystemEventService, TypedMap, ISharedDataService, IFileValidation } from 'smarteditcommons';
import { LoadConfigManagerService } from 'smarteditcontainer';
export declare const MediaContainerClonePrefix = "clone_";
export interface MediaContainer {
    catalogVersion: string;
    medias: {
        [index in MediaFormatType]: string;
    } | unknown;
    qualifier: string;
    mediaContainerUuid: string;
}
export declare enum MediaFormatType {
    widescreen = "widescreen",
    desktop = "desktop",
    tablet = "tablet",
    mobile = "mobile"
}
export declare class MediaContainerComponent implements OnInit {
    private systemEventService;
    private logService;
    private typePermissionsRestService;
    private loadConfigManagerService;
    private fileValidationService;
    private sharedDataService;
    image: {
        file: File;
        format: MediaFormatType;
    };
    advancedMediaContainerManagementEnabled: boolean;
    hasReadPermissionOnMediaRelatedTypes: boolean;
    mediaContainerCreationInProgress: boolean;
    selectorEventNameAffix: string;
    fileValidationErrors: ErrorContext[];
    initialMediaContainerName: string;
    field: GenericEditorField;
    model: TypedMap<MediaContainer | undefined>;
    lang: string;
    isFieldDisabled: () => boolean;
    maxUploadFileSize: number;
    private initialMediaContainerNameKey;
    private editor;
    private unRegDependsOnValueChanged;
    private sessionStorage;
    constructor(systemEventService: SystemEventService, logService: LogService, typePermissionsRestService: TypePermissionsRestService, loadConfigManagerService: LoadConfigManagerService, fileValidationService: IFileValidation, sharedDataService: ISharedDataService, data: GenericEditorWidgetData<TypedMap<MediaContainer>>);
    ngOnInit(): Promise<void>;
    getMediaContainerName(): string;
    getInitialMediaContainerName(): void;
    getMediaContainerCellClassName(format: MediaFormatType): string;
    setMediaContainer(mediaContainer: MediaContainer): void;
    canShowMediaFormatWithUploadForm(): boolean;
    isMediaFormatUnderEdit(format: MediaFormatType): boolean;
    onFileSelect(files: FileList, format?: MediaFormatType): Promise<void>;
    onFileUploadSuccess(uuid: string, format: MediaFormatType): void;
    resetErrors(): void;
    onMediaContainerCreate(name: string): void;
    onMediaContainerRemove(): void;
    onMediaContainerNameChange(name: string): void;
    onMediaContainerCreationInProgressChange(inProgress: boolean): void;
    removeMediaByFormat(format: MediaFormatType): void;
    isAdvancedCloning(): boolean;
    private onDependsOnValueChanged;
    private initAdvancedMediaContainerManagementEnabled;
    private initHasReadPermissionOnMediaRelatedTypes;
    private setMediaUuidForFormat;
    private isMediaContainerSelected;
    private resetImage;
    private clearModel;
    private resetModelForClone;
}
