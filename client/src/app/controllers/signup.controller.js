/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('signUpController',signUpController);
    signUpController.$inject = ['userService','$location'];
    function signUpController(userService,$location) {
        var signUpVm = this;
        signUpVm.createUser = createUser;
        function createUser() {
            console.log(signUpVm.newUser);
            userService.createUser(signUpVm.newUser)
                .then(function (user) {
                    signUpVm.user = user;
                    signUpVm.newUser ={}
                    $location.path("/signin");
                },function (error) {
                    console.log(error)
                });
        };
    };
})();
