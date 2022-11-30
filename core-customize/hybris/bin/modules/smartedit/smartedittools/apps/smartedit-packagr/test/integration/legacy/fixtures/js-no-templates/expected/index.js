'use strict';

angular.module('fooModule', []).service('foo', function() {
    this.sayHello = function() {
        return 'foo';
    };
});

(function(){
      var angular = angular || window.angular;
      var SE_NG_TEMPLATE_MODULE = null;
      
      try {
        SE_NG_TEMPLATE_MODULE = angular.module('myTemplates');
      } catch (err) {}
      SE_NG_TEMPLATE_MODULE = SE_NG_TEMPLATE_MODULE || angular.module('myTemplates', []);
      SE_NG_TEMPLATE_MODULE.run(['$templateCache', function($templateCache) {
        
      }]);
    })();

angular.module('barModule', ['fooModule']).service('bar', ["foo", function(foo) {
    this.sayHello = function() {
        return foo.sayHello() + 'bar';
    };
}]);
