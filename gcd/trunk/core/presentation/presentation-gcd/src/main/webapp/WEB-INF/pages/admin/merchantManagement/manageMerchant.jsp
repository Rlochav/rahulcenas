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
					<form:form method="post" name="manageMerchantForm" id="manageMerchantForm">
						<div class="profile">
							<input type="text" style="display: none;" id="docType" name="docType" value="1">
							<table class="tableStyle" id="merchantListTable" style="width: 100%;">
								<tr>
									<th>Name</th>
									<th>Address</th>
									<th>Neighborhood</th>
									<th>Category</th>
									<th>Subscription Level</th>
									<th>Active</th>
									<th>&nbsp;</th>
								</tr>
								<c:forEach var="merchantDTO" items="${merchantDTO}">
									<tr>
										<td class="mReadOnlyLabel">${merchantDTO.merchantName}</td>
										<td class="mReadOnlyLabel">${merchantDTO.address1}<c:if test="${merchantDTO.address2!=''}">,${merchantDTO.address2}</c:if> <c:if test="${merchantDTO.address2!=''}">,${merchantDTO.address3}</c:if></td>
										<td class="mReadOnlyLabel">${merchantDTO.neighborhoodName}</td>
										<td class="mReadOnlyLabel">${merchantDTO.category1Text}/${merchantDTO.category2Text}</td>
										<td class="mReadOnlyLabel">${merchantDTO.subscriptionLevel}</td>
										<td class="mReadOnlyLabel">${merchantDTO.statusText}</td>
										<td><input type="button" onclick="viewMerchantInfo('${merchantDTO.merchantId}');" id="ve${merchantDTO.merchantId}" value="View/Edit" /></td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<div style="float: right;">
							<input type="button" onclick="addNewMerchant();" value="Add New Merchant" />
						</div>
					</form:form>
				</div>
				<div class="pagination" id="paginationDiv"></div>
			</div>
			<strong> </strong>
		</div>
		<strong><%@include file="../../common/bottom.jsp"%></strong>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		var total = 20;
		var count = getIntValue('<c:out value="${count}"/>');
		if (count > 20) {
			if (count % total != 0) {
				count = count + (total - (count % total));
			}

			var prev = getIntValue('<c:out value="${start}"/>') == 0 ? 0 : getIntValue('<c:out value="${start}"/>') - total;
			var next = getIntValue('<c:out value="${start}"/>') == (count - total) ? (count - total) : getIntValue('<c:out value="${start}"/>') + total;
			$("#paginationDiv").append(
					'<p class="counter">Page ${page} of ' + count / total + '</p>' + '<ul>' + '<li class="pagination-start"><a href="merchantList?start=0" class="pagenav">Start</a></li>'
							+ '<li class="pagination-prev"><a href="merchantList?start=' + prev + '" class="pagenav">Prev</a></li>' + '<label id="pages"></label>'
							+ '<li class="pagination-next"><a title="Next" href="merchantList?start=' + next + '" class="pagenav">Next</a></li>'
							+ '<li class="pagination-end"><a title="End" href="merchantList?start=' + (count - total) + '" class="pagenav">End</a></li>' + '</ul>');

			var pageing = '';
			for ( var i = 1; i <= count / total; i++) {
				var start = (i - 1) * total;
				pageing = pageing + '<li><a title="' + i + '" href="merchantList?start=' + start + '" class="pagenav">' + i + '</a></li>';
			}
			$("#pages").html(pageing);
		} else {
			$("#paginationDiv").css('display', 'none');
		}

		if ('<c:out value="${message}"/>'.length > 0) {
			$.alert.open('info', '<c:out value="${message}"/>');
			$("#merchantListTable tr:nth-child(2)").css("background", "green");
		}
		setTimeout('$("#merchantListTable tr:nth-child(2)" ).css("background","#fff");', 8000);

	});
	function viewMerchantInfo(merchantId) {
		document.manageMerchantForm.action = 'merchantInfo?merchantId=' + merchantId;
		document.manageMerchantForm.submit();
	}

	function addNewMerchant() {
		document.manageMerchantForm.action = 'merchantRegistration';
		document.manageMerchantForm.submit();
	}
</script>
</html>