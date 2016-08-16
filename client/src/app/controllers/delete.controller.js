/**
 * Created by kaushik nandhan on 8/14/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('deleteController',deleteController);
    deleteController.$inject = ['titleService','$location','$routeParams','Notification','$localStorage','userService'];
    function deleteController(titleService,$location,$routeParams,Notification,$localStorage,userService) {
        var deleteVm = this;
        deleteVm.userObj = "";
        deleteVm.deleteTitle = deleteTitle;
        function deleteTitle() {

            deleteVm.userObj =  userService.getUserObj($localStorage.userObject);

            if(ddeleteVm.userObj.role === "admin") {

                titleService.deleteTitle($routeParams.id)
                    .then(function (deletedTitle) {
                        deleteVm.deletedTitle = deletedTitle;
                        $location.path('/admin/browse');
                        Notification.success('Title deleted successfully');
                    }, function (error) {
                        Notification.error('Title not deleted, try again!!!');
                    });
            }
            else
            {
                Notification.error('Sorry!! not authorized for this functionlity');
            }
        };
    };
})();