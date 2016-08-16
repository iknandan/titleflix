/**
 * Created by kaushik nandhan on 8/14/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('deleteController',deleteController);
    deleteController.$inject = ['titleService','$location','$routeParams','Notification'];
    function deleteController(titleService,$location,$routeParams,Notification) {
        var deleteVm = this;
        deleteVm.deleteTitle = deleteTitle;
        function deleteTitle() {
            titleService.deleteTitle($routeParams.id)
                .then(function (deletedTitle) {
                    deleteVm.deletedTitle = deletedTitle;
                    Notification.success('Title deleted successfully');
                    $location.path('/admin/browse');
                },function (error) {
                    Notification.error('Title not deleted, try again!!!');
                });
        };
    };
})();