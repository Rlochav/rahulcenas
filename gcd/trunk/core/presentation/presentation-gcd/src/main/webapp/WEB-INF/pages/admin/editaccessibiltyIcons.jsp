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
					<div id="title">${btnName}GETCITY DEALZ ACCESSIBILITY ICON</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp;<a href="icons" class="link1">Return to All Icons</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form method="post" name="editicons" action="/component/editicons" modelAttribute="iconFeilds" enctype="multipart/form-data">
						<div class="profile">
							<table class="tableStyle" style="width: 100%; border: 1px solid #CCCCCC; border-collapse: collapse;" border="0">
								<tbody>
									<tr>
										<td>Icon File<span style="color: red;">*</span></td>
										<td><input type="hidden" id="iconId" name="iconId" value="${icons.iconId}" /> <input type="file" name="iconImage" id="iconImage" class="mInput" required /> ${icons.iconUrl}</td>
										<c:set var="img" value="${fn:replace(icons.imagePath,'.', '_do_custom_separator_')}" />
										<td><c:if test="${icons.iconName!=null}">
												<img alt="${icons.iconName}" src="../displayImage1/${img}?docType=11" width="60" />
											</c:if> <c:if test="${icons.iconName==null}">&nbsp;</c:if></td>
									</tr>
									<tr>
										<td>Icon Name<span style="color: red;">*</span></td>
										<td><input type="text" name="iconName" id="iconName" value="${icons.iconName}" class="mInput"></td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td></td>
										<td><input type="button" id="iconBtn" onclick="saveIconDetails();" value="${btnName}" /></td>
										<td>&nbsp;</td>
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
	
	if ('<c:out value="${message}"/>'.length > 0) {
		$.alert.open('info', '<c:out value="${message}"/>');
	}
});
	function saveIconDetails() {
		 if (trimString($("#iconImage").val()) == ""&&${icons.iconId}+''=='') {
				appFocus($("#iconImage"));
				$.alert.open('error', 'Icon Image is Missing');
				return false;
		 } 
		if (trimString($("#iconName").val()) == "") {
			appFocus($("#iconName"));
			$.alert.open('error', 'Icon Name is Missing');
			return false;
		}
		/* if (trimString($("#iconUrl").val()) == "") {
			appFocus($("#cityName"));
			$.alert.open('error', 'Icon Url is Missing');
			return false;
		} */
		document.editicons.action="saveIconDetails";
		document.editicons.submit();
	}
</script>
</html>