'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@angular/core');

angular
    .module('fooModule', [])
    .service('foo', function() {
        this.sayHello = function() {
            return 'foo';
        };
    })
    .component('fooComponent', {
        templateUrl: 'fooTemplate.html'
    });

angular.module('barModule', ['fooModule']).service('bar', ["foo", function(foo) {
    this.sayHello = function() {
        return foo.sayHello() + 'bar';
    };
}]);

(function(){
      var angular = angular || window.angular;
      var SE_NG_TEMPLATE_MODULE = null;
      
      try {
        SE_NG_TEMPLATE_MODULE = angular.module('myTemplates');
      } catch (err) {}
      SE_NG_TEMPLATE_MODULE = SE_NG_TEMPLATE_MODULE || angular.module('myTemplates', []);
      SE_NG_TEMPLATE_MODULE.run(['$templateCache', function($templateCache) {
         
    $templateCache.put(
        "fooTemplate.html", 
        "<div>This is the angularJS template!!<div>It also contains 'quotes'</div><div>It also contains \"double quotes\"</div></div>"
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

window.__smartedit__.addDecoratorPayload("Component", "TestComponent", {
    selector: 'test',
    template: `<div>This is the angular component!!<div>It contains 'quotes'</div><div>It contains "double quotes"</div></div>`
});
exports.TestComponent = class TestComponent {
    constructor() { }
};
exports.TestComponent = __decorate([
    core.Component({
        selector: 'test',
        template: `<div>This is the angular component!!<div>It contains 'quotes'</div><div>It contains "double quotes"</div></div>`
    })
], exports.TestComponent);
