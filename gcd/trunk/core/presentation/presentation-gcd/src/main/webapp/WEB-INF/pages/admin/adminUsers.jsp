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
					<div id="title">All GCD Admins</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form method="post" name="userMasterForm" id="userMasterForm">
						<div class="items">
							<table class="items_list" width="100%" cellpadding="0" cellspacing="0">
								<tbody>
									<tr>
										<th>UserId</th>
										<th>First Name</th>
										<th>Last Name</th>
										<!-- <th>Status</th> -->
										<th>&nbsp;</th>
									</tr>
									<c:forEach var="um" items="${usermasters}">
										<tr>
											<td>${um.userId}</td>
											<td>${um.contactFirstName}</td>
											<td>${um.contactLastName}</td>
											<%-- <td>${um.status}</td> --%>
											<td class="button2"><input type="button" onclick="updateUserMaster('${um.userIndex}');" id="${um.userIndex}" value="Edit" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="pagination">
							<p class="counter"></p>
						</div>
						<br>
						<div class="button2">
							<input type="button" onclick="saveSubscriptionLevel();" value="Add New User" />
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
	function saveSubscriptionLevel() {
		document.userMasterForm.action = 'editAdminDetails';
		document.userMasterForm.submit();
	}

	function updateUserMaster(subsId) {
		document.userMasterForm.action = 'editAdminDetails?userId=' + subsId;
		document.userMasterForm.submit();
	}
</script>
</html>