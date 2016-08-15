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
        titleVm.filterBy = filterBy;
        titleVm.sortby = sortby;
        titleVm.titleInfo = titleInfo;
        // titleVm.conmmentsList = conmmentsList;
        titleVm.topRatedMovies = topRatedMovies;
        titleVm.topratedSeries = topratedSeries;
        titleVm.deleteTitle = deleteTitle;
        titleVm.createTitle = createTitle;
        titleVm.updateTitle = updateTitle;



        function findAllTitles() {
            console.log('title service');
            return $http.get('http://localhost:8080/titleflix/api/title/viewAll').then(successFn,errorFn);
        };
        function filterBy(basedOn,value) {
            return $http.get('http://localhost:8080/titleflix/api/title/filterBy/' + basedOn + '/' + value)
                .then(successFn, errorFn);
        };
        function sortby(basedOn) {
            return $http.get('http://localhost:8080/titleflix/api/title/sortBy/'+basedOn)
                .then(successFn,errorFn);
        };
        function titleInfo(id) {
            return $http.get('http://localhost:8080/titleflix/api/title/viewTitleDetails/'+id)
                .then(successFn,errorFn);
        };
        // function conmmentsList(id) {
        //     return $http.get('http://localhost:8080/titleflix/api/comment/viewReviews/'+id)
        //         .then(successFn,errorFn);
        // };
        function topRatedMovies(){
            return $http.get('http://localhost:8080/titleflix/api/title/topRatedMovies')
                .then(successFn,errorFn);
        };
        function topratedSeries() {
            return $http.get('http://localhost:8080/titleflix/api/title/topRatedSeries')
                .then(successFn, errorFn);
        };
        function deleteTitle(id) {
            console.log('serviceDelete-'+id);
            return $http.delete('http://localhost:8080/titleflix/api/title/deleteTitle/'+id)
                .then(successFn,errorFn);
        };
        function createTitle(newTitle) {
            return $http.post('http://localhost:8080/titleflix/api/title/createTitle',newTitle)
                .then(successFn,errorFn);
        };
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