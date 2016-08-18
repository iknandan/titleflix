(function () {
    'use strict';

    angular
        .module('titleflix',['ngRoute','angularUtils.directives.dirPagination','ngMessages','ngAnimate','ui.bootstrap','ngStorage','ui-notification'])
        .config(moduleConfig);

    function moduleConfig($routeProvider,NotificationProvider) {
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
            .when('/topRated/:type',{
            templateUrl:'app/views/topTitle.tmpl.html',
            controller: 'topTitleController',
            controllerAs: 'topTitleVm'
            })
            .when('/admin/topRated/:type',{
                templateUrl:'app/views/topTitleAdmin.tmpl.html',
                controller: 'topTitleController',
                controllerAs: 'topTitleVm'
            })
            .when('/sortBy/:basedOn',{
                templateUrl:'app/views/sortBy.tmpl.html',
                controller: 'sortByController',
                controllerAs: 'sortByVm'
            })
            .when('/filterBy/:basedOn/:value',{
                templateUrl:'app/views/filterBy.tmpl.html',
                controller: 'filterByController',
                controllerAs: 'filterByVm'
            })
            .when('/browse/:id',{
                templateUrl:'app/views/titleInfo.tmpl.html',
                controller: 'titleInfoController',
                controllerAs: 'titleInfoVm'
            })
            .when('/admin/browse',{
                templateUrl:'app/views/titlesAdmin.tmpl.html',
                controller: 'titleController',
                controllerAs: 'titleVm'
            })
            .when('/admin/sortBy/:basedOn',{
                templateUrl:'app/views/sortByAdmin.tmpl.html',
                controller: 'sortByController',
                controllerAs: 'sortByVm'
            })
            .when('/admin/filterBy/:basedOn/:value',{
                templateUrl:'app/views/filterByAdmin.tmpl.html',
                controller: 'filterByController',
                controllerAs: 'filterByVm'
            })
            .when('/admin/browse/:id',{
                templateUrl:'app/views/titleInfoAdmin.tmpl.html',
                controller: 'titleInfoController',
                controllerAs: 'titleInfoVm'
            })
            .when('/admin/create',{
                templateUrl:'app/views/titleCreate.tmpl.html',
                controller: 'titleCreateController',
                controllerAs: 'titleCreateVm'
            })
            .when('/admin/update/:id',{
                templateUrl:'app/views/titleUpdate.tmpl.html',
                controller: 'titleUpdateController',
                controllerAs: 'titleUpdateVm'
            })
            .otherwise({
                redirectTo:'/home'
            })
        NotificationProvider.setOptions({
            delay: 2000,
            startTop: 40,
            startRight: 20,
            verticalSpacing: 40,
            horizontalSpacing: 20,
            positionX: 'center',
            positionY: 'top',
            closeOnClick: true

        });

    }


})();