<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="common.html.000001"></spring:message></title>

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
				<div id="title">
					<c:if test="${cityDTO!=null}">Become a ${cityDTO.cityName} Merchant | Get City Dealz</c:if>
				</div>
				<div id="deal_content">
					<form:form id="userLoginForm" name="userLoginForm" modelAttribute="chooseCityForm">
						<h3 class="msg">

							<div class="errorDiv" style="position: absolute; right: 0px; top: 10px;">
								<label class="error" id="error"></label>
							</div>
							<table class="login_box">
								<tr>
									<td>Select a city:</td>
									<td><form:select path="path1" cssClass="mSelect" onchange="redirectToCityLink();">
											<form:option value="-1" label="--Select--"></form:option>
											<form:options items="${cityMap}" />
										</form:select></td>
								</tr>
							</table>
						</h3>


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
	function redirectToCityLink() {
		var q = '${q}';
		if ($("#path1").val() == "-1")
			return false;
		window.location.href = "redirectToGcdCity?cityId=" + $("#path1").val() + "&q=" + q;
	}
</script>
</html>
