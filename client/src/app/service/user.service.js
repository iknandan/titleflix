/**
 * Created by kaushik nandhan on 8/14/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .service('userService',userService);

    userService.$inject = ['$http','$q','$location','$localStorage','Notification','CONFIG'];
    function userService($http,$q,$location,$localStorage,Notification,CONFIG) {
        var signUpVm = this;
        signUpVm.createUser = createUser;
        signUpVm.loginUser = loginUser;
        signUpVm.logOut = logOut;
        signUpVm.getUserObj = getUserObj;
        function createUser(newUser) {
            return $http.post(CONFIG.API_HOST+'/user/signUp',newUser)
                .then(successFn, errorFn);
        };
        function loginUser(user) {
            console.log(user);
            return $http.post(CONFIG.API_HOST+'/user/signIn',user)
                .then(function (response) {
                    console.log(response.data.compact);
                    return response.data.compact;
                }, function (response) {
                    return $q.reject('Error Text', response.statusText);
                });
        };
        function logOut(){
            $localStorage.$reset();
            Notification.success('Logged Out Successfully');
            $location.path('/signin');
        };

        function getUserObj(userObj) {
            var token = userObj;
            signUpVm.user = {};
            function urlBase64Decode(str) {
                var output = str.replace('-', '+').replace('_', '/');
                switch (output.length % 4) {
                    case 0:
                        break;
                    case 2:
                        output += '==';
                        break;
                    case 3:
                        output += '=';
                        break;
                    default:
                        throw 'Illegal base64url string!';
                }
                return window.atob(output);
            }
            if (typeof token !== 'undefined') {
                var encoded = token.split('.')[1];
                signUpVm.user = JSON.parse(urlBase64Decode(encoded));
            }
            else{

                $location.path('/signin');
                Notification.error('Please provide your credentails');

            }

            return signUpVm.user.roles;

        }
        function successFn(response) {
            return response.data;
        };
        function errorFn(response) {
            return $q.reject('Error Text', response.statusText);
        };
    };
})();