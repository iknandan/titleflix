/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .service('sortByService',sortByService);
    sortByService.$inject = ['$http','$q'];
    function sortByService($http,$q) {

        var sortByVm = this;
        sortByVm.sortby = sortby;
        function sortby(basedOn) {
           return $http.get('http://localhost:8080/titleflix/api/title/sortBy/'+basedOn)
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