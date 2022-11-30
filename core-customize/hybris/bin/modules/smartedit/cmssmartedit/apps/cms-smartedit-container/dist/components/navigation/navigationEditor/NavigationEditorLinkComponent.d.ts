import { CatalogDetailsItemData, UserTrackingService } from 'smarteditcommons';
export declare class NavigationEditorLinkComponent {
    catalogDetails: CatalogDetailsItemData;
    private userTrackingService;
    constructor(catalogDetails: CatalogDetailsItemData, userTrackingService: UserTrackingService);
    getLink(): string;
    onClick(): void;
}
