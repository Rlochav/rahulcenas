<%@include file="../../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="common.html.000001"></spring:message></title>

<script type="text/javascript" src="<c:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>">
<link rel="shortcut icon" href="/resources/images/icon.png" />

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
					<div id="title">EDIT ${SESSION_ATTR_USER_INFO.cityText} : ${merchantDto.merchantName}'s ${dealzDTO.title}</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp; <a href="merchantList" class="link1">Return to All ${SESSION_ATTR_USER_INFO.cityText} Merchants</a> &nbsp; <a href="merchantmgmt	" class="link1">Return to ${SESSION_ATTR_USER_INFO.cityText} Dashboard</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form method="post" name="uploadMediaFiles" action="uploadMediaFiles?merchantId=${merchantId}" modelAttribute="uploadForm" enctype="multipart/form-data">
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
									<td><input type="checkbox" name="showOnPages[1]" /></td>
									<td><input type="file" name="files[1]" /></td>
								</tr>
								<tr>
									<td><input type="text" class="mInput" name="docTitle[2]" /></td>
									<td><input type="checkbox" name="showOnPages[2]" /></td>
									<td><input type="file" name="files[2]" /></td>
								</tr>
								<tr>
									<td colspan="3" align="right"><input type="submit" value="Add New / Replace Media" class="xlBtn" /> <input type="button" value="Reset" class="mediumBtn" />
								</tr>
							</table>
						</div>
					</form:form>
				</div>
			</div>
			<strong> </strong>
		</div>
		<strong><%@include file="../../common/bottom.jsp"%></strong>
	</div>
</body>
<script type="text/javascript">
$(document).ready(function() {
if ('<c:out value="${message}"/>'.length > 0) {
	$.alert.open('error', '<c:out value="${message}"/>');
}
});

function updateTitle(docId) {
var retVal = $.ajax({
	url : "../updateMediaTitle",
	type : "POST",
	global : false,
	data : {
		merchantId : ${merchantId},
		docId : docId,
		title : $("#editableTitle"+docId).val()
	},
	dataType : "json",
	async : false
}).responseText;

var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);

if (obj != null) {
	if (obj.jsonMessage != null) {
		$.alert.open('error', obj.jsonMessage);
	} else {				
		$("#editableTitle").val(obj.documentTitle);
		$.alert.open('info', 'Updated successfully.');
	}
} else {
	$.alert.open('error','Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator.');
}
}

function deleteMediaFile(docId) {
	$.alert.open('confirm', 'Do you want delete media.?', function(button) {
		if (button == 'yes') {
			var retVal = $.ajax({
				url : "../deleteMediaFile",
				type : "POST",
				global : false,
				data : {
					merchantId : ${merchantId},
					docId : docId
				},
				dataType : "json",
				async : false
			}).responseText;

			var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);

			if (obj != null) {
				if (obj.jsonMessage != null) {
					$("#error").html('<li>' + obj.jsonMessage + '</li>');
				} else {
					$("#" + docId).remove();
				}
			} else {
				$("#error").html(
						'<li>Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator.</li>');
			}		
		}
	});
}
</script>

</html>