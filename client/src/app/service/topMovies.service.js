/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';

    angular.module('titleflix')
        .service('topMoviesService',topMoviesService);

    topMoviesService.$inject = ['$http','$q'];
    function topMoviesService($http,$q) {

        var topMoviesVm = this;
        topMoviesVm.topRatedMovies = topRatedMovies;

        function topRatedMovies(){

            return $http.get('http://localhost:8080/titleflix/api/title/topRatedMovies')
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
