<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/main.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/screens.css'/>">
<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<script type="text/javascript" src="<c:url value='resources/js/CommonFunction.js'/>"></script>
<script src="<c:url value='resources/common/js/base/jquery-ui.js'/>"></script>
<link rel="shortcut icon" href="resources/images/icon.png">
<link rel="stylesheet" href="<c:url value='resources/common/themes/start/jquery.ui.all.css'/>">
<link href="<c:url value='resources/css/jquery-ui-timepicker-addon.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='resources/js/jquery-ui-timepicker-addon.js'/>"></script>
<script src="<c:url value='resources/js/jquery-ui-sliderAccess.js'/>"></script>
<link href="<c:url value='resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />	
<script src="<c:url value='resources/js/js-image-slider.js'/>"></script>
<script src="<c:url value='resources/js/main.js'/>"></script></head>
<body>
	<form:form name="merchantDealz" id="merchantDealz" class="formStyle" modelAttribute="uploadForm" enctype="multipart/form-data" method="POST">
		<h3 class="msg">
			<em>Hi There ${SESSION_ATTR_USER_INFO.userName} Create Your Deal</em>
			<div class="errorDiv" style="position: absolute; right: 0px; top: 10px;">
				<label class="error" id="error"></label>
			</div>
			<div style="position: absolute; right: 0px; top: 10px; color: green;">
				<label id="success"></label>
			</div>
		</h3>
		<div class="postDealz">
			<fieldset>
				<input type="hidden" style="display: none;" id="dealId" name="dealId" value="<c:out value="${dealId}"/>" /> <input type="text" style="display: none;" id="dealType" name="dealType"
					value="<c:out value="${dealType}"/>" />
				<legend>Post Dealz</legend>
				<div class="form_fields">
					<label>Category<span class="mandatory">*</span></label> <select name="category" id="category" class="mSelect">
						<option value="-1">--Select--</option>
						<option value="1">Automotive</option>
						<option value="2">Beauty</option>
					</select>
				</div>
				<div class="form_fields">
					<label>Sub Category</label> <select name="subCategory" id="subCategory" class="mSelect">
						<option value="-1">--Select--</option>
						<option value="1">New Orleans</option>
						<option value="2">Baton Rouge</option>
					</select>
				</div>
				<div class="form_fields">
					<label>Deal Title<span class="mandatory">*</span></label> <input type="text" name="title" value="${dealzDTO.title}" id="dealzTitle" class="mInput" />
				</div>
				<div class="form_fields">
					<label>City<span class="mandatory">*</span></label> <select name="city" id="city" class="mSelect">
						<option value="-1">--Select--</option>
						<option value="1">New Orleans</option>
						<option value="2">Baton Rouge</option>
					</select>
				</div>
				<div class="form_fields">
					<label>Restriction</label> <input type="text" value="${dealzDTO.restriction}" name="restriction" id="restriction" class="mInput" />
				</div>
				<div class="form_fields">
					<label>Start Date<span class="mandatory">*</span></label> <input type="text" value="${dealzDTO.startDate}" name="startDate" id="startDate" class="mInput" />
				</div>
				<div class="form_fields">
					<label>End Date<span class="mandatory">*</span></label> <input type="text" value="${dealzDTO.endDate}" name="endDate" id="endDate" class="mInput" />
				</div>
				<div class="form_fields">
					<label>Amount Saved</label> <input type="text" value="${dealzDTO.amountSaved}" name="amountSaved" id="amountSaved" class="mInput" />
				</div>
				<div class="form_fields">
					<label>Deal Code</label> <input type="text" value="${dealzDTO.dealCode}" name="dealCode" id="dealCode" class="mInput" />
				</div>
				<!-- <div class="form_fields">
					<label>Website</label> <input type="text" name="website" id="website" class="mInput" />
				</div> -->
				<div class="form_fields">
					<input type="text" style="display: none;" name="docType" value="0" /> <label>Deal Image</label> <input type="file" name="files[0]" id="dealImage" class="mInput" /> <input type="checkbox"
						id="useLogo" name="useLogo"> Select Logo as deafult image. <input type="text" style="display: none;" name="docType" value="0" />
				</div>
				<div class="form_fields" style="width: 100%;">
					<label style="width: 20%;">Description<span class="mandatory">*</span></label>
					<textarea style="width: 76%;" rows="2" cols="3" name="description" id="description"></textarea>
				</div>
			</fieldset>
			<div style="float: right;">
				<input type="button" class="mediumBtn" name="submitDeal" id="submitDeal" value="Submit Deal" onclick="saveDealz();" />
			</div>
	</form:form>
</body>
<script type="text/javascript">
	$(function() {
		$("#dealId").val('<c:out value="${dealzDTO.dealId}"/>');
		$("#category").val('<c:out value="${dealzDTO.category}"/>');
		$("#subCategory").val('<c:out value="${dealzDTO.subCategory}"/>');
		$("#city").val('<c:out value="${dealzDTO.city}"/>');
		$("#description").val('<c:out value="${dealzDTO.description}"/>');
		$("#startDate").datetimepicker({
			minDate : "-0M -0D",
			timeFormat : "hh:mm tt",
			dateFormat : "dd/mm/yy"
		});

		$("#endDate").datetimepicker({
			minDate : "-0M -0D",
			timeFormat : "hh:mm tt",
			dateFormat : "dd/mm/yy"
		});
	});

	function saveDealz() {
		if (formValidation()) {
			document.merchantDealz.action = 'saveMerchantDealz';
			document.merchantDealz.submit();
		}
	}

	function formValidation() {
		if ($("#category").val() == "-1") {
			appFocus($("#category"));
			$("#error").html("");
			$("#error").html("<li>Category is Mandatory</li>");
			return false;
		}
		if ($("#subCategory").val() == "-1") {
			appFocus($("#subCategory"));
			$("#error").html("");
			$("#error").html("<li>Sub Category is Mandatory</li>");
			return false;
		}
		if ($("#city").val() == "-1") {
			appFocus($("#city"));
			$("#error").html("");
			$("#error").html("<li>City is Mandatory</li>");
			return false;
		}
		if ($("#dealzTitle").val() == "") {
			appFocus($("#dealzTitle"));
			$("#error").html("");
			$("#error").html("<li>Title is Mandatory</li>");
			return false;
		}
		if ($("#startDate").val() == "") {
			appFocus($("#startDate"));
			$("#error").html("<li>Start Date is Mandatory</li>");
			return false;
		}
		if ($("#endDate").val() == "") {
			appFocus($("#endDate"));
			$("#error").html("");
			$("#error").html("<li>End Date is Mandatory</li>");
			return false;
		}
		/* if ($("#amountSaved").val() == "") {
			$("#error").html("");
			$("#error").html("<li>Amount Saved is Mandatory</li>");
			return false;
		} */
		if ($("#description").val() == "") {
			appFocus($("#description"));
			$("#error").html("");
			$("#error").html("<li>Description is Mandatory</li>");
			return false;
		} else
			return true;
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
    (function(a,b,c,d){
    a='//tags.tiqcdn.com/tmu/sandbox/lima-gcd/dev/utag.js';
    b=document;c='script';d=b.createElement(c);d.src=a;d.type='text/java'+c;d.async=true;
    a=b.getElementsByTagName(c)[0];a.parentNode.insertBefore(d,a);
    })();
</script>
</html>