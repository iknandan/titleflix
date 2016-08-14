/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('navBarController',navBarController);
    navBarController.$inject = ['navBarService'];
    function navBarController(navBarService) {

        var navBarVm = this;
        init();
        function init() {

            navBarService.genreList()
                .then(function (genres) {
                    navBarVm.genres = genres;
                },function (error) {
                    console.log(error);
                });
            navBarService.yearList()
                .then(function (years) {
                    navBarVm.years = years;
                },function (error) {
                    console.log(error);
                });
            navBarService.typeList()
                .then(function (types) {
                    navBarVm.types = types;
                },function (error) {
                    console.log(error);
                });
        };
    };
})();