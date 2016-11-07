<%@include file="../common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Ceo Stocks</title>
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!--link rel="shortcut icon" href="images/favicon.png"-->
<link rel="stylesheet" href="<c:url value="../static/css/style.css" />" />
<link rel="stylesheet" href="<c:url value="../static/css/responsive.css" />" />

<script type="text/javascript" src='<c:url value="../static/js/jquery.min.js" />'></script>
<script type="text/javascript" src='<c:url value="../static/js/bootstrap.js" />'></script>
<script type="text/javascript" src='<c:url value="../static/js/script.js" />'></script>
<script type="text/javascript" src='<c:url value="../static/js/angular.min.js" />'></script>
<script type="text/javascript" src='<c:url value="../static/js/angular-route.min.js" />'></script>
</head>
<body>
	<!--Logo and Menu-->
	<header>
		<jsp:include page="../common/headerWithSession.jsp"></jsp:include>
	</header>
	<section id="main-section" ng-app="app">
		<div class="container">
			<div class="row">
				<div class="col-md-2 col-sm-12 col-xs-12">
					<div class="left-section">
						<div class="panel panel-default mar-top-10">
							<div class="panel-heading">
								Product Management
								<!--  <a href="#" class="add">Add</a> -->
							</div>
							<div class="panel-body">
								<ul class="list-block">
									<li><a href="#cmsPageContent" class="list-block">Content Manager</a></li>
								</ul>
								<ul class="list-block">
									<li><a href="#cmsMenuList">Menu Manager</a></li>
								</ul>
								<ul class="list-block">
									<li><a href="#cmsUrlCategoryMaster">URL Manager</a></li>
								</ul>
								<ul class="list-block">
									<li><a href="#">Page Manager</a></li>
								</ul>
								<ul class="list-block">
									<li><a href="#">Role Manager</a></li>
								</ul>
								<ul class="list-block">
									<li><a href="#">User Manager</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-7 col-sm-12 col-xs-12">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<!-- HTML template -->
							<div ng-view></div>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-12 col-xs-12">
					<jsp:include page="../common/menuWithSessionRight.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
<script>
	var app = angular.module('app', [ 'ngRoute' ]);
	app.config([ '$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
		$routeProvider.when('/', {
			templateUrl : 'cmsContentList',
			controller : 'SiteAdminCtrl',
			controllerAs : 'book'
		}).when('/cmsPageContentEditor', {
			templateUrl : 'cmsPageContentEditor',
			controller : 'SiteAdminCtrl',
			controllerAs : 'book'
		}).when('/cmsPageMaster', {
			templateUrl : 'cmsPageMaster',
			controller : 'SiteAdminCtrl',
			controllerAs : 'book'
		}).when('/cmsLinkMaster', {
			templateUrl : 'cmsLinkMaster',
			controller : 'SiteAdminCtrl',
			controllerAs : 'book'
		}).when('/cmsMenuList', {
			templateUrl : 'cmsMenuList',
			controller : 'SiteAdminCtrl',
			controllerAs : 'book'
		}).when('/cmsMenuMaster', {
			templateUrl : 'cmsMenuMaster',
			controller : 'SiteAdminCtrl',
			controllerAs : 'book'
		}).when('/cmsUrlCategoryMaster', {
			templateUrl : 'cmsUrlCategoryMaster',
			controller : 'UrlCategoryMasterCtrl'
		}).otherwise({
			redirectTo : '/'
		});

		//$locationProvider.html5Mode(true);
	} ]);
	app.controller('SiteAdminCtrl', function($scope) {
	});

	app.controller('UrlCategoryMasterCtrl', function($scope, $http) {
		$scope.isActive = true;
		$scope.type = "-1";
		$scope.save = function() {
			$http({
				url : 'saveCmsUrlCategory',
				method : "POST",
				data : {
					'name' : $scope.categoryName,
					'categoryType' : $scope.type,
					'isActive' : $scope.isActive
				}
			}).then(function(response) {
				console.log(response);
			}, function(response) {

			});
		};
	});
</script>
</html>