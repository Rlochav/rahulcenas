<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Get City Dealz Privacy Policy</title>

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
				<div style="margin: -32px 0 0 479px;" id="facebookLoginBtn">
					<a href="javascript:void(0);" onclick="loginFacebook();"><img alt="facebook login" src="<c:url value='resources/images/fb-login.png'/>" width="60" height="32" /></a>
				</div>
				<div style="margin-top: -35px; float: right;" id="googleSignInBtn">
					<c:set var="req" value="${pageContext.request}" />
					<c:set var="baseURL" value="${req.scheme}://${req.serverName}" />
					<c:if test="${baseURL=='http://gcddev.com'}">
						<span id="signinButton"> <span class="g-signin" data-callback="signinCallback" data-clientid="444894883269-1karm3bk3t1jvrfvq3j2l8e7om2735a0.apps.googleusercontent.com" data-cookiepolicy="single_host_origin" data-requestvisibleactions="http://schema.org/AddAction"
							data-scope="https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email"> </span>
						</span>
					</c:if>

					<c:if test="${baseURL=='http://neworleans.gcddev.com'}">
						<span id="signinButton"> <span class="g-signin" data-callback="signinCallback" data-clientid="409160420325-ub8u1td20i4it7fi1mi2hcfvi77ao32p.apps.googleusercontent.com" data-cookiepolicy="single_host_origin" data-requestvisibleactions="http://schema.org/AddAction"
							data-scope="https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email"> </span>
						</span>
					</c:if>

					<script src="https://apis.google.com/js/client.js?onload=OnLoadCallback"></script>
					<script type="text/javascript">
					function signinCallback(authResult) {
					  if (authResult['status']['signed_in']) {
					    document.getElementById('signinButton').setAttribute('style', 'display: none');
					    gapi.client.setApiKey('AIzaSyBD1Gq-gv7pQCvhGROVLapuM0HikN-0st4');
						
					    var retVal = $.ajax({
							url : "https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token="+authResult.access_token,
							type : "GET",
							global : false,
							dataType : "json",
							async : false
						}).responseText;
					   
					    retVal = jQuery.parseJSON(retVal);
					    if(retVal!=null){
					    	console.log(retVal.given_name+" "+retVal.family_name+" "+retVal.email);
					    	doSubscribeViaChannel(retVal.given_name,retVal.family_name,retVal.email);
					    	$("#facebookLoginBtn").remove();
					    }
					  } else {
					    console.log('Sign-in state: ' + authResult['error']);
					  }
					}
				</script>
				</div>
			</c:if>
			<div class="main-content">
				<div id="system-message-container"></div>
				<div id="title">GET CITY DEALZ PRIVACY POLICY</div>
				<h3 class="msg"></h3>
				<div id="deal_content">
					<form:form id="displayDealz" name="displayDealz" action="loadAllDealz" cssClass="formStyle">
						<div id="system-message-container"></div>

						<p>This policy covers how we at GetCityDealz.com will use your personal information. We take your privacy seriously and will take all measures to protect your personal information.</p>
						<p>Any personal information received will only be used to fill your subscription. We will not sell or redistribute your information to any third party company or individuals. Your information will be utilized to power your merchant information on the site and for GetCityDealz.com to
							communicate with you.</p>
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
