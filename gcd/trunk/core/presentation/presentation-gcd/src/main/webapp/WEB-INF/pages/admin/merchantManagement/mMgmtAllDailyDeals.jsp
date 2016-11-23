<%@include file="../../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="common.html.000001"></spring:message></title>

<script type="text/javascript" src="<c:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>">
<link rel="shortcut icon" href="/resources/images/icon.png" />
<script type="text/javascript" src="<c:url value='/resources/js/CommonFunction.js'/>"></script>

<link href="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/css/alert.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/themes/light/theme.css'/>" rel="stylesheet" />
<script src="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/js/alert.js'/>"></script>
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
					<div id="title">VIEW ALL ${SESSION_ATTR_USER_INFO.cityText} : ACTIVE AND SCHEDULED DEALS</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp; <a href="merchantmgmt" class="link1">Return to ${SESSION_ATTR_USER_INFO.cityText} Dashboard</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form method="post" name="allDealzForm" id="allDealzForm">
						<div class="profile">
							<input type="text" style="display: none;" id="docType" name="docType" value="1">
							<table class="tableStyle" style="width: 100%;">
								<tr>
									<th>Merchant Name</th>
									<th style="display: none;">Deal Date</th>
									<th>Deal Title</th>
									<th style="width: 25%;">Deal Description</th>
									<th>Deal Start Date/Time</th>
									<th>Deal End Date/Time</th>
									<th>Status</th>
									<th style="width: 13%;">&nbsp;</th>
								</tr>
								<c:forEach var="dealz" items="${dealzDTO}">
									<tr id="row${dealz.dealId}">
										<td class="mReadOnlyLabel">${dealz.merchantName}</td>
										<td style="display: none;" class="mReadOnlyLabel">${dealz.createDateText}</td>
										<td class="mReadOnlyLabel">${dealz.title}</td>
										<td class="mReadOnlyLabel">${dealz.description}</td>
										<td class="mReadOnlyLabel">${dealz.startDate}</td>
										<td class="mReadOnlyLabel">${dealz.endDate}</td>
										<td class="mReadOnlyLabel">${dealz.statusText}</td>
										<td>
											<%-- <c:if test="${dealz.statusText!='Active'}"> --%> <input type="button" style="font-size: 12px; padding: 2px 7px;" onclick="editDealzContent('${dealz.dealId}','${dealz.merchantId}');" id="edit${dealz.dealId}" value="Edit" />&nbsp;&nbsp;<input type="button"
											style="font-size: 12px; padding: 2px 7px;" onclick="deleteDealz('${dealz.dealId}','${dealz.merchantId}');" id="delete${dealz.dealId}" value="Delete" /> <%-- </c:if> --%>
										</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</form:form>
					<div class="pagination" id="paginationDiv"></div>
				</div>
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
					'<p class="counter">Page ${page} of ' + count / total + '</p>' + '<ul>' + '<li class="pagination-start"><a href="alldailydeals?dealType=1&?start=0" class="pagenav">Start</a></li>'
							+ '<li class="pagination-prev"><a href="alldailydeals?dealType=1&?start=' + prev + '" class="pagenav">Prev</a></li>' + '<label id="pages"></label>'
							+ '<li class="pagination-next"><a title="Next" href="alldailydeals?dealType=1&?start=' + next + '" class="pagenav">Next</a></li>'
							+ '<li class="pagination-end"><a title="End" href="alldailydeals?dealType=1&?start=' + (count - total) + '" class="pagenav">End</a></li>' + '</ul>');

			var pageing = '';
			for ( var i = 1; i <= count / total; i++) {
				var start = (i - 1) * total;
				pageing = pageing + '<li><a title="' + i + '" href="alldailydeals?dealType=1&?start=' + start + '" class="pagenav">' + i + '</a></li>';
			}
			$("#pages").html(pageing);
		} else {
			$("#paginationDiv").css('display', 'none');
		}
	});

	function editDealzContent(dealzId, merchantId) {
		document.allDealzForm.action = 'editdailydeals?dealzId=' + dealzId + "&dealType=<c:out value="${dealType}"/>" + "&merchantId=" + merchantId;
		document.allDealzForm.submit();
	}

	function deleteDealz(dealzId, merchantId) {
		$.alert.open('confirm', 'Do you want delete dealz.?', function(button) {
			if (button == 'yes') {
				var retVal = $.ajax({
					url : "deleteMerchantDealz",
					type : "POST",
					global : false,
					data : {
						dealzId : dealzId,
						merchantId : merchantId
					},
					dataType : "json",
					async : false
				}).responseText;

				var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
				if (obj != null) {
					if (obj.jsonMessage == null || obj.jsonMessage == "") {
						$("#row" + dealzId).remove();
						$.alert.open('info', 'Deal deleted sucessfully.');
					} else {
						$.alert.open('error', obj.jsonMessage);
					}
				} else {
					$.alert.open('error', 'Error');
				}
			}
		});
	}
</script>

</html>