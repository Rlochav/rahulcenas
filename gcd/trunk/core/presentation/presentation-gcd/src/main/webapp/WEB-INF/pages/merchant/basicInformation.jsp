<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/main.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/screens.css'/>">
<link rel="shortcut icon" href="resources/images/icon.png">
<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<script type="text/javascript" src="<c:url value='resources/js/CommonFunction.js'/>"></script>
<link href="<c:url value='resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='resources/js/js-image-slider.js'/>"></script>
<script src="<c:url value='resources/js/main.js'/>"></script>
</head>
<body class="darkGradientBG">
	<%@include file="../common/telliumTags.jsp"%>
	<form:form id="basicInformationForm" name="basicInformationForm" class="formStyle">
		<h3 class="msg">
			<em>Hi There blue manage Your Basic Information</em>
			<div class="errorDiv" style="position: absolute; right: 0px; top: 10px;">
				<label class="error" id="error"></label>
			</div>
			<div style="position: absolute; right: 0px; top: 10px; color: green;">
				<label id="success"></label>
			</div>
		</h3>
		<div class="postDealz">
			<fieldset>
				<legend>Basic Details</legend>
				<fieldset class="sub_fieldset">
					<div class="form_fields">
						<label>Merchant Name<span class="mandatory">*</span></label><input type="text" id="name">
					</div>
					<div class="form_fields">
						<label>&nbsp;</label>
					</div>
					<div class="form_fields">
						<label>Contact First Name<span class="mandatory">*</span></label><input type="text" id="name">
					</div>
				</fieldset>
			</fieldset>
			<div style="float: right;">
				<input type="button" class="mediumBtn" name="submitDeal" id="submitDeal" value="Submit Deal" onclick="saveMerchantDealz();" />
			</div>
	</form:form>
</body>

</html>