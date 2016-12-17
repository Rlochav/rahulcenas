<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="common.html.000001"></spring:message></title>

<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>">
<link rel="shortcut icon" href="resources/images/icon.png" />
<link href="<c:url value='resources/css/media.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/resources/js/CommonFunction.js'/>"></script>
<link href="<c:url value='resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='resources/js/js-image-slider.js'/>"></script>

</head>

<body>
	<%@include file="../common/telliumTags.jsp"%>
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
			<div class="main-content">
				<form:form action="adminDoLogin" method="POST" commandName="userMaster">
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
					<div id="title">Admin Login</div>
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
					<li><a href="admin/reset?query=password"> Forgot your password?</a></li>
					<li><a href="admin/remind?query=username"> Forgot your username?</a></li>
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
		if ('<c:out value="${message}"/>'.length > 0) {
			$.alert.open('error', '<c:out value="${message}"/>');
		}
		if ('<c:out value="${SESSION_ATTR_USER_INFO.userIndex}"/>'.length > 0)
			window.location.href = "component/adminDashboard";

		$("#password").bind('keydown', function(e) {
			if (e) {
				var keyCode = (e.keyCode) ? e.keyCode : ((e.charCode) ? e.charCode : e.which);

				if (keyCode === 13) {
					adminDoLogin();
				}
			}
		});
	});

	function adminDoLogin() {
		if ($("#userId").val() == "" || ($("#userId").val()).length == 0) {
			appFocus($("#userId"));
			$.alert.open('error', 'User ID can not be empty.');
			return false;
		}

		if ($("#password").val() == "" || ($("#password").val()).length == 0) {
			appFocus($("#password"));
			$.alert.open('error', 'Password can not be empty.');
			return false;
		}
		document.adminLoginForm.action = 'adminDoLogin';
		document.adminLoginForm.submit();
	}
</script>
</html>
