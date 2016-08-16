/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('signInController',signInController);

    signInController.$inject = ['userService','$location','$localStorage'];
    function signInController(userService,$location,$localStorage) {
        var signInVm = this;
        signInVm.loginUser = loginUser;

        function loginUser() {
            console.log('signInController');
            console.log(signInVm.user);
            userService.loginUser(signInVm.user)
                .then(function (user) {
                    signInVm.user = user;
                    $localStorage.userObject = user;
                    if(signInVm.user.role === "user")
                    {
                        $location.path('/browse');
                    };
                    if(signInVm.user.role === "admin")
                    {
                        $location.path('/admin/browse');
                    };

                },function (error) {
                    console.log(error);
                });
        };
    };
})();
