import { OnInit, OnDestroy } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { PaginationHelper, PersonalizationsmarteditMessageHandler, PersonalizationsmarteditUtils, Customization } from 'personalizationcommons';
import { CustomizationDataFactory } from 'personalizationsmarteditcontainer/dataFactory';
import { PersonalizationsmarteditContextService } from 'personalizationsmarteditcontainer/service';
export declare class CustomizeViewComponent implements OnInit, OnDestroy {
    private translateService;
    protected customizationDataFactory: CustomizationDataFactory;
    protected personalizationsmarteditContextService: PersonalizationsmarteditContextService;
    protected personalizationsmarteditMessageHandler: PersonalizationsmarteditMessageHandler;
    protected personalizationsmarteditUtils: PersonalizationsmarteditUtils;
    isMenuOpen: boolean;
    pagination: PaginationHelper;
    moreCustomizationsRequestProcessing: boolean;
    customizationsList: Customization[];
    filters: any;
    catalogFilter: any;
    pageFilter: any;
    statusFilter: any;
    nameFilter: any;
    showResetButton: boolean;
    constructor(translateService: TranslateService, customizationDataFactory: CustomizationDataFactory, personalizationsmarteditContextService: PersonalizationsmarteditContextService, personalizationsmarteditMessageHandler: PersonalizationsmarteditMessageHandler, personalizationsmarteditUtils: PersonalizationsmarteditUtils);
    ngOnInit(): void;
    ngOnDestroy(): void;
    catalogFilterChange(itemId: string): void;
    pageFilterChange(itemId: string): void;
    statusFilterChange(itemId: string): void;
    nameInputKeypress(): void;
    resetSearch(event?: Event): void;
    addMoreCustomizationItems(): void;
    getPage: () => void;
    private errorCallback;
    private successCallback;
    private getStatus;
    private getCustomizations;
    private getCustomizationsFilterObject;
    private refreshList;
}
