angular.module('barModule', ['fooModule']).service('bar', function(foo) {
    this.sayHello = function() {
        return foo.sayHello() + 'bar';
    };
});
