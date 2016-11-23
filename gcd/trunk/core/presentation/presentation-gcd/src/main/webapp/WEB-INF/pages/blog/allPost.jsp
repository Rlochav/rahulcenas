<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title><spring:message code="common.html.000001"></spring:message></title>

<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/template1.css'/>">
<link href="<c:url value='resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='resources/js/js-image-slider.js'/>"></script>
<link rel="shortcut icon" href="resources/images/icon.png" />
<script type="text/javascript" src="<c:url value='resources/js/CommonFunction.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/rating.css'/>" />

<link href="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/css/alert.css'/>" rel="stylesheet" />
<link href="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/themes/light/theme.css'/>" rel="stylesheet" />
<script src="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/js/alert.js'/>"></script>
</head>

<body>
	<%@include file="../common/telliumTags.jsp"%>
	<div id="wrapper">
		<%@include file="../common/header.jsp"%>
		<div class="tagline">
			<div class="moduletable">


				<div class="custom">
					<p class="MsoNormal">
						<strong><spring:message code="common.html.000002"></spring:message></strong>
					</p>
				</div>
			</div>
		</div>
		<!-- Header section end here -->
		<%@include file="../common/merchantLeft.jsp"%>
		<!-- Menu section end here -->


		<div class="cent center-leftcenter-both no-right">
			<div class="main-content">
				<c:if test="${message!=null}">
					<div id="system-message-container">
						<dl id="system-message">
							<dt class="message">Message</dt>
							<dd class="message message">
								<ul>
									<li>${message}</li>
								</ul>
							</dd>
						</dl>
					</div>
				</c:if>
				<div id="dashboard-area">
					<div id="title">
						Hi There ${SESSION_ATTR_USER_INFO.userName} Manage Your Posts<br>
					</div>
					<br>
					<%-- <h3 class="msg">
						<em>Hi there ${SESSION_ATTR_USER_INFO.userName} Manage Your Locations<br>
						</em>
					</h3> --%>
					<br>
					<div class="items">
						<div id="midContentDiv">
							<form:form method="post" name="allPostForm" id="allPostForm" cssClass="formStyle">
								<h3 class="msg">
									<em>List of All Blog Posts </em>
									<div class="errorDiv" style="position: absolute; right: 0px; top: 10px;">
										<label class="error" id="error"></label>
									</div>
									<div id="success" class="success">
										<label></label>
									</div>
								</h3>
								<div class="profile">
									<table class="tableStyle" style="width: 100%;">
										<tr>
											<th>Scheduled/Published date</th>
											<th>Title</th>
											<th>&nbsp;</th>
										</tr>
										<c:forEach var="post" items="${postDTO}">
											<tr id="TR${post.postId}">
												<td>${post.postDate}</td>
												<td>${post.title}</td>
												<td><input type="button" id="deletDocx" value="Edit" onclick="editPost('${post.postId}')" /> <input type="button" id="deletDocx" value="Delete" onclick="deletePost('${post.postId}')" /></td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Slideshow section end here -->
		<!--show right div only if user not logged in -->
		<!-- Main text div end here -->

		<%@include file="../common/bottom.jsp"%>
	</div>
	<!-- wrapper end here -->


	<div class="tip-wrap" style="position: absolute; top: 586px; left: 396px; display: none;">
		<div class="tip-top"></div>
		<div class="tip">
			<div class="tip-title">Merchant Name</div>
			<div class="tip-text"></div>
		</div>
		<div class="tip-bottom"></div>
	</div>
</body>
<script type="text/javascript">
$(function(){
	var retVal = $.ajax({
		url : "jsonGetHotDealz",
		type : "POST",
		global : false,
		dataType : "json",
		async : false
	}).responseText;
	//alert(retVal);
	var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
	if (obj != null) {
		var bannerArr = obj.bannerDTOs;
		var sliderImage='';
		for(var i=0;i<bannerArr.length;i++){
			'<c:set var="merchantName" value="'+bannerArr[i].merchantName+'" />';
			<c:set var="merchantName1" value="${fn:split(merchantName, ' ')}" />
			<c:set var="merchantName2" value="${fn:join(merchantName1, '-')}" />
			sliderImage +='<a href="merchant/${merchantName2}-'+bannerArr[i].merchantId+'"><img src="displayImage?image='+bannerArr[i].imagePath+'" style="height:170px;" class="wrap" id="wrap'+(i+1)+'" style="display: none;"/></a>';
		}
		$("#slider").append(sliderImage);
	}
});
	function editPost(postId) {
		document.allPostForm.action = 'createPost?postId=' + postId;
		document.allPostForm.submit();
	}

	function deletePost(postId) {
		var retVal = $.ajax({
			url : "deletePost",
			global : false,
			type : "POST",
			data : {
				postId : postId
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);

		if (obj != null) {
			if (obj.jsonMessage == null) {
				$('#TR' + postId).remove();
				$.alert.open('info', 'Post deleted successfully.');
			} else {
				$.alert.open('error', obj.jsonMessage);
			}
		}
	}
</script>
</html>