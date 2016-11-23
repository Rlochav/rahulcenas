<%@include file="../../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Best Daily Deals in New Orleans,LA | Hot Local Bargains in NOLA</title>

<script type="text/javascript" src="<c:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<script src="<c:url value='/resources/js/main.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/screens.css'/>">
<link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="../resources/images/icon.png" />
<link href="<c:url value='/resources/css/media.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/resources/js/CommonFunction.js'/>"></script>
<link href="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/css/alert.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/themes/light/theme.css'/>" rel="stylesheet" />
<script src="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/js/alert.js'/>"></script>
<link href="<c:url value='/resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='/resources/js/js-image-slider.js'/>"></script>
</head>

<body>
	<%@include file="../../common/telliumTags.jsp"%>
	<div class="all">
		<div id="wrapper">
			<!-- header start -->
			<div class="header">
				<div class="upper-header">
					<div class="social">
						<ul class="social-icon">
							<li><a id="gcd_sm_fb" href="http://www.facebook.com/GetCityDealz" target="_blank"><img src="<c:url value='/resources/images/facebook.png'/>" width="auto" border="0" alt="facebook" title="facebook"></a></li>
							<li><a id="gcd_sm_twitter" href="http://www.twitter.com/GetCityDealz" target="_blank"><img src="<c:url value='/resources/images/twitter.png'/>" border="0" alt="twitter" title="twitter"></a></li>
							<li><a id="gcd_sm_pinterest" href="http://www.pinterest.com/getcitydealz" target="_blank"> <img src="<c:url value='/resources/images/pintrest.png'/>" border="0" alt="pintrest" title="pintrest"></a></li>
							<li><a id="gcd_sm_g+" href="https://plus.google.com/113127686225602648376" target="_blank"> <img src="<c:url value='/resources/images/gplush.png'/>" border="0" alt="Google Plus" title="Google Plus"></a></li>
							<li><a id="gcd_sm_youtube" href="http://www.youtube.com/user/GetCityDealz" target="_blank"> <img src="<c:url value='/resources/images/youtube.png'/>" border="0" alt="youtube" title="youtube"></a></li>
							<div class="clr"></div>
						</ul>
						<c:if test='${SESSION_ATTR_USER_INFO!=null}'>
							<div class="login" id="login">
								<a id="merchant_login_button" style="cursor: pointer;" href="../appLogOut"><img src="<c:url value='/resources/images/marchent-logout.png'/>" border="0"></a>
							</div>
						</c:if>
						<div class="clr"></div>
					</div>

					<div class="logo">
						<a id="header_home_link" href="../index"><img src="<c:url value='/resources/images/logo1.png'/>" /></a>
						<div class="clr"></div>
					</div>
					<div id="sliderFrame">
						<div id="ribbon" style="right: 11.7%;">
							<img id="prev87" class="prev-button" src="<c:url value='/resources/images/prev.png'/>" alt="Previous"> <img id="next87" class="next-button" src="<c:url value='/resources/images/next.png'/>" alt="Next">

						</div>
						<div class="slider" id="slider"></div>
					</div>
					<div class="clr"></div>
				</div>
				<div class="icon_menu" id="top_nav_buttons">
					<ul>
						<li><a id="tnb_dining" href="../dealsbymaincategory/dining"><img src="<c:url value='/resources/images/DINING.png'/>" /> </a></li>
						<li><a id="tnb_nightlife" href="../dealsbymaincategory/night-life"><img src="<c:url value='/resources/images/NIGHTLIFE.png'/>" /></a></li>
						<li><a id="tnb_shopping" href="../dealsbymaincategory/shopping"><img src="<c:url value='/resources/images/SHOPPING.png'/>" /> </a></li>
						<li><a id="tnb_attractions" href="../dealsbymaincategory/attractions"><img src="<c:url value='/resources/images/ATTRACTIONS.png'/>" /></a></li>
						<li><a id="tnb_services" href="../dealsbymaincategory/services"><img src="<c:url value='/resources/images/SERVICES.png'/>" /></a></li>
						<li class="last"><a id="tnb_recreation" href="../dealsbymaincategory/recreation"><img src="<c:url value='/resources/images/RECREATION.png'/>" /></a></li>
						<div class="clr"></div>
					</ul>
					<div class="clr"></div>
					<div class="mobile_nav">
						<label> <select>
								<option>home</option>
								<option><a href="#"><div class="menu-links">DINING</div></a>
								</option>
								<option><a href="#"><span>NIGHTLIFE</span><em></em></a>
								</option>
								<option><a href="#"><span>SHOPPING</span><em></em></a>
								</option>
								<option><a href="#"><span>ATTRACTIONS</span><em></em></a>
								</option>
								<option><a href="#"><span>SERVICES</span><em></em></a>
								</option>
								<option><a href="#"><span>RECREATION</span><em></em></a>
								</option>
								<div class="clr"></div>
						</select>
						</label>
					</div>

					<!--menu for mobile start-->
					<div class="mobile_na">
						<div class="fflip" id="f1" onclick="fflip(this.id)">
							<img src="<c:url value='/resources/images/toogle.png'/>">
						</div>
						<div class="ppanelf1">
							<a href="inde.userIndexx.html">
								<div class="stare3"></div>
								<p>DINING</p>
							</a> <a href="index.html">
								<div class="stare3"></div>
								<p>NIGHTLIFE</p>
							</a> <a href="index.html">
								<div class="stare3"></div>
								<p>SHOPPING</p>
							</a> <a href="INNER.html">
								<div class="stare3"></div>
								<p>ATTRACTIONS</p>
							</a> <a href="INNER.html">
								<div class="stare3"></div>
								<p>SERVICES</p>
							</a> <a href="INNER.html">
								<div class="stare3"></div>
								<p>RECRloginEATION</p>
							</a>
							<div class="clear"></div>
						</div>
						<div class="clear"></div>
					</div>
					<!--menu for mobile end-->
					<div class="clr"></div>
				</div>
				<div class="clr"></div>
			</div>
			<!-- header end -->
			<div class="clr"></div>
			<div class="middle-container">
				<div class="tagline">
					<p>
						<strong>&bull; FREE &bull; REAL TIME &bull; LOCAL &bull; DEALS WHEN&nbsp; YOU WANT THEM!</strong>
					</p>
				</div>
				<div class="tagline-mobi">
					<p>
						<strong>&bull; FREE &bull; REAL TIME &bull; LOCAL &bull; DEALS WHEN&nbsp; YOU WANT THEM!</strong>
					</p>
				</div>
				<div class="mid-admin">
					<!-- mid start here -->
					<div class="mid admin-container">
						<div id="dashboard-area">
							<div id="title">${SESSION_ATTR_USER_INFO.cityText}:${merchantDTO.merchantName}'SeditBASICINFORMATION</div>
							<div id="menu">
								<div class="menu-new">
									<div style="float: right; padding: 2px 35px;">
										<img src="<c:url value='/resources/images/blue-arrow.png'/>" style="width: 4px; height: 9px; padding: 0px 7px; margin: -1px;"> <a style="color: #046604; cursor: pointer;" href="adminDashboard"> Return to Main Dashboard </a> <img src="<c:url value='/resources/images/blue-arrow.png'/>"
											style="width: 4px; height: 9px; padding: 0px 7px; margin: -1px;"> <a style="color: #046604; cursor: pointer;" href="merchantList"> Return to All ${SESSION_ATTR_USER_INFO.cityText} Merchants </a><img src="<c:url value='/resources/images/blue-arrow.png'/>"
											style="width: 4px; height: 9px; padding: 0px 7px; margin: -1px;"> <a style="color: #046604; cursor: pointer;" href="merchantmgmt"> Return to ${SESSION_ATTR_USER_INFO.cityText} Dashboard </a><img src="<c:url value='/resources/images/blue-arrow.png'/>"
											style="width: 4px; height: 9px; padding: 0px 7px; margin: -1px;"> <a style="color: #046604; cursor: pointer;" href="manageMerchantLocation?merchantId=${merchantId}">Return to Manage Location</a>
									</div>
								</div>
							</div>
							<div align="center" style="visibility: hidden;">
								<strong><i>Manage Merchants, Categories, Neighborhoods, Deals, Hot Deals &amp; Mobile</i> <dtrong></dtrong></strong>
							</div>
							<br>
							<h3 class="msg">
								<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
								</em>
							</h3>
							<br>
							<div id="form-field" class="manageLocationClass">
								<div id="midContentDiv">
									<form:form method="POST" id="editMerchantLocation" name="editMerchantLocation" class="formStyle" modelAttribute="editLocationForm">
										<div class="postDealz"></div>
										<fieldset>
											<legend>Edit Location</legend>
											<table class="tableStyle" style="width: 96%; margin: 2%;">
												<tr>
													<td><label>Location Name :<span class="mandatory">*</span></label></td>
													<td><input type="text" value="${locationDTO.locationId}" style="display: none;" id="locationId"> <input type="text" value="${locationDTO.locationName}" name="locationName" id="locationName" class="mInput" /></td>
												</tr>
												<tr>
													<td><label>Contact First Name :<span class="mandatory">*</span></label></td>
													<td><input type="text" name="contactFirstName" value="${locationDTO.contactFirstName}" id="contactFirstName" class="mInput" /></td>
												</tr>
												<tr>
													<td><label>Contact Last Name:<span class="mandatory">*</span></label></td>
													<td><input type="text" name="contactLastName" value="${locationDTO.contactLastName}" id="contactLastName" class="mInput" /></td>
												</tr>
												<tr>
													<td><label>Location Phone<span class="mandatory">*</span></label></td>
													<td><input type="text" name="locationPhone" value="${locationDTO.locationPhone}" id="locationPhone" class="mInput" /></td>
												</tr>
												<tr>
													<td><label>e-Mail :</label></td>
													<td><input type="text" name="emailAddress" value="${locationDTO.emailAddress}" id="emailAddress" class="mInput" /></td>
												</tr>
												<tr>
													<td><label>Physical Address1 :</label></td>
													<td><input type="text" name="address1" id="address1" value="${locationDTO.address1}" maxlength="100" class="mInput" /></td>
												</tr>
												<tr>
													<td><label>Physical Address2 :</label></td>
													<td><input type="text" value="${locationDTO.address2}" maxlength="100" name="address2" id="address2" class="mInput" /></td>
												</tr>
												<tr>
													<td><label>Physical Address3 :</label></td>
													<td><input type="text" value="${locationDTO.address3}" maxlength="100" name="address3" id="address3" class="mInput" /></td>
												</tr>
												<tr>
													<td><label>City :</label></td>
													<td><input type="text" name="city" id="city" class="mInput" /></td>
												</tr>
												<tr>
													<td><label>State :</label></td>
													<td><input type="text" value="${locationDTO.state}" name="state" id="state" class="mInput" /></td>
												</tr>
												<tr>
													<td><label>Zip Code :</label></td>
													<td><input type="text" name="zipCode" id="zipCode" maxlength="8" value="${locationDTO.zipCode}" class="mInput" /></td>
												</tr>
												<tr>
													<td><label>Neighborhood Name :<span style="color: red;">*</span></label></td>
													<td><form:select path="neighborhoodName" cssClass="mSelect">
															<form:option value="-1" label="--Select--"></form:option>
															<form:options items="${neighborhoodMap}" />
														</form:select></td>
												</tr>
												<tr>
													<td><label style="width: 20%;">Location Description :</label></td>
													<td><textarea style="width: 76%;" rows="2" cols="3" name="locationDesc" value="${locationDTO.locationDesc}" id="locationDesc" maxlength="255"></textarea></td>
												</tr>
												<tr>
													<td><label style="width: 20%;">Location Hours :</label></td>
													<td><input type="text" class="mInput" name="locationHours" value="${locationDTO.locationHours}" id="locationHours" maxlength="10" /></td>
												</tr>
												<tr>
													<td>&nbsp;</td>
													<td><input type="button" class="mediumBtn" name="submitDeal" id="submitDeal" value="Save" onclick="editLocationSave();" /> <input type="button" class="mediumBtn" name="resetLOcation" id="resetLOcation" value="Reset" onclick="resetAll();" /></td>
												</tr>
											</table>
										</fieldset>
									</form:form>
								</div>
							</div>
						</div>

					</div>
					<!-- mid end here -->

					<!-- footer start -->
					<div class="bottom">
						<div class="footer-left">
							<ul>
								<li class="active"><a id="gcd_footer_home" href="../index">Home</a></li>
								<li class=""><a id="gcd_footer_privacy_policy" href="http://gcddev.com/privacy-policy">Privacy Policy</a></li>
								<li class=""><a id="gcd_footer_contact" href="http://gcddev.com/contactus">Contact Us</a></li>
							</ul>
						</div>
						<div class="copyright">Copyright &copy; 2012-2014 Getcitydealz</div>
					</div>
					<!-- footer end -->
				</div>
			</div>
			<div class="clr"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
$(function(){
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
			sliderImage +='<a href="merchant/${merchantName2}-'+bannerArr[i].merchantId+'"><img src="displayImage?image='+bannerArr[i].imagePath+'" style="height:170px;" class="wrap" id="wrap'+(i+1)+'" style="display: none;"/></a>';
		}
		$("#slider").append(sliderImage);
	}
	
	$("#city").val('<c:out value="${locationDTO.city}"/>');
	$("#locationDesc").val('<c:out value="${locationDTO.locationDesc}"/>');
	var neighbourId = '${locationDTO.neighborhoodName}' == "" ? "-1" : '${locationDTO.neighborhoodName}';
	$("#neighborhoodName").val(neighbourId);
});

function editLocationSave() {
	if (validateForm()) {
		var retVal = $.ajax({
			url : "../saveEditLocation",
			type : "POST",
			global : false,
			data : {
				merchantId:${merchantId},
				locationId : $("#locationId").val(),
				locationName : $("#locationName").val(),
				contactFirstName : $("#contactFirstName").val(),
				contactLastName : $("#contactLastName").val(),
				locationPhone : $("#locationPhone").val(),
				address1 : $("#address1").val(),
				address2 : $("#address2").val(),
				address3 : $("#address3").val(),
				city : $("#city").val(),
				state : $("#state").val(),
				zipCode : $("#zipCode").val(),
				emailAddress : $("#emailAddress").val(),
				locationDesc : $("#locationDesc").val(),
				locationHours : $("#locationHours").val(),
				neighborhoodName : $("#neighborhoodName").val()
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);

		if (obj != null) {
			if (obj.jsonMessage != null) {
				alert(obj.jsonMessage);
			} else {
				$.alert.open('info', 'Location saved sucessfully.');
			}
		} else {
			alert('Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator.');
		}
		resetAll();
	}
}

function validateForm() {
	if (trimString($("#locationName").val()) == "") {
		appFocus($("#locationName"));
		$.alert.open('error', 'Location Name is Mandatory.');
		return false;
	}

	if (trimString($("#contactFirstName").val()) == "") {
		appFocus($("#contactFirstName"));
		$.alert.open('error', 'Contact First Name is Mandatory.');
		return false;
	}

	if (trimString($("#contactLastName").val()) == "") {
		appFocus($("#contactLastName"));
		$.alert.open('error', 'Contact Last Name is Mandatory.');
		return false;
	}

	if (trimString($("#locationName").val()) == "") {
		appFocus($("#locationName"));
		$.alert.open('error', 'Location Name is Mandatory.');
		return false;
	}

	/* if (!isNaN($("#locationPhone").val())) {
	} else {
		appFocus($("#locationPhone"));
		$.alert.open('error', 'Location Phone is not valid.');
		return false;
	}
	if ($("#locationPhone").val().length < 10) {
		appFocus($("#locationPhone"));
		$.alert.open('error', 'Location Phone must be 10 digits.');
		return false;
	}
	 */
	if (!isNaN($("#zipCode").val())) {
	} else {
		appFocus($("#zipCode"));
		$.alert.open('error', 'Zip Code is not valid.');
		return false;
	}
	/* if (!isNaN($("#locationHours").val())) {
	} else {
		appFocus($("#locationHours"));
		$.alert.open('error', 'Location Hours is not valid.');
		return false;
	} */
	if (trimString($("#emailAddress").val()) == "") {
		appFocus($("#emailAddress"));
		$.alert.open('error', 'e-Mail address is Mandatory.');
		return false;
	}
	if ($("#emailAddress").val() != "") {
		var emailaddressVal = $("#emailAddress").val();
		var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		var test_email = emailReg.test(emailaddressVal);
		if (test_email == false) {
			appFocus($("#emailAddress"));
			$.alert.open('error', 'e-Mail address is not valid.');
			return false;
		}
	}

	return true;
}

function onCity() {
	var retVal = $.ajax({
		url : "jsonGetStateByCityId",
		global : false,
		type : "POST",
		data : {
			cityId : $("#city").val()
		},
		dataType : "json",
		async : false
	}).responseText;

	var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);

	if (obj != null) {
		var subCityMap = obj;
		if (subCityMap != null) {
			var values4Cmb = new Array;
			var counter = 0;
			for ( var subCityVal in subCityMap) {
				values4Cmb[counter++] = new CodeValueStruct(subCityVal, subCityMap[subCityVal]);
			}
			fillCombo('state', values4Cmb);
		} else {
			fillCombo('state', new Array);
		}
	} else {
		fillCombo('state', new Array);
	}
}
</script>
</html>
