<%@include file="../common/taglibs.jsp"%>
<div ng-repeat="user in users" class="col-md-4 col-sm-4 col-xs-12 no-pad-lt mar-bot-15">
	<div class="pad profile-fr pad-10 text-center">
		<figure class="avatar">
			<img
				style="width: 100px; height: 100px; margin: 0px auto; background-size: cover; border-radius: 50%; margin: 1px auto;"
				ng-src="../profileImage?image={{user.profilePic}}" />
		</figure>
		<div class="mar-top-10">
			<a href="../profile/{{user.timelineId}}" class="name">{{user.firstName+" "+user.lastName}}</a>
		</div>
		<div class="mar-top-10">
			<a href="#" class="btn btn-default">More About Me</a>
		</div>
		<!-- <div class="page-url mar-top-10">http://ceostocks.com/memberabc.4477</div> -->
		<div class="mar-top-10">
			<a href="#" class="btn btn-blue" ng-if="user.userFriendStatus==1"
				ng-click="sendFriendRequest(user)"><spring:message code="addAsFriend" text="UNKNOWN"></spring:message>
			</a> <a href="#" class="btn btn-blue" ng-if="user.userFriendStatus==2"><spring:message
					code="friendRequestSent" text="UNKNOWN"></spring:message></a> <a href="#" class="btn btn-blue"
				ng-if="user.userFriendStatus==3" ng-click="confirmFriendRequest(user)"><spring:message
					code="confirmFriendRequest" text="UNKNOWN"></spring:message></a> <a href="#" class="btn btn-blue"
				ng-if="user.userFriendStatus==4"><spring:message code="friends" text="UNKNOWN"></spring:message></a>
		</div>
	</div>
</div>