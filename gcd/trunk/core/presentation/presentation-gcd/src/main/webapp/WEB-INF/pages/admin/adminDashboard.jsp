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
		<%@include file="../common/header3.jsp"%>
		<div class="tagline">
			<div class="moduletable">
				<div class="custom">
					<p class="MsoNormal">
						<strong><spring:message code="common.html.000002"></spring:message></strong>
					</p>
				</div>
			</div>
		</div>
		<div class="cent  no-right">
			<div class="main-content">
				<div id="system-message-container"></div>
				<div id="dashboard-area">
					<div id="title">Get City Dealz Admin Dashboard</div>
					<div id="menu">
						<ul>
							<li><a href="subscriptionLevel"><span>Subscription</span></a></li>
							<li><a href="categories"><span>Categories &amp; Sub Categories</span></a></li>
							<li><a href="salesPeople"><span>Sales People</span></a></li>
							<li><a href="cities"><span>Cities</span></a></li>
							<li><a href="icons"><span> Feature Icons</span></a></li>
							<li><a href="socialLinks"><span>GCD Social</span></a></li>
							<li><a href="gcd-meta-handler"><span>Site Content Mgt</span></a></li>
							<li><a href="adminUsers"><span>Site Admins</span></a></li>
						</ul>
					</div>
					<div align="center">
						<strong><i>Manage Merchants, Categories, Neighborhoods, Deals, Hot Deals &amp; Mobile</i> <dtrong></dtrong></strong>
					</div>
					<strong> <br>
						<h3 class="msg">
							<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
							</em>
						</h3> <br>
						<div id="form-field">
							<form:form id="userLoginForm" name="userLoginForm" action="merchantmgmt" modelAttribute="chooseCityForm">
								<div style="background-color: #f4f4f4; padding: 10px; border: 1px solid #E6E6E6">
									<table width="50%" border="0" cellspacing="0" cellpadding="0" align="center">
										<tr>
											<td width="19%"><strong>Select a City</strong></td>
											<td width="81%"><form:select path="path1" cssClass="mSelect" id="citieslist" onchange="this.form.submit();">
													<form:option value="-1" label="Choose A City"></form:option>
													<form:options items="${cityMap}" />
												</form:select></td>
										</tr>
									</table>
								</div>
							</form:form>
						</div>
					</strong>
				</div>
			</div>
			<strong> </strong>
		</div>
		<strong><%@include file="../common/bottom.jsp"%></strong>
	</div>
</body>
<script type="text/javascript">
	function adminLogin() {
		window.location.href = "";
	}
</script>
</html>