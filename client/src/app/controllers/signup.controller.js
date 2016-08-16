/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('signUpController',signUpController);
    signUpController.$inject = ['userService','$location','Notification'];
    function signUpController(userService,$location,Notification) {
        var signUpVm = this;
        signUpVm.createUser = createUser;
        function createUser() {
            userService.createUser(signUpVm.newUser)
                .then(function (user) {
                    signUpVm.user = user;
                    Notification.success('Hi '+signUpVm.user.userName+' Welcome to TitleFlix !');
                    signUpVm.newUser ={}
                    $location.path("/signin");
                },function (error) {
                    Notification.error('Email provided is already in use');
                });
        };
    };
})();
