/**
 * Created by kaushik nandhan on 8/14/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .service('userService',userService);

    userService.$inject = ['$http','$q'];
    function userService($http,$q) {
        var signUpVm = this;
        signUpVm.createUser = createUser;
        signUpVm.loginUser = loginUser;
        function createUser(newUser) {
            return $http.post('http://localhost:8080/titleflix/api/user/signUp',newUser)
                .then(successFn, errorFn);
        };
        function loginUser(user) {
            return $http.post('http://localhost:8080/titleflix/api/user/signIn',user)
                .then(successFn, errorFn);
        };
        function successFn(response) {
            return response.data;
        };
        function errorFn(response) {
            return $q.reject('Error Text', response.statusText);
        };
    };
})();