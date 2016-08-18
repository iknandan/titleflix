/**
 * Created by kaushik nandhan on 8/14/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('titleUpdateController',titleUpdateController);

    titleUpdateController.$inject = ['titleService','$routeParams','$location','Notification','$localStorage','userService'];
    function titleUpdateController(titleService,$routeParams,$location,Notification,$localStorage,userService){
        var titleUpdateVm = this;
        titleUpdateVm.user = "";
        titleUpdateVm.updateTitle = updateTitle;
        // console.log('titleUpdateController');
        // initialzie the functionality when the controller is called
        init();
        function init() {
            titleService.titleInfo($routeParams.id)
                .then(function (title) {
                    titleUpdateVm.title = title;
                },function (error) {
                    Notification.error('Error from teh Server!!!');
                    console.log(error);
                });
        };
        // Updates the title - Authorized only for admin
        function updateTitle() {

            titleUpdateVm.user =  userService.getUserObj($localStorage.userObject);
            if(titleUpdateVm.user.role === "admin") {

                var genreList = titleUpdateVm.title.genre;
                var arr =  titleService.objectToArray(genreList);
                titleUpdateVm.title.genre = "";
                titleUpdateVm.title.genre = arr;
                titleService.updateTitle($routeParams.id, titleUpdateVm.title)
                    .then(function (updatedTitle) {
                        titleUpdateVm.updatedTitle = updatedTitle;
                        Notification.success('Updated ' + titleUpdateVm.updatedTitle.title + ' Successfully');
                        titleUpdateVm.updatedTitle = [];
                        $location.path('/admin/browse');
                    }, function (error) {
                        Notification.error('Error connecting to the server');
                    });
            }
            else{
                Notification.error('Sorry!! not authorized for this functionlity');
            }
        };
    };
})();