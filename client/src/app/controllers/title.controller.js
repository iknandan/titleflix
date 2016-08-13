(function () {
    'use strict';

    angular.module('titleflix')
        .controller('titleController',titleController);

    titleController.$inject = ['titleService'];
    function titleController(titleService) {

        var titleVm = this;
        titleVm.titles = [];

        init();

        function init(){
            console.log('title controller');
            titleService.findAllTitles()
                .then(function (titles) {
                    titleVm.titles = titles;
                },function (error) {
                    console.log(error);
                });
        };

    };

})();