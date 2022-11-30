import { Injector, OnChanges, SimpleChanges } from '@angular/core';
import { DynamicPagedListColumnKey, DynamicPagedListDropdownItem } from '../dynamicPagedList';
export declare class DataTableRendererComponent implements OnChanges {
    private injector;
    column: DynamicPagedListColumnKey;
    item: DynamicPagedListDropdownItem;
    componentInjector: Injector;
    constructor(injector: Injector);
    ngOnChanges(changes: SimpleChanges): void;
    private createInjector;
}
