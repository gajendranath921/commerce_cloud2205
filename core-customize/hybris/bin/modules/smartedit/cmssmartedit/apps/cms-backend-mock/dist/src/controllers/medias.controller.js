"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.MediasController = void 0;
const tslib_1 = require("tslib");
const common_1 = require("@nestjs/common");
const services_1 = require("../services");
let MediasController = class MediasController {
    constructor(mediaService) {
        this.mediaService = mediaService;
    }
    findMedias(query) {
        return { media: this.mediaService.filterMediaByInput(query.mask), pagination: {} };
    }
};
tslib_1.__decorate([
    common_1.Get('cmswebservices/v1/catalogs/:catalogId/versions/:versionId/medias'),
    tslib_1.__param(0, common_1.Query()),
    tslib_1.__metadata("design:type", Function),
    tslib_1.__metadata("design:paramtypes", [Object]),
    tslib_1.__metadata("design:returntype", void 0)
], MediasController.prototype, "findMedias", null);
MediasController = tslib_1.__decorate([
    common_1.Controller(),
    tslib_1.__metadata("design:paramtypes", [services_1.MediaService])
], MediasController);
exports.MediasController = MediasController;
//# sourceMappingURL=medias.controller.js.map