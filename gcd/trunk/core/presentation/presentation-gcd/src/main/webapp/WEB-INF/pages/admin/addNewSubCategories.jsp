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
					<div id="title">Get City Dealz Admin Dashboard<</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp;<a href="categories" class="link1">Return to All Categories</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
						<c:if test='%{message}!=null'>
								%{message}
								</c:if>
					</h3>
					<form:form method="post" name="categoryForm" action="#" modelAttribute="SubCategoryForm">
						<div class="profile">
							<table cellspacing="0" cellpadding="0" style="width: 100%;" class="tableStyle custom_td">
								<tbody>
									<tr>
										<td><label>Category Name<span class="star">&nbsp;*</span></label></td>
										<td><input type="text" name="categoryName" id="categoryName" value="${categoryName}" class="mInput" size="40"></td>
										<td class="button2"><input type="button" class="mediumBtn" value="Update" onclick="updateCategory('${categoryId}')" /></td>
									</tr>
								</tbody>
							</table>
							<table class="tableStyle" style="width: 100%; border: 1px solid #CCCCCC; border-collapse: collapse;" border="1">
								<tr>
									<th>Sub-Categories</th>
									<th>&nbsp;</th>
								</tr>
								<c:forEach var="subcategory" items="${subCategories}">
									<tr>
										<td>${subcategory.subCategoryName}</td>
										<td><a style="cursor: pointer;" onclick="updateSubCategory('${categoryId}','${subcategory.subCategoryId}','${subcategory.subCategoryName}');">Edit</a></td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<div style="float: right;">
							<input type="button" onclick="editSubCategory('${categoryId}')" value="Add New Sub-Category" />
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
	function editSubCategory(categoryId) {
		window.location.href = "editSubCategory?categoryId=" + categoryId;
	}

	function updateCategory(cId) {
		if (trimString($("#categoryName").val()) == "") {
			appFocus($("#categoryName"));
			$.alert.open('error', 'Category Name Missing.');
			return false;
		}
		if (trimString($("#categoryId").val()) == "-1") {
			appFocus($("#categoryId"));
			$.alert.open('error', 'Category is Missing.');
			return false;
		}
		var retVal = $.ajax({
			url : "jsonSaveCategoryDetails",
			type : "POST",
			global : false,
			data : {
				categoryId : cId,
				categoryName : $("#categoryName").val()
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
		if (obj != null) {
			if (obj.jsonMessage == null || obj.jsonMessage == "")
				$.alert.open('info', 'Category saved sucessfully.');
			else {
				$.alert.open('error', obj.jsonMessage);
			}
		} else {
			$.alert.open('error', 'Error');
		}
	}

	function resetAll() {
		$("#categoryName").val("");
	}

	function updateSubCategory(categoryId, subCatgId, subCatName) {
		window.location.href = "editSubCategory?categoryId=" + categoryId
				+ "&subCategoryId=" + subCatgId + "&subCategoryName="
				+ subCatName;
	}
</script>
</html>