<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Best Daily Deals in New Orleans,LA | Hot Local Bargains in NOLA</title>

<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<script src="<c:url value='resources/js/main.js'/>"></script>
<link href="<c:url value='resources/css/main.css'/>" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="resources/images/icon.png" />
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
							<li><a id="gcd_sm_fb" href="http://www.facebook.com/GetCityDealz" target="_blank"><img src="<c:url value='resources/images/facebook.png'/>" width="auto" border="0" alt="facebook" title="facebook"></a></li>
							<li><a id="gcd_sm_twitter" href="http://www.twitter.com/GetCityDealz" target="_blank"><img src="<c:url value='resources/images/twitter.png'/>" border="0" alt="twitter" title="twitter"></a></li>
							<li><a id="gcd_sm_pinterest" href="http://www.pinterest.com/getcitydealz" target="_blank"> <img src="<c:url value='resources/images/pintrest.png'/>" border="0" alt="pintrest" title="pintrest"></a></li>
							<li><a id="gcd_sm_g+" href="https://plus.google.com/113127686225602648376" target="_blank"> <img src="<c:url value='resources/images/gplush.png'/>" border="0" alt="Google Plus" title="Google Plus"></a></li>
							<li><a id="gcd_sm_youtube" href="http://www.youtube.com/user/GetCityDealz" target="_blank"> <img src="<c:url value='resources/images/youtube.png'/>" border="0" alt="youtube" title="youtube"></a></li>
							<div class="clr"></div>
						</ul>
						<c:if test='${SESSION_ATTR_USER_INFO==null}'>
							<div class="login" id="merchant_login_button">
								<a style="cursor: pointer;" href="merchant-login-city"><img src="<c:url value='resources/images/marchent-login.png'/>" border="0"></a>
							</div>
						</c:if>
						<div class="clr"></div>
					</div>

					<div class="logo" id="header_home_link">
						<a href="index"> <img src="<c:url value='resources/images/logo1.png'/>" /></a>
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
						<li><a id="tnb_dining" href="${subdomainUrl}/dealsbymaincategory/dining"><img src="<c:url value='resources/images/DINING.png'/>" /> </a></li>
						<li><a id="tnb_nightlife" href="${subdomainUrl}/dealsbymaincategory/night-life"><img src="<c:url value='resources/images/NIGHTLIFE.png'/>" /></a></li>
						<li><a id="tnb_shopping" href="${subdomainUrl}/dealsbymaincategory/shopping"><img src="<c:url value='resources/images/SHOPPING.png'/>" /> </a></li>
						<li><a id="tnb_attractions" href="${subdomainUrl}/dealsbymaincategory/attractions"><img src="<c:url value='resources/images/ATTRACTIONS.png'/>" /></a></li>
						<li><a id="tnb_services" href="${subdomainUrl}/dealsbymaincategory/services"><img src="<c:url value='resources/images/SERVICES.png'/>" /></a></li>
						<li class="last"><a id="tnb_recreation" href="${subdomainUrl}/dealsbymaincategory/recreation"><img src="<c:url value='resources/images/RECREATION.png'/>" /></a></li>
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
						<h4 id="deals_by_map">
							Deal By Map
							<div class="fflip" id="f2" onclick="fflip(this.id)">
								<img src="<c:url value='resources/images/toogle1.png'/>">
							</div>
						</h4>
						<div class="left-first-box">
							<a href="dealzByMap/DealsOnMap"><img src="<c:url value='resources/images/map.jpg'/>" width="150px" height="80px"></a>
						</div>

						<div class="ppanelf2">

							<a href="#"><img src="<c:url value='resources/images/map.jpg'/>" width="150px" height="80px"></a>
						</div>

					</div>
					<div class="moduletable">
						<h4 id="neighborhood">
							Neighborhood Deals
							<div class="fflip" id="f3" onclick="fflip(this.id)">
								<img src="<c:url value='resources/images/toogle1.png'/>">
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
								<img src="<c:url value='resources/images/toogle1.png'/>">
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
									<img src="<c:url value='resources/images/toogle1.png'/>">
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
						<div id="title">Jefferson Chamber Special</div>
					</div>
					<div class="main-content text-padding-top1">
						<div id="midContentDiv" class="midContentDiv item-page">
							<div id="system-message-container"></div>
							<table width="98%" align="center">
								<tbody>
									<tr>
										<td align="center" valign="middle"><img src="<c:url value='resources/images/GCD-Logo-650w.jpg'/>" border="0" width="200" style="border: 0;">&nbsp;</td>
										<td align="center" valign="middle">&nbsp;<img src="<c:url value='resources/images/jefferson-chamber-logo.png'/>" border="0" width="283" height="155"></td>
									</tr>
								</tbody>
							</table>
							<p class="MsoNormal">
								<span style="font-size: 20.0pt;">Local Marketing Works!</span>
							</p>
							<p>
								<img src="<c:url value='resources/images/GCD-Screenshot.png'/>" border="0" width="300" style="border: 0; float: right; margin-left: 10px; margin-right: 10px;"><span
									style="font-size: 11.0pt; font-family: 'Calibri', 'sans-serif'; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: Calibri; mso-fareast-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: EN-US; mso-bidi-language: AR-SA;">Expand
									Your Local Reach. Drive Foot Traffic to Your Business.</span>
							</p>
							<p class="MsoNormal">
								<span style="font-size: 9.0pt;">GetCityDealz.com allows local merchants in New Orleans to create, control and manage social media campaigns to promote their businesses easily and effectively!</span>&nbsp;
							</p>
							<p class="MsoNormal">
								<span style="font-size: 9.0pt;">The Jefferson Chamber of Commerce and GetCityDealz.com are pleased to offer a <em><span style="text-decoration: underline;">free</span></em> six-month trial of GetCityDealz.com <em><span style="text-decoration: underline;">exclusively</span></em> for
									current and new Chamber members!
								</span><span style="font-size: 9pt;">&nbsp;</span>
							</p>
							<p class="MsoNormal">
								<span style="text-decoration: underline;"><span style="font-size: 9.0pt; color: #0070c0;">Sign up today</span></span><span style="font-size: 9.0pt;"> by filling out the contact information or sending an email to web [at] getcitydealz.com.</span>
							</p>
							<p class="MsoNormal"></p>
							<div id="aiContactSafe_form_1">
								<div class="aiContactSafe" id="aiContactSafe_mainbody_1">
									<div class="contentpaneopen">
										<table id="aiContactSafeForm" border="0" cellpadding="0" cellspacing="5">
											<tbody>
												<tr>
													<td valign="top" style="width: 400px;">
														<div id="displayAiContactSafeForm_1" style="">
															<form:form id="becomeMerchant" name="becomeMerchant">

																<div style="margin-bottom: 10%;">Interested in becoming a Get City Dealz Merchant? Fill out the form below and we'll contact you about becoming one of our newest New Orleans merchants!</div>

																<div class="profile">
																	<div class="errorDiv" id="errorDiv">
																		<label style="color: red;">${message}</label>
																	</div>
																	<div class="merchantRegForm">
																		<div>
																			<div>Fields marked with ( ! ) are required.</div>
																			<div>
																				<div>
																					<span><label id="bussinessName_lbl">Business Name</label></span>&nbsp;<label>( ! )</label>
																				</div>
																				<div>
																					<input type="text" name="bussinessName" id="bussinessName" class="mInput" />
																				</div>
																			</div>
																			<div>
																				<div>
																					<span><label id="typeOfBusiness_lbl">Type of Business</label></span>&nbsp;<label class="required_field">( ! )</label>
																				</div>
																				<div>
																					<input type="text" name="typeOfBusiness" id="typeOfBusiness" class="mInput" />
																				</div>
																			</div>
																			<div>
																				<div>
																					<span><label id="contactName_lbl">Contact Name</label></span>&nbsp;<label>( ! )</label>
																				</div>
																				<div>
																					<input type="text" name="contactName" id="contactName" class="mInput" />
																				</div>
																			</div>
																			<div>
																				<div>
																					<span><label id="emailId_lbl">Email</label></span>&nbsp;<label class="required_field">( ! )</label>
																				</div>
																				<div>
																					<input type="text" name="emailId" id="emailId" class="mInput">
																				</div>
																			</div>
																			<div>
																				<div>
																					<span><label id="phone_lbl">Phone</label></span>&nbsp;
																				</div>
																				<div>
																					<input type="text" name="phone" id="phone" maxlength="15" class="mInput" />
																				</div>
																			</div>
																			<div>
																				<div>
																					<input type="checkbox" name="sendToSender" id="sendToSender" class="checkbox" />
																				</div>
																				<div>
																					<span><label for="aics_send_to_sender">Send a copy of this message to yourself</label></span>&nbsp;
																				</div>
																			</div>
																		</div>
																		<div class="clr" style="margin-bottom: 5%;"></div>
																		<div id="div_captcha">
																			<div id="div_captcha_info">Please enter the following security code:</div>
																			<div id="div_captcha_img">
																				<div id="div_captcha_img_3" style="width: 300px; height: 55px;">
																					<img id="captcha" src="<c:url value="simpleCaptcha.jpg" />" width="150"> <label id="tempcaptcha"></label>
																				</div>
																			</div>
																			<a style="cursor: pointer;" onclick="reloadCapcha();">Not readable? Change text.</a>
																			<div style="margin-top: 5px;" id="div_captcha_code">
																				<input type="text" name="answer" id="answer">
																			</div>
																		</div>
																		<div id="div_captcha">
																			<div style="margin-top: 5px;" id="div_captcha_code">
																				<input type="button" value="Send" id="sendMerchantInfo" onclick="sendRequest();">
																			</div>
																		</div>
																	</div>
																	<div style="float: right;"></div>
																</div>
															</form:form>
														</div> <br clear="all"> <br clear="all">
													</td>
													<td valign="top"><p>&nbsp;</p>
														<p>&nbsp;</p></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<p></p>
							<p class="MsoNormal" style="margin-left: .5in;">
								<em><span style="font-size: 9.0pt;">"GetCityDealz.com is so very easy to use – as simple to learn as writing and sending an email!"</span></em>&nbsp;
							</p>
							<p class="MsoNormal" style="margin-left: .5in;">
								<em><span style="font-size: 9.0pt;">"We like the ability to have control over and input our own offers and specials that GCD gives us!"</span></em>&nbsp;
							</p>
							<p class="MsoNormal" style="margin-left: .5in;">
								<em><span style="font-size: 9.0pt;">"Spending a lot of money on a social media marketing campaign is not in our budget. GetCityDealz.com makes it possible for us to create and manage our own campaigns!</span></em>&nbsp;
							</p>
							<p class="MsoNormal">&nbsp;</p>
							<p class="MsoNormal">
								<span style="font-size: 16.0pt;">GetCityDealz.com's mission is to support and promote local businesses.</span>&nbsp;
							</p>
							<p class="MsoNormal">Competition from national brands is intense and marketing budgets are tight. For local merchants, search and social media marketing is necessary to expand your reach and attract foot traffic to your business. GetCityDealz.com is your one-stop social media marketing
								campaign tool!</p>
							<p class="MsoNormal" style="text-align: center;">
								<strong><span
									style="font-size: 16.0pt; font-family: 'Calibri', 'sans-serif'; mso-ascii-theme-font: minor-latin; mso-fareast-font-family: Calibri; mso-fareast-theme-font: minor-latin; mso-hansi-theme-font: minor-latin; mso-bidi-font-family: 'Times New Roman'; mso-bidi-theme-font: minor-bidi; mso-ansi-language: EN-US; mso-fareast-language: EN-US; mso-bidi-language: AR-SA;">Local
										Marketing has never been so easy!</span></strong>&nbsp;
							</p>
							<p class="MsoNormal" style="text-align: center;">
								<span style="font-size: 16.0pt;"><img src="<c:url value='resources/images/in-the-news.png'/>" border="0" alt="Get City Dealz in the News" width="500" style="vertical-align: middle; border: 0;"></span>
							</p>
							<p class="MsoNormal" style="text-align: center;">
								&nbsp;<a href="http://markets.cbsnews.com/cbsnews/news/read/23357907/get_city_dealz_helps_jazzy_nola_reach_new_orleans_visitors_in_time_for_the_big_game_and_mardi_gras_celebrations?tag=cbsContent;contentMain" target="_blank">CBS Money Watch</a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<a
									href="http://finance.yahoo.com/news/city-dealz-helps-drive-customers-113000593.html" target="_blank">Yahoo! Finance</a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<a href="http://www.businesswire.com/news/home/20130223005012/en/City-Dealz-Glam-504-Small-Town-Pennsylvania"
									target="_blank">Business Wire</a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<a href="http://www.reuters.com/article/2013/02/02/la-get-city-dealz-idUSnBw7qMyM3a+114+BSW20130202" target="_blank">Reuters</a>&nbsp; &nbsp; &nbsp;
							</p>
							<p class="MsoNormal">&nbsp;</p>
							<p class="MsoNormal">
								<span style="text-decoration: underline;"><span style="font-size: 9.0pt;">About the Jefferson Chamber of Commerce</span></span><span style="font-size: 9.0pt;">:</span>
							</p>
							<p class="MsoNormal">
								<span style="font-size: 9.0pt;">The Jefferson Chamber is the premier business organization in the greater New Orleans area. We work on behalf of our members to help their businesses grow, implement relevant and informative programming and provide opportunities to build relationships
									with other businesses in the community. Visit us at </span><a href="http://jeffersonchamber.org/"><span style="font-size: 9.0pt;">http://jeffersonchamber.org</span></a><span style="font-size: 9.0pt;"> or call us at (504) 835-3880.</span><span style="font-size: 9pt;">&nbsp;</span>
							</p>
							<p class="MsoNormal">
								<span style="text-decoration: underline;"><span style="font-size: 9.0pt;">About GetCityDealz.com</span></span><span style="font-size: 9.0pt;">:</span>
							</p>
							<p class="MsoNormal">
								<a href="http://www.getcitydealz.com/?utm_source=SalesPitch&amp;utm_medium=Email&amp;utm_content=Introductory&amp;utm_campaign=PatCalls"><span style="font-size: 9.0pt;">GetCityDealz.com</span></a><span style="font-size: 9.0pt;">&nbsp;is a new technology company launched in New Orleans
									that helps local merchants promote their businesses on its web-based marketing platform. Designed to integrate all aspects of online marketing from search engines to social media networks, GetCityDealz serves up “Real-Time, Local Deals” when visitors to the site want them the most.
									Searchable by local neighborhoods, categories and even a map that locates the deals, GetCityDealz benefits both consumers and merchants.</span>
							</p>
							<p class="MsoNormal">
								<span lang="EN-GB">&nbsp;</span><span lang="EN-GB">The GetCityDealz technology uses proprietary algorithms to integrateaspects of both <em><span style="text-decoration: underline;">Search Engine Optimization</span></em> and <em><span style="text-decoration: underline;">Social
											Media Marketing</span></em> so that, when local merchants promote a special offer, a featured product or an event in the system, it automatically integrates with Facebook, Twitter and other social media networks. This and other strategies increase local reach, encourage social engagement, build brand
									awareness and drive foot traffic to your door!
								</span>&nbsp;
							</p>
							<p class="MsoNormal">
								GetCityDealz.com enables merchants to create, control and manage social media campaigns to promote their businesses easily and effectively – and it is as simple to use as composing and sending an email. While some merchants and professional service providers offer discounted deals,
								GetCityDealz encourages <span lang="EN-GB">business owners to post all sorts of marketing messages, including featured items, special offers, upcoming events, announcements and other brand-building information. We attract consumers who are looking for wonderful local products and
									services – and are delighted to learn about what businesses have to offer!</span>
							</p>
							<p class="MsoNormal">&nbsp;</p>
							<p class="MsoNormal">&nbsp;</p>
							<p class="MsoNormal">&nbsp;</p>
							<p class="MsoNormal">&nbsp;</p>
							<p class="MsoNormal">&nbsp;</p>
							<p class="MsoNormal">&nbsp;</p>
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
						<h3 id="drive_foot_traffic">
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
								<a id="dd_email" href="subscribe" style="cursor: se-resize !important;"><img src="<c:url value='resources/images/email-24x24.png'/>" border="0" alt="Delivered By Email" title="Delivered By Email"></a>&nbsp; &nbsp;&nbsp;<a id="dd_fb" href="#" style="cursor: se-resize !important;"
									target="_blank"><img src="<c:url value='resources/images/facebook-24x24.png'/>" border="0" alt="Delivered on Facebook" title="Delivered on Facebook"></a>&nbsp; &nbsp; <a id="dd_twitter" href="#" style="cursor: se-resize !important;" target="_blank"><img
									src="<c:url value='resources/images/twitter-24x24.png'/>" border="0" alt="Delivered on Twitter" title="Delivered on Twitter"></a>
							</p>
						</div>
						<div class="ppanelf7">
							<p style="text-align: center;">
								<a id="dd_email" href="#"><img src="<c:url value='resources/images/email-24x24.png'/>" border="0" alt="Delivered By Email" title="Delivered By Email"></a>&nbsp; &nbsp;&nbsp;<a id="dd_fb" href="#" target="_blank"><img src="<c:url value='resources/images/facebook-24x24.png'/>"
									border="0" alt="Delivered on Facebook" title="Delivered on Facebook"></a>&nbsp; &nbsp; <a id="dd_twitter" href="#" target="_blank"><img src="<c:url value='resources/images/twitter-24x24.png'/>" border="0" alt="Delivered on Twitter" title="Delivered on Twitter"></a>
							</p>
						</div>
					</div>
					<div class="moduletable-deli">
						<h3 id="lu_fb_button">
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

	function sendRequest() {
		if (trimString($("#bussinessName").val()) == "") {
			appFocus($("#bussinessName"));
			$.alert.open('error', 'Bussiness Name is Missing.');
			return false;
		}
		if (trimString($("#typeOfBusiness").val()) == "") {
			appFocus($("#typeOfBusiness"));
			$.alert.open('error', 'Type Of Business is Missing.');
			return false;
		}
		if (trimString($("#contactName").val()) == "") {
			appFocus($("#contactName"));
			$.alert.open('error', 'Contact Name is Missing.');
			return false;
		}
		if (trimString($("#emailId").val()) == "") {
			appFocus($("#emailId"));
			$.alert.open('error', 'Email Id is Missing.');
			return false;
		}
		if (trimString($("#emailId").val()) != "") {
			var emailaddressVal = $("#emailId").val();
			var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
			var test_email = emailReg.test(emailaddressVal);
			if (test_email == false) {
				appFocus($("#emailId"));
				$.alert.open('error', 'e-Mail Address is invalid.');
				return false;
			}
		}
		if (trimString($("#phone").val()) == "") {
			appFocus($("#phone"));
			$.alert.open('error', 'Phone is Missing.');
			return false;
		}
		if (!isNaN($("#phone").val())) {
		} else {
			appFocus($("#phone"));
			$.alert.open('error', 'Phone is not valid.');
			return false;
		}
		if (trimString($("#answer").val()) == "") {
			appFocus($("#answer"));
			$.alert.open('error', 'Captcha is Missing.');
			return false;
		}

		var retVal = $.ajax({
			url : "sendBecomeMerchantRequest",
			type : "POST",
			global : false,
			data : {
				bussinessName : $("#bussinessName").val(),
				typeOfBusiness : $("#typeOfBusiness").val(),
				contactName : $("#contactName").val(),
				emailId : $("#emailId").val(),
				phone : $("#phone").val(),
				sendToSender : $("#sendToSender").is(':checked') == true ? "1" : "0",
				answer : $("#answer").val()
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
		if (obj != null) {
			$.alert.open('error', obj.jsonMessage);
			if (obj.jsonMessage != "Captcha is invalid.") {
				resetAll();
				window.location.href = "dev"
			}

		} else {
			$.alert
					.open('error',
							'Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator.');
		}
	}

	function becomeAmerchant() {

	}

	function resetAll() {
		$("#bussinessName").val("");
		$("#typeOfBusiness").val("");
		$("#contactName").val("");
		$("#emailId").val("");
		$("#phone").val("");
		$("#answer").val("");
	}

	function reloadCapcha() {
		$("#captcha").remove();
		$("#tempcaptcha").html('<img id="captcha" src="<c:url value="simpleCaptcha.jpg" />" width="150">');
	}
</script>
</html>
