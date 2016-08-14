/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .service('navBarService',navBarService);

    navBarService.$inject = ['$http','$q'];
    function navBarService($http,$q) {
       var navBarVm = this;
        navBarVm.genreList = genreList;
        navBarVm.yearList = yearList;
        navBarVm.typeList = typeList;

        function genreList() {
            return $http.get('http://localhost:8080/titleflix/api/genre/viewAll')
                .then(successFn,errorFn);
        };
        function yearList() {
            return $http.get('http://localhost:8080/titleflix/api/title/yearList')
                .then(successFn,errorFn);
        };
        function typeList() {
            return $http.get('http://localhost:8080/titleflix/api/title/typeList')
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