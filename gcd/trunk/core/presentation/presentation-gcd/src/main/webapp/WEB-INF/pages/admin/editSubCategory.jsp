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

<link href="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/css/alert.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/themes/light/theme.css'/>" rel="stylesheet" />
<script src="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/js/alert.js'/>"></script>
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
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp;<a href="categories" class="link1">Return to All Categories</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form method="post" name="categoryForm" modelAttribute="editSubCategoryForm">
						<div class="profile">
							<table cellspacing="0" cellpadding="0" style="width: 100%;" class="tableStyle custom_td">
								<tbody>
									<tr>
										<td><label>Sub-Category Name:<span class="mandatory">*</span></label></td>
										<td><input type="text" name="subCategoryName" id="subCategoryName" value="${subCategoryName}" class="mInput" size="40"><input type="text" name="subCategoryId" id="subCategoryId" value="${subCategoryId}" class="mInput" style="display: none;"></td>
										<td><label>Category Name:<span class="mandatory">*</span><span class="star">&nbsp;*</span></label></td>
										<td><form:select path="categoryId" cssClass="mSelect" onchange="citiesList();">
												<form:option value="-1" label="--Select--"></form:option>
												<form:options items="${categoryMap}" />
											</form:select></td>
										<td class="button2"><input type="button" class="mediumBtn" value="${btnName}" onclick="saveSubCategory();" /></td>
									</tr>
								</tbody>
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
	$(function() {
		$("#categoryId").val('<c:out value="${categoryId}"/>');
	});

	function saveSubCategory() {
		if (trimString($("#subCategoryName").val()) == "") {
			appFocus($("#subCategoryName"));
			$.alert.open('error', 'Sub-CategoryName Name Missing.');
			return false;
		}
		if (trimString($("#categoryId").val()) == "-1") {
			appFocus($("#categoryId"));
			$.alert.open('error', 'Category is Missing.');
			return false;
		}
		var retVal = $.ajax({
			url : "saveNewSubCategory",
			type : "POST",
			global : false,
			data : {
				categoryId : $("#categoryId").val(),
				subCategoryName : $("#subCategoryName").val(),
				subCategoryId : $("#subCategoryId").val()
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
		if (obj != null) {
			if (obj.jsonMessage == null || obj.jsonMessage == "")
				$.alert.open('info', 'Sub-Category saved sucessfully.');
			else {
				$.alert.open('error', obj.jsonMessage);
			}
		} else {
			$.alert.open('error', 'Error');
		}
		//resetAll();
	}

	function resetAll() {
		//$("#subCategoryName").val("");
		$("#categoryId").val("");
	}
</script>
</html>