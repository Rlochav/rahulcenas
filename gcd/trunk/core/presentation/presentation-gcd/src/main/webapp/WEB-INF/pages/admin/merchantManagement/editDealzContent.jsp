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

<script type="text/javascript" src="<c:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/rating.css'/>">
<link rel="shortcut icon" href="resources/images/icon.png" />
<link href="<c:url value='resources/css/media.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/resources/js/CommonFunction.js'/>"></script>
<link href="<c:url value='/resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='/resources/js/js-image-slider.js'/>"></script>

<script src="<c:url value='/resources/common/js/base/jquery-ui.js'/>"></script>
<link rel="stylesheet" href="<c:url value='/resources/common/themes/start/jquery.ui.all.css'/>">
<link href="<c:url value='/resources/css/jquery-ui-timepicker-addon.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='/resources/js/jquery-ui-timepicker-addon.js'/>"></script>
</head>

<body>
	<%@include file="../../common/telliumTags.jsp"%>
	<div id="wrapper">
		<%@include file="../../common/header3.jsp"%>
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
					<div id="title">EDIT ${SESSION_ATTR_USER_INFO.cityText} : ${merchantDto.merchantName}'s ${dealzDTO.title}</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp; <a href="alldailydeals?dealType=1" class="link1">Return to All ${SESSION_ATTR_USER_INFO.cityText} Deals</a> &nbsp; <a href="merchantmgmt" class="link1">Return to ${SESSION_ATTR_USER_INFO.cityText} Dashboard</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form name="merchantDealzForm" id="merchantDealzForm" class="formStyle" modelAttribute="merchantDealzForm" enctype="multipart/form-data" method="POST">

						<h3 class="msg" align="center">
							<em>Merchant's Name: ${dealzDTO.merchantName}</em>
						</h3>
						<input type="hidden" style="display: none;" id="latitude" name="latitude" value="${dealzDTO.latitude}" />
						<input type="hidden" style="display: none;" id="longitude" name="longitude" value="${dealzDTO.longitude}" />
						<input type="hidden" style="display: none;" id="merchantId" name="merchantId" value="${dealzDTO.merchantId}" />
						<div class="form_fields" style="display: none;">
							<label>City<span class="mandatory">*</span></label>
							<form:select path="city" cssClass="mSelect" onchange="findAddress();">
								<form:option value="-1" label="--Select--"></form:option>
								<form:options items="${cityMap}" />
							</form:select>
						</div>
						<fieldset>
							<input type="hidden" style="display: none;" id="dealId" name="dealId" value="<c:out value="${dealId}"/>" /> <input type="text" style="display: none;" id="dealType" name="dealType" value="<c:out value="${dealType}"/>" />
							<legend>Post Dealz</legend>
							<table style="width: 100%;">
								<tr>
									<td><label>Deal Title<span class="mandatory">*</span></label></td>
									<td><input type="text" name="title" value="${dealzDTO.title}" id="dealzTitle" class="mInput" /></td>
									<td><label>Deal Code</label></td>
									<td><input type="text" value="${dealzDTO.dealCode}" name="dealCode" id="dealCode" class="mInput" /></td>
								</tr>
								<tr>
									<td><label>Description<span class="mandatory">*</span></label></td>
									<td colspan="3"><textarea style="width: 76%;" rows="2" cols="3" name="description" id="description">${dealzDTO.description}</textarea></td>
								</tr>
								<tr>
									<td><label>Amount Saved</label></td>
									<td><input type="text" value="${dealzDTO.amountSaved}" name="amountSaved" id="amountSaved" class="mInput" /></td>
									<td><label>Restriction</label></td>
									<td><input type="text" value="${dealzDTO.restriction}" name="restriction" id="restriction" class="mInput" /></td>
								</tr>
								<tr>
									<td><label>Time Zone<span class="mandatory">*</span></label></td>
									<td><form:select path="timeZoneId" cssClass="mSelect">
											<form:option value="-1">--Select--</form:option>
											<form:options items="${timeZoneMap}" />
										</form:select></td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td><label>Start Date<span class="mandatory">*</span></label></td>
									<td><input type="text" value="${dealzDTO.startDate}" name="startDate" id="startDate" class="mInput" /></td>
									<td><label>End Date<span class="mandatory">*</span></label></td>
									<td><input type="text" value="${dealzDTO.endDate}" name="endDate" id="endDate" class="mInput" /></td>
								</tr>
								<tr>
									<td><label>Deal Image <c:if test="${dealType==2}">(Minimum size 658w X 216h)</c:if></label></td>
									<td><input type="text" style="display: none;" name="docType" value="0" /> <input type="file" name="files[0]" id="dealImage" class="mInput" /> <input type="hidden" name="localTimeZoneName" id="localTimeZoneName" /></td>
									<td>&nbsp;</td>
									<td><input type="checkbox" id="useLogo" name="useLogo"> Select Logo as default logo. <input type="text" style="display: none;" name="docType" value="0" /></td>
								</tr>
							</table>
						</fieldset>
						<!-- Gmap Start-->
						<div id="map-canvas" style="width: 300px; height: 300px; display: none;"></div>
						<!--Gmap End -->
						<div style="float: right;">
							<input type="reset" name="resetBtn" id="resetBtn" />
							<c:if test="${dealType==1}">
								<input type="button" name="submitDeal" id="submitDeal" value="Submit Deal" onclick="saveDealz();" />
							</c:if>
							<c:if test="${dealType==2}">
								<input type="button" name="submitDeal" id="submitDeal" value="Create Hot Deal & Pay" onclick="saveDealz();" />
							</c:if>
						</div>
					</form:form>
				</div>
			</div>
			<strong> </strong>
		</div>
		<strong><%@include file="../../common/bottom.jsp"%></strong>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$("#dealId").val('<c:out value="${dealzDTO.dealId}"/>');
		$("#category").val('<c:out value="${dealzDTO.category}"/>');
		$("#subCategory").val('<c:out value="${dealzDTO.subCategory}"/>');
		$("#city").val('<c:out value="${dealzDTO.city}"/>');
		$("#description").val('<c:out value="${dealzDTO.description}"/>');
		if ('<c:out value="${dealzDTO.useLogo}"/>' == "1")
			$("#useLogo").attr("checked", true);
		$("#startDate").datetimepicker({
			//minDate : "-0M -0D",
			timeFormat : "hh:mm tt"
		});

		$("#endDate").datetimepicker({
			//minDate : "-0M -0D",
			timeFormat : "hh:mm tt"
		});

	});

	function saveDealz() {
		if (formValidation()) {
			document.merchantDealzForm.action = 'saveEditMerchantDealz';
			document.merchantDealzForm.submit();
		}
	}

	function formValidation() {
		if ($("#city").val() == "-1") {
			appFocus($("#city"));
			alert("City is Mandatory");
			return false;
		}
		if ($("#dealzTitle").val() == "") {
			appFocus($("#dealzTitle"));
			alert("Title is Mandatory");
			return false;
		}
		if ($("#startDate").val() == "") {
			appFocus($("#startDate"));
			alert("Start Date is Mandatory");
			return false;
		}
		if ($("#endDate").val() == "") {
			appFocus($("#endDate"));
			alert("End Date is Mandatory");
			return false;
		}

		if ($("#description").val() == "") {
			appFocus($("#description"));
			alert("Description is Mandatory");
			return false;
		}
		/* if ($("#dealImage").val() == "" && !$("#useLogo").is(":checked")) {
			appFocus($("#dealImage"));
			alert("Choose image or use default logo.");
			return false; */

		return true;
	}
</script>

</html>