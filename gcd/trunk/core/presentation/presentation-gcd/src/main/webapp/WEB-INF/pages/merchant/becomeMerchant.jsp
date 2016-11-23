<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><c:if test="${cityDTO!=null}">Become a ${cityDTO.cityName} Merchant | Get City Dealz</c:if></title>

<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/template.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/rating.css'/>">
<link rel="shortcut icon" href="resources/images/icon.png" />
<script type="text/javascript" src="<c:url value='resources/js/CommonFunction.js'/>"></script>

<link href="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/css/alert.css'/>" rel="stylesheet" />
<link href="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/themes/light/theme.css'/>" rel="stylesheet" />
<script src="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/js/alert.js'/>"></script>

<script src="https://apis.google.com/js/platform.js" async defer></script>
<script src="http://connect.facebook.net/en_US/all.js"></script>
<script src="https://apis.google.com/js/client.js?onload=handleClientLoad" gapi_processed="true"></script>

<script src="<c:url value='resources/js/googleLogin.js'/>"></script>
<script src="<c:url value='resources/js/facebookLogin.js'/>"></script>
<script>
	window.fbAsyncInit = FB.init({
		appId : '1499701620271988',
		status : true,
		cookie : true,
		xfbml : true
	});
</script>
</head>
<body>
	<%@include file="../common/telliumTags.jsp"%>
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=1499701620271988&version=v2.0";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
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
			<form action="searchQuery">
				<div style="height: 25px; width: 185px; background: rgb(37, 70, 87); border-radius: 6px;">
					<input name="query" class="searchfield" type="text" placeholder="Search" style="margin: 1px 0 0 4px;" />
				</div>
				<div style="margin: -25px 0px 0 186px;">
					<input type="submit" name="searchBtn" id="searchBtn" class="mediumBtn" value="Search" />
				</div>
			</form>
			<c:if test="${socialProfileDTO.emailId==null}">
				<div style="margin: -32px 0 0 454px;" id="facebookLoginBtn">
					<a href="javascript:void(0);" onclick="loginFacebook();"><img alt="facebook login" src="<c:url value='resources/images/fb-login.png'/>" width="100" height="35" /></a>
				</div>
				<div style="margin-top: -41px; float: right;" id="googleSignInBtn">
					<a href="javascript:void(0);" id="googlelogin"><img alt="facebook login" src="<c:url value='resources/images/gSignIn.png'/>" width="100" height="42" /></a>
				</div>
			</c:if>
			<div class="main-content">
				<div id="system-message-container"></div>
				<div id="title">BECOME A MERCHANT</div>
				<div id="deal_content">
					<form:form id="displayDealz" name="displayDealz" action="loadAllDealz" cssClass="formStyle">
						<div id="system-message-container"></div>

						<form:form id="becomeMerchant" name="becomeMerchant">
							<div style="margin-bottom: 10%;">Interested in becoming a Get City Dealz Merchant? Fill out the form below and we'll contact you about becoming one of our newest New Orleans merchants!</div>
							<div class="profile">
								<div class="merchantRegForm">
									<div>
										<div>Fields marked with ( ! ) are required.</div>
										<table style="width: 100%;">
											<tr>
												<td><span><label id="bussinessName_lbl">Business Name</label></span>&nbsp;<label>( ! )</label></td>
												<td><input type="text" name="bussinessName" id="bussinessName" class="mInput" /></td>
											</tr>
											<tr>
												<td><span><label id="typeOfBusiness_lbl">Type of Business</label></span>&nbsp;<label class="required_field">( ! )</label></td>
												<td><input type="text" name="typeOfBusiness" id="typeOfBusiness" class="mInput" /></td>
											</tr>
											<tr>
												<td><span><label id="contactName_lbl">Contact Name</label></span>&nbsp;<label>( ! )</label></td>
												<td><input type="text" name="contactName" id="contactName" class="mInput" /></td>
											</tr>
											<tr>
												<td><span><label id="emailId_lbl">Email</label></span>&nbsp;<label class="required_field">( ! )</label></td>
												<td><input type="text" name="emailId" id="emailId" class="mInput"></td>
											</tr>
											<tr>
												<td><span><label id="phone_lbl">Phone</label></span>&nbsp;</td>
												<td><input type="text" name="phone" id="phone" maxlength="15" class="mInput" /></td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><input type="checkbox" name="sendToSender" id="sendToSender" class="checkbox" />&nbsp;<span><label for="aics_send_to_sender">Send a copy of this message to yourself</label></span></td>
											</tr>
											<tr>
												<td><div id="div_captcha_info">Please enter the following security code:</div></td>
												<td><div id="div_captcha_img">
														<div id="div_captcha_img_3" style="width: 300px; height: 55px;">
															<img id="captcha" src="<c:url value="simpleCaptcha.jpg" />" width="150"> <label id="tempcaptcha"></label>
														</div>
													</div> <a style="cursor: pointer;" onclick="reloadCapcha();">Not readable? Change text.</a>
													<div style="margin-top: 5px;" id="div_captcha_code">
														<input type="text" name="answer" id="answer">
													</div></td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><div style="margin-top: 5px;" id="div_captcha_code">
														<input type="button" value="Send" id="sendMerchantInfo" onclick="sendRequest();">
													</div></td>
											</tr>
										</table>
									</div>
								</div>
							</div>
						</form:form>
					</form:form>
				</div>
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
	function sendRequest() {
		if (trimString($("#bussinessName").val()) == "") {
			appFocus($("#bussinessName"));
			$.alert.open('error', 'Bussiness Name is Missing.');
			return false;
		}
		if (trimString($("#typeOfBusiness").val()) == "") {
			appFocus($("#typeOfBusiness"));
			$.alert.open('error', 'Type Of Business is Missing.');
			return false;
		}
		if (trimString($("#contactName").val()) == "") {
			appFocus($("#contactName"));
			$.alert.open('error', 'Contact Name is Missing.');
			return false;
		}
		if (trimString($("#emailId").val()) == "") {
			appFocus($("#emailId"));
			$.alert.open('error', 'Email Id is Missing.');
			return false;
		}
		if (trimString($("#emailId").val()) != "") {
			var emailaddressVal = $("#emailId").val();
			var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
			var test_email = emailReg.test(emailaddressVal);
			if (test_email == false) {
				appFocus($("#emailId"));
				$.alert.open('error', 'e-Mail Address is invalid.');
				return false;
			}
		}
		if (trimString($("#phone").val()) == "") {
			appFocus($("#phone"));
			$.alert.open('error', 'Phone is Missing.');
			return false;
		}
		if (!isNaN($("#phone").val())) {
		} else {
			appFocus($("#phone"));
			$.alert.open('error', 'Phone is not valid.');
			return false;
		}
		if (trimString($("#answer").val()) == "") {
			appFocus($("#answer"));
			$.alert.open('error', 'Captcha is Missing.');
			return false;
		}

		var retVal = $.ajax({
			url : "sendBecomeMerchantRequest",
			type : "POST",
			global : false,
			data : {
				bussinessName : $("#bussinessName").val(),
				typeOfBusiness : $("#typeOfBusiness").val(),
				contactName : $("#contactName").val(),
				emailId : $("#emailId").val(),
				phone : $("#phone").val(),
				sendToSender : $("#sendToSender").is(':checked') == true ? "1" : "0",
				answer : $("#answer").val()
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
		if (obj != null) {
			$.alert.open('error', obj.jsonMessage);
			if (obj.jsonMessage != "Captcha is invalid.") {
				resetAll();
				window.location.href = "index"
			}

		} else {
			$.alert.open('error', 'Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator.');
		}
	}

	function resetAll() {
		$("#bussinessName").val("");
		$("#typeOfBusiness").val("");
		$("#contactName").val("");
		$("#emailId").val("");
		$("#phone").val("");
		$("#answer").val("");
	}

	function reloadCapcha() {
		$("#captcha").remove();
		$("#tempcaptcha").html('<img id="captcha" src="<c:url value="simpleCaptcha.jpg" />" width="150">');
	}
</script>
</html>
