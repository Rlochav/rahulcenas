<%@include file="../../common/taglibs.jsp"%>
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
	<%@include file="../../common/telliumTags.jsp"%>
	<div id="wrapper">
		<%@include file="../../common/header3.jsp"%>
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
					<div id="title">${SESSION_ATTR_USER_INFO.cityText}:NEIGHBORHOODS</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp;<a href="merchantmgmt" class="link1">Return to ${SESSION_ATTR_USER_INFO.cityText} Dashboard</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form method="post" name="addNewNeighborhoodForm" id="addNewNeighborhoodForm" action="addneighborhood" modelAttribute="addneighborhoodForm">

						<div class="profile">
							<input type="text" style="display: none;" id="docType" name="docType" value="1">
							<table class="tableStyle width_50" style="width: 100%;" border="0">
								<tr>
									<th>Neighborhoods</th>
									<th>&nbsp;</th>
								</tr>
								<c:forEach var="nMaster" items="${neighborhoodDTOList}">
									<tr>
										<td class="mReadOnlyLabel">${nMaster.neighborhoodName}</td>
										<td><input type="button" onclick="updateNeighborhood('${nMaster.neighborhoodId}','${nMaster.neighborhoodName}');" value="Edit" style="cursor: pointer;" /></td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<div style="float: right;">
							<input type="submit" id="addNewNeighborhood" value="Add New Neighborhood" />
						</div>
					</form:form>
				</div>
			</div>
			<strong> </strong>
		</div>
		<strong><%@include file="../../common/bottom.jsp"%></strong>
	</div>
</body>
<script type="text/javascript">
	function updateNeighborhood(nId, nName) {
		document.addNewNeighborhoodForm.action = "addneighborhood?nId=" + nId + "&nName=" + nName;
		document.addNewNeighborhoodForm.submit();
	}
</script>
</html>