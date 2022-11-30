import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { ItemComponentData, SelectComponent } from 'smarteditcommons';
import { Media } from '../../../services';
export declare class MediaPrinterComponent {
    data: ItemComponentData<Media>;
    private readonly sanitizer;
    media: Media;
    isSelected: boolean;
    select: SelectComponent<Media>;
    constructor(data: ItemComponentData<Media>, sanitizer: DomSanitizer);
    isDisabled(): boolean;
    isImage(): boolean;
    isVideo(): boolean;
    isPdf(): boolean;
    getSafeUrl(): SafeResourceUrl;
}
