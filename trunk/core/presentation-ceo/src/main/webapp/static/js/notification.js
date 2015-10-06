var notifyApp = angular.module('notifyMe', []);

notifyApp.controller('refreshNotify', function($scope, $interval, $http) {
	$scope.friendRequestCount;
	$scope.friendRequests;
	$scope.frCnfNotifys;
	var timer = $interval(function() {
		$scope.notifyMe();
	}, 10000);

	$scope.notifyMe = function() {
		$http({
			url : $("#componentUrl").val() + 'notify/jsonGetNotification',
			method : 'POST',
			data : {

			}
		}).then(function(response) {
			$scope.friendRequestCount = response.data.friendRequests.length;
			$scope.friendRequests = response.data.friendRequests;
		}, function(response) {

		});
	}

	$scope.confirmFriendRequest = function(emailId) {
		$http({
			url : $("#componentUrl").val() + 'friends/jsonConfirmFriendRequest',
			method : 'POST',
			data : {
				'friendRequestTo' : emailId
			}
		}).then(function(response) {
			$scope.notifyMe();
		}, function(response) {

		});
	};
});