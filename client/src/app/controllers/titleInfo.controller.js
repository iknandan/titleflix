/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';

    angular.module('titleflix')
        .controller('titleInfoController',titleInfoController);

    titleInfoController.$inject = ['titleService','commentService','userService','$routeParams','$location','$localStorage','$route'];
    function titleInfoController(titleService,commentService,userService,$routeParams,$location,$localStorage,$route) {
        var titleInfoVm = this;
        titleInfoVm.commentobj = {
            comment:"",
            rating:2,
            userId:{
                id: ""
            },
            movieId:{
                movieId:""
            }
        };
        titleInfoVm.max = 5;
        titleInfoVm.deleteTitle = deleteTitle;
        titleInfoVm.postComment = postComment;
        init();
        function init() {
            titleService.titleInfo($routeParams.id)
                .then(function (title) {
                    titleInfoVm.title = title;
                },function (error) {
                    console.log(error);
                });
            commentService.conmmentsList($routeParams.id)
                .then(function (comments) {
                    titleInfoVm.comments = comments;
                },function (error) {
                    console.log(error);
                });
            // titleInfoVm.currentUser = userService.currentUser;
            console.log('titleInfoController');
            console.log($localStorage.userObject);
            titleInfoVm.currentUser = $localStorage.userObject;

        };
        titleInfoVm.hoveringOver = function(value) {
            titleInfoVm.overStar = value;
        };

        function postComment() {
            titleInfoVm.commentobj.movieId.movieId = $routeParams.id;
            titleInfoVm.commentobj.userId.id = titleInfoVm.currentUser.id;
            commentService.postComment(titleInfoVm.commentobj)
                .then(function (commentPosted) {
                    titleInfoVm.commentPosted = commentPosted;
                    titleInfoVm.commentobj.comment = [];
                    titleInfoVm.commentobj.rating = 2;
                    $route.reload();
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