<%@include file="../../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="common.html.000001"></spring:message></title>

<script type="text/javascript" src="<c:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/rating.css'/>">
<link rel="shortcut icon" href="/resources/images/icon.png" />
<link href="<c:url value='resources/css/media.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/resources/js/CommonFunction.js'/>"></script>
<link href="<c:url value='/resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='/resources/js/js-image-slider.js'/>"></script>

<link href="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/css/alert.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/themes/light/theme.css'/>" rel="stylesheet" />
<script src="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/js/alert.js'/>"></script>

<script src="<c:url value='/resources/common/js/base/jquery-ui.js'/>"></script>
<link rel="stylesheet" href="<c:url value='/resources/common/themes/start/jquery.ui.all.css'/>">
<link href="<c:url value='/resources/css/jquery-ui-timepicker-addon.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='/resources/js/jquery-ui-timepicker-addon.js'/>"></script>
</head>

<body>
	<%@include file="../../common/telliumTags.jsp"%>
	<div id="wrapper">
		<%@include file="../../common/header1.jsp"%>
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
					<div id="title">${SESSION_ATTR_USER_INFO.cityText}:HotDealAdmin</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp; <a href="merchantmgmt" class="link1">Return to ${SESSION_ATTR_USER_INFO.cityText} Dashboard</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form name="hotDealForm" id="hotDealForm" commandName="dealzDTO" enctype="multipart/form-data" method="POST">
						<fieldset>
							<input type="hidden" name="dealType" id="dealType" value="2" /> <input type="hidden" style="display: none;" id="dealId" name="dealId" value="<c:out value="${dealzDTO.dealId}"/>" />
							<legend>Hot Dealz</legend>
							<table>
								<tr>
									<td>Merchant</td>
									<td><form:select path="merchantId" cssClass="mSelect">
											<form:option value="-1">--Select--</form:option>
											<form:options items="${merchantsMap}" />
										</form:select></td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td>Hot Deal Title</td>
									<td><input type="text" name="title" value="${dealzDTO.title}" id="dealzTitle" /></td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td>Hot Deal Link</td>
									<td><input type="text" name="hotDealLink" id="hotDealLink" value="${dealzDTO.hotDealLink}" /></td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td>Hot Deal Image</td>
									<td><input type="file" name="files[0]" id="dealImage" style="width: 202px;" /></td>
									<td>&nbsp;</td>
									<td><img alt="dasd" src="../displayImage?image=${dealzDTO.imagePath}" width="100" height="40" /></td>
								</tr>
								<tr>
									<td>Deal Start Date</td>
									<td><input type="text" name="startDate" id="startDate" value="${dealzDTO.startDate}" /></td>
									<td>Deal End Date</td>
									<td><input type="text" name="endDate" id="endDate" value="${dealzDTO.endDate}" /></td>
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
									<td><label>Order Number in Carousel</td>
									<td><input type="text" name="orderNo" id="orderNo" value="${dealzDTO.orderNo}"></td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
							</table>
						</fieldset>
						<div style="float: right;">
							<input type="reset" name="resetBtn" id="resetBtn" /> <input type="button" name="submitDeal" id="submitDeal" value="Save Hot Deal" onclick="saveDealz();" />
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
		$("#startDate").datetimepicker({
			//minDate : "-0M -0D",
			timeFormat : "hh:mm tt"
		});

		$("#endDate").datetimepicker({
			//minDate : "-0M -0D",
			timeFormat : "hh:mm tt"
		});

		$("#timeZoneId").val("${zoneId}");
	});

	function saveDealz() {
		if (formValidation()) {
			document.hotDealForm.action = 'saveEditMerchantDealz';
			document.hotDealForm.submit();
		}
	}

	function formValidation() {
		if ($("#merchantId").val() == "-1") {
			$.alert.open('error', "Merchant is missing.");
			return false;
		}
		if ($("#dealzTitle").val() == "") {
			$.alert.open('error', "Deal Title is missing.");
			return false;
		}
		if ($("#startDate").val() == "") {
			$.alert.open('error', "Deal Start Date is missing.");
			return false;
		}
		if ($("#endDate").val() == "") {
			$.alert.open('error', "Deal End Date is missing.");
			return false;
		}
		if ($("#orderNo").val() == "") {
			$.alert.open('error', "Order Number in Carousel is missing.");
			return false;
		}
		if ($("#orderNo").val() != "" && isNaN($("#orderNo").val())) {
			$.alert.open('error', "Order Number in Carousel is invalid.");
			return false;
		}
		return true;
	}
</script>
</html>