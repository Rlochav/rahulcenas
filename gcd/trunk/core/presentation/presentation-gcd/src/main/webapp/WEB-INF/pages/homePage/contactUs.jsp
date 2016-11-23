<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Contact Get City Dealz</title>

<script type="text/javascript" src="<c:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/rating.css'/>">
<link rel="shortcut icon" href="/resources/images/icon.png" />
<link href="<c:url value='/resources/css/media.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/resources/js/CommonFunction.js'/>"></script>
<link href="<c:url value='/resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='/resources/js/js-image-slider.js'/>"></script>

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
	<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=1499701620271988&version=v2.0";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
	<div id="wrapper">
		<%@include file="../common/header4.jsp"%>
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
				<div id="title">CONTACT GET CITY DEALZ</div>
				<h3 class="msg"></h3>
				<div id="deal_content">
					<form:form id="displayDealz" name="displayDealz" action="loadAllDealz" cssClass="formStyle">
						<div id="system-message-container"></div>
						<p>
							You can contact GetCityDealz.com via the web either through the contact form below or by emailing "
							<script type="text/javascript">
									<!--
										var prefix = '&#109;a' + 'i&#108;'
												+ '&#116;o';
										var path = 'hr' + 'ef' + '=';
										var addy12689 = 'c&#111;nt&#97;ct'
												+ '&#64;';
										addy12689 = addy12689
												+ 'g&#101;tc&#105;tyd&#101;&#97;lz'
												+ '&#46;' + 'c&#111;m';
										document
												.write('<a ' + path + '\'' + prefix + ':' + addy12689 + '\'>');
										document.write(addy12689);
										document.write('<\/a>');
										//-->\n
									</script>
							<a href="mailto:contact@getcitydealz.com">contact@getcitydealz.com</a>
							<script type="text/javascript">
									<!--
										document
												.write('<span style=\'display: none;\'>');
									//-->
									</script>
							<span style="display: none;">This email address is being protected from spambots. You need JavaScript enabled to view it. <script type="text/javascript">
										<!--
											document.write('</');
											document.write('span>');
										//-->
										</script>
							</span>" .<br> <br>
						</p>
						<p>
							<span style="text-decoration: underline;">New Orleans Office Mailing Address:<br>
							</span><span style="line-height: 1.3em;">815 Saint Ann Street #3<br>
							</span><span style="line-height: 1.3em;">New Orleans, LA 70116</span>
						</p>
						<p class="MsoNormal">&nbsp;</p>
						<p>
							<span style="text-decoration: underline;">Financial Office Mailing Address:</span> <br> GetCityDealz.com<br>1333A North Ave. &nbsp;Suite 533&nbsp;<br>New Rochelle, NY 10804
						</p>
						<p></p>
						<div class="plg_contactus_main_div" id="plg_contactus_12">
							<center>
								<form>
									<fieldset style="width: 100" align="left">
										<legend>Contact information</legend>
										<table class="tableStyle">
											<tr>
												<td><div align="right">Name:</div></td>
												<td><input type="text" name="ContactName" id="ContactName" class="mInput"></td>
											</tr>
											<tr>
												<td><div align="right">Email:</div></td>
												<td><input type="textfield" name="email"></td>
											</tr>
											<tr>
												<td><div align="right">Phone:</div></td>
												<br>
												<td><input type="text" name="phone" id="phone"></td>
											</tr>
											<tr>
												<td><div align="right">Subject:</div></td>
												<br>
												<td><select class="mSelect">
														<option value>Select Subject</option>
														<option value="Billing Question">Billing Question</option>
												</select></td>
											</tr>
											<tr>
												<td><div align="right">Message:</div> <input name="message" type="hidden" id="recipient" value="contact@example.com" /></td>
												<td><textarea name="comments" id="comments" cols="20" rows="5" class="labelBox"></textarea></td>
											</tr>

											<tr>
												<td colspan="2"><script type="text/javascript" src="http://www.google.com/recaptcha/api/challenge?k=6Ldbwc8SAAAAAOA8RYOgAI6OHLU3OLc3w4UNGbcu">
															
														</script>
													<noscript>
														<iframe src="http://www.google.com/recaptcha/api/challenge?k=6Ldbwc8SAAAAAOA8RYOgAI6OHLU3OLc3w4UNGbcu" height="300" width="300" frameborder="0"></iframe>
														<br>
														<textarea name="recaptcha_challenge_field" rows="3" cols="20"></textarea>
														<input type="hidden" name="recaptcha_response_field" value="manual_challenge">
													</noscript></td>
											</tr>
											<tr>
												<td><div align="right">
														<input type="checkbox" name="email_copy" id="contact_email_copy" value="1">
													</div></td>
												<td>Send copy to yourself</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><input type="button" value="Send Email" id="send mail" class="submit" onclick="myfunction()" /></td>
											</tr>
										</table>
									</fieldset>
								</form>
							</center>
							<br>
						</div>
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
			sliderImage +='<a href="merchant/${merchantName2}-'+bannerArr[i].merchantId+'"><img src="../displayImage?image='+bannerArr[i].imagePath+'" style="height:170px;" class="wrap" id="wrap'+(i+1)+'" style="display: none;"/></a>';
		}
		$("#slider").append(sliderImage);
	}
});

function loginFacebook() {
    FB.login(function(response) {
        if (response.authResponse) {
            // connected
        testAPI();
        } else {
            // cancelled
        }
    }, { scope: 'email' });
    }

function testAPI() {

    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
        console.log('Good to see you, ' + response.name + '.' + ' Email: ' + response.email + ' Facebook ID: ' + response.id);
        var strName = (response.name).split(" ");
        var fName = strName[0];
        var lName;
        if(strName.length>1)
        	lName = strName[1];
        doSubscribeViaChannel(fName,lName,response.email);
        $("#facebookLoginBtn").remove();
		$("#googleSignInBtn").remove();
    });
}

function validate(){
	if($(".searchfield").val()=='')
		return false;
	event.preventDefault();
}

function doSubscribeViaChannel(fName,lName,emailId){
	$.alert.open('confirm', 'Thanks for signing in!  Would you like to subscribe to local deal alerts now?', function(button) {
		if (button == 'yes') {
			window.location.href="http://neworleans.gcddev.com/subscribe?fName="+fName+"&lName="+lName+"&email="+emailId;
		}
		if (button == 'no') {
			var retVal = $.ajax({
				url : "../socialDetailsConsumer",
				global : false,
				type : "POST",
				data : {
					fName : fName,
					lName : lName,
					emailId:emailId
				},
				dataType : "json",
				async : false
			}).responseText;
		}
	});
}
</script>
</html>
