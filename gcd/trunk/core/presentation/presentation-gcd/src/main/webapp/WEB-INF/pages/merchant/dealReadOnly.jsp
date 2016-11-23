<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link rel="shortcut icon" href="resources/images/icon.png" />

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
				<div id="dashboard-area">
					<div id="title">Hi There ${SESSION_ATTR_USER_INFO.userName}, ${innerTitle}</div>
					<br>
						<div class="items">
							<div id="midContentDiv">
								<form:form name="merchantDealz" id="merchantDealz" class="formStyle" modelAttribute="uploadForm" enctype="multipart/form-data" method="POST">
									<div class="postDealz">
										<input type="hidden" style="display: none;" id="latitude" name="latitude" value="${dealzDTO.latitude}" /> <input type="hidden" style="display: none;" id="longitude" name="longitude" value="${dealzDTO.longitude}" />
										<fieldset>
											<input type="hidden" style="display: none;" id="dealId" name="dealId" value="<c:out value="${dealId}"/>" /> <input type="text" style="display: none;" id="dealType" name="dealType" value="<c:out value="${dealType}"/>" />
											<legend>Post Dealz</legend>
											<table style="width: 100%;">
												<tr>
													<td><label>Deal Title<span class="mandatory">*</span></label></td>
													<td><label id="titles" class="readOnlyLabel"><strong>${dealzDTO.title}</strong></label></td>
													<td><label>Deal Code</label></td>
													<td><label id="dealCode" class="readOnlyLabel"><strong>${dealzDTO.dealCode}</strong></label></td>
												</tr>
												<tr>
													<td><label style="width: 20%;">Description<span class="mandatory">*</span></label></td>
													<td><label style="width: 80%;" id="description"><strong>${dealzDTO.description}</strong></label></td>
													<td><label>Amount Saved</label></td>
													<td><label id="amountSaved" class="readOnlyLabel"><strong>${dealzDTO.amountSaved}</strong></label></td>
												</tr>
												<tr>
													<td><label>Restriction</label></td>
													<td><label id="restriction" class="readOnlyLabel"><strong>${dealzDTO.restriction}</strong></label></td>
													<td>&nbsp;</td>
													<td>&nbsp;</td>
												</tr>
												<tr>
													<td><label>End Date<span class="mandatory">*</span></label></td>
													<td><label id="endDate" class="readOnlyLabel"><strong>${dealzDTO.endDate}</strong></label></td>
													<td><label>Start Date<span class="mandatory">*</span></label></td>
													<td><label id="startDate" class="readOnlyLabel"><strong>${dealzDTO.startDate}</strong></label></td>
												</tr>
												<tr>
													<td colspan="3"><img width="12%" src="displayImage?image=${dealzDTO.imagePath}" /><input type="text" style="display: none;" name="docType" value="0" /> <label id="endDate" class="readOnlyLabel"></label></td>
													<td>Select Logo as deafult image: <c:if test="${dealzDTO.useLogo!=1}">
															<strong>No</strong>
														</c:if> <c:if test="${dealzDTO.useLogo==1}">
															<strong>Yes</strong>
														</c:if></td>
												</tr>
												<tr>
													<td colspan="4" align="right">
													<input type="button" style="width: 14%;" class="mediumBtn" name="okBtn" id="okBtn" value="Confirm & Post" onclick="OkClick();" /> 
													<input type="button" class="mediumBtn" name="editBtn" id="editBtn" value="Edit" onclick="editDealz(${dealzId},${dealType});" />
													<input type="button" class="mediumBtn" name="draftBtn" id="draftBtn" style="width: 13%;" value="Save As Draft" onclick="saveAsDraft();" /></td>
												</tr>
											</table>
										</fieldset>
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
</body>
<script type="text/javascript">
	function OkClick() {
		$.alert.open('confirm', 'Deal Submitted Successfully, It Will Go Live on Get City Dealz in the Next 1-2 Minutes.', function(button) {
			if (button == 'yes') {
				//window.location.href="allHotDealz?dealType=${dealType}"
				var retVal = $.ajax({
					url : "jsonConfirmDeal",
					type : "POST",
					global : false,
					data : {
						dealzId : "${dealzId}",
						dealType : "${dealType}"
					},
					dataType : "json",
					async : true
				}).responseText;

				window.location.href = "allHotDealz?dealType=${dealType}";
			}
		});
	}

	function saveAsDraft() {
		$.alert.open('confirm', 'Deal Saved  As Draft Successfully.', function(button) {
			if (button == 'yes') {
				window.location.href = "allHotDealz?dealType=${dealType}";
			}
		});
	}

	function editDealz(dealzId, dealType) {
		window.location.href = "postDealz?dealId=" + dealzId + "&dealType=" + dealType;
	}
</script>
</html>