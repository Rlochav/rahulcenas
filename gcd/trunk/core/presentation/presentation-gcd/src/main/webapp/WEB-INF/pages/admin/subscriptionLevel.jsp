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
					<div id="title">All Get City Dealz Subscription Levels</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form method="post" name="subscriptionLevelForm" id="subscriptionLevelForm">
						<div class="items">
							<table class="items_list" width="100%" cellpadding="0" cellspacing="0">
								<tbody>
									<tr>
										<th>Level Name</th>
										<th>Level Full Year Price</th>
										<th>Quarter Payment Price</th>
										<th>&nbsp;</th>
									</tr>
									<c:forEach var="level" items="${levels}">
										<tr>
											<td>${level.levelName}</td>
											<td>${level.levelFullYearPrice}</td>
											<td>${level.quarterPaymentPrice}</td>
											<td class="button2"><input type="button" onclick="updateSubscriptionLevel('${level.levelId}');" id="${level.levelId}" value="Edit" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="pagination">
							<p class="counter"></p>
						</div>
						<br>
						<div class="button2">
							<input type="button" onclick="saveSubscriptionLevel();" value="Add New Subscription Level" />
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
	function saveSubscriptionLevel() {
		document.subscriptionLevelForm.action = 'editsubscriptionLevel';
		document.subscriptionLevelForm.submit();
	}

	function updateSubscriptionLevel(subsId) {
		document.subscriptionLevelForm.action = 'editsubscriptionLevel?subsId=' + subsId;
		document.subscriptionLevelForm.submit();
	}
</script>
</html>