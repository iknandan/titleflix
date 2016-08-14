/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';

    angular.module('titleflix')
        .service('filterByService',filterByService);
    filterByService.$inject = ['$http','$q'];
    function filterByService($http,$q) {

        var filterByVm = this;
        filterByVm.filterBy = filterBy;

        function filterBy(basedOn,value){
            return $http.get('http://localhost:8080/titleflix/api/title/filterBy/'+basedOn+'/'+value)
                .then(successFn,errorFn);

            function successFn(response) {
                return response.data
            };
            function errorFn(response) {
                return $q.reject('Error Text',response.statusText)
            };

        };

    }
})();
