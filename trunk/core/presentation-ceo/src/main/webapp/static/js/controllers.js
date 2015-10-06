'use strict';

angular

.module('app', [ 'angularFileUpload' ])

.controller('AppController', [ '$scope', 'FileUploader', '$http', function($scope, FileUploader, $http) {
	$scope.hideThumbnail = true;
	$scope.postImageId = [];
	var uploader = $scope.uploader = new FileUploader({
		url : $("#componentUrl").val() + 'upload'
	});

	// FILTERS

	uploader.filters.push({
		name : 'imageFilter',
		fn : function(item /* {File|FileLikeObject} */, options) {
			var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
			return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
		}
	});

	// CALLBACKS

	uploader.onWhenAddingFileFailed = function(item /* {File|FileLikeObject} */, filter, options) {
		// console.info('onWhenAddingFileFailed', item, filter, options);
	};
	uploader.onAfterAddingFile = function(fileItem) {
		fileItem.upload();
		// console.info('onAfterAddingFile', fileItem);
	};
	uploader.onAfterAddingAll = function(addedFileItems) {
		// console.info('onAfterAddingAll', addedFileItems);
	};
	uploader.onBeforeUploadItem = function(item) {
		// console.info('onBeforeUploadItem', item);
	};
	uploader.onProgressItem = function(fileItem, progress) {
		// console.info('onProgressItem', fileItem, progress);
	};
	uploader.onProgressAll = function(progress) {
		// console.info('onProgressAll', progress);
	};
	uploader.onSuccessItem = function(fileItem, response, status, headers) {
		// console.info('onSuccessItem', fileItem, response, status, headers);
	};
	uploader.onErrorItem = function(fileItem, response, status, headers) {
		// console.info('onErrorItem', fileItem, response, status, headers);
	};
	uploader.onCancelItem = function(fileItem, response, status, headers) {
		console.info('onCancelItem', fileItem, response, status, headers);
	};
	uploader.onCompleteItem = function(fileItem, response, status, headers) {
		$scope.postImageId.push(response.fileSavedAs);
		// console.info('onCompleteItem', fileItem, response, status, headers);
	};
	uploader.onCompleteAll = function() {
		$scope.hideThumbnail = false;
		$('#canvas canvas').css('width', '62');
		$('#canvas canvas').css('height', '64');
		// console.info('onCompleteAll');
	};

	console.info('uploader', uploader);

	$scope.doPost = function() {
		if ($scope.statusText) {
			uploader.queue.length = 0;
			$http({
				url : $("#componentUrl").val() + 'saveStatus',
				method : "POST",
				data : {
					'timelineId' : $("#timelineId").val(),
					'postText' : $scope.statusText,
					'postImageNames' : $scope.postImageId,
					'visibility' : $("#visibilityTypes").val()
				}
			}).then(function(response) {
				console.info(response.data);
				$scope.posts.splice(0, 0, response.data);
				clearFeilds($scope);
			}, function(response) { // optional
				clearFeilds($scope)
				// console.info('save', response);
			});
		}
	};
} ]);

function clearFeilds(scope) {
	scope.postImageId.length = 0;
	scope.statusText = '';
	scope.submitted = false;
	scope.hideThumbnail = true;
}