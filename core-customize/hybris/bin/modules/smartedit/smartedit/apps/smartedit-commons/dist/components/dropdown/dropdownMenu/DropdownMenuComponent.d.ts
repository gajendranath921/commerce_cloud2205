import { ChangeDetectorRef, ElementRef, EventEmitter, Injector, OnChanges, SimpleChanges } from '@angular/core';
import { Placement } from '../../popupOverlay';
import { IDropdownMenuItem } from './IDropdownMenuItem';
import './DropdownMenuComponent.scss';
export declare class DropdownMenuComponent implements OnChanges {
    private cd;
    dropdownItems: IDropdownMenuItem[];
    selectedItem: any;
    placement: Placement;
    useProjectedAnchor: boolean;
    isOpen: boolean;
    additionalClasses: string[];
    isOpenChange: EventEmitter<boolean>;
    toggleMenuElement: ElementRef<HTMLDivElement>;
    clonedDropdownItems: IDropdownMenuItem[];
    dropdownMenuItemDefaultInjector: Injector;
    constructor(cd: ChangeDetectorRef);
    clickHandler(event: MouseEvent): void;
    ngOnChanges(changes: SimpleChanges): void;
    private emitIsOpenChange;
    private setDefaultComponentIfNeeded;
    private validateDropdownItem;
}
