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
					<div id="title">ALL GET CITY DEALZ SOCIAL CONNECTIONS</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form method="post" name="listCityForm" action="editcity">
						<div class="profile">
							<input type="hidden" value="${conn.connectionId}" id="sConnId" name="sConnId" />
							<table class="tableStyle" style="margin-bottom: 20px; width: 100%; border: 1px solid #CCCCCC; border-collapse: collapse;" border="0">
								<tbody>
									<tr>
										<td>Facebook Fan Page</td>
										<td><input type="text" name="fbFanPage" id="fbFanPage" value="${conn.facebookFanPage}"></td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Facebook Post deals to:</td>
										<td><strong>${conn.fbPostDealzTo}</strong></td>
										<td><a href="signInFacebook"><img alt="Facebook Login" src="<c:url value='/resources/images/connectToFacebook.jpg'/>" width="144" /></a></td>
									</tr>
									<tr>
										<td>Twitter Account</td>
										<td><input type="text" name="twtId" id="twtId" value="${conn.twitterAccount}"></td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Twitter Post deals to:</td>
										<td><strong>${conn.twitterScreenName}</strong></td>
										<td><a href="javascript:void(0);" onclick="getOAuthUrl();"><img alt="Twitter Login" src="<c:url value='/resources/images/TwitterLogin.png'/>" width="144" /></a></td>
									</tr>
								</tbody>
							</table>
							<div class="button2">
								<input type="button" onclick="addSocialConnection(1);" name="fbtwBtn" id="fbtwBtn" value="Add Social Connections" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
			<strong> </strong>
		</div>
		<strong><%@include file="../common/bottom.jsp"%></strong>
	</div>
</body>
<script type="text/javascript">
	function addSocialConnection(flag) {
		if (flag == "1") {
			if (trimString($("#fbFanPage").val()) == "") {
				appFocus($("#fbFanPage"));
				alert("Facebook Fan Page is Missing");
				return false;
			}
			if (trimString($("#twtId").val()) == "") {
				appFocus($("#twtId"));
				alert("Twitter Account is Missing");
				return false;
			}
		}

		if (flag == "2") {
			if (trimString($("#consumerKey").val()) == "") {
				appFocus($("#consumerKey"));
				alert("Consumer Key is Missing");
				return false;
			}
			if (trimString($("#consumerSecret").val()) == "") {
				appFocus($("#consumerSecret"));
				alert("Consumer Secret is Missing");
				return false;
			}
			if (trimString($("#oAuthToken").val()) == "") {
				appFocus($("#oAuthToken"));
				alert("OAuth Token is Missing");
				return false;
			}
			if (trimString($("#oAuthSecret").val()) == "") {
				appFocus($("#oAuthSecret"));
				alert("OAuth Secret is Missing");
				return false;
			}
		}

		var retVal = $.ajax({
			url : "jsonSaveSConnDetails",
			type : "POST",
			global : false,
			data : {
				sConnId : $("#sConnId").val(),
				fbFanPage : $("#fbFanPage").val(),
				twtId : $("#twtId").val(),
				consumerKey : $("#consumerKey").val(),
				consumerSecret : $("#consumerSecret").val(),
				oAuthToken : $("#oAuthToken").val(),
				oAuthSecret : $("#oAuthSecret").val(),
				flag : flag
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
		if (obj != null) {
			if (obj.jsonMessage == null || obj.jsonMessage == "") {
				$("#sConnId").val(obj.connectionId);
				alert("Connection saved sucessfully.");
			} else {
				alert(obj.jsonMessage)
			}
		} else {
			$("#error").html("Error");
		}
	}

	function getOAuthUrl() {
		var retVal = $.ajax({
			url : "jsonTwitterOAuthUrl",
			type : "POST",
			global : false,
			data : {

			},
			dataType : "json",
			async : false
		}).responseText;

		if (retVal != null) {
			document.location.href = retVal + "";
		}
	}
</script>
</html>