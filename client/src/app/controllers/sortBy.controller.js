/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use stirct';
    angular.module('titleflix')
        .controller('sortByController',sortByController);

    sortByController.$inject = ['titleService','$routeParams','Notification','$localStorage','$location'];
    function sortByController(titleService,$routeParams,Notification,$localStorage,$location) {

        var sortByVm = this;
        sortByVm.sortBasedOn = $routeParams.basedOn;
        // initializes this method when the controller is called, sorts the Titles based on the type selected
        init();
        function init(){
            // console.log('sortByController');
            if(!($localStorage.userObject ===  undefined)) {
                titleService.sortby($routeParams.basedOn)
                    .then(function (sortTitles) {
                        sortByVm.sortTitles = sortTitles;
                    }, function (error) {
                        Notification.error('Error connecting to the server');
                    });
            }
            else
            {
                // Notification.error('Please provide your credentails');
                $location.path('/signin');
            }
        };
    };
})();