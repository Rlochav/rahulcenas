<%@include file="../../common/taglibs.jsp"%>
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

<link href="<c:url value='/resources/css/multiple-select.css'/>" rel="stylesheet" type="text/css" />
<script src="http://wenzhixin.net.cn/p/multiple-select/jquery.multiple.select.js"></script>

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
					<div id="title">${SESSION_ATTR_USER_INFO.cityText}:AddNewMerchant</div>
					<br>
					<div align="right">
						<a href="adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp; <a href="merchantmgmt" class="link1">Return to ${SESSION_ATTR_USER_INFO.cityText} Dashboard</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form method="POST" id="addNewMerchantForm1" name="addNewMerchantForm1" class="formStyle" modelAttribute="addNewMerchantForm" enctype="multipart/form-data">
						<div class="profile">
							<fieldset>
								<legend>Basic Details</legend>
								<table style="width: 100%;">
									<tr>
										<td><label>Merchant Name:<span style="color: red;">*</span></label></td>
										<td><form:input path="merchantName" cssClass="mInput" /></td>
										<td><label>Get City Dealz Name:<span style="color: red;">*</span></label></td>
										<td><form:input path="getCityDealzName" cssClass="mInput" /></td>
									</tr>
									<tr>
										<td><label>Contact First Name:</label></td>
										<td><form:input path="contactFirstName" cssClass="mInput" /></td>
										<td><label>Last Name:</label></td>
										<td><form:input path="contactLastName" cssClass="mInput" /></td>
									</tr>
									<tr>
										<td><label>Business Phone:</label></td>
										<td><form:input path="businessPhone" maxlength="15" cssClass="mInput" /></td>
										<td><label>Alternate Phone :</label></td>
										<td><form:input path="contactAlternatePhone" maxlength="15" cssClass="mInput" /></td>
									</tr>
									<tr>
										<td><label>Password :<span style="color: red;">*</span></label></td>
										<td><form:password path="password" cssClass="mInput" /></td>
										<td><label>Repeat Password :<span style="color: red;">*</span></label></td>
										<td><input type="password" id="cPwd" class="mInput" /></td>
									</tr>
									<tr>
										<td><label>Email :<span style="color: red;">*</span></label></td>
										<td><form:input path="emailId" cssClass="mInput" /></td>
										<td><label>Website URL :<span style="color: red;">*</span></label></td>
										<td><form:input path="websiteUrl" cssClass="mInput" /></td>
									</tr>
								</table>
							</fieldset>
							<fieldset class="address-field">
								<legend>Physical Address</legend>
								<table style="width: 100%;">
									<tr>
										<td><label>Address1 :</label></td>
										<td><form:input path="address1" cssClass="mInput" /></td>
										<td><label>Address2 :</label></td>
										<td><form:input path="address2" cssClass="mInput" /></td>
										<td><label>Address3 :</label></td>
										<td><form:input path="address3" cssClass="mInput" /></td>
									</tr>
									<tr>
										<td><label>City :</label></td>
										<td><form:input path="cityToDisplay" cssClass="mInput" /></td>
										<td><label>State :</label></td>
										<td><form:input path="state" cssClass="mInput" /></td>
										<td><label>Zip Code :<span style="color: red;">*</span></label></td>
										<td><form:input path="zipCode" cssClass="mInput" /></td>
									</tr>

								</table>
								<div class="innerDiv">
									<label>Business Hours :To have your business hours display on separate lines in your profile, please place a comma (,) to indicate where the current line ends and the new begins</label>
									<textarea maxlength="200" rows="3" cols="2" name="businessHours" id="businessHours" style="width: 99%; resize: none;">${merchantDTO.businessHours}</textarea>

									<div class="form_fields" style="width: 100%;">
										<input type="checkbox" onclick="billingAddressChk();" name="isDifferentBillingAddress" id="isDifferentBillingAddress" style="float: left;" /> <label style="line-height: 20px;">Different Billing Address ?</label>
									</div>
								</div>
							</fieldset>
							<div id="bill-add" style="display: none;">
								<fieldset class="address-field">
									<legend>Billing Address</legend>
									<table style="width: 100%;">
										<tr>
											<td><label>Address 1</label></td>
											<td><form:input path="bAddress1" cssClass="mInput" /></td>
											<td><label>Address 2</label></td>
											<td><form:input path="bAddress2" cssClass="mInput" /></td>
											<td><label>Address 3</label></td>
											<td><form:input path="bAddress3" cssClass="mInput" /></td>
										</tr>
										<tr>
											<td><label>City</label></td>
											<td><input type="text" name="bCity" id="bCity" value="${SESSION_ATTR_USER_INFO.cityText}" cssClass="mInput" /></td>
											<td><label>State</label></td>
											<td><form:select path="bState" cssClass="mSelect">
													<form:option value="1" label="LA"></form:option>
												</form:select></td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
									</table>
								</fieldset>
							</div>
							<fieldset>
								<legend>Select Categories/Sub-categoriess</legend>
								<table class="items_list" width="100%" cellpadding="0" cellspacing="0">
									<tr>
										<td><label class="mReadOnlyLabel">Master Category :</label></td>
										<td><form:select path="masterCategory" cssClass="mSelect">
												<form:options items="${masterCategory}" />
											</form:select></td>
										<td><label>&nbsp;</label></td>
										<td><select class="mSelect" style="visibility: hidden;" name="masterCategory">
										</select></td>
									</tr>
								</table>
							</fieldset>
							<fieldset>
								<legend>Select Categories/Sub-categoriess</legend>
								<table class="items_list" width="100%" cellpadding="0" cellspacing="0">
									<tr>
										<td><label class="mReadOnlyLabel">Category1 :<span style="color: red;">*</span></label></td>
										<td><form:select path="category1" cssClass="mSelect" onchange="onChageCategory1();">
												<form:option value="-1" label="--Select--"></form:option>
												<form:options items="${categoryMap}" />
											</form:select></td>
										<td><label class="mReadOnlyLabel">Sub-Category1 :</label></td>
										<td><form:select path="subCategory1" cssClass="mSelect">
												<form:options items="${null}" />
											</form:select></td>
									</tr>
									<tr>
										<td><label class="mReadOnlyLabel">Category2 :</label></td>
										<td><form:select path="category2" cssClass="mSelect" onchange="onChageCategory2();">
												<form:option value="-1" label="--Select--"></form:option>
												<form:options items="${categoryMap}" />
											</form:select></td>
										<td><label class="mReadOnlyLabel">Sub-Category2 :</label></td>
										<td><form:select path="subCategory2" cssClass="mSelect">
												<form:options items="${null}" />
											</form:select></td>
									</tr>
								</table>
							</fieldset>
							<fieldset>
								<legend>Other Address</legend>
								<table class="tableStyle" style="width: 96%; margin: 2%;">
									<tr>
										<th>Second Location</th>
										<th>Third Location</th>
										<th>Fourth Location:</th>
									</tr>
									<tr>
										<td><label class="addrs1"><input type="hidden" id="locationId_othrLoc1" value="${merchantDTO.locationDTOs[0].locationId}" name="locationDTOs[0].locationId" /><input type="text" placeholder="Street Address" value="${merchantDTO.locationDTOs[0].address1}"
												id="streetAddress_othrLoc1" name="locationDTOs[0].address1" /></label></td>
										<td><label class="addrs2"><input type="hidden" id="locationId_othrLoc2" value="${merchantDTO.locationDTOs[1].locationId}" name="locationDTOs[1].locationId" /><input type="text" placeholder="Street Address" value="${merchantDTO.locationDTOs[1].address1}"
												id="streetAddress_othrLoc1" name="locationDTOs[1].address1" /></label></td>
										<td><label class="addrs3"><input type="hidden" id="locationId_othrLoc3" value="${merchantDTO.locationDTOs[2].locationId}" name="locationDTOs[2].locationId" /><input type="text" placeholder="Street Address" value="${merchantDTO.locationDTOs[2].address1}"
												id="streetAddress_othrLoc1" name="locationDTOs[2].address1" /></label></td>
									</tr>
									<tr>
										<td><label class="addrs1"><input type="text" placeholder="City" value="${merchantDTO.locationDTOs[0].city}" id="city_othrLoc1" name="locationDTOs[0].city" /></label></td>
										<td><label class="addrs2"><input type="text" placeholder="City" value="${merchantDTO.locationDTOs[1].city}" id="city_othrLoc2" name="locationDTOs[1].city" /></label></td>
										<td><label class="addrs3"><input type="text" placeholder="City" value="${merchantDTO.locationDTOs[2].city}" id="city_othrLoc3" name="locationDTOs[2].city" /></label></td>
									</tr>
									<tr>
										<td><label class="addrs1"><input type="text" placeholder="State" value="${merchantDTO.locationDTOs[0].state}" id="state_othrLoc1" name="locationDTOs[0].state" /></label></td>
										<td><label class="addrs2"><input type="text" placeholder="State" value="${merchantDTO.locationDTOs[1].state}" id="state_othrLoc2" name="locationDTOs[1].state" /></label></td>
										<td><label class="addrs3"><input type="text" placeholder="State" value="${merchantDTO.locationDTOs[2].state}" id="state_othrLoc3" name="locationDTOs[2].state" /></label></td>
									</tr>
									<tr>
										<td><label class="addrs1"><input type="text" placeholder="Zip Code" value="${merchantDTO.locationDTOs[0].zipCode}" id="zipCode_othrLoc1" name="locationDTOs[0].zipCode" /></label></td>
										<td><label class="addrs2"><input type="text" placeholder="Zip Code" value="${merchantDTO.locationDTOs[1].zipCode}" id="zipCode_othrLoc2" name="locationDTOs[1].zipCode" /></label></td>
										<td><label class="addrs3"><input type="text" placeholder="Zip Code" value="${merchantDTO.locationDTOs[2].zipCode}" id="zipCode_othrLoc3" name="locationDTOs[2].zipCode" /></label></td>
									</tr>
									<tr>
										<td><label class="addrs1"><input type="text" placeholder="Phone" value="${merchantDTO.locationDTOs[0].locationPhone}" id="locationContact_othrLoc1" name="locationDTOs[0].locationPhone" /></label></td>
										<td><label class="addrs2"><input type="text" placeholder="Phone" value="${merchantDTO.locationDTOs[1].locationPhone}" id="locationContact_othrLoc2" name="locationDTOs[1].locationPhone" /></label></td>
										<td><label class="addrs3"><input type="text" placeholder="Phone" value="${merchantDTO.locationDTOs[2].locationPhone}" id="locationContact_othrLoc3" name="locationDTOs[2].locationPhone" /></label></td>
									</tr>
									<tr>
										<td><label class="addrs1"><input type="text" placeholder="Hours" value="${merchantDTO.locationDTOs[0].locationHours}" id="locationHours_othrLoc1" name="locationDTOs[0].locationHours" /></label></td>
										<td><label class="addrs2"><input type="text" placeholder="Hours" value="${merchantDTO.locationDTOs[1].locationHours}" id="locationHours_othrLoc2" name="locationDTOs[1].locationHours" /></label></td>
										<td><label class="addrs3"><input type="text" placeholder="Hours" value="${merchantDTO.locationDTOs[2].locationHours}" id="locationHours_othrLoc3" name="locationDTOs[2].locationHours" /></label></td>
									</tr>
									<tr>
										<td><label class="addrs1"><form:select path="locationDTOs[0].neighborhood" cssClass="mSelect n1">
													<form:option value="-1" label="--Select--"></form:option>
													<form:options items="${neighborhoodMap}" />
												</form:select> </label></td>
										<td><label class="addrs2"><form:select path="locationDTOs[1].neighborhood" cssClass="mSelect n2">
													<form:option value="-1" label="--Select--"></form:option>
													<form:options items="${neighborhoodMap}" />
												</form:select></label></td>
										<td><label class="addrs3"><form:select path="locationDTOs[2].neighborhood" cssClass="mSelect n3">
													<form:option value="-1" label="--Select--"></form:option>
													<form:options items="${neighborhoodMap}" />
												</form:select></label></td>
									</tr>
									<tr>
										<td><label class="addrs1"><input type="text" placeholder="Contact Name" value="${merchantDTO.locationDTOs[0].contactFirstName}" id="contactFirstName_othrLoc1" name="locationDTOs[0].contactFirstName" /></label></td>
										<td><label class="addrs2"><input type="text" placeholder="Contact Name" value="${merchantDTO.locationDTOs[1].contactFirstName}" id="contactFirstName_othrLoc2" name="locationDTOs[1].contactFirstName" /></label></td>
										<td><label class="addrs3"><input type="text" placeholder="Contact Name" value="${merchantDTO.locationDTOs[2].contactFirstName}" id="contactFirstName_othrLoc3" name="locationDTOs[2].contactFirstName" /></label></td>
									</tr>
									<tr>
										<td><label class="addrs1"><input type="text" placeholder="e-Mail" value="${merchantDTO.locationDTOs[0].emailAddress}" id="emailAddress_othrLoc1" name="locationDTOs[0].emailAddress" /></label></td>
										<td><label class="addrs2"><input type="text" placeholder="e-Mail" value="${merchantDTO.locationDTOs[1].emailAddress}" id="emailAddress_othrLoc2" name="locationDTOs[1].emailAddress" /></label></td>
										<td><label class="addrs3"><input type="text" placeholder="e-Mail" value="${merchantDTO.locationDTOs[2].emailAddress}" id="emailAddress_othrLoc3" name="locationDTOs[2].emailAddress" /></label></td>
									</tr>
								</table>
							</fieldset>
							<fieldset>
								<legend>Other Details</legend>
								<table class="items_list" width="100%" cellpadding="0" cellspacing="0">
									<tr>
										<td><label>Neighborhood Name :<span style="color: red;">*</span></label></td>
										<td><form:select path="neighborhoodName" cssClass="mSelect">
												<form:option value="-1" label="--Select--"></form:option>
												<form:options items="${neighborhoodMap}" />
											</form:select></td>
										<td><label>Subscription Level :<span style="color: red;">*</span></label></td>
										<td><form:select path="subscriptionLevel" cssClass="mSelect" multiple="true">
												<form:option value="-1" label="--Select--"></form:option>
												<form:options items="${subcLevelMap}" />
											</form:select></td>
									</tr>
									<tr>
										<td><label>Google Analytics ID :</label></td>
										<td><form:input path="googleAnalyticsId" cssClass="mInput" /></td>
										<td><label>Merchant Features & Accessiblity :</label></td>
										<td><form:select path="merchantFeature" cssClass="mSelect" multiple="multiple" size="2" items="${featureMap}">
											</form:select></td>
									</tr>
									<tr>
										<td><label>Merchant Logo :</label></td>
										<td><input type="file" class="mInput" name="logo" /></td>
										<td><label>Sales Person :</label></td>
										<td><form:select path="salesPerson" cssClass="mSelect">
												<form:option value="-1" label="--Select--"></form:option>
												<form:options items="${salesPersonMap}" />
											</form:select></td>
									</tr>
								</table>
							</fieldset>
							<div style="float: right;">
								<input type="button" value="Reset" onclick="resetAll();" /> &nbsp;<input type="button" onclick="registerMerchant();" value="Add New Merchant" />
							</div>
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
	$(function() {
		$('#merchantFeature').multipleSelect();

		if ('<c:out value="${message}"/>'.length > 0) {
			$.alert.open('error', '<c:out value="${message}"/>');
		}
	});

	function registerMerchant() {
		if (validateForm()) {
			document.addNewMerchantForm1.action = 'doRegister';
			document.addNewMerchantForm1.submit();
		}
	}

	function validateForm() {
		if ($("#merchantName").val() == "") {
			appFocus($("#merchantName"));
			$.alert.open('error', 'Merchant Name Missing.');
			return false;
		}
		if ($("#getCityDealzName").val() == "") {
			appFocus($("#getCityDealzName"));
			$.alert.open('error', 'Get City Dealz Name Missing.');
			return false;
		}

		if ($("#password").val() == "") {
			appFocus($("#password"));
			$.alert.open('error', 'Password Missing.');
			return false;
		}

		if ($("#password").val() != "" && $("#cPwd").val() == "") {
			appFocus($("#cPwd"));
			$.alert.open('error', 'Confirm Password Missing.');
			return false;
		}

		if ($("#password").val() != "" && $("#cPwd").val() != "" && $("#password").val() != $("#cPwd").val()) {
			appFocus($("#cPwd"));
			$.alert.open('error', 'Passwords Do Not Match.');
			return false;
		}

		if ($("#emailId").val() == "") {
			appFocus($("#emailId"));
			$.alert.open('error', 'e-Mail Address Missing.');
			return false;
		}

		if (trimString($("#emailId").val()) != "") {
			var emailaddressVal = $("#emailId").val();
			var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
			var test_email = emailReg.test(emailaddressVal);
			if (test_email == false) {
				$.alert.open('error', 'e-Mail Address is invalid.');
				appFocus($("#emailId"));
				return false;
			}
		}

		if ($("#zipCode").val() == "") {
			appFocus($("#zipCode"));
			$.alert.open('error', 'Zip Code Missing.');
			return false;
		}

		if ($("#category1").val() == "-1") {
			appFocus($("#category1"));
			$.alert.open('error', 'Category1 is missing.');
			return false;
		}

		if ($("#neighborhoodName").val() == "-1") {
			appFocus($("#neighborhoodName"));
			$.alert.open('error', 'Neighborhood Name is missing.');
			return false;
		}

		if ($("#subscriptionLevel").val() == "-1") {
			appFocus($("#subscriptionLevel"));
			$.alert.open('error', 'Subscription Level missing.');
			return false;
		}

		var retVal = $.ajax({
			url : "verifyEmailUserId",
			type : "POST",
			global : false,
			data : {
				userId : $("#getCityDealzName").val(),
				emailId : $("#emailId").val()
			},
			dataType : "json",
			async : false
		}).responseText;
		//alert(retVal);
		var obj = retVal.length != 0 ? retVal : null;
		//console.log(obj);
		if (obj != null) {
			if (obj.indexOf('Mail') > 0) {
				appFocus($("#emailId"));
			} else {
				appFocus($("#getCityDealzName"));
			}
			$.alert.open('error', obj);
			return false;
		}

		return true;
	}

	function billingAddressChk() {
		if ($("#isDifferentBillingAddress").is(":checked") == true) {
			$("#bill-add").css('display', 'block');
		}
		if ($("#isDifferentBillingAddress").is(":checked") == false) {
			$("#bill-add").css('display', 'none');
		}
	}

	function onChageCategory1() {
		if (trimString($("#category1").val()) == '-1') {
			$("#subCategory1 option:selected").removeAttr("selected");
			return false;
		}
		var retVal = $.ajax({
			url : "../jsonGetSubCategoryByCtgId",
			global : false,
			type : "POST",
			data : {
				categoryId : $("#category1").val()
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);

		if (obj != null) {
			var subCmplntypMap = obj;
			if (subCmplntypMap != null) {
				var values4Cmb = new Array;
				var counter = 0;
				//values4Cmb[counter++] = new CodeValueStruct("-1", '--Select--');
				for ( var subCmplntVal in subCmplntypMap) {
					values4Cmb[counter++] = new CodeValueStruct(subCmplntVal, subCmplntypMap[subCmplntVal]);
				}
				fillCombo('subCategory1', values4Cmb);
				$("#subCategory1").attr("multiple", "multiple");
				$("#subCategory1 option:selected").removeAttr("selected");
			} else {
				fillCombo('subCategory1', new Array);
			}
		} else {
			fillCombo('subCategory1', new Array);
		}
	}

	function onChageCategory2() {
		if (trimString($("#category2").val()) == '-1') {
			$("#subCategory2 option:selected").removeAttr("selected");
			return false;
		}
		var retVal = $.ajax({
			url : "../jsonGetSubCategoryByCtgId",
			global : false,
			type : "POST",
			data : {
				categoryId : $("#category2").val()
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);

		if (obj != null) {
			var subCmplntypMap = obj;
			if (subCmplntypMap != null) {
				var values4Cmb = new Array;
				var counter = 0;
				//values4Cmb[counter++] = new CodeValueStruct("-1", '--Select--');
				for ( var subCmplntVal in subCmplntypMap) {
					values4Cmb[counter++] = new CodeValueStruct(subCmplntVal, subCmplntypMap[subCmplntVal]);
				}
				fillCombo('subCategory2', values4Cmb);
				$("#subCategory2").attr("multiple", "multiple");
				$("#subCategory2 option:selected").removeAttr("selected");
			} else {
				fillCombo('subCategory2', new Array);
			}
		} else {
			fillCombo('subCategory2', new Array);
		}
	}

	function resetAll() {
		$("#merchantName").val("");
		$("#getCityDealzName").val("");
		$("#contactFirstName").val("");
		$("#contactLastName").val("");
		$("#businessPhone").val("");
		$("#contactAlternatePhone").val("");
		$("#password").val("");
		$("#cPwd").val("");
		$("#emailId").val("");
		$("#websiteUrl").val("");
		$("#address1").val("");
		$("#address2").val("");
		$("#address3").val("");
		$("#city").val("");
		$("#state").val("");

		$("#zipCode").val("");
		$("#category1").val("-1");
		$("#category2").val("-1");
		$("#subCategory1").val("");
		$("#subCategory2").val("");
		$("#neighborhoodName").val("-1");
		$("#subscriptionLevel").val("-1");
		$("#googleAnalyticsId").val("");
		$("#salesPerson").val("-1");
		$("#merchantFeature").val("");
	}

	function showNeighborhoodAddress() {
		if ($('#neighborhoodName').val() != '-1') {
			$("#neighborhoodAddressDiv").show();
		} else {
			$("#neighborhoodAddressDiv").hide();
		}
	}

	function appFocus(obj) {
		try {
			obj.focus();
		} catch (e) {
		}
		try {
			$('#' + obj[0].id).addClass("focus");
			setTimeout('$("#' + obj[0].id + '").removeClass("focus");', 2500);
		} catch (e) {
			// TODO: handle exception
		}
	}
</script>

</html>