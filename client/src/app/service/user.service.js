/**
 * Created by kaushik nandhan on 8/14/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .service('userService',userService);

    userService.$inject = ['$http','$q','$location','$localStorage'];
    function userService($http,$q,$location,$localStorage) {
        var signUpVm = this;
        signUpVm.currentUser = {
            isLoggedIn: false,
            userObj:{}
        };
        signUpVm.createUser = createUser;
        signUpVm.loginUser = loginUser;
        signUpVm.logOut = logOut;
        function createUser(newUser) {
            return $http.post('http://localhost:8080/titleflix/api/user/signUp',newUser)
                .then(successFn, errorFn);
        };
        function loginUser(user) {
            return $http.post('http://localhost:8080/titleflix/api/user/signIn',user)
                .then(function (response) {
                    signUpVm.currentUser.userObj = response.data;
                    signUpVm.currentUser.isLoggedIn = true;
                    console.log('User Service')
                    console.log(signUpVm.currentUser.userObj);
                    return response.data;
                }, function (response) {
                    return $q.reject('Error Text', response.statusText);
                });
        };
        function logOut(){
            // signUpVm.currentUser.isLoggedIn = false;
            // signUpVm.currentUser.userObj = {};
            $localStorage.$reset();
            $location.path('/signin');
        }
        function successFn(response) {
            return response.data;
        };
        function errorFn(response) {
            return $q.reject('Error Text', response.statusText);
        };
    };
})();