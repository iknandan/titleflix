/**
 * Created by kaushik nandhan on 8/14/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .service('deleteService',deleteService);
    deleteService.$inject = ['$http','$q'];
    function deleteService($http,$q) {
    
        var deleteVm = this;
        deleteVm.deleteTitle = deleteTitle;
        function deleteTitle(id) {
            console.log('serviceDelete-'+id);
            return $http.delete('http://localhost:8080/titleflix/api/title/deleteTitle/'+id)
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