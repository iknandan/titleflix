/**
 * Created by kaushik nandhan on 8/14/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('titleUpdateController',titleUpdateController);

    titleUpdateController.$inject = ['titleInfoService','titleUpdateService','$routeParams','$location'];
    function titleUpdateController(titleInfoService,titleUpdateService,$routeParams,$location){
        var titleUpdateVm = this;
        titleUpdateVm.updateTitle = updateTitle;
        console.log('titleUpdateController');
        init();
        function init() {
            titleInfoService.titleInfo($routeParams.id)
                .then(function (title) {
                    titleUpdateVm.title = title;
                },function (error) {
                    console.log(error);
                });
        };
        function updateTitle() {
            var genreList = titleUpdateVm.title.genre;
            Object.size = function(genreList) {
                var size = 0, key;
                for (key in genreList) {
                    if (genreList.hasOwnProperty(key)) size++;
                }
                return size;
            };
            // Get the size of an object
            var size = Object.size(genreList);
            var arr = [];
            for(var i=0;i<size;i++)
            {
                console.log(genreList[i]);
                if(!(genreList[i].isUndefined)){
                    arr[i]=genreList[i];
                    console.log(arr[i]);
                }
            }
            titleUpdateVm.title.genre = "";
            titleUpdateVm.title.genre = arr;
            titleUpdateService.updateTitle($routeParams.id,titleUpdateVm.title)
                .then(function (updatedTitle) {
                    titleUpdateVm.updatedTitle = updatedTitle;
                    titleUpdateVm.updatedTitle = [];
                    $location.path('/admin/browse');
                },function (error) {
                    console.log(error);
                });
        };
    };
})();