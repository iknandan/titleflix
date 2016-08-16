/**
 * Created by kaushik nandhan on 8/14/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('titleCreateController',titleCreateController);

    titleCreateController.$inject = ['titleService','$location','Notification','$localStorage','userService'];
    function titleCreateController(titleService,$location,Notification,$localStorage,userService){
        var titleCreateVm = this;
        titleCreateVm.createTitle = createTitle;
        titleCreateVm.user = "";
        function createTitle() {

            titleCreateVm.user =  userService.getUserObj($localStorage.userObject);

            if (titleCreateVm.user.role === "admin") {

                var genreList = titleCreateVm.newTitle.genre;
                var arr =  titleService.objectToArray(genreList);
                titleCreateVm.newTitle.genre = "";
                titleCreateVm.newTitle.genre = arr;
                titleService.createTitle(titleCreateVm.newTitle)
                    .then(function (newTitle) {
                        titleCreateVm.newTitle = newTitle;
                        Notification.success('New Title ' + titleCreateVm.newTitle.title + ' is created');
                        titleCreateVm.newTitle = [];
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