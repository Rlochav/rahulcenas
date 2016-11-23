<%@include file="../../common/taglibs.jsp"%>
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
		<!-- Header section end here -->
		<!-- Menu section end here -->
		<div class="cent  no-right">
			<div class="main-content">
				<div id="system-message-container"></div>
				<div id="dashboard-area">
					<div id="title">Manage Merchants, Categories, Neighborhoods, Deals, Hot Deals &amp; Mobile</div>
					<br>
					<div id="menu">
						<ul>
							<li><a href="merchantList"><span>Manage Merchants</span></a></li>
							<li><a href="neighborhoods"><span>Neighborhoods</span></a></li>
							<li><a href="alldailydeals?dealType=1"><span>Deals</span></a></li>
							<li><a href="hotdealz?dealType=2"><span>Hot Deals</span></a></li>
							<!--<li><a href="#"><span>Mobile</span></a></li>-->
							<li><a href="merchantRegistration"><span>Add a New Merchant</span></a></li>
						</ul>
					</div>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> <a href="#" class="link1">Return New Orleans Dashboard</a>
					</div>
					<br> <br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your ${SESSION_ATTR_USER_INFO.cityText} Dashboard
						</em>
					</h3>
				</div>
			</div>
		</div>
		<!-- Slideshow section end here -->
		<!--show right div only if user not logged in -->
		<!-- Main text div end here -->
		<%@include file="../../common/bottom.jsp"%>
	</div>
	<!-- wrapper end here -->
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
</script>
</html>