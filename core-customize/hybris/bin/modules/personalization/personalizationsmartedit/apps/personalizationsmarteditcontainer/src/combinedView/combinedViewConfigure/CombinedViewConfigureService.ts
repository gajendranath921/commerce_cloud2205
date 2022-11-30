import { OnDestroy } from '@angular/core';
import { CombinedViewSelectItem } from 'personalizationcommons';
import { BehaviorSubject, Observable, Subject, Subscription } from 'rxjs';
import { SeDowngradeService } from 'smarteditcommons';

@SeDowngradeService()
export class CombinedViewConfigureService implements OnDestroy {
    private catalogFilterSubject: Subject<string> = new Subject<string>();
    private selectedItemsSubject: BehaviorSubject<CombinedViewSelectItem[]> = new BehaviorSubject<
        CombinedViewSelectItem[]
    >([]);
    private selectedItemsSubscription: Subscription;
    private selectedItems: CombinedViewSelectItem[] = [];

    constructor() {
        this.selectedItemsSubscription = this.selectedItemsSubject
            .asObservable()
            .subscribe((selectedItems: CombinedViewSelectItem[]) => {
                this.selectedItems = selectedItems;
            });
    }

    ngOnDestroy(): void {
        this.selectedItemsSubscription.unsubscribe();
    }

    public setCatalogFilter(catalogFilter: string): void {
        this.catalogFilterSubject.next(catalogFilter);
    }

    public getCatalogFilter$(): Observable<string> {
        return this.catalogFilterSubject.asObservable();
    }

    public setSelectedItems(items: CombinedViewSelectItem[]): void {
        this.selectedItemsSubject.next(items);
    }

    public isItemSelected = (item: CombinedViewSelectItem): boolean =>
        !!this.selectedItems.find(
            (currentItem: CombinedViewSelectItem) =>
                currentItem.customization.code === item.customization.code &&
                currentItem.variation.code === item.variation.code
        );
}
