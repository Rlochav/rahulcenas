<%@include file="../common/taglibs.jsp"%>
<html>
<head>
</head>
<body class="darkGradientBG">
	<form:form method="POST" id="editMerchantLocation" name="editMerchantLocation" class="formStyle" modelAttribute="editLocationForm">
		<h3 class="msg">
			<em>Hi There ${SESSION_ATTR_USER_INFO.userName} Manage Your Location Information</em>
			<div class="errorDiv" style="position: absolute; right: 0px; top: 10px;">
				<label class="error" id="error"></label>
			</div>
			<div style="position: absolute; right: 0px; top: 10px; color: green;">
				<label id="success"></label>
			</div>
		</h3>
		<div class="postDealz"></div>
		<fieldset>
			<legend>Other Location</legend>
			<table class="tableStyle" style="width: 96%; margin: 2%;">
				<tr>
					<td><label>Location Name :<span class="mandatory">*</span></label></td>
					<td><input type="text" value="${locationDTO.locationId}" style="display: none;" id="locationId"> <input type="text" value="${locationDTO.locationName}" name="locationName"
						id="locationName" class="mInput" /></td>
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
					<td><%-- <form:select path="city" cssClass="mSelect" onchange="onCity();">
							<form:options items="${cityMap}" />
						</form:select> --%><input type="text" name="city" id="city" class="mInput" /></td>
				</tr>
				<tr>
					<td><label>State :</label></td>
					<td><%-- <form:select path="state" cssClass="mSelect">
							<form:options items="${null}" />
						</form:select> --%><input type="text" value="${locationDTO.state}" name="state" id="state" class="mInput" /></td>
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
					<td><input type="button" class="mediumBtn" name="submitDeal" id="submitDeal" value="Save" onclick="editLocationSave();" /> <input type="button" class="mediumBtn" name="resetLOcation"
						id="resetLOcation" value="Reset" onclick="resetAll();" /></td>
				</tr>
			</table>
		</fieldset>
	</form:form>
</body>
<script type="text/javascript">
	$(function() {
		$("#city").val('<c:out value="${locationDTO.city}"/>');
		$("#locationDesc").val('<c:out value="${locationDTO.locationDesc}"/>');		
		$("#neighborhoodName").val(${locationDTO.neighborhoodName});
	});

	function editLocationSave() {
		if (validateForm()) {
			var retVal = $.ajax({
				url : "saveEditLocation",
				type : "POST",
				global : false,
				data : {
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
					resetAll();
				}
			} else {
				alert('Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator.');
			}
			resetAll();
		}
	}

	function resetAll() {
		window.location.href = "manageLocation";
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
<script type="text/javascript">
	var utag_data = {
		page_name : "", // Name of the Page
		fname : "", // First Name
		lname : "", // Last Name
		business_name : "", // Name of Business
		addr1 : "", // Address Line 1
		addr2 : "", // Address Line 2
		city : "", // City
		state : "", // State
		zip : "", // Zip Code
		ctry : "", // Country
		currency : "", // Currency
		order_id : "", // Order ID
		order_subtotal : "", // Subtotal of order not including tax and shipping
		order_total : "", // Order Total (USD $)
		product_name : "", // name of product
		category : "", // Product Category
		gcd_city : "", // GetCityDealz City
		top_nav_category : "", // Top nav category chosen
		left_nav_category : "", // Left Navigation Category Chosen
		left_nav_subcatgory : "", // Left Navigation SubCategory Chosen
		left_nav_neighborhood : "", // Left Navigation Neighborhood Choosen
		merchant_name : "", // Merchant's Name
		deal_title : "", // Deal Title
		business_type : "", // Business Type from contact form
		social_media_connection : "", // type of social media connectin merchant successfully added
		merchant_media : "", // type of media the merchant successfully added
		update_top_nav_cat : "", // top nav category the merchant updated to
		update_primary_cat : "", // primary category the merchant updated to
		update_primary_subcat : "", // primary subcategory the merchant updated to
		update_secondary_cat : "", // secondary category the merchant updated to
		update_secondary_subcat : "", // secondary subcategory the merchant update to
		merchant_gcd_city : "", // the GCD city the merchant belongs to when they signed in
		hot_dealz_title : "", // title of the hot deal
		gcd_social_media_button : "", // gcd social media button that was clicked
		deals_delivered : "", // captures when deals delivered is pressed
		media_title : "", // captures the title of the media a visitor clicks on
		_visit_page_num : "", // number of pages during visit
		_visit_return : "", // return visit
		_visit_start : "", // visit start
		_visit_number : "", // number of visits
		_visit_type : "", // type of visit
		ga_EventCategory : "", // GA Event Category Goal
		ga_EventAction : "" // GA Event Action Goal
	}
</script>

<!-- Loading script asynchronously -->
<script type="text/javascript">
	(function(a, b, c, d) {
		a = '//tags.tiqcdn.com/tmu/sandbox/lima-gcd/dev/utag.js';
		b = document;
		c = 'script';
		d = b.createElement(c);
		d.src = a;
		d.type = 'text/java' + c;
		d.async = true;
		a = b.getElementsByTagName(c)[0];
		a.parentNode.insertBefore(d, a);
	})();
</script>
</html>