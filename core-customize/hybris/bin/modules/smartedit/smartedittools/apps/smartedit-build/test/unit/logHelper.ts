/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import * as angular from 'angular';

export class LogHelper implements angular.ILogService {
    debug: angular.ILogCall = (function () {
        const f: any = (...args: any[]) => {
            return console.debug.call(this, args);
        };
        f.logs = [];
        return f;
    })();

    info: angular.ILogCall = (function () {
        const f: any = (...args: any[]) => {
            return console.info.call(this, args);
        };
        f.logs = [];
        return f;
    })();

    log: angular.ILogCall = (function () {
        const f: any = (...args: any[]) => {
            return console.log.call(this, args);
        };
        f.logs = [];
        return f;
    })();

    error: angular.ILogCall = (function () {
        const f: any = (...args: any[]) => {
            return console.error.call(this, args);
        };
        f.logs = [];
        return f;
    })();

    warn: angular.ILogCall = (function () {
        const f: any = (...args: any[]) => {
            return console.warn.call(this, args);
        };
        f.logs = [];
        return f;
    })();

    constructor() {
        spyOn(this as LogHelper, 'debug');
        spyOn(this as LogHelper, 'info');
        spyOn(this as LogHelper, 'log');
        spyOn(this as LogHelper, 'error');
        spyOn(this as LogHelper, 'warn');
    }

    // from angular-mocks
    assertEmpty(): void {
        throw new Error(`LogHelper.assertEmpty() was not implemented`);
    }

    // from angular-mocks
    reset(): void {
        throw new Error(`LogHelper.reset() was not implemented`);
    }
}
