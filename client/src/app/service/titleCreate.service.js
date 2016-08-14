/**
 * Created by kaushik nandhan on 8/14/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .service('titleCreateService',titleCreateService);

    titleCreateService.$inject = ['$http','$q'];
    function titleCreateService($http,$q) {

        var titleCreateVm = this;
        titleCreateVm.createTitle = createTitle;

        function createTitle(newTitle) {
            return $http.post('http://localhost:8080/titleflix/api/title/createTitle',newTitle)
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
