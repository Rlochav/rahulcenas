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

<link href="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/css/alert.css'/>" rel="stylesheet" />
<link href="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/themes/light/theme.css'/>" rel="stylesheet" />
<script src="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/js/alert.js'/>"></script>

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
						List of All Daily Deals <br>
					</div>
					<br>
					<%-- <h3 class="msg">
						<em>Hi there ${SESSION_ATTR_USER_INFO.userName} Manage Your Locations<br>
						</em>
					</h3> --%>
					<br>
					<div class="items">
						<div id="midContentDiv">
							<form:form method="post" name="allHotDealzForm" action="allHotDealzForm" modelAttribute="uploadForm" enctype="multipart/form-data">
								<div class="profile">
									<input type="text" style="display: none;" id="docType" name="docType" value="1">
									<div id="NoDealFound" style="display: none; margin-left: 5px;">
										<span>No deal created yet.</span><br /> <input type="button" onclick="createNewDeal();" value="Add a Deal" />
									</div>
									<table class="tableStyle" id="dealzList" style="width: 96%; margin: 2%;">
										<tr>
											<th>Deal Date</th>
											<th>Deal Title</th>
											<th>Deal Description</th>
											<th>Deal Status</th>
											<th>&nbsp;</th>
										</tr>
										<c:forEach var="dealz" items="${dealzDTO}">
											<tr id="row${dealz.dealId}">
												<td class="mReadOnlyLabel">${dealz.createDateText}</td>
												<td class="mReadOnlyLabel">${dealz.title}</td>
												<td class="mReadOnlyLabel">${dealz.description}</td>
												<td class="mReadOnlyLabel">${dealz.statusText}</td>
												<td>
													<%-- <c:if test="${dealz.statusText!='Active'}"> --%> <input type="button" onclick="editHotDealz('${dealz.dealId}');" style="font-size: 12px; padding: 2px 7px;" id="${dealz.dealId}" value="Edit" /> <input type="button" style="font-size: 12px; padding: 2px 7px;"
													onclick="deleteHotDealz('${dealz.dealId}','${dealz.merchantId}');" id="${dealz.dealId}" value="Delete" /> <%-- </c:if> --%>
												</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</form:form>
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
	$(function() {		
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
		
		
		if ('<c:out value="${error}"/>'.length > 0) {
			$.alert.open('confirm', '<c:out value="${error}"/>', function(
					button) {
				if (button == 'yes') {
					window.location.href='manageGcdSubscription';
				}
			});
		}
		
		if('<c:out value="${dealzDTO}"/>'==""){
			$("#dealzList").hide();
			$("#NoDealFound").show();
		}
	});

	function editHotDealz(dealId) {
		window.location.href = 'postDealz?dealId=' + dealId
				+ '&dealType=<c:out value="${dealType}"/>';
	}

	function deleteHotDealz(dealzId, merchantId) {
		$.alert.open('confirm', 'Do you want delete dealz.?', function(button) {
			if (button == 'yes') {
				var retVal = $.ajax({
					url : "component/deleteMerchantDealz",
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
	
	function createNewDeal() {
		window.location.href = 'postDealz?dealType=<c:out value="${dealType}"/>';
	}
</script>
</html>