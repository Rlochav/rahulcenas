<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="common.html.000001"></spring:message></title>

<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/rating.css'/>">
<link rel="shortcut icon" href="resources/images/icon.png" />
<script type="text/javascript" src="<c:url value='/resources/js/CommonFunction.js'/>"></script>
<link href="<c:url value='resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='resources/js/js-image-slider.js'/>"></script>
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
		<%@include file="../common/left.jsp"%>
		<!-- Menu section end here -->
		<div class="cent center-both no-right">
			<!--<div class="slider"><a href="#"></a></div>-->
			<div class="main-content">
				<div id="system-message-container"></div>
				<div id="dashboard-area">
					<div id="title">You will be redirected to selected city page..</div>
					<br>
					<div id="form-field">
						<form:form id="userLoginForm" name="userLoginForm" modelAttribute="chooseCityForm">
							<div style="background-color: #f4f4f4; padding: 10px; border: 1px solid #E6E6E6">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
									<tbody>
										<tr>
											<td width="19%"><strong>Select a City</strong></td>
											<td width="81%"><form:select path="path1" cssClass="mSelect" onchange="redirectToCityLink();">
													<form:option value="-1" label="--Select--"></form:option>
													<form:options items="${cityMap}" />
												</form:select></td>
										</tr>
									</tbody>
								</table>
							</div>
						</form:form>
					</div>
					<!--Content End -->
				</div>
				<!-- End of Dashboard -->
			</div>
		</div>
		<!-- Slideshow section end here -->
		<!--show right div only if user not logged in -->
		<%@include file="../common/right.jsp"%>
		<!-- Main text div end here -->
		<%@include file="../common/bottom.jsp"%>
	</div>
	<!-- wrapper end here -->
</body>
<script type="text/javascript">
$(function () {
	var retVal = $.ajax({
		url : "jsonGetHotDealz",
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
			sliderImage +='<a href="merchant/${merchantName2}-'+bannerArr[i].merchantId+'"><img src="displayImage?image='+bannerArr[i].imagePath+'" id="wrap'+(i+1)+'" style="visibility: hidden;"/></a>';
		}
		//sliderImage +='<div class="clr"></div>';
		$("#slider").append(sliderImage);
	}	
});
	function redirectToCityLink() {
		if ($("#path1").val() == "-1")
			return false;
		window.location.href = "redirectToCityLink?cityId=" + $("#path1").val();
	}

	function becomeAmerchant() {
		window.open("become-a-merchant");
	}
</script>
</html>
