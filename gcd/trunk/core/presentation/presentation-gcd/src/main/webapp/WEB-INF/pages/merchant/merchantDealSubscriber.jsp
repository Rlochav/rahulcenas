<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><c:if test="${cityDTO!=null}">Become a ${cityDTO.cityName} Merchant | Get City Dealz</c:if></title>

<script type="text/javascript" src="<c:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/rating.css'/>">
<link rel="shortcut icon" href="/resources/images/icon.png" />
<script type="text/javascript" src="<c:url value='/resources/js/CommonFunction.js'/>"></script>

<link href="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/css/alert.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/themes/light/theme.css'/>" rel="stylesheet" />
<script src="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/js/alert.js'/>"></script>

<script src="https://apis.google.com/js/platform.js" async defer></script>
<script src="http://connect.facebook.net/en_US/all.js"></script>
<script src="https://apis.google.com/js/client.js?onload=handleClientLoad" gapi_processed="true"></script>

<script src="<c:url value='/resources/js/googleLogin.js'/>"></script>
<script src="<c:url value='/resources/js/facebookLogin.js'/>"></script>
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
		<%@include file="../common/header1.jsp"%>
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

		<%@include file="../common/left1.jsp"%>
		<!-- Menu section end here -->


		<div class="cent center-both no-right">
			<form action="../searchQuery">
				<div style="height: 25px; width: 185px; background: rgb(37, 70, 87); border-radius: 6px;">
					<input name="query" class="searchfield" type="text" placeholder="Search" style="margin: 1px 0 0 4px;" />
				</div>
				<div style="margin: -25px 0px 0 186px;">
					<input type="submit" name="searchBtn" id="searchBtn" class="mediumBtn" value="Search" />
				</div>
			</form>
			<c:if test="${socialProfileDTO.emailId==null}">
				<div style="margin: -32px 0 0 454px;" id="facebookLoginBtn">
					<a href="javascript:void(0);" onclick="loginFacebook();"><img alt="facebook login" src="<c:url value='/resources/images/fb-login.png'/>" width="100" height="35" /></a>
				</div>
				<div style="margin-top: -41px; float: right;" id="googleSignInBtn">
					<a href="javascript:void(0);" id="googlelogin"><img alt="facebook login" src="<c:url value='/resources/images/gSignIn.png'/>" width="100" height="42" /></a>
				</div>
			</c:if>
			<div class="main-content">
				<div id="system-message-container"></div>
				<div id="title"></div>
				<div id="deal_content">
					<form:form id="displayDealz" name="displayDealz" action="loadAllDealz" cssClass="formStyle">
						<table style="border-right: 0px; border-left: 0px; width: 100%;" cellspacing="1" cellpadding="1">
							<tr>
								<td rowspan="2"><img src="../displayImage?image=${merchantDTO.logoImagePath}" height="150px" width="156px" class="border" alt="${merchantDTO.merchantName}" title="${merchantDTO.merchantName}"></td>
								<td colspan="2"><h2>${merchantDTO.merchantName}</h2>
									<div class="merchant-address">
										${merchantDTO.address1}, ${merchantDTO.city}, ${merchantDTO.state} ${merchantDTO.zipCode}<br>${merchantDTO.contactPhone}&nbsp;&nbsp;&nbsp;<a href="mailto:${merchantDTO.emailId}">${merchantDTO.emailId}</a><br> <a href="http://${merchantDTO.websiteUrl}">${merchantDTO.websiteUrl}</a>
									</div></td>
							</tr>
							<c:set var="merchantName" value="${merchantDTO.merchantName}" />
							<c:set var="merchantName1" value="${fn:split(merchantName, ' ')}" />
							<c:set var="merchantName2" value="${fn:join(merchantName1, '-')}" />
							<tr>
								<td><strong>Subscribe to merchant deals</strong><br> <c:if test="${sDto.twitterAccount!=null && sDto.twitterAccountchk==1}">
										<a href="${sDto.twitterAccount}" target="_blank"><img src="<c:url value='/resources/images/twitter-16x16.png'/>" /></a>&nbsp;
																</c:if> &nbsp;<a href="${sDto.facebookFanPage}" target="_blank"> <img src="<c:url value='/resources/images/facebook-16x16.png'/>" title="Facebook">
								</a> &nbsp;<a href="../subscribe/${merchantDTO.urlMerchant}-${merchantDTO.merchantId}" target="_blank"><img src="<c:url value='/resources/images/email-16x16.png'/>" title="Email"></a></td>
								<td><strong>Follow Merchant</strong><br>
									<table>
										<tr>
											<td><c:if test="${sDto.gPlusAccount!=null && sDto.gPlusAccountchk==1}">
													<a href="${sDto.gPlusAccount}" target="_blank"><img src="<c:url value='/resources/images/gplus.png'/>" /></a>&nbsp;
																	</c:if> <c:if test="${sDto.facebookFanPage!=null && sDto.facebookFanPagechk==1}">
													<a href="${sDto.facebookFanPage}" target="_blank"><img src="<c:url value='/resources/images/facebook-16x16.png'/>" /></a>&nbsp;
																	</c:if> <c:if test="${sDto.twitterAccount!=null && sDto.twitterAccountchk==1}">
													<a href="${sDto.twitterAccount}" target="_blank"><img src="<c:url value='/resources/images/twitter-16x16.png'/>" /></a>&nbsp;
																</c:if> <c:if test="${sDto.fourSquareAccount!=null && sDto.fourSquareAccountchk==1}">
													<a href="${sDto.fourSquareAccount}" target="_blank"><img src="<c:url value='/resources/images/foursquare-16x16.png'/>" /></a>&nbsp;
																	</c:if></td>
										</tr>
										<tr>
											<td><c:if test="${sDto.yelpAccount!=null && sDto.yelpAccountchk==1}">
													<a href="${sDto.yelpAccount}" target="_blank"><img src="<c:url value='/resources/images/yelp-16x16.png'/>" /></a>&nbsp;
																	</c:if> <c:if test="${sDto.flickerAccount!=null && sDto.flickerAccountchk==1}">
													<a href="${sDto.flickerAccount}" target="_blank"><img src="<c:url value='/resources/images/flicker.jpg'/>" width="16px" height="16px" /></a>&nbsp;
																	</c:if> <c:if test="${sDto.youtubeAccount!=null && sDto.youtubeAccountchk==1}">
													<a href="${sDto.youtubeAccount}" target="_blank"><img src="<c:url value='/resources/images/youtube-16x16.png'/>" /></a>&nbsp;
																	</c:if> <c:if test="${sDto.linkedinProfile!=null && sDto.linkedinProfilechk==1}">
													<a href="${sDto.linkedinProfile}" target="_blank"><img src="<c:url value='/resources/images//linkedin-16x16.png'/>" /></a>&nbsp;
																	</c:if></td>
										</tr>
										<tr>
											<td><c:if test="${sDto.tripAdvisorAccount!=null && sDto.tripAdvisorAccountchk==1}">
													<a href="${sDto.tripAdvisorAccount}" target="_blank"><img src="<c:url value='/resources/images/tripadvisor-icon.png'/>" width="16px" height="16px" /></a>&nbsp;
																	</c:if> <c:if test="${sDto.meetupAccount!=null && sDto.meetupAccountchk==1}">
													<a href="${sDto.meetupAccount}" target="_blank"><img src="<c:url value='/resources/images/meetup.jpg' />" width="16px" height="16px" /></a>&nbsp;
																	</c:if> <c:if test="${sDto.openTableAccount!=null && sDto.openTableAccountchk==1}">
													<a href="${sDto.openTableAccount}" target="_blank"><img src="<c:url value='/resources/images/opentable.jpg'/>" width="16px" height="16px" /></a>&nbsp;
																	</c:if> <c:if test="${sDto.pinterestAccount!=null && sDto.pinterestAccountchk==1}">
													<a href="${sDto.pinterestAccount}" target="_blank"><img src="<c:url value='/resources/images/pintrest-16x16.png'/>" /></a>&nbsp;
																	</c:if></td>
										</tr>
										<tr>
											<td><c:if test="${sDto.instagramAccount!=null && sDto.instagramAccountchk==1}">
													<a href="${sDto.instagramAccount}" target="_blank"><img src="<c:url value='/resources/images/Instagram-16x16.png'/>" /></a>&nbsp;
																	</c:if> <c:if test="${sDto.etsyAccount!=null && sDto.etsyAccountchk==1}">
													<a href="${sDto.etsyAccount}" target="_blank"><img src="<c:url value='/resources/images/etsy-16x16.png'/>" /></a>&nbsp;
																	</c:if> <c:if test="${sDto.tumblrAccount!=null && sDto.tumblrAccountchk==1}">
													<a href="${sDto.tumblrAccount}" target="_blank"><img src="<c:url value='/resources/images/square-tumblr-16x16.png'/>" /></a>&nbsp;
																	</c:if></td>
										</tr>
									</table></td>
							</tr>
							<tr>
								<td colspan="3"></td>
							</tr>
						</table>
						<h3 class="msg">
							<em>${merchantDTO.merchantName} GetCityDealz Deals How You Want Them</em>
						</h3>
						<table class="tableStyle" style="width: 95%; border: 1px solid #CCCCCC; border-collapse: collapse;" align="center">
							<tr>
								<td>First Name:<span style="color: red;">*</span></td>
								<td><input type="text" id="firstName" name="firstName" /></td>
							</tr>
							<tr>
								<td>Last Name:<span style="color: red;">*</span></td>
								<td><input type="text" id="lastName" name="lastName" /></td>
							</tr>
							<tr>
								<td>Email:<span style="color: red;">*</span></td>
								<td><input type="text" id="emailId" name="emailId" /></td>
							</tr>
							<tr align="right">
								<td>&nbsp;</td>
								<td><input type="button" value="Reset my Choices" id="resetBtn" onclick="resetAll();" /><input type="button" value="Send Me My Deals!" onclick="subscribeDealz();" /></td>
							</tr>
						</table>
						<br>
						<br>
						<br>
						<table class="tableStyle" style="width: 95%; border: 1px solid #CCCCCC; border-collapse: collapse;" align="center">
							<tr>
								<th align="center">Follow Us</th>
							</tr>
							<tr>
								<td align="center"><a href="http://www.facebook.com/GetCityDealz" target="_blank"><img src="<c:url value='/resources/images/facebook-24x24.png'/>" border="0" /></a> &nbsp; <a href="http://www.twitter.com/GetCityDealz" target="_blank"><img
										src="<c:url value='/resources/images/twitter-24x24.png'/>" border="0" /></td>
							</tr>
						</table>
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
function subscribeDealz() {
	if (trimString($("#firstName").val()) == "") {
		appFocus($("#firstName"));
		$.alert.open('error', 'First Name is Missing.');
		
		return false;
	}

	if (trimString($("#lastName").val()) == "") {
		appFocus($("#lastName"));
		$.alert.open('error', 'Last Name is Missing.');
	
		return false;
	}
	if (trimString($("#emailId").val()) == "") {
		appFocus($("#emailId"));
		$.alert.open('error', 'e-mail is Missing.');
		return false;
	}
	
	if (trimString($("#emailId").val()) != "") {
		var emailaddressVal = $("#emailId").val();
		var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		var test_email = emailReg.test(emailaddressVal);
		if (test_email == false) {
			$.alert.open('error', 'e-mail is not valid.');
			appFocus($("#emailId"));
			return false;
		}
	}
	
	var retVal = $.ajax({
		url : "subscribeDealz",
		type : "POST",
		global : false,
		data : {
			merchantId : ${merchantDTO.merchantId},
			firstName : $("#firstName").val(),
			lastName : $("#lastName").val(),
			emailId : $("#emailId").val()
		},
		dataType : "json",
		async : false
	}).responseText;

	

	var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
	if (obj != null) {
		if (obj.jsonMessage == null || obj.jsonMessage == ""){
			resetAll();
			alert("Dealz Subscribed sucessfully.");
		}
		else {
			alert(obj.jsonMessage)
		}
	} else {
		$("#error").html("Error");
	} 
}

function resetAll(){
	$("#firstName").val("");
	$("#lastName").val("");
	$("#emailId").val("");
}

</script>
</html>
