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
					<div id="title">List of All Accessiblity Icons</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form method="post" name="accessbiltyIconForm" id="accessbiltyIconForm" action="editicons">
						<div class="profile">
							<table class="tableStyle" style="width: 100%;" border="0">
								<tbody>
									<tr>
										<th>Icon Name</th>
										<th>Icon Image</th>
										<th></th>
									</tr>
									<c:forEach var="icon" items="${icons}">
										<tr>
											<td>${icon.iconName}</td>
											<c:set var="img" value="${fn:replace(icon.imagePath,'.', '_do_custom_separator_')}" />
											<td align="center"><img alt="${icon.iconName}" src="../displayImage1/${img}?docType=11" width="20" /></td>
											<td class="button2" align="center"><input type="button" onclick="editIcons('${icon.iconId}')" value="Edit" id="${icon.iconId}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div style="float: right;">
							<input type="submit" value="Add New Accessibility Icon" />
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
	function editIcons(iconId) {
		document.accessbiltyIconForm.action = 'editicons?iconId=' + iconId;
		document.accessbiltyIconForm.submit();
	}
</script>
</html>