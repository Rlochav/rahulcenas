<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<%@ taglib uri="http://cksource.com/ckfinder" prefix="ckfinder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title><spring:message code="common.html.000001"></spring:message></title>
<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/template1.css'/>"></link>
<link href="<c:url value='resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css"></link>
<script src="<c:url value='resources/js/js-image-slider.js'/>"></script>
<link rel="shortcut icon" href="resources/images/icon.png"></link>
<script type="text/javascript" src="<c:url value='resources/js/CommonFunction.js'/>"></script>

<link href="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/css/alert.css'/>" rel="stylesheet" />
<link href="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/themes/light/theme.css'/>" rel="stylesheet" />
<script src="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/js/alert.js'/>"></script>
<link href="<c:url value='resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />

<style>
iframe {
	width: 700px;
}
</style>
</head>
<body>
	<%@include file="../common/telliumTags.jsp"%>
	<div id="wrapper">
		<%@include file="../common/header4.jsp"%>
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
				<div id="system-message-container"></div>
				<div id="dashboard-area">
					<div id="title" class="merchantTitle">
						<span id="titleSpan">HI THERE ${SESSION_ATTR_USER_INFO.userName} Create New Post 
					</div>

					<br>
						<div class="items">
							<form:form method="POST" id="createPostForm" name="createPostForm" class="formStyle" modelAttribute="postDTO" enctype="multipart/form-data">
								<h3 class="msg">
									<em>Hi There ${SESSION_ATTR_USER_INFO.userName}, Create a New Blog Post</em>
									<div class="errorDiv" style="position: absolute; right: 0px; top: 10px;">
										<label class="error" id="error"></label>
									</div>
									<div id="success" class="success">
										<label></label>
									</div>
								</h3>
								<div class="profile">
									<table class="tableStyle" style="width: 100%;">
										<input type="hidden" id="postId" name="postId" value="${postDTO.postId}" />
										<tr>
											<td><form:input path="postTitle" cssClass="mInput" cssStyle="width: 100%;" /></td>
										</tr>
										<tr>
											<td><form:textarea path="postText" cols="50" rows="10" /> <ckfinder:setupCKEditor basePath="resources/ckfinder/" editor="postText" /> <ckeditor:replace replace="postText" basePath="resources/ckeditor/" /> <%--  --%></td>
										</tr>
										<tr>
											<td align="right"><input type="button" id="postBtn" value="Post" onclick="createPosts();" /></td>
										</tr>
									</table>
								</div>
							</form:form>
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
</body>
<script type="text/javascript">
	$(function() {
		$("#postTitle").attr('placeholder', 'Blog Post Title');
	});
	function createPosts() {
		if (trimString($("#postTitle").val()) == "") {
			appFocus($("#postTitle"));
			$.alert.open('error', 'Title is Mandatory.');
			return false;
		}

		document.createPostForm.action = 'savePost';
		document.createPostForm.submit();
	}
</script>
</body>
</html>