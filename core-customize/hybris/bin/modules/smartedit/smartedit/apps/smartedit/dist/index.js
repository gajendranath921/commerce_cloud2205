'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@angular/core');
var http = require('@angular/common/http');
var platformBrowser = require('@angular/platform-browser');
var _static = require('@angular/upgrade/static');
var lodash = require('lodash');
var smarteditcommons = require('smarteditcommons');
var rxjs = require('rxjs');
var common = require('@angular/common');
var ResizeObserver = require('resize-observer-polyfill');
var angular = require('angular');
var operators = require('rxjs/operators');

function _interopDefaultLegacy (e) { return e && typeof e === 'object' && 'default' in e ? e : { 'default': e }; }

function _interopNamespace(e) {
    if (e && e.__esModule) return e;
    var n = Object.create(null);
    if (e) {
        Object.keys(e).forEach(function (k) {
            if (k !== 'default') {
                var d = Object.getOwnPropertyDescriptor(e, k);
                Object.defineProperty(n, k, d.get ? d : {
                    enumerable: true,
                    get: function () {
                        return e[k];
                    }
                });
            }
        });
    }
    n['default'] = e;
    return Object.freeze(n);
}

var ResizeObserver__default = /*#__PURE__*/_interopDefaultLegacy(ResizeObserver);
var angular__namespace = /*#__PURE__*/_interopNamespace(angular);

(function(){
      var angular = angular || window.angular;
      var SE_NG_TEMPLATE_MODULE = null;
      
      try {
        SE_NG_TEMPLATE_MODULE = angular.module('coretemplates');
      } catch (err) {}
      SE_NG_TEMPLATE_MODULE = SE_NG_TEMPLATE_MODULE || angular.module('coretemplates', []);
      SE_NG_TEMPLATE_MODULE.run(['$templateCache', function($templateCache) {
         
    $templateCache.put(
        "ContextualMenuItemComponent.html", 
        "<div *ngIf=\"mode === 'small'\" id=\"{{itemConfig.i18nKey | translate}}-{{componentAttributes.smarteditComponentId}}-{{componentAttributes.smarteditComponentType}}-{{index}}\" class=\"se-ctx-menu-element__btn {{itemConfig.displayIconClass}} {{itemConfig.displayClass}}\" [ngClass]=\"{'is-active': itemConfig.isOpen }\" [title]=\"itemConfig.i18nKey | translate\"></div><div *ngIf=\"mode === 'compact'\" class=\"se-ctx-menu-element__label {{itemConfig.displayClass}}\" id=\"{{itemConfig.i18nKey | translate}}-{{componentAttributes.smarteditComponentId}}-{{componentAttributes.smarteditComponentType}}-{{index}}\">{{itemConfig.i18nKey | translate}}</div>"
    );
     
    $templateCache.put(
        "ContextualMenuDecoratorComponent.html", 
        "<div class=\"se-ctx-menu-decorator-wrapper\" [ngClass]=\"{'se-ctx-menu-decorator__border--visible': showContextualMenuBorders()}\"><div class=\"se-ctx-menu__overlay\" *ngIf=\"showOverlay(active)\"><div class=\"se-ctx-menu__overlay__left-section\" *ngIf=\"getItems()\"><div *ngFor=\"let item of getItems().leftMenuItems; let $index = index\" id=\"{{ item.key }}\"><se-popup-overlay [popupOverlay]=\"itemTemplateOverlayWrapper\" [popupOverlayTrigger]=\"shouldShowTemplate(item)\" [popupOverlayData]=\"{ item: item }\" (popupOverlayOnShow)=\"onShowItemPopup(item)\" (popupOverlayOnHide)=\"onHideItemPopup(false)\"><se-contextual-menu-item [mode]=\"'small'\" [index]=\"$index\" [componentAttributes]=\"componentAttributes\" [slotAttributes]=\"slotAttributes\" [itemConfig]=\"item\" (click)=\"triggerMenuItemAction(item, $event)\" [attr.data-component-id]=\"smarteditComponentId\" [attr.data-component-uuid]=\"componentAttributes.smarteditComponentUuid\" [attr.data-component-type]=\"smarteditComponentType\" [attr.data-slot-id]=\"smarteditSlotId\" [attr.data-slot-uuid]=\"smarteditSlotUuid\" [attr.data-container-id]=\"smarteditContainerId\" [attr.data-container-type]=\"smarteditContainerType\"></se-contextual-menu-item></se-popup-overlay></div></div><se-popup-overlay [popupOverlay]=\"moreMenuPopupConfig\" [popupOverlayTrigger]=\"moreMenuIsOpen\" (popupOverlayOnShow)=\"onShowMoreMenuPopup()\" (popupOverlayOnHide)=\"onHideMoreMenuPopup()\"><div *ngIf=\"getItems() && getItems().moreMenuItems.length > 0\" class=\"se-ctx-menu-element__btn se-ctx-menu-element__btn--more\" [ngClass]=\"{'se-ctx-menu-element__btn--more--open': moreMenuIsOpen }\" (click)=\"toggleMoreMenu()\"><span [title]=\"moreButton.i18nKey | translate\" class=\"{{moreButton.displayClass}}\"></span></div></se-popup-overlay></div><div class=\"se-wrapper-data\"><div><ng-content></ng-content></div></div></div>"
    );
     
    $templateCache.put(
        "SlotContextualMenuDecoratorComponent.html", 
        "<div class=\"se-decorative-panel-wrapper\"><ng-container *ngIf=\"showOverlay(active) && !showAtBottom\"><ng-container *ngTemplateOutlet=\"decorativePanelArea\"></ng-container></ng-container><div class=\"se-decoratorative-body-area\"><div class=\"se-decorative-body__padding--left\" [ngClass]=\"{ 'active': active }\"></div><div class=\"se-decorative-body__inner-border\" [ngClass]=\"{ 'active': active }\"></div><div class=\"se-wrapper-data\" [ngClass]=\"{ 'active': active }\"><ng-content></ng-content></div><div class=\"se-decorative-body__padding--right\" [ngClass]=\"{ 'active': active }\"></div></div><ng-container *ngIf=\"showOverlay(active) && showAtBottom\"><ng-container *ngTemplateOutlet=\"decorativePanelArea\"></ng-container></ng-container><ng-template #decorativePanelArea><div class=\"se-decorative-panel-area\" [ngStyle]=\"showAtBottom && { 'margin-top': '0px' }\"><span class=\"se-decorative-panel__title\">{{smarteditComponentId}}</span><div class=\"se-decorative-panel__slot-contextual-menu\"><slot-contextual-menu-item [item]=\"item\" *ngFor=\"let item of items\"></slot-contextual-menu-item></div></div></ng-template></div>"
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

/* @ngInject */ exports.AnnouncementService = class /* @ngInject */ AnnouncementService extends smarteditcommons.IAnnouncementService {
};
/* @ngInject */ exports.AnnouncementService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IAnnouncementService),
    smarteditcommons.GatewayProxied('showAnnouncement', 'closeAnnouncement')
], /* @ngInject */ exports.AnnouncementService);

/** @internal */
/* @ngInject */ exports.CatalogService = class /* @ngInject */ CatalogService extends smarteditcommons.ICatalogService {
};
/* @ngInject */ exports.CatalogService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.ICatalogService),
    smarteditcommons.GatewayProxied()
], /* @ngInject */ exports.CatalogService);

/**
 * The ContextualMenuService is used to add contextual menu items for each component.
 *
 * To add items to the contextual menu, you must call the addItems method of the contextualMenuService and pass a map
 * of the component-type array of contextual menu items mapping. The component type names are the keys in the mapping.
 * The component name can be the full name of the component type, an ant-like wildcard (such as  *middle*Suffix), or a
 * valid regex that includes or excludes a set of component types.
 *
 */
/* @ngInject */ exports.ContextualMenuService = class /* @ngInject */ ContextualMenuService {
    /* @internal */
    constructor(priorityService, systemEventService) {
        this.priorityService = priorityService;
        this.systemEventService = systemEventService;
        this.onContextualMenuItemsAdded = new rxjs.BehaviorSubject(null);
        this._contextualMenus = {};
    }
    /**
     * The method called to add contextual menu items to component types in the SmartEdit application.
     * The contextual menu items are then retrieved by the contextual menu decorator to wire the set of menu items to the specified component.
     *
     * ### Example:
     *
     *
     *      contextualMenuService.addItems({
     *          '.*Component': [{
     *              key: 'itemKey',
     *              i18nKey: 'CONTEXTUAL_MENU',
     *              condition: function(componentType, componentId) {
     *                  return componentId === 'ComponentType';
     *              },
     *              callback: function(componentType, componentId) {
     *                  alert('callback for ' + componentType + "_" + componentId);
     *              },
     *              displayClass: 'democlass',
     *              iconIdle: '.../icons/icon.png',
     *              iconNonIdle: '.../icons/icon.png',
     *              }]
     *          });
     *
     *
     * @param  contextualMenuItemsMap A map of componentType regular expressions to list of IContextualMenuButton contextual menu items
     *
     * The object contains a list that maps component types to arrays of IContextualMenuButton contextual menu items. The mapping is a key-value pair.
     * The key is the name of the component type, for example, Simple Responsive Banner Component, and the value is an array of IContextualMenuButton contextual menu items, like add, edit, localize, etc.
     */
    addItems(contextualMenuItemsMap) {
        try {
            if (contextualMenuItemsMap !== undefined) {
                this._featuresList = this._getFeaturesList(this._contextualMenus);
                const componentTypes = Object.keys(contextualMenuItemsMap);
                componentTypes.forEach((type) => this._initContextualMenuItems(contextualMenuItemsMap, type));
            }
        }
        catch (e) {
            throw new Error('addItems() - Cannot add items. ' + e);
        }
    }
    /**
     * This method removes the menu items identified by the provided key.
     *
     * @param itemKey The key that identifies the menu items to remove.
     */
    removeItemByKey(itemKey) {
        Object.keys(this._contextualMenus).forEach((contextualMenuKey) => {
            const contextualMenuItems = this._contextualMenus[contextualMenuKey];
            this._contextualMenus[contextualMenuKey] = contextualMenuItems.filter((item) => item.key !== itemKey);
            if (this._contextualMenus[contextualMenuKey].length === 0) {
                // Remove if the contextual menu is empty.
                delete this._contextualMenus[contextualMenuKey];
            }
        });
    }
    /**
     * Verifies whether the itemKey has already been added to contextual menu list.
     *
     * @param itemKey The item key to verify.
     *
     * @returns Return true if itemKey exists in the contextual menu list, false otherwise.
     */
    containsItem(itemKey) {
        const contextualMenuExists = Object.keys(this._contextualMenus).map((contextualMenuKey) => {
            const contextualMenuItems = this._contextualMenus[contextualMenuKey];
            return (contextualMenuItems.findIndex((item) => item.key === itemKey) > -1);
        });
        return contextualMenuExists.findIndex((menuExists) => menuExists === true) > -1;
    }
    /**
     * Will return an array of contextual menu items for a specific component type.
     * For each key in the contextual menus' object, the method converts each component type into a valid regex using the regExpFactory of the function module and then compares it with the input componentType and, if matched, will add it to an array and returns the array.
     *
     * @param componentType The type code of the selected component
     *
     * @returns An array of contextual menu items assigned to the type.
     *
     */
    getContextualMenuByType(componentType) {
        let contextualMenuArray = [];
        if (this._contextualMenus) {
            Object.keys(this._contextualMenus).forEach((regexpKey) => {
                if (smarteditcommons.stringUtils.regExpFactory(regexpKey).test(componentType)) {
                    contextualMenuArray = this._getUniqueItemArray(contextualMenuArray, this._contextualMenus[regexpKey]);
                }
            });
        }
        return contextualMenuArray;
    }
    /**
     * Returns an object that contains a list of contextual menu items that are displayed in the menu and menu items that are added to the More … options.
     *
     * The returned object contains two arrays. The first array contains the menu items that are displayed in the menu. The display limit size (iLeftBtns) specifies
     * the maximum number of items that can be displayed in the menu. The other array contains the menu items that are available under the More... options.
     * This method decides which items to send to each array based on their priority. Items with the lowest priority are displayed in the menu. The remaining
     * items are added to the More... menu. Items that do not have a priority are automatically assigned a default priority.
     *
     * @param configuration
     * @returns A promise that resolves to an array of contextual menu items assigned to the component type.
     *
     * The returned object contains the following properties
     * - leftMenuItems : An array of menu items that can be displayed on the component.
     * - moreMenuItems : An array of menu items that are available under the more menu items action.
     *
     */
    getContextualMenuItems(configuration) {
        const { iLeftBtns } = configuration;
        delete configuration.iLeftBtns;
        const menuItems = this.getContextualMenuByType(configuration.componentType);
        const promises = menuItems.map((item) => {
            if (!item.condition) {
                return Promise.resolve(item);
            }
            const isItemEnabled = item.condition(configuration);
            return isItemEnabled instanceof Promise
                ? isItemEnabled.then((_isItemEnabled) => (_isItemEnabled ? item : null))
                : Promise.resolve(isItemEnabled ? item : null);
        });
        return Promise.all(promises).then((items) => {
            const leftMenuItems = [];
            const moreMenuItems = [];
            this.priorityService
                .sort(items.filter((menuItem) => menuItem !== null))
                .forEach((menuItem) => {
                const collection = leftMenuItems.length < iLeftBtns ? leftMenuItems : moreMenuItems;
                collection.push(menuItem);
            });
            return {
                leftMenuItems,
                moreMenuItems
            };
        });
    }
    /**
     * This method can be used to ask SmartEdit to retrieve again the list of items in the enabled contextual menus.
     */
    refreshMenuItems() {
        this.systemEventService.publishAsync(smarteditcommons.REFRESH_CONTEXTUAL_MENU_ITEMS_EVENT);
    }
    // Helper Methods
    _getFeaturesList(_contextualMenus) {
        // Would be better to use a set for this, but it's not currently supported by all browsers.
        const featuresList = Object.keys(_contextualMenus).reduce((acc, key) => [
            ...acc,
            ..._contextualMenus[key].map((entry) => entry.key)
        ], []);
        return featuresList.reduce((acc, current) => acc.indexOf(current) < 0 ? [...acc, current] : [...acc], []);
    }
    _validateItem(item) {
        if (!item.action) {
            throw new Error('Contextual menu item must provide an action: ' + JSON.stringify(item));
        }
    }
    _getUniqueItemArray(array1, array2) {
        let currItem;
        array2.forEach((item) => {
            currItem = item;
            if (array1.every((it) => currItem.key !== it.key)) {
                array1.push(currItem);
            }
        });
        return array1;
    }
    _initContextualMenuItems(map, componentType) {
        const componentTypeContextualMenus = map[componentType].filter((item) => {
            this._validateItem(item);
            if (!item.key) {
                throw new Error("Item doesn't have key.");
            }
            if (this._featuresList.indexOf(item.key) !== -1) {
                throw new Error(`Item with that key (${item.key}) already exist.`);
            }
            return true;
        });
        this._contextualMenus[componentType] = smarteditcommons.objectUtils.uniqueArray(this._contextualMenus[componentType] || [], componentTypeContextualMenus);
        this.onContextualMenuItemsAdded.next(componentType);
    }
};
exports.ContextualMenuService.$inject = ["priorityService", "systemEventService"];
/* @ngInject */ exports.ContextualMenuService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IContextualMenuService),
    core.Injectable(),
    __metadata("design:paramtypes", [smarteditcommons.PriorityService,
        smarteditcommons.SystemEventService])
], /* @ngInject */ exports.ContextualMenuService);

/*
 * internal service to proxy calls from inner RESTService to the outer restServiceFactory and the 'real' IRestService
 */
/** @internal */
/* @ngInject */ exports.DelegateRestService = class /* @ngInject */ DelegateRestService {
    delegateForSingleInstance(methodName, params, uri, identifier, metadataActivated, options) {
        'proxyFunction';
        return null;
    }
    delegateForArray(methodName, params, uri, identifier, metadataActivated, options) {
        'proxyFunction';
        return null;
    }
    delegateForPage(pageable, uri, identifier, metadataActivated, options) {
        'proxyFunction';
        return null;
    }
    delegateForQueryByPost(payload, params, uri, identifier, metadataActivated, options) {
        'proxyFunction';
        return null;
    }
};
/* @ngInject */ exports.DelegateRestService = __decorate([
    smarteditcommons.GatewayProxied(),
    core.Injectable()
], /* @ngInject */ exports.DelegateRestService);

/** @internal */
/* @ngInject */ exports.ExperienceService = class /* @ngInject */ ExperienceService extends smarteditcommons.IExperienceService {
    constructor(routingService, logService, previewService) {
        super();
        this.routingService = routingService;
        this.logService = logService;
        this.previewService = previewService;
    }
    buildRefreshedPreviewUrl() {
        return this.getCurrentExperience().then((experience) => {
            if (!experience) {
                throw new Error('ExperienceService.buildRefreshedPreviewUrl() - Invalid experience from ExperienceService.getCurrentExperience()');
            }
            const promise = this.previewService.getResourcePathFromPreviewUrl(experience.siteDescriptor.previewUrl);
            return promise.then((resourcePath) => {
                const previewData = this._convertExperienceToPreviewData(experience, resourcePath);
                return this.previewService.updateUrlWithNewPreviewTicketId(this.routingService.absUrl(), previewData);
            }, (err) => {
                this.logService.error('ExperienceService.buildRefreshedPreviewUrl() - failed to retrieve resource path');
                return Promise.reject(err);
            });
        }, (err) => {
            this.logService.error('ExperienceService.buildRefreshedPreviewUrl() - failed to retrieve current experience');
            return Promise.reject(err);
        });
    }
};
exports.ExperienceService.$inject = ["routingService", "logService", "previewService"];
/* @ngInject */ exports.ExperienceService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IExperienceService),
    smarteditcommons.GatewayProxied('loadExperience', 'updateExperiencePageContext', 'getCurrentExperience', 'setCurrentExperience', 'hasCatalogVersionChanged', 'buildRefreshedPreviewUrl', 'compareWithCurrentExperience'),
    __metadata("design:paramtypes", [smarteditcommons.SmarteditRoutingService,
        smarteditcommons.LogService,
        smarteditcommons.IPreviewService])
], /* @ngInject */ exports.ExperienceService);

/** @internal */
/* @ngInject */ exports.FeatureService = class /* @ngInject */ FeatureService extends smarteditcommons.IFeatureService {
    constructor(logService, decoratorService, cloneableUtils, contextualMenuService) {
        super(cloneableUtils);
        this.logService = logService;
        this.decoratorService = decoratorService;
        this.contextualMenuService = contextualMenuService;
    }
    addDecorator(configuration) {
        const prevEnablingCallback = configuration.enablingCallback;
        const prevDisablingCallback = configuration.disablingCallback;
        const displayCondition = configuration.displayCondition;
        configuration.enablingCallback = function () {
            this.enable(configuration.key, displayCondition);
            if (prevEnablingCallback) {
                prevEnablingCallback();
            }
        }.bind(this.decoratorService);
        configuration.disablingCallback = function () {
            this.disable(configuration.key);
            if (prevDisablingCallback) {
                prevDisablingCallback();
            }
        }.bind(this.decoratorService);
        delete configuration.displayCondition;
        return this.register(configuration);
    }
    addContextualMenuButton(item) {
        const clone = Object.assign({}, item);
        delete item.nameI18nKey;
        delete item.descriptionI18nKey;
        delete item.regexpKeys;
        clone.enablingCallback = function () {
            const mapping = {};
            clone.regexpKeys.forEach((regexpKey) => {
                mapping[regexpKey] = [item];
            });
            if (!this.containsItem(clone.key)) {
                this.addItems(mapping);
            }
        }.bind(this.contextualMenuService);
        clone.disablingCallback = function () {
            this.removeItemByKey(clone.key);
        }.bind(this.contextualMenuService);
        return this.register(clone);
    }
    _remoteEnablingFromInner(key) {
        if (this._featuresToAlias && this._featuresToAlias[key]) {
            this._featuresToAlias[key].enablingCallback();
        }
        else {
            this.logService.warn('could not enable feature named ' + key + ', it was not found in the iframe');
        }
        return Promise.resolve();
    }
    _remoteDisablingFromInner(key) {
        if (this._featuresToAlias && this._featuresToAlias[key]) {
            this._featuresToAlias[key].disablingCallback();
        }
        else {
            this.logService.warn('could not disable feature named ' + key + ', it was not found in the iframe');
        }
        return Promise.resolve();
    }
};
exports.FeatureService.$inject = ["logService", "decoratorService", "cloneableUtils", "contextualMenuService"];
/* @ngInject */ exports.FeatureService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IFeatureService),
    smarteditcommons.GatewayProxied('_registerAliases', 'addToolbarItem', 'register', 'enable', 'disable', '_remoteEnablingFromInner', '_remoteDisablingFromInner', 'addDecorator', 'getFeatureProperty', 'addContextualMenuButton'),
    __metadata("design:paramtypes", [smarteditcommons.LogService,
        smarteditcommons.IDecoratorService,
        smarteditcommons.CloneableUtils,
        smarteditcommons.IContextualMenuService])
], /* @ngInject */ exports.FeatureService);

/**
 * The notification service is used to display visual cues to inform the user of the state of the application.
 */
/** @internal */
/* @ngInject */ exports.NotificationService = class /* @ngInject */ NotificationService extends smarteditcommons.INotificationService {
};
/* @ngInject */ exports.NotificationService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.INotificationService),
    smarteditcommons.GatewayProxied('pushNotification', 'removeNotification', 'removeAllNotifications')
], /* @ngInject */ exports.NotificationService);

/**
 * This service makes it possible to track the mouse position to detect when it leaves the notification panel.
 * It is solely meant to be used with the notificationService.
 */
/** @internal */
/* @ngInject */ exports.NotificationMouseLeaveDetectionService = class /* @ngInject */ NotificationMouseLeaveDetectionService extends smarteditcommons.INotificationMouseLeaveDetectionService {
    constructor(document) {
        super();
        this.document = document;
        this.notificationPanelBounds = null;
        this.mouseLeaveCallback = null;
        /*
         * We need to bind the function in order for it to execute within the service's
         * scope and store it to be able to un-register the listener.
         */
        this._onMouseMove = this._onMouseMove.bind(this);
    }
    _remoteStartDetection(innerBounds) {
        this.notificationPanelBounds = innerBounds;
        this.document.addEventListener('mousemove', this._onMouseMove);
        return Promise.resolve();
    }
    _remoteStopDetection() {
        this.document.removeEventListener('mousemove', this._onMouseMove);
        this.notificationPanelBounds = null;
        return Promise.resolve();
    }
    _getBounds() {
        return Promise.resolve(this.notificationPanelBounds);
    }
    _getCallback() {
        return Promise.resolve(this.mouseLeaveCallback);
    }
};
exports.NotificationMouseLeaveDetectionService.$inject = ["document"];
/* @ngInject */ exports.NotificationMouseLeaveDetectionService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.INotificationMouseLeaveDetectionService),
    smarteditcommons.GatewayProxied('stopDetection', '_remoteStartDetection', '_remoteStopDetection', '_callCallback'),
    core.Injectable(),
    __param(0, core.Inject(common.DOCUMENT)),
    __metadata("design:paramtypes", [Document])
], /* @ngInject */ exports.NotificationMouseLeaveDetectionService);

/** @internal */
/* @ngInject */ exports.DragAndDropCrossOrigin = class /* @ngInject */ DragAndDropCrossOrigin extends smarteditcommons.IDragAndDropCrossOrigin {
    constructor(document, yjQuery, crossFrameEventService, inViewElementObserver, dragAndDropScrollingService, polyfillService) {
        super();
        this.document = document;
        this.yjQuery = yjQuery;
        this.crossFrameEventService = crossFrameEventService;
        this.inViewElementObserver = inViewElementObserver;
        this.dragAndDropScrollingService = dragAndDropScrollingService;
        this.polyfillService = polyfillService;
        this.onDnDCrossOriginStart = (eventId) => {
            this.dragAndDropScrollingService.toggleThrottling(this.polyfillService.isEligibleForThrottledScrolling());
        };
        this.onTrackMouseInner = (eventId, eventData) => {
            if (this.isSearchingElement) {
                return;
            }
            this.isSearchingElement = true;
            /**
             * Get the element from mouse position.
             * In IE11, document.elementFromPoint returns null because of the #ySmartEditFrameDragArea positioned over the iframe and has pointer-events (necessary to listen on 'dragover' to track the mouse position).
             * To polyfill document.elementFromPoint in IE11 in this scenario, we call isPointOverElement() on each elligible droppable element.
             *
             * Note: in IE11, a switch of pointer-events value to none for the #ySmartEditFrameDragArea will return a value when calling $document.elementFromPoint, BUT it is causing cursor flickering and too much latency. The 'isPointOverElement' approach give better results.
             */
            this.currentElementHovered = this.yjQuery(this.inViewElementObserver.elementFromPoint(eventData));
            const mousePositionInPage = this.getMousePositionInPage(eventData);
            if (this.lastElementHovered && this.lastElementHovered.length) {
                if ((this.currentElementHovered.length &&
                    this.lastElementHovered[0] !== this.currentElementHovered[0]) ||
                    !this.currentElementHovered.length) {
                    this.dispatchDragEvent(this.lastElementHovered[0], smarteditcommons.IDragEventType.DRAG_LEAVE, mousePositionInPage);
                    this.lastElementHovered.data(smarteditcommons.SMARTEDIT_ELEMENT_HOVERED, false);
                }
            }
            if (this.currentElementHovered.length) {
                if (!this.currentElementHovered.data(smarteditcommons.SMARTEDIT_ELEMENT_HOVERED)) {
                    this.dispatchDragEvent(this.currentElementHovered[0], smarteditcommons.IDragEventType.DRAG_ENTER, mousePositionInPage);
                    this.currentElementHovered.data(smarteditcommons.SMARTEDIT_ELEMENT_HOVERED, true);
                }
                this.dispatchDragEvent(this.currentElementHovered[0], smarteditcommons.IDragEventType.DRAG_OVER, mousePositionInPage);
            }
            this.lastElementHovered = this.currentElementHovered;
            this.isSearchingElement = false;
        };
        this.onDropElementInner = (eventId, mousePosition) => {
            if (this.currentElementHovered.length) {
                this.currentElementHovered.data(smarteditcommons.SMARTEDIT_ELEMENT_HOVERED, false);
                this.dispatchDragEvent(this.currentElementHovered[0], smarteditcommons.IDragEventType.DROP, mousePosition);
                this.dispatchDragEvent(this.currentElementHovered[0], smarteditcommons.IDragEventType.DRAG_LEAVE, mousePosition);
            }
        };
    }
    initialize() {
        this.crossFrameEventService.subscribe(smarteditcommons.SMARTEDIT_DRAG_AND_DROP_EVENTS.TRACK_MOUSE_POSITION, this.onTrackMouseInner.bind(this));
        this.crossFrameEventService.subscribe(smarteditcommons.SMARTEDIT_DRAG_AND_DROP_EVENTS.DROP_ELEMENT, this.onDropElementInner.bind(this));
        this.crossFrameEventService.subscribe(smarteditcommons.SMARTEDIT_DRAG_AND_DROP_EVENTS.DRAG_DROP_CROSS_ORIGIN_START, this.onDnDCrossOriginStart.bind(this));
    }
    dispatchDragEvent(element, type, mousePosition) {
        const evt = this.document.createEvent('CustomEvent');
        evt.initCustomEvent(type, true, true, null);
        evt.dataTransfer = {
            data: {},
            // eslint-disable-next-line @typescript-eslint/ban-types
            setData(_type, val) {
                this.data[_type] = val;
            },
            getData(_type) {
                return this.data[_type];
            }
        };
        evt.pageX = mousePosition.x;
        evt.pageY = mousePosition.y;
        element.dispatchEvent(evt);
    }
    getMousePositionInPage(mousePosition) {
        const scrollingElement = this.yjQuery(this.document.scrollingElement || this.document.documentElement);
        return {
            x: mousePosition.x + scrollingElement.scrollLeft(),
            y: mousePosition.y + scrollingElement.scrollTop()
        };
    }
};
exports.DragAndDropCrossOrigin.$inject = ["document", "yjQuery", "crossFrameEventService", "inViewElementObserver", "dragAndDropScrollingService", "polyfillService"];
/* @ngInject */ exports.DragAndDropCrossOrigin = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IDragAndDropCrossOrigin),
    __param(0, core.Inject(common.DOCUMENT)),
    __param(1, core.Inject(smarteditcommons.YJQUERY_TOKEN)),
    __metadata("design:paramtypes", [Document, Function, smarteditcommons.CrossFrameEventService,
        smarteditcommons.InViewElementObserver,
        smarteditcommons.DragAndDropScrollingService,
        smarteditcommons.PolyfillService])
], /* @ngInject */ exports.DragAndDropCrossOrigin);

var /* @ngInject */ PageInfoService_1;
/** @internal */
/* @ngInject */ exports.PageInfoService = /* @ngInject */ PageInfoService_1 = class /* @ngInject */ PageInfoService extends smarteditcommons.IPageInfoService {
    /* @internal */
    constructor(yjQuery, restServiceFactory, logService) {
        super();
        this.yjQuery = yjQuery;
        this.restServiceFactory = restServiceFactory;
        this.logService = logService;
        this.pageTemplateRestService = restServiceFactory.get('/cmswebservices/v1/pagetemplate');
    }
    /**
     * When the time comes to deprecate these 3 functions from componentHandlerService in the inner app, we will need
     * to migrate their implementations to here.
     */
    getPageUID() {
        return this.try(() => this.getBodyClassAttributeByRegEx(/* @ngInject */ PageInfoService_1.PATTERN_SMARTEDIT_PAGE_UID));
    }
    getPageUUID() {
        return this.try(() => this.getBodyClassAttributeByRegEx(/* @ngInject */ PageInfoService_1.PATTERN_SMARTEDIT_PAGE_UUID));
    }
    getCatalogVersionUUIDFromPage() {
        return this.try(() => this.getBodyClassAttributeByRegEx(/* @ngInject */ PageInfoService_1.PATTERN_SMARTEDIT_CATALOG_VERSION_UUID));
    }
    // eslint-disable-next-line @typescript-eslint/member-ordering
    isSameCatalogVersionOfPageAndPageTemplate() {
        return __awaiter(this, void 0, void 0, function* () {
            const pageUuid = yield this.getPageUUID();
            const pageCatalogVersion = yield this.getCatalogVersionUUIDFromPage();
            const params = {
                pageUuid
            };
            const pageTemplate = yield this.pageTemplateRestService.get(params);
            return pageCatalogVersion === pageTemplate.catalogVersion;
        });
    }
    /**
     * @param pattern Pattern of class names to search for
     *
     * @returns  Class attributes from the body element of the storefront
     */
    getBodyClassAttributeByRegEx(pattern) {
        try {
            const bodyClass = this.yjQuery('body').attr('class');
            return pattern.exec(bodyClass)[1];
        }
        catch (_a) {
            throw {
                name: 'InvalidStorefrontPageError',
                message: 'Error: the page is not a valid storefront page.'
            };
        }
    }
    /** @internal */
    try(func) {
        try {
            return Promise.resolve(func());
        }
        catch (e) {
            this.logService.warn('Missing SmartEdit attributes on body element of the storefront - SmartEdit will resume once the attributes are added');
            return Promise.reject(e);
        }
    }
};
/* @ngInject */ exports.PageInfoService.PATTERN_SMARTEDIT_CATALOG_VERSION_UUID = /smartedit-catalog-version-uuid\-(\S+)/;
/* @ngInject */ exports.PageInfoService.PATTERN_SMARTEDIT_PAGE_UID = /smartedit-page-uid\-(\S+)/;
/* @ngInject */ exports.PageInfoService.PATTERN_SMARTEDIT_PAGE_UUID = /smartedit-page-uuid\-(\S+)/;
__decorate([
    smarteditcommons.Cached({ actions: [smarteditcommons.rarelyChangingContent], tags: [smarteditcommons.pageChangeEvictionTag] }),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", Promise)
], /* @ngInject */ exports.PageInfoService.prototype, "isSameCatalogVersionOfPageAndPageTemplate", null);
/* @ngInject */ exports.PageInfoService = /* @ngInject */ PageInfoService_1 = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IPageInfoService),
    smarteditcommons.GatewayProxied('getPageUID', 'getPageUUID', 'getCatalogVersionUUIDFromPage', 'isSameCatalogVersionOfPageAndPageTemplate'),
    __param(0, core.Inject(smarteditcommons.YJQUERY_TOKEN)),
    __metadata("design:paramtypes", [Function, smarteditcommons.IRestServiceFactory,
        smarteditcommons.LogService])
], /* @ngInject */ exports.PageInfoService);

/* @ngInject */ exports.PageTreeService = class /* @ngInject */ PageTreeService extends smarteditcommons.IPageTreeService {
    constructor() {
        super();
    }
};
/* @ngInject */ exports.PageTreeService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IPageTreeService),
    smarteditcommons.GatewayProxied('registerTreeComponent', 'getTreeComponent'),
    __metadata("design:paramtypes", [])
], /* @ngInject */ exports.PageTreeService);

/* @ngInject */ exports.PageTreeNodeService = class /* @ngInject */ PageTreeNodeService extends smarteditcommons.IPageTreeNodeService {
    constructor(componentHandlerService, yjQuery, crossFrameEventService, windowUtils, logService) {
        super();
        this.componentHandlerService = componentHandlerService;
        this.yjQuery = yjQuery;
        this.crossFrameEventService = crossFrameEventService;
        this.windowUtils = windowUtils;
        this.logService = logService;
    }
    buildSlotNodes() {
        this.slotNodes = this.buildSlotNodesByElement(this.yjQuery('body'));
        this.crossFrameEventService.publish(smarteditcommons.EVENT_OVERALL_REFRESH_TREE_NODE);
    }
    updateSlotNodes(nodes) {
        if (this.slotNodes && nodes.length > 0) {
            const parentSet = new Set();
            const updatedSlotNodes = {};
            nodes.forEach((node) => {
                if (parentSet.has(node.parent)) {
                    return;
                }
                parentSet.add(node.parent);
                const element = this.yjQuery(node.parent);
                const parentUUid = element.attr(smarteditcommons.ELEMENT_UUID_ATTRIBUTE);
                if (!parentUUid) {
                    return;
                }
                const childrenNode = this.buildSlotNodesByElement(element);
                updatedSlotNodes[parentUUid] = childrenNode;
                this.slotNodes.forEach((item) => {
                    if (item.elementUuid === parentUUid) {
                        item.childrenNode = childrenNode;
                    }
                });
            });
            this.crossFrameEventService.publish(smarteditcommons.EVENT_PART_REFRESH_TREE_NODE, updatedSlotNodes);
        }
    }
    getSlotNodes() {
        return Promise.resolve(this.slotNodes);
    }
    /*
     * If element is not in viewport or element bottom is in viewport scroll element into view
     */
    scrollToElement(elementUuid) {
        const element = this.yjQuery(`[data-smartedit-element-uuid="${elementUuid}"]`)
            .get()
            .shift();
        if (element) {
            if (this.elementTopInViewport(element) || this.elementCenterInViewport(element)) {
                return;
            }
            element.scrollIntoView({ behavior: 'smooth', block: 'center' });
        }
        else {
            this.logService.error(`data-smartedit-element-uuid="${elementUuid}" is not existed!`);
        }
    }
    existedSmartEditElement(elementUuid) {
        const element = this.yjQuery(`smartedit-element[data-smartedit-element-uuid="${elementUuid}"]`)
            .get()
            .shift();
        return Promise.resolve(!!element);
    }
    _buildSlotNode(node) {
        const element = this.yjQuery(node);
        const childrenNode = Array.from(this.componentHandlerService.getFirstSmartEditComponentChildren(element))
            .filter((child) => this._isValidElement(child))
            .map((firstLevelComponent) => this._buildSlotNode(firstLevelComponent));
        if (!element.attr(smarteditcommons.ELEMENT_UUID_ATTRIBUTE)) {
            element.attr(smarteditcommons.ELEMENT_UUID_ATTRIBUTE, smarteditcommons.stringUtils.generateIdentifier());
        }
        return {
            componentId: element.attr(smarteditcommons.ID_ATTRIBUTE),
            componentUuid: element.attr(smarteditcommons.UUID_ATTRIBUTE),
            componentTypeFromPage: element.attr(smarteditcommons.TYPE_ATTRIBUTE),
            catalogVersionUuid: element.attr(smarteditcommons.CATALOG_VERSION_UUID_ATTRIBUTE),
            containerId: element.attr(smarteditcommons.CONTAINER_ID_ATTRIBUTE),
            containerType: element.attr(smarteditcommons.CONTAINER_TYPE_ATTRIBUTE),
            elementUuid: element.attr(smarteditcommons.ELEMENT_UUID_ATTRIBUTE),
            isExpanded: false,
            childrenNode
        };
    }
    _isValidElement(ele) {
        const element = this.yjQuery(ele);
        if (!element || !element.is(':visible')) {
            return false;
        }
        return !(!element.attr(smarteditcommons.ID_ATTRIBUTE) ||
            !element.attr(smarteditcommons.UUID_ATTRIBUTE) ||
            !element.attr(smarteditcommons.TYPE_ATTRIBUTE) ||
            !element.attr(smarteditcommons.CATALOG_VERSION_UUID_ATTRIBUTE));
    }
    elementTopInViewport(element) {
        const rect = element.getBoundingClientRect();
        return (rect.top >= 0 &&
            rect.left >= 0 &&
            rect.top <
                (this.windowUtils.getWindow().innerHeight ||
                    document.documentElement.clientHeight) &&
            rect.left <
                (this.windowUtils.getWindow().innerWidth || document.documentElement.clientWidth));
    }
    elementCenterInViewport(element) {
        const rect = element.getBoundingClientRect();
        return (rect.top < 0 &&
            rect.left < 0 &&
            rect.bottom >
                (this.windowUtils.getWindow().innerHeight ||
                    document.documentElement.clientHeight) &&
            rect.right >
                (this.windowUtils.getWindow().innerWidth || document.documentElement.clientWidth));
    }
    buildSlotNodesByElement(element) {
        return Array.from(this.componentHandlerService.getFirstSmartEditComponentChildren(element))
            .filter((child) => this._isValidElement(child))
            .map((firstLevelComponent) => this._buildSlotNode(firstLevelComponent));
    }
};
exports.PageTreeNodeService.$inject = ["componentHandlerService", "yjQuery", "crossFrameEventService", "windowUtils", "logService"];
/* @ngInject */ exports.PageTreeNodeService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IPageTreeNodeService),
    smarteditcommons.GatewayProxied('getSlotNodes', 'scrollToElement', 'existedSmartEditElement'),
    __param(1, core.Inject(smarteditcommons.YJQUERY_TOKEN)),
    __metadata("design:paramtypes", [smarteditcommons.ComponentHandlerService, Function, smarteditcommons.CrossFrameEventService,
        smarteditcommons.WindowUtils,
        smarteditcommons.LogService])
], /* @ngInject */ exports.PageTreeNodeService);

/** @internal */
/* @ngInject */ exports.PerspectiveService = class /* @ngInject */ PerspectiveService extends smarteditcommons.IPerspectiveService {
    constructor() {
        super();
    }
};
/* @ngInject */ exports.PerspectiveService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IPerspectiveService),
    smarteditcommons.GatewayProxied(),
    __metadata("design:paramtypes", [])
], /* @ngInject */ exports.PerspectiveService);

/** @internal */
/* @ngInject */ exports.PreviewService = class /* @ngInject */ PreviewService extends smarteditcommons.IPreviewService {
    constructor(urlUtils) {
        super(urlUtils);
    }
};
exports.PreviewService.$inject = ["urlUtils"];
/* @ngInject */ exports.PreviewService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IPreviewService),
    smarteditcommons.GatewayProxied(),
    __metadata("design:paramtypes", [smarteditcommons.UrlUtils])
], /* @ngInject */ exports.PreviewService);

/** @internal */
class RestService {
    constructor(delegateRestService, uri, identifier) {
        this.delegateRestService = delegateRestService;
        this.uri = uri;
        this.identifier = identifier;
        this.metadataActivated = false;
    }
    getById(id, options) {
        return this.delegateRestService.delegateForSingleInstance('getById', id, this.uri, this.identifier, this.metadataActivated, options);
    }
    get(searchParams, options) {
        return this.delegateRestService.delegateForSingleInstance('get', searchParams, this.uri, this.identifier, this.metadataActivated, options);
    }
    update(payload, options) {
        return this.delegateRestService.delegateForSingleInstance('update', payload, this.uri, this.identifier, this.metadataActivated, options);
    }
    patch(payload, options) {
        return this.delegateRestService.delegateForSingleInstance('patch', payload, this.uri, this.identifier, this.metadataActivated, options);
    }
    save(payload, options) {
        return this.delegateRestService.delegateForSingleInstance('save', payload, this.uri, this.identifier, this.metadataActivated, options);
    }
    query(searchParams, options) {
        return this.delegateRestService.delegateForArray('query', searchParams, this.uri, this.identifier, this.metadataActivated, options);
    }
    page(pageable, options) {
        return this.delegateRestService.delegateForPage(pageable, this.uri, this.identifier, this.metadataActivated, options);
    }
    remove(payload, options) {
        return this.delegateRestService.delegateForSingleInstance('remove', payload, this.uri, this.identifier, this.metadataActivated, options);
    }
    queryByPost(payload, searchParams, options) {
        return this.delegateRestService.delegateForQueryByPost(payload, searchParams, this.uri, this.identifier, this.metadataActivated, options);
    }
    activateMetadata() {
        // will activate response headers appending
        this.metadataActivated = true;
    }
}

/** @internal */
/* @ngInject */ exports.RestServiceFactory = class /* @ngInject */ RestServiceFactory {
    constructor(delegateRestService) {
        this.delegateRestService = delegateRestService;
    }
    get(uri, identifier) {
        return new RestService(this.delegateRestService, uri, identifier);
    }
};
exports.RestServiceFactory.$inject = ["delegateRestService"];
/* @ngInject */ exports.RestServiceFactory = __decorate([
    smarteditcommons.SeDowngradeService(),
    core.Injectable(),
    __metadata("design:paramtypes", [exports.DelegateRestService])
], /* @ngInject */ exports.RestServiceFactory);

/** @internal */
/* @ngInject */ exports.SessionService = class /* @ngInject */ SessionService extends smarteditcommons.ISessionService {
    constructor() {
        super();
    }
};
/* @ngInject */ exports.SessionService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.ISessionService),
    smarteditcommons.GatewayProxied(),
    core.Injectable(),
    __metadata("design:paramtypes", [])
], /* @ngInject */ exports.SessionService);

/** @internal */
/* @ngInject */ exports.SharedDataService = class /* @ngInject */ SharedDataService extends smarteditcommons.ISharedDataService {
    constructor() {
        super();
    }
};
/* @ngInject */ exports.SharedDataService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.ISharedDataService),
    smarteditcommons.GatewayProxied(),
    __metadata("design:paramtypes", [])
], /* @ngInject */ exports.SharedDataService);

/** @internal */
/* @ngInject */ exports.StorageService = class /* @ngInject */ StorageService extends smarteditcommons.IStorageService {
    constructor() {
        super();
    }
};
/* @ngInject */ exports.StorageService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IStorageService),
    smarteditcommons.GatewayProxied(),
    __metadata("design:paramtypes", [])
], /* @ngInject */ exports.StorageService);

/** @internal */
/* @ngInject */ exports.UrlService = class /* @ngInject */ UrlService extends smarteditcommons.IUrlService {
};
/* @ngInject */ exports.UrlService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IUrlService),
    smarteditcommons.GatewayProxied('openUrlInPopup', 'path')
], /* @ngInject */ exports.UrlService);

/** @internal */
/* @ngInject */ exports.WaitDialogService = class /* @ngInject */ WaitDialogService extends smarteditcommons.IWaitDialogService {
};
/* @ngInject */ exports.WaitDialogService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IWaitDialogService),
    smarteditcommons.GatewayProxied()
], /* @ngInject */ exports.WaitDialogService);

/* @internal */
/* @ngInject */ exports.SeNamespaceService = class /* @ngInject */ SeNamespaceService {
    constructor(logService) {
        this.logService = logService;
        this.reprocessPage = lodash.debounce(this._reprocessPage.bind(this), 50);
    }
    // explain slot for multiple instances of component scenario
    renderComponent(componentId, componentType, parentId) {
        return this.namespace && typeof this.namespace.renderComponent === 'function'
            ? this.namespace.renderComponent(componentId, componentType, parentId)
            : false;
    }
    _reprocessPage() {
        if (this.namespace && typeof this.namespace.reprocessPage === 'function') {
            this.namespace.reprocessPage();
            return;
        }
        this.logService.warn('No reprocessPage function defined on smartediFt namespace');
    }
    get namespace() {
        window.smartedit = window.smartedit || {};
        return window.smartedit;
    }
};
exports.SeNamespaceService.$inject = ["logService"];
/* @ngInject */ exports.SeNamespaceService = __decorate([
    smarteditcommons.SeDowngradeService(),
    __metadata("design:paramtypes", [smarteditcommons.LogService])
], /* @ngInject */ exports.SeNamespaceService);

/* @ngInject */ exports.PermissionService = class /* @ngInject */ PermissionService extends smarteditcommons.IPermissionService {
    constructor(logService) {
        super();
        this.logService = logService;
    }
    _remoteCallRuleVerify(ruleKey, permissionNameObjs) {
        if (this.ruleVerifyFunctions && this.ruleVerifyFunctions[ruleKey]) {
            return this.ruleVerifyFunctions[ruleKey].verify(permissionNameObjs);
        }
        this.logService.warn('could not call rule verify function for rule key: ' +
            ruleKey +
            ', it was not found in the iframe');
        return null;
    }
};
exports.PermissionService.$inject = ["logService"];
/* @ngInject */ exports.PermissionService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IPermissionService),
    smarteditcommons.GatewayProxied(),
    __metadata("design:paramtypes", [smarteditcommons.LogService])
], /* @ngInject */ exports.PermissionService);

/** @internal */
/* @ngInject */ exports.AlertService = class /* @ngInject */ AlertService extends smarteditcommons.IAlertService {
};
/* @ngInject */ exports.AlertService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IAlertService),
    smarteditcommons.GatewayProxied(),
    core.Injectable()
], /* @ngInject */ exports.AlertService);

/* @ngInject */ exports.AuthenticationService = class /* @ngInject */ AuthenticationService extends smarteditcommons.IAuthenticationService {
};
/* @ngInject */ exports.AuthenticationService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IAuthenticationService),
    smarteditcommons.GatewayProxied()
], /* @ngInject */ exports.AuthenticationService);

/**
 * This service enables and disables decorators. It also maps decorators to SmartEdit component types–regardless if they are enabled or disabled.
 *
 */
/* @ngInject */ exports.DecoratorService = class /* @ngInject */ DecoratorService {
    constructor(promiseUtils, stringUtils, legacyDecoratorToCustomElementConverter) {
        this.promiseUtils = promiseUtils;
        this.stringUtils = stringUtils;
        this.legacyDecoratorToCustomElementConverter = legacyDecoratorToCustomElementConverter;
        this._activeDecorators = {};
        this.componentDecoratorsMap = {};
    }
    /**
     * This method enables a list of decorators for a group of component types.
     * The list to be [enable]{@link DecoratorService#enable} is identified by a matching pattern.
     * The list is enabled when a perspective or referenced perspective that it is bound to is activated/enabled.
     *
     *
     *
     *      decoratorService.addMappings({
     *          '*Suffix': ['decorator1', 'decorator2'],
     *          '.*Suffix': ['decorator2', 'decorator3'],
     *          'MyExactType': ['decorator3', 'decorator4'],
     *          '^((?!Middle).)*$': ['decorator4', 'decorator5']
     *      });
     *
     *
     * @param  map A key-map value; the key is the matching pattern and the value is an array of decorator keys. The key can be an exact type, an ant-like wild card, or a full regular expression:
     */
    addMappings(map) {
        for (const regexpKey in map) {
            if (map.hasOwnProperty(regexpKey)) {
                const decoratorsArray = map[regexpKey];
                this.legacyDecoratorToCustomElementConverter.convertIfNeeded(decoratorsArray);
                this.componentDecoratorsMap[regexpKey] = lodash.union(this.componentDecoratorsMap[regexpKey] || [], decoratorsArray);
            }
        }
    }
    /**
     * Enables a decorator
     *
     * @param decoratorKey The key that uniquely identifies the decorator.
     * @param displayCondition Returns a promise that will resolve to a boolean that determines whether the decorator will be displayed.
     */
    enable(decoratorKey, displayCondition) {
        if (!(decoratorKey in this._activeDecorators)) {
            this._activeDecorators[decoratorKey] = {
                displayCondition
            };
        }
    }
    /**
     * Disables a decorator
     *
     * @param decoratorKey the decorator key
     */
    disable(decoratorKey) {
        if (this._activeDecorators[decoratorKey]) {
            delete this._activeDecorators[decoratorKey];
        }
    }
    /**
     * This method retrieves a list of decorator keys that is eligible for the specified component type.
     * The list retrieved depends on which perspective is active.
     *
     * This method uses the list of decorators enabled by the [addMappings]{@link DecoratorService#addMappings} method.
     *
     * @param componentType The type of the component to be decorated.
     * @param componentId The id of the component to be decorated.
     * @returns A promise that resolves to a list of decorator keys.
     *
     */
    getDecoratorsForComponent(componentType, componentId) {
        let decoratorArray = [];
        if (this.componentDecoratorsMap) {
            for (const regexpKey in this.componentDecoratorsMap) {
                if (this.stringUtils.regExpFactory(regexpKey).test(componentType)) {
                    decoratorArray = lodash.union(decoratorArray, this.componentDecoratorsMap[regexpKey]);
                }
            }
        }
        return this.getDecoratorPromise(decoratorArray, componentType, componentId);
    }
    getDecoratorPromise(decoratorArray, componentType, componentId) {
        const promisesToResolve = [];
        const displayedDecorators = [];
        decoratorArray.forEach((dec) => {
            const activeDecorator = this._activeDecorators[dec];
            if (activeDecorator && activeDecorator.displayCondition) {
                if (typeof activeDecorator.displayCondition !== 'function') {
                    throw new Error("The active decorator's displayCondition property must be a function and must return a boolean");
                }
                const deferred = this.promiseUtils.defer();
                activeDecorator
                    .displayCondition(componentType, componentId)
                    .then((display) => {
                    if (display) {
                        deferred.resolve(dec);
                    }
                    else {
                        deferred.resolve(null);
                    }
                });
                promisesToResolve.push(deferred.promise);
            }
            else if (activeDecorator) {
                displayedDecorators.push(dec);
            }
        });
        return Promise.all(promisesToResolve).then((decoratorsEnabled) => displayedDecorators.concat(decoratorsEnabled.filter((dec) => dec)));
    }
};
exports.DecoratorService.$inject = ["promiseUtils", "stringUtils", "legacyDecoratorToCustomElementConverter"];
/* @ngInject */ exports.DecoratorService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IDecoratorService),
    core.Injectable(),
    __metadata("design:paramtypes", [smarteditcommons.PromiseUtils,
        smarteditcommons.StringUtils,
        smarteditcommons.ILegacyDecoratorToCustomElementConverter])
], /* @ngInject */ exports.DecoratorService);

/* @internal */
/* @ngInject */ exports.TranslationsFetchService = class /* @ngInject */ TranslationsFetchService extends smarteditcommons.ITranslationsFetchService {
    get(lang) {
        'proxyFunction';
        return null;
    }
    isReady() {
        'proxyFunction';
        return null;
    }
    waitToBeReady() {
        'proxyFunction';
        return null;
    }
};
/* @ngInject */ exports.TranslationsFetchService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.ITranslationsFetchService),
    smarteditcommons.GatewayProxied(),
    core.Injectable()
], /* @ngInject */ exports.TranslationsFetchService);

/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
const CONTENT_PLACEHOLDER = 'CONTENT_PLACEHOLDER';
const scopes = [];
function angularJSDecoratorCustomElementClassFactory(upgrade, nodeUtils, componentName) {
    return class extends smarteditcommons.AbstractAngularJSBasedCustomElement {
        /**
         * Avoid changing anything (no DOM changes) to the custom element in the constructor (Safari throw NotSupportedError).
         */
        constructor() {
            super(upgrade);
            // this.attachShadow({mode: 'open'});
        }
        static get observedAttributes() {
            return ['active'];
        }
        internalConnectedCallback() {
            this.markAsProcessed();
            let componentAttributes;
            try {
                componentAttributes = nodeUtils.collectSmarteditAttributesByElementUuid(this.getAttribute(smarteditcommons.ELEMENT_UUID_ATTRIBUTE));
            }
            catch (e) {
                // the original component may have disappeared in the meantime
                return;
            }
            /* compile should only happen in one layer,
             * other layers will iteratively be compiled by their own custom element
             * these layers are therefore to be removed before compilation
             */
            this.content =
                this.content ||
                    Array.from(this.childNodes).find((childNode) => childNode.nodeType === Node.ELEMENT_NODE);
            // const computedStyle = window.getComputedStyle(this.content);
            const placeholder = document.createElement(CONTENT_PLACEHOLDER);
            // placeholder.style.width = computedStyle.width + "px";
            // placeholder.style.height = computedStyle.height + "px";
            // placeholder.style.minHeight = "49px";
            // placeholder.style.minWidth = "51px";
            while (this.firstChild) {
                this.removeChild(this.firstChild);
            }
            this.appendChild(placeholder);
            const actualActiveState = this.getAttribute('active') === 'true';
            this.setAttribute('active', 'active');
            // compile should only happen in one layer
            this.scope = this.$rootScope.$new(false);
            scopes.push(this.scopeIdentifier);
            this.scope.active = actualActiveState;
            this.scope.componentAttributes = componentAttributes;
            const compiledClone = this.$compile(this)(this.scope)[0];
            // const style = document.createElement('style');
            // style.innerHTML = `
            // 		:host {
            // 			display: block;
            // 		}`;
            // this.shadowRoot.appendChild(style);
            // reappending content after potentially asynchronous compilation
            /*
             * When using templateUrl, rendering is asynchronous
             * we need wait until the place holder is transcluded before continuing
             */
            smarteditcommons.promiseUtils.waitOnCondition(() => !!compiledClone.querySelector(CONTENT_PLACEHOLDER), () => {
                compiledClone.querySelector(CONTENT_PLACEHOLDER).replaceWith(this.content);
                // this.shadowRoot.append(compiledClone);
            }, `decorator ${componentName} doesn't seem to contain contain an ng-transclude statement`);
        }
        internalAttributeChangedCallback(name, oldValue, newValue) {
            /*
             * attributes don't change in the case of decorators:
             * - they come from the shallow clone itself
             * - only active flag changes but because of the full rewrapping it goes through constructor
             */
            this.scope.active = newValue === 'true';
        }
        internalDisconnectedCallback() {
            scopes.splice(scopes.indexOf(this.scopeIdentifier), 1);
        }
        get scopeIdentifier() {
            return `${this.getAttribute(smarteditcommons.ID_ATTRIBUTE)}_${this.tagName}`;
        }
    };
}
/* @ngInject */ exports.LegacyDecoratorToCustomElementConverter = class /* @ngInject */ LegacyDecoratorToCustomElementConverter {
    constructor(upgrade, nodeUtils) {
        this.upgrade = upgrade;
        this.nodeUtils = nodeUtils;
        this.convertedDecorators = [];
    }
    // for e2e purposes
    getScopes() {
        return scopes;
    }
    /*
     * Decorators are first class components:
     * even though they are built hierarchically, they are independant on one another and their scope should not be chained.
     * As a consequence, compiling them seperately is not an issue and thus enables converting them
     * to custom elements.
     */
    convert(_componentName) {
        const componentName = _componentName.replace('se.', '');
        const originalName = lodash.kebabCase(componentName);
        if (!customElements.get(originalName)) {
            // may already have been defined through DI
            const CustomComponentClass = angularJSDecoratorCustomElementClassFactory(this.upgrade, this.nodeUtils, componentName);
            customElements.define(originalName, CustomComponentClass);
        }
    }
    convertIfNeeded(componentNames) {
        componentNames.forEach((componentName) => {
            if (this.convertedDecorators.indexOf(componentName) === -1) {
                this.convertedDecorators.push(componentName);
                this.convert(componentName);
            }
        });
    }
};
exports.LegacyDecoratorToCustomElementConverter.$inject = ["upgrade", "nodeUtils"];
/* @ngInject */ exports.LegacyDecoratorToCustomElementConverter = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.ILegacyDecoratorToCustomElementConverter),
    core.Injectable(),
    __metadata("design:paramtypes", [_static.UpgradeModule, smarteditcommons.NodeUtils])
], /* @ngInject */ exports.LegacyDecoratorToCustomElementConverter);

/** @internal */
/* @ngInject */ exports.RenderService = class /* @ngInject */ RenderService extends smarteditcommons.IRenderService {
    constructor(smarteditBootstrapGateway, httpClient, logService, yjQuery, alertService, componentHandlerService, crossFrameEventService, jQueryUtilsService, experienceService, seNamespaceService, systemEventService, notificationService, pageInfoService, perspectiveService, windowUtils, modalService) {
        super(yjQuery, systemEventService, notificationService, pageInfoService, perspectiveService, crossFrameEventService, windowUtils, modalService);
        this.smarteditBootstrapGateway = smarteditBootstrapGateway;
        this.httpClient = httpClient;
        this.logService = logService;
        this.yjQuery = yjQuery;
        this.alertService = alertService;
        this.componentHandlerService = componentHandlerService;
        this.crossFrameEventService = crossFrameEventService;
        this.jQueryUtilsService = jQueryUtilsService;
        this.experienceService = experienceService;
        this.seNamespaceService = seNamespaceService;
        this.systemEventService = systemEventService;
        this.crossFrameEventService.subscribe(smarteditcommons.EVENT_PERSPECTIVE_CHANGED, (eventId, isNonEmptyPerspective) => {
            this.renderPage(isNonEmptyPerspective);
        });
        this.crossFrameEventService.subscribe(smarteditcommons.EVENT_PERSPECTIVE_REFRESHED, (eventId, isNonEmptyPerspective) => {
            this.renderPage(isNonEmptyPerspective);
        });
        this.systemEventService.subscribe(smarteditcommons.CONTRACT_CHANGE_LISTENER_PROCESS_EVENTS.PROCESS_COMPONENTS, (eventId, componentsList) => {
            const components = lodash.map(componentsList, (component) => {
                if (component.dataset[smarteditcommons.SMARTEDIT_COMPONENT_PROCESS_STATUS] !==
                    smarteditcommons.CONTRACT_CHANGE_LISTENER_COMPONENT_PROCESS_STATUS.KEEP_VISIBLE) {
                    component.dataset[smarteditcommons.SMARTEDIT_COMPONENT_PROCESS_STATUS] = this.componentHandlerService.isOverlayOn()
                        ? smarteditcommons.CONTRACT_CHANGE_LISTENER_COMPONENT_PROCESS_STATUS.PROCESS
                        : smarteditcommons.CONTRACT_CHANGE_LISTENER_COMPONENT_PROCESS_STATUS.REMOVE;
                }
                return component;
            });
            return Promise.resolve(components);
        });
    }
    toggleOverlay(isVisible) {
        const overlay = this.componentHandlerService.getOverlay();
        overlay.css('visibility', isVisible ? 'visible' : 'hidden');
    }
    refreshOverlayDimensions(element = null) {
        element = element || this.yjQuery('body');
        const children = this.componentHandlerService.getFirstSmartEditComponentChildren(element);
        children.each((index, childElement) => {
            this.updateComponentSizeAndPosition(childElement);
            this.refreshOverlayDimensions(childElement);
        });
    }
    /**
     * Updates the dimensions of the overlay component element given the original component element and the overlay component itself.
     * If no overlay component is provided, it will be fetched through {@link componentHandlerService.getOverlayComponent}
     *
     * The overlay component is resized to be the same dimensions of the component for which it overlays, and positioned absolutely
     * on the page. Additionally, it is provided with a minimum height and width. The resizing takes into account both
     * the size of the component element, and the position based on iframe scrolling.
     *
     * @param {HTMLElement} element The original CMS component element from the storefront.
     * @param {HTMLElement =} componentOverlayElem The overlay component. If none is provided
     */
    updateComponentSizeAndPosition(element, componentOverlayElem) {
        const componentElem = this.yjQuery(element);
        componentOverlayElem =
            componentOverlayElem ||
                this.componentHandlerService.getComponentCloneInOverlay(componentElem).get(0);
        if (!componentOverlayElem) {
            return;
        }
        const parentPos = this._getParentInOverlay(componentElem).get(0).getBoundingClientRect();
        const innerWidth = componentElem.get(0).offsetWidth;
        const innerHeight = componentElem.get(0).offsetHeight;
        // Update the position based on the IFrame Scrolling
        const pos = componentElem.get(0).getBoundingClientRect();
        const elementTopPos = pos.top - parentPos.top;
        const elementLeftPos = pos.left - parentPos.left;
        // In SakExecutorService.ts, the 'position' and 'top' will decide the slot-contextual-menu show at top of slot or bottom of slot
        componentOverlayElem.style.position = 'absolute';
        componentOverlayElem.style.top = elementTopPos + 'px';
        componentOverlayElem.style.left = elementLeftPos + 'px';
        componentOverlayElem.style.width = innerWidth + 'px';
        componentOverlayElem.style.height = innerHeight + 'px';
        componentOverlayElem.style.minWidth = '51px';
        componentOverlayElem.style.minHeight = '48px';
        const cloneId = this._buildShallowCloneId(componentElem.attr(smarteditcommons.ID_ATTRIBUTE), componentElem.attr(smarteditcommons.TYPE_ATTRIBUTE), componentElem.attr(smarteditcommons.CONTAINER_ID_ATTRIBUTE));
        const shallowCopy = this.yjQuery(componentOverlayElem).find('[id="' + cloneId + '"]');
        shallowCopy.width(innerWidth);
        shallowCopy.height(innerHeight);
        shallowCopy.css('min-height', 49);
        shallowCopy.css('min-width', 51);
    }
    renderPage(isRerender) {
        if (isRerender) {
            this._resizeSlots();
        }
        this.componentHandlerService.getOverlay().hide();
        this.isRenderingBlocked().then((isRenderingBlocked) => {
            this._markSmartEditAsReady();
            const overlay = this._createOverlay();
            if (isRerender && !isRenderingBlocked) {
                overlay.show();
            }
            this.systemEventService.publish(smarteditcommons.CONTRACT_CHANGE_LISTENER_PROCESS_EVENTS.RESTART_PROCESS);
            this.crossFrameEventService.publish(smarteditcommons.OVERLAY_RERENDERED_EVENT);
        });
    }
    renderSlots(_slotIds = null) {
        return __awaiter(this, void 0, void 0, function* () {
            if (smarteditcommons.stringUtils.isBlank(_slotIds) || (_slotIds instanceof Array && _slotIds.length === 0)) {
                return Promise.reject('renderService.renderSlots.slotIds.required');
            }
            if (typeof _slotIds === 'string') {
                _slotIds = [_slotIds];
            }
            // need to retrieve unique set of slotIds, happens when moving a component within a slot
            const slotIds = lodash.uniqBy(_slotIds, (slotId) => slotId);
            // see if storefront can handle the rerendering
            const slotsRemaining = slotIds.filter((id) => !this.seNamespaceService.renderComponent(id, 'ContentSlot'));
            if (slotsRemaining.length <= 0) {
                // all were handled by storefront
                return true;
            }
            else {
                let storefrontUrl;
                let response;
                try {
                    storefrontUrl = yield this.experienceService.buildRefreshedPreviewUrl();
                }
                catch (e) {
                    this.logService.error('renderService.renderSlots() - error with buildRefreshedPreviewUrl');
                    return Promise.reject(e);
                }
                try {
                    response = yield this.httpClient
                        .get(storefrontUrl, {
                        headers: {
                            Accept: 'text/html',
                            Pragma: 'no-cache'
                        },
                        responseType: 'text'
                    })
                        .toPromise();
                }
                catch (e) {
                    this.alertService.showDanger({
                        message: e
                    });
                    return Promise.reject(e);
                }
                const root = this.jQueryUtilsService.unsafeParseHTML(response);
                slotsRemaining.forEach((slotId) => {
                    const slotSelector = '.' +
                        smarteditcommons.COMPONENT_CLASS +
                        '[' +
                        smarteditcommons.TYPE_ATTRIBUTE +
                        "='ContentSlot'][" +
                        smarteditcommons.ID_ATTRIBUTE +
                        "='" +
                        slotId +
                        "']";
                    const slotToBeRerendered = this.jQueryUtilsService.extractFromElement(root, slotSelector);
                    const originalSlot = this.yjQuery(slotSelector);
                    originalSlot.html(slotToBeRerendered.html());
                    if (originalSlot.data('smartedit-resized-slot')) {
                        // reset the slot height to auto because the originalSlot height could have been changed previously with a specific height.
                        originalSlot.css('height', 'auto');
                    }
                });
                this._reprocessPage();
                return Promise.resolve();
            }
        });
    }
    renderComponent(componentId, componentType) {
        const component = this.componentHandlerService.getComponent(componentId, componentType);
        const slotId = this.componentHandlerService.getParent(component).attr(smarteditcommons.ID_ATTRIBUTE);
        if (this.seNamespaceService.renderComponent(componentId, componentType, slotId)) {
            return Promise.resolve(true);
        }
        else {
            return this.renderSlots(slotId);
        }
    }
    renderRemoval(componentId, componentType, slotId) {
        const removedComponents = this.componentHandlerService
            .getComponentUnderSlot(componentId, componentType, slotId)
            .remove();
        this.refreshOverlayDimensions();
        return removedComponents;
    }
    /**
     * Given a smartEdit component in the storefront layer, its clone in the smartEdit overlay is removed and the pertaining decorators destroyed.
     *
     * @param {Element} element The original CMS component element from the storefront.
     * @param {Element=} parent the closest smartEditComponent parent, expected to be null for the highest elements
     * @param {Object=} oldAttributes The map of former attributes of the element. necessary when the element has mutated since the last creation
     */
    destroyComponent(_component, _parent, oldAttributes) {
        const component = this.yjQuery(_component);
        const parent = this.yjQuery(_parent);
        const componentInOverlayId = oldAttributes && oldAttributes[smarteditcommons.ID_ATTRIBUTE]
            ? oldAttributes[smarteditcommons.ID_ATTRIBUTE]
            : component.attr(smarteditcommons.ID_ATTRIBUTE);
        const componentInOverlayType = oldAttributes && oldAttributes[smarteditcommons.TYPE_ATTRIBUTE]
            ? oldAttributes[smarteditcommons.TYPE_ATTRIBUTE]
            : component.attr(smarteditcommons.TYPE_ATTRIBUTE);
        // the node is no longer attached so can't find parent
        if (parent.attr(smarteditcommons.ID_ATTRIBUTE)) {
            this.componentHandlerService
                .getOverlayComponentWithinSlot(componentInOverlayId, componentInOverlayType, parent.attr(smarteditcommons.ID_ATTRIBUTE))
                .remove();
        }
        else {
            this.componentHandlerService
                .getComponentInOverlay(componentInOverlayId, componentInOverlayType)
                .remove();
        }
    }
    /**
     * Given a smartEdit component in the storefront layer. An empty clone of it will be created, sized and positioned in the smartEdit overlay
     * then compiled with all eligible decorators for the given perspective (see {@link smarteditServicesModule.interface:IPerspectiveService perspectiveService})
     * @param {Element} element The original CMS component element from the storefront.
     */
    createComponent(element) {
        if (this.componentHandlerService.isOverlayOn() && this._isComponentVisible(element)) {
            this._cloneComponent(element);
        }
    }
    /**
     * Resizes the height of all slots on the page based on the sizes of the components. The new height of the
     * slot is set to the minimum height encompassing its sub-components, calculated by comparing each of the
     * sub-components' top and bottom bounding rectangle values.
     *
     * Slots that do not have components inside still appear in the DOM. If the CMS manager is in a perspective in which
     * slot contextual menus are displayed, slots must have a height. Otherwise, overlays will overlap. Thus, empty slots
     * are given a minimum size so that overlays match.
     *
     * fix CXEC-7224: If we set height of component slot 'auto', the height will be calculated automatically with proper size.
     * So it's not neccessary to call resizeSlots in smartedit.ts for different event.
     */
    _resizeSlots() {
        Array.prototype.slice
            .call(this.componentHandlerService.getFirstSmartEditComponentChildren(document.body))
            .forEach((slotComponent) => {
            slotComponent.style.height = 'auto';
        });
    }
    _getParentInOverlay(element) {
        const parent = this.componentHandlerService.getParent(element);
        if (parent.length) {
            return this.componentHandlerService.getOverlayComponent(parent);
        }
        else {
            return this.componentHandlerService.getOverlay();
        }
    }
    _buildShallowCloneId(smarteditComponentId, smarteditComponentType, smarteditContainerId) {
        const containerSection = !smarteditcommons.stringUtils.isBlank(smarteditContainerId)
            ? '_' + smarteditContainerId
            : '';
        return smarteditComponentId + '_' + smarteditComponentType + containerSection + '_overlay';
    }
    _cloneComponent(el) {
        if (!this.yjQuery(el).is(':visible')) {
            return;
        }
        const element = this.yjQuery(el);
        const parentOverlay = this._getParentInOverlay(element);
        if (!parentOverlay.length) {
            this.logService.error('renderService: parentOverlay empty for component:', element.attr(smarteditcommons.ID_ATTRIBUTE));
            return;
        }
        if (!this._validateComponentAttributesContract(element)) {
            return;
        }
        // FIXME: CMSX-6139: use dataset instead of attr(): ELEMENT_UUID_ATTRIBUTE value should not be exposed.
        const elementUUID = smarteditcommons.stringUtils.generateIdentifier();
        if (!element.attr(smarteditcommons.ELEMENT_UUID_ATTRIBUTE)) {
            element.attr(smarteditcommons.ELEMENT_UUID_ATTRIBUTE, elementUUID);
        }
        const smarteditComponentId = element.attr(smarteditcommons.ID_ATTRIBUTE);
        const smarteditComponentType = element.attr(smarteditcommons.TYPE_ATTRIBUTE);
        const smarteditContainerId = element.attr(smarteditcommons.CONTAINER_ID_ATTRIBUTE);
        const shallowCopy = this._getDocument().createElement('div');
        shallowCopy.id = this._buildShallowCloneId(smarteditComponentId, smarteditComponentType, smarteditContainerId);
        const smartEditWrapper = this._getDocument().createElement('smartedit-element');
        const componentDecorator = this.yjQuery(smartEditWrapper);
        componentDecorator.append(shallowCopy);
        this.updateComponentSizeAndPosition(element.get(0), smartEditWrapper);
        if (smarteditComponentType === 'NavigationBarCollectionComponent') {
            // Make sure the Navigation Bar is on top of the navigation items
            smartEditWrapper.style.zIndex = '7';
        }
        componentDecorator.addClass(smarteditcommons.OVERLAY_COMPONENT_CLASS);
        Array.prototype.slice.apply(element.get(0).attributes).forEach((node) => {
            if (node.nodeName.indexOf(smarteditcommons.SMARTEDIT_ATTRIBUTE_PREFIX) === 0) {
                componentDecorator.attr(node.nodeName, node.nodeValue);
            }
        });
        parentOverlay.append(smartEditWrapper);
    }
    _createOverlay() {
        const overlayWrapper = this.componentHandlerService.getOverlay();
        if (overlayWrapper.length) {
            return overlayWrapper;
        }
        const overlay = this._getDocument().createElement('div');
        overlay.id = smarteditcommons.OVERLAY_ID;
        overlay.style.position = 'absolute';
        overlay.style.top = '0px';
        overlay.style.left = '0px';
        overlay.style.bottom = '0px';
        overlay.style.right = '0px';
        overlay.style.display = 'none';
        document.body.appendChild(overlay);
        return this.yjQuery(overlay);
    }
    _validateComponentAttributesContract(element) {
        const requiredAttributes = [
            smarteditcommons.ID_ATTRIBUTE,
            smarteditcommons.UUID_ATTRIBUTE,
            smarteditcommons.TYPE_ATTRIBUTE,
            smarteditcommons.CATALOG_VERSION_UUID_ATTRIBUTE
        ];
        let valid = true;
        requiredAttributes.forEach((reqAttribute) => {
            if (!element || !element.attr(reqAttribute)) {
                valid = false;
                this.logService.warn('RenderService - smarteditComponent element discovered with missing contract attribute: ' +
                    reqAttribute);
            }
        });
        return valid;
    }
    _markSmartEditAsReady() {
        this.smarteditBootstrapGateway.getInstance().publish('smartEditReady', {});
    }
    _isComponentVisible(component) {
        // NOTE: This might not work as expected for fixed positioned items. For those cases a more expensive
        // check must be performed (get the component style and check if it's visible or not).
        return component.offsetParent !== null;
    }
    _reprocessPage() {
        this.seNamespaceService.reprocessPage();
    }
};
exports.RenderService.$inject = ["smarteditBootstrapGateway", "httpClient", "logService", "yjQuery", "alertService", "componentHandlerService", "crossFrameEventService", "jQueryUtilsService", "experienceService", "seNamespaceService", "systemEventService", "notificationService", "pageInfoService", "perspectiveService", "windowUtils", "modalService"];
/* @ngInject */ exports.RenderService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IRenderService),
    smarteditcommons.GatewayProxied('blockRendering', 'isRenderingBlocked', 'renderSlots', 'renderComponent', 'renderRemoval', 'toggleOverlay', 'refreshOverlayDimensions', 'renderPage'),
    __param(3, core.Inject(smarteditcommons.YJQUERY_TOKEN)),
    __metadata("design:paramtypes", [smarteditcommons.SmarteditBootstrapGateway,
        http.HttpClient,
        smarteditcommons.LogService, Function, smarteditcommons.IAlertService,
        smarteditcommons.ComponentHandlerService,
        smarteditcommons.CrossFrameEventService,
        smarteditcommons.JQueryUtilsService,
        smarteditcommons.IExperienceService,
        exports.SeNamespaceService,
        smarteditcommons.SystemEventService,
        smarteditcommons.INotificationService,
        smarteditcommons.IPageInfoService,
        smarteditcommons.IPerspectiveService,
        smarteditcommons.WindowUtils,
        smarteditcommons.ModalService])
], /* @ngInject */ exports.RenderService);

/* @ngInject */ exports.IframeClickDetectionService = class /* @ngInject */ IframeClickDetectionService extends smarteditcommons.IIframeClickDetectionService {
    constructor(document) {
        super();
        document.addEventListener('mousedown', () => this.onIframeClick());
    }
};
exports.IframeClickDetectionService.$inject = ["document"];
/* @ngInject */ exports.IframeClickDetectionService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IIframeClickDetectionService),
    smarteditcommons.GatewayProxied('onIframeClick'),
    core.Injectable(),
    __param(0, core.Inject(common.DOCUMENT)),
    __metadata("design:paramtypes", [Document])
], /* @ngInject */ exports.IframeClickDetectionService);

/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
class ToolbarService extends smarteditcommons.IToolbarService {
    constructor(gatewayId, gatewayProxy, logService, $templateCache, permissionService) {
        super(logService, $templateCache, permissionService);
        this.gatewayId = gatewayId;
        gatewayProxy.initForService(this, [
            'addAliases',
            'removeItemByKey',
            'removeAliasByKey',
            '_removeItemOnInner',
            'triggerActionOnInner'
        ]);
    }
    _removeItemOnInner(itemKey) {
        if (itemKey in this.actions) {
            delete this.actions[itemKey];
        }
        this.logService.warn('removeItemByKey() - Failed to find action for key ' + itemKey);
    }
    triggerActionOnInner(action) {
        if (!this.actions[action.key]) {
            this.logService.error('triggerActionByKey() - Failed to find action for key ' + action.key);
            return;
        }
        this.actions[action.key]();
    }
}

/* @ngInject */ exports.ToolbarServiceFactory = class /* @ngInject */ ToolbarServiceFactory {
    constructor(gatewayProxy, logService, lazy, permissionService) {
        this.gatewayProxy = gatewayProxy;
        this.logService = logService;
        this.lazy = lazy;
        this.permissionService = permissionService;
        this.toolbarServicesByGatewayId = {};
    }
    getToolbarService(gatewayId) {
        if (!this.toolbarServicesByGatewayId[gatewayId]) {
            this.toolbarServicesByGatewayId[gatewayId] = new ToolbarService(gatewayId, this.gatewayProxy, this.logService, this.lazy.$templateCache(), this.permissionService);
        }
        return this.toolbarServicesByGatewayId[gatewayId];
    }
};
exports.ToolbarServiceFactory.$inject = ["gatewayProxy", "logService", "lazy", "permissionService"];
/* @ngInject */ exports.ToolbarServiceFactory = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IToolbarServiceFactory),
    __metadata("design:paramtypes", [smarteditcommons.GatewayProxy,
        smarteditcommons.LogService,
        smarteditcommons.AngularJSLazyDependenciesService,
        smarteditcommons.IPermissionService])
], /* @ngInject */ exports.ToolbarServiceFactory);

/**
 * Internal service
 *
 * Service that resizes slots and components in the Inner Frame when the overlay is enabled or disabled.
 */
/* @ngInject */ exports.ResizeComponentService = class /* @ngInject */ ResizeComponentService {
    constructor(componentHandlerService, yjQuery) {
        this.componentHandlerService = componentHandlerService;
        this.yjQuery = yjQuery;
    }
    /**
     * This methods appends CSS classes to inner frame slots and components. Passing a boolean true to showResizing
     * enables the resizing, and false vice versa.
     */
    resizeComponents(showResizing) {
        const slots = this.yjQuery(this.componentHandlerService.getAllSlotsSelector());
        const components = this.yjQuery(this.componentHandlerService.getAllComponentsSelector());
        if (showResizing) {
            slots.addClass('ySEEmptySlot');
            components.addClass('se-storefront-component');
        }
        else {
            slots.removeClass('ySEEmptySlot');
            components.removeClass('se-storefront-component');
        }
    }
};
exports.ResizeComponentService.$inject = ["componentHandlerService", "yjQuery"];
/* @ngInject */ exports.ResizeComponentService = __decorate([
    smarteditcommons.SeDowngradeService(),
    __param(1, core.Inject(smarteditcommons.YJQUERY_TOKEN)),
    __metadata("design:paramtypes", [smarteditcommons.ComponentHandlerService, Function])
], /* @ngInject */ exports.ResizeComponentService);

/**
 * Service aimed at determining the list of registered DOM elements that have been repositioned, regardless of how, since it was last queried
 */
/* @ngInject */ exports.PositionRegistry = class /* @ngInject */ PositionRegistry {
    constructor(yjQuery) {
        this.yjQuery = yjQuery;
        this.positionRegistry = [];
    }
    /**
     * registers a given node in the repositioning registry
     */
    register(element) {
        this.unregister(element);
        this.positionRegistry.push({
            element,
            position: this.calculatePositionHash(element)
        });
    }
    /**
     * unregisters a given node from the repositioning registry
     */
    unregister(element) {
        const entryToBeRemoved = this.positionRegistry.find((entry) => entry.element === element);
        const index = this.positionRegistry.indexOf(entryToBeRemoved);
        if (index > -1) {
            this.positionRegistry.splice(index, 1);
        }
    }
    /**
     * Method returning the list of nodes having been repositioned since last query
     */
    getRepositionedComponents() {
        return this.positionRegistry
            .filter((entry) => 
        // to ignore elements that would keep showing here because of things like display table-inline
        this.yjQuery(entry.element).height() !== 0)
            .filter((entry) => {
            const element = entry.element;
            const newPosition = this.calculatePositionHash(element);
            if (newPosition !== entry.position) {
                entry.position = newPosition;
                return true;
            }
            else {
                return false;
            }
        })
            .map((entry) => entry.element);
    }
    /**
     * unregisters all nodes and cleans up
     */
    dispose() {
        this.positionRegistry = [];
    }
    /**
     * for e2e test purposes
     */
    _listenerCount() {
        return this.positionRegistry.length;
    }
    floor(val) {
        return Math.floor(val * 100) / 100;
    }
    calculatePositionHash(element) {
        const rootPosition = this.yjQuery('body')[0].getBoundingClientRect();
        const position = element.getBoundingClientRect();
        return (this.floor(position.top - rootPosition.top) +
            '_' +
            this.floor(position.left - rootPosition.left));
    }
};
exports.PositionRegistry.$inject = ["yjQuery"];
/* @ngInject */ exports.PositionRegistry = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IPositionRegistry),
    __param(0, core.Inject(smarteditcommons.YJQUERY_TOKEN)),
    __metadata("design:paramtypes", [Function])
], /* @ngInject */ exports.PositionRegistry);

/* @ngInject */ exports.ResizeListener = class /* @ngInject */ ResizeListener {
    constructor() {
        this.resizeListenersRegistry = new Map();
        this._resizeObserver = new ResizeObserver__default['default']((entries) => {
            for (const entry of entries) {
                const element = entry.target;
                const registryElement = this.resizeListenersRegistry.get(element);
                registryElement.listener();
            }
        });
    }
    /**
     * registers a resize listener of a given node
     */
    register(element, listener) {
        if (!this.resizeListenersRegistry.has(element)) {
            this.resizeListenersRegistry.set(element, { listener });
            this._resizeObserver.observe(element);
        }
    }
    /**
     * unregisters listeners on all nodes and cleans up
     */
    dispose() {
        this.resizeListenersRegistry.forEach((entry, element) => {
            this.unregister(element);
        });
    }
    /**
     * unregisters the resize listener of a given node
     */
    unregister(element) {
        if (this.resizeListenersRegistry.has(element)) {
            this._resizeObserver.unobserve(element);
            this.resizeListenersRegistry.delete(element);
        }
    }
    /*
     * for test purposes
     */
    _listenerCount() {
        return this.resizeListenersRegistry.size;
    }
};
/* @ngInject */ exports.ResizeListener = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IResizeListener),
    __metadata("design:paramtypes", [])
], /* @ngInject */ exports.ResizeListener);

/* @ngInject */ exports.CatalogVersionPermissionService = class /* @ngInject */ CatalogVersionPermissionService extends smarteditcommons.ICatalogVersionPermissionService {
    constructor() {
        super();
    }
};
/* @ngInject */ exports.CatalogVersionPermissionService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.ICatalogVersionPermissionService),
    smarteditcommons.GatewayProxied(),
    __metadata("design:paramtypes", [])
], /* @ngInject */ exports.CatalogVersionPermissionService);

var COMPONENT_STATE;
(function (COMPONENT_STATE) {
    COMPONENT_STATE["ADDED"] = "added";
    COMPONENT_STATE["DESTROYED"] = "destroyed";
})(COMPONENT_STATE || (COMPONENT_STATE = {}));
/*
 * interval at which manual listening/checks are executed
 * So far it is only by repositionListener
 * (resizeListener delegates to a self-contained third-party library and DOM mutations observation is done in native MutationObserver)
 */
/* @internal */
const DEFAULT_REPROCESS_TIMEOUT = 100;
/* @internal */
const DEFAULT_PROCESS_QUEUE_POLYFILL_INTERVAL = 250;
/* @internal */
const DEFAULT_CONTRACT_CHANGE_LISTENER_INTERSECTION_OBSERVER_OPTIONS = {
    // The root to use for intersection.
    // If not provided, use the top-level document’s viewport.
    root: null,
    // Same as margin, can be 1, 2, 3 or 4 components, possibly negative lengths.
    // If an explicit root element is specified, components may be percentages of the
    // root element size. If no explicit root element is specified, using a percentage
    // is an error.
    rootMargin: '1000px',
    // Threshold(s) at which to trigger callback, specified as a ratio, or list of
    // ratios, of (visible area / total area) of the observed element (hence all
    // entries must be in the range [0, 1]). Callback will be invoked when the visible
    // ratio of the observed element crosses a threshold in the list.
    threshold: 0
};
/* @internal */
const DEFAULT_CONTRACT_CHANGE_LISTENER_PROCESS_QUEUE_THROTTLE = 500;
/* @internal */
let /* @ngInject */ SmartEditContractChangeListener = class /* @ngInject */ SmartEditContractChangeListener {
    constructor(yjQueryUtilsService, componentHandlerService, pageInfoService, resizeListener, positionRegistry, logService, yjQuery, systemEventService, polyfillService, testModeService, pageTreeNodeService) {
        this.yjQueryUtilsService = yjQueryUtilsService;
        this.componentHandlerService = componentHandlerService;
        this.pageInfoService = pageInfoService;
        this.resizeListener = resizeListener;
        this.positionRegistry = positionRegistry;
        this.logService = logService;
        this.yjQuery = yjQuery;
        this.systemEventService = systemEventService;
        this.polyfillService = polyfillService;
        this.testModeService = testModeService;
        this.pageTreeNodeService = pageTreeNodeService;
        /*
         * This is the configuration passed to the MutationObserver instance
         */
        this.MUTATION_OBSERVER_OPTIONS = {
            /*
             * enables observation of attribute mutations
             */
            attributes: true,
            /*
             * instruct the observer to keep in store the former values of the mutated attributes
             */
            attributeOldValue: true,
            /*
             * enables observation of addition and removal of nodes
             */
            childList: true,
            characterData: false,
            /*
             * enables recursive lookup without which only addition and removal of DIRECT children of the observed DOM root would be collected
             */
            subtree: true
        };
        /*
         * Component state values
         * 'added' when _componentsAddedCallback was called
         * 'destroyed' when _componentsRemovedCallback was called
         */
        this.enableExtendedView = false;
        /*
         * nullable callbacks provided to smartEditContractChangeListener for all the observed events
         */
        this._componentsAddedCallback = null;
        this._componentsRemovedCallback = null;
        this._componentResizedCallback = null;
        this._componentRepositionedCallback = null;
        this._onComponentChangedCallback = null;
        this._pageChangedCallback = null;
        this._throttledProcessQueue = lodash.throttle(() => this._rawProcessQueue(), DEFAULT_CONTRACT_CHANGE_LISTENER_PROCESS_QUEUE_THROTTLE);
        /*
         * Queue used to process components when intersecting the viewport
         * {Array.<{isIntersecting: Boolean, parent: DOMElement, processed: SmartEditContractChangeListener.COMPONENT_STATE}>}
         */
        this.componentsQueue = new Map();
        this.smartEditAttributeNames = [smarteditcommons.TYPE_ATTRIBUTE, smarteditcommons.ID_ATTRIBUTE, smarteditcommons.UUID_ATTRIBUTE];
    }
    /*
     * wrapping for test purposes
     */
    _newMutationObserver(callback) {
        return new MutationObserver(callback);
    }
    /*
     * wrapping for test purposes
     */
    _newIntersectionObserver(callback) {
        return new IntersectionObserver(callback, DEFAULT_CONTRACT_CHANGE_LISTENER_INTERSECTION_OBSERVER_OPTIONS);
    }
    /*
     * Add the given entry to the componentsQueue
     * The components in the queue are sorted according to their position in the DOM
     * so that the adding of components is done to have parents before children
     */
    _addToComponentQueue(entry) {
        const component = this.componentsQueue.get(entry.target);
        if (component) {
            component.isIntersecting = entry.isIntersecting;
        }
        else if (this.yjQueryUtilsService.isInDOM(entry.target)) {
            this.componentsQueue.set(entry.target, {
                component: entry.target,
                isIntersecting: entry.isIntersecting,
                processed: null,
                oldProcessedValue: null,
                parent: this.componentHandlerService.getParent(entry.target)[0]
            });
        }
    }
    /*
     * for e2e test purposes
     */
    _componentsQueueLength() {
        return this.componentsQueue.size;
    }
    isExtendedViewEnabled() {
        return this.enableExtendedView;
    }
    /**
     * Set the 'economyMode' to true for better performance.
     * In economyMode, resize/position listeners are not present, and the current economyMode value is passed to the add /remove callbacks.
     */
    setEconomyMode(_mode) {
        this.economyMode = _mode;
        if (!this.economyMode) {
            // reactivate
            Array.from(this.componentHandlerService.getFirstSmartEditComponentChildren(this.yjQuery('body'))).forEach((firstLevelComponent) => {
                this.applyToSelfAndAllChildren(firstLevelComponent, (node) => {
                    this._registerSizeAndPositionListeners(node);
                });
            });
        }
    }
    /*
     * initializes and starts all Intersection/DOM listeners:
     * - Intersection of smartEditComponents with the viewport
     * - DOM mutations on smartEditComponents and page identifier (by Means of native MutationObserver)
     * - smartEditComponents repositioning (by means of querying, with an interval, the list of repositioned components from the positionRegistry)
     * - smartEditComponents resizing (by delegating to the injected resizeListener)
     */
    initListener() {
        this.enableExtendedView = this.polyfillService.isEligibleForExtendedView();
        this.pageInfoService.getPageUUID().then((pageUUID) => {
            this.currentPage = pageUUID;
            if (this._pageChangedCallback) {
                this.executeCallback(this._pageChangedCallback.bind(undefined, this.currentPage));
            }
        });
        this.systemEventService.subscribe(smarteditcommons.CONTRACT_CHANGE_LISTENER_PROCESS_EVENTS.RESTART_PROCESS, () => {
            this._processQueue();
            return Promise.resolve();
        });
        // Intersection Observer not able to re-evaluate components that are not intersecting but going in and out of the extended viewport.
        if (this.enableExtendedView) {
            setInterval(() => {
                this._processQueue();
            }, DEFAULT_PROCESS_QUEUE_POLYFILL_INTERVAL);
        }
        this.mutationObserver = this._newMutationObserver(this.mutationObserverCallback.bind(this));
        this.mutationObserver.observe(document.body, this.MUTATION_OBSERVER_OPTIONS);
        // Intersection Observer is used to observe intersection of components with the viewport.
        // each time the 'isIntersecting' property of an entry (SmartEdit component) changes, the Intersection Callback is called.
        // we are using the componentsQueue to hold the components references and their isIntersecting value.
        this.intersectionObserver = this._newIntersectionObserver((entries) => {
            entries.forEach((entry) => {
                this._addToComponentQueue(entry);
            });
            // A better approach would be to process each entry individually instead of processing the whole queue, but a bug Firefox v.55 prevent us to do so.
            this._processQueue();
        });
        // Observing all SmartEdit components that are already in the page.
        // Note that when an element visible in the viewport is removed, the Intersection Callback is called so we don't need to use the Mutation Observe to observe the removal of Nodes.
        Array.from(this.componentHandlerService.getFirstSmartEditComponentChildren(this.yjQuery('body'))).forEach((firstLevelComponent) => {
            this.applyToSelfAndAllChildren(firstLevelComponent, this.intersectionObserver.observe.bind(this.intersectionObserver));
        });
        this._startExpendableListeners();
    }
    // Processing the queue with throttling in production to avoid scrolling lag when there is a lot of components in the page.
    // No throttling when e2e mode is active
    _processQueue() {
        if (this.testModeService.isE2EMode() || smarteditcommons.functionsUtils.isUnitTestMode()) {
            this._rawProcessQueue();
        }
        else {
            this._throttledProcessQueue();
        }
    }
    isIntersecting(obj) {
        if (!this.yjQueryUtilsService.isInDOM(obj.component)) {
            return false;
        }
        return this.enableExtendedView
            ? this.yjQueryUtilsService.isInExtendedViewPort(obj.component)
            : obj.isIntersecting;
    }
    // for each component in the componentsQueue, we use the 'isIntersecting' and 'processed' values to add or remove it.
    // An intersecting component that was not already added is added, and a non intersecting component that was added is removed (happens when scrolling, resizing the page, zooming, opening dev-tools)
    // the 'PROCESS_COMPONENTS' promise is RESOLVED when the component can be added or removed, and it is REJECTED when the component can't be added but could be removed.
    _rawProcessQueue() {
        const observedQueueArray = Array.from(this.componentsQueue.values());
        this.systemEventService
            .publish(smarteditcommons.CONTRACT_CHANGE_LISTENER_PROCESS_EVENTS.PROCESS_COMPONENTS, observedQueueArray.map(({ component }) => component))
            .then(this.publishSuccess.bind(this, observedQueueArray));
    }
    _addComponents(componentsObj) {
        if (this._componentsAddedCallback) {
            this.executeCallback(this._componentsAddedCallback.bind(undefined, lodash.map(componentsObj, 'component'), this.economyMode));
        }
        if (!this.economyMode) {
            componentsObj
                .filter((queueObj) => queueObj.oldProcessedValue === null)
                .forEach((queueObj) => {
                this._registerSizeAndPositionListeners(queueObj.component);
            });
        }
    }
    _removeComponents(componentsObj, forceRemoval = false) {
        componentsObj
            .filter((queueObj) => !this.yjQueryUtilsService.isInDOM(queueObj.component) || forceRemoval)
            .forEach((queueObj) => {
            if (!this.economyMode) {
                this._unregisterSizeAndPositionListeners(queueObj.component);
            }
            this.componentsQueue.delete(queueObj.component);
        });
        if (this._componentsRemovedCallback) {
            const removedComponents = componentsObj.map((obj) => lodash.pick(obj, ['component', 'parent', 'oldAttributes']));
            this.executeCallback(this._componentsRemovedCallback.bind(undefined, removedComponents, this.economyMode));
        }
    }
    _registerSizeAndPositionListeners(component) {
        if (this._componentRepositionedCallback) {
            this.positionRegistry.register(component);
        }
        if (this._componentResizedCallback) {
            this.resizeListener.register(component, this._componentResizedCallback.bind(undefined, component));
        }
    }
    _unregisterSizeAndPositionListeners(component) {
        if (this._componentRepositionedCallback) {
            this.positionRegistry.unregister(component);
        }
        if (this._componentResizedCallback) {
            this.resizeListener.unregister(component);
        }
    }
    /*
     * stops and clean up all listeners
     */
    stopListener() {
        // Stop listening for DOM mutations
        if (this.mutationObserver) {
            this.mutationObserver.disconnect();
        }
        this.intersectionObserver.disconnect();
        this.mutationObserver = null;
        this._stopExpendableListeners();
    }
    _stopExpendableListeners() {
        // Stop listening for DOM resize
        this.resizeListener.dispose();
        // Stop listening for DOM repositioning
        if (this.repositionListener) {
            clearInterval(this.repositionListener);
            this.repositionListener = null;
        }
        this.positionRegistry.dispose();
    }
    _startExpendableListeners() {
        if (this._componentRepositionedCallback) {
            this.repositionListener = setInterval(() => {
                this.positionRegistry
                    .getRepositionedComponents()
                    .forEach((component) => {
                    this._componentRepositionedCallback(component);
                });
            }, DEFAULT_REPROCESS_TIMEOUT);
        }
    }
    /*
     * registers a unique callback to be executed every time a smarteditComponent node is added to the DOM
     * it is executed only once per subtree of smarteditComponent nodes being added
     * the callback is invoked with the root node of a subtree
     */
    onComponentsAdded(callback) {
        this._componentsAddedCallback = callback;
    }
    /*
     * registers a unique callback to be executed every time a smarteditComponent node is removed from the DOM
     * it is executed only once per subtree of smarteditComponent nodes being removed
     * the callback is invoked with the root node of a subtree and its parent
     */
    onComponentsRemoved(callback) {
        this._componentsRemovedCallback = callback;
    }
    /*
     * registers a unique callback to be executed every time at least one of the smartEdit contract attributes of a smarteditComponent node is changed
     * the callback is invoked with the mutated node itself and the map of old attributes
     */
    onComponentChanged(callback) {
        this._onComponentChangedCallback = callback;
    }
    /*
     * registers a unique callback to be executed every time a smarteditComponent node is resized in the DOM
     * the callback is invoked with the resized node itself
     */
    onComponentResized(callback) {
        this._componentResizedCallback = callback;
    }
    /*
     * registers a unique callback to be executed every time a smarteditComponent node is repositioned (as per Node.getBoundingClientRect()) in the DOM
     * the callback is invoked with the resized node itself
     */
    onComponentRepositioned(callback) {
        this._componentRepositionedCallback = callback;
    }
    /*
     * registers a unique callback to be executed:
     * - upon bootstrapping smartEdit IF the page identifier is available
     * - every time the page identifier is changed in the DOM (see pageInfoService.getPageUUID())
     * the callback is invoked with the new page identifier read from pageInfoService.getPageUUID()
     */
    onPageChanged(callback) {
        this._pageChangedCallback = callback;
    }
    loopObservedQueue(observedQueue, response) {
        const addedComponents = [];
        const removedComponents = [];
        const responseSet = new Set(response || []);
        observedQueue.forEach((obj) => {
            if (!responseSet.has(obj.component)) {
                return;
            }
            const processStatus = obj.component.dataset[smarteditcommons.SMARTEDIT_COMPONENT_PROCESS_STATUS];
            switch (processStatus) {
                case smarteditcommons.CONTRACT_CHANGE_LISTENER_COMPONENT_PROCESS_STATUS.PROCESS:
                    if (obj.processed !== COMPONENT_STATE.ADDED && this.isIntersecting(obj)) {
                        addedComponents.push(obj);
                    }
                    else if (obj.processed === COMPONENT_STATE.ADDED &&
                        !this.isIntersecting(obj)) {
                        removedComponents.push(obj);
                    }
                    break;
                case smarteditcommons.CONTRACT_CHANGE_LISTENER_COMPONENT_PROCESS_STATUS.REMOVE:
                    if (obj.processed === COMPONENT_STATE.ADDED) {
                        removedComponents.push(obj);
                    }
                    break;
            }
            obj.oldProcessedValue = obj.processed;
        });
        addedComponents.forEach((queueObj) => {
            queueObj.processed = COMPONENT_STATE.ADDED;
        });
        removedComponents.forEach((queueObj) => {
            queueObj.processed = COMPONENT_STATE.DESTROYED;
        });
        return {
            addedComponents,
            removedComponents
        };
    }
    publishSuccess(observedQueue, response) {
        const { addedComponents, removedComponents } = this.loopObservedQueue(observedQueue, response);
        // If the intersection observer returns multiple time the same components in the callback (happen when doing a drag and drop or sfBuilder.actions.rerenderComponent)
        // we will have these same components in BOTH addedComponents and removedComponents, hence we must first call _removeComponents and then _addComponents (in this order).
        if (removedComponents.length) {
            this._removeComponents(removedComponents);
        }
        if (addedComponents.length) {
            addedComponents.sort(smarteditcommons.nodeUtils.compareHTMLElementsPosition('component'));
            this._addComponents(addedComponents);
        }
        if (!this.economyMode) {
            lodash.chain(addedComponents.concat(removedComponents))
                .filter((obj) => obj.oldProcessedValue === null ||
                !this.yjQueryUtilsService.isInDOM(obj.component))
                .map('parent')
                .compact()
                .uniq()
                .value()
                .forEach((parent) => {
                this.repairParentResizeListener(parent);
            });
        }
    }
    /*
     * Method used in mutationObserverCallback that extracts from mutations the list of nodes added
     * The nodes are returned within a pair along with their nullable closest smartEditComponent parent
     */
    aggregateAddedOrRemovedNodesAndTheirParents(mutations, type) {
        const entries = mutations
            .filter((mutation) => 
        // only keep mutations of type childList and [added/removed]Nodes
        mutation.type === smarteditcommons.MUTATION_TYPES.CHILD_LIST.NAME &&
            mutation[type] &&
            mutation[type].length)
            .map((mutation) => {
            // the mutated child may not be smartEditComponent, in such case we return their first level smartEditComponent children
            const children = lodash.flatten(Array.from(mutation[type])
                .filter((node) => node.nodeType === Node.ELEMENT_NODE)
                .map((child) => {
                if (this.componentHandlerService.isSmartEditComponent(child)) {
                    return child;
                }
                else {
                    return Array.from(this.componentHandlerService.getFirstSmartEditComponentChildren(child));
                }
            }))
                .sort(smarteditcommons.nodeUtils.compareHTMLElementsPosition());
            // nodes are returned in pairs with their nullable parent
            const parent = this.componentHandlerService.getClosestSmartEditComponent(mutation.target);
            return children.map((node) => ({
                node,
                parent: parent.length ? parent[0] : null
            }));
        });
        /*
         * Despite MutationObserver specifications it so happens that sometimes,
         * depending on the very way a parent node is added with its children,
         * parent AND children will appear in a same mutation. We then must only keep the parent
         * Since the parent will appear first, the filtering lodash.uniqWith will always return the parent as opposed to the child which is what we need
         */
        return lodash.uniqWith(lodash.flatten(entries), (entry1, entry2) => entry1.node.contains(entry2.node) || entry2.node.contains(entry1.node));
    }
    /*
     * Method used in mutationObserverCallback that extracts from mutations the list of nodes the attributes of which have changed
     * The nodes are returned within a pair along with their map of changed attributes
     */
    aggregateMutationsOnChangedAttributes(mutations) {
        const map = mutations.reduce((seed, mutation) => {
            if (!(mutation.target &&
                mutation.target.nodeType === Node.ELEMENT_NODE &&
                mutation.type === smarteditcommons.MUTATION_TYPES.ATTRIBUTES.NAME)) {
                return seed;
            }
            let targetEntry = seed.get(mutation.target);
            if (!targetEntry) {
                targetEntry = {
                    node: mutation.target,
                    oldAttributes: {}
                };
                seed.set(mutation.target, targetEntry);
            }
            targetEntry.oldAttributes[mutation.attributeName] = mutation.oldValue;
            return seed;
        }, new Map());
        return Array.from(map.values());
    }
    /**
     * Verifies whether the entry is a smartedit complient element.
     */
    isSmarteditNode(entry) {
        return (this.componentHandlerService.isSmartEditComponent(entry.node) &&
            this.smartEditAttributeNames.some((attributeName) => entry.node.hasAttribute(attributeName)));
    }
    /**
     * Verifies whether at least one of the changed attributes is a smartedit attribute.
     */
    isSmarteditAttributeChanged(entry) {
        return this.smartEditAttributeNames.some((attributeName) => entry.oldAttributes.hasOwnProperty(attributeName));
    }
    /**
     * Verifies whether the entry is not a smartedit element anymore.
     * It checks that all smartedit related attributes were removed and the
     * entry.node is still in the componentsQueue.
     */
    wasSmarteditNode(entry) {
        return (this.componentsQueue.has(entry.node) &&
            this.smartEditAttributeNames.every((attributeName) => !entry.node.hasAttribute(attributeName)));
    }
    /*
     * Methods used in mutationObserverCallback that determines whether the smartEdit contract page identifier MAY have changed in the DOM
     */
    mutationsHasPageChange(mutations) {
        return mutations.find((mutation) => {
            const element = mutation.target;
            return (mutation.type === smarteditcommons.MUTATION_TYPES.ATTRIBUTES.NAME &&
                element.tagName === 'BODY' &&
                mutation.attributeName === 'class');
        });
    }
    /*
     * convenience method to invoke a callback on a node and recursively on all its smartEditComponent children
     */
    applyToSelfAndAllChildren(node, callback) {
        callback(node);
        Array.from(this.componentHandlerService.getFirstSmartEditComponentChildren(node)).forEach((component) => {
            this.applyToSelfAndAllChildren(component, callback);
        });
    }
    repairParentResizeListener(parent) {
        if (parent) {
            // the adding of a component is likely to destroy the DOM added by the resizeListener on the parent, it needs be restored
            /*
             * since the DOM hierarchy is processed in order, by the time we need repair the parent,
             * it has already been processed so we can rely on its process status to know whether it is eligible
             */
            const parentObj = this.componentsQueue.get(parent);
            if (parentObj &&
                parentObj.processed === COMPONENT_STATE.ADDED &&
                this.yjQueryUtilsService.isInDOM(parent)) {
                this._componentResizedCallback(parent);
            }
        }
    }
    /*
     * when a callback is executed we make sure that angular is synchronized since it is occurring outside the life cycle
     */
    executeCallback(callback) {
        if (this.testModeService.isE2EMode() || smarteditcommons.functionsUtils.isUnitTestMode()) {
            callback();
        }
        else {
            setTimeout(() => callback(), 0);
        }
    }
    handleSmartEditNode(entry) {
        const component = this.componentsQueue.get(entry.node);
        if (!component) {
            // Newly created smartedit element should always be in the component queue. If the component was created from
            // a simple div tag by adding smartedit attributes we need first to add the component to the queue even if the current
            // operation is change. If the component is not added to the queue it won't be rendered cause during the change callback
            // it sometimes won't be able to find a parent overlay (if it is outside of the viewport).
            this.applyToSelfAndAllChildren(entry.node, this.intersectionObserver.observe.bind(this.intersectionObserver));
        }
        else {
            // the onComponentChanged is called with the mutated smartEditComponent subtree and the map of old attributes
            this.executeCallback(this._onComponentChangedCallback.bind(undefined, entry.node, entry.oldAttributes));
        }
    }
    handleNoSmarteditNode(entry) {
        this.applyToSelfAndAllChildren(entry.node, this.intersectionObserver.unobserve.bind(this.intersectionObserver));
        const parents = this.componentHandlerService.getClosestSmartEditComponent(entry.node);
        this._removeComponents([
            {
                isIntersecting: false,
                component: entry.node,
                parent: parents.length ? parents[0] : null,
                oldAttributes: entry.oldAttributes
            }
        ], true);
    }
    loopAggregateNodes(aggregatedNodes) {
        aggregatedNodes.forEach((childAndParent) => {
            this.applyToSelfAndAllChildren(childAndParent.node, (node) => {
                const component = this.componentsQueue.get(node);
                if (!component) {
                    return;
                }
                if (!this.economyMode) {
                    this.repairParentResizeListener(childAndParent.parent);
                }
                this._removeComponents([
                    {
                        isIntersecting: false,
                        component: node,
                        parent: childAndParent.parent
                    }
                ]);
            });
        });
    }
    loopMutationsOnChangedAttributes(mutations) {
        // TODO: are we missing tests here?
        this.aggregateMutationsOnChangedAttributes(mutations).forEach((entry) => {
            if (this.isSmarteditAttributeChanged(entry)) {
                if (this.isSmarteditNode(entry)) {
                    this.handleSmartEditNode(entry);
                }
                else if (this.wasSmarteditNode(entry)) {
                    this.handleNoSmarteditNode(entry);
                }
            }
        });
    }
    /*
     * callback executed by the mutation observer every time mutations occur.
     * repositioning and resizing are not part of this except that every time a smartEditComponent is added,
     * it is registered within the positionRegistry and the resizeListener
     */
    mutationObserverCallback(mutations) {
        this.logService.debug(mutations);
        if (this._pageChangedCallback && this.mutationsHasPageChange(mutations)) {
            this.pageInfoService.getPageUUID().then((newPageUUID) => {
                if (this.currentPage !== newPageUUID) {
                    this.executeCallback(this._pageChangedCallback.bind(undefined, newPageUUID));
                }
                this.currentPage = newPageUUID;
            });
        }
        const addNodes = this.aggregateAddedOrRemovedNodesAndTheirParents(mutations, smarteditcommons.MUTATION_TYPES.CHILD_LIST.ADD_OPERATION);
        this.pageTreeNodeService.updateSlotNodes(addNodes);
        if (this._componentsAddedCallback) {
            addNodes.forEach((childAndParent) => {
                this.applyToSelfAndAllChildren(childAndParent.node, this.intersectionObserver.observe.bind(this.intersectionObserver));
            });
        }
        const removeNodes = this.aggregateAddedOrRemovedNodesAndTheirParents(mutations, smarteditcommons.MUTATION_TYPES.CHILD_LIST.REMOVE_OPERATION);
        this.pageTreeNodeService.updateSlotNodes(removeNodes);
        this.loopAggregateNodes(removeNodes);
        if (this._onComponentChangedCallback) {
            this.loopMutationsOnChangedAttributes(mutations);
        }
    }
};
SmartEditContractChangeListener.$inject = ["yjQueryUtilsService", "componentHandlerService", "pageInfoService", "resizeListener", "positionRegistry", "logService", "yjQuery", "systemEventService", "polyfillService", "testModeService", "pageTreeNodeService"];
/* @ngInject */ SmartEditContractChangeListener = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.ISmartEditContractChangeListener),
    __param(6, core.Inject(smarteditcommons.YJQUERY_TOKEN)),
    __metadata("design:paramtypes", [smarteditcommons.JQueryUtilsService,
        smarteditcommons.ComponentHandlerService,
        smarteditcommons.IPageInfoService,
        smarteditcommons.IResizeListener,
        smarteditcommons.IPositionRegistry,
        smarteditcommons.LogService, Function, smarteditcommons.SystemEventService,
        smarteditcommons.PolyfillService,
        smarteditcommons.TestModeService,
        smarteditcommons.IPageTreeNodeService])
], /* @ngInject */ SmartEditContractChangeListener);

/**
 * Module containing all the services shared within the smartedit application
 */
/* @ngInject */ exports.LegacySmarteditServicesModule = class /* @ngInject */ LegacySmarteditServicesModule {
};
/* @ngInject */ exports.LegacySmarteditServicesModule = __decorate([
    smarteditcommons.SeModule({
        imports: ['coretemplates', 'seConstantsModule', 'yLoDashModule', smarteditcommons.LegacySmarteditCommonsModule],
        providers: [
            smarteditcommons.diNameUtils.makeValueProvider({ DEFAULT_REPROCESS_TIMEOUT }),
            smarteditcommons.diNameUtils.makeValueProvider({ DEFAULT_PROCESS_QUEUE_POLYFILL_INTERVAL }),
            smarteditcommons.diNameUtils.makeValueProvider({
                DEFAULT_CONTRACT_CHANGE_LISTENER_INTERSECTION_OBSERVER_OPTIONS
            }),
            smarteditcommons.diNameUtils.makeValueProvider({ DEFAULT_CONTRACT_CHANGE_LISTENER_PROCESS_QUEUE_THROTTLE })
        ]
    })
], /* @ngInject */ exports.LegacySmarteditServicesModule);

exports.SmarteditServicesModule = class SmarteditServicesModule {
};
exports.SmarteditServicesModule = __decorate([
    core.NgModule({
        imports: [smarteditcommons.DragAndDropServiceModule, smarteditcommons.SmarteditCommonsModule],
        providers: [
            { provide: smarteditcommons.IPermissionService, useClass: exports.PermissionService },
            exports.DelegateRestService,
            exports.RestServiceFactory,
            exports.ResizeListener,
            exports.SeNamespaceService,
            exports.ContextualMenuService,
            smarteditcommons.ComponentHandlerService,
            exports.ResizeComponentService,
            smarteditcommons.PriorityService,
            smarteditcommons.UserTrackingService,
            {
                provide: smarteditcommons.IRestServiceFactory,
                useClass: exports.RestServiceFactory
            },
            {
                provide: smarteditcommons.IRenderService,
                useClass: exports.RenderService
            },
            {
                provide: smarteditcommons.ICatalogVersionPermissionService,
                useClass: exports.CatalogVersionPermissionService
            },
            {
                provide: smarteditcommons.ISmartEditContractChangeListener,
                useClass: SmartEditContractChangeListener
            },
            { provide: smarteditcommons.IPageInfoService, useClass: exports.PageInfoService },
            {
                provide: smarteditcommons.IResizeListener,
                useClass: exports.ResizeListener
            },
            {
                provide: smarteditcommons.IPositionRegistry,
                useClass: exports.PositionRegistry
            },
            {
                provide: smarteditcommons.IAnnouncementService,
                useClass: exports.AnnouncementService
            },
            {
                provide: smarteditcommons.IPerspectiveService,
                useClass: exports.PerspectiveService
            },
            {
                provide: smarteditcommons.IFeatureService,
                useClass: exports.FeatureService
            },
            {
                provide: smarteditcommons.INotificationMouseLeaveDetectionService,
                useClass: exports.NotificationMouseLeaveDetectionService
            },
            {
                provide: smarteditcommons.IWaitDialogService,
                useClass: exports.WaitDialogService
            },
            {
                provide: smarteditcommons.IPreviewService,
                useClass: exports.PreviewService
            },
            {
                provide: smarteditcommons.IDragAndDropCrossOrigin,
                useClass: exports.DragAndDropCrossOrigin
            },
            smarteditcommons.PolyfillService,
            {
                provide: smarteditcommons.INotificationService,
                useClass: exports.NotificationService
            },
            {
                provide: smarteditcommons.IAlertService,
                useClass: exports.AlertService
            },
            {
                provide: smarteditcommons.IPageTreeNodeService,
                useClass: exports.PageTreeNodeService
            },
            {
                provide: smarteditcommons.IPageTreeService,
                useClass: exports.PageTreeService
            },
            smarteditcommons.moduleUtils.initialize((notificationMouseLeaveDetectionService) => {
                //
            }, [smarteditcommons.INotificationMouseLeaveDetectionService])
        ]
    })
], exports.SmarteditServicesModule);

/* @ngInject */ exports.ConfirmationModalService = class /* @ngInject */ ConfirmationModalService extends smarteditcommons.IConfirmationModalService {
};
/* @ngInject */ exports.ConfirmationModalService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IConfirmationModalService),
    smarteditcommons.GatewayProxied('confirm')
], /* @ngInject */ exports.ConfirmationModalService);

let /* @ngInject */ SakExecutorService = class /* @ngInject */ SakExecutorService {
    constructor(decoratorService) {
        this.decoratorService = decoratorService;
    }
    wrapDecorators(projectedContent, element) {
        return this.decoratorService
            .getDecoratorsForComponent(element.getAttribute(smarteditcommons.TYPE_ATTRIBUTE), element.getAttribute(smarteditcommons.ID_ATTRIBUTE))
            .then((decorators) => {
            const compiled = decorators.reduce((templateacc, decorator) => {
                const decoratorSelector = lodash.kebabCase(decorator.replace('se.', ''));
                const decoratorClass = lodash.camelCase(decorator.replace('se.', ''));
                const decoratorElement = document.createElement(decoratorSelector);
                decoratorElement.className = `${decoratorClass} se-decorator-wrap`;
                // To display slot menu need 32px, if there is not enough space it should be display at the slot bottom
                if (decoratorSelector === 'slot-contextual-menu' &&
                    element.style.position === 'absolute' &&
                    parseInt(element.style.top, 10) < 32) {
                    decoratorElement.setAttribute('show-at-bottom', 'true');
                }
                decoratorElement.setAttribute('active', 'false');
                decoratorElement.setAttribute('component-attributes', 'componentAttributes');
                decoratorElement.appendChild(templateacc);
                this.setAttributeOn(decoratorElement, 'data-smartedit-element-uuid', element);
                this.setAttributeOn(decoratorElement, 'data-smartedit-component-id', element);
                this.setAttributeOn(decoratorElement, 'data-smartedit-component-uuid', element);
                this.setAttributeOn(decoratorElement, 'data-smartedit-component-type', element);
                this.setAttributeOn(decoratorElement, 'data-smartedit-catalog-version-uuid', element);
                this.setAttributeOn(decoratorElement, 'data-smartedit-container-id', element);
                this.setAttributeOn(decoratorElement, 'data-smartedit-container-uuid', element);
                this.setAttributeOn(decoratorElement, 'data-smartedit-container-type', element);
                return decoratorElement;
            }, projectedContent);
            return compiled;
        });
    }
    setAttributeOn(decorator, attributeName, element) {
        const value = element.getAttribute(attributeName);
        if (value) {
            decorator.setAttribute(attributeName, value);
        }
    }
};
SakExecutorService.$inject = ["decoratorService"];
/* @ngInject */ SakExecutorService = __decorate([
    smarteditcommons.SeDowngradeService()
    /* @internal */
    ,
    core.Injectable(),
    __metadata("design:paramtypes", [smarteditcommons.IDecoratorService])
], /* @ngInject */ SakExecutorService);

var ContextualMenuItemMode;
(function (ContextualMenuItemMode) {
    ContextualMenuItemMode["Small"] = "small";
    ContextualMenuItemMode["Compact"] = "compact";
})(ContextualMenuItemMode || (ContextualMenuItemMode = {}));
window.__smartedit__.addDecoratorPayload("Component", "ContextualMenuItemComponent", {
    selector: 'se-contextual-menu-item',
    template: `<div *ngIf="mode === 'small'" id="{{itemConfig.i18nKey | translate}}-{{componentAttributes.smarteditComponentId}}-{{componentAttributes.smarteditComponentType}}-{{index}}" class="se-ctx-menu-element__btn {{itemConfig.displayIconClass}} {{itemConfig.displayClass}}" [ngClass]="{'is-active': itemConfig.isOpen }" [title]="itemConfig.i18nKey | translate"></div><div *ngIf="mode === 'compact'" class="se-ctx-menu-element__label {{itemConfig.displayClass}}" id="{{itemConfig.i18nKey | translate}}-{{componentAttributes.smarteditComponentId}}-{{componentAttributes.smarteditComponentType}}-{{index}}">{{itemConfig.i18nKey | translate}}</div>`
});
let /* @ngInject */ ContextualMenuItemComponent = class /* @ngInject */ ContextualMenuItemComponent {
    constructor(element) {
        this.element = element;
        this.modes = [
            ContextualMenuItemMode.Small,
            ContextualMenuItemMode.Compact
        ];
    }
    ngOnInit() {
        this.classes = `cmsx-ctx__icon-more--small ${this.itemConfig.displayClass}`;
        this.validateInput();
        if (this.itemConfig.action && this.itemConfig.action.callbacks) {
            this.setupListeners();
        }
    }
    ngOnDestroy() {
        this.removeListeners();
    }
    validateInput() {
        if (typeof this.mode !== 'string' || this.modes.indexOf(this.mode) === -1) {
            throw new Error('Error initializing contextualMenuItem - unknown mode');
        }
    }
    removeListeners() {
        Object.keys(this.listeners || {}).forEach((key) => {
            this.element.nativeElement.removeEventListener(key, this.listeners[key]);
        });
    }
    setupListeners() {
        const { smarteditComponentType, smarteditComponentId, smarteditComponentUuid, smarteditContainerType, smarteditContainerId } = this.componentAttributes;
        const { smarteditSlotId, smarteditSlotUuid } = this.slotAttributes;
        const config = {
            componentType: smarteditComponentType,
            componentId: smarteditComponentId,
            componentUuid: smarteditComponentUuid,
            containerType: smarteditContainerType,
            containerId: smarteditContainerId,
            componentAttributes: this.componentAttributes,
            slotId: smarteditSlotId,
            slotUuid: smarteditSlotUuid
        };
        this.listeners = Object.keys(this.itemConfig.action.callbacks).reduce((acc, key) => (Object.assign(Object.assign({}, acc), { [key]: () => this.itemConfig.action.callbacks[key](config) })), {});
        Object.keys(this.listeners).forEach((key) => {
            this.element.nativeElement.addEventListener(key, () => this.listeners[key]());
        });
    }
};
ContextualMenuItemComponent.$inject = ["element"];
__decorate([
    core.Input(),
    __metadata("design:type", String)
], /* @ngInject */ ContextualMenuItemComponent.prototype, "mode", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Number)
], /* @ngInject */ ContextualMenuItemComponent.prototype, "index", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ ContextualMenuItemComponent.prototype, "componentAttributes", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ ContextualMenuItemComponent.prototype, "slotAttributes", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ ContextualMenuItemComponent.prototype, "itemConfig", void 0);
/* @ngInject */ ContextualMenuItemComponent = __decorate([
    smarteditcommons.SeDowngradeComponent(),
    core.Component({
        selector: 'se-contextual-menu-item',
        template: `<div *ngIf="mode === 'small'" id="{{itemConfig.i18nKey | translate}}-{{componentAttributes.smarteditComponentId}}-{{componentAttributes.smarteditComponentType}}-{{index}}" class="se-ctx-menu-element__btn {{itemConfig.displayIconClass}} {{itemConfig.displayClass}}" [ngClass]="{'is-active': itemConfig.isOpen }" [title]="itemConfig.i18nKey | translate"></div><div *ngIf="mode === 'compact'" class="se-ctx-menu-element__label {{itemConfig.displayClass}}" id="{{itemConfig.i18nKey | translate}}-{{componentAttributes.smarteditComponentId}}-{{componentAttributes.smarteditComponentType}}-{{index}}">{{itemConfig.i18nKey | translate}}</div>`
    }),
    __metadata("design:paramtypes", [core.ElementRef])
], /* @ngInject */ ContextualMenuItemComponent);

/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/**
 * Backwards compatibility for partners and downstream teams
 * The deprecated modules below were moved to smarteditServicesModule
 *
 * IMPORANT: THE DEPRECATED MODULES WILL NOT BE AVAILABLE IN FUTURE RELEASES
 * @deprecated since 1811
 */
/* forbiddenNameSpaces angular.module:false */
const deprecatedSince1811 = () => {
    angular.module('permissionServiceModule', ['legacySmarteditServicesModule']);
};
function deprecatedSince1905() {
    angular.module('alertServiceModule', ['legacySmarteditServicesModule']);
    angular.module('decoratorServiceModule', ['legacySmarteditServicesModule']);
    angular.module('renderServiceModule', ['legacySmarteditServicesModule']);
    angular.module('renderServiceInterfaceModule', ['legacySmarteditServicesModule']);
}
function deprecatedSince2005() {
    angular.module('smarteditServicesModule', ['legacySmarteditServicesModule']);
    angular.module('pageSensitiveDirectiveModule', ['legacySmartedit']);
    angular.module('toolbarModule', ['legacySmarteditServicesModule']);
    angular.module('contextualMenuItemModule', ['legacySmartedit']);
    angular.module('contextualMenuDecoratorModule', ['legacySmartedit']);
    angular.module('positionRegistryModule', ['legacySmarteditServicesModule']);
    angular.module('slotContextualMenuDecoratorModule', ['legacySmartedit']);
    angular.module('resizeListenerModule', ['legacySmarteditServicesModule']);
    angular.module('sanitizeHtmlInputModule', ['legacySmartedit']);
    angular.module('catalogVersionPermissionModule', ['legacySmarteditServicesModule']);
}
const deprecate = () => {
    deprecatedSince1811();
    deprecatedSince1905();
    deprecatedSince2005();
};

deprecate();
_static.setAngularJSGlobal(angular__namespace);
let /* @ngInject */ LegacySmartedit = class /* @ngInject */ LegacySmartedit {
};
/* @ngInject */ LegacySmartedit = __decorate([
    smarteditcommons.SeModule({
        imports: [
            exports.LegacySmarteditServicesModule,
            'templateCacheDecoratorModule',
            'ui.bootstrap',
            'ui.select'
        ],
        config: ["$provide", "$logProvider", ($provide, $logProvider) => {
            'ngInject';
            smarteditcommons.instrument($provide, (arg) => smarteditcommons.objectUtils.readObjectStructure(arg), 'smartedit');
            $logProvider.debugEnabled(false);
        }]
    })
], /* @ngInject */ LegacySmartedit);

window.__smartedit__.addDecoratorPayload("Component", "SmarteditComponent", {
    selector: smarteditcommons.SMARTEDIT_COMPONENT_NAME,
    template: ``
});
let SmarteditComponent = class SmarteditComponent {
    constructor(elementRef, upgrade, injector, angularJSBootstrapIndicatorService) {
        this.elementRef = elementRef;
        this.upgrade = upgrade;
        this.angularJSBootstrapIndicatorService = angularJSBootstrapIndicatorService;
        smarteditcommons.registerCustomComponents(injector);
    }
    ngAfterViewInit() {
        if (!smarteditcommons.nodeUtils.hasLegacyAngularJSBootsrap()) {
            const e2ePlaceHolderTagName = 'e2e-placeholder';
            if (document.querySelector(e2ePlaceHolderTagName)) {
                document.querySelector(e2ePlaceHolderTagName).childNodes.forEach((childNode) => {
                    if (childNode.nodeType === Node.ELEMENT_NODE) {
                        this.elementRef.nativeElement.appendChild(childNode);
                    }
                });
            }
            this.upgrade.bootstrap(this.elementRef.nativeElement, [LegacySmartedit.moduleName], { strictDi: false });
            this.angularJSBootstrapIndicatorService.setSmarteditReady();
        }
    }
};
SmarteditComponent = __decorate([
    core.Component({
        selector: smarteditcommons.SMARTEDIT_COMPONENT_NAME,
        template: ``
    }),
    __metadata("design:paramtypes", [core.ElementRef,
        _static.UpgradeModule,
        core.Injector,
        smarteditcommons.AngularJSBootstrapIndicatorService])
], SmarteditComponent);

class BaseContextualMenuComponent {
    constructor() {
        this.remainOpenMap = {};
    }
    isHybrisIcon(icon) {
        return icon && icon.indexOf('hyicon') >= 0;
    }
    /*
     setRemainOpen receives a key name and a boolean value
     the button name needs to be unique across all buttons so it won' t collide with other button actions.
     */
    setRemainOpen(key, remainOpen) {
        this.remainOpenMap[key] = remainOpen;
    }
    showOverlay(active) {
        if (active) {
            return true;
        }
        return Object.keys(this.remainOpenMap).reduce((isOpen, key) => isOpen || this.remainOpenMap[key], false);
    }
}

window.__smartedit__.addDecoratorPayload("Component", "MoreItemsComponent", {
    selector: 'se-more-items-component',
    template: `
        <div class="se-contextual-more-menu fd-menu">
            <ul
                id="{{ parent.smarteditComponentId }}-{{ parent.smarteditComponentType }}-more-menu"
                class="fd-menu__list se-contextual-more-menu__list"
            >
                <li
                    *ngFor="let item of parent.getItems().moreMenuItems; let $index = index"
                    [attr.data-smartedit-id]="parent.smarteditComponentId"
                    [attr.data-smartedit-type]="parent.smarteditComponentType"
                    class="se-contextual-more-menu__item"
                    [ngClass]="item.customCss"
                >
                    <se-popup-overlay
                        [popupOverlay]="parent.itemTemplateOverlayWrapper"
                        [popupOverlayTrigger]="parent.shouldShowTemplate(item)"
                        [popupOverlayData]="{ item: item }"
                        (popupOverlayOnShow)="parent.onShowItemPopup(item)"
                        (popupOverlayOnHide)="parent.onHideItemPopup(false)"
                    >
                        <se-contextual-menu-item
                            [mode]="'compact'"
                            [index]="$index"
                            [componentAttributes]="parent.componentAttributes"
                            [slotAttributes]="parent.slotAttributes"
                            [itemConfig]="item"
                            (click)="parent.triggerMenuItemAction(item, $event)"
                            [attr.data-component-id]="parent.smarteditComponentId"
                            [attr.data-component-uuid]="
                                parent.componentAttributes.smarteditComponentUuid
                            "
                            [attr.data-component-type]="parent.smarteditComponentType"
                            [attr.data-slot-id]="parent.smarteditSlotId"
                            [attr.data-slot-uuid]="parent.smarteditSlotUuid"
                            [attr.data-container-id]="parent.smarteditContainerId"
                            [attr.data-container-type]="parent.smarteditContainerType"
                        >
                        </se-contextual-menu-item>
                    </se-popup-overlay>
                </li>
            </ul>
        </div>
    `
});
exports.MoreItemsComponent = class MoreItemsComponent {
    constructor(parent) {
        this.parent = parent;
    }
};
exports.MoreItemsComponent = __decorate([
    core.Component({
        selector: 'se-more-items-component',
        template: `
        <div class="se-contextual-more-menu fd-menu">
            <ul
                id="{{ parent.smarteditComponentId }}-{{ parent.smarteditComponentType }}-more-menu"
                class="fd-menu__list se-contextual-more-menu__list"
            >
                <li
                    *ngFor="let item of parent.getItems().moreMenuItems; let $index = index"
                    [attr.data-smartedit-id]="parent.smarteditComponentId"
                    [attr.data-smartedit-type]="parent.smarteditComponentType"
                    class="se-contextual-more-menu__item"
                    [ngClass]="item.customCss"
                >
                    <se-popup-overlay
                        [popupOverlay]="parent.itemTemplateOverlayWrapper"
                        [popupOverlayTrigger]="parent.shouldShowTemplate(item)"
                        [popupOverlayData]="{ item: item }"
                        (popupOverlayOnShow)="parent.onShowItemPopup(item)"
                        (popupOverlayOnHide)="parent.onHideItemPopup(false)"
                    >
                        <se-contextual-menu-item
                            [mode]="'compact'"
                            [index]="$index"
                            [componentAttributes]="parent.componentAttributes"
                            [slotAttributes]="parent.slotAttributes"
                            [itemConfig]="item"
                            (click)="parent.triggerMenuItemAction(item, $event)"
                            [attr.data-component-id]="parent.smarteditComponentId"
                            [attr.data-component-uuid]="
                                parent.componentAttributes.smarteditComponentUuid
                            "
                            [attr.data-component-type]="parent.smarteditComponentType"
                            [attr.data-slot-id]="parent.smarteditSlotId"
                            [attr.data-slot-uuid]="parent.smarteditSlotUuid"
                            [attr.data-container-id]="parent.smarteditContainerId"
                            [attr.data-container-type]="parent.smarteditContainerType"
                        >
                        </se-contextual-menu-item>
                    </se-popup-overlay>
                </li>
            </ul>
        </div>
    `
    }),
    __param(0, core.Inject(core.forwardRef(() => exports.ContextualMenuDecoratorComponent))),
    __metadata("design:paramtypes", [exports.ContextualMenuDecoratorComponent])
], exports.MoreItemsComponent);
window.__smartedit__.addDecoratorPayload("Component", "ContextualMenuItemOverlayComponent", {
    template: `
        <div *ngIf="item.action.component" class="se-contextual-extra-menu">
            <ng-container
                *ngComponentOutlet="item.action.component; injector: componentInjector"
            ></ng-container>
        </div>
    `,
    selector: 'se-contextual-menu-item-overlay'
});
exports.ContextualMenuItemOverlayComponent = class ContextualMenuItemOverlayComponent {
    constructor(data, parent, injector) {
        this.data = data;
        this.parent = parent;
        this.injector = injector;
    }
    ngOnInit() {
        this.createComponentInjector();
    }
    get item() {
        return this.data.item;
    }
    createComponentInjector() {
        this.componentInjector = core.Injector.create({
            parent: this.injector,
            providers: [
                {
                    provide: smarteditcommons.CONTEXTUAL_MENU_ITEM_DATA,
                    useValue: {
                        componentAttributes: this.parent.componentAttributes,
                        setRemainOpen: (key, remainOpen) => this.parent.setRemainOpen(key, remainOpen)
                    }
                }
            ]
        });
    }
};
exports.ContextualMenuItemOverlayComponent = __decorate([
    core.Component({
        template: `
        <div *ngIf="item.action.component" class="se-contextual-extra-menu">
            <ng-container
                *ngComponentOutlet="item.action.component; injector: componentInjector"
            ></ng-container>
        </div>
    `,
        selector: 'se-contextual-menu-item-overlay'
    }),
    __param(0, core.Inject(smarteditcommons.POPUP_OVERLAY_DATA)),
    __param(1, core.Inject(core.forwardRef(() => exports.ContextualMenuDecoratorComponent))),
    __metadata("design:paramtypes", [Object, exports.ContextualMenuDecoratorComponent,
        core.Injector])
], exports.ContextualMenuItemOverlayComponent);
window.__smartedit__.addDecoratorPayload("Component", "ContextualMenuDecoratorComponent", {
    selector: 'contextual-menu',
    template: `<div class="se-ctx-menu-decorator-wrapper" [ngClass]="{'se-ctx-menu-decorator__border--visible': showContextualMenuBorders()}"><div class="se-ctx-menu__overlay" *ngIf="showOverlay(active)"><div class="se-ctx-menu__overlay__left-section" *ngIf="getItems()"><div *ngFor="let item of getItems().leftMenuItems; let $index = index" id="{{ item.key }}"><se-popup-overlay [popupOverlay]="itemTemplateOverlayWrapper" [popupOverlayTrigger]="shouldShowTemplate(item)" [popupOverlayData]="{ item: item }" (popupOverlayOnShow)="onShowItemPopup(item)" (popupOverlayOnHide)="onHideItemPopup(false)"><se-contextual-menu-item [mode]="'small'" [index]="$index" [componentAttributes]="componentAttributes" [slotAttributes]="slotAttributes" [itemConfig]="item" (click)="triggerMenuItemAction(item, $event)" [attr.data-component-id]="smarteditComponentId" [attr.data-component-uuid]="componentAttributes.smarteditComponentUuid" [attr.data-component-type]="smarteditComponentType" [attr.data-slot-id]="smarteditSlotId" [attr.data-slot-uuid]="smarteditSlotUuid" [attr.data-container-id]="smarteditContainerId" [attr.data-container-type]="smarteditContainerType"></se-contextual-menu-item></se-popup-overlay></div></div><se-popup-overlay [popupOverlay]="moreMenuPopupConfig" [popupOverlayTrigger]="moreMenuIsOpen" (popupOverlayOnShow)="onShowMoreMenuPopup()" (popupOverlayOnHide)="onHideMoreMenuPopup()"><div *ngIf="getItems() && getItems().moreMenuItems.length > 0" class="se-ctx-menu-element__btn se-ctx-menu-element__btn--more" [ngClass]="{'se-ctx-menu-element__btn--more--open': moreMenuIsOpen }" (click)="toggleMoreMenu()"><span [title]="moreButton.i18nKey | translate" class="{{moreButton.displayClass}}"></span></div></se-popup-overlay></div><div class="se-wrapper-data"><div><ng-content></ng-content></div></div></div>`
});
exports.ContextualMenuDecoratorComponent = class ContextualMenuDecoratorComponent extends BaseContextualMenuComponent {
    constructor(yjQuery, element, contextualMenuService, systemEventService, componentHandlerService, nodeUtils, crossFrameEventService, userTrackingService) {
        super();
        this.yjQuery = yjQuery;
        this.element = element;
        this.contextualMenuService = contextualMenuService;
        this.systemEventService = systemEventService;
        this.componentHandlerService = componentHandlerService;
        this.nodeUtils = nodeUtils;
        this.crossFrameEventService = crossFrameEventService;
        this.userTrackingService = userTrackingService;
        this.openItem = null;
        this.moreMenuIsOpen = false;
        this.itemTemplateOverlayWrapper = {
            component: exports.ContextualMenuItemOverlayComponent
        };
        this.moreMenuPopupConfig = {
            component: exports.MoreItemsComponent,
            halign: 'left'
        };
        this.moreButton = {
            displayClass: 'sap-icon--overflow',
            i18nKey: 'se.cms.contextmenu.title.more'
        };
        this.oldWidth = null;
        this.crossFrameEventService.subscribe(smarteditcommons.EVENT_PAGE_TREE_COMPONENT_SELECTED, (eventId, data) => {
            if (this.smarteditElementUuid === data.elementUuid) {
                this._pageTreeActive = data.active;
                if (!this._pageTreeActive) {
                    this._active = false;
                }
            }
            else {
                this._pageTreeActive = false;
            }
        });
    }
    set active(_active) {
        if (typeof _active === 'string') {
            this._active = _active === 'true';
        }
        else {
            this._active = _active;
        }
        if (!this._active) {
            this._pageTreeActive = false;
        }
    }
    get active() {
        return this._active || this._pageTreeActive;
    }
    ngDoCheck() {
        if (this.element) {
            const width = this.element.nativeElement.offsetWidth;
            if (this.oldWidth !== width) {
                this.oldWidth = width;
                this.ngOnDestroy();
                this.onInit();
            }
        }
    }
    ngOnDestroy() {
        if (this.dndUnRegFn) {
            this.dndUnRegFn();
        }
        if (this.unregisterRefreshItems) {
            this.unregisterRefreshItems();
        }
    }
    ngOnInit() {
        this.componentAttributes = this.nodeUtils.collectSmarteditAttributesByElementUuid(this.smarteditElementUuid);
        this.slotAttributes = {
            smarteditSlotId: this.smarteditSlotId,
            smarteditSlotUuid: this.smarteditSlotUuid
        };
        this.onInit();
        this.contextualMenuService.onContextualMenuItemsAdded
            .pipe(operators.filter((type) => type === this.smarteditComponentType))
            .subscribe((type) => this.updateItems());
    }
    get smarteditSlotId() {
        return this.componentHandlerService.getParentSlotForComponent(this.element.nativeElement);
    }
    get smarteditSlotUuid() {
        return this.componentHandlerService.getParentSlotUuidForComponent(this.element.nativeElement);
    }
    onInit() {
        this.updateItems();
        this.dndUnRegFn = this.systemEventService.subscribe(smarteditcommons.CLOSE_CTX_MENU, () => this.hideAllPopups());
        this.unregisterRefreshItems = this.systemEventService.subscribe(smarteditcommons.REFRESH_CONTEXTUAL_MENU_ITEMS_EVENT, () => this.updateItems);
    }
    toggleMoreMenu() {
        this.moreMenuIsOpen = !this.moreMenuIsOpen;
    }
    shouldShowTemplate(menuItem) {
        return this.displayedItem === menuItem;
    }
    onShowItemPopup(item) {
        this.setRemainOpen('someContextualPopupOverLay', true);
        this.openItem = item;
        this.openItem.isOpen = true;
    }
    onHideItemPopup(hideMoreMenu) {
        if (this.openItem) {
            this.openItem.isOpen = false;
            this.openItem = null;
        }
        this.displayedItem = null;
        this.setRemainOpen('someContextualPopupOverLay', false);
        if (hideMoreMenu) {
            this.onHideMoreMenuPopup();
        }
    }
    onShowMoreMenuPopup() {
        this.setRemainOpen('someContextualPopupOverLay', true);
    }
    onHideMoreMenuPopup() {
        this.moreMenuIsOpen = false;
        this.setRemainOpen('someContextualPopupOverLay', false);
    }
    hideAllPopups() {
        this.onHideMoreMenuPopup();
        this.onHideItemPopup();
    }
    getItems() {
        return this.items;
    }
    showContextualMenuBorders() {
        return this.active && this.items && this.items.leftMenuItems.length > 0;
    }
    triggerMenuItemAction(item, $event) {
        $event.stopPropagation();
        $event.preventDefault();
        this.userTrackingService.trackingUserAction(smarteditcommons.USER_TRACKING_FUNCTIONALITY.CONTEXT_MENU, item.i18nKey);
        if (item.action.component) {
            if (this.displayedItem === item) {
                this.displayedItem = null;
            }
            else {
                this.displayedItem = item;
            }
        }
        else if (item.action.callback) {
            this.hideAllPopups();
            item.action.callback({
                componentType: this.smarteditComponentType,
                componentId: this.smarteditComponentId,
                containerType: this.smarteditContainerType,
                containerId: this.smarteditContainerId,
                componentAttributes: this.componentAttributes,
                slotId: this.smarteditSlotId,
                slotUuid: this.smarteditSlotUuid,
                element: this.yjQuery(this.element.nativeElement)
            }, $event);
        }
    }
    maxContextualMenuItems() {
        const ctxSize = 50;
        const buttonMaxCapacity = Math.round(this.yjQuery(this.element.nativeElement).width() / ctxSize) - 1;
        let leftButtons = buttonMaxCapacity >= 4 ? 3 : buttonMaxCapacity - 1;
        leftButtons = leftButtons < 0 ? 0 : leftButtons;
        return leftButtons;
    }
    updateItems() {
        this.contextualMenuService
            .getContextualMenuItems({
            componentType: this.smarteditComponentType,
            componentId: this.smarteditComponentId,
            containerType: this.smarteditContainerType,
            containerId: this.smarteditContainerId,
            componentAttributes: this.componentAttributes,
            iLeftBtns: this.maxContextualMenuItems(),
            element: this.yjQuery(this.element.nativeElement)
        })
            .then((newItems) => {
            this.items = newItems;
        });
    }
};
__decorate([
    core.Input('data-smartedit-component-type'),
    __metadata("design:type", String)
], exports.ContextualMenuDecoratorComponent.prototype, "smarteditComponentType", void 0);
__decorate([
    core.Input('data-smartedit-component-id'),
    __metadata("design:type", String)
], exports.ContextualMenuDecoratorComponent.prototype, "smarteditComponentId", void 0);
__decorate([
    core.Input('data-smartedit-container-type'),
    __metadata("design:type", String)
], exports.ContextualMenuDecoratorComponent.prototype, "smarteditContainerType", void 0);
__decorate([
    core.Input('data-smartedit-container-id'),
    __metadata("design:type", String)
], exports.ContextualMenuDecoratorComponent.prototype, "smarteditContainerId", void 0);
__decorate([
    core.Input('data-smartedit-catalog-version-uuid'),
    __metadata("design:type", String)
], exports.ContextualMenuDecoratorComponent.prototype, "smarteditCatalogVersionUuid", void 0);
__decorate([
    core.Input('data-smartedit-element-uuid'),
    __metadata("design:type", String)
], exports.ContextualMenuDecoratorComponent.prototype, "smarteditElementUuid", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], exports.ContextualMenuDecoratorComponent.prototype, "componentAttributes", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object),
    __metadata("design:paramtypes", [Object])
], exports.ContextualMenuDecoratorComponent.prototype, "active", null);
exports.ContextualMenuDecoratorComponent = __decorate([
    smarteditcommons.SeCustomComponent(),
    core.Component({
        selector: 'contextual-menu',
        template: `<div class="se-ctx-menu-decorator-wrapper" [ngClass]="{'se-ctx-menu-decorator__border--visible': showContextualMenuBorders()}"><div class="se-ctx-menu__overlay" *ngIf="showOverlay(active)"><div class="se-ctx-menu__overlay__left-section" *ngIf="getItems()"><div *ngFor="let item of getItems().leftMenuItems; let $index = index" id="{{ item.key }}"><se-popup-overlay [popupOverlay]="itemTemplateOverlayWrapper" [popupOverlayTrigger]="shouldShowTemplate(item)" [popupOverlayData]="{ item: item }" (popupOverlayOnShow)="onShowItemPopup(item)" (popupOverlayOnHide)="onHideItemPopup(false)"><se-contextual-menu-item [mode]="'small'" [index]="$index" [componentAttributes]="componentAttributes" [slotAttributes]="slotAttributes" [itemConfig]="item" (click)="triggerMenuItemAction(item, $event)" [attr.data-component-id]="smarteditComponentId" [attr.data-component-uuid]="componentAttributes.smarteditComponentUuid" [attr.data-component-type]="smarteditComponentType" [attr.data-slot-id]="smarteditSlotId" [attr.data-slot-uuid]="smarteditSlotUuid" [attr.data-container-id]="smarteditContainerId" [attr.data-container-type]="smarteditContainerType"></se-contextual-menu-item></se-popup-overlay></div></div><se-popup-overlay [popupOverlay]="moreMenuPopupConfig" [popupOverlayTrigger]="moreMenuIsOpen" (popupOverlayOnShow)="onShowMoreMenuPopup()" (popupOverlayOnHide)="onHideMoreMenuPopup()"><div *ngIf="getItems() && getItems().moreMenuItems.length > 0" class="se-ctx-menu-element__btn se-ctx-menu-element__btn--more" [ngClass]="{'se-ctx-menu-element__btn--more--open': moreMenuIsOpen }" (click)="toggleMoreMenu()"><span [title]="moreButton.i18nKey | translate" class="{{moreButton.displayClass}}"></span></div></se-popup-overlay></div><div class="se-wrapper-data"><div><ng-content></ng-content></div></div></div>`
    }),
    __param(0, core.Inject(smarteditcommons.YJQUERY_TOKEN)),
    __metadata("design:paramtypes", [Function, core.ElementRef,
        smarteditcommons.IContextualMenuService,
        smarteditcommons.SystemEventService,
        smarteditcommons.ComponentHandlerService,
        smarteditcommons.NodeUtils,
        smarteditcommons.CrossFrameEventService,
        smarteditcommons.UserTrackingService])
], exports.ContextualMenuDecoratorComponent);

/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
const SE_DECORATIVE_BODY_PADDING_LEFT_CLASS = '.se-decorative-body__padding--left';
const SE_DECORATIVE_BODY_PADDING_RIGHT_CLASS = '.se-decorative-body__padding--right';
const SE_DECORATIVE_PANEL_AREA_CLASS = '.se-decorative-panel-area';
const SE_DECORATIVE_BODY_AREA_CLASS = '.se-decoratorative-body-area';

window.__smartedit__.addDecoratorPayload("Component", "SlotContextualMenuDecoratorComponent", {
    selector: 'slot-contextual-menu',
    template: `<div class="se-decorative-panel-wrapper"><ng-container *ngIf="showOverlay(active) && !showAtBottom"><ng-container *ngTemplateOutlet="decorativePanelArea"></ng-container></ng-container><div class="se-decoratorative-body-area"><div class="se-decorative-body__padding--left" [ngClass]="{ 'active': active }"></div><div class="se-decorative-body__inner-border" [ngClass]="{ 'active': active }"></div><div class="se-wrapper-data" [ngClass]="{ 'active': active }"><ng-content></ng-content></div><div class="se-decorative-body__padding--right" [ngClass]="{ 'active': active }"></div></div><ng-container *ngIf="showOverlay(active) && showAtBottom"><ng-container *ngTemplateOutlet="decorativePanelArea"></ng-container></ng-container><ng-template #decorativePanelArea><div class="se-decorative-panel-area" [ngStyle]="showAtBottom && { 'margin-top': '0px' }"><span class="se-decorative-panel__title">{{smarteditComponentId}}</span><div class="se-decorative-panel__slot-contextual-menu"><slot-contextual-menu-item [item]="item" *ngFor="let item of items"></slot-contextual-menu-item></div></div></ng-template></div>`
});
exports.SlotContextualMenuDecoratorComponent = class SlotContextualMenuDecoratorComponent extends BaseContextualMenuComponent {
    constructor(element, yjQuery, systemEventService, contextualMenuService, nodeUtils, crossFrameEventService) {
        super();
        this.element = element;
        this.yjQuery = yjQuery;
        this.systemEventService = systemEventService;
        this.contextualMenuService = contextualMenuService;
        this.nodeUtils = nodeUtils;
        this.crossFrameEventService = crossFrameEventService;
        this.oldRightMostOffsetFromPage = null;
        this.maxContextualMenuItems = 3;
        this.showAtBottom = this.element.nativeElement.getAttribute('show-at-bottom') || false;
        const THROTTLE_DELAY = 200;
        this.positionPanelHorizontally = lodash.throttle(this.positionPanelHorizontally, THROTTLE_DELAY);
        this.positionPanelVertically = lodash.throttle(() => this.positionPanelVertically(), THROTTLE_DELAY);
        this.hidePadding = lodash.throttle(this.hidePadding, THROTTLE_DELAY);
        this.crossFrameEventService.subscribe(smarteditcommons.EVENT_PAGE_TREE_SLOT_SELECTED, (eventId, data) => {
            if (this.smarteditElementUuid === data.elementUuid) {
                this._active = data.active;
            }
            else {
                this._active = false;
            }
        });
    }
    set active(_active) {
        this._active = _active === 'true';
    }
    get active() {
        return this._active;
    }
    ngOnChanges(changes) {
        if (changes.active) {
            this.hidePadding();
            if (this.active) {
                this.positionPanelVertically();
                this.positionPanelHorizontally();
            }
        }
    }
    ngOnInit() {
        this.componentAttributes = this.nodeUtils.collectSmarteditAttributesByElementUuid(this.smarteditElementUuid);
        this.updateItems();
        this.showSlotMenuUnregFn = this.systemEventService.subscribe(this.smarteditComponentId + smarteditcommons.SHOW_SLOT_MENU, (eventId, slotId) => {
            this.remainOpenMap.slotMenuButton = true;
            this.positionPanelVertically();
            this.positionPanelHorizontally();
        });
        this.hideSlotMenuUnregFn = this.systemEventService.subscribe(smarteditcommons.HIDE_SLOT_MENU, () => {
            if (this.remainOpenMap.slotMenuButton) {
                delete this.remainOpenMap.slotMenuButton;
            }
            this.hidePadding();
        });
        this.refreshContextualMenuUnregFn = this.systemEventService.subscribe(smarteditcommons.REFRESH_CONTEXTUAL_MENU_ITEMS_EVENT, () => this.updateItems());
        this.contextualMenuService.onContextualMenuItemsAdded
            .pipe(operators.filter((type) => type === this.smarteditComponentType))
            .subscribe(() => this.updateItems());
    }
    ngDoCheck() {
        const rightMostOffsetFromPage = this.getRightMostOffsetFromPage();
        if (this.active &&
            !isNaN(rightMostOffsetFromPage) &&
            rightMostOffsetFromPage !== this.oldRightMostOffsetFromPage) {
            this.oldRightMostOffsetFromPage = rightMostOffsetFromPage;
            this.positionPanelHorizontally(rightMostOffsetFromPage);
        }
    }
    ngOnDestroy() {
        if (this.showSlotMenuUnregFn) {
            this.showSlotMenuUnregFn();
        }
        if (this.hideSlotMenuUnregFn) {
            this.hideSlotMenuUnregFn();
        }
        if (this.refreshContextualMenuUnregFn) {
            this.refreshContextualMenuUnregFn();
        }
        if (this.hideSlotUnSubscribeFn) {
            this.hideSlotUnSubscribeFn();
        }
        if (this.showSlotUnSubscribeFn) {
            this.showSlotUnSubscribeFn();
        }
    }
    updateItems() {
        this.contextualMenuService
            .getContextualMenuItems({
            componentType: this.smarteditComponentType,
            componentId: this.smarteditComponentId,
            containerType: this.smarteditContainerType,
            containerId: this.smarteditContainerId,
            componentAttributes: this.componentAttributes,
            iLeftBtns: this.maxContextualMenuItems,
            element: this.yjQuery(this.element.nativeElement)
        })
            .then((newItems) => {
            this.items = [...newItems.leftMenuItems, ...newItems.moreMenuItems];
        });
    }
    triggerMenuItemAction(item, $event) {
        item.action.callback({
            componentType: this.smarteditComponentType,
            componentId: this.smarteditComponentId,
            containerType: this.smarteditContainerType,
            containerId: this.smarteditContainerId,
            componentAttributes: this.componentAttributes,
            slotId: this.smarteditSlotId,
            slotUuid: this.smarteditSlotUuid,
            element: this.yjQuery(this.element.nativeElement)
        }, $event);
    }
    hidePadding() {
        this.yjQuery(this.element.nativeElement)
            .find(SE_DECORATIVE_BODY_PADDING_LEFT_CLASS)
            .css('display', 'none');
        this.yjQuery(this.element.nativeElement)
            .find(SE_DECORATIVE_BODY_PADDING_RIGHT_CLASS)
            .css('display', 'none');
    }
    getRightMostOffsetFromPage() {
        const $decorativePanel = this.yjQuery(this.element.nativeElement).find(SE_DECORATIVE_PANEL_AREA_CLASS);
        return this.yjQuery(this.element.nativeElement).offset().left + $decorativePanel.width();
    }
    positionPanelHorizontally(rightMostOffsetFromPage) {
        const $decorativePanel = this.yjQuery(this.element.nativeElement).find(SE_DECORATIVE_PANEL_AREA_CLASS);
        rightMostOffsetFromPage =
            rightMostOffsetFromPage !== undefined
                ? rightMostOffsetFromPage
                : this.getRightMostOffsetFromPage();
        const isOnLeft = rightMostOffsetFromPage >= this.yjQuery('body').width();
        if (isOnLeft) {
            const offset = $decorativePanel.outerWidth() -
                this.yjQuery(this.element.nativeElement).find('.se-wrapper-data').width();
            $decorativePanel.css('margin-left', -offset);
            this.yjQuery(this.element.nativeElement)
                .find(SE_DECORATIVE_BODY_PADDING_LEFT_CLASS)
                .css('margin-left', -offset);
        }
        this.hidePadding();
        this.yjQuery(this.element.nativeElement)
            .find(isOnLeft
            ? SE_DECORATIVE_BODY_PADDING_LEFT_CLASS
            : SE_DECORATIVE_BODY_PADDING_RIGHT_CLASS)
            .css('display', 'flex');
    }
    positionPanelVertically() {
        const decorativePanelArea = this.yjQuery(this.element.nativeElement).find(SE_DECORATIVE_PANEL_AREA_CLASS);
        const decoratorPaddingContainer = this.yjQuery(this.element.nativeElement).find(SE_DECORATIVE_BODY_AREA_CLASS);
        let marginTop;
        const height = decorativePanelArea.height();
        const marginTopOffset = -32;
        if (this.yjQuery(this.element.nativeElement).offset().top <= height) {
            const borderOffset = 6;
            marginTop = decoratorPaddingContainer.height() + borderOffset;
            decoratorPaddingContainer.css('margin-top', -(marginTop + height));
        }
        else {
            marginTop = marginTopOffset;
        }
        decorativePanelArea.css('margin-top', marginTop);
    }
};
__decorate([
    core.Input('data-smartedit-component-type'),
    __metadata("design:type", String)
], exports.SlotContextualMenuDecoratorComponent.prototype, "smarteditComponentType", void 0);
__decorate([
    core.Input('data-smartedit-component-id'),
    __metadata("design:type", String)
], exports.SlotContextualMenuDecoratorComponent.prototype, "smarteditComponentId", void 0);
__decorate([
    core.Input('data-smartedit-container-type'),
    __metadata("design:type", String)
], exports.SlotContextualMenuDecoratorComponent.prototype, "smarteditContainerType", void 0);
__decorate([
    core.Input('data-smartedit-container-id'),
    __metadata("design:type", String)
], exports.SlotContextualMenuDecoratorComponent.prototype, "smarteditContainerId", void 0);
__decorate([
    core.Input('data-smartedit-slot-id'),
    __metadata("design:type", String)
], exports.SlotContextualMenuDecoratorComponent.prototype, "smarteditSlotId", void 0);
__decorate([
    core.Input('data-smartedit-slot-uuid'),
    __metadata("design:type", String)
], exports.SlotContextualMenuDecoratorComponent.prototype, "smarteditSlotUuid", void 0);
__decorate([
    core.Input('data-smartedit-catalog-version-uuid'),
    __metadata("design:type", String)
], exports.SlotContextualMenuDecoratorComponent.prototype, "smarteditCatalogVersionUuid", void 0);
__decorate([
    core.Input('data-smartedit-element-uuid'),
    __metadata("design:type", String)
], exports.SlotContextualMenuDecoratorComponent.prototype, "smarteditElementUuid", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], exports.SlotContextualMenuDecoratorComponent.prototype, "componentAttributes", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object),
    __metadata("design:paramtypes", [Object])
], exports.SlotContextualMenuDecoratorComponent.prototype, "active", null);
exports.SlotContextualMenuDecoratorComponent = __decorate([
    smarteditcommons.SeCustomComponent(),
    core.Component({
        selector: 'slot-contextual-menu',
        template: `<div class="se-decorative-panel-wrapper"><ng-container *ngIf="showOverlay(active) && !showAtBottom"><ng-container *ngTemplateOutlet="decorativePanelArea"></ng-container></ng-container><div class="se-decoratorative-body-area"><div class="se-decorative-body__padding--left" [ngClass]="{ 'active': active }"></div><div class="se-decorative-body__inner-border" [ngClass]="{ 'active': active }"></div><div class="se-wrapper-data" [ngClass]="{ 'active': active }"><ng-content></ng-content></div><div class="se-decorative-body__padding--right" [ngClass]="{ 'active': active }"></div></div><ng-container *ngIf="showOverlay(active) && showAtBottom"><ng-container *ngTemplateOutlet="decorativePanelArea"></ng-container></ng-container><ng-template #decorativePanelArea><div class="se-decorative-panel-area" [ngStyle]="showAtBottom && { 'margin-top': '0px' }"><span class="se-decorative-panel__title">{{smarteditComponentId}}</span><div class="se-decorative-panel__slot-contextual-menu"><slot-contextual-menu-item [item]="item" *ngFor="let item of items"></slot-contextual-menu-item></div></div></ng-template></div>`
    }),
    __param(1, core.Inject(smarteditcommons.YJQUERY_TOKEN)),
    __metadata("design:paramtypes", [core.ElementRef, Function, smarteditcommons.SystemEventService,
        smarteditcommons.IContextualMenuService,
        smarteditcommons.NodeUtils,
        smarteditcommons.CrossFrameEventService])
], exports.SlotContextualMenuDecoratorComponent);

window.__smartedit__.addDecoratorPayload("Component", "SlotContextualMenuItemComponent", {
    selector: 'slot-contextual-menu-item',
    template: `
        <div *ngIf="!item.action.component">
            <span
                *ngIf="item.iconIdle && parent.isHybrisIcon(item.displayClass)"
                id="{{ item.i18nKey | translate }}-{{ parent.smarteditComponentId }}-{{
                    parent.smarteditComponentType
                }}-hyicon"
                (click)="parent.triggerMenuItemAction(item, $event)"
                [ngClass]="{ clickable: true }"
            >
                <img
                    [src]="isHovered ? item.iconNonIdle : item.iconIdle"
                    id="{{ item.i18nKey | translate }}-{{ parent.smarteditComponentId }}-{{
                        parent.smarteditComponentType
                    }}-hyicon-img"
                    title="{{ item.i18nKey | translate }}"
                />
            </span>
            <img
                [title]="item.i18nKey | translate"
                *ngIf="item.iconIdle && !parent.isHybrisIcon(item.displayClass)"
                [ngClass]="{ clickable: true }"
                (click)="parent.triggerMenuItemAction(item, $event)"
                [src]="isHovered ? item.iconNonIdle : item.iconIdle"
                [alt]="item.i18nKey"
                class="{{ item.displayClass }}"
                id="{{ item.i18nKey | translate }}-{{ parent.smarteditComponentId }}-{{
                    parent.smarteditComponentType
                }}"
            />
        </div>

        <div *ngIf="item.action.component">
            <ng-container
                *ngComponentOutlet="item.action.component; injector: componentInjector"
            ></ng-container>
        </div>
    `
});
exports.SlotContextualMenuItemComponent = class SlotContextualMenuItemComponent {
    constructor(parent, injector) {
        this.parent = parent;
        this.injector = injector;
    }
    onMouseOver() {
        this.isHovered = true;
    }
    onMouseOut() {
        this.isHovered = false;
    }
    ngOnInit() {
        this.createComponentInjector();
    }
    ngOnChanges() {
        this.createComponentInjector();
    }
    createComponentInjector() {
        this.componentInjector = core.Injector.create({
            parent: this.injector,
            providers: [
                {
                    provide: smarteditcommons.CONTEXTUAL_MENU_ITEM_DATA,
                    useValue: {
                        componentAttributes: this.parent.componentAttributes,
                        setRemainOpen: (key, remainOpen) => this.parent.setRemainOpen(key, remainOpen)
                    }
                }
            ]
        });
    }
};
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], exports.SlotContextualMenuItemComponent.prototype, "item", void 0);
__decorate([
    core.HostListener('mouseover'),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", void 0)
], exports.SlotContextualMenuItemComponent.prototype, "onMouseOver", null);
__decorate([
    core.HostListener('mouseout'),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", void 0)
], exports.SlotContextualMenuItemComponent.prototype, "onMouseOut", null);
exports.SlotContextualMenuItemComponent = __decorate([
    core.Component({
        selector: 'slot-contextual-menu-item',
        template: `
        <div *ngIf="!item.action.component">
            <span
                *ngIf="item.iconIdle && parent.isHybrisIcon(item.displayClass)"
                id="{{ item.i18nKey | translate }}-{{ parent.smarteditComponentId }}-{{
                    parent.smarteditComponentType
                }}-hyicon"
                (click)="parent.triggerMenuItemAction(item, $event)"
                [ngClass]="{ clickable: true }"
            >
                <img
                    [src]="isHovered ? item.iconNonIdle : item.iconIdle"
                    id="{{ item.i18nKey | translate }}-{{ parent.smarteditComponentId }}-{{
                        parent.smarteditComponentType
                    }}-hyicon-img"
                    title="{{ item.i18nKey | translate }}"
                />
            </span>
            <img
                [title]="item.i18nKey | translate"
                *ngIf="item.iconIdle && !parent.isHybrisIcon(item.displayClass)"
                [ngClass]="{ clickable: true }"
                (click)="parent.triggerMenuItemAction(item, $event)"
                [src]="isHovered ? item.iconNonIdle : item.iconIdle"
                [alt]="item.i18nKey"
                class="{{ item.displayClass }}"
                id="{{ item.i18nKey | translate }}-{{ parent.smarteditComponentId }}-{{
                    parent.smarteditComponentType
                }}"
            />
        </div>

        <div *ngIf="item.action.component">
            <ng-container
                *ngComponentOutlet="item.action.component; injector: componentInjector"
            ></ng-container>
        </div>
    `
    }),
    __param(0, core.Inject(core.forwardRef(() => exports.SlotContextualMenuDecoratorComponent))),
    __metadata("design:paramtypes", [exports.SlotContextualMenuDecoratorComponent,
        core.Injector])
], exports.SlotContextualMenuItemComponent);

const smarteditElementComponentSelector = 'smartedit-element';
window.__smartedit__.addDecoratorPayload("Component", "SmarteditElementComponent", {
    selector: smarteditElementComponentSelector,
    template: ` <div id="projectedContent"><ng-content></ng-content></div> `
});
let SmarteditElementComponent = class SmarteditElementComponent {
    constructor(elementRef, sakExecutorService, systemEventService, crossFrameEventService, polyfillService) {
        this.elementRef = elementRef;
        this.sakExecutorService = sakExecutorService;
        this.systemEventService = systemEventService;
        this.crossFrameEventService = crossFrameEventService;
        this.polyfillService = polyfillService;
        this.active = false;
        this.componentDecoratorEnabled = true;
        this.removeDecorators = () => {
            // removing previous content of placeHolder
            if (this.bundle && this.element.contains(this.bundle)) {
                this.element.removeChild(this.bundle);
            }
            this.bundle = this.projectedContent;
            this.element.appendChild(this.bundle);
        };
        this.appendDecorators = () => {
            // removing previous content of placeHolder
            if (this.bundle && this.element.contains(this.bundle)) {
                this.element.removeChild(this.bundle);
            }
            this.sakExecutorService
                .wrapDecorators(this.projectedContent, this.element)
                .then((bundle) => {
                this.bundle = bundle;
                this.element.appendChild(this.bundle);
            });
        };
        this.propagateActiveStateToChildren = () => {
            this.element.querySelectorAll('[active]').forEach((element) => {
                if (this.uuid === this.getUuid(element)) {
                    element.setAttribute('active', this.active + '');
                }
            });
        };
    }
    ngOnInit() {
        const projectedContentWrapper = this.element.querySelector('#projectedContent');
        this.projectedContent = projectedContentWrapper.children[0];
        this.element.removeChild(projectedContentWrapper);
        this.appendDecorators();
    }
    ngAfterViewInit() {
        this.mousenterListener = (event) => {
            if (!this.active) {
                this.active = this.componentDecoratorEnabled;
                this.propagateActiveStateToChildren();
            }
        };
        this.mouseleaveListener = (event) => {
            if (this.active) {
                this.active = false;
                this.propagateActiveStateToChildren();
            }
        };
        // Register Event Listeners
        this.element.addEventListener('mouseenter', this.mousenterListener);
        this.element.addEventListener('mouseleave', this.mouseleaveListener);
        this.unregisterPerspectiveChangeEvent = this.crossFrameEventService.subscribe(smarteditcommons.EVENT_PERSPECTIVE_CHANGED, (eventId, notPreview) => {
            notPreview && this.appendDecorators();
        });
        this.unregisterPerspectiveRefreshedEvent = this.crossFrameEventService.subscribe(smarteditcommons.EVENT_PERSPECTIVE_REFRESHED, (eventId, notPreview) => {
            notPreview && this.appendDecorators();
        });
        this.unregisterComponentUpdatedEvent = this.crossFrameEventService.subscribe(smarteditcommons.EVENT_SMARTEDIT_COMPONENT_UPDATED, this.onComponentUpdated.bind(this));
        // we can't listen to these events in the controller because they could be sent before the component compilation.
        this.unregisterDnDStart = this.systemEventService.subscribe(smarteditcommons.SMARTEDIT_DRAG_AND_DROP_EVENTS.DRAG_DROP_START, (eventId, smarteditComponentClosestToDraggedElement) => {
            if (this.polyfillService.isEligibleForEconomyMode() &&
                smarteditComponentClosestToDraggedElement &&
                this.uuid ===
                    smarteditComponentClosestToDraggedElement.attr(smarteditcommons.ELEMENT_UUID_ATTRIBUTE)) {
                this.componentDecoratorEnabled = false;
                this.removeDecorators();
            }
        });
        this.unregisterDnDEnd = this.systemEventService.subscribe(smarteditcommons.SMARTEDIT_DRAG_AND_DROP_EVENTS.DRAG_DROP_END, () => {
            if (this.polyfillService.isEligibleForEconomyMode()) {
                this.componentDecoratorEnabled = true;
                this.appendDecorators();
            }
        });
    }
    ngOnDestroy() {
        this.removeDecorators();
        this.unregisterPerspectiveChangeEvent();
        this.unregisterPerspectiveRefreshedEvent();
        this.unregisterComponentUpdatedEvent();
        this.unregisterDnDEnd();
        this.unregisterDnDStart();
        this.element.removeEventListener('mouseenter', this.mousenterListener);
        this.element.removeEventListener('mouseleave', this.mouseleaveListener);
        delete this.bundle;
    }
    onComponentUpdated(eventId, componentUpdatedData) {
        const requiresReplayingDecorators = componentUpdatedData && componentUpdatedData.requiresReplayingDecorators;
        const isCurrentComponent = componentUpdatedData &&
            componentUpdatedData.componentId === this.smarteditComponentId &&
            componentUpdatedData.componentType === this.smarteditComponentType;
        if (isCurrentComponent && requiresReplayingDecorators) {
            this.appendDecorators();
        }
    }
    getUuid(element) {
        return element.getAttribute(smarteditcommons.ELEMENT_UUID_ATTRIBUTE);
    }
    get uuid() {
        return this.element.getAttribute(smarteditcommons.ELEMENT_UUID_ATTRIBUTE);
    }
    get element() {
        return this.elementRef.nativeElement;
    }
};
__decorate([
    core.Input('data-smartedit-component-id'),
    __metadata("design:type", String)
], SmarteditElementComponent.prototype, "smarteditComponentId", void 0);
__decorate([
    core.Input('data-smartedit-component-uuid'),
    __metadata("design:type", String)
], SmarteditElementComponent.prototype, "smarteditComponentUuid", void 0);
__decorate([
    core.Input('data-smartedit-component-type'),
    __metadata("design:type", String)
], SmarteditElementComponent.prototype, "smarteditComponentType", void 0);
__decorate([
    core.Input('data-smartedit-container-id'),
    __metadata("design:type", String)
], SmarteditElementComponent.prototype, "smarteditContainerId", void 0);
__decorate([
    core.Input('data-smartedit-container-type'),
    __metadata("design:type", String)
], SmarteditElementComponent.prototype, "smarteditContainerType", void 0);
SmarteditElementComponent = __decorate([
    smarteditcommons.SeCustomComponent(),
    core.Component({
        selector: smarteditElementComponentSelector,
        template: ` <div id="projectedContent"><ng-content></ng-content></div> `
    }),
    __metadata("design:paramtypes", [core.ElementRef,
        SakExecutorService,
        smarteditcommons.SystemEventService,
        smarteditcommons.CrossFrameEventService,
        smarteditcommons.PolyfillService])
], SmarteditElementComponent);

/** @internal */
let /* @ngInject */ StorageGateway = class /* @ngInject */ StorageGateway {
    handleStorageRequest(storageConfiguration, method, args) {
        'proxyFunction';
        return null;
    }
};
/* @ngInject */ StorageGateway = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IStorageGateway),
    smarteditcommons.GatewayProxied('handleStorageRequest')
], /* @ngInject */ StorageGateway);

/** @internal */
class StorageProxy {
    constructor(configuration, storageGateway) {
        this.configuration = configuration;
        this.storageGateway = storageGateway;
    }
    clear() {
        return this.storageGateway.handleStorageRequest(this.configuration, 'clear', this.arrayFromArguments(arguments));
    }
    dispose() {
        return this.storageGateway.handleStorageRequest(this.configuration, 'dispose', this.arrayFromArguments(arguments));
    }
    entries() {
        return this.storageGateway.handleStorageRequest(this.configuration, 'entries', this.arrayFromArguments(arguments));
    }
    find(queryObject) {
        return this.storageGateway.handleStorageRequest(this.configuration, 'find', this.arrayFromArguments(arguments));
    }
    get(queryObject) {
        return this.storageGateway.handleStorageRequest(this.configuration, 'get', this.arrayFromArguments(arguments));
    }
    getLength() {
        return this.storageGateway.handleStorageRequest(this.configuration, 'getLength', this.arrayFromArguments(arguments));
    }
    put(obj, queryObject) {
        return this.storageGateway.handleStorageRequest(this.configuration, 'put', this.arrayFromArguments(arguments));
    }
    remove(queryObject) {
        return this.storageGateway.handleStorageRequest(this.configuration, 'remove', this.arrayFromArguments(arguments));
    }
    arrayFromArguments(args) {
        return Array.prototype.slice.call(args);
    }
}

/** @internal */
let /* @ngInject */ StorageManagerGateway = class /* @ngInject */ StorageManagerGateway {
    constructor($log, storageGateway) {
        this.$log = $log;
        this.storageGateway = storageGateway;
    }
    /**
     * Disabled for inner app, due not to being able to pass storage controller instances across the gateway
     * @param {IStorageController} controller
     */
    registerStorageController(controller) {
        throw new Error(`registerStorageController() is not supported from the smartedit (inner) application, please register controllers from smarteditContainer`);
    }
    getStorage(storageConfiguration) {
        const errMsg = `Unable to get storage ${storageConfiguration.storageId}`;
        return new Promise((resolve, reject) => {
            this.getStorageSanitityCheck(storageConfiguration).then((createdSuccessfully) => {
                if (createdSuccessfully) {
                    resolve(new StorageProxy(storageConfiguration, this.storageGateway));
                }
                else {
                    this.$log.error(errMsg);
                    reject(errMsg);
                }
            }, (result) => {
                this.$log.error(errMsg);
                this.$log.error(result);
                reject(errMsg);
            });
        });
    }
    // =============================================
    // ============= PROXIED METHODS ===============
    // =============================================
    deleteExpiredStorages(force) {
        'proxyFunction';
        return undefined;
    }
    deleteStorage(storageId, force) {
        'proxyFunction';
        return undefined;
    }
    getStorageSanitityCheck(storageConfiguration) {
        'proxyFunction';
        return undefined;
    }
    hasStorage(storageId) {
        'proxyFunction';
        return false;
    }
};
StorageManagerGateway.$inject = ["$log", "storageGateway"];
/* @ngInject */ StorageManagerGateway = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IStorageManagerGateway),
    smarteditcommons.GatewayProxied('getStorageSanitityCheck', 'deleteExpiredStorages', 'deleteStorage', 'hasStorage'),
    __metadata("design:paramtypes", [smarteditcommons.LogService, smarteditcommons.IStorageGateway])
], /* @ngInject */ StorageManagerGateway);

let StorageModule = class StorageModule {
};
StorageModule = __decorate([
    core.NgModule({
        providers: [
            /**
             * The StorageManagerFactory implements the IStorageManagerFactory interface, and produces
             * StorageManager instances. Typically you would only create one StorageManager instance, and expose it through a
             * service for the rest of your application. StorageManagers produced from this factory will take care of
             * name-spacing storage ids, preventing clashes between extensions, or other storages with the same ID.
             * All StorageManagers produced by the storageManagerFactory delegate to the same single root StorageManager.
             *
             */
            { provide: smarteditcommons.IStorageGateway, useValue: StorageGateway },
            { provide: smarteditcommons.IStorageManagerGateway, useValue: StorageManagerGateway },
            {
                provide: smarteditcommons.IStorageManagerFactory,
                deps: [smarteditcommons.IStorageManagerGateway],
                // eslint-disable-next-line @typescript-eslint/explicit-function-return-type
                useFactory: (storageManagerGateway) => new smarteditcommons.StorageManagerFactory(storageManagerGateway)
            },
            {
                provide: smarteditcommons.IStorageManager,
                deps: [smarteditcommons.IStorageManagerFactory],
                // eslint-disable-next-line @typescript-eslint/explicit-function-return-type
                useFactory: (storageManagerFactory) => storageManagerFactory.getStorageManager('se.nsp')
            },
            smarteditcommons.moduleUtils.initialize((storageManagerFactory, storageGateway) => {
                smarteditcommons.diBridgeUtils.downgradeService('storageManagerFactory', smarteditcommons.IStorageManagerFactory);
                smarteditcommons.diBridgeUtils.downgradeService('seStorageManager', smarteditcommons.IStorageManager);
            }, [smarteditcommons.IStorageManagerFactory, smarteditcommons.IStorageGateway])
        ]
    })
], StorageModule);

const SmarteditFactory = (payload) => {
    let Smartedit = class Smartedit {
    };
    Smartedit = __decorate([
        core.NgModule({
            schemas: [core.CUSTOM_ELEMENTS_SCHEMA],
            imports: [
                platformBrowser.BrowserModule,
                _static.UpgradeModule,
                http.HttpClientModule,
                StorageModule,
                exports.SmarteditServicesModule,
                smarteditcommons.PopupOverlayModule,
                smarteditcommons.CompileHtmlModule,
                smarteditcommons.HttpInterceptorModule.forRoot(smarteditcommons.RetryInterceptor),
                smarteditcommons.SeTranslationModule.forRoot(exports.TranslationsFetchService),
                ...payload.modules
                /* TODO: create a function and dynamic add of extensions NgModule(s) */
            ],
            declarations: [
                SmarteditComponent,
                SmarteditElementComponent,
                exports.ContextualMenuDecoratorComponent,
                ContextualMenuItemComponent,
                exports.MoreItemsComponent,
                exports.ContextualMenuItemOverlayComponent,
                exports.SlotContextualMenuDecoratorComponent,
                exports.SlotContextualMenuItemComponent
            ],
            entryComponents: [
                SmarteditComponent,
                SmarteditElementComponent,
                exports.ContextualMenuDecoratorComponent,
                ContextualMenuItemComponent,
                exports.MoreItemsComponent,
                exports.ContextualMenuItemOverlayComponent,
                exports.SlotContextualMenuDecoratorComponent,
                exports.SlotContextualMenuItemComponent
            ],
            providers: [
                { provide: smarteditcommons.IAuthenticationManagerService, useClass: smarteditcommons.AuthenticationManager },
                {
                    provide: smarteditcommons.IConfirmationModalService,
                    useClass: exports.ConfirmationModalService
                },
                {
                    provide: smarteditcommons.IAuthenticationService,
                    useClass: exports.AuthenticationService
                },
                {
                    provide: core.ErrorHandler,
                    useClass: smarteditcommons.SmarteditErrorHandler
                },
                {
                    provide: smarteditcommons.ILegacyDecoratorToCustomElementConverter,
                    useClass: exports.LegacyDecoratorToCustomElementConverter
                },
                {
                    provide: smarteditcommons.IDecoratorService,
                    useClass: exports.DecoratorService
                },
                { provide: smarteditcommons.IContextualMenuService, useClass: exports.ContextualMenuService },
                SakExecutorService,
                {
                    provide: smarteditcommons.ISessionService,
                    useClass: exports.SessionService
                },
                {
                    provide: smarteditcommons.IToolbarServiceFactory,
                    useClass: exports.ToolbarServiceFactory
                },
                {
                    provide: smarteditcommons.ISharedDataService,
                    useClass: exports.SharedDataService
                },
                {
                    provide: smarteditcommons.IStorageService,
                    useClass: exports.StorageService
                },
                {
                    provide: smarteditcommons.IUrlService,
                    useClass: exports.UrlService
                },
                {
                    provide: smarteditcommons.IIframeClickDetectionService,
                    useClass: exports.IframeClickDetectionService
                },
                {
                    provide: smarteditcommons.ICatalogService,
                    useClass: exports.CatalogService
                },
                {
                    provide: smarteditcommons.IExperienceService,
                    useClass: exports.ExperienceService
                },
                smarteditcommons.SmarteditRoutingService,
                smarteditcommons.moduleUtils.provideValues(payload.constants),
                // temporary upgrades
                smarteditcommons.diBridgeUtils.upgradeProvider('EVENT_PERSPECTIVE_CHANGED'),
                smarteditcommons.diBridgeUtils.upgradeProvider('EVENT_PERSPECTIVE_REFRESHED'),
                smarteditcommons.diBridgeUtils.upgradeProvider('EVENT_SMARTEDIT_COMPONENT_UPDATED'),
                smarteditcommons.diBridgeUtils.upgradeProvider('SMARTEDIT_DRAG_AND_DROP_EVENTS'),
                smarteditcommons.diBridgeUtils.upgradeProvider('$templateCache', smarteditcommons.ITemplateCacheService),
                smarteditcommons.moduleUtils.bootstrap((gatewayFactory, smartEditContractChangeListener, seNamespaceService, resizeComponentService, renderService, systemEventService, pageInfoService, experienceService, polyfillService, crossFrameEventService, perspectiveService, languageService, featureService, angularJSBootstrapIndicatorService, pageTreeNodeService, userTrackingService) => {
                    angularJSBootstrapIndicatorService.onSmarteditReady().subscribe(() => {
                        gatewayFactory.initListener();
                        smartEditContractChangeListener.onComponentsAdded((components, isEconomyMode) => {
                            if (!isEconomyMode) {
                                seNamespaceService.reprocessPage();
                                resizeComponentService.resizeComponents(true);
                            }
                            components.forEach((component) => renderService.createComponent(component));
                            systemEventService.publishAsync(smarteditcommons.OVERLAY_RERENDERED_EVENT, {
                                addedComponents: components
                            });
                        });
                        smartEditContractChangeListener.onComponentsRemoved((components, isEconomyMode) => {
                            if (!isEconomyMode) {
                                seNamespaceService.reprocessPage();
                            }
                            components.forEach((entry) => renderService.destroyComponent(entry.component, entry.parent, entry.oldAttributes));
                            systemEventService.publishAsync(smarteditcommons.OVERLAY_RERENDERED_EVENT, {
                                removedComponents: lodash.map(components, 'component')
                            });
                        });
                        smartEditContractChangeListener.onComponentResized((component) => {
                            seNamespaceService.reprocessPage();
                            renderService.updateComponentSizeAndPosition(component);
                        });
                        smartEditContractChangeListener.onComponentRepositioned((component) => {
                            renderService.updateComponentSizeAndPosition(component);
                        });
                        smartEditContractChangeListener.onComponentChanged((component, oldAttributes) => {
                            seNamespaceService.reprocessPage();
                            renderService.destroyComponent(component, component.parent, oldAttributes);
                            renderService.createComponent(component);
                        });
                        smartEditContractChangeListener.onPageChanged((pageUUID) => {
                            pageInfoService
                                .getCatalogVersionUUIDFromPage()
                                .then((catalogVersionUUID) => {
                                pageInfoService.getPageUID().then((pageUID) => {
                                    experienceService.updateExperiencePageContext(catalogVersionUUID, pageUID);
                                });
                            });
                            pageTreeNodeService.buildSlotNodes();
                        });
                        if (polyfillService.isEligibleForEconomyMode()) {
                            systemEventService.subscribe(smarteditcommons.SMARTEDIT_DRAG_AND_DROP_EVENTS.DRAG_DROP_START, function () {
                                smartEditContractChangeListener.setEconomyMode(true);
                            });
                            systemEventService.subscribe(smarteditcommons.SMARTEDIT_DRAG_AND_DROP_EVENTS.DRAG_DROP_END, function () {
                                seNamespaceService.reprocessPage();
                                resizeComponentService.resizeComponents(true);
                                smartEditContractChangeListener.setEconomyMode(false);
                            });
                        }
                        crossFrameEventService.subscribe(smarteditcommons.EVENTS.PAGE_CHANGE, () => {
                            perspectiveService.refreshPerspective();
                            languageService.registerSwitchLanguage();
                        });
                        smartEditContractChangeListener.initListener();
                        pageTreeNodeService.buildSlotNodes();
                        userTrackingService.initConfiguration();
                        // Feature registration
                        featureService.register({
                            key: 'se.emptySlotFix',
                            nameI18nKey: 'se.emptyslotfix',
                            enablingCallback: () => {
                                resizeComponentService.resizeComponents(true);
                            },
                            disablingCallback: () => {
                                resizeComponentService.resizeComponents(false);
                            }
                        });
                        featureService.addDecorator({
                            key: 'se.contextualMenu',
                            nameI18nKey: 'contextualMenu'
                        });
                        featureService.addDecorator({
                            key: 'se.slotContextualMenu',
                            nameI18nKey: 'se.slot.contextual.menu'
                        });
                    });
                }, [
                    smarteditcommons.GatewayFactory,
                    smarteditcommons.ISmartEditContractChangeListener,
                    exports.SeNamespaceService,
                    exports.ResizeComponentService,
                    smarteditcommons.IRenderService,
                    smarteditcommons.SystemEventService,
                    smarteditcommons.IPageInfoService,
                    smarteditcommons.IExperienceService,
                    smarteditcommons.PolyfillService,
                    smarteditcommons.CrossFrameEventService,
                    smarteditcommons.IPerspectiveService,
                    smarteditcommons.LanguageService,
                    smarteditcommons.IFeatureService,
                    smarteditcommons.AngularJSBootstrapIndicatorService,
                    smarteditcommons.IPageTreeNodeService,
                    smarteditcommons.UserTrackingService
                ]),
                smarteditcommons.moduleUtils.initialize((httpClient, iframeClickDetectionService, // initializes mousedown event listener for the iframe
                l10nService) => {
                    smarteditcommons.diBridgeUtils.downgradeService('languageService', smarteditcommons.LanguageService);
                    smarteditcommons.diBridgeUtils.downgradeService('httpClient', http.HttpClient);
                    smarteditcommons.diBridgeUtils.downgradeService('l10nPipe', smarteditcommons.L10nPipe);
                    return l10nService.resolveLanguage();
                }, [http.HttpClient, smarteditcommons.IIframeClickDetectionService, smarteditcommons.L10nService])
            ],
            bootstrap: [SmarteditComponent]
        })
    ], Smartedit);
    return Smartedit;
};
/* forbiddenNameSpaces window._:false */
window.__smartedit__.SmarteditFactory = SmarteditFactory;

if (process.env.NODE_ENV === 'production') {
    core.enableProdMode();
}

exports.BaseContextualMenuComponent = BaseContextualMenuComponent;
exports.RestService = RestService;
exports.SmarteditFactory = SmarteditFactory;
