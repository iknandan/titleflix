/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';

    angular.module('titleflix')
        .controller('filterByController',filterByController);
    filterByController.$inject = ['titleService','$routeParams','Notification'];
    function filterByController(titleService,$routeParams,Notification) {

        var filterByVm = this;

        init();
        function init(){
            titleService.filterBy($routeParams.basedOn,$routeParams.value)
                .then(function (filterTitles) {
                    filterByVm.filterTitles = filterTitles;
                },function (error) {
                    Notification.error('Error connecting to the server');
                });
        };
    };
})();