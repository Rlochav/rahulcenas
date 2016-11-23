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
					<div id="title">
						<c:if test="${type==1}">
						Social Profile List
					</c:if>
						<c:if test="${type==2}">
						Category Navigation Button List
					</c:if>

						<c:if test="${type==3}">
						Footer Menu List
					</c:if>

					</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp;<a href="gcd-meta-handler" class="link1">Return to meta manager</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form method="post" name="navForm" id="navForm">
						<c:if test="${type==1}">
							<div class="items">
								<table class="items_list" width="100%" cellpadding="0" cellspacing="0">
									<tbody>
										<tr>
											<th>Social Icon Name</th>
											<th>Show On Page</th>
											<th>&nbsp;</th>
										</tr>
										<c:forEach var="dto" items="${dtos}">
											<tr>
												<td>${dto.imageAlt}</td>
												<td>${dto.showOnPage}</td>
												<td class="button2"><input type="button" onclick="editIcons('${dto.id}')" value="Edit" id="${dto.id}" /></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="pagination">
								<p class="counter"></p>
							</div>
							<br>
							<%-- <%
								if ((Integer) request.getAttribute("size") < 5) {
							%> --%>
							<div class="button2">
								<input type="button" onclick="addMeta();" value="Add New Social Icon" />
							</div>
							<%-- <%
								}
							%> --%>
						</c:if>
						<c:if test="${type==2}">
							<div class="items">
								<table class="items_list" width="100%" cellpadding="0" cellspacing="0">
									<tbody>
										<tr>
											<th>Master Category Name</th>
											<th>Show On Page</th>
											<th>&nbsp;</th>
										</tr>
										<c:forEach var="dto" items="${dtos}">
											<tr>
												<td>${dto.imageAlt}</td>
												<td>${dto.showOnPage}</td>
												<td class="button2"><input type="button" onclick="editIcons('${dto.id}')" value="Edit" id="${dto.id}" /></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="pagination">
								<p class="counter"></p>
							</div>
							<br>
							<%
								if ((Integer) request.getAttribute("size") < 6) {
							%>
							<div class="button2">
								<input type="button" onclick="addMeta();" value="Add New Social Icon" />
							</div>
							<%
								}
							%>
						</c:if>
						<c:if test="${type==3}">
							<div class="items">
								<table class="items_list" width="100%" cellpadding="0" cellspacing="0">
									<tbody>
										<tr>
											<th>Master Category Name</th>
											<th>Show On Page</th>
											<th>&nbsp;</th>
										</tr>
										<c:forEach var="dto" items="${dtos}">
											<tr>
												<td>${dto.imageAlt}</td>
												<td>${dto.showOnPage}</td>
												<td class="button2"><input type="button" onclick="editIcons('${dto.id}')" value="Edit" id="${dto.id}" /></td>
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
								<input type="button" onclick="addMeta();" value="Add New Link" />
							</div>
						</c:if>
						<c:if test="${type==4}">
							<div class="items">
								<table class="items_list" width="100%" cellpadding="0" cellspacing="0">
									<tbody>
										<tr>
											<th>Page Title</th>
											<th>Show On Page</th>
											<th>&nbsp;</th>
										</tr>
										<c:forEach var="dto" items="${dtos}">
											<tr>
												<td>${dto.imageAlt}</td>
												<td>${dto.showOnPage}</td>
												<td class="button2"><input type="button" onclick="editIcons('${dto.id}')" value="Edit" id="${dto.id}" /></td>
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
								<input type="button" onclick="addNewPage();" value="Add New Page" />
							</div>
						</c:if>
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
		document.navForm.action = 'editNav?tyep=${type}&navId=' + iconId;
		document.navForm.submit();
	}

	function addMeta() {
		document.navForm.action = 'editNav?tyep=${type}';
		document.navForm.submit();
	}

	function addNewPage() {
		document.navForm.action = 'editNav?tyep=${type}&edit=true';
		document.navForm.submit();
	}
</script>
</html>