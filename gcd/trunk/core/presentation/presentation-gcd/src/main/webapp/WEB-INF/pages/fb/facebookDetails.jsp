<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<script src="http://connect.facebook.net/en_US/all.js"></script>
<script>
	window.fbAsyncInit = FB.init({
		appId : '174025642805043',
		status : true,
		cookie : true,
		xfbml : true
	});
</script>
<body>
	<select name="selectTag" id="selectTag"></select>
	<div id="fb-root"></div>
</body>
<script type="text/javascript">
	var app_id = '174025642805043';
	var app_secret = '9834e76ac9a4cfbfca2befc0e1c94698';
	var loggedInUserId;
	var accessArry = new Array();
	accessArry['appId'] = app_id;
	accessArry['secret'] = app_secret;
	window.fbAsyncInit = function() {
		FB.init({
			appId : '174025642805043', // App ID
			status : true, // check login status
			cookie : true, // enable cookies to allow the server to access the session
			xfbml : true
		// parse XFBML
		});
	};

	FB.login(function(response) {
		if (response.authResponse) {
			console.log(response.status);
			access_token = response.authResponse.accessToken;
			console.log('Access Token: ' + response.authResponse.accessToken);
			if (access_token) {
				console.log("trhis is aceess");
				return FB.getLoginStatus();
			}
		} else {
			alert('Not logged in');
		}
	}, {
		scope : 'publish_stream'
	});

	FB.getLoginStatus(function(response) {
		console.log(response);
		if (response.status === 'connected') {
			var opts = {
				//message : document.getElementById('fb_message').value,
				name : 'Obcasio',
				link : 'www.obcasio.com',
				description : 'post description',
				picture : 'http://obcasio.com/images/logo.png'
			};

			FB.api('/me/feed', 'post', opts, function(response) {
				if (!response || response.error) {
					alert('Posting error occured');
				} else {
					console.log('Success - Post ID: ' + response.id);

				}
			});
			FB.api('/me', function(response) {
				loggedInUserId = response.id;
				var a = '<optgroup label="Personal Profile"><option>' + response.name + '</option></optgroup>';
				console.log(response);
				$("#selectTag").append(a);
			});
			FB.api('/me/applications/developer', function(response) {
				var a = '<optgroup label="Personal Profile"><option>' + response.data[0].name + '</option></optgroup>';
				console.log(response);
				$("#selectTag").append(a);
				console.log(response);
			});
			/* FB.api('/me/accounts', function(response) {
				console.log(response);
			}); */
		} else if (response.status === 'not_authorized') {
			FB.login();
		}
	});
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