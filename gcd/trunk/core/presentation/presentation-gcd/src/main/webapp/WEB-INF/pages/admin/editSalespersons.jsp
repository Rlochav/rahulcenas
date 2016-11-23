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
					<div id="title">ALL GET CITY DEALZ SALES PEOPLE</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp;<a href="salesPeople" class="link1">Return to All Sales People</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form method="post" name="allHotDealzForm" action="allHotDealzForm" modelAttribute="uploadForm" enctype="multipart/form-data">
						<div class="profile">
							<input type="text" style="display: none;" id="docType" name="docType" value="1">
							<table cellspacing="0" cellpadding="0" style="width: 100%;" class="tableStyle custom_td">
								<tr>
									<td><label>First Name<span class="star">&nbsp;*</span></label></td>
									<td><input type="hidden" style="display: none;" id="spId" value="${salesPDTO.salesPersonId}" /> <input type="text" name="salesPersonFirstName" id="salesPersonFirstName" class="mInput" size="50" value="${salesPDTO.salesPersonFirstName}"></td>
									<td><label>Last Name<span class="star">&nbsp;*</span></label></td>
									<td><input type="text" name="salesPersonLastName" id="salesPersonLastName" value="${salesPDTO.salesPersonLastName}" class="mInput" size="40"></td>
									<td><label>Status</label></td>
									<td><select id="status" name="status" class="mSelect" size="1">
											<option value="1" selected="selected">Active</option>
											<option value="0">Inactive</option>
									</select></td>
									<td class="button2"><input type="button" class="mediumBtn" value="${btnName}" onclick="saveSalesPerson();" /></td>
								</tr>
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
		
			var retVal = $.ajax({
				url : "../jsonGetHotDealz",
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
					sliderImage +='<a href="merchant/${merchantName2}-'+bannerArr[i].merchantId+'"><img src="../displayImage?image='+bannerArr[i].imagePath+'" style="height:170px;" class="wrap" id="wrap'+(i+1)+'" style="display: none;"/></a>';
				}
				$("#slider").append(sliderImage);
			}
		
		
		$("#status").val('<c:out value="${salesPDTO.status}"/>');
	});

	function saveSalesPerson() {
		if (trimString($("#salesPersonFirstName").val()) == "") {
			appFocus($("#categoryName"));
			$.alert.open('error', 'First Name is Missing.');
			return false;
		}
		if (trimString($("#salesPersonLastName").val()) == "") {
			appFocus($("#salesPersonLastName"));
			$.alert.open('error', 'Last Name is Missing.');
			return false;
		}
		var retVal = $.ajax({
			url : "jsonSaveSalesPerson",
			type : "POST",
			global : false,
			data : {
				spId : $("#spId").val(),
				firstName : $("#salesPersonFirstName").val(),
				lastName : $("#salesPersonLastName").val(),
				status : $("#status").val()
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
		if (obj != null) {
			if (obj.jsonMessage == null || obj.jsonMessage == "") {
				$.alert.open('info', 'Sales Person saved sucessfully.');
				window.location.href = "salesPeople";
			} else {
				$.alert.open('error', obj.jsonMessage);
			}
		} else {
			$.alert.open('error', 'Error');
		}
	}
</script>
</html>