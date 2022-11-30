import { ChangeDetectorRef, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { ErrorContext, FileValidatorFactory, GenericEditorMediaType } from 'smarteditcommons';
import { MediaBackendValidationHandler, MediaUploaderService, MediaUtilService, MediaFolderService, MediaFolderFetchStrategy } from '../../services';
interface ImageEditableParams {
    code: string;
    description: string;
    altText: string;
}
export declare class MediaUploadFormComponent implements OnChanges {
    private cdr;
    private fileValidatorFactory;
    private mediaBackendValidationHandler;
    private mediaUploaderService;
    private mediaFolderService;
    private mediaUtilService;
    image: File;
    allowMediaType: GenericEditorMediaType;
    maxUploadFileSize: number;
    onCancel: EventEmitter<void>;
    onSelect: EventEmitter<FileList>;
    onUploadSuccess: EventEmitter<string>;
    acceptedFileTypes: string[];
    isUploading: boolean;
    fieldErrors: ErrorContext[];
    imageParams: ImageEditableParams | null;
    folderSelected: string;
    folderFetchStrategy: MediaFolderFetchStrategy;
    folderErrors: string[];
    private fileValidator;
    constructor(cdr: ChangeDetectorRef, fileValidatorFactory: FileValidatorFactory, mediaBackendValidationHandler: MediaBackendValidationHandler, mediaUploaderService: MediaUploaderService, mediaFolderService: MediaFolderService, mediaUtilService: MediaUtilService);
    ngOnInit(): Promise<void>;
    ngOnChanges(changes: SimpleChanges): void;
    getErrorsForFieldByCode(code: keyof ImageEditableParams): string[];
    uploadMedia(): Promise<void>;
    cancel(): void;
    onChangeFieldValue(value: string, paramName: keyof ImageEditableParams): void;
    onFileSelect(fileList: FileList): void;
    hasError(): boolean;
    folderSelectedChanged(folder: string): void;
    private onMediaUploadSuccess;
    private onMediaUploadFail;
    private reset;
}
export {};
