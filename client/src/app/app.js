(function () {
    'use strict';

    angular
        .module('titleflix',['ngRoute','angularUtils.directives.dirPagination','ngMessages'])
        .config(moduleConfig);

    function moduleConfig($routeProvider) {
        $routeProvider
            .when('/home',{
                templateUrl:'app/views/home.tmpl.html',

            })
            .when('/signin',{
                templateUrl:'app/views/signin.tmpl.html',
                controller: 'signInController',
                controllerAs: 'signInVm'
            })
            .when('/signup',{
                templateUrl:'app/views/signup.tmpl.html',
                controller: 'signUpController',
                controllerAs: 'signUpVm'
            })
            .when('/browse',{
                templateUrl:'app/views/titles.tmpl.html',
                controller: 'titleController',
                controllerAs: 'titleVm'
            })
            .when('/topRatedMovies',{
                templateUrl:'app/views/topMovies.tmpl.html',
                controller: 'topMoviesController',
                controllerAs: 'topMoviesVm'
            })
            .when('/topRatedSeries',{
                templateUrl:'app/views/topSeries.tmpl.html',
                controller: 'topSeriesController',
                controllerAs: 'topSeriesVm'
            })
            .when('/sortBy/:basedOn',{
                templateUrl:'app/views/sortBy.tmpl.html',
                controller: 'sortByController',
                controllerAs: 'sortByVm'
            })
            .otherwise({
                redirectTo:'/home'
            })

    }


})();