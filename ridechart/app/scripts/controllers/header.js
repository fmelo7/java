'use strict';

/**
 * @ngdoc function
 * @name myAppYoApp.controller:HeaderCtrl
 * @description # HeaderCtrl Controller of the myAppYoApp
 */
angular
.module('myAppYoApp')
.controller('HeaderCtrl', function($scope, $location) {
	$scope.isActive = function(viewLocation) {
		return viewLocation === $location.path();
	};
});