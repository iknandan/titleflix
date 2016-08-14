/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';

    angular.module('titleflix')
        .controller('filterByController',filterByController);
    filterByController.$inject = ['filterByService','$routeParams'];
    function filterByController(filterByService,$routeParams) {

        var filterByVm = this;

        init();
        function init(){
            filterByService.filterBy($routeParams.basedOn,$routeParams.value)
                .then(function (filterTitles) {
                    filterByVm.filterTitles = filterTitles;
                },function (error) {
                    console.log(error);
                });
        };
    };
})();