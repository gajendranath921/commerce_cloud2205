import { EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { ISelectItem } from '@smart/utils';
import { Observable } from 'rxjs';
import { UserTrackingService } from '../../services';
import { Tab } from './types';
export declare class TabsComponent<T> implements OnChanges {
    private userTrackingService;
    model: T;
    tabsList: Tab[];
    numTabsDisplayed: number;
    onTabSelected: EventEmitter<string>;
    selectedTab: Tab;
    selectItems: ISelectItem<Tab>[];
    dropdownTabs: ISelectItem<Tab>[];
    private tabChangedStream;
    constructor(userTrackingService: UserTrackingService);
    get isInitialized(): boolean;
    isActiveInMoreTab(): boolean;
    ngOnChanges(changes: SimpleChanges): void;
    selectTab(tabToSelect: Tab): void;
    dropDownHasErrors(): boolean;
    findSelectedTab(): void;
    getDropdownTabs(): Observable<ISelectItem<Tab>[]>;
    getVisibleTabs(): Observable<Tab[]>;
    trackTabById(index: number): number;
}
