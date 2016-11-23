<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="common.html.000001"></spring:message></title>

<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/rating.css'/>">
<link rel="shortcut icon" href="resources/images/icon.png" />
<link href="<c:url value='resources/css/media.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/resources/js/CommonFunction.js'/>"></script>
<link href="<c:url value='resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='resources/js/js-image-slider.js'/>"></script>

<script src="http://connect.facebook.net/en_US/all.js"></script>
<script>
	window.fbAsyncInit = FB.init({
		appId : '1499701620271988',
		status : true,
		cookie : true,
		xfbml : true
	});
</script>

<script src="https://apis.google.com/js/client.js?onload=handleClientLoad" gapi_processed="true"></script>

<script src="<c:url value='resources/js/googleLogin.js'/>"></script>
<script src="<c:url value='resources/js/facebookLogin.js'/>"></script>
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
				<form:form action="doLogin" method="POST" commandName="merchantMaster">
					<c:set var="userIdErr">
						<form:errors path='userId' />
						<form:errors path='password' />
					</c:set>
					<c:if test="${not empty userIdErr}">
						<div id="system-message-container">
							<dl id="system-message">
								<dt class="error">Error</dt>
								<dd class="error message">
									<ul>
										<li><form:errors path="userId"></form:errors> <form:errors path="password"></form:errors></li>
									</ul>
								</dd>
							</dl>
						</div>
					</c:if>
					<div id="title">Merchant Login</div>
					<div class="login">
						<fieldset>
							<div class="login-fields">
								<label id="username-lbl" for="username" class="">User Name</label>
								<form:input path="userId" />
							</div>
							<div class="login-fields">
								<label id="password-lbl" for="password" class="">Password</label>
								<form:password path="password" />
							</div>
							<button type="submit" class="button">Log in</button>
						</fieldset>
				</form:form>
			</div>
			<div>
				<ul>
					<li><a href="merchant/reset?query=password"> Forgot your password?</a></li>
					<li><a href="merchant/remind?query=username"> Forgot your username?</a></li>
				</ul>
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
	$(function() {
		if ('<c:out value="${SESSION_ATTR_USER_INFO.userIndex}"/>'.length > 0)
			window.location.href = "merchantDashboard";
		$("#password").bind('keydown', function(e) {
			if (e) {
				var keyCode = (e.keyCode) ? e.keyCode : ((e.charCode) ? e.charCode : e.which);

				if (keyCode === 13) {
					doLogin();
				}
			}
		});
	});
</script>
</html>
