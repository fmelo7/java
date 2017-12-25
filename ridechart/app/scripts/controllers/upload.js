'use strict';

/**
 * @ngdoc function
 * @name myAppYoApp.controller:UploadCtrl
 * @description # UploadCtrl Controller of the myAppYoApp
 */
angular
.module('myAppYoApp')
.controller('UploadCtrl', function($scope, FileUploader) {

	//var DATA_SERVICE = "/data-service";
	var DATA_SERVICE = "";

	$scope.vm = {
		title : 'Upload Files',
		description : 'Here you can upload your .fit files from your device.'
	};
	
	var uploader = $scope.uploader = new FileUploader({
		url : DATA_SERVICE = '/datamodel/upload'
	});
	
	// FILTERS
	
	uploader.filters.push({
		name : 'customFilter',
		fn : function(item /* {File|FileLikeObject} */, options) {
			return this.queue.length < 1024;
		}
	});
	
	// CALLBACKS
	
	uploader.onWhenAddingFileFailed = function(item /* {File|FileLikeObject} */, filter, options) {
		//console.info('onWhenAddingFileFailed', item, filter, options);
	};
	
	uploader.onAfterAddingFile = function(fileItem) {
		//console.info(fileItem.file.name);
		//console.info('onAfterAddingFile', fileItem);
	};
	
	uploader.onAfterAddingAll = function(addedFileItems) {
		//console.info('onAfterAddingAll', addedFileItems);
	};
	
	uploader.onBeforeUploadItem = function(item) {
		//console.info('onBeforeUploadItem', item);
	};
	
	uploader.onProgressItem = function(fileItem, progress) {
		//console.info('onProgressItem', fileItem, progress);
	};
	
	uploader.onProgressAll = function(progress) {
		//console.info('onProgressAll', progress);
	};
	
	uploader.onSuccessItem = function(fileItem, response, status, headers) {
		//console.info('onSuccessItem', fileItem, response, status, headers);
	};
	
	uploader.onErrorItem = function(fileItem, response, status, headers) {
		//console.info('onErrorItem', fileItem, response, status, headers);
	};
	
	uploader.onCancelItem = function(fileItem, response, status, headers) {
		//console.info('onCancelItem', fileItem, response, status, headers);
	};
	
	uploader.onCompleteItem = function(fileItem, response, status, headers) {
		//console.info('onCompleteItem', fileItem, response, status, headers);
	};
	
	uploader.onCompleteAll = function() {
		//console.info('onCompleteAll');
	};
	
	//console.info('uploader', uploader);
});
