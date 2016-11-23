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
</head>

<body>
	<%@include file="../common/telliumTags.jsp"%>
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
			<div class="main-content">
				<div class="reset">
					<form:form action="${formAction}" method="POST" commandName="userMaster">
						<c:set var="userIdErr">
							<form:errors path='emailId' />
						</c:set>
						<c:if test="${not empty userIdErr}">
							<div id="system-message-container">
								<dl id="system-message">
									<dt class="error">Error</dt>
									<dd class="error message">
										<ul>
											<li><form:errors path="emailId"></form:errors> <form:errors path="password"></form:errors></li>
										</ul>
									</dd>
								</dl>
							</div>
						</c:if>
						<p>Please enter the email address for your account. A verification code will be sent to you. Once you have received the verification code, you will be able to choose a new password for your account.</p>
						<fieldset>
							<dl>
								<dt>
									<label id="jform_email-lbl" for="jform_email" class="hasTip required" title="">Email Address:<span class="star">&nbsp;*</span></label>
								</dt>
								<dd>
									<form:input path="emailId" />
								</dd>
								<dt></dt>
								<dd></dd>
							</dl>
						</fieldset>
						<div>
							<button type="submit" class="button">Submit</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<!-- Slideshow section end here -->
		<!--show right div only if user not logged in -->
		<%@include file="../common/right1.jsp"%>
		<!-- Main text div end here -->
		<%@include file="../common/bottom.jsp"%>
	</div>
	<!-- wrapper end here -->
</body>
<script type="text/javascript">
	
</script>
</html>
