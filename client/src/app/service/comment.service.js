/**
 * Created by kaushik nandhan on 8/14/2016.
 */
(function () {
    'use strict';

    angular.module('titleflix')
        .service('commentService',commentService);

    commentService.$inject = ['$http','$q'];
    function commentService($http,$q) {

        var commentVm = this;
        commentVm.conmmentsList = conmmentsList;
        commentVm.postComment = postComment;

        function conmmentsList(id) {
            return $http.get('http://localhost:8080/titleflix/api/comment/viewReviews/'+id)
                .then(successFn,errorFn);
        };
        function postComment(comment) {
            return $http.post('http://localhost:8080/titleflix/api/comment/reviewTitle',comment)
                .then(successFn,errorFn);
        }
        function successFn(response) {
            return response.data
        };
        function errorFn(response) {
            return $q.reject('Error Text',response.statusText)
        };
    };
})();
