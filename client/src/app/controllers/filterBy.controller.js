/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';

    angular.module('titleflix')
        .controller('filterByController',filterByController);
    filterByController.$inject = ['titleService','$routeParams','Notification','$localStorage','$location'];
    function filterByController(titleService,$routeParams,Notification,$localStorage,$location) {

        var filterByVm = this;
        filterByVm.filterType = $routeParams.basedOn;
        filterByVm.filterValue = $routeParams.value;
        // Initialize function when the controller is called
        init();
        function init(){
            if(!($localStorage.userObject ===  undefined)) {
                titleService.filterBy($routeParams.basedOn, $routeParams.value)
                    .then(function (filterTitles) {
                        filterByVm.filterTitles = filterTitles;
                    }, function (error) {
                        Notification.error('Error connecting to the server');
                    });
            }
            else{
                // Notification.error('Please provide your credentails');
                $location.path('/signin');

            }
        };
    };
})();