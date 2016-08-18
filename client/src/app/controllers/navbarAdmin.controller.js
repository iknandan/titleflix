/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('navBarAdminController',navBarAdminController);
    navBarAdminController.$inject = ['navBarService','userService','$localStorage','Notification','$location'];
    function navBarAdminController(navBarService,userService,$localStorage,Notification,$location) {

        var navBarVm = this;
        navBarVm.user = "";
        navBarVm.userName = "";
        navBarVm.logout = logout;
        // Initialize function when the controller is called
        init();
        function init() {
            // navBarVm.userName = $localStorage.userObject.userName;
            navBarVm.userObj =  userService.getUserObj($localStorage.userObject);
            if( navBarVm.userObj.role === "admin")
            {
                // Get the list of Genres from the data base
                navBarService.genreList()
                    .then(function (genres) {
                        navBarVm.genres = genres;
                    }, function (error) {
                        console.log(error);
                    });
                // Get the list of Years from the data base
                navBarService.yearList()
                    .then(function (years) {
                        navBarVm.years = years;
                    }, function (error) {
                        console.log(error);
                    });
                // Get the list of type from the data base
                navBarService.typeList()
                    .then(function (types) {
                        navBarVm.types = types;
                    }, function (error) {
                        console.log(error);
                    });
            if( !(navBarVm.userObj === undefined)){
                navBarVm.userName = navBarVm.userObj.userName;
            };
            }
            else{
                    Notification.error('Sorry!!! Not authorized for this functionlity. Please sign in an admin');
                    $location.path('/signin');
            }
        };
        // delete the token
        function logout() {
            userService.logOut()
        };
    };
})();
