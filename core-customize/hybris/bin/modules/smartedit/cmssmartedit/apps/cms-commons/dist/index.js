'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var smarteditcommons = require('smarteditcommons');
var core$1 = require('@ngx-translate/core');
var core = require('@angular/core');
var common = require('@angular/common');
var forms = require('@angular/forms');
var moment = require('moment');
var rxjs = require('rxjs');
var operators = require('rxjs/operators');
var lodash = require('lodash');
var core$2 = require('@fundamental-ngx/core');

(function(){
      var angular = angular || window.angular;
      var SE_NG_TEMPLATE_MODULE = null;
      
      try {
        SE_NG_TEMPLATE_MODULE = angular.module('cmscommonsTemplates');
      } catch (err) {}
      SE_NG_TEMPLATE_MODULE = SE_NG_TEMPLATE_MODULE || angular.module('cmscommonsTemplates', []);
      SE_NG_TEMPLATE_MODULE.run(['$templateCache', function($templateCache) {
         
    $templateCache.put(
        "ExternalComponentButtonComponent.html", 
        "<div class=\"se-ctx-menu-btn__msg\" *ngIf=\"isReady\">{{ catalogVersion }}</div>"
    );
     
    $templateCache.put(
        "SharedComponentButtonComponent.html", 
        "<div class=\"se-ctx-menu-btn__msg\"><div class=\"se-ctx-menu-btn__msg-title\" translate=\"se.cms.contextmenu.shared.component.info.title\"></div><div *ngIf=\"isReady\" class=\"se-ctx-menu-btn__msg-description\" [translate]=\"message\"></div><se-spinner [isSpinning]=\"!isReady\"></se-spinner></div>"
    );
     
    $templateCache.put(
        "SynchronizationPanelComponent.html", 
        "<div class=\"se-sync-panel\"><se-message *ngIf=\"message\" [type]=\"message.type\"><ng-container se-message-description>{{ message.description }}</ng-container></se-message><div class=\"se-sync-panel__sync-info\" [style.visibility]=\"showItemList ? 'visible': 'hidden'\"><se-spinner [isSpinning]=\"isLoading\"></se-spinner><se-synchronization-panel-item *ngFor=\"let item of getAllItems(); let i = index\" class=\"se-sync-panel__row\" [index]=\"i\" [item]=\"item\" [rootItem]=\"getRootItem()\" [selectAllLabel]=\"selectAllLabel\" [disableList]=\"disableList\" [disableItem]=\"api.disableItem\" (selectionChange)=\"selectionChange($event)\"></se-synchronization-panel-item></div><div class=\"se-sync-panel__footer\" *ngIf=\"showFooter\"><button class=\"se-sync-panel__sync-btn fd-button--emphasized\" [disabled]=\"isSyncButtonDisabled()\" (click)=\"syncItems()\" translate=\"se.cms.actionitem.page.sync\"></button></div></div>"
    );
     
    $templateCache.put(
        "SynchronizationPanelItemComponent.html", 
        "<div class=\"se-sync-panel-item-checkbox fd-form__item\"><input *ngIf=\"!item.isExternal\" type=\"checkbox\" [id]=\"'sync-info__checkbox_' + index\" class=\"se-sync-panel-item-checkbox__field fd-form__control\" [(ngModel)]=\"item.selected\" (ngModelChange)=\"onSelectionChange()\" [attr.disabled]=\"isItemDisabled() ? true : null\"/> <label *ngIf=\"index === 0\" [for]=\"'sync-info__checkbox_' + index\" class=\"se-sync-panel-item-checkbox__label se-sync-panel-item-checkbox__label--select-all fd-form__label\" [title]=\"getSelectAllLabel() | translate\" [translate]=\"getSelectAllLabel()\"></label> <label *ngIf=\"index !== 0 && !item.isExternal\" [for]=\"'sync-info__checkbox_' + index\" class=\"se-sync-panel-item-checkbox__label fd-form__label\" [title]=\"item.name | translate\" [translate]=\"item.name\"></label><se-tooltip *ngIf=\"index !== 0 && item.isExternal\" [isChevronVisible]=\"true\" [triggers]=\"['mouseenter', 'mouseleave']\"><label se-tooltip-trigger [for]=\"'sync-info__checkbox_' + index\" class=\"se-sync-panel-item-checkbox__label fd-form__label\" [translate]=\"item.name\"></label><div se-tooltip-body translate=\"se.cms.synchronization.slot.external.component\"></div></se-tooltip></div><span *ngIf=\"showPopoverOverSyncIcon()\"><se-tooltip [isChevronVisible]=\"true\" [appendTo]=\"'body'\" [placement]=\"'left'\" [triggers]=\"['mouseenter', 'mouseleave']\" [title]=\"getInfoTitle()\" class=\"pull-right se-sync-panel-item-info-icon\" [ngClass]=\"{ 'se-sync-panel--icon-globe': item.isExternal }\"><ng-container *ngIf=\"!item.isExternal\" se-tooltip-trigger><ng-container *ngTemplateOutlet=\"syncInfoIcon\"></ng-container></ng-container><span *ngIf=\"item.isExternal\" class=\"sap-icon--globe\" se-tooltip-trigger></span><div se-tooltip-body><ng-container *ngIf=\"!item.isExternal\"><div *ngFor=\"let dependentItem of item.dependentItemTypesOutOfSync\">{{ dependentItem.i18nKey | translate }}</div></ng-container><div *ngIf=\"item.isExternal\">{{ item.catalogVersionName | seL10n | async }}</div></div></se-tooltip></span><span *ngIf=\"!showPopoverOverSyncIcon()\" class=\"pull-right se-sync-panel-item-info-icon\"><ng-container *ngTemplateOutlet=\"syncInfoIcon\"></ng-container></span><ng-template #syncInfoIcon><span [attr.status]=\"item.status\" class=\"se-sync-panel-item-info-icon__icon\" [ngClass]=\"{                'sap-icon--accept': isInSync(),                'sap-icon--message-warning': !isInSync()            }\"></span></ng-template>"
    );
    
      }]);
    })();

/*! *****************************************************************************
Copyright (c) Microsoft Corporation.

Permission to use, copy, modify, and/or distribute this software for any
purpose with or without fee is hereby granted.

THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES WITH
REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY
AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY SPECIAL, DIRECT,
INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM
LOSS OF USE, DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR
OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR
PERFORMANCE OF THIS SOFTWARE.
***************************************************************************** */

function __decorate(decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
}

function __param(paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
}

function __metadata(metadataKey, metadataValue) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(metadataKey, metadataValue);
}

function __awaiter(thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
}

/**
 * Determines the root of the production and test assets
 */
/* @ngInject */ exports.AssetsService = class /* @ngInject */ AssetsService {
    constructor(testModeService) {
        this.testModeService = testModeService;
        this.TEST_ASSETS_SRC = '/web/webroot';
        this.PROD_ASSETS_SRC = '/cmssmartedit';
    }
    getAssetsRoot() {
        return this.testModeService.isE2EMode() ? this.TEST_ASSETS_SRC : this.PROD_ASSETS_SRC;
    }
};
exports.AssetsService.$inject = ["testModeService"];
/* @ngInject */ exports.AssetsService = __decorate([
    smarteditcommons.SeDowngradeService(),
    __metadata("design:paramtypes", [smarteditcommons.TestModeService])
], /* @ngInject */ exports.AssetsService);

/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
const WORKFLOW_CREATED_EVENT = 'WORKFLOW_CREATED_EVENT';
const WORKFLOW_FINISHED_EVENT = 'WORKFLOW_FINISHED_EVENT';
const workflowCreatedEvictionTag = new smarteditcommons.EvictionTag({ event: WORKFLOW_CREATED_EVENT });
const workflowCompletedEvictionTag = new smarteditcommons.EvictionTag({ event: WORKFLOW_FINISHED_EVENT });
const workflowTasksMenuOpenedEvictionTag = new smarteditcommons.EvictionTag({
    event: 'WORKFLOW_TASKS_MENU_OPENED_EVENT'
});

/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
const slotEvictionTag = new smarteditcommons.EvictionTag({ event: 'SLOT_UPDATE_EVENT' });

/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/**
 * @ngdoc service
 *
 * @description
 * Service to verify whether the item is editable in a particular context.
 */
class IContextAwareEditableItemService {
    /**
     * @ngdoc method
     *
     * @description
     * Verifies whether the item is editable in current context or not.
     *
     * @param {string} itemUid The item uid.
     *
     * @returns {Promise} A promise that resolves to a boolean. It will be true, if the item is editable, false otherwise.
     */
    isItemEditable(itemUid) {
        'proxyFunction';
        return null;
    }
}

/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
const CONTEXT_CATALOG = 'CURRENT_CONTEXT_CATALOG';
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:CONTEXT_CATALOG_VERSION
 *
 * @description
 * Constant containing the name of the catalog version placeholder in URLs
 */
const CONTEXT_CATALOG_VERSION = 'CURRENT_CONTEXT_CATALOG_VERSION';
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:CONTEXT_SITE_ID
 *
 * @description
 * Constant containing the name of the site uid placeholder in URLs
 */
const CONTEXT_SITE_ID = 'CURRENT_CONTEXT_SITE_ID';
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:PAGE_CONTEXT_CATALOG
 *
 * @description
 * Constant containing the name of the current page catalog uid placeholder in URLs
 */
const PAGE_CONTEXT_CATALOG = 'CURRENT_PAGE_CONTEXT_CATALOG';
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:PAGE_CONTEXT_CATALOG_VERSION
 *
 * @description
 * Constant containing the name of the current page catalog version placeholder in URLs
 */
const PAGE_CONTEXT_CATALOG_VERSION = 'CURRENT_PAGE_CONTEXT_CATALOG_VERSION';
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:TYPES_RESOURCE_URI
 *
 * @description
 * Resource URI of the component types REST service.
 */
const TYPES_RESOURCE_URI = '/cmswebservices/v1/types';
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:ITEMS_RESOURCE_URI
 *
 * @description
 * Resource URI of the custom components REST service.
 */
const ITEMS_RESOURCE_URI = `/cmswebservices/v1/sites/${CONTEXT_SITE_ID}/catalogs/${CONTEXT_CATALOG}/versions/${CONTEXT_CATALOG_VERSION}/items`;
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:ITEMS_RESOURCE_URI
 *
 * @description
 * Resource URI of the custom components REST service.
 */
const PAGES_CONTENT_SLOT_COMPONENT_RESOURCE_URI = `/cmswebservices/v1/sites/${smarteditcommons.PAGE_CONTEXT_SITE_ID}/catalogs/${PAGE_CONTEXT_CATALOG}/versions/${PAGE_CONTEXT_CATALOG_VERSION}/pagescontentslotscomponents`;
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:CONTENT_SLOT_TYPE_RESTRICTION_RESOURCE_URI
 *
 * @description
 * Resource URI of the content slot type restrictions REST service.
 */
const CONTENT_SLOT_TYPE_RESTRICTION_RESOURCE_URI = `/cmswebservices/v1/catalogs/${PAGE_CONTEXT_CATALOG}/versions/${PAGE_CONTEXT_CATALOG_VERSION}/pages/:pageUid/contentslots/:slotUid/typerestrictions`;
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:CONTENT_SLOT_TYPE_RESTRICTION_RESOURCE_URI
 *
 * @description
 * Resource URI of the content slot type restrictions REST service given the page uid.
 */
const CONTENT_SLOTS_TYPE_RESTRICTION_RESOURCE_URI = `/cmswebservices/v1/catalogs/${PAGE_CONTEXT_CATALOG}/versions/${PAGE_CONTEXT_CATALOG_VERSION}/pages/:pageUid/typerestrictions`;
/**
 * @ngdoc object
 * @name resourceLocationsMod`ule.object:PAGES_LIST_RESOURCE_URI
 *
 * @description
 * Resource URI of the pages REST service.
 */
const PAGES_LIST_RESOURCE_URI = `/cmswebservices/v1/sites/${CONTEXT_SITE_ID}/catalogs/${CONTEXT_CATALOG}/versions/${CONTEXT_CATALOG_VERSION}/pages`;
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:PAGE_LIST_PATH
 *
 * @description
 * Path of the page list
 */
const PAGE_LIST_PATH = '/pages/:siteId/:catalogId/:catalogVersion';
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:TRASHED_PAGE_LIST_PATH
 *
 * @description
 * Path of the page list
 */
const TRASHED_PAGE_LIST_PATH = '/trashedpages/:siteId/:catalogId/:catalogVersion';
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:PAGES_CONTENT_SLOT_RESOURCE_URI
 *
 * @description
 * Resource URI of the page content slots REST service
 */
const PAGES_CONTENT_SLOT_RESOURCE_URI = `/cmswebservices/v1/sites/${smarteditcommons.PAGE_CONTEXT_SITE_ID}/catalogs/${PAGE_CONTEXT_CATALOG}/versions/${PAGE_CONTEXT_CATALOG_VERSION}/pagescontentslots`;
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:PAGE_TEMPLATES_URI
 *
 * @description
 * Resource URI of the page templates REST service
 */
const PAGE_TEMPLATES_URI = `/cmswebservices/v1/sites/:${CONTEXT_SITE_ID}/catalogs/:${CONTEXT_CATALOG}/versions/:${CONTEXT_CATALOG_VERSION}/pagetemplates`;
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:NAVIGATION_MANAGEMENT_PAGE_PATH
 *
 * @description
 * Path to the Navigation Management
 */
const NAVIGATION_MANAGEMENT_PAGE_PATH = '/navigations/:siteId/:catalogId/:catalogVersion';
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:NAVIGATION_MANAGEMENT_RESOURCE_URI
 *
 * @description
 * Resource URI of the navigations REST service.
 */
const NAVIGATION_MANAGEMENT_RESOURCE_URI = `/cmswebservices/v1/sites/:${CONTEXT_SITE_ID}/catalogs/:${CONTEXT_CATALOG}/versions/:${CONTEXT_CATALOG_VERSION}/navigations`;
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:NAVIGATION_MANAGEMENT_ENTRIES_RESOURCE_URI
 *
 * @description
 * Resource URI of the navigations REST service.
 */
const NAVIGATION_MANAGEMENT_ENTRIES_RESOURCE_URI = `/cmswebservices/v1/sites/:${CONTEXT_SITE_ID}/catalogs/:${CONTEXT_CATALOG}/versions/:${CONTEXT_CATALOG_VERSION}/navigations/:navigationUid/entries`;
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:NAVIGATION_MANAGEMENT_ENTRY_TYPES_RESOURCE_URI
 *
 * @description
 * Resource URI of the navigation entry types REST service.
 */
const NAVIGATION_MANAGEMENT_ENTRY_TYPES_RESOURCE_URI = '/cmswebservices/v1/navigationentrytypes';
/**
 * @ngdoc object
 * @name resourceLocationsModule.CONTEXTUAL_PAGES_RESTRICTIONS_RESOURCE_URI
 *
 * @description
 * Resource URI of the pages restrictions REST service, with placeholders to be replaced by the currently selected catalog version.
 */
const CONTEXTUAL_PAGES_RESTRICTIONS_RESOURCE_URI = `/cmswebservices/v1/sites/${smarteditcommons.PAGE_CONTEXT_SITE_ID}/catalogs/${PAGE_CONTEXT_CATALOG}/versions/${PAGE_CONTEXT_CATALOG_VERSION}/pagesrestrictions`;
/**
 * @ngdoc object
 * @name resourceLocationsModule.PAGES_RESTRICTIONS_RESOURCE_URI
 *
 * @description
 * Resource URI of the pages restrictions REST service, with placeholders to be replaced by the currently selected catalog version.
 */
const PAGES_RESTRICTIONS_RESOURCE_URI = '/cmswebservices/v1/sites/:siteUID/catalogs/:catalogId/versions/:catalogVersion/pagesrestrictions';
/**
 * @ngdoc object
 * @name resourceLocationsModule.RESTRICTION_TYPES_URI
 *
 * @description
 * Resource URI of the restriction types REST service.
 */
const RESTRICTION_TYPES_URI = '/cmswebservices/v1/restrictiontypes';
/**
 * @ngdoc object
 * @name resourceLocationsModule.RESTRICTION_TYPES_URI
 *
 * @description
 * Resource URI of the pageTypes-restrictionTypes relationship REST service.
 */
const PAGE_TYPES_RESTRICTION_TYPES_URI = '/cmswebservices/v1/pagetypesrestrictiontypes';
/**
 * @ngdoc object
 * @name resourceLocationsModule.PAGE_TYPES_URI
 *
 * @description
 * Resource URI of the page types REST service.
 */
const PAGE_TYPES_URI = '/cmswebservices/v1/pagetypes';
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:GET_PAGE_SYNCHRONIZATION_RESOURCE_URI
 *
 * @description
 * Resource URI to retrieve the full synchronization status of page related items
 */
const GET_PAGE_SYNCHRONIZATION_RESOURCE_URI = `/cmssmarteditwebservices/v1/sites/${smarteditcommons.PAGE_CONTEXT_SITE_ID}/catalogs/${PAGE_CONTEXT_CATALOG}/versions/${PAGE_CONTEXT_CATALOG_VERSION}/synchronizations/versions/:target/pages/:pageUid`;
/**
 * @ngdoc object
 * @name resourceLocationsModule.object:POST_PAGE_SYNCHRONIZATION_RESOURCE_URI
 *
 * @description
 * Resource URI to perform synchronization of page related items
 */
const POST_PAGE_SYNCHRONIZATION_RESOURCE_URI = `/cmssmarteditwebservices/v1/sites/${CONTEXT_SITE_ID}/catalogs/${CONTEXT_CATALOG}/versions/${CONTEXT_CATALOG_VERSION}/synchronizations/versions/:target`;

/**
 * Rest Service to retrieve page content slots for components.
 */
class IPageContentSlotsComponentsRestService {
    /**
     * Clears the slotId - components list map in the cache.
     */
    clearCache() {
        'proxyFunction';
    }
    /**
     * Retrieves a list of pageContentSlotsComponents associated to a page and Converts the list of pageContentSlotsComponents to slotId - components list map.
     * If the map is already stored in the cache, it will return the cache info.
     *
     * @param pageUid The uid of the page to retrieve the content slots to components map.
     * @return A promise that resolves to slotId - components list map.
     */
    getSlotsToComponentsMapForPageUid(pageUid) {
        'proxyFunction';
        return null;
    }
    /**
     * Retrieves a list of all components for a given slot which is part of the page being loaded.
     * It returns all the components irrespective of their visibility.
     *
     * @param slotUuid The uid of the slot to retrieve the list of components.
     * @return A promise that resolves to components list.
     */
    getComponentsForSlot(slotUuid) {
        'proxyFunction';
        return null;
    }
}

/* @ngInject */ exports.SynchronizationResourceService = class /* @ngInject */ SynchronizationResourceService {
    constructor(restServiceFactory) {
        this.restServiceFactory = restServiceFactory;
    }
    getPageSynchronizationGetRestService(uriContext) {
        const getURI = new smarteditcommons.URIBuilder(GET_PAGE_SYNCHRONIZATION_RESOURCE_URI)
            .replaceParams(uriContext)
            .build();
        return this.restServiceFactory.get(getURI);
    }
    getPageSynchronizationPostRestService(uriContext) {
        const postURI = new smarteditcommons.URIBuilder(POST_PAGE_SYNCHRONIZATION_RESOURCE_URI)
            .replaceParams(uriContext)
            .build();
        return this.restServiceFactory.get(postURI);
    }
};
exports.SynchronizationResourceService.$inject = ["restServiceFactory"];
/* @ngInject */ exports.SynchronizationResourceService = __decorate([
    smarteditcommons.SeDowngradeService(),
    __metadata("design:paramtypes", [smarteditcommons.IRestServiceFactory])
], /* @ngInject */ exports.SynchronizationResourceService);

/**
 * Service which manages component types and items.
 */
/* @ngInject */ exports.ComponentService = class /* @ngInject */ ComponentService {
    constructor(restServiceFactory, cmsitemsRestService, pageInfoService, pageContentSlotsComponentsRestService) {
        this.restServiceFactory = restServiceFactory;
        this.cmsitemsRestService = cmsitemsRestService;
        this.pageInfoService = pageInfoService;
        this.pageContentSlotsComponentsRestService = pageContentSlotsComponentsRestService;
        this.pageComponentTypesRestServiceURI = '/cmssmarteditwebservices/v1/catalogs/:catalogId/versions/:catalogVersion/pages/:pageId/types';
        this.pageComponentTypesRestService = this.restServiceFactory.get(this.pageComponentTypesRestServiceURI);
        this.restServiceForAddExistingComponent = this.restServiceFactory.get(PAGES_CONTENT_SLOT_COMPONENT_RESOURCE_URI);
    }
    /**
     * Fetches all component types that are applicable to the current page.
     *
     * @returns A promise resolving to a page of component types applicable to the current page.
     */
    getSupportedComponentTypesForCurrentPage(payload) {
        return this.pageComponentTypesRestService.get(payload);
    }
    /**
     * Given a component info and the component payload, a new componentItem is created and added to a slot
     */
    createNewComponent(componentInfo, componentPayload) {
        const payload = {
            name: componentInfo.name,
            slotId: componentInfo.targetSlotId,
            pageId: componentInfo.pageId,
            position: componentInfo.position,
            typeCode: componentInfo.componentType,
            itemtype: componentInfo.componentType,
            catalogVersion: componentInfo.catalogVersionUuid,
            uid: '',
            uuid: ''
        };
        // TODO: consider refactor. Remove the if statement, rely on TypeScript.
        if (typeof componentPayload === 'object') {
            for (const property in componentPayload) {
                if (componentPayload.hasOwnProperty(property)) {
                    payload[property] = componentPayload[property];
                }
            }
        }
        else if (componentPayload) {
            throw new Error(`ComponentService.createNewComponent() - Illegal componentPayload - [${componentPayload}]`);
        }
        return this.cmsitemsRestService.create(payload);
    }
    /**
     * Given a component payload related to an existing component, it will be updated with the new supplied values.
     */
    updateComponent(componentPayload) {
        return this.cmsitemsRestService.update(componentPayload);
    }
    /**
     * Add an existing component item to a slot.
     *
     * @param pageId used to identify the page containing the slot in the current template.
     * @param componentId used to identify the existing component which will be added to the slot.
     * @param slotId used to identify the slot in the current template.
     * @param position used to identify the position in the slot in the current template.
     */
    addExistingComponent(pageId, componentId, slotId, position) {
        return this.restServiceForAddExistingComponent.save({
            pageId,
            slotId,
            componentId,
            position
        });
    }
    /**
     * Load a component identified by its id.
     */
    loadComponentItem(id) {
        return this.cmsitemsRestService.getById(id);
    }
    /**
     * All existing component items for the provided content catalog are retrieved in the form of pages
     * used for pagination especially when the result set is very large.
     *
     * E.g. Add Components -> Saved Components.
     *
     * @returns A promise resolving to a page of component items retrieved from the provided catalog version.
     */
    loadPagedComponentItemsByCatalogVersion(payload) {
        const requestParams = {
            pageSize: payload.pageSize,
            currentPage: payload.page,
            mask: payload.mask,
            sort: 'name',
            typeCode: 'AbstractCMSComponent',
            catalogId: payload.catalogId,
            catalogVersion: payload.catalogVersion,
            itemSearchParams: ''
        };
        return this.cmsitemsRestService.get(requestParams);
    }
    /**
     * Returns slot IDs for the given componentUuid.
     *
     * E.g. Edit Component on Storefront and click Save button.
     */
    getSlotsForComponent(componentUuid) {
        return __awaiter(this, void 0, void 0, function* () {
            const allSlotsToComponents = yield this.getContentSlotsForComponents();
            return Object.entries(allSlotsToComponents)
                .filter(([, components]) => components.find((component) => component.uuid === componentUuid))
                .map(([slotId]) => slotId);
        });
    }
    getContentSlotsForComponents() {
        return __awaiter(this, void 0, void 0, function* () {
            const pageId = yield this.pageInfoService.getPageUID();
            return yield this.pageContentSlotsComponentsRestService.getSlotsToComponentsMapForPageUid(pageId);
        });
    }
};
exports.ComponentService.$inject = ["restServiceFactory", "cmsitemsRestService", "pageInfoService", "pageContentSlotsComponentsRestService"];
__decorate([
    smarteditcommons.Cached({ actions: [smarteditcommons.rarelyChangingContent], tags: [smarteditcommons.pageChangeEvictionTag] }),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [Object]),
    __metadata("design:returntype", Promise)
], /* @ngInject */ exports.ComponentService.prototype, "getSupportedComponentTypesForCurrentPage", null);
/* @ngInject */ exports.ComponentService = __decorate([
    smarteditcommons.SeDowngradeService(),
    __metadata("design:paramtypes", [smarteditcommons.IRestServiceFactory,
        smarteditcommons.CmsitemsRestService,
        smarteditcommons.IPageInfoService,
        IPageContentSlotsComponentsRestService])
], /* @ngInject */ exports.ComponentService);

/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
(function (SlotStatus) {
    SlotStatus["TEMPLATE"] = "TEMPLATE";
    SlotStatus["PAGE"] = "PAGE";
    SlotStatus["OVERRIDE"] = "OVERRIDE";
})(exports.SlotStatus || (exports.SlotStatus = {}));

/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
(function (JOB_STATUS) {
    JOB_STATUS["RUNNING"] = "RUNNING";
    JOB_STATUS["ERROR"] = "ERROR";
    JOB_STATUS["FAILURE"] = "FAILURE";
    JOB_STATUS["FINISHED"] = "FINISHED";
    JOB_STATUS["UNKNOWN"] = "UNKNOWN";
    JOB_STATUS["ABORTED"] = "ABORTED";
    JOB_STATUS["PENDING"] = "PENDING";
})(exports.JOB_STATUS || (exports.JOB_STATUS = {}));

/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
(function (StructureTypeCategory) {
    StructureTypeCategory["COMPONENT"] = "COMPONENT";
    StructureTypeCategory["PREVIEW"] = "PREVIEW";
    StructureTypeCategory["PAGE"] = "PAGE";
    StructureTypeCategory["RESTRICTION"] = "RESTRICTION";
})(exports.StructureTypeCategory || (exports.StructureTypeCategory = {}));

/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/**
 * Constant containing the different sync statuses.
 */
const DEFAULT_SYNCHRONIZATION_STATUSES = {
    UNAVAILABLE: 'UNAVAILABLE',
    IN_SYNC: 'IN_SYNC',
    NOT_SYNC: 'NOT_SYNC',
    IN_PROGRESS: 'IN_PROGRESS',
    SYNC_FAILED: 'SYNC_FAILED'
};
/**
 * Constant containing polling related values
 * * `SLOW_POLLING_TIME` : the slow polling time in milliseconds
 * * `FAST_POLLING_TIME` : the slow polling time in milliseconds
 * * `SPEED_UP` : event used to speed up polling (`syncPollingSpeedUp`)
 * * `SLOW_DOWN` : event used to slow down polling (`syncPollingSlowDown`)
 * * `FAST_FETCH` : event used to trigger a sync fetch (`syncFastFetch`)
 * * `FETCH_SYNC_STATUS_ONCE`: event used to trigger a one time sync (`fetchSyncStatusOnce`)
 *
 */
const DEFAULT_SYNCHRONIZATION_POLLING = {
    SLOW_POLLING_TIME: 20000,
    FAST_POLLING_TIME: 4000,
    SPEED_UP: 'syncPollingSpeedUp',
    SLOW_DOWN: 'syncPollingSlowDown',
    FAST_FETCH: 'syncFastFetch',
    FETCH_SYNC_STATUS_ONCE: 'fetchSyncStatusOnce'
};
/**
 * Constant containing synchronization events.
 */
const DEFAULT_SYNCHRONIZATION_EVENT = {
    CATALOG_SYNCHRONIZED: 'CATALOG_SYNCHRONIZED_EVENT'
};

(function (SynchronizationStatus) {
    SynchronizationStatus["Unavailable"] = "UNAVAILABLE";
    SynchronizationStatus["InSync"] = "IN_SYNC";
    SynchronizationStatus["NotSync"] = "NOT_SYNC";
    SynchronizationStatus["InProgress"] = "IN_PROGRESS";
    SynchronizationStatus["SyncFailed"] = "SYNC_FAILED";
})(exports.SynchronizationStatus || (exports.SynchronizationStatus = {}));

class SynchronizationUtils {
    /**
     * Verifies whether the sync status item is synchronized.
     */
    isInSync(item) {
        return item.status === exports.SynchronizationStatus.InSync;
    }
    /**
     * Verifies whether the sync status item is not sync.
     */
    isInNotSync(item) {
        return item.status === exports.SynchronizationStatus.NotSync;
    }
    /**
     * Verifies whether the item has failed synchronization status.
     */
    isSyncInFailed(item) {
        return item.status === exports.SynchronizationStatus.SyncFailed;
    }
    isSyncInProgress(item) {
        return item.status === exports.SynchronizationStatus.InProgress;
    }
    /**
     * Verifies whether the item is external.
     */
    isExternalItem(syncStatusItem) {
        return !!syncStatusItem.isExternal;
    }
}
const synchronizationUtils = new SynchronizationUtils();

/**
 * Queue of items to be synchronized.
 */
class SyncQueue {
    constructor() {
        this.items = [];
    }
    getItems() {
        return this.items;
    }
    addItems(items) {
        this.items = this.items.concat(items);
    }
    removeItem(item) {
        this.items = this.items.filter((itemId) => itemId !== item.itemId);
    }
    itemExists(item) {
        return this.getItems().includes(item.itemId);
    }
    isEmpty() {
        return this.getItems().length === 0;
    }
    hasAtLeastOneItem() {
        return this.getItems().length > 0;
    }
    emptyItems() {
        this.items = [];
    }
}

window.__smartedit__.addDecoratorPayload("Component", "SynchronizationPanelComponent", {
    selector: 'se-synchronization-panel',
    template: `<div class="se-sync-panel"><se-message *ngIf="message" [type]="message.type"><ng-container se-message-description>{{ message.description }}</ng-container></se-message><div class="se-sync-panel__sync-info" [style.visibility]="showItemList ? 'visible': 'hidden'"><se-spinner [isSpinning]="isLoading"></se-spinner><se-synchronization-panel-item *ngFor="let item of getAllItems(); let i = index" class="se-sync-panel__row" [index]="i" [item]="item" [rootItem]="getRootItem()" [selectAllLabel]="selectAllLabel" [disableList]="disableList" [disableItem]="api.disableItem" (selectionChange)="selectionChange($event)"></se-synchronization-panel-item></div><div class="se-sync-panel__footer" *ngIf="showFooter"><button class="se-sync-panel__sync-btn fd-button--emphasized" [disabled]="isSyncButtonDisabled()" (click)="syncItems()" translate="se.cms.actionitem.page.sync"></button></div></div>`,
    styles: [`.se-sync-panel__sync-info{max-height:300px;overflow-y:auto}.se-sync-panel__row{display:flex;flex-direction:row;align-items:center;justify-content:space-between;padding:0 20px;height:40px;border-bottom:1px solid #d9d9d9}.se-sync-panel__row:first-child{height:50px}.se-sync-panel__row:last-child{border-bottom:none}.se-sync-panel__footer{padding:20px;border-top:1px solid #d9d9d9;display:flex;flex-direction:row;align-items:center;justify-content:flex-end}.se-sync-panel__sync-btn{text-transform:capitalize;padding:0 20px;margin-left:8px}`]
});
/* @ngInject */ exports.SynchronizationPanelComponent = class /* @ngInject */ SynchronizationPanelComponent {
    constructor(waitDialogService, logService, crossFrameEventService, systemEventService, timerService, alertService, translateService, sharedDataService, catalogService, userTrackingService) {
        this.waitDialogService = waitDialogService;
        this.logService = logService;
        this.crossFrameEventService = crossFrameEventService;
        this.systemEventService = systemEventService;
        this.timerService = timerService;
        this.alertService = alertService;
        this.translateService = translateService;
        this.sharedDataService = sharedDataService;
        this.catalogService = catalogService;
        this.userTrackingService = userTrackingService;
        this.getApi = new core.EventEmitter();
        this.selectedItemsUpdate = new core.EventEmitter();
        this.syncStatusReady = new core.EventEmitter();
        this.showFooter = true;
        this.showItemList = true;
        this.message = null;
        this.disableList = false;
        this.isLoading = false;
        this.SYNC_POLLING_SPEED_PREFIX = 'syncPanel-';
        this.syncQueue = new SyncQueue();
        this.api = {
            selectAll: () => {
                if (!this.isRootItemExist()) {
                    throw new Error("Synchronization status is not available. The 'selectAll' function should be used with 'onSyncStatusReady' event.");
                }
                this.toogleRootItem(true);
            },
            displayItemList: (visible) => {
                this.showItemList = visible;
            },
            disableItemList: (disableList) => {
                this.disableList = disableList;
            },
            setMessage: (msgConfig) => {
                this.message = msgConfig;
            },
            disableItem: null
        };
    }
    ngOnInit() {
        this.getApi.emit(this.api);
        this.unsubscribeFastFetch = this.crossFrameEventService.subscribe(DEFAULT_SYNCHRONIZATION_POLLING.FAST_FETCH, (id, data) => this.fetchSyncStatus(data));
        this.fetchSyncStatus();
        this.resynchTimer = this.timerService.createTimer(() => this.fetchSyncStatus(), DEFAULT_SYNCHRONIZATION_POLLING.SLOW_POLLING_TIME);
        this.resynchTimer.start();
    }
    ngOnDestroy() {
        const finalizeTimer = this.timerService.createTimer(() => {
            if (this.syncQueue.isEmpty()) {
                this.resynchTimer.teardown();
                this.unsubscribeFastFetch();
                this.systemEventService.publishAsync(DEFAULT_SYNCHRONIZATION_POLLING.SLOW_DOWN, this.SYNC_POLLING_SPEED_PREFIX + this.itemId);
                this.toggleWaitModal(false);
                finalizeTimer.teardown();
            }
            else {
                this.toggleWaitModal(true);
            }
        }, 200);
        finalizeTimer.start();
    }
    syncItems() {
        const selectedItemPayloads = this.getSelectedItemPayloads();
        const selectedItemPayloadIds = selectedItemPayloads.map((syncItemPayload) => syncItemPayload.itemId);
        this.userTrackingService.trackingUserAction(smarteditcommons.USER_TRACKING_FUNCTIONALITY.TOOL_BAR, 'Sync');
        this.syncQueue.addItems(selectedItemPayloadIds);
        if (this.atLeastOneSelectedItemExists()) {
            this.toggleWaitModal(true);
            return this.performSync(selectedItemPayloads).then(() => {
                this.speedUpPolling();
            }, () => {
                this.logService.warn('[synchronizationPanel] - Could not perform synchronization.');
                this.toggleWaitModal(false);
                this.syncQueue.emptyItems();
            });
        }
        else {
            return Promise.resolve();
        }
    }
    selectionChange(index) {
        if (index === 0) {
            this.toggleAllDependentItems();
        }
        this.saveCurrentlySelectedItemsInStorage();
        this.selectedItemsUpdate.emit(this.getSelectedItems());
    }
    isSyncButtonDisabled() {
        return this.disableList || this.noSelectedItems() || this.syncQueue.hasAtLeastOneItem();
    }
    fetchSyncStatus(eventData) {
        return __awaiter(this, void 0, void 0, function* () {
            if (eventData && eventData.itemId !== this.itemId) {
                return;
            }
            this.isLoading = true;
            const rootItem = yield this.getSyncStatus(this.itemId);
            this.setRootItem(rootItem);
            this.restoreSelectionAfterFetchingUpdatedItems();
            this.markExternalItems();
            this.showSyncErrors();
            this.updateSyncQueue();
            this.setExternalItemsCatalogVersionName();
            if (this.syncQueue.isEmpty()) {
                this.slowDownPolling();
                this.toggleWaitModal(false);
            }
            this.syncStatusReady.emit(this.getRootItem());
            this.isLoading = false;
        });
    }
    markExternalItems() {
        const rootItem = this.getRootItem();
        const rootItemCatalogVersion = rootItem.catalogVersionUuid;
        const dependentItems = this.getDependentItems();
        dependentItems.forEach((item) => {
            item.isExternal = item.catalogVersionUuid !== rootItemCatalogVersion;
        });
    }
    getAllItems() {
        return this.isRootItemExist() ? [this.getRootItem(), ...this.getDependentItems()] : [];
    }
    setExternalItemsCatalogVersionName() {
        return __awaiter(this, void 0, void 0, function* () {
            const experience = yield this.getCurrentExperience();
            const allItems = this.getAllItems();
            const externalItems = allItems.filter((item) => synchronizationUtils.isExternalItem(item));
            const catalogVersionPromises = externalItems.map((externalItem) => new Promise((resolve) => __awaiter(this, void 0, void 0, function* () {
                const { catalogName } = yield this.catalogService.getCatalogVersionByUuid(externalItem.catalogVersionUuid, experience.siteDescriptor.uid);
                externalItem.catalogVersionName = catalogName;
                resolve(externalItem);
            })));
            yield Promise.all(catalogVersionPromises);
        });
    }
    slowDownPolling() {
        this.resynchTimer.restart(DEFAULT_SYNCHRONIZATION_POLLING.SLOW_POLLING_TIME);
        this.systemEventService.publishAsync(DEFAULT_SYNCHRONIZATION_POLLING.SLOW_DOWN, this.SYNC_POLLING_SPEED_PREFIX + this.itemId);
    }
    speedUpPolling() {
        this.resynchTimer.restart(DEFAULT_SYNCHRONIZATION_POLLING.FAST_POLLING_TIME);
        this.systemEventService.publishAsync(DEFAULT_SYNCHRONIZATION_POLLING.SPEED_UP, this.SYNC_POLLING_SPEED_PREFIX + this.itemId);
    }
    setRootItem(rootItem) {
        this.rootItem = rootItem;
    }
    getRootItem() {
        return this.rootItem;
    }
    isRootItemExist() {
        return this.getRootItem() != null;
    }
    getDependentItems() {
        return this.isRootItemExist() ? this.getRootItem().selectedDependencies : [];
    }
    getCurrentExperience() {
        return this.sharedDataService.get(smarteditcommons.EXPERIENCE_STORAGE_KEY);
    }
    getSelectedItemPayloads() {
        return this.getSelectedItems().map(({ itemId, itemType }) => ({
            itemId,
            itemType
        }));
    }
    getSelectedItems() {
        return this.getAllItems().filter((item) => item.selected);
    }
    toogleRootItem(selected) {
        if (this.isRootItemExist()) {
            const rootItem = this.getRootItem();
            rootItem.selected = selected;
            this.selectionChange(0);
        }
    }
    toggleAllDependentItems() {
        this.getDependentItems()
            .filter((item) => !synchronizationUtils.isInSync(item))
            .filter((item) => !synchronizationUtils.isExternalItem(item))
            .forEach((item) => {
            item.selected = this.getRootItem().selected;
        });
    }
    toggleWaitModal(show) {
        if (show) {
            this.waitDialogService.showWaitModal('se.sync.synchronizing');
        }
        else {
            this.waitDialogService.hideWaitModal();
        }
    }
    saveCurrentlySelectedItemsInStorage() {
        this.selectedItemsStorage = this.getSelectedItems();
    }
    getSelectedItemsFromStorage() {
        return this.selectedItemsStorage || [];
    }
    restoreSelectionAfterFetchingUpdatedItems() {
        const selectedItemsFromStorage = this.getSelectedItemsFromStorage();
        const selectedItemsFromStorageIds = selectedItemsFromStorage.map((item) => item.itemId);
        this.getAllItems()
            .filter((item) => !synchronizationUtils.isInSync(item))
            .filter((item) => selectedItemsFromStorageIds.indexOf(item.itemId) > -1)
            .forEach((item) => (item.selected = true));
    }
    updateSyncQueue() {
        const syncQueueWasNotEmpty = this.syncQueue.hasAtLeastOneItem();
        const allItems = this.getAllItems();
        allItems
            .filter((item) => this.syncQueue.itemExists(item))
            .filter((item) => !(synchronizationUtils.isSyncInProgress(item) ||
            synchronizationUtils.isInNotSync(item)))
            .forEach((item) => this.syncQueue.removeItem(item));
        allItems
            .filter((item) => !this.syncQueue.itemExists(item))
            .filter((item) => synchronizationUtils.isSyncInProgress(item))
            .forEach((item) => this.syncQueue.addItems([item.itemId]));
        const syncQueueIsNowEmpty = this.syncQueue.isEmpty();
        if (syncQueueWasNotEmpty && syncQueueIsNowEmpty) {
            this.systemEventService.publishAsync(smarteditcommons.EVENT_CONTENT_CATALOG_UPDATE);
        }
    }
    showSyncErrors() {
        const itemsInErrors = this.getAllItems()
            .filter((item) => this.syncQueue.itemExists(item))
            .filter((item) => synchronizationUtils.isSyncInFailed(item))
            .map((item) => item.itemId);
        if (itemsInErrors.length > 0) {
            this.alertService.showDanger({
                message: this.translateService.instant('se.cms.synchronization.panel.failure.message', {
                    items: itemsInErrors.join(' ')
                })
            });
        }
    }
    atLeastOneSelectedItemExists() {
        return this.getSelectedItems().length > 0;
    }
    noSelectedItems() {
        return this.getSelectedItems().length === 0;
    }
};
exports.SynchronizationPanelComponent.$inject = ["waitDialogService", "logService", "crossFrameEventService", "systemEventService", "timerService", "alertService", "translateService", "sharedDataService", "catalogService", "userTrackingService"];
__decorate([
    core.Input(),
    __metadata("design:type", String)
], /* @ngInject */ exports.SynchronizationPanelComponent.prototype, "itemId", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", String)
], /* @ngInject */ exports.SynchronizationPanelComponent.prototype, "selectAllLabel", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Function)
], /* @ngInject */ exports.SynchronizationPanelComponent.prototype, "getSyncStatus", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Function)
], /* @ngInject */ exports.SynchronizationPanelComponent.prototype, "performSync", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Boolean)
], /* @ngInject */ exports.SynchronizationPanelComponent.prototype, "showFooter", void 0);
__decorate([
    core.Output(),
    __metadata("design:type", Object)
], /* @ngInject */ exports.SynchronizationPanelComponent.prototype, "getApi", void 0);
__decorate([
    core.Output(),
    __metadata("design:type", Object)
], /* @ngInject */ exports.SynchronizationPanelComponent.prototype, "selectedItemsUpdate", void 0);
__decorate([
    core.Output(),
    __metadata("design:type", Object)
], /* @ngInject */ exports.SynchronizationPanelComponent.prototype, "syncStatusReady", void 0);
/* @ngInject */ exports.SynchronizationPanelComponent = __decorate([
    smarteditcommons.SeDowngradeComponent(),
    core.Component({
        selector: 'se-synchronization-panel',
        template: `<div class="se-sync-panel"><se-message *ngIf="message" [type]="message.type"><ng-container se-message-description>{{ message.description }}</ng-container></se-message><div class="se-sync-panel__sync-info" [style.visibility]="showItemList ? 'visible': 'hidden'"><se-spinner [isSpinning]="isLoading"></se-spinner><se-synchronization-panel-item *ngFor="let item of getAllItems(); let i = index" class="se-sync-panel__row" [index]="i" [item]="item" [rootItem]="getRootItem()" [selectAllLabel]="selectAllLabel" [disableList]="disableList" [disableItem]="api.disableItem" (selectionChange)="selectionChange($event)"></se-synchronization-panel-item></div><div class="se-sync-panel__footer" *ngIf="showFooter"><button class="se-sync-panel__sync-btn fd-button--emphasized" [disabled]="isSyncButtonDisabled()" (click)="syncItems()" translate="se.cms.actionitem.page.sync"></button></div></div>`,
        styles: [`.se-sync-panel__sync-info{max-height:300px;overflow-y:auto}.se-sync-panel__row{display:flex;flex-direction:row;align-items:center;justify-content:space-between;padding:0 20px;height:40px;border-bottom:1px solid #d9d9d9}.se-sync-panel__row:first-child{height:50px}.se-sync-panel__row:last-child{border-bottom:none}.se-sync-panel__footer{padding:20px;border-top:1px solid #d9d9d9;display:flex;flex-direction:row;align-items:center;justify-content:flex-end}.se-sync-panel__sync-btn{text-transform:capitalize;padding:0 20px;margin-left:8px}`]
    }),
    __metadata("design:paramtypes", [smarteditcommons.IWaitDialogService,
        smarteditcommons.LogService,
        smarteditcommons.CrossFrameEventService,
        smarteditcommons.SystemEventService,
        smarteditcommons.TimerService,
        smarteditcommons.IAlertService,
        core$1.TranslateService,
        smarteditcommons.ISharedDataService,
        smarteditcommons.ICatalogService,
        smarteditcommons.UserTrackingService])
], /* @ngInject */ exports.SynchronizationPanelComponent);

window.__smartedit__.addDecoratorPayload("Component", "SynchronizationPanelItemComponent", {
    selector: 'se-synchronization-panel-item',
    template: `<div class="se-sync-panel-item-checkbox fd-form__item"><input *ngIf="!item.isExternal" type="checkbox" [id]="'sync-info__checkbox_' + index" class="se-sync-panel-item-checkbox__field fd-form__control" [(ngModel)]="item.selected" (ngModelChange)="onSelectionChange()" [attr.disabled]="isItemDisabled() ? true : null"/> <label *ngIf="index === 0" [for]="'sync-info__checkbox_' + index" class="se-sync-panel-item-checkbox__label se-sync-panel-item-checkbox__label--select-all fd-form__label" [title]="getSelectAllLabel() | translate" [translate]="getSelectAllLabel()"></label> <label *ngIf="index !== 0 && !item.isExternal" [for]="'sync-info__checkbox_' + index" class="se-sync-panel-item-checkbox__label fd-form__label" [title]="item.name | translate" [translate]="item.name"></label><se-tooltip *ngIf="index !== 0 && item.isExternal" [isChevronVisible]="true" [triggers]="['mouseenter', 'mouseleave']"><label se-tooltip-trigger [for]="'sync-info__checkbox_' + index" class="se-sync-panel-item-checkbox__label fd-form__label" [translate]="item.name"></label><div se-tooltip-body translate="se.cms.synchronization.slot.external.component"></div></se-tooltip></div><span *ngIf="showPopoverOverSyncIcon()"><se-tooltip [isChevronVisible]="true" [appendTo]="'body'" [placement]="'left'" [triggers]="['mouseenter', 'mouseleave']" [title]="getInfoTitle()" class="pull-right se-sync-panel-item-info-icon" [ngClass]="{ 'se-sync-panel--icon-globe': item.isExternal }"><ng-container *ngIf="!item.isExternal" se-tooltip-trigger><ng-container *ngTemplateOutlet="syncInfoIcon"></ng-container></ng-container><span *ngIf="item.isExternal" class="sap-icon--globe" se-tooltip-trigger></span><div se-tooltip-body><ng-container *ngIf="!item.isExternal"><div *ngFor="let dependentItem of item.dependentItemTypesOutOfSync">{{ dependentItem.i18nKey | translate }}</div></ng-container><div *ngIf="item.isExternal">{{ item.catalogVersionName | seL10n | async }}</div></div></se-tooltip></span><span *ngIf="!showPopoverOverSyncIcon()" class="pull-right se-sync-panel-item-info-icon"><ng-container *ngTemplateOutlet="syncInfoIcon"></ng-container></span><ng-template #syncInfoIcon><span [attr.status]="item.status" class="se-sync-panel-item-info-icon__icon" [ngClass]="{
                'sap-icon--accept': isInSync(),
                'sap-icon--message-warning': !isInSync()
            }"></span></ng-template>`,
    styles: [`.se-sync-panel-item-checkbox{display:flex;flex-direction:row;align-items:center;margin:0!important}.se-sync-panel-item-checkbox__field{margin:0}.se-sync-panel-item-checkbox__label{text-overflow:ellipsis;white-space:nowrap;overflow:hidden;word-break:break-all;max-width:190px!important;margin:0!important;padding-left:8px;color:#32363a;text-transform:capitalize}.se-sync-panel-item-checkbox__label--select-all{font-weight:700!important}.se-sync-panel-item-info-icon{font-size:1.1428571429rem;line-height:1.25;font-weight:400}.se-sync-panel-item-info-icon__icon.sap-icon--accept{font-size:1.1428571429rem;line-height:1.25;font-weight:400;color:#0a7e3e}.se-sync-panel-item-info-icon__icon.sap-icon--message-warning{font-size:1.1428571429rem;line-height:1.25;font-weight:400;color:#e9730c}`]
});
/* @ngInject */ exports.SynchronizationPanelItemComponent = class /* @ngInject */ SynchronizationPanelItemComponent {
    constructor() {
        this.selectionChange = new core.EventEmitter();
    }
    getSelectAllLabel() {
        return this.selectAllLabel || 'se.cms.synchronization.page.select.all.slots';
    }
    isItemDisabled() {
        var _a;
        if (this.disableList || (this.disableItem && this.disableItem(this.item))) {
            return true;
        }
        return ((this.item !== this.rootItem && !!((_a = this.rootItem) === null || _a === void 0 ? void 0 : _a.selected)) ||
            synchronizationUtils.isInSync(this.item));
    }
    showPopoverOverSyncIcon() {
        var _a;
        return (((_a = this.item.dependentItemTypesOutOfSync) === null || _a === void 0 ? void 0 : _a.length) > 0 ||
            synchronizationUtils.isExternalItem(this.item));
    }
    getInfoTitle() {
        return !synchronizationUtils.isExternalItem(this.item)
            ? 'se.cms.synchronization.panel.update.title'
            : '';
    }
    isInSync() {
        return synchronizationUtils.isInSync(this.item);
    }
    onSelectionChange() {
        this.selectionChange.emit(this.index);
    }
};
__decorate([
    core.Input(),
    __metadata("design:type", Number)
], /* @ngInject */ exports.SynchronizationPanelItemComponent.prototype, "index", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ exports.SynchronizationPanelItemComponent.prototype, "item", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ exports.SynchronizationPanelItemComponent.prototype, "rootItem", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", String)
], /* @ngInject */ exports.SynchronizationPanelItemComponent.prototype, "selectAllLabel", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Boolean)
], /* @ngInject */ exports.SynchronizationPanelItemComponent.prototype, "disableList", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Function)
], /* @ngInject */ exports.SynchronizationPanelItemComponent.prototype, "disableItem", void 0);
__decorate([
    core.Output(),
    __metadata("design:type", Object)
], /* @ngInject */ exports.SynchronizationPanelItemComponent.prototype, "selectionChange", void 0);
/* @ngInject */ exports.SynchronizationPanelItemComponent = __decorate([
    smarteditcommons.SeDowngradeComponent(),
    core.Component({
        selector: 'se-synchronization-panel-item',
        template: `<div class="se-sync-panel-item-checkbox fd-form__item"><input *ngIf="!item.isExternal" type="checkbox" [id]="'sync-info__checkbox_' + index" class="se-sync-panel-item-checkbox__field fd-form__control" [(ngModel)]="item.selected" (ngModelChange)="onSelectionChange()" [attr.disabled]="isItemDisabled() ? true : null"/> <label *ngIf="index === 0" [for]="'sync-info__checkbox_' + index" class="se-sync-panel-item-checkbox__label se-sync-panel-item-checkbox__label--select-all fd-form__label" [title]="getSelectAllLabel() | translate" [translate]="getSelectAllLabel()"></label> <label *ngIf="index !== 0 && !item.isExternal" [for]="'sync-info__checkbox_' + index" class="se-sync-panel-item-checkbox__label fd-form__label" [title]="item.name | translate" [translate]="item.name"></label><se-tooltip *ngIf="index !== 0 && item.isExternal" [isChevronVisible]="true" [triggers]="['mouseenter', 'mouseleave']"><label se-tooltip-trigger [for]="'sync-info__checkbox_' + index" class="se-sync-panel-item-checkbox__label fd-form__label" [translate]="item.name"></label><div se-tooltip-body translate="se.cms.synchronization.slot.external.component"></div></se-tooltip></div><span *ngIf="showPopoverOverSyncIcon()"><se-tooltip [isChevronVisible]="true" [appendTo]="'body'" [placement]="'left'" [triggers]="['mouseenter', 'mouseleave']" [title]="getInfoTitle()" class="pull-right se-sync-panel-item-info-icon" [ngClass]="{ 'se-sync-panel--icon-globe': item.isExternal }"><ng-container *ngIf="!item.isExternal" se-tooltip-trigger><ng-container *ngTemplateOutlet="syncInfoIcon"></ng-container></ng-container><span *ngIf="item.isExternal" class="sap-icon--globe" se-tooltip-trigger></span><div se-tooltip-body><ng-container *ngIf="!item.isExternal"><div *ngFor="let dependentItem of item.dependentItemTypesOutOfSync">{{ dependentItem.i18nKey | translate }}</div></ng-container><div *ngIf="item.isExternal">{{ item.catalogVersionName | seL10n | async }}</div></div></se-tooltip></span><span *ngIf="!showPopoverOverSyncIcon()" class="pull-right se-sync-panel-item-info-icon"><ng-container *ngTemplateOutlet="syncInfoIcon"></ng-container></span><ng-template #syncInfoIcon><span [attr.status]="item.status" class="se-sync-panel-item-info-icon__icon" [ngClass]="{
                'sap-icon--accept': isInSync(),
                'sap-icon--message-warning': !isInSync()
            }"></span></ng-template>`,
        styles: [`.se-sync-panel-item-checkbox{display:flex;flex-direction:row;align-items:center;margin:0!important}.se-sync-panel-item-checkbox__field{margin:0}.se-sync-panel-item-checkbox__label{text-overflow:ellipsis;white-space:nowrap;overflow:hidden;word-break:break-all;max-width:190px!important;margin:0!important;padding-left:8px;color:#32363a;text-transform:capitalize}.se-sync-panel-item-checkbox__label--select-all{font-weight:700!important}.se-sync-panel-item-info-icon{font-size:1.1428571429rem;line-height:1.25;font-weight:400}.se-sync-panel-item-info-icon__icon.sap-icon--accept{font-size:1.1428571429rem;line-height:1.25;font-weight:400;color:#0a7e3e}.se-sync-panel-item-info-icon__icon.sap-icon--message-warning{font-size:1.1428571429rem;line-height:1.25;font-weight:400;color:#e9730c}`]
    })
], /* @ngInject */ exports.SynchronizationPanelItemComponent);

// TODO: Remove after all consumers (slotSyncButton, pageSyncMenuToolbarItem) has been migrated at least to TS. They should use imports instead.
const PROVIDE_DEFAULTS = [
    {
        provide: 'SYNCHRONIZATION_STATUSES',
        useValue: DEFAULT_SYNCHRONIZATION_STATUSES
    },
    {
        provide: 'SYNCHRONIZATION_POLLING',
        useValue: DEFAULT_SYNCHRONIZATION_POLLING
    },
    {
        provide: 'SYNCHRONIZATION_EVENT',
        useValue: DEFAULT_SYNCHRONIZATION_EVENT
    }
];
exports.SynchronizationPanelModule = class SynchronizationPanelModule {
};
exports.SynchronizationPanelModule = __decorate([
    core.NgModule({
        imports: [
            common.CommonModule,
            forms.FormsModule,
            smarteditcommons.TranslationModule.forChild(),
            smarteditcommons.TooltipModule,
            smarteditcommons.MessageModule,
            smarteditcommons.SpinnerModule,
            smarteditcommons.L10nPipeModule
        ],
        declarations: [exports.SynchronizationPanelComponent, exports.SynchronizationPanelItemComponent],
        entryComponents: [exports.SynchronizationPanelComponent],
        providers: [
            ...PROVIDE_DEFAULTS,
            smarteditcommons.moduleUtils.initialize(() => {
                smarteditcommons.diBridgeUtils.downgradeService('SYNCHRONIZATION_STATUSES', null, 'SYNCHRONIZATION_STATUSES');
                smarteditcommons.diBridgeUtils.downgradeService('SYNCHRONIZATION_POLLING', null, 'SYNCHRONIZATION_POLLING');
                smarteditcommons.diBridgeUtils.downgradeService('SYNCHRONIZATION_EVENT', null, 'SYNCHRONIZATION_EVENT');
            })
        ],
        exports: [exports.SynchronizationPanelComponent]
    })
], exports.SynchronizationPanelModule);

const CATALOG_SYNC_INTERVAL_IN_MILLISECONDS = 5000;
/* @ngInject */ exports.SynchronizationService = class /* @ngInject */ SynchronizationService {
    constructor(restServiceFactory, timerService, translateService, alertService, authenticationService, crossFrameEventService) {
        this.restServiceFactory = restServiceFactory;
        this.timerService = timerService;
        this.translateService = translateService;
        this.alertService = alertService;
        this.authenticationService = authenticationService;
        this.crossFrameEventService = crossFrameEventService;
        // Constants
        this.BASE_URL = '/cmswebservices';
        this.SYNC_JOB_INFO_BY_TARGET_URI = '/cmswebservices/v1/catalogs/:catalog/synchronizations/targetversions/:target';
        this.SYNC_JOB_INFO_BY_SOURCE_AND_TARGET_URI = '/cmswebservices/v1/catalogs/:catalog/versions/:source/synchronizations/versions/:target';
        this.intervalHandle = {};
        this.syncRequested = [];
        this.syncJobInfoByTargetRestService = this.restServiceFactory.get(this.SYNC_JOB_INFO_BY_TARGET_URI);
        this.syncJobInfoBySourceAndTargetRestService = this.restServiceFactory.get(this.SYNC_JOB_INFO_BY_SOURCE_AND_TARGET_URI, 'catalog');
    }
    /**
     * This method is used to synchronize a catalog between two catalog versions.
     * It sends the SYNCHRONIZATION_EVENT.CATALOG_SYNCHRONIZED event if successful.
     */
    updateCatalogSync(catalog) {
        return __awaiter(this, void 0, void 0, function* () {
            const jobKey = this._getJobKey(catalog.catalogId, catalog.sourceCatalogVersion, catalog.targetCatalogVersion);
            this.addCatalogSyncRequest(jobKey);
            try {
                const response = yield this.syncJobInfoBySourceAndTargetRestService.save({
                    catalog: catalog.catalogId,
                    source: catalog.sourceCatalogVersion,
                    target: catalog.targetCatalogVersion
                });
                return response;
            }
            catch (reason) {
                const translationErrorMsg = this.translateService.instant('sync.running.error.msg', {
                    catalogName: catalog.name
                });
                if (reason.statusText === 'Conflict') {
                    this.alertService.showDanger({
                        message: translationErrorMsg
                    });
                }
                return null;
            }
        });
    }
    /**
     * This method is used to get the status of the last synchronization job between two catalog versions.
     */
    getCatalogSyncStatus(catalog) {
        if (catalog.sourceCatalogVersion) {
            return this.getSyncJobInfoBySourceAndTarget(catalog);
        }
        else {
            return this.getLastSyncJobInfoByTarget(catalog);
        }
    }
    /**
     * This method is used to get the status of the last synchronization job between two catalog versions.
     */
    getSyncJobInfoBySourceAndTarget(catalog) {
        return this.syncJobInfoBySourceAndTargetRestService.get({
            catalog: catalog.catalogId,
            source: catalog.sourceCatalogVersion,
            target: catalog.targetCatalogVersion
        });
    }
    /**
     * This method is used to get the status of the last synchronization job.
     */
    getLastSyncJobInfoByTarget(catalog) {
        return this.syncJobInfoByTargetRestService.get({
            catalog: catalog.catalogId,
            target: catalog.targetCatalogVersion
        });
    }
    /**
     * This method starts the auto synchronization status update in a catalog between two given catalog versions.
     */
    startAutoGetSyncData(catalog, callback) {
        const { catalogId, sourceCatalogVersion, targetCatalogVersion } = catalog;
        const jobKey = this._getJobKey(catalogId, sourceCatalogVersion, targetCatalogVersion);
        const syncJobTimer = this.timerService.createTimer(() => this._autoSyncCallback(catalog, callback, jobKey), CATALOG_SYNC_INTERVAL_IN_MILLISECONDS);
        syncJobTimer.start();
        this.intervalHandle[jobKey] = syncJobTimer;
    }
    /**
     * This method stops the auto synchronization status update in a catalog between two given catalog versions
     * or it marks the job with discardWhenNextSynced = true if there is a synchronization in progress. If the job is
     * marked with discardWhenNextSynced = true then it will be discarded when the synchronization process is finished or aborted.
     */
    stopAutoGetSyncData(catalog) {
        const jobKey = this._getJobKey(catalog.catalogId, catalog.sourceCatalogVersion, catalog.targetCatalogVersion);
        if (this.intervalHandle[jobKey]) {
            if (this.syncRequested.indexOf(jobKey) > -1) {
                this.intervalHandle[jobKey].discardWhenNextSynced = true;
            }
            else {
                this.intervalHandle[jobKey].stop();
                this.intervalHandle[jobKey] = undefined;
            }
        }
    }
    _autoSyncCallback(catalog, callback, jobKey) {
        return __awaiter(this, void 0, void 0, function* () {
            const response = yield this.authenticationService.isAuthenticated(this.BASE_URL);
            if (!response) {
                this.stopAutoGetSyncData(catalog);
            }
            const syncStatus = yield this.getCatalogSyncStatus(catalog);
            const syncJob = this.syncRequestedCallback(catalog)(syncStatus);
            callback(syncJob);
            if (!this.intervalHandle[jobKey]) {
                this.startAutoGetSyncData(catalog, callback);
            }
        });
    }
    /**
     * Method sends SYNCHRONIZATION_EVENT.CATALOG_SYNCHRONIZED event when synchronization process is finished.
     * It also stops polling if the job is not needed anymore (i.e. was marked with discardWhenNextSynced = true).
     */
    syncRequestedCallback(catalog) {
        const jobKey = this._getJobKey(catalog.catalogId, catalog.sourceCatalogVersion, catalog.targetCatalogVersion);
        return (response) => {
            if (this.catalogSyncInProgress(jobKey)) {
                if (this.catalogSyncFinished(response)) {
                    this.removeCatalogSyncRequest(jobKey);
                    this.crossFrameEventService.publish(DEFAULT_SYNCHRONIZATION_EVENT.CATALOG_SYNCHRONIZED, catalog);
                }
                if ((this.intervalHandle[jobKey].discardWhenNextSynced &&
                    this.catalogSyncFinished(response)) ||
                    this.catalogSyncAborted(response)) {
                    this.intervalHandle[jobKey].stop();
                    this.intervalHandle[jobKey] = undefined;
                    this.removeCatalogSyncRequest(jobKey);
                }
            }
            return response;
        };
    }
    catalogSyncInProgress(jobKey) {
        return this.syncRequested.indexOf(jobKey) > -1;
    }
    catalogSyncFinished(response) {
        return response.syncStatus === exports.JOB_STATUS.FINISHED;
    }
    catalogSyncAborted(response) {
        return response.syncStatus === exports.JOB_STATUS.ABORTED;
    }
    removeCatalogSyncRequest(jobKey) {
        const index = this.syncRequested.indexOf(jobKey);
        if (index > -1) {
            this.syncRequested.splice(index, 1);
        }
    }
    addCatalogSyncRequest(jobKey) {
        if (this.syncRequested.indexOf(jobKey) === -1) {
            this.syncRequested.push(jobKey);
        }
    }
    _getJobKey(catalogId, sourceCatalogVersion, targetCatalogVersion) {
        return catalogId + '_' + sourceCatalogVersion + '_' + targetCatalogVersion;
    }
};
exports.SynchronizationService.$inject = ["restServiceFactory", "timerService", "translateService", "alertService", "authenticationService", "crossFrameEventService"];
/* @ngInject */ exports.SynchronizationService = __decorate([
    smarteditcommons.OperationContextRegistered('/cmswebservices/v1/catalogs/:catalog/synchronizations/targetversions/:target', smarteditcommons.OPERATION_CONTEXT.CMS),
    smarteditcommons.OperationContextRegistered('/cmswebservices/v1/catalogs/:catalog/versions/:source/synchronizations/versions/:target', smarteditcommons.OPERATION_CONTEXT.CMS),
    smarteditcommons.SeDowngradeService(),
    __metadata("design:paramtypes", [smarteditcommons.IRestServiceFactory,
        smarteditcommons.TimerService,
        core$1.TranslateService,
        smarteditcommons.IAlertService,
        smarteditcommons.IAuthenticationService,
        smarteditcommons.CrossFrameEventService])
], /* @ngInject */ exports.SynchronizationService);

/**
 * Service for time management functionality.
 */
/* @ngInject */ exports.CMSTimeService = class /* @ngInject */ CMSTimeService {
    constructor(translate) {
        this.translate = translate;
    }
    /**
     * Give a time difference in milliseconds, this method returns a string that determines time in ago.
     *
     * Examples:
     * If the diff is less then 24 hours, the result is in hours eg: 17 hour(s) ago.
     * If the diff is more than a day, the result is in days, eg: 2 day(s) ago.
     *
     * @param timeDiff The time difference in milliseconds.
     */
    getTimeAgo(timeDiff) {
        const timeAgoInDays = Math.floor(moment.duration(timeDiff).asDays());
        const timeAgoInHours = Math.floor(moment.duration(timeDiff).asHours());
        if (timeAgoInDays >= 1) {
            return (timeAgoInDays +
                ' ' +
                this.translate.instant('se.cms.actionitem.page.workflow.action.started.days.ago'));
        }
        else if (timeAgoInHours >= 1) {
            return (timeAgoInHours +
                ' ' +
                this.translate.instant('se.cms.actionitem.page.workflow.action.started.hours.ago'));
        }
        return ('<1 ' +
            this.translate.instant('se.cms.actionitem.page.workflow.action.started.hours.ago'));
    }
};
exports.CMSTimeService.$inject = ["translate"];
/* @ngInject */ exports.CMSTimeService = __decorate([
    smarteditcommons.SeDowngradeService(),
    __metadata("design:paramtypes", [core$1.TranslateService])
], /* @ngInject */ exports.CMSTimeService);

var /* @ngInject */ VersionExperienceInterceptor_1;
/* @ngInject */ exports.VersionExperienceInterceptor = /* @ngInject */ VersionExperienceInterceptor_1 = class /* @ngInject */ VersionExperienceInterceptor {
    constructor(sharedDataService) {
        this.sharedDataService = sharedDataService;
    }
    intercept(request, next) {
        if (this.isGET(request) && this.isPreviewDataTypeResourceEndpoint(request.url)) {
            return rxjs.from(this.sharedDataService.get(smarteditcommons.EXPERIENCE_STORAGE_KEY)).pipe(operators.switchMap((experience) => {
                if (experience.versionId) {
                    const newReq = request.clone({
                        url: request.url.replace(/* @ngInject */ VersionExperienceInterceptor_1.MODE_DEFAULT, /* @ngInject */ VersionExperienceInterceptor_1.MODE_PREVIEW_VERSION)
                    });
                    return next.handle(newReq);
                }
                else {
                    return next.handle(request);
                }
            }));
        }
        else {
            return next.handle(request);
        }
    }
    isGET(request) {
        return request.method === 'GET';
    }
    isPreviewDataTypeResourceEndpoint(url) {
        return (url.indexOf(TYPES_RESOURCE_URI) > -1 &&
            url.indexOf(/* @ngInject */ VersionExperienceInterceptor_1.PREVIEW_DATA_TYPE) > -1);
    }
};
/* @ngInject */ exports.VersionExperienceInterceptor.MODE_DEFAULT = 'DEFAULT';
/* @ngInject */ exports.VersionExperienceInterceptor.MODE_PREVIEW_VERSION = 'PREVIEWVERSION';
/* @ngInject */ exports.VersionExperienceInterceptor.PREVIEW_DATA_TYPE = 'PreviewData';
/* @ngInject */ exports.VersionExperienceInterceptor = /* @ngInject */ VersionExperienceInterceptor_1 = __decorate([
    core.Injectable(),
    __metadata("design:paramtypes", [smarteditcommons.ISharedDataService])
], /* @ngInject */ exports.VersionExperienceInterceptor);

/**
 * Service used to determine if a component is shared.
 */
class IComponentSharedService {
    /**
     * This method is used to determine if a component is shared.
     * A component is considered shared if it is used in two or more content slots.
     */
    isComponentShared(component) {
        'proxyFunction';
        return null;
    }
}

(function (TypePermissionNames) {
    TypePermissionNames["CREATE"] = "create";
    TypePermissionNames["READ"] = "read";
    TypePermissionNames["CHANGE"] = "change";
    TypePermissionNames["REMOVE"] = "remove";
})(exports.TypePermissionNames || (exports.TypePermissionNames = {}));
/**
 * Rest Service to retrieve the type permissions.
 */
/* @ngInject */ exports.TypePermissionsRestService = class /* @ngInject */ TypePermissionsRestService {
    constructor(logService, sessionService, restServiceFactory) {
        this.logService = logService;
        this.sessionService = sessionService;
        this.URI = '/permissionswebservices/v1/permissions/types/search';
        this.resource = restServiceFactory.get(this.URI);
    }
    /**
     * Determines if the current user has CREATE access to the given types.
     *
     * @param types The codes of all types.
     * @returns A promise that resolves to a TypedMap object with key (the code) and
     * value (true if the user has CREATE access to the type or false otherwise).
     */
    hasCreatePermissionForTypes(types) {
        return this.getPermissionsForTypesAndName(types, exports.TypePermissionNames.CREATE);
    }
    /**
     * Determines if the current user has READ access to the given types.
     *
     * @param types The codes of all types.
     * @returns A promise that resolves to a TypedMap object with key (the code) and
     * value (true if the user has READ access to the type or false otherwise).
     */
    hasReadPermissionForTypes(types) {
        return this.getPermissionsForTypesAndName(types, exports.TypePermissionNames.READ);
    }
    /**
     * Determines if the current user has CHANGE access to the given types.
     *
     * @param types The codes of all types.
     * @returns A promise that resolves to a TypedMap object with key (the code) and
     * value (true if the user has CHANGE access to the type or false otherwise).
     */
    hasUpdatePermissionForTypes(types) {
        return this.getPermissionsForTypesAndName(types, exports.TypePermissionNames.CHANGE);
    }
    /**
     * Determines if the current user has REMOVE access to the given types.
     *
     * @param types The codes of all types.
     * @returns A promise that resolves to a TypedMap object with key (the code) and
     * value (true if the user has REMOVE access to the type or false otherwise).
     */
    hasDeletePermissionForTypes(types) {
        return this.getPermissionsForTypesAndName(types, exports.TypePermissionNames.REMOVE);
    }
    /**
     * Determines if the current user has READ, CREATE, CHANGE, REMOVE access to the given types.
     *
     * @param types The codes of all types.
     * @returns A promise that resolves to a TypedMap of TypedMap object with key (the code) and
     * value (true if the user has corresponding access to the type or false otherwise).
     * {
     *  "typeA": {"read": true, "change": false, "create": true, "remove": true},
     *  "typeB": {"read": true, "change": false, "create": true, "remove": false}
     * }
     */
    hasAllPermissionsForTypes(types) {
        return __awaiter(this, void 0, void 0, function* () {
            const initialMap = {};
            const permissionsForTypes = yield this.getAllPermissionsForTypes(types);
            return permissionsForTypes.reduce((map, permissionsResult) => {
                if (permissionsResult.permissions) {
                    map[permissionsResult.id] = {};
                    map[permissionsResult.id][exports.TypePermissionNames.READ] = this.getPermissionByNameAndResult(permissionsResult, exports.TypePermissionNames.READ);
                    map[permissionsResult.id][exports.TypePermissionNames.CHANGE] = this.getPermissionByNameAndResult(permissionsResult, exports.TypePermissionNames.CHANGE);
                    map[permissionsResult.id][exports.TypePermissionNames.CREATE] = this.getPermissionByNameAndResult(permissionsResult, exports.TypePermissionNames.CREATE);
                    map[permissionsResult.id][exports.TypePermissionNames.REMOVE] = this.getPermissionByNameAndResult(permissionsResult, exports.TypePermissionNames.REMOVE);
                }
                return map;
            }, initialMap);
        });
    }
    getAllPermissionsForTypes(types) {
        return __awaiter(this, void 0, void 0, function* () {
            if (types.length === 0) {
                return [];
            }
            const user = yield this.sessionService.getCurrentUsername();
            if (!user) {
                return [];
            }
            try {
                const permissionNames = [
                    exports.TypePermissionNames.CREATE,
                    exports.TypePermissionNames.CHANGE,
                    exports.TypePermissionNames.READ,
                    exports.TypePermissionNames.REMOVE
                ].join(',');
                const result = yield this.resource.queryByPost({ principalUid: user }, { types: types.join(','), permissionNames });
                return result.permissionsList || [];
            }
            catch (error) {
                if (error) {
                    this.logService.error(`TypePermissionsRestService - no composed types ${types} exist`);
                }
                return Promise.reject(error);
            }
        });
    }
    getPermissionByNameAndResult(permissionsResult, permissionName) {
        const foundPermission = permissionsResult.permissions.find((permission) => permission.key === permissionName);
        return JSON.parse(foundPermission.value);
    }
    getPermissionsForTypesAndName(types, permissionName) {
        return __awaiter(this, void 0, void 0, function* () {
            const permissionsForTypes = yield this.getAllPermissionsForTypes(types);
            return permissionsForTypes.reduce((map, permissionsResult) => {
                if (permissionsResult.permissions) {
                    map[permissionsResult.id] = this.getPermissionByNameAndResult(permissionsResult, permissionName);
                }
                return map;
            }, {});
        });
    }
};
exports.TypePermissionsRestService.$inject = ["logService", "sessionService", "restServiceFactory"];
__decorate([
    smarteditcommons.Cached({ actions: [smarteditcommons.rarelyChangingContent], tags: [smarteditcommons.authorizationEvictionTag] }),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [Array]),
    __metadata("design:returntype", Promise)
], /* @ngInject */ exports.TypePermissionsRestService.prototype, "getAllPermissionsForTypes", null);
/* @ngInject */ exports.TypePermissionsRestService = __decorate([
    smarteditcommons.SeDowngradeService(),
    __metadata("design:paramtypes", [smarteditcommons.LogService,
        smarteditcommons.ISessionService,
        smarteditcommons.IRestServiceFactory])
], /* @ngInject */ exports.TypePermissionsRestService);

/**
 * An enum type representing available attribute permission names for a given item
 */
var AttributePermissionNames;
(function (AttributePermissionNames) {
    AttributePermissionNames["READ"] = "read";
    AttributePermissionNames["CHANGE"] = "change";
})(AttributePermissionNames || (AttributePermissionNames = {}));
/**
 * Rest Service to retrieve attribute permissions.
 */
/* @ngInject */ exports.AttributePermissionsRestService = class /* @ngInject */ AttributePermissionsRestService {
    constructor(restServiceFactory, sessionService, logService) {
        this.sessionService = sessionService;
        this.logService = logService;
        this.ATTRIBUTE_PERMISSIONS_URI = '/permissionswebservices/v1/permissions/attributes/search';
        this.permissionRestService = restServiceFactory.get(this.ATTRIBUTE_PERMISSIONS_URI);
    }
    /**
     * Determines if the current user has READ access to the given attributes in the given type.
     *
     * @param type The type enclosing the attributes for which to evaluate their read permissions.
     * @param attributeNames The names of the attributes for which to evaluate their read permissions.
     * @returns A promise that resolves to a TypedMap object with key (the attribute name) and
     * value (true if the user has READ access to the type or false otherwise).
     */
    hasReadPermissionOnAttributesInType(type, attributeNames) {
        return this.getPermissionsForAttributesAndNameByType(type, attributeNames, AttributePermissionNames.READ);
    }
    /**
     * Determines if the current user has CHANGE access to the given attributes in the given type.
     *
     * @param type The type enclosing the attributes for which to evaluate their change permissions.
     * @param attributeNames The names of the attributes for which to evaluate their change permissions.
     * @returns A promise that resolves to a TypedMap object with key (the attribute name) and
     * value (true if the user has READ access to the type or false otherwise).
     */
    hasChangePermissionOnAttributesInType(type, attributeNames) {
        return this.getPermissionsForAttributesAndNameByType(type, attributeNames, AttributePermissionNames.CHANGE);
    }
    /**
     * @internal
     *
     * This method retrieves ALL the permissions the current user has on the given attributes. Attributes are expected with the following format:
     * - type.attribute name
     * For example, for an attribute called approvalStatus within the type ContentPage, the given attribute must be:
     * - ContentPage.approvalStatus
     *
     * Note: This method is cached.
     *
     * @param attributes The list of attributes for which to retrieve permissions
     * @returns A promise that resolves to a list of IPermissionsRestServiceResult, each of which
     * represents the permissions of one of the given attributes.
     */
    getAllPermissionsForAttributes(attributes) {
        return __awaiter(this, void 0, void 0, function* () {
            if (attributes.length <= 0) {
                return [];
            }
            const user = yield this.sessionService.getCurrentUsername();
            if (!user) {
                return [];
            }
            try {
                const result = yield this.permissionRestService.queryByPost({ principalUid: user }, {
                    attributes: attributes.join(','),
                    permissionNames: AttributePermissionNames.CHANGE + ',' + AttributePermissionNames.READ
                });
                return result.permissionsList || [];
            }
            catch (error) {
                if (error) {
                    this.logService.error(`AttributePermissionsRestService - couldn't retrieve attribute permissions ${attributes}`);
                }
                return [];
            }
        });
    }
    getPermissionsForAttributesAndNameByType(type, attributes, permissionName) {
        const convertedAttributeNames = attributes.map((attr) => type + '.' + attr);
        return this.getPermissionsForAttributesAndName(convertedAttributeNames, permissionName).then((attributePermissionsByTypeMap) => attributePermissionsByTypeMap[type]);
    }
    getPermissionsForAttributesAndName(attributes, permissionName) {
        return __awaiter(this, void 0, void 0, function* () {
            const result = yield this.getAllPermissionsForAttributes(attributes);
            const allPermissions = this.concatPermissionsNotFound(attributes, result);
            return allPermissions.reduce((attributePermissionsByTypeMap, permissionsResult) => {
                if (permissionsResult.permissions) {
                    const typeAttributePair = this.parsePermissionsResultId(permissionsResult.id);
                    if (!attributePermissionsByTypeMap[typeAttributePair.type]) {
                        attributePermissionsByTypeMap[typeAttributePair.type] = {};
                    }
                    attributePermissionsByTypeMap[typeAttributePair.type][typeAttributePair.attribute] = this.getPermissionByNameFromResult(permissionsResult, permissionName);
                }
                return attributePermissionsByTypeMap;
            }, {});
        });
    }
    parsePermissionsResultId(id) {
        const tokens = id.split('.');
        if (tokens.length !== 2) {
            throw new Error('AttributePermissionsRestService - Received invalid attribute permissions');
        }
        return {
            type: tokens[0],
            attribute: tokens[1]
        };
    }
    getPermissionByNameFromResult(permissionsResult, permissionName) {
        const foundPermission = permissionsResult.permissions.find((permission) => permission.key === permissionName);
        return JSON.parse(foundPermission.value);
    }
    concatPermissionsNotFound(attributes, permissionsFound) {
        const permissionKeysFound = permissionsFound.map((permission) => permission.id);
        const permissionKeysNotFound = lodash.difference(attributes, permissionKeysFound);
        return permissionsFound.concat(permissionKeysNotFound.map((key) => ({
            id: key,
            permissions: [
                {
                    key: AttributePermissionNames.READ,
                    value: 'false'
                },
                {
                    key: AttributePermissionNames.CHANGE,
                    value: 'false'
                }
            ]
        })));
    }
};
exports.AttributePermissionsRestService.$inject = ["restServiceFactory", "sessionService", "logService"];
__decorate([
    smarteditcommons.Cached({ actions: [smarteditcommons.rarelyChangingContent], tags: [smarteditcommons.authorizationEvictionTag] }),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [Array]),
    __metadata("design:returntype", Promise)
], /* @ngInject */ exports.AttributePermissionsRestService.prototype, "getAllPermissionsForAttributes", null);
/* @ngInject */ exports.AttributePermissionsRestService = __decorate([
    smarteditcommons.SeDowngradeService(),
    __metadata("design:paramtypes", [smarteditcommons.IRestServiceFactory,
        smarteditcommons.ISessionService,
        smarteditcommons.LogService])
], /* @ngInject */ exports.AttributePermissionsRestService);

/**
 * Service interface specifying the contract used to remove a component from a slot.
 * This class serves as an interface and should be extended, not instantiated.
 */
class IRemoveComponentService {
    /**
     * Removes the component specified by the given ID from the component specified by the given ID.
     *
     * @param slotId The ID of the slot from which to remove the component.
     * @param componentId The ID of the component to remove from the slot.
     */
    removeComponent(configuration) {
        'proxyFunction';
        return null;
    }
}

class ISlotVisibilityService {
    /**
     * Returns the list of hidden components for a given slotId
     */
    getHiddenComponents(slotId) {
        'proxyFunction';
        return null;
    }
    /**
     * Reloads and cache's the pagesContentSlotsComponents for the current page in context.
     * this method can be called when ever a component is added or modified to the slot
     * so that the pagesContentSlotsComponents is re-evaluated.
     *
     * @returns A promise that resolves to the contentSlot - Components [] map for the page in context.
     */
    reloadSlotsInfo() {
        'proxyFunction';
        return null;
    }
}

class IEditorEnablerService {
    enableForComponents(componentTypes) {
        'proxyFunction';
    }
    onClickEditButton({ slotUuid, componentAttributes }) {
        'proxyFunction';
        return null;
    }
    isSlotEditableForNonExternalComponent(config) {
        'proxyFunction';
        return null;
    }
}

class IComponentMenuConditionAndCallbackService {
    externalCondition(configuration) {
        'proxyFunction';
        return null;
    }
    sharedCondition(configuration) {
        'proxyFunction';
        return null;
    }
    removeCondition(configuration) {
        'proxyFunction';
        return null;
    }
    removeCallback(configuration, $event) {
        'proxyFunction';
        return null;
    }
    cloneCondition(configuration) {
        'proxyFunction';
        return null;
    }
    cloneCallback(configuration) {
        'proxyFunction';
        return null;
    }
    editConditionForHiddenComponent(configuration) {
        'proxyFunction';
        return null;
    }
}

window.__smartedit__.addDecoratorPayload("Component", "ActionableAlertComponent", {
    selector: 'se-actionable-alert',
    changeDetection: core.ChangeDetectionStrategy.OnPush,
    template: `<div>
        <p>{{ description | translate: descriptionDetails }}</p>
        <div>
            <a href (click)="onHyperLinkClick($event)">{{
                hyperlinkLabel | translate: hyperlinkDetails
            }}</a>
        </div>
    </div> `
});
exports.ActionableAlertComponent = class ActionableAlertComponent {
    constructor() {
        this.hyperLinkClick = new core.EventEmitter();
    }
    onHyperLinkClick(event) {
        event.preventDefault();
        this.hyperLinkClick.emit();
    }
};
__decorate([
    core.Input(),
    __metadata("design:type", String)
], exports.ActionableAlertComponent.prototype, "description", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], exports.ActionableAlertComponent.prototype, "descriptionDetails", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", String)
], exports.ActionableAlertComponent.prototype, "hyperlinkLabel", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], exports.ActionableAlertComponent.prototype, "hyperlinkDetails", void 0);
__decorate([
    core.Output(),
    __metadata("design:type", core.EventEmitter)
], exports.ActionableAlertComponent.prototype, "hyperLinkClick", void 0);
exports.ActionableAlertComponent = __decorate([
    core.Component({
        selector: 'se-actionable-alert',
        changeDetection: core.ChangeDetectionStrategy.OnPush,
        template: `<div>
        <p>{{ description | translate: descriptionDetails }}</p>
        <div>
            <a href (click)="onHyperLinkClick($event)">{{
                hyperlinkLabel | translate: hyperlinkDetails
            }}</a>
        </div>
    </div> `
    }),
    __metadata("design:paramtypes", [])
], exports.ActionableAlertComponent);

window.__smartedit__.addDecoratorPayload("Component", "SharedComponentButtonComponent", {
    selector: 'shared-component-button',
    template: `<div class="se-ctx-menu-btn__msg"><div class="se-ctx-menu-btn__msg-title" translate="se.cms.contextmenu.shared.component.info.title"></div><div *ngIf="isReady" class="se-ctx-menu-btn__msg-description" [translate]="message"></div><se-spinner [isSpinning]="!isReady"></se-spinner></div>`,
    styles: [`.se-ctx-menu-btn__msg{box-shadow:0 6px 12px rgba(0,0,0,.175);background-color:#fff;border-radius:4px!important;min-width:100px;width:fit-content;position:absolute;border:1px solid #d9d9d9;z-index:2000;top:96%;box-shadow:0 0 4px 0 #d9d9d9;font-size:1.1428571429rem;line-height:1.25;font-weight:400;white-space:normal;padding:20px;width:250px}.se-ctx-menu-btn__msg::before{height:0;width:0;border-style:solid;border-width:0 8px 8px 8px;border-bottom-color:#d9d9d9;border-bottom-color:var(var(--fd-color-neutral-4));border-left-color:transparent;border-right-color:transparent;content:"";position:absolute;top:-8px}.se-ctx-menu-btn__msg::after{height:0;width:0;border-style:solid;border-width:0 8px 8px 8px;border-bottom-color:#fff;border-bottom-color:var(var(--fd-color-background-4));border-left-color:transparent;border-right-color:transparent;content:"";position:absolute;top:-7px}.se-ctx-menu-btn__msg::after,.se-ctx-menu-btn__msg::before{left:14px}.se-ctx-menu-btn__msg-title{font-weight:700;color:#32363a;margin-bottom:8px}.se-ctx-menu-btn__msg-description{color:#51555a}`],
    changeDetection: core.ChangeDetectionStrategy.OnPush
});
exports.SharedComponentButtonComponent = class SharedComponentButtonComponent {
    constructor(item, contextAwareEditableItemService, cdr) {
        this.contextAwareEditableItemService = contextAwareEditableItemService;
        this.cdr = cdr;
        this.isReady = false;
        ({
            componentAttributes: { smarteditComponentId: this.smarteditComponentId }
        } = item);
    }
    ngOnInit() {
        return __awaiter(this, void 0, void 0, function* () {
            const isEditable = yield this.contextAwareEditableItemService.isItemEditable(this.smarteditComponentId);
            this.message = `se.cms.contextmenu.shared.component.info.msg${isEditable ? '.editable' : ''}`;
            this.isReady = true;
            if (!this.cdr.destroyed) {
                this.cdr.detectChanges();
            }
        });
    }
};
exports.SharedComponentButtonComponent = __decorate([
    core.Component({
        selector: 'shared-component-button',
        template: `<div class="se-ctx-menu-btn__msg"><div class="se-ctx-menu-btn__msg-title" translate="se.cms.contextmenu.shared.component.info.title"></div><div *ngIf="isReady" class="se-ctx-menu-btn__msg-description" [translate]="message"></div><se-spinner [isSpinning]="!isReady"></se-spinner></div>`,
        styles: [`.se-ctx-menu-btn__msg{box-shadow:0 6px 12px rgba(0,0,0,.175);background-color:#fff;border-radius:4px!important;min-width:100px;width:fit-content;position:absolute;border:1px solid #d9d9d9;z-index:2000;top:96%;box-shadow:0 0 4px 0 #d9d9d9;font-size:1.1428571429rem;line-height:1.25;font-weight:400;white-space:normal;padding:20px;width:250px}.se-ctx-menu-btn__msg::before{height:0;width:0;border-style:solid;border-width:0 8px 8px 8px;border-bottom-color:#d9d9d9;border-bottom-color:var(var(--fd-color-neutral-4));border-left-color:transparent;border-right-color:transparent;content:"";position:absolute;top:-8px}.se-ctx-menu-btn__msg::after{height:0;width:0;border-style:solid;border-width:0 8px 8px 8px;border-bottom-color:#fff;border-bottom-color:var(var(--fd-color-background-4));border-left-color:transparent;border-right-color:transparent;content:"";position:absolute;top:-7px}.se-ctx-menu-btn__msg::after,.se-ctx-menu-btn__msg::before{left:14px}.se-ctx-menu-btn__msg-title{font-weight:700;color:#32363a;margin-bottom:8px}.se-ctx-menu-btn__msg-description{color:#51555a}`],
        changeDetection: core.ChangeDetectionStrategy.OnPush
    }),
    __param(0, core.Inject(smarteditcommons.CONTEXTUAL_MENU_ITEM_DATA)),
    __metadata("design:paramtypes", [Object, IContextAwareEditableItemService,
        core.ChangeDetectorRef])
], exports.SharedComponentButtonComponent);

window.__smartedit__.addDecoratorPayload("Component", "ExternalComponentButtonComponent", {
    selector: 'se-external-component-button',
    template: `<div class="se-ctx-menu-btn__msg" *ngIf="isReady">{{ catalogVersion }}</div>`,
    styles: [`.se-ctx-menu-btn__msg{box-shadow:0 6px 12px rgba(0,0,0,.175);background-color:#fff;border-radius:4px!important;min-width:100px;width:fit-content;position:absolute;border:1px solid #d9d9d9;z-index:2000;top:96%;box-shadow:0 0 4px 0 #d9d9d9;font-size:1.1428571429rem;line-height:1.25;font-weight:400;white-space:normal;padding:20px;width:250px}.se-ctx-menu-btn__msg::before{height:0;width:0;border-style:solid;border-width:0 8px 8px 8px;border-bottom-color:#d9d9d9;border-bottom-color:var(var(--fd-color-neutral-4));border-left-color:transparent;border-right-color:transparent;content:"";position:absolute;top:-8px}.se-ctx-menu-btn__msg::after{height:0;width:0;border-style:solid;border-width:0 8px 8px 8px;border-bottom-color:#fff;border-bottom-color:var(var(--fd-color-background-4));border-left-color:transparent;border-right-color:transparent;content:"";position:absolute;top:-7px}.se-ctx-menu-btn__msg::after,.se-ctx-menu-btn__msg::before{left:14px}.se-ctx-menu-btn__msg-title{font-weight:700;color:#32363a;margin-bottom:8px}.se-ctx-menu-btn__msg-description{color:#51555a}`],
    providers: [smarteditcommons.L10nPipe],
    changeDetection: core.ChangeDetectionStrategy.OnPush
});
exports.ExternalComponentButtonComponent = class ExternalComponentButtonComponent {
    constructor(item, catalogService, l10nPipe, cdr) {
        this.catalogService = catalogService;
        this.l10nPipe = l10nPipe;
        this.cdr = cdr;
        this.isReady = false;
        ({
            componentAttributes: { smarteditCatalogVersionUuid: this.catalogVersionUuid }
        } = item);
    }
    ngOnInit() {
        return __awaiter(this, void 0, void 0, function* () {
            const catalogVersion = yield this.catalogService.getCatalogVersionByUuid(this.catalogVersionUuid);
            const catalogName = yield this.l10nPipe
                .transform(catalogVersion.catalogName)
                .pipe(operators.take(1))
                .toPromise();
            this.catalogVersion = `${catalogName} (${catalogVersion.version})`;
            this.isReady = true;
            if (!this.cdr.destroyed) {
                this.cdr.detectChanges();
            }
        });
    }
};
exports.ExternalComponentButtonComponent = __decorate([
    core.Component({
        selector: 'se-external-component-button',
        template: `<div class="se-ctx-menu-btn__msg" *ngIf="isReady">{{ catalogVersion }}</div>`,
        styles: [`.se-ctx-menu-btn__msg{box-shadow:0 6px 12px rgba(0,0,0,.175);background-color:#fff;border-radius:4px!important;min-width:100px;width:fit-content;position:absolute;border:1px solid #d9d9d9;z-index:2000;top:96%;box-shadow:0 0 4px 0 #d9d9d9;font-size:1.1428571429rem;line-height:1.25;font-weight:400;white-space:normal;padding:20px;width:250px}.se-ctx-menu-btn__msg::before{height:0;width:0;border-style:solid;border-width:0 8px 8px 8px;border-bottom-color:#d9d9d9;border-bottom-color:var(var(--fd-color-neutral-4));border-left-color:transparent;border-right-color:transparent;content:"";position:absolute;top:-8px}.se-ctx-menu-btn__msg::after{height:0;width:0;border-style:solid;border-width:0 8px 8px 8px;border-bottom-color:#fff;border-bottom-color:var(var(--fd-color-background-4));border-left-color:transparent;border-right-color:transparent;content:"";position:absolute;top:-7px}.se-ctx-menu-btn__msg::after,.se-ctx-menu-btn__msg::before{left:14px}.se-ctx-menu-btn__msg-title{font-weight:700;color:#32363a;margin-bottom:8px}.se-ctx-menu-btn__msg-description{color:#51555a}`],
        providers: [smarteditcommons.L10nPipe],
        changeDetection: core.ChangeDetectionStrategy.OnPush
    }),
    __param(0, core.Inject(smarteditcommons.CONTEXTUAL_MENU_ITEM_DATA)),
    __metadata("design:paramtypes", [Object, smarteditcommons.ICatalogService,
        smarteditcommons.L10nPipe,
        core.ChangeDetectorRef])
], exports.ExternalComponentButtonComponent);

/**
 * Displays an alert informing the user possibility to edit Component Settings when the component is hidden or restricted.
 * Provides an instant feedback for the user so he can still change some settings instead of searching the Storefront for
 * the slot to which the component belongs.
 *
 * When the user clicks on the link, the Alert will be closed and Component Settings will be reopened.
 * When no action is performed, the alert will disappear after a few seconds.
 */
class IComponentVisibilityAlertService {
    /**
     * Method checks on a component visibility and triggers the display of a
     * contextual alert when the component is either hidden or restricted.
     */
    checkAndAlertOnComponentVisibility(component) {
        'proxyFunction';
        return null;
    }
}

window.__smartedit__.addDecoratorPayload("Component", "ComponentVisibilityAlertComponent", {
    selector: 'se-component-visibility-alert',
    template: `<div>
        <p [translate]="message"></p>
        <div>
            <a (click)="onClick()" [translate]="hyperlinkLabel"></a>
        </div>
    </div>`,
    changeDetection: core.ChangeDetectionStrategy.OnPush
});
/* @ngInject */ exports.ComponentVisibilityAlertComponent = class /* @ngInject */ ComponentVisibilityAlertComponent {
    constructor(editorModalService, componentVisibilityAlertService, alertRef) {
        this.editorModalService = editorModalService;
        this.componentVisibilityAlertService = componentVisibilityAlertService;
        this.alertRef = alertRef;
        this.hyperlinkLabel = 'se.cms.component.visibility.alert.hyperlink';
        ({ component: this.component, message: this.message } = this.alertRef.data);
    }
    onClick() {
        return __awaiter(this, void 0, void 0, function* () {
            this.alertRef.dismiss();
            this.checkProvidedArguments(this.component);
            const item = yield this.editorModalService.openAndRerenderSlot(this.component.itemType, this.component.itemId, 'visibilityTab');
            this.componentVisibilityAlertService.checkAndAlertOnComponentVisibility({
                itemId: item.uuid,
                itemType: item.itemtype,
                catalogVersion: item.catalogVersion,
                restricted: item.restricted,
                slotId: this.component.slotId,
                visible: item.visible
            });
        });
    }
    // TODO: since we can leverage TypeScript it could possibly be removed once we migrate each consumer.
    checkProvidedArguments(component) {
        const checkedArguments = [component.itemId, component.itemType, component.slotId];
        const nonEmptyArguments = checkedArguments.filter((value) => value && !smarteditcommons.stringUtils.isBlank(value));
        if (nonEmptyArguments.length !== checkedArguments.length) {
            throw new Error('componentVisibilityAlertService.checkAndAlertOnComponentVisibility - missing properly typed parameters');
        }
    }
};
exports.ComponentVisibilityAlertComponent.$inject = ["editorModalService", "componentVisibilityAlertService", "alertRef"];
/* @ngInject */ exports.ComponentVisibilityAlertComponent = __decorate([
    smarteditcommons.SeDowngradeComponent(),
    core.Component({
        selector: 'se-component-visibility-alert',
        template: `<div>
        <p [translate]="message"></p>
        <div>
            <a (click)="onClick()" [translate]="hyperlinkLabel"></a>
        </div>
    </div>`,
        changeDetection: core.ChangeDetectionStrategy.OnPush
    }),
    __metadata("design:paramtypes", [smarteditcommons.IEditorModalService,
        IComponentVisibilityAlertService,
        core$2.AlertRef])
], /* @ngInject */ exports.ComponentVisibilityAlertComponent);

exports.ComponentVisibilityAlertModule = class ComponentVisibilityAlertModule {
};
exports.ComponentVisibilityAlertModule = __decorate([
    core.NgModule({
        imports: [smarteditcommons.TranslationModule.forChild()],
        declarations: [exports.ComponentVisibilityAlertComponent],
        entryComponents: [exports.ComponentVisibilityAlertComponent]
    })
], exports.ComponentVisibilityAlertModule);

exports.CmsCommonsModule = class CmsCommonsModule {
};
exports.CmsCommonsModule = __decorate([
    core.NgModule({
        imports: [
            common.CommonModule,
            smarteditcommons.SpinnerModule,
            core$1.TranslateModule.forChild(),
            exports.SynchronizationPanelModule,
            exports.ComponentVisibilityAlertModule
        ],
        providers: [
            exports.AttributePermissionsRestService,
            exports.CMSTimeService,
            exports.SynchronizationService,
            exports.TypePermissionsRestService,
            exports.ComponentService,
            exports.SynchronizationResourceService,
            exports.AssetsService
        ],
        declarations: [
            exports.ActionableAlertComponent,
            exports.SharedComponentButtonComponent,
            exports.ExternalComponentButtonComponent
        ],
        entryComponents: [exports.SharedComponentButtonComponent, exports.ExternalComponentButtonComponent],
        exports: [
            exports.ActionableAlertComponent,
            exports.SharedComponentButtonComponent,
            exports.ExternalComponentButtonComponent,
            exports.SynchronizationPanelModule,
            exports.ComponentVisibilityAlertModule
        ]
    })
], exports.CmsCommonsModule);

/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
(function (DRAG_AND_DROP_EVENTS) {
    /**
     * Name of event executed when a drag and drop event starts.
     */
    DRAG_AND_DROP_EVENTS["DRAG_STARTED"] = "CMS_DRAG_STARTED";
    /**
     * Name of event executed when a drag and drop event stops.
     */
    DRAG_AND_DROP_EVENTS["DRAG_STOPPED"] = "CMS_DRAG_STOPPED";
    /**
     * Name of event executed when onDragOver is triggered.
     */
    DRAG_AND_DROP_EVENTS["DRAG_OVER"] = "CMS_DRAG_OVER";
    /**
     * Name of event executed when onDragLeave is triggered.
     */
    DRAG_AND_DROP_EVENTS["DRAG_LEAVE"] = "CMS_DRAG_LEAVE";
})(exports.DRAG_AND_DROP_EVENTS || (exports.DRAG_AND_DROP_EVENTS = {}));
const COMPONENT_CREATED_EVENT = 'COMPONENT_CREATED_EVENT';
const COMPONENT_REMOVED_EVENT = 'COMPONENT_REMOVED_EVENT';
const COMPONENT_UPDATED_EVENT = 'COMPONENT_UPDATED_EVENT';
const CMSITEMS_UPDATE_EVENT = 'CMSITEMS_UPDATE';
const EVENT_PAGE_STATUS_UPDATED_IN_ACTIVE_CV = 'EVENT_PAGE_STATUS_UPDATED_IN_ACTIVE_CV';
const NAVIGATION_NODE_TYPECODE = 'CMSNavigationNode';
const NAVIGATION_NODE_ROOT_NODE_UID = 'root';
const IMAGES_URL = '/cmssmartedit/images';

exports.CATALOG_SYNC_INTERVAL_IN_MILLISECONDS = CATALOG_SYNC_INTERVAL_IN_MILLISECONDS;
exports.CMSITEMS_UPDATE_EVENT = CMSITEMS_UPDATE_EVENT;
exports.COMPONENT_CREATED_EVENT = COMPONENT_CREATED_EVENT;
exports.COMPONENT_REMOVED_EVENT = COMPONENT_REMOVED_EVENT;
exports.COMPONENT_UPDATED_EVENT = COMPONENT_UPDATED_EVENT;
exports.CONTENT_SLOTS_TYPE_RESTRICTION_RESOURCE_URI = CONTENT_SLOTS_TYPE_RESTRICTION_RESOURCE_URI;
exports.CONTENT_SLOT_TYPE_RESTRICTION_RESOURCE_URI = CONTENT_SLOT_TYPE_RESTRICTION_RESOURCE_URI;
exports.CONTEXTUAL_PAGES_RESTRICTIONS_RESOURCE_URI = CONTEXTUAL_PAGES_RESTRICTIONS_RESOURCE_URI;
exports.CONTEXT_CATALOG = CONTEXT_CATALOG;
exports.CONTEXT_CATALOG_VERSION = CONTEXT_CATALOG_VERSION;
exports.CONTEXT_SITE_ID = CONTEXT_SITE_ID;
exports.DEFAULT_SYNCHRONIZATION_EVENT = DEFAULT_SYNCHRONIZATION_EVENT;
exports.DEFAULT_SYNCHRONIZATION_POLLING = DEFAULT_SYNCHRONIZATION_POLLING;
exports.DEFAULT_SYNCHRONIZATION_STATUSES = DEFAULT_SYNCHRONIZATION_STATUSES;
exports.EVENT_PAGE_STATUS_UPDATED_IN_ACTIVE_CV = EVENT_PAGE_STATUS_UPDATED_IN_ACTIVE_CV;
exports.GET_PAGE_SYNCHRONIZATION_RESOURCE_URI = GET_PAGE_SYNCHRONIZATION_RESOURCE_URI;
exports.IComponentMenuConditionAndCallbackService = IComponentMenuConditionAndCallbackService;
exports.IComponentSharedService = IComponentSharedService;
exports.IComponentVisibilityAlertService = IComponentVisibilityAlertService;
exports.IContextAwareEditableItemService = IContextAwareEditableItemService;
exports.IEditorEnablerService = IEditorEnablerService;
exports.IMAGES_URL = IMAGES_URL;
exports.IPageContentSlotsComponentsRestService = IPageContentSlotsComponentsRestService;
exports.IRemoveComponentService = IRemoveComponentService;
exports.ISlotVisibilityService = ISlotVisibilityService;
exports.ITEMS_RESOURCE_URI = ITEMS_RESOURCE_URI;
exports.NAVIGATION_MANAGEMENT_ENTRIES_RESOURCE_URI = NAVIGATION_MANAGEMENT_ENTRIES_RESOURCE_URI;
exports.NAVIGATION_MANAGEMENT_ENTRY_TYPES_RESOURCE_URI = NAVIGATION_MANAGEMENT_ENTRY_TYPES_RESOURCE_URI;
exports.NAVIGATION_MANAGEMENT_PAGE_PATH = NAVIGATION_MANAGEMENT_PAGE_PATH;
exports.NAVIGATION_MANAGEMENT_RESOURCE_URI = NAVIGATION_MANAGEMENT_RESOURCE_URI;
exports.NAVIGATION_NODE_ROOT_NODE_UID = NAVIGATION_NODE_ROOT_NODE_UID;
exports.NAVIGATION_NODE_TYPECODE = NAVIGATION_NODE_TYPECODE;
exports.PAGES_CONTENT_SLOT_COMPONENT_RESOURCE_URI = PAGES_CONTENT_SLOT_COMPONENT_RESOURCE_URI;
exports.PAGES_CONTENT_SLOT_RESOURCE_URI = PAGES_CONTENT_SLOT_RESOURCE_URI;
exports.PAGES_LIST_RESOURCE_URI = PAGES_LIST_RESOURCE_URI;
exports.PAGES_RESTRICTIONS_RESOURCE_URI = PAGES_RESTRICTIONS_RESOURCE_URI;
exports.PAGE_CONTEXT_CATALOG = PAGE_CONTEXT_CATALOG;
exports.PAGE_CONTEXT_CATALOG_VERSION = PAGE_CONTEXT_CATALOG_VERSION;
exports.PAGE_LIST_PATH = PAGE_LIST_PATH;
exports.PAGE_TEMPLATES_URI = PAGE_TEMPLATES_URI;
exports.PAGE_TYPES_RESTRICTION_TYPES_URI = PAGE_TYPES_RESTRICTION_TYPES_URI;
exports.PAGE_TYPES_URI = PAGE_TYPES_URI;
exports.POST_PAGE_SYNCHRONIZATION_RESOURCE_URI = POST_PAGE_SYNCHRONIZATION_RESOURCE_URI;
exports.RESTRICTION_TYPES_URI = RESTRICTION_TYPES_URI;
exports.SynchronizationUtils = SynchronizationUtils;
exports.TRASHED_PAGE_LIST_PATH = TRASHED_PAGE_LIST_PATH;
exports.TYPES_RESOURCE_URI = TYPES_RESOURCE_URI;
exports.WORKFLOW_CREATED_EVENT = WORKFLOW_CREATED_EVENT;
exports.WORKFLOW_FINISHED_EVENT = WORKFLOW_FINISHED_EVENT;
exports.slotEvictionTag = slotEvictionTag;
exports.synchronizationUtils = synchronizationUtils;
exports.workflowCompletedEvictionTag = workflowCompletedEvictionTag;
exports.workflowCreatedEvictionTag = workflowCreatedEvictionTag;
exports.workflowTasksMenuOpenedEvictionTag = workflowTasksMenuOpenedEvictionTag;
