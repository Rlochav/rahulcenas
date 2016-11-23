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
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/template1.css'/>">
<link href="<c:url value='resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='resources/js/js-image-slider.js'/>"></script>
<link rel="shortcut icon" href="resources/images/icon.png" />
<script type="text/javascript" src="<c:url value='resources/js/CommonFunction.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/rating.css'/>" />

<script src="<c:url value='resources/common/js/base/jquery-ui.js'/>"></script>
<link rel="stylesheet" href="<c:url value='resources/common/themes/start/jquery.ui.all.css'/>">
<link href="<c:url value='resources/css/jquery-ui-timepicker-addon.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='resources/js/jquery-ui-timepicker-addon.js'/>"></script>

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
					<div id="title">
						<c:if test="${dealType==2}">${SESSION_ATTR_USER_INFO.cityText}:${SESSION_ATTR_USER_INFO.userName} Hot</c:if>
						Deal Information<br>
					</div>
					<br>
					<%-- <h3 class="msg">
						<em>Hi there ${SESSION_ATTR_USER_INFO.userName} Manage Your Locations<br>
						</em>
					</h3> --%>
					<div class="items">
						<div id="midContentDiv">
							<form:form name="merchantDealz" id="merchantDealz" class="formStyle" modelAttribute="uploadForm" enctype="multipart/form-data" method="POST">
								<h3 class="msg">
									<em>Hi There ${SESSION_ATTR_USER_INFO.userName}, ${innerTitle}</em>
									<div class="errorDiv" style="position: absolute; right: 0px; top: 10px;">
										<label class="error" id="error"></label>
									</div>
									<div style="position: absolute; right: 0px; top: 10px; color: green;">
										<label id="success"></label>
									</div>
								</h3>
								<input type="hidden" style="display: none;" id="latitude" name="latitude" value="${dealzDTO.latitude}" />
								<input type="hidden" style="display: none;" id="longitude" name="longitude" value="${dealzDTO.longitude}" />
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
	$(function() {

		if ('<c:out value="${message}"/>'.length > 0) {
			$.alert.open('info', '<c:out value="${message}"/>');
		}

		$("#dealId").val('<c:out value="${dealzDTO.dealId}"/>');
		$("#category").val('<c:out value="${dealzDTO.category}"/>');
		$("#subCategory").val('<c:out value="${dealzDTO.subCategory}"/>');
		$("#city").val('<c:out value="${dealzDTO.city}"/>');

		$("#startDate").datetimepicker({
			//minDate : "-0M -0D",
			timeFormat : "hh:mm tt"
		});

		$("#endDate").datetimepicker({
			//minDate : "-0M -0D",
			timeFormat : "hh:mm tt"
		});

		$("#latitude").val('<c:out value="${dealzDTO.latitude}"/>');
		$("#longitude").val('<c:out value="${dealzDTO.longitude}"/>');

		var address1 = "${SESSION_ATTR_USER_INFO.address1}";
		var address2 = "${SESSION_ATTR_USER_INFO.address2}";
		var address3 = "${SESSION_ATTR_USER_INFO.address3}";
		var address4 = "${SESSION_ATTR_USER_INFO.zipCode}";
		var address5 = "${SESSION_ATTR_USER_INFO.cityToDisplay}";
		var address6 = "${SESSION_ATTR_USER_INFO.city}";
		var address = address1 + " " + address2 + " " + address3 + " " + address5 + " " + address6 + " " + address4;

		var retVal = $.ajax({
			url : "https://maps.googleapis.com/maps/api/geocode/json?address=" + address,
			type : "POST",
			global : false,
			data : {

			},
			dataType : "json",
			async : false
		}).responseText;

		retVal = jQuery.parseJSON(retVal);
		if (retVal != null) {
			$("#latitude").val(retVal.results[0].geometry.location.lat);
			$("#longitude").val(retVal.results[0].geometry.location.lng);
		}
	});

	function saveDealz() {
		if (formValidation()) {
			if (validateDealCode()) {
				document.merchantDealz.action = 'saveMerchantDealz';
				document.merchantDealz.submit();
			}
		}
	}

	function formValidation() {
		/* if ($("#category").val() == "-1") {
			appFocus($("#category"));
			$.alert.open('error', 'Category is Mandatory.');
			return false;
		}
		if ($("#subCategory").val() == "-1") {
			appFocus($("#subCategory"));
			$.alert.open('error', 'Sub Category is Mandatory.');
			return false;
		} */

		if ($("#dealzTitle").val() == "") {
			appFocus($("#dealzTitle"));
			$.alert.open('error', 'Title is Mandatory.');
			return false;
		}
		if ($("#startDate").val() == "") {
			appFocus($("#startDate"));
			$.alert.open('error', 'Start Date is Mandatory.');
			return false;
		}
		if ($("#endDate").val() == "") {
			appFocus($("#endDate"));
			$.alert.open('error', 'End Date is Mandatory.');
			return false;
		}
		if ($("#description").val() == "") {
			appFocus($("#description"));
			$.alert.open('error', 'Description is Mandatory.');
			return false;
		} else
			return true;
	}

	function onChageCategory1() {
		if (trimString($("#category").val()) == '-1') {
			return false;
		}
		var retVal = $.ajax({
			url : "jsonGetSubCategoryByCtgId",
			global : false,
			type : "POST",
			data : {
				categoryId : $("#category").val()
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);

		if (obj != null) {
			var subCmplntypMap = obj;
			if (subCmplntypMap != null) {
				var values4Cmb = new Array;
				var counter = 0;
				for ( var subCmplntVal in subCmplntypMap) {
					values4Cmb[counter++] = new CodeValueStruct(subCmplntVal, subCmplntypMap[subCmplntVal]);
				}
				fillCombo('subCategory', values4Cmb);
			} else {
				fillCombo('subCategory', new Array);
			}
		} else {
			fillCombo('subCategory', new Array);
		}
	}

	function validateDealCode() {
		var retVal = $.ajax({
			url : "jsonValidateDealCode",
			global : false,
			type : "POST",
			data : {
				dealId : $("#dealId").val(),
				dealCode : $("#dealCode").val()
			},
			dataType : "json",
			async : false
		}).responseText;

		console.log(retVal);

		var obj = (retVal.length != 0 ? retVal : null);

		if (obj != null && obj != "") {
			$.alert.open('warning', obj);
			return false
		}
		return true;
	}
</script>
</html>