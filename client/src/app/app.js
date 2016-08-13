(function () {
    'use strict';

    angular
        .module('titleflix',['ngRoute','ngMessages'])
        .config(moduleConfig);

    function moduleConfig($routeProvider) {
        $routeProvider
            .when('/home',{
                templateUrl:'app/views/home.tmpl.html',
                controller:'homeController',
                controllerAs:'homeVm'
            })

    }


})();