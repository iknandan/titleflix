/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';

    angular.module('titleflix')
        .controller('titleInfoController',titleInfoController);

    titleInfoController.$inject = ['titleService','commentService','userService','$routeParams','$location','$localStorage','$route','Notification'];
    function titleInfoController(titleService,commentService,userService,$routeParams,$location,$localStorage,$route,Notification) {
        var titleInfoVm = this;
        titleInfoVm.commentobj = {
            comment: "",
            rating: 2,
            userId: {
                id: ""
            },
            movieId: {
                movieId: ""
            }
        };
        titleInfoVm.max = 5;
        titleInfoVm.deleteTitle = deleteTitle;
        titleInfoVm.postComment = postComment;
        // Initialize the function when controller is called - gets all the information about title
        init();
        function init() {
            if (!($localStorage.userObject === undefined)){

        titleService.titleInfo($routeParams.id)
            .then(function (title) {
                titleInfoVm.title = title;
            }, function (error) {
                Notification.error('Error connecting to the server');
            });
        // Gets the List of comments of a Title from the server
        commentService.conmmentsList($routeParams.id)
            .then(function (comments) {
                titleInfoVm.comments = comments;
            }, function (error) {
                Notification.error('Error connecting to the server');
            });

    }
    else
            {
                Notification.error('Please provide your credentails');
                $location.path('/signin');
            }
        };
        titleInfoVm.hoveringOver = function(value) {
            titleInfoVm.overStar = value;
        };

        // Posts the Reviews - comments and rating - and reloads the page.
        function postComment() {
            titleInfoVm.commentobj.movieId.movieId = $routeParams.id;
            titleInfoVm.currentUser =  userService.getUserObj($localStorage.userObject);
            titleInfoVm.commentobj.userId.id = titleInfoVm.currentUser.id;
            commentService.postComment(titleInfoVm.commentobj)
                .then(function (commentPosted) {
                    titleInfoVm.commentPosted = commentPosted;
                    titleInfoVm.commentobj.comment = [];
                    titleInfoVm.commentobj.rating = 2;
                    $route.reload();
                    Notification.success('posted comment successfully');
                },function (error) {
                    Notification.error('Error connecting to the server');
                });
        };
        // Deletes the Title
        function deleteTitle() {
            // console.log('titleInfoController '+titleInfoVm.titleId);
            titleService.deleteTitle($routeParams.id)
                .then(function (deletedTitle) {
                    titleInfoVm.deletedTitle = deletedTitle;
                    $location.path('/admin/browse');
                },function (error) {
                    Notification.error('Error connecting to the server');
                });
        };
    };
})();