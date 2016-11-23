<%@include file="../../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="common.html.000001"></spring:message></title>

<script type="text/javascript" src="<c:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/rating.css'/>">
<link rel="shortcut icon" href="/resources/images/icon.png" />
<script type="text/javascript" src="<c:url value='/resources/js/CommonFunction.js'/>"></script>
<link href="<c:url value='/resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='/resources/js/js-image-slider.js'/>"></script>

<link href="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/css/alert.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/themes/light/theme.css'/>" rel="stylesheet" />
<script src="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/js/alert.js'/>"></script>
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
					<div id="title">${SESSION_ATTR_USER_INFO.cityText}:HotDealListings</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp; <a href="merchantmgmt" class="link1">Return to ${SESSION_ATTR_USER_INFO.cityText} Dashboard</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form method="post" name="allDealzForm" id="allDealzForm">

						<div class="profile">
							<input type="text" style="display: none;" id="docType" name="docType" value="1">
							<table class="tableStyle" style="width: 100%;">
								<tr>
									<th>Merchant Name</th>
									<th style="display: none;">Deal Date</th>
									<th>Deal Title</th>
									<th style="width: 25%;">Deal Description</th>
									<th>Deal Start Date/Time</th>
									<th>Deal End Date/Time</th>
									<th>Status</th>
									<th style="width: 13%;">&nbsp;</th>
								</tr>
								<c:forEach var="dealz" items="${dealzDTO}">
									<tr id="row${dealz.dealId}">
										<td class="mReadOnlyLabel">${dealz.merchantName}</td>
										<td style="display: none;" class="mReadOnlyLabel">${dealz.createDateText}</td>
										<td class="mReadOnlyLabel">${dealz.title}</td>
										<td class="mReadOnlyLabel">${dealz.description}</td>
										<td class="mReadOnlyLabel">${dealz.startDate}</td>
										<td class="mReadOnlyLabel">${dealz.endDate}</td>
										<td class="mReadOnlyLabel">${dealz.statusText}</td>
										<td>
											<%-- <c:if test="${dealz.statusText!='Active'}"> --%> <input type="button" onclick="editDealzContent('${dealz.dealId}','${dealz.merchantId}');" id="${dealz.dealId}" style="font-size: 12px; padding: 2px 7px;" value="Edit" />&nbsp;&nbsp;<input type="button"
											style="font-size: 12px; padding: 2px 7px;" onclick="deleteDealz('${dealz.dealId}','${dealz.merchantId}');" id="deleteBtn${dealz.dealId}" value="Delete" /> <%-- </c:if> --%>
										</td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<c:if test="${dealType==2}">
							<div class="button2">
								<input type="button" onclick="addNewHotDeal();" value="Add New Hot Deal" />
							</div>
						</c:if>
					</form:form>
				</div>
			</div>
			<strong> </strong>
		</div>
		<strong><%@include file="../../common/bottom.jsp"%></strong>
	</div>
</body>
<script type="text/javascript">
$(function(){
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
		if("${message}"!=""){
			$.alert.open('info', '${message}');
		}
	}
});
	function editDealzContent(dealzId, merchantId) {
		document.allDealzForm.action = 'openHotDeal?dealzId=' + dealzId
				+ "&dealType=2" + "&merchantId=" + merchantId;
		document.allDealzForm.submit();
	}

	function deleteDealz(dealzId, merchantId) {
		$.alert.open('confirm', 'Do you want delete dealz.?', function(button) {
			if (button == 'yes') {
				var retVal = $.ajax({
					url : "deleteMerchantDealz",
					type : "POST",
					global : false,
					data : {
						dealzId : dealzId,
						merchantId : merchantId
					},
					dataType : "json",
					async : false
				}).responseText;

				var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
				if (obj != null) {
					if (obj.jsonMessage == null || obj.jsonMessage == "") {
						$("#row" + dealzId).remove();
						$.alert.open('info', 'Deal deleted sucessfully.');
					} else {
						$.alert.open('error', obj.jsonMessage);
					}
				} else {
					$.alert.open('error', 'Error');
				}
			}
		});
	}
	
	function addNewHotDeal(){
		document.allDealzForm.action ="openHotDeal";
		document.allDealzForm.submit();
	}
</script>
</html>