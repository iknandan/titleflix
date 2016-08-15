/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';

    angular.module('titleflix')
        .controller('titleInfoController',titleInfoController);

    titleInfoController.$inject = ['titleService','commentService','$routeParams','$location'];
    function titleInfoController(titleService,commentService,$routeParams,$location) {
        var titleInfoVm = this;
         titleInfoVm.titleId = "";
        titleInfoVm.deleteTitle = deleteTitle;
        init();
        function init() {
            titleService.titleInfo($routeParams.id)
                .then(function (title) {
                    titleInfoVm.title = title;
                    titleInfoVm.titleId = titleInfoVm.title.movieId;
                },function (error) {
                    console.log(error);
                });
            commentService.conmmentsList($routeParams.id)
                .then(function (comments) {
                    titleInfoVm.comments = comments;
                },function (error) {
                    console.log(error);
                });
        };

        function deleteTitle() {
            console.log('titleInfoController '+titleInfoVm.titleId);
            titleService.deleteTitle(titleInfoVm.titleId)
                .then(function (deletedTitle) {
                    titleInfoVm.deletedTitle = deletedTitle;
                    $location.path('/admin/browse');
                },function (error) {
                    console.log(error)
                });
        };
    };
})();