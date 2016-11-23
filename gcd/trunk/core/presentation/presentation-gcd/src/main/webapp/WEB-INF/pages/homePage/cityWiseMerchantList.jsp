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
				<div id="title">NEW ORLEANS MERCHANT LISTING</div>
				<div id="deal_content">
					<form:form id="displayDealz" name="displayDealz" action="loadAllDealz" cssClass="formStyle">
						<table class="tableStyle" style="width: 100%; border-collapse: collapse; margin: 15px;">
							<tbody>
								<tr>
									<td valign="top" width="33%">
										<h3>
											<span style="text-decoration: underline;"><strong>A-H</strong></span>
										</h3> <c:forEach var="mDtoAH" items="${mDtoAH}">
											<p class="MsoNormal">
												<c:set var="merchantName" value="${mDtoAH.merchantName}" />
												<c:set var="merchantName1" value="${fn:split(merchantName, ' ')}" />
												<c:set var="merchantName2" value="${fn:join(merchantName1, '-')}" />
												<a href="http://${mDtoAH.cityText}<spring:message code="common.city.domain"></spring:message>/merchant/${mDtoAH.urlMerchant}">${mDtoAH.merchantName}</a>
											</p>
										</c:forEach>
									</td>
									<td valign="top" width="33%">
										<h3>
											<span style="text-decoration: underline;"><strong>I-P</strong></span>
										</h3> <c:forEach var="mDtoIP" items="${mDtoIP}">
											<p>
												<c:set var="merchantName" value="${mDtoIP.merchantName}" />
												<c:set var="merchantName1" value="${fn:split(merchantName, ' ')}" />
												<c:set var="merchantName2" value="${fn:join(merchantName1, '-')}" />
												<a href="http://${mDtoIP.cityText}<spring:message code="common.city.domain"></spring:message>/merchant/${mDtoIP.urlMerchant}" target="_self">${mDtoIP.merchantName}</a>
											</p>
										</c:forEach>
									</td>
									<td valign="top" width="33%">
										<h3>
											<span style="text-decoration: underline;"><strong>Q-Z</strong></span>
										</h3> <c:forEach var="mDtoQZ" items="${mDtoQZ}">
											<p>
												<c:set var="merchantName" value="${mDtoQZ.merchantName}" />
												<c:set var="merchantName1" value="${fn:split(merchantName, ' ')}" />
												<c:set var="merchantName2" value="${fn:join(merchantName1, '-')}" />
												<a href="http://${mDtoQZ.cityText}<spring:message code="common.city.domain"></spring:message>/merchant/${mDtoQZ.urlMerchant}" target="_self">${mDtoQZ.merchantName}</a>
											</p>
										</c:forEach>

										<table>
											<tr>
												<td valign="top" width="33%">
													<h3>
														<span style="text-decoration: underline;"><strong>0-9 & Special Characters</strong></span>
													</h3> <c:forEach var="mDtoSpecial" items="${mDtoSpecial}">
														<p>
															<c:set var="merchantName" value="${mDtoSpecial.merchantName}" />
															<c:set var="merchantName1" value="${fn:split(merchantName, ' ')}" />
															<c:set var="merchantName2" value="${fn:join(merchantName1, '-')}" />
															<a href="merchant/${mDtoSpecial.urlMerchant}" target="_self">${mDtoSpecial.merchantName}</a>
														</p>
													</c:forEach>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</tbody>
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
</html>
