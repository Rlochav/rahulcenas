<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title><spring:message code="common.html.000001"></spring:message></title>

<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/template1.css'/>">
<link rel="shortcut icon" href="resources/images/icon.png" />
<script type="text/javascript" src="<c:url value='resources/js/CommonFunction.js'/>"></script>

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
					<h3 class="msg">
						<em> Hi There ${SESSION_ATTR_USER_INFO.userName} manage Your Basic Information<br>
						</em>
					</h3>
					<br>
					<div class="items">
						<form:form id="merchantProfile" name="merchantProfile" action="updateMyProfile" class="formStyle" onsubmit="return profileValidate();" modelAttribute="myProfileForm" enctype="multipart/form-data" method="POST">
							<fieldset>
								<legend> Basic Details</legend>
								<table cellpadding="0" cellspacing="0">
									<tbody>
										<tr>
											<td><label id="jform_merchant_name-lbl" for="jform_merchant_name" class="hasTip required" title="">Merchant Name<span class="star">&nbsp;*</span></label></td>
											<td><input type="text" name="merchantName" id="merchantName" value="${merchantDTO.merchantName}" class="mInput" required /><input type="hidden" style="display: none;" name="merchantId" id="merchantId" /></td>
											<td>&nbsp;<!-- <label id="jform_merchant_name-lbl" for="jform_merchant_name" class="hasTip required" title="">Business Hours<span class="star">&nbsp;*</span></label> --></td>
											<td>&nbsp;<input type="hidden" value="${merchantDTO.logoId}" name="logoId" id="logoId" /> <%-- <input type="text" name="businessHours" id="businessHours" value="${merchantDTO.businessHours}" class="mInput" /> --%></td>
										</tr>
										<tr>
											<td>Contact First Name</td>
											<td><input type="text" name="contactFirstName" value="${merchantDTO.contactFirstName}" id="contactFirstName" class="mInput" required /></td>
											<td>Contact Last Name</td>
											<td><input type="text" name="contactLastName" value="${merchantDTO.contactLastName}" id="contactLastName" class="mInput" required /></td>
										</tr>
										<tr>
											<td><label id="jform_business_phone-lbl" for="jform_business_phone" class="hasTip required" title="">Business Phone<span class="star">&nbsp;*</span></label></td>
											<td><input type="text" name="contactPhone" value="${merchantDTO.contactPhone}" id="contactPhone" class="mInput" required /></td>
											<td><label id="jform_alternate_phone-lbl" for="jform_alternate_phone" class="hasTip" title="">Alternate Phone</label></td>
											<td><input type="text" name="contactAlternatePhone" value="${merchantDTO.contactAlternatePhone}" id="contactAlternatePhone" class="mInput" /></td>
										</tr>
										<tr>
											<td><label id="jform_websiteUrl-lbl" for="jform_websiteUrl" class="hasTip required" title="">Website Url<span class="star">&nbsp;*</span></label></td>
											<td><input type="text" name="websiteUrl" id="websiteUrl" value="${merchantDTO.websiteUrl}" class="mInput" required /></td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
									</tbody>
								</table>
							</fieldset>
							<fieldset>
								<legend>Physical Address</legend>
								<table>
									<tbody>
										<tr>
											<td>Address Line 1</td>
											<td>Address Line 2</td>
											<td>Address Line 3</td>
										</tr>
										<tr>
											<td><input type="text" value="${merchantDTO.address1}" name="address1" id="address1" class="mInput" /></td>
											<td><input type="text" value="${merchantDTO.address2}" name="address2" id="address2" class="mInput" /></td>
											<td><input type="text" value="${merchantDTO.address3}" name="address3" id="address3" class="mInput" /></td>
										</tr>
										<tr>
											<td>City</td>
											<td>State</td>
											<td>ZipCode</td>
										</tr>
										<tr>
											<td><input type="text" value="${merchantDTO.cityToDisplay}" name="cityToDisplay" id="cityToDisplay" class="mInput" /> <input type="hidden" name="cityId" id="cityId" style="display: none;" /></td>
											<td><input type="text" value="${merchantDTO.state}" name="state" id="state" class="mInput" /></td>
											<td><input type="text" value="${merchantDTO.zipCode}" name="zipCode" id="zipCode" class="mInput" /></td>
										</tr>
										<tr>
											<td colspan="3">Business Hours</td>
										</tr>
										<tr>
											<td colspan="3">To have your business hours display on separate lines in your profile, please place a comma (,) to indicate where the current line ends and the new begins <br /> <textarea maxlength="200" rows="3" cols="2" name="businessHours" id="businessHours"
													style="width: 99%; resize: none;">${merchantDTO.businessHours}</textarea>
											</td>
										</tr>
									</tbody>
								</table>
							</fieldset>
							<fieldset>
								<legend>Current Categories:Sub-categores</legend>
								<table width="100%">
								</table>
								<table class="items_list" width="100%" cellpadding="0" cellspacing="0">
									<tbody>
										<tr>
											<td><strong>Master Category</strong><br> ${merchantDTO.masterCategoryText}</td>
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
								<legend>Select Categories/Sub-categories</legend>
								<table cellpadding="0" cellspacing="0">
									<tbody>
										<tr>
											<td><strong>Master Category</strong></td>
											<td><form:select path="masterCategory" cssClass="mSelect">
													<form:options items="${masterCategory}" />
												</form:select></td>
											<select class="mSelect" style="visibility: hidden;" name="masterCategory">
											</select>
										</tr>
									</tbody>
								</table>
								<br>
								<table class="items_list" width="100%" cellpadding="0" cellspacing="0">
									<tbody>
										<tr>
											<th>Category</th>
											<th>Sub-Category</th>
										</tr>
										<tr>
											<td><form:select path="category1" cssClass="mSelect" onchange="onChageCategory1();">
													<form:option value="-1" label="--Select--"></form:option>
													<form:options items="${categoryMap}" />
												</form:select></td>
											<td><div id="subcategegory_select_box" style="padding-left: 10px;">
													<form:select path="subCategory1" cssClass="mSelect" multiple="multiple">
														<form:options items="${subCategory1}" />
													</form:select>
												</div></td>
										</tr>
										<tr>
											<td><form:select path="category2" cssClass="mSelect" onchange="onChageCategory2();">
													<form:option value="-1" label="--Select--"></form:option>
													<form:options items="${categoryMap}" />
												</form:select></td>
											<td><div id="subcategegory_select_box1" style="padding-left: 10px;">
													<form:select path="subCategory2" cssClass="mSelect" multiple="multiple">
														<form:options items="${subCategory2}" />
													</form:select>
												</div></td>
										</tr>

									</tbody>
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
								<table>
									<tbody>
										<tr>
											<td>Neighborhood Name</td>
											<td><form:select path="neighborhoodName" cssClass="mSelect" onchange="showNeighborhoodAddress();">
													<form:option value="-1" label="--Select--"></form:option>
													<form:options items="${neighborhoodMap}" />
												</form:select></td>
											<td>Merchant Logo</td>
											<td><input type="file" class="mInput" name="logo" /></td>
										</tr>
										<tr>
											<td><label id="jform_google_analytics_id-lbl" for="jform_google_analytics_id" class="hasTip" title="">Google Analytics Id</label></td>
											<td><input type="text" name="googleAnalyticsId" value="${merchantDTO.googleAnalyticsId}" id="googleAnalyticsId" class="mInput" /></td>
											<td><label id="jform_merchant_features-lbl" for="jform_merchant_features" class="hasTip" title="">Merchant Features & Accessiblity</label></td>
											<td><form:select path="merchantFeature" cssClass="mSelect" multiple="multiple" size="2" items="${featureMap}">
												</form:select></td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td class="button2  al-right"><input type="submit" value="Update" onclick="updateMyProfile();" /> &nbsp;<input type="button" value="Reset" onclick="resetAll();" /></td>
										</tr>
									</tbody>
								</table>
							</fieldset>
						</form:form>
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
		$(".n1").val(${merchantDTO.locationDTOs[0].neighborhood});
		$(".n2").val(${merchantDTO.locationDTOs[1].neighborhood});
		$(".n3").val(${merchantDTO.locationDTOs[2].neighborhood});
		$("#cityId").val('<c:out value="${merchantDTO.cityId}"/>');
		$("#emailId").val('<c:out value="${merchantDTO.emailId}"/>');
		$("#salesPerson").val('<c:out value="${merchantDTO.salesPerson}"/>');
		$("#dailyDealenName").val(
				'<c:out value="${merchantDTO.dailyDealenName}"/>');
		$("#testDrive").val('<c:out value="${merchantDTO.testDrive}"/>');
		$("#blogTemplateId").val(
				'<c:out value="${merchantDTO.blogTemplateId}"/>');
		$("#merchantLevel").val(
				'<c:out value="${SESSION_ATTR_USER_INFO.userLevel}"/>');
		$("#merchantId").val('<c:out value="${merchantDTO.merchantId}"/>');
		$("#password").val('<c:out value="${merchantDTO.password}"/>');
		if ('<c:out value="${merchantDTO.masterCategory}"/>' != "")
			$("#masterCategory").val(
					'<c:out value="${merchantDTO.masterCategory}"/>');
		if ('<c:out value="${merchantDTO.category1}"/>' != "")
			$("#category1").val('<c:out value="${merchantDTO.category1}"/>');
		if ('<c:out value="${merchantDTO.category2}"/>' != "")
			$("#category2").val('<c:out value="${merchantDTO.category2}"/>');

		if ('<c:out value="${merchantDTO.neighborhoodName}"/>' != "")
			$("#neighborhoodName").val(
					'<c:out value="${merchantDTO.neighborhoodName}"/>');

		var mfeature = '<c:out value="${merchantDTO.merchantFeature}"/>' + "";
		if(mfeature!=null&&mfeature!=''){
			mfArr = mfeature.split(',');
			size = (mfArr).length;
			for (i=0; i < size; i++) {
				$("#merchantFeature option[value='" + mfArr[i] + "']").attr("selected", true);
			}
		}	

		var subCtg = ('<c:out value="${selectedSubCategory1}"/>' + "")
				.split(",");

		var size = subCtg.length;
		var $options = $('#subCategory1 option');
		for (i = 0; i < size; i++) {
			$("#subCategory1 option[value='" + subCtg[i] + "']").attr(
					"selected", true);
		}

		var subCtg1 = ('<c:out value="${selectedSubCategory2}"/>' + "")
				.split(",");

		var i = 0, size = subCtg1.length;
		var $options = $('#subCategory2 option');
		for (i = 0; i < size; i++) {
			$("#subCategory2 option[value='" + subCtg1[i] + "']").attr(
					"selected", true);
		}
		showNeighborhoodAddress();
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
		$("#city").val("");
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

	$(function() {
		$('.uploadLogo').click(function() {
			$('.overlay').fadeIn();
			$('.box').fadeIn();
			$('#TB_iframeContent').attr('src', 'documentManagement');
			$('#TB_iframeContent').load();
		});

		$('.overlay').click(function() {
			$(this).fadeOut();
			$('.box').fadeOut();
		});

		$('.divclose').click(function() {
			$('.overlay').fadeOut();
			$('.box').fadeOut();
		});

	});

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
					values4Cmb[counter++] = new CodeValueStruct(subCmplntVal,
							subCmplntypMap[subCmplntVal]);
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
					values4Cmb[counter++] = new CodeValueStruct(subCmplntVal,
							subCmplntypMap[subCmplntVal]);
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
	
	function showNeighborhoodAddress() {
		if($('#neighborhoodName').val()!='-1'){
			$("#neighborhoodAddressDiv").show();
		}else{
			$("#neighborhoodAddressDiv").hide();
		}
	}
	
	/* function profileValidate(){
		var sCat1 = $("#subCategory1").val()+"";
		var sCat1Arr = sCat1.split(",");
		
		var sCat2 = $("#subCategory2").val()+"";
		var sCat2Arr = sCat2.split(",");
		
		for(var i=0;i<sCat1.length;i++){
			for(var j=0;j<sCat1.length;j++){
				if(sCat1[i]==sCat2[j]){
					$.alert.open('error', 'You already selected this subcategory in Subcategory 1 .'+ $("#subCategory1 option:selected").text());
					return false;
				}
			}
		}
		
		return true;
	} */
</script>
</html>