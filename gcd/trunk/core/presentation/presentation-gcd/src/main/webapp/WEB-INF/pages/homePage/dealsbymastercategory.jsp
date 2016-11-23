<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Best Daily Deals in New Orleans,LA | Hot Local Bargains in NOLA</title>

<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<script src="<c:url value='resources/js/main.js'/>"></script>
<link rel="shortcut icon" href="resources/images/icon.png">
<link href="<c:url value='resources/css/main.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='resources/css/media.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='resources/js/js-image-slider.js'/>"></script>
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
							<li><a href="http://www.facebook.com/GetCityDealz" target="_blank"><img src="<c:url value='resources/images/facebook.png'/>" width="auto" border="0" alt="facebook" title="facebook"></a></li>
							<li><a href="http://www.twitter.com/GetCityDealz" target="_blank"><img src="<c:url value='resources/images/twitter.png'/>" border="0" alt="twitter" title="twitter"></a></li>
							<li><a href="http://www.pinterest.com/getcitydealz" target="_blank"> <img src="<c:url value='resources/images/pintrest.png'/>" border="0" alt="pintrest" title="pintrest"></a></li>
							<li><a href="https://plus.google.com/113127686225602648376" target="_blank"> <img src="<c:url value='resources/images/gplush.png'/>" border="0" alt="Google Plus" title="Google Plus"></a></li>
							<li><a href="http://www.youtube.com/user/GetCityDealz" target="_blank"> <img src="<c:url value='resources/images/youtube.png'/>" border="0" alt="youtube" title="youtube"></a></li>
							<div class="clr"></div>
						</ul>
						<c:if test='${SESSION_ATTR_USER_INFO==null}'>
							<div class="login" id="login">
								<a style="cursor: pointer;" href="../merchant-login-city"><img src="<c:url value='resources/images/marchent-login.png'/>" border="0"></a>
							</div>
						</c:if>
						<div class="clr"></div>
					</div>

					<div class="logo">
						<a href="../index"><img src="<c:url value='resources/images/logo1.png'/>" /></a>
						<div class="clr"></div>
					</div>
					<div id="sliderFrame">
						<div id="ribbon">
							<img id="prev87" class="prev-button" src="<c:url value='resources/images/prev.png'/>" alt="Previous"> <img id="next87" class="next-button" src="<c:url value='resources/images/next.png'/>" alt="Next">

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
							<img src="<c:url value='resources/images/toogle.png'/>">
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
						<h4>
							Deal By Map
							<div class="fflip" id="f2" onclick="fflip(this.id)">
								<img src="<c:url value='resources/images/toogle1.png'/>">
							</div>
						</h4>
						<div class="left-first-box">
							<a href="#"><img src="<c:url value='resources/images/map.jpg'/>" width="150px" height="80px"></a>
						</div>

						<div class="ppanelf2">

							<a href="#"><img src="<c:url value='resources/images/map.jpg'/>" width="150px" height="80px"></a>
						</div>

					</div>
					<div class="moduletable">
						<h4>
							Neighborhood Deals
							<div class="fflip" id="f3" onclick="fflip(this.id)">
								<img src="<c:url value='resources/images/toogle1.png'/>">
							</div>
						</h4>
						<ul>
							<c:forEach var="nDto" items="${nDtoLis}">
								<li><a href="dealsbyarea/${nDto.neighborhoodId}">${nDto.neighborhoodName}(${nDto.count})</a></li>
							</c:forEach>
						</ul>

						<div class="ppanelf3">
							<a href="#"><p>ByWater / Faubourg Marigny(1)</p></a> <a href="#"><p>Downtown / CBD(0)</p> </a> <a href="#"><p>East Orleans(0)</p> </a> <a href="#"><p>French Quarter(8)</p></a> <a href="#"><p>Frenchman Street(0)</p></a> <a href="#"><p>Garden District / Uptown(4)</p> </a> <a href="#"><p>Gentilly
									/ Lakeview(0)</p> </a> <a href="#"><p>Kenner / Airport(0)</p> </a> <a href="#"><p>Magazine Street(2)</p> </a> <a href="#"><p>Metairie / Jefferson (5)</p> </a> <a href="#"><p>MidCity(0)</p></a> <a href="#"><p>North Shore(0)</p></a> <a href="#"><p>Riverbend / Carrollton(1)</p></a> <a href="#"><p>Treme
									- Lafitte(0)</p></a> <a href="#"><p>West Bank(1)</p></a>
							<div class="clear"></div>
						</div>
						<div class="clear"></div>
					</div>
					<div class="moduletable">
						<h4>
							Deals by Category
							<div class="fflip" id="f4" onclick="fflip(this.id)">
								<img src="<c:url value='resources/images/toogle1.png'/>">
							</div>
						</h4>
						<ul>
							<li><a href="dealsbycategory/category">Automotive(0)</a></li>
							<li><a href="dealsbycategory/category">Bars / Pubs(0)</a></li>
							<li><a href="dealsbycategory/category">Beauty(0)</a></li>
							<li><a href="dealsbycategory/category">Coffee Shops / Bakeries(0)</a></li>
							<li><a href="dealsbycategory/category">Education(0)</a></li>
							<li><a href="dealsbycategory/category">Entertainment / Events(0)</a></li>
							<li><a href="dealsbycategory/category">Health / Wellness(0)</a></li>
							<li><a href="dealsbycategory/category">Home Improvement(0)</a></li>
							<li><a href="dealsbycategory/category">Online(0)</a></li>
							<li><a href="dealsbycategory/category">Organizations / Associations(0)</a></li>
							<li><a href="dealsbycategory/category">Pets(0)</a></li>
							<li><a href="dealsbycategory/category">Professional Services(0)</a></li>
							<li><a href="dealsbycategory/category">Real Estate(0)</a></li>
							<li><a href="dealsbycategory/category">Restaurants(0)</a></li>
							<li><a href="dealsbycategory/category">Retail Shops(0)</a></li>
							<li><a href="dealsbycategory/category">Tours / Charters(0)</a></li>
							<li><a href="dealsbycategory/category">Travel Accomodations(0)</a></li>
						</ul>
						<div class="ppanelf4">
							<a href="#"><p>Automotive(1)</p></a> <a href="#"><p>Bars / Pubs(2)</p> </a> <a href="#"><p>Beauty(0)</p> </a> <a href="#"><p>Coffee Shops / Bakeries(0)</p> </a> <a href="#"><p>Education(0)</p></a> <a href="#"><p>Entertainment / Events(1)</p></a> <a href="#"><p>Health / Wellness(5)</p> </a> <a
								href="#"><p>Home Improvement(2)</p> </a> <a href="#"><p>Online(0)</p> </a> <a href="#"><p>Organizations / Associations(2)</p> </a> <a href="#"><p>Pets(2)</p> </a> <a href="#"><p>Professional Services(1)</p> </a> <a href="#"><p>Real Estate(0)</p> </a> <a href="#"><p>Restaurants(0)</p> </a> <a
								href="#"><p>Retail Shops(4)</p> </a> <a href="#"><p>Tours / Charters(2)</p> </a> <a href="#"><p>Travel Accomodations(0)</p> </a>

							<div class="clear"></div>
						</div>
					</div>
					<div class="custom-drive">
						<div class="moduletable">
							<h4>
								<strong>Merchant Listings </strong>
								<div class="fflip" id="f5" onclick="fflip(this.id)">
									<img src="<c:url value='resources/images/toogle1.png'/>">
								</div>
							</h4>
							<ul>
								<li><a href="new-orleans-merchant-listing" target="_self">New Orleans Merchants</a></li>
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
					<div class="mid-title">
						<div id="title"></div>
					</div>
					<div class="main-content">
						<!-- <iframe name="midContent" id="midContent" frameborder="0" marginheight="0" marginwidth="0" scrolling="no" style="width: 100%; height: 100%;"></iframe> -->
						<div id="midContentDiv">
							<form:form id="displayDealz" name="displayDealz" action="loadAllDealz" cssClass="formStyle">
								<h3 class="msg">
									<em>The Latest Deals</em>
								</h3>
								<c:forEach var="listVar" items="${dealzs}">
									<div class="shadow">
										<div class="deals_left">
											<img src="displayImage?image=${listVar.imagePath}" />
										</div>
										<div class="deals_right">
											<div class="border">
												<strong><c:out value="${listVar.title}" /></strong>
											</div>
											<div class="border">
												<span><c:out value="${listVar.restriction}" /></span>
											</div>
											<div class="border">
												<div class="deal-start">
													<b>Deal Start :</b>
													<c:out value="${listVar.startDate}" />
												</div>
												<div class="deal-start">
													<b>Deal End :</b>
													<c:out value="${listVar.endDate}" />
												</div>
												<div class="clr"></div>
											</div>
											<div class="border2">
												<b>Description :</b>
												<c:out value="${listVar.description}" />
											</div>
											<div class="border">
												<div class="share-deal share">
													<p>Share Deal on Facebook</p>
													<a style="cursor: pointer;" onclick="shareOnFB('link','<c:out value="${listVar.imagePath}" />','<c:out value="${listVar.title}" />','<c:out value="${listVar.description}" />','redirect');"><img src="<c:url value='resources/images/facebook-share-this-deal-ic1.png'/>" /></a>
												</div>
												<div class="share-deal rate">
													<p>Rate this deal</p>
													Rating: (<label id="currentRating${listVar.dealId}"></label>/5)
													<div class="rating">
														<div class="cancel">
															<a style="cursor: pointer;" title="Cancel Rating">Cancel Rating</a>
														</div>
														<div class="star" id="ratingStart1<c:out value="${listVar.dealId}"/>">
															<a style="cursor: pointer;" title="Give it 1/1" style="width: 100%;" onclick="rateDealz(1,${listVar.dealId});">1</a>
														</div>
														<div class="star" id="ratingStart2<c:out value="${listVar.dealId}"/>">
															<a style="cursor: pointer;" title="Give it 2/2" style="width: 100%;" onclick="rateDealz(2,${listVar.dealId});">2</a>
														</div>
														<div class="star" id="ratingStart3<c:out value="${listVar.dealId}"/>">
															<a style="cursor: pointer;" title="Give it 3/3" style="width: 100%;" onclick="rateDealz(3,${listVar.dealId});">3</a>
														</div>
														<div class="star" id="ratingStart4<c:out value="${listVar.dealId}"/>">
															<a style="cursor: pointer;" title="Give it 4/4" style="width: 100%;" onclick="rateDealz(4,${listVar.dealId});">4</a>
														</div>
														<div class="star" id="ratingStart5<c:out value="${listVar.dealId}"/>">
															<a style="cursor: pointer;" title="Give it 5/5" style="width: 100%;" onclick="rateDealz(5,${listVar.dealId});">5</a>
														</div>
													</div>
													<script type="text/javascript">
															$(function(){
																rate(${listVar.currentRating},${listVar.dealId});
															})
															</script>
												</div>
												<div class="share-deal subscribe">
													<p>Subscribe to Merchant</p>
													<img src="<c:url value='resources/images/email-16x16.png'/>" />&nbsp;<img src="<c:url value='resources/images/twitter-16x16.png'/>" />&nbsp;<img src="<c:url value='resources/images/facebook-16x16.png'/>" />
												</div>
												<div class="clr"></div>
												<label class="error" id="error${listVar.dealId}"></label>
											</div>
										</div>
										<div class="clr"></div>
									</div>
								</c:forEach>
							</form:form>
						</div>
						<div class="clr"></div>
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
						<h3>
							Drive Foot Traffic
							<div class="fflip" id="f6" onclick="fflip(this.id)">
								<img src="<c:url value='resources/images/toogle1.png'/>">
							</div>
						</h3>
						<div class="right-box-1">
							<p style="text-align: center;">
								<a href="#" title="Become a Merchant"><strong><img src="<c:url value='resources/images/become-a-merchant.png'/>" border="0" /></strong></a>
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
								<a style="cursor: pointer" onclick="becomeAmerchant();" target="_blank" title="Become a Merchant"><img src="<c:url value='resources/images/start-dealz-now.png'/>" border="0" alt="Start Your Dealz Today!" title="Start Your Dealz Today!" width="163" height="32" style="border: 0;"></a>
							</p>
						</div>
						<div class="ppanelf6">
							<p style="text-align: center;">
								<a href="#" title="Become a Merchant"><strong><img src="<c:url value='resources/images/become-a-merchant.png'/>" border="0" /></strong></a>
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
								<a style="cursor: pointer;" onclick="becomeMerchant();" target="_blank" title="Become a Merchant"><img src="<c:url value='resources/images/start-dealz-now.png'/>" border="0" alt="Start Your Dealz Today!" title="Start Your Dealz Today!" width="163" height="32" style="border: 0;"></a>
							</p>
						</div>
					</div>
					<div class="moduletable-deli">
						<h3>
							Deals Delivered Free!
							<div class="fflip" id="f7" onclick="fflip(this.id)">
								<img src="<c:url value='resources/images/toogle1.png'/>">
							</div>
						</h3>
						<div class="custom-deli">
							<p style="text-align: center;">
								<a href="#" style="cursor: se-resize !important;"><img src="<c:url value='resources/images/email-24x24.png'/>" border="0" alt="Delivered By Email" title="Delivered By Email"></a>&nbsp; &nbsp;&nbsp;<a href="#" style="cursor: se-resize !important;" target="_blank"><img
									src="<c:url value='resources/images/facebook-24x24.png'/>" border="0" alt="Delivered on Facebook" title="Delivered on Facebook"></a>&nbsp; &nbsp; <a href="#" style="cursor: se-resize !important;" target="_blank"><img src="<c:url value='resources/images/twitter-24x24.png'/>" border="0"
									alt="Delivered on Twitter" title="Delivered on Twitter"></a>
							</p>
						</div>
						<div class="ppanelf7">

							<p style="text-align: center;">
								<a href="#"><img src="<c:url value='resources/images/email-24x24.png'/>" border="0" alt="Delivered By Email" title="Delivered By Email"></a>&nbsp; &nbsp;&nbsp;<a href="#" target="_blank"><img src="<c:url value='resources/images/facebook-24x24.png'/>" border="0"
									alt="Delivered on Facebook" title="Delivered on Facebook"></a>&nbsp; &nbsp; <a href="#" target="_blank"><img src="<c:url value='resources/images/twitter-24x24.png'/>" border="0" alt="Delivered on Twitter" title="Delivered on Twitter"></a>
							</p>
						</div>
					</div>
					<div class="moduletable-deli">
						<h3>
							Like Us on Facebook
							<div class="fflip" id="f8" onclick="fflip(this.id)">
								<img src="<c:url value='resources/images/toogle1.png'/>">
							</div>
						</h3>
						<div class="custom-deli">
							<p align="center">
								<img src="<c:url value='resources/images/fb-like-button.png'/>" border="0" alt="Like Get City Dealz on Facebook">
							</p>
							<p align="center">
								<a href="#" target="_blank">Like Us on&nbsp;Facebook&nbsp;&amp;&nbsp;Get Our Deals in Your News Feed</a>
							</p>
							<h3>
								<strong>ACCOMPLISHMENTS</strong>
							</h3>
							<p>
								<img src="<c:url value='resources/images/SNCR-excellence-winner.gif'/>" border="0" width="100%">
							</p>
							<p>
								<img src="<c:url value='resources/images/US-Search-Winner-Small.jpg'/>" border="0" width="100%">
							</p>
							<h3>
								<strong>Member</strong>
							</h3>
							<p>
								<img src="<c:url value='resources/images/nola-chamber.png'/>" border="0" width="100%">
							</p>
							<p>
								<img src="<c:url value='resources/images/nola-cvb.png'/>" border="0" width="100%">
							</p>
							<p>
								<img src="<c:url value='resources/images/jefferson-parish-chamber.png'/>" border="0" alt="Jefferson Parish Chamber Member" width="100%">
							</p>
						</div>
						<div class="ppanelf8">
							<p align="center">
								<img src="<c:url value='resources/images/fb-like-button.png'/>" border="0" alt="Like Get City Dealz on Facebook">
							</p>
							<p align="center">
								<a href="#" target="_blank">Like Us on&nbsp;Facebook&nbsp;&amp;&nbsp;Get Our Deals in Your News Feed</a>
							</p>
							<h3>
								<strong>Member</strong>
							</h3>
							<p>
								<img src="<c:url value='resources/images/nola-chamber.png'/>" border="0" width="100%">
							</p>
							<p>
								<img src="<c:url value='resources/images/nola-cvb.png'/>" border="0" width="100%">
							</p>
							<p>
								<img src="<c:url value='resources/images/jefferson-parish-chamber.png'/>" border="0" alt="Jefferson Parish Chamber Member" width="100%">
							</p>
						</div>
					</div>
					<div class="moduletable-deli">
						<h3>
							Testimonials
							<div class="fflip" id="f8" onclick="fflip(this.id)">
								<img src="<c:url value='resources/images/toogle1.png'/>">
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
						<li class="active"><a href="../index">Home</a></li>
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
	$(function() {
		var retVal = $.ajax({
			url : "jsonGetHotDealz",
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
				sliderImage +='<a href="merchant/${merchantName2}-'+bannerArr[i].merchantId+'"><img src="displayImage?image='+bannerArr[i].imagePath+'" id="wrap'+(i+1)+'" style="visibility: hidden;"/></a>';
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

	function becomeMerchant() {
		$("#midContentDiv").load('becomeAmerchant');
	}

	function becomeAmerchant() {
		window.open("become-a-merchant");
	}
	
	function shareOnFB(link, picture, name, desc, redirect) {
		window.open('https://www.facebook.com/dialog/feed?app_id=174025642805043&' + 'link=http://162.209.102.165:8080/AppWeb/'
				+ '&picture=http://162.209.102.165:8080/AppWeb/displayImage?image=' + picture + '&name=' + name + '&description=' + desc
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
				//alert(obj.currentRating);
				$("#currentRating"+dealzId).html(obj.currentRating+"");
			} else {
				//alert(obj.jsonMessage);
				$(".error").html('');
				$("#error"+dealzId).html('<li>' + obj.jsonMessage + '</li>');
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
		$("#currentRating"+dealzId).html(currentRating);
	}
</script>
</html>
