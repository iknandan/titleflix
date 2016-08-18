/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('navBarController',navBarController);
    navBarController.$inject = ['navBarService','userService','$localStorage','Notification'];
    function navBarController(navBarService,userService,$localStorage,Notification) {

        var navBarVm = this;
        navBarVm.user = "";
        navBarVm.userName = "";
        navBarVm.logout = logout;
        // Initialize function when the controller is called
        init();
        function init() {
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
                // navBarVm.userName = $localStorage.userObject.userName;
            navBarVm.userObj =  userService.getUserObj($localStorage.userObject);
            if( !(navBarVm.userObj === undefined)){
                navBarVm.userName = navBarVm.userObj.userName;
            };
        };
        // delete the token
        function logout() {
            userService.logOut()
        };
    };
})();
