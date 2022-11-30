'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

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

/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
const decoratorsToTest = ['Injectable', 'Component'];
const { Injectable, Component } = decoratorsToTest.reduce((acc, current) => {
    acc[current] = function (providedConstructor) {
        return providedConstructor;
    };
}, {});
window.__smartedit__.addDecoratorPayload("Injectable", "InjectableTest", {
    data: 'some data'
});
/* @ngInject */ exports.InjectableTest = class /* @ngInject */ InjectableTest {
    constructor($log) { }
};
exports.InjectableTest.$inject = ["$log"];
/* @ngInject */ exports.InjectableTest = __decorate([
    Injectable({
        data: 'some data'
    })
], /* @ngInject */ exports.InjectableTest);
window.__smartedit__.addDecoratorPayload("Component", "ComponentTest", {
    data: 'other data'
});
exports.ComponentTest = class ComponentTest {
    constructor($log) { }
};
exports.ComponentTest = __decorate([
    Component({
        data: 'other data'
    })
], exports.ComponentTest);
