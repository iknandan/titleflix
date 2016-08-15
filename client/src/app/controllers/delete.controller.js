/**
 * Created by kaushik nandhan on 8/14/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('deleteController',deleteController);
    deleteController.$inject = ['titleService','$location','$routeParams'];
    function deleteController(titleService,$location,$routeParams) {
        var deleteVm = this;
        deleteVm.deleteTitle = deleteTitle;
        
        function deleteTitle() {

            titleService.deleteTitle($routeParams.id)
                .then(function (deletedTitle) {
                    deleteVm.deletedTitle = deletedTitle;
                    $location.path('/admin/browse');
                },function (error) {
                    console.log(error);
                });
        };
    };
})();