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
					<div id="title">All Categories & Sub Categories</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form method="post" name="allHotDealzForm" action="addCategory">
						<div class="profile">
							<input type="text" style="display: none;" id="docType" name="docType" value="1">
							<table class="tableStyle" style="width: 100%;" border="0">
								<tr>
									<th style="width: 25%;">Categories</th>
									<th style="width: 25%;">&nbsp;</th>
									<th>Sub-Categories</th>
								</tr>
								<c:forEach var="category" items="${categories}">
									<tr>
										<td class="mReadOnlyLabel" style="vertical-align: top;">${category.categoryName}<input type="hidden" style="" name="categoryId" />
										</td>
										<td style="vertical-align: top;"><input type="button" id="cat${category.categoryId}" onclick="updateCategory('${category.categoryId}','${category.categoryName}');" value="Edit" /></td>
										<td class="mReadOnlyLabel" style="padding: 0;">
											<table class="tableStyle subcategory width_50" cellpadding="0" style="width: 100%; border: none;" border="0">
												<c:forEach var="subcategory" items="${category.subCategoryDTOs}">
													<tr>
														<td>${subcategory.subCategoryName}</td>
														<td align="left"><input type="button" id="${subcategory.subCategoryId}" value="Edit" onclick="updateSubCategory('${category.categoryId}','${subcategory.subCategoryId}','${subcategory.subCategoryName}');" /></td>
													</tr>
												</c:forEach>
											</table>
										</td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<div style="float: right;">
							<input type="submit" value="Add New Category" />
						</div>
					</form:form>
				</div>
				<div class="pagination" id="paginationDiv"></div>	
			</div>
			<strong> </strong>
		</div>
		<strong><%@include file="../common/bottom.jsp"%></strong>
	</div>
</body>
<script type="text/javascript">
	$(function() {	
		var count = getIntValue('<c:out value="${count}"/>');
		if (count % 2 != 0) {
			count = count + 1;
		}

		var prev = getIntValue('<c:out value="${start}"/>') == 0 ? 0 : getIntValue('<c:out value="${start}"/>') - 2;
		var next = getIntValue('<c:out value="${start}"/>') == (count - 2) ? (count - 2) : getIntValue('<c:out value="${start}"/>') + 2;
		$("#paginationDiv").append(
				'<p class="counter">Page ${page} of ' + count / 2 + '</p>' + '<ul>'
						+ '<li class="pagination-start"><a href="categories?start=0" class="pagenav">Start</a></li>'
						+ '<li class="pagination-prev"><a href="categories?start=' + prev + '" class="pagenav">Prev</a></li>' + '<label id="pages"></label>'
						+ '<li class="pagination-next"><a title="Next" href="categories?start=' + next + '" class="pagenav">Next</a></li>'
						+ '<li class="pagination-end"><a title="End" href="categories?start=' + (count - 2) + '" class="pagenav">End</a></li>' + '</ul>');

		var pageing = '';
		for ( var i = 1; i <= count / 2; i++) {
			var start = (i - 1) * 2;
			pageing = pageing + '<li><a title="' + i + '" href="categories?start=' + start + '" class="pagenav">' + i + '</a></li>';
		}
		$("#pages").html(pageing);
	});

	function updateCategory(categoryId, categoryName) {
		window.location.href = "addSubCategory?categoryId=" + categoryId + "&categoryName=" + categoryName;
	}

	function updateSubCategory(categoryId, subCatgId, subCatName) {
		window.location.href = "editSubCategory?categoryId=" + categoryId + "&subCategoryId=" + subCatgId + "&subCategoryName=" + subCatName;
	}
</script>
</html>