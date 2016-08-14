/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';

    angular.module('titleflix')
        .controller('titleInfoController',titleInfoController);

    titleInfoController.$inject = ['titleInfoService','$routeParams'];
    function titleInfoController(titleInfoService,$routeParams) {
        var titleInfoVm = this;
        init();
        function init() {
            titleInfoService.titleInfo($routeParams.id)
                .then(function (title) {
                    titleInfoVm.title = title;
                },function (error) {
                    console.log(error);
                });
            titleInfoService.conmmentsList($routeParams.id)
                .then(function (comments) {
                    titleInfoVm.comments = comments;
                },function (error) {
                    console.log(error);
                });
        };
    };
})();