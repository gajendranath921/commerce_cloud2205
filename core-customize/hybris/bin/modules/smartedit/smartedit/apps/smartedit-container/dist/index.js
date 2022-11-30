'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@angular/core');
var http = require('@angular/common/http');
var angular = require('angular');
var lo = require('lodash');
var smarteditcommons = require('smarteditcommons');
var rxjs = require('rxjs');
var operators = require('rxjs/operators');
var common = require('@angular/common');
var router = require('@angular/router');
var core$2 = require('@ngx-translate/core');
var core$1 = require('@fundamental-ngx/core');
var forms = require('@angular/forms');
var moment = require('moment');
var platformBrowser = require('@angular/platform-browser');
var animations$1 = require('@angular/platform-browser/animations');
var _static = require('@angular/upgrade/static');
var animations = require('@angular/animations');

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

var lo__namespace = /*#__PURE__*/_interopNamespace(lo);
var moment__default = /*#__PURE__*/_interopDefaultLegacy(moment);

(function(){
      var angular = angular || window.angular;
      var SE_NG_TEMPLATE_MODULE = null;
      
      try {
        SE_NG_TEMPLATE_MODULE = angular.module('coretemplates');
      } catch (err) {}
      SE_NG_TEMPLATE_MODULE = SE_NG_TEMPLATE_MODULE || angular.module('coretemplates', []);
      SE_NG_TEMPLATE_MODULE.run(['$templateCache', function($templateCache) {
         
    $templateCache.put(
        "AnnouncementBoardComponent.html", 
        "<ng-container *ngIf=\"(announcements$ | async) as announcements\"><div class=\"se-announcement-board\"><se-announcement *ngFor=\"                let announcement of (announcements | seReverse);                trackBy: annnouncementTrackBy;                let i = index            \" id=\"se-announcement-{{ i }}\" [announcement]=\"announcement\"></se-announcement></div></ng-container>"
    );
     
    $templateCache.put(
        "AnnouncementComponent.html", 
        "<div class=\"se-announcement-content\"><span *ngIf=\"isCloseable()\" class=\"sap-icon--decline se-announcement-close\" (click)=\"closeAnnouncement()\"></span><div *ngIf=\"hasMessage()\"><h4 *ngIf=\"hasMessageTitle()\">{{ announcement.messageTitle | translate }}</h4><span>{{ announcement.message | translate }}</span></div><ng-container *ngIf=\"hasComponent()\"><ng-container *ngComponentOutlet=\"announcement.component; injector: announcementInjector\"></ng-container></ng-container></div>"
    );
     
    $templateCache.put(
        "ExperienceSelectorComponent.html", 
        "<se-generic-editor *ngIf=\"isReady\" [smarteditComponentType]=\"smarteditComponentType\" [smarteditComponentId]=\"smarteditComponentId\" [structureApi]=\"structureApi\" [content]=\"content\" [contentApi]=\"contentApi\" (getApi)=\"getApi($event)\"></se-generic-editor>"
    );
     
    $templateCache.put(
        "ConfigurationModalComponent.html", 
        "<div id=\"editConfigurationsBody\" class=\"se-config\"><form #form=\"ngForm\" novalidate><div class=\"se-config__sub-header\"><span class=\"se-config__sub-title\">{{'se.configurationform.label.keyvalue' | translate}}</span> <button class=\"se-config__add-entry-btn fd-button--compact\" type=\"button\" (click)=\"editor.addEntry()\">{{ \"se.general.configuration.add.button\" | translate }}</button></div><div class=\"se-config__entry\" *ngFor=\"let entry of editor.filterConfiguration(); let $index = index\"><div class=\"se-config__entry-data\"><div class=\"se-config__entry-key\"><input type=\"text\" [ngClass]=\"{                            'is-invalid': entry.errors &&  entry.errors.keys && entry.errors.keys.length > 0,                            'se-config__entry-key--disabled': !entry.isNew }\" name=\"{{entry.key}}_{{entry.uuid}}_key\" placeholder=\"{{'se.configurationform.header.key.name' | translate}}\" [(ngModel)]=\"entry.key\" [required]=\"true\" [disabled]=\"!entry.isNew\" class=\"se-config__entry-key-input fd-form__control\" [title]=\"entry.key\"/><ng-container *ngIf=\"entry.errors && entry.errors.keys\"><span id=\"{{entry.key}}_error_{{$index}}\" *ngFor=\"let error of entry.errors.keys; let $index = index\" class=\"error-input help-block\">{{error.message|translate}}</span></ng-container></div><div class=\"se-config__entry-value\"><textarea [ngClass]=\"{'is-invalid': entry.errors && entry.errors.values && entry.errors.values.length>0}\" name=\"{{entry.key}}_{{entry.uuid}}_value\" placeholder=\"{{'se.configurationform.header.value.name' | translate}}\" [(ngModel)]=\"entry.value\" [required]=\"true\" class=\"se-config__entry-text-area fd-form__control\" (change)=\"editor.validateUserInput(entry)\"></textarea><div *ngIf=\"entry.requiresUserCheck\"><input id=\"{{entry.key}}_absoluteUrl_check_{{$index}}\" type=\"checkbox\" name=\"{{entry.key}}_{{entry.uuid}}_isCheckedByUser\" [(ngModel)]=\"entry.isCheckedByUser\"/> <span id=\"{{entry.key}}_absoluteUrl_msg_{{$index}}\" [ngClass]=\"{                                'warning-check-msg': true,                                'not-checked': entry.hasErrors && !entry.isCheckedByUser                            }\">{{'se.configurationform.absoluteurl.check' | translate}}</span></div><ng-container *ngIf=\"entry.errors && entry.errors.values && entry.errors.values\"><span id=\"{{entry.key}}_error_{{$index}}\" *ngFor=\"let error of entry.errors.values; let $index = index\" class=\"error-input help-block\">{{error.message|translate}}</span></ng-container></div></div><button type=\"button\" id=\"{{entry.key}}_removeButton_{{$index}}\" class=\"se-config__entry-remove-btn fd-button--light sap-icon--delete\" (click)=\"editor.removeEntry(entry, form);\"></button></div></form></div>"
    );
     
    $templateCache.put(
        "HeartBeatAlertComponent.html", 
        "<div><span>{{ 'se.heartbeat.failure1' | translate }}</span> <span><a (click)=\"switchToPreviewMode()\">{{ 'se.heartbeat.failure2' | translate }}</a></span></div>"
    );
     
    $templateCache.put(
        "HotkeyNotificationComponentTemplate.html", 
        "<div class=\"se-notification__hotkey\"><div *ngFor=\"let key of hotkeyNames; let last = last\"><div class=\"se-notification__hotkey--key\"><span>{{ key }}</span></div><span *ngIf=\"!last\" class=\"se-notification__hotkey__icon--add\">+</span></div><div class=\"se-notification__hotkey--text\"><div class=\"se-notification__hotkey--title\">{{ title }}</div><div class=\"se-notification__hotkey--message\">{{ message }}</div></div></div>"
    );
     
    $templateCache.put(
        "NotificationComponentTemplate.html", 
        "<div class=\"se-notification\" id=\"{{ id }}\" *ngIf=\"notification\"><div [seCustomComponentOutlet]=\"notification.componentName\"></div></div>"
    );
     
    $templateCache.put(
        "NotificationPanelComponentTemplate.html", 
        "<ng-container *ngIf=\"(notifications$ | async) as notifications\"><div class=\"se-notification-panel\" *ngIf=\"notifications.length > 0\" [ngClass]=\"{'is-mouseover': isMouseOver}\" (mouseenter)=\"onMouseEnter()\"><div><se-notification *ngFor=\"let notification of (notifications | seReverse)\" [notification]=\"notification\"></se-notification></div></div></ng-container>"
    );
     
    $templateCache.put(
        "sitesLinkTemplate.html", 
        "<div (click)=\"goToSites()\" class=\"se-sites-link {{cssClass}}\"><a class=\"se-sites-link__text\">{{'se.toolbar.sites' | translate}}</a> <span class=\"icon-navigation-right-arrow se-sites-link__arrow {{iconCssClass}}\"></span></div>"
    );
     
    $templateCache.put(
        "sitesLinkWrapperTemplate.html", 
        "<sites-link/>"
    );
     
    $templateCache.put(
        "UserAccountComponent.html", 
        "<div class=\"se-user-account-dropdown\"><div class=\"se-user-account-dropdown__role\">{{ 'se.toolbar.useraccount.role' | translate }}</div><div class=\"user-account-dropdown__name\">{{username}}</div><div class=\"divider\"></div><a class=\"se-sign-out__link fd-menu__item\" (click)=\"signOut()\">{{'se.toolbar.useraccount.signout' | translate}}</a></div>"
    );
     
    $templateCache.put(
        "ExperienceSelectorButtonComponent.html", 
        "<fd-popover class=\"se-experience-selector\" [(isOpen)]=\"status.isOpen\" (isOpenChange)=\"resetExperienceSelector()\" [closeOnOutsideClick]=\"false\" [triggers]=\"['click']\" [placement]=\"'bottom-end'\"><fd-popover-control><div class=\"se-experience-selector__control\"><se-tooltip [placement]=\"'bottom'\" [triggers]=\"['mouseenter', 'mouseleave']\" *ngIf=\"isCurrentPageFromParent\" class=\"se-experience-selector__tooltip\"><span se-tooltip-trigger class=\"se-experience-selector__btn--globe\"><span class=\"hyicon hyicon-globe se-experience-selector__btn--globe--icon\"></span></span><div se-tooltip-body>{{ parentCatalogVersion }}</div></se-tooltip><button class=\"se-experience-selector__btn\" id=\"experience-selector-btn\"><span [attr.title]=\"experienceText\" class=\"se-experience-selector__btn-text se-nowrap-ellipsis\">{{ experienceText }} </span><span class=\"se-experience-selector__btn-arrow icon-navigation-down-arrow\"></span></button></div></fd-popover-control><fd-popover-body><div class=\"se-experience-selector__dropdown fd-modal fd-modal__content\" role=\"menu\"><se-experience-selector [experience]=\"experience\" [dropdownStatus]=\"status\" [(resetExperienceSelector)]=\"resetExperienceSelector\"></se-experience-selector></div></fd-popover-body></fd-popover>"
    );
     
    $templateCache.put(
        "inflectionPointSelectorWidgetComponentTemplate.html", 
        "<div class=\"se-inflection-point dropdown\" [class.open]=\"isOpen\" id=\"inflectionPtDropdown\"><button type=\"button\" class=\"se-inflection-point__toggle\" (click)=\"toggleDropdown($event)\" aria-pressed=\"false\" [attr.aria-expanded]=\"isOpen\"><span [ngClass]=\"getIconClass()\" class=\"se-inflection-point___selected\"></span></button><div class=\"se-inflection-point-dropdown\"><nav class=\"fd-menu\"><ul class=\"fd-menu__list\" role=\"menu\"><li *ngFor=\"let choice of points\" class=\"fd-menu__item inflection-point__device\" [ngClass]=\"{selected: isSelected(choice)}\" id=\"se-device-{{choice.type}}\" (click)=\"selectPoint(choice)\"><span [ngClass]=\"getIconClass(choice)\"></span></li></ul></nav></div></div>"
    );
     
    $templateCache.put(
        "PerspectiveSelectorComponent.html", 
        "<fd-popover [(isOpen)]=\"isOpen\" [closeOnOutsideClick]=\"false\" [triggers]=\"['click']\" *ngIf=\"hasActivePerspective()\" class=\"se-perspective-selector\" [placement]=\"'bottom-end'\" [disabled]=\"isDisabled\" [options]=\"popperOptions\"><fd-popover-control><div class=\"se-perspective-selector__trigger\"><se-tooltip [isChevronVisible]=\"true\" [triggers]=\"['mouseenter', 'mouseleave']\" *ngIf=\"isTooltipVisible()\"><span se-tooltip-trigger id=\"perspectiveTooltip\" class=\"hyicon hyicon-info se-perspective-selector__hotkey-tooltip--icon\"></span><div se-tooltip-body>{{ activePerspective.descriptionI18nKey | translate }}</div></se-tooltip><button class=\"se-perspective-selector__btn\" [disabled]=\"isDisabled\">{{getActivePerspectiveName() | translate}} <span class=\"se-perspective-selector__btn-arrow icon-navigation-down-arrow\"></span></button></div></fd-popover-control><fd-popover-body><ul class=\"se-perspective__list fd-list-group\" [ngClass]=\"{'se-perspective__list--tooltip': isTooltipVisible()}\" role=\"menu\"><li *ngFor=\"let choice of getDisplayedPerspectives()\" class=\"fd-list-group__item se-perspective__list-item fd-has-padding-none\"><a class=\"item se-perspective__list-item-text\" (click)=\"selectPerspective($event, choice.key);\">{{choice.nameI18nKey | translate}}</a></li></ul></fd-popover-body></fd-popover>"
    );
     
    $templateCache.put(
        "PerspectiveSelectorHotkeyNotificationComponentTemplate.html", 
        "<se-hotkey-notification [hotkeyNames]=\"['esc']\" [title]=\"'se.application.status.hotkey.title' | translate\" [message]=\"'se.application.status.hotkey.message' | translate\"></se-hotkey-notification>"
    );
     
    $templateCache.put(
        "LandingPageComponent.html", 
        "<div class=\"se-toolbar-group\"><se-toolbar cssClass=\"se-toolbar--shell\" imageRoot=\"imageRoot\" toolbarName=\"smartEditHeaderToolbar\"></se-toolbar></div><div class=\"se-landing-page\"><div class=\"se-landing-page-actions\"><div class=\"se-landing-page-container\"><h1 class=\"se-landing-page-title\">{{ 'se.landingpage.title' | translate }}</h1><div class=\"se-landing-page-site-selection\" *ngIf=\"model\"><se-generic-editor-dropdown [field]=\"field\" [qualifier]=\"qualifier\" [model]=\"model\" [id]=\"sitesId\"></se-generic-editor-dropdown></div><p class=\"se-landing-page-label\">{{ 'se.landingpage.label' | translate }}</p></div></div><p class=\"se-landing-page-container se-landing-page-sub-header\">Content Catalogs</p><div class=\"se-landing-page-container se-landing-page-catalogs\"><div class=\"se-landing-page-catalog\" *ngFor=\"let catalog of catalogs; let isLast = last\"><se-catalog-details [catalog]=\"catalog\" [siteId]=\"model.site\" [isCatalogForCurrentSite]=\"isLast\"></se-catalog-details></div></div><img src=\"static-resources/images/best-run-sap-logo.svg\" class=\"se-landing-page-footer-logo\"/></div>"
    );
     
    $templateCache.put(
        "PageTreeContainerComponent.html", 
        "<div *ngIf=\"component\" class=\"page-tree-container\"><ng-container *ngComponentOutlet=\"component\"></ng-container></div>"
    );
     
    $templateCache.put(
        "StorefrontPageComponent.html", 
        "<div class=\"se-toolbar-group\"><se-toolbar cssClass=\"se-toolbar--shell\" imageRoot=\"imageRoot\" toolbarName=\"smartEditHeaderToolbar\"></se-toolbar><se-toolbar cssClass=\"se-toolbar--experience\" imageRoot=\"imageRoot\" toolbarName=\"smartEditExperienceToolbar\"></se-toolbar><se-toolbar cssClass=\"se-toolbar--perspective\" imageRoot=\"imageRoot\" toolbarName=\"smartEditPerspectiveToolbar\"></se-toolbar></div><div id=\"js_iFrameWrapper\" class=\"iframeWrapper\"><div class=\"wrap\"><div *ngIf=\"showPageTreeList()\" class=\"page-tree__list\"><se-page-tree-container></se-page-tree-container></div><div class=\"iframe-panel\"><iframe id=\"ySmartEditFrame\" src=\"\"></iframe><div id=\"ySmartEditFrameDragArea\"></div></div></div></div>"
    );
     
    $templateCache.put(
        "MultiProductCatalogVersionConfigurationComponent.html", 
        "<div class=\"form-group se-multi-product-catalog-version-selector__label\">{{'se.product.catalogs.multiple.list.header' | translate}}</div><div class=\"se-multi-product-catalog-version-selector__catalog form-group\" *ngFor=\"let productCatalog of productCatalogs\"><label class=\"se-control-label se-multi-product-catalog-version-selector__catalog-name\" id=\"{{ productCatalog.catalogId }}-label\">{{ productCatalog.name | seL10n | async }}</label><div class=\"se-multi-product-catalog-version-selector__catalog-version\"><se-select [id]=\"productCatalog.catalogId\" [(model)]=\"productCatalog.selectedItem\" [onChange]=\"updateModel()\" [fetchStrategy]=\"productCatalog.fetchStrategy\"></se-select></div></div>"
    );
     
    $templateCache.put(
        "MultiProductCatalogVersionSelectorComponent.html", 
        "<se-tooltip [placement]=\"'bottom'\" [triggers]=\"['mouseenter', 'mouseleave']\" [isChevronVisible]=\"true\" class=\"se-products-catalog-select-multiple__tooltip\"><div id=\"multi-product-catalog-versions-selector\" se-tooltip-trigger (click)=\"onClickSelector()\" class=\"se-products-catalog-select-multiple\"><input type=\"text\" [value]=\"multiProductCatalogVersionsSelectedOptions$ | async\" class=\"form-control se-products-catalog-select-multiple__catalogs se-nowrap-ellipsis\" [name]=\"'productCatalogVersions'\" readonly=\"readonly\"/> <span class=\"hyicon hyicon-optionssm se-products-catalog-select-multiple__icon\"></span></div><div class=\"se-product-catalogs-tooltip\" se-tooltip-body><div class=\"se-product-catalogs-tooltip__h\">{{ ('se.product.catalogs.selector.headline.tooltip' || '') | translate }}</div><div class=\"se-product-catalog-info\" *ngFor=\"let productCatalog of productCatalogs\">{{ getCatalogNameCatalogVersionLabel(productCatalog.catalogId) | async }}</div></div></se-tooltip>"
    );
     
    $templateCache.put(
        "ProductCatalogVersionsSelectorComponent.html", 
        "<ng-container *ngIf=\"isReady\"><se-select *ngIf=\"isSingleVersionSelector\" [id]=\"geData.qualifier\" [(model)]=\"geData.model.productCatalogVersions[0]\" [(reset)]=\"reset\" [fetchStrategy]=\"fetchStrategy\"></se-select><se-multi-product-catalog-version-selector *ngIf=\"isMultiVersionSelector\" [productCatalogs]=\"productCatalogs\" [(selectedProductCatalogVersions)]=\"geData.model[geData.qualifier]\"></se-multi-product-catalog-version-selector></ng-container>"
    );
     
    $templateCache.put(
        "ToolbarActionComponent.html", 
        "<div *ngIf=\"item.isPermissionGranted\"><div *ngIf=\"item.type == type.ACTION\" class=\"toolbar-action\"><button type=\"button\" [ngClass]=\"{                'toolbar-action--button--compact': isCompact,                'toolbar-action--button': !isCompact            }\" class=\"btn\" (click)=\"toolbar.triggerAction(item, $event)\" [attr.aria-pressed]=\"false\" [attr.aria-haspopup]=\"true\" [attr.aria-expanded]=\"false\" id=\"{{toolbar.toolbarName}}_option_{{item.key}}_btn\"><span *ngIf=\"item.iconClassName\" id=\"{{toolbar.toolbarName}}_option_{{item.key}}_btn_iconclass\" class=\"{{item.iconClassName}}\" [ngClass]=\"{ 'se-toolbar-actions__icon': isCompact }\"></span> <img *ngIf=\"!item.iconClassName && item.icons\" id=\"{{toolbar.toolbarName}}_option_{{item.key}}\" src=\"{{toolbar.imageRoot}}{{item.icons[0]}}\" class=\"file\" title=\"{{item.name | translate}}\" alt=\"{{item.name | translate}}\"/> <span *ngIf=\"!isCompact\" class=\"toolbar-action-button__txt\" id=\"{{toolbar.toolbarName}}_option_{{item.key}}_btn_lbl\">{{item.name | translate}}</span></button></div><fd-popover class=\"se-toolbar-action__wrapper toolbar-action toolbar-action--hybrid\" *ngIf=\"item.type === type.HYBRID_ACTION\" [attr.data-item-key]=\"item.key\" [triggers]=\"['click']\" [noArrow]=\"false\" [isOpen]=\"item.isOpen\" [closeOnOutsideClick]=\"false\" (isOpenChange)=\"onOpenChange()\" [placement]=\"placement\" seClickOutside (clickOutside)=\"onOutsideClicked()\"><fd-popover-control><button *ngIf=\"item.iconClassName || item.icons\" type=\"button\" class=\"btn\" [ngClass]=\"{                    'toolbar-action--button--compact': isCompact,                    'toolbar-action--button': !isCompact                }\" [disabled]=\"disabled\" [attr.aria-pressed]=\"false \" (click)=\"toolbar.triggerAction(item, $event)\"><span *ngIf=\"item.iconClassName\" class=\"{{item.iconClassName}}\" [ngClass]=\"{ 'se-toolbar-actions__icon': isCompact }\"></span> <img *ngIf=\"!item.iconClassName && item.icons\" id=\"{{toolbar.toolbarName}}_option_{{item.key}}\" src=\"{{toolbar.imageRoot}}{{item.icons[0]}}\" class=\"file\" title=\"{{item.name | translate}}\" alt=\"{{item.name | translate}}\"/> <span *ngIf=\"!isCompact\" class=\"toolbar-action-button__txt\">{{item.name | translate}}</span></button></fd-popover-control><fd-popover-body class=\"se-toolbar-action__body\" [ngClass]=\"{                'toolbar-action--include--compact': isCompact,                'toolbar-action--include': !isCompact                          }\"><se-prevent-vertical-overflow><ng-container *ngIf=\"toolbar.getItemVisibility(item) && item.component\"><ng-container *ngComponentOutlet=\"item.component; injector: actionInjector\"></ng-container></ng-container></se-prevent-vertical-overflow></fd-popover-body></fd-popover></div>"
    );
     
    $templateCache.put(
        "ToolbarComponent.html", 
        "<div class=\"se-toolbar\" [ngClass]=\"cssClass\"><div class=\"se-toolbar__left\"><div *ngFor=\"let item of aliases | seProperty:{section:'left'}; trackBy: trackByFn\" class=\"se-template-toolbar se-template-toolbar__left {{item.className}}\"><se-toolbar-section-item [item]=\"item\"></se-toolbar-section-item></div></div><div class=\"se-toolbar__middle\"><div *ngFor=\"let item of aliases | seProperty:{section:'middle'}; trackBy: trackByFn\" class=\"se-template-toolbar se-template-toolbar__middle {{item.className}}\"><se-toolbar-section-item [item]=\"item\"></se-toolbar-section-item></div></div><div class=\"se-toolbar__right\"><div *ngFor=\"let item of aliases | seProperty:{section:'right'}; trackBy: trackByFn\" class=\"se-template-toolbar se-template-toolbar__right {{item.className}}\"><se-toolbar-section-item [item]=\"item\"></se-toolbar-section-item></div></div></div>"
    );
     
    $templateCache.put(
        "CatalogDetailsComponent.html", 
        "<div class=\"se-catalog-details\" [attr.data-catalog]=\"catalog.name | seL10n | async\"><div class=\"se-catalog-header\"><div class=\"se-catalog-header-flex\"><div class=\"se-catalog-details__header\">{{ catalog.name | seL10n | async }}</div><div *ngIf=\"catalog.parents?.length\"><a href=\"javascript:void(0)\" (click)=\"onOpenCatalogHierarchy()\">{{ 'se.landingpage.catalog.hierarchy' | translate }}</a></div></div></div><div class=\"se-catalog-details__content\"><se-catalog-version-details *ngFor=\"let catalogVersion of sortedCatalogVersions\" [catalog]=\"catalog\" [catalogVersion]=\"catalogVersion\" [activeCatalogVersion]=\"activeCatalogVersion\" [siteId]=\"siteId\"></se-catalog-version-details></div></div>"
    );
     
    $templateCache.put(
        "CatalogHierarchyModalComponent.html", 
        "<div class=\"se-catalog-hierarchy-header\"><span>{{ 'se.catalog.hierarchy.modal.tree.header' | translate }}</span></div><div *ngIf=\"this.catalogs$ | async as catalogs\" class=\"se-catalog-hierarchy-body\"><se-catalog-hierarchy-node *ngFor=\"let catalog of catalogs; let i = index\" [catalog]=\"catalog\" [index]=\"i\" [isLast]=\"i === catalogs.length - 1\" [siteId]=\"siteId\" (siteSelect)=\"onSiteSelected()\"></se-catalog-hierarchy-node></div>"
    );
     
    $templateCache.put(
        "CatalogHierarchyNodeComponent.html", 
        "<div class=\"se-cth-node-name\" [style.padding-left.px]=\"15 * index\" [style.padding-right.px]=\"15 * index\" [class.se-cth-node-name__last]=\"isLast\"><fd-icon glyph=\"navigation-down-arrow\"></fd-icon>{{ (isLast ? catalog.name : catalog.catalogName) | seL10n | async }}&nbsp; <span *ngIf=\"isLast\">({{ 'se.catalog.hierarchy.modal.tree.this.catalog' | translate}})</span></div><div class=\"se-cth-node-sites\"><ng-container><ng-container *ngIf=\"hasOneSite; else hasManySites\"><a class=\"se-cth-node-anchor\" href=\"\" (click)=\"onNavigateToSite(catalog.sites[0].uid)\">{{ catalog.sites[0].name | seL10n | async }}<fd-icon glyph=\"navigation-right-arrow\"></fd-icon></a></ng-container><ng-template #hasManySites><se-dropdown-menu [dropdownItems]=\"dropdownItems\" useProjectedAnchor=\"1\" (click)=\"onSiteSelect($event)\"><span class=\"se-cth-node-anchor\">{{ this.catalog.sites.length }} Sites<fd-icon glyph=\"navigation-down-arrow\"></fd-icon></span></se-dropdown-menu></ng-template></ng-container></div>"
    );
     
    $templateCache.put(
        "CatalogVersionDetailsComponent.html", 
        "<div class=\"se-catalog-version-container\" [attr.data-catalog-version]=\"catalogVersion.version\"><div class=\"se-catalog-version-container__left\"><se-catalog-versions-thumbnail-carousel [catalogVersion]=\"catalogVersion\" [catalog]=\"catalog\" [siteId]=\"siteId\"></se-catalog-versions-thumbnail-carousel><div><div class=\"se-catalog-version-container__name\">{{catalogVersion.version}}</div><div class=\"se-catalog-version-container__left__templates\"><div class=\"se-catalog-version-container__left__template\" *ngFor=\"let item of leftItems; let isLast = last\"><se-catalog-version-item-renderer [item]=\"item\" [siteId]=\"siteId\" [catalog]=\"catalog\" [catalogVersion]=\"catalogVersion\" [activeCatalogVersion]=\"activeCatalogVersion\"></se-catalog-version-item-renderer><div class=\"se-catalog-version-container__divider\" *ngIf=\"!isLast\"></div></div></div></div></div><div class=\"se-catalog-version-container__right\"><div class=\"se-catalog-version-container__right__template\" *ngFor=\"let item of rightItems\"><se-catalog-version-item-renderer [item]=\"item\" [siteId]=\"siteId\" [catalog]=\"catalog\" [catalogVersion]=\"catalogVersion\" [activeCatalogVersion]=\"activeCatalogVersion\"></se-catalog-version-item-renderer></div></div></div>"
    );
     
    $templateCache.put(
        "CatalogVersionsThumbnailCarouselComponent.html", 
        "<div class=\"se-active-catalog-thumbnail\"><div class=\"se-active-catalog-version-container__thumbnail\" (click)=\"onClick()\"><div class=\"se-active-catalog-version-container__thumbnail__default-img\"><div class=\"se-active-catalog-version-container__thumbnail__img\" [ngStyle]=\"{'background-image': 'url(' + catalogVersion.thumbnailUrl + ')'}\"></div></div></div></div>"
    );
     
    $templateCache.put(
        "HomePageLinkComponent.html", 
        "<div class=\"home-link-container\"><a href=\"javascript:void(0)\" class=\"home-link-item__link se-catalog-version__link\" (click)=\"onClick()\">{{ 'se.landingpage.homepage' | translate }}</a></div>"
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

var ApplicationLayer;
(function (ApplicationLayer) {
    ApplicationLayer[ApplicationLayer["SMARTEDITCONTAINER"] = 0] = "SMARTEDITCONTAINER";
    ApplicationLayer[ApplicationLayer["SMARTEDIT"] = 1] = "SMARTEDIT";
})(ApplicationLayer || (ApplicationLayer = {}));
/** @internal */
/* @ngInject */ exports.ConfigurationExtractorService = class /* @ngInject */ ConfigurationExtractorService {
    constructor(logService) {
        this.logService = logService;
    }
    extractSEContainerModules(configurations) {
        return this._getAppsAndLocations(configurations, ApplicationLayer.SMARTEDITCONTAINER);
    }
    extractSEModules(configurations) {
        return this._getAppsAndLocations(configurations, ApplicationLayer.SMARTEDIT);
    }
    orderApplications(applications) {
        const simpleApps = applications.filter((item) => !item.extends);
        const extendingApps = applications
            .filter((item) => !!item.extends)
            /*
             * filer out extendingApps thata do extend an unknown app
             * other recursive _addExtendingAppsInOrder will never end
             */
            .filter((extendingApp) => {
            const index = applications.findIndex((item) => item.name === extendingApp.extends);
            if (index === -1) {
                this.logService.error(`Application ${extendingApp.name} located at ${extendingApp.location} is ignored because it extends an unknown application '${extendingApp.extends}'; SmartEdit functionality may be compromised.`);
            }
            return index > -1;
        });
        return this._addExtendingAppsInOrder(simpleApps, extendingApps);
    }
    _addExtendingAppsInOrder(simpleApps, extendingApps, pass) {
        pass = pass || 1;
        const remainingApps = [];
        extendingApps.forEach((extendingApp) => {
            const index = simpleApps.findIndex((item) => item.name === extendingApp.extends);
            if (index > -1) {
                this.logService.debug(`pass ${pass}, ${extendingApp.name} requiring ${extendingApp.extends} found it at index ${index} (${simpleApps.map((app) => app.name)})`);
                simpleApps.splice(index + 1, 0, extendingApp);
            }
            else {
                this.logService.debug(`pass ${pass}, ${extendingApp.name} requiring ${extendingApp.extends} did not find it  (${simpleApps.map((app) => app.name)})`);
                remainingApps.push(extendingApp);
            }
        });
        if (remainingApps.length) {
            return this._addExtendingAppsInOrder(simpleApps, remainingApps, ++pass);
        }
        else {
            return simpleApps;
        }
    }
    _getAppsAndLocations(configurations, applicationLayer) {
        let locationName;
        switch (applicationLayer) {
            case ApplicationLayer.SMARTEDITCONTAINER:
                locationName = 'smartEditContainerLocation';
                break;
            case ApplicationLayer.SMARTEDIT:
                locationName = 'smartEditLocation';
                break;
        }
        const appsAndLocations = lo.map(configurations, (value, prop) => ({ key: prop, value }))
            .reduce((holder, current) => {
            if (current.key.indexOf('applications') === 0 &&
                typeof current.value[locationName] === 'string') {
                const app = {};
                app.name = current.key.split('.')[1];
                const location = current.value[locationName];
                if (/^https?\:\/\//.test(location)) {
                    app.location = location;
                }
                else {
                    app.location = configurations.domain + location;
                }
                const _extends = current.value.extends;
                if (_extends) {
                    app.extends = _extends;
                }
                holder.applications.push(app);
                // authenticationMaps from smartedit modules
                holder.authenticationMap = lo.merge(holder.authenticationMap, current.value.authenticationMap);
            }
            else if (current.key === 'authenticationMap') {
                // authenticationMap from smartedit
                holder.authenticationMap = lo.merge(holder.authenticationMap, current.value);
            }
            return holder;
        }, {
            applications: [],
            authenticationMap: {}
        });
        return appsAndLocations;
    }
};
exports.ConfigurationExtractorService.$inject = ["logService"];
/* @ngInject */ exports.ConfigurationExtractorService = __decorate([
    smarteditcommons.SeDowngradeService(),
    __metadata("design:paramtypes", [smarteditcommons.LogService])
], /* @ngInject */ exports.ConfigurationExtractorService);

/* @ngInject */ exports.BootstrapService = class /* @ngInject */ BootstrapService {
    constructor(configurationExtractorService, sharedDataService, logService, httpClient, promiseUtils, smarteditBootstrapGateway, moduleUtils, SMARTEDIT_INNER_FILES, SMARTEDIT_INNER_FILES_POST) {
        this.configurationExtractorService = configurationExtractorService;
        this.sharedDataService = sharedDataService;
        this.logService = logService;
        this.httpClient = httpClient;
        this.promiseUtils = promiseUtils;
        this.smarteditBootstrapGateway = smarteditBootstrapGateway;
        this.moduleUtils = moduleUtils;
        this.SMARTEDIT_INNER_FILES = SMARTEDIT_INNER_FILES;
        this.SMARTEDIT_INNER_FILES_POST = SMARTEDIT_INNER_FILES_POST;
    }
    bootstrapContainerModules(configurations) {
        const deferred = this.promiseUtils.defer();
        const seContainerModules = this.configurationExtractorService.extractSEContainerModules(configurations);
        const orderedApplications = this.configurationExtractorService.orderApplications(seContainerModules.applications);
        this.logService.debug('outerAppLocations are:', orderedApplications);
        this.sharedDataService.set('authenticationMap', seContainerModules.authenticationMap);
        this.sharedDataService.set('credentialsMap', configurations['authentication.credentials']);
        const constants = this._getConstants(configurations);
        Object.keys(constants).forEach((key) => {
            this._getLegacyContainerModule().constant(key, constants[key]);
        });
        this._getValidApplications(orderedApplications).then((validApplications) => {
            smarteditcommons.scriptUtils.injectJS().execute({
                srcs: validApplications.map((app) => app.location),
                callback: () => {
                    const modules = [...window.__smartedit__.pushedModules];
                    // The original validApplications contains the list of modules that must be loaded dynamically as determined by
                    // the SmartEdit Configuration service; this is the legacy way of loading extensions.
                    // However, now extensions can also be loaded at compilation time. The code of those extensions is not required to be
                    // loaded dynamically, but it's still necessary to load their Angular top-level module. Those modules are defined in
                    // the smartEditContainerAngularApps global variable.
                    window.__smartedit__.smartEditContainerAngularApps.forEach((appName) => {
                        validApplications.push({
                            name: appName,
                            location: ''
                        });
                    });
                    validApplications.forEach((app) => {
                        this.moduleUtils.addModuleToAngularJSApp('smarteditcontainer', app.name);
                        const esModule = this.moduleUtils.getNgModule(app.name);
                        if (esModule) {
                            modules.push(esModule);
                        }
                    });
                    deferred.resolve({
                        modules,
                        constants
                    });
                }
            });
        });
        return deferred.promise;
    }
    /**
     * Retrieve SmartEdit inner application configuration and dispatch 'bundle' event with list of resources.
     * @param configurations
     */
    bootstrapSEApp(configurations) {
        const seModules = this.configurationExtractorService.extractSEModules(configurations);
        const orderedApplications = this.configurationExtractorService.orderApplications(seModules.applications);
        this.sharedDataService.set('authenticationMap', seModules.authenticationMap);
        this.sharedDataService.set('credentialsMap', configurations['authentication.credentials']);
        const resources = {
            properties: this._getConstants(configurations),
            js: [
                {
                    src: configurations.smarteditroot +
                        '/static-resources/userTracking/trackingUserActions.js'
                },
                {
                    src: configurations.smarteditroot +
                        '/static-resources/thirdparties/piwik/piwik.js'
                },
                {
                    src: configurations.smarteditroot +
                        '/static-resources/thirdparties/blockumd/blockumd.js'
                },
                {
                    src: configurations.smarteditroot +
                        '/static-resources/dist/smartedit-new/vendors.js'
                },
                {
                    src: configurations.smarteditroot +
                        '/static-resources/thirdparties/ckeditor/ckeditor.js'
                },
                {
                    src: configurations.smarteditroot +
                        '/static-resources/dist/smartedit-new/smartedit.js'
                }
            ]
        };
        return this._getValidApplications(orderedApplications).then((validApplications) => {
            // The original validApplications contains the list of modules that must be loaded dynamically as determined by
            // the SmartEdit Configuration service; this is the legacy way of loading extensions.
            // However, now extensions can also be loaded at compilation time. The code of those extensions is not required to be
            // loaded dynamically, but it's still necessary to load their Angular top-level module. Those modules are defined in
            // the smartEditInnerAngularApps global variable.
            window.__smartedit__.smartEditInnerAngularApps.forEach((appName) => {
                validApplications.push({
                    name: appName,
                    location: ''
                });
            });
            if (E2E_ENVIRONMENT && this.SMARTEDIT_INNER_FILES) {
                // Note: This is only enabled on e2e tests. In production, this is removed by webpack.
                resources.js = this.SMARTEDIT_INNER_FILES.map((filePath) => ({
                    src: configurations.domain + filePath
                }));
            }
            resources.js = resources.js.concat(validApplications.map((app) => {
                const source = { src: app.location };
                return source;
            }));
            if (E2E_ENVIRONMENT && this.SMARTEDIT_INNER_FILES_POST) {
                // Note: This is only enabled on e2e tests. In production, this is removed by webpack.
                resources.js = resources.js.concat(this.SMARTEDIT_INNER_FILES_POST.map((filePath) => ({
                    src: configurations.domain + filePath
                })));
            }
            resources.properties.applications = validApplications.map((app) => app.name);
            this.smarteditBootstrapGateway
                .getInstance()
                .publish('bundle', { resources });
        });
    }
    _getLegacyContainerModule() {
        /* forbiddenNameSpaces angular.module:false */
        return angular.module('smarteditcontainer');
    }
    _getConstants(configurations) {
        return {
            domain: configurations.domain,
            smarteditroot: configurations.smarteditroot
        };
    }
    /**
     * Applications are considered valid if they can be retrieved over the wire
     */
    _getValidApplications(applications) {
        return Promise.all(applications.map((application) => {
            const deferred = this.promiseUtils.defer();
            this.httpClient.get(application.location, { responseType: 'text' }).subscribe(() => {
                deferred.resolve(application);
            }, (e) => {
                this.logService.error(`Failed to load application '${application.name}' from location ${application.location}; SmartEdit functionality may be compromised.`);
                deferred.resolve();
            });
            return deferred.promise;
        })).then((validApplications) => lo.merge(lo.compact(validApplications)));
    }
};
exports.BootstrapService.$inject = ["configurationExtractorService", "sharedDataService", "logService", "httpClient", "promiseUtils", "smarteditBootstrapGateway", "moduleUtils", "SMARTEDIT_INNER_FILES", "SMARTEDIT_INNER_FILES_POST"];
/* @ngInject */ exports.BootstrapService = __decorate([
    smarteditcommons.SeDowngradeService(),
    __param(7, core.Inject('SMARTEDIT_INNER_FILES')),
    __param(8, core.Inject('SMARTEDIT_INNER_FILES_POST')),
    __metadata("design:paramtypes", [exports.ConfigurationExtractorService,
        smarteditcommons.ISharedDataService,
        smarteditcommons.LogService,
        http.HttpClient,
        smarteditcommons.PromiseUtils,
        smarteditcommons.SmarteditBootstrapGateway,
        smarteditcommons.ModuleUtils, Array, Array])
], /* @ngInject */ exports.BootstrapService);

/**
 * LoadConfigManagerService is used to retrieve configurations stored in configuration API.
 */
/* @ngInject */ exports.LoadConfigManagerService = class /* @ngInject */ LoadConfigManagerService {
    constructor(restServicefactory, sharedDataService, logService, promiseUtils, SMARTEDIT_RESOURCE_URI_REGEXP, SMARTEDIT_ROOT) {
        this.sharedDataService = sharedDataService;
        this.logService = logService;
        this.promiseUtils = promiseUtils;
        this.SMARTEDIT_RESOURCE_URI_REGEXP = SMARTEDIT_RESOURCE_URI_REGEXP;
        this.SMARTEDIT_ROOT = SMARTEDIT_ROOT;
        this.restService = restServicefactory.get(smarteditcommons.CONFIGURATION_URI);
    }
    /**
     * Retrieves configuration from an API and returns as an array of mapped key/value pairs.
     *
     * ### Example:
     *
     *      loadConfigManagerService.loadAsArray().then(
     *          (response: ConfigurationItem[]) => {
     *              this._prettify(response);
     *          }));
     *
     *
     *
     * @returns  a promise of configuration values as an array of mapped configuration key/value pairs
     */
    loadAsArray() {
        const deferred = this.promiseUtils.defer();
        this.restService.query().then((response) => {
            deferred.resolve(this._parse(response));
        }, (error) => {
            this.logService.log('Fail to load the configurations.', error);
            deferred.reject();
        });
        return deferred.promise;
    }
    /**
     * Retrieves a configuration from the API and converts it to an object.
     *
     * ### Example:
     *
     *
     *      loadConfigManagerService.loadAsObject().then((conf: ConfigurationObject) => {
     *          sharedDataService.set('defaultToolingLanguage', conf.defaultToolingLanguage);
     *      });
     *
     * @returns a promise of configuration values as an object of mapped configuration key/value pairs
     */
    loadAsObject() {
        const deferred = this.promiseUtils.defer();
        this.loadAsArray().then((response) => {
            try {
                const conf = this._convertToObject(response);
                this.sharedDataService.set('configuration', conf);
                deferred.resolve(conf);
            }
            catch (e) {
                this.logService.error('LoadConfigManager.loadAsObject - _convertToObject failed to load configuration:', response);
                this.logService.error(e);
                deferred.reject();
            }
        });
        return deferred.promise;
    }
    _convertToObject(configuration) {
        const configurations = configuration.reduce((previous, current) => {
            try {
                if (typeof previous[current.key] !== 'undefined') {
                    this.logService.error('LoadConfigManager._convertToObject() - duplicate configuration keys found: ' +
                        current.key);
                }
                previous[current.key] = JSON.parse(current.value);
            }
            catch (parseError) {
                this.logService.error('item _key_ from configuration contains unparsable JSON data _value_ and was ignored'
                    .replace('_key_', current.key)
                    .replace('_value_', current.value));
            }
            return previous;
        }, {});
        try {
            configurations.domain = this.SMARTEDIT_RESOURCE_URI_REGEXP.exec(this._getLocation())[1];
        }
        catch (e) {
            throw new Error(`location ${this._getLocation()} doesn't match the expected pattern ${this.SMARTEDIT_RESOURCE_URI_REGEXP}`);
        }
        configurations.smarteditroot = configurations.domain + '/' + this.SMARTEDIT_ROOT;
        return configurations;
    }
    _getLocation() {
        return document.location.href;
    }
    // FIXME: weird on an array and useless
    _parse(configuration) {
        const conf = lo.cloneDeep(configuration);
        Object.keys(conf).forEach((key) => {
            try {
                conf[key] = JSON.parse(conf[key]);
            }
            catch (e) {
                //
            }
        });
        return conf;
    }
};
exports.LoadConfigManagerService.$inject = ["restServicefactory", "sharedDataService", "logService", "promiseUtils", "SMARTEDIT_RESOURCE_URI_REGEXP", "SMARTEDIT_ROOT"];
/* @ngInject */ exports.LoadConfigManagerService = __decorate([
    smarteditcommons.SeDowngradeService(),
    smarteditcommons.OperationContextRegistered(smarteditcommons.CONFIGURATION_URI, 'TOOLING'),
    __param(4, core.Inject('SMARTEDIT_RESOURCE_URI_REGEXP')),
    __param(5, core.Inject('SMARTEDIT_ROOT')),
    __metadata("design:paramtypes", [smarteditcommons.RestServiceFactory,
        smarteditcommons.ISharedDataService,
        smarteditcommons.LogService,
        smarteditcommons.PromiseUtils,
        RegExp, String])
], /* @ngInject */ exports.LoadConfigManagerService);

const ANNOUNCEMENT_DEFAULTS = {
    timeout: 5000,
    closeable: true
};
let /* @ngInject */ AnnouncementService = class /* @ngInject */ AnnouncementService extends smarteditcommons.IAnnouncementService {
    constructor(logService) {
        super();
        this.logService = logService;
        this.announcements$ = new rxjs.BehaviorSubject([]);
    }
    showAnnouncement(announcementConfig) {
        this.validateAnnouncementConfig(announcementConfig);
        const announcement = lo.clone(announcementConfig);
        announcement.id = smarteditcommons.stringUtils.encode(announcementConfig);
        announcement.timeout =
            !!announcement.timeout && announcement.timeout > 0
                ? announcement.timeout
                : ANNOUNCEMENT_DEFAULTS.timeout;
        if (announcement.timeout > 0) {
            announcement.timer = setTimeout(() => {
                this._closeAnnouncement(announcement);
            }, announcement.timeout);
        }
        this.announcements$.next([...this.announcements$.getValue(), announcement]);
        return Promise.resolve(announcement.id);
    }
    getAnnouncements() {
        return this.announcements$.asObservable();
    }
    closeAnnouncement(announcementId) {
        const announcement = this.announcements$
            .getValue()
            .find((announcementObj) => announcementObj.id === announcementId);
        if (announcement) {
            this._closeAnnouncement(announcement);
        }
        return Promise.resolve();
    }
    _closeAnnouncement(announcement) {
        if (announcement.timer) {
            clearTimeout(announcement.timer);
        }
        const announcements = this.announcements$.getValue();
        const newAnnouncements = announcements.filter((announcementObj) => announcementObj.id !== announcement.id);
        this.announcements$.next(newAnnouncements);
    }
    validateAnnouncementConfig(announcementConfig) {
        const { message, component } = announcementConfig;
        if (!message && !component) {
            this.logService.warn('AnnouncementService.validateAnnouncementConfig - announcement must contain at least a message or component property', announcementConfig);
        }
        if (message && component) {
            throw new Error('AnnouncementService.validateAnnouncementConfig - either message or component must be provided');
        }
    }
};
AnnouncementService.$inject = ["logService"];
/* @ngInject */ AnnouncementService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IAnnouncementService),
    smarteditcommons.GatewayProxied('showAnnouncement', 'closeAnnouncement'),
    core.Injectable(),
    __metadata("design:paramtypes", [smarteditcommons.LogService])
], /* @ngInject */ AnnouncementService);

/**
 * The notification service is used to display visual cues to inform the user of the state of the application.
 */
/** @internal */
let /* @ngInject */ NotificationService = class /* @ngInject */ NotificationService {
    constructor(systemEventService, logService) {
        this.systemEventService = systemEventService;
        this.logService = logService;
        this.notificationsChangeAction = new rxjs.BehaviorSubject(undefined);
        this.notifications = new rxjs.BehaviorSubject([]);
        this.initNotificationsChangeAction();
    }
    ngOnDestroy() {
        this.notifications.unsubscribe();
        this.notificationsChangeAction.unsubscribe();
    }
    pushNotification(configuration) {
        const action = {
            type: "PUSH" /* PUSH */,
            payload: configuration
        };
        this.notificationsChangeAction.next(action);
        return Promise.resolve();
    }
    removeNotification(notificationId) {
        const action = {
            type: "REMOVE" /* REMOVE */,
            payload: {
                id: notificationId
            }
        };
        this.notificationsChangeAction.next(action);
        return Promise.resolve();
    }
    removeAllNotifications() {
        const action = {
            type: "REMOVE_ALL" /* REMOVE_ALL */
        };
        this.notificationsChangeAction.next(action);
        return Promise.resolve();
    }
    isNotificationDisplayed(notificationId) {
        return !!this.getNotification(notificationId);
    }
    getNotification(notificationId) {
        return this.notifications
            .getValue()
            .find((notification) => notification.id === notificationId);
    }
    getNotifications() {
        return this.notifications.asObservable();
    }
    initNotificationsChangeAction() {
        this.notificationsChangeAction
            .pipe(operators.distinctUntilChanged((_, action) => this.emitWhenActionIsAvailable(action)), 
        // Skip first emission with "undefined" value.
        // First "undefined" is needed for invoking distinctUntilChanged (which requires at least 2 values emited) when first notification is added.
        operators.skip(1), operators.map((action) => this.resolveNotifications(action)))
            .subscribe((notifications) => {
            this.notifications.next(notifications);
            this.systemEventService.publishAsync(smarteditcommons.EVENT_NOTIFICATION_CHANGED);
        });
    }
    /**
     * Meant for case when a user has quickly pressed ESC key multiple times.
     * There might be some delay when adding / removing a notification because these methods are called in async context.
     * This may lead to the situation where notification has not yet been removed, but ESC key has called the pushNotification.
     *
     * @returns false (emit), true (do not emit)
     */
    emitWhenActionIsAvailable(action) {
        const { payload: newNotification } = action;
        const notification = (action.type === "PUSH" /* PUSH */ ||
            action.type === "REMOVE" /* REMOVE */) &&
            this.getNotification(newNotification.id);
        switch (action.type) {
            case "PUSH" /* PUSH */:
                if (notification) {
                    this.logService.debug(`Notification already exists for id:"${newNotification.id}"`);
                    return true;
                }
                return false;
            case "REMOVE" /* REMOVE */:
                if (!notification) {
                    this.logService.debug(`Attempt to remove a non existing notification for id:"${newNotification.id}"`);
                    return true;
                }
                return false;
            case "REMOVE_ALL" /* REMOVE_ALL */:
                return false;
        }
    }
    resolveNotifications(action) {
        const { payload: newNotification } = action;
        switch (action.type) {
            case "PUSH" /* PUSH */:
                return [...this.notifications.getValue(), newNotification];
            case "REMOVE" /* REMOVE */:
                return this.notifications
                    .getValue()
                    .filter((notification) => notification.id !== newNotification.id);
            case "REMOVE_ALL" /* REMOVE_ALL */:
                return [];
        }
    }
};
NotificationService.$inject = ["systemEventService", "logService"];
/* @ngInject */ NotificationService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.INotificationService),
    smarteditcommons.GatewayProxied('pushNotification', 'removeNotification', 'removeAllNotifications'),
    __metadata("design:paramtypes", [smarteditcommons.SystemEventService, smarteditcommons.LogService])
], /* @ngInject */ NotificationService);

/**
 * This service makes it possible to track the mouse position to detect when it leaves the notification panel.
 * It is solely meant to be used with the notificationService.
 */
/** @internal */
let /* @ngInject */ NotificationMouseLeaveDetectionService = class /* @ngInject */ NotificationMouseLeaveDetectionService extends smarteditcommons.INotificationMouseLeaveDetectionService {
    constructor(document, windowUtils) {
        super();
        this.document = document;
        this.windowUtils = windowUtils;
        this.notificationPanelBounds = null;
        this.mouseLeaveCallback = null;
        /*
         * We need to bind the function in order for it to execute within the service's
         * scope and store it to be able to un-register the listener.
         */
        this._onMouseMove = this._onMouseMove.bind(this);
    }
    startDetection(outerBounds, innerBounds, callback) {
        this.validateBounds(outerBounds);
        if (!callback) {
            throw new Error('Callback function is required');
        }
        this.notificationPanelBounds = outerBounds;
        this.mouseLeaveCallback = callback;
        this.document.addEventListener('mousemove', this._onMouseMove);
        if (innerBounds) {
            this.validateBounds(innerBounds);
            this._remoteStartDetection(innerBounds);
        }
        return Promise.resolve();
    }
    stopDetection() {
        this.document.removeEventListener('mousemove', this._onMouseMove);
        this.notificationPanelBounds = null;
        this.mouseLeaveCallback = null;
        if (this.windowUtils.getGatewayTargetFrame()) {
            this._remoteStopDetection();
        }
        return Promise.resolve();
    }
    _callCallback() {
        this._getCallback().then((callback) => {
            if (callback) {
                callback();
            }
        });
        return Promise.resolve();
    }
    _getBounds() {
        return Promise.resolve(this.notificationPanelBounds);
    }
    _getCallback() {
        return Promise.resolve(this.mouseLeaveCallback);
    }
    validateBounds(bounds) {
        if (!bounds) {
            throw new Error('Bounds are required for mouse leave detection');
        }
        if (!bounds.hasOwnProperty('x')) {
            throw new Error('Bounds must contain the x coordinate');
        }
        if (!bounds.hasOwnProperty('y')) {
            throw new Error('Bounds must contain the y coordinate');
        }
        if (!bounds.hasOwnProperty('width')) {
            throw new Error('Bounds must contain the width dimension');
        }
        if (!bounds.hasOwnProperty('height')) {
            throw new Error('Bounds must contain the height dimension');
        }
    }
};
NotificationMouseLeaveDetectionService.$inject = ["document", "windowUtils"];
/* @ngInject */ NotificationMouseLeaveDetectionService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.INotificationMouseLeaveDetectionService),
    smarteditcommons.GatewayProxied('stopDetection', '_remoteStartDetection', '_remoteStopDetection', '_callCallback'),
    core.Injectable(),
    __param(0, core.Inject(common.DOCUMENT)),
    __metadata("design:paramtypes", [Document, smarteditcommons.WindowUtils])
], /* @ngInject */ NotificationMouseLeaveDetectionService);

/*
 * internal service to proxy calls from inner RESTService to the outer restServiceFactory and the 'real' IRestService
 */
/** @internal */
/* @ngInject */ exports.DelegateRestService = class /* @ngInject */ DelegateRestService {
    constructor(restServiceFactory) {
        this.restServiceFactory = restServiceFactory;
    }
    delegateForSingleInstance(methodName, params, uri, identifier, metadataActivated, options) {
        const restService = this.restServiceFactory.get(uri, identifier);
        if (metadataActivated) {
            restService.activateMetadata();
        }
        return restService.getMethodForSingleInstance(methodName)(params, options);
    }
    delegateForArray(methodName, params, uri, identifier, metadataActivated, options) {
        const restService = this.restServiceFactory.get(uri, identifier);
        if (metadataActivated) {
            restService.activateMetadata();
        }
        return restService.getMethodForArray(methodName)(params, options);
    }
    delegateForPage(pageable, uri, identifier, metadataActivated, options) {
        const restService = this.restServiceFactory.get(uri, identifier);
        if (metadataActivated) {
            restService.activateMetadata();
        }
        return restService.page(pageable, options);
    }
    delegateForQueryByPost(payload, params, uri, identifier, metadataActivated, options) {
        const restService = this.restServiceFactory.get(uri, identifier);
        if (metadataActivated) {
            restService.activateMetadata();
        }
        return restService.queryByPost(payload, params, options);
    }
};
exports.DelegateRestService.$inject = ["restServiceFactory"];
/* @ngInject */ exports.DelegateRestService = __decorate([
    smarteditcommons.SeDowngradeService(),
    smarteditcommons.GatewayProxied(),
    __metadata("design:paramtypes", [smarteditcommons.IRestServiceFactory])
], /* @ngInject */ exports.DelegateRestService);

/** @internal */
const DEVICE_ORIENTATIONS = [
    {
        orientation: 'vertical',
        key: 'se.deviceorientation.vertical.label',
        default: true
    },
    {
        orientation: 'horizontal',
        key: 'se.deviceorientation.horizontal.label'
    }
];

/** @internal */
const DEVICE_SUPPORTS = [
    {
        iconClass: 'sap-icon--iphone',
        type: 'phone',
        width: 480
    },
    {
        iconClass: 'sap-icon--iphone-2',
        type: 'wide-phone',
        width: 600
    },
    {
        iconClass: 'sap-icon--ipad',
        type: 'tablet',
        width: 700
    },
    {
        iconClass: 'sap-icon--ipad-2',
        type: 'wide-tablet',
        width: 1024
    },
    {
        iconClass: 'sap-icon--sys-monitor',
        type: 'desktop',
        width: 1200
    },
    {
        iconClass: 'hyicon hyicon-wide-screen',
        type: 'wide-desktop',
        width: '100%',
        default: true
    }
];

var /* @ngInject */ IframeManagerService_1;
/**
 * The iFrame Manager service provides methods to load the storefront into an iframe. The preview of the storefront can be loaded for a specified input homepage and a specified preview ticket. The iframe src attribute is updated with that information in order to display the storefront in SmartEdit.
 */
let /* @ngInject */ IframeManagerService = /* @ngInject */ IframeManagerService_1 = class /* @ngInject */ IframeManagerService {
    constructor(logService, httpClient, yjQuery, windowUtils, sharedDataService) {
        this.logService = logService;
        this.httpClient = httpClient;
        this.yjQuery = yjQuery;
        this.windowUtils = windowUtils;
        this.sharedDataService = sharedDataService;
    }
    /**
     * This method sets the current page location and stores it in the service. The storefront will be loaded with this location.
     *
     * @param URL Location to be stored
     */
    setCurrentLocation(location) {
        this.currentLocation = location;
    }
    getIframe() {
        return this.yjQuery(this.windowUtils.getSmarteditIframe());
    }
    isCrossOrigin() {
        return this.windowUtils.isCrossOrigin(this.currentLocation);
    }
    /**
     * This method loads the storefront within an iframe by setting the src attribute to the specified input URL.
     * If this method is called within the context of a new or updated experience, prior to the loading, it will check if the page exists.
     * If the pages does not exist (the server returns a 404 and a content-type:text/html), the user will be redirected to the homepage of the storefront. Otherwise,
     * the user will be redirected to the requested page for the experience.
     *
     * @param URL The URL of the storefront.
     * @param checkIfFailingHTML Boolean indicating if we need to check if the page call returns a 404
     * @param homepageInPreviewMode URL of the storefront homepage in preview mode if it's a new experience
     *
     */
    load(url, checkIfFailingHTML, pageInPreviewMode) {
        if (checkIfFailingHTML) {
            return this._getPageAsync(url).then(() => {
                this.getIframe().attr('src', url);
            }, (error) => {
                if (error.status === 404) {
                    this.getIframe().attr('src', pageInPreviewMode);
                    return;
                }
                this.logService.error(`IFrameManagerService.load - _getPageAsync failed with error ${error}`);
            });
        }
        else {
            this.logService.debug('iframeManagerService::load - loading storefront url:', url);
            this.getIframe().attr('src', url);
            return Promise.resolve();
        }
    }
    /**
     * This method loads the preview of the storefront for a specified input homepage URL or a page from the page list, and for a specified preview ticket.
     * This method will add '/cx-preview' as specified in configuration.storefrontPreviewRoute to the URI and append the preview ticket in the query string.
     * <br/>If it is an initial load, [load]{@link IframeManagerService#load} will be called with this modified homepage or page from page list.
     * <br/>If it is a subsequent call, the modified homepage will be called through Ajax to initialize the preview (storefront constraint) and then
     * [load]{@link IframeManagerService#load} will be called with the current location.
     *
     * @param homePageOrPageFromPageList The URL of the storefront homepage or a page from the page list for a given experience context.
     * @param  previewTicket The preview ticket.
     */
    loadPreview(homePageOrPageFromPageList, previewTicket) {
        this.windowUtils.setTrustedIframeDomain(homePageOrPageFromPageList);
        this.logService.debug('loading storefront iframe with preview ticket:', previewTicket);
        let promiseToResolve;
        if (!/.+\.html/.test(homePageOrPageFromPageList)) {
            // for testing purposes
            promiseToResolve = this._appendURISuffix(homePageOrPageFromPageList);
        }
        else {
            promiseToResolve = Promise.resolve(homePageOrPageFromPageList);
        }
        return promiseToResolve.then((previewURL) => {
            const pageInPreviewMode = previewURL +
                (previewURL.indexOf('?') === -1 ? '?' : '&') +
                'cmsTicketId=' +
                previewTicket;
            // If we don't have a current location, or the current location is the homePage or a page from page list, or the current location has a cmsTicketID
            if (this._mustLoadAsSuch(homePageOrPageFromPageList)) {
                return this.load(pageInPreviewMode);
            }
            else {
                const isCrossOrigin = this.isCrossOrigin();
                /*
                 * check failing HTML only if same origin to prevent CORS errors.
                 * if location to reload in new experience context is different from homepage, one will have to
                 * first load the home page in preview mode and then access the location without preview mode
                 */
                return (isCrossOrigin
                    ? Promise.resolve({})
                    : this._getPageAsync(pageInPreviewMode)).then(() => 
                // FIXME: use gatewayProxy to load url from the inner
                this.load(this.currentLocation, !isCrossOrigin, pageInPreviewMode), (error) => this.logService.error('failed to load preview', error));
            }
        });
    }
    apply(deviceSupport, deviceOrientation) {
        let width;
        let height;
        let isVertical = true;
        if (deviceOrientation && deviceOrientation.orientation) {
            isVertical = deviceOrientation.orientation === 'vertical';
        }
        if (deviceSupport) {
            width = isVertical ? deviceSupport.width : deviceSupport.height;
            height = isVertical ? deviceSupport.height : deviceSupport.width;
            // hardcoded the name to default to remove the device skin
            this.getIframe()
                .removeClass()
                .addClass('device-' + (isVertical ? 'vertical' : 'horizontal') + ' device-default');
        }
        else {
            this.getIframe().removeClass();
        }
        this.getIframe().css({
            width: width || '100%',
            height: height || '100%',
            display: 'block',
            margin: 'auto'
        });
    }
    applyDefault() {
        const defaultDeviceSupport = DEVICE_SUPPORTS.find((deviceSupport) => deviceSupport.default);
        const defaultDeviceOrientation = DEVICE_ORIENTATIONS.find((deviceOrientation) => deviceOrientation.default);
        this.apply(defaultDeviceSupport, defaultDeviceOrientation);
    }
    /*
     * if currentLocation is not set yet, it means that this is a first loading and we are trying to load the homepage,
     * or if the page has a ticket ID but is not the homepage, it means that we try to load a page from the page list.
     * For those scenarios, we want to load the page as such in preview mode.
     */
    _mustLoadAsSuch(homePageOrPageFromPageList) {
        return (!this.currentLocation ||
            smarteditcommons.urlUtils.getURI(homePageOrPageFromPageList) === smarteditcommons.urlUtils.getURI(this.currentLocation) ||
            'cmsTicketId' in smarteditcommons.urlUtils.parseQuery(this.currentLocation));
    }
    _getPageAsync(url) {
        return this.httpClient.get(url, { observe: 'body', responseType: 'text' }).toPromise();
    }
    _appendURISuffix(url) {
        const pair = url.split('?');
        return this.sharedDataService
            .get('configuration')
            .then((configuration) => {
            if (!configuration || !configuration.storefrontPreviewRoute) {
                this.logService.debug("SmartEdit configuration for 'storefrontPreviewRoute' is not found. Fallback to default value: '" +
                    /* @ngInject */ IframeManagerService_1.DEFAULT_PREVIEW_ROUTE +
                    "'");
                return /* @ngInject */ IframeManagerService_1.DEFAULT_PREVIEW_ROUTE;
            }
            return configuration.storefrontPreviewRoute;
        })
            .then((previewRoute) => pair[0]
            .replace(/(.+)([^\/])$/g, '$1$2/' + previewRoute)
            .replace(/(.+)\/$/g, '$1/' + previewRoute) +
            (pair.length === 2 ? '?' + pair[1] : ''));
    }
};
/* @ngInject */ IframeManagerService.DEFAULT_PREVIEW_ROUTE = 'cx-preview';
/* @ngInject */ IframeManagerService = /* @ngInject */ IframeManagerService_1 = __decorate([
    smarteditcommons.SeDowngradeService(),
    __param(2, core.Inject(smarteditcommons.YJQUERY_TOKEN)),
    __metadata("design:paramtypes", [smarteditcommons.LogService,
        http.HttpClient, Function, smarteditcommons.WindowUtils,
        smarteditcommons.ISharedDataService])
], /* @ngInject */ IframeManagerService);

/**
 * Polyfill for HTML5 Drag and Drop in a cross-origin setup.
 * Most browsers (except Firefox) do not allow on-page drag-and-drop from non-same-origin frames.
 * This service is a polyfill to allow it, by listening the 'dragover' event over a sibling <div> of the iframe and sending the mouse position to the inner frame.
 * The inner frame 'DragAndDropCrossOriginInner' will use document.elementFromPoint (or isPointOverElement helper function for IE only) to determine the current hovered element and then dispatch drag events onto elligible droppable elements.
 *
 * More information about security restrictions:
 * https://bugs.chromium.org/p/chromium/issues/detail?id=251718
 * https://bugs.chromium.org/p/chromium/issues/detail?id=59081
 * https://www.infosecurity-magazine.com/news/new-google-chrome-clickjacking-vulnerability/
 * https://bugzilla.mozilla.org/show_bug.cgi?id=605991
 */
/** @internal */
let /* @ngInject */ DragAndDropCrossOrigin = class /* @ngInject */ DragAndDropCrossOrigin extends smarteditcommons.IDragAndDropCrossOrigin {
    constructor(yjQuery, crossFrameEventService, iframeManagerService) {
        super();
        this.yjQuery = yjQuery;
        this.crossFrameEventService = crossFrameEventService;
        this.iframeManagerService = iframeManagerService;
        this.onDragStart = () => {
            if (!this.isEnabled()) {
                return;
            }
            this.crossFrameEventService.publish(smarteditcommons.SMARTEDIT_DRAG_AND_DROP_EVENTS.DRAG_DROP_CROSS_ORIGIN_START);
            this.syncIframeDragArea()
                .show()
                .off('dragover') // `off()` is necessary since dragEnd event is not always fired.
                .on('dragover', (e) => {
                e.preventDefault(); // `preventDefault()` is necessary for the 'drop' event callback to be fired.
                const mousePosition = this.getPositionRelativeToIframe(e.pageX, e.pageY);
                this.throttledSendMousePosition(mousePosition);
                return false;
            })
                .off('drop')
                .on('drop', (e) => {
                e.preventDefault();
                e.stopPropagation();
                const mousePosition = this.getPositionRelativeToIframe(e.pageX, e.pageY);
                this.crossFrameEventService.publish(smarteditcommons.SMARTEDIT_DRAG_AND_DROP_EVENTS.DROP_ELEMENT, mousePosition);
                return false;
            });
        };
        this.onDragEnd = () => {
            if (!this.isEnabled()) {
                return;
            }
            this.getIframeDragArea().off('dragover').off('drop').hide();
        };
        this.sendMousePosition = (mousePosition) => {
            this.crossFrameEventService.publish(smarteditcommons.SMARTEDIT_DRAG_AND_DROP_EVENTS.TRACK_MOUSE_POSITION, mousePosition);
        };
    }
    initialize() {
        this.throttledSendMousePosition = lo.throttle(this.sendMousePosition, smarteditcommons.SEND_MOUSE_POSITION_THROTTLE);
        this.crossFrameEventService.subscribe(smarteditcommons.SMARTEDIT_DRAG_AND_DROP_EVENTS.DRAG_DROP_START, this.onDragStart);
        this.crossFrameEventService.subscribe(smarteditcommons.SMARTEDIT_DRAG_AND_DROP_EVENTS.DRAG_DROP_END, this.onDragEnd);
        this.crossFrameEventService.subscribe(smarteditcommons.DRAG_AND_DROP_CROSS_ORIGIN_BEFORE_TIME.START, () => {
            if (this.isEnabled()) {
                this.iframeManagerService.getIframe().css('pointer-events', 'none');
            }
        });
        this.crossFrameEventService.subscribe(smarteditcommons.DRAG_AND_DROP_CROSS_ORIGIN_BEFORE_TIME.END, () => {
            if (this.isEnabled()) {
                this.iframeManagerService.getIframe().css('pointer-events', 'auto');
            }
        });
    }
    isEnabled() {
        return this.iframeManagerService.isCrossOrigin();
    }
    getIframeDragArea() {
        return this.yjQuery('#' + smarteditcommons.SMARTEDIT_IFRAME_DRAG_AREA);
    }
    getPositionRelativeToIframe(posX, posY) {
        const iframeOffset = this.getIframeDragArea().offset();
        return {
            x: posX - iframeOffset.left,
            y: posY - iframeOffset.top
        };
    }
    syncIframeDragArea() {
        this.getIframeDragArea().width(this.iframeManagerService.getIframe().width());
        this.getIframeDragArea().height(this.iframeManagerService.getIframe().height());
        const iframeOffset = this.iframeManagerService.getIframe().offset();
        this.getIframeDragArea().css({
            top: iframeOffset.top,
            left: iframeOffset.left
        });
        return this.getIframeDragArea();
    }
};
DragAndDropCrossOrigin.$inject = ["yjQuery", "crossFrameEventService", "iframeManagerService"];
/* @ngInject */ DragAndDropCrossOrigin = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IDragAndDropCrossOrigin),
    __param(0, core.Inject(smarteditcommons.YJQUERY_TOKEN)),
    __metadata("design:paramtypes", [Function, smarteditcommons.CrossFrameEventService,
        IframeManagerService])
], /* @ngInject */ DragAndDropCrossOrigin);

/**
 * The Site Service fetches all sites configured on the hybris platform using REST calls to the cmswebservices sites API.
 */
let /* @ngInject */ SiteService = class /* @ngInject */ SiteService {
    constructor(restServiceFactory) {
        this.SITES_FOR_CATALOGS_URI = '/cmswebservices/v1/sites/catalogs';
        this.cache = null;
        this.siteRestService = restServiceFactory.get(smarteditcommons.SITES_RESOURCE_URI);
        this.sitesForCatalogsRestService = restServiceFactory.get(this.SITES_FOR_CATALOGS_URI);
    }
    /**
     * Fetches a list of sites for which user has at-least read access to one of the non-active catalog versions.
     *
     * @returns A promise of [ISite]{@link ISite} array.
     */
    getAccessibleSites() {
        return this.siteRestService.get({}).then((sitesDTO) => sitesDTO.sites);
    }
    /**
     * Fetches a list of sites configured for accessible sites. The list of sites fetched using REST calls through
     * the cmswebservices sites API.
     *
     * @returns A promise of [ISite]{@link ISite} array.
     */
    getSites() {
        //  Uses two REST API calls because of multicountry. The first call gives all the sites for which the user has permissions to.
        return this.getAccessibleSites().then((sites) => {
            const catalogIds = sites.reduce((catalogs, site) => [...(catalogs || []), ...site.contentCatalogs], []);
            // The call with catalogIds gives all the corresponding sites in the hierarchy.
            return this.sitesForCatalogsRestService
                .save({
                catalogIds
            })
                .then((allSites) => {
                this.cache = allSites.sites;
                return this.cache;
            });
        });
    }
    /**
     * Fetches a site, configured on the hybris platform, by its uid. The sites fetched using REST calls through
     * cmswebservices sites API.
     *
     * @param uid unique site ID
     * @returns A promise of [ISite]{@link ISite}.
     */
    getSiteById(uid) {
        return this.getSites().then((sites) => sites.find((site) => site.uid === uid));
    }
};
SiteService.$inject = ["restServiceFactory"];
__decorate([
    smarteditcommons.Cached({ actions: [smarteditcommons.rarelyChangingContent], tags: [smarteditcommons.authorizationEvictionTag] }),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", Promise)
], /* @ngInject */ SiteService.prototype, "getAccessibleSites", null);
__decorate([
    smarteditcommons.Cached({ actions: [smarteditcommons.rarelyChangingContent], tags: [smarteditcommons.authorizationEvictionTag] }),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", Promise)
], /* @ngInject */ SiteService.prototype, "getSites", null);
/* @ngInject */ SiteService = __decorate([
    smarteditcommons.OperationContextRegistered('SITES_RESOURCE_URI', 'CMS'),
    smarteditcommons.SeDowngradeService(),
    __metadata("design:paramtypes", [smarteditcommons.RestServiceFactory])
], /* @ngInject */ SiteService);

/** @internal */
let /* @ngInject */ ExperienceService = class /* @ngInject */ ExperienceService extends smarteditcommons.IExperienceService {
    constructor(seStorageManager, storagePropertiesService, logService, crossFrameEventService, siteService, previewService, catalogService, languageService, sharedDataService, iframeManagerService, routingService) {
        super();
        this.seStorageManager = seStorageManager;
        this.storagePropertiesService = storagePropertiesService;
        this.logService = logService;
        this.crossFrameEventService = crossFrameEventService;
        this.siteService = siteService;
        this.previewService = previewService;
        this.catalogService = catalogService;
        this.languageService = languageService;
        this.sharedDataService = sharedDataService;
        this.iframeManagerService = iframeManagerService;
        this.routingService = routingService;
        this.storageLoaded$ = new rxjs.BehaviorSubject(false);
        seStorageManager
            .getStorage({
            storageId: smarteditcommons.EXPERIENCE_STORAGE_KEY,
            storageType: storagePropertiesService.getProperty('STORAGE_TYPE_SESSION_STORAGE')
        })
            .then((_storage) => {
            this.experienceStorage = _storage;
            this.storageLoaded$.next(true);
        });
    }
    /**
     * Given an object containing a siteId, catalogId, catalogVersion and catalogVersions (array of product catalog version uuid's), will return a reconstructed experience
     *
     */
    buildAndSetExperience(params) {
        const siteId = params.siteId;
        const catalogId = params.catalogId;
        const catalogVersion = params.catalogVersion;
        const productCatalogVersions = params.productCatalogVersions;
        return Promise.all([
            this.siteService.getSiteById(siteId),
            this.catalogService.getContentCatalogsForSite(siteId),
            this.catalogService.getProductCatalogsForSite(siteId),
            this.languageService.getLanguagesForSite(siteId)
        ]).then(([siteDescriptor, catalogs, productCatalogs, languages]) => {
            const currentCatalog = catalogs.find((catalog) => catalog.catalogId === catalogId);
            const currentCatalogVersion = currentCatalog
                ? currentCatalog.versions.find((result) => result.version === catalogVersion)
                : null;
            if (!currentCatalogVersion) {
                return Promise.reject(`no catalogVersionDescriptor found for ${catalogId} catalogId and ${catalogVersion} catalogVersion`);
            }
            const currentExperienceProductCatalogVersions = [];
            productCatalogs.forEach((productCatalog) => {
                // for each product catalog either choose the version already present in the params or choose the active version.
                const currentProductCatalogVersion = productCatalog.versions.find((version) => productCatalogVersions
                    ? productCatalogVersions.indexOf(version.uuid) > -1
                    : version.active === true);
                currentExperienceProductCatalogVersions.push({
                    catalog: productCatalog.catalogId,
                    catalogName: productCatalog.name,
                    catalogVersion: currentProductCatalogVersion.version,
                    active: currentProductCatalogVersion.active,
                    uuid: currentProductCatalogVersion.uuid
                });
            });
            const languageDescriptor = params.language
                ? languages.find((lang) => lang.isocode === params.language)
                : languages[0];
            const defaultExperience = lo.cloneDeep(params);
            delete defaultExperience.siteId;
            delete defaultExperience.catalogId;
            delete defaultExperience.catalogVersion;
            defaultExperience.siteDescriptor = siteDescriptor;
            defaultExperience.catalogDescriptor = {
                catalogId,
                catalogVersion: currentCatalogVersion.version,
                catalogVersionUuid: currentCatalogVersion.uuid,
                name: currentCatalog.name,
                siteId,
                active: currentCatalogVersion.active
            };
            defaultExperience.languageDescriptor = languageDescriptor;
            defaultExperience.time = defaultExperience.time || null;
            defaultExperience.productCatalogVersions = currentExperienceProductCatalogVersions;
            return this.setCurrentExperience(defaultExperience);
        });
    }
    /**
     * Used to update the page ID stored in the current experience and reloads the page to make the changes visible.
     *
     * @param newPageID the ID of the page that must be stored in the current experience.
     *
     */
    updateExperiencePageId(newPageID) {
        return this.getCurrentExperience().then((currentExperience) => {
            if (!currentExperience) {
                // Experience haven't been set. Thus, the experience hasn't been loaded.
                // No need to update the experience then.
                return null;
            }
            currentExperience.pageId = newPageID;
            return this.setCurrentExperience(currentExperience).then(() => this.reloadPage());
        });
    }
    /**
     * Used to update the experience with the parameters provided and reloads the page to make the changes visible.
     *
     * @param params The object containing the paratements for the experience to be loaded.
     * @param params.siteId the ID of the site that must be stored in the current experience.
     * @param params.catalogId the ID of the catalog that must be stored in the current experience.
     * @param params.catalogVersion the version of the catalog that must be stored in the current experience.
     * @param params.pageId the ID of the page that must be stored in the current experience.
     *
     */
    loadExperience(params) {
        return this.buildAndSetExperience(params).then(() => this.reloadPage());
    }
    reloadPage() {
        this.routingService.reload(`${smarteditcommons.NG_ROUTE_PREFIX}${smarteditcommons.STORE_FRONT_CONTEXT}`);
    }
    updateExperiencePageContext(pageCatalogVersionUuid, pageId) {
        return this.getCurrentExperience()
            .then((currentExperience) => this.catalogService
            .getContentCatalogsForSite(currentExperience.catalogDescriptor.siteId)
            .then((catalogs) => {
            if (!currentExperience) {
                // Experience haven't been set. Thus, the experience hasn't been loaded. No need to update the
                // experience then.
                return null;
            }
            const allCatalogs = catalogs.reduce((acc, catalog) => {
                if (catalog.parents && catalog.parents.length) {
                    catalog.parents.forEach((parent) => {
                        acc.push(parent);
                    });
                }
                return acc;
            }, [...catalogs]);
            const pageCatalogVersion = lo.flatten(allCatalogs.map((catalog) => catalog.versions.map((version) => {
                version.catalogName =
                    catalog.name ||
                        catalog.catalogName;
                version.catalogId = catalog.catalogId;
                return version;
            })))
                .find((version) => version.uuid === pageCatalogVersionUuid);
            return this.catalogService.getCurrentSiteID().then((siteID) => {
                currentExperience.pageId = pageId;
                currentExperience.pageContext = {
                    catalogId: pageCatalogVersion.catalogId,
                    catalogName: pageCatalogVersion.catalogName,
                    catalogVersion: pageCatalogVersion.version,
                    catalogVersionUuid: pageCatalogVersion.uuid,
                    siteId: siteID,
                    active: pageCatalogVersion.active
                };
                return this.setCurrentExperience(currentExperience);
            });
        }))
            .then((experience) => {
            this.crossFrameEventService.publish(smarteditcommons.EVENTS.PAGE_CHANGE, experience);
            return experience;
        });
    }
    getCurrentExperience() {
        // After Angular porting of StorageModule the experienceStorage load promise seems to be resolved after execution of getCurrentExperience.
        // To avoid errors the method is triggered once experienceStorage is present.
        return this.storageLoaded$
            .pipe(operators.filter((value) => value), operators.take(1), operators.mergeMap(() => this.experienceStorage.get(smarteditcommons.EXPERIENCE_STORAGE_KEY)))
            .toPromise();
    }
    setCurrentExperience(experience) {
        return this.getCurrentExperience().then((previousExperience) => {
            this.previousExperience = previousExperience;
            return this.experienceStorage
                .put(experience, smarteditcommons.EXPERIENCE_STORAGE_KEY)
                .then(() => this.sharedDataService
                .set(smarteditcommons.EXPERIENCE_STORAGE_KEY, experience)
                .then(() => experience));
        });
    }
    hasCatalogVersionChanged() {
        return this.getCurrentExperience().then((currentExperience) => this.previousExperience === undefined ||
            currentExperience.catalogDescriptor.catalogId !==
                this.previousExperience.catalogDescriptor.catalogId ||
            currentExperience.catalogDescriptor.catalogVersion !==
                this.previousExperience.catalogDescriptor.catalogVersion);
    }
    initializeExperience() {
        this.iframeManagerService.setCurrentLocation(null);
        return this.getCurrentExperience().then((experience) => {
            if (!experience) {
                this.routingService.go(smarteditcommons.NG_ROUTE_PREFIX);
                return null;
            }
            return this.updateExperience();
        }, (err) => {
            this.logService.error('ExperienceService.initializeExperience() - failed to retrieve experience');
            return Promise.reject(err);
        });
    }
    updateExperience(newExperience) {
        return this.getCurrentExperience().then((experience) => {
            // create a deep copy of the current experience
            experience = lo.cloneDeep(experience);
            // merge the new experience into the copy of the current experience
            lo.merge(experience, newExperience);
            return this.previewService
                .getResourcePathFromPreviewUrl(experience.siteDescriptor.previewUrl)
                .then((resourcePath) => {
                const previewData = this._convertExperienceToPreviewData(experience, resourcePath);
                return this.previewService.createPreview(previewData).then((previewResponse) => {
                    /* forbiddenNameSpaces window._:false */
                    window.__smartedit__.smartEditBootstrapped = {};
                    this.iframeManagerService.loadPreview(previewResponse.resourcePath, previewResponse.ticketId);
                    return this.setCurrentExperience(experience);
                }, (err) => {
                    this.logService.error('iframeManagerService.updateExperience() - failed to update experience');
                    return Promise.reject(err);
                });
            }, (err) => {
                this.logService.error('ExperienceService.updateExperience() - failed to retrieve resource path');
                return Promise.reject(err);
            });
        }, (err) => {
            this.logService.error('ExperienceService.updateExperience() - failed to retrieve current experience');
            return Promise.reject(err);
        });
    }
    compareWithCurrentExperience(experience) {
        if (!experience) {
            return Promise.resolve(false);
        }
        return this.getCurrentExperience().then((currentExperience) => {
            if (!currentExperience) {
                return Promise.resolve(false);
            }
            if (currentExperience.pageId === experience.pageId &&
                currentExperience.siteDescriptor.uid === experience.siteId &&
                currentExperience.catalogDescriptor.catalogId === experience.catalogId &&
                currentExperience.catalogDescriptor.catalogVersion === experience.catalogVersion) {
                return Promise.resolve(true);
            }
            return Promise.resolve(false);
        });
    }
};
ExperienceService.$inject = ["seStorageManager", "storagePropertiesService", "logService", "crossFrameEventService", "siteService", "previewService", "catalogService", "languageService", "sharedDataService", "iframeManagerService", "routingService"];
/* @ngInject */ ExperienceService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IExperienceService),
    smarteditcommons.GatewayProxied('loadExperience', 'updateExperiencePageContext', 'getCurrentExperience', 'hasCatalogVersionChanged', 'buildRefreshedPreviewUrl', 'compareWithCurrentExperience'),
    __param(3, core.Inject(smarteditcommons.EVENT_SERVICE)),
    __metadata("design:paramtypes", [smarteditcommons.IStorageManager,
        smarteditcommons.IStoragePropertiesService,
        smarteditcommons.LogService,
        smarteditcommons.CrossFrameEventService,
        SiteService,
        smarteditcommons.IPreviewService,
        smarteditcommons.ICatalogService,
        smarteditcommons.LanguageService,
        smarteditcommons.ISharedDataService,
        IframeManagerService,
        smarteditcommons.SmarteditRoutingService])
], /* @ngInject */ ExperienceService);

/** @internal */
let /* @ngInject */ FeatureService = class /* @ngInject */ FeatureService extends smarteditcommons.IFeatureService {
    constructor(toolbarServiceFactory, cloneableUtils) {
        super(cloneableUtils);
        this.toolbarServiceFactory = toolbarServiceFactory;
        this.features = [];
    }
    getFeatureProperty(featureKey, propertyName) {
        const feature = this._getFeatureByKey(featureKey);
        return Promise.resolve(feature ? feature[propertyName] : null);
    }
    getFeatureKeys() {
        return this.features.map((feature) => feature.key);
    }
    addToolbarItem(configuration) {
        const toolbar = this.toolbarServiceFactory.getToolbarService(configuration.toolbarId);
        configuration.enablingCallback = function () {
            this.addItems([configuration]);
        }.bind(toolbar);
        configuration.disablingCallback = function () {
            this.removeItemByKey(configuration.key);
        }.bind(toolbar);
        return this.register(configuration);
    }
    _registerAliases(configuration) {
        const feature = this._getFeatureByKey(configuration.key);
        if (!feature) {
            configuration.id = btoa(configuration.key);
            this.features.push(configuration);
        }
        return Promise.resolve();
    }
    _getFeatureByKey(key) {
        return this.features.find((feature) => feature.key === key);
    }
};
FeatureService.$inject = ["toolbarServiceFactory", "cloneableUtils"];
/* @ngInject */ FeatureService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IFeatureService),
    smarteditcommons.GatewayProxied('_registerAliases', 'addToolbarItem', 'register', 'enable', 'disable', '_remoteEnablingFromInner', '_remoteDisablingFromInner', 'addDecorator', 'getFeatureProperty', 'addContextualMenuButton'),
    __metadata("design:paramtypes", [smarteditcommons.IToolbarServiceFactory,
        smarteditcommons.CloneableUtils])
], /* @ngInject */ FeatureService);

/** @internal */
let /* @ngInject */ PageInfoService = class /* @ngInject */ PageInfoService extends smarteditcommons.IPageInfoService {
    constructor() {
        super();
    }
};
/* @ngInject */ PageInfoService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IPageInfoService),
    smarteditcommons.GatewayProxied('getPageUID', 'getPageUUID', 'getCatalogVersionUUIDFromPage', 'isSameCatalogVersionOfPageAndPageTemplate'),
    __metadata("design:paramtypes", [])
], /* @ngInject */ PageInfoService);

/** @internal */
let /* @ngInject */ PreviewService = class /* @ngInject */ PreviewService extends smarteditcommons.IPreviewService {
    constructor(log, loadConfigManagerService, restServiceFactory, urlUtils) {
        super(urlUtils);
        this.log = log;
        this.loadConfigManagerService = loadConfigManagerService;
        this.restServiceFactory = restServiceFactory;
        this.ticketIdIdentifier = 'ticketId';
    }
    createPreview(previewData) {
        return __awaiter(this, void 0, void 0, function* () {
            /**
             * We don't know about any fields coming from other extensions, but throw error for any of the fields
             * that we do know about, namely the IPreviewData interface fields
             */
            const requiredFields = ['catalogVersions', 'resourcePath'];
            this.validatePreviewDataAttributes(previewData, requiredFields);
            yield this.prepareRestService();
            try {
                const response = yield this.previewRestService.save(previewData);
                /**
                 * The response object being stringified, when using copy method, has a method named toJSON()
                 * because it is originally of type angular.resource.IResource<IPreviewData> and
                 * that IResource.toJSON() method is responsible to remove $promise, $resolved properties from the response object.
                 */
                return smarteditcommons.objectUtils.copy(response);
            }
            catch (err) {
                this.log.error('PreviewService.createPreview() - Error creating preview');
                return Promise.reject(err);
            }
        });
    }
    updatePreview(previewData) {
        return __awaiter(this, void 0, void 0, function* () {
            const requiredFields = ['catalogVersions', 'resourcePath', 'ticketId'];
            this.validatePreviewDataAttributes(previewData, requiredFields);
            yield this.prepareRestService();
            try {
                return yield this.previewByticketRestService.update(previewData);
            }
            catch (err) {
                this.log.error('PreviewService.updatePreview() - Error updating preview');
                return Promise.reject(err);
            }
        });
    }
    getResourcePathFromPreviewUrl(previewUrl) {
        return this.prepareRestService().then(() => this.urlUtils.getAbsoluteURL(this.domain, previewUrl));
    }
    prepareRestService() {
        if (!this.previewRestService || !this.previewByticketRestService) {
            return this.loadConfigManagerService.loadAsObject().then((configurations) => {
                const RESOURCE_URI = (configurations.previewTicketURI ||
                    smarteditcommons.PREVIEW_RESOURCE_URI);
                this.previewRestService = this.restServiceFactory.get(RESOURCE_URI);
                this.previewByticketRestService = this.restServiceFactory.get(RESOURCE_URI, this.ticketIdIdentifier);
                this.domain = configurations.domain;
            }, (err) => {
                this.log.error('PreviewService.getRestService() - Error loading configuration');
                return Promise.reject(err);
            });
        }
        return Promise.resolve();
    }
    validatePreviewDataAttributes(previewData, requiredFields) {
        if (requiredFields) {
            requiredFields.forEach((elem) => {
                if (lo.isEmpty(previewData[elem])) {
                    throw new Error(`ValidatePreviewDataAttributes - ${elem} is empty`);
                }
            });
        }
    }
};
PreviewService.$inject = ["log", "loadConfigManagerService", "restServiceFactory", "urlUtils"];
/* @ngInject */ PreviewService = __decorate([
    smarteditcommons.GatewayProxied(),
    smarteditcommons.SeDowngradeService(smarteditcommons.IPreviewService),
    __metadata("design:paramtypes", [smarteditcommons.LogService,
        exports.LoadConfigManagerService,
        smarteditcommons.RestServiceFactory,
        smarteditcommons.UrlUtils])
], /* @ngInject */ PreviewService);

/** @internal */
let /* @ngInject */ PerspectiveService = class /* @ngInject */ PerspectiveService extends smarteditcommons.IPerspectiveService {
    constructor(routingService, logService, systemEventService, featureService, waitDialogService, storageService, crossFrameEventService, permissionService) {
        super();
        this.routingService = routingService;
        this.logService = logService;
        this.systemEventService = systemEventService;
        this.featureService = featureService;
        this.waitDialogService = waitDialogService;
        this.storageService = storageService;
        this.crossFrameEventService = crossFrameEventService;
        this.permissionService = permissionService;
        this.PERSPECTIVE_COOKIE_NAME = 'smartedit-perspectives';
        this.INITIAL_SWITCHTO_ARG = 'INITIAL_SWITCHTO_ARG';
        this.data = {
            activePerspective: undefined,
            previousPerspective: undefined,
            previousSwitchToArg: this.INITIAL_SWITCHTO_ARG
        };
        this.immutablePerspectives = []; // once a perspective is registered it will always exists in this variable
        this.perspectives = [];
        this._addDefaultPerspectives();
        this._registerEventHandlers();
        this.NON_PERSPECTIVE_OBJECT = { key: smarteditcommons.NONE_PERSPECTIVE, nameI18nKey: '', features: [] };
    }
    register(configuration) {
        this._validate(configuration);
        let perspective = this._findByKey(configuration.key);
        if (!perspective) {
            this._addPerspectiveSelectorWidget(configuration);
            perspective = configuration;
            perspective.isHotkeyDisabled = !!configuration.isHotkeyDisabled;
            this.immutablePerspectives.push(perspective);
            this.perspectives.push(perspective);
            this.systemEventService.publishAsync(smarteditcommons.EVENT_PERSPECTIVE_ADDED);
        }
        else {
            perspective.features = smarteditcommons.objectUtils.uniqueArray(perspective.features || [], configuration.features || []);
            perspective.perspectives = smarteditcommons.objectUtils.uniqueArray(perspective.perspectives || [], configuration.perspectives || []);
            perspective.permissions = smarteditcommons.objectUtils.uniqueArray(perspective.permissions || [], configuration.permissions || []);
            this.systemEventService.publishAsync(smarteditcommons.EVENT_PERSPECTIVE_UPDATED);
        }
        return Promise.resolve();
    }
    // Filters immutablePerspectives to determine which perspectives are available, taking into account security
    getPerspectives() {
        const promises = [];
        this.immutablePerspectives.forEach((perspective) => {
            let promise;
            if (perspective.permissions && perspective.permissions.length > 0) {
                promise = this.permissionService.isPermitted([
                    {
                        names: perspective.permissions
                    }
                ]);
            }
            else {
                promise = Promise.resolve(true);
            }
            promises.push(promise);
        });
        return Promise.all(promises).then((results) => this.immutablePerspectives.filter((perspective, index) => results[index]));
    }
    hasActivePerspective() {
        return Promise.resolve(Boolean(this.data.activePerspective));
    }
    getActivePerspective() {
        return this.data.activePerspective
            ? Object.assign({}, this._findByKey(this.data.activePerspective.key)) : null;
    }
    isEmptyPerspectiveActive() {
        return Promise.resolve(!!this.data.activePerspective && this.data.activePerspective.key === smarteditcommons.NONE_PERSPECTIVE);
    }
    switchTo(key) {
        if (!this._changeActivePerspective(key)) {
            this.waitDialogService.hideWaitModal();
            return Promise.resolve();
        }
        this._handleUnloadEvent(key);
        this.waitDialogService.showWaitModal();
        const featuresFromPreviousPerspective = [];
        if (this.data.previousPerspective) {
            this._fetchAllFeatures(this.data.previousPerspective, featuresFromPreviousPerspective);
        }
        const featuresFromNewPerspective = [];
        this._fetchAllFeatures(this.data.activePerspective, featuresFromNewPerspective);
        // deactivating any active feature not belonging to either the perspective or one of its nested perspectives
        featuresFromPreviousPerspective
            .filter((featureKey) => !featuresFromNewPerspective.some((f) => featureKey === f))
            .forEach((featureKey) => {
            this.featureService.disable(featureKey);
        });
        // activating any feature belonging to either the perspective or one of its nested perspectives
        const permissionPromises = [];
        featuresFromNewPerspective
            .filter((feature) => !featuresFromPreviousPerspective.some((f) => feature === f))
            .forEach((featureKey) => {
            permissionPromises.push(this._enableOrDisableFeature(featureKey));
        });
        return Promise.all(permissionPromises).then(() => {
            if (this.data.activePerspective.key === smarteditcommons.NONE_PERSPECTIVE) {
                this.waitDialogService.hideWaitModal();
            }
            this.crossFrameEventService.publish(smarteditcommons.EVENT_PERSPECTIVE_CHANGED, this.data.activePerspective.key !== smarteditcommons.NONE_PERSPECTIVE);
        });
    }
    selectDefault() {
        return this.getPerspectives().then((perspectives) => this.storageService
            .getValueFromLocalStorage(this.PERSPECTIVE_COOKIE_NAME, true)
            .then((cookieValue) => {
            //  restricted by permission
            const perspectiveAvailable = perspectives.find((p) => p.key === cookieValue);
            let defaultPerspective;
            let perspective;
            if (!perspectiveAvailable) {
                this.logService.warn('Cannot select mode "' +
                    cookieValue +
                    '" It might not exist or is restricted.');
                // from full list of perspectives, regardless of permissions
                const perspectiveFromCookie = this._findByKey(cookieValue);
                if (!!perspectiveFromCookie) {
                    this._disableAllFeaturesForPerspective(perspectiveFromCookie);
                }
                defaultPerspective = this.NON_PERSPECTIVE_OBJECT;
                perspective = this.NON_PERSPECTIVE_OBJECT;
            }
            else {
                const perspectiveFromCookie = this._findByKey(cookieValue);
                defaultPerspective = perspectiveFromCookie
                    ? perspectiveFromCookie
                    : this.NON_PERSPECTIVE_OBJECT;
                perspective = this.data.previousPerspective
                    ? this.data.previousPerspective
                    : defaultPerspective;
            }
            if (defaultPerspective.key !== this.NON_PERSPECTIVE_OBJECT.key) {
                this._disableAllFeaturesForPerspective(defaultPerspective);
            }
            return this.switchTo(perspective.key);
        }));
    }
    refreshPerspective() {
        return this.getPerspectives().then((result) => {
            const activePerspective = this.getActivePerspective();
            if (!activePerspective) {
                return this.selectDefault();
            }
            else {
                this.perspectives = result;
                if (!this._findByKey(activePerspective.key)) {
                    return this.switchTo(smarteditcommons.NONE_PERSPECTIVE);
                }
                else {
                    const features = [];
                    const permissionPromises = [];
                    this._fetchAllFeatures(activePerspective, features);
                    features.forEach((featureKey) => {
                        permissionPromises.push(this._enableOrDisableFeature(featureKey));
                    });
                    return Promise.all(permissionPromises).then(() => {
                        this.waitDialogService.hideWaitModal();
                        this.crossFrameEventService.publish(smarteditcommons.EVENT_PERSPECTIVE_REFRESHED, activePerspective.key !== smarteditcommons.NONE_PERSPECTIVE);
                    });
                }
            }
        });
    }
    getActivePerspectiveKey() {
        const activePerspective = this.getActivePerspective();
        return Promise.resolve(activePerspective ? activePerspective.key : null);
    }
    isHotkeyEnabledForActivePerspective() {
        const activePerspective = this.getActivePerspective();
        return Promise.resolve(activePerspective && !activePerspective.isHotkeyDisabled);
    }
    _addPerspectiveSelectorWidget(configuration) {
        configuration.features = configuration.features || [];
        if (configuration.features.indexOf(smarteditcommons.PERSPECTIVE_SELECTOR_WIDGET_KEY) === -1) {
            configuration.features.unshift(smarteditcommons.PERSPECTIVE_SELECTOR_WIDGET_KEY);
        }
    }
    _addDefaultPerspectives() {
        this.register({
            key: smarteditcommons.NONE_PERSPECTIVE,
            nameI18nKey: 'se.perspective.none.name',
            isHotkeyDisabled: true,
            descriptionI18nKey: 'se.perspective.none.description.disabled'
        });
        this.register({
            key: smarteditcommons.ALL_PERSPECTIVE,
            nameI18nKey: 'se.perspective.all.name',
            descriptionI18nKey: 'se.perspective.all.description'
        });
    }
    _registerEventHandlers() {
        this.systemEventService.subscribe(smarteditcommons.EVENTS.LOGOUT, this._clearPerspectiveFeatures.bind(this));
        this.crossFrameEventService.subscribe(smarteditcommons.EVENTS.USER_HAS_CHANGED, this._clearPerspectiveFeatures.bind(this));
        // clear the features when navigating to another page than the storefront. this is preventing a flickering of toolbar icons when going back to storefront on another page.
        this.routingService.routeChangeSuccess().subscribe((event) => {
            const url = this.routingService.getCurrentUrlFromEvent(event);
            if ((url || '').includes(smarteditcommons.STORE_FRONT_CONTEXT)) {
                this._clearPerspectiveFeatures();
            }
        });
    }
    _validate(configuration) {
        if (smarteditcommons.stringUtils.isBlank(configuration.key)) {
            throw new Error('perspectiveService.configuration.key.error.required');
        }
        if (smarteditcommons.stringUtils.isBlank(configuration.nameI18nKey)) {
            throw new Error('perspectiveService.configuration.nameI18nKey.error.required');
        }
        if ([smarteditcommons.NONE_PERSPECTIVE, smarteditcommons.ALL_PERSPECTIVE].indexOf(configuration.key) === -1 &&
            (smarteditcommons.stringUtils.isBlank(configuration.features) || configuration.features.length === 0)) {
            throw new Error('perspectiveService.configuration.features.error.required');
        }
    }
    _findByKey(key) {
        return this.perspectives.find((perspective) => perspective.key === key);
    }
    _fetchAllFeatures(perspective, holder) {
        if (!holder) {
            holder = [];
        }
        if (perspective.key === smarteditcommons.ALL_PERSPECTIVE) {
            smarteditcommons.objectUtils.uniqueArray(holder, this.featureService.getFeatureKeys() || []);
        }
        else {
            smarteditcommons.objectUtils.uniqueArray(holder, perspective.features || []);
            (perspective.perspectives || []).forEach((perspectiveKey) => {
                const nestedPerspective = this._findByKey(perspectiveKey);
                if (nestedPerspective) {
                    this._fetchAllFeatures(nestedPerspective, holder);
                }
                else {
                    this.logService.debug('nested perspective ' + perspectiveKey + ' was not found in the registry');
                }
            });
        }
    }
    _enableOrDisableFeature(featureKey) {
        return this.featureService
            .getFeatureProperty(featureKey, 'permissions')
            .then((permissionNames) => {
            if (!Array.isArray(permissionNames)) {
                permissionNames = [];
            }
            return this.permissionService
                .isPermitted([
                {
                    names: permissionNames
                }
            ])
                .then((allowCallback) => {
                if (allowCallback) {
                    this.featureService.enable(featureKey);
                }
                else {
                    this.featureService.disable(featureKey);
                }
            });
        });
    }
    /**
     * Takes care of sending EVENT_PERSPECTIVE_UNLOADING when perspectives change.
     *
     * This function tracks the "key" argument in calls to switchTo(..) function in order to detect when a
     * perspective is being switched.
     */
    _handleUnloadEvent(nextPerspectiveKey) {
        if (nextPerspectiveKey !== this.data.previousSwitchToArg &&
            this.data.previousSwitchToArg !== this.INITIAL_SWITCHTO_ARG) {
            this.crossFrameEventService.publish(smarteditcommons.EVENT_PERSPECTIVE_UNLOADING, this.data.previousSwitchToArg);
        }
        this.data.previousSwitchToArg = nextPerspectiveKey;
    }
    _retrievePerspective(key) {
        // Validation
        // Change the perspective only if it makes sense.
        if (this.data.activePerspective && this.data.activePerspective.key === key) {
            return null;
        }
        const newPerspective = this._findByKey(key);
        if (!newPerspective) {
            throw new Error("switchTo() - Couldn't find perspective with key " + key);
        }
        return newPerspective;
    }
    _changeActivePerspective(newPerspectiveKey) {
        const newPerspective = this._retrievePerspective(newPerspectiveKey);
        if (newPerspective) {
            this.data.previousPerspective = this.data.activePerspective;
            this.data.activePerspective = newPerspective;
            this.storageService.setValueInLocalStorage(this.PERSPECTIVE_COOKIE_NAME, newPerspective.key, true);
        }
        return newPerspective;
    }
    _disableAllFeaturesForPerspective(perspective) {
        const features = [];
        this._fetchAllFeatures(perspective, features);
        features.forEach((featureKey) => {
            this.featureService.disable(featureKey);
        });
    }
    _clearPerspectiveFeatures() {
        // De-activates all current perspective's features (Still leaves the cookie in the system).
        const perspectiveFeatures = [];
        if (this.data && this.data.activePerspective) {
            this._fetchAllFeatures(this.data.activePerspective, perspectiveFeatures);
        }
        perspectiveFeatures.forEach((feature) => {
            this.featureService.disable(feature);
        });
        return Promise.resolve();
    }
};
PerspectiveService.$inject = ["routingService", "logService", "systemEventService", "featureService", "waitDialogService", "storageService", "crossFrameEventService", "permissionService"];
/* @ngInject */ PerspectiveService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IPerspectiveService),
    smarteditcommons.GatewayProxied('register', 'switchTo', 'hasActivePerspective', 'isEmptyPerspectiveActive', 'selectDefault', 'refreshPerspective', 'getActivePerspectiveKey', 'isHotkeyEnabledForActivePerspective'),
    __metadata("design:paramtypes", [smarteditcommons.SmarteditRoutingService,
        smarteditcommons.LogService,
        smarteditcommons.SystemEventService,
        smarteditcommons.IFeatureService,
        smarteditcommons.IWaitDialogService,
        smarteditcommons.IStorageService,
        smarteditcommons.CrossFrameEventService,
        smarteditcommons.IPermissionService])
], /* @ngInject */ PerspectiveService);

/** @internal */
/* @ngInject */ exports.SessionService = class /* @ngInject */ SessionService extends smarteditcommons.ISessionService {
    // ------------------------------------------------------------------------
    // Constructor
    // ------------------------------------------------------------------------
    constructor($log, restServiceFactory, storageService, cryptographicUtils) {
        super();
        this.$log = $log;
        this.storageService = storageService;
        this.cryptographicUtils = cryptographicUtils;
        // ------------------------------------------------------------------------
        // Constants
        // ------------------------------------------------------------------------
        this.USER_DATA_URI = '/cmswebservices/v1/users/:userUid';
        this.whoAmIService = restServiceFactory.get(smarteditcommons.WHO_AM_I_RESOURCE_URI);
        this.userRestService = restServiceFactory.get(this.USER_DATA_URI);
    }
    // ------------------------------------------------------------------------
    // Public API
    // ------------------------------------------------------------------------
    getCurrentUserDisplayName() {
        return this.getCurrentUserData().then((currentUserData) => currentUserData.displayName);
    }
    getCurrentUsername() {
        return this.getCurrentUserData().then((currentUserData) => currentUserData.uid);
    }
    getCurrentUser() {
        return this.getCurrentUserData();
    }
    hasUserChanged() {
        const prevHashPromise = Promise.resolve(this.cachedUserHash
            ? this.cachedUserHash
            : this.storageService.getItem(smarteditcommons.PREVIOUS_USERNAME_HASH));
        return prevHashPromise.then((prevHash) => this.whoAmIService
            .get({})
            .then((currentUserData) => !!prevHash &&
            prevHash !== this.cryptographicUtils.sha1Hash(currentUserData.uid)));
    }
    setCurrentUsername() {
        return this.whoAmIService.get({}).then((currentUserData) => {
            // NOTE: For most of SmartEdit operation, it is enough to store the previous user hash in the cache.
            // However, if the page is refreshed the cache is cleaned. Therefore, it's necessary to also store it in
            // a cookie through the storageService.
            this.cachedUserHash = this.cryptographicUtils.sha1Hash(currentUserData.uid);
            this.storageService.setItem(smarteditcommons.PREVIOUS_USERNAME_HASH, this.cachedUserHash);
        });
    }
    // ------------------------------------------------------------------------
    // Helper Methods
    // ------------------------------------------------------------------------
    getCurrentUserData() {
        return this.whoAmIService
            .get({})
            .then((whoAmIData) => this.userRestService
            .get({
            userUid: whoAmIData.uid
        })
            .then((userData) => ({
            uid: userData.uid,
            displayName: whoAmIData.displayName,
            readableLanguages: userData.readableLanguages,
            writeableLanguages: userData.writeableLanguages
        })))
            .catch((reason) => {
            this.$log.warn("[SessionService]: Can't load session information", reason);
            return null;
        });
    }
};
exports.SessionService.$inject = ["$log", "restServiceFactory", "storageService", "cryptographicUtils"];
__decorate([
    smarteditcommons.Cached({ actions: [smarteditcommons.rarelyChangingContent], tags: [smarteditcommons.userEvictionTag] }),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", Promise)
], /* @ngInject */ exports.SessionService.prototype, "getCurrentUserData", null);
/* @ngInject */ exports.SessionService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.ISessionService),
    smarteditcommons.GatewayProxied('getCurrentUsername', 'getCurrentUserDisplayName', 'hasUserChanged', 'setCurrentUsername', 'getCurrentUser'),
    __metadata("design:paramtypes", [smarteditcommons.LogService,
        smarteditcommons.RestServiceFactory,
        smarteditcommons.IStorageService,
        smarteditcommons.CryptographicUtils])
], /* @ngInject */ exports.SessionService);

/** @internal */
/* @ngInject */ exports.SharedDataService = class /* @ngInject */ SharedDataService extends smarteditcommons.ISharedDataService {
    constructor() {
        super();
        this.storage = {};
    }
    get(key) {
        return Promise.resolve(this.storage[key]);
    }
    set(key, value) {
        this.storage[key] = value;
        return Promise.resolve();
    }
    update(key, modifyingCallback) {
        return this.get(key).then((oldValue) => modifyingCallback(oldValue).then((newValue) => this.set(key, newValue)));
    }
    remove(key) {
        const value = this.storage[key];
        delete this.storage[key];
        return Promise.resolve(value);
    }
    containsKey(key) {
        return Promise.resolve(lo.has(this.storage, key));
    }
};
/* @ngInject */ exports.SharedDataService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.ISharedDataService),
    smarteditcommons.GatewayProxied(),
    core.Injectable(),
    __metadata("design:paramtypes", [])
], /* @ngInject */ exports.SharedDataService);

/** @internal */
/* @ngInject */ exports.StorageService = class /* @ngInject */ StorageService extends smarteditcommons.IStorageService {
    constructor(logService, windowUtils, cryptographicUtils, fingerPrintingService) {
        super();
        this.logService = logService;
        this.windowUtils = windowUtils;
        this.cryptographicUtils = cryptographicUtils;
        this.fingerPrintingService = fingerPrintingService;
        this.SMARTEDIT_SESSIONS = 'smartedit-sessions';
        this.CUSTOM_PROPERTIES = 'custom_properties';
    }
    isInitialized() {
        const sessions = this.getAuthTokens();
        return Promise.resolve(lo.values(lo.omit(sessions, [this.CUSTOM_PROPERTIES])).length > 0);
    }
    storeAuthToken(authURI, auth) {
        const sessions = this.getAuthTokens();
        sessions[authURI] = auth;
        this._setSmarteditSessions(sessions);
        return Promise.resolve();
    }
    getAuthToken(authURI) {
        const sessions = this.getAuthTokens();
        return Promise.resolve(sessions[authURI]);
    }
    removeAuthToken(authURI) {
        const sessions = this.getAuthTokens();
        delete sessions[authURI];
        this._setSmarteditSessions(sessions);
        return Promise.resolve();
    }
    removeAllAuthTokens() {
        this._removeAllAuthTokens();
        return Promise.resolve();
    }
    getValueFromCookie(cookieName, isEncoded) {
        throw new Error('getValueFromCookie deprecated since 1905, use getValueFromLocalStorage');
    }
    getValueFromLocalStorage(cookieName, isEncoded) {
        return Promise.resolve(this._getValueFromLocalStorage(cookieName, isEncoded));
    }
    getAuthTokens() {
        const smarteditSessions = this.windowUtils
            .getWindow()
            .localStorage.getItem(this.SMARTEDIT_SESSIONS);
        let authTokens;
        if (smarteditSessions) {
            try {
                const decrypted = this.cryptographicUtils.aesDecrypt(smarteditSessions, this.fingerPrintingService.getFingerprint());
                authTokens = JSON.parse(decodeURIComponent(escape(decrypted)));
            }
            catch (_a) {
                // failed to decrypt token. may occur if fingerprint changed.
                this.logService.info('Failed to read authentication token. Forcing a re-authentication.');
            }
        }
        return authTokens || {};
    }
    putValueInCookie(cookieName, value, encode) {
        throw new Error('putValueInCookie deprecated since 1905, use setValueInLocalStorage');
    }
    setValueInLocalStorage(cookieName, value, encode) {
        return Promise.resolve(this._setValueInLocalStorage(cookieName, value, encode));
    }
    setItem(key, value) {
        const sessions = this.getAuthTokens();
        sessions[this.CUSTOM_PROPERTIES] = sessions[this.CUSTOM_PROPERTIES] || {};
        sessions[this.CUSTOM_PROPERTIES][key] = value;
        this._setSmarteditSessions(sessions);
        return Promise.resolve();
    }
    getItem(key) {
        const sessions = this.getAuthTokens();
        sessions[this.CUSTOM_PROPERTIES] = sessions[this.CUSTOM_PROPERTIES] || {};
        return Promise.resolve(sessions[this.CUSTOM_PROPERTIES][key]);
    }
    _removeAllAuthTokens() {
        const sessions = this.getAuthTokens();
        const newSessions = lo.pick(sessions, [this.CUSTOM_PROPERTIES]);
        this._setSmarteditSessions(newSessions);
    }
    _getValueFromLocalStorage(cookieName, isEncoded) {
        const rawValue = this.windowUtils.getWindow().localStorage.getItem(cookieName);
        let value = null;
        if (rawValue) {
            try {
                value = JSON.parse(isEncoded ? decodeURIComponent(escape(window.atob(rawValue))) : rawValue);
            }
            catch (e) {
                // protecting against deserialization issue
                this.logService.error('Failed during deserialization ', e);
            }
        }
        return value;
    }
    _setSmarteditSessions(sessions) {
        const sessionsJSONString = btoa(unescape(encodeURIComponent(JSON.stringify(sessions))));
        const sessionsEncrypted = this.cryptographicUtils.aesBase64Encrypt(sessionsJSONString, this.fingerPrintingService.getFingerprint());
        this.windowUtils
            .getWindow()
            .localStorage.setItem(this.SMARTEDIT_SESSIONS, sessionsEncrypted);
    }
    _setValueInLocalStorage(cookieName, value, encode) {
        let processedValue = JSON.stringify(value);
        processedValue = encode
            ? btoa(unescape(encodeURIComponent(processedValue)))
            : processedValue;
        this.windowUtils.getWindow().localStorage.setItem(cookieName, processedValue);
    }
};
exports.StorageService.$inject = ["logService", "windowUtils", "cryptographicUtils", "fingerPrintingService"];
/* @ngInject */ exports.StorageService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IStorageService),
    smarteditcommons.GatewayProxied('isInitialized', 'storeAuthToken', 'getAuthToken', 'removeAuthToken', 'removeAllAuthTokens', 'storePrincipalIdentifier', 'getPrincipalIdentifier', 'removePrincipalIdentifier', 'getValueFromCookie', 'getValueFromLocalStorage'),
    core.Injectable(),
    __metadata("design:paramtypes", [smarteditcommons.LogService,
        smarteditcommons.WindowUtils,
        smarteditcommons.CryptographicUtils,
        smarteditcommons.FingerPrintingService])
], /* @ngInject */ exports.StorageService);

/** @internal */
let /* @ngInject */ PermissionsRegistrationService = class /* @ngInject */ PermissionsRegistrationService {
    constructor(permissionService, sharedDataService) {
        this.permissionService = permissionService;
        this.sharedDataService = sharedDataService;
    }
    /**
     * Method containing registrations of rules and permissions to be used in smartedit workspace
     */
    registerRulesAndPermissions() {
        // Rules
        this.permissionService.registerRule({
            names: ['se.slot.belongs.to.page'],
            verify: (permissionObjects) => this.sharedDataService
                .get(smarteditcommons.EXPERIENCE_STORAGE_KEY)
                .then((experience) => experience.pageContext &&
                experience.pageContext.catalogVersionUuid ===
                    permissionObjects[0].context.slotCatalogVersionUuid)
        });
        // Permissions
        this.permissionService.registerPermission({
            aliases: ['se.slot.not.external'],
            rules: ['se.slot.belongs.to.page']
        });
    }
};
PermissionsRegistrationService.$inject = ["permissionService", "sharedDataService"];
/* @ngInject */ PermissionsRegistrationService = __decorate([
    smarteditcommons.SeDowngradeService(),
    __metadata("design:paramtypes", [smarteditcommons.IPermissionService,
        smarteditcommons.ISharedDataService])
], /* @ngInject */ PermissionsRegistrationService);

/** @internal */
let /* @ngInject */ CatalogService = class /* @ngInject */ CatalogService extends smarteditcommons.ICatalogService {
    constructor(logService, sharedDataService, siteService, urlService, contentCatalogRestService, productCatalogRestService, storageService) {
        super();
        this.logService = logService;
        this.sharedDataService = sharedDataService;
        this.siteService = siteService;
        this.urlService = urlService;
        this.contentCatalogRestService = contentCatalogRestService;
        this.productCatalogRestService = productCatalogRestService;
        this.storageService = storageService;
        this.SELECTED_SITE_COOKIE_NAME = 'seselectedsite';
    }
    getContentCatalogsForSite(siteUID) {
        return this.contentCatalogRestService
            .get({
            siteUID
        })
            .then((catalogs) => catalogs.catalogs);
    }
    getCatalogByVersion(siteUID, catalogVersionName) {
        return this.getContentCatalogsForSite(siteUID).then((catalogs) => catalogs.filter((catalog) => catalog.versions.some((currentCatalogVersion) => currentCatalogVersion.version === catalogVersionName)));
    }
    isContentCatalogVersionNonActive(_uriContext) {
        return this._getContext(_uriContext).then((uriContext) => this.getContentCatalogsForSite(uriContext[smarteditcommons.CONTEXT_SITE_ID]).then((catalogs) => {
            const currentCatalog = catalogs.find((catalog) => catalog.catalogId === uriContext[smarteditcommons.CONTEXT_CATALOG]);
            const currentCatalogVersion = currentCatalog
                ? currentCatalog.versions.find((catalogVersion) => catalogVersion.version === uriContext[smarteditcommons.CONTEXT_CATALOG_VERSION])
                : null;
            if (!currentCatalogVersion) {
                throw new Error(`Invalid uriContext ${uriContext}, cannot find catalog version.`);
            }
            return !currentCatalogVersion.active;
        }));
    }
    getContentCatalogActiveVersion(_uriContext) {
        return this._getContext(_uriContext).then((uriContext) => this.getContentCatalogsForSite(uriContext[smarteditcommons.CONTEXT_SITE_ID]).then((catalogs) => {
            const currentCatalog = catalogs.find((catalog) => catalog.catalogId === uriContext[smarteditcommons.CONTEXT_CATALOG]);
            const activeCatalogVersion = currentCatalog
                ? currentCatalog.versions.find((catalogVersion) => catalogVersion.active)
                : null;
            if (!activeCatalogVersion) {
                throw new Error(`Invalid uriContext ${uriContext}, cannot find catalog version.`);
            }
            return activeCatalogVersion.version;
        }));
    }
    getActiveContentCatalogVersionByCatalogId(contentCatalogId) {
        return this._getContext().then((uriContext) => this.getContentCatalogsForSite(uriContext[smarteditcommons.CONTEXT_SITE_ID]).then((catalogs) => {
            const currentCatalog = catalogs.find((catalog) => catalog.catalogId === contentCatalogId);
            const currentCatalogVersion = currentCatalog
                ? currentCatalog.versions.find((catalogVersion) => catalogVersion.active)
                : null;
            if (!currentCatalogVersion) {
                throw new Error(`Invalid content catalog ${contentCatalogId}, cannot find any active catalog version.`);
            }
            return currentCatalogVersion.version;
        }));
    }
    getContentCatalogVersion(_uriContext) {
        return this._getContext(_uriContext).then((uriContext) => this.getContentCatalogsForSite(uriContext[smarteditcommons.CONTEXT_SITE_ID]).then((catalogs) => {
            const catalog = catalogs.find((c) => c.catalogId === uriContext[smarteditcommons.CONTEXT_CATALOG]);
            if (!catalog) {
                throw new Error('no catalog ' +
                    uriContext[smarteditcommons.CONTEXT_CATALOG] +
                    ' found for site ' +
                    uriContext[smarteditcommons.CONTEXT_SITE_ID]);
            }
            const catalogVersion = catalog.versions.find((version) => version.version === uriContext[smarteditcommons.CONTEXT_CATALOG_VERSION]);
            if (!catalogVersion) {
                throw new Error(`no catalogVersion ${uriContext[smarteditcommons.CONTEXT_CATALOG_VERSION]} for catalog ${uriContext[smarteditcommons.CONTEXT_CATALOG]} and site ${uriContext[smarteditcommons.CONTEXT_SITE_ID]}`);
            }
            catalogVersion.catalogName = catalog.name;
            catalogVersion.catalogId = catalog.catalogId;
            return catalogVersion;
        }));
    }
    getCurrentSiteID() {
        return this.storageService.getValueFromLocalStorage(this.SELECTED_SITE_COOKIE_NAME, false);
    }
    /**
     * Finds the ID of the default site configured for the provided content catalog.
     * @param contentCatalogId The UID of content catalog for which to retrieve its default site ID.
     * @returns The ID of the default site found.
     */
    getDefaultSiteForContentCatalog(contentCatalogId) {
        return this.siteService.getSites().then((sites) => {
            const defaultSitesForCatalog = sites.filter((site) => {
                // ContentCatalogs in the site object are sorted. The last one is considered
                // the default one for a given site.
                const siteDefaultContentCatalog = lo.last(site.contentCatalogs);
                return siteDefaultContentCatalog && siteDefaultContentCatalog === contentCatalogId;
            });
            if (defaultSitesForCatalog.length === 0) {
                this.logService.warn(`[catalogService] - No default site found for content catalog ${contentCatalogId}`);
            }
            else if (defaultSitesForCatalog.length > 1) {
                this.logService.warn(`[catalogService] - Many default sites found for content catalog ${contentCatalogId}`);
            }
            return defaultSitesForCatalog[0];
        });
    }
    getCatalogVersionByUuid(catalogVersionUuid, siteId) {
        return this.getAllContentCatalogsGroupedById().then((contentCatalogsGrouped) => {
            const catalogs = lo.reduce(contentCatalogsGrouped, (allCatalogs, siteCatalogs) => allCatalogs.concat(siteCatalogs), []);
            const catalogVersionFound = lo.flatten(catalogs.map((catalog) => lo.cloneDeep(catalog.versions).map((version) => {
                version.catalogName = catalog.name;
                version.catalogId = catalog.catalogId;
                return version;
            })))
                .filter((version) => catalogVersionUuid === version.uuid &&
                (!siteId || siteId === version.siteDescriptor.uid))[0];
            if (!catalogVersionFound) {
                const errorMessage = 'Cannot find catalog version with UUID ' +
                    catalogVersionUuid +
                    (siteId ? ' in site ' + siteId : '');
                throw new Error(errorMessage);
            }
            return this.getCurrentSiteID().then((defaultSiteID) => {
                catalogVersionFound.siteId = defaultSiteID;
                return catalogVersionFound;
            });
        });
    }
    getAllContentCatalogsGroupedById() {
        return this.siteService.getSites().then((sites) => {
            const promisesToResolve = sites.map((site) => this.getContentCatalogsForSite(site.uid).then((catalogs) => {
                catalogs.forEach((catalog) => {
                    catalog.versions = catalog.versions.map((catalogVersion) => {
                        catalogVersion.siteDescriptor = site;
                        return catalogVersion;
                    });
                });
                return catalogs;
            }));
            return Promise.all(promisesToResolve);
        });
    }
    getProductCatalogsBySiteKey(siteUIDKey) {
        return this._getContext().then((uriContext) => this.getProductCatalogsForSite(uriContext[siteUIDKey]));
    }
    /* =====================================================================================================================
      * `getProductCatalogsBySite` is to get product catalogs by site value
      * `siteUIDValue` - is the site value rather than site key
      * if you want to get product catalogs by site key, please refer to function `getProductCatalogsBySiteKey`
       =====================================================================================================================
    */
    // eslint-disable-next-line @typescript-eslint/member-ordering
    getProductCatalogsForSite(siteUIDValue) {
        return this.productCatalogRestService
            .get({
            siteUID: siteUIDValue
        })
            .then((catalogs) => catalogs.catalogs);
    }
    getActiveProductCatalogVersionByCatalogId(productCatalogId) {
        return this.getProductCatalogsBySiteKey(smarteditcommons.CONTEXT_SITE_ID).then((catalogs) => {
            const currentCatalog = catalogs.find((catalog) => catalog.catalogId === productCatalogId);
            const currentCatalogVersion = currentCatalog
                ? currentCatalog.versions.find((catalogVersion) => catalogVersion.active)
                : null;
            if (!currentCatalogVersion) {
                throw new Error(`Invalid product catalog ${productCatalogId}, cannot find any active catalog version.`);
            }
            return currentCatalogVersion.version;
        });
    }
    // =====================================================================================================================
    //  Helper Methods
    // =====================================================================================================================
    getCatalogVersionUUid(_uriContext) {
        return this.getContentCatalogVersion(_uriContext).then((catalogVersion) => catalogVersion.uuid);
    }
    retrieveUriContext(_uriContext) {
        return this._getContext(_uriContext);
    }
    returnActiveCatalogVersionUIDs(catalogs) {
        return catalogs.reduce((accumulator, catalog) => {
            accumulator.push(catalog.versions.find((version) => version.active).uuid);
            return accumulator;
        }, []);
    }
    // eslint-disable-next-line @typescript-eslint/member-ordering
    isCurrentCatalogMultiCountry() {
        return this.sharedDataService.get(smarteditcommons.EXPERIENCE_STORAGE_KEY).then((experience) => {
            if (experience && experience.siteDescriptor && experience.catalogDescriptor) {
                const siteId = experience.siteDescriptor.uid;
                const catalogId = experience.catalogDescriptor.catalogId;
                return this.getContentCatalogsForSite(siteId).then((catalogs) => {
                    const catalog = catalogs.find((obj) => obj.catalogId === catalogId);
                    return Promise.resolve(catalog && catalog.parents && catalog.parents.length ? true : false);
                });
            }
            return false;
        });
    }
    _getContext(_uriContext) {
        // TODO: once refactored by Nick, use definition of experience
        return _uriContext
            ? Promise.resolve(_uriContext)
            : this.sharedDataService.get(smarteditcommons.EXPERIENCE_STORAGE_KEY).then((experience) => {
                if (!experience) {
                    throw new Error('catalogService was not provided with a uriContext and could not retrive an experience from sharedDataService');
                }
                return this.urlService.buildUriContext(experience.siteDescriptor.uid, experience.catalogDescriptor.catalogId, experience.catalogDescriptor.catalogVersion);
            });
    }
};
CatalogService.$inject = ["logService", "sharedDataService", "siteService", "urlService", "contentCatalogRestService", "productCatalogRestService", "storageService"];
__decorate([
    smarteditcommons.Cached({ actions: [smarteditcommons.rarelyChangingContent], tags: [smarteditcommons.catalogEvictionTag] }),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [String]),
    __metadata("design:returntype", Promise)
], /* @ngInject */ CatalogService.prototype, "getProductCatalogsForSite", null);
__decorate([
    smarteditcommons.Cached({ actions: [smarteditcommons.rarelyChangingContent], tags: [smarteditcommons.pageChangeEvictionTag] }),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", Promise)
], /* @ngInject */ CatalogService.prototype, "isCurrentCatalogMultiCountry", null);
/* @ngInject */ CatalogService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.ICatalogService),
    smarteditcommons.GatewayProxied(),
    __metadata("design:paramtypes", [smarteditcommons.LogService,
        smarteditcommons.ISharedDataService,
        SiteService,
        smarteditcommons.IUrlService,
        smarteditcommons.ContentCatalogRestService,
        smarteditcommons.ProductCatalogRestService,
        smarteditcommons.IStorageService])
], /* @ngInject */ CatalogService);

/** @internal */
let /* @ngInject */ UrlService = class /* @ngInject */ UrlService extends smarteditcommons.IUrlService {
    constructor(router, location, windowUtils) {
        super();
        this.router = router;
        this.location = location;
        this.windowUtils = windowUtils;
    }
    openUrlInPopup(url) {
        const win = this.windowUtils
            .getWindow()
            .open(url, '_blank', 'toolbar=no, scrollbars=yes, resizable=yes');
        win.focus();
    }
    path(url) {
        /**
         * Route registered in angularjs application does not work
         * if the angular route has been used to navigate to currently previewed page.
         * Same happening if we first navigate to angularjs page and angular routing stops working.
         * The possible solution: use location and router service at the same time.
         */
        this.location.go(url);
        this.router.navigateByUrl(url);
    }
};
UrlService.$inject = ["router", "location", "windowUtils"];
/* @ngInject */ UrlService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IUrlService),
    smarteditcommons.GatewayProxied('openUrlInPopup', 'path'),
    core.Injectable(),
    __metadata("design:paramtypes", [router.Router,
        common.Location,
        smarteditcommons.WindowUtils])
], /* @ngInject */ UrlService);

/** @internal */
let /* @ngInject */ WaitDialogService = class /* @ngInject */ WaitDialogService extends smarteditcommons.IWaitDialogService {
    constructor(modalService) {
        super();
        this.modalService = modalService;
        this.modalRef = null;
    }
    showWaitModal(customLoadingMessageLocalizedKey) {
        const config = {
            component: smarteditcommons.WaitDialogComponent,
            data: { customLoadingMessageLocalizedKey },
            config: {
                backdropClickCloseable: false,
                modalPanelClass: 'se-wait-spinner-dialog',
                focusTrapped: false
            }
        };
        if (this.modalRef === null) {
            this.modalRef = this.modalService.open(config);
        }
    }
    hideWaitModal() {
        if (this.modalRef != null) {
            this.modalRef.close();
            this.modalRef = null;
        }
    }
};
WaitDialogService.$inject = ["modalService"];
/* @ngInject */ WaitDialogService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IWaitDialogService),
    smarteditcommons.GatewayProxied(),
    __metadata("design:paramtypes", [smarteditcommons.ModalService])
], /* @ngInject */ WaitDialogService);

/** @internal */
class MemoryStorage {
    constructor() {
        this.data = {};
    }
    clear() {
        this.data = {};
        return Promise.resolve(true);
    }
    dispose() {
        return Promise.resolve(true);
    }
    find(queryObject) {
        return this.get(queryObject).then((result) => [result]);
    }
    get(queryObject) {
        return Promise.resolve(this.data[this.getKey(queryObject)]);
    }
    getLength() {
        return Promise.resolve(Object.keys(this.data).length);
    }
    put(obj, queryObject) {
        this.data[this.getKey(queryObject)] = obj;
        return Promise.resolve(true);
    }
    remove(queryObject) {
        const originalData = this.data[this.getKey(queryObject)];
        delete this.data[this.getKey(queryObject)];
        return Promise.resolve(originalData);
    }
    entries() {
        const entries = [];
        Object.keys(this.data).forEach((key) => {
            entries.push([JSON.parse(key), this.data[key]]);
        });
        return Promise.resolve(entries);
    }
    getKey(queryObject) {
        return JSON.stringify(queryObject);
    }
}

/** @internal */
class MemoryStorageController {
    constructor(storagePropertiesService) {
        this.storages = {};
        this.storageType = storagePropertiesService.getProperty('STORAGE_TYPE_IN_MEMORY');
    }
    getStorage(options) {
        let storage = this.storages[options.storageId];
        if (!storage) {
            storage = new MemoryStorage();
        }
        this.storages[options.storageId] = storage;
        return Promise.resolve(storage);
    }
    deleteStorage(storageId) {
        delete this.storages[storageId];
        return Promise.resolve(true);
    }
    getStorageIds() {
        return Promise.resolve(Object.keys(this.storages));
    }
}

/** @internal */
class WebStorage {
    constructor(controller, storageConfiguration) {
        this.controller = controller;
        this.storageConfiguration = storageConfiguration;
    }
    static ERR_INVALID_QUERY_OBJECT(queryObjec, storageId) {
        return new Error(`WebStorage exception for storage [${storageId}]. Invalid key [${queryObjec}]`);
    }
    clear() {
        this.controller.saveStorageData({});
        return Promise.resolve(true);
    }
    find(queryObject) {
        if (queryObject === undefined) {
            throw WebStorage.ERR_INVALID_QUERY_OBJECT(queryObject, this.storageConfiguration.storageId);
        }
        return this.get(queryObject).then((result) => [result]);
    }
    get(queryObject) {
        return this.controller.getStorageData().then((data) => {
            const key = this.getKeyFromQueryObj(queryObject);
            return Promise.resolve(data[key]);
        });
    }
    put(obj, queryObject) {
        return this.controller.getStorageData().then((data) => {
            data[this.getKeyFromQueryObj(queryObject)] = obj;
            this.controller.saveStorageData(data);
            return Promise.resolve(true);
        });
    }
    remove(queryObject) {
        if (queryObject === undefined) {
            throw WebStorage.ERR_INVALID_QUERY_OBJECT(queryObject, this.storageConfiguration.storageId);
        }
        const getPromise = this.get(queryObject);
        return this.controller.getStorageData().then((data) => {
            delete data[this.getKeyFromQueryObj(queryObject)];
            this.controller.saveStorageData(data);
            return getPromise;
        });
    }
    getLength() {
        return this.controller
            .getStorageData()
            .then((data) => Promise.resolve(Object.keys(data).length));
    }
    dispose() {
        return Promise.resolve(true);
    }
    entries() {
        const entries = [];
        return new Promise((resolve) => {
            this.controller.getStorageData().then((data) => {
                Object.keys(data).forEach((key) => {
                    entries.push([JSON.parse(key), data[key]]);
                });
                resolve(entries);
            });
        });
    }
    getKeyFromQueryObj(queryObj) {
        return JSON.stringify(queryObj);
    }
}

/** @internal */
class WebStorageBridge {
    constructor(controller, configuration) {
        this.controller = controller;
        this.configuration = configuration;
    }
    saveStorageData(data) {
        return this.controller.saveStorageData(this.configuration.storageId, data);
    }
    getStorageData() {
        return this.controller.getStorageData(this.configuration.storageId);
    }
}

/** @internal */
class AbstractWebStorageController {
    getStorage(configuration) {
        const bridge = new WebStorageBridge(this, configuration);
        const store = new WebStorage(bridge, configuration);
        const oldDispose = store.dispose;
        store.dispose = () => this.deleteStorage(configuration.storageId).then(() => oldDispose());
        return Promise.resolve(store);
    }
    deleteStorage(storageId) {
        const container = this.getWebStorageContainer();
        delete container[storageId];
        this.setWebStorageContainer(container);
        return Promise.resolve(true);
    }
    getStorageIds() {
        const keys = Object.keys(this.getWebStorageContainer());
        return Promise.resolve(keys);
    }
    saveStorageData(storageId, data) {
        const root = this.getWebStorageContainer();
        root[storageId] = data;
        this.setWebStorageContainer(root);
        return Promise.resolve(true);
    }
    getStorageData(storageId) {
        const root = this.getWebStorageContainer();
        if (root[storageId]) {
            return Promise.resolve(root[storageId]);
        }
        return Promise.resolve({});
    }
    setWebStorageContainer(data) {
        this.getStorageApi().setItem(this.getStorageRootKey(), JSON.stringify(data));
    }
    getWebStorageContainer() {
        const container = this.getStorageApi().getItem(this.getStorageRootKey());
        if (!container) {
            return {};
        }
        return JSON.parse(container);
    }
}

/** @internal */
class LocalStorageController extends AbstractWebStorageController {
    constructor(storagePropertiesService) {
        super();
        this.storagePropertiesService = storagePropertiesService;
        this.storageType = this.storagePropertiesService.getProperty('STORAGE_TYPE_LOCAL_STORAGE');
    }
    getStorageApi() {
        return window.localStorage;
    }
    getStorageRootKey() {
        return this.storagePropertiesService.getProperty('LOCAL_STORAGE_ROOT_KEY');
    }
}

/** @internal */
class SessionStorageController extends AbstractWebStorageController {
    constructor(storagePropertiesService) {
        super();
        this.storagePropertiesService = storagePropertiesService;
        this.storageType = this.storagePropertiesService.getProperty('STORAGE_TYPE_SESSION_STORAGE');
    }
    getStorageApi() {
        return window.sessionStorage;
    }
    getStorageRootKey() {
        return this.storagePropertiesService.getProperty('SESSION_STORAGE_ROOT_KEY');
    }
}

/** @internal */
let /* @ngInject */ StorageManagerGateway = class /* @ngInject */ StorageManagerGateway {
    constructor(storageManager) {
        this.storageManager = storageManager;
    }
    getStorageSanitityCheck(storageConfiguration) {
        return this.storageManager.getStorage(storageConfiguration).then(() => true, () => false);
    }
    deleteExpiredStorages(force) {
        return this.storageManager.deleteExpiredStorages(force);
    }
    deleteStorage(storageId, force) {
        return this.storageManager.deleteStorage(storageId, force);
    }
    hasStorage(storageId) {
        return this.storageManager.hasStorage(storageId);
    }
    getStorage(storageConfiguration) {
        throw new Error(`getStorage() is not supported from the StorageManagerGateway, please use the storage manager directly`);
    }
    registerStorageController(controller) {
        throw new Error(`registerStorageController() is not supported from the StorageManagerGateway, please use the storage manager directly`);
    }
};
StorageManagerGateway.$inject = ["storageManager"];
/* @ngInject */ StorageManagerGateway = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IStorageManagerGateway),
    smarteditcommons.GatewayProxied('getStorageSanitityCheck', 'deleteExpiredStorages', 'deleteStorage', 'hasStorage'),
    __param(0, core.Inject(smarteditcommons.DO_NOT_USE_STORAGE_MANAGER_TOKEN)),
    __metadata("design:paramtypes", [smarteditcommons.IStorageManager])
], /* @ngInject */ StorageManagerGateway);

/** @internal */
let /* @ngInject */ StorageGateway = class /* @ngInject */ StorageGateway {
    constructor(storageManager) {
        this.storageManager = storageManager;
    }
    handleStorageRequest(storageConfiguration, method, args) {
        return new Promise((resolve, reject) => {
            this.storageManager.getStorage(storageConfiguration).then((storage) => resolve(storage[method](...args)), (reason) => reject(reason));
        });
    }
};
StorageGateway.$inject = ["storageManager"];
/* @ngInject */ StorageGateway = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IStorageGateway),
    smarteditcommons.GatewayProxied(),
    __param(0, core.Inject(smarteditcommons.DO_NOT_USE_STORAGE_MANAGER_TOKEN)),
    __metadata("design:paramtypes", [smarteditcommons.IStorageManager])
], /* @ngInject */ StorageGateway);

/** @internal */
class MetaDataMapStorage {
    constructor(storageKey) {
        this.storageKey = storageKey;
    }
    getAll() {
        const allMetaData = [];
        const data = this.getDataFromStore();
        Object.keys(data).forEach((key) => {
            allMetaData.push(data[key]);
        });
        return allMetaData;
    }
    get(storageId) {
        return this.getDataFromStore()[storageId];
    }
    put(storageId, value) {
        const data = this.getDataFromStore();
        data[storageId] = value;
        this.setDataInStore(data);
    }
    remove(storageId) {
        const data = this.getDataFromStore();
        delete data[storageId];
        this.setDataInStore(data);
    }
    removeAll() {
        window.localStorage.removeItem(this.storageKey);
    }
    getDataFromStore() {
        try {
            const store = window.localStorage.getItem(this.storageKey);
            if (store === null) {
                return {};
            }
            return JSON.parse(store);
        }
        catch (e) {
            return {};
        }
    }
    setDataInStore(data) {
        window.localStorage.setItem(this.storageKey, JSON.stringify(data));
    }
}

var /* @ngInject */ StorageManager_1;
/** @internal */
let /* @ngInject */ StorageManager = /* @ngInject */ StorageManager_1 = class /* @ngInject */ StorageManager {
    constructor(logService, storagePropertiesService) {
        this.logService = logService;
        this.storagePropertiesService = storagePropertiesService;
        this.storageControllers = {};
        this.storages = {};
        this.storageMetaDataMap = new MetaDataMapStorage(this.storagePropertiesService.getProperty('LOCAL_STORAGE_KEY_STORAGE_MANAGER_METADATA'));
    }
    static ERR_NO_STORAGE_TYPE_CONTROLLER(storageType) {
        return new Error(`StorageManager Error: Cannot create storage. No Controller available to handle type [${storageType}]`);
    }
    registerStorageController(controller) {
        this.storageControllers[controller.storageType] = controller;
    }
    getStorage(storageConfiguration) {
        this.setDefaultStorageOptions(storageConfiguration);
        const loadExistingStorage = this.hasStorage(storageConfiguration.storageId);
        let pendingValidation = Promise.resolve(true);
        if (loadExistingStorage) {
            const metadata = this.storageMetaDataMap.get(storageConfiguration.storageId);
            pendingValidation = this.verifyMetaData(metadata, storageConfiguration);
        }
        return new Promise((resolve, reject) => {
            pendingValidation
                .then(() => {
                if (this.storages[storageConfiguration.storageId]) {
                    this.updateStorageMetaData(storageConfiguration);
                    resolve(this.storages[storageConfiguration.storageId]);
                }
                else {
                    this.getStorageController(storageConfiguration.storageType)
                        .getStorage(storageConfiguration)
                        .then((newStorage) => {
                        this.applyDisposeDecorator(storageConfiguration.storageId, newStorage);
                        this.updateStorageMetaData(storageConfiguration);
                        this.storages[storageConfiguration.storageId] = newStorage;
                        resolve(newStorage);
                    });
                }
            })
                .catch((e) => reject(e));
        });
    }
    hasStorage(storageId) {
        // true if we have metadata for it
        return !!this.storageMetaDataMap.get(storageId);
    }
    deleteStorage(storageId, force = false) {
        delete this.storages[storageId];
        if (!this.hasStorage(storageId)) {
            return Promise.resolve(true);
        }
        const metaData = this.storageMetaDataMap.get(storageId);
        if (metaData) {
            let ctrl;
            try {
                ctrl = this.getStorageController(metaData.storageType);
            }
            catch (e) {
                // silently fail on no storage type handler
                if (force) {
                    this.storageMetaDataMap.remove(storageId);
                }
                return Promise.resolve(true);
            }
            return ctrl.deleteStorage(storageId).then(() => {
                this.storageMetaDataMap.remove(storageId);
                return Promise.resolve(true);
            });
        }
        else {
            return Promise.resolve(true);
        }
    }
    deleteExpiredStorages(force = false) {
        const deletePromises = [];
        const storageMetaDatas = this.storageMetaDataMap.getAll();
        storageMetaDatas.forEach((metaData) => {
            if (this.isStorageExpired(metaData)) {
                deletePromises.push(this.deleteStorage(metaData.storageId, force));
            }
        });
        return Promise.all(deletePromises).then(() => true, () => false);
    }
    updateStorageMetaData(storageConfiguration) {
        this.storageMetaDataMap.put(storageConfiguration.storageId, {
            storageId: storageConfiguration.storageId,
            storageType: storageConfiguration.storageType,
            storageVersion: storageConfiguration.storageVersion,
            lastAccess: Date.now()
        });
    }
    isStorageExpired(metaData) {
        const timeSinceLastAccess = Date.now() - metaData.lastAccess;
        let idleExpiryTime = metaData.expiresAfterIdle;
        if (idleExpiryTime === undefined) {
            idleExpiryTime = this.storagePropertiesService.getProperty('STORAGE_IDLE_EXPIRY');
        }
        return timeSinceLastAccess >= idleExpiryTime;
    }
    applyDisposeDecorator(storageId, storage) {
        const originalDispose = storage.dispose;
        storage.dispose = () => this.deleteStorage(storageId).then(() => originalDispose());
    }
    getStorageController(storageType) {
        const controller = this.storageControllers[storageType];
        if (!controller) {
            throw /* @ngInject */ StorageManager_1.ERR_NO_STORAGE_TYPE_CONTROLLER(storageType);
        }
        return controller;
    }
    verifyMetaData(metadata, configuration) {
        if (metadata.storageVersion !== configuration.storageVersion) {
            this.logService.warn(`StorageManager - Removing old storage version for storage ${metadata.storageId}`);
            return this.deleteStorage(metadata.storageId);
        }
        if (metadata.storageType !== configuration.storageType) {
            this.logService.warn(`StorageManager - Detected a change in storage type for existing storage. Removing old storage with id ${configuration.storageId}`);
            return this.deleteStorage(metadata.storageId);
        }
        return Promise.resolve(true);
    }
    setDefaultStorageOptions(options) {
        if (!options.storageVersion || options.storageVersion.length <= 0) {
            options.storageVersion = '0';
        }
    }
};
/* @ngInject */ StorageManager = /* @ngInject */ StorageManager_1 = __decorate([
    core.Injectable(),
    __metadata("design:paramtypes", [smarteditcommons.LogService,
        smarteditcommons.IStoragePropertiesService])
], /* @ngInject */ StorageManager);

/**
 *
 * defaultStorageProperties are the default [IStorageProperties]{@link IStorageProperties} of the
 * storage system. These values should not be reference directly at build/compile time, but rather through the
 * angularJs provider that exposes them. See [IStoragePropertiesService]{@link IStoragePropertiesService}
 * for more details.
 *
 * ```
 * {
 *     STORAGE_IDLE_EXPIRY: 1000 * 60 * 60 * 24 * 30, // 30 days
 *     STORAGE_TYPE_LOCAL_STORAGE: "se.storage.type.localstorage",
 *     STORAGE_TYPE_SESSION_STORAGE: "se.storage.type.sessionstorage",
 *     STORAGE_TYPE_IN_MEMORY: "se.storage.type.inmemory",
 *     LOCAL_STORAGE_KEY_STORAGE_MANAGER_METADATA: "se.storage.storagemanager.metadata",
 *     LOCAL_STORAGE_ROOT_KEY: "se.storage.root",
 *     SESSION_STORAGE_ROOT_KEY: "se.storage.root"
 * }
 * ```
 */
/** @internal */
const defaultStorageProperties = {
    STORAGE_IDLE_EXPIRY: 1000 * 60 * 60 * 24 * 30,
    // STORAGE TYPES
    STORAGE_TYPE_LOCAL_STORAGE: 'se.storage.type.localstorage',
    STORAGE_TYPE_SESSION_STORAGE: 'se.storage.type.sessionstorage',
    STORAGE_TYPE_IN_MEMORY: 'se.storage.type.inmemory',
    // LOCAL STORAGE KEYS
    LOCAL_STORAGE_KEY_STORAGE_MANAGER_METADATA: 'se.storage.storagemanager.metadata',
    LOCAL_STORAGE_ROOT_KEY: 'se.storage.root',
    SESSION_STORAGE_ROOT_KEY: 'se.storage.root'
};

/**
 * The storagePropertiesService is a provider that implements the IStoragePropertiesService
 * interface and exposes the default storage properties. These properties are used to bootstrap various
 * pieces of the storage system.
 * By Means of StorageModule.configure() you would might change the default localStorage key names, or storage types.
 */
/** @internal */
let /* @ngInject */ StoragePropertiesService = class /* @ngInject */ StoragePropertiesService {
    constructor(storageProperties) {
        this.properties = lo.cloneDeep(defaultStorageProperties);
        storageProperties.forEach((properties) => {
            lo.merge(this.properties, properties);
        });
    }
    getProperty(propertyName) {
        return this.properties[propertyName];
    }
};
StoragePropertiesService.$inject = ["storageProperties"];
/* @ngInject */ StoragePropertiesService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IStoragePropertiesService),
    __param(0, core.Inject(smarteditcommons.STORAGE_PROPERTIES_TOKEN)),
    __metadata("design:paramtypes", [Array])
], /* @ngInject */ StoragePropertiesService);

var StorageModule_1;
let StorageModule = StorageModule_1 = class StorageModule {
    static forRoot(properties = {}) {
        return {
            ngModule: StorageModule_1,
            providers: [
                {
                    provide: smarteditcommons.STORAGE_PROPERTIES_TOKEN,
                    multi: true,
                    useValue: properties
                }
            ]
        };
    }
};
StorageModule = StorageModule_1 = __decorate([
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
            {
                provide: smarteditcommons.IStoragePropertiesService,
                useClass: StoragePropertiesService
            },
            {
                provide: smarteditcommons.DO_NOT_USE_STORAGE_MANAGER_TOKEN,
                useClass: StorageManager
            },
            {
                provide: smarteditcommons.IStorageGateway,
                useClass: StorageGateway
            },
            {
                provide: smarteditcommons.IStorageManagerGateway,
                useClass: StorageManagerGateway
            },
            {
                provide: smarteditcommons.IStorageManagerFactory,
                // eslint-disable-next-line @typescript-eslint/explicit-function-return-type
                useFactory: (logService, doNotUseStorageManager) => new smarteditcommons.StorageManagerFactory(doNotUseStorageManager),
                deps: [smarteditcommons.LogService, smarteditcommons.DO_NOT_USE_STORAGE_MANAGER_TOKEN]
            },
            {
                provide: smarteditcommons.IStorageManager,
                // eslint-disable-next-line @typescript-eslint/explicit-function-return-type
                useFactory: (storageManagerFactory) => storageManagerFactory.getStorageManager('se.nsp'),
                deps: [smarteditcommons.IStorageManagerFactory]
            },
            smarteditcommons.moduleUtils.initialize((storagePropertiesService, seStorageManager) => {
                seStorageManager.registerStorageController(new LocalStorageController(storagePropertiesService));
                seStorageManager.registerStorageController(new SessionStorageController(storagePropertiesService));
                seStorageManager.registerStorageController(new MemoryStorageController(storagePropertiesService));
                smarteditcommons.diBridgeUtils.downgradeService('storageManagerFactory', smarteditcommons.IStorageManagerFactory);
                smarteditcommons.diBridgeUtils.downgradeService('seStorageManager', smarteditcommons.IStorageManager);
            }, [smarteditcommons.IStoragePropertiesService, smarteditcommons.IStorageManager])
        ]
    })
], StorageModule);

var /* @ngInject */ PermissionService_1;
/**
 * The name used to register the default rule.
 */
const DEFAULT_DEFAULT_RULE_NAME = 'se.permission.service.default.rule';
let /* @ngInject */ PermissionService = /* @ngInject */ PermissionService_1 = class /* @ngInject */ PermissionService extends smarteditcommons.IPermissionService {
    constructor(logService, systemEventService, crossFrameEventService) {
        super();
        this.logService = logService;
        this.systemEventService = systemEventService;
        this.crossFrameEventService = crossFrameEventService;
        this._registerEventHandlers();
    }
    static resetForTests() {
        /* @ngInject */ PermissionService_1.rules = [];
        /* @ngInject */ PermissionService_1.permissionsRegistry = [];
        /* @ngInject */ PermissionService_1.cachedResults = {};
    }
    static hasCacheRegion(ruleName) {
        return /* @ngInject */ PermissionService_1.cachedResults.hasOwnProperty(ruleName);
    }
    static getCacheRegion(ruleName) {
        return /* @ngInject */ PermissionService_1.cachedResults[ruleName];
    }
    getPermission(permissionName) {
        return /* @ngInject */ PermissionService_1.permissionsRegistry.find((permission) => permission.aliases.indexOf(permissionName) > -1);
    }
    unregisterDefaultRule() {
        const defaultRule = this._getRule(DEFAULT_DEFAULT_RULE_NAME);
        if (defaultRule) {
            /* @ngInject */ PermissionService_1.rules.splice(/* @ngInject */ PermissionService_1.rules.indexOf(defaultRule), 1);
        }
    }
    registerPermission(permission) {
        this._validatePermission(permission);
        /* @ngInject */ PermissionService_1.permissionsRegistry.push({
            aliases: permission.aliases,
            rules: permission.rules
        });
    }
    hasCachedResult(ruleName, key) {
        return (/* @ngInject */ PermissionService_1.hasCacheRegion(ruleName) &&
            /* @ngInject */ PermissionService_1.getCacheRegion(ruleName).hasOwnProperty(key));
    }
    clearCache() {
        /* @ngInject */ PermissionService_1.cachedResults = {};
        this.crossFrameEventService.publish(smarteditcommons.EVENTS.PERMISSION_CACHE_CLEANED);
    }
    isPermitted(permissions) {
        const rulePermissionNames = this._mapRuleNameToPermissionNames(permissions);
        const rulePromises = this._getRulePromises(rulePermissionNames);
        const names = Object.keys(rulePromises);
        const promises = names.map((key) => rulePromises[key]);
        const onSuccess = (permissionResults) => {
            const result = names.reduce((acc, name, index) => {
                acc[name] = permissionResults[index];
                return acc;
            }, {});
            this._updateCache(rulePermissionNames, result);
            return true;
        };
        const onError = (result) => {
            if (result === false) {
                return result;
            }
            this.logService.error(result);
            return result === undefined ? false : result;
        };
        return Promise.all(promises).then(onSuccess, onError);
    }
    /**
     * This method adds a promise obtained by calling the pre-configured rule.verify function to the rulePromises
     * map if the result does not exist in the rule's cache. Otherwise, a promise that contains the cached result
     * is added.
     *
     * The promise obtained from the rule.verify function is chained to allow short-circuiting the permission
     * verification process. If a rule resolves with a false result or with an error, the chained promise is
     * rejected to stop the verification process without waiting for all other rules to resolve.
     *
     * @param rulePromises An object that maps rule names to promises.
     * @param rulePermissionNames An object that maps rule names to permission name arrays.
     * @param ruleName The name of the rule to verify.
     */
    _addRulePromise(rulePromises, rulePermissionNames, ruleName) {
        const rule = this._getRule(ruleName);
        const permissionNameObjs = rulePermissionNames[ruleName];
        const cacheKey = this._generateCacheKey(permissionNameObjs);
        let rulePromise;
        if (this.hasCachedResult(ruleName, cacheKey)) {
            rulePromise = Promise.resolve(this._getCachedResult(ruleName, cacheKey));
        }
        else {
            rulePromise = this._callRuleVerify(rule.names.join('-'), permissionNameObjs).then((isPermitted) => isPermitted ? Promise.resolve(true) : Promise.reject(false));
        }
        rulePromises[ruleName] = rulePromise;
    }
    /**
     * This method validates a permission name. Permission names need to be prefixed by at least one
     * namespace followed by a "." character to be valid.
     *
     * Example: se.mynamespace is valid.
     * Example: mynamespace is not valid.
     */
    _isPermissionNameValid(permissionName) {
        const checkNameSpace = /^[A-Za-z0-9_\-]+\.[A-Za-z0-9_\-\.]+/;
        return checkNameSpace.test(permissionName);
    }
    /**
     * This method returns an object that maps rule names to promises.
     */
    _getRulePromises(rulePermissionNames) {
        const rulePromises = {};
        Object.keys(rulePermissionNames).forEach((ruleName) => {
            this._addRulePromise.call(this, rulePromises, rulePermissionNames, ruleName);
        });
        return rulePromises;
    }
    /**
     * This method returns true if a default rule is already registered.
     *
     * @returns true if the default rule has been registered, false otherwise.
     */
    _hasDefaultRule() {
        return !!this._getRule(DEFAULT_DEFAULT_RULE_NAME);
    }
    /**
     * This method returns the rule's cached result for the given key.
     *
     * @param ruleName The name of the rule for which to lookup the cached result.
     * @param key The cached key to lookup..
     *
     * @returns The cached result, if it exists, null otherwise.
     */
    _getCachedResult(ruleName, key) {
        return /* @ngInject */ PermissionService_1.hasCacheRegion(ruleName)
            ? /* @ngInject */ PermissionService_1.getCacheRegion(ruleName)[key]
            : null;
    }
    /**
     * This method generates a key to store a rule's result for a given combination of
     * permissions in its cache. It is done by sorting the list of permissions by name
     * and serializing it.
     *
     * @param permissions A list of permissions with a name and context.
     *
     * [{
     *     name: "permission.name"
     *     context: {
     *         key: "value"
     *     }
     * }]
     *
     * @returns The serialized sorted list of permissions.
     */
    _generateCacheKey(permissions) {
        return JSON.stringify(permissions.sort((permissionA, permissionB) => {
            const nameA = permissionA.name;
            const nameB = permissionB.name;
            return nameA === nameB ? 0 : nameA < nameB ? -1 : 1;
        }));
    }
    /**
     * This method goes through the permission name arrays associated to rule names to remove any duplicate
     * permission names.
     *
     * If one or more permission names with the same context are found in a rule name's permission name array,
     * only one entry is kept.
     */
    _removeDuplicatePermissionNames(rulePermissionNames) {
        Object.keys(rulePermissionNames).forEach((ruleName) => {
            rulePermissionNames[ruleName] = rulePermissionNames[ruleName].filter((currentPermission) => {
                const existingPermission = rulePermissionNames[ruleName].find((permission) => permission.name === currentPermission.name);
                if (existingPermission === currentPermission) {
                    return true;
                }
                else {
                    const existingPermissionContext = existingPermission.context;
                    const currentPermissionContext = currentPermission.context;
                    return (JSON.stringify(existingPermissionContext) !==
                        JSON.stringify(currentPermissionContext));
                }
            });
        });
    }
    /**
     * This method returns an object mapping rule name to permission name arrays.
     *
     * It will iterate through the given permission name object array to extract the permission names and contexts,
     * populate the map and clean it up by removing duplicate permission name and context pairs.
     */
    _mapRuleNameToPermissionNames(permissions) {
        const rulePermissionNames = {};
        permissions.forEach((permission) => {
            if (!permission.names) {
                throw Error('Requested Permission requires at least one name');
            }
            const permissionNames = permission.names;
            const permissionContext = permission.context;
            permissionNames.forEach((permissionName) => {
                this._populateRulePermissionNames(rulePermissionNames, permissionName, permissionContext);
            });
        });
        this._removeDuplicatePermissionNames(rulePermissionNames);
        return rulePermissionNames;
    }
    /**
     * This method will populate rulePermissionNames with the rules associated to the permission with the given
     * permissionName.
     *
     * If no permission is registered with the given permissionName and a default rule is registered, the default
     * rule is added to rulePermissionNames.
     *
     * If no permission is registered with the given permissionName and no default rule is registered, an error
     * is thrown.
     */
    _populateRulePermissionNames(rulePermissionNames, permissionName, permissionContext) {
        const permission = this.getPermission(permissionName);
        const permissionHasRules = !!permission && !!permission.rules && permission.rules.length > 0;
        if (permissionHasRules) {
            permission.rules.forEach((ruleName) => {
                this._addPermissionName(rulePermissionNames, ruleName, permissionName, permissionContext);
            });
        }
        else if (this._hasDefaultRule()) {
            this._addPermissionName(rulePermissionNames, DEFAULT_DEFAULT_RULE_NAME, permissionName, permissionContext);
        }
        else {
            throw Error('Permission has no rules');
        }
    }
    /**
     * This method will add an object with the permissionName and permissionContext to rulePermissionNames.
     *
     * Since rules can have multiple names, the map will use the first name in the rule's name list as its key.
     * This way, each rule will be called only once for every permission name and context.
     *
     * If the rule associated to a given rule name is already in rulePermissionNames, the permission will be
     * appended to the associated array. Otherwise, the rule name is added to the map and its permission name array
     * is created.
     */
    _addPermissionName(rulePermissionNames, ruleName, permissionName, permissionContext) {
        const rule = this._getRule(ruleName);
        if (!rule) {
            throw Error('Permission found but no rule found named: ' + ruleName);
        }
        ruleName = rule.names[0];
        if (!rulePermissionNames.hasOwnProperty(ruleName)) {
            rulePermissionNames[ruleName] = [];
        }
        rulePermissionNames[ruleName].push({
            name: permissionName,
            context: permissionContext
        });
    }
    /**
     * This method returns the rule registered with the given name.
     *
     * @param ruleName The name of the rule to lookup.
     *
     * @returns rule The rule with the given name, undefined otherwise.
     */
    _getRule(ruleName) {
        return /* @ngInject */ PermissionService_1.rules.find((rule) => rule.names.indexOf(ruleName) > -1);
    }
    _validationRule(ruleConfiguration) {
        ruleConfiguration.names.forEach((ruleName) => {
            if (this._getRule(ruleName)) {
                throw Error('Rule already exists: ' + ruleName);
            }
        });
    }
    _validatePermission(permissionConfiguration) {
        if (!(permissionConfiguration.aliases instanceof Array)) {
            throw Error('Permission aliases must be an array');
        }
        if (permissionConfiguration.aliases.length < 1) {
            throw Error('Permission requires at least one alias');
        }
        if (!(permissionConfiguration.rules instanceof Array)) {
            throw Error('Permission rules must be an array');
        }
        if (permissionConfiguration.rules.length < 1) {
            throw Error('Permission requires at least one rule');
        }
        permissionConfiguration.aliases.forEach((permissionName) => {
            if (this.getPermission(permissionName)) {
                throw Error('Permission already exists: ' + permissionName);
            }
            if (!this._isPermissionNameValid(permissionName)) {
                throw Error('Permission aliases must be prefixed with namespace and a full stop');
            }
        });
        permissionConfiguration.rules.forEach((ruleName) => {
            if (!this._getRule(ruleName)) {
                throw Error('Permission found but no rule found named: ' + ruleName);
            }
        });
    }
    _updateCache(rulePermissionNames, permissionResults) {
        Object.keys(permissionResults).forEach((ruleName) => {
            const cacheKey = this._generateCacheKey(rulePermissionNames[ruleName]);
            const cacheValue = permissionResults[ruleName];
            this._addCachedResult(ruleName, cacheKey, cacheValue);
        });
    }
    _addCachedResult(ruleName, key, result) {
        if (!/* @ngInject */ PermissionService_1.hasCacheRegion(ruleName)) {
            /* @ngInject */ PermissionService_1.cachedResults[ruleName] = {};
        }
        /* @ngInject */ PermissionService_1.cachedResults[ruleName][key] = result;
    }
    _registerRule(ruleConfiguration) {
        this._validationRule(ruleConfiguration);
        if (ruleConfiguration.names &&
            ruleConfiguration.names.length &&
            ruleConfiguration.names.indexOf(DEFAULT_DEFAULT_RULE_NAME) > -1) {
            throw Error('Register default rule using permissionService.registerDefaultRule()');
        }
        /* @ngInject */ PermissionService_1.rules.push({
            names: ruleConfiguration.names
        });
    }
    _registerDefaultRule(ruleConfiguration) {
        this._validationRule(ruleConfiguration);
        if (ruleConfiguration.names &&
            ruleConfiguration.names.length &&
            ruleConfiguration.names.indexOf(DEFAULT_DEFAULT_RULE_NAME) === -1) {
            throw Error('Default rule name must be DEFAULT_RULE_NAME');
        }
        /* @ngInject */ PermissionService_1.rules.push({
            names: ruleConfiguration.names
        });
    }
    _callRuleVerify(ruleKey, permissionNameObjs) {
        if (this.ruleVerifyFunctions && this.ruleVerifyFunctions[ruleKey]) {
            return this.ruleVerifyFunctions[ruleKey].verify(permissionNameObjs);
        }
        // ask inner application for verify function.
        return this._remoteCallRuleVerify(ruleKey, permissionNameObjs);
    }
    _registerEventHandlers() {
        this.crossFrameEventService.subscribe(smarteditcommons.EVENTS.USER_HAS_CHANGED, this.clearCache.bind(this));
        this.systemEventService.subscribe(smarteditcommons.EVENTS.EXPERIENCE_UPDATE, this.clearCache.bind(this));
        this.crossFrameEventService.subscribe(smarteditcommons.EVENTS.PAGE_CHANGE, this.clearCache.bind(this));
        this.crossFrameEventService.subscribe(smarteditcommons.EVENT_PERSPECTIVE_CHANGED, this.clearCache.bind(this));
    }
    _remoteCallRuleVerify(name, permissionNameObjs) {
        'proxyFunction';
        return null;
    }
};
/* @ngInject */ PermissionService.rules = [];
/* @ngInject */ PermissionService.permissionsRegistry = [];
/* @ngInject */ PermissionService.cachedResults = {};
/* @ngInject */ PermissionService = /* @ngInject */ PermissionService_1 = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IPermissionService),
    smarteditcommons.GatewayProxied('isPermitted', 'clearCache', 'registerPermission', 'unregisterDefaultRule', 'registerDefaultRule', 'registerRule', '_registerRule', '_remoteCallRuleVerify', '_registerDefaultRule'),
    __metadata("design:paramtypes", [smarteditcommons.LogService,
        smarteditcommons.SystemEventService,
        smarteditcommons.CrossFrameEventService])
], /* @ngInject */ PermissionService);

/**
 * The catalog version permission service is used to check if the current user has been granted certain permissions
 * on a given catalog ID and catalog Version.
 */
let /* @ngInject */ CatalogVersionPermissionRestService = class /* @ngInject */ CatalogVersionPermissionRestService {
    constructor(restServiceFactory, sessionService) {
        this.restServiceFactory = restServiceFactory;
        this.sessionService = sessionService;
        this.URI = '/permissionswebservices/v1/permissions/catalogs/search';
    }
    /**
     * This method returns permissions from the Catalog Version Permissions Service API.
     *
     * Sample Request:
     * POST /permissionswebservices/v1/permissions/catalogs/search?catalogId=apparel-deContentCatalog&catalogVersion=Online
     *
     * Sample Response from API:
     * {
     * "permissionsList": [
     *     {
     *       "catalogId": "apparel-deContentCatalog",
     *       "catalogVersion": "Online",
     *       "permissions": [
     *         {
     *           "key": "read",
     *           "value": "true"
     *         },
     *         {
     *           "key": "write",
     *           "value": "false"
     *         }
     *       ],
     *      "syncPermissions": [
     *        {
     *          "canSynchronize": "true",
     *          "targetCatalogVersion": "Online"
     *        }
     *     }
     *    ]
     * }
     *
     * Sample Response returned by the service:
     * {
     *   "catalogId": "apparel-deContentCatalog",
     *   "catalogVersion": "Online",
     *   "permissions": [
     *      {
     *        "key": "read",
     *        "value": "true"
     *      },
     *      {
     *        "key": "write",
     *        "value": "false"
     *      }
     *     ],
     *    "syncPermissions": [
     *      {
     *        "canSynchronize": "true",
     *        "targetCatalogVersion": "Online"
     *      }
     *    ]
     *  }
     *
     * @param catalogId The Catalog ID
     * @param catalogVersion The Catalog Version name
     *
     * @returns A Promise which returns an object exposing a permissions array containing the catalog version permissions
     */
    getCatalogVersionPermissions(catalogId, catalogVersion) {
        this.validateParams(catalogId, catalogVersion);
        return this.sessionService.getCurrentUsername().then((principal) => {
            const restService = this.restServiceFactory.get(this.URI);
            return restService
                .queryByPost({ principalUid: principal }, { catalogId, catalogVersion })
                .then(({ permissionsList }) => permissionsList[0] || {});
        });
    }
    // TODO: When everything has been migrated to typescript it is sufficient enough to remove this validation.
    validateParams(catalogId, catalogVersion) {
        if (!catalogId) {
            throw new Error('catalog.version.permission.service.catalogid.is.required');
        }
        if (!catalogVersion) {
            throw new Error('catalog.version.permission.service.catalogversion.is.required');
        }
    }
};
CatalogVersionPermissionRestService.$inject = ["restServiceFactory", "sessionService"];
__decorate([
    smarteditcommons.Cached({ actions: [smarteditcommons.rarelyChangingContent], tags: [smarteditcommons.userEvictionTag] }),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [String, String]),
    __metadata("design:returntype", Promise)
], /* @ngInject */ CatalogVersionPermissionRestService.prototype, "getCatalogVersionPermissions", null);
/* @ngInject */ CatalogVersionPermissionRestService = __decorate([
    smarteditcommons.SeDowngradeService(),
    __metadata("design:paramtypes", [smarteditcommons.RestServiceFactory,
        smarteditcommons.ISessionService])
], /* @ngInject */ CatalogVersionPermissionRestService);

window.__smartedit__.addDecoratorPayload("Component", "HeartBeatAlertComponent", {
    selector: 'se-heartbeat-alert',
    template: `<div><span>{{ 'se.heartbeat.failure1' | translate }}</span> <span><a (click)="switchToPreviewMode()">{{ 'se.heartbeat.failure2' | translate }}</a></span></div>`
});
let HeartBeatAlertComponent = class HeartBeatAlertComponent {
    constructor(alertRef, perspectiveService, crossFrameEventService) {
        this.alertRef = alertRef;
        this.perspectiveService = perspectiveService;
        this.crossFrameEventService = crossFrameEventService;
    }
    switchToPreviewMode() {
        this.alertRef.dismiss();
        this.perspectiveService.switchTo(smarteditcommons.NONE_PERSPECTIVE);
        this.crossFrameEventService.publish(smarteditcommons.EVENT_STRICT_PREVIEW_MODE_REQUESTED, true);
    }
};
HeartBeatAlertComponent = __decorate([
    core.Component({
        selector: 'se-heartbeat-alert',
        template: `<div><span>{{ 'se.heartbeat.failure1' | translate }}</span> <span><a (click)="switchToPreviewMode()">{{ 'se.heartbeat.failure2' | translate }}</a></span></div>`
    }),
    __param(2, core.Inject(smarteditcommons.EVENT_SERVICE)),
    __metadata("design:paramtypes", [core$1.AlertRef,
        smarteditcommons.IPerspectiveService,
        smarteditcommons.CrossFrameEventService])
], HeartBeatAlertComponent);

let /* @ngInject */ AlertFactory = class /* @ngInject */ AlertFactory extends smarteditcommons.BaseAlertFactory {
    constructor(fundamentalAlertService, translateService, ALERT_CONFIG_DEFAULTS) {
        super(fundamentalAlertService, translateService, ALERT_CONFIG_DEFAULTS);
    }
    createAlert(alertConf) {
        alertConf = this.getAlertConfigFromStringOrConfig(alertConf);
        return super.createAlert(alertConf);
    }
    createInfo(alertConf) {
        alertConf = this.getAlertConfigFromStringOrConfig(alertConf);
        alertConf.type = smarteditcommons.IAlertServiceType.INFO;
        return super.createInfo(alertConf);
    }
    createDanger(alertConf) {
        alertConf = this.getAlertConfigFromStringOrConfig(alertConf);
        alertConf.type = smarteditcommons.IAlertServiceType.DANGER;
        return super.createDanger(alertConf);
    }
    createWarning(alertConf) {
        alertConf = this.getAlertConfigFromStringOrConfig(alertConf);
        alertConf.type = smarteditcommons.IAlertServiceType.WARNING;
        return super.createWarning(alertConf);
    }
    createSuccess(alertConf) {
        alertConf = this.getAlertConfigFromStringOrConfig(alertConf);
        alertConf.type = smarteditcommons.IAlertServiceType.SUCCESS;
        return super.createSuccess(alertConf);
    }
    /**
     * Accepts message string or config object
     * Will convert a str param to { message: str }
     */
    getAlertConfigFromStringOrConfig(strOrConf) {
        if (typeof strOrConf === 'string') {
            return {
                message: strOrConf
            };
        }
        const config = strOrConf;
        return Object.assign({}, config);
    }
};
AlertFactory.$inject = ["fundamentalAlertService", "translateService", "ALERT_CONFIG_DEFAULTS"];
/* @ngInject */ AlertFactory = __decorate([
    smarteditcommons.SeDowngradeService(),
    core.Injectable(),
    __param(2, core.Inject(smarteditcommons.ALERT_CONFIG_DEFAULTS_TOKEN)),
    __metadata("design:paramtypes", [core$1.AlertService,
        core$2.TranslateService,
        core$1.AlertConfig])
], /* @ngInject */ AlertFactory);

let /* @ngInject */ AlertService = class /* @ngInject */ AlertService extends smarteditcommons.BaseAlertService {
    constructor(_alertFactory) {
        super(_alertFactory);
        this._alertFactory = _alertFactory;
    }
    showAlert(alertConf) {
        alertConf = this._alertFactory.getAlertConfigFromStringOrConfig(alertConf);
        super.showAlert(alertConf);
    }
    showInfo(alertConf) {
        alertConf = this._alertFactory.getAlertConfigFromStringOrConfig(alertConf);
        super.showInfo(alertConf);
    }
    showDanger(alertConf) {
        alertConf = this._alertFactory.getAlertConfigFromStringOrConfig(alertConf);
        super.showDanger(alertConf);
    }
    showWarning(alertConf) {
        alertConf = this._alertFactory.getAlertConfigFromStringOrConfig(alertConf);
        super.showWarning(alertConf);
    }
    showSuccess(alertConf) {
        alertConf = this._alertFactory.getAlertConfigFromStringOrConfig(alertConf);
        super.showSuccess(alertConf);
    }
};
AlertService.$inject = ["_alertFactory"];
/* @ngInject */ AlertService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IAlertService),
    smarteditcommons.GatewayProxied(),
    core.Injectable(),
    __metadata("design:paramtypes", [AlertFactory])
], /* @ngInject */ AlertService);

exports.AlertServiceModule = class AlertServiceModule {
};
exports.AlertServiceModule = __decorate([
    core.NgModule({
        imports: [smarteditcommons.AlertModule],
        providers: [
            AlertFactory,
            {
                provide: smarteditcommons.IAlertService,
                useClass: AlertService
            }
        ]
    })
], exports.AlertServiceModule);

var /* @ngInject */ HeartBeatService_1;
/* @internal */
let /* @ngInject */ HeartBeatService = /* @ngInject */ HeartBeatService_1 = class /* @ngInject */ HeartBeatService {
    constructor(HEART_BEAT_TIMEOUT_THRESHOLD_MS, translate, routingService, windowUtils, alertFactory, crossFrameEventService, gatewayFactory, sharedDataService) {
        this.HEART_BEAT_TIMEOUT_THRESHOLD_MS = HEART_BEAT_TIMEOUT_THRESHOLD_MS;
        this.routingService = routingService;
        this.windowUtils = windowUtils;
        this.crossFrameEventService = crossFrameEventService;
        this.sharedDataService = sharedDataService;
        this.reconnectingInProgress = false;
        /**
         * @internal
         * Hide all alerts and cancel all pending actions and timers.
         */
        this.resetAndStop = () => {
            this.reconnectingInProgress = false;
            if (this.cancellableTimeoutTimer) {
                clearTimeout(this.cancellableTimeoutTimer);
                this.cancellableTimeoutTimer = null;
            }
            this.reconnectingAlert.hide();
            this.reconnectedAlert.hide();
        };
        /**
         * Connection to iframe has been lost, show reconnected alert to user
         */
        this.connectionLost = () => {
            this.resetAndStop();
            if (!!this.windowUtils.getGatewayTargetFrame()) {
                this.reconnectingAlert.show();
            }
            this.reconnectingInProgress = true;
        };
        this.reconnectingAlert = alertFactory.createInfo({
            component: HeartBeatAlertComponent,
            duration: -1,
            dismissible: false
        });
        this.reconnectedAlert = alertFactory.createInfo({
            message: translate.instant('se.heartbeat.reconnection'),
            duration: 3000
        });
        const heartBeatGateway = gatewayFactory.createGateway(/* @ngInject */ HeartBeatService_1.HEART_BEAT_GATEWAY_ID);
        heartBeatGateway.subscribe(/* @ngInject */ HeartBeatService_1.HEART_BEAT_MSG_ID, () => this.heartBeatReceived());
        this.crossFrameEventService.subscribe(smarteditcommons.EVENTS.PAGE_CHANGE, () => {
            this.resetAndStop();
            // assume every page is smarteditable ¯\_(ツ)_/¯
            return this.heartBeatReceived();
        });
        this.routingService.routeChangeSuccess().subscribe((event) => {
            const url = this.routingService.getCurrentUrlFromEvent(event);
            if (url === `/${smarteditcommons.NG_ROUTE_PREFIX}${smarteditcommons.STORE_FRONT_CONTEXT}`) {
                return this.heartBeatReceived();
            }
            return Promise.resolve();
        });
        this.routingService.routeChangeStart().subscribe(() => {
            this.resetAndStop();
        });
    }
    /**
     * @internal
     * Heartbeat received from iframe, show reconnected if connection was previously
     * lost, and restart the timer to wait for iframe heartbeat
     */
    heartBeatReceived() {
        const reconnecting = this.reconnectingInProgress;
        this.resetAndStop();
        if (reconnecting) {
            if (!!this.windowUtils.getGatewayTargetFrame()) {
                this.reconnectedAlert.show();
            }
            this.reconnectingInProgress = false;
            // Publish an event to enable the perspective selector in case if it is disabled
            this.crossFrameEventService.publish(smarteditcommons.EVENT_STRICT_PREVIEW_MODE_REQUESTED, false);
        }
        return this.sharedDataService
            .get('configuration')
            .then(({ heartBeatTimeoutThreshold }) => {
            if (!heartBeatTimeoutThreshold) {
                heartBeatTimeoutThreshold = this.HEART_BEAT_TIMEOUT_THRESHOLD_MS;
            }
            this.cancellableTimeoutTimer = this.windowUtils.runTimeoutOutsideAngular(this.connectionLost, +heartBeatTimeoutThreshold);
        });
    }
};
/* @ngInject */ HeartBeatService.HEART_BEAT_GATEWAY_ID = 'heartBeatGateway';
/* @ngInject */ HeartBeatService.HEART_BEAT_MSG_ID = 'heartBeat';
/* @ngInject */ HeartBeatService = /* @ngInject */ HeartBeatService_1 = __decorate([
    smarteditcommons.SeDowngradeService(),
    __param(0, core.Inject(smarteditcommons.HEART_BEAT_TIMEOUT_THRESHOLD_MS_TOKEN)),
    __metadata("design:paramtypes", [Number, core$2.TranslateService,
        smarteditcommons.SmarteditRoutingService,
        smarteditcommons.WindowUtils,
        AlertFactory,
        smarteditcommons.CrossFrameEventService,
        smarteditcommons.GatewayFactory,
        smarteditcommons.ISharedDataService])
], /* @ngInject */ HeartBeatService);

/** @internal */
let /* @ngInject */ ConfigurationService = class /* @ngInject */ ConfigurationService {
    constructor(logService, loadConfigManagerService, restServiceFactory) {
        this.logService = logService;
        this.loadConfigManagerService = loadConfigManagerService;
        this.restServiceFactory = restServiceFactory;
        // Constants
        this.ABSOLUTE_URI_NOT_APPROVED = 'URI_EXCEPTION';
        this.ABSOLUTE_URI_REGEX = /(\"[A-Za-z]+:\/|\/\/)/;
        this.configuration = [];
        this.editorCRUDService = this.restServiceFactory.get(smarteditcommons.CONFIGURATION_URI, 'key');
    }
    /*
     * The Add Entry method adds an entry to the list of configurations.
     *
     */
    addEntry() {
        const item = { key: '', value: '', isNew: true, uuid: lo.uniqueId() };
        this.configuration = [item, ...(this.configuration || [])];
    }
    /*
     * The Remove Entry method deletes the specified entry from the list of configurations. The method does not delete the actual configuration, but just removes it from the array of configurations.
     * The entry will be deleted when a user clicks the Submit button but if the entry is new we can are removing it from the configuration
     *
     * @param {Object} entry The object to be deleted
     * @param {Object} configurationForm The form object which is an instance of {@link https://docs.angularjs.org/api/ng/type/form.FormController FormController}
     * that provides methods to monitor and control the state of the form.
     */
    removeEntry(entry, configurationForm) {
        if (entry.isNew) {
            this.configuration = this.configuration.filter((confEntry) => !confEntry.isNew || confEntry.key !== entry.key);
        }
        else {
            configurationForm.form.markAsDirty();
            entry.toDelete = true;
        }
    }
    /*
     * Method that returns a list of configurations by filtering out only those configurations whose 'toDelete' parameter is set to false.
     *
     * @returns {Object} A list of filtered configurations.
     */
    filterConfiguration() {
        return (this.configuration || []).filter((instance) => !instance.toDelete);
    }
    validateUserInput(entry) {
        if (!entry.value) {
            return;
        }
        entry.requiresUserCheck = !!entry.value.match(this.ABSOLUTE_URI_REGEX);
    }
    /*
     * The Submit method saves the list of available configurations by making a REST call to a web service.
     * The method is called when a user clicks the Submit button in the configuration editor.
     *
     * @param {Object} configurationForm The form object that is an instance of {@link https://docs.angularjs.org/api/ng/type/form.FormController FormController}.
     * It provides methods to monitor and control the state of the form.
     */
    submit(configurationForm) {
        if (!configurationForm.dirty || !this.isValid(configurationForm)) {
            return Promise.reject([]);
        }
        configurationForm.form.markAsPristine();
        return Promise.all(this.configuration.map((entry, i) => this.reconstructConfigurationEntry(entry, i)));
    }
    /*
     * The init method initializes the configuration editor and loads all the configurations so they can be edited.
     *
     * @param {Function} loadCallback The callback to be executed after loading the configurations.
     */
    init(_loadCallback) {
        this.loadCallback = _loadCallback || lo.noop;
        return this.loadAndPresent();
    }
    reconstructConfigurationEntry(entry, i) {
        const payload = smarteditcommons.objectUtils.copy(entry);
        let method;
        payload.secured = false; // needed for yaas configuration service
        delete payload.toDelete;
        delete payload.errors;
        delete payload.uuid;
        try {
            if (entry.toDelete) {
                method = 'remove';
            }
            else if (payload.isNew) {
                method = 'save';
                payload.value = this.validate(payload);
            }
            else {
                method = 'update';
                payload.value = this.validate(payload);
            }
        }
        catch (error) {
            entry.hasErrors = true;
            if (error instanceof smarteditcommons.Errors.ParseError) {
                this.addValueError(entry, 'se.configurationform.json.parse.error');
                return Promise.reject({});
            }
        }
        delete payload.isNew;
        entry.hasErrors = false;
        // eslint-disable-next-line @typescript-eslint/no-unsafe-return
        return this.editorCRUDService[method](payload).then(() => {
            switch (method) {
                case 'save':
                    delete entry.isNew;
                    break;
                case 'remove':
                    this.configuration.splice(i, 1);
                    break;
            }
            return Promise.resolve({});
        }, () => {
            this.addValueError(entry, 'configurationform.save.error');
            return Promise.reject({});
        });
    }
    reset(configurationForm) {
        this.configuration = smarteditcommons.objectUtils.copy(this.pristine);
        if (configurationForm) {
            configurationForm.form.markAsPristine();
        }
        if (this.loadCallback) {
            this.loadCallback();
        }
    }
    addError(entry, type, message) {
        entry.errors = entry.errors || {};
        entry.errors[type] = entry.errors[type] || [];
        entry.errors[type].push({
            message
        });
    }
    addKeyError(entry, message) {
        this.addError(entry, 'keys', message);
    }
    addValueError(entry, message) {
        this.addError(entry, 'values', message);
    }
    prettify(array) {
        const configuration = smarteditcommons.objectUtils.copy(array);
        configuration.forEach((entry) => {
            try {
                entry.value = JSON.stringify(JSON.parse(entry.value), null, 2);
            }
            catch (parseError) {
                this.addValueError(entry, 'se.configurationform.json.parse.error');
            }
        });
        return configuration;
    }
    /**
     * for editing purposes
     */
    loadAndPresent() {
        return new Promise((resolve, reject) => this.loadConfigManagerService.loadAsArray().then((response) => {
            this.pristine = this.prettify(response.map((item) => (Object.assign(Object.assign({}, item), { uuid: lo.uniqueId() }))));
            this.reset();
            resolve();
        }, () => {
            this.logService.log('load failed');
            reject();
        }));
    }
    isValid(configurationForm) {
        this.configuration.forEach((entry) => {
            delete entry.errors;
        });
        if (configurationForm.invalid) {
            this.configuration.forEach((entry) => {
                if (smarteditcommons.stringUtils.isBlank(entry.key)) {
                    this.addKeyError(entry, 'se.configurationform.required.entry.error');
                    entry.hasErrors = true;
                }
                if (smarteditcommons.stringUtils.isBlank(entry.value)) {
                    this.addValueError(entry, 'se.configurationform.required.entry.error');
                    entry.hasErrors = true;
                }
            });
        }
        return (configurationForm.valid &&
            !this.configuration.reduce((confHolder, nextConfiguration) => {
                if (confHolder.keys.indexOf(nextConfiguration.key) > -1) {
                    this.addKeyError(nextConfiguration, 'se.configurationform.duplicate.entry.error');
                    confHolder.errors = true;
                }
                else {
                    confHolder.keys.push(nextConfiguration.key);
                }
                return confHolder;
            }, {
                keys: [],
                errors: false
            }).errors);
    }
    validate(entry) {
        try {
            if (entry.requiresUserCheck && !entry.isCheckedByUser) {
                throw new Error(this.ABSOLUTE_URI_NOT_APPROVED);
            }
            return JSON.stringify(JSON.parse(entry.value));
        }
        catch (parseError) {
            throw new smarteditcommons.Errors.ParseError(entry.value);
        }
    }
};
ConfigurationService.$inject = ["logService", "loadConfigManagerService", "restServiceFactory"];
/* @ngInject */ ConfigurationService = __decorate([
    smarteditcommons.SeDowngradeService(),
    __metadata("design:paramtypes", [smarteditcommons.LogService,
        exports.LoadConfigManagerService,
        smarteditcommons.RestServiceFactory])
], /* @ngInject */ ConfigurationService);

let /* @ngInject */ IframeClickDetectionService = class /* @ngInject */ IframeClickDetectionService extends smarteditcommons.IIframeClickDetectionService {
    constructor() {
        super();
        this.callbacks = {};
    }
    registerCallback(id, callback) {
        this.callbacks[id] = callback;
        return this.removeCallback.bind(this, id);
    }
    removeCallback(id) {
        if (this.callbacks[id]) {
            delete this.callbacks[id];
            return true;
        }
        return false;
    }
    /**
     * Triggers all callbacks currently registered to the service. This function is registered as a listener through
     * the GatewayProxy
     */
    onIframeClick() {
        for (const ref in this.callbacks) {
            if (this.callbacks.hasOwnProperty(ref)) {
                this.callbacks[ref]();
            }
        }
    }
};
/* @ngInject */ IframeClickDetectionService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IIframeClickDetectionService),
    smarteditcommons.GatewayProxied('onIframeClick'),
    core.Injectable(),
    __metadata("design:paramtypes", [])
], /* @ngInject */ IframeClickDetectionService);

/** @internal */
let /* @ngInject */ RenderService = class /* @ngInject */ RenderService extends smarteditcommons.IRenderService {
    constructor(yjQuery, crossFrameEventService, systemEventService, notificationService, pageInfoService, perspectiveService, windowUtils, modalService) {
        super(yjQuery, systemEventService, notificationService, pageInfoService, perspectiveService, crossFrameEventService, windowUtils, modalService);
        this.yjQuery = yjQuery;
        this.crossFrameEventService = crossFrameEventService;
        this.systemEventService = systemEventService;
    }
    blockRendering(block) {
        this.renderingBlocked = block;
    }
    isRenderingBlocked() {
        return Promise.resolve(this.renderingBlocked || false);
    }
};
RenderService.$inject = ["yjQuery", "crossFrameEventService", "systemEventService", "notificationService", "pageInfoService", "perspectiveService", "windowUtils", "modalService"];
/* @ngInject */ RenderService = __decorate([
    smarteditcommons.GatewayProxied('blockRendering', 'isRenderingBlocked', 'renderSlots', 'renderComponent', 'renderRemoval', 'toggleOverlay', 'refreshOverlayDimensions', 'renderPage'),
    smarteditcommons.SeDowngradeService(smarteditcommons.IRenderService),
    __param(0, core.Inject(smarteditcommons.YJQUERY_TOKEN)),
    __metadata("design:paramtypes", [Function, smarteditcommons.CrossFrameEventService,
        smarteditcommons.SystemEventService,
        smarteditcommons.INotificationService,
        smarteditcommons.IPageInfoService,
        smarteditcommons.IPerspectiveService,
        smarteditcommons.WindowUtils,
        smarteditcommons.ModalService])
], /* @ngInject */ RenderService);

window.__smartedit__.addDecoratorPayload("Injectable", "TranslationsFetchService", { providedIn: 'root' });
/* @ngInject */ exports.TranslationsFetchService = class /* @ngInject */ TranslationsFetchService extends smarteditcommons.ITranslationsFetchService {
    constructor(httpClient, promiseUtils) {
        super();
        this.httpClient = httpClient;
        this.promiseUtils = promiseUtils;
        this.ready = false;
    }
    get(lang) {
        return this.httpClient
            .get(`${smarteditcommons.RestServiceFactory.getGlobalBasePath()}${smarteditcommons.I18N_RESOURCE_URI}/${lang}`, {
            responseType: 'json'
        })
            .pipe(operators.map((result) => result.value
            ? result.value
            : result))
            .toPromise()
            .then((result) => {
            this.ready = true;
            return result;
        });
    }
    isReady() {
        return Promise.resolve(this.ready);
    }
    waitToBeReady() {
        return this.promiseUtils.resolveToCallbackWhenCondition(() => this.ready, () => {
            //
        });
    }
};
exports.TranslationsFetchService.$inject = ["httpClient", "promiseUtils"];
__decorate([
    smarteditcommons.Cached({ actions: [smarteditcommons.rarelyChangingContent] }),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [String]),
    __metadata("design:returntype", Promise)
], /* @ngInject */ exports.TranslationsFetchService.prototype, "get", null);
/* @ngInject */ exports.TranslationsFetchService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.ITranslationsFetchService),
    smarteditcommons.GatewayProxied()
    /*
     * this service, provider in SeTranslationModule, needs be accessible to root
     * so that when downgrading it to legacy usage it will be found in DI
     */
    ,
    core.Injectable({ providedIn: 'root' }),
    __metadata("design:paramtypes", [http.HttpClient, smarteditcommons.PromiseUtils])
], /* @ngInject */ exports.TranslationsFetchService);

var PERMISSION_TYPES;
(function (PERMISSION_TYPES) {
    PERMISSION_TYPES["READ"] = "read";
    PERMISSION_TYPES["WRITE"] = "write";
})(PERMISSION_TYPES || (PERMISSION_TYPES = {}));
let /* @ngInject */ CatalogVersionPermissionService = class /* @ngInject */ CatalogVersionPermissionService extends smarteditcommons.ICatalogVersionPermissionService {
    constructor(catalogVersionPermissionRestService, catalogService) {
        super();
        this.catalogVersionPermissionRestService = catalogVersionPermissionRestService;
        this.catalogService = catalogService;
    }
    hasPermission(accessType, catalogId, catalogVersion, siteId) {
        return __awaiter(this, void 0, void 0, function* () {
            const [shouldOverride, response] = yield Promise.all([
                this.shouldIgnoreCatalogPermissions(accessType, catalogId, catalogVersion, siteId),
                this.catalogVersionPermissionRestService.getCatalogVersionPermissions(catalogId, catalogVersion)
            ]);
            if (this.isCatalogVersionPermissionResponse(response)) {
                const targetPermission = response.permissions.find((permission) => permission.key === accessType);
                const value = targetPermission ? targetPermission.value : 'false';
                return value === 'true' || shouldOverride;
            }
            return false;
        });
    }
    hasSyncPermissionFromCurrentToActiveCatalogVersion() {
        return __awaiter(this, void 0, void 0, function* () {
            const data = yield this.catalogService.retrieveUriContext();
            return yield this.hasSyncPermissionToActiveCatalogVersion(data[smarteditcommons.CONTEXT_CATALOG], data[smarteditcommons.CONTEXT_CATALOG_VERSION]);
        });
    }
    hasSyncPermissionToActiveCatalogVersion(catalogId, catalogVersion) {
        return __awaiter(this, void 0, void 0, function* () {
            const targetCatalogVersion = yield this.catalogService.getActiveContentCatalogVersionByCatalogId(catalogId);
            return yield this.hasSyncPermission(catalogId, catalogVersion, targetCatalogVersion);
        });
    }
    hasSyncPermission(catalogId, sourceCatalogVersion, targetCatalogVersion) {
        return __awaiter(this, void 0, void 0, function* () {
            const response = yield this.catalogVersionPermissionRestService.getCatalogVersionPermissions(catalogId, sourceCatalogVersion);
            if (this.isCatalogVersionPermissionResponse(response) &&
                response.syncPermissions &&
                response.syncPermissions.length > 0) {
                const permission = response.syncPermissions.some((syncPermission) => syncPermission
                    ? syncPermission.canSynchronize === true &&
                        syncPermission.targetCatalogVersion === targetCatalogVersion
                    : false);
                return permission;
            }
            return false;
        });
    }
    hasWritePermissionOnCurrent() {
        return this.hasCurrentCatalogPermission(PERMISSION_TYPES.WRITE);
    }
    hasReadPermissionOnCurrent() {
        return this.hasCurrentCatalogPermission(PERMISSION_TYPES.READ);
    }
    hasWritePermission(catalogId, catalogVersion) {
        return this.hasPermission(PERMISSION_TYPES.WRITE, catalogId, catalogVersion);
    }
    hasReadPermission(catalogId, catalogVersion) {
        return this.hasPermission(PERMISSION_TYPES.READ, catalogId, catalogVersion);
    }
    /**
     * if in the context of an experience AND the catalogVersion is the active one, then permissions should be ignored in read mode
     */
    shouldIgnoreCatalogPermissions(accessType, catalogId, catalogVersion, siteId) {
        return __awaiter(this, void 0, void 0, function* () {
            const promise = siteId && accessType === PERMISSION_TYPES.READ
                ? this.catalogService.getActiveContentCatalogVersionByCatalogId(catalogId)
                : Promise.resolve();
            const versionCheckedAgainst = yield promise;
            return versionCheckedAgainst === catalogVersion;
        });
    }
    /**
     * Verifies whether current user has write or read permission for current catalog version.
     * @param {String} accessType
     */
    hasCurrentCatalogPermission(accessType) {
        return __awaiter(this, void 0, void 0, function* () {
            const data = yield this.catalogService.retrieveUriContext();
            return yield this.hasPermission(accessType, data[smarteditcommons.CONTEXT_CATALOG], data[smarteditcommons.CONTEXT_CATALOG_VERSION], data[smarteditcommons.CONTEXT_SITE_ID]);
        });
    }
    isCatalogVersionPermissionResponse(response) {
        return !lo.isEmpty(response);
    }
};
CatalogVersionPermissionService.$inject = ["catalogVersionPermissionRestService", "catalogService"];
/* @ngInject */ CatalogVersionPermissionService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.ICatalogVersionPermissionService),
    smarteditcommons.GatewayProxied('hasWritePermission', 'hasReadPermission', 'hasWritePermissionOnCurrent', 'hasReadPermissionOnCurrent'),
    __metadata("design:paramtypes", [CatalogVersionPermissionRestService,
        smarteditcommons.ICatalogService])
], /* @ngInject */ CatalogVersionPermissionService);

/**
 * Implementation of smarteditcommons' DropdownPopulatorInterface for language dropdown in
 * experience selector to populate the list of languages by making a REST call to retrieve the list of langauges for a given site.
 *
 */
let /* @ngInject */ PreviewDatalanguageDropdownPopulator = class /* @ngInject */ PreviewDatalanguageDropdownPopulator extends smarteditcommons.DropdownPopulatorInterface {
    constructor(languageService) {
        super(lo__namespace, languageService);
    }
    /**
     * Returns a promise resolving to a list of languages for a given Site ID (based on the selected catalog). The site Id is generated from the
     * selected catalog in the 'catalog' dropdown.
     */
    fetchAll(payload) {
        if (payload.model[payload.field.dependsOn]) {
            const siteUid = payload.model[payload.field.dependsOn].split('|')[0];
            return this.getLanguageDropdownChoices(siteUid, payload.search);
        }
        return Promise.resolve([]);
    }
    /** @internal */
    getLanguageDropdownChoices(siteUid, search) {
        return __awaiter(this, void 0, void 0, function* () {
            try {
                const languages = yield this.languageService.getLanguagesForSite(siteUid);
                let languagesDropdownChoices = languages.map(({ isocode, nativeName }) => {
                    const dropdownChoices = {};
                    dropdownChoices.id = isocode;
                    dropdownChoices.label = nativeName;
                    return dropdownChoices;
                });
                if (search) {
                    languagesDropdownChoices = languagesDropdownChoices.filter((language) => language.label.toUpperCase().indexOf(search.toUpperCase()) > -1);
                }
                return languagesDropdownChoices;
            }
            catch (e) {
                throw new Error(e);
            }
        });
    }
};
PreviewDatalanguageDropdownPopulator.$inject = ["languageService"];
/* @ngInject */ PreviewDatalanguageDropdownPopulator = __decorate([
    smarteditcommons.SeDowngradeService(),
    __metadata("design:paramtypes", [smarteditcommons.LanguageService])
], /* @ngInject */ PreviewDatalanguageDropdownPopulator);

/**
 * Implementation of DropdownPopulatorInterface for catalog dropdown in
 * experience selector to populate the list of catalogs by making a REST call to retrieve the sites and then the catalogs based on the site.
 */
let /* @ngInject */ PreviewDatapreviewCatalogDropdownPopulator = class /* @ngInject */ PreviewDatapreviewCatalogDropdownPopulator extends smarteditcommons.DropdownPopulatorInterface {
    constructor(catalogService, sharedDataService, l10nPipe, languageService) {
        super(lo__namespace, languageService);
        this.catalogService = catalogService;
        this.sharedDataService = sharedDataService;
        this.l10nPipe = l10nPipe;
    }
    /**
     *  Returns a promise resolving to a list of site - catalogs to be displayed in the experience selector.
     *
     */
    fetchAll(payload) {
        return this.initCatalogVersionDropdownChoices(payload.search);
    }
    /** @internal */
    initCatalogVersionDropdownChoices(search) {
        return __awaiter(this, void 0, void 0, function* () {
            try {
                const experience = (yield this.sharedDataService.get(smarteditcommons.EXPERIENCE_STORAGE_KEY));
                const siteDescriptor = experience.siteDescriptor;
                const dropdownChoices = yield this.getDropdownChoices(siteDescriptor, search);
                const ascDropdownChoices = lo.flatten(dropdownChoices)
                    .sort((e1, e2) => e1.label.localeCompare(e2.label));
                return ascDropdownChoices;
            }
            catch (e) {
                throw new Error(e);
            }
        });
    }
    /** @internal */
    getDropdownChoices(siteDescriptor, search) {
        return __awaiter(this, void 0, void 0, function* () {
            const catalogs = yield this.catalogService.getContentCatalogsForSite(siteDescriptor.uid);
            const optionPromises = lo.flatten(catalogs)
                .map((catalog) => this.getTranslatedCatalogVersionsOptions(siteDescriptor, catalog));
            const options = yield Promise.all(lo.flatten(optionPromises));
            return options.filter((option) => search ? option.label.toUpperCase().includes(search.toUpperCase()) : true);
        });
    }
    getTranslatedCatalogVersionsOptions(siteDescriptor, catalog) {
        return catalog.versions.map((catalogVersion) => __awaiter(this, void 0, void 0, function* () {
            const catalogName = yield this.l10nPipe
                .transform(catalog.name)
                .pipe(operators.take(1))
                .toPromise();
            return {
                id: `${siteDescriptor.uid}|${catalog.catalogId}|${catalogVersion.version}`,
                label: `${catalogName} - ${catalogVersion.version}`
            };
        }));
    }
};
PreviewDatapreviewCatalogDropdownPopulator.$inject = ["catalogService", "sharedDataService", "l10nPipe", "languageService"];
/* @ngInject */ PreviewDatapreviewCatalogDropdownPopulator = __decorate([
    smarteditcommons.SeDowngradeService(),
    __metadata("design:paramtypes", [smarteditcommons.ICatalogService,
        smarteditcommons.ISharedDataService,
        smarteditcommons.L10nPipe,
        smarteditcommons.LanguageService])
], /* @ngInject */ PreviewDatapreviewCatalogDropdownPopulator);

var /* @ngInject */ CatalogAwareRouteResolverHelper_1;
/**
 * Validates if user has permission on current catalog.
 *
 * Implemented by Route Guards.
 */
/* @ngInject */ exports.CatalogAwareRouteResolverHelper = /* @ngInject */ CatalogAwareRouteResolverHelper_1 = class /* @ngInject */ CatalogAwareRouteResolverHelper {
    constructor(logService, route, systemEventService, experienceService, sharedDataService, catalogVersionPermissionService) {
        this.logService = logService;
        this.route = route;
        this.systemEventService = systemEventService;
        this.experienceService = experienceService;
        this.sharedDataService = sharedDataService;
        this.catalogVersionPermissionService = catalogVersionPermissionService;
    }
    /**
     * @internal
     * @ignore
     *
     * Convert to instance method after 2105 deprecation period has been exceeded.
     */
    static executeAndCheckCatalogPermissions(catalogVersionPermissionService, logService, experienceService, systemEventService, operation) {
        return operation().then(() => catalogVersionPermissionService.hasReadPermissionOnCurrent().then((hasReadPermission) => {
            if (!hasReadPermission) {
                logService.info('no permission to access the storefront view with this experience');
                return Promise.reject();
            }
            return experienceService
                .hasCatalogVersionChanged()
                .then((hasCatalogVersionChanged) => {
                if (hasCatalogVersionChanged) {
                    systemEventService.publishAsync(smarteditcommons.EVENTS.EXPERIENCE_UPDATE);
                }
                return true;
            });
        }, () => {
            logService.info('failed to evaluate permissions to access the storefront view with this experience');
            return Promise.reject();
        }), (error) => {
            logService.error('could not retrieve experience from storage or route params', error);
            throw new Error(error);
        });
    }
    /**
     * @internal
     * @ignore
     */
    static checkExperienceIsSet(experienceService, sharedDataService) {
        return new Promise((resolve, reject) => {
            experienceService.getCurrentExperience().then((experience) => {
                if (!experience) {
                    return reject();
                }
                // next line to preserve in-memory features throughout the app
                sharedDataService.set(smarteditcommons.EXPERIENCE_STORAGE_KEY, experience);
                return resolve(experience);
            });
        });
    }
    /**
     * @internal
     * @ignore
     */
    static buildExperienceFromRoute(experienceService, params) {
        return experienceService.buildAndSetExperience(params).then((experience) => {
            if (!experience) {
                return Promise.reject();
            }
            return experience;
        });
    }
    /**
     * Checks presence of a stored experience.
     *
     * It will reject if the user doesn't have a read permission to the current catalog version.
     * Consumer can redirect current user to the Landing Page by handling the rejection.
     *
     * If the user has read permission for the catalog version then EVENTS.EXPERIENCE_UPDATE is sent, but only when the experience has been changed.
     */
    storefrontResolve() {
        return this.executeAndCheckCatalogPermissions(() => this.checkExperienceIsSet());
    }
    /**
     * Initializes new experience based on route params.
     *
     * It will reject if the user doesn't have a read permission to the current catalog version.
     * Consumer can redirect current user to the Landing Page by handling the rejection.
     *
     * If the user has read permission for the catalog version then EVENTS.EXPERIENCE_UPDATE is sent, but only when the experience has been changed.
     */
    experienceFromPathResolve(params) {
        return this.executeAndCheckCatalogPermissions(() => this.buildExperienceFromRoute(params));
    }
    /**
     * Runs operation that sets the experience and then resolves to true if the user has read permissions on current catalog.
     *
     * @internal
     * @ignore
     */
    executeAndCheckCatalogPermissions(operation) {
        return /* @ngInject */ CatalogAwareRouteResolverHelper_1.executeAndCheckCatalogPermissions(this.catalogVersionPermissionService, this.logService, this.experienceService, this.systemEventService, operation);
    }
    /**
     * Resolves with the existing experience if it is set, otherwise rejects.
     *
     * @internal
     * @ignore
     */
    checkExperienceIsSet() {
        return /* @ngInject */ CatalogAwareRouteResolverHelper_1.checkExperienceIsSet(this.experienceService, this.sharedDataService);
    }
    /**
     * Creates and sets an experience based on active route params.
     *
     * @internal
     * @ignore
     */
    buildExperienceFromRoute(params) {
        return /* @ngInject */ CatalogAwareRouteResolverHelper_1.buildExperienceFromRoute(this.experienceService, params || this.route.snapshot.params);
    }
};
/* @ngInject */ exports.CatalogAwareRouteResolverHelper = /* @ngInject */ CatalogAwareRouteResolverHelper_1 = __decorate([
    core.Injectable(),
    __metadata("design:paramtypes", [smarteditcommons.LogService,
        router.ActivatedRoute,
        smarteditcommons.SystemEventService,
        smarteditcommons.IExperienceService,
        smarteditcommons.ISharedDataService,
        smarteditcommons.ICatalogVersionPermissionService])
], /* @ngInject */ exports.CatalogAwareRouteResolverHelper);

/**
 * Guard that prevents unauthorized user from navigating to Storefront Page.
 *
 * @internal
 * @ignore
 */
let /* @ngInject */ StorefrontPageGuard = class /* @ngInject */ StorefrontPageGuard {
    constructor(catalogAwareResolverHelper, routing) {
        this.catalogAwareResolverHelper = catalogAwareResolverHelper;
        this.routing = routing;
    }
    /**
     * It will redirect current user to the Landing Page if the user doesn't have a read permission to the current catalog version.
     */
    canActivate() {
        return this.catalogAwareResolverHelper.storefrontResolve().catch(() => {
            this.routing.go(smarteditcommons.NG_ROUTE_PREFIX);
            return false;
        });
    }
};
StorefrontPageGuard.$inject = ["catalogAwareResolverHelper", "routing"];
/* @ngInject */ StorefrontPageGuard = __decorate([
    core.Injectable(),
    __metadata("design:paramtypes", [exports.CatalogAwareRouteResolverHelper,
        smarteditcommons.SmarteditRoutingService])
], /* @ngInject */ StorefrontPageGuard);

/**
 * The ProductService provides is used to access products from the product catalog
 */
/* @ngInject */ exports.ProductService = class /* @ngInject */ ProductService {
    constructor(restServiceFactory, languageService) {
        this.restServiceFactory = restServiceFactory;
        this.languageService = languageService;
        this.productService = this.restServiceFactory.get(smarteditcommons.PRODUCT_RESOURCE_API);
        this.productListService = this.restServiceFactory.get(smarteditcommons.PRODUCT_LIST_RESOURCE_API);
    }
    /**
     * Returns a list of Products from the catalog that match the given mask
     */
    findProducts(productSearch, pageable) {
        return __awaiter(this, void 0, void 0, function* () {
            this._validateProductCatalogInfo(productSearch);
            const langIsoCode = yield this.languageService.getResolveLocale();
            const list = yield this.productListService.get({
                catalogId: productSearch.catalogId,
                catalogVersion: productSearch.catalogVersion,
                text: pageable.mask,
                pageSize: pageable.pageSize,
                currentPage: pageable.currentPage,
                langIsoCode
            });
            return list;
        });
    }
    /**
     * Returns a Product that matches the given siteUID and productUID
     */
    getProductById(siteUID, productUID) {
        return this.productService.get({
            siteUID,
            productUID
        });
    }
    _validateProductCatalogInfo(productSearch) {
        if (!productSearch.catalogId) {
            throw new Error('[productService] - catalog ID missing.');
        }
        if (!productSearch.catalogVersion) {
            throw new Error('[productService] - catalog version missing.');
        }
    }
};
exports.ProductService.$inject = ["restServiceFactory", "languageService"];
__decorate([
    smarteditcommons.Cached({ actions: [smarteditcommons.rarelyChangingContent], tags: [smarteditcommons.userEvictionTag] }),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [Object, Object]),
    __metadata("design:returntype", Promise)
], /* @ngInject */ exports.ProductService.prototype, "findProducts", null);
/* @ngInject */ exports.ProductService = __decorate([
    smarteditcommons.SeDowngradeService(),
    __metadata("design:paramtypes", [smarteditcommons.RestServiceFactory,
        smarteditcommons.LanguageService])
], /* @ngInject */ exports.ProductService);

window.__smartedit__.addDecoratorPayload("Component", "ConfigurationModalComponent", {
    selector: 'se-configuration-modal',
    template: `<div id="editConfigurationsBody" class="se-config"><form #form="ngForm" novalidate><div class="se-config__sub-header"><span class="se-config__sub-title">{{'se.configurationform.label.keyvalue' | translate}}</span> <button class="se-config__add-entry-btn fd-button--compact" type="button" (click)="editor.addEntry()">{{ "se.general.configuration.add.button" | translate }}</button></div><div class="se-config__entry" *ngFor="let entry of editor.filterConfiguration(); let $index = index"><div class="se-config__entry-data"><div class="se-config__entry-key"><input type="text" [ngClass]="{
                            'is-invalid': entry.errors &&  entry.errors.keys && entry.errors.keys.length > 0,
                            'se-config__entry-key--disabled': !entry.isNew }" name="{{entry.key}}_{{entry.uuid}}_key" placeholder="{{'se.configurationform.header.key.name' | translate}}" [(ngModel)]="entry.key" [required]="true" [disabled]="!entry.isNew" class="se-config__entry-key-input fd-form__control" [title]="entry.key"/><ng-container *ngIf="entry.errors && entry.errors.keys"><span id="{{entry.key}}_error_{{$index}}" *ngFor="let error of entry.errors.keys; let $index = index" class="error-input help-block">{{error.message|translate}}</span></ng-container></div><div class="se-config__entry-value"><textarea [ngClass]="{'is-invalid': entry.errors && entry.errors.values && entry.errors.values.length>0}" name="{{entry.key}}_{{entry.uuid}}_value" placeholder="{{'se.configurationform.header.value.name' | translate}}" [(ngModel)]="entry.value" [required]="true" class="se-config__entry-text-area fd-form__control" (change)="editor.validateUserInput(entry)"></textarea><div *ngIf="entry.requiresUserCheck"><input id="{{entry.key}}_absoluteUrl_check_{{$index}}" type="checkbox" name="{{entry.key}}_{{entry.uuid}}_isCheckedByUser" [(ngModel)]="entry.isCheckedByUser"/> <span id="{{entry.key}}_absoluteUrl_msg_{{$index}}" [ngClass]="{
                                'warning-check-msg': true,
                                'not-checked': entry.hasErrors && !entry.isCheckedByUser
                            }">{{'se.configurationform.absoluteurl.check' | translate}}</span></div><ng-container *ngIf="entry.errors && entry.errors.values && entry.errors.values"><span id="{{entry.key}}_error_{{$index}}" *ngFor="let error of entry.errors.values; let $index = index" class="error-input help-block">{{error.message|translate}}</span></ng-container></div></div><button type="button" id="{{entry.key}}_removeButton_{{$index}}" class="se-config__entry-remove-btn fd-button--light sap-icon--delete" (click)="editor.removeEntry(entry, form);"></button></div></form></div>`
});
let ConfigurationModalComponent = class ConfigurationModalComponent {
    constructor(editor, modalManager, confirmationModalService) {
        this.editor = editor;
        this.modalManager = modalManager;
        this.confirmationModalService = confirmationModalService;
    }
    ngOnInit() {
        this.editor.init();
        this.form.statusChanges.subscribe(() => {
            if (this.form.valid && this.form.dirty) {
                this.modalManager.enableButton('save');
            }
            if (this.form.invalid || !this.form.dirty) {
                this.modalManager.disableButton('save');
            }
        });
        this.modalManager.addButtons([
            {
                id: 'save',
                style: smarteditcommons.ModalButtonStyle.Primary,
                label: 'se.cms.component.confirmation.modal.save',
                callback: () => rxjs.from(this.onSave()),
                disabled: true
            },
            {
                id: 'cancel',
                label: 'se.cms.component.confirmation.modal.cancel',
                style: smarteditcommons.ModalButtonStyle.Default,
                action: smarteditcommons.ModalButtonAction.Dismiss,
                callback: () => rxjs.from(this.onCancel())
            }
        ]);
    }
    trackByFn(_, item) {
        return item.uuid;
    }
    onCancel() {
        const { dirty } = this.form;
        const confirmationData = {
            description: 'se.editor.cancel.confirm'
        };
        if (!dirty) {
            return Promise.resolve();
        }
        return this.confirmationModalService
            .confirm(confirmationData)
            .then(() => this.modalManager.close(null));
    }
    onSave() {
        return this.editor.submit(this.form).then(() => {
            this.modalManager.close(null);
        });
    }
};
__decorate([
    core.ViewChild('form', { static: true }),
    __metadata("design:type", forms.NgForm)
], ConfigurationModalComponent.prototype, "form", void 0);
ConfigurationModalComponent = __decorate([
    core.Component({
        selector: 'se-configuration-modal',
        template: `<div id="editConfigurationsBody" class="se-config"><form #form="ngForm" novalidate><div class="se-config__sub-header"><span class="se-config__sub-title">{{'se.configurationform.label.keyvalue' | translate}}</span> <button class="se-config__add-entry-btn fd-button--compact" type="button" (click)="editor.addEntry()">{{ "se.general.configuration.add.button" | translate }}</button></div><div class="se-config__entry" *ngFor="let entry of editor.filterConfiguration(); let $index = index"><div class="se-config__entry-data"><div class="se-config__entry-key"><input type="text" [ngClass]="{
                            'is-invalid': entry.errors &&  entry.errors.keys && entry.errors.keys.length > 0,
                            'se-config__entry-key--disabled': !entry.isNew }" name="{{entry.key}}_{{entry.uuid}}_key" placeholder="{{'se.configurationform.header.key.name' | translate}}" [(ngModel)]="entry.key" [required]="true" [disabled]="!entry.isNew" class="se-config__entry-key-input fd-form__control" [title]="entry.key"/><ng-container *ngIf="entry.errors && entry.errors.keys"><span id="{{entry.key}}_error_{{$index}}" *ngFor="let error of entry.errors.keys; let $index = index" class="error-input help-block">{{error.message|translate}}</span></ng-container></div><div class="se-config__entry-value"><textarea [ngClass]="{'is-invalid': entry.errors && entry.errors.values && entry.errors.values.length>0}" name="{{entry.key}}_{{entry.uuid}}_value" placeholder="{{'se.configurationform.header.value.name' | translate}}" [(ngModel)]="entry.value" [required]="true" class="se-config__entry-text-area fd-form__control" (change)="editor.validateUserInput(entry)"></textarea><div *ngIf="entry.requiresUserCheck"><input id="{{entry.key}}_absoluteUrl_check_{{$index}}" type="checkbox" name="{{entry.key}}_{{entry.uuid}}_isCheckedByUser" [(ngModel)]="entry.isCheckedByUser"/> <span id="{{entry.key}}_absoluteUrl_msg_{{$index}}" [ngClass]="{
                                'warning-check-msg': true,
                                'not-checked': entry.hasErrors && !entry.isCheckedByUser
                            }">{{'se.configurationform.absoluteurl.check' | translate}}</span></div><ng-container *ngIf="entry.errors && entry.errors.values && entry.errors.values"><span id="{{entry.key}}_error_{{$index}}" *ngFor="let error of entry.errors.values; let $index = index" class="error-input help-block">{{error.message|translate}}</span></ng-container></div></div><button type="button" id="{{entry.key}}_removeButton_{{$index}}" class="se-config__entry-remove-btn fd-button--light sap-icon--delete" (click)="editor.removeEntry(entry, form);"></button></div></form></div>`
    }),
    __metadata("design:paramtypes", [ConfigurationService,
        smarteditcommons.ModalManagerService,
        smarteditcommons.IConfirmationModalService])
], ConfigurationModalComponent);

let /* @ngInject */ ConfigurationModalService = class /* @ngInject */ ConfigurationModalService {
    constructor(modalService) {
        this.modalService = modalService;
    }
    /*
     *The edit configuration method opens the modal for the configurations.
     */
    editConfiguration() {
        this.modalService.open({
            templateConfig: {
                title: 'se.modal.administration.configuration.edit.title'
            },
            component: ConfigurationModalComponent,
            config: {
                focusTrapped: false,
                backdropClickCloseable: false
            }
        });
    }
};
ConfigurationModalService.$inject = ["modalService"];
/* @ngInject */ ConfigurationModalService = __decorate([
    smarteditcommons.SeDowngradeService(),
    __metadata("design:paramtypes", [smarteditcommons.IModalService])
], /* @ngInject */ ConfigurationModalService);

let /* @ngInject */ PageTreeNodeService = class /* @ngInject */ PageTreeNodeService extends smarteditcommons.IPageTreeNodeService {
    constructor() {
        super();
    }
};
/* @ngInject */ PageTreeNodeService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IPageTreeNodeService),
    smarteditcommons.GatewayProxied('getSlotNodes', 'scrollToElement', 'existedSmartEditElement'),
    __metadata("design:paramtypes", [])
], /* @ngInject */ PageTreeNodeService);

let /* @ngInject */ PageTreeService = class /* @ngInject */ PageTreeService extends smarteditcommons.IPageTreeService {
    constructor() {
        super();
    }
    registerTreeComponent(item) {
        this.item = item;
        return Promise.resolve();
    }
    getTreeComponent() {
        return Promise.resolve(this.item);
    }
};
/* @ngInject */ PageTreeService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IPageTreeService),
    smarteditcommons.GatewayProxied('registerTreeComponent', 'getTreeComponent'),
    __metadata("design:paramtypes", [])
], /* @ngInject */ PageTreeService);

let SmarteditServicesModule = class SmarteditServicesModule {
};
SmarteditServicesModule = __decorate([
    core.NgModule({
        imports: [smarteditcommons.DragAndDropServiceModule, smarteditcommons.SmarteditCommonsModule, exports.AlertServiceModule],
        providers: [
            HeartBeatService,
            exports.BootstrapService,
            exports.ConfigurationExtractorService,
            exports.DelegateRestService,
            smarteditcommons.RestServiceFactory,
            ConfigurationService,
            ConfigurationModalService,
            PreviewDatalanguageDropdownPopulator,
            PreviewDatapreviewCatalogDropdownPopulator,
            CatalogVersionPermissionRestService,
            CatalogVersionPermissionService,
            exports.CatalogAwareRouteResolverHelper,
            StorefrontPageGuard,
            smarteditcommons.SmarteditRoutingService,
            smarteditcommons.UserTrackingService,
            {
                provide: smarteditcommons.ICatalogVersionPermissionService,
                useClass: CatalogVersionPermissionService
            },
            { provide: smarteditcommons.IPermissionService, useClass: PermissionService },
            { provide: smarteditcommons.IPageInfoService, useClass: PageInfoService },
            {
                provide: smarteditcommons.IRestServiceFactory,
                useClass: smarteditcommons.RestServiceFactory
            },
            {
                provide: smarteditcommons.IRenderService,
                useClass: RenderService
            },
            {
                provide: smarteditcommons.IAnnouncementService,
                useClass: AnnouncementService
            },
            {
                provide: smarteditcommons.IPerspectiveService,
                useClass: PerspectiveService
            },
            {
                provide: smarteditcommons.IFeatureService,
                useClass: FeatureService
            },
            {
                provide: smarteditcommons.INotificationMouseLeaveDetectionService,
                useClass: NotificationMouseLeaveDetectionService
            },
            {
                provide: smarteditcommons.IWaitDialogService,
                useClass: WaitDialogService
            },
            {
                provide: smarteditcommons.IPreviewService,
                useClass: PreviewService
            },
            {
                provide: smarteditcommons.IDragAndDropCrossOrigin,
                useClass: DragAndDropCrossOrigin
            },
            PermissionsRegistrationService,
            {
                provide: smarteditcommons.INotificationService,
                useClass: NotificationService
            },
            {
                provide: smarteditcommons.IPageTreeNodeService,
                useClass: PageTreeNodeService
            },
            {
                provide: smarteditcommons.IPageTreeService,
                useClass: PageTreeService
            },
            exports.ProductService,
            smarteditcommons.moduleUtils.initialize((previewService) => {
                //
            }, [smarteditcommons.IPreviewService])
        ]
    })
], SmarteditServicesModule);

/**
 * **Deprecated since 2005, use {@link FilterByFieldPipe}**.
 *
 * @deprecated
 */
let FilterByFieldFilter = class FilterByFieldFilter {
    static transform() {
        return (items, query, keys, callbackFcn) => smarteditcommons.FilterByFieldPipe.transform(items, query, keys, callbackFcn);
    }
};
FilterByFieldFilter = __decorate([
    smarteditcommons.SeFilter()
], FilterByFieldFilter);

/**
 * Service used to open a confirmation modal in which an end-user can confirm or cancel an action.
 * A confirmation modal consists of a title, content, and an OK and cancel button. This modal may be used in any context in which a
 * confirmation is required.
 */
let /* @ngInject */ ConfirmationModalService = class /* @ngInject */ ConfirmationModalService extends smarteditcommons.IConfirmationModalService {
    constructor(modalService) {
        super();
        this.modalService = modalService;
    }
    /**
     * Uses the [ModalService]{@link IModalService} to open a confirmation modal.
     *
     * The confirmation modal is initialized by a default i18N key as a title or by an override title passed in configuration.
     *
     * @returns A promise that is resolved when the OK button is actioned or is rejected when the Cancel
     * button is actioned.
     */
    confirm(configuration) {
        const ref = this.modalService.open({
            component: smarteditcommons.ConfirmDialogComponent,
            data: configuration,
            config: {
                focusTrapped: false,
                modalPanelClass: 'se-confirmation-dialog',
                // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
                container: document.querySelector('[uib-modal-window]') || 'body'
            },
            templateConfig: {
                title: configuration.title || 'se.confirmation.modal.title',
                buttons: this.getButtons(configuration),
                isDismissButtonVisible: true
            }
        });
        // it always rejects with undefined, no matter what value you pass (due to handling rejection in MessageGateway)
        return new Promise((resolve, reject) => ref.afterClosed.subscribe(resolve, reject));
    }
    getButtons(configuration) {
        return [
            {
                id: 'confirmOk',
                label: 'se.confirmation.modal.ok',
                style: smarteditcommons.ModalButtonStyle.Primary,
                action: smarteditcommons.ModalButtonAction.Close,
                callback: () => rxjs.of(true)
            },
            !configuration.showOkButtonOnly && {
                id: 'confirmCancel',
                label: 'se.confirmation.modal.cancel',
                style: smarteditcommons.ModalButtonStyle.Default,
                action: smarteditcommons.ModalButtonAction.Dismiss,
                callback: () => rxjs.of(false)
            }
        ].filter((x) => !!x);
    }
};
ConfirmationModalService.$inject = ["modalService"];
/* @ngInject */ ConfirmationModalService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IConfirmationModalService),
    smarteditcommons.GatewayProxied('confirm'),
    __metadata("design:paramtypes", [smarteditcommons.IModalService])
], /* @ngInject */ ConfirmationModalService);

/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
class ToolbarService extends smarteditcommons.IToolbarService {
    constructor(gatewayId, gatewayProxy, logService, $templateCache, permissionService) {
        super(logService, $templateCache, permissionService);
        this.gatewayId = gatewayId;
        this.onAliasesChange = null;
        gatewayProxy.initForService(this, [
            'addAliases',
            'removeItemByKey',
            'removeAliasByKey',
            '_removeItemOnInner',
            'triggerActionOnInner'
        ]);
    }
    addAliases(aliases) {
        this.aliases = this.aliases.map((alias) => this.get(aliases, alias) || alias);
        this.aliases = [
            ...(this.aliases || []),
            ...(aliases || []).filter((alias) => !this.get(this.aliases, alias))
        ];
        this.aliases = this.sortAliases(this.aliases);
        if (this.onAliasesChange) {
            this.onAliasesChange(this.aliases);
        }
    }
    /**
     * This method removes the action and the aliases of the toolbar item identified by
     * the provided key.
     *
     * @param itemKey - Identifier of the toolbar item to remove.
     */
    removeItemByKey(itemKey) {
        if (itemKey in this.actions) {
            delete this.actions[itemKey];
        }
        else {
            this._removeItemOnInner(itemKey);
        }
        this.removeAliasByKey(itemKey);
    }
    removeAliasByKey(itemKey) {
        let aliasIndex = 0;
        for (; aliasIndex < this.aliases.length; aliasIndex++) {
            if (this.aliases[aliasIndex].key === itemKey) {
                break;
            }
        }
        if (aliasIndex < this.aliases.length) {
            this.aliases.splice(aliasIndex, 1);
        }
        if (this.onAliasesChange) {
            this.onAliasesChange(this.aliases);
        }
    }
    setOnAliasesChange(onAliasesChange) {
        this.onAliasesChange = onAliasesChange;
    }
    triggerAction(action) {
        if (action && this.actions[action.key]) {
            this.actions[action.key].call(action);
            return;
        }
        this.triggerActionOnInner(action);
    }
    get(aliases, alias) {
        return aliases.find(({ key }) => key === alias.key);
    }
    sortAliases(aliases) {
        let samePriority = false;
        let warning = 'In ' + this.gatewayId + ' the items ';
        let _section = null;
        const result = [...(aliases || [])].sort((a, b) => {
            if (a.priority === b.priority && a.section === b.section) {
                _section = a.section;
                warning += a.key + ' and ' + b.key + ' ';
                samePriority = true;
                return a.key > b.key ? 1 : -1; // or the opposite ?
            }
            return a.priority - b.priority;
        });
        if (samePriority) {
            this.logService.warn('WARNING: ' + warning + 'have the same priority withing section:' + _section);
        }
        return result;
    }
}

let /* @ngInject */ ToolbarServiceFactory = class /* @ngInject */ ToolbarServiceFactory {
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
ToolbarServiceFactory.$inject = ["gatewayProxy", "logService", "lazy", "permissionService"];
/* @ngInject */ ToolbarServiceFactory = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.IToolbarServiceFactory),
    __metadata("design:paramtypes", [smarteditcommons.GatewayProxy,
        smarteditcommons.LogService,
        smarteditcommons.AngularJSLazyDependenciesService,
        smarteditcommons.IPermissionService])
], /* @ngInject */ ToolbarServiceFactory);

var /* @ngInject */ ToolbarComponent_1;
window.__smartedit__.addDecoratorPayload("Component", "ToolbarComponent", {
    selector: 'se-toolbar',
    template: `<div class="se-toolbar" [ngClass]="cssClass"><div class="se-toolbar__left"><div *ngFor="let item of aliases | seProperty:{section:'left'}; trackBy: trackByFn" class="se-template-toolbar se-template-toolbar__left {{item.className}}"><se-toolbar-section-item [item]="item"></se-toolbar-section-item></div></div><div class="se-toolbar__middle"><div *ngFor="let item of aliases | seProperty:{section:'middle'}; trackBy: trackByFn" class="se-template-toolbar se-template-toolbar__middle {{item.className}}"><se-toolbar-section-item [item]="item"></se-toolbar-section-item></div></div><div class="se-toolbar__right"><div *ngFor="let item of aliases | seProperty:{section:'right'}; trackBy: trackByFn" class="se-template-toolbar se-template-toolbar__right {{item.className}}"><se-toolbar-section-item [item]="item"></se-toolbar-section-item></div></div></div>`
});
let /* @ngInject */ ToolbarComponent = /* @ngInject */ ToolbarComponent_1 = class /* @ngInject */ ToolbarComponent {
    constructor(toolbarServiceFactory, iframeClickDetectionService, systemEventService, injector, cdr, routingService, userTrackingService) {
        this.toolbarServiceFactory = toolbarServiceFactory;
        this.iframeClickDetectionService = iframeClickDetectionService;
        this.systemEventService = systemEventService;
        this.injector = injector;
        this.cdr = cdr;
        this.routingService = routingService;
        this.userTrackingService = userTrackingService;
        this.imageRoot = '';
        this.aliases = [];
        this.unregCloseActions = null;
        this.unregCloseAll = null;
        this.unregRecalcPermissions = null;
    }
    ngOnInit() {
        this.setup();
    }
    ngOnDestroy() {
        var _a, _b, _c;
        (_a = this.unregCloseActions) === null || _a === void 0 ? void 0 : _a.call(this);
        (_b = this.unregCloseAll) === null || _b === void 0 ? void 0 : _b.call(this);
        (_c = this.unregRecalcPermissions) === null || _c === void 0 ? void 0 : _c.call(this);
    }
    triggerAction(action, $event) {
        $event.preventDefault();
        this.userTrackingService.trackingUserAction(smarteditcommons.USER_TRACKING_FUNCTIONALITY.TOOL_BAR, action.key);
        this.toolbarService.triggerAction(action);
    }
    getItemVisibility(item) {
        return item.component && (item.isOpen || item.keepAliveOnClose);
    }
    isOnStorefront() {
        return this.routingService.absUrl().includes(smarteditcommons.STORE_FRONT_CONTEXT);
    }
    createInjector(item) {
        return core.Injector.create({
            parent: this.injector,
            providers: [
                {
                    provide: smarteditcommons.TOOLBAR_ITEM,
                    useValue: item
                }
            ]
        });
    }
    trackByFn(_, item) {
        return item.key;
    }
    closeAllActionItems() {
        this.aliases.forEach((alias) => {
            alias.isOpen = false;
        });
    }
    populatePermissions() {
        return __awaiter(this, void 0, void 0, function* () {
            const promises = this.aliases.map((alias) => this.toolbarService._populateIsPermissionGranted(alias));
            this.aliases = yield Promise.all(promises);
        });
    }
    setup() {
        this.buildAliases();
        this.populatePermissions();
        this.registerCallbacks();
    }
    buildAliases() {
        this.toolbarService = this.toolbarServiceFactory.getToolbarService(this.toolbarName);
        this.toolbarService.setOnAliasesChange((aliases) => {
            this.aliases = aliases;
            if (!this.cdr.destroyed) {
                this.cdr.detectChanges();
            }
        });
        this.aliases = this.toolbarService.getAliases();
    }
    registerCallbacks() {
        this.unregCloseActions = this.iframeClickDetectionService.registerCallback(/* @ngInject */ ToolbarComponent_1.CLOSE_ALL_ACTION_ITEMS + this.toolbarName, () => this.closeAllActionItems());
        this.unregCloseAll = this.systemEventService.subscribe(smarteditcommons.EVENTS.PAGE_SELECTED, () => this.closeAllActionItems());
        this.unregRecalcPermissions = this.systemEventService.subscribe(smarteditcommons.EVENTS.PERMISSION_CACHE_CLEANED, () => this.populatePermissions());
    }
};
/* @ngInject */ ToolbarComponent.CLOSE_ALL_ACTION_ITEMS = 'closeAllActionItems';
__decorate([
    core.Input(),
    __metadata("design:type", String)
], /* @ngInject */ ToolbarComponent.prototype, "cssClass", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", String)
], /* @ngInject */ ToolbarComponent.prototype, "toolbarName", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ ToolbarComponent.prototype, "imageRoot", void 0);
/* @ngInject */ ToolbarComponent = /* @ngInject */ ToolbarComponent_1 = __decorate([
    smarteditcommons.SeDowngradeComponent(),
    core.Component({
        selector: 'se-toolbar',
        template: `<div class="se-toolbar" [ngClass]="cssClass"><div class="se-toolbar__left"><div *ngFor="let item of aliases | seProperty:{section:'left'}; trackBy: trackByFn" class="se-template-toolbar se-template-toolbar__left {{item.className}}"><se-toolbar-section-item [item]="item"></se-toolbar-section-item></div></div><div class="se-toolbar__middle"><div *ngFor="let item of aliases | seProperty:{section:'middle'}; trackBy: trackByFn" class="se-template-toolbar se-template-toolbar__middle {{item.className}}"><se-toolbar-section-item [item]="item"></se-toolbar-section-item></div></div><div class="se-toolbar__right"><div *ngFor="let item of aliases | seProperty:{section:'right'}; trackBy: trackByFn" class="se-template-toolbar se-template-toolbar__right {{item.className}}"><se-toolbar-section-item [item]="item"></se-toolbar-section-item></div></div></div>`
    }),
    __metadata("design:paramtypes", [smarteditcommons.IToolbarServiceFactory,
        smarteditcommons.IIframeClickDetectionService,
        smarteditcommons.SystemEventService,
        core.Injector,
        core.ChangeDetectorRef,
        smarteditcommons.SmarteditRoutingService,
        smarteditcommons.UserTrackingService])
], /* @ngInject */ ToolbarComponent);

window.__smartedit__.addDecoratorPayload("Component", "ToolbarActionComponent", {
    selector: 'se-toolbar-action',
    template: `<div *ngIf="item.isPermissionGranted"><div *ngIf="item.type == type.ACTION" class="toolbar-action"><button type="button" [ngClass]="{
                'toolbar-action--button--compact': isCompact,
                'toolbar-action--button': !isCompact
            }" class="btn" (click)="toolbar.triggerAction(item, $event)" [attr.aria-pressed]="false" [attr.aria-haspopup]="true" [attr.aria-expanded]="false" id="{{toolbar.toolbarName}}_option_{{item.key}}_btn"><span *ngIf="item.iconClassName" id="{{toolbar.toolbarName}}_option_{{item.key}}_btn_iconclass" class="{{item.iconClassName}}" [ngClass]="{ 'se-toolbar-actions__icon': isCompact }"></span> <img *ngIf="!item.iconClassName && item.icons" id="{{toolbar.toolbarName}}_option_{{item.key}}" src="{{toolbar.imageRoot}}{{item.icons[0]}}" class="file" title="{{item.name | translate}}" alt="{{item.name | translate}}"/> <span *ngIf="!isCompact" class="toolbar-action-button__txt" id="{{toolbar.toolbarName}}_option_{{item.key}}_btn_lbl">{{item.name | translate}}</span></button></div><fd-popover class="se-toolbar-action__wrapper toolbar-action toolbar-action--hybrid" *ngIf="item.type === type.HYBRID_ACTION" [attr.data-item-key]="item.key" [triggers]="['click']" [noArrow]="false" [isOpen]="item.isOpen" [closeOnOutsideClick]="false" (isOpenChange)="onOpenChange()" [placement]="placement" seClickOutside (clickOutside)="onOutsideClicked()"><fd-popover-control><button *ngIf="item.iconClassName || item.icons" type="button" class="btn" [ngClass]="{
                    'toolbar-action--button--compact': isCompact,
                    'toolbar-action--button': !isCompact
                }" [disabled]="disabled" [attr.aria-pressed]="false " (click)="toolbar.triggerAction(item, $event)"><span *ngIf="item.iconClassName" class="{{item.iconClassName}}" [ngClass]="{ 'se-toolbar-actions__icon': isCompact }"></span> <img *ngIf="!item.iconClassName && item.icons" id="{{toolbar.toolbarName}}_option_{{item.key}}" src="{{toolbar.imageRoot}}{{item.icons[0]}}" class="file" title="{{item.name | translate}}" alt="{{item.name | translate}}"/> <span *ngIf="!isCompact" class="toolbar-action-button__txt">{{item.name | translate}}</span></button></fd-popover-control><fd-popover-body class="se-toolbar-action__body" [ngClass]="{
                'toolbar-action--include--compact': isCompact,
                'toolbar-action--include': !isCompact
              
            }"><se-prevent-vertical-overflow><ng-container *ngIf="toolbar.getItemVisibility(item) && item.component"><ng-container *ngComponentOutlet="item.component; injector: actionInjector"></ng-container></ng-container></se-prevent-vertical-overflow></fd-popover-body></fd-popover></div>`
});
let ToolbarActionComponent = class ToolbarActionComponent {
    constructor(toolbar) {
        this.toolbar = toolbar;
        this.type = smarteditcommons.ToolbarItemType;
    }
    ngOnInit() {
        this.setup();
    }
    ngOnChanges(changes) {
        if (changes.item) {
            this.setup();
        }
    }
    get isCompact() {
        return this.item.actionButtonFormat === 'compact';
    }
    get placement() {
        if (this.item.section === smarteditcommons.ToolbarSection.left ||
            this.item.section === smarteditcommons.ToolbarSection.middle) {
            return 'bottom-start';
        }
        else if (this.item.section === smarteditcommons.ToolbarSection.right) {
            return 'bottom-end';
        }
        switch (this.item.dropdownPosition) {
            case smarteditcommons.ToolbarDropDownPosition.left:
                return 'bottom-start';
            case smarteditcommons.ToolbarDropDownPosition.right:
                return 'bottom-end';
            default:
                return 'bottom';
        }
    }
    onOutsideClicked() {
        this.item.isOpen = false;
    }
    onOpenChange() {
        this.item.isOpen = !this.item.isOpen;
    }
    setup() {
        this.actionInjector = this.toolbar.createInjector(this.item);
    }
};
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], ToolbarActionComponent.prototype, "item", void 0);
ToolbarActionComponent = __decorate([
    core.Component({
        selector: 'se-toolbar-action',
        template: `<div *ngIf="item.isPermissionGranted"><div *ngIf="item.type == type.ACTION" class="toolbar-action"><button type="button" [ngClass]="{
                'toolbar-action--button--compact': isCompact,
                'toolbar-action--button': !isCompact
            }" class="btn" (click)="toolbar.triggerAction(item, $event)" [attr.aria-pressed]="false" [attr.aria-haspopup]="true" [attr.aria-expanded]="false" id="{{toolbar.toolbarName}}_option_{{item.key}}_btn"><span *ngIf="item.iconClassName" id="{{toolbar.toolbarName}}_option_{{item.key}}_btn_iconclass" class="{{item.iconClassName}}" [ngClass]="{ 'se-toolbar-actions__icon': isCompact }"></span> <img *ngIf="!item.iconClassName && item.icons" id="{{toolbar.toolbarName}}_option_{{item.key}}" src="{{toolbar.imageRoot}}{{item.icons[0]}}" class="file" title="{{item.name | translate}}" alt="{{item.name | translate}}"/> <span *ngIf="!isCompact" class="toolbar-action-button__txt" id="{{toolbar.toolbarName}}_option_{{item.key}}_btn_lbl">{{item.name | translate}}</span></button></div><fd-popover class="se-toolbar-action__wrapper toolbar-action toolbar-action--hybrid" *ngIf="item.type === type.HYBRID_ACTION" [attr.data-item-key]="item.key" [triggers]="['click']" [noArrow]="false" [isOpen]="item.isOpen" [closeOnOutsideClick]="false" (isOpenChange)="onOpenChange()" [placement]="placement" seClickOutside (clickOutside)="onOutsideClicked()"><fd-popover-control><button *ngIf="item.iconClassName || item.icons" type="button" class="btn" [ngClass]="{
                    'toolbar-action--button--compact': isCompact,
                    'toolbar-action--button': !isCompact
                }" [disabled]="disabled" [attr.aria-pressed]="false " (click)="toolbar.triggerAction(item, $event)"><span *ngIf="item.iconClassName" class="{{item.iconClassName}}" [ngClass]="{ 'se-toolbar-actions__icon': isCompact }"></span> <img *ngIf="!item.iconClassName && item.icons" id="{{toolbar.toolbarName}}_option_{{item.key}}" src="{{toolbar.imageRoot}}{{item.icons[0]}}" class="file" title="{{item.name | translate}}" alt="{{item.name | translate}}"/> <span *ngIf="!isCompact" class="toolbar-action-button__txt">{{item.name | translate}}</span></button></fd-popover-control><fd-popover-body class="se-toolbar-action__body" [ngClass]="{
                'toolbar-action--include--compact': isCompact,
                'toolbar-action--include': !isCompact
              
            }"><se-prevent-vertical-overflow><ng-container *ngIf="toolbar.getItemVisibility(item) && item.component"><ng-container *ngComponentOutlet="item.component; injector: actionInjector"></ng-container></ng-container></se-prevent-vertical-overflow></fd-popover-body></fd-popover></div>`
    }),
    __param(0, core.Inject(core.forwardRef(() => ToolbarComponent))),
    __metadata("design:paramtypes", [ToolbarComponent])
], ToolbarActionComponent);

window.__smartedit__.addDecoratorPayload("Component", "ToolbarActionOutletComponent", {
    selector: 'se-toolbar-action-outlet',
    template: `
        <div
            class="se-template-toolbar__action-template"
            [ngClass]="{
                'se-toolbar-action': isSectionRight,
                'se-toolbar-action--active': isSectionRight && isPermitionGranted
            }"
        >
            <ng-container *ngIf="item.component && item.type === type.TEMPLATE">
                <ng-container
                    *ngComponentOutlet="item.component; injector: actionInjector"
                ></ng-container>
            </ng-container>

            <!--ACTION and HYBRID_ACTION types-->

            <div *ngIf="item.type !== type.TEMPLATE">
                <se-toolbar-action [item]="item"></se-toolbar-action>
            </div>
        </div>
    `
});
/** @internal  */
let ToolbarActionOutletComponent = class ToolbarActionOutletComponent {
    constructor(toolbar) {
        this.toolbar = toolbar;
        this.type = smarteditcommons.ToolbarItemType;
    }
    ngOnInit() {
        this.setup();
    }
    ngOnChanges(changes) {
        if (changes.item) {
            this.setup();
        }
    }
    get isSectionRight() {
        return this.item.section === smarteditcommons.ToolbarSection.right;
    }
    get isPermitionGranted() {
        return this.item.isPermissionGranted;
    }
    setup() {
        this.actionInjector = this.toolbar.createInjector(this.item);
    }
};
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], ToolbarActionOutletComponent.prototype, "item", void 0);
ToolbarActionOutletComponent = __decorate([
    core.Component({
        selector: 'se-toolbar-action-outlet',
        template: `
        <div
            class="se-template-toolbar__action-template"
            [ngClass]="{
                'se-toolbar-action': isSectionRight,
                'se-toolbar-action--active': isSectionRight && isPermitionGranted
            }"
        >
            <ng-container *ngIf="item.component && item.type === type.TEMPLATE">
                <ng-container
                    *ngComponentOutlet="item.component; injector: actionInjector"
                ></ng-container>
            </ng-container>

            <!--ACTION and HYBRID_ACTION types-->

            <div *ngIf="item.type !== type.TEMPLATE">
                <se-toolbar-action [item]="item"></se-toolbar-action>
            </div>
        </div>
    `
    }),
    __param(0, core.Inject(core.forwardRef(() => ToolbarComponent))),
    __metadata("design:paramtypes", [ToolbarComponent])
], ToolbarActionOutletComponent);

window.__smartedit__.addDecoratorPayload("Component", "ToolbarItemContextComponent", {
    selector: 'se-toolbar-item-context',
    template: `
        <div
            *ngIf="displayContext"
            id="toolbar_item_context_{{ itemKey }}_btn"
            class="se-toolbar-actionable-item-context"
            [ngClass]="{ 'se-toolbar-actionable-item-context--open': isOpen }"
        >
            <div *ngIf="contextComponent" class="se-toolbar-actionable-context__btn">
                <ng-container *ngComponentOutlet="contextComponent"></ng-container>
            </div>
        </div>
    `
});
/** @internal  */
let ToolbarItemContextComponent = class ToolbarItemContextComponent {
    constructor(crossFrameEventService) {
        this.crossFrameEventService = crossFrameEventService;
        this.displayContext = false;
    }
    ngOnInit() {
        this.registerCallbacks();
    }
    ngOnDestroy() {
        this.unregShowContext();
        this.unregHideContext();
    }
    showContext(show) {
        this.displayContext = show;
    }
    registerCallbacks() {
        this.unregShowContext = this.crossFrameEventService.subscribe(smarteditcommons.SHOW_TOOLBAR_ITEM_CONTEXT, (eventId, itemKey) => {
            if (itemKey === this.itemKey) {
                this.showContext(true);
            }
        });
        this.unregHideContext = this.crossFrameEventService.subscribe(smarteditcommons.HIDE_TOOLBAR_ITEM_CONTEXT, (eventId, itemKey) => {
            if (itemKey === this.itemKey) {
                this.showContext(false);
            }
        });
    }
};
__decorate([
    core.Input(),
    __metadata("design:type", String)
], ToolbarItemContextComponent.prototype, "itemKey", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Boolean)
], ToolbarItemContextComponent.prototype, "isOpen", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", core.Type)
], ToolbarItemContextComponent.prototype, "contextComponent", void 0);
ToolbarItemContextComponent = __decorate([
    core.Component({
        selector: 'se-toolbar-item-context',
        template: `
        <div
            *ngIf="displayContext"
            id="toolbar_item_context_{{ itemKey }}_btn"
            class="se-toolbar-actionable-item-context"
            [ngClass]="{ 'se-toolbar-actionable-item-context--open': isOpen }"
        >
            <div *ngIf="contextComponent" class="se-toolbar-actionable-context__btn">
                <ng-container *ngComponentOutlet="contextComponent"></ng-container>
            </div>
        </div>
    `
    }),
    __param(0, core.Inject(smarteditcommons.EVENT_SERVICE)),
    __metadata("design:paramtypes", [smarteditcommons.CrossFrameEventService])
], ToolbarItemContextComponent);

window.__smartedit__.addDecoratorPayload("Component", "ToolbarSectionItemComponent", {
    selector: 'se-toolbar-section-item',
    host: {
        class: 'se-toolbar-section-item'
    },
    template: `
        <se-toolbar-action-outlet [item]="item"></se-toolbar-action-outlet>
        <se-toolbar-item-context
            *ngIf="item.contextComponent"
            class="se-template-toolbar__context-template"
            [attr.data-item-key]="item.key"
            [itemKey]="item.key"
            [isOpen]="item.isOpen"
            [contextComponent]="item.contextComponent"
        ></se-toolbar-item-context>
    `
});
/** @internal  */
let ToolbarSectionItemComponent = class ToolbarSectionItemComponent {
};
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], ToolbarSectionItemComponent.prototype, "item", void 0);
ToolbarSectionItemComponent = __decorate([
    core.Component({
        selector: 'se-toolbar-section-item',
        host: {
            class: 'se-toolbar-section-item'
        },
        template: `
        <se-toolbar-action-outlet [item]="item"></se-toolbar-action-outlet>
        <se-toolbar-item-context
            *ngIf="item.contextComponent"
            class="se-template-toolbar__context-template"
            [attr.data-item-key]="item.key"
            [itemKey]="item.key"
            [isOpen]="item.isOpen"
            [contextComponent]="item.contextComponent"
        ></se-toolbar-item-context>
    `
    })
], ToolbarSectionItemComponent);

window.__smartedit__.addDecoratorPayload("Component", "DeviceSupportWrapperComponent", {
    selector: 'se-device-support-wrapper',
    template: `
        <inflection-point-selector
            *ngIf="toolbar.isOnStorefront()"
            class="toolbar-action"
        ></inflection-point-selector>
    `
});
let DeviceSupportWrapperComponent = class DeviceSupportWrapperComponent {
    constructor(toolbar) {
        this.toolbar = toolbar;
    }
};
DeviceSupportWrapperComponent = __decorate([
    core.Component({
        selector: 'se-device-support-wrapper',
        template: `
        <inflection-point-selector
            *ngIf="toolbar.isOnStorefront()"
            class="toolbar-action"
        ></inflection-point-selector>
    `
    }),
    __param(0, core.Inject(core.forwardRef(() => ToolbarComponent))),
    __metadata("design:paramtypes", [ToolbarComponent])
], DeviceSupportWrapperComponent);

window.__smartedit__.addDecoratorPayload("Component", "ExperienceSelectorButtonComponent", {
    selector: 'se-experience-selector-button',
    template: `<fd-popover class="se-experience-selector" [(isOpen)]="status.isOpen" (isOpenChange)="resetExperienceSelector()" [closeOnOutsideClick]="false" [triggers]="['click']" [placement]="'bottom-end'"><fd-popover-control><div class="se-experience-selector__control"><se-tooltip [placement]="'bottom'" [triggers]="['mouseenter', 'mouseleave']" *ngIf="isCurrentPageFromParent" class="se-experience-selector__tooltip"><span se-tooltip-trigger class="se-experience-selector__btn--globe"><span class="hyicon hyicon-globe se-experience-selector__btn--globe--icon"></span></span><div se-tooltip-body>{{ parentCatalogVersion }}</div></se-tooltip><button class="se-experience-selector__btn" id="experience-selector-btn"><span [attr.title]="experienceText" class="se-experience-selector__btn-text se-nowrap-ellipsis">{{ experienceText }} </span><span class="se-experience-selector__btn-arrow icon-navigation-down-arrow"></span></button></div></fd-popover-control><fd-popover-body><div class="se-experience-selector__dropdown fd-modal fd-modal__content" role="menu"><se-experience-selector [experience]="experience" [dropdownStatus]="status" [(resetExperienceSelector)]="resetExperienceSelector"></se-experience-selector></div></fd-popover-body></fd-popover>`,
    providers: [smarteditcommons.L10nPipe]
});
let /* @ngInject */ ExperienceSelectorButtonComponent = class /* @ngInject */ ExperienceSelectorButtonComponent {
    constructor(systemEventService, crossFrameEventService, locale, sharedDataService, l10nPipe) {
        this.systemEventService = systemEventService;
        this.crossFrameEventService = crossFrameEventService;
        this.locale = locale;
        this.sharedDataService = sharedDataService;
        this.l10nPipe = l10nPipe;
        this.status = { isOpen: false };
        this.isCurrentPageFromParent = false;
    }
    ngOnInit() {
        return __awaiter(this, void 0, void 0, function* () {
            yield this.updateExperience();
            yield this.setExperienceText();
            this.unregFn = this.systemEventService.subscribe(smarteditcommons.EVENTS.EXPERIENCE_UPDATE, () => __awaiter(this, void 0, void 0, function* () {
                yield this.updateExperience();
                yield this.setExperienceText();
            }));
            this.unRegNewPageContextEventFn = this.crossFrameEventService.subscribe(smarteditcommons.EVENTS.PAGE_CHANGE, (eventId, data) => {
                this.setPageFromParent(data);
            });
        });
    }
    ngOnDestroy() {
        this.unregFn();
        this.unRegNewPageContextEventFn();
    }
    updateExperience() {
        return __awaiter(this, void 0, void 0, function* () {
            this.experience = (yield this.sharedDataService.get(smarteditcommons.EXPERIENCE_STORAGE_KEY));
        });
    }
    setPageFromParent(data) {
        return __awaiter(this, void 0, void 0, function* () {
            const { pageContext: { catalogName, catalogVersion, catalogVersionUuid: pageContextCatalogVersionUuid }, catalogDescriptor: { catalogVersionUuid: catalogDescriptorCatalogVersionUuid } } = data;
            const translatedName = yield this.l10nPipe.transform(catalogName).pipe(operators.take(1)).toPromise();
            this.parentCatalogVersion = `${translatedName} (${catalogVersion})`;
            this.isCurrentPageFromParent =
                catalogDescriptorCatalogVersionUuid !== pageContextCatalogVersionUuid;
        });
    }
    setExperienceText() {
        return __awaiter(this, void 0, void 0, function* () {
            if (!this.experience) {
                this.experienceText = '';
            }
            const { catalogDescriptor: { name, catalogVersion }, languageDescriptor: { nativeName }, time } = this.experience;
            const pipe = new common.DatePipe(this.locale);
            const transformedTime = time
                ? `  |  ${pipe.transform(moment__default['default'](time).isValid() ? time : moment__default['default'].now(), smarteditcommons.DATE_CONSTANTS.ANGULAR_SHORT)}`
                : '';
            const [translatedName, catalogVersions] = yield Promise.all([
                this.l10nPipe.transform(name).pipe(operators.take(1)).toPromise(),
                this.getProductCatalogVersionTextByUuids()
            ]);
            this.experienceText = `${translatedName} - ${catalogVersion}  |  ${nativeName}${transformedTime}${catalogVersions}`;
        });
    }
    getProductCatalogVersionTextByUuids() {
        return __awaiter(this, void 0, void 0, function* () {
            const { productCatalogVersions } = this.experience;
            const SEPARATOR = '';
            const versionPromises = productCatalogVersions.map(({ catalogName, catalogVersion }) => __awaiter(this, void 0, void 0, function* () {
                const translatedName = yield this.l10nPipe
                    .transform(catalogName)
                    .pipe(operators.take(1))
                    .toPromise();
                return `${translatedName} (${catalogVersion})`;
            }));
            const versions = yield Promise.all(versionPromises);
            return [SEPARATOR].concat(versions).join(' | ');
        });
    }
};
ExperienceSelectorButtonComponent.$inject = ["systemEventService", "crossFrameEventService", "locale", "sharedDataService", "l10nPipe"];
/* @ngInject */ ExperienceSelectorButtonComponent = __decorate([
    smarteditcommons.SeDowngradeComponent(),
    core.Component({
        selector: 'se-experience-selector-button',
        template: `<fd-popover class="se-experience-selector" [(isOpen)]="status.isOpen" (isOpenChange)="resetExperienceSelector()" [closeOnOutsideClick]="false" [triggers]="['click']" [placement]="'bottom-end'"><fd-popover-control><div class="se-experience-selector__control"><se-tooltip [placement]="'bottom'" [triggers]="['mouseenter', 'mouseleave']" *ngIf="isCurrentPageFromParent" class="se-experience-selector__tooltip"><span se-tooltip-trigger class="se-experience-selector__btn--globe"><span class="hyicon hyicon-globe se-experience-selector__btn--globe--icon"></span></span><div se-tooltip-body>{{ parentCatalogVersion }}</div></se-tooltip><button class="se-experience-selector__btn" id="experience-selector-btn"><span [attr.title]="experienceText" class="se-experience-selector__btn-text se-nowrap-ellipsis">{{ experienceText }} </span><span class="se-experience-selector__btn-arrow icon-navigation-down-arrow"></span></button></div></fd-popover-control><fd-popover-body><div class="se-experience-selector__dropdown fd-modal fd-modal__content" role="menu"><se-experience-selector [experience]="experience" [dropdownStatus]="status" [(resetExperienceSelector)]="resetExperienceSelector"></se-experience-selector></div></fd-popover-body></fd-popover>`,
        providers: [smarteditcommons.L10nPipe]
    }),
    __param(2, core.Inject(core.LOCALE_ID)),
    __metadata("design:paramtypes", [smarteditcommons.SystemEventService,
        smarteditcommons.CrossFrameEventService, String, smarteditcommons.ISharedDataService,
        smarteditcommons.L10nPipe])
], /* @ngInject */ ExperienceSelectorButtonComponent);

window.__smartedit__.addDecoratorPayload("Component", "InflectionPointSelectorComponent", {
    selector: 'inflection-point-selector',
    template: `<div class="se-inflection-point dropdown" [class.open]="isOpen" id="inflectionPtDropdown"><button type="button" class="se-inflection-point__toggle" (click)="toggleDropdown($event)" aria-pressed="false" [attr.aria-expanded]="isOpen"><span [ngClass]="getIconClass()" class="se-inflection-point___selected"></span></button><div class="se-inflection-point-dropdown"><nav class="fd-menu"><ul class="fd-menu__list" role="menu"><li *ngFor="let choice of points" class="fd-menu__item inflection-point__device" [ngClass]="{selected: isSelected(choice)}" id="se-device-{{choice.type}}" (click)="selectPoint(choice)"><span [ngClass]="getIconClass(choice)"></span></li></ul></nav></div></div>`
});
let /* @ngInject */ InflectionPointSelectorComponent = class /* @ngInject */ InflectionPointSelectorComponent {
    constructor(systemEventService, iframeManagerService, iframeClickDetectionService, yjQuery, userTrackingService) {
        this.systemEventService = systemEventService;
        this.iframeManagerService = iframeManagerService;
        this.iframeClickDetectionService = iframeClickDetectionService;
        this.yjQuery = yjQuery;
        this.userTrackingService = userTrackingService;
        this.currentPointSelected = DEVICE_SUPPORTS.find((deviceSupport) => deviceSupport.default);
        this.points = DEVICE_SUPPORTS;
        this.isOpen = false;
    }
    ngOnInit() {
        this.iframeClickDetectionService.registerCallback('inflectionPointClose', () => (this.isOpen = false));
        const window = smarteditcommons.windowUtils.getWindow();
        this.documentClick$ = rxjs.fromEvent(window.document, 'click')
            .pipe(operators.filter((event) => this.yjQuery(event.target).parents('inflection-point-selector').length <=
            0 && this.isOpen))
            .subscribe((event) => (this.isOpen = false));
        this.unRegFn = this.systemEventService.subscribe(smarteditcommons.OVERLAY_DISABLED_EVENT, () => (this.isOpen = false));
    }
    ngOnDestroy() {
        this.unRegFn();
        this.documentClick$.unsubscribe();
    }
    selectPoint(choice) {
        this.userTrackingService.trackingUserAction(smarteditcommons.USER_TRACKING_FUNCTIONALITY.INFLECTION, choice.type);
        this.currentPointSelected = choice;
        this.isOpen = !this.isOpen;
        if (choice !== undefined) {
            this.iframeManagerService.apply(choice);
        }
    }
    toggleDropdown(event) {
        event.preventDefault();
        event.stopPropagation();
        this.isOpen = !this.isOpen;
    }
    getIconClass(choice) {
        if (choice !== undefined) {
            return choice.iconClass;
        }
        else {
            return this.currentPointSelected.iconClass;
        }
    }
    isSelected(choice) {
        if (choice !== undefined) {
            return choice.type === this.currentPointSelected.type;
        }
        return false;
    }
};
InflectionPointSelectorComponent.$inject = ["systemEventService", "iframeManagerService", "iframeClickDetectionService", "yjQuery", "userTrackingService"];
/* @ngInject */ InflectionPointSelectorComponent = __decorate([
    smarteditcommons.SeDowngradeComponent(),
    core.Component({
        selector: 'inflection-point-selector',
        template: `<div class="se-inflection-point dropdown" [class.open]="isOpen" id="inflectionPtDropdown"><button type="button" class="se-inflection-point__toggle" (click)="toggleDropdown($event)" aria-pressed="false" [attr.aria-expanded]="isOpen"><span [ngClass]="getIconClass()" class="se-inflection-point___selected"></span></button><div class="se-inflection-point-dropdown"><nav class="fd-menu"><ul class="fd-menu__list" role="menu"><li *ngFor="let choice of points" class="fd-menu__item inflection-point__device" [ngClass]="{selected: isSelected(choice)}" id="se-device-{{choice.type}}" (click)="selectPoint(choice)"><span [ngClass]="getIconClass(choice)"></span></li></ul></nav></div></div>`
    }),
    __param(2, core.Inject(smarteditcommons.IIframeClickDetectionService)),
    __param(3, core.Inject(smarteditcommons.YJQUERY_TOKEN)),
    __metadata("design:paramtypes", [smarteditcommons.SystemEventService,
        IframeManagerService,
        IframeClickDetectionService, Function, smarteditcommons.UserTrackingService])
], /* @ngInject */ InflectionPointSelectorComponent);

window.__smartedit__.addDecoratorPayload("Component", "ExperienceSelectorComponent", {
    selector: 'se-experience-selector',
    template: `<se-generic-editor *ngIf="isReady" [smarteditComponentType]="smarteditComponentType" [smarteditComponentId]="smarteditComponentId" [structureApi]="structureApi" [content]="content" [contentApi]="contentApi" (getApi)="getApi($event)"></se-generic-editor>`,
    providers: [smarteditcommons.L10nPipe]
});
let /* @ngInject */ ExperienceSelectorComponent = class /* @ngInject */ ExperienceSelectorComponent {
    constructor(systemEventService, siteService, sharedDataService, iframeClickDetectionService, iframeManagerService, experienceService, catalogService, l10nPipe, userTrackingService) {
        this.systemEventService = systemEventService;
        this.siteService = siteService;
        this.sharedDataService = sharedDataService;
        this.iframeClickDetectionService = iframeClickDetectionService;
        this.iframeManagerService = iframeManagerService;
        this.experienceService = experienceService;
        this.catalogService = catalogService;
        this.l10nPipe = l10nPipe;
        this.userTrackingService = userTrackingService;
        this.resetExperienceSelectorChange = new core.EventEmitter();
        this.modalHeaderTitle = 'se.experience.selector.header';
        this.siteCatalogs = {};
    }
    ngOnInit() {
        setTimeout(() => {
            this.resetExperienceSelectorChange.emit(() => this.resetExperienceSelectorFn());
        });
        this.unRegCloseExperienceFn = this.iframeClickDetectionService.registerCallback('closeExperienceSelector', () => {
            if (this.dropdownStatus && this.dropdownStatus.isOpen) {
                this.dropdownStatus.isOpen = false;
            }
        });
        this.unRegFn = this.systemEventService.subscribe('OVERLAY_DISABLED', () => {
            if (this.dropdownStatus && this.dropdownStatus.isOpen) {
                this.dropdownStatus.isOpen = false;
            }
        });
    }
    ngOnDestroy() {
        if (this.unRegFn) {
            this.unRegFn();
        }
        if (this.unRegCloseExperienceFn) {
            this.unRegCloseExperienceFn();
        }
    }
    preparePayload(experienceContent) {
        return __awaiter(this, void 0, void 0, function* () {
            [
                this.siteCatalogs.siteId,
                this.siteCatalogs.catalogId,
                this.siteCatalogs.catalogVersion
            ] = experienceContent.previewCatalog.split('|');
            const productCatalogs = yield this.catalogService.getProductCatalogsForSite(this.siteCatalogs.siteId);
            const { domain } = (yield this.sharedDataService.get('configuration'));
            const { previewUrl, uid: siteId } = yield this.siteService.getSiteById(this.siteCatalogs.siteId);
            const { language, time, pageId, productCatalogVersions } = experienceContent;
            this.siteCatalogs.productCatalogs = productCatalogs;
            this.siteCatalogs.productCatalogVersions = productCatalogVersions;
            this.userTrackingService.trackingUserAction(smarteditcommons.USER_TRACKING_FUNCTIONALITY.TOOL_BAR, 'update Experience');
            return Object.assign(Object.assign({}, experienceContent), { resourcePath: smarteditcommons.urlUtils.getAbsoluteURL(domain, previewUrl), catalogVersions: [
                    ...this._getProductCatalogsByUuids(productCatalogVersions),
                    {
                        catalog: this.siteCatalogs.catalogId,
                        catalogVersion: this.siteCatalogs.catalogVersion
                    }
                ], siteId,
                language,
                time,
                pageId });
        });
    }
    updateCallback(payload, response) {
        return __awaiter(this, void 0, void 0, function* () {
            const { siteId, catalogId, catalogVersion, productCatalogVersions } = this.siteCatalogs;
            const { time } = payload;
            const { pageId, language, ticketId } = response;
            this.smarteditComponentId = null;
            this.dropdownStatus.isOpen = false;
            const experienceParams = Object.assign(Object.assign({}, response), { siteId,
                catalogId,
                catalogVersion,
                productCatalogVersions, time: smarteditcommons.dateUtils.formatDateAsUtc(time), pageId,
                language });
            const experience = yield this.experienceService.buildAndSetExperience(experienceParams);
            yield this.sharedDataService.set(smarteditcommons.EXPERIENCE_STORAGE_KEY, experience);
            this.systemEventService.publishAsync(smarteditcommons.EVENTS.EXPERIENCE_UPDATE);
            this.iframeManagerService.loadPreview(experience.siteDescriptor.previewUrl, ticketId);
        });
    }
    getApi($api) {
        $api.setPreparePayload(this.preparePayload.bind(this));
        $api.setUpdateCallback(this.updateCallback.bind(this));
        $api.setAlwaysShowSubmit(true);
        $api.setAlwaysShowReset(true);
        $api.setSubmitButtonText('se.componentform.actions.apply');
        $api.setCancelButtonText('se.componentform.actions.cancel');
        $api.setOnReset(() => {
            this.dropdownStatus.isOpen = false;
            return this.dropdownStatus.isOpen;
        });
    }
    _getProductCatalogsByUuids(versionUuids) {
        return this.siteCatalogs.productCatalogs.map(({ versions, catalogId }) => ({
            catalogVersion: versions.find(({ uuid }) => versionUuids.indexOf(uuid) > -1).version,
            catalog: catalogId
        }));
    }
    resetExperienceSelectorFn() {
        return __awaiter(this, void 0, void 0, function* () {
            const experience = (yield this.sharedDataService.get(smarteditcommons.EXPERIENCE_STORAGE_KEY));
            const configuration = (yield this.sharedDataService.get('configuration'));
            this.smarteditComponentType = 'PreviewData';
            this.smarteditComponentId = null;
            this.structureApi = smarteditcommons.TYPES_RESOURCE_URI + '?code=:smarteditComponentType&mode=DEFAULT';
            this.contentApi = (configuration && configuration.previewTicketURI) || smarteditcommons.PREVIEW_RESOURCE_URI;
            const activeSiteTranslated = yield this.l10nPipe
                .transform(experience.siteDescriptor.name)
                .pipe(operators.take(1))
                .toPromise();
            this.content = Object.assign(Object.assign({}, experience), { activeSite: activeSiteTranslated, time: experience.time, pageId: experience.pageId, productCatalogVersions: experience.productCatalogVersions.map((productCatalogVersion) => productCatalogVersion.uuid), language: experience.languageDescriptor.isocode, previewCatalog: `${experience.siteDescriptor.uid}|${experience.catalogDescriptor.catalogId}|${experience.catalogDescriptor.catalogVersion}` });
            if (!this.isReady) {
                this.isReady = true;
            }
        });
    }
};
ExperienceSelectorComponent.$inject = ["systemEventService", "siteService", "sharedDataService", "iframeClickDetectionService", "iframeManagerService", "experienceService", "catalogService", "l10nPipe", "userTrackingService"];
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ ExperienceSelectorComponent.prototype, "experience", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ ExperienceSelectorComponent.prototype, "dropdownStatus", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Function)
], /* @ngInject */ ExperienceSelectorComponent.prototype, "resetExperienceSelector", void 0);
__decorate([
    core.Output(),
    __metadata("design:type", core.EventEmitter)
], /* @ngInject */ ExperienceSelectorComponent.prototype, "resetExperienceSelectorChange", void 0);
/* @ngInject */ ExperienceSelectorComponent = __decorate([
    smarteditcommons.SeDowngradeComponent(),
    core.Component({
        selector: 'se-experience-selector',
        template: `<se-generic-editor *ngIf="isReady" [smarteditComponentType]="smarteditComponentType" [smarteditComponentId]="smarteditComponentId" [structureApi]="structureApi" [content]="content" [contentApi]="contentApi" (getApi)="getApi($event)"></se-generic-editor>`,
        providers: [smarteditcommons.L10nPipe]
    }),
    __metadata("design:paramtypes", [smarteditcommons.SystemEventService,
        SiteService,
        smarteditcommons.ISharedDataService,
        smarteditcommons.IIframeClickDetectionService,
        IframeManagerService,
        smarteditcommons.IExperienceService,
        smarteditcommons.ICatalogService,
        smarteditcommons.L10nPipe,
        smarteditcommons.UserTrackingService])
], /* @ngInject */ ExperienceSelectorComponent);

window.__smartedit__.addDecoratorPayload("Component", "UserAccountComponent", {
    selector: 'se-user-account',
    template: `<div class="se-user-account-dropdown"><div class="se-user-account-dropdown__role">{{ 'se.toolbar.useraccount.role' | translate }}</div><div class="user-account-dropdown__name">{{username}}</div><div class="divider"></div><a class="se-sign-out__link fd-menu__item" (click)="signOut()">{{'se.toolbar.useraccount.signout' | translate}}</a></div>`
});
let /* @ngInject */ UserAccountComponent = class /* @ngInject */ UserAccountComponent {
    constructor(authenticationService, iframeManagerService, crossFrameEventService, sessionService) {
        this.authenticationService = authenticationService;
        this.iframeManagerService = iframeManagerService;
        this.crossFrameEventService = crossFrameEventService;
        this.sessionService = sessionService;
    }
    ngOnInit() {
        this.unregUserChanged = this.crossFrameEventService.subscribe(smarteditcommons.EVENTS.USER_HAS_CHANGED, () => this.getUsername());
        this.getUsername();
    }
    ngOnDestroy() {
        this.unregUserChanged();
    }
    signOut() {
        this.authenticationService.logout();
        this.iframeManagerService.setCurrentLocation(null);
    }
    getUsername() {
        this.sessionService.getCurrentUserDisplayName().then((displayName) => {
            this.username = displayName;
        });
    }
};
UserAccountComponent.$inject = ["authenticationService", "iframeManagerService", "crossFrameEventService", "sessionService"];
/* @ngInject */ UserAccountComponent = __decorate([
    smarteditcommons.SeDowngradeComponent(),
    core.Component({
        selector: 'se-user-account',
        template: `<div class="se-user-account-dropdown"><div class="se-user-account-dropdown__role">{{ 'se.toolbar.useraccount.role' | translate }}</div><div class="user-account-dropdown__name">{{username}}</div><div class="divider"></div><a class="se-sign-out__link fd-menu__item" (click)="signOut()">{{'se.toolbar.useraccount.signout' | translate}}</a></div>`
    }),
    __metadata("design:paramtypes", [smarteditcommons.IAuthenticationService,
        IframeManagerService,
        smarteditcommons.CrossFrameEventService,
        smarteditcommons.ISessionService])
], /* @ngInject */ UserAccountComponent);

window.__smartedit__.addDecoratorPayload("Component", "ExperienceSelectorWrapperComponent", {
    selector: 'se-experience-selector-wrapper',
    template: `
        <se-experience-selector-button
            *ngIf="toolbar.isOnStorefront()"
        ></se-experience-selector-button>
    `
});
let ExperienceSelectorWrapperComponent = class ExperienceSelectorWrapperComponent {
    constructor(toolbar) {
        this.toolbar = toolbar;
    }
};
ExperienceSelectorWrapperComponent = __decorate([
    core.Component({
        selector: 'se-experience-selector-wrapper',
        template: `
        <se-experience-selector-button
            *ngIf="toolbar.isOnStorefront()"
        ></se-experience-selector-button>
    `
    }),
    __param(0, core.Inject(core.forwardRef(() => ToolbarComponent))),
    __metadata("design:paramtypes", [ToolbarComponent])
], ExperienceSelectorWrapperComponent);

window.__smartedit__.addDecoratorPayload("Component", "LogoComponent", {
    selector: 'se-logo',
    template: `
        <div class="se-app-logo">
            <img src="static-resources/images/SAP_scrn_R.png" class="se-logo-image" />
            <div class="se-logo-text">{{ 'se.application.name' | translate }}</div>
        </div>
    `
});
let LogoComponent = class LogoComponent {
};
LogoComponent = __decorate([
    core.Component({
        selector: 'se-logo',
        template: `
        <div class="se-app-logo">
            <img src="static-resources/images/SAP_scrn_R.png" class="se-logo-image" />
            <div class="se-logo-text">{{ 'se.application.name' | translate }}</div>
        </div>
    `
    })
], LogoComponent);

/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
!(function () {
    const t =
            window.ShadowRoot &&
            (void 0 === window.ShadyCSS || window.ShadyCSS.nativeShadow) &&
            'adoptedStyleSheets' in Document.prototype &&
            'replace' in CSSStyleSheet.prototype,
        e = Symbol(),
        o = new Map();
    class i {
        constructor(t, o) {
            if (((this._$cssResult$ = !0), o !== e))
                throw Error('CSSResult is not constructable. Use `unsafeCSS` or `css` instead.');
            this.cssText = t;
        }
        get styleSheet() {
            let e = o.get(this.cssText);
            return (
                t &&
                    void 0 === e &&
                    (o.set(this.cssText, (e = new CSSStyleSheet())), e.replaceSync(this.cssText)),
                e
            );
        }
        toString() {
            return this.cssText;
        }
    }
    const n = t
        ? (t) => t
        : (t) =>
              t instanceof CSSStyleSheet
                  ? ((t) => {
                        let o = '';
                        for (const e of t.cssRules) o += e.cssText;
                        return ((t) => new i('string' == typeof t ? t : t + '', e))(o);
                    })(t)
                  : t;
    var s, r;
    const a = {
            toAttribute(t, e) {
                switch (e) {
                    case Boolean:
                        t = t ? '' : null;
                        break;
                    case Object:
                    case Array:
                        t = null == t ? t : JSON.stringify(t);
                }
                return t;
            },
            fromAttribute(t, e) {
                let o = t;
                switch (e) {
                    case Boolean:
                        o = null !== t;
                        break;
                    case Number:
                        o = null === t ? null : Number(t);
                        break;
                    case Object:
                    case Array:
                        try {
                            o = JSON.parse(t);
                        } catch (t) {
                            o = null;
                        }
                }
                return o;
            }
        },
        l = (t, e) => e !== t && (e == e || t == t),
        h = { attribute: !0, type: String, converter: a, reflect: !1, hasChanged: l };
    class c extends HTMLElement {
        constructor() {
            super(),
                (this._$Et = new Map()),
                (this.isUpdatePending = !1),
                (this.hasUpdated = !1),
                (this._$Ei = null),
                this.o();
        }
        static addInitializer(t) {
            var e;
            (null !== (e = this.l) && void 0 !== e) || (this.l = []), this.l.push(t);
        }
        static get observedAttributes() {
            this.finalize();
            const t = [];
            return (
                this.elementProperties.forEach((e, o) => {
                    const i = this._$Eh(o, e);
                    void 0 !== i && (this._$Eu.set(i, o), t.push(i));
                }),
                t
            );
        }
        static createProperty(t, e = h) {
            if (
                (e.state && (e.attribute = !1),
                this.finalize(),
                this.elementProperties.set(t, e),
                !e.noAccessor && !this.prototype.hasOwnProperty(t))
            ) {
                const o = 'symbol' == typeof t ? Symbol() : '__' + t,
                    i = this.getPropertyDescriptor(t, o, e);
                void 0 !== i && Object.defineProperty(this.prototype, t, i);
            }
        }
        static getPropertyDescriptor(t, e, o) {
            return {
                get() {
                    return this[e];
                },
                set(i) {
                    const n = this[t];
                    (this[e] = i), this.requestUpdate(t, n, o);
                },
                configurable: !0,
                enumerable: !0
            };
        }
        static getPropertyOptions(t) {
            return this.elementProperties.get(t) || h;
        }
        static finalize() {
            if (this.hasOwnProperty('finalized')) return !1;
            this.finalized = !0;
            const t = Object.getPrototypeOf(this);
            if (
                (t.finalize(),
                (this.elementProperties = new Map(t.elementProperties)),
                (this._$Eu = new Map()),
                this.hasOwnProperty('properties'))
            ) {
                const t = this.properties,
                    e = [...Object.getOwnPropertyNames(t), ...Object.getOwnPropertySymbols(t)];
                for (const o of e) this.createProperty(o, t[o]);
            }
            return (this.elementStyles = this.finalizeStyles(this.styles)), !0;
        }
        static finalizeStyles(t) {
            const e = [];
            if (Array.isArray(t)) {
                const o = new Set(t.flat(1 / 0).reverse());
                for (const t of o) e.unshift(n(t));
            } else void 0 !== t && e.push(n(t));
            return e;
        }
        static _$Eh(t, e) {
            const o = e.attribute;
            return !1 === o
                ? void 0
                : 'string' == typeof o
                ? o
                : 'string' == typeof t
                ? t.toLowerCase()
                : void 0;
        }
        o() {
            var t;
            (this._$Ev = new Promise((t) => (this.enableUpdating = t))),
                (this._$AL = new Map()),
                this._$Ep(),
                this.requestUpdate(),
                null === (t = this.constructor.l) || void 0 === t || t.forEach((t) => t(this));
        }
        addController(t) {
            var e, o;
            (null !== (e = this._$Em) && void 0 !== e ? e : (this._$Em = [])).push(t),
                void 0 !== this.renderRoot &&
                    this.isConnected &&
                    (null === (o = t.hostConnected) || void 0 === o || o.call(t));
        }
        removeController(t) {
            var e;
            null === (e = this._$Em) || void 0 === e || e.splice(this._$Em.indexOf(t) >>> 0, 1);
        }
        _$Ep() {
            this.constructor.elementProperties.forEach((t, e) => {
                this.hasOwnProperty(e) && (this._$Et.set(e, this[e]), delete this[e]);
            });
        }
        createRenderRoot() {
            var e;
            const o =
                null !== (e = this.shadowRoot) && void 0 !== e
                    ? e
                    : this.attachShadow(this.constructor.shadowRootOptions);
            return (
                ((e, o) => {
                    t
                        ? (e.adoptedStyleSheets = o.map((t) =>
                              t instanceof CSSStyleSheet ? t : t.styleSheet
                          ))
                        : o.forEach((t) => {
                              const o = document.createElement('style'),
                                  i = window.litNonce;
                              void 0 !== i && o.setAttribute('nonce', i),
                                  (o.textContent = t.cssText),
                                  e.appendChild(o);
                          });
                })(o, this.constructor.elementStyles),
                o
            );
        }
        connectedCallback() {
            var t;
            void 0 === this.renderRoot && (this.renderRoot = this.createRenderRoot()),
                this.enableUpdating(!0),
                null === (t = this._$Em) ||
                    void 0 === t ||
                    t.forEach((t) => {
                        var e;
                        return null === (e = t.hostConnected) || void 0 === e ? void 0 : e.call(t);
                    });
        }
        enableUpdating(t) {}
        disconnectedCallback() {
            var t;
            null === (t = this._$Em) ||
                void 0 === t ||
                t.forEach((t) => {
                    var e;
                    return null === (e = t.hostDisconnected) || void 0 === e ? void 0 : e.call(t);
                });
        }
        attributeChangedCallback(t, e, o) {
            this._$AK(t, o);
        }
        _$Eg(t, e, o = h) {
            var i, n;
            const s = this.constructor._$Eh(t, o);
            if (void 0 !== s && !0 === o.reflect) {
                const r = (null !==
                    (n = null === (i = o.converter) || void 0 === i ? void 0 : i.toAttribute) &&
                    void 0 !== n
                    ? n
                    : a.toAttribute)(e, o.type);
                (this._$Ei = t),
                    null == r ? this.removeAttribute(s) : this.setAttribute(s, r),
                    (this._$Ei = null);
            }
        }
        _$AK(t, e) {
            var o, i, n;
            const s = this.constructor,
                r = s._$Eu.get(t);
            if (void 0 !== r && this._$Ei !== r) {
                const t = s.getPropertyOptions(r),
                    l = t.converter,
                    h =
                        null !==
                            (n =
                                null !==
                                    (i =
                                        null === (o = l) || void 0 === o
                                            ? void 0
                                            : o.fromAttribute) && void 0 !== i
                                    ? i
                                    : 'function' == typeof l
                                    ? l
                                    : null) && void 0 !== n
                            ? n
                            : a.fromAttribute;
                (this._$Ei = r), (this[r] = h(e, t.type)), (this._$Ei = null);
            }
        }
        requestUpdate(t, e, o) {
            let i = !0;
            void 0 !== t &&
                (((o = o || this.constructor.getPropertyOptions(t)).hasChanged || l)(this[t], e)
                    ? (this._$AL.has(t) || this._$AL.set(t, e),
                      !0 === o.reflect &&
                          this._$Ei !== t &&
                          (void 0 === this._$ES && (this._$ES = new Map()), this._$ES.set(t, o)))
                    : (i = !1)),
                !this.isUpdatePending && i && (this._$Ev = this._$EC());
        }
        async _$EC() {
            this.isUpdatePending = !0;
            try {
                await this._$Ev;
            } catch (t) {
                Promise.reject(t);
            }
            const t = this.scheduleUpdate();
            return null != t && (await t), !this.isUpdatePending;
        }
        scheduleUpdate() {
            return this.performUpdate();
        }
        performUpdate() {
            var t;
            if (!this.isUpdatePending) return;
            this.hasUpdated,
                this._$Et && (this._$Et.forEach((t, e) => (this[e] = t)), (this._$Et = void 0));
            let e = !1;
            const o = this._$AL;
            try {
                (e = this.shouldUpdate(o)),
                    e
                        ? (this.willUpdate(o),
                          null === (t = this._$Em) ||
                              void 0 === t ||
                              t.forEach((t) => {
                                  var e;
                                  return null === (e = t.hostUpdate) || void 0 === e
                                      ? void 0
                                      : e.call(t);
                              }),
                          this.update(o))
                        : this._$ET();
            } catch (t) {
                throw ((e = !1), this._$ET(), t);
            }
            e && this._$AE(o);
        }
        willUpdate(t) {}
        _$AE(t) {
            var e;
            null === (e = this._$Em) ||
                void 0 === e ||
                e.forEach((t) => {
                    var e;
                    return null === (e = t.hostUpdated) || void 0 === e ? void 0 : e.call(t);
                }),
                this.hasUpdated || ((this.hasUpdated = !0), this.firstUpdated(t)),
                this.updated(t);
        }
        _$ET() {
            (this._$AL = new Map()), (this.isUpdatePending = !1);
        }
        get updateComplete() {
            return this.getUpdateComplete();
        }
        getUpdateComplete() {
            return this._$Ev;
        }
        shouldUpdate(t) {
            return !0;
        }
        update(t) {
            void 0 !== this._$ES &&
                (this._$ES.forEach((t, e) => this._$Eg(e, this[e], t)), (this._$ES = void 0)),
                this._$ET();
        }
        updated(t) {}
        firstUpdated(t) {}
    }
    var u, d;
    (c.finalized = !0),
        (c.elementProperties = new Map()),
        (c.elementStyles = []),
        (c.shadowRootOptions = { mode: 'open' }),
        null === (s = globalThis.reactiveElementPolyfillSupport) ||
            void 0 === s ||
            s.call(globalThis, { ReactiveElement: c }),
        (null !== (r = globalThis.reactiveElementVersions) && void 0 !== r
            ? r
            : (globalThis.reactiveElementVersions = [])
        ).push('1.0.0');
    const p = globalThis.trustedTypes,
        v = p ? p.createPolicy('lit-html', { createHTML: (t) => t }) : void 0,
        f = `lit$${(Math.random() + '').slice(9)}$`,
        b = '?' + f,
        m = `<${b}>`,
        g = document,
        _ = (t = '') => g.createComment(t),
        y = (t) => null === t || ('object' != typeof t && 'function' != typeof t),
        x = Array.isArray,
        $ = /<(?:(!--|\/[^a-zA-Z])|(\/?[a-zA-Z][^>\s]*)|(\/?$))/g,
        A = /-->/g,
        w = />/g,
        S = />|[ 	\n\r](?:([^\s"'>=/]+)([ 	\n\r]*=[ 	\n\r]*(?:[^ 	\n\r"'`<>=]|("|')|))|$)/g,
        C = /'/g,
        E = /"/g,
        P = /^(?:script|style|textarea)$/i,
        k = ((t) => (e, ...o) => ({ _$litType$: t, strings: e, values: o }))(1),
        I = Symbol.for('lit-noChange'),
        T = Symbol.for('lit-nothing'),
        O = new WeakMap(),
        U = g.createTreeWalker(g, 129, null, !1),
        N = (t, e) => {
            const o = t.length - 1,
                i = [];
            let n,
                s = 2 === e ? '<svg>' : '',
                r = $;
            for (let e = 0; e < o; e++) {
                const o = t[e];
                let a,
                    l,
                    h = -1,
                    c = 0;
                for (; c < o.length && ((r.lastIndex = c), (l = r.exec(o)), null !== l); )
                    (c = r.lastIndex),
                        r === $
                            ? '!--' === l[1]
                                ? (r = A)
                                : void 0 !== l[1]
                                ? (r = w)
                                : void 0 !== l[2]
                                ? (P.test(l[2]) && (n = RegExp('</' + l[2], 'g')), (r = S))
                                : void 0 !== l[3] && (r = S)
                            : r === S
                            ? '>' === l[0]
                                ? ((r = null != n ? n : $), (h = -1))
                                : void 0 === l[1]
                                ? (h = -2)
                                : ((h = r.lastIndex - l[2].length),
                                  (a = l[1]),
                                  (r = void 0 === l[3] ? S : '"' === l[3] ? E : C))
                            : r === E || r === C
                            ? (r = S)
                            : r === A || r === w
                            ? (r = $)
                            : ((r = S), (n = void 0));
                const u = r === S && t[e + 1].startsWith('/>') ? ' ' : '';
                s +=
                    r === $
                        ? o + m
                        : h >= 0
                        ? (i.push(a), o.slice(0, h) + '$lit$' + o.slice(h) + f + u)
                        : o + f + (-2 === h ? (i.push(void 0), e) : u);
            }
            const a = s + (t[o] || '<?>') + (2 === e ? '</svg>' : '');
            return [void 0 !== v ? v.createHTML(a) : a, i];
        };
    class L {
        constructor({ strings: t, _$litType$: e }, o) {
            let i;
            this.parts = [];
            let n = 0,
                s = 0;
            const r = t.length - 1,
                a = this.parts,
                [l, h] = N(t, e);
            if (((this.el = L.createElement(l, o)), (U.currentNode = this.el.content), 2 === e)) {
                const t = this.el.content,
                    e = t.firstChild;
                e.remove(), t.append(...e.childNodes);
            }
            for (; null !== (i = U.nextNode()) && a.length < r; ) {
                if (1 === i.nodeType) {
                    if (i.hasAttributes()) {
                        const t = [];
                        for (const e of i.getAttributeNames())
                            if (e.endsWith('$lit$') || e.startsWith(f)) {
                                const o = h[s++];
                                if ((t.push(e), void 0 !== o)) {
                                    const t = i.getAttribute(o.toLowerCase() + '$lit$').split(f),
                                        e = /([.?@])?(.*)/.exec(o);
                                    a.push({
                                        type: 1,
                                        index: n,
                                        name: e[2],
                                        strings: t,
                                        ctor:
                                            '.' === e[1]
                                                ? M
                                                : '?' === e[1]
                                                ? j
                                                : '@' === e[1]
                                                ? Q
                                                : q
                                    });
                                } else a.push({ type: 6, index: n });
                            }
                        for (const e of t) i.removeAttribute(e);
                    }
                    if (P.test(i.tagName)) {
                        const t = i.textContent.split(f),
                            e = t.length - 1;
                        if (e > 0) {
                            i.textContent = p ? p.emptyScript : '';
                            for (let o = 0; o < e; o++)
                                i.append(t[o], _()), U.nextNode(), a.push({ type: 2, index: ++n });
                            i.append(t[e], _());
                        }
                    }
                } else if (8 === i.nodeType)
                    if (i.data === b) a.push({ type: 2, index: n });
                    else {
                        let t = -1;
                        for (; -1 !== (t = i.data.indexOf(f, t + 1)); )
                            a.push({ type: 7, index: n }), (t += f.length - 1);
                    }
                n++;
            }
        }
        static createElement(t, e) {
            const o = g.createElement('template');
            return (o.innerHTML = t), o;
        }
    }
    function B(t, e, o = t, i) {
        var n, s, r, a;
        if (e === I) return e;
        let l = void 0 !== i ? (null === (n = o._$Cl) || void 0 === n ? void 0 : n[i]) : o._$Cu;
        const h = y(e) ? void 0 : e._$litDirective$;
        return (
            (null == l ? void 0 : l.constructor) !== h &&
                (null === (s = null == l ? void 0 : l._$AO) || void 0 === s || s.call(l, !1),
                void 0 === h ? (l = void 0) : ((l = new h(t)), l._$AT(t, o, i)),
                void 0 !== i
                    ? ((null !== (r = (a = o)._$Cl) && void 0 !== r ? r : (a._$Cl = []))[i] = l)
                    : (o._$Cu = l)),
            void 0 !== l && (e = B(t, l._$AS(t, e.values), l, i)),
            e
        );
    }
    class R {
        constructor(t, e) {
            (this.v = []), (this._$AN = void 0), (this._$AD = t), (this._$AM = e);
        }
        get parentNode() {
            return this._$AM.parentNode;
        }
        get _$AU() {
            return this._$AM._$AU;
        }
        p(t) {
            var e;
            const {
                    el: { content: o },
                    parts: i
                } = this._$AD,
                n = (null !== (e = null == t ? void 0 : t.creationScope) && void 0 !== e
                    ? e
                    : g
                ).importNode(o, !0);
            U.currentNode = n;
            let s = U.nextNode(),
                r = 0,
                a = 0,
                l = i[0];
            for (; void 0 !== l; ) {
                if (r === l.index) {
                    let e;
                    2 === l.type
                        ? (e = new H(s, s.nextSibling, this, t))
                        : 1 === l.type
                        ? (e = new l.ctor(s, l.name, l.strings, this, t))
                        : 6 === l.type && (e = new z(s, this, t)),
                        this.v.push(e),
                        (l = i[++a]);
                }
                r !== (null == l ? void 0 : l.index) && ((s = U.nextNode()), r++);
            }
            return n;
        }
        m(t) {
            let e = 0;
            for (const o of this.v)
                void 0 !== o &&
                    (void 0 !== o.strings
                        ? (o._$AI(t, o, e), (e += o.strings.length - 2))
                        : o._$AI(t[e])),
                    e++;
        }
    }
    class H {
        constructor(t, e, o, i) {
            var n;
            (this.type = 2),
                (this._$AH = T),
                (this._$AN = void 0),
                (this._$AA = t),
                (this._$AB = e),
                (this._$AM = o),
                (this.options = i),
                (this._$Cg =
                    null === (n = null == i ? void 0 : i.isConnected) || void 0 === n || n);
        }
        get _$AU() {
            var t, e;
            return null !== (e = null === (t = this._$AM) || void 0 === t ? void 0 : t._$AU) &&
                void 0 !== e
                ? e
                : this._$Cg;
        }
        get parentNode() {
            let t = this._$AA.parentNode;
            const e = this._$AM;
            return void 0 !== e && 11 === t.nodeType && (t = e.parentNode), t;
        }
        get startNode() {
            return this._$AA;
        }
        get endNode() {
            return this._$AB;
        }
        _$AI(t, e = this) {
            (t = B(this, t, e)),
                y(t)
                    ? t === T || null == t || '' === t
                        ? (this._$AH !== T && this._$AR(), (this._$AH = T))
                        : t !== this._$AH && t !== I && this.$(t)
                    : void 0 !== t._$litType$
                    ? this.T(t)
                    : void 0 !== t.nodeType
                    ? this.S(t)
                    : ((t) => {
                          var e;
                          return (
                              x(t) ||
                              'function' ==
                                  typeof (null === (e = t) || void 0 === e
                                      ? void 0
                                      : e[Symbol.iterator])
                          );
                      })(t)
                    ? this.M(t)
                    : this.$(t);
        }
        A(t, e = this._$AB) {
            return this._$AA.parentNode.insertBefore(t, e);
        }
        S(t) {
            this._$AH !== t && (this._$AR(), (this._$AH = this.A(t)));
        }
        $(t) {
            this._$AH !== T && y(this._$AH)
                ? (this._$AA.nextSibling.data = t)
                : this.S(g.createTextNode(t)),
                (this._$AH = t);
        }
        T(t) {
            var e;
            const { values: o, _$litType$: i } = t,
                n =
                    'number' == typeof i
                        ? this._$AC(t)
                        : (void 0 === i.el && (i.el = L.createElement(i.h, this.options)), i);
            if ((null === (e = this._$AH) || void 0 === e ? void 0 : e._$AD) === n) this._$AH.m(o);
            else {
                const t = new R(n, this),
                    e = t.p(this.options);
                t.m(o), this.S(e), (this._$AH = t);
            }
        }
        _$AC(t) {
            let e = O.get(t.strings);
            return void 0 === e && O.set(t.strings, (e = new L(t))), e;
        }
        M(t) {
            x(this._$AH) || ((this._$AH = []), this._$AR());
            const e = this._$AH;
            let o,
                i = 0;
            for (const n of t)
                i === e.length
                    ? e.push((o = new H(this.A(_()), this.A(_()), this, this.options)))
                    : (o = e[i]),
                    o._$AI(n),
                    i++;
            i < e.length && (this._$AR(o && o._$AB.nextSibling, i), (e.length = i));
        }
        _$AR(t = this._$AA.nextSibling, e) {
            var o;
            for (
                null === (o = this._$AP) || void 0 === o || o.call(this, !1, !0, e);
                t && t !== this._$AB;

            ) {
                const e = t.nextSibling;
                t.remove(), (t = e);
            }
        }
        setConnected(t) {
            var e;
            void 0 === this._$AM &&
                ((this._$Cg = t), null === (e = this._$AP) || void 0 === e || e.call(this, t));
        }
    }
    class q {
        constructor(t, e, o, i, n) {
            (this.type = 1),
                (this._$AH = T),
                (this._$AN = void 0),
                (this.element = t),
                (this.name = e),
                (this._$AM = i),
                (this.options = n),
                o.length > 2 || '' !== o[0] || '' !== o[1]
                    ? ((this._$AH = Array(o.length - 1).fill(new String())), (this.strings = o))
                    : (this._$AH = T);
        }
        get tagName() {
            return this.element.tagName;
        }
        get _$AU() {
            return this._$AM._$AU;
        }
        _$AI(t, e = this, o, i) {
            const n = this.strings;
            let s = !1;
            if (void 0 === n)
                (t = B(this, t, e, 0)),
                    (s = !y(t) || (t !== this._$AH && t !== I)),
                    s && (this._$AH = t);
            else {
                const i = t;
                let r, a;
                for (t = n[0], r = 0; r < n.length - 1; r++)
                    (a = B(this, i[o + r], e, r)),
                        a === I && (a = this._$AH[r]),
                        s || (s = !y(a) || a !== this._$AH[r]),
                        a === T ? (t = T) : t !== T && (t += (null != a ? a : '') + n[r + 1]),
                        (this._$AH[r] = a);
            }
            s && !i && this.k(t);
        }
        k(t) {
            t === T
                ? this.element.removeAttribute(this.name)
                : this.element.setAttribute(this.name, null != t ? t : '');
        }
    }
    class M extends q {
        constructor() {
            super(...arguments), (this.type = 3);
        }
        k(t) {
            this.element[this.name] = t === T ? void 0 : t;
        }
    }
    class j extends q {
        constructor() {
            super(...arguments), (this.type = 4);
        }
        k(t) {
            t && t !== T
                ? this.element.setAttribute(this.name, '')
                : this.element.removeAttribute(this.name);
        }
    }
    class Q extends q {
        constructor(t, e, o, i, n) {
            super(t, e, o, i, n), (this.type = 5);
        }
        _$AI(t, e = this) {
            var o;
            if ((t = null !== (o = B(this, t, e, 0)) && void 0 !== o ? o : T) === I) return;
            const i = this._$AH,
                n =
                    (t === T && i !== T) ||
                    t.capture !== i.capture ||
                    t.once !== i.once ||
                    t.passive !== i.passive,
                s = t !== T && (i === T || n);
            n && this.element.removeEventListener(this.name, this, i),
                s && this.element.addEventListener(this.name, this, t),
                (this._$AH = t);
        }
        handleEvent(t) {
            var e, o;
            'function' == typeof this._$AH
                ? this._$AH.call(
                      null !==
                          (o = null === (e = this.options) || void 0 === e ? void 0 : e.host) &&
                          void 0 !== o
                          ? o
                          : this.element,
                      t
                  )
                : this._$AH.handleEvent(t);
        }
    }
    class z {
        constructor(t, e, o) {
            (this.element = t),
                (this.type = 6),
                (this._$AN = void 0),
                (this._$AM = e),
                (this.options = o);
        }
        get _$AU() {
            return this._$AM._$AU;
        }
        _$AI(t) {
            B(this, t);
        }
    }
    var V, D, F;
    null === (u = globalThis.litHtmlPolyfillSupport) || void 0 === u || u.call(globalThis, L, H),
        (null !== (d = globalThis.litHtmlVersions) && void 0 !== d
            ? d
            : (globalThis.litHtmlVersions = [])
        ).push('2.0.0');
    class G extends c {
        constructor() {
            super(...arguments), (this.renderOptions = { host: this }), (this._$Dt = void 0);
        }
        createRenderRoot() {
            var t, e;
            const o = super.createRenderRoot();
            return (
                (null !== (t = (e = this.renderOptions).renderBefore) && void 0 !== t) ||
                    (e.renderBefore = o.firstChild),
                o
            );
        }
        update(t) {
            const e = this.render();
            this.hasUpdated || (this.renderOptions.isConnected = this.isConnected),
                super.update(t),
                (this._$Dt = ((t, e, o) => {
                    var i, n;
                    const s =
                        null !== (i = null == o ? void 0 : o.renderBefore) && void 0 !== i ? i : e;
                    let r = s._$litPart$;
                    if (void 0 === r) {
                        const t =
                            null !== (n = null == o ? void 0 : o.renderBefore) && void 0 !== n
                                ? n
                                : null;
                        s._$litPart$ = r = new H(
                            e.insertBefore(_(), t),
                            t,
                            void 0,
                            null != o ? o : {}
                        );
                    }
                    return r._$AI(t), r;
                })(e, this.renderRoot, this.renderOptions));
        }
        connectedCallback() {
            var t;
            super.connectedCallback(),
                null === (t = this._$Dt) || void 0 === t || t.setConnected(!0);
        }
        disconnectedCallback() {
            var t;
            super.disconnectedCallback(),
                null === (t = this._$Dt) || void 0 === t || t.setConnected(!1);
        }
        render() {
            return I;
        }
    }
    function Z(t, e) {
        let o = t;
        const i = (e || '').split('/'),
            n = i.length;
        i.forEach((t, e) => {
            Object.prototype.hasOwnProperty.call(o, t) && (e === n - 1 ? delete o[t] : (o = o[t]));
        });
    }
    (G.finalized = !0),
        (G._$litElement$ = !0),
        null === (V = globalThis.litElementHydrateSupport) ||
            void 0 === V ||
            V.call(globalThis, { LitElement: G }),
        null === (D = globalThis.litElementPolyfillSupport) ||
            void 0 === D ||
            D.call(globalThis, { LitElement: G }),
        (null !== (F = globalThis.litElementVersions) && void 0 !== F
            ? F
            : (globalThis.litElementVersions = [])
        ).push('3.0.0');
    const J = 'surveyTriggerButton';
    function W(t) {
        return !(!t.QSI || !t.QSI.API || 'function' != typeof t.QSI.API.unload);
    }
    const K = {
            init: function (t) {
                const {
                    interceptUrl: e,
                    globalObj: o,
                    contextRootPath: i,
                    contextParamPaths: n,
                    customContextParamPaths: s,
                    surveyLaunchMethod: r
                } = t;
                return new Promise((t, a) => {
                    if (e)
                        try {
                            const l = {},
                                h = () => {
                                    var e, c;
                                    o.QSI.API
                                        ? ((l.QSI = o.QSI),
                                          (l.apiLoadedListener = h),
                                          (l.setParameters = new Set([])),
                                          (l.globalObj = o),
                                          (l.destroyed = !1),
                                          (l.firstNonExistingRoot = (function (t, e) {
                                              if ('string' != typeof e || 0 === e.length)
                                                  return null;
                                              const o = e.split('/');
                                              let i = '',
                                                  n = t;
                                              for (let t = 0; t < o.length; t++) {
                                                  const e = o[t];
                                                  if (!Object.prototype.hasOwnProperty.call(n, e))
                                                      return i + (0 === i.length ? '' : '/') + e;
                                                  (n = n[e]), (i += (0 === t ? '' : '/') + e);
                                              }
                                              return e === i ? null : i;
                                          })(o, i)),
                                          (l.contextRootPath = i),
                                          (l.contextParamPaths =
                                              ((e = n),
                                              (c = s),
                                              Object.keys(e || {}).reduce(
                                                  (t, o) => ((t[o] = e[o]), t),
                                                  JSON.parse(JSON.stringify(c || {}))
                                              ))),
                                          (l.surveyLaunchMethod = r),
                                          t(l))
                                        : a(
                                              new Error(
                                                  'Survey intercept was loaded but API could not be found'
                                              )
                                          );
                                };
                            if (!o.document || !o.document.body)
                                throw new Error(
                                    'Cannot inject elements in the document: document.body is not available.'
                                );
                            switch (r) {
                                case 'invisibleButton':
                                    if (document.getElementById(J))
                                        throw new Error(
                                            "An element with id surveyTriggerButton already exists in this page. The survey won't be launched unless the existing button is removed or its id is renamed."
                                        );
                                    const t = (function () {
                                        const t = document.createElement('button');
                                        return (
                                            t.setAttribute('id', 'surveyTriggerButton'),
                                            (t.style.display = 'none'),
                                            document.body.appendChild(t),
                                            t
                                        );
                                    })();
                                    l.invisibleButtonElement = t;
                                    break;
                                case 'qsiApi':
                                    break;
                                default:
                                    throw new Error(`Unsupported launch method: ${r}.`);
                            }
                            W(o)
                                ? o.QSI.API.load().then(h)
                                : (!(function (t, e) {
                                      const o = e.document.createElement('script');
                                      (o.type = 'text/javascript'),
                                          (o.src = t),
                                          e.document.body.appendChild(o);
                                  })(e, o),
                                  o.addEventListener('qsi_js_loaded', h, !1));
                        } catch (t) {
                            a(t);
                        }
                    else
                        a(
                            new Error(
                                'No intercept URL was provided. This is a mandatory parameter.'
                            )
                        );
                });
            },
            destroy: function (t) {
                W(t) && t.QSI.API.unload(),
                    t.apiLoadedListener &&
                        t.globalObj.removeEventListener('qsi_js_loaded', t.apiLoadedListener);
                let e = t.contextRootPath;
                t.firstNonExistingRoot
                    ? Z(t.globalObj, t.firstNonExistingRoot)
                    : t.setParameters.forEach((o) => {
                          const i = t.contextParamPaths[o];
                          i && (e = `${e}/${i}`), Z(t.globalObj, e);
                      }),
                    t.invisibleButtonElement && t.invisibleButtonElement.remove(),
                    (t.destroyed = !0);
            },
            setContextParameters: function (t, e) {
                const o = (function (t, e, o) {
                    2 === arguments.length && (o = !0);
                    let i = t;
                    const n = (e || '').split('/');
                    for (const t of n) {
                        if (!Object.prototype.hasOwnProperty.call(i, t)) {
                            if (!o) return;
                            i[t] = {};
                        }
                        i = i[t];
                    }
                    return i;
                })(t.globalObj, t.contextRootPath);
                Object.keys(e).forEach((i) => {
                    const n = t.contextParamPaths[i] || i;
                    !(function (t, e, o) {
                        let i = t;
                        if ('' === e) throw new Error('Path cannot be empty');
                        const n = (e || '').split('/'),
                            s = n.length;
                        n.forEach((t, e) => {
                            Object.prototype.hasOwnProperty.call(i, t) || (i[t] = {}),
                                e === s - 1 && (i[t] = o),
                                (i = i[t]);
                        });
                    })(o, n, e[i]),
                        t.setParameters.add(i);
                });
            },
            startSurvey: function (t) {
                if (0 === t.setParameters.size)
                    throw new Error(
                        'Cannot start a survey without context parameters. Call setContextParameters first.'
                    );
                'invisibleButton' !== t.surveyLaunchMethod
                    ? (t.QSI.API.unload(), t.QSI.API.load().then(t.QSI.API.run.bind(t.QSI.API)))
                    : t.invisibleButtonElement &&
                      t.invisibleButtonElement.dispatchEvent(new Event('click'));
            }
        },
        Y = 'cx-qtx-sbtn-timestamp',
        X = 'cx-qtx-sbtn-localstorage-test';
    const tt = {
        saveUserInteractionTime: function (t) {
            if (t.enabled)
                try {
                    t.globalObj.localStorage.setItem(Y, +new Date());
                } catch (t) {
                    return;
                }
        },
        determineNotificationStatus: function (t) {
            return new Promise((e, o) => {
                var i;
                if (!t.enabled) return void e(!1);
                if (
                    !(function (t) {
                        var e;
                        if ('boolean' == typeof t._IS_LOCAL_STORAGE_AVAILABLE_CACHE)
                            return t._IS_LOCAL_STORAGE_AVAILABLE_CACHE;
                        const o =
                            null == t || null === (e = t.globalObj) || void 0 === e
                                ? void 0
                                : e.localStorage;
                        let i;
                        try {
                            o.setItem(X, 'true'), o.removeItem(X), (i = !0);
                        } catch (t) {
                            i = !1;
                        }
                        return (t._IS_LOCAL_STORAGE_AVAILABLE_CACHE = i), i;
                    })(t)
                )
                    return void e(!1);
                const n = null == t || null === (i = t.range) || void 0 === i ? void 0 : i.type;
                if ('months' !== n) return void o(new Error(`Invalid range type configured: ${n}`));
                const s = new Date().getMonth() + 1,
                    r = (function (t) {
                        var e, o;
                        return 'months' ===
                            (null == t || null === (e = t.range) || void 0 === e ? void 0 : e.type)
                            ? null == t || null === (o = t.range) || void 0 === o
                                ? void 0
                                : o.value.map((t) => window.parseInt(t, 10))
                            : [];
                    })(t),
                    a = r.indexOf(s) >= 0,
                    l = (function (t) {
                        try {
                            return t.globalObj.localStorage.getItem(Y);
                        } catch (t) {
                            return null;
                        }
                    })(t);
                if (!l) return void e(a);
                const h = parseInt(l, 10),
                    c = new Date(h).getMonth() + 1;
                e(a && s !== c);
            });
        }
    };
    let et,
        ot,
        it,
        nt,
        st = (t) => t;
    class rt extends G {
        constructor() {
            super(),
                (this._version = '1.0.2'),
                (this.apiContext = null),
                (this.notifyUser = null),
                (this.surveyLaunchMethod = 'invisibleButton'),
                (this.contextParams = {}),
                (this.fiori3Compatible = !1),
                (this.interceptUrl = ''),
                (this.contextRootPath = 'sap/qtx'),
                (this.notificationConfig = {
                    enabled: !0,
                    range: { type: 'months', value: [2, 5, 8, 11] }
                }),
                (this.title = 'Give Feedback'),
                (this.ariaLabel = 'Give Feedback'),
                (this.contextParamPaths = {
                    Q_Language: 'appcontext/languageTag',
                    language: 'appcontext/languageTag',
                    appFrameworkVersion: 'appcontext/appFrameworkVersion',
                    theme: 'appcontext/theme',
                    appId: 'appcontext/appId',
                    appVersion: 'appcontext/appVersion',
                    technicalAppComponentId: 'appcontext/technicalAppComponentId',
                    appTitle: 'appcontext/appTitle',
                    appSupportInfo: 'appcontext/appSupportInfo',
                    tenantId: 'session/tenantId',
                    tenantRole: 'session/tenantRole',
                    appFrameworkId: 'appcontext/appFrameworkId',
                    productName: 'session/productName',
                    platformType: 'session/platformType',
                    pushSrcType: 'push/pushSrcType',
                    pushSrcAppId: 'push/pushSrcAppId',
                    pushSrcTrigger: 'push/pushSrcTrigger',
                    clientAction: 'appcontext/clientAction',
                    previousTheme: 'appcontext/previousTheme',
                    followUpCount: 'appcontext/followUpCount',
                    deviceType: 'device/type',
                    orientation: 'device/orientation',
                    osName: 'device/osName',
                    browserName: 'device/browserName'
                }),
                (this.customContextParamPaths = {});
        }
        static get properties() {
            return {
                title: { type: String, attribute: 'title', reflect: !1 },
                ariaLabel: { type: String, attribute: 'aria-label', reflect: !1 },
                surveyLaunchMethod: {
                    type: String,
                    attribute: 'survey-launch-method',
                    reflect: !1
                },
                notifyUser: { type: Boolean, attribute: 'notify-user', reflect: !0 },
                notificationConfig: { type: Object, attribute: 'notification-config', reflect: !0 },
                interceptUrl: { type: String, attribute: 'intercept-url', reflect: !0 },
                customContextParamPaths: {
                    type: Object,
                    attribute: 'custom-context-param-paths',
                    reflect: !0
                },
                contextParamPaths: { type: Object, attribute: 'context-param-paths', reflect: !0 },
                contextRootPath: { type: String, attribute: 'context-root-path', reflect: !0 },
                contextParams: { type: Object, attribute: 'context-params', reflect: !0 },
                fiori3Compatible: { type: Boolean, attribute: 'fiori3-compatible', reflect: !0 }
            };
        }
        _onClick() {
            this._turnOffNotification(),
                tt.saveUserInteractionTime({ ...this.notificationConfig, globalObj: window }),
                this._runSurvey();
        }
        _turnOffNotification() {
            (this.notifyUser = !1), this.requestUpdate();
        }
        _runSurvey() {
            this._getAPIContext().then(
                (t) => {
                    const e = this.contextParams;
                    (this.apiContext = t),
                        K.setContextParameters(this.apiContext, e),
                        K.startSurvey(this.apiContext);
                },
                (t) => {
                    console.log(t);
                }
            );
        }
        _getAPIContext() {
            return this.apiContext
                ? Promise.resolve(this.apiContext)
                : K.init({
                      interceptUrl: this.interceptUrl,
                      globalObj: window,
                      contextRootPath: this.contextRootPath,
                      contextParamPaths: this.contextParamPaths,
                      customContextParamPaths: this.customContextParamPaths,
                      surveyLaunchMethod: this.surveyLaunchMethod
                  });
        }
        setContextParams(t) {
            this.contextParams = JSON.parse(JSON.stringify(t));
        }
        updateContextParam(t, e) {
            this.contextParams[t] = e;
        }
        connectedCallback() {
            super.connectedCallback(),
                this.addEventListener('click', this._onClick),
                this.setAttribute('aria-hidden', 'true'),
                tt
                    .determineNotificationStatus({ ...this.notificationConfig, globalObj: window })
                    .then(
                        (t) => {
                            null === this.notifyUser &&
                                ((this.notifyUser = t), this.requestUpdate());
                        },
                        (t) => {
                            console.log(t);
                        }
                    );
        }
        disconnectedCallback() {
            super.disconnectedCallback(),
                this.removeEventListener('click', this._onClick),
                this.apiContext && (K.destroy(this.apiContext), (this.apiContext = null));
        }
        render() {
            const t = this.fiori3Compatible
                ? k(
                      et ||
                          (et = st`<svg
  version="1.1"
  viewBox="0 0 16 15"
  width="16"
  height="15"
  xmlns="http://www.w3.org/2000/svg"
  xmlns:svg="http://www.w3.org/2000/svg"
>
  <g class="pathGroup">
      <path
          class="backgroundCircle"
          style="stroke-width:0.0257446"
          d="m 11.5,0.79276785 q 0.77234,0 1.441702,0.29606375 0.66936,0.2960636 1.171381,0.7980845 0.502022,0.5020211 0.798086,1.1713824 0.296063,0.6693614 0.296063,1.4417015 0,0.77234 -0.296063,1.4417015 Q 14.615105,6.6110627 14.113083,7.1130839 13.611062,7.6151046 12.941702,7.9111681 12.27234,8.2072317 11.5,8.2072317 q -0.77234,0 -1.441701,-0.2960636 Q 9.3889383,7.6151046 8.8869163,7.1130839 8.3848954,6.6110627 8.0888316,5.9417015 7.792768,5.27234 7.792768,4.5 q 0,-0.7723401 0.2960636,-1.4417015 Q 8.3848954,2.3889372 8.8869163,1.8869161 9.3889383,1.3848952 10.058299,1.0888316 10.72766,0.79276785 11.5,0.79276785 Z"
      />
      <path
          class="foregroundIcon"
          d="m 11.5,0 q 0.9375,0 1.75,0.359375 0.8125,0.35937501 1.421874,0.96875 Q 15.28125,1.9375 15.640626,2.75 16,3.5625 16,4.5 16,5.4375001 15.640626,6.2500002 15.28125,7.0625 14.671874,7.6718752 14.0625,8.2812502 13.25,8.6406251 12.4375,8.9999998 11.5,8.9999998 q -0.9375,0 -1.7499995,-0.3593747 Q 8.9375006,8.2812502 8.3281251,7.6718752 7.7187501,7.0625 7.359375,6.2500002 7.0000001,5.4375001 7.0000001,4.5 q 0,-0.9375 0.3593749,-1.75 Q 7.7187501,1.9375 8.3281251,1.328125 8.9375006,0.71875001 9.7500005,0.359375 10.5625,0 11.5,0 Z M 7.9375002,4.5 q 0,0.7500001 0.2812498,1.3906251 Q 8.5,6.53125 8.984375,7.0156251 9.4687505,7.5000001 10.109376,7.7812502 10.75,8.0625 11.5,8.0625 q 0.75,0 1.390624,-0.2812498 Q 13.53125,7.5000001 14.015625,7.0156251 14.5,6.53125 14.78125,5.8906251 15.062499,5.2500001 15.062499,4.5 q 0,-0.75 -0.281249,-1.3906249 Q 14.5,2.4687501 14.015625,1.9843751 13.53125,1.5 12.890624,1.21875 12.25,0.93750001 11.5,0.93750001 q -0.75,0 -1.390624,0.28124999 Q 9.4687505,1.5 8.984375,1.9843751 8.5,2.4687501 8.21875,3.1093751 7.9375002,3.75 7.9375002,4.5 Z M 0,3.9999998 Q 0,3.1875001 0.59375,2.59375 1.1875,2.0000002 2.0000002,2.0000002 h 4.59375 Q 6.375,2.40625 6.2187502,3 h -4.21875 Q 1.5624999,3 1.28125,3.3124999 0.99999999,3.59375 0.99999999,3.9999998 v 6.0000001 q 0,0.4375001 0.28125001,0.7187491 Q 1.5624999,11 2.0000002,11 h 1.9999996 v 2.500001 L 6.0000001,11.03125 13.000001,11 q 0.4375,0 0.718749,-0.281251 Q 14,10.4375 14,10.000001 V 9.406253 Q 14.3125,9.218753 14.5625,9.0625025 14.8125,8.9062526 15,8.7500027 v 1.2500003 q 0,0.84375 -0.578124,1.421875 -0.578126,0.578125 -1.421875,0.578125 H 6.5000001 l -2.4375,2.875 q -0.125,0.125001 -0.4062502,0.125001 -0.2499998,0 -0.4531248,-0.171875 Q 3,14.656254 3,14.375003 V 12.000004 H 2.0000002 q -0.8437503,0 -1.4218752,-0.578125 Q 0,10.84375 0,9.9999999 Z M 12.09375,3.0625001 Q 12.09375,2.75 12.296874,2.59375 12.5,2.4375 12.750001,2.4375 q 0.25,0 0.437499,0.15625 0.1875,0.15625 0.1875,0.4687501 0,0.3125 -0.1875,0.4687501 Q 13.000001,3.6875 12.750001,3.6875 12.5,3.6875 12.296874,3.5312502 12.09375,3.3750001 12.09375,3.0625001 Z M 10.249999,2.4375 q 0.25,0 0.437501,0.15625 0.187501,0.15625 0.187501,0.4687501 0,0.3125 -0.187501,0.4687501 Q 10.499999,3.6875 10.249999,3.6875 9.9999999,3.6875 9.7968755,3.5312502 9.5937501,3.3750001 9.5937501,3.0625001 9.5937501,2.75 9.7968755,2.59375 9.9999999,2.4375 10.249999,2.4375 Z m -1.0937487,2.7499999 0.062501,-0.062499 q 0.093749,-0.093751 0.21875,-0.093751 0.1562504,0 0.2500004,0.125 0.8437513,0.9375001 1.8124993,0.9375001 1.031251,0 1.8125,-0.9375001 0.09374,-0.093751 0.25,-0.093751 0.125,0 0.21875,0.093751 h 0.03125 q 0,0.031249 0.01561,0.031249 0.01562,0 0.01562,0.03125 0.125001,0.1249999 0.125001,0.21875 0,0.125 -0.09376,0.21875 -0.5,0.6250001 -1.109375,0.9218751 -0.609376,0.2968747 -1.234374,0.2968747 -0.625001,0 -1.250001,-0.2968747 Q 9.6562318,6.2812505 9.1249813,5.6562504 9.0312322,5.5625 9.0312322,5.4687503 q 0,-0.03125 0.015627,-0.109375 0.015628,-0.078125 0.1093752,-0.1718751 z"
          style="stroke-width:0.0312499"
      />
  </g>
</svg>
`)
                  )
                : k(
                      ot ||
                          (ot = st`<svg
    version="1.1"
    width="18.190166"
    height="20"
    viewBox="0 0 18.190167 20"
    xmlns="http://www.w3.org/2000/svg"
    xmlns:svg="http://www.w3.org/2000/svg"
>
    <g class="pathGroup">
        <path
            d="M 3.665181,2.7601972 H 2.7601972 c -0.9996179,0 -1.80996746,0.8103496 -1.80996746,1.8099675 v 9.0498373 c 0,0.999645 0.81034956,1.809967 1.80996746,1.809967 h 1.8099675 v 3.619936 L 8.1900998,15.429969 H 15.42997 c 0.999645,0 1.809967,-0.810322 1.809967,-1.809967 v -0.904984"
            stroke-linecap="round"
            stroke-linejoin="round"
        />
        <path
            class="smiley"
            fill-rule="evenodd"
            clip-rule="evenodd"
            d="m 11.810035,11.810035 c 2.998844,0 5.429902,-2.4310584 5.429902,-5.4299028 0,-2.9988537 -2.431058,-5.42990246 -5.429902,-5.42990246 -2.9988444,0 -5.4299028,2.43104876 -5.4299028,5.42990246 0,2.9988444 2.4310584,5.4299028 5.4299028,5.4299028 z"
            stroke-linecap="round"
            stroke-linejoin="round"
        />
        <path
            d="m 10.000068,7.2851161 c 0,0 0.452491,0.9049837 1.809967,0.9049837 1.357475,0 1.809967,-0.9049837 1.809967,-0.9049837"
            stroke-linecap="round"
            stroke-linejoin="round"
        />
        <path
            class="eye"
            fill-rule="evenodd"
            clip-rule="evenodd"
            d="m 10.000068,5.4751485 c 0.499821,0 0.904983,-0.4051794 0.904983,-0.9049838 0,-0.4998044 -0.405162,-0.9049838 -0.904983,-0.9049838 -0.4998231,0 -0.904984,0.4051794 -0.904984,0.9049838 0,0.4998044 0.4051609,0.9049838 0.904984,0.9049838 z"
        />
        <path
            class="eye"
            fill-rule="evenodd"
            clip-rule="evenodd"
            d="m 13.620002,5.4751485 c 0.499823,0 0.904984,-0.4051794 0.904984,-0.9049838 0,-0.4998044 -0.405161,-0.9049838 -0.904984,-0.9049838 -0.499822,0 -0.904984,0.4051794 -0.904984,0.9049838 0,0.4998044 0.405162,0.9049838 0.904984,0.9049838 z"
        />
    </g>
</svg>
`)
                  );
            return k(
                it ||
                    (it = st`
            <button title="${0}" aria-label="${0}">
                ${0}
            </button>
        `),
                this.title,
                this.ariaLabel,
                t
            );
        }
        static get styles() {
            return ((t, ...o) => {
                const n =
                    1 === t.length
                        ? t[0]
                        : o.reduce(
                              (e, o, i) =>
                                  e +
                                  ((t) => {
                                      if (!0 === t._$cssResult$) return t.cssText;
                                      if ('number' == typeof t) return t;
                                      throw Error(
                                          "Value passed to 'css' function must be a 'css' function result: " +
                                              t +
                                              ". Use 'unsafeCSS' to pass non-literal values, but take care to ensure page security."
                                      );
                                  })(o) +
                                  t[i + 1],
                              t[0]
                          );
                return new i(n, e);
            })(
                nt ||
                    (nt = st`/*
 * Prevent focus effect on the host, the button only should be focussed.
 */
:host(:focus) {
    outline: none;
    box-shadow: none;
}

:host(:focus) button {
    background-color: initial;
}

button {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    width: var(--qtxSurveyButton_Size, 2rem);
    height: var(--qtxSurveyButton_Size, 2rem);

    outline: none;

    shape-rendering: geometricprecision;

    /* Fiori Next buttons have transitions */
    -webkit-transition: 0.3s ease-in-out;
    transition: 0.3s ease-in-out;

    font-weight: 400;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    margin: 0;
    border: 0;
    -webkit-box-pack: center;
    -ms-flex-pack: center;
    justify-content: center;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
    cursor: pointer;
    position: relative;
    padding: 6px;
    -webkit-box-shadow: none;
    box-shadow: none;
    border-radius: var(--sapButton_BorderCornerRadius, 0.5rem);
    background: 0 0;
}

button.is-focus,
button:focus {
    z-index: 5;
    background: var(--sapShell_Hover_Background, transparent);
    outline: 0;
    border-color: #fff;
    -webkit-box-shadow: 0 0 2px rgba(27, 144, 255, 0.16),
        0 8px 16px rgba(27, 144, 255, 0.16), 0 0 0 0.125rem #1b90ff,
        inset 0 0 0 0.125rem #fff;
    box-shadow: 0 0 2px rgba(27, 144, 255, 0.16),
        0 8px 16px rgba(27, 144, 255, 0.16), 0 0 0 0.125rem #1b90ff,
        inset 0 0 0 0.125rem #fff;
}

:host([fiori3-compatible]) button {
    /*
     * Fiori 3: use correct sizing
     */
    width: var(--qtxSurveyButton_Size, 2.25rem);
    height: var(--qtxSurveyButton_Size, 2.25rem);

    /*
     * Fiori 3: disable Fiori Next transitions + box shadow
     */
    -webkit-transition: none;
    transition: none;
    box-shadow: none;
    -webkit-box-shadow: none;
}
:host([fiori3-compatible]):host(:hover) button {
    box-shadow: none;
    -webkit-box-shadow: none;
}
:host([fiori3-compatible]):host(:active) button {
    box-shadow: none;
    -webkit-box-shadow: none;
}

/*
 * Fiori3: create visible focus area
 */
:host([fiori3-compatible]):host(:focus) button:after {
    content: "";
    position: absolute;
    width: auto;
    height: auto;
    top: 0.0625rem;
    left: 0.0625rem;
    right: 0.0625rem;
    bottom: 0.0625rem;
    border: var(--sapContent_FocusWidth, 0.0625rem) dotted
        var(--sapContent_ContrastFocusColor, #fff);
    border-radius: 4px;
}

:host(:hover) button {
    background-color: var(--sapShell_Hover_Background, transparent);

    -webkit-box-shadow: 0 0 2px rgba(131, 150, 168, 0.16),
        0 8px 16px rgba(131, 150, 168, 0.16);
    box-shadow: 0 0 2px rgba(131, 150, 168, 0.16),
        0 8px 16px rgba(131, 150, 168, 0.16);
}
:host(:hover) path {
    stroke: var(--sapShell_Active_TextColor, #475e75);
}
:host(:hover) .eye,
:host(:hover) .foregroundIcon {
    fill: var(--sapShell_Active_TextColor, #475e75);
    stroke: transparent;
}
:host(:active) button {
    -webkit-box-shadow: 0 0 2px rgba(131, 150, 168, 0.16),
        0 2px 4px rgba(131, 150, 168, 0.16);
    box-shadow: 0 0 2px rgba(131, 150, 168, 0.16),
        0 2px 4px rgba(131, 150, 168, 0.16);
    background: var(--sapShell_Active_Background, #fff);
}

:host([notify-user]) .smiley,
:host([notify-user]) .backgroundCircle {
    fill: var(
        --qtxSurveyButton_NotificationColor,
        #64edd2
    ); /* Teal 2 */
}
:host([notify-user][fiori3-compatible]) .smiley,
:host([notify-user][fiori3-compatible]) .backgroundCircle {
    fill: var(
        --qtxSurveyButton_NotificationColor,
        var(--sapIndicationColor_6, #0f828f)
    );
}

:host([fiori3-compatible]) .pathGroup {
    transform: scale(var(--qtxSurveyButton_IconScale, 1))
        translate(0, var(--qtxSurveyButton_IconOffsetY, 0));
}
.pathGroup {
    transform: scale(var(--qtxSurveyButton_IconScale, 1))
        translate(0, var(--qtxSurveyButton_IconOffsetY, 0));
    transform-origin: center;
    fill: none;
}

path {
    stroke: var(--sapShell_InteractiveTextColor, #5b738b);
    stroke-width: 2px;
    vector-effect: non-scaling-stroke;
}
.eye,
.foregroundIcon {
    fill: var(--sapShell_InteractiveTextColor, #5b738b);
    stroke: transparent;
}

button::after,
button::before {
    -webkit-box-sizing: inherit;
    box-sizing: inherit;
    font-size: inherit;
}

button.is-pressed,
button[aria-pressed="true"] {
    -webkit-box-shadow: 0 0 2px rgba(131, 150, 168, 0.16),
        0 2px 4px rgba(131, 150, 168, 0.16);
    box-shadow: 0 0 2px rgba(131, 150, 168, 0.16),
        0 2px 4px rgba(131, 150, 168, 0.16);
    background: var(--sapShell_Active_Background, #fff);
}
`)
            );
        }
    }
    var at, lt, ht;
    (at = rt),
        (lt = 'shadowRootOptions'),
        (ht = { ...G.shadowRootOptions, mode: 'closed', delegatesFocus: 'true' }),
        lt in at
            ? Object.defineProperty(at, lt, {
                  value: ht,
                  enumerable: !0,
                  configurable: !0,
                  writable: !0
              })
            : (at[lt] = ht),
        window.customElements.define('cx-qtx-survey-button', rt);
})();

window.__smartedit__.addDecoratorPayload("Component", "QualtricsComponent", {
    selector: 'se-qualtrics',
    template: `
        <cx-qtx-survey-button
            fiori3-compatible="true"
            style="--qtxSurveyButton_Size:40px; --sapContent_ContrastFocusColor: transparent;"
            title="{{ 'se.toolbar.qualtrics.title' | translate }}"
            [attr.intercept-url]="interceptUrl"
            [attr.context-params]="contextParamsString"
            (click)="onClick()"
        >
        </cx-qtx-survey-button>
    `
});
let QualtricsComponent = class QualtricsComponent {
    constructor(translateService, settingService, userTrackingService) {
        this.translateService = translateService;
        this.settingService = settingService;
        this.userTrackingService = userTrackingService;
        this.interceptUrl = '';
        this.contextParamsString = '';
        this.contextParams = {};
    }
    ngOnDestroy() {
        document.querySelector('cx-qtx-survey-button').remove();
    }
    ngOnInit() {
        this.contextParams = this._getFixedContextParams();
        this.settingService.load().then((settings) => {
            const tenantId = `${settings['modelt.customer.code']}-${settings['modelt.project.code']}-${settings['modelt.environment.code']}`;
            const tenantRole = settings['modelt.environment.type'];
            const appVersion = settings['build.version.api'];
            this.contextParamsString = JSON.stringify(Object.assign(Object.assign({}, this.contextParams), { tenantId,
                tenantRole,
                appVersion }));
            this.interceptUrl = settings['smartedit.qualtrics.interceptUrl'];
        });
        // change language when customer switch language
        this.translateService.onLangChange.subscribe((result) => {
            const language = result.lang;
            const productName = result.translations['se.application.name'];
            this.contextParamsString = JSON.stringify(Object.assign(Object.assign({}, this.contextParams), { language,
                productName }));
        });
    }
    onClick() {
        this.userTrackingService.trackingUserAction(smarteditcommons.USER_TRACKING_FUNCTIONALITY.HEADER_TOOL, 'Give Feedback');
    }
    _getFixedContextParams() {
        return {
            appFrameworkId: 4,
            appFrameworkVersion: core.VERSION.full,
            appId: 'SmartEdit',
            appTitle: 'SmartEdit',
            appSupportInfo: 'CEC-COM-ADM-SEDIT',
            pushSrcType: 2
        };
    }
};
QualtricsComponent = __decorate([
    core.Component({
        selector: 'se-qualtrics',
        template: `
        <cx-qtx-survey-button
            fiori3-compatible="true"
            style="--qtxSurveyButton_Size:40px; --sapContent_ContrastFocusColor: transparent;"
            title="{{ 'se.toolbar.qualtrics.title' | translate }}"
            [attr.intercept-url]="interceptUrl"
            [attr.context-params]="contextParamsString"
            (click)="onClick()"
        >
        </cx-qtx-survey-button>
    `
    }),
    __metadata("design:paramtypes", [core$2.TranslateService,
        smarteditcommons.SettingsService,
        smarteditcommons.UserTrackingService])
], QualtricsComponent);

let TopToolbarsModule = class TopToolbarsModule {
};
TopToolbarsModule = __decorate([
    core.NgModule({
        schemas: [core.CUSTOM_ELEMENTS_SCHEMA],
        imports: [
            core$1.PopoverModule,
            common.CommonModule,
            smarteditcommons.SeGenericEditorModule,
            core$2.TranslateModule.forChild(),
            smarteditcommons.TooltipModule
        ],
        declarations: [
            smarteditcommons.HeaderLanguageDropdownComponent,
            UserAccountComponent,
            InflectionPointSelectorComponent,
            ExperienceSelectorButtonComponent,
            ExperienceSelectorComponent,
            DeviceSupportWrapperComponent,
            ExperienceSelectorWrapperComponent,
            LogoComponent,
            QualtricsComponent
        ],
        entryComponents: [
            smarteditcommons.HeaderLanguageDropdownComponent,
            UserAccountComponent,
            InflectionPointSelectorComponent,
            ExperienceSelectorButtonComponent,
            ExperienceSelectorComponent,
            DeviceSupportWrapperComponent,
            ExperienceSelectorWrapperComponent,
            LogoComponent,
            QualtricsComponent
        ],
        exports: [
            smarteditcommons.HeaderLanguageDropdownComponent,
            UserAccountComponent,
            InflectionPointSelectorComponent,
            ExperienceSelectorButtonComponent,
            ExperienceSelectorComponent,
            DeviceSupportWrapperComponent,
            ExperienceSelectorWrapperComponent,
            LogoComponent,
            QualtricsComponent
        ]
    })
], TopToolbarsModule);

exports.ToolbarModule = class ToolbarModule {
};
exports.ToolbarModule = __decorate([
    core.NgModule({
        imports: [
            TopToolbarsModule,
            common.CommonModule,
            core$2.TranslateModule.forChild(),
            smarteditcommons.CompileHtmlModule,
            smarteditcommons.PropertyPipeModule,
            smarteditcommons.ResizeObserverModule,
            core$1.PopoverModule,
            smarteditcommons.ClickOutsideModule,
            smarteditcommons.PreventVerticalOverflowModule
        ],
        providers: [
            {
                provide: smarteditcommons.IToolbarServiceFactory,
                useClass: ToolbarServiceFactory
            }
        ],
        declarations: [
            ToolbarActionComponent,
            ToolbarActionOutletComponent,
            ToolbarComponent,
            ToolbarItemContextComponent,
            ToolbarSectionItemComponent
        ],
        entryComponents: [
            ToolbarActionComponent,
            ToolbarActionOutletComponent,
            ToolbarComponent,
            ToolbarItemContextComponent,
            ToolbarSectionItemComponent
        ],
        exports: [
            ToolbarActionComponent,
            ToolbarActionOutletComponent,
            ToolbarComponent,
            ToolbarItemContextComponent,
            ToolbarSectionItemComponent
        ]
    })
], exports.ToolbarModule);

window.__smartedit__.addDecoratorPayload("Component", "AnnouncementBoardComponent", {
    selector: 'se-announcement-board',
    changeDetection: core.ChangeDetectionStrategy.OnPush,
    template: `<ng-container *ngIf="(announcements$ | async) as announcements"><div class="se-announcement-board"><se-announcement *ngFor="
                let announcement of (announcements | seReverse);
                trackBy: annnouncementTrackBy;
                let i = index
            " id="se-announcement-{{ i }}" [announcement]="announcement"></se-announcement></div></ng-container>`
});
let AnnouncementBoardComponent = class AnnouncementBoardComponent {
    constructor(announcementService) {
        this.announcementService = announcementService;
    }
    ngOnInit() {
        this.announcements$ = this.announcementService.getAnnouncements();
    }
    annnouncementTrackBy(index, item) {
        return item.id;
    }
};
AnnouncementBoardComponent = __decorate([
    core.Component({
        selector: 'se-announcement-board',
        changeDetection: core.ChangeDetectionStrategy.OnPush,
        template: `<ng-container *ngIf="(announcements$ | async) as announcements"><div class="se-announcement-board"><se-announcement *ngFor="
                let announcement of (announcements | seReverse);
                trackBy: annnouncementTrackBy;
                let i = index
            " id="se-announcement-{{ i }}" [announcement]="announcement"></se-announcement></div></ng-container>`
    }),
    __param(0, core.Inject(smarteditcommons.IAnnouncementService)),
    __metadata("design:paramtypes", [AnnouncementService])
], AnnouncementBoardComponent);

window.__smartedit__.addDecoratorPayload("Component", "AnnouncementComponent", {
    selector: 'se-announcement',
    changeDetection: core.ChangeDetectionStrategy.OnPush,
    animations: [
        animations.trigger('fadeAnimation', [
            animations.transition(':enter', [
                animations.style({
                    opacity: 0,
                    transform: 'rotateY(90deg)'
                }),
                animations.animate('0.5s'),
                animations.style({
                    opacity: 1,
                    transform: 'translateX(0px)'
                })
            ]),
            animations.transition(':leave', [
                animations.animate('0.25s'),
                animations.style({
                    opacity: '0',
                    transform: 'translateX(100%)'
                })
            ])
        ])
    ],
    template: `<div class="se-announcement-content"><span *ngIf="isCloseable()" class="sap-icon--decline se-announcement-close" (click)="closeAnnouncement()"></span><div *ngIf="hasMessage()"><h4 *ngIf="hasMessageTitle()">{{ announcement.messageTitle | translate }}</h4><span>{{ announcement.message | translate }}</span></div><ng-container *ngIf="hasComponent()"><ng-container *ngComponentOutlet="announcement.component; injector: announcementInjector"></ng-container></ng-container></div>`
});
let AnnouncementComponent = class AnnouncementComponent {
    constructor(announcementService, injector) {
        this.announcementService = announcementService;
        this.injector = injector;
    }
    get fadeAnimation() {
        return true;
    }
    ngOnChanges() {
        this.createAnnouncementInjector();
    }
    hasComponent() {
        return this.announcement.hasOwnProperty('component');
    }
    hasMessage() {
        return this.announcement.hasOwnProperty('message');
    }
    hasMessageTitle() {
        return this.announcement.hasOwnProperty('messageTitle');
    }
    isCloseable() {
        return this.announcement.hasOwnProperty('closeable')
            ? this.announcement.closeable
            : ANNOUNCEMENT_DEFAULTS.closeable;
    }
    closeAnnouncement() {
        this.announcementService.closeAnnouncement(this.announcement.id);
    }
    createAnnouncementInjector() {
        this.announcementInjector = core.Injector.create({
            parent: this.injector,
            providers: [
                {
                    provide: smarteditcommons.ANNOUNCEMENT_DATA,
                    useValue: Object.assign({ id: this.announcement.id }, this.announcement.data)
                }
            ]
        });
    }
};
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], AnnouncementComponent.prototype, "announcement", void 0);
__decorate([
    core.HostBinding('@fadeAnimation'),
    __metadata("design:type", Boolean),
    __metadata("design:paramtypes", [])
], AnnouncementComponent.prototype, "fadeAnimation", null);
AnnouncementComponent = __decorate([
    core.Component({
        selector: 'se-announcement',
        changeDetection: core.ChangeDetectionStrategy.OnPush,
        animations: [
            animations.trigger('fadeAnimation', [
                animations.transition(':enter', [
                    animations.style({
                        opacity: 0,
                        transform: 'rotateY(90deg)'
                    }),
                    animations.animate('0.5s'),
                    animations.style({
                        opacity: 1,
                        transform: 'translateX(0px)'
                    })
                ]),
                animations.transition(':leave', [
                    animations.animate('0.25s'),
                    animations.style({
                        opacity: '0',
                        transform: 'translateX(100%)'
                    })
                ])
            ])
        ],
        template: `<div class="se-announcement-content"><span *ngIf="isCloseable()" class="sap-icon--decline se-announcement-close" (click)="closeAnnouncement()"></span><div *ngIf="hasMessage()"><h4 *ngIf="hasMessageTitle()">{{ announcement.messageTitle | translate }}</h4><span>{{ announcement.message | translate }}</span></div><ng-container *ngIf="hasComponent()"><ng-container *ngComponentOutlet="announcement.component; injector: announcementInjector"></ng-container></ng-container></div>`
    }),
    __metadata("design:paramtypes", [smarteditcommons.IAnnouncementService, core.Injector])
], AnnouncementComponent);

window.__smartedit__.addDecoratorPayload("Component", "HotkeyNotificationComponent", {
    selector: 'se-hotkey-notification',
    changeDetection: core.ChangeDetectionStrategy.OnPush,
    template: `<div class="se-notification__hotkey"><div *ngFor="let key of hotkeyNames; let last = last"><div class="se-notification__hotkey--key"><span>{{ key }}</span></div><span *ngIf="!last" class="se-notification__hotkey__icon--add">+</span></div><div class="se-notification__hotkey--text"><div class="se-notification__hotkey--title">{{ title }}</div><div class="se-notification__hotkey--message">{{ message }}</div></div></div>`
});
let HotkeyNotificationComponent = class HotkeyNotificationComponent {
};
__decorate([
    core.Input(),
    __metadata("design:type", Array)
], HotkeyNotificationComponent.prototype, "hotkeyNames", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", String)
], HotkeyNotificationComponent.prototype, "title", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", String)
], HotkeyNotificationComponent.prototype, "message", void 0);
HotkeyNotificationComponent = __decorate([
    core.Component({
        selector: 'se-hotkey-notification',
        changeDetection: core.ChangeDetectionStrategy.OnPush,
        template: `<div class="se-notification__hotkey"><div *ngFor="let key of hotkeyNames; let last = last"><div class="se-notification__hotkey--key"><span>{{ key }}</span></div><span *ngIf="!last" class="se-notification__hotkey__icon--add">+</span></div><div class="se-notification__hotkey--text"><div class="se-notification__hotkey--title">{{ title }}</div><div class="se-notification__hotkey--message">{{ message }}</div></div></div>`
    })
], HotkeyNotificationComponent);

window.__smartedit__.addDecoratorPayload("Component", "PerspectiveSelectorHotkeyNotificationComponent", {
    selector: 'se-perspective-selector-hotkey-notification',
    changeDetection: core.ChangeDetectionStrategy.OnPush,
    template: `<se-hotkey-notification [hotkeyNames]="['esc']" [title]="'se.application.status.hotkey.title' | translate" [message]="'se.application.status.hotkey.message' | translate"></se-hotkey-notification>`
});
let PerspectiveSelectorHotkeyNotificationComponent = class PerspectiveSelectorHotkeyNotificationComponent {
};
PerspectiveSelectorHotkeyNotificationComponent = __decorate([
    smarteditcommons.SeCustomComponent(),
    core.Component({
        selector: 'se-perspective-selector-hotkey-notification',
        changeDetection: core.ChangeDetectionStrategy.OnPush,
        template: `<se-hotkey-notification [hotkeyNames]="['esc']" [title]="'se.application.status.hotkey.title' | translate" [message]="'se.application.status.hotkey.message' | translate"></se-hotkey-notification>`
    })
], PerspectiveSelectorHotkeyNotificationComponent);

/** @internal */
let HotkeyNotificationModule = class HotkeyNotificationModule {
};
HotkeyNotificationModule = __decorate([
    core.NgModule({
        imports: [common.CommonModule, smarteditcommons.TranslationModule.forChild()],
        declarations: [HotkeyNotificationComponent, PerspectiveSelectorHotkeyNotificationComponent],
        entryComponents: [HotkeyNotificationComponent, PerspectiveSelectorHotkeyNotificationComponent]
    })
], HotkeyNotificationModule);

window.__smartedit__.addDecoratorPayload("Component", "InvalidRouteComponent", { selector: 'empty', template: "<div>This page doesn't exist</div>" });
/**
 * Component that is displayed when Angular route has not been found
 */
let InvalidRouteComponent = class InvalidRouteComponent {
};
InvalidRouteComponent = __decorate([
    core.Component({ selector: 'empty', template: "<div>This page doesn't exist</div>" })
], InvalidRouteComponent);

/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
/**
 * Backwards compatibility for partners and downstream teams
 * The deprecated modules below were moved to smarteditServicesModule
 *
 * IMPORTANT: THE DEPRECATED MODULES WILL NOT BE AVAILABLE IN FUTURE RELEASES
 */
function surpressDiErrorForDeprecated() {
    // TODO: remove after personalization team clean up legacy modules
    angular.module('alertServiceModule', ['legacySmarteditCommonsModule']);
    angular.module('smarteditServicesModule', []);
    angular.module('modalServiceModule', []);
    angular.module('functionsModule', []);
}
const deprecate = () => {
    surpressDiErrorForDeprecated();
};

deprecate();
// eslint-disable-next-line @typescript-eslint/no-var-requires
const NgRouteModule = require('angular-route'); // Only supports CommonJS
// eslint-disable-next-line @typescript-eslint/no-var-requires
const NgUiBootstrapModule = require('angular-ui-bootstrap'); // Only supports CommonJS
const TOP_LEVEL_MODULE_NAME = 'smarteditcontainer';
// eslint-disable-next-line @typescript-eslint/ban-ts-comment
// @ts-ignore
let /* @ngInject */ Smarteditcontainer = 
/** @internal */
class /* @ngInject */ Smarteditcontainer {
};
/* @ngInject */ Smarteditcontainer = __decorate([
    smarteditcommons.SeModule({
        imports: [
            smarteditcommons.TemplateCacheDecoratorModule,
            NgRouteModule,
            NgUiBootstrapModule,
            'coretemplates',
            'paginationFilterModule',
            'resourceLocationsModule',
            'seConstantsModule',
            smarteditcommons.GenericEditorModule
        ],
        providers: [],
        config: ["$provide", "LANDING_PAGE_PATH", "STORE_FRONT_CONTEXT", "$routeProvider", "$logProvider", ($provide, LANDING_PAGE_PATH, STORE_FRONT_CONTEXT, $routeProvider, $logProvider) => {
            'ngInject';
            smarteditcommons.instrument($provide, (arg) => smarteditcommons.objectUtils.readObjectStructure(arg), TOP_LEVEL_MODULE_NAME);
            // Due to not working Angular <-> AngularJS navigation (issues with $locationShim),
            // it is not possible to register unified routes that will handle the navigation properly.
            // Routes must be registered as an Angular routes at once, when each route component has been migrated to Angular.
            // Until then, each route must register downgraded component.
            smarteditcommons.SeRouteService.init($routeProvider);
            smarteditcommons.SeRouteService.provideLegacyRoute({
                path: LANDING_PAGE_PATH,
                route: {
                    redirectTo: smarteditcommons.NG_ROUTE_PREFIX
                }
            });
            smarteditcommons.SeRouteService.provideLegacyRoute({
                path: `${LANDING_PAGE_PATH}sites/:siteId`,
                route: {
                    redirectTo: `${smarteditcommons.NG_ROUTE_PREFIX}/sites/:siteId`
                }
            });
            smarteditcommons.SeRouteService.provideLegacyRoute({
                path: STORE_FRONT_CONTEXT,
                route: {
                    redirectTo: `${smarteditcommons.NG_ROUTE_PREFIX}${STORE_FRONT_CONTEXT}`
                }
            });
            $logProvider.debugEnabled(false);
        }]
    })
    /** @internal */
], /* @ngInject */ Smarteditcontainer);

const LEGACY_APP_NAME = 'legacyApp';
window.__smartedit__.addDecoratorPayload("Component", "SmarteditcontainerComponent", {
    selector: smarteditcommons.SMARTEDITCONTAINER_COMPONENT_NAME,
    template: `
        <router-outlet></router-outlet>
        <div ng-attr-id="${LEGACY_APP_NAME}">
            <se-announcement-board></se-announcement-board>
            <se-notification-panel></se-notification-panel>
            <div ng-view></div>
        </div>
    `
});
let SmarteditcontainerComponent = class SmarteditcontainerComponent {
    constructor(translateService, injector, upgrade, elementRef, bootstrapIndicator) {
        this.translateService = translateService;
        this.upgrade = upgrade;
        this.elementRef = elementRef;
        this.bootstrapIndicator = bootstrapIndicator;
        this.legacyAppName = LEGACY_APP_NAME;
        this.legacyAppName = LEGACY_APP_NAME;
        this.setApplicationTitle();
        smarteditcommons.registerCustomComponents(injector);
    }
    ngOnInit() {
        /*
         * for e2e purposes:
         * in e2e, we sometimes add some test code in the parent frame to be added to the runtime
         * since we only bootstrap within smarteditcontainer-component node,
         * this code will be ignored unless added into the component before legacy AnguylarJS bootstrapping
         */
        Array.prototype.slice
            .call(document.body.childNodes)
            .filter((childNode) => !this.isAppComponent(childNode) && !this.isSmarteditLoader(childNode))
            .forEach((childNode) => {
            this.legacyAppNode.appendChild(childNode);
        });
    }
    ngAfterViewInit() {
        this.upgrade.bootstrap(this.legacyAppNode, [Smarteditcontainer.moduleName], { strictDi: false });
        this.bootstrapIndicator.setSmarteditContainerReady();
    }
    setApplicationTitle() {
        this.translateService.get('se.application.name').subscribe((pageTitle) => {
            document.title = pageTitle;
        });
    }
    get legacyAppNode() {
        // return this.elementRef.nativeElement.querySelector(`#${this.legacyAppName}`);
        return this.elementRef.nativeElement.querySelector(`div[ng-attr-id="${this.legacyAppName}"]`);
    }
    isAppComponent(childNode) {
        return (childNode.nodeType === Node.ELEMENT_NODE &&
            childNode.tagName === smarteditcommons.SMARTEDITCONTAINER_COMPONENT_NAME.toUpperCase());
    }
    isSmarteditLoader(childNode) {
        return (childNode.nodeType === Node.ELEMENT_NODE &&
            (childNode.id === 'smarteditloader' ||
                childNode.tagName === smarteditcommons.SMARTEDITLOADER_COMPONENT_NAME.toUpperCase()));
    }
};
SmarteditcontainerComponent = __decorate([
    core.Component({
        selector: smarteditcommons.SMARTEDITCONTAINER_COMPONENT_NAME,
        template: `
        <router-outlet></router-outlet>
        <div ng-attr-id="${LEGACY_APP_NAME}">
            <se-announcement-board></se-announcement-board>
            <se-notification-panel></se-notification-panel>
            <div ng-view></div>
        </div>
    `
    }),
    __metadata("design:paramtypes", [core$2.TranslateService,
        core.Injector,
        _static.UpgradeModule,
        core.ElementRef,
        smarteditcommons.AngularJSBootstrapIndicatorService])
], SmarteditcontainerComponent);

window.__smartedit__.addDecoratorPayload("Component", "NotificationComponent", {
    selector: 'se-notification',
    changeDetection: core.ChangeDetectionStrategy.OnPush,
    template: `<div class="se-notification" id="{{ id }}" *ngIf="notification"><div [seCustomComponentOutlet]="notification.componentName"></div></div>`
});
let NotificationComponent = class NotificationComponent {
    ngOnInit() {
        this.id =
            this.notification && this.notification.id
                ? 'se-notification-' + this.notification.id
                : '';
    }
};
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], NotificationComponent.prototype, "notification", void 0);
NotificationComponent = __decorate([
    core.Component({
        selector: 'se-notification',
        changeDetection: core.ChangeDetectionStrategy.OnPush,
        template: `<div class="se-notification" id="{{ id }}" *ngIf="notification"><div [seCustomComponentOutlet]="notification.componentName"></div></div>`
    })
], NotificationComponent);

window.__smartedit__.addDecoratorPayload("Component", "NotificationPanelComponent", {
    selector: 'se-notification-panel',
    changeDetection: core.ChangeDetectionStrategy.OnPush,
    template: `<ng-container *ngIf="(notifications$ | async) as notifications"><div class="se-notification-panel" *ngIf="notifications.length > 0" [ngClass]="{'is-mouseover': isMouseOver}" (mouseenter)="onMouseEnter()"><div><se-notification *ngFor="let notification of (notifications | seReverse)" [notification]="notification"></se-notification></div></div></ng-container>`
});
let NotificationPanelComponent = class NotificationPanelComponent {
    constructor(notificationService, notificationMouseLeaveDetectionService, systemEventService, iframeManagerService, windowUtils, element, yjQuery, cd) {
        this.notificationService = notificationService;
        this.notificationMouseLeaveDetectionService = notificationMouseLeaveDetectionService;
        this.systemEventService = systemEventService;
        this.iframeManagerService = iframeManagerService;
        this.windowUtils = windowUtils;
        this.element = element;
        this.yjQuery = yjQuery;
        this.cd = cd;
        this.notificationPanelBounds = null;
        this.iFrameNotificationPanelBounds = null;
        this.addMouseMoveEventListenerTimeout = null;
    }
    ngOnInit() {
        this.notifications$ = this.notificationService.getNotifications();
        this.isMouseOver = false;
        this.windowUtils.getWindow().addEventListener('resize', () => this.onResize());
        this.unRegisterNotificationChangedEventHandler = this.systemEventService.subscribe(smarteditcommons.EVENT_NOTIFICATION_CHANGED, () => this.onNotificationChanged());
    }
    ngAfterViewInit() {
        this.$element = this.yjQuery(this.element.nativeElement);
    }
    ngOnDestroy() {
        this.windowUtils.getWindow().removeEventListener('resize', () => this.onResize());
        this.notificationMouseLeaveDetectionService.stopDetection();
        this.unRegisterNotificationChangedEventHandler();
    }
    onMouseEnter() {
        this.isMouseOver = true;
        this.cd.detectChanges();
        if (!this.hasBounds()) {
            this.calculateBounds();
        }
        this.addMouseMoveEventListenerTimeout =
            this.addMouseMoveEventListenerTimeout ||
                setTimeout(() => this.addMouseMoveEventListener(), 10);
    }
    onMouseLeave() {
        this.isMouseOver = false;
        this.cd.detectChanges();
    }
    getIFrame() {
        return this.iframeManagerService.getIframe()[0];
    }
    getNotificationPanel() {
        return this.$element.find('.se-notification-panel');
    }
    calculateNotificationPanelBounds() {
        const notificationPanel = this.getNotificationPanel();
        const notificationPanelPosition = notificationPanel.position();
        this.notificationPanelBounds = {
            x: Math.floor(notificationPanelPosition.left),
            y: Math.floor(notificationPanelPosition.top),
            width: Math.floor(notificationPanel.width()),
            height: Math.floor(notificationPanel.height())
        };
    }
    calculateIFrameNotificationPanelBounds() {
        const iFrame = this.getIFrame();
        if (iFrame) {
            this.iFrameNotificationPanelBounds = {
                x: this.notificationPanelBounds.x - iFrame.offsetLeft,
                y: this.notificationPanelBounds.y - iFrame.offsetTop,
                width: this.notificationPanelBounds.width,
                height: this.notificationPanelBounds.height
            };
        }
    }
    calculateBounds() {
        this.calculateNotificationPanelBounds();
        this.calculateIFrameNotificationPanelBounds();
    }
    invalidateBounds() {
        this.notificationPanelBounds = null;
        this.iFrameNotificationPanelBounds = null;
    }
    hasBounds() {
        const hasNotificationPanelBounds = !!this.notificationPanelBounds;
        const hasIFrameBounds = this.getIFrame()
            ? !!this.iFrameNotificationPanelBounds
            : true;
        return hasNotificationPanelBounds && hasIFrameBounds;
    }
    cancelDetection() {
        this.invalidateBounds();
        this.notificationMouseLeaveDetectionService.stopDetection();
        if (this.isMouseOver) {
            this.onMouseLeave();
        }
    }
    onResize() {
        this.cancelDetection();
    }
    onNotificationChanged() {
        if (!this.isMouseOver) {
            this.cancelDetection();
        }
    }
    addMouseMoveEventListener() {
        this.addMouseMoveEventListenerTimeout = null;
        this.notificationMouseLeaveDetectionService.startDetection(this.notificationPanelBounds, this.iFrameNotificationPanelBounds, () => this.onMouseLeave());
    }
};
NotificationPanelComponent = __decorate([
    core.Component({
        selector: 'se-notification-panel',
        changeDetection: core.ChangeDetectionStrategy.OnPush,
        template: `<ng-container *ngIf="(notifications$ | async) as notifications"><div class="se-notification-panel" *ngIf="notifications.length > 0" [ngClass]="{'is-mouseover': isMouseOver}" (mouseenter)="onMouseEnter()"><div><se-notification *ngFor="let notification of (notifications | seReverse)" [notification]="notification"></se-notification></div></div></ng-container>`
    }),
    __param(0, core.Inject(smarteditcommons.INotificationService)),
    __param(1, core.Inject(smarteditcommons.INotificationMouseLeaveDetectionService)),
    __param(6, core.Inject(smarteditcommons.YJQUERY_TOKEN)),
    __metadata("design:paramtypes", [NotificationService,
        NotificationMouseLeaveDetectionService,
        smarteditcommons.SystemEventService,
        IframeManagerService,
        smarteditcommons.WindowUtils,
        core.ElementRef, Function, core.ChangeDetectorRef])
], NotificationPanelComponent);

let NotificationPanelModule = class NotificationPanelModule {
};
NotificationPanelModule = __decorate([
    core.NgModule({
        imports: [
            SmarteditServicesModule,
            smarteditcommons.SharedComponentsModule,
            common.CommonModule,
            smarteditcommons.CustomComponentOutletDirectiveModule
        ],
        declarations: [NotificationPanelComponent, NotificationComponent],
        exports: [NotificationPanelComponent]
    })
], NotificationPanelModule);

const SITES_ID = 'sites-id';

window.__smartedit__.addDecoratorPayload("Component", "LandingPageComponent", {
    selector: 'se-landing-page',
    template: `<div class="se-toolbar-group"><se-toolbar cssClass="se-toolbar--shell" imageRoot="imageRoot" toolbarName="smartEditHeaderToolbar"></se-toolbar></div><div class="se-landing-page"><div class="se-landing-page-actions"><div class="se-landing-page-container"><h1 class="se-landing-page-title">{{ 'se.landingpage.title' | translate }}</h1><div class="se-landing-page-site-selection" *ngIf="model"><se-generic-editor-dropdown [field]="field" [qualifier]="qualifier" [model]="model" [id]="sitesId"></se-generic-editor-dropdown></div><p class="se-landing-page-label">{{ 'se.landingpage.label' | translate }}</p></div></div><p class="se-landing-page-container se-landing-page-sub-header">Content Catalogs</p><div class="se-landing-page-container se-landing-page-catalogs"><div class="se-landing-page-catalog" *ngFor="let catalog of catalogs; let isLast = last"><se-catalog-details [catalog]="catalog" [siteId]="model.site" [isCatalogForCurrentSite]="isLast"></se-catalog-details></div></div><img src="static-resources/images/best-run-sap-logo.svg" class="se-landing-page-footer-logo"/></div>`
});
let /* @ngInject */ LandingPageComponent = class /* @ngInject */ LandingPageComponent {
    constructor(siteService, catalogService, systemEventService, storageService, alertService, route, location, yjQuery) {
        this.siteService = siteService;
        this.catalogService = catalogService;
        this.systemEventService = systemEventService;
        this.storageService = storageService;
        this.alertService = alertService;
        this.route = route;
        this.location = location;
        this.yjQuery = yjQuery;
        this.sitesId = SITES_ID;
        this.qualifier = 'site';
        this.catalogs = [];
        this.SELECTED_SITE_COOKIE_NAME = 'seselectedsite';
    }
    ngOnInit() {
        this.route.paramMap.subscribe((params) => {
            this.getCurrentSiteId(params.get('siteId')).then((siteId) => {
                this.setModel(siteId);
            });
        });
        this.siteService.getAccessibleSites().then((sites) => {
            this.field = {
                idAttribute: 'uid',
                labelAttributes: ['name'],
                editable: true,
                paged: false,
                options: sites
            };
        });
        this.removeStorefrontCssClass();
        this.unregisterSitesDropdownEventHandler = this.systemEventService.subscribe(this.sitesId + smarteditcommons.LINKED_DROPDOWN, this.selectedSiteDropdownEventHandler.bind(this));
    }
    ngOnDestroy() {
        var _a;
        (_a = this.unregisterSitesDropdownEventHandler) === null || _a === void 0 ? void 0 : _a.call(this);
    }
    getCurrentSiteId(siteIdFromUrl) {
        return this.storageService
            .getValueFromLocalStorage(this.SELECTED_SITE_COOKIE_NAME, false)
            .then((siteIdFromCookie) => this.siteService.getAccessibleSites().then((sites) => {
            const isSiteAvailableFromUrl = sites.some((site) => site.uid === siteIdFromUrl);
            if (isSiteAvailableFromUrl) {
                this.setSelectedSite(siteIdFromUrl);
                this.updateRouteToRemoveSite();
                return siteIdFromUrl;
            }
            else {
                if (siteIdFromUrl) {
                    this.alertService.showInfo('se.landingpage.site.url.error');
                    this.updateRouteToRemoveSite();
                }
                const isSelectedSiteAvailableFromCookie = sites.some((site) => site.uid === siteIdFromCookie);
                if (!isSelectedSiteAvailableFromCookie) {
                    const firstSiteId = sites.length > 0 ? sites[0].uid : null;
                    return firstSiteId;
                }
                else {
                    return siteIdFromCookie;
                }
            }
        }));
    }
    updateRouteToRemoveSite() {
        this.location.replaceState(smarteditcommons.NG_ROUTE_PREFIX);
    }
    removeStorefrontCssClass() {
        const bodyTag = this.yjQuery(document.querySelector('body'));
        if (bodyTag.hasClass('is-storefront')) {
            bodyTag.removeClass('is-storefront');
        }
        if (bodyTag.hasClass('is-safari')) {
            bodyTag.removeClass('is-safari');
        }
    }
    selectedSiteDropdownEventHandler(_eventId, data) {
        if (data.optionObject) {
            const siteId = data.optionObject.id;
            this.setSelectedSite(siteId);
            this.loadCatalogsBySite(siteId);
            this.setModel(siteId);
        }
        else {
            this.catalogs = [];
        }
    }
    setSelectedSite(siteId) {
        this.storageService.setValueInLocalStorage(this.SELECTED_SITE_COOKIE_NAME, siteId, false);
    }
    loadCatalogsBySite(siteId) {
        this.catalogService
            .getContentCatalogsForSite(siteId)
            .then((catalogs) => (this.catalogs = catalogs));
    }
    setModel(siteId) {
        if (this.model) {
            this.model[this.qualifier] = siteId;
        }
        else {
            this.model = {
                [this.qualifier]: siteId
            };
        }
    }
};
LandingPageComponent.$inject = ["siteService", "catalogService", "systemEventService", "storageService", "alertService", "route", "location", "yjQuery"];
/* @ngInject */ LandingPageComponent = __decorate([
    smarteditcommons.SeDowngradeComponent(),
    core.Component({
        selector: 'se-landing-page',
        template: `<div class="se-toolbar-group"><se-toolbar cssClass="se-toolbar--shell" imageRoot="imageRoot" toolbarName="smartEditHeaderToolbar"></se-toolbar></div><div class="se-landing-page"><div class="se-landing-page-actions"><div class="se-landing-page-container"><h1 class="se-landing-page-title">{{ 'se.landingpage.title' | translate }}</h1><div class="se-landing-page-site-selection" *ngIf="model"><se-generic-editor-dropdown [field]="field" [qualifier]="qualifier" [model]="model" [id]="sitesId"></se-generic-editor-dropdown></div><p class="se-landing-page-label">{{ 'se.landingpage.label' | translate }}</p></div></div><p class="se-landing-page-container se-landing-page-sub-header">Content Catalogs</p><div class="se-landing-page-container se-landing-page-catalogs"><div class="se-landing-page-catalog" *ngFor="let catalog of catalogs; let isLast = last"><se-catalog-details [catalog]="catalog" [siteId]="model.site" [isCatalogForCurrentSite]="isLast"></se-catalog-details></div></div><img src="static-resources/images/best-run-sap-logo.svg" class="se-landing-page-footer-logo"/></div>`
    }),
    __param(7, core.Inject(smarteditcommons.YJQUERY_TOKEN)),
    __metadata("design:paramtypes", [SiteService,
        smarteditcommons.ICatalogService,
        smarteditcommons.SystemEventService,
        smarteditcommons.IStorageService,
        smarteditcommons.IAlertService,
        router.ActivatedRoute,
        common.Location, Function])
], /* @ngInject */ LandingPageComponent);

window.__smartedit__.addDecoratorPayload("Component", "StorefrontPageComponent", {
    selector: 'se-storefront-page',
    template: `<div class="se-toolbar-group"><se-toolbar cssClass="se-toolbar--shell" imageRoot="imageRoot" toolbarName="smartEditHeaderToolbar"></se-toolbar><se-toolbar cssClass="se-toolbar--experience" imageRoot="imageRoot" toolbarName="smartEditExperienceToolbar"></se-toolbar><se-toolbar cssClass="se-toolbar--perspective" imageRoot="imageRoot" toolbarName="smartEditPerspectiveToolbar"></se-toolbar></div><div id="js_iFrameWrapper" class="iframeWrapper"><div class="wrap"><div *ngIf="showPageTreeList()" class="page-tree__list"><se-page-tree-container></se-page-tree-container></div><div class="iframe-panel"><iframe id="ySmartEditFrame" src=""></iframe><div id="ySmartEditFrameDragArea"></div></div></div></div>`,
    styles: [`.wrap{display:flex;justify-content:flex-start;flex-wrap:nowrap;height:100%}.page-tree__list{width:20%;height:100%;padding:16px 8px 16px 8px;min-width:20%}.iframe-panel{width:100%;height:100%}`]
});
let /* @ngInject */ StorefrontPageComponent = class /* @ngInject */ StorefrontPageComponent {
    constructor(browserService, iframeManagerService, experienceService, yjQuery, crossFrameEventService, storageService, permissionService) {
        this.browserService = browserService;
        this.iframeManagerService = iframeManagerService;
        this.experienceService = experienceService;
        this.yjQuery = yjQuery;
        this.crossFrameEventService = crossFrameEventService;
        this.storageService = storageService;
        this.permissionService = permissionService;
        this.PAGE_TREE_PANEL_OPEN_COOKIE_NAME = 'smartedit-page-tree-panel-open';
        this.isPageTreePanelOpen = false;
    }
    ngOnInit() {
        return __awaiter(this, void 0, void 0, function* () {
            this.iframeManagerService.applyDefault();
            yield this.experienceService.initializeExperience();
            this.yjQuery(document.body).addClass('is-storefront');
            if (this.browserService.isSafari()) {
                this.yjQuery(document.body).addClass('is-safari');
            }
            const pageTreePanelStatus = yield this.storageService.getValueFromLocalStorage(this.PAGE_TREE_PANEL_OPEN_COOKIE_NAME, true);
            const allowed = yield this.permissionService.isPermitted([
                {
                    names: ['se.read.page']
                }
            ]);
            this.isPageTreePanelOpen = pageTreePanelStatus && allowed;
            this.crossFrameEventService.subscribe(smarteditcommons.EVENT_PAGE_TREE_PANEL_SWITCH, () => {
                this.isPageTreePanelOpen = !this.isPageTreePanelOpen;
                this.updateStorage();
            });
            this.crossFrameEventService.subscribe(smarteditcommons.EVENT_OPEN_IN_PAGE_TREE, () => {
                if (!this.isPageTreePanelOpen) {
                    this.isPageTreePanelOpen = true;
                    this.updateStorage();
                }
            });
            this.crossFrameEventService.subscribe(smarteditcommons.EVENT_PERSPECTIVE_UNLOADING, () => {
                this.isPageTreePanelOpen = false;
                this.updateStorage();
            });
        });
    }
    showPageTreeList() {
        return this.isPageTreePanelOpen;
    }
    updateStorage() {
        this.storageService.setValueInLocalStorage(this.PAGE_TREE_PANEL_OPEN_COOKIE_NAME, this.isPageTreePanelOpen, true);
    }
};
StorefrontPageComponent.$inject = ["browserService", "iframeManagerService", "experienceService", "yjQuery", "crossFrameEventService", "storageService", "permissionService"];
/* @ngInject */ StorefrontPageComponent = __decorate([
    smarteditcommons.SeDowngradeComponent(),
    core.Component({
        selector: 'se-storefront-page',
        template: `<div class="se-toolbar-group"><se-toolbar cssClass="se-toolbar--shell" imageRoot="imageRoot" toolbarName="smartEditHeaderToolbar"></se-toolbar><se-toolbar cssClass="se-toolbar--experience" imageRoot="imageRoot" toolbarName="smartEditExperienceToolbar"></se-toolbar><se-toolbar cssClass="se-toolbar--perspective" imageRoot="imageRoot" toolbarName="smartEditPerspectiveToolbar"></se-toolbar></div><div id="js_iFrameWrapper" class="iframeWrapper"><div class="wrap"><div *ngIf="showPageTreeList()" class="page-tree__list"><se-page-tree-container></se-page-tree-container></div><div class="iframe-panel"><iframe id="ySmartEditFrame" src=""></iframe><div id="ySmartEditFrameDragArea"></div></div></div></div>`,
        styles: [`.wrap{display:flex;justify-content:flex-start;flex-wrap:nowrap;height:100%}.page-tree__list{width:20%;height:100%;padding:16px 8px 16px 8px;min-width:20%}.iframe-panel{width:100%;height:100%}`]
    }),
    __param(3, core.Inject(smarteditcommons.YJQUERY_TOKEN)),
    __metadata("design:paramtypes", [smarteditcommons.BrowserService,
        IframeManagerService,
        smarteditcommons.IExperienceService, Function, smarteditcommons.CrossFrameEventService,
        smarteditcommons.IStorageService,
        smarteditcommons.IPermissionService])
], /* @ngInject */ StorefrontPageComponent);

window.__smartedit__.addDecoratorPayload("Component", "PageTreeContainerComponent", {
    selector: 'se-page-tree-container',
    template: `<div *ngIf="component" class="page-tree-container"><ng-container *ngComponentOutlet="component"></ng-container></div>`,
    styles: [`.page-tree-container{height:100%}`]
});
let /* @ngInject */ PageTreeContainerComponent = class /* @ngInject */ PageTreeContainerComponent {
    constructor(pageTreeService) {
        this.pageTreeService = pageTreeService;
    }
    ngOnInit() {
        return __awaiter(this, void 0, void 0, function* () {
            const config = yield this.pageTreeService.getTreeComponent();
            this.component = config.component;
        });
    }
};
PageTreeContainerComponent.$inject = ["pageTreeService"];
/* @ngInject */ PageTreeContainerComponent = __decorate([
    smarteditcommons.SeDowngradeComponent(),
    core.Component({
        selector: 'se-page-tree-container',
        template: `<div *ngIf="component" class="page-tree-container"><ng-container *ngComponentOutlet="component"></ng-container></div>`,
        styles: [`.page-tree-container{height:100%}`]
    }),
    __metadata("design:paramtypes", [smarteditcommons.IPageTreeService])
], /* @ngInject */ PageTreeContainerComponent);

const MULTI_PRODUCT_CATALOGS_UPDATED = 'MULTI_PRODUCT_CATALOGS_UPDATED';

window.__smartedit__.addDecoratorPayload("Component", "MultiProductCatalogVersionConfigurationComponent", {
    selector: 'se-multi-product-catalog-version-configuration',
    changeDetection: core.ChangeDetectionStrategy.OnPush,
    host: {
        '[class.se-multi-product-catalog-version-configuration]': 'true'
    },
    template: `<div class="form-group se-multi-product-catalog-version-selector__label">{{'se.product.catalogs.multiple.list.header' | translate}}</div><div class="se-multi-product-catalog-version-selector__catalog form-group" *ngFor="let productCatalog of productCatalogs"><label class="se-control-label se-multi-product-catalog-version-selector__catalog-name" id="{{ productCatalog.catalogId }}-label">{{ productCatalog.name | seL10n | async }}</label><div class="se-multi-product-catalog-version-selector__catalog-version"><se-select [id]="productCatalog.catalogId" [(model)]="productCatalog.selectedItem" [onChange]="updateModel()" [fetchStrategy]="productCatalog.fetchStrategy"></se-select></div></div>`
});
let MultiProductCatalogVersionConfigurationComponent = class MultiProductCatalogVersionConfigurationComponent {
    constructor(modalManager, systemEventService) {
        this.modalManager = modalManager;
        this.systemEventService = systemEventService;
        this.doneButtonId = 'done';
    }
    ngOnInit() {
        this.modalManager
            .getModalData()
            .pipe(operators.take(1))
            .subscribe((data) => {
            this.selectedCatalogVersions = data.selectedCatalogVersions;
            this.productCatalogs = data.productCatalogs.map((productCatalog) => {
                const versions = productCatalog.versions.map((version) => (Object.assign(Object.assign({}, version), { id: version.uuid, label: version.version })));
                return Object.assign(Object.assign({}, productCatalog), { versions, fetchStrategy: {
                        fetchAll: () => Promise.resolve(versions)
                    }, selectedItem: productCatalog.versions.find((version) => this.selectedCatalogVersions.includes(version.uuid)).uuid });
            });
        });
        this.modalManager.setDismissCallback(() => this.onCancel());
        this.modalManager.addButtons([
            {
                id: this.doneButtonId,
                label: 'se.confirmation.modal.done',
                style: smarteditcommons.ModalButtonStyle.Primary,
                action: smarteditcommons.ModalButtonAction.None,
                disabled: true,
                callback: () => rxjs.from(this.onSave())
            },
            {
                id: 'cancel',
                label: 'se.confirmation.modal.cancel',
                style: smarteditcommons.ModalButtonStyle.Default,
                action: smarteditcommons.ModalButtonAction.Dismiss,
                callback: () => rxjs.from(this.onCancel())
            }
        ]);
    }
    updateModel() {
        return () => {
            const selectedVersions = this.productCatalogs.map((productCatalog) => productCatalog.selectedItem);
            this.updateSelection(selectedVersions);
        };
    }
    updateSelection(updatedSelectedVersions) {
        if (!lo.isEqual(updatedSelectedVersions, this.selectedCatalogVersions)) {
            this.updatedCatalogVersions = updatedSelectedVersions;
            this.modalManager.enableButton(this.doneButtonId);
        }
        else {
            this.modalManager.disableButton(this.doneButtonId);
        }
    }
    onCancel() {
        this.modalManager.close(null);
        return Promise.resolve();
    }
    onSave() {
        this.systemEventService.publishAsync(MULTI_PRODUCT_CATALOGS_UPDATED, this.updatedCatalogVersions);
        this.modalManager.close(null);
        return Promise.resolve();
    }
};
MultiProductCatalogVersionConfigurationComponent = __decorate([
    core.Component({
        selector: 'se-multi-product-catalog-version-configuration',
        changeDetection: core.ChangeDetectionStrategy.OnPush,
        host: {
            '[class.se-multi-product-catalog-version-configuration]': 'true'
        },
        template: `<div class="form-group se-multi-product-catalog-version-selector__label">{{'se.product.catalogs.multiple.list.header' | translate}}</div><div class="se-multi-product-catalog-version-selector__catalog form-group" *ngFor="let productCatalog of productCatalogs"><label class="se-control-label se-multi-product-catalog-version-selector__catalog-name" id="{{ productCatalog.catalogId }}-label">{{ productCatalog.name | seL10n | async }}</label><div class="se-multi-product-catalog-version-selector__catalog-version"><se-select [id]="productCatalog.catalogId" [(model)]="productCatalog.selectedItem" [onChange]="updateModel()" [fetchStrategy]="productCatalog.fetchStrategy"></se-select></div></div>`
    }),
    __metadata("design:paramtypes", [smarteditcommons.ModalManagerService,
        smarteditcommons.SystemEventService])
], MultiProductCatalogVersionConfigurationComponent);

window.__smartedit__.addDecoratorPayload("Component", "MultiProductCatalogVersionSelectorComponent", {
    selector: 'se-multi-product-catalog-version-selector',
    providers: [smarteditcommons.L10nPipe],
    changeDetection: core.ChangeDetectionStrategy.OnPush,
    host: {
        '[class.se-multi-product-catalog-version-selector]': 'true'
    },
    template: `<se-tooltip [placement]="'bottom'" [triggers]="['mouseenter', 'mouseleave']" [isChevronVisible]="true" class="se-products-catalog-select-multiple__tooltip"><div id="multi-product-catalog-versions-selector" se-tooltip-trigger (click)="onClickSelector()" class="se-products-catalog-select-multiple"><input type="text" [value]="multiProductCatalogVersionsSelectedOptions$ | async" class="form-control se-products-catalog-select-multiple__catalogs se-nowrap-ellipsis" [name]="'productCatalogVersions'" readonly="readonly"/> <span class="hyicon hyicon-optionssm se-products-catalog-select-multiple__icon"></span></div><div class="se-product-catalogs-tooltip" se-tooltip-body><div class="se-product-catalogs-tooltip__h">{{ ('se.product.catalogs.selector.headline.tooltip' || '') | translate }}</div><div class="se-product-catalog-info" *ngFor="let productCatalog of productCatalogs">{{ getCatalogNameCatalogVersionLabel(productCatalog.catalogId) | async }}</div></div></se-tooltip>`
});
let MultiProductCatalogVersionSelectorComponent = class MultiProductCatalogVersionSelectorComponent {
    constructor(l10nPipe, modalService, systemEventService) {
        this.l10nPipe = l10nPipe;
        this.modalService = modalService;
        this.systemEventService = systemEventService;
        this.selectedProductCatalogVersionsChange = new core.EventEmitter();
        this.multiProductCatalogVersionsSelectedOptions$ = new rxjs.BehaviorSubject('');
    }
    ngOnInit() {
        this.$unRegEventForMultiProducts = this.systemEventService.subscribe(MULTI_PRODUCT_CATALOGS_UPDATED, (eventId, catalogVersions) => this.updateProductCatalogVersionsModel(eventId, catalogVersions));
    }
    ngOnDestroy() {
        if (this.$unRegEventForMultiProducts) {
            this.$unRegEventForMultiProducts();
        }
    }
    ngOnChanges() {
        this.setMultiVersionSelectorTexts(this.productCatalogs);
    }
    onClickSelector() {
        this.modalService.open({
            component: MultiProductCatalogVersionConfigurationComponent,
            data: {
                productCatalogs: this.productCatalogs,
                selectedCatalogVersions: this.selectedProductCatalogVersions
            },
            templateConfig: {
                title: 'se.modal.product.catalog.configuration'
            },
            config: {
                modalPanelClass: 'modal-md modal-stretched'
            }
        });
    }
    getCatalogNameCatalogVersionLabel(catalogId) {
        const catalogNameCatalogVersionLabel = this.catalogNameCatalogVersionLabelMap.get(catalogId);
        return this.l10nPipe
            .transform(catalogNameCatalogVersionLabel.name)
            .pipe(operators.map((name) => `${name} (${catalogNameCatalogVersionLabel.version})`));
    }
    setMultiVersionSelectorTexts(productCatalogs) {
        this.catalogNameCatalogVersionLabelMap = this.buildCatalogNameCatalogVersionLabelMap(productCatalogs, this.selectedProductCatalogVersions);
        this.setMultiProductCatalogVersionsSelectedOptions(productCatalogs);
    }
    buildCatalogNameCatalogVersionLabelMap(productCatalogs, versionsFromModel) {
        const catalogsMap = new Map();
        productCatalogs.forEach((productCatalog) => {
            const productCatalogVersion = productCatalog.versions.find((version) => versionsFromModel && versionsFromModel.includes(version.uuid));
            if (productCatalogVersion) {
                catalogsMap.set(productCatalog.catalogId, {
                    name: productCatalog.name,
                    version: productCatalogVersion.version
                });
            }
        });
        return catalogsMap;
    }
    setMultiProductCatalogVersionsSelectedOptions(productCatalogs) {
        if (productCatalogs) {
            const labels$ = Array.from(this.catalogNameCatalogVersionLabelMap).map((key) => this.getCatalogNameCatalogVersionLabel(key[0]));
            rxjs.combineLatest(labels$)
                .pipe(operators.take(1), operators.map((results) => results.join(', ')))
                .subscribe((selectedOptions) => this.multiProductCatalogVersionsSelectedOptions$.next(selectedOptions));
        }
        else {
            this.multiProductCatalogVersionsSelectedOptions$.next('');
        }
    }
    updateProductCatalogVersionsModel(_eventId, catalogVersions) {
        this.selectedProductCatalogVersionsChange.emit(catalogVersions);
    }
};
__decorate([
    core.Input(),
    __metadata("design:type", Array)
], MultiProductCatalogVersionSelectorComponent.prototype, "productCatalogs", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Array)
], MultiProductCatalogVersionSelectorComponent.prototype, "selectedProductCatalogVersions", void 0);
__decorate([
    core.Output(),
    __metadata("design:type", Object)
], MultiProductCatalogVersionSelectorComponent.prototype, "selectedProductCatalogVersionsChange", void 0);
MultiProductCatalogVersionSelectorComponent = __decorate([
    core.Component({
        selector: 'se-multi-product-catalog-version-selector',
        providers: [smarteditcommons.L10nPipe],
        changeDetection: core.ChangeDetectionStrategy.OnPush,
        host: {
            '[class.se-multi-product-catalog-version-selector]': 'true'
        },
        template: `<se-tooltip [placement]="'bottom'" [triggers]="['mouseenter', 'mouseleave']" [isChevronVisible]="true" class="se-products-catalog-select-multiple__tooltip"><div id="multi-product-catalog-versions-selector" se-tooltip-trigger (click)="onClickSelector()" class="se-products-catalog-select-multiple"><input type="text" [value]="multiProductCatalogVersionsSelectedOptions$ | async" class="form-control se-products-catalog-select-multiple__catalogs se-nowrap-ellipsis" [name]="'productCatalogVersions'" readonly="readonly"/> <span class="hyicon hyicon-optionssm se-products-catalog-select-multiple__icon"></span></div><div class="se-product-catalogs-tooltip" se-tooltip-body><div class="se-product-catalogs-tooltip__h">{{ ('se.product.catalogs.selector.headline.tooltip' || '') | translate }}</div><div class="se-product-catalog-info" *ngFor="let productCatalog of productCatalogs">{{ getCatalogNameCatalogVersionLabel(productCatalog.catalogId) | async }}</div></div></se-tooltip>`
    }),
    __metadata("design:paramtypes", [smarteditcommons.L10nPipe,
        smarteditcommons.IModalService,
        smarteditcommons.SystemEventService])
], MultiProductCatalogVersionSelectorComponent);

window.__smartedit__.addDecoratorPayload("Component", "ProductCatalogVersionsSelectorComponent", {
    selector: 'se-product-catalog-versions-selector',
    changeDetection: core.ChangeDetectionStrategy.OnPush,
    host: {
        '[class.se-product-catalog-versions-selector]': 'true'
    },
    template: `<ng-container *ngIf="isReady"><se-select *ngIf="isSingleVersionSelector" [id]="geData.qualifier" [(model)]="geData.model.productCatalogVersions[0]" [(reset)]="reset" [fetchStrategy]="fetchStrategy"></se-select><se-multi-product-catalog-version-selector *ngIf="isMultiVersionSelector" [productCatalogs]="productCatalogs" [(selectedProductCatalogVersions)]="geData.model[geData.qualifier]"></se-multi-product-catalog-version-selector></ng-container>`
});
let ProductCatalogVersionsSelectorComponent = class ProductCatalogVersionsSelectorComponent {
    constructor(geData, catalogService, systemEventService, cdr) {
        this.geData = geData;
        this.catalogService = catalogService;
        this.systemEventService = systemEventService;
        this.cdr = cdr;
    }
    ngOnInit() {
        return __awaiter(this, void 0, void 0, function* () {
            this.contentCatalogVersionId = lo.cloneDeep(this.geData.model.previewCatalog);
            if (this.contentCatalogVersionId) {
                this.isReady = false;
                this.isSingleVersionSelector = false;
                this.isMultiVersionSelector = false;
                const eventId = (this.geData.id || '') + smarteditcommons.LINKED_DROPDOWN;
                this.$unRegSiteChangeEvent = this.systemEventService.subscribe(eventId, (id, data) => this.resetSelector(id, data));
                yield this.setContent();
            }
            return Promise.resolve();
        });
    }
    ngOnDestroy() {
        if (this.$unRegSiteChangeEvent) {
            this.$unRegSiteChangeEvent();
        }
    }
    resetSelector(_eventId, data) {
        return __awaiter(this, void 0, void 0, function* () {
            if (data.qualifier === 'previewCatalog' &&
                data.optionObject &&
                this.contentCatalogVersionId !== data.optionObject.id) {
                this.contentCatalogVersionId = data.optionObject.id;
                const siteUID = this.getSiteUIDFromContentCatalogVersionId(this.contentCatalogVersionId);
                const productCatalogs = yield this.catalogService.getProductCatalogsForSite(siteUID);
                const activeProductCatalogVersions = yield Promise.resolve(this.catalogService.returnActiveCatalogVersionUIDs(productCatalogs));
                this.geData.model[this.geData.qualifier] = activeProductCatalogVersions;
                if (this.isSingleVersionSelector) {
                    this.reset();
                }
                this.setContent();
            }
        });
    }
    setContent() {
        return __awaiter(this, void 0, void 0, function* () {
            const setContent = () => __awaiter(this, void 0, void 0, function* () {
                this.productCatalogs = yield this.catalogService.getProductCatalogsForSite(this.getSiteUIDFromContentCatalogVersionId(this.contentCatalogVersionId));
                if (this.productCatalogs.length === 0) {
                    return;
                }
                if (this.productCatalogs.length === 1) {
                    this.fetchStrategy = {
                        fetchAll: () => {
                            const parsedVersions = this.parseSingleCatalogVersion(this.productCatalogs[0].versions);
                            return Promise.resolve(parsedVersions);
                        }
                    };
                    this.isSingleVersionSelector = true;
                    this.isMultiVersionSelector = false;
                    this.isReady = true;
                    return;
                }
                this.isSingleVersionSelector = false;
                this.isMultiVersionSelector = true;
                this.isReady = true;
            });
            yield setContent();
            if (!this.cdr.destroyed) {
                this.cdr.detectChanges();
            }
        });
    }
    getSiteUIDFromContentCatalogVersionId(id) {
        return id.split('|')[0];
    }
    parseSingleCatalogVersion(versions) {
        return versions.map((version) => ({
            id: version.uuid,
            label: version.version
        }));
    }
};
ProductCatalogVersionsSelectorComponent = __decorate([
    core.Component({
        selector: 'se-product-catalog-versions-selector',
        changeDetection: core.ChangeDetectionStrategy.OnPush,
        host: {
            '[class.se-product-catalog-versions-selector]': 'true'
        },
        template: `<ng-container *ngIf="isReady"><se-select *ngIf="isSingleVersionSelector" [id]="geData.qualifier" [(model)]="geData.model.productCatalogVersions[0]" [(reset)]="reset" [fetchStrategy]="fetchStrategy"></se-select><se-multi-product-catalog-version-selector *ngIf="isMultiVersionSelector" [productCatalogs]="productCatalogs" [(selectedProductCatalogVersions)]="geData.model[geData.qualifier]"></se-multi-product-catalog-version-selector></ng-container>`
    }),
    __param(0, core.Inject(smarteditcommons.GENERIC_EDITOR_WIDGET_DATA)),
    __metadata("design:paramtypes", [Object, smarteditcommons.ICatalogService,
        smarteditcommons.SystemEventService,
        core.ChangeDetectorRef])
], ProductCatalogVersionsSelectorComponent);

let ProductCatalogVersionModule = class ProductCatalogVersionModule {
};
ProductCatalogVersionModule = __decorate([
    core.NgModule({
        imports: [
            common.CommonModule,
            forms.FormsModule,
            smarteditcommons.L10nPipeModule,
            smarteditcommons.TranslationModule.forChild(),
            smarteditcommons.SelectModule,
            smarteditcommons.TooltipModule
        ],
        declarations: [
            ProductCatalogVersionsSelectorComponent,
            MultiProductCatalogVersionConfigurationComponent,
            MultiProductCatalogVersionSelectorComponent
        ],
        entryComponents: [
            ProductCatalogVersionsSelectorComponent,
            MultiProductCatalogVersionConfigurationComponent,
            MultiProductCatalogVersionSelectorComponent
        ],
        providers: [
            smarteditcommons.moduleUtils.initialize((editorFieldMappingService) => {
                editorFieldMappingService.addFieldMapping('ProductCatalogVersionsSelector', null, null, {
                    component: ProductCatalogVersionsSelectorComponent
                });
            }, [smarteditcommons.EditorFieldMappingService])
        ]
    })
], ProductCatalogVersionModule);

window.__smartedit__.addDecoratorPayload("Component", "SitesLinkComponent", {
    selector: 'sites-link',
    template: `<div (click)="goToSites()" class="se-sites-link {{cssClass}}"><a class="se-sites-link__text">{{'se.toolbar.sites' | translate}}</a> <span class="icon-navigation-right-arrow se-sites-link__arrow {{iconCssClass}}"></span></div>`
});
let SitesLinkComponent = class SitesLinkComponent {
    constructor(routingService, iframeManagerService, userTrackingService) {
        this.routingService = routingService;
        this.iframeManagerService = iframeManagerService;
        this.userTrackingService = userTrackingService;
        this.iconCssClass = 'sap-icon--navigation-right-arrow';
    }
    goToSites() {
        this.userTrackingService.trackingUserAction(smarteditcommons.USER_TRACKING_FUNCTIONALITY.NAVIGATION, 'Sites');
        this.iframeManagerService.setCurrentLocation(null);
        this.routingService.go(smarteditcommons.NG_ROUTE_PREFIX);
    }
};
__decorate([
    core.Input(),
    __metadata("design:type", String)
], SitesLinkComponent.prototype, "cssClass", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], SitesLinkComponent.prototype, "iconCssClass", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], SitesLinkComponent.prototype, "shortcutLink", void 0);
SitesLinkComponent = __decorate([
    core.Component({
        selector: 'sites-link',
        template: `<div (click)="goToSites()" class="se-sites-link {{cssClass}}"><a class="se-sites-link__text">{{'se.toolbar.sites' | translate}}</a> <span class="icon-navigation-right-arrow se-sites-link__arrow {{iconCssClass}}"></span></div>`
    }),
    __metadata("design:paramtypes", [smarteditcommons.SmarteditRoutingService,
        IframeManagerService,
        smarteditcommons.UserTrackingService])
], SitesLinkComponent);

window.__smartedit__.addDecoratorPayload("Component", "PerspectiveSelectorComponent", {
    selector: 'se-perspective-selector',
    template: `<fd-popover [(isOpen)]="isOpen" [closeOnOutsideClick]="false" [triggers]="['click']" *ngIf="hasActivePerspective()" class="se-perspective-selector" [placement]="'bottom-end'" [disabled]="isDisabled" [options]="popperOptions"><fd-popover-control><div class="se-perspective-selector__trigger"><se-tooltip [isChevronVisible]="true" [triggers]="['mouseenter', 'mouseleave']" *ngIf="isTooltipVisible()"><span se-tooltip-trigger id="perspectiveTooltip" class="hyicon hyicon-info se-perspective-selector__hotkey-tooltip--icon"></span><div se-tooltip-body>{{ activePerspective.descriptionI18nKey | translate }}</div></se-tooltip><button class="se-perspective-selector__btn" [disabled]="isDisabled">{{getActivePerspectiveName() | translate}} <span class="se-perspective-selector__btn-arrow icon-navigation-down-arrow"></span></button></div></fd-popover-control><fd-popover-body><ul class="se-perspective__list fd-list-group" [ngClass]="{'se-perspective__list--tooltip': isTooltipVisible()}" role="menu"><li *ngFor="let choice of getDisplayedPerspectives()" class="fd-list-group__item se-perspective__list-item fd-has-padding-none"><a class="item se-perspective__list-item-text" (click)="selectPerspective($event, choice.key);">{{choice.nameI18nKey | translate}}</a></li></ul></fd-popover-body></fd-popover>`
});
let /* @ngInject */ PerspectiveSelectorComponent = class /* @ngInject */ PerspectiveSelectorComponent {
    constructor(logService, yjQuery, perspectiveService, iframeClickDetectionService, systemEventService, crossFrameEventService, testModeService, userTrackingService) {
        this.logService = logService;
        this.yjQuery = yjQuery;
        this.perspectiveService = perspectiveService;
        this.iframeClickDetectionService = iframeClickDetectionService;
        this.systemEventService = systemEventService;
        this.crossFrameEventService = crossFrameEventService;
        this.testModeService = testModeService;
        this.userTrackingService = userTrackingService;
        this.isOpen = false;
        this.popperOptions = {
            placement: 'bottom-start',
            modifiers: {
                preventOverflow: {
                    enabled: true,
                    escapeWithReference: true,
                    boundariesElement: 'viewport'
                },
                applyStyle: {
                    gpuAcceleration: false
                }
            }
        };
        this.isDisabled = false;
        this.perspectives = [];
        this.displayedPerspectives = [];
        this.activePerspective = null;
    }
    onDocumentClick(event) {
        this.onClickHandler(event);
    }
    ngOnInit() {
        this.activePerspective = null;
        this.iframeClickDetectionService.registerCallback('perspectiveSelectorClose', () => this.closeDropdown());
        this.unRegOverlayDisabledFn = this.systemEventService.subscribe('OVERLAY_DISABLED', () => this.closeDropdown());
        this.unRegPerspectiveAddedFn = this.systemEventService.subscribe(smarteditcommons.EVENT_PERSPECTIVE_ADDED, () => this.onPerspectiveAdded());
        this.unRegPerspectiveChgFn = this.crossFrameEventService.subscribe(smarteditcommons.EVENT_PERSPECTIVE_CHANGED, () => this.refreshPerspectives());
        this.unRegPerspectiveRefreshFn = this.crossFrameEventService.subscribe(smarteditcommons.EVENT_PERSPECTIVE_REFRESHED, () => this.refreshPerspectives());
        this.unRegUserHasChanged = this.crossFrameEventService.subscribe(smarteditcommons.EVENTS.USER_HAS_CHANGED, () => this.onPerspectiveAdded());
        this.unRegStrictPreviewModeToggleFn = this.crossFrameEventService.subscribe(smarteditcommons.EVENT_STRICT_PREVIEW_MODE_REQUESTED, (eventId, isDisabled) => this.togglePerspectiveSelector(isDisabled));
        this.onPerspectiveAdded();
    }
    ngOnDestroy() {
        this.unRegOverlayDisabledFn();
        this.unRegPerspectiveAddedFn();
        this.unRegPerspectiveChgFn();
        this.unRegPerspectiveRefreshFn();
        this.unRegUserHasChanged();
        this.unRegStrictPreviewModeToggleFn();
    }
    selectPerspective(event, choice) {
        event.preventDefault();
        this.userTrackingService.trackingUserAction(smarteditcommons.USER_TRACKING_FUNCTIONALITY.SELECT_PERSPECTIVE, choice);
        try {
            this.perspectiveService.switchTo(choice);
            this.closeDropdown();
        }
        catch (e) {
            this.logService.error('selectPerspective() - Cannot select perspective.', e);
        }
    }
    getDisplayedPerspectives() {
        return this.displayedPerspectives;
    }
    getActivePerspectiveName() {
        return this.activePerspective ? this.activePerspective.nameI18nKey : '';
    }
    hasActivePerspective() {
        return this.activePerspective !== null;
    }
    isTooltipVisible() {
        return (!!this.activePerspective &&
            !!this.activePerspective.descriptionI18nKey &&
            this.checkTooltipVisibilityCondition());
    }
    checkTooltipVisibilityCondition() {
        if (this.activePerspective.key !== smarteditcommons.NONE_PERSPECTIVE ||
            (this.activePerspective.key === smarteditcommons.NONE_PERSPECTIVE && this.isDisabled)) {
            return true;
        }
        return false;
    }
    filterPerspectives(perspectives) {
        return perspectives.filter((perspective) => {
            const isActivePerspective = this.activePerspective && perspective.key === this.activePerspective.key;
            const isAllPerspective = perspective.key === smarteditcommons.ALL_PERSPECTIVE;
            return !isActivePerspective && (!isAllPerspective || this.testModeService.isE2EMode());
        });
    }
    closeDropdown() {
        this.isOpen = false;
    }
    onPerspectiveAdded() {
        this.perspectiveService.getPerspectives().then((result) => {
            this.perspectives = result;
            this.displayedPerspectives = this.filterPerspectives(this.perspectives);
        });
    }
    refreshPerspectives() {
        this.perspectiveService.getPerspectives().then((result) => {
            this.perspectives = result;
            this._refreshActivePerspective();
            this.displayedPerspectives = this.filterPerspectives(this.perspectives);
        });
    }
    _refreshActivePerspective() {
        this.activePerspective = this.perspectiveService.getActivePerspective();
    }
    onClickHandler(event) {
        if (this.yjQuery(event.target).parents('.se-perspective-selector').length <= 0 &&
            this.isOpen) {
            this.closeDropdown();
        }
    }
    togglePerspectiveSelector(value) {
        this.isDisabled = value;
    }
};
PerspectiveSelectorComponent.$inject = ["logService", "yjQuery", "perspectiveService", "iframeClickDetectionService", "systemEventService", "crossFrameEventService", "testModeService", "userTrackingService"];
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ PerspectiveSelectorComponent.prototype, "isOpen", void 0);
__decorate([
    core.HostListener('document:click', ['$event']),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [Event]),
    __metadata("design:returntype", void 0)
], /* @ngInject */ PerspectiveSelectorComponent.prototype, "onDocumentClick", null);
/* @ngInject */ PerspectiveSelectorComponent = __decorate([
    smarteditcommons.SeDowngradeComponent(),
    core.Component({
        selector: 'se-perspective-selector',
        template: `<fd-popover [(isOpen)]="isOpen" [closeOnOutsideClick]="false" [triggers]="['click']" *ngIf="hasActivePerspective()" class="se-perspective-selector" [placement]="'bottom-end'" [disabled]="isDisabled" [options]="popperOptions"><fd-popover-control><div class="se-perspective-selector__trigger"><se-tooltip [isChevronVisible]="true" [triggers]="['mouseenter', 'mouseleave']" *ngIf="isTooltipVisible()"><span se-tooltip-trigger id="perspectiveTooltip" class="hyicon hyicon-info se-perspective-selector__hotkey-tooltip--icon"></span><div se-tooltip-body>{{ activePerspective.descriptionI18nKey | translate }}</div></se-tooltip><button class="se-perspective-selector__btn" [disabled]="isDisabled">{{getActivePerspectiveName() | translate}} <span class="se-perspective-selector__btn-arrow icon-navigation-down-arrow"></span></button></div></fd-popover-control><fd-popover-body><ul class="se-perspective__list fd-list-group" [ngClass]="{'se-perspective__list--tooltip': isTooltipVisible()}" role="menu"><li *ngFor="let choice of getDisplayedPerspectives()" class="fd-list-group__item se-perspective__list-item fd-has-padding-none"><a class="item se-perspective__list-item-text" (click)="selectPerspective($event, choice.key);">{{choice.nameI18nKey | translate}}</a></li></ul></fd-popover-body></fd-popover>`
    }),
    __param(1, core.Inject(smarteditcommons.YJQUERY_TOKEN)),
    __param(5, core.Inject(smarteditcommons.EVENT_SERVICE)),
    __metadata("design:paramtypes", [smarteditcommons.LogService, Function, smarteditcommons.IPerspectiveService,
        smarteditcommons.IIframeClickDetectionService,
        smarteditcommons.SystemEventService,
        smarteditcommons.CrossFrameEventService,
        smarteditcommons.TestModeService,
        smarteditcommons.UserTrackingService])
], /* @ngInject */ PerspectiveSelectorComponent);

window.__smartedit__.addDecoratorPayload("Component", "CatalogHierarchyModalComponent", {
    selector: 'se-catalog-hierarchy-modal',
    template: `<div class="se-catalog-hierarchy-header"><span>{{ 'se.catalog.hierarchy.modal.tree.header' | translate }}</span></div><div *ngIf="this.catalogs$ | async as catalogs" class="se-catalog-hierarchy-body"><se-catalog-hierarchy-node *ngFor="let catalog of catalogs; let i = index" [catalog]="catalog" [index]="i" [isLast]="i === catalogs.length - 1" [siteId]="siteId" (siteSelect)="onSiteSelected()"></se-catalog-hierarchy-node></div>`
});
let CatalogHierarchyModalComponent = class CatalogHierarchyModalComponent {
    constructor(modalService) {
        this.modalService = modalService;
    }
    ngOnInit() {
        this.catalogs$ = this.modalService
            .getModalData()
            .pipe(operators.take(1))
            .toPromise()
            .then(({ catalog }) => [...catalog.parents, catalog]);
    }
    onSiteSelected() {
        this.modalService.close();
    }
};
CatalogHierarchyModalComponent = __decorate([
    core.Component({
        selector: 'se-catalog-hierarchy-modal',
        template: `<div class="se-catalog-hierarchy-header"><span>{{ 'se.catalog.hierarchy.modal.tree.header' | translate }}</span></div><div *ngIf="this.catalogs$ | async as catalogs" class="se-catalog-hierarchy-body"><se-catalog-hierarchy-node *ngFor="let catalog of catalogs; let i = index" [catalog]="catalog" [index]="i" [isLast]="i === catalogs.length - 1" [siteId]="siteId" (siteSelect)="onSiteSelected()"></se-catalog-hierarchy-node></div>`
    }),
    __metadata("design:paramtypes", [smarteditcommons.ModalManagerService])
], CatalogHierarchyModalComponent);

window.__smartedit__.addDecoratorPayload("Component", "CatalogDetailsComponent", {
    selector: 'se-catalog-details',
    template: `<div class="se-catalog-details" [attr.data-catalog]="catalog.name | seL10n | async"><div class="se-catalog-header"><div class="se-catalog-header-flex"><div class="se-catalog-details__header">{{ catalog.name | seL10n | async }}</div><div *ngIf="catalog.parents?.length"><a href="javascript:void(0)" (click)="onOpenCatalogHierarchy()">{{ 'se.landingpage.catalog.hierarchy' | translate }}</a></div></div></div><div class="se-catalog-details__content"><se-catalog-version-details *ngFor="let catalogVersion of sortedCatalogVersions" [catalog]="catalog" [catalogVersion]="catalogVersion" [activeCatalogVersion]="activeCatalogVersion" [siteId]="siteId"></se-catalog-version-details></div></div>`
});
let /* @ngInject */ CatalogDetailsComponent = class /* @ngInject */ CatalogDetailsComponent {
    constructor(modalService) {
        this.modalService = modalService;
        this.catalogDividerImage = 'static-resources/images/icon_catalog_arrow.png';
    }
    ngOnInit() {
        this.activeCatalogVersion = this.catalog.versions.find((catalogVersion) => catalogVersion.active);
        this.sortedCatalogVersions = this.getSortedCatalogVersions();
        this.collapsibleConfiguration = {
            expandedByDefault: this.isCatalogForCurrentSite
        };
    }
    onOpenCatalogHierarchy() {
        this.modalService.open({
            component: CatalogHierarchyModalComponent,
            data: {
                catalog: this.catalog
            },
            templateConfig: {
                title: 'se.catalog.hierarchy.modal.title',
                isDismissButtonVisible: true
            }
        });
    }
    getSortedCatalogVersions() {
        return [
            this.activeCatalogVersion,
            ...this.catalog.versions.filter((catalogVersion) => !catalogVersion.active)
        ];
    }
};
CatalogDetailsComponent.$inject = ["modalService"];
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ CatalogDetailsComponent.prototype, "catalog", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Boolean)
], /* @ngInject */ CatalogDetailsComponent.prototype, "isCatalogForCurrentSite", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", String)
], /* @ngInject */ CatalogDetailsComponent.prototype, "siteId", void 0);
/* @ngInject */ CatalogDetailsComponent = __decorate([
    smarteditcommons.SeDowngradeComponent(),
    core.Component({
        selector: 'se-catalog-details',
        template: `<div class="se-catalog-details" [attr.data-catalog]="catalog.name | seL10n | async"><div class="se-catalog-header"><div class="se-catalog-header-flex"><div class="se-catalog-details__header">{{ catalog.name | seL10n | async }}</div><div *ngIf="catalog.parents?.length"><a href="javascript:void(0)" (click)="onOpenCatalogHierarchy()">{{ 'se.landingpage.catalog.hierarchy' | translate }}</a></div></div></div><div class="se-catalog-details__content"><se-catalog-version-details *ngFor="let catalogVersion of sortedCatalogVersions" [catalog]="catalog" [catalogVersion]="catalogVersion" [activeCatalogVersion]="activeCatalogVersion" [siteId]="siteId"></se-catalog-version-details></div></div>`
    }),
    __metadata("design:paramtypes", [smarteditcommons.ModalService])
], /* @ngInject */ CatalogDetailsComponent);

/**
 * @ignore
 * @internal
 *
 * Navigates to a site with the given site id.
 */
let /* @ngInject */ CatalogNavigateToSite = class /* @ngInject */ CatalogNavigateToSite {
    constructor(systemEvent) {
        this.systemEvent = systemEvent;
    }
    navigate(siteId) {
        this.systemEvent.publishAsync(SITES_ID + smarteditcommons.LINKED_DROPDOWN, {
            qualifier: 'site',
            optionObject: {
                contentCatalogs: [],
                uid: siteId,
                id: siteId,
                label: {},
                name: {},
                previewUrl: ''
            }
        });
    }
};
CatalogNavigateToSite.$inject = ["systemEvent"];
/* @ngInject */ CatalogNavigateToSite = __decorate([
    core.Injectable(),
    __metadata("design:paramtypes", [smarteditcommons.SystemEventService])
], /* @ngInject */ CatalogNavigateToSite);

window.__smartedit__.addDecoratorPayload("Component", "CatalogHierarchyNodeMenuItemComponent", {
    changeDetection: core.ChangeDetectionStrategy.OnPush,
    selector: 'se-catalog-hierarchy-node-menu-item',
    template: `
        <a class="se-dropdown-item fd-menu__item" (click)="onSiteSelect()">
            {{ name | seL10n | async }}
        </a>
    `
});
let CatalogHierarchyNodeMenuItemComponent = class CatalogHierarchyNodeMenuItemComponent {
    constructor(activateSite, data) {
        this.activateSite = activateSite;
        const { name, uid } = data.dropdownItem;
        this.name = name;
        this.uid = uid;
    }
    onSiteSelect() {
        this.activateSite.navigate(this.uid);
    }
};
CatalogHierarchyNodeMenuItemComponent = __decorate([
    core.Component({
        changeDetection: core.ChangeDetectionStrategy.OnPush,
        selector: 'se-catalog-hierarchy-node-menu-item',
        template: `
        <a class="se-dropdown-item fd-menu__item" (click)="onSiteSelect()">
            {{ name | seL10n | async }}
        </a>
    `
    }),
    __param(1, core.Inject(smarteditcommons.DROPDOWN_MENU_ITEM_DATA)),
    __metadata("design:paramtypes", [CatalogNavigateToSite, Object])
], CatalogHierarchyNodeMenuItemComponent);

const CATALOG_DROPDOWN_ANCHOR_CLASS = 'se-cth-node-anchor';
window.__smartedit__.addDecoratorPayload("Component", "CatalogHierarchyNodeComponent", {
    changeDetection: core.ChangeDetectionStrategy.OnPush,
    selector: 'se-catalog-hierarchy-node',
    template: `<div class="se-cth-node-name" [style.padding-left.px]="15 * index" [style.padding-right.px]="15 * index" [class.se-cth-node-name__last]="isLast"><fd-icon glyph="navigation-down-arrow"></fd-icon>{{ (isLast ? catalog.name : catalog.catalogName) | seL10n | async }}&nbsp; <span *ngIf="isLast">({{ 'se.catalog.hierarchy.modal.tree.this.catalog' | translate}})</span></div><div class="se-cth-node-sites"><ng-container><ng-container *ngIf="hasOneSite; else hasManySites"><a class="se-cth-node-anchor" href="" (click)="onNavigateToSite(catalog.sites[0].uid)">{{ catalog.sites[0].name | seL10n | async }}<fd-icon glyph="navigation-right-arrow"></fd-icon></a></ng-container><ng-template #hasManySites><se-dropdown-menu [dropdownItems]="dropdownItems" useProjectedAnchor="1" (click)="onSiteSelect($event)"><span class="se-cth-node-anchor">{{ this.catalog.sites.length }} Sites<fd-icon glyph="navigation-down-arrow"></fd-icon></span></se-dropdown-menu></ng-template></ng-container></div>`
});
let CatalogHierarchyNodeComponent = class CatalogHierarchyNodeComponent {
    constructor(navigateToSite) {
        this.navigateToSite = navigateToSite;
        this.siteSelect = new core.EventEmitter();
    }
    ngOnChanges() {
        this.dropdownItems = this.getDropdownItems();
    }
    onNavigateToSite(siteUid) {
        this.navigateToSite.navigate(siteUid);
        this.siteSelect.emit();
    }
    onSiteSelect($event) {
        const target = $event.target;
        if (!target.classList.contains(CATALOG_DROPDOWN_ANCHOR_CLASS) &&
            !target.closest(`.${CATALOG_DROPDOWN_ANCHOR_CLASS}`)) {
            this.siteSelect.emit();
        }
    }
    get hasOneSite() {
        return this.catalog.sites.length === 1;
    }
    getDropdownItems() {
        return this.catalog.sites.map((site) => (Object.assign(Object.assign({}, site), { component: CatalogHierarchyNodeMenuItemComponent })));
    }
};
__decorate([
    core.Input(),
    __metadata("design:type", Number)
], CatalogHierarchyNodeComponent.prototype, "index", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], CatalogHierarchyNodeComponent.prototype, "catalog", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", String)
], CatalogHierarchyNodeComponent.prototype, "siteId", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Boolean)
], CatalogHierarchyNodeComponent.prototype, "isLast", void 0);
__decorate([
    core.Output(),
    __metadata("design:type", Object)
], CatalogHierarchyNodeComponent.prototype, "siteSelect", void 0);
CatalogHierarchyNodeComponent = __decorate([
    core.Component({
        changeDetection: core.ChangeDetectionStrategy.OnPush,
        selector: 'se-catalog-hierarchy-node',
        template: `<div class="se-cth-node-name" [style.padding-left.px]="15 * index" [style.padding-right.px]="15 * index" [class.se-cth-node-name__last]="isLast"><fd-icon glyph="navigation-down-arrow"></fd-icon>{{ (isLast ? catalog.name : catalog.catalogName) | seL10n | async }}&nbsp; <span *ngIf="isLast">({{ 'se.catalog.hierarchy.modal.tree.this.catalog' | translate}})</span></div><div class="se-cth-node-sites"><ng-container><ng-container *ngIf="hasOneSite; else hasManySites"><a class="se-cth-node-anchor" href="" (click)="onNavigateToSite(catalog.sites[0].uid)">{{ catalog.sites[0].name | seL10n | async }}<fd-icon glyph="navigation-right-arrow"></fd-icon></a></ng-container><ng-template #hasManySites><se-dropdown-menu [dropdownItems]="dropdownItems" useProjectedAnchor="1" (click)="onSiteSelect($event)"><span class="se-cth-node-anchor">{{ this.catalog.sites.length }} Sites<fd-icon glyph="navigation-down-arrow"></fd-icon></span></se-dropdown-menu></ng-template></ng-container></div>`
    }),
    __metadata("design:paramtypes", [CatalogNavigateToSite])
], CatalogHierarchyNodeComponent);

window.__smartedit__.addDecoratorPayload("Component", "CatalogVersionDetailsComponent", {
    selector: 'se-catalog-version-details',
    template: `<div class="se-catalog-version-container" [attr.data-catalog-version]="catalogVersion.version"><div class="se-catalog-version-container__left"><se-catalog-versions-thumbnail-carousel [catalogVersion]="catalogVersion" [catalog]="catalog" [siteId]="siteId"></se-catalog-versions-thumbnail-carousel><div><div class="se-catalog-version-container__name">{{catalogVersion.version}}</div><div class="se-catalog-version-container__left__templates"><div class="se-catalog-version-container__left__template" *ngFor="let item of leftItems; let isLast = last"><se-catalog-version-item-renderer [item]="item" [siteId]="siteId" [catalog]="catalog" [catalogVersion]="catalogVersion" [activeCatalogVersion]="activeCatalogVersion"></se-catalog-version-item-renderer><div class="se-catalog-version-container__divider" *ngIf="!isLast"></div></div></div></div></div><div class="se-catalog-version-container__right"><div class="se-catalog-version-container__right__template" *ngFor="let item of rightItems"><se-catalog-version-item-renderer [item]="item" [siteId]="siteId" [catalog]="catalog" [catalogVersion]="catalogVersion" [activeCatalogVersion]="activeCatalogVersion"></se-catalog-version-item-renderer></div></div></div>`
});
let /* @ngInject */ CatalogVersionDetailsComponent = class /* @ngInject */ CatalogVersionDetailsComponent {
    constructor(catalogDetailsService) {
        this.catalogDetailsService = catalogDetailsService;
    }
    ngOnInit() {
        const { left, right } = this.catalogDetailsService.getItems();
        this.leftItems = left;
        this.rightItems = right;
    }
};
CatalogVersionDetailsComponent.$inject = ["catalogDetailsService"];
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ CatalogVersionDetailsComponent.prototype, "catalog", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ CatalogVersionDetailsComponent.prototype, "catalogVersion", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ CatalogVersionDetailsComponent.prototype, "activeCatalogVersion", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", String)
], /* @ngInject */ CatalogVersionDetailsComponent.prototype, "siteId", void 0);
/* @ngInject */ CatalogVersionDetailsComponent = __decorate([
    smarteditcommons.SeDowngradeComponent(),
    core.Component({
        selector: 'se-catalog-version-details',
        template: `<div class="se-catalog-version-container" [attr.data-catalog-version]="catalogVersion.version"><div class="se-catalog-version-container__left"><se-catalog-versions-thumbnail-carousel [catalogVersion]="catalogVersion" [catalog]="catalog" [siteId]="siteId"></se-catalog-versions-thumbnail-carousel><div><div class="se-catalog-version-container__name">{{catalogVersion.version}}</div><div class="se-catalog-version-container__left__templates"><div class="se-catalog-version-container__left__template" *ngFor="let item of leftItems; let isLast = last"><se-catalog-version-item-renderer [item]="item" [siteId]="siteId" [catalog]="catalog" [catalogVersion]="catalogVersion" [activeCatalogVersion]="activeCatalogVersion"></se-catalog-version-item-renderer><div class="se-catalog-version-container__divider" *ngIf="!isLast"></div></div></div></div></div><div class="se-catalog-version-container__right"><div class="se-catalog-version-container__right__template" *ngFor="let item of rightItems"><se-catalog-version-item-renderer [item]="item" [siteId]="siteId" [catalog]="catalog" [catalogVersion]="catalogVersion" [activeCatalogVersion]="activeCatalogVersion"></se-catalog-version-item-renderer></div></div></div>`
    }),
    __metadata("design:paramtypes", [smarteditcommons.ICatalogDetailsService])
], /* @ngInject */ CatalogVersionDetailsComponent);

/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
window.__smartedit__.addDecoratorPayload("Component", "CatalogVersionItemRendererComponent", {
    selector: 'se-catalog-version-item-renderer',
    template: `
        <ng-container>
            <div *ngIf="item.component">
                <ng-container
                    *ngComponentOutlet="item.component; injector: itemInjector"
                ></ng-container>
            </div>
        </ng-container>
    `
});
let /* @ngInject */ CatalogVersionItemRendererComponent = class /* @ngInject */ CatalogVersionItemRendererComponent {
    constructor(injector) {
        this.injector = injector;
    }
    ngOnInit() {
        this.createInjector();
    }
    ngOnChanges() {
        this.createInjector();
    }
    createInjector() {
        if (!this.item.component) {
            return;
        }
        this.itemInjector = core.Injector.create({
            parent: this.injector,
            providers: [
                {
                    provide: smarteditcommons.CATALOG_DETAILS_ITEM_DATA,
                    useValue: {
                        siteId: this.siteId,
                        catalog: this.catalog,
                        catalogVersion: this.catalogVersion,
                        activeCatalogVersion: this.activeCatalogVersion
                    }
                }
            ]
        });
    }
};
CatalogVersionItemRendererComponent.$inject = ["injector"];
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ CatalogVersionItemRendererComponent.prototype, "item", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ CatalogVersionItemRendererComponent.prototype, "catalog", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ CatalogVersionItemRendererComponent.prototype, "catalogVersion", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ CatalogVersionItemRendererComponent.prototype, "activeCatalogVersion", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", String)
], /* @ngInject */ CatalogVersionItemRendererComponent.prototype, "siteId", void 0);
/* @ngInject */ CatalogVersionItemRendererComponent = __decorate([
    smarteditcommons.SeDowngradeComponent(),
    core.Component({
        selector: 'se-catalog-version-item-renderer',
        template: `
        <ng-container>
            <div *ngIf="item.component">
                <ng-container
                    *ngComponentOutlet="item.component; injector: itemInjector"
                ></ng-container>
            </div>
        </ng-container>
    `
    }),
    __metadata("design:paramtypes", [core.Injector])
], /* @ngInject */ CatalogVersionItemRendererComponent);

window.__smartedit__.addDecoratorPayload("Component", "CatalogVersionsThumbnailCarouselComponent", {
    selector: 'se-catalog-versions-thumbnail-carousel',
    template: `<div class="se-active-catalog-thumbnail"><div class="se-active-catalog-version-container__thumbnail" (click)="onClick()"><div class="se-active-catalog-version-container__thumbnail__default-img"><div class="se-active-catalog-version-container__thumbnail__img" [ngStyle]="{'background-image': 'url(' + catalogVersion.thumbnailUrl + ')'}"></div></div></div></div>`
});
let /* @ngInject */ CatalogVersionsThumbnailCarouselComponent = class /* @ngInject */ CatalogVersionsThumbnailCarouselComponent {
    constructor(experienceService) {
        this.experienceService = experienceService;
    }
    onClick() {
        this.experienceService.loadExperience({
            siteId: this.siteId,
            catalogId: this.catalog.catalogId,
            catalogVersion: this.catalogVersion.version
        });
    }
};
CatalogVersionsThumbnailCarouselComponent.$inject = ["experienceService"];
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ CatalogVersionsThumbnailCarouselComponent.prototype, "catalog", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", Object)
], /* @ngInject */ CatalogVersionsThumbnailCarouselComponent.prototype, "catalogVersion", void 0);
__decorate([
    core.Input(),
    __metadata("design:type", String)
], /* @ngInject */ CatalogVersionsThumbnailCarouselComponent.prototype, "siteId", void 0);
/* @ngInject */ CatalogVersionsThumbnailCarouselComponent = __decorate([
    smarteditcommons.SeDowngradeComponent(),
    core.Component({
        selector: 'se-catalog-versions-thumbnail-carousel',
        template: `<div class="se-active-catalog-thumbnail"><div class="se-active-catalog-version-container__thumbnail" (click)="onClick()"><div class="se-active-catalog-version-container__thumbnail__default-img"><div class="se-active-catalog-version-container__thumbnail__img" [ngStyle]="{'background-image': 'url(' + catalogVersion.thumbnailUrl + ')'}"></div></div></div></div>`
    }),
    __metadata("design:paramtypes", [smarteditcommons.IExperienceService])
], /* @ngInject */ CatalogVersionsThumbnailCarouselComponent);

window.__smartedit__.addDecoratorPayload("Component", "HomePageLinkComponent", {
    selector: 'se-home-page-link',
    template: `<div class="home-link-container"><a href="javascript:void(0)" class="home-link-item__link se-catalog-version__link" (click)="onClick()">{{ 'se.landingpage.homepage' | translate }}</a></div>`
});
let /* @ngInject */ HomePageLinkComponent = class /* @ngInject */ HomePageLinkComponent {
    constructor(experienceService, userTrackingService, data) {
        this.experienceService = experienceService;
        this.userTrackingService = userTrackingService;
        this.data = data;
    }
    onClick() {
        const { siteId, catalog: { catalogId }, catalogVersion: { version: catalogVersion } } = this.data;
        this.experienceService.loadExperience({
            siteId,
            catalogId,
            catalogVersion
        });
        this.userTrackingService.trackingUserAction(smarteditcommons.USER_TRACKING_FUNCTIONALITY.NAVIGATION, catalogVersion + ' - HomePage');
    }
};
HomePageLinkComponent.$inject = ["experienceService", "userTrackingService", "data"];
/* @ngInject */ HomePageLinkComponent = __decorate([
    smarteditcommons.SeDowngradeComponent(),
    core.Component({
        selector: 'se-home-page-link',
        template: `<div class="home-link-container"><a href="javascript:void(0)" class="home-link-item__link se-catalog-version__link" (click)="onClick()">{{ 'se.landingpage.homepage' | translate }}</a></div>`
    }),
    __param(2, core.Inject(smarteditcommons.CATALOG_DETAILS_ITEM_DATA)),
    __metadata("design:paramtypes", [smarteditcommons.IExperienceService,
        smarteditcommons.UserTrackingService, Object])
], /* @ngInject */ HomePageLinkComponent);

/**
 * The catalog details Service makes it possible to add items in form of directive
 * to the catalog details directive
 *
 */
let /* @ngInject */ CatalogDetailsService = class /* @ngInject */ CatalogDetailsService {
    constructor() {
        this._customItems = {
            left: [
                {
                    component: HomePageLinkComponent
                }
            ],
            right: []
        };
    }
    /**
     * This method allows to add a new item/items to the template array.
     *
     * @param  items An array that hold a list of items.
     * @param  column The place where the template will be added to. If this value is empty
     * the template will be added to the left side by default. The available places are defined in the
     * constant CATALOG_DETAILS_COLUMNS
     */
    addItems(items, column) {
        if (column === smarteditcommons.CATALOG_DETAILS_COLUMNS.RIGHT) {
            this._customItems.right = this._customItems.right.concat(items);
        }
        else {
            this._customItems.left = this._customItems.left.splice(0);
            this._customItems.left.splice(this._customItems.left.length - 1, 0, ...items);
        }
    }
    /**
     * This retrieves the list of items currently extending catalog version details components.
     */
    getItems() {
        return this._customItems;
    }
};
/* @ngInject */ CatalogDetailsService = __decorate([
    smarteditcommons.SeDowngradeService(smarteditcommons.ICatalogDetailsService)
], /* @ngInject */ CatalogDetailsService);

/**
 * This module contains the {@link CatalogDetailsModule.component:catalogVersionDetails} component.
 */
let CatalogDetailsModule = class CatalogDetailsModule {
};
CatalogDetailsModule = __decorate([
    core.NgModule({
        imports: [
            common.CommonModule,
            smarteditcommons.CollapsibleContainerModule,
            smarteditcommons.CompileHtmlModule,
            smarteditcommons.L10nPipeModule,
            smarteditcommons.SharedComponentsModule,
            core$1.IconModule,
            core$2.TranslateModule.forChild()
        ],
        providers: [
            { provide: smarteditcommons.ICatalogDetailsService, useClass: CatalogDetailsService },
            CatalogNavigateToSite
        ],
        declarations: [
            HomePageLinkComponent,
            CatalogDetailsComponent,
            CatalogVersionDetailsComponent,
            CatalogVersionsThumbnailCarouselComponent,
            CatalogVersionItemRendererComponent,
            CatalogHierarchyModalComponent,
            CatalogHierarchyNodeComponent,
            CatalogHierarchyNodeMenuItemComponent
        ],
        entryComponents: [
            CatalogVersionsThumbnailCarouselComponent,
            CatalogVersionDetailsComponent,
            HomePageLinkComponent,
            CatalogDetailsComponent,
            CatalogVersionItemRendererComponent,
            CatalogHierarchyModalComponent,
            CatalogHierarchyNodeComponent,
            CatalogHierarchyNodeMenuItemComponent
        ],
        exports: [CatalogDetailsComponent]
    })
], CatalogDetailsModule);

// https://stackoverflow.com/questions/38888008/how-can-i-use-create-dynamic-template-to-compile-dynamic-component-with-angular
const SmarteditContainerFactory = (bootstrapPayload) => {
    let Smarteditcontainer = class Smarteditcontainer {
    };
    Smarteditcontainer = __decorate([
        core.NgModule({
            schemas: [core.CUSTOM_ELEMENTS_SCHEMA],
            imports: [
                platformBrowser.BrowserModule,
                animations$1.BrowserAnimationsModule,
                forms.FormsModule,
                forms.ReactiveFormsModule,
                _static.UpgradeModule,
                http.HttpClientModule,
                smarteditcommons.FundamentalsModule,
                smarteditcommons.SeGenericEditorModule,
                smarteditcommons.SharedComponentsModule,
                smarteditcommons.ClientPagedListModule,
                smarteditcommons.FilterByFieldPipeModule,
                NotificationPanelModule,
                StorageModule.forRoot(),
                exports.ToolbarModule,
                CatalogDetailsModule,
                smarteditcommons.SelectModule,
                HotkeyNotificationModule,
                ProductCatalogVersionModule,
                smarteditcommons.ConfirmDialogModule,
                smarteditcommons.HttpInterceptorModule.forRoot(smarteditcommons.UnauthorizedErrorInterceptor, smarteditcommons.ResourceNotFoundErrorInterceptor, smarteditcommons.RetryInterceptor, smarteditcommons.NonValidationErrorInterceptor, smarteditcommons.PreviewErrorInterceptor, smarteditcommons.PermissionErrorInterceptor),
                smarteditcommons.SeTranslationModule.forRoot(exports.TranslationsFetchService),
                SmarteditServicesModule,
                ...bootstrapPayload.modules,
                // AngularJS router is left with '/' path for Landing Page
                // Routes are "flat" because there are routes registered also in cmssmarteditcontainer.ts
                // And they conflict each (overriding themselves)
                smarteditcommons.SeRouteService.provideNgRoute([
                    {
                        path: smarteditcommons.NG_ROUTE_PREFIX,
                        shortcutComponent: SitesLinkComponent,
                        component: LandingPageComponent
                    },
                    {
                        path: `${smarteditcommons.NG_ROUTE_PREFIX}/sites/:siteId`,
                        component: LandingPageComponent
                    },
                    {
                        path: `${smarteditcommons.NG_ROUTE_PREFIX}/storefront`,
                        canActivate: [StorefrontPageGuard],
                        priority: 30,
                        titleI18nKey: 'se.route.storefront.title',
                        component: StorefrontPageComponent
                    },
                    {
                        path: smarteditcommons.NG_ROUTE_WILDCARD,
                        component: InvalidRouteComponent
                    }
                ], { useHash: true, initialNavigation: true, onSameUrlNavigation: 'reload' })
            ],
            declarations: [
                SmarteditcontainerComponent,
                InvalidRouteComponent,
                SitesLinkComponent,
                AnnouncementComponent,
                AnnouncementBoardComponent,
                ConfigurationModalComponent,
                PerspectiveSelectorComponent,
                HeartBeatAlertComponent,
                LandingPageComponent,
                StorefrontPageComponent,
                PageTreeContainerComponent
            ],
            entryComponents: [
                SmarteditcontainerComponent,
                SitesLinkComponent,
                AnnouncementComponent,
                ConfigurationModalComponent,
                PerspectiveSelectorComponent,
                HeartBeatAlertComponent,
                LandingPageComponent,
                StorefrontPageComponent,
                PageTreeContainerComponent
            ],
            providers: [
                {
                    provide: core.ErrorHandler,
                    useClass: smarteditcommons.SmarteditErrorHandler
                },
                SiteService,
                smarteditcommons.SSOAuthenticationHelper,
                smarteditcommons.moduleUtils.provideValues(bootstrapPayload.constants),
                { provide: router.UrlHandlingStrategy, useClass: smarteditcommons.CustomHandlingStrategy },
                // APP_BASE_HREF = "!" to be matching legacy angular JS setup
                { provide: common.APP_BASE_HREF, useValue: '!' },
                smarteditcommons.LegacyGEWidgetToCustomElementConverter,
                IframeManagerService,
                {
                    provide: smarteditcommons.IAuthenticationManagerService,
                    useClass: smarteditcommons.AuthenticationManager
                },
                {
                    provide: smarteditcommons.IAuthenticationService,
                    useClass: smarteditcommons.AuthenticationService
                },
                {
                    provide: smarteditcommons.IConfirmationModalService,
                    useClass: ConfirmationModalService
                },
                {
                    provide: smarteditcommons.ISharedDataService,
                    useClass: exports.SharedDataService
                },
                smarteditcommons.SeRouteService,
                {
                    provide: smarteditcommons.ISessionService,
                    useClass: exports.SessionService
                },
                {
                    provide: smarteditcommons.IStorageService,
                    useClass: exports.StorageService
                },
                {
                    provide: smarteditcommons.IUrlService,
                    useClass: UrlService
                },
                {
                    provide: smarteditcommons.IIframeClickDetectionService,
                    useClass: IframeClickDetectionService
                },
                {
                    provide: smarteditcommons.ICatalogService,
                    useClass: CatalogService
                },
                {
                    provide: smarteditcommons.IExperienceService,
                    useClass: ExperienceService
                },
                smarteditcommons.SmarteditRoutingService,
                smarteditcommons.ContentCatalogRestService,
                smarteditcommons.ProductCatalogRestService,
                exports.LoadConfigManagerService,
                smarteditcommons.moduleUtils.bootstrap((auth, gatewayProxy, bootstrapIndicator, featureService, configurationModalService, toolbarServiceFactory, loadConfigManagerService, gatewayFactory, smarteditBootstrapGateway, yjQuery, iframeManagerService, waitDialogService, promiseUtils, bootstrapService, sharedDataService, modalService, renderService, heartBeatService, routingService, userTrackingService) => {
                    gatewayProxy.initForService(auth, [
                        'filterEntryPoints',
                        'isAuthEntryPoint',
                        'authenticate',
                        'logout',
                        'isReAuthInProgress',
                        'setReAuthInProgress',
                        'isAuthenticated'
                    ], smarteditcommons.diNameUtils.buildServiceName(smarteditcommons.AuthenticationService));
                    gatewayFactory.initListener();
                    bootstrapIndicator.onSmarteditContainerReady().subscribe(() => {
                        routingService.init();
                        routingService.routeChangeSuccess().subscribe((event) => {
                            modalService.dismissAll();
                        });
                        loadConfigManagerService.loadAsObject().then((configurations) => {
                            sharedDataService.set('defaultToolingLanguage', configurations.defaultToolingLanguage);
                            sharedDataService.set('maxUploadFileSize', configurations.maxUploadFileSize);
                            if (!!configurations.typeAheadDebounce) {
                                sharedDataService.set('typeAheadDebounce', configurations.typeAheadDebounce);
                            }
                            if (!!configurations.typeAheadMiniSearchTermLength) {
                                sharedDataService.set('typeAheadMiniSearchTermLength', configurations.typeAheadMiniSearchTermLength);
                            }
                        });
                        featureService.addToolbarItem({
                            toolbarId: 'smartEditPerspectiveToolbar',
                            key: smarteditcommons.PERSPECTIVE_SELECTOR_WIDGET_KEY,
                            nameI18nKey: 'se.perspective.selector.widget',
                            type: 'TEMPLATE',
                            priority: 1,
                            section: 'left',
                            component: PerspectiveSelectorComponent
                        });
                        const smartEditHeaderToolbarService = toolbarServiceFactory.getToolbarService('smartEditHeaderToolbar');
                        smartEditHeaderToolbarService.addItems([
                            {
                                key: 'headerToolbar.logoTemplate',
                                type: smarteditcommons.ToolbarItemType.TEMPLATE,
                                component: LogoComponent,
                                priority: 1,
                                section: smarteditcommons.ToolbarSection.left
                            },
                            {
                                key: 'headerToolbar.userAccountTemplate',
                                type: smarteditcommons.ToolbarItemType.HYBRID_ACTION,
                                iconClassName: 'sap-icon--customer',
                                component: UserAccountComponent,
                                priority: 1,
                                actionButtonFormat: 'compact',
                                section: smarteditcommons.ToolbarSection.right,
                                dropdownPosition: smarteditcommons.ToolbarDropDownPosition.right
                            },
                            {
                                key: 'headerToolbar.languageSelectorTemplate',
                                type: smarteditcommons.ToolbarItemType.HYBRID_ACTION,
                                iconClassName: 'sap-icon--world',
                                component: smarteditcommons.HeaderLanguageDropdownComponent,
                                priority: 3,
                                actionButtonFormat: 'compact',
                                section: smarteditcommons.ToolbarSection.right,
                                dropdownPosition: smarteditcommons.ToolbarDropDownPosition.center
                            },
                            {
                                key: 'headerToolbar.configurationTemplate',
                                type: smarteditcommons.ToolbarItemType.ACTION,
                                actionButtonFormat: 'compact',
                                iconClassName: 'icon-action-settings',
                                callback: () => {
                                    configurationModalService.editConfiguration();
                                },
                                priority: 4,
                                section: smarteditcommons.ToolbarSection.right,
                                permissions: ['smartedit.configurationcenter.read']
                            },
                            {
                                key: 'headerToolbar.qualtricTemplate',
                                type: smarteditcommons.ToolbarItemType.TEMPLATE,
                                priority: 2,
                                section: smarteditcommons.ToolbarSection.right,
                                component: QualtricsComponent
                            }
                        ]);
                        const smartEditExperienceToolbarService = toolbarServiceFactory.getToolbarService('smartEditExperienceToolbar');
                        smartEditExperienceToolbarService.addItems([
                            {
                                key: 'se.cms.shortcut',
                                type: smarteditcommons.ToolbarItemType.TEMPLATE,
                                component: smarteditcommons.ShortcutLinkComponent,
                                priority: 1,
                                section: smarteditcommons.ToolbarSection.left
                            },
                            {
                                key: 'experienceToolbar.deviceSupportTemplate',
                                type: smarteditcommons.ToolbarItemType.TEMPLATE,
                                component: DeviceSupportWrapperComponent,
                                priority: 1,
                                section: smarteditcommons.ToolbarSection.right
                            },
                            {
                                type: smarteditcommons.ToolbarItemType.TEMPLATE,
                                key: 'experienceToolbar.experienceSelectorTemplate',
                                // className: 'se-experience-selector',
                                component: ExperienceSelectorWrapperComponent,
                                priority: 1,
                                section: smarteditcommons.ToolbarSection.middle
                            }
                        ]);
                        function offSetStorefront() {
                            // Set the storefront offset
                            yjQuery(smarteditcommons.SMARTEDIT_IFRAME_WRAPPER_ID).css('padding-top', yjQuery('.se-toolbar-group').height() + 'px');
                        }
                        // storefront actually loads twice all the JS files, including webApplicationInjector.js, smartEdit must be protected against receiving twice a smartEditBootstrap event
                        function getBootstrapNamespace() {
                            /* forbiddenNameSpaces window._:false */
                            if (window.__smartedit__.smartEditBootstrapped) {
                                window.__smartedit__.smartEditBootstrapped = {};
                            }
                            return window.__smartedit__.smartEditBootstrapped;
                        }
                        smarteditBootstrapGateway
                            .getInstance()
                            .subscribe('loading', (eventId, data) => {
                            const deferred = promiseUtils.defer();
                            iframeManagerService.setCurrentLocation(data.location);
                            waitDialogService.showWaitModal();
                            const smartEditBootstrapped = getBootstrapNamespace();
                            delete smartEditBootstrapped[data.location];
                            return deferred.promise;
                        });
                        smarteditBootstrapGateway
                            .getInstance()
                            .subscribe('unloading', (eventId, data) => {
                            const deferred = promiseUtils.defer();
                            waitDialogService.showWaitModal();
                            return deferred.promise;
                        });
                        smarteditBootstrapGateway
                            .getInstance()
                            .subscribe('bootstrapSmartEdit', (eventId, data) => {
                            offSetStorefront();
                            const deferred = promiseUtils.defer();
                            const smartEditBootstrapped = getBootstrapNamespace();
                            if (!smartEditBootstrapped[data.location]) {
                                smartEditBootstrapped[data.location] = true;
                                loadConfigManagerService
                                    .loadAsObject()
                                    .then((configurations) => {
                                    bootstrapService.bootstrapSEApp(configurations);
                                    deferred.resolve();
                                });
                            }
                            else {
                                deferred.resolve();
                            }
                            return deferred.promise;
                        });
                        smarteditBootstrapGateway
                            .getInstance()
                            .subscribe('smartEditReady', function () {
                            const deferred = promiseUtils.defer();
                            deferred.resolve();
                            waitDialogService.hideWaitModal();
                            return deferred.promise;
                        });
                        userTrackingService.initConfiguration();
                    });
                }, [
                    smarteditcommons.IAuthenticationService,
                    smarteditcommons.GatewayProxy,
                    smarteditcommons.AngularJSBootstrapIndicatorService,
                    smarteditcommons.IFeatureService,
                    ConfigurationModalService,
                    smarteditcommons.IToolbarServiceFactory,
                    exports.LoadConfigManagerService,
                    smarteditcommons.GatewayFactory,
                    smarteditcommons.SmarteditBootstrapGateway,
                    smarteditcommons.YJQUERY_TOKEN,
                    IframeManagerService,
                    smarteditcommons.IWaitDialogService,
                    smarteditcommons.PromiseUtils,
                    exports.BootstrapService,
                    smarteditcommons.ISharedDataService,
                    smarteditcommons.IModalService,
                    smarteditcommons.IRenderService,
                    HeartBeatService,
                    smarteditcommons.SmarteditRoutingService,
                    smarteditcommons.UserTrackingService
                ]),
                smarteditcommons.moduleUtils.initialize((legacyGEWidgetToCustomElementConverter, delegateRestService, httpClient, restServiceFactory, permissionsRegistrationService, permissionService, authorizationService) => {
                    smarteditcommons.diBridgeUtils.downgradeService('httpClient', http.HttpClient);
                    smarteditcommons.diBridgeUtils.downgradeService('restServiceFactory', smarteditcommons.RestServiceFactory);
                    smarteditcommons.diBridgeUtils.downgradeService('authenticationService', smarteditcommons.AuthenticationService, smarteditcommons.IAuthenticationService);
                    smarteditcommons.diBridgeUtils.downgradeService('l10nPipe', smarteditcommons.L10nPipe);
                    permissionService.registerDefaultRule({
                        names: [DEFAULT_DEFAULT_RULE_NAME],
                        verify: (permissionNameObjs) => {
                            const permissionNames = permissionNameObjs.map((permissionName) => permissionName.name);
                            return authorizationService.hasGlobalPermissions(permissionNames);
                        }
                    });
                    legacyGEWidgetToCustomElementConverter.convert();
                    permissionsRegistrationService.registerRulesAndPermissions();
                }, [
                    smarteditcommons.LegacyGEWidgetToCustomElementConverter,
                    exports.DelegateRestService,
                    http.HttpClient,
                    smarteditcommons.RestServiceFactory,
                    PermissionsRegistrationService,
                    smarteditcommons.IPermissionService,
                    smarteditcommons.AuthorizationService,
                    smarteditcommons.L10nService
                ])
            ],
            bootstrap: [SmarteditcontainerComponent]
        })
    ], Smarteditcontainer);
    return Smarteditcontainer;
};

if (process.env.NODE_ENV === 'production') {
    core.enableProdMode();
}

exports.SmarteditContainerFactory = SmarteditContainerFactory;
