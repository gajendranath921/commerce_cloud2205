import { CatalogDetailsItemData, UserTrackingService } from 'smarteditcommons';
export declare class PageListLinkComponent {
    catalogDetails: CatalogDetailsItemData;
    private userTrackingService;
    constructor(catalogDetails: CatalogDetailsItemData, userTrackingService: UserTrackingService);
    getLink(): string;
    onClick(): void;
}
