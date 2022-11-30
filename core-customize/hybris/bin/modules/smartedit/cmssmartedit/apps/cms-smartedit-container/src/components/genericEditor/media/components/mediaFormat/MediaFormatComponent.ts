/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import {
    Component,
    EventEmitter,
    Input,
    OnChanges,
    OnInit,
    Output,
    Inject,
    SimpleChanges,
    ViewEncapsulation
} from '@angular/core';
import {
    GenericEditorFieldMessage,
    GenericEditorMediaType,
    MEDIA_SELECTOR_I18N_KEY_TOKEN,
    MediaSelectorI18nKey,
    SeDowngradeComponent
} from 'smarteditcommons';
import { Media, MediaService, MediaUtilService } from '../../services';

@SeDowngradeComponent()
@Component({
    selector: 'se-media-format',
    templateUrl: './MediaFormatComponent.html',
    styleUrls: ['./MediaFormatComponent.scss', '../../mediaPreviewContainer.scss'],
    encapsulation: ViewEncapsulation.None
})
export class MediaFormatComponent implements OnInit, OnChanges {
    @Input() errorMessages: GenericEditorFieldMessage[];
    @Input() isEditable: boolean;
    @Input() isUnderEdit: boolean;
    @Input() isFieldDisabled: boolean;
    @Input() mediaUuid: string | undefined;
    @Input() mediaFormat: string;
    @Input() mediaLabel: string;
    @Input() allowMediaType: GenericEditorMediaType;

    @Output() onFileSelect: EventEmitter<FileList>;
    @Output() onDelete: EventEmitter<void>;

    public media: Media | null;
    public mediaFormatI18nKey: string;
    public mediaSelectorI18nKeys: MediaSelectorI18nKey;
    public acceptedFileTypes: string[];

    constructor(
        private mediaService: MediaService,
        private mediaUtilService: MediaUtilService,
        @Inject(MEDIA_SELECTOR_I18N_KEY_TOKEN) mediaSelectorI18nKey: MediaSelectorI18nKey
    ) {
        this.onFileSelect = new EventEmitter();
        this.onDelete = new EventEmitter();
        this.media = null;
        this.mediaSelectorI18nKeys = mediaSelectorI18nKey;
    }

    async ngOnInit(): Promise<void> {
        this.acceptedFileTypes = this.mediaUtilService.getAcceptedFileTypes(this.allowMediaType);
        this.mediaFormatI18nKey = `se.media.format.${this.mediaFormat}`;
        if (this.mediaUuid) {
            return this.fetchAndSetMedia();
        }
    }

    async ngOnChanges(changes: SimpleChanges): Promise<void> {
        const mediaUuidChange = changes.mediaUuid;

        // To prevent calling fetchAndSetMedia twice.
        // Skips the first change as the condition is checked in ngOnInit which is called after the ngOnChanges
        if (mediaUuidChange && !mediaUuidChange.firstChange) {
            if (this.mediaUuid) {
                // Media Image has been replaced
                return this.fetchAndSetMedia();
            } else {
                // Media Image has been removed
                this.media = null;
            }
        }
    }

    public onFileSelectorFileSelect(file: FileList): void {
        this.onFileSelect.emit(file);
    }

    public onRemoveButtonClick(): void {
        this.onDelete.emit();
    }

    public isMediaPreviewEnabled(): boolean {
        return this.mediaUuid && !this.isUnderEdit && !!this.media?.code;
    }

    public isMediaAbsent(): boolean {
        return !this.mediaUuid && !this.isUnderEdit;
    }

    public getErrors(): string[] {
        return (this.errorMessages || [])
            .filter((error) => error.format === this.mediaFormat)
            .map((error) => error.message);
    }

    private async fetchAndSetMedia(): Promise<void> {
        this.media = await this.mediaService.getMedia(this.mediaUuid);
    }
}
