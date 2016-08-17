/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('signInController',signInController);

    signInController.$inject = ['userService','$location','$localStorage','Notification'];
    function signInController(userService,$location,$localStorage,Notification) {
        var signInVm = this;
        signInVm.userObj = "";
        signInVm.loginUser = loginUser;
        function loginUser() {
        console.log(signInVm.user);
            userService.loginUser(signInVm.user)
                .then(function (user) {
                    signInVm.user = user;
                    $localStorage.userObject = user;
                    signInVm.userObj =  userService.getUserObj($localStorage.userObject);
                    if(signInVm.userObj.role === "user")
                    {
                        Notification.success('Welcome to TITLEFLIX');
                        $location.path('/browse');
                    };
                    if(signInVm.userObj.role === "admin")
                    {
                        Notification.success('Logged In as Admin');
                        $location.path('/admin/browse');
                    };

                },function (error) {
                    Notification.error('Incorrect Credentials for the Email and Password');
                });
        };
    };
})();
