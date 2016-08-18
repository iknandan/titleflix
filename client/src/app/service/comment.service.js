/**
 * Created by kaushik nandhan on 8/14/2016.
 */
(function () {
    'use strict';

    angular.module('titleflix')
        .service('commentService',commentService);

    commentService.$inject = ['$http','$q','CONFIG'];
    function commentService($http,$q,CONFIG) {

        var commentVm = this;
        commentVm.conmmentsList = conmmentsList;
        commentVm.postComment = postComment;

        function conmmentsList(id) {
            return $http.get(CONFIG.API_HOST+'/comment/viewReviews/'+id)
                .then(successFn,errorFn);
        };
        function postComment(comment) {
            return $http.post(CONFIG.API_HOST+'/comment/reviewTitle',comment)
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
