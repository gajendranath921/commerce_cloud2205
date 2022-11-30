/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import {
    ChangeDetectionStrategy,
    ChangeDetectorRef,
    Component,
    EventEmitter,
    Input,
    OnChanges,
    Output,
    SimpleChanges,
    ViewRef
} from '@angular/core';
import { ICMSMedia } from 'cmscommons';
import {
    ErrorContext,
    FILE_VALIDATION_CONFIG,
    FileValidator,
    FileValidatorFactory,
    SeDowngradeComponent,
    stringUtils,
    ErrorResponse,
    GenericEditorMediaType
} from 'smarteditcommons';
import {
    MediaBackendValidationHandler,
    MediaUploaderService,
    MediaUtilService,
    MediaFolderService,
    MediaFolderFetchStrategy
} from '../../services';

interface ImageEditableParams {
    code: string;
    description: string;
    altText: string;
}
@SeDowngradeComponent()
@Component({
    selector: 'se-media-upload-form',
    templateUrl: './MediaUploadFormComponent.html',
    styleUrls: ['./MediaUploadFormComponent.scss'],
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class MediaUploadFormComponent implements OnChanges {
    @Input() image: File;
    @Input() allowMediaType: GenericEditorMediaType;
    @Input() maxUploadFileSize: number;
    @Output() onCancel: EventEmitter<void>;
    @Output() onSelect: EventEmitter<FileList>;
    @Output() onUploadSuccess: EventEmitter<string>;

    public acceptedFileTypes: string[];
    public isUploading: boolean;
    public fieldErrors: ErrorContext[];
    public imageParams: ImageEditableParams | null;
    public folderSelected: string;
    public folderFetchStrategy: MediaFolderFetchStrategy;
    public folderErrors: string[];

    private fileValidator: FileValidator;

    constructor(
        private cdr: ChangeDetectorRef,
        private fileValidatorFactory: FileValidatorFactory,
        private mediaBackendValidationHandler: MediaBackendValidationHandler,
        private mediaUploaderService: MediaUploaderService,
        private mediaFolderService: MediaFolderService,
        private mediaUtilService: MediaUtilService
    ) {
        this.onCancel = new EventEmitter();
        this.onSelect = new EventEmitter();
        this.onUploadSuccess = new EventEmitter();

        this.fieldErrors = [];
        this.imageParams = null;
        this.fileValidator = this.fileValidatorFactory.build([
            {
                subject: 'code',
                message: 'se.uploaded.image.code.is.required',
                validate: (code: string): boolean => !!code
            }
        ]);
    }

    async ngOnInit(): Promise<void> {
        this.acceptedFileTypes = this.mediaUtilService.getAcceptedFileTypes(this.allowMediaType);
        this.folderFetchStrategy = this.mediaFolderService.mediaFoldersFetchStrategy;
        this.folderSelected = await this.mediaFolderService.getDefaultFolder();
        this.cdr.markForCheck();
    }

    ngOnChanges(changes: SimpleChanges): void {
        const imageChange = changes.image;
        if (imageChange) {
            const { name: imageName } = this.image;
            this.imageParams = {
                code: imageName,
                description: imageName,
                altText: imageName
            };
        }
    }

    public getErrorsForFieldByCode(code: keyof ImageEditableParams): string[] {
        return this.fieldErrors
            .filter((error) => error.subject === code)
            .map((error) => error.message);
    }

    public async uploadMedia(): Promise<void> {
        this.fieldErrors = [];
        if (
            !this.fileValidator.validate(this.imageParams, this.maxUploadFileSize, this.fieldErrors)
        ) {
            return;
        }
        const validate = this.acceptedFileTypes.filter(
            (type: string) => this.image && this.image.type && this.image.type.includes(type)
        );
        if (!validate || (validate && validate.length < 1)) {
            this.fieldErrors.push({
                subject: 'code',
                message: FILE_VALIDATION_CONFIG.I18N_KEYS.FILE_TYPE_INVALID
            });
            return;
        }

        this.isUploading = true;
        try {
            const uploadedMedia = await this.mediaUploaderService.uploadMedia({
                file: this.image,
                code: stringUtils.escapeHtml(this.imageParams.code) as string,
                description: stringUtils.escapeHtml(this.imageParams.description) as string,
                altText: stringUtils.escapeHtml(this.imageParams.altText) as string,
                folder: this.folderSelected ? this.folderSelected : ''
            });

            this.onMediaUploadSuccess(uploadedMedia);
        } catch (error) {
            this.onMediaUploadFail(error);
        } finally {
            this.isUploading = false;
        }
        if (!(this.cdr as ViewRef).destroyed) {
            this.cdr.detectChanges();
        }
    }

    public cancel(): void {
        this.reset();

        this.onCancel.emit();
    }

    public onChangeFieldValue(value: string, paramName: keyof ImageEditableParams): void {
        this.imageParams[paramName] = value;
    }

    public onFileSelect(fileList: FileList): void {
        this.onSelect.emit(fileList);
    }

    public hasError(): boolean {
        return this.folderErrors?.length > 0;
    }

    public folderSelectedChanged(folder: string): void {
        this.folderErrors = []; // clean the error
    }

    private onMediaUploadSuccess({ uuid }: ICMSMedia): void {
        this.reset();

        this.onUploadSuccess.emit(uuid);
    }

    private onMediaUploadFail(response: ErrorResponse): void {
        this.mediaBackendValidationHandler.handleResponse(response, this.fieldErrors);
        this.folderErrors = this.fieldErrors
            .filter((error) => error.subject === 'folder')
            .map((error) => error.message);
    }

    private reset(): void {
        this.imageParams = null;
        this.fieldErrors = [];
        this.isUploading = false;
    }
}
