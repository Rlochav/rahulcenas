<%@include file="../../common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en" ng-app="searchFriendsApp">
<head>
<meta charset="UTF-8">
<title>Search Friends</title>
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!--link rel="shortcut icon" href="images/favicon.png"-->
<link rel="stylesheet" href="<c:url value="../../static/css/style.css" />" />
<link rel="stylesheet" href="<c:url value="../../static/css/responsive.css" />" />

<script type="text/javascript" src='<c:url value="../../static/js/angular.min.js" />'></script>
<script type="text/javascript" src='<c:url value="../../static/js/jquery.min.js" />'></script>
<script type="text/javascript" src='<c:url value="../../static/js/bootstrap.js" />'></script>
<script type="text/javascript" src='<c:url value="../../static/js/script.js" />'></script>
<script type="text/javascript" src='<c:url value="../../static/js/notification.js" />'></script>
</head>
<body>
	<input type="hidden" id="componentUrl" value="<spring:message code="domain.component.prefix"/>">
	<!--Logo and Menu-->
	<header>
		<jsp:include page="../../common/headerWithSession.jsp"></jsp:include>
	</header>
	<section id="main-section">
		<div class="container">
			<div class="row">
				<div class="col-md-2 col-sm-12 col-xs-12">
					<div class="left-section">
						<div class="panel panel-default mar-top-10">
							<div class="panel-heading">
								Contacts <a href="#" class="add">Add</a>
							</div>
							<div class="panel-body">
								<ul class="list-block">
									<li><a href="#">Search Friends</a></li>
									<li><a href="#">Business Associates</a></li>
								</ul>
							</div>
						</div>
						<div class="panel panel-default mar-top-10">
							<div class="panel-heading">
								Friends Group <a href="#" class="add">Add</a>
							</div>
							<div class="panel-body">
								<ul class="list-block">
									<li><a href="#">All</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-7 col-sm-12 col-xs-12">
					<div class="post-section">
						<div class="col-md-12 col-sm-12 col-xs-12 no-pad-lt">
							<h3 class="mar-bot-10 text-left xs">
								<i class="fa fa-users"></i> Search Friends
							</h3>
						</div>
						<div class="clearfix"></div>
						<div class="well clearfix row">
							<div class="col-md-12 col-sm-12 col-xs-12 no-pad-lt no-pad-rt">
								<input type="text" placeholder="Search Friends" ng-model="searchText"
									class="pad-10 table-bordered mar-bot-10" />
								<div class="col-md-12 col-sm-12 col-xs-12 text-center mar-top-10 mar-bot-10">
									<a class="btn-success btn-lg" href="#" ng-click="doSearchFriend()">Show the Result</a>
								</div>
							</div>
						</div>

						<div class="friends">
							<!-- <div class="row">
								<div class="col-md-12 col-sm-12 col-xs-12 no-pad-lt">
									<div class="col-md-3 col-sm-3 col-xs-12 text-left xs">
										<ul class="pagination">
											<li><a href="#">First</a></li>
											<li><a href="#">Prev</a></li>
										</ul>
									</div>
									<div class="col-md-6 col-sm-6 col-xs-12 text-center xs">
										<ul class="pagination">
											<li><a href="#">1</a></li>
											<li class="active"><a href="#">2</a></li>
											<li><a href="#">3</a></li>
											<li><a href="#">4</a></li>
											<li><a href="#">5</a></li>
										</ul>
									</div>
									<div class="col-md-3 col-sm-3 col-xs-12 text-right xs">
										<ul class="pagination">
											<li><a href="#">Next</a></li>
											<li><a href="#">Last</a></li>
										</ul>
									</div>
								</div>
							</div> -->

							<search-friend-template></search-friend-template>

							<!-- <div class="row">
								<div class="col-md-12 col-sm-12 col-xs-12 no-pad-lt">
									<div class="col-md-3 col-sm-3 col-xs-12 text-left xs">
										<ul class="pagination">
											<li><a href="#">First</a></li>
											<li><a href="#">Prev</a></li>
										</ul>
									</div>
									<div class="col-md-6 col-sm-6 col-xs-12 text-center xs">
										<ul class="pagination">
											<li><a href="#">1</a></li>
											<li class="active"><a href="#">2</a></li>
											<li><a href="#">3</a></li>
											<li><a href="#">4</a></li>
											<li><a href="#">5</a></li>
										</ul>
									</div>
									<div class="col-md-3 col-sm-3 col-xs-12 text-right xs">
										<ul class="pagination">
											<li><a href="#">Next</a></li>
											<li><a href="#">Last</a></li>
										</ul>
									</div>
								</div>
							</div> -->
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-12 col-xs-12">
					<jsp:include page="../../common/menuWithSessionRight.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="../../common/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
	var app = angular.module('searchFriendsApp', [ 'notifyMe' ]);

	app.directive('searchFriendTemplate', function() {
		return {
			restrict : 'E',
			controller : function($scope, $http) {
				$scope.doSearchFriend = function() {
					$http({
						url : 'jsonSearchFriend',
						method : 'POST',
						data : {
							'firstName' : $scope.searchText
						}
					}).then(function(response) {
						$scope.users = response.data;
					}, function(response) {

					});
				};

				$scope.sendFriendRequest = function(user) {
					$http({
						url : 'jsonSendFriendRequest',
						method : 'POST',
						data : {
							'friendRequestTo' : user.emailId
						}
					}).then(function(response) {
						console.info(response.data);
					}, function(response) {

					});
				};

				$scope.confirmFriendRequest = function(user) {
					$http({
						url : 'jsonConfirmFriendRequest',
						method : 'POST',
						data : {
							'friendRequestTo' : user.emailId
						}
					}).then(function(response) {
						angular.forEach($scope.users, function(orignal) {
							if (orignal.userIndex == user.userIndex) {
								orignal.userFriendStatus = 4;
							}
						});
					}, function(response) {

					});
				};
			},
			templateUrl : '../searchFriendTemplate'
		}
	});
</script>
</html>