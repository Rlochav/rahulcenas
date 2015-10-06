<%@include file="../common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en" ng-app="userHomePage">
<head>
<meta charset="UTF-8">
<title>Welcome ${userInfo.firstName}</title>
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!--link rel="shortcut icon" href="images/favicon.png"-->
<link rel="stylesheet" href="<c:url value="../static/css/style.css" />" />
<link rel="stylesheet" href="<c:url value="../static/css/responsive.css" />" />

<script type="text/javascript" src='<c:url value="../static/js/jquery.min.js" />'></script>
<script type="text/javascript" src='<c:url value="../static/js/bootstrap.js" />'></script>
<script type="text/javascript" src='<c:url value="../static/js/script.js" />'></script>

<script type="text/javascript" src='<c:url value="../static/js/angular.min.js" />'></script>
<script type="text/javascript" src='<c:url value="../static/js/angular-file-upload.min.js" />'></script>
<script type="text/javascript" src='<c:url value="../static/js/controllers.js" />'></script>
<script type="text/javascript" src='<c:url value="../static/js/directives.js" />'></script>
<script type="text/javascript" src='<c:url value="../static/js/notification.js" />'></script>


<%-- <link type="text/css" rel="stylesheet" media="all" href="<c:url value="../static/css/chat.css" />" />
<link type="text/css" rel="stylesheet" media="all" href="<c:url value="../static/css/screen.css" />" />
<script type="text/javascript" src="<c:url value="../static/js/chat.js" />"></script> --%>
<style type="text/css">
.profile {
	position: relative;
	width: 175px;
	height: 175px;
	text-align: center;
	border: 3px solid #fff;
	border-radius: 5px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	-o-border-radius: 5px;
	overflow: hidden;
	margin: 0 auto;
	background: url(profileImage?image=${userInfo.profilePic}) no-repeat
		center center;
	background-size: cover;
}
</style>
<!-- <script type="text/javascript">
	$(function() {
		var cbhtml = "";
		var j = 0;
		$.ajax({
			url : "getOnlineUserList",
			cache : false,
			dataType : "json",
			success : function(data) {
				var obj = data;
				$.each(data, function(i, item) {
					cbhtml = cbhtml + '<div class="chatboxUser"><div class="uclink">&#149; <a href="javascript:void(0)" onclick="javascript:chatWith(\''
							+ item.nickName + '\')">' + item.nickName + '</a></div></div>';
					j = i + 1;
				});
				userList(cbhtml, j);
			}
		});
	})
</script> -->
</head>
<body ng-controller="AppController">
	<input type="hidden" id="timelineId" value="${userInfo.timelineId}">
	<input type="hidden" id="componentUrl" value="<spring:message code="domain.component.prefix"/>">
	<!--Logo and Menu-->
	<header>
		<jsp:include page="../common/headerWithSession.jsp"></jsp:include>
	</header>
	<section id="main-section">
		<div class="container">
			<div class="row">
				<div class="col-md-2 col-sm-3 col-xs-12">
					<div class="left-section">
						<div class="profile">
							<span class="fa fa-user fa-5x"></span> <span class="profile-name"><a href="#"
								class="color-white" data-toggle="modal" data-target="#myModal">${userInfo.firstName}</a></span>
						</div>
					</div>
				</div>
				<div class="col-md-5 col-sm-9 col-xs-12">
					<div class="post-section">
						<form role="form" name="statusForm" ng-submit="doPost();" class="simple-form" novalidate>
							<div class="update-status">
								<a href="#" class="color-black share"><span class="fa fa-share-alt"></span> Share an
									Update</a>
								<!--  <input type="text" placeholder="Subject" /> -->
								<textarea placeholder="Tell your friends what's in your mind..." id="statusText"
									name="statusText" ng-model="statusText" ng-required="true"></textarea>
								<span ng-cloak class="text-danger"
									ng-show="submitted && statusForm.statusText.$error.required">Post cann't be empty.</span>
							</div>
							<div class="update-status" ng-hide="hideThumbnail">
								<div ng-repeat="item in uploader.queue">
									<div id="canvas" ng-cloak class="ng-cloak" ng-thumb="{ file: item._file, height: 100 }"
										style="position: relative; width: 70px; height: 70px; text-align: center; border: 3px solid #F1E8E8;"></div>

									<div class="progress-bar" role="progressbar"
										ng-style="{ 'width': uploader.progress + '%' }"></div>
								</div>
								<input type="hidden" name="postImageId" ng-model="postImageId" />
							</div>
							<div class="status-actions">
								<div class="row">
									<div class="col-md-1 col-sm-1 col-xs-1 text-center" nv-file-drop="" uploader="uploader">
										<a href="#" class="color-black fa fa-camera fa-lg" style="cursor: pointer;"
											ng-class="{disabled: disabled}"><input type="file" name="files[]" multiple
											nv-file-select="" uploader="uploader" style="margin-top: -20px; opacity: 0;"></a>
									</div>
									<div class="col-md-1 col-sm-1 col-xs-1 text-center">
										<a href="#" class="color-black" title="Tag Your Friends"><span
											class="fa fa-tags fa-lg"></span></a>
									</div>
									<div class="col-md-1 col-sm-1 col-xs-1 text-center">
										<a href="#" class="color-black" title="Share Your feelings"><span
											class="fa fa-smile-o fa-lg"></span></a>
									</div>
									<div class="col-md-1 col-sm-1 col-xs-1 text-center">
										<a href="#" class="color-black" title="Share Your Location"><span
											class="fa fa-map-marker fa-lg"></span></a>
									</div>
									<div
										class="col-md-3 col-sm-3 col-xs-4 col-md-offset-3 col-sm-offset-3 col-xs-offset-1 text-right">
										<select id="visibilityTypes">
											<option value="PUBLIC">Public</option>
											<option value="FRIENDS">Friends</option>
											<option value="ONLY_ME">Only Me</option>
										</select>
									</div>
									<div class="col-md-2 col-sm-1 col-xs-2 text-right">
										<input type="submit" ng-click="submitted=true" class="btn btn-blue" value="Post" />
									</div>
								</div>
							</div>
						</form>

						<!--POST 1-->
						<post-content ng-init="init()"></post-content>
					</div>
				</div>
				<div class="col-md-2 col-sm-12 col-xs-12">
					<div class="trending panel panel-default">
						<div class="panel-heading">Trending</div>
						<div class="panel-body">
							<div class="product">
								<a href="#" class="product-pic"><img
									src="<c:url value='../static/images/product-box.png'/>" /></a> <a href="#"
									class="product-name"><strong>Product 1</strong></a>
							</div>
							<div class="product">
								<a href="#" class="product-pic"><img
									src="<c:url value='../static/images/product-box.png'/>" /></a> <a href="#"
									class="product-name"><strong>Product 2</strong></a>
							</div>
							<div class="product">
								<a href="#" class="product-pic"><img
									src="<c:url value='../static/images/product-box.png'/>" /></a> <a href="#"
									class="product-name"><strong>Product 3</strong></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-12 col-xs-12">
					<jsp:include page="../common/menuWithSessionRight.jsp"></jsp:include>
					<div class="recent-post-section">
						<div class="panel panel-default">
							<div class="panel-heading">
								<a href="#">Recent Posts</a>
							</div>
							<div class="panel-body">
								<div class="product">
									<a href="#" class="product-pic"><span class="fa fa-user fa-2x"></span></a> <a href="#"
										class="product-name"><strong>Thor</strong></a> <span>Hi...</span>
								</div>
								<div class="product">
									<a href="#" class="product-pic"><span class="fa fa-user fa-2x"></span></a> <a href="#"
										class="product-name"><strong>Thor</strong></a> <span>Hi...</span>
								</div>
								<div class="product">
									<a href="#" class="product-pic"><span class="fa fa-user fa-2x"></span></a> <a href="#"
										class="product-name"><strong>Thor</strong></a> <span>Hi...</span>
								</div>
								<div class="product">
									<a href="#" class="product-pic"><span class="fa fa-user fa-2x"></span></a> <a href="#"
										class="product-name"><strong>Thor</strong></a> <span>Hi...</span>
								</div>
								<div class="product last">
									<a href="#" class="product-pic"><span class="fa fa-user fa-2x"></span></a> <a href="#"
										class="product-name"><strong>Thor</strong></a> <span>Hi...</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<h3>Starting Your Online Business</h3>
					<ul>
						<li><a href="#" class="color-white">CEO Stock Option Plans</a></li>
						<li><a href="#" class="color-white">My Binary Renewal</a></li>
						<li><a href="#" class="color-white">User Type</a></li>
					</ul>
				</div>
				<div class="col-md-3">
					<h3>Shopping And Selling</h3>
					<ul>
						<li><a href="#" class="color-white">Company Registration</a></li>
						<li><a href="#" class="color-white">Applying for an account</a></li>
						<li><a href="#" class="color-white">Transfer Funding</a></li>
						<li><a href="#" class="color-white">Marketing tools</a></li>
						<li><a href="#" class="color-white">Private Registration</a></li>
					</ul>
				</div>
				<div class="col-md-3">
					<h3>Website Services</h3>
					<ul>
						<li><a href="#" class="color-white">SSL Certificates</a></li>
						<li><a href="#" class="color-white">Custom Web Design</a></li>
						<li><a href="#" class="color-white">Email Marketing</a></li>
					</ul>
				</div>
				<div class="col-md-3">
					<h3>I Want To ...</h3>
					<ul>
						<li><a href="#" class="color-white">Apply for a sharing fund</a></li>
						<li><a href="#" class="color-white">Promote my company</a></li>
						<li><a href="#" class="color-white">Start a Blog</a></li>
						<li><a href="#" class="color-white">Connect the online credit to my web</a></li>
						<li><a href="#" class="color-white">Log Into My Account</a></li>
						<li><a href="#" class="color-white">Get Help</a></li>
						<li><a href="#" class="color-white">Promte this site for rewards</a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
	<footer class="copyright">
		<ul>
			<li><a href="#" class="color-white">Site Terms</a></li>
			<li><a href="#" class="color-white">Terms and Conditions of Sale</a></li>
			<li><a href="#" class="color-white">Privacy Policy</a></li>
			<li><a href="#" class="color-white">About Us</a></li>
			<li><a href="#" class="color-white">Contact Us</a></li>
		</ul>
		<p>Copyright &copy; Company name, 2015. All Rights Reserved</p>
	</footer>

	<!-- Modal -->
	<form action="uploadUserProfilePic" method="post" enctype="multipart/form-data">
		<div id="myModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Update Profile Picture</h4>
					</div>
					<div class="modal-body">
						<p>
							Upload Image <input type="file" name="file" id="file" />
						</p>
						<div class="col-md-2 col-sm-1 col-xs-2 text-right">
							<input type="submit" class="btn btn-blue" value="Upload" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>

	<!-- Post image Modal -->
	<div id="postImageModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content" style="height: 150px;">
				<form name="postImageForm" id="postImageForm">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Update Profile Picture</h4>
					</div>
					<div class="modal-body">
						<p>
							Upload Image <input type="file" file-model="myFile" name="file" id="file" multiple />
						</p>
						<div class="col-md-2 col-sm-1 col-xs-2 text-right">
							<input type="submit" class="btn btn-blue" value="Upload" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var app = angular.module('userHomePage', [ 'app', 'angularFileUpload', 'notifyMe' ]);
	app.directive('postContent', function() {
		return {
			restrict : 'E',
			controller : function($scope, $http) {
				$scope.init = function() {
					$http({
						url : 'getTimelineStatus',
						method : "POST",
						data : {
							timelineId : $("#timelineId").val(),
							start : '0',
							total : '10'
						}
					}).then(function(response) {
						console.info(response.data);
						$scope.posts = response.data;
					}, function(response) {
					});
				};

				$scope.doComment = function(postId) {
					if ($scope.commentText) {
						$http({
							url : 'savePostComment',
							method : "POST",
							data : {
								'postId' : postId,
								'commentText' : $scope.commentText
							}
						}).then(function(response) {
							angular.forEach($scope.posts, function(item) {
								if (item.postId == postId) {
									item.commentDTOs.push(response.data);
								}
							});
							$scope.commentText = '';
						}, function(response) {

						});
					}
				};
			},
			templateUrl : 'postContent'
		};
	});

	app.directive('ngEnter', function() {
		return function(scope, element, attrs) {
			element.bind("keydown", function(e) {
				if (e.which === 13) {
					scope.$apply(function() {
						scope.$eval(attrs.ngEnter, {
							'e' : e
						});
					});
					e.preventDefault();
				}
			});
		};
	});
</script>
</html>