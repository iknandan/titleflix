/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';

    angular.module('titleflix')
        .controller('filterByController',filterByController);
    filterByController.$inject = ['titleService','$routeParams'];
    function filterByController(titleService,$routeParams) {

        var filterByVm = this;

        init();
        function init(){
            titleService.filterBy($routeParams.basedOn,$routeParams.value)
                .then(function (filterTitles) {
                    filterByVm.filterTitles = filterTitles;
                },function (error) {
                    console.log(error);
                });
        };
    };
})();