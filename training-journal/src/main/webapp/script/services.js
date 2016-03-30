'use strict';

var module = angular.module('trainingJournal');


// Service that provides persons operations
module.factory('personService', function ($resource) {
    return $resource('rest/api/persons/:id');
});

// Service that provides persons operations
module.factory('trainingService', function ($resource) {
    return $resource('rest/api/trainings/:id');
});


module.factory('authResource', ['$resource', function($resource) {
    return $resource('rest/login/', null,
        {
            'save': {
                method: 'POST',
                ignoreAuthToken: true
            }
        },
        {
            userId: '@userId',
            password: '@password'
        });
}]);

module.factory('authService', function(authResource) {
    return {
        login: function(userId, password) {
            console.log('Username:',userId,' password ',password );
            return authResource.save({userId: userId, password: password}).
                $promise.then(function(data) {
                    sessionStorage.setItem('token', data.token);
                    console.log('uloz token');
                });
        },
        logout: function() {
            console.log('logout');
            sessionStorage.remoteItem('token');
        }
    }
});

