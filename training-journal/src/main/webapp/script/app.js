'use strict';

var module = angular.module('trainingJournal', [
    'ngResource',
    'ngGrid',
    'ui.router',
    'ui.bootstrap',
    'ngWebSocket'
]);

module.config(['$stateProvider', '$urlRouterProvider', '$httpProvider',
    function($stateProvider, $urlRouterProvider, $httpProvider) {

        $httpProvider.interceptors.push('authInterceptor');


        $stateProvider.
            state("home", {
                url : "/",
                template: "Hello world"
            }).
            state("persons", {
                url: '/persons',
                templateUrl: 'partials/person-list.html',
                controller: 'personListController'
            }).
            state("trainings", {
                url: "/trainings",
                templateUrl: 'partials/training-list.html',
                controller: 'trainingListController'
            });
        $urlRouterProvider.otherwise("/");

    }
]);

module.factory('webSocket', function($websocket) {
    var stream = $websocket('ws://localhost:8080/training-journal/activesockets');

    var counter = [];

    stream.onMessage(function(message) {
        counter.push(JSON.parse(message.data));
    });

    var ws = {
        counter: counter
    };

    return ws;
});

module.factory('authInterceptor', ['$q', '$injector', function($q, $injector) {
    var requestInterceptor = {
        request: function(config) {
            if(config.ignoreAuthToken !== true) {
                var token = sessionStorage.getItem('token');
                if(token != null && token != '' && token != 'undefined') {
                    console.log('vkladam token');
                    config.headers.Authorization = 'Token  ' + token;
                }
            }
            return config;
        }, responseError : function (response) {
            if (response.status == 401 || response.status == 403) {
                $injector.get('$state').go("home");
            }
        }
    };

    return requestInterceptor;
}]);


//log state according ui-router
//module.run(['$rootScope', function($rootScope) {
//    $rootScope.$on('$stateChangeStart',
//        function(event, toState, toParams, fromState, fromParams){ console.log(toState, 'toState'); })
//}]);

