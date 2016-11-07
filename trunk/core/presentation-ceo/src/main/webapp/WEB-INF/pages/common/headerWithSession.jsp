<%@include file="../common/taglibs.jsp"%>
<div class="header_top_wrapper">
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<nav class="top-navigation">
					<ul>
						<li><a href="profile/${userInfo.timelineId}" class="color-white" title="Home"><span class="fa fa-home"></span>
								Home</a></li>
						<c:if test="${userInfo.permissionMap.M002_F001==true}">
							<li><a href="#" class="color-white" title="Shopping"><span class="fa fa-shopping-cart"></span> Shopping</a></li>
						</c:if>
						<c:if test="${userInfo.permissionMap.M003_F001==true}">
							<li><a href="#" class="color-white" title="Admin"><span class="fa fa-shield"></span> Investor</a></li>
						</c:if>
						<c:if test="${userInfo.permissionMap.M004_F001==true}">
							<li><a href="#" class="color-white" title="Admin"><span class="fa fa-shield"></span> Humanity</a></li>
						</c:if>
						<c:if test="${userInfo.permissionMap.M005_F001==true}">
							<li><a href="#" class="color-white" title="Admin"><span class="fa fa-shield"></span> Admin</a></li>
						</c:if>

						<li><a href="siteAdmin" class="color-white" title="Admin"><span class="fa fa-shield"></span> Site Admin</a></li>
						<li><a href="#" class="color-white" title="Market"><span class="fa fa-money"></span> Market</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-md-4" ng-controller="refreshNotify" ng-init="notifyMe();">
				<nav class="top-navigation icon-menus">
					<ul class="text-center">
						<li><a href="#" title="Mail"> <span class="fa fa-envelope fa-lg"></span> <!-- <span
								class="notification-counter">0</span> -->
						</a>
							<div class="mail pop-up panel panel-default">
								<div class="panel-content">
									<div class="comments">
										<div class="top-bar">
											<div class="heading">Inbox</div>
											<div class="action">
												<a href="#">Mark all as Read</a> <a href="#">Send New Message</a>
											</div>
										</div>
										<a href="javascript:void(0)" class="comment unread"> <span class="profile-pic"><span
												class="fa fa-user fa-2x"></span></span>
											<p class="member-name">
												<strong>Thor</strong>
											</p> <span class="msg">Hi...</span>
										</a> <a href="javascript:void(0)" class="comment"> <span class="profile-pic"><span
												class="fa fa-user fa-2x"></span></span>
											<p class="member-name">
												<strong>Thor</strong>
											</p> <span class="msg">Hi...</span>
										</a> <a href="javascript:void(0)" class="comment"> <span class="profile-pic"><span
												class="fa fa-user fa-2x"></span></span>
											<p class="member-name">
												<strong>Thor</strong>
											</p> <span class="msg">Hi...</span>
										</a> <a href="javascript:void(0)" class="comment last"> <span class="profile-pic"><span
												class="fa fa-user fa-2x"></span></span>
											<p class="member-name">
												<strong>Thor</strong>
											</p> <span class="msg">Hi...</span>
										</a>
									</div>
								</div>
								<div class="panel-footer">
									<a href="#" class="color-blue"><strong>See All</strong></a>
								</div>
							</div></li>
						<li><a href="#" title="Message"> <span class="fa fa-comments fa-lg"></span> <!-- <span
								class="notification-counter">0</span> -->
						</a>
							<div class="message pop-up panel panel-default">
								<div class="panel-content">
									<div class="comments">
										<div class="top-bar">
											<div class="heading">Inbox</div>
											<div class="action">
												<a href="#">Mark all as Read</a> <a href="#">Send New Message</a>
											</div>
										</div>
										<a href="javascript:void(0)" class="comment unread"> <span class="profile-pic"><span
												class="fa fa-user fa-2x"></span></span>
											<p class="member-name">
												<strong>Thor</strong>
											</p> <span class="msg">Hi...</span>
										</a> <a href="javascript:void(0)" class="comment"> <span class="profile-pic"><span
												class="fa fa-user fa-2x"></span></span>
											<p class="member-name">
												<strong>Thor</strong>
											</p> <span class="msg">Hi...</span>
										</a> <a href="javascript:void(0)" class="comment"> <span class="profile-pic"><span
												class="fa fa-user fa-2x"></span></span>
											<p class="member-name">
												<strong>Thor</strong>
											</p> <span class="msg">Hi...</span>
										</a> <a href="javascript:void(0)" class="comment last"> <span class="profile-pic"><span
												class="fa fa-user fa-2x"></span></span>
											<p class="member-name">
												<strong>Thor</strong>
											</p> <span class="msg">Hi...</span>
										</a>
									</div>
								</div>
								<div class="panel-footer">
									<a href="#" class="color-blue"><strong>See All</strong></a>
								</div>
							</div></li>
						<li><a href="#" title="Friends"> <span class="fa fa-users fa-lg"></span> <span
								class="notification-counter" ng-if="friendRequestCount!=0" ng-cloak class="ng-cloak">{{friendRequestCount}}</span>
						</a>
							<div class="friends pop-up panel panel-default">
								<div class="panel-content">
									<div class="comments">
										<!-- New Friend Requests -->
										<div class="top-bar">
											<div class="heading">Friend Requests</div>
											<div class="action">
												<a href="#">Find Friends</a> <a href="#">Settings</a>
											</div>
										</div>
										<div class="comment" ng-repeat="friendRequest in friendRequests">
											<a href="#" class="profile-pic">
												<!-- <span class="fa fa-user fa-2x"></span> -->
												<img ng-src="profileImage?image={{friendRequest.profilePic}}" />
											</a>
											<p>
												<a href="profile/{{friendRequest.timelineId}}" class="member-name"><strong>{{friendRequest.userName}}</strong></a>
											</p>
											<a class="btn btn-primary color-white" ng-click="confirmFriendRequest(friendRequest.emailId)">Accept</a> <a
												class="btn btn-default">Not Now</a>
										</div>
										<!-- New Friend Added -->
										<div class="top-bar">
											<div class="heading">New Friends</div>
											<div class="action">
												<a href="#">Find Friends</a> <a href="#">Settings</a>
											</div>
										</div>
										<div class="comment">
											<a href="#" class="profile-pic"><span class="fa fa-user fa-2x"></span></a> <a href="#" class="member-name"><strong>Oliver</strong></a>
										</div>
									</div>
								</div>
								<div class="panel-footer">
									<a href="#" class="color-blue"><strong>See All</strong></a>
								</div>
							</div></li>
						<li><a href="#" title="To Do"> <span class="fa fa-tasks fa-lg"></span> <!-- <span
								class="notification-counter">0</span> -->
						</a>
							<div class="to-do pop-up panel-body"></div></li>
						<li><a href="#" title="Notifications"> <span class="fa fa-globe fa-lg"></span> <!-- <span
								class="notification-counter">0</span> -->
						</a>
							<div class="notification pop-up panel panel-default">
								<div class="panel-content">
									<div class="comments">
										<div class="top-bar">
											<div class="heading">Notifications</div>
											<div class="action">
												<a href="#">Mark as Read</a> <a href="#">Settings</a>
											</div>
										</div>
										<a href="javascript:void(0)" class="comment unread" ng-repeat="frCnfNotify in frCnfNotifys"> <span
											class="profile-pic"><span class="fa fa-user fa-2x"></span></span> <span class="notifi-msg"><span
												class="member-name"><strong>{{frCnfNotify.firstName+" "+frCnfNotify.lastName}}</strong></span> <span
												class="msg">accepted friend request.</span></span> <span class="notifi-img">
												<!-- <img src="images/box.jpg" /> -->
										</span>
										</a>
									</div>
								</div>
								<div class="panel-footer">
									<a href="#" class="color-blue"><strong>See All</strong></a>
								</div>
							</div></li>
						<li><a href="#" title="Marketing"> <span class="fa fa-bar-chart fa-lg"></span> <!--  <span
								class="notification-counter">0</span> -->
						</a>
							<div class="marketing pop-up panel-body"></div></li>
					</ul>
				</nav>
			</div>
			<div class="col-md-4">
				<nav class="top-navigation right-nav">
					<ul class="text-right">
						<li><a href="#" class="color-white">Welcome ${userInfo.firstName} <span class="profile-pic"><i
									class="fa fa-user"></i></span></a>
							<div class="message pop-up panel panel-default">
								<div class="panel-content">
									<div class="comments">
										<a href="javascript:void(0)" class="comment unread text-right">Thor</a> <a href="javascript:void(0)"
											class="comment unread text-right">Thor</a>
										<div class="divider"></div>
										<a href="javascript:void(0)" class="comment unread text-right">Thor</a> <a href="javascript:void(0)"
											class="comment unread text-right">Thor</a>
										<div class="divider"></div>
										<a href="javascript:void(0)" class="comment unread text-right">Thor</a> <a href="javascript:void(0)"
											class="comment unread text-right">Thor</a>
										<div class="divider"></div>
										<a href="javascript:void(0)" class="comment unread text-right">Thor</a> <a href="javascript:void(0)"
											class="comment unread text-right">Thor</a>
									</div>
								</div>
							</div></li>
						<li><a href="<spring:message code="domain.prefix"/>logout" class="color-white">Sign Out</a></li>
						<li><a href="#" class="color-white">Wish List</a>
							<div class="pop-up panel-body"></div></li>
						<li><a href="#" class="color-white">English <span class="fa fa-language"></span></a>
							<div class="pop-up panel-body"></div></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</div>
<div class="sub_header_wrapper">
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-2 col-xs-12">
				<div class="logo">
					<a href="#">CEO</a>
				</div>
			</div>
			<div class="col-md-6 col-sm-8 col-xs-9">
				<div class="search">
					<input type="text" placeholder="Lets Start Saving..." /> <input type="submit" value="Search" />
				</div>
			</div>
			<div class="col-md-3 col-sm-2 col-xs-3">
				<nav class="top-navigation cart-nav">
					<ul class="text-right">
						<li><a href="#" class="color-white"><span class="cart">0</span><i class="fa fa-cart-plus fa-3x"></i></a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
	<div class="navigation">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<nav class="main-navigation">
						<ul>
							<li><a href="home"><span class="fa fa-home"></span> HOME</a></li>
							<li><a href="about-us/"><span class="fa fa-info-circle"></span> ABOUT</a></li>
							<li><a href="gallery/"><span class="fa fa-image"></span> GALLERY</a></li>
							<li><a href="friends/"><span class="fa fa-user"></span> FRIENDS</a></li>
							<li><a href="profile/${userInfo.timelineId}"><span class="fa fa-newspaper-o"></span> TIMELINE</a></li>
							<li><a href="#"><span class="fa fa-rss"></span> BLOG & FORUMS</a></li>
							<li><a href="task/"><span class="fa fa-tasks"></span> TASKS</a></li>
						</ul>
					</nav>
					<div class="mobile-nav">
						<div class="dropdown">
							<button class="btn dropdown-toggle" type="button" data-toggle="dropdown">
								Menu <span class="fa fa-navicon"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#"><span class="fa fa-home"></span> HOME</a></li>
								<li><a href="#"><span class="fa fa-info-circle"></span> ABOUT</a></li>
								<li><a href="#"><span class="fa fa-image"></span> GALLERY</a></li>
								<li><a href="#"><span class="fa fa-user"></span> FRIENDS</a></li>
								<li><a href="#"><span class="fa fa-newspaper-o"></span> TIMELINE</a></li>
								<li><a href="#"><span class="fa fa-rss"></span> BLOG & FORUMS</a></li>
								<li><a href="#"><span class="fa fa-tasks"></span> TASKS</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>