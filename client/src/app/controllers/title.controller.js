(function () {
    'use strict';

    angular.module('titleflix')
        .controller('titleController',titleController);

    titleController.$inject = ['titleService','Notification','$localStorage','$location'];
    function titleController(titleService,Notification,$localStorage,$location) {

        var titleVm = this;
        titleVm.titles = [];
        // initializes the function when the controller is called and lists the Titles
        init();

        function init(){
            if(!($localStorage.userObject ===  undefined)){
            // console.log('title controller');
            titleService.findAllTitles()
                .then(function (titles) {
                    titleVm.titles = titles;
                },function (error) {
                    Notification.error('Error connecting to the server');
                });
            }
            else{
                $location.path('/signin');
            }
        };
    };

})();