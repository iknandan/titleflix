/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use stirct';
    angular.module('titleflix')
        .controller('sortByController',sortByController);

    sortByController.$inject = ['sortByService','$routeParams'];
    function sortByController(sortByService,$routeParams) {

        var sortByVm = this;
        init();
        function init(){
            console.log('sortByController');
            sortByService.sortby($routeParams.basedOn)
                .then(function(sortTitles){
                    sortByVm.sortTitles = sortTitles;
                },function(error){
                    console.log(error);
                });
        };
    };
})();