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

        function updateTitle() {
            return $http.post('')
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
