import { TranslateService } from '@ngx-translate/core';
import { ISynchronizationPanelApi, ISyncStatus, ISyncJob } from 'cmscommons';
import { IPageInfoService, TypedMap, Nullable, IPageService, PageContentSlotsService } from 'smarteditcommons';
import { SlotSynchronizationService } from '../../services/SlotSynchronizationService';
export declare class SlotSynchronizationPanelWrapperComponent {
    private pageService;
    private pageInfoService;
    private slotSynchronizationService;
    private pageContentSlotsService;
    private translateService;
    slotId: string;
    private synchronizationPanelApi;
    constructor(pageService: IPageService, pageInfoService: IPageInfoService, slotSynchronizationService: SlotSynchronizationService, pageContentSlotsService: PageContentSlotsService, translateService: TranslateService);
    getApi(api: ISynchronizationPanelApi): void;
    getSyncStatus: () => Promise<Nullable<ISyncStatus>>;
    performSync: (itemsToSync: TypedMap<string>[]) => Promise<ISyncJob>;
    private isSyncDisallowed;
    private isPageSlot;
    private isPageApproved;
    private disableSync;
}
