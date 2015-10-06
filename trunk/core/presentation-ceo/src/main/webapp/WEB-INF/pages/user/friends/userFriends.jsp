<%@include file="../../common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en" ng-app="userFriendsApp">
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
	<header>
		<jsp:include page="../../common/headerWithSession.jsp"></jsp:include>
	</header>
	<section id="main-section">
		<div class="container">
			<div class="row">
				<div class="col-md-2 col-sm-12 col-xs-12">
					<div class="left-section">
						<!-- <div class="profile">
							<span class="fa fa-user fa-5x"></span> <span class="profile-name"><a href="#"
								class="color-white">Jhon</a></span>
						</div> -->
						<div class="panel panel-default mar-top-10">
							<div class="panel-heading">
								Contacts <a href="#" class="add">Add</a>
							</div>
							<div class="panel-body">
								<ul class="list-block">
									<li><a href="searchFriend">Search Friends</a></li>
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

						<div class="friends">
							<search-friend-template ng-init="init()"></search-friend-template>
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
	var app = angular.module('userFriendsApp', [ 'notifyMe' ]);

	app.directive('searchFriendTemplate', function() {
		return {
			restrict : 'E',
			controller : function($scope, $http) {
				$scope.init = function() {
					$http({
						url : 'jsonGetUserFriends',
						method : 'POST',
						data : {}
					}).then(function(response) {
						$scope.users = response.data;
					}, function(response) {

					});
				};
			},
			templateUrl : '../searchFriendTemplate'
		}
	});
</script>
</html>