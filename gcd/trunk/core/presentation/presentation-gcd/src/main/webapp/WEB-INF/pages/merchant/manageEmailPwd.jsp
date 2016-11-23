<%@include file="../common/taglibs.jsp"%>
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
				<div id="system-message-container" style="display: none;">
					<dl id="system-message">
						<dt class="message">Message</dt>
						<dd class="message message">
							<ul>
								<li><span id="message"></span></li>
							</ul>
						</dd>
					</dl>
				</div>
				<div id="title">Manage Email and Password</div>
				<br>
				<h3 class="msg">
					<em>Hi There ${SESSION_ATTR_USER_INFO.userName}, Edit your password or email address</em>
				</h3>
				<div class="media-mng">
					<div class="items">
						<form id="member-profile" action="/admin?task=profile.save" method="post" class="form-validate" enctype="multipart/form-data" onsubmit="return myValidate(this);">
							<table cellpadding="0" cellspacing="0">
								<tbody>
									<tr>
										<td></td>
										<td><input type="hidden" name="jform[id]" id="jform_id" value="876"></td>
									</tr>
									<tr>
										<td><label id="jform_name-lbl" for="jform_name" class="hasTip required" title="">Name:<span class="star">&nbsp;*</span></label></td>
										<td><input type="text" class="mInput" name="mName" id="mName" value="${merchantDTO.merchantName}" required /></td>
									</tr>
									<tr>
										<td><label id="jform_username-lbl" for="jform_username" class="hasTip" title="">Username:</label></td>
										<td><c:out value="${merchantDTO.userId}"></c:out></td>
									</tr>
									<tr>
										<td><label id="jform_password1-lbl" for="jform_password1" class="hasTip" title="">Password:</label> <span class="optional">(optional)</span></td>
										<td><input type="password" name="mPassword" id="mPassword" class="mInput" /></td>
									</tr>
									<tr>
										<td><label id="jform_password2-lbl" for="jform_password2" class="hasTip" title="">Confirm Password:</label> <span class="optional">(optional)</span></td>
										<td><input type="password" name="mCPassword" id="mCPassword" class="mInput" /></td>
									</tr>
									<tr>
										<td><label id="jform_email1-lbl" for="jform_email1" class="hasTip required" title="">Email Address:<span class="star">&nbsp;*</span></label></td>
										<td><input type="text" class="mInput" name="mEmailId" id="mEmailId" value="${merchantDTO.emailId}" required /></td>
									</tr>
									<tr>
										<td><label id="jform_email2-lbl" for="jform_email2" class="hasTip required" title="">Confirm email Address:<span class="star">&nbsp;*</span></label></td>
										<td><input type="text" name="mCEmailId" id="mCEmailId" value="${merchantDTO.emailId}" class="mInput" required /></td>
									</tr>
									<tr>
										<td></td>
										<td class="al-right button2"><input type="button" value="Update" onclick="updateMyInfo();"><input type="button" value="Reset" onclick="resetAll();"></td>
									</tr>
								</tbody>
							</table>
							<div>
								<input type="hidden" name="option" value="com_users"> <input type="hidden" name="task" value="profile.save"> <input type="hidden" name="255fb4539ed80c8e6ee94575a9f0e775" value="1">
							</div>
						</form>
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
</body>
<script type="text/javascript">
$(function(){
	var retVal = $.ajax({
		url : "jsonGetHotDealz",
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
			sliderImage +='<a href="merchant/${merchantName2}-'+bannerArr[i].merchantId+'"><img src="displayImage?image='+bannerArr[i].imagePath+'" style="height:170px;" class="wrap" id="wrap'+(i+1)+'" style="display: none;"/></a>';
		}
		$("#slider").append(sliderImage);
	}
});
	function updateMyInfo() {
		if (trimString($("#mName").val()) == "") {
			$("#system-message-container").show();
			$("#message").html('Merchant Name is Mandatory.');
		}

		if (trimString($("#mPassword").val()).length > 0) {
			if (trimString($("#mCPassword").val()) == "") {
				$("#system-message-container").show();
				$("#message").html('Confirm Password is Mandatory.');
				return false;
			}
			if (trimString($("#mPassword").val()) != trimString($("#mCPassword")
					.val())) {
				$("#system-message-container").show();
				$("#message").html('Password does not match with Confirm Password.');
				return false;
			}
		}

		if (trimString($("#mEmailId").val()) != "") {
			var emailaddressVal = $("#mEmailId").val();
			var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
			var test_email = emailReg.test(emailaddressVal);
			if (test_email == false) {
				$("#system-message-container").show();
				$("#message").html('e-Mail address is not valid.');
				return false;
			}
		}

		if (trimString($("#mEmailId").val()).length > 0) {
			if (trimString($("#mCEmailId").val()) == "") {
				$("#system-message-container").show();
				$("#message").html('Confirm e-Mail is Mandatory.');
				return false;
			}
			if (trimString($("#mEmailId").val()) != trimString($("#mCEmailId")
					.val())) {
				$("#system-message-container").show();
				$("#message").html('e-Mail does not match with Confirm e-Mail.');
				return false;
			}
		}

		var retVal = $.ajax({
			url : "updateEmailPwdMerchant",
			type : "POST",
			global : false,
			data : {
				merchantName : $("#mName").val(),
				mPassword : $("#mPassword").val(),
				mEmailId : $("#mEmailId").val()
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);

		if (obj != null) {
			if (obj.jsonMessage != null) {
				$("#system-message-container").show();
				$("#message").html(obj.jsonMessage);
			} else {
				$("#system-message-container").show();
				$("#message").html('Information updated successfully.');
			}
		} else {
			$("#system-message-container").show();
			$("#message").html('Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator.');
		}
	}
</script>
</html>