<%@include file="../../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="common.html.000001"></spring:message></title>

<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/template.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/rating.css'/>">
<link rel="shortcut icon" href="resources/images/icon.png" />
<link href="<c:url value='resources/css/media.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='resources/js/CommonFunction.js'/>"></script>
<link href="<c:url value='resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='resources/js/js-image-slider.js'/>"></script>

<link href="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/css/alert.css'/>" rel="stylesheet" />
<link href="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/themes/light/theme.css'/>" rel="stylesheet" />
<script src="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/js/alert.js'/>"></script>
</head>

<body>
	<%@include file="../../common/telliumTags.jsp"%>
	<div id="wrapper">
		<%@include file="../../common/header4.jsp"%>
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
					<div id="title">${SESSION_ATTR_USER_INFO.cityText}:${merchantDTO.merchantName}'SeditBASIC INFORMATION</div>
					<br>
					<div align="right">
						<a href="component/adminDashboard" class="link1">Return to Main Dashboard</a> &nbsp; <a href="component/merchantList" class="link1">Return to All ${SESSION_ATTR_USER_INFO.cityText} Merchants</a> &nbsp; <a href="component/merchantmgmt	" class="link1">Return to
							${SESSION_ATTR_USER_INFO.cityText} Dashboard</a> &nbsp;
					</div>
					<br>
					<h3 class="msg">
						<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
						</em>
					</h3>
					<form:form id="merchantProfile" name="merchantProfile" action="component/updateMerchantInfo?merchantId=${merchantDTO.merchantId}" class="formStyle" modelAttribute="myProfileForm" enctype="multipart/form-data" method="POST" onsubmit="return validateForm();">
						<div class="profile">
							<fieldset><input type="hidden" value="${merchantDTO.logoId}" name="logoId" id="logoId" /> 
								<legend>Basic Details</legend>
								<table style="width: 100%;">
									<tr>
										<td><label>Merchant Name:</label></td>
										<td><form:input path="merchantName" cssClass="mInput"></form:input> <input type="hidden" style="display: none;" name="merchantId" id="merchantId" /></td>
										<td><label>GetCityDealz Name:</label></td>
										<td><form:input path="userId" cssClass="mInput"></form:input></td>
									</tr>
									<tr>
										<td><label>Contact First Name:</label></td>
										<td><form:input path="contactFirstName" cssClass="mInput" /></td>
										<td><label>Contact Last Name:</label></td>
										<td><form:input path="contactLastName" cssClass="mInput" /></td>
									</tr>
									<tr>
										<td><label>Business Phone :</label></td>
										<td><form:input path="contactPhone" cssClass="mInput" /></td>
										<td><label>Alternate Phone :</label></td>
										<td><form:input path="contactAlternatePhone" cssClass="mInput" /></td>
									</tr>
									<tr>
										<td><label>Email:</label></td>
										<td><form:input path="emailId" cssClass="mInput" /></td>
										<td><label>Website URL:</label></td>
										<td><form:input path="websiteUrl" cssClass="mInput" /></td>
									</tr>
									<tr>
										<td><label>Password:</label></td>
										<td><input type="password" name="password" id="password" /></td>
										<td><label>Retype Password:</label></td>
										<td><input type="password" name="repassword" id="repassword" /></td>
									</tr>
								</table>
							</fieldset>
							<fieldset class="address-field">
								<legend>Merchant Details</legend>
								<table style="width: 100%;">
									<tr>
										<td><label>Address Line 1 :</label></td>
										<td><form:input path="address1" cssClass="mInput" /></td>
										<td><label>Address Line 2 :</label></td>
										<td><form:input path="address2" cssClass="mInput" /></td>
									</tr>
									<tr>
										<td><label>Address Line 3 :</label></td>
										<td><form:input path="address3" cssClass="mInput" /></td>
										<td><label>City :</label></td>
										<td><form:input path="cityToDisplay" cssClass="mInput" /><input type="hidden" style="display: none;" name="cityId" id="cityId" /></td>
									</tr>
									<tr>
										<td><label>State :</label></td>
										<td><form:input path="state" cssClass="mInput" /></td>
										<td><label>Zip Code :</label></td>
										<td><form:input path="zipCode" cssClass="mInput" /></td>
									</tr>
									<tr>
										<td><label>Business Hours :To have your business hours display on separate lines in your profile, please place a comma (,) to indicate where the current line ends and the new begins </label></td>
										<td colspan="3"><textarea maxlength="200" rows="3" cols="2" name="businessHours" id="businessHours" style="width: 99%; resize: none;">${merchantDTO.businessHours}</textarea></td>
									</tr>
								</table>
							</fieldset>
							<fieldset>
								<legend>Current Categories:Sub-categores</legend>
								<table width="100%">
								</table>
								<table class="items_list" width="100%" cellpadding="0" cellspacing="0">
									<tbody>
										<tr>
											<td><strong>Master Category</strong><br>${merchantDTO.masterCategoryText}</td>
											<td><strong>Category : Sub-Category</strong><br>
												<dl>
													<dt>
														<strong>${merchantDTO.category1Text}</strong>
													</dt>
													<dd>${merchantDTO.subCategory1Text}</dd>
													<dt>
														<strong>${merchantDTO.category2Text}</strong>
													</dt>
													<dd>${merchantDTO.subCategory2Text}</dd>
												</dl></td>
										</tr>
									</tbody>
								</table>
							</fieldset>
							<fieldset>
								<legend>Select Master Category</legend>
								<table class="items_list" width="100%" cellpadding="0" cellspacing="0">
									<tr>
										<td><label class="mReadOnlyLabel">Master Category :</label></td>
										<td><form:select path="masterCategory" cssClass="mSelect">
												<form:options items="${masterCategory}" />
											</form:select></td>
										<td><label>&nbsp;</label></td>
										<td>&nbsp;<select class="mSelect" style="display: none;" name="masterCategory">
										</select></td>
									</tr>
								</table>
							</fieldset>
							<fieldset>
								<legend>Select Categories/Sub-categoriess</legend>
								<table style="width: 100%;">
									<tr>
										<td><label class="mReadOnlyLabel">Category1 :</label></td>
										<td><form:select path="category1" cssClass="mSelect" onchange="onChageCategory1();">
												<form:option value="-1" label="--Select--"></form:option>
												<form:options items="${categoryMap}" />
											</form:select></td>
										<td><label class="mReadOnlyLabel">Sub-Category1 :</label></td>
										<td><form:select path="subCategory1" cssClass="mSelect" multiple="multiple">
												<form:options items="${subCategory1}" />
											</form:select></td>
									</tr>
									<tr>
										<td><label class="mReadOnlyLabel">Category2 :</label></td>
										<td><form:select path="category2" cssClass="mSelect" onchange="onChageCategory2();">
												<form:option value="-1" label="--Select--"></form:option>
												<form:options items="${categoryMap}" />
											</form:select></td>
										<td><label class="mReadOnlyLabel">Sub-Category2 :</label></td>
										<td><form:select path="subCategory2" cssClass="mSelect" multiple="multiple">
												<form:options items="${subCategory2}" />
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
										<td><label class="addrs1"><input type="text" placeholder="e-mail" value="${merchantDTO.locationDTOs[0].emailAddress}" id="emailAddress_othrLoc1" name="locationDTOs[0].emailAddress" /></label></td>
										<td><label class="addrs2"><input type="text" placeholder="e-mail" value="${merchantDTO.locationDTOs[1].emailAddress}" id="emailAddress_othrLoc2" name="locationDTOs[1].emailAddress" /></label></td>
										<td><label class="addrs3"><input type="text" placeholder="e-mail" value="${merchantDTO.locationDTOs[2].emailAddress}" id="emailAddress_othrLoc3" name="locationDTOs[2].emailAddress" /></label></td>
									</tr>
								</table>
							</fieldset>
							<fieldset>
								<legend>Other Details</legend>
								<table style="width: 100%;">
									<tr>
										<td><label>Neighborhood Name :</label></td>
										<td><form:select path="neighborhoodName" cssClass="mSelect">
												<form:option value="-1" label="--Select--"></form:option>
												<form:options items="${neighborhoodMap}" />
											</form:select></td>
										<td><label>Merchant Logo :</label></td>
										<td><input type="file" class="mInput" name="logo" /></td>
									</tr>
									<tr>
										<td><label>Google Analytics ID :</label></td>
										<td><input type="text" name="googleAnalyticsId" id="googleAnalyticsId" class="mInput" /></td>
										<td><label>Merchant Features & Accessiblity :</label></td>
										<td><form:select path="merchantFeature" cssClass="mSelect" multiple="multiple" size="4" items="${featureMap}">
											</form:select></td>
									</tr>
								</table>
							</fieldset>
							<div style="float: right;">
								<input type="submit" value="Update" onclick="updateMyProfile();" />&nbsp;<input type="button" value="Reset" onclick="resetAll();" />
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
					sliderImage +='<a href="merchant/${merchantName2}-'+bannerArr[i].merchantId+'"><img src="../displayImage?image='+bannerArr[i].imagePath+'" style="height:170px;" class="wrap" id="wrap'+(i+1)+'" style="display: none;"/></a>';
				}
				$("#slider").append(sliderImage);
			}		
		//alert(${merchantDTO.locationDTOs[0].neighborhoodName});
		$(".n1").val(${merchantDTO.locationDTOs[0].neighborhood});
		$(".n2").val(${merchantDTO.locationDTOs[1].neighborhood});
		$(".n3").val(${merchantDTO.locationDTOs[2].neighborhood});
		$("#emailId").val('<c:out value="${merchantDTO.emailId}"/>');
		$("#salesPerson").val('<c:out value="${merchantDTO.salesPerson}"/>');
		$("#websiteUrl").val('<c:out value="${merchantDTO.websiteUrl}"/>');
		$("#dailyDealenName").val('<c:out value="${merchantDTO.dailyDealenName}"/>');
		$("#testDrive").val('<c:out value="${merchantDTO.testDrive}"/>');
		$("#googleAnalyticsId").val('<c:out value="${merchantDTO.googleAnalyticsId}"/>');
		$("#blogTemplateId").val('<c:out value="${merchantDTO.blogTemplateId}"/>');
		$("#merchantLevel").val('<c:out value="${SESSION_ATTR_USER_INFO.userLevel}"/>');
		$("#merchantId").val('<c:out value="${merchantDTO.merchantId}"/>');
		$("#cityId").val('<c:out value="${merchantDTO.cityId}"/>');
		if ('<c:out value="${merchantDTO.masterCategory}"/>' != "")
			$("#masterCategory").val('<c:out value="${merchantDTO.masterCategory}"/>');
		if ('<c:out value="${merchantDTO.category1}"/>' != "")
			$("#category1").val('<c:out value="${merchantDTO.category1}"/>');
		if ('<c:out value="${merchantDTO.category2}"/>' != "")
			$("#category2").val('<c:out value="${merchantDTO.category2}"/>');

		if ('<c:out value="${merchantDTO.neighborhoodName}"/>' != "")
			$("#neighborhoodName").val('<c:out value="${merchantDTO.neighborhoodName}"/>');

		var mfeature = '<c:out value="${merchantDTO.merchantFeature}"/>' + "";
		if(mfeature!=null&&mfeature!=''){
			mfArr = mfeature.split(',');
			size = (mfArr).length;
			for (i=0; i < size; i++) {
				$("#merchantFeature option[value='" + mfArr[i] + "']").attr("selected", true);
			}
		}	

		var subCtg = ('<c:out value="${selectedSubCategory1}"/>' + "").split(",");

		var size = subCtg.length;
		var $options = $('#subCategory1 option');
		for (i = 0; i < size; i++) {
			$("#subCategory1 option[value='" + subCtg[i] + "']").attr("selected", true);
		}

		var subCtg1 = ('<c:out value="${selectedSubCategory2}"/>' + "").split(",");

		var i = 0, size = subCtg1.length;
		var $options = $('#subCategory2 option');
		for (i = 0; i < size; i++) {
			$("#subCategory2 option[value='" + subCtg1[i] + "']").attr("selected", true);
		}

	});

	function resetAll() {
		$("#merchantId").val("");
		$("#merchantName").val("");
		$("#contactFirstName").val("");
		$("#contactLastName").val("");
		$("#contactPhone").val("");
		$("#contactAlternatePhone").val("");
		$("#address1").val("");
		$("#address2").val("");
		$("#address3").val("");
		$("#city").html("");
		$("#state").val("");
		$("#zipCode").val("");
		$("#emailId").val("");
		$("#salesPerson").val("");
		$("#dailyDealenName").val("");
		$("#testDrive").val("");
		$("#googleAnalyticsId").val("");
		$("#blogTemplateId").val("");
		$("#merchantLevel").val("");
		$("#category1").val("");
		$("#category1").val("");
		fillCombo('subCategory1', new Array);
		$("#subCategory1").removeAttr("multiple");
		fillCombo('subCategory2', new Array);
		$("#subCategory2").removeAttr("multiple");
	}

	function onChageCategory1() {
		if (trimString($("#category1").val()) == '-1') {
			$("#subCategory1 option:selected").removeAttr("selected");
			return false;
		}
		var retVal = $.ajax({
			url : "jsonGetSubCategoryByCtgId",
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
			url : "jsonGetSubCategoryByCtgId",
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

	function validateForm() {
		if (trimString($("#password").val()).length > 0) {
			if (trimString($("#repassword").val()) == "") {
				$.alert.open('error', 'Retype Password is Mandatory.');
				appFocus($("#repassword"));
				return false;
			}
			if (trimString($("#password").val()) != trimString($("#repassword").val())) {
				$.alert.open('error', 'Password does not match with Retype Password.');
				appFocus($("#repassword"));
				return false;
			}
		}
		
		/* var sCat1 = $("#subCategory1").val()+"";
		var sCat1Arr = sCat1.split(",");
		
		var sCat2 = $("#subCategory2").val()+"";
		var sCat2Arr = sCat2.split(",");
		
		
		if($("#category1").val()==$("#category2").val()){
			var len = sCat1Arr.length + sCat2Arr.length;
			if(len>2){
				$.alert.open('error', 'You cannot Select more then two subcategory for .'+ $("#category1 option:selected").text());
				return false;
			}
		}
		if(sCat1Arr.length>2){
			$.alert.open('error', 'You cannot Select more then two subcategory for .'+ $("#category1 option:selected").text());
			$("#subCategory1").css('color','red');
			return false;
		}
		
		if(sCat2Arr.length>2){
			$.alert.open('error', 'You cannot Select more then two subcategory for .'+ $("#category2 option:selected").text());
			$("#subCategory2").css('color','red');
			return false;
		} */
		
		return true;
	}
</script>

</html>