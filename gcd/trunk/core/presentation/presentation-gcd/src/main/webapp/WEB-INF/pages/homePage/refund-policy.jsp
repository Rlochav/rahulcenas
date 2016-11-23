<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Best Daily Deals in New Orleans,LA | Hot Local Bargains in NOLA</title>

<script type="text/javascript" src="<c:url value='../resources/js/jquery-2.0.3.js'/>"></script>
<script src="<c:url value='../resources/js/main.js'/>"></script>
<link href="<c:url value='../resources/css/main.css'/>" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="../resources/images/icon.png" />
<link href="<c:url value='../resources/css/media.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='../resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='../resources/js/js-image-slider.js'/>"></script>
</head>

<body>
	<%@include file="../common/telliumTags.jsp"%>
	<div class="all">
		<div id="wrapper">
			<!-- header start -->
			<div class="header">
				<div class="upper-header">
					<div class="social">
						<ul class="social-icon">
							<li><a id="gcd_sm_fb" href="http://www.facebook.com/GetCityDealz" target="_blank"><img src="<c:url value='../resources/images/facebook.png'/>" width="auto" border="0" alt="facebook" title="facebook"></a></li>
							<li><a id="gcd_sm_twitter" href="http://www.twitter.com/GetCityDealz" target="_blank"><img src="<c:url value='../resources/images/twitter.png'/>" border="0" alt="twitter" title="twitter"></a></li>
							<li><a id="gcd_sm_pinterest" href="http://www.pinterest.com/getcitydealz" target="_blank"> <img src="<c:url value='../resources/images/pintrest.png'/>" border="0" alt="pintrest" title="pintrest"></a></li>
							<li><a id="gcd_sm_g+" href="https://plus.google.com/113127686225602648376" target="_blank"> <img src="<c:url value='../resources/images/gplush.png'/>" border="0" alt="Google Plus" title="Google Plus"></a></li>
							<li><a id="gcd_sm_youtube" href="http://www.youtube.com/user/GetCityDealz" target="_blank"> <img src="<c:url value='../resources/images/youtube.png'/>" border="0" alt="youtube" title="youtube"></a></li>
							<div class="clr"></div>
						</ul>
						<c:if test='${SESSION_ATTR_USER_INFO==null}'>
							<div class="login" id="merchant_login_button">
								<a style="cursor: pointer;" href="merchant-login-city"><img src="<c:url value='../resources/images/marchent-login.png'/>" border="0"></a>
							</div>
						</c:if>
						<div class="clr"></div>
					</div>

					<div class="logo" id="header_home_link">
						<a href="index"> <img src="<c:url value='../resources/images/logo1.png'/>" /></a>
						<div class="clr"></div>
					</div>
					<div id="sliderFrame">
						<div id="ribbon">
							<img id="prev87" class="prev-button" src="<c:url value='../resources/images/prev.png'/>" alt="Previous"> <img id="next87" class="next-button" src="<c:url value='../resources/images/next.png'/>" alt="Next">

						</div>
						<div class="slider" id="slider"></div>
					</div>
					<div class="clr"></div>
				</div>
				<div class="icon_menu">
					<ul>
						<li><a id="tnb_dining" href="${subdomainUrl}/dealsbymaincategory/dining"><img src="<c:url value='../resources/images/DINING.png'/>" /> </a></li>
						<li><a id="tnb_nightlife" href="${subdomainUrl}/dealsbymaincategory/night-life"><img src="<c:url value='../resources/images/NIGHTLIFE.png'/>" /></a></li>
						<li><a id="tnb_shopping" href="${subdomainUrl}/dealsbymaincategory/shopping"><img src="<c:url value='../resources/images/SHOPPING.png'/>" /> </a></li>
						<li><a id="tnb_attractions" href="${subdomainUrl}/dealsbymaincategory/attractions"><img src="<c:url value='../resources/images/ATTRACTIONS.png'/>" /></a></li>
						<li><a id="tnb_services" href="${subdomainUrl}/dealsbymaincategory/services"><img src="<c:url value='../resources/images/SERVICES.png'/>" /></a></li>
						<li class="last"><a id="tnb_recreation" href="${subdomainUrl}/dealsbymaincategory/recreation"><img src="<c:url value='../resources/images/RECREATION.png'/>" /></a></li>
						<div class="clr"></div>
					</ul>

					<div class="clr"></div>
					<div class="mobile_nav">
						<label> <select>
								<option>home</option>
								<option><a href="dining"><div class="menu-links">DINING</div></a>
								</option>
								<option><a href="nightLife"><span>NIGHTLIFE</span><em></em></a>
								</option>
								<option><a href="shopping"><span>SHOPPING</span><em></em></a>
								</option>
								<option><a href="attractions"><span>ATTRACTIONS</span><em></em></a>
								</option>
								<option><a href="services"><span>SERVICES</span><em></em></a>
								</option>
								<option><a href="recreation"><span>RECREATION</span><em></em></a>
								</option>
								<div class="clr"></div>
						</select>
						</label>
					</div>

					<!--menu for mobile start-->
					<div class="mobile_na">
						<div class="fflip" id="f1" onclick="fflip(this.id)">
							<img src="<c:url value='../resources/images/toogle.png'/>">
						</div>
						<div class="ppanelf1">
							<a href="dining">
								<div class="stare3"></div>
								<p>DINING</p>
							</a> <a href="nightLife">
								<div class="stare3"></div>
								<p>NIGHTLIFE</p>
							</a> <a href="shopping">
								<div class="stare3"></div>
								<p>SHOPPING</p>
							</a> <a href="attractions">
								<div class="stare3"></div>
								<p>ATTRACTIONS</p>
							</a> <a href="services">
								<div class="stare3"></div>
								<p>SERVICES</p>
							</a> <a href="recreation">
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
					<div class="moduletable">
						<h4 id="deals_by_map">
							Deal By Map
							<div class="fflip" id="f2" onclick="fflip(this.id)">
								<img src="<c:url value='../resources/images/toogle1.png'/>">
							</div>
						</h4>
						<div class="left-first-box">
							<a href="dealzByMap/DealsOnMap"><img src="<c:url value='../resources/images/map.jpg'/>" width="150px" height="80px"></a>
						</div>

						<div class="ppanelf2">

							<a href="#"><img src="<c:url value='../resources/images/map.jpg'/>" width="150px" height="80px"></a>
						</div>

					</div>
					<div class="moduletable">
						<h4 id="neighborhood">
							Neighborhood Deals
							<div class="fflip" id="f3" onclick="fflip(this.id)">
								<img src="<c:url value='../resources/images/toogle1.png'/>">
							</div>
						</h4>
						<ul>
							<c:forEach var="nDto" items="${nDtoLis}">
								<c:set var="neighborhoodName" value="${nDto.neighborhoodName}" />
								<c:set var="neighborhoodName1" value="${fn:split(neighborhoodName, ' ')}" />
								<c:set var="neighborhoodName2" value="${fn:join(neighborhoodName1, '-')}" />
								<c:set var="neighborhoodName3" value="${fn:split(neighborhoodName2, '/')}" />
								<c:set var="neighborhoodName4" value="${fn:join(neighborhoodName3, '-')}" />
								<li><a href="${subdomainUrl}/dealsbyarea/${neighborhoodName4}-${nDto.neighborhoodId}">${nDto.neighborhoodName}(${nDto.count})</a></li>
							</c:forEach>
						</ul>

						<div class="ppanelf3">
							<c:forEach var="nDto" items="${nDtoLis}">
								<c:set var="neighborhoodName" value="${nDto.neighborhoodName}" />
								<c:set var="neighborhoodName1" value="${fn:split(neighborhoodName, ' ')}" />
								<c:set var="neighborhoodName2" value="${fn:join(neighborhoodName1, '-')}" />
								<c:set var="neighborhoodName3" value="${fn:split(neighborhoodName2, '/')}" />
								<c:set var="neighborhoodName4" value="${fn:join(neighborhoodName3, '-')}" />
								<a href="${subdomainUrl}/dealsbyarea/${neighborhoodName4}-${nDto.neighborhoodId}"><p>${nDto.neighborhoodName}(${nDto.count})</p></a>
							</c:forEach>

							<div class="clear"></div>
						</div>
						<div class="clear"></div>
					</div>
					<div class="moduletable">
						<h4 id="category">
							Deals by Category
							<div class="fflip" id="f4" onclick="fflip(this.id)">
								<img src="<c:url value='../resources/images/toogle1.png'/>">
							</div>
						</h4>
						<ul>
							<c:forEach var="categoryDTO" items="${categoryDTO}">
								<c:set var="categoryName" value="${categoryDTO.categoryName}" />
								<c:set var="categoryName1" value="${fn:split(categoryName, ' ')}" />
								<c:set var="categoryName2" value="${fn:join(categoryName1, '-')}" />
								<c:set var="categoryName3" value="${fn:split(categoryName2, '/')}" />
								<c:set var="categoryName4" value="${fn:join(categoryName3, '-')}" />
								<li><a href="dealsbycategory/${categoryName4}-${categoryDTO.categoryId}">${categoryDTO.categoryName}(${categoryDTO.counts})</a></li>
							</c:forEach>
						</ul>
						<div class="ppanelf4">
							<c:forEach var="categoryDTO" items="${categoryDTO}">
								<c:set var="categoryName" value="${categoryDTO.categoryName}" />
								<c:set var="categoryName1" value="${fn:split(categoryName, ' ')}" />
								<c:set var="categoryName2" value="${fn:join(categoryName1, '-')}" />
								<c:set var="categoryName3" value="${fn:split(categoryName2, '/')}" />
								<c:set var="categoryName4" value="${fn:join(categoryName3, '-')}" />
								<li><a href="dealsbycategory/${categoryName4}-${categoryDTO.categoryId}"><p>${categoryDTO.categoryName}(${categoryDTO.counts})</p></a></li>
							</c:forEach>
							<div class="clear"></div>
						</div>
					</div>
					<div class="custom-drive">
						<div class="moduletable">
							<h4 id="merchant_listing">
								<strong>Merchant Listings </strong>
								<div class="fflip" id="f5" onclick="fflip(this.id)">
									<img src="<c:url value='../resources/images/toogle1.png'/>">
								</div>
							</h4>
							<ul>
								<li><a id="ml_link" href="new-orleans-merchant-listing" target="_self">New Orleans Merchants</a></li>
							</ul>
							<div class="ppanelf5">
								<a href="#"><p>Merchant Listings</p> </a>
								<div class="clear"></div>
							</div>
						</div>
					</div>
				</div>
				<!--/*--for mobile view start --*/-->


				<!--/*--for mobile view end --*/-->
				<!-- left end here -->

				<!-- mid start here -->
				<div class="mid">
					<div class="mid-title text-padding">
						<div id="title">GET CITY DEALZ REFUND POLICY</div>
					</div>
					<div class="main-content text-padding-top">
						<div id="midContentDiv" class="item-page">
							<div id="system-message-container"></div>
							<h4>Billing and Payment.</h4>
							<p>GetCityDealz.com bills you through an online account (your “Billing Account”) for use of the Service. You agree to pay GetCityDealz.com all charges at the prices you agreed to for any use of the Service by you or other persons (including your agents) using your Billing Account, and
								you authorize GetCityDealz.com to charge your chosen payment provider (your “Payment Method”) for the Service.</p>
							<p>You agree to make payment using that selected Payment Method. GetCityDealz.com may correct any billing errors or mistakes that it makes even if it has already requested or received payment. This includes any agreements you made with GetCityDealz.com on the Website when becoming a
								Member or subscribing to the Service. The terms of your payment will be based on your Payment Method and may be determined by agreements between you and the financial institution, credit card issuer or other provider of your chosen Payment Method.</p>
							<h4>Automatic Renewal.</h4>
							<p>Your subscription will continue indefinitely until cancelled by you. After your initial subscription commitment period, and again after any subsequent subscription period, your subscription will automatically continue for an additional equivalent period, at the price you agreed to when
								subscribing. You agree that your account will be subject to this automatic renewal feature. If you do not wish your account to renew automatically, or if you want to change or terminate your subscription, please log in and go to the Change / Cancel Membership (or similar) page on your
								Account Settings page.</p>
							<p>If you cancel your subscription, you may use your subscription until the end of your then-current subscription term; your subscription will not be renewed after your then-current term expires. However, you won’t be eligible for a prorated refund of any portion of the subscription fee
								paid for the then-current subscription period. By subscribing, you authorize GetCityDealz.com to charge your Payment Method now and again at the beginning of any subsequent subscription period. You also authorize GetCityDealz.com to charge you for any sales or similar taxes that may be
								imposed on your subscription payments. Upon the renewal of your subscription, if GetCityDealz.com does not receive payment from your Payment Method provider, (i) you agree to pay all amounts due on your Billing Account upon demand, and/or (ii) you agree that GetCityDealz.com may either
								terminate or suspend your subscription and continue to attempt to charge your Payment Method provider until payment is received (upon receipt of payment, your account will be activated and for purposes of automatic renewal, your new subscription commitment period will begin as of the day
								payment was received).</p>
						</div>
					</div>
					<div class="clr"></div>
				</div>


				<!-- mid end here -->
				<!-- right start here -->
				<div class="right">
					<div class="modulet">
						<p style="color: #ffffff; font-family: arial; font-weight: bold; text-align: center;">GET CITY DEALS</p>

					</div>
					<div class="moduletable-drive">
						<h3 id="drive_foot_traffic">
							Drive Foot Traffic
							<div class="fflip" id="f6" onclick="fflip(this.id)">
								<img src="<c:url value='../resources/images/toogle1.png'/>">
							</div>
						</h3>
						<div class="right-box-1">
							<p style="text-align: center;">
								<a href="#" title="Become a Merchant"><strong><img src="<c:url value='../resources/images/become-a-merchant.png'/>" border="0" /></strong></a>
							</p>
							<p align="center">
								<strong>&bull;&nbsp;Bring in the Locals&nbsp;&bull;</strong>
							</p>
							<p align="center">
								<strong>&bull;&nbsp;Draw in the Tourists&nbsp;&bull;</strong>
							</p>
							<p align="center">
								<strong>&bull;&nbsp;Control Your Marketing&nbsp;&bull;</strong>
							</p>
							<p align="center">
								<strong>&bull;&nbsp;Connect With Fans&nbsp;&bull;</strong>
							</p>
							<p align="center">
								<strong>&bull;&nbsp;All On Your Schedule!&nbsp;&bull;</strong>
							</p>
							<p style="text-align: center;">
								<a style="cursor: pointer" onclick="becomeAmerchant();" target="_blank" title="Become a Merchant"><img src="<c:url value='../resources/images/start-dealz-now.png'/>" border="0" alt="Start Your Dealz Today!" title="Start Your Dealz Today!" width="163" height="32" style="border: 0;"></a>
							</p>
						</div>
						<div class="ppanelf6">
							<p style="text-align: center;">
								<a href="#" title="Become a Merchant"><strong><img src="<c:url value='../resources/images/become-a-merchant.png'/>" border="0" /></strong></a>
							</p>
							<p align="center">
								<strong>&bull;&nbsp;Bring in the Locals&nbsp;&bull;</strong>
							</p>
							<p align="center">
								<strong>&bull;&nbsp;Draw in the Tourists&nbsp;&bull;</strong>
							</p>
							<p align="center">
								<strong>&bull;&nbsp;Control Your Marketing&nbsp;&bull;</strong>
							</p>
							<p align="center">
								<strong>&bull;&nbsp;Connect With Fans&nbsp;&bull;</strong>
							</p>
							<p align="center">
								<strong>&bull;&nbsp;All On Your Schedule!&nbsp;&bull;</strong>
							</p>
							<p style="text-align: center;">
								<a style="cursor: pointer;" onclick="becomeMerchant();" target="_blank" title="Become a Merchant"><img src="<c:url value='../resources/images/start-dealz-now.png'/>" border="0" alt="Start Your Dealz Today!" title="Start Your Dealz Today!" width="163" height="32" style="border: 0;"></a>
							</p>
						</div>
					</div>
					<div class="moduletable-deli">
						<h3>
							Deals Delivered Free!
							<div class="fflip" id="f7" onclick="fflip(this.id)">
								<img src="<c:url value='../resources/images/toogle1.png'/>">
							</div>
						</h3>
						<div class="custom-deli">
							<p style="text-align: center;">
								<a id="dd_email" href="subscribe" style="cursor: se-resize !important;"><img src="<c:url value='../resources/images/email-24x24.png'/>" border="0" alt="Delivered By Email" title="Delivered By Email"></a>&nbsp; &nbsp;&nbsp;<a id="dd_fb" href="#" style="cursor: se-resize !important;"
									target="_blank"><img src="<c:url value='../resources/images/facebook-24x24.png'/>" border="0" alt="Delivered on Facebook" title="Delivered on Facebook"></a>&nbsp; &nbsp; <a id="dd_twitter" href="#" style="cursor: se-resize !important;" target="_blank"><img
									src="<c:url value='../resources/images/twitter-24x24.png'/>" border="0" alt="Delivered on Twitter" title="Delivered on Twitter"></a>
							</p>
						</div>
						<div class="ppanelf7">
							<p style="text-align: center;">
								<a id="dd_email" href="#"><img src="<c:url value='../resources/images/email-24x24.png'/>" border="0" alt="Delivered By Email" title="Delivered By Email"></a>&nbsp; &nbsp;&nbsp;<a id="dd_fb" href="#" target="_blank"><img src="<c:url value='../resources/images/facebook-24x24.png'/>"
									border="0" alt="Delivered on Facebook" title="Delivered on Facebook"></a>&nbsp; &nbsp; <a id="dd_twitter" href="#" target="_blank"><img src="<c:url value='../resources/images/twitter-24x24.png'/>" border="0" alt="Delivered on Twitter" title="Delivered on Twitter"></a>
							</p>
						</div>
					</div>
					<div class="moduletable-deli">
						<h3 id="lu_fb_button">
							Like Us on Facebook
							<div class="fflip" id="f8" onclick="fflip(this.id)">
								<img src="<c:url value='../resources/images/toogle1.png'/>">
							</div>
						</h3>
						<div class="custom-deli">
							<p align="center">
								<img src="<c:url value='../resources/images/fb-like-button.png'/>" border="0" alt="Like Get City Dealz on Facebook">
							</p>
							<p align="center">
								<a href="#" target="_blank">Like Us on&nbsp;Facebook&nbsp;&amp;&nbsp;Get Our Deals in Your News Feed</a>
							</p>
							<h3>
								<strong>Member</strong>
							</h3>
							<p>
								<img src="<c:url value='../resources/images/nola-chamber.png'/>" border="0" width="100%">
							</p>
							<p>
								<img src="<c:url value='../resources/images/nola-cvb.png'/>" border="0" width="100%">
							</p>
							<p>
								<img src="<c:url value='../resources/images/jefferson-parish-chamber.png'/>" border="0" alt="Jefferson Parish Chamber Member" width="100%">
							</p>
						</div>
						<div class="ppanelf8">
							<p align="center">
								<img src="<c:url value='../resources/images/fb-like-button.png'/>" border="0" alt="Like Get City Dealz on Facebook">
							</p>
							<p align="center">
								<a href="#" target="_blank">Like Us on&nbsp;Facebook&nbsp;&amp;&nbsp;Get Our Deals in Your News Feed</a>
							</p>
							<h3>
								<strong>Member</strong>
							</h3>
							<p>
								<img src="<c:url value='../resources/images/nola-chamber.png'/>" border="0" width="100%">
							</p>
							<p>
								<img src="<c:url value='../resources/images/nola-cvb.png'/>" border="0" width="100%">
							</p>
							<p>
								<img src="<c:url value='../resources/images/jefferson-parish-chamber.png'/>" border="0" alt="Jefferson Parish Chamber Member" width="100%">
							</p>
						</div>
					</div>
					<div class="moduletable-deli">
						<h3>
							Testimonials
							<div class="fflip" id="f8" onclick="fflip(this.id)">
								<img src="<c:url value='../resources/images/toogle1.png'/>">
							</div>
						</h3>
						<div class="custom-deli">
							<p>
								<em>"..this.id is definitely a unique way to reach current&nbsp;and potential pet owners." </em>&nbsp;-Anthony M.
							</p>
							<p>
								".<em>..GCD is an&nbsp;easy-touse,&nbsp;cost-effective alternative marketing method.</em>" -Scott V.
							</p>
							<p>
								"...<em>we like the ability to have control over and input our own&nbsp;offers and specials that GCD gives us!</em>" - Nannette G.
							</p>
							<p>
								"<em>I like the concept of putting out our own offers and announcements at any time, any day, any week- all&nbsp;year long. &nbsp; This is so much better than having plain directory listings, whether in print or on the Internet. &nbsp;The price is right too- the cost of a 1/3 page ad in
									our local magazine allows us to use your&nbsp;marketing program all year long.</em>" &nbsp;-Adam O
							</p>
						</div>
						<div class="ppanelf9">
							<p>
								<em>"..this.id is definitely a unique way to reach current&nbsp;and potential pet owners." </em>&nbsp;-Anthony M.
							</p>
							<p>
								".<em>..GCD is an&nbsp;easy-touse,&nbsp;cost-effective alternative marketing method.</em>" -Scott V.
							</p>
							<p>
								"...<em>midContentwe like the ability to have control over and input our own&nbsp;offers and specials that GCD gives us!</em>" - Nannette G.
							</p>
							<p>
								"<em>I like the concept of putting out our own offers and announcements at any time, any day, any week- all&nbsp;year long. &nbsp; This is so much better than having plain directory listings, whether in print or on the Internet. &nbsp;The price is right too- the cost of a 1/3 page ad in
									our local magazine allows us to use your&nbsp;marketing program all year long.</em>" &nbsp;-Adam O
							</p>
						</div>
					</div>

				</div>
			</div>
			<!-- right end here -->
			<!-- footer start -->
			<div class="bottom">
				<div class="footer-left">
					<ul>
						<li class="active"><a href="index">Home</a></li>
						<li class=""><a href="http://gcddev.com/privacy-policy">Privacy Policy</a></li>
						<li class=""><a href="http://gcddev.com/contactus">Contact Us</a></li>
					</ul>
				</div>

				<div class="copyright">Copyright &copy; 2012-2014 Getcitydealz</div>

			</div>
			<!-- footer end -->
		</div>


		<div class="clr"></div>
	</div>
</body>
<script type="text/javascript">
	var _gaq = _gaq || [];
	_gaq.push([ '_setAccount', 'UA-36507206-1' ]);
	_gaq.push([ '_setDomainName', 'getcitydealz.com' ]);
	_gaq.push([ '_trackPageview' ]);

	(function() {
		var ga = document.createElement('script');
		ga.type = 'text/javascript';
		ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl'
				: 'http://www')
				+ '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(ga, s);
	})();
</script>
<script type="text/javascript">
	$(function() {
		var retVal = $.ajax({
			url : "../jsonGetHotDealz",
			type : "POST",
			global : false,
			dataType : "json",
			async : false
		}).responseText;
		
		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
		if (obj != null) {
			var bannerArr = obj.bannerDTOs;
			var sliderImage='';
			for(var i=0;i<bannerArr.length;i++){
				'<c:set var="merchantName" value="'+bannerArr[i].merchantName+'" />';
				<c:set var="merchantName1" value="${fn:split(merchantName, ' ')}" />
				<c:set var="merchantName2" value="${fn:join(merchantName1, '-')}" />
				sliderImage +='<a href="../merchant/${merchantName2}-'+bannerArr[i].merchantId+'"><img src="../displayImage?image='+bannerArr[i].imagePath+'" id="wrap'+(i+1)+'" style="visibility: hidden;"/></a>';
			}
			//sliderImage +='<div class="clr"></div>';
			$("#slider").append(sliderImage);
		}
		
		if ('<c:out value="${SESSION_ATTR_USER_INFO.userIndex}"/>'.length > 0)
			window.location.href = "merchantHome";
		//openPage('loadAllDealz?upcoming=0');
	});

	function openPage(remotePage) {
		$("#midContentDiv").load(remotePage);
	}

	function becomeAmerchant() {
		window.open("become-a-merchant");
	}

	function shareOnFB(link, picture, name, desc, redirect) {
		window
				.open('https://www.facebook.com/dialog/feed?app_id=174025642805043&'
						+ 'link=http://162.209.102.165:8080/AppWeb/'
						+ '&picture=http://162.209.102.165:8080/AppWeb/displayImage?image='
						+ picture
						+ '&name='
						+ name
						+ '&description='
						+ desc
						+ '&redirect_uri=http://162.209.102.165:8080/AppWeb/');
	}

	function rateDealz(rate, dealzId) {
		var retVal = $.ajax({
			url : "rateDealz",
			global : false,
			type : "POST",
			data : {
				rate : rate,
				dealzId : dealzId
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);

		if (obj != null) {
			if (obj.jsonMessage == null) {
				if (obj.currentRating == "1") {
					$("#ratingStart1" + dealzId).addClass('on');
				} else if (obj.currentRating == "2") {
					$("#ratingStart1" + dealzId).addClass('on');
					$("#ratingStart2" + dealzId).addClass('on');
				} else if (obj.currentRating == "3") {
					$("#ratingStart1" + dealzId).addClass('on');
					$("#ratingStart2" + dealzId).addClass('on');
					$("#ratingStart3" + dealzId).addClass('on');
				} else if (obj.currentRating == "4") {
					$("#ratingStart1" + dealzId).addClass('on');
					$("#ratingStart2" + dealzId).addClass('on');
					$("#ratingStart3" + dealzId).addClass('on');
					$("#ratingStart4" + dealzId).addClass('on');
				} else if (obj.currentRating == "5") {
					$("#ratingStart1" + dealzId).addClass('on');
					$("#ratingStart2" + dealzId).addClass('on');
					$("#ratingStart3" + dealzId).addClass('on');
					$("#ratingStart4" + dealzId).addClass('on');
					$("#ratingStart5" + dealzId).addClass('on');
				}
				$(".error").html('');
				$("#error" + dealzId).html('Thankyou for rating.');
				$("#currentRating" + dealzId).html(obj.currentRating + "");
			} else {
				//alert(obj.jsonMessage);
				$(".error").html('');
				$("#error" + dealzId).html('<li>' + obj.jsonMessage + '</li>');
			}
		}
	}

	function rate(currentRating, dealzId) {
		if (currentRating == "1") {
			$("#ratingStart1" + dealzId).addClass('on');
		} else if (currentRating == "2") {
			$("#ratingStart1" + dealzId).addClass('on');
			$("#ratingStart2" + dealzId).addClass('on');
		} else if (currentRating == "3") {
			$("#ratingStart1" + dealzId).addClass('on');
			$("#ratingStart2" + dealzId).addClass('on');
			$("#ratingStart3" + dealzId).addClass('on');
		} else if (currentRating == "4") {
			$("#ratingStart1" + dealzId).addClass('on');
			$("#ratingStart2" + dealzId).addClass('on');
			$("#ratingStart3" + dealzId).addClass('on');
			$("#ratingStart4" + dealzId).addClass('on');
		} else if (currentRating == "5") {
			$("#ratingStart1" + dealzId).addClass('on');
			$("#ratingStart2" + dealzId).addClass('on');
			$("#ratingStart3" + dealzId).addClass('on');
			$("#ratingStart4" + dealzId).addClass('on');
			$("#ratingStart5" + dealzId).addClass('on');
		}
		$("#currentRating" + dealzId).html(currentRating);
	}
</script>
</html>
