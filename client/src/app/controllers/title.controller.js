(function () {
    'use strict';

    angular.module('titleflix')
        .controller('titleController',titleController);

    titleController.$inject = ['titleService','Notification'];
    function titleController(titleService,Notification) {

        var titleVm = this;
        titleVm.titles = [];

        init();

        function init(){
            console.log('title controller');
            titleService.findAllTitles()
                .then(function (titles) {
                    titleVm.titles = titles;
                },function (error) {
                    Notification.error('Error connecting to the server');
                });
        };

    };

})();