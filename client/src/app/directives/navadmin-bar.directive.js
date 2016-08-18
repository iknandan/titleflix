/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {

    'use strict';
    angular.module('titleflix')
        .directive('navAdmin',navAdmin);
    
    function navAdmin() {
        var directive = {
            restrict:'E',
            templateUrl:'app/views/nav-admin.tmpl.html',
            controller : 'navBarAdminController',
            controllerAs : 'navBarVm'
        };
      return directive;
    };
})();