/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('topMoviesController',topMoviesController);

    topMoviesController.$inject = ['titleService','Notification'];
    function topMoviesController(titleService,Notification){
        var topMoviesVm = this;
        init();

        function init(){
            titleService.topRatedMovies()
                .then(function (topMovietitles) {
                    topMoviesVm.topMovietitles = topMovietitles;
                },function (error) {
                    Notification.error('Error connecting to the server');
                });
        }
    };
})();