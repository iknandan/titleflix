/**
 * Created by kaushik nandhan on 8/12/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .service('titleService',titleService);

    titleService.$inject = ['$http','$q'];
    function titleService($http,$q) {

        var titleVm = this;

        titleVm.findAllTitles = findAllTitles;

        function findAllTitles() {
            console.log('title service');
            return $http.get('http://localhost:8080/titleflix/api/title/viewAll').then(successFn,errorFn);
        };

        function successFn(response) {
            return response.data
        };
        function errorFn(response) {
            return $q.reject('Error Text',response.statusText)
        };

    };
})();