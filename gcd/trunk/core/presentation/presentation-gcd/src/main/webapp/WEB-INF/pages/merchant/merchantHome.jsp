<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title>Best Daily Deals in New Orleans,LA | Hot Local Bargains in NOLA</title>

<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<script src="<c:url value='resources/js/main.js'/>"></script>
<link href="http://fonts.googleapis.com/css?family=Oswald:700" rel="stylesheet" type="text/css">
<link href="<c:url value='resources/css/main.css'/>" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="resources/images/icon.png">
<link href="<c:url value='resources/css/media.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />	
<script src="<c:url value='resources/js/js-image-slider.js'/>"></script>
<script src="<c:url value='resources/js/main.js'/>"></script></head>
<body style="margin: 0px;">
	<div class="all">
		<div id="wrapper">
			<!-- header start -->
			<div class="header">
				<div class="upper-header">
					<div class="social">
						<c:if test='${SESSION_ATTR_USER_INFO!=null}'>
							<div class="login" id="login">
								<a style="cursor: pointer;" href="appLogOut"><img src="<c:url value='resources/images/marchent-logout.png'/>" border="0"></a>
							</div>
						</c:if>
						<ul class="social-icon">
							<li><a href="http://www.facebook.com/GetCityDealz" target="_blank"><img src="<c:url value='resources/images/facebook.png'/>" width="auto" border="0" alt="facebook" title="facebook"></a></li>
							<li><a href="http://www.twitter.com/GetCityDealz" target="_blank"><img src="<c:url value='resources/images/twitter.png'/>" border="0" alt="twitter" title="twitter"></a></li>
							<li><a href="http://www.pinterest.com/getcitydealz" target="_blank"> <img src="<c:url value='resources/images/pintrest.png'/>" border="0" alt="pintrest" title="pintrest"></a></li>
							<li><a href="https://plus.google.com/113127686225602648376" target="_blank"> <img src="<c:url value='resources/images/gplush.png'/>" border="0" alt="Google Plus" title="Google Plus"></a></li>
							<li><a href="http://www.youtube.com/user/GetCityDealz" target="_blank"> <img src="<c:url value='resources/images/youtube.png'/>" border="0" alt="youtube" title="youtube"></a></li>
							<div class="clr"></div>
						</ul>

						<div class="clr"></div>
					</div>
					<div class="clr"></div>
				</div>

				<div class="mid-header">
					<div class="logo">
						<a href="/index"><img src="<c:url value='resources/images/logo1.png'/>" /></a>
						<div class="clr"></div>
					</div>
					<div id="sliderFrame">
						<div id="ribbon">
							<img id="prev87" class="prev-button"
								src="<c:url value='resources/images/prev.png'/>"
								alt="Previous"> <img id="next87" class="next-button"
								src="<c:url value='resources/images/next.png'/>"
								alt="Next">

						</div>
						<div class="slider" id="slider"></div>
					</div>
					<div class="clr"></div>
				</div>
				<div class="icon_menu">
					<ul>
						<li><a href="${subdomainUrl}/dealsbymaincategory/dining"><img src="<c:url value='resources/images/DINING.png'/>" /> </a></li>
						<li><a href="${subdomainUrl}/dealsbymaincategory/night-life"><img src="<c:url value='resources/images/NIGHTLIFE.png'/>" /></a></li>
						<li><a href="${subdomainUrl}/dealsbymaincategory/shopping"><img src="<c:url value='resources/images/SHOPPING.png'/>" /> </a></li>
						<li><a href="${subdomainUrl}/dealsbymaincategory/attractions"><img src="<c:url value='resources/images/ATTRACTIONS.png'/>" /></a></li>
						<li><a href="${subdomainUrl}/dealsbymaincategory/services"><img src="<c:url value='resources/images/SERVICES.png'/>" /></a></li>
						<li class="last"><a href="${subdomainUrl}/dealsbymaincategory/recreation"><img src="<c:url value='resources/images/RECREATION.png'/>" /></a></li>
						<div class="clr"></div>
					</ul>
					<div class="clr"></div>
					<div class="mobile_nav">
						<label> <select>
								<option>home</option>
								<option>
									<a href="#"><div class="menu-links">DINING</div></a>
								</option>
								<option>
									<a href="#"><span>NIGHTLIFE</span><em></em></a>
								</option>
								<option>
									<a href="#"><span>SHOPPING</span><em></em></a>
								</option>
								<option>
									<a href="#"><span>ATTRACTIONS</span><em></em></a>
								</option>
								<option>
									<a href="#"><span>SERVICES</span><em></em></a>
								</option>
								<option>
									<a href="#"><span>RECREATION</span><em></em></a>
								</option>
								<div class="clr"></div>
						</select>
						</label>
					</div>

					<!--menu for mobile start-->
					<div class="mobile_na">
						<div class="fflip" id="f1" onclick="fflip(this.id)">
							<img src="<c:url value='resources/images/toogle.png'/>">
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
			<div class="middle-comtaner">
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
				<!-- left start here -->
				<div class="left">
					<div class="modulet">
						<p style="font-size: 12px; padding: 6px; color: #ffffff; font-family: arial; font-weight: bold; text-align: center;">FIND YOUR DEALS</p>
					</div>
					<div class="moduletable dash_heading">
						<h4>
							<a style="cursor: pointer;" onclick="openPage('merchantDashboard')">Merchant Dashboard</a>
						</h4>
						<div class="clear"></div>
					</div>
					<div class="moduletable">
						<h4>Manage Merchant Information</h4>
						<ul>
							<li><a href="myProfile" style="cursor: pointer;">Basic Information</a></li>
							<li><a href="purchaseLevel" style="cursor: pointer;">Billing Information</a></li>
							<li><a href="manageLocation" style="cursor: pointer;">Manage Locations</a></li>
							<li><a href="manageMedia" style="cursor: pointer;">Manage Media</a></li>
							<li><a href="manageGcdSubscription" style="cursor: pointer;">Manage Your Get City Dealz Subscription</a></li>
							<li><a href="manageEmailPwd" style="cursor: pointer;">Manage Email & Password</a></li>
						</ul>
					</div>
					<div class="custom-drive">
						<div class="moduletable">
							<h4>Manage Merchant Deals</h4>
							<ul>
								<li><a href="allHotDealz?dealType=1" style="cursor: pointer;">All Deals</a></li>
								<li><a href="postDealz?dealType=1" style="cursor: pointer;">Create New Deal</a></li>
								<li><a href="allHotDealz?dealType=2" style="cursor: pointer;">All Hot Deals</a></li>
								<li><a href="postDealz?dealType=2" style="cursor: pointer;">Buy a Hot Deal</a></li>
							</ul>
						</div>
					</div>
					<div class="custom-drive">
						<div class="moduletable">
							<h4>Manage Blog</h4>
							<ul>
								<li><a href="loadAllPost" style="cursor: pointer;">All Posts</a></li>
								<li><a href="createPost" style="cursor: pointer;">Create New Post</a></li>
							</ul>
						</div>
					</div>
					<div class="custom-drive">
						<div class="moduletable">
							<h4>Manage Social Connections</h4>
							<ul>
								<li><a href="socialConnections" style="cursor: pointer;">Social Connections</a></li>
							</ul>
						</div>
					</div>
				</div>
				<!--/*--for mobile view start --*/-->


				<!--/*--for mobile view end --*/-->
				<!-- left end here -->

				<!-- mid start here -->
				<div class="merchantDetail">
					<div class="main-content">
						<!-- <iframe name="midContent" id="midContent" frameborder="0" marginheight="0" marginwidth="0" scrolling="no" style="width: 100%; height: 100%;"></iframe> -->
						<div id="midContentDiv"></div>
						<div class="clr"></div>
					</div>
					<div class="clr"></div>
				</div>
				<!-- mid end here -->
			</div>
			<!-- right end here -->
			<!-- footer start -->
			<div class="bottom">
				<div class="footer-left">
					<ul>
						<li class="active"><a href="/index">Home</a></li>
						<li class=""><a href="http://gcddev.com/privacy-policy">Privacy Policy</a></li>
						<li class=""><a href="http://gcddev.com/contactus">Contact Us</a></li>
					</ul>
				</div>

				<div class="copyright">Copyright © 2012-2014 Getcitydealz</div>

			</div>
			<!-- footer end -->
			<div class="clr"></div>
		</div>
		<div class="clr"></div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		window.location.href = 'merchantDashboard';
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