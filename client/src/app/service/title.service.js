/**
 * Created by kaushik nandhan on 8/12/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .service('titleService',titleService);

    titleService.$inject = ['$http','$q','CONFIG','$localStorage'];
    function titleService($http,$q,CONFIG,$localStorage) {

        var titleVm = this;

        titleVm.findAllTitles = findAllTitles;
        titleVm.filterBy = filterBy;
        titleVm.sortby = sortby;
        titleVm.titleInfo = titleInfo;
        titleVm.objectToArray = objectToArray;
        titleVm.deleteTitle = deleteTitle;
        titleVm.createTitle = createTitle;
        titleVm.updateTitle = updateTitle;
        titleVm.topRated = topRated;


        function findAllTitles() {
            // console.log('title service');
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
        function objectToArray(genreList) {

            Object.size = function (genreList) {
                var size = 0, key;
                for (key in genreList) {
                    if (genreList.hasOwnProperty(key)) size++;
                }
                return size;
            };
            // Get the size of an object
            var size = Object.size(genreList);
            var arr = [];
            for (var i = 0; i < size; i++) {
                if (!(genreList[i].isUndefined)) {
                    arr[i] = genreList[i];
                }
            }
            return arr;

        };
        function topRated(type) {
            return $http.get(CONFIG.API_HOST+'/title/topRated/'+type)
                .then(successFn,errorFn);
        }
        function titleInfo(id) {
            return $http.get(CONFIG.API_HOST+'/title/viewTitleDetails/'+id)
                .then(successFn,errorFn);
        };
        function deleteTitle(id) {
            // console.log('serviceDelete-'+id);
            return $http.delete(CONFIG.API_HOST+'/title/deleteTitle/'+id)
                .then(successFn,errorFn);
        };
        function createTitle(newTitle) {
            $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.userObject;
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