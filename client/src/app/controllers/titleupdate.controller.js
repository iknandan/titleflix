/**
 * Created by kaushik nandhan on 8/14/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('titleUpdateController',titleUpdateController);

    titleUpdateController.$inject = [];
    function titleUpdateController(){
        var titleUpdateVm = this;
        console.log('titleUpdateController');
    };
})();