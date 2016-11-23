<%@include file="../../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="common.html.000001"></spring:message></title>

<script type="text/javascript" src="<c:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>">
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
					<div id="title">${SESSION_ATTR_USER_INFO.cityText}:${merchantDTO.merchantName}'S Basic INFORMATION</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp;<a href="merchantmgmt" class="link1">Return to ${SESSION_ATTR_USER_INFO.cityText} Dashboard</a> &nbsp;<a href="merchantList" class="link1">Return to All ${SESSION_ATTR_USER_INFO.cityText} Merchants</a>&nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form method="post" name="allHotDealzForm" action="allHotDealzForm" modelAttribute="uploadForm" enctype="multipart/form-data">
						<table class="tableStyle" style="width: 100%; margin-bottom: 20px;">
							<tr>
								<td width="20%"><strong>Date Account Established</strong></td>
								<td>${merchantDTO.createDateText}</td>
								<td width="20%"><strong>Date Account De-activated</strong></td>
								<td>
									<div id="dateLink">
										<c:if test="${merchantDTO.deactivateDate!=null}">
														${merchantDTO.deactivateDate}
													</c:if>
									</div>

									<div id="dactLink">
										<c:if test="${merchantDTO.deactivateDate==null}">
											<a style="cursor: pointer;" onclick="deactivateMerchant('${merchantDTO.merchantId}')">deactivate</a>
										</c:if>
									</div>
								</td>
							</tr>
							<tr>
								<td><strong>Account Status</strong></td>
								<td>Active</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><strong>Business Name</strong></td>
								<td>${merchantDTO.merchantName}</td>
								<td><strong>Get City Dealz Name</strong></td>
								<td>${merchantDTO.userId}</td>
							</tr>
							<tr>
								<td><strong>Physical Address</strong></td>
								<td>${merchantDTO.address1}<br>${merchantDTO.address2} ${merchantDTO.address3} ${SESSION_ATTR_USER_INFO.cityText} ${merchantDTO.state} ${merchantDTO.zipCode}
								</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><strong>Contact</strong></td>
								<td>${merchantDTO.contactFirstName}${merchantDTO.contactLastName}</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><strong>Business Phone</strong></td>
								<td>${merchantDTO.contactPhone}</td>
								<td><strong>Alternate Phone</strong></td>
								<td>${merchantDTO.contactAlternatePhone}</td>
							</tr>
							<tr>
								<td>Current Master Category</td>
								<td>${merchantDTO.masterCategoryText}</td>

								<td>Current Categories:Sub-categores</td>
								<td><dl>
										<dt>
											<strong>${merchantDTO.category1Text}</strong>
										</dt>
										<dd>${merchantDTO.subCategory1Text}</dd>
										<dt>
											<strong>${merchantDTO.category2Text}</strong>
										</dt>
										<dd>${merchantDTO.subCategory2Text}</dd>
									</dl></td>
							</tr>
							<tr>
								<td><strong>Sales Person</strong></td>
								<td>${merchantDTO.salesPerson}</td>
								<td><strong>Neighborhood</strong></td>
								<td>${merchantDTO.neighborhoodName}</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td><a class="link1" align="right" href="../myProfile?merchantId=<c:out value="${merchantDTO.merchantId}"/>">Edit Basic Info</a></td>
							</tr>
						</table>
						<h3 align="center">Social Connections</h3>
						<table class="tableStyle" style="width: 100%; border: 1px solid #CCCCCC; border-collapse: collapse; margin-bottom: 20px;" border="1">
							<tr>
								<th>&nbsp;</th>
								<th>Show On Page</th>
								<th>&nbsp;</th>
								<th>Show On Page</th>
							</tr>
							<tr>
								<td><strong>Facebook Fanpage</strong></td>
								<td><c:if test="${connectionsDTO.facebookFanPagechk!=1}">No</c:if> <c:if test="${connectionsDTO.facebookFanPagechk==1}">Yes</c:if></td>
								<td><strong>YouTube Account</strong></td>
								<td><c:if test="${connectionsDTO.youtubeAccountchk!=1}">No</c:if> <c:if test="${connectionsDTO.youtubeAccountchk==1}">Yes</c:if></td>
							</tr>
							<tr>
								<td><strong>Twitter Account</strong></td>
								<td><c:if test="${connectionsDTO.twitterAccountchk!=1}">No</c:if> <c:if test="${connectionsDTO.twitterAccountchk==1}">Yes</c:if></td>
								<td><strong>LinkedIn Profile</strong></td>
								<td><c:if test="${connectionsDTO.linkedinProfilechk!=1}">No</c:if> <c:if test="${connectionsDTO.linkedinProfilechk==1}">Yes</c:if></td>
							</tr>
							<tr>
								<td><strong>Foursquare Account</strong></td>
								<td><c:if test="${connectionsDTO.fourSquareAccountchk!=1}">No</c:if> <c:if test="${connectionsDTO.fourSquareAccountchk==1}">Yes</c:if></td>
								<td><strong>Trip Advisor Account</strong></td>
								<td><c:if test="${connectionsDTO.tripAdvisorAccountchk!=1}">No</c:if> <c:if test="${connectionsDTO.tripAdvisorAccountchk==1}">Yes</c:if></td>
							</tr>
							<tr>
								<td><strong>Yelp Account</strong></td>
								<td><c:if test="${connectionsDTO.yelpAccountchk!=1}">No</c:if> <c:if test="${connectionsDTO.yelpAccountchk==1}">Yes</c:if></td>
								<td><strong>MeetUp Account</strong></td>
								<td><c:if test="${connectionsDTO.meetupAccountchk!=1}">No</c:if> <c:if test="${connectionsDTO.meetupAccountchk==1}">Yes</c:if></td>
							</tr>
							<tr>
								<td><strong>Flickr Account</strong></td>
								<td><c:if test="${connectionsDTO.flickerAccountchk!=1}">No</c:if> <c:if test="${connectionsDTO.flickerAccountchk==1}">Yes</c:if></td>
								<td><strong>Open Table Account</strong></td>
								<td><c:if test="${connectionsDTO.openTableAccountchk!=1}">No</c:if> <c:if test="${connectionsDTO.openTableAccountchk==1}">Yes</c:if></td>
							</tr>
							<tr>
								<td><strong>Pinterest UserName</strong></td>
								<td><c:if test="${connectionsDTO.pinterestAccountchk!=1}">No</c:if> <c:if test="${connectionsDTO.pinterestAccountchk==1}">Yes</c:if></td>
								<td></td>
								<td><a class="link1" href="updateSocialConnection?merchantId=${merchantDTO.merchantId}">Add/Edit Social Info</a></td>
							</tr>
						</table>
						<h3 align="center">Current Media</h3>
						<div class="items">
							<table class="tableStyle" style="width: 100%;">
								<tr>
									<th>Document Title</th>
									<th>Type</th>
									<th>Date Uploaded</th>
									<th>Show on Page</th>

								</tr>
								<c:forEach var="documentDTOList" items="${documentDTO}">
									<tr id="${documentDTOList.docId}">
										<td>${documentDTOList.documentTitle}</td>
										<td class="mReadOnlyLabel">${documentDTOList.contentType}</td>
										<td class="mReadOnlyLabel">${documentDTOList.createDateText}</td>
										<td class="mReadOnlyLabel">${documentDTOList.showOnPage}</td>
									</tr>
								</c:forEach>
								<tr>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td><a class="link1" href="editMerchantMedia?merchantId=${merchantDTO.merchantId}">Add New/Replace Media</a></td>
								</tr>
							</table>
						</div>
						<br>
						<h3 align="center">Other Location</h3>
						<div class="items">
							<table class="tableStyle" style="width: 96%; margin: 2%;">
								<tr>
									<th>Primary Location</th>
									<th>Second Location</th>
									<th>Third Location:</th>
								</tr>
								<tr>
									<td><label class="addrs1">${locationDTO1.address1} ${locationDTO1.address2} ${locationDTO1.address3}</label></td>
									<td><label class="addrs2">${locationDTO2.address1} ${locationDTO2.address2} ${locationDTO2.address3}</label></td>
									<td><label class="addrs3">${locationDTO3.address1} ${locationDTO3.address2} ${locationDTO3.address3}</label></td>
								</tr>
								<tr>
									<td><label class="addrs1">${locationDTO1.city}</label></td>
									<td><label class="addrs2">${locationDTO2.city}</label></td>
									<td><label class="addrs3">${locationDTO3.city}</label></td>
								</tr>
								<tr>
									<td><label class="addrs1">${locationDTO1.state}</label></td>
									<td><label class="addrs2">${locationDTO2.state}</label></td>
									<td><label class="addrs3">${locationDTO3.state}</label></td>
								</tr>
								<tr>
									<td><label class="addrs1">${locationDTO1.zipCode}</label></td>
									<td><label class="addrs2">${locationDTO2.zipCode}</label></td>
									<td><label class="addrs3">${locationDTO3.zipCode}</label></td>
								</tr>
								<tr>
									<td><label class="addrs1">${locationDTO1.locationPhone}</label></td>
									<td><label class="addrs2">${locationDTO2.locationPhone}</label></td>
									<td><label class="addrs3">${locationDTO3.locationPhone}</label></td>
								</tr>
								<tr>
									<td><label class="addrs1">${locationDTO1.locationHours}</label></td>
									<td><label class="addrs2">${locationDTO2.locationHours}</label></td>
									<td><label class="addrs3">${locationDTO3.locationHours}</label></td>
								</tr>
								<tr>
									<td><label class="addrs1">${locationDTO1.neighborhoodName}</label></td>
									<td><label class="addrs2">${locationDTO2.neighborhoodName}</label></td>
									<td><label class="addrs3">${locationDTO3.neighborhoodName}</label></td>
								</tr>
								<tr>
									<td><label class="addrs1">${locationDTO1.contactFirstName}</label></td>
									<td><label class="addrs2">${locationDTO2.contactFirstName}</label></td>
									<td><label class="addrs3">${locationDTO3.contactFirstName}</label></td>
								</tr>
								<tr>
									<td><label class="addrs1">${locationDTO1.emailAddress}</label></td>
									<td><label class="addrs2">${locationDTO2.emailAddress}</label></td>
									<td><label class="addrs3">${locationDTO3.emailAddress}</label></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td><a class="link1" href="manageMerchantLocation?merchantId=${merchantDTO.merchantId}">Manage Locations</a></td>
								</tr>
							</table>
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
	function deactivateMerchant(merchantId) {
		var retVal = $.ajax({
			url : "deactivateMerchant",
			type : "POST",
			global : false,
			data : {
				merchantId : merchantId
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
		if (obj != null) {
			if (obj.jsonMessage == null || obj.jsonMessage == "") {
				$("#dactLink").remove();
				$("#dateLink").html(obj.deactivateDate);
				$.alert.open('info', 'Merchant Deactivated successfully.');
			} else {
				$.alert.open('error', obj.jsonMessage);
			}
		} else {
			$.alert.open('error', 'Error');
		}
	}
</script>
</html>