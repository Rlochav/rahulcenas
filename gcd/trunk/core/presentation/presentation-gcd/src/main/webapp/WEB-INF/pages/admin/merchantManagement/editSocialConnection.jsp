<%@include file="../../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Best Daily Deals in New Orleans,LA | Hot Local Bargains in NOLA</title>

<script type="text/javascript" src="<c:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<script src="<c:url value='/resources/js/main.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/screens.css'/>">
<link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='/resources/css/media.css'/>" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="../resources/images/icon.png" />
<script type="text/javascript" src="<c:url value='/resources/js/CommonFunction.js'/>"></script>
<link href="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/css/alert.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/themes/light/theme.css'/>" rel="stylesheet" />
<script src="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/js/alert.js'/>"></script>
<link href="<c:url value='/resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='/resources/js/js-image-slider.js'/>"></script>
</head>

<body>
	<%@include file="../../common/telliumTags.jsp"%>
	<div class="all">
		<div id="wrapper">
			<!-- header start -->
			<div class="header">
				<div class="upper-header">
					<div class="social">
						<c:if test='${SESSION_ATTR_USER_INFO!=null}'>
							<div class="login" id="login">
								<a style="cursor: pointer;" href="../appLogOut"><img src="<c:url value='/resources/images/marchent-logout.png'/>" border="0"></a>
							</div>
						</c:if>
						<ul class="social-icon">
							<li><a id="gcd_sm_fb" href="http://www.facebook.com/GetCityDealz" target="_blank"><img src="<c:url value='/resources/images/facebook.png'/>" width="auto" border="0" alt="facebook" title="facebook"></a></li>
							<li><a id="gcd_sm_twitter" href="http://www.twitter.com/GetCityDealz" target="_blank"><img src="<c:url value='/resources/images/twitter.png'/>" border="0" alt="twitter" title="twitter"></a></li>
							<li><a id="gcd_sm_pinterest" href="http://www.pinterest.com/getcitydealz" target="_blank"> <img src="<c:url value='/resources/images/pintrest.png'/>" border="0" alt="pintrest" title="pintrest"></a></li>
							<li><a id="gcd_sm_g+" href="https://plus.google.com/113127686225602648376" target="_blank"> <img src="<c:url value='/resources/images/gplush.png'/>" border="0" alt="Google Plus" title="Google Plus"></a></li>
							<li><a id="gcd_sm_youtube" href="http://www.youtube.com/user/GetCityDealz" target="_blank"> <img src="<c:url value='/resources/images/youtube.png'/>" border="0" alt="youtube" title="youtube"></a></li>
							<div class="clr"></div>
						</ul>
						<div class="clr"></div>

					</div>

					<div class="logo">
						<a id="header_home_link" href="../index"><img src="<c:url value='/resources/images/logo1.png'/>" /></a>
						<div class="clr"></div>
					</div>
					<div id="sliderFrame">
						<div id="ribbon" style="right: 11.7%;">
							<img id="prev87" class="prev-button" src="<c:url value='/resources/images/prev.png'/>" alt="Previous"> <img id="next87" class="next-button" src="<c:url value='/resources/images/next.png'/>" alt="Next">

						</div>
						<div class="slider" id="slider"></div>
					</div>
					<div class="clr"></div>
				</div>
				<div class="icon_menu" id="top_nav_buttons">
					<ul>
						<li><a id="tnb_dining" href="../dealsbymaincategory/dining"><img src="<c:url value='/resources/images/DINING.png'/>" /> </a></li>
						<li><a id="tnb_nightlife" href="../dealsbymaincategory/night-life"><img src="<c:url value='/resources/images/NIGHTLIFE.png'/>" /></a></li>
						<li><a id="tnb_shopping" href="../dealsbymaincategory/shopping"><img src="<c:url value='/resources/images/SHOPPING.png'/>" /> </a></li>
						<li><a id="tnb_attractions" href="../dealsbymaincategory/attractions"><img src="<c:url value='/resources/images/ATTRACTIONS.png'/>" /></a></li>
						<li><a id="tnb_services" href="../dealsbymaincategory/services"><img src="<c:url value='/resources/images/SERVICES.png'/>" /></a></li>
						<li class="last"><a id="tnb_recreation" href="../dealsbymaincategory/recreation"><img src="<c:url value='/resources/images/RECREATION.png'/>" /></a></li>
						<div class="clr"></div>
					</ul>
					<div class="clr"></div>
					<div class="mobile_nav">
						<label> <select>
								<option>home</option>
								<option><a href="#"><div class="menu-links">DINING</div></a>
								</option>
								<option><a href="#"><span>NIGHTLIFE</span><em></em></a>
								</option>
								<option><a href="#"><span>SHOPPING</span><em></em></a>
								</option>
								<option><a href="#"><span>ATTRACTIONS</span><em></em></a>
								</option>
								<option><a href="#"><span>SERVICES</span><em></em></a>
								</option>
								<option><a href="#"><span>RECREATION</span><em></em></a>
								</option>
								<div class="clr"></div>
						</select>
						</label>
					</div>

					<!--menu for mobile start-->
					<div class="mobile_na">
						<div class="fflip" id="f1" onclick="fflip(this.id)">
							<img src="<c:url value='/resources/images/toogle.png'/>">
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
			<div class="middle-container">
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
				<div class="mid-admin">
					<!-- mid start here -->
					<div class="mid admin-container">
						<div id="dashboard-area">
							<div id="title">${SESSION_ATTR_USER_INFO.cityText}:${merchantDto.merchantName}'SManage Social ConnectionN</div>
							<div id="menu">
								<div class="menu-new">
									<div style="float: right; padding: 2px 35px;">
										<img src="<c:url value='/resources/images/blue-arrow.png'/>" style="width: 4px; height: 9px; padding: 0px 7px; margin: -1px;"> <a style="color: #046604; cursor: pointer;" href="adminDashboard"> Return to Main Dashboard </a> <img src="<c:url value='/resources/images/blue-arrow.png'/>"
											style="width: 4px; height: 9px; padding: 0px 7px; margin: -1px;"> <a style="color: #046604; cursor: pointer;" href="merchantList"> Return to All ${SESSION_ATTR_USER_INFO.cityText} Merchants </a><img src="<c:url value='/resources/images/blue-arrow.png'/>"
											style="width: 4px; height: 9px; padding: 0px 7px; margin: -1px;"> <a style="color: #046604; cursor: pointer;" href="merchantmgmt"> Return to ${SESSION_ATTR_USER_INFO.cityText} Dashboard </a>
									</div>
								</div>
							</div>
							<div align="center" style="visibility: hidden;">
								<strong><i>Manage Merchants, Categories, Neighborhoods, Deals, Hot Deals &amp; Mobile</i> <dtrong></dtrong></strong>
							</div>
							<strong> <br>
								<h3 class="msg">
									<em> Hi There <strong>${SESSION_ATTR_USER_INFO.userName}</strong> Welcome to Your Get City Dealz Admin Dashboard
									</em>
								</h3> <br>
								<div id="form-field">
									<form:form id="socialConnectionForm" name="socialConnectionForm" class="formStyle">
										<h3 class="msg">
											<em>Manage Social Community Connections</em>
											<div class="errorDiv" style="position: absolute; right: 0px; top: 10px;">
												<label class="error" id="error"></label>
											</div>
											<div id="success" class="success">
												<label></label><input type="text" style="display: none;" id="connectionId" />
											</div>
										</h3>
										<div class="profile">
											<table cellspacing="0" cellpadding="0" style="width: 100%;" class="tableStyle custom_td">
												<tbody>
													<tr>
														<th width="20%">&nbsp;</th>
														<th width="30%">&nbsp;</th>
														<th width="20%">Show On Page</th>
														<th width="35%"></th>
													</tr>
													<tr>
														<td><label id="jform_facebook_fan_page-lbl" class="hasTip" title="">Facebook Fan Page</label></td>
														<td><input type="text" value="${socialDTO.facebookFanPage}" name="facebookFanPage" id="facebookFanPage" class="lInput">
															<div id="facebook_fan_page_result">
																<input id="tuser_valid" type="hidden" value="true" name="fuser_valid">
															</div></td>
														<td><input type="checkbox" name="facebookFanPagechk" id="facebookFanPagechk"></td>
														<td rowspan="13"><strong>* Instructions required to follow while creating app for twitter</strong>
															<ul class="listStyle">
																<li>Log into <a href="http://dev.twitter.com/apps/new" target="_blank">dev.twitter.com</a> using the credentials associated with the Twitter account
																</li>
																<li>Fill out the application details</li>
																<li>Callback URL should be left blank</li>
																<li>On the same screen as the Application Details (under the settings tab), you must select the option for "Read and Write". Your giving the application permission to write to your Twitter timeline</li>
																<li>On detail page, Click on create my access token</li>
																<li>Copy all the required data in the textboxes provided on this page and press save button</li>
															</ul></td>
													</tr>
													<tr>
														<td>Facebook Post deals to:</td>
														<td><strong> ${socialDTO.fbPostDealzTo}</strong></td>
														<td><a href="javascript:void(0);" onclick="authPopup();">Click to Authenticate</a></td>
													</tr>
													<tr>
														<td><label id="jform_twitter_id-lbl" class="hasTip" title="">Twitter Account</label></td>
														<td><input type="text" value="${socialDTO.twitterAccount}" name="twitterAccount" id="twitterAccount" class="lInput">
															<div id="twitter_fan_page_result">
																<input id="tuser_valid" type="hidden" value="true" name="tuser_valid" class="lInput" />
															</div></td>
														<td><input type="checkbox" name="twitterAccountchk" id="twitterAccountchk"></td>
													</tr>
													<tr>
														<td><label id="jform_four_square_username-lbl" class="hasTip" title="" aria-invalid="false">Four Square Account</label></td>
														<td><input type="text" value="${socialDTO.fourSquareAccount}" name="fourSquareAccount" id="fourSquareAccount" class="lInput" /></td>
														<td><input type="checkbox" name="fourSquareAccountchk" id="fourSquareAccountchk"></td>
													</tr>
													<tr>
														<td><label id="jform_yelp_username-lbl" class="hasTip" title="">Yelp Account</label></td>
														<td><input type="text" value="${socialDTO.yelpAccount}" name="yelpAccount" id="yelpAccount" class="lInput" /></td>
														<td><input type="checkbox" name="yelpAccountchk" id="yelpAccountchk"></td>
													</tr>
													<tr>
														<td><label id="jform_flicker_username-lbl" class="hasTip" title="">Flicker Account</label></td>
														<td><input type="text" value="${socialDTO.flickerAccount}" name="flickerAccount" id="flickerAccount" class="lInput" /></td>
														<td><input type="checkbox" name="flickerAccountchk" id="flickerAccountchk"></td>
													</tr>
													<tr>
														<td><label id="jform_youtube_username-lbl" class="hasTip" title="">Youtube Account</label></td>
														<td><input type="text" value="${socialDTO.youtubeAccount}" name="youtubeAccount" id="youtubeAccount" class="lInput" /></td>
														<td><input type="checkbox" name="youtubeAccountchk" id="youtubeAccountchk"></td>
													</tr>
													<tr>
														<td><label id="jform_linkedin_username-lbl" class="hasTip" title="">Linkedin Profile</label></td>
														<td><input type="text" value="${socialDTO.linkedinProfile}" name="linkedinProfile" id="linkedinProfile" class="lInput" /></td>
														<td><input type="checkbox" name="linkedinProfilechk" id="linkedinProfilechk"></td>
													</tr>
													<tr>
														<td><label id="jform_trip_advisor_username-lbl" class="hasTip" title="">Trip Advisor Account</label></td>
														<td><input type="text" value="${socialDTO.tripAdvisorAccount}" name="tripAdvisorAccount" id="tripAdvisorAccount" class="lInput" /></td>
														<td><input type="checkbox" name="tripAdvisorAccountchk" id="tripAdvisorAccountchk"></td>
													</tr>
													<tr>
														<td><label id="jform_meetup_username-lbl" class="hasTip" title="">Meetup Account</label></td>
														<td><input type="text" value="${socialDTO.meetupAccount}" name="meetupAccount" id="meetupAccount" class="lInput" /></td>
														<td><input type="checkbox" name="meetupAccountchk" id="meetupAccountchk"></td>
													</tr>
													<tr>
														<td><label id="jform_open_table_username-lbl" class="hasTip" title="">Open Table Account</label></td>
														<td><input type="text" value="${socialDTO.openTableAccount}" name="openTableAccount" id="openTableAccount" class="lInput" /></td>
														<td><input type="checkbox" name="openTableAccountchk" id="openTableAccountchk"></td>
													</tr>
													<tr>
														<td>Pinterest Account</td>
														<td><input type="text" value="${socialDTO.pinterestAccount}" name="pinterestAccount" id="pinterestAccount" class="lInput" /></td>
														<td><input type="checkbox" name="pinterestAccountchk" id="pinterestAccountchk"></td>
													</tr>
													<tr>
														<td>Tumblr Account</td>
														<td><input type="text" value="${socialDTO.tumblrAccount}" name="tumblrAccount" id="tumblrAccount" class="lInput" /></td>
														<td><input type="checkbox" name="tumblrAccountchk" id="tumblrAccountchk"></td>
													</tr>
													<tr>
														<td>Instagram Account</td>
														<td><input type="text" value="${socialDTO.instagramAccount}" name="instagramAccount" id="instagramAccount" class="lInput" /></td>
														<td><input type="checkbox" name="instagramAccountchk" id="instagramAccountchk"></td>
													</tr>
													<tr>
														<td>Etsy Account</td>
														<td><input type="text" value="${socialDTO.etsyAccount}" name="etsyAccount" id="etsyAccount" class="lInput" /></td>
														<td><input type="checkbox" name="etsyAccountchk" id="etsyAccountchk"></td>
													</tr>
													<tr>
														<td>G+ Account</td>
														<td><input type="text" value="${socialDTO.gPlusAccount}" name="gPlusAccount" id="gPlusAccount" class="lInput" /></td>
														<td><input type="checkbox" name="gPlusAccountchk" id="gPlusAccountchk"></td>
													</tr>
													<tr>
														<td></td>
														<td></td>
														<td class="al-right button2"><input type="reset" value="Reset">&nbsp;&nbsp;<input type="button" onclick="saveSocialConnection();" value="Update"></td>
													</tr>
												</tbody>
											</table>

											<div style="margin-bottom: 5%"></div>

											<table class="tableStyle custom_td" cellpadding="0" cellspacing="0" style="width: 100%">
												<tbody>
													<tr>
														<th colspan="4">Twitter OAuth details for posting deals to twitter</th>
													</tr>
													<tr>
														<td>Consumer Key:<input type="text" style="display: none;" id="twitterOAuthdetailsId" value="${socialDTO.twitterOAuthdetailsId}" />
														</td>
														<td><input type="text" value="${socialDTO.consumerKey}" name="consumerKey" id="consumerKey" /></td>
														<td>Consumer Secret:</td>
														<td><input type="text" value="${socialDTO.consumerSecret}" name="consumerSecret" id="consumerSecret" /></td>
													</tr>
													<tr>
														<td>OAuth Token:</td>
														<td><input type="text" value="${socialDTO.oAuthToken}" name="oAuthToken" id="oAuthToken" /></td>
														<td>OAuth Secret:</td>
														<td><input type="text" value="${socialDTO.oAuthSecret}" name="oAuthSecret" id="oAuthSecret" /></td>
													</tr>
													<tr>
														<td colspan="4" align="right"><input type="button" class="xxlBtn" value="Add Twitter Details" onclick="saveSocialConnection();"></input></td>
													</tr>
												</tbody>
											</table>
										</div>
										<div style="margin-bottom: 5%"></div>
									</form:form>
								</div>
							</strong>
						</div>

					</div>
					<!-- mid end here -->

					<!-- footer start -->
					<div class="bottom">
						<div class="footer-left">
							<ul>
								<li class="active"><a id="gcd_footer_home" href="/">Home</a></li>
								<li class=""><a id="gcd_footer_privacy_policy" href="http://gcddev.com/privacy-policy">Privacy Policy</a></li>
								<li class=""><a id="gcd_footer_contact" href="http://gcddev.com/contactus">Contact Us</a></li>
							</ul>
						</div>
						<div class="copyright">Copyright &copy; 2012-2014 Getcitydealz</div>
					</div>
					<!-- footer end -->
				</div>
			</div>
			<div class="clr"></div>
		</div>
		<div id="login-box" class="login-popup">
			<a href="javascript:void(0);" class="close" id="fbClose"><img src="<c:url value='/resources/images/cancel.png'/>" class="btn_close" title="Close Window" alt="Close"></a>
			<h2>Choose Your Destination</h2>
			<div class="icon">
				<a href="javascript:void(0);" onclick="authPopup1();" class="fbClose"><img src="<c:url value='/resources/images/fb.png'/>"></a><img src="<c:url value='/resources/images/twitter.png'/>"> <br> <br>
			</div>
		</div>

		<div id="login-box1" class="login-popup1">
			<a href="javascript:void(0);" class="close fbClose"><img src="<c:url value='/resources/images/cancel.png'/>" class="btn_close" title="Close Window" alt="Close"></a>
			<h2>Choose Your Destination</h2>
			<table width="100%" border="0" cellspacing="0" cellpadding="6">
				<tbody>
					<tr>
						<td><img src="<c:url value='resources/images/fb.png'/>"></td>
						<td><a href="signInByAdminFacebook?merchantId=${socialDTO.merchantId}"><span class="tab-sh">Connect to facebook</span></a></td>
						<td>- OR -</td>
						<td><select>
								<option selected="selected">Reuse Facebook Account</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="4" class="cancel-txt"><a href="javascript:void(0);" onclick="authPopup();">Previous</a> <a href="javascript:void(0);" id="clos">Cancel</a></td>
					</tr>
				</tbody>
			</table>
		</div>
</body>
<script type="text/javascript">
	$(function() {
			var retVal = $.ajax({
				url : "../jsonGetHotDealz",
				type : "POST",
				global : false,
				dataType : "json",
				async : false
			}).responseText;
			//alert(retVal);
			var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
			if (obj != null) {
				var bannerArr = obj.bannerDTOs;
				var sliderImage='';
				for(var i=0;i<bannerArr.length;i++){
					'<c:set var="merchantName" value="'+bannerArr[i].merchantName+'" />';
					<c:set var="merchantName1" value="${fn:split(merchantName, ' ')}" />
					<c:set var="merchantName2" value="${fn:join(merchantName1, '-')}" />
					sliderImage +='<a href="merchant/${merchantName2}-'+bannerArr[i].merchantId+'"><img src="../displayImage?image='+bannerArr[i].imagePath+'" style="height:170px;" class="wrap" id="wrap'+(i+1)+'" style="display: none;"/></a>';
				}
				$("#slider").append(sliderImage);
			}
		
		
		if ('<c:out value="${socialDTO.facebookFanPagechk}"/>' == "1")
			$("#facebookFanPagechk").attr('checked', true);

		if ('<c:out value="${socialDTO.twitterAccountchk}"/>' == "1")
			$("#twitterAccountchk").attr('checked', true);

		if ('<c:out value="${socialDTO.fourSquareAccountchk}"/>' == "1")
			$("#fourSquareAccountchk").attr('checked', true);

		if ('<c:out value="${socialDTO.yelpAccountchk}"/>' == "1")
			$("#yelpAccountchk").attr('checked', true);

		if ('<c:out value="${socialDTO.flickerAccountchk}"/>' == "1")
			$("#flickerAccountchk").attr('checked', true);

		if ('<c:out value="${socialDTO.youtubeAccountchk}"/>' == "1")
			$("#youtubeAccountchk").attr('checked', true);

		if ('<c:out value="${socialDTO.linkedinProfilechk}"/>' == "1")
			$("#linkedinProfilechk").attr('checked', true);

		if ('<c:out value="${socialDTO.tripAdvisorAccountchk}"/>' == "1")
			$("#tripAdvisorAccountchk").attr('checked', true);

		if ('<c:out value="${socialDTO.meetupAccountchk}"/>' == "1")
			$("#meetupAccountchk").attr('checked', true);

		if ('<c:out value="${socialDTO.openTableAccountchk}"/>' == "1")
			$("#openTableAccountchk").attr('checked', true);

		if ('<c:out value="${socialDTO.pinterestAccountchk}"/>' == "1")
			$("#pinterestAccountchk").attr('checked', true);
		
		if ('<c:out value="${socialDTO.gPlusAccountchk}"/>' == "1")
			$("#gPlusAccountchk").attr('checked', true);
		
		if ('<c:out value="${socialDTO.tumblrAccountchk}"/>' == "1")
			$("#tumblrAccountchk").attr('checked', true);
		
		if ('<c:out value="${socialDTO.etsyAccountchk}"/>' == "1")
			$("#etsyAccountchk").attr('checked', true);
		
		if ('<c:out value="${socialDTO.instagramAccountchk}"/>' == "1")
			$("#instagramAccountchk").attr('checked', true);
	});
	
	$( "#fbClose" ).click(function() {
		  $( "#mask" ).hide();
		  $( "#login-box" ).hide();
		  $("#login-box1").hide();
		});

	function saveSocialConnection() {
		if (validation()) {
			var retVal = $.ajax({
				url : "../saveSocialConnection",
				type : "POST",
				global : false,
				data : {
					connectionId : '<c:out value="${socialDTO.connectionId}"/>',
					merchantId : ${merchantId},
					facebookFanPage : $("#facebookFanPage").val(),
					facebookFanPagechk : $("#facebookFanPagechk").is(':checked') == true ? "1" : "0",
					twitterAccount : $("#twitterAccount").val(),
					twitterAccountchk : $("#twitterAccountchk").is(':checked') == true ? "1" : "0",
					fourSquareAccount : $("#fourSquareAccount").val(),
					fourSquareAccountchk : $("#fourSquareAccountchk").is(':checked') == true ? "1" : "0",
					yelpAccount : $("#yelpAccount").val(),
					yelpAccountchk : $("#yelpAccountchk").is(':checked') == true ? "1" : "0",
					flickerAccount : $("#flickerAccount").val(),
					flickerAccountchk : $("#flickerAccountchk").is(':checked') == true ? "1" : "0",
					youtubeAccount : $("#youtubeAccount").val(),
					youtubeAccountchk : $("#youtubeAccountchk").is(':checked') == true ? "1" : "0",
					linkedinProfile : $("#linkedinProfile").val(),
					linkedinProfilechk : $("#linkedinProfilechk").is(':checked') == true ? "1" : "0",
					tripAdvisorAccount : $("#tripAdvisorAccount").val(),
					tripAdvisorAccountchk : $("#tripAdvisorAccountchk").is(':checked') == true ? "1" : "0",
					meetupAccount : $("#meetupAccount").val(),
					meetupAccountchk : $("#meetupAccountchk").is(':checked') == true ? "1" : "0",
					openTableAccount : $("#openTableAccount").val(),
					openTableAccountchk : $("#openTableAccountchk").is(':checked') == true ? "1" : "0",
					pinterestAccount : $("#pinterestAccount").val(),
					pinterestAccountchk : $("#pinterestAccountchk").is(':checked') == true ? "1" : "0",
					gPlusAccount : $("#gPlusAccount").val(),
					gPlusAccountchk : $("#gPlusAccountchk").is(':checked') == true ? "1" : "0",
					instagramAccount : $("#instagramAccount").val(),
					instagramAccountchk : $("#instagramAccountchk").is(':checked') == true ? "1" : "0",
					etsyAccount : $("#etsyAccount").val(),
					etsyAccountchk : $("#etsyAccountchk").is(':checked') == true ? "1" : "0",
					tumblrAccount : $("#tumblrAccount").val(),
					tumblrAccountchk : $("#tumblrAccountchk").is(':checked') == true ? "1" : "0",
					consumerKey : $("#consumerKey").val(),
					consumerSecret : $("#consumerSecret").val(),
					oAuthToken : $("#oAuthToken").val(),
					oAuthSecret : $("#oAuthSecret").val(),
					twitterOAuthdetailsId : $("#twitterOAuthdetailsId").val()
				},
				dataType : "json",
				async : false
			}).responseText;

			var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);

			if (obj != null) {
				if (obj.jsonMessage != null) {
					$.alert.open('error', obj.jsonMessage);
				} else {
					$("#connectionId").val(obj.connectionId);
					$.alert.open('info', 'Social Connections saved successfully.');
				}
			} else {
				$.alert.open('error','Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator.');
			}
		}
	}

	function validation() {
		if ($("#facebookFanPagechk").is(':checked') == true && trimString($("#facebookFanPage").val()) == "") {
			appFocus($("#facebookFanPage"));
			$.alert.open('error', 'Facebook Fan Page is Mandatory.');
			return false;
		}

		if ($("#twitterAccountchk").is(':checked') == true && trimString($("#twitterAccount").val()) == "") {
			appFocus($("#twitterAccount"));			
			$.alert.open('error', 'Twitter Account is Mandatory.');
			return false;
		}

		if ($("#fourSquareAccountchk").is(':checked') == true && trimString($("#fourSquareAccount").val()) == "") {
			appFocus($("#fourSquareAccount"));
			$.alert.open('error', 'Four Square Account is Mandatory.');
			return false;
		}

		if ($("#yelpAccountchk").is(':checked') == true && trimString($("#yelpAccount").val()) == "") {
			appFocus($("#yelpAccount"));
			$.alert.open('error', 'Yelp Account is Mandatory.');
			return false;
		}

		if ($("#flickerAccountchk").is(':checked') == true && trimString($("#flickerAccount").val()) == "") {
			appFocus($("#flickerAccount"));
			$.alert.open('error', 'Flicker Account is Mandatory.');
			return false;
		}

		if ($("#youtubeAccountchk").is(':checked') == true && trimString($("#youtubeAccount").val()) == "") {
			appFocus($("#youtubeAccount"));
			$.alert.open('error', 'Youtube Account is Mandatory.');
			return false;
		}

		if ($("#linkedinProfilechk").is(':checked') == true && trimString($("#linkedinProfile").val()) == "") {
			appFocus($("#linkedinProfile"));
			$.alert.open('error', 'Linkedin Profile is Mandatory.');
			return false;
		}

		if ($("#tripAdvisorAccountchk").is(':checked') == true && trimString($("#tripAdvisorAccount").val()) == "") {
			appFocus($("#tripAdvisorAccount"));
			$.alert.open('error', 'Trip Advisor Account is Mandatory.');
			return false;
		}

		if ($("#meetupAccountchk").is(':checked') == true && trimString($("#meetupAccount").val()) == "") {
			appFocus($("#meetupAccount"));
			$.alert.open('error', 'Meetup Account is Mandatory.');
			return false;
		}

		if ($("#openTableAccountchk").is(':checked') == true && trimString($("#openTableAccount").val()) == "") {
			appFocus($("#openTableAccount"));
			$.alert.open('error', 'Open Table Account is Mandatory.');
			return false;
		}

		if ($("#pinterestAccountchk").is(':checked') == true && trimString($("#pinterestAccount").val()) == "") {
			appFocus($("#pinterestAccount"));
			$.alert.open('error', 'Pinterest Account is Mandatory.');
			return false;
		}
		return true;
	}

	function authPopup(){
		var loginBox = $(this).attr('href');
			$("#login-box").fadeIn(300);
			
			var popMargTop = ($(loginBox).height() + 24) / 2; 
			var popMargLeft = ($(loginBox).width() + 24) / 2; 
			
			$("#login-box").css({ 
				'margin-top' : -popMargTop,
				'margin-left' : -popMargLeft
			});
			
			$('body').append('<div id="mask"></div>');
			$('#mask').fadeIn(300);
	}
	function authPopup1(){
		var loginBox = $(this).attr('href');

			$("#login-box1").fadeIn(300);
			
			var popMargTop = ($(loginBox).height() + 24) / 2; 
			var popMargLeft = ($(loginBox).width() + 24) / 2; 
			
			$("#login-box1").css({ 
				'margin-top' : -popMargTop,
				'margin-left' : -popMargLeft
			});
			
			$('body').append('<div id="mask1"></div>');
			$('#mask1').fadeIn(300);
	}
</script>
</html>
