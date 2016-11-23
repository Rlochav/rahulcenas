<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<link href="<c:url value='resources/css/screens.css'/>" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/main.css'/>">
<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<script type="text/javascript" src="<c:url value='resources/js/CommonFunction.js'/>"></script>
</head>
<body class="darkGradientBG">
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
			<table class="tableStyle" style="width: 100%;">
				<tr>
					<th>Document Title</th>
					<th>Type</th>
					<th>Date Uploaded</th>
					<th>Show on Page</th>
					<th>&nbsp;</th>
				</tr>
				<c:forEach var="documentDTOList" items="${documentDTO}">
					<tr>
						<td><input type="text" value="${documentDTOList.documentTitle}" class="mInput" id="editableTitle" maxlength="100" /></td>
						<td class="mReadOnlyLabel">${documentDTOList.contentType}</td>
						<td class="mReadOnlyLabel">${documentDTOList.createDateText}</td>
						<td class="mReadOnlyLabel">${documentDTOList.showOnPage}</td>
						<td><input type="button" id="deletDocx" value="Delete" class="mediumBtn" onclick="deleteMediaFile('${documentDTOList.docId}');" /><input type="button" id="deletDocx" value="Update"
							class="mediumBtn" onclick="updateTitle('${documentDTOList.docId}');" /></td>
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
					<td colspan="3" align="right"><input type="submit" value="Add New Media" class="xlBtn" /><input type="button" value="Reset" class="mediumBtn" />
				</tr>
			</table>
		</div>
	</form:form>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#error").html('<c:out value="${message}"/>');
	});

	function updateTitle(docId) {
		var retVal = $.ajax({
			url : "updateMediaTitle",
			type : "POST",
			global : false,
			data : {
				docId : docId,
				title : $("#editableTitle").val()
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
				$("#editableTitle").val(obj.documentTitle)
			}
		} else {
			$("#error").html("");
			$("#error").html(
					'<li>Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator.</li>');
		}
	}

	function deleteMediaFile(docId) {
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
				$("#error").html("");
				$("#error").html('<li>' + obj.jsonMessage + '</li>');
			} else {
				window.parent.reloadFrame();
			}
		} else {
			$("#error").html("");
			$("#error").html(
					'<li>Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator.</li>');
		}
	}

	/* function uploadFiles() {
		document.uploadMediaFiles.action = 'uploadMediaFiles';
		document.uploadMediaFiles.submit();
	}
	function formValidate() {
		if (trimString($("#docTitle0").val()) != "" && trimString($("#files0").val()) == "") {
			appFocus($("#files0"));
			$("#error").html("");
			$("#error").html("<li>Select File is Mandatory</li>");
			return false;
		}
	} */
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