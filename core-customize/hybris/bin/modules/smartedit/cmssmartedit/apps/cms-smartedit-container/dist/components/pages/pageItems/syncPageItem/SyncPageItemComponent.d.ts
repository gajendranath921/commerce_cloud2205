import { OnInit } from '@angular/core';
import { ICatalogService, IModalService, LogService, MultiNamePermissionContext, SystemEventService, IDropdownMenuItemData, ICMSPage, UserTrackingService } from 'smarteditcommons';
export declare class SyncPageItemComponent implements OnInit {
    private dropdownMenuData;
    private catalogService;
    private systemEventService;
    private modalService;
    private logService;
    private userTrackingService;
    pageInfo: ICMSPage;
    syncPagePermission: MultiNamePermissionContext[];
    constructor(dropdownMenuData: IDropdownMenuItemData, catalogService: ICatalogService, systemEventService: SystemEventService, modalService: IModalService, logService: LogService, userTrackingService: UserTrackingService);
    ngOnInit(): void;
    sync(): Promise<void>;
}
