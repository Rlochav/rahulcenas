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
						HI ${SESSION_ATTR_USER_INFO.userName}, MANAGE YOUR Embeds<br>
					</div>
					<br>
					<%-- <h3 class="msg">
						<em>Hi there ${SESSION_ATTR_USER_INFO.userName} Manage Your Locations<br>
						</em>
					</h3> --%>
					<br>
					<div class="items">
						<div id="midContentDiv">
							<form:form method="post" name="uploadMediaFiles" action="saveEmbeds" modelAttribute="merchantEmbeds">
								<h3 class="msg">
									<em>Manage Media</em>
									<div class="errorDiv" style="position: absolute; right: 0px; top: 10px;">
										<label class="error" id="error"></label>
									</div>
									<div id="success" class="success">
										<label></label>
									</div>
								</h3>
								<div class="profile">
									<input type="text" style="display: none;" id="docType" name="docType" value="1">
									<div style="max-height: 200px; overflow-y: scroll;">
										<table class="tableStyle" style="width: 100%;">
											<tr>
												<th>Embed Content Code</th>
												<th>Embed Content Title</th>
												<th>Created Date</th>
												<th>Show on Page</th>
												<th>&nbsp;</th>
											</tr>
											<c:forEach var="embedsDTOs" items="${embedsDTOs}">
												<tr id="${embedsDTOs.embedId}">
													<td><input type="text" name="embedContent_${embedsDTOs.embedId}" id="embedContent_${embedsDTOs.embedId}" value="${embedsDTOs.embedContent}" /></td>
													<td><input type="text" value="${embedsDTOs.embedTitle}" id="embedTitle_${embedsDTOs.embedId}" name="embedTitle_${embedsDTOs.embedId}" maxlength="100" /></td>
													<td class="mReadOnlyLabel">${embedsDTOs.createDateText}</td>
													<td class="mReadOnlyLabel"><script type="text/javascript">
															if('<c:out value="${embedsDTOs.showOnPage}"/>'=="Yes")
															document.write('<input type="checkbox" name="showOnPage_${embedsDTOs.embedId}" id="showOnPage_${embedsDTOs.embedId}" checked/>');
															if('<c:out value="${embedsDTOs.showOnPage}"/>'=="No")
																document.write('<input type="checkbox" name="showOnPage_${embedsDTOs.embedId}" id="showOnPage_${embedsDTOs.embedId}"/>');
														</script></td>
													<td><input type="button" id="deletDocx" value="Delete" class="mediumBtn" onclick="deleteMediaFile('${embedsDTOs.embedId}');" /> <input type="button" id="deletDocx" value="Update" class="mediumBtn" onclick="updateTitle('${embedsDTOs.embedId}');" /></td>
												</tr>
											</c:forEach>
										</table>
									</div>
								</div>
								<div style="margin-bottom: 5%"></div>
								<h3 class="msg">
									<em>Add Embed Content</em>
									<div class="errorDiv" style="position: absolute; right: 0px; top: 10px;">
										<label class="error" id="error"></label>
									</div>
									<div id="success" class="success">
										<label></label>
									</div>
								</h3>
								<div class="profile">
									<table class="tableStyle custom_tab" style="width: 100%;">
										<tr>
											<th>Embed Content Code</th>
											<th>Show on Page</th>
											<th>Embed Content Title</th>
										</tr>
										<tr>
											<td><form:input path="embedContent" /></td>
											<td><form:checkbox path="isShowOnPage" /></td>
											<td><form:input path="embedTitle" /></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td align="right"><input type="submit" value="Add Embed" class="xlBtn" /> <input type="button" value="Reset" onclick="resetAll();" class="mediumBtn" />
										</tr>
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
});
	$(document).ready(function() {
		if('<c:out value="${message}"/>'.length>0)
		$.alert.open('info','<c:out value="${message}"/>');
		//$("#error").html('<c:out value="${message}"/>');
	});

	function updateTitle(docId) {
		var retVal = $.ajax({
			url : "updateEmbeds",
			type : "POST",
			global : false,
			data : {
				embedId : docId,
				title : $("#embedTitle_" + docId).val(),
				content : $("#embedContent_" + docId).val(),
				showOnPage : $("#showOnPage_" + docId).is(':checked')==true?"true":"false"
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);

		if (obj != null) {
			if (obj.jsonMessage != null) {
				$("#error").html("");
				$("#error").html('<li>' + obj.jsonMessage + '</li>');
			} else {
				$("#editableTitle").val(obj.documentTitle);
				$.alert.open('info', 'Updated successfully.');
			}
		} else {
			$("#error").html("");
			$("#error").html(
					'<li>Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator.</li>');
		}
	}

	function deleteMediaFile(docId) {
		$.alert.open('confirm', 'Do you want delete document.?', function(button) {
			if (button == 'yes') {
				var retVal = $.ajax({
					url : "deleteEmbeds",
					type : "POST",
					global : false,
					data : {
						embedId : docId
					},
					dataType : "json",
					async : false
				}).responseText;

				var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);

				if (obj != null) {
					if (obj.jsonMessage != null) {
						$.alert.open('error', obj.jsonMessage);
					} else {
						$("#" + docId).remove();
						$.alert.open('info', 'Document deleted sucessfully.');
					}
				} else {
					$.alert.open('error',
							'Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator.');
				}
			}
		});
	}

	function resetAll() {
		$("#docTitle0").val("");
		$("#docTitle1").val("");
		$("#docTitle2").val("");
		$("#showOnPages0").attr('checked', false);
		$("#showOnPages1").attr('checked', false);
		$("#showOnPages2").attr('checked', false);
		$("#files0").val("");
		$("#files1").val("");
		$("#files2").val("");
	}	
</script>

</html>