/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .service('topSeriesService',topSeriesService);

    topSeriesService.$inject = ['$http','$q'];
    function topSeriesService($http,$q) {

        var topSeriesVm = this;
        topSeriesVm.topratedSeries = topratedSeries;

        function topratedSeries() {

            return $http.get('http://localhost:8080/titleflix/api/title/topRatedSeries')
                .then(successFn,errorFn);
            function successFn(response) {
                return response.data
            };
            function errorFn(response) {
                return $q.reject('Error Text',response.statusText)
            };

        };
    };
})();
