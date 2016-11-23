<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<script src="<c:url value='resources/js/main.js'/>"></script>
<script type="text/javascript" src="<c:url value='resources/js/CommonFunction.js'/>"></script>

<link href="<c:url value='resources/css/main.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='resources/css/media.css'/>" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="resources/images/icon.png">
<link href="<c:url value='resources/css/screens.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='resources/js/main.js'/>"></script></head>
<body>
	<form:form id="becomeMerchant" name="becomeMerchant">
		<h3 class="msg">
			<em>Registration process has been successfully . thank you</em>
		</h3>
		<div style="color: blue;">
			<table class="tableStyle" style="margin: 0px;">
				<tr>
					<td>User ID :</td>
					<td>${emailId}</td>
				</tr>
				<tr>
					<td>Password :</td>
					<td>${password}</td>
				</tr>
			</table>
		</div>
		<table class="tableStyle" style="margin: 0px; height: 100%; width: 100%;">
			<tr>
				<td colspan="4" align="right">Press here to login <input type="button" style="background-color: green;" value="Next" onclick="goToLogin();"></td>
			</tr>
		</table>
	</form:form>
</body>
<script type="text/javascript">
	function goToLogin() {
		window.parent.$("#midContentDiv").load('login');
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