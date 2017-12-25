'use strict';

/**
 * @ngdoc filter
 * @name myAppYoApp.filter:extensionSplit
 * @function
 * @description # extensionSplit Filter in the myAppYoApp.
 */
angular
.module('myAppYoApp')
.filter('extensionSplit', function() {
	return function(input) {
		return input.split(".")[0];
	};
});