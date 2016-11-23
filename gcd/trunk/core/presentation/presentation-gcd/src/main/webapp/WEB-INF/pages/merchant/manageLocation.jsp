<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title><spring:message code="common.html.000001"></spring:message></title>

<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/template1.css'/>">
<link href="<c:url value='resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='resources/js/js-image-slider.js'/>"></script>
<link rel="shortcut icon" href="resources/images/icon.png" />
<script type="text/javascript" src="<c:url value='resources/js/CommonFunction.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/rating.css'/>" />
</head>

<body>
	<%@include file="../common/telliumTags.jsp"%>
	<div id="wrapper">
		<%@include file="../common/header.jsp"%>
		<div class="tagline">
			<div class="moduletable">


				<div class="custom">
					<p class="MsoNormal">
						<strong><spring:message code="common.html.000002"></spring:message></strong>
					</p>
				</div>
			</div>
		</div>
		<!-- Header section end here -->
		<%@include file="../common/merchantLeft.jsp"%>
		<!-- Menu section end here -->


		<div class="cent center-leftcenter-both no-right">
			<div class="main-content">
				<c:if test="${message!=null}">
					<div id="system-message-container">
						<dl id="system-message">
							<dt class="message">Message</dt>
							<dd class="message message">
								<ul>
									<li>${message}</li>
								</ul>
							</dd>
						</dl>
					</div>
				</c:if>
				<div id="dashboard-area">
					<div id="title">
						List of All Locations of ${SESSION_ATTR_USER_INFO.userName}<br>
					</div>
					<br>
					<h3 class="msg">
						<em>Hi there ${SESSION_ATTR_USER_INFO.userName} Manage Your Locations<br>
						</em>
					</h3>
					<br>
					<div class="items">
						<div id="midContentDiv">
							<fieldset>
								<legend>Main Location</legend>
								<div class="innerDiv">
									<div class="form_fields">
										<label>${SESSION_ATTR_USER_INFO.address1}, ${SESSION_ATTR_USER_INFO.city}, ${SESSION_ATTR_USER_INFO.state} Zipcode: ${SESSION_ATTR_USER_INFO.zipCode} <br />Email: ${SESSION_ATTR_USER_INFO.emailId}
										</label>
									</div>
								</div>
							</fieldset>
							<fieldset>
								<legend>Other Location</legend>
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
										<td><input type="button" value="Add/Edit" id="addBtn1" onclick="editLocation('<c:out value="${locationDTO1.locationId}"/>');" /><input type="button" id="deleteLocation1" value="Delete" onclick="deleteAdditionalLocation('<c:out value="${locationDTO1.locationId}"/>','1');" /></td>
										<td><input type="button" value="Add/Edit" id="addBtn2" onclick="editLocation('<c:out value="${locationDTO2.locationId}"/>');" /><input type="button" id="deleteLocation2" value="Delete" onclick="deleteAdditionalLocation('<c:out value="${locationDTO2.locationId}"/>','2');" /></td>
										<td><input type="button" value="Add/Edit" id="addBtn3" onclick="editLocation('<c:out value="${locationDTO3.locationId}"/>');" /><input type="button" id="deleteLocation3" value="Delete" onclick="deleteAdditionalLocation('<c:out value="${locationDTO3.locationId}"/>','3');" /></td>
									</tr>
								</table>
							</fieldset>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Slideshow section end here -->
		<!--show right div only if user not logged in -->
		<!-- Main text div end here -->

		<%@include file="../common/bottom.jsp"%>
	</div>
	<!-- wrapper end here -->


	<div class="tip-wrap" style="position: absolute; top: 586px; left: 396px; display: none;">
		<div class="tip-top"></div>
		<div class="tip">
			<div class="tip-title">Merchant Name</div>
			<div class="tip-text"></div>
		</div>
		<div class="tip-bottom"></div>
	</div>
</body>

<script type="text/javascript">
$(function(){
	var retVal = $.ajax({
		url : "jsonGetHotDealz",
		type : "POST",
		global : false,
		dataType : "json",
		async : false
	}).responseText;
	//alert(retVal);
	var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
	if (obj != null) {
		var bannerArr = obj.bannerDTOs;
		var sliderImage='';
		for(var i=0;i<bannerArr.length;i++){
			'<c:set var="merchantName" value="'+bannerArr[i].merchantName+'" />';
			<c:set var="merchantName1" value="${fn:split(merchantName, ' ')}" />
			<c:set var="merchantName2" value="${fn:join(merchantName1, '-')}" />
			sliderImage +='<a href="merchant/${merchantName2}-'+bannerArr[i].merchantId+'"><img src="displayImage?image='+bannerArr[i].imagePath+'" style="height:170px;" class="wrap" id="wrap'+(i+1)+'" style="display: none;"/></a>';
		}
		$("#slider").append(sliderImage);
	}
	
	if('<c:out value="${locationDTO1.locationId}"/>'==''){
		$("#deleteLocation1").hide();
		//$("#addBtn1").hide();
		$("#addBtn2").hide();
	}
	if('<c:out value="${locationDTO2.locationId}"/>'==''){
		$("#deleteLocation2").hide();
		$("#addBtn3").hide();
		//$("#addBtn2").hide();
	}
	if('<c:out value="${locationDTO3.locationId}"/>'==''){
		$("#deleteLocation3").hide();
		//$("#addBtn3").hide();
	}
});
	function editLocation(locationId) {
		window.parent.$("#dashboard-area").load(
				"editLocation?locationId=" + locationId);
	}

	function deleteAdditionalLocation(locId,id) {
		$.alert.open('confirm', 'Do you want delete location.?', function(button) {
			if (button == 'yes') {
			var retVal = $.ajax({
				url : "deleteAdditionalLocation",
				type : "POST",
				global : false,
				data : {
					locId : locId
				},
				dataType : "json",
				async : false
			}).responseText;
	
			var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
	
			if (obj != null) {
				if (obj.jsonMessage != null) {
					alert(obj.jsonMessage);
				} else {
					window.location.href="manageLocation";
					alert('Location deleted successfully.');
				}
			} else {
				alert('Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator.');
			}
				}
		});
	}
</script>

</html>