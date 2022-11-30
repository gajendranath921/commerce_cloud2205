"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.SynchronizationController = void 0;
const tslib_1 = require("tslib");
const common_1 = require("@nestjs/common");
const lodash_1 = require("lodash");
const synchronization_1 = require("../../fixtures/constants/synchronization");
const services_1 = require("../services");
let SynchronizationController = class SynchronizationController {
    constructor(synchronizationService) {
        this.synchronizationService = synchronizationService;
    }
    createSynchronizationStatus(syncList) {
        const itemIds = syncList.items.map((item) => item.itemId);
        const newlyCreatedPageSyncStatus = this.synchronizationService.getNewlyCreatedPageSyncStatus();
        const currentSyncStatus = itemIds.indexOf('trashedCategoryPage') > -1
            ? synchronization_1.trashedCategoryPageSyncStatus
            : synchronization_1.syncStatus;
        const status = itemIds.indexOf('trashedCategoryPage') > -1
            ? this.synchronizationService.getTrashedCategorySyncStatus()
            : this.synchronizationService.getSyncStatus();
        if (itemIds.indexOf(currentSyncStatus.itemId) > -1 &&
            currentSyncStatus.status !== 'IN_SYNC') {
            this.synchronizationService.makeStatusInSync(status);
        }
        else if (itemIds.indexOf(newlyCreatedPageSyncStatus.itemId) > -1 &&
            newlyCreatedPageSyncStatus.status !== 'IN_SYNC') {
            newlyCreatedPageSyncStatus.lastSyncStatus = new Date(2016, 10, 10, 13, 10, 0).getTime();
            this.synchronizationService.makeStatusInSync(newlyCreatedPageSyncStatus);
        }
        else {
            status.selectedDependencies.forEach((item) => {
                this._handleSelectedDependencyItem(itemIds, item);
            });
        }
        if (itemIds.indexOf('trashedCategoryPage') > -1) {
            this.synchronizationService.setTrashedCategorySyncStatus(status);
        }
        else {
            this.synchronizationService.setSyncStatus(status);
        }
        status.lastModifiedDate = new Date();
        return [200, status];
    }
    getSynchronizationStatus(pageId) {
        const counter = this.synchronizationService.getCounter();
        const status = this.synchronizationService.getSyncStatus();
        if (counter === 3) {
            if (status.selectedDependencies[1].status === 'IN_PROGRESS') {
                status.selectedDependencies[1].status = 'IN_SYNC';
                status.selectedDependencies[1].dependentItemTypesOutOfSync = [];
                this.synchronizationService.setCounter(1);
            }
        }
        if (pageId === 'syncedpageuid' || pageId === 'synchedPage') {
            const syncedPageStatus = lodash_1.cloneDeep(status);
            syncedPageStatus.status = 'IN_SYNC';
            syncedPageStatus.dependentItemTypesOutOfSync = [];
            syncedPageStatus.selectedDependencies.forEach((selectedDependency) => {
                selectedDependency.status = 'IN_SYNC';
            });
            return syncedPageStatus;
        }
        else if (pageId === 'secondpage' || pageId === 'trashedProductPage') {
            return lodash_1.cloneDeep(this.synchronizationService.getNewlyCreatedPageSyncStatus());
        }
        else if (pageId === 'otherpage') {
            return lodash_1.cloneDeep(synchronization_1.otherPageSyncStatus);
        }
        else if (pageId === 'trashedCategoryPage') {
            return lodash_1.cloneDeep(this.synchronizationService.getTrashedCategorySyncStatus());
        }
        else if (pageId === 'trashedContentPage') {
            return lodash_1.cloneDeep(this.synchronizationService.getTrashedContentSyncStatus());
        }
        else {
            return status;
        }
    }
    getSynchronizationStatusByCatalog() {
        return synchronization_1.currentSyncJob;
    }
    createSynchronizationStatusForCatalog() {
        synchronization_1.currentSyncJob.syncStatus = 'RUNNING';
        synchronization_1.currentSyncJob.syncResult = 'UNKNOWN';
        return synchronization_1.currentSyncJob;
    }
    refreshFixtureState() {
        this.synchronizationService.refreshState();
    }
    _handleSelectedDependencyItem(itemIds, iSyncStatus) {
        const handleFooterSlot = () => {
            iSyncStatus.status = 'SYNC_FAILED';
            iSyncStatus.dependentItemTypesOutOfSync = [
                {
                    type: 'Component',
                    i18nKey: 'component 5'
                }
            ];
            iSyncStatus.selectedDependencies.forEach((subItem) => {
                if (itemIds.indexOf(subItem.itemId) <= -1) {
                    return;
                }
                if (subItem.itemId !== 'component5') {
                    return;
                }
                subItem.status = 'SYNC_FAILED';
                subItem.dependentItemTypesOutOfSync = [
                    {
                        type: 'Other',
                        i18nKey: 'other'
                    }
                ];
            });
        };
        if (itemIds.indexOf(iSyncStatus.itemId) <= -1) {
            return;
        }
        switch (iSyncStatus.itemId) {
            case 'footerSlot':
                handleFooterSlot();
                break;
            case 'bottomHeaderSlot':
                iSyncStatus.status = 'IN_PROGRESS';
                break;
            default:
                iSyncStatus.status = 'IN_SYNC';
                iSyncStatus.dependentItemTypesOutOfSync = [];
                iSyncStatus.selectedDependencies.forEach((subItem) => {
                    subItem.status = 'IN_SYNC';
                    subItem.dependentItemTypesOutOfSync = [];
                });
        }
    }
};
tslib_1.__decorate([
    common_1.Post('cmssmarteditwebservices/v1/sites/:baseSiteId/catalogs/:catalogId/versions/:versionId/synchronizations/versions/:targetCatalogVersion*'),
    tslib_1.__param(0, common_1.Body()),
    tslib_1.__metadata("design:type", Function),
    tslib_1.__metadata("design:paramtypes", [Object]),
    tslib_1.__metadata("design:returntype", void 0)
], SynchronizationController.prototype, "createSynchronizationStatus", null);
tslib_1.__decorate([
    common_1.Get('cmssmarteditwebservices/v1/sites/:baseSiteId/catalogs/:catalogId/versions/:versionId/synchronizations/versions/:targetCatalogVersion/pages/:pageId'),
    tslib_1.__param(0, common_1.Param('pageId')),
    tslib_1.__metadata("design:type", Function),
    tslib_1.__metadata("design:paramtypes", [String]),
    tslib_1.__metadata("design:returntype", void 0)
], SynchronizationController.prototype, "getSynchronizationStatus", null);
tslib_1.__decorate([
    common_1.Get('cmswebservices/v1/catalogs/:catalogId/versions/:sourceVersionId/synchronizations/versions/:targetVersionId'),
    tslib_1.__metadata("design:type", Function),
    tslib_1.__metadata("design:paramtypes", []),
    tslib_1.__metadata("design:returntype", void 0)
], SynchronizationController.prototype, "getSynchronizationStatusByCatalog", null);
tslib_1.__decorate([
    common_1.Post('cmswebservices/v1/catalogs/:catalogId/versions/:sourceVersionId/synchronizations/versions/:targetVersionId'),
    tslib_1.__metadata("design:type", Function),
    tslib_1.__metadata("design:paramtypes", []),
    tslib_1.__metadata("design:returntype", void 0)
], SynchronizationController.prototype, "createSynchronizationStatusForCatalog", null);
tslib_1.__decorate([
    common_1.Post('api/refresh/synchronization'),
    tslib_1.__metadata("design:type", Function),
    tslib_1.__metadata("design:paramtypes", []),
    tslib_1.__metadata("design:returntype", void 0)
], SynchronizationController.prototype, "refreshFixtureState", null);
SynchronizationController = tslib_1.__decorate([
    common_1.Controller(),
    tslib_1.__metadata("design:paramtypes", [services_1.SynchronizationService])
], SynchronizationController);
exports.SynchronizationController = SynchronizationController;
//# sourceMappingURL=synchronization.controller.js.map