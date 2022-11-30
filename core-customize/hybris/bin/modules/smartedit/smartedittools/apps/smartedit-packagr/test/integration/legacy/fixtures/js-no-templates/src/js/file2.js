angular.module('fooModule', []).service('foo', function() {
    this.sayHello = function() {
        return 'foo';
    };
});
