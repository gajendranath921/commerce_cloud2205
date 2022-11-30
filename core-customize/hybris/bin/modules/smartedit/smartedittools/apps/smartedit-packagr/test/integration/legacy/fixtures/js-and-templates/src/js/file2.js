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
