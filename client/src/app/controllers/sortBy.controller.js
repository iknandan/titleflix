/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use stirct';
    angular.module('titleflix')
        .controller('sortByController',sortByController);

    sortByController.$inject = ['titleService','$routeParams','Notification'];
    function sortByController(titleService,$routeParams,Notification) {

        var sortByVm = this;
        init();
        function init(){
            console.log('sortByController');
            titleService.sortby($routeParams.basedOn)
                .then(function(sortTitles){
                    sortByVm.sortTitles = sortTitles;
                },function(error){
                    Notification.error('Error connecting to the server');
                });
        };
    };
})();