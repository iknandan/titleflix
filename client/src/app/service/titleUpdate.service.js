/**
 * Created by kaushik nandhan on 8/14/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .service('titleUpdateService',titleUpdateService);

    titleUpdateService.$inject = ['$http','$q'];
    function titleUpdateService($http,$q) {

        var titleUpdateVm = this;
        titleUpdateVm.updateTitle = updateTitle;

        function updateTitle(id,title) {
            return $http.put('http://localhost:8080/titleflix/api/title/updateTitle/'+id,title)
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
