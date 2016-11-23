<%@include file="../common/taglibs.jsp"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<%@ taglib uri="http://cksource.com/ckfinder" prefix="ckfinder"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="common.html.000001"></spring:message></title>

<script type="text/javascript" src="<c:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/rating.css'/>">
<link rel="shortcut icon" href="resources/images/icon.png" />
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
						${btnName} Social Profile
					</c:if>
						<c:if test="${type==2}">
						${btnName} Category Navigation Button
					</c:if>

						<c:if test="${type==3}">
						${btnName} Footer Menu
					</c:if>
					</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp;<a href="<c:if test="${type==1}">
					nav1
					</c:if> <c:if test="${type==2}">
						nav2
					</c:if> <c:if test="${type==3}">
					 nav3
					</c:if>" class="link1">Return to <c:if test="${type==1}">
					 Social Profile list
					</c:if> <c:if test="${type==2}">
						Category Navigation Button List
					</c:if> <c:if test="${type==3}">
					 Footer Menu List
					</c:if></a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form method="post" name="editicons" action="/component/saveMetaNav" modelAttribute="metaDTO" enctype="multipart/form-data">
						<input type="hidden" id="type" name="type" value="${type}">
						<div class="profile">
							<table class="tableStyle" style="width: 100%; border: 1px solid #CCCCCC; border-collapse: collapse;" border="0">
								<c:if test="${type==1}">
									<tr>
										<td>Social Icon<span style="color: red;">*</span></td>
										<td><input type="hidden" id="id" name="id" value="${dto.id}" /> <input type="file" name="image" id="image" class="mInput" required /> ${dto.imageAlt}</td>
										<c:set var="img" value="${fn:replace(dto.imagePath,'.', '_do_custom_separator_')}" />
										<td><c:if test="${dto.imagePath!=null}">
												<img alt="${dto.imageAlt}" src="../displayImage1/${img}?docType=12" width="60" />
											</c:if> <c:if test="${dto.imagePath==null}">&nbsp;</c:if></td>
									</tr>
									<tr>
										<td>Icon Name<span style="color: red;">*</span></td>
										<td><input type="text" name="imageAlt" id="imageAlt" value="${dto.imageAlt}" class="mInput"></td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Icon Url<span style="color: red;">*</span></td>
										<td><input type="text" name="url" id="url" value="${dto.url}" class="mInput"></td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Show On Page<span style="color: red;">*</span></td>
										<td><script type="text/javascript">
											if ('<c:out value="${dto.showOnPage}"/>' == "1")
												document.write('<input type="checkbox" name="showOnPage" id="showOnPage_${dto.id}" checked/>');
											if ('<c:out value="${dto.showOnPage}"/>' == "0")
												document.write('<input type="checkbox" name="showOnPage" id="showOnPage_${dto.id}"/>');
											if ('<c:out value="${dto.showOnPage}"/>' != "0" && '<c:out value="${dto.showOnPage}"/>' != "1")
												document.write('<input type="checkbox" name="showOnPage" id="showOnPage" checked/>');
										</script></td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Align<span style="color: red;">*</span></td>
										<td><input type="text" name="align" id="align" value="${dto.align}" class="mInput"></td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td></td>
										<td><input type="button" id="iconBtn" onclick="saveIconDetails();" value="${btnName}" /></td>
										<td>&nbsp;</td>
									</tr>
								</c:if>

								<c:if test="${type==2}">
									<input type="hidden" name="url" id="url" value="${dto.url}" class="mInput">
									<tr>
										<td>Icon<span style="color: red;">*</span></td>
										<td><input type="hidden" id="id" name="id" value="${dto.id}" /> <input type="file" name="image" id="image" class="mInput" required /> ${dto.imageAlt}</td>
										<c:set var="img" value="${fn:replace(dto.imagePath,'.', '_do_custom_separator_')}" />
										<td><c:if test="${dto.imagePath!=null}">
												<img alt="${dto.imageAlt}" src="../displayImage1/${img}?docType=12" width="60" />
											</c:if> <c:if test="${dto.imagePath==null}">&nbsp;</c:if></td>
									</tr>
									<tr>
										<td>Icon Name<span style="color: red;">*</span></td>
										<td><input type="text" name="imageAlt" id="imageAlt" value="${dto.imageAlt}" class="mInput"></td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Show On Page<span style="color: red;">*</span></td>
										<td><script type="text/javascript">
											if ('<c:out value="${dto.showOnPage}"/>' == "1")
												document.write('<input type="checkbox" name="showOnPage" id="showOnPage_${dto.id}" checked/>');
											if ('<c:out value="${dto.showOnPage}"/>' == "0")
												document.write('<input type="checkbox" name="showOnPage" id="showOnPage_${dto.id}"/>');
											if ('<c:out value="${dto.showOnPage}"/>' != "0" && '<c:out value="${dto.showOnPage}"/>' != "1")
												document.write('<input type="checkbox" name="showOnPage" id="showOnPage" checked/>');
										</script></td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Align<span style="color: red;">*</span></td>
										<td><input type="text" name="align" id="align" value="${dto.align}" class="mInput"></td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Element Id<span style="color: red;">*</span></td>
										<td><input type="text" name="elementId" id="elementId" value="${dto.elementId}" class="mInput"></td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Element Class<span style="color: red;">*</span></td>
										<td><input type="text" name="elementClass" id="elementClass" value="${dto.elementId}" class="mInput"></td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td></td>
										<td><input type="button" id="iconBtn" onclick="saveIconDetails();" value="${btnName}" /></td>
										<td>&nbsp;</td>
									</tr>
								</c:if>

								<c:if test="${type==3}">
									<input type="hidden" id="id" name="id" value="${dto.id}" />
									<tr>
										<td>Link Text<span style="color: red;">*</span></td>
										<td><input type="text" name="imageAlt" id="imageAlt" value="${dto.imageAlt}" class="mInput"></td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Link<span style="color: red;">*</span></td>
										<td><input type="text" name="url" id="url" value="${dto.url}" class="mInput"></td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Show On Page<span style="color: red;">*</span></td>
										<td><script type="text/javascript">
											if ('<c:out value="${dto.showOnPage}"/>' == "1")
												document.write('<input type="checkbox" name="showOnPage" id="showOnPage_${dto.id}" checked/>');
											if ('<c:out value="${dto.showOnPage}"/>' == "0")
												document.write('<input type="checkbox" name="showOnPage" id="showOnPage_${dto.id}"/>');
											if ('<c:out value="${dto.showOnPage}"/>' != "0" && '<c:out value="${dto.showOnPage}"/>' != "1")
												document.write('<input type="checkbox" name="showOnPage" id="showOnPage" checked/>');
										</script></td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>Align<span style="color: red;">*</span></td>
										<td><input type="text" name="align" id="align" value="${dto.align}" class="mInput"></td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td></td>
										<td><input type="button" id="iconBtn" onclick="saveIconDetails();" value="${btnName}" /></td>
										<td>&nbsp;</td>
									</tr>
								</c:if>
							</table>
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
	function saveIconDetails() {
		/*  if (trimString($("#iconImage").val()) == ""&&${icons.iconId}+''=='') {
				appFocus($("#iconImage"));
				$.alert.open('error', 'Icon Image is Missing');
				return false;
		 } 
		if (trimString($("#iconName").val()) == "") {
			appFocus($("#iconName"));
			$.alert.open('error', 'Icon Name is Missing');
			return false;
		} */
		/* if (trimString($("#iconUrl").val()) == "") {
			appFocus($("#cityName"));
			$.alert.open('error', 'Icon Url is Missing');
			return false;
		} */
		document.editicons.action = "saveMetaNav";
		document.editicons.submit();
	}
</script>
</html>