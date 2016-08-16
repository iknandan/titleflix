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
        signInVm.loginUser = loginUser;
        function loginUser() {
            userService.loginUser(signInVm.user)
                .then(function (user) {
                    signInVm.user = user;
                    $localStorage.userObject = user;
                    if(signInVm.user.role === "user")
                    {
                        Notification.success('Welcome to TITLEFLIX');
                        $location.path('/browse');
                    };
                    if(signInVm.user.role === "admin")
                    {
                        Notification.success('Logged In as Admin');
                        $location.path('/admin/browse');
                    };

                },function (error) {
                    console.log(error);
                    Notification.error('Incorrect Credentials for the Email and Password');
                });
        };
    };
})();
