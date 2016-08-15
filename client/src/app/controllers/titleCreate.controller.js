/**
 * Created by kaushik nandhan on 8/14/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('titleCreateController',titleCreateController);

    titleCreateController.$inject = ['titleService','$location'];
    function titleCreateController(titleService,$location){
        var titleCreateVm = this;
        titleCreateVm.createTitle = createTitle;
        function createTitle() {
            var genreList = titleCreateVm.newTitle.genre;
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
            titleCreateVm.newTitle.genre = "";
            titleCreateVm.newTitle.genre = arr;
            titleService.createTitle(titleCreateVm.newTitle)
                .then(function (newTitle) {
                    titleCreateVm.newTitle = newTitle;
                    titleCreateVm.newTitle= [];
                    $location.path('/admin/browse');
                },function (error) {
                    console.log(error);
                });
        };
    };
})();