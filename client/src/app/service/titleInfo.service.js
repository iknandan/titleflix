/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';

    angular.module('titleflix')
        .service('titleInfoService',titleInfoService);

    titleInfoService.$inject = ['$http','$q'];
    function titleInfoService($http,$q) {
        var titleInfoVm = this;
        titleInfoVm.titleInfo = titleInfo;
        titleInfoVm.conmmentsList = conmmentsList;

        function titleInfo(id) {
            return $http.get('http://localhost:8080/titleflix/api/title/viewTitleDetails/'+id)
                .then(successFn,errorFn);

        };
        function conmmentsList(id) {
            return $http.get('http://localhost:8080/titleflix/api/comment/viewReviews/'+id)
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
