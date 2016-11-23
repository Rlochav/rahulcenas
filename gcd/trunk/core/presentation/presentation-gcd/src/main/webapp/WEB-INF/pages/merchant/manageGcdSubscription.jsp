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
				<div id="system-message-container" style="display: none;">
					<dl id="system-message">
						<dt class="message">Message</dt>
						<dd class="message message">
							<ul>
								<li><span id="message"></span></li>
							</ul>
						</dd>
					</dl>
				</div>
				<div id="dashboard-area">
					<div id="title">
						Your Current get City Dealz Subscription : <span id="levelName_Span">
					</div>
					<br>

					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Manage Your Subscription
						</em>
					</h3>
					<div class="items">
						<form:form id="merchantLevelForm" name="merchantLevelForm" class="formStyle" modelAttribute="chooseLevelForm">
							<input type="hidden" value="${levelId}" id="currentLevel" name="currentLevel">
							<table cellspacing="0" cellpadding="0">
								<tbody>
									<tr>
										<th width="20%">Change Level:</th>
										<td><form:select path="path1" cssClass="mSelect">
												<form:option value="-1" label="--Select--"></form:option>
												<form:options items="${levelMap}" />
											</form:select></td>
										<td width="20%" class="button2"><input type="button" class="mediumBtn" value="Update" onclick="updateLevel();"></td>
									</tr>
								</tbody>
							</table>
						</form:form>
					</div>
					<br>
				</div>
			</div>
		</div>

		<!-- Slideshow section end here -->
		<!--show right div only if user not logged in -->
		<!-- Main text div end here -->
		<%@include file="../common/bottom.jsp"%>
	</div>
	<!-- wrapper end here -->
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

$("#path1").val('<c:out value="${levelId}"/>');
$("#currentLevel").val('<c:out value="${levelId}"/>');
$("#levelName_Span").html($("#path1 option:selected").text());
});

function updateLevel() {		
var retVal = $.ajax({
	url : "jsonUpgradeSubscription",
	type : "POST",
	global : false,
	data : {
		currentLevel : $("#currentLevel").val(),
		changedLevel : $("#path1").val()
	},
	dataType : "json",
	async : false
}).responseText;

var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
if (obj != null) {
	if (obj.response != null) {
		alert('error', obj.response);
	} else {
		$("#levelName_Span").html($("#path1 option:selected").text());
		$("#currentLevel").val($("#path1").val());
		$("#system-message-container").show();
		$("#message").html('Level updated sucessfully.');
	}
}
}
</script>

</html>