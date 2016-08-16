/**
 * Created by kaushik nandhan on 8/12/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .service('titleService',titleService);

    titleService.$inject = ['$http','$q','CONFIG'];
    function titleService($http,$q,CONFIG) {

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
            return $http.get(CONFIG.API_HOST+'/title/viewAll').then(successFn,errorFn);
        };
        function filterBy(basedOn,value) {
            return $http.get(CONFIG.API_HOST+'/title/filterBy/' + basedOn + '/' + value)
                .then(successFn, errorFn);
        };
        function sortby(basedOn) {
            return $http.get(CONFIG.API_HOST+'/title/sortBy/'+basedOn)
                .then(successFn,errorFn);
        };
        function titleInfo(id) {
            return $http.get(CONFIG.API_HOST+'/title/viewTitleDetails/'+id)
                .then(successFn,errorFn);
        };
        function topRatedMovies(){
            return $http.get(CONFIG.API_HOST+'/title/topRatedMovies')
                .then(successFn,errorFn);
        };
        function topratedSeries() {
            return $http.get(CONFIG.API_HOST+'/title/topRatedSeries')
                .then(successFn, errorFn);
        };
        function deleteTitle(id) {
            console.log('serviceDelete-'+id);
            return $http.delete(CONFIG.API_HOST+'/title/deleteTitle/'+id)
                .then(successFn,errorFn);
        };
        function createTitle(newTitle) {
            return $http.post(CONFIG.API_HOST+'/title/createTitle',newTitle)
                .then(successFn,errorFn);
        };
        function updateTitle(id,title) {
            return $http.put(CONFIG.API_HOST+'/title/updateTitle/'+id,title)
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