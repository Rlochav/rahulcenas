<%@include file="common/taglibs.jsp"%>
<html>
<head>
<link href="<c:url value='resources/css/screens.css'/>" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/main.css'/>">
<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<script type="text/javascript" src="<c:url value='resources/js/CommonFunction.js'/>"></script>
<script src="<c:url value='resources/common/js/base/jquery-ui.js'/>"></script>
<link rel="stylesheet" href="<c:url value='resources/common/themes/start/jquery.ui.all.css'/>">
</head>
<body class="darkGradientBG">
	<form:form method="post" id="doxForm" name="doxForm" action="upload?dealzId=${dealzId}" modelAttribute="uploadForm" enctype="multipart/form-data">
		<h3 class="msg">
			<em>Upload</em>
		</h3>
		<div class="errorDiv">
			<label class="error" id="error"></label>
		</div>
		<div style="text-align: center;">
			<input type="text" style="display: none;" id="docType" name="docType" value="<c:out value="${docType}"/>"> <label>Upload default business logo <span style="color: red;">*</span></label> <input
				type="file" name="files" style="width: 64%" /> <input type="button" onclick="uploadFileSunc();" id="uploadBtn" value="Upload" class="mediumBtn" />
		</div>
	</form:form>
</body>
<script type="text/javascript">
	function uploadFileSunc() {
		document.doxForm.action = 'upload?dealzId=<c:out value="${dealzId}"/>';
		document.doxForm.submit();
		window.parent.reloadForm();
	}
</script>
</html>