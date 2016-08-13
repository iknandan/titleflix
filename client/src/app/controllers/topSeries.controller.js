/**
 * Created by kaushik nandhan on 8/13/2016.
 */
(function () {
    'use strict';
    angular.module('titleflix')
        .controller('topSeriesController',topSeriesController);

    topSeriesController.$inject = ['topSeriesService'];
    function topSeriesController(topSeriesService) {
        var topSeriesVm = this;
        init();

        function init() {
            topSeriesService.topratedSeries()
                .then(function (topSeriesTitles) {
                    topSeriesVm.topSeriesTitles = topSeriesTitles;
                },function (error) {
                    console.log(error);
                });
        };
    };
})();