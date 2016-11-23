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
				<div id="system-message-container">
					<div id="message"></div>
				</div>
				<div id="dashboard-area">
					<div id="title">${btnName}GETCITYDEALZAdminManagement</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp;<a href="adminUsers" class="link1">Return to All Admins</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form method="post" name="usermasterForm" id="usermasterForm" action="/component/saveAdminDetails" commandName="usermasters">
						<div class="profile">
							<table class="tableStyle" style="width: 100%; border: 1px solid #CCCCCC; border-collapse: collapse;" border="0">
								<tr>
									<td>User Id</td>
									<td><form:input path="userId" /> <form:hidden path="userIndex" /></td>
								</tr>
								<tr>
									<td>e-Mail</td>
									<td><form:input path="emailId" /></td>
								</tr>
								<tr>
									<td>Password</td>
									<td><input type="password" name="password" id="password" /></td>
								</tr>
								<tr>
									<td>Re-Password</td>
									<td><input type="password" name="repassword" id="repassword" /></td>
								</tr>
								<tr>
									<td>First Name</td>
									<td><form:input path="contactFirstName" /></td>
								</tr>
								<tr>
									<td>Last Name</td>
									<td><form:input path="contactLastName" /></td>
								</tr>

								<tr>
									<td>&nbsp;</td>
									<td><input type="button" value="${btnName}" name="adminBtn" id="adminBtn" onclick="saveDetails();" /></td>
								</tr>
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
	function saveDetails() {
		if (trimString($("#userId").val()) == "") {
			$.alert.open('User Id is Mandatory.');
			return false;
		}
		if (trimString($("#emailId").val()) == "") {
			$.alert.open('e-Mail is Mandatory.');
			return false;
		}
		if (trimString($("#password").val()) == ""&&$("#userIndex").val()=="") {
			$.alert.open('Password is Mandatory.');
			return false;
		}
		if (trimString($("#password").val()).length > 0) {
			if (trimString($("#repassword").val()) == "") {
				$.alert.open('Re Password is Mandatory.');
				return false;
			}
			if (trimString($("#password").val()) != trimString($("#repassword")
					.val())) {
				$.alert.open('Password does not match with Confirm Password.');
				return false;
			}
		}
		
		if (trimString($("#contactFirstName").val()) == "") {
			$.alert.open('First Name is Mandatory.');
			return false;
		}
		
		var retVal = $.ajax({
			url:"validateAdminUserIdEmailId",
			type:"POST",
			global:false,
			data:{
				userId :$("#userId").val(),
				emailId:$("#emailId").val(),
				userIndex :$("#userIndex").val()
			},
			dataType:"json",
			async:false
		}).responseText;
		
		if(retVal!=""){
			$.alert.open(retVal);
			return false;
		}
		document.usermasterForm.action="saveAdminDetails";
		document.usermasterForm.submit();
	}
</script>
</html>