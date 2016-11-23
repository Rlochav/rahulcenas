<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="common.html.000001"></spring:message></title>

<script type="text/javascript" src="<c:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/rating.css'/>">
<link rel="shortcut icon" href="/resources/images/icon.png" />
<link href="<c:url value='/resources/css/media.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/resources/js/CommonFunction.js'/>"></script>
<link href="<c:url value='/resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='/resources/js/js-image-slider.js'/>"></script>

<link href="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/css/alert.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/themes/light/theme.css'/>" rel="stylesheet" />
<script src="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/js/alert.js'/>"></script>
</head>

<body>
	<%@include file="../common/telliumTags.jsp"%>
	<div id="wrapper">
		<%@include file="../common/header3.jsp"%>
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
					<div id="title">${cityName}</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp;<a href="cities" class="link1">Return to All City Listings</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form method="post" name="allHotDealzForm" action="allHotDealzForm" modelAttribute="city" enctype="multipart/form-data">
						<div class="profile">
							<table class="tableStyle" style="width: 100%; border: 1px solid #CCCCCC; border-collapse: collapse;" border="1">
								<tbody>
									<tr>
										<td><label id="cityCodeLbl">City Code<span class="star">&nbsp;*</span></label></td>
										<td><input type="hidden" id="cityId" name="cityId" value="${city.cityId}" /> <input type="text" name="cityCode" value="${city.cityCode}" id="cityCode" class="mInput"></td>
									</tr>
									<tr>
										<td><label id="cityNameLbl">City Name<span class="star">&nbsp;*</span></label></td>
										<td><input type="text" name="cityName" id="cityName" value="${city.cityName}" class="mInput"></td>
									</tr>
									<tr>
										<td><label id="stateLbl">State<span class="star">&nbsp;*</span></label></td>
										<td><input type="hidden" id="stateId" name="stateId" value="${city.stateId}" /><input type="text" value="${city.stateName}" name="state" id="state" class="mInput"></td>
									</tr>
									<tr>
										<td><label id="timeZoneLbl">Time Zone<span class="star">&nbsp;*</span></label></td>
										<td><form:select path="timeZoneId" cssClass="mSelect" cssStyle="width: 210px;">
												<form:option value="-1">--Select--</form:option>
												<form:options items="${timeZoneMap}" />
											</form:select></td>
									</tr>
									<tr>
										<td></td>
										<td><input type="button" id="addCity" onclick="saveCity();" class="mediumBtn" value="${btnName}" /></td>
									</tr>
								</tbody>
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
$(function(){
	//$("#timeZoneId").val("${city.timeZoneId}");
	
	var retVal = $.ajax({
		url : "../jsonGetHotDealz",
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
			sliderImage +='<a href="merchant/${merchantName2}-'+bannerArr[i].merchantId+'"><img src="../displayImage?image='+bannerArr[i].imagePath+'" style="height:170px;" class="wrap" id="wrap'+(i+1)+'" style="display: none;"/></a>';
		}
		$("#slider").append(sliderImage);
	}
	
});
	function saveCity() {
		if (trimString($("#cityCode").val()) == "") {
			appFocus($("#cityCode"));
			$.alert.open('error', 'City Code is Missing.');
			return false;
		}
		if (trimString($("#cityName").val()) == "") {
			appFocus($("#cityName"));
			$.alert.open('error', 'City Name is Missing.');
			return false;
		}
		if (trimString($("#state").val()) == "") {
			appFocus($("#state"));
			alert("State is Missing");
			return false;
		}
		if (trimString($("#timeZoneId").val()) == "-1") {
			appFocus($("#timeZoneId"));
			alert("Time Zone is missing");
			return false;
		}
		var retVal = $.ajax({
			url : "jsonSaveCityDetails",
			type : "POST",
			global : false,
			data : {
				cityId : $("#cityId").val(),
				cityCode : $("#cityCode").val(),
				cityName : $("#cityName").val(),
				state : $("#state").val(),
				stateId : $("#stateId").val(),
				timeZoneId : $("#timeZoneId").val()
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
		if (obj != null) {
			if (obj.jsonMessage == null || obj.jsonMessage == ""){
				$.alert.open('info', 'City saved sucessfully.');
				window.location.href="cities";
			}
			else {
				$.alert.open('error', obj.jsonMessage);
			}
		} else {
			$.alert.open('error', 'Error');
		}
	}
</script>
</html>