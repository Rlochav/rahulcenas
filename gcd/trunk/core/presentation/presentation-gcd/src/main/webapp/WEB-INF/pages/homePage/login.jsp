<%@include file="../common/taglibs.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<link rel="icon" href="resources/images/icon.png">
<title><spring:message code="common.html.000001"></spring:message></title>
<link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='/resources/css/signin.css'/>" rel="stylesheet">
</head>

<body>
	<div class="container">
		<form class="form-signin" role="form" onsubmit="doLogin();">
			<div style="color: red;" align="center" id="error"></div>
			<h2 class="form-signin-heading">Please sign in</h2>
			<input type="text" class="form-control" placeholder="User Id" id="userId_txt" required="" autofocus=""> <input type="password" class="form-control" placeholder="Password" id="pwd_txt" required=""> <label
				class="checkbox"> <!-- <input type="checkbox" value="remember-me"> Remember me -->
			</label>
			<button class="btn btn-lg btn-primary btn-block" onclick="doLogin();" type="submit">Sign in</button>
		</form>

	</div>
</body>
<script type="text/javascript">
	$(function() {
		if ('<c:out value="${SESSION_ATTR_MASTER_LOGIN.userIndex}"/>'.length > 0)
			window.location.href = "index";
		
		if ('<c:out value="${SESSION_ATTR_USER_INFO.userIndex}"/>'.length > 0)
			window.location.href = "merchantHome";
	});

	function doLogin() {
		if ($("#userId_txt").val() == ""
				|| ($("#userId_txt").val()).length == 0) {
			$("#error").html('User ID can not be empty.');
			return false;
		}

		if ($("#pwd_txt").val() == "" || ($("#pwd_txt").val()).length == 0) {
			$("#error").html('Password can not be empty.');
			return false;
		}
		var retVal = $.ajax({
			url : "masterLogin",
			type : "POST",
			global : false,
			data : {
				userId : $("#userId_txt").val(),
				password : $("#pwd_txt").val()
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
		if (obj != null) {
			if (obj.jsonMessage == null || obj.jsonMessage == "")
				window.location.href = "index";
			else {
				$("#error").html(obj.jsonMessage);
			}
		} else {
			alert('User ID and Password do not match or you do not have an account yet.');
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
    (function(a,b,c,d){
    a='//tags.tiqcdn.com/tmu/sandbox/lima-gcd/dev/utag.js';
    b=document;c='script';d=b.createElement(c);d.src=a;d.type='text/java'+c;d.async=true;
    a=b.getElementsByTagName(c)[0];a.parentNode.insertBefore(d,a);
    })();
</script>
</html>