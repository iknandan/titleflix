/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {

    'use strict';
    angular.module('titleflix')
        .directive('navBar',navBar);
    
    function navBar() {
        var directive = {
            restrict:'E',
            templateUrl:'app/views/nav-bar.tmpl.html',
            controller : 'navBarController',
            controllerAs : 'navBarVm'
        };
      return directive;
    };
})();