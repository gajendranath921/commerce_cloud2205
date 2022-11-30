import { EventEmitter, OnInit, Type, Injector } from '@angular/core';
import { MediaFileSelectorCustom } from 'smarteditcommons';
declare enum MediaFileSelectionMode {
    'replace' = "replace",
    'upload' = "upload"
}
interface CustomComponent {
    component: Type<any>;
    injector: Injector;
}
export declare class MediaFileSelectorComponent implements OnInit {
    private injector;
    selectionMode?: MediaFileSelectionMode;
    labelI18nKey: string;
    acceptedFileTypes: string[];
    customClass?: string;
    disabled?: boolean;
    onFileSelect: EventEmitter<FileList>;
    customComponent: CustomComponent | undefined;
    constructor(injector: Injector, customSelector: MediaFileSelectorCustom);
    ngOnInit(): void;
    buildAcceptedFileTypesList(): string;
    isReplaceMode(): boolean;
    onSelect(fileList: FileList): void;
    private initCustomComponent;
}
export {};
