/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .service('navBarService',navBarService);

    navBarService.$inject = ['$http','$q','CONFIG'];
    function navBarService($http,$q,CONFIG) {
       var navBarVm = this;
        navBarVm.genreList = genreList;
        navBarVm.yearList = yearList;
        navBarVm.typeList = typeList;

        function genreList() {
            return $http.get(CONFIG.API_HOST+'/genre/viewAll')
                .then(successFn,errorFn);
        };
        function yearList() {
            return $http.get(CONFIG.API_HOST+'/title/yearList')
                .then(successFn,errorFn);
        };
        function typeList() {
            return $http.get(CONFIG.API_HOST+'/title/typeList')
                .then(successFn,errorFn);
        };
        function successFn(response) {
            return response.data
        };
        function errorFn(response) {
            return $q.reject('Error Text',response.statusText)
        };

    };
})();