/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';

    angular.module('titleflix')
        .controller('filterByController',filterByController);
    filterByController.$inject = ['titleService','$routeParams','Notification','$localStorage'];
    function filterByController(titleService,$routeParams,Notification,$localStorage) {

        var filterByVm = this;

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
                Notification.error('Please provide your credentails');
                $location.path('/signin');

            }
        };
    };
})();