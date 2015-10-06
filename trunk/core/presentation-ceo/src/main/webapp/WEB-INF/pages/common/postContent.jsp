<%@include file="../common/taglibs.jsp"%>
<div class="post" ng-repeat="post in posts">
	<div class="member">
		<a href="<spring:message code="domain.component.prefix"/>profile/{{post.timelineId}}" class="profile-pic"><img ng-src="<spring:message code="domain.component.prefix"/>profileImage?image={{post.postedByUserPic}}"/><!-- <span class="fa fa-user fa-4x"></span> --></a>
		<a href="<spring:message code="domain.component.prefix"/>profile/{{post.timelineId}}" class="member-name">{{post.postedBy}} <span ng-if="post.isPostedByOnWall=='true'">&nbsp; <i class="fa fa-play"></i> &nbsp;${userInfo.firstName} ${userInfo.lastName}</span><br /> <small
			class="color-grey"><em><span class="date">{{post.postCreationDate}}</span> <!-- <span class="time">15:29:13</span> --></em></small></a>
	</div>
	<p class="post-title">{{post.postText}}</p>
	<div class="post-img">
		<img ng-src="<spring:message code="domain.component.prefix"/>picture/{{post.postImageNames[0]}}" />
	</div>
	<div class="like-comnt">
		<a href="#">Like</a> <a href="#">Comment</a> <a href="#">Share</a>
	</div>
	<div class="comments">
		<div ng-repeat="comment in post.commentDTOs" class="comment">
			<a href="#" class="profile-pic"><img ng-src="<spring:message code="domain.component.prefix"/>profileImage?image={{comment.commentedByUserPic}}"/><!-- <span class="fa fa-user fa-2x"></span> --></a> <a href="#"
				class="member-name"><strong>{{comment.createdByText}}</strong></a> <span>{{comment.commentText}}</span><br /> <a href="#"
				style="margin-right: 20px;">Like</a><a href="#">Reply</a>
		</div>
		<div class="comment last">
			<a href="#" class="profile-pic"><img ng-src="<spring:message code="domain.component.prefix"/>profileImage?image=${userInfo.profilePic}"/><!-- <span class="fa fa-user fa-2x"></span> --></a>
			<textarea placeholder="Write a comment..." name="commentText" ng-model="$parent.commentText"
				ng-enter="doComment({{post.postId}})" style="overflow: hidden;"></textarea>
		</div>
	</div>
</div>