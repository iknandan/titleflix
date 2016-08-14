/**
 * Created by kaushik nandhan on 8/14/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('titleCreateController',titleCreateController);

    titleCreateController.$inject = ['titleCreateService'];
    function titleCreateController(titleCreateService){
        var titleCreateVm = this;
        titleCreateVm.createTitle = createTitle;
        console.log('titlecreatecontroller');

        function createTitle() {
            console.log('title obj '+titleCreateVm.newTitle);

            titleCreateService.createTitle(titleCreateVm.newTitle)
                .then(function (newTitle) {
                    titleCreateVm.newTitle = newTitle;
                },function (error) {
                    console.log(error);
                });
        };
    };
})();