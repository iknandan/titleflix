/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('topMoviesController',topMoviesController);

    topMoviesController.$inject = ['topMoviesService'];
    function topMoviesController(topMoviesService){
        var topMoviesVm = this;
        init();

        function init(){
            topMoviesService.topRatedMovies()
                .then(function (topMovietitles) {
                    topMoviesVm.topMovietitles = topMovietitles;
                },function (error) {
                    console.log('error');
                });
        }
    };
})();