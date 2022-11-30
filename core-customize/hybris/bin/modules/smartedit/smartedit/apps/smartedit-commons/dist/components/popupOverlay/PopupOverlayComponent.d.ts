import { EventEmitter, Injector, SimpleChanges } from '@angular/core';
import { PopoverComponent } from '@fundamental-ngx/core';
import { TypedMap } from '@smart/utils';
import { PopupOverlayConfig } from './PopupOverlayConfig';
import { PopupOverlayTrigger, Placement } from './PopupOverlayTrigger';
export declare class PopupOverlayComponent {
    private injector;
    popupOverlay: PopupOverlayConfig;
    popupOverlayTrigger: PopupOverlayTrigger;
    popupOverlayData: TypedMap<any>;
    popupOverlayOnShow: EventEmitter<any>;
    popupOverlayOnHide: EventEmitter<any>;
    popover: PopoverComponent;
    isOpen: boolean;
    trigger: string[];
    appendTo: HTMLElement;
    popupOverlayInjector: Injector;
    constructor(injector: Injector);
    ngOnInit(): void;
    ngOnChanges(changes: SimpleChanges): void;
    handleOpenChange(isOpen: boolean): void;
    handleOpen(): void;
    handleClose(): void;
    getPlacement(): Placement;
    private setTrigger;
    private getHorizontalAlign;
    private createInjector;
}
