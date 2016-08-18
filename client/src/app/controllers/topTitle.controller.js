/**
 * Created by kaushik nandhan on 8/17/2016.
 */
(function () {
    'use strict';

    angular.module('titleflix')
        .controller('topTitleController',topTitleController);

    topTitleController.$inject = ['titleService','$routeParams'];
    function topTitleController(titleService,$routeParams) {

        var topTitleVm = this;
        topTitleVm.titleType = $routeParams.type;
        // Initialize the controller and gets the top rated titles
        init();
        function init() {
            // console.log($routeParams.type);
            titleService.topRated($routeParams.type)
                .then(function (topTitles) {
                    topTitleVm.topTitles = topTitles;
                },function (error) {
                    Notification.error('Error connecting to the server');
                });
        };
    };
})();
