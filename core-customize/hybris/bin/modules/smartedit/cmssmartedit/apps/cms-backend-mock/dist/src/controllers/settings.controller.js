"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.SettingsController = void 0;
const tslib_1 = require("tslib");
const common_1 = require("@nestjs/common");
let SettingsController = class SettingsController {
    getSettings() {
        return { 'smartedit.pagetree.enabled': 'false' };
    }
};
tslib_1.__decorate([
    common_1.Get('smartedit/settings'),
    tslib_1.__metadata("design:type", Function),
    tslib_1.__metadata("design:paramtypes", []),
    tslib_1.__metadata("design:returntype", void 0)
], SettingsController.prototype, "getSettings", null);
SettingsController = tslib_1.__decorate([
    common_1.Controller()
], SettingsController);
exports.SettingsController = SettingsController;
//# sourceMappingURL=settings.controller.js.map