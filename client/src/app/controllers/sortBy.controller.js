/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use stirct';
    angular.module('titleflix')
        .controller('sortByController',sortByController);

    sortByController.$inject = ['titleService','$routeParams'];
    function sortByController(titleService,$routeParams) {

        var sortByVm = this;
        init();
        function init(){
            console.log('sortByController');
            titleService.sortby($routeParams.basedOn)
                .then(function(sortTitles){
                    sortByVm.sortTitles = sortTitles;
                },function(error){
                    console.log(error);
                });
        };
    };
})();