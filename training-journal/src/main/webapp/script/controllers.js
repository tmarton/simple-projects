'use strict';

var module = angular.module('trainingJournal');

// Create a controller with name personsListController to bind to the grid section.
module.controller('personListController', ['$scope', '$log', '$rootScope', 'personService', function ($scope, $log, $rootScope, personService) {
    // Initialize required information: sorting, the first page to show and the grid options.
    $scope.sortInfo = {fields: ['id'], directions: ['asc']};
    $scope.pagingOptions = {
        pageSize: 10,
        totalItems: 0,
        currentPage: 1
    };

    $rootScope.gridOptions = {
        data: 'persons',
        sortInfo: $scope.sortInfo,
        pagingOptions: $scope.pagingOptions,

        columnDefs: [
            {field: 'id', displayName: 'Id'},
            {field: 'firstName', displayName: 'First Name'},
            {field: 'lastName', displayName: 'Last Name'},
            { field: '', width: 30, cellTemplate: '<span class="glyphicon glyphicon-remove remove" ng-click="deleteRow(row)"></span>' }
        ],

        multiSelect: false,
        selectedItems: [],
        // Broadcasts an event when a row is selected, to signal the form that it needs to load the row data.
        afterSelectionChange: function (rowItem) {
            if (rowItem.selected) {
                $rootScope.$broadcast('personSelected', $scope.gridOptions.selectedItems[0].id);
            }
        }
    };

    // Refresh the grid, calling the appropriate rest method.
    $scope.refreshGrid = function () {
        personService.query(function (data) {
            var page = $scope.pagingOptions.currentPage;
            var pageSize = $scope.pagingOptions.pageSize;
            var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
            $scope.persons = pagedData;
        })
    };

    // Broadcast an event when an element in the grid is deleted. No real deletion is perfomed at this point.
    $scope.deleteRow = function (row) {
        $rootScope.$broadcast('deletePerson', row.entity.id);
    };

    // Watch the sortInfo variable. If changes are detected than we need to refresh the grid.
    // This also works for the first page access, since we assign the initial sorting in the initialize section.
    $scope.$watch('sortInfo.fields[0]', function () {
        $scope.refreshGrid();
    }, true);

    // Do something when the grid is sorted.
    // The grid throws the ngGridEventSorted that gets picked up here and assigns the sortInfo to the scope.
    // This will allow to watch the sortInfo in the scope for changed and refresh the grid.
    $scope.$on('ngGridEventSorted', function (event, sortInfo) {
        $scope.sortInfo = sortInfo;
    });

    // Picks the event broadcasted when a person is saved or deleted to refresh the grid elements with the most
    // updated information.
    $scope.$on('refreshGrid', function () {
        $scope.refreshGrid();
    });

    // Picks the event broadcasted when the form is cleared to also clear the grid selection.
    $scope.$on('clear', function () {
        if ($scope.gridOptions != 'undefined') {
            $scope.gridOptions.selectAll(false);
        } else {
            $log.warn('$scope.gridOptions is undefined on receiving clear signal');
        }
    });
}]);

// Create a controller with name personsFormController to bind to the form section.
module.controller('personsFormController', function ($scope, $rootScope, personService) {
    //Clears the form. Either by clicking the 'Clear' button in the form, or when a successfull save is performed.
    $scope.clearForm = function () {
        $scope.person = null;
        // Resets the form validation state.
        $scope.personForm.$setPristine();
        // Broadcast the event to also clear the grid selection.
        $rootScope.$broadcast('clear');
    };

    //Calls the rest method to save a person.
    $scope.updatePerson = function () {
        personService.save($scope.person).$promise.then(
            function () {
                // Broadcast the event to refresh the grid.
                $rootScope.$broadcast('refreshGrid');
                // Broadcast the event to display a save message.
                $rootScope.$broadcast('entitySaved');
                $scope.clearForm();
            },
            function () {
                // Broadcast the event for a server error.
                $rootScope.$broadcast('error');
            });
    };

    //Picks up the event broadcasted when the person is selected from the grid and perform the person load by calling
    //the appropiate rest service.
    $scope.$on('personSelected', function (event, id) {
        $scope.person = personService.get({id: id});
    });

    //Picks us the event broadcasted when the person is deleted from the grid and perform the actual person delete by
    //calling the appropiate rest service.
    $scope.$on('deletePerson', function (event, id) {
        personService.delete({id: id}).$promise.then(
            function () {
                // Broadcast the event to refresh the grid.
                $rootScope.$broadcast('refreshGrid');
                // Broadcast the event to display a delete message.
                $rootScope.$broadcast('entityDeleted');
                $scope.clearForm();
            },
            function () {
                // Broadcast the event for a server error.
                $rootScope.$broadcast('error');
            });
    });
});

module.controller('trainingListController', function ($scope, $rootScope, trainingService) {
    $scope.sortInfo = {fields: ['id'], directions: ['asc']};
    $scope.pagingOptions = {
        pageSize: 10,
        totalItems: 0,
        currentPage: 1
    };

    $rootScope.gridOptions = {
        data: 'trainings',
        sortInfo: $scope.sortInfo,
        pagingOptions: $scope.pagingOptions,

        columnDefs: [
            {field: 'id', displayName: 'Id'},
            {field: 'time', displayName: 'Time', cellFilter: 'date:\'yyyy-MM-dd HH:mm:ss\'', width: '180px'},
            {field: 'name', displayName: 'Name'},
            { field: '', width: 30, cellTemplate: '<span class="glyphicon glyphicon-remove remove" ng-click="deleteRow(row)"></span>' }
        ],

        multiSelect: false,
        selectedItems: [],
        // Broadcasts an event when a row is selected, to signal the form that it needs to load the row data.
        afterSelectionChange: function (rowItem) {
            if (rowItem.selected) {
                $rootScope.$broadcast('trainingSelected', $scope.gridOptions.selectedItems[0].id);
            }
        }
    };

    // Refresh the grid, calling the appropriate rest method.
    $scope.refreshGrid = function () {
        trainingService.query(function (data) {
            var page = $scope.pagingOptions.currentPage;
            var pageSize = $scope.pagingOptions.pageSize;
            var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
            $scope.trainings = pagedData;
        })
    };

    // Broadcast an event when an element in the grid is deleted. No real deletion is perfomed at this point.
    $scope.deleteRow = function (row) {
        $rootScope.$broadcast('deleteTraining', row.entity.id);
    };

    // Watch the sortInfo variable. If changes are detected than we need to refresh the grid.
    // This also works for the first page access, since we assign the initial sorting in the initialize section.
    $scope.$watch('sortInfo.fields[0]', function () {
        $scope.refreshGrid();
    }, true);

    // Do something when the grid is sorted.
    // The grid throws the ngGridEventSorted that gets picked up here and assigns the sortInfo to the scope.
    // This will allow to watch the sortInfo in the scope for changed and refresh the grid.
    $scope.$on('ngGridEventSorted', function (event, sortInfo) {
        $scope.sortInfo = sortInfo;
    });

    // Picks the event broadcasted when a person is saved or deleted to refresh the grid elements with the most
    // updated information.
    $scope.$on('refreshGrid', function () {
        $scope.refreshGrid();
    });

    // Picks the event broadcasted when the form is cleared to also clear the grid selection.
    $scope.$on('clear', function () {
        if ($scope.gridOptions != 'undefined') {
            $scope.gridOptions.selectAll(false);
        } else {
            $log.warn('$scope.gridOptions is undefined on receiving clear signal');
        }
    });

});

// Create a controller with name trainingFormController to bind to the form section.
module.controller('trainingFormController', function ($scope, $rootScope, trainingService) {

    var
        WEIGHTLIFTING = { key: 'WEIGHTLIFTING', value: 'Weightlifting'},
        GYMNASTICS = {key: 'GYMNASTICS', value: 'Gymnastics'},
        CONDITIONING = {key: 'CONDITIONING', value: 'Conditioning'},
        SKILL = {key: 'SKILL', value: 'Skill'},
        STRENGTH = {key: 'STRENGTH', value: 'Strength'};

    $scope.sectionTypes = [
        WEIGHTLIFTING, GYMNASTICS, CONDITIONING, SKILL, STRENGTH
    ];

    $scope.addSection = function(sectionType) {
        if(angular.isUndefined($scope.training)) {
            $scope.training = {};
        }
        if(angular.isUndefined($scope.training.sections)) {
            $scope.training.sections = [];
        }
        $scope.training.sections.push({
            "type": sectionType,
            "exercises": []
        });
    };

    $scope.removeSection = function(section) {
        var index = $scope.training.sections.indexOf(section);
        if(index !== -1) {
            $scope.training.sections.splice(index, 1);
        }
    };

    $scope.removeExcercise = function(section, excercise) {
        var index = section.exercises.indexOf(excercise);
        if(index !== -1) {
            section.exercises.splice(index, 1);
        }
    };

    $scope.addExcercise = function(section, exercise) {
        section.exercises.push(exercise);
        $scope.trainingForm.$setPristine();
    };

    //Clears the form. Either by clicking the 'Clear' button in the form, or when a successfull save is performed.
    $scope.clearForm = function () {
        $scope.training = null;
        // Resets the form validation state.
        $scope.trainingForm.$setPristine();
        // Broadcast the event to also clear the grid selection.
        $rootScope.$broadcast('clear');
    };

    //Calls the rest method to save a person.
    $scope.updateTraining = function () {
        $scope.training.time = new Date().toISOString().slice(0,19);
        trainingService.save($scope.training).$promise.then(
            function () {
                // Broadcast the event to refresh the grid.
                $rootScope.$broadcast('refreshGrid');
                // Broadcast the event to display a save message.
                $rootScope.$broadcast('trainingSaved');
                $rootScope.$broadcast('entitySaved');
                $scope.clearForm();
            },
            function () {
                // Broadcast the event for a server error.
                $rootScope.$broadcast('error');
            });
    };

    //Picks up the event broadcasted when the person is selected from the grid and perform the person load by calling
    //the appropiate rest service.
    $scope.$on('trainingSelected', function (event, id) {
        $scope.training = trainingService.get({id: id});
    });

    //Picks us the event broadcasted when the person is deleted from the grid and perform the actual person delete by
    //calling the appropiate rest service.
    $scope.$on('deleteTraining', function (event, id) {
        trainingService.delete({id: id}).$promise.then(
            function () {
                // Broadcast the event to refresh the grid.
                $rootScope.$broadcast('refreshGrid');
                // Broadcast the event to display a delete message.
                $rootScope.$broadcast('entityDeleted');
                $scope.clearForm();
            },
            function () {
                // Broadcast the event for a server error.
                $rootScope.$broadcast('error');
            });
    });
});

module.controller('headerController', function ($modal, $scope) {
    $scope.loginModal = function () {
        console.log("otvor modal");
        $modal.open({
            templateUrl: 'partials/loginModal.html',
            controller: 'loginController'
        });
    }
});

module.controller('footerController', function ($scope, webSocket) {
    $scope.webSocket = webSocket;
});

module.controller('loginController', function ($scope, authService, $modalInstance) {
    var isBadLoginVal = false;
    angular.extend($scope, {
        user: {

        },
        login: function () {
            authService.login($scope.user.name, $scope.user.password).then(function () {
                console.log('Authentication OK');
                $modalInstance.close();
            }, function () {
                console.log('Authentication fail');
                isBadLoginVal = true;
            }).finally(function() {
                console.log('karamelky');
            });
        },
        isBadLogin: function() {
            return isBadLoginVal;
        },
        cancel: function() {
            $modalInstance.dismiss('cancel');
        }
    })
    ;
});


// Create a controller with name alertMessagesController to bind to the feedback messages section.
module.controller('alertMessagesController', function ($scope) {
    // Picks up the event to display a saved message.
    $scope.$on('entitySaved', function () {
        $scope.alerts = [
            { type: 'success', msg: 'Record saved successfully!' }
        ];
    });

    // Picks up the event to display a deleted message.
    $scope.$on('entityDeleted', function () {
        $scope.alerts = [
            { type: 'success', msg: 'Record deleted successfully!' }
        ];
    });

    // Picks up the event to display a server error message.
    $scope.$on('error', function () {
        $scope.alerts = [
            { type: 'danger', msg: 'There was a problem in the server!' }
        ];
    });

    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };
});