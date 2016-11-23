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
		<div class="cent  no-right">
			<div class="main-content">
				<div id="system-message-container"></div>
				<div id="dashboard-area">
					<div id="title">Add Right Hand Rail</div>
					<br>
						<div align="right">
							<a href="component/adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp;<a href="component/gcd-meta-handler" class="link1">Return to meta manager</a> &nbsp;&nbsp;<a href="component/righHandRails" class="link1">Return to list of right hand rail</a> &nbsp;
						</div> <br>
							<h3 class="msg">
								<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
								</em>
							</h3> <form:form method="POST" id="createPostForm" name="createPostForm" class="formStyle" modelAttribute="metaDTO" enctype="multipart/form-data">
								<div class="profile">
									<table class="tableStyle" style="width: 100%;">
										<form:hidden path="id" />
										<tr>
											<td><form:input path="pageTitle" cssClass="mInput" cssStyle="width: 100%;" /></td>
										</tr>
										<tr>
											<td>Order Appearance: <form:input path="align" cssClass="mInput" cssStyle="width: 5%;" /></td>
										</tr>
										<tr>
											<td>Show in Right Rail: <script type="text/javascript">
												if ('<c:out value="${dto.showOnPage}"/>' == "1")
													document.write('<input type="checkbox" name="showOnPage" id="showOnPage_${dto.id}" checked/>');
												if ('<c:out value="${dto.showOnPage}"/>' == "0")
													document.write('<input type="checkbox" name="showOnPage" id="showOnPage_${dto.id}"/>');
												if ('<c:out value="${dto.showOnPage}"/>' != "0" && '<c:out value="${dto.showOnPage}"/>' != "1")
													document.write('<input type="checkbox" name="showOnPage" id="showOnPage" checked/>');
											</script></td>
										</tr>
										<tr>
											<td><form:textarea path="pageText" cols="50" rows="10" /> <ckfinder:setupCKEditor basePath="resources/ckfinder/" editor="pageText" /> <ckeditor:replace replace="pageText" basePath="resources/ckeditor/" /> <%--  --%></td>
										</tr>
										<tr>
											<td align="right"><input type="button" id="postBtn" value="Post" onclick="createPosts();" /></td>
										</tr>
									</table>
								</div>
							</form:form>
				</div>
			</div>
			<strong> </strong>
		</div>
		<strong><%@include file="../common/bottom.jsp"%></strong>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$("#pageTitle").attr('placeholder', 'Section Title');
	});
	function createPosts() {
		if (trimString($("#pageTitle").val()) == "") {
			appFocus($("#pageTitle"));
			$.alert.open('error', '	Title is Mandatory.');
			return false;
		}

		document.createPostForm.action = 'saveRightHandRails';
		document.createPostForm.submit();
	}
</script>
</body>
</html>