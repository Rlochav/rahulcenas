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
						HI ${SESSION_ATTR_USER_INFO.userName}, MANAGE YOUR MEDIA<br>
					</div>
					<br>
					<%-- <h3 class="msg">
						<em>Hi there ${SESSION_ATTR_USER_INFO.userName} Manage Your Locations<br>
						</em>
					</h3> --%>
					<br>
					<div class="items">
						<div id="midContentDiv">
							<form:form method="post" name="uploadMediaFiles" action="uploadMediaFiles" modelAttribute="uploadForm" enctype="multipart/form-data">
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
												<th>Document Title</th>
												<th>Type</th>
												<th>Date Uploaded</th>
												<th>Show on Page</th>
												<th>&nbsp;</th>
											</tr>
											<c:forEach var="documentDTOList" items="${documentDTO}">
												<tr id="${documentDTOList.docId}">
													<td><input type="text" value="${documentDTOList.documentTitle}" class="mInput" id="editableTitle${documentDTOList.docId}" maxlength="100" /></td>
													<td class="mReadOnlyLabel">${documentDTOList.contentType}</td>
													<td class="mReadOnlyLabel">${documentDTOList.createDateText}</td>
													<td class="mReadOnlyLabel">${documentDTOList.showOnPage}</td>
													<td><input type="button" id="deletDocx" value="Delete" class="mediumBtn" onclick="deleteMediaFile('${documentDTOList.docId}');" /> <input type="button" id="deletDocx" value="Update" class="mediumBtn" onclick="updateTitle('${documentDTOList.docId}');" /></td>
												</tr>
											</c:forEach>

										</table>
									</div>
								</div>
								<div style="margin-bottom: 5%"></div>
								<h3 class="msg">
									<em>Add New Media</em>
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
											<th>Document Title</th>
											<th>Show on Page</th>
											<th>&nbsp;</th>
										</tr>
										<tr>
											<td><input type="text" class="mInput" name="docTitle[0]" id="docTitle0" /></td>
											<td><input type="checkbox" name="showOnPages[0]" id="showOnPages0" /></td>
											<td><input type="file" name="files[0]" id="files0" /></td>
										</tr>
										<tr>
											<td><input type="text" class="mInput" name="docTitle[1]" /></td>
											<td><input type="checkbox" name="showOnPages[1]" id="showOnPages1" /></td>
											<td><input type="file" name="files[1]" id="files1" /></td>
										</tr>
										<tr>
											<td><input type="text" class="mInput" name="docTitle[2]" /></td>
											<td><input type="checkbox" name="showOnPages[2]" id="showOnPages2" /></td>
											<td><input type="file" name="files[2]" id="files2" /></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td align="right"><input type="submit" value="Add New Media" class="xlBtn" /> <input type="button" value="Reset" onclick="resetAll();" class="mediumBtn" />
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
			url : "updateMediaTitle",
			type : "POST",
			global : false,
			data : {
				docId : docId,
				title : $("#editableTitle" + docId).val()
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
		$.alert.open('confirm', 'Do you want delete media.?', function(button) {
			if (button == 'yes') {
				var retVal = $.ajax({
					url : "deleteMediaFile",
					type : "POST",
					global : false,
					data : {
						docId : docId
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