<%@include file="../common/taglibs.jsp"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.io.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-control" content="public">
<meta http-equiv="Cache-control" content="private">
<meta http-equiv="Cache-control" content="no-cache">

<title><c:if test="${cityDTO!=null}">${merchantDTO.merchantName}'s Latest Deals & News | ${merchantDTO.merchantName}'s ${merchantDTO.neighborhoodText} Offers | Great ${merchantDTO.category1Text} Bargains</c:if></title>

<link href="<c:url value='/resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='/resources/js/js-image-slider.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/rating.css'/>">

<link rel="shortcut icon" href="../resources/images/icon.png">
<script type="text/javascript" src="<c:url value='/resources/js/CommonFunction.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>" />

<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/jquery.kyco.googleplusfeed2.demo.css'/>" />
<script type="text/javascript" src="<c:url value='/resources/js/jquery.kyco.googleplusfeed2.min.js'/>"></script>

<!--Pinterest -->
<script type="text/javascript" async src="//assets.pinterest.com/js/pinit.js"></script>
<script type="text/javascript" async src="<c:url value='/resources/js/instafeed.min.js'/>"></script>
<style>
/* iframe {
		width: 146px !important;
		height: 180px !important;
	} */
html,body,#map-canvas {
	height: 100%;
	margin: 0px;
	padding: 0px
}

.controls {
	margin-top: 16px;
	border: 1px solid transparent;
	border-radius: 2px 0 0 2px;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	height: 32px;
	outline: none;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
}

#pac-input {
	background-color: #fff;
	padding: 0 11px 0 13px;
	width: 400px;
	font-family: Roboto;
	font-size: 15px;
	font-weight: 300;
	text-overflow: ellipsis;
}

#pac-input:focus {
	border-color: #4d90fe;
	margin-left: -1px;
	padding-left: 14px; /* Regular padding-left + 1. */
	width: 401px;
}

.pac-container {
	font-family: Roboto;
}

#type-selector {
	color: #fff;
	background-color: #4d90fe;
	padding: 5px 11px 0px 11px;
}

#type-selector label {
	font-family: Roboto;
	font-size: 13px;
	font-weight: 300;
}

.mapDiv {
	width: 96%;
	height: 125px;
	margin: 4px 3px 0px 5px;
}
</style>

<style>
#target {
	width: 345px;
}
</style>

<script src="http://connect.facebook.net/en_US/all.js"></script>
<script>
		window.fbAsyncInit = FB.init({
			appId : '1499701620271988',
			status : true,
			cookie : true,
			xfbml : true
		});
	</script>

<!-- Place this tag in your head or just before your close body tag. -->
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script src="https://apis.google.com/js/client.js?onload=handleClientLoad" gapi_processed="true"></script>

<script src="<c:url value='/resources/js/googleLogin.js'/>"></script>
<script src="<c:url value='/resources/js/facebookLogin.js'/>"></script>

<style type="text/css">
.circle {
	width: 100px;
	height: 100px;
	-moz-border-radius: 100px;
	-webkit-border-radius: 100px;
}

.inset {
	-moz-box-shadow: inset 0 3px 8px rgba(0, 0, 0, .4);
	-webkit-box-shadow: inset 0 3px 8px rgba(0, 0, 0, .4);
	box-shadow: inset 0 3px 8px rgba(0, 0, 0, .24);
}
</style>
<script src="https://maps.googleapis.com/maps/api/js"></script>
</head>
<script type="text/javascript">
		$(function() {
			var address1 = '${merchantDTO.zipCode} ,${merchantDTO.city} ,${merchantDTO.address1},${merchantDTO.address2},${merchantDTO.address3}';
			var retVal = $.ajax({
				url : "https://maps.googleapis.com/maps/api/geocode/json?address=" + address1,
				type : "POST",
				global : false,
				data : {
	
				},
				dataType : "json",
				async : false
			}).responseText;
	
			retVal = jQuery.parseJSON(retVal);
			if (retVal != null) {
				var map = new google.maps.Map(document.getElementById('map-canvas'), {
					zoom : 10,
					center : new google.maps.LatLng(retVal.results[0].geometry.location.lat, retVal.results[0].geometry.location.lng),
					mapTypeId : google.maps.MapTypeId.ROADMAP
				});
	
				marker = new google.maps.Marker({
					position : new google.maps.LatLng(retVal.results[0].geometry.location.lat, retVal.results[0].geometry.location.lng),
					map : map
				});
			}
		});
	</script>
<body>
	<%@include file="../common/telliumTags.jsp"%>
	<div id="fb-root"></div>
	<script>(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=1499701620271988&version=v2.0";
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));</script>
	<div id="wrapper">
		<%@include file="../common/header1.jsp"%>
		<div class="tagline">
			<div class="moduletable">
				<div class="custom">
					<p class="MsoNormal">
						<strong><spring:message code="common.html.000002"></spring:message></strong>
					</p>
				</div>
			</div>
		</div>
		<!-- Header section end here -->

		<%@include file="../common/left1.jsp"%>
		<!-- Menu section end here -->

		<div class="cent center-both no-right">
			<form action="../searchQuery">
				<div style="height: 25px; width: 185px; background: rgb(37, 70, 87); border-radius: 6px;">
					<input name="query" class="searchfield" type="text" placeholder="Search" style="margin: 1px 0 0 4px;" />
				</div>
				<div style="margin: -25px 0px 0 186px;">
					<input type="submit" name="searchBtn" id="searchBtn" class="mediumBtn" value="Search" />
				</div>
			</form>
			<c:if test="${socialProfileDTO.emailId==null}">
				<div style="margin: -32px 0 0 454px;" id="facebookLoginBtn">
					<a href="javascript:void(0);" onclick="loginFacebook();"><img alt="facebook login" src="<c:url value='/resources/images/fb-login.png'/>" width="100" height="35" /></a>
				</div>
				<div style="margin-top: -41px; float: right;" id="googleSignInBtn">
					<a href="javascript:void(0);" id="googlelogin"><img alt="facebook login" src="<c:url value='/resources/images/gSignIn.png'/>" width="100" height="42" /></a>
				</div>
			</c:if>
			<div class="main-content">
				<div id="system-message-container"></div>
				<div id="title"></div>
				<div itemscopeitemtype="http://schema.org/LocalBusiness">
					<table id="merchant_profile" class="items_list" cellspacing="1" cellpadding="1">
						<tbody>
							<tr>
								<td rowspan="2"><span itemprop="logo"><img id="mp_logo" src="../displayImage?image=${merchantDTO.logoImagePath}" width="156px" class="border" alt="${merchantDTO.merchantName}" title="${merchantDTO.merchantName}" /></span></td>
								<td colspan="2"><h2>
										<span itemprop="name">${merchantDTO.merchantName}</span>
									</h2>
									<div class="merchant-address">
										<div itemprop="address" itemscopeitemtype="http://schema.org/PostalAddress">
											<span itemprop="streetAddress">${merchantDTO.address1}</span>, <span itemprop="addressLocality">${merchantDTO.city}</span>, <span itemprop="addressRegion">${merchantDTO.state}</span> <span itemprop="postalcode">${merchantDTO.zipCode}</span><br> <span itemprop="telephone">${merchantDTO.contactPhone}</span>&nbsp;&nbsp;&nbsp;<span
												itemprop="email"><a id="mp_email_link" href="mailto:${merchantDTO.emailId}">${merchantDTO.emailId}</a></span><br> <span itemprop="url"><a id="mp_url" href="http://${merchantDTO.websiteUrl}" target="_blank">http://${merchantDTO.websiteUrl}</a></span> <br /> <span
												itemprop="openingHours"><span id="bHour"><strong>Business Hours:</strong>${merchantDTO.businessHours}</span></span>
										</div>
									</div></td>

							</tr>
							<tr>
								<td>
									<div id="mp_sub_deals">
										<strong>Subscribe To Merchant</strong><br>
										<c:if test="${connectionDTO.twitterAccount!=null && connectionDTO.twitterAccountchk==1}">
											<a id="mp_sub_deals_twitter" href="${connectionDTO.twitterAccount}" target="_blank"> <img src="<c:url value='/resources/images/twitter-16x16.png'/>" title="Twitter"></a>
										</c:if>
										&nbsp;
										<c:if test="${connectionDTO.facebookFanPage!=null && connectionDTO.facebookFanPagechk==1}">
											<a id="mp_sub_deals_fb" href="${connectionDTO.facebookFanPage}" target="_blank"> <img src="<c:url value='/resources/images/facebook-16x16.png'/>" title="Facebook"></a>
										</c:if>
										&nbsp;<a id="mp_sub_deals_email" href="../subscribe/${merchantDTO.urlMerchant}-${merchantDTO.merchantId}"><img src="<c:url value='/resources/images/email-16x16.png'/>" title="Email"></a>
									</div>
								</td>
								<td><div id="mFollowMerchant">
										<strong>Follow Merchant</strong><br>
										<div id="mAccessibility" style="width: 85px;">
											<c:if test="${connectionDTO.gPlusAccount!=null && connectionDTO.gPlusAccountchk==1}">
												<a href="${connectionDTO.gPlusAccount}" target="_blank"><img src="<c:url value='/resources/images/gplus.png'/>" /></a>&nbsp;
																		</c:if>
											<c:if test="${connectionDTO.facebookFanPage!=null && connectionDTO.facebookFanPagechk==1}">
												<a href="${connectionDTO.facebookFanPage}" target="_blank"><img src="<c:url value='/resources/images/facebook-16x16.png'/>" /></a>&nbsp;
																		</c:if>
											<c:if test="${connectionDTO.twitterAccount!=null && connectionDTO.twitterAccountchk==1}">
												<a href="${connectionDTO.twitterAccount}" target="_blank"><img src="<c:url value='/resources/images/twitter-16x16.png'/>" /></a>&nbsp;
																	</c:if>
											<c:if test="${connectionDTO.fourSquareAccount!=null && connectionDTO.fourSquareAccountchk==1}">
												<a href="${connectionDTO.fourSquareAccount}" target="_blank"><img src="<c:url value='/resources/images/foursquare-16x16.png'/>" /></a>&nbsp;
																		</c:if>
											<c:if test="${connectionDTO.yelpAccount!=null && connectionDTO.yelpAccountchk==1}">
												<a href="${connectionDTO.yelpAccount}" target="_blank"><img src="<c:url value='/resources/images/yelp-16x16.png'/>" /></a>&nbsp;
																		</c:if>
											<c:if test="${connectionDTO.flickerAccount!=null && connectionDTO.flickerAccountchk==1}">
												<a href="${connectionDTO.flickerAccount}" target="_blank"><img src="<c:url value='/resources/images/flicker.jpg'/>" width="16px" height="16px" /></a>&nbsp;
																		</c:if>
											<c:if test="${connectionDTO.youtubeAccount!=null && connectionDTO.youtubeAccountchk==1}">
												<a href="${connectionDTO.youtubeAccount}" target="_blank"><img src="<c:url value='/resources/images/youtube-16x16.png'/>" /></a>&nbsp;
																		</c:if>
											<c:if test="${connectionDTO.linkedinProfile!=null && connectionDTO.linkedinProfilechk==1}">
												<a href="${connectionDTO.linkedinProfile}" target="_blank"><img src="<c:url value='/resources/images/linkedin-16x16.png'/>" /></a>&nbsp;
																		</c:if>
											<c:if test="${connectionDTO.tripAdvisorAccount!=null && connectionDTO.tripAdvisorAccountchk==1}">
												<a href="${connectionDTO.tripAdvisorAccount}" target="_blank"><img src="<c:url value='/resources/images/tripadvisor-icon.png'/>" width="16px" height="16px" /></a>&nbsp;
																		</c:if>
											<c:if test="${connectionDTO.meetupAccount!=null && connectionDTO.meetupAccountchk==1}">
												<a href="${connectionDTO.meetupAccount}" target="_blank"><img src="<c:url value='/resources/images/meetup.jpg' />" width="16px" height="16px" /></a>&nbsp;
																		</c:if>
											<c:if test="${connectionDTO.openTableAccount!=null && connectionDTO.openTableAccountchk==1}">
												<a href="${connectionDTO.openTableAccount}" target="_blank"><img src="<c:url value='/resources/images/opentable.jpg'/>" width="16px" height="16px" /></a>&nbsp;
																		</c:if>
											<c:if test="${connectionDTO.pinterestAccount!=null && connectionDTO.pinterestAccountchk==1}">
												<a href="${connectionDTO.pinterestAccount}" target="_blank"><img src="<c:url value='/resources/images/pintrest-16x16.png'/>" /></a>&nbsp;
																		</c:if>
											<c:if test="${connectionDTO.instagramAccount!=null && connectionDTO.instagramAccountchk==1}">
												<a href="${connectionDTO.instagramAccount}" target="_blank"><img src="<c:url value='/resources/images/Instagram-16x16.png'/>" /></a>&nbsp;
																		</c:if>
											<c:if test="${connectionDTO.etsyAccount!=null && connectionDTO.etsyAccountchk==1}">
												<a href="${connectionDTO.etsyAccount}" target="_blank"><img src="<c:url value='/resources/images/etsy-16x16.png'/>" /></a>&nbsp;
																		</c:if>
											<c:if test="${connectionDTO.tumblrAccount!=null && connectionDTO.tumblrAccountchk==1}">
												<a href="${connectionDTO.tumblrAccount}" target="_blank"><img src="<c:url value='/resources/images/square-tumblr-16x16.png'/>" /></a>&nbsp;
																		</c:if>
										</div>
									</div></td>
								<td>
									<div id="mFeaturesMerchant">
										<strong>Merchant Features</strong>
										<div id="mAccessibility" style="width: 111px;">
											<c:forEach var="icon" items="${icons}">
												<c:set var="img" value="${fn:replace(icon.imagePath,'.', '_do_custom_separator_')}" />
												<a href="../displayImage1/${img}?docType=11" target="_blank"><img alt="${icon.iconName}" title="${icon.iconName}" src="<c:url value='../displayImage1/${img}?docType=11'/>" width="20" height="20" /></a>
												&nbsp;
											</c:forEach>
										</div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<table class="items_list">
					<tbody>
						<tr>
							<td>
								<h2 id="otherLocationHeader" align="center">OTHER LOCATIONS</h2> <c:if test="${merchantDTO.getLocationDTOs()!=null}">
									<table id="otherLocations" class="tableStyle" style="width: 96%; margin: 2%;">
										<!-- <tr>
												<th>Primary Location</th>
												<th>Second Location</th>
												<th>Third Location:</th>
											</tr> -->
										<tr>
											<td><label class="addrs1">${locationDTO1.address1} ${locationDTO1.address2} ${locationDTO1.address3}</label></td>
											<td><label class="addrs2">${locationDTO2.address1} ${locationDTO2.address2} ${locationDTO2.address3}</label></td>
											<td><label class="addrs3">${locationDTO3.address1} ${locationDTO3.address2} ${locationDTO3.address3}</label></td>
										</tr>
										<tr>
											<td><label class="addrs1">${locationDTO1.city}</label></td>
											<td><label class="addrs2">${locationDTO2.city}</label></td>
											<td><label class="addrs3">${locationDTO3.city}</label></td>
										</tr>
										<tr>
											<td><label class="addrs1">${locationDTO1.state}</label></td>
											<td><label class="addrs2">${locationDTO2.state}</label></td>
											<td><label class="addrs3">${locationDTO3.state}</label></td>
										</tr>
										<tr>
											<td><label class="addrs1">${locationDTO1.zipCode}</label></td>
											<td><label class="addrs2">${locationDTO2.zipCode}</label></td>
											<td><label class="addrs3">${locationDTO3.zipCode}</label></td>
										</tr>
										<tr>
											<td><label class="addrs1">${locationDTO1.locationPhone}</label></td>
											<td><label class="addrs2">${locationDTO2.locationPhone}</label></td>
											<td><label class="addrs3">${locationDTO3.locationPhone}</label></td>
										</tr>
										<tr>
											<td><label class="addrs1"><span id="lbHour1"></span></label></td>
											<td><label class="addrs2"><span id="lbHour2"></span></label></td>
											<td><label class="addrs3"><span id="lbHour3"></span></label></td>
										</tr>
										<tr>
											<td><label class="addrs1">${locationDTO1.neighborhoodName}</label></td>
											<td><label class="addrs2">${locationDTO2.neighborhoodName}</label></td>
											<td><label class="addrs3">${locationDTO3.neighborhoodName}</label></td>
										</tr>
										<tr>
											<td><label class="addrs1">${locationDTO1.contactFirstName}</label></td>
											<td><label class="addrs2">${locationDTO2.contactFirstName}</label></td>
											<td><label class="addrs3">${locationDTO3.contactFirstName}</label></td>
										</tr>
										<tr>
											<td><label class="addrs1">${locationDTO1.emailAddress}</label></td>
											<td><label class="addrs2">${locationDTO2.emailAddress}</label></td>
											<td><label class="addrs3">${locationDTO3.emailAddress}</label></td>
										</tr>
									</table>
								</c:if> <c:if test="${posts!=null}">
									<h2>Latest Blog Posts</h2>
									<ul>
										<c:forEach items="${posts}" var="postDTO">
											<li><a href="../blog/${postDTO.postId}/${merchantDTO.merchantId}">${postDTO.title}</a></li>
										</c:forEach>
									</ul>
								</c:if>
								<h2>Latest Deals</h2> <c:forEach var="listVar" items="${dealzs}">
									<div itemprop="offers" itemscopeitemtype="http://schema.org/Offer">
										<metaitemprop ="priceCurrency" content="USD" />
										<div id="deal_content_${listVar.dealId}">
											<div class="image">
												<span itemprop="image"><a id="deal_image" href="http://${listVar.cityName}<spring:message code="common.city.domain"></spring:message>/displayImage?image=${listVar.imagePath}" target="_blank"><img src="../displayImage?image=${listVar.imagePath}" width="156px" class="border"></a></span>
											</div>
											<div class="deal-content">
												<table width="100%" border="0" cellpadding="0" cellspacing="0">
													<tbody>
														<tr>
															<td colspan="3"><span itemprop="seller"><strong><a class="merchant" id="merchant_name_link" style="color: #28708D;" href="http://${listVar.cityName}<spring:message code="common.city.domain"></spring:message>/merchant/${listVar.urlMerchantName}"><c:out
																				value="${listVar.merchantName}" /></a></strong></span></td>
														</tr>
														<tr>
															<c:set var="merchantName" value="${listVar.merchantName}" />
															<c:set var="merchantName1" value="${fn:split(merchantName, ' ')}" />
															<c:set var="merchantName2" value="${fn:join(merchantName1, '-')}" />
															<td colspan="3"><span itemprop="itemOffered"><a id="deal_title_link" href="http://${listVar.cityName}<spring:message code="common.city.domain"></spring:message>/${listVar.urlMerchantName}/deal/${listVar.urlTitle}--${listVar.dealId}"><c:out value="${listVar.title}" /></a></span></td>
														</tr>
														<tr>
															<td><strong>Deal Start :</strong> <span itemprop="validFrom"><c:out value="${listVar.startDate}" /></span></td>
															<td><strong>Deal End :</strong> <span itemprop="validThrough"><c:out value="${listVar.endDate}" /></span></td>
															<c:if test="${listVar.amountSaved!=null}">
																<td><strong>How Much Saved :</strong> <c:out value="${listVar.amountSaved}" /></td>
															</c:if>
														</tr>
														<tr>
															<td><c:if test="${listVar.dealCode!=null}">
																	<strong>Deal Code :</strong>
																	<c:out value="${listVar.dealCode}" />
																</c:if></td>
															<td colspan="2"><c:if test="${listVar.restriction!=null}">
																	<strong>Restrictions :</strong>
																	<c:out value="${listVar.restriction}" />
																</c:if></td>
														</tr>
														<tr>
															<td colspan="3"><strong>Description :</strong> <span itemprop="description"><c:out value="${listVar.description}" /></span></td>
														</tr>
														<tr>
															<td class="blue-font">Share This Deal</td>
															<td class="blue-font">Rate This Deal</td>
															<td class="blue-font">Subscribe To Merchant</td>
														</tr>
														<tr>
															<c:set var="description" value="${listVar.description}" />
															<c:set var="description1" value="${fn:split(description, \"'\")}" />
															<c:set var="description2" value="${fn:join(description1, '-')}" />
															<!--  Title -->
															<c:set var="title_a" value="${listVar.title}" />
															<c:set var="title_b" value="${fn:split(title_a, \"'\")}" />
															<c:set var="title_c" value="${fn:join(title_b, '-')}" />
															<td>
																<%-- <a id="share_deal_fb_${listVar.merchantId}"
																onclick="shareOnFB('${listVar.urlMerchantName}/deal/${listVar.urlTitle}-${listVar.dealId}','<c:out value="${listVar.imagePath}" />','<c:out value="${title_c}" />','<c:out value="${description2}" />','redirect');"
																target="_blank"><img src="<c:url value='../resources/images/facebook-share-this-deal-ic1.png'/>" width="80px" height="30px"></a> --%>
																<li><a id="stm_email" href="subscribe/${listVar.urlMerchantName}-${listVar.merchantId}"><img src="<c:url value='../resources/images/email-16x16.png'/>" title="Email"></a></li>
																<li><a id="stm_prnt" href="JavaScript:void(0)" onclick="PrintDiv('deal_content_${listVar.dealId}');" target="_blank"><img src="<c:url value='../resources/images/printer-16x16.jpg'/>" title="Print this deal"></a></li>
															</td>
															<td>
																<div id="current-rating">
																	<div itemprop="aggregateRating" itemscopeitemtype="http://schema.org/AggregateRating">
																		Rated <span itemprop="ratingValue"><label id="currentRating${listVar.dealId}"></label></span>/5
																	</div>
																</div>
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
																</div> <script type="text/javascript">
																$(function(){
																	rate(${listVar.currentRating},${listVar.dealId});
																})
																</script>
															</td>
															<td>
																<ul>
																	<%-- <li><a id="stm_email" href="subscribe/${listVar.urlMerchantName}-${listVar.merchantId}"><img src="<c:url value='../resources/images/email-16x16.png'/>" title="Email"></a></li> --%>
																	<c:if test="${connectionDTO.twitterAccount!=null && connectionDTO.twitterAccountchk==1}">
																		<li><a id="stm_twitter" href="${connectionDTO.twitterAccount}"><img src="<c:url value='../resources/images/twitter-16x16.png'/>" title="Twitter"></a></li>
																	</c:if>
																	<c:if test="${connectionDTO.facebookFanPage!=null && connectionDTO.facebookFanPagechk==1}">
																		<li><a id="stm_fb" href="${connectionDTO.facebookFanPage}" target="_blank"><img src="<c:url value='../resources/images/facebook-16x16.png'/>" title="Facebook"></a></li>
																	</c:if>
																	<%-- <li><a id="stm_prnt" href="JavaScript:void(0)" onclick="PrintDiv('deal_content_${listVar.dealId}');" target="_blank"><img
																			src="<c:url value='../resources/images/printer-16x16.jpg'/>" title="Print this deal"></a></li> --%>
																</ul>
															</td>
														</tr>
														<tr>
															<td colspan="3">
																<!-- Facebook share button Start --> <iframe src='http://www.facebook.com/plugins/like.php?href=${listVar.fbSortUrl}&amp;width&amp;layout=button_count&amp;action=like&amp;show_faces=true&amp;share=true&amp;height=21&amp;appId=1499701620271988' scrolling="no" frameborder="0"
																	style="border: none; overflow: hidden; height: 21px; width: 123px;" allowTransparency="true"></iframe> <!-- FB End  --> <!--Twitter Start  --> <a href="https://twitter.com/share" class="twitter-share-button" data-text="${listVar.title}" data-url="${listVar.twitSortUrl}"
																data-via="getcitydealz">Tweet</a> <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>
																<!--Twitter End  --> <!-- Pinterest button Start by BloggerSentral.com -->
																<div style="margin: -26px 0 0 208px">
																	<c:set var="img" value="${fn:replace(listVar.imagePath,'.', '_do_custom_separator_')}" />
																	<a href='http://www.pinterest.com/pin/create/button/
													       ?url=${listVar.pinSortUrl}
													       &media=http://getcitydealz.com/displayImage1/${img}
													       &description=${description2}' data-pin-do="buttonPin" data-pin-config="beside"> <img
																		src="//assets.pinterest.com/images/pidgets/pin_it_button.png" />
																	</a>
																</div> <!-- Pinterest button End --> <!--  -->
																<div class="inLinkgcd" style="margin: -26px 0 0 271px">
																	<script src="//platform.linkedin.com/in.js" type="text/javascript">
												  lang: en_US
												</script>
																	<script type="IN/Share" data-counter="right" data-image="http://getcitydealz.com/displayImage1/${img}" data-url="${listVar.linkSortUrl}"></script>
																</div>
																<div style="margin: -26px 0 0 373px;">
																	<div class="g-plusone" data-size="medium" data-href='${listVar.gPSortUrl}'></div>
																</div>
															</td>
														</tr>
													</tbody>
												</table>
												<label class="error" id="error${listVar.dealId}"></label>
											</div>
											<div style="clear: both;"></div>
											<div align="center" style="margin-top: 5px;">
												<img src="<c:url value='../resources/images/shadow.png'/>">
											</div>
										</div>
									</div>
								</c:forEach>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- Slideshow section end here -->
		<!--show right div only if user not logged in -->

		<div class="right">
			<div class="moduletable">

				<div id="mp_map">
					<div id="map-canvas" class="mapDiv map-canvas" style="width: 169px; height: 200px; margin: 4px"></div>
				</div>

				<style>
h3 {
	background-color: #69BB01;
	border-bottom: 1px solid #FFFFFF;
	border-top: 1px solid #FFFFFF;
	color: #000000;
	font-family: 'Oswald', sans-serif;
	font-size: 16px;
	margin: 0;
	padding: 3px 8px;
	text-transform: uppercase;
}
</style>

				<c:if test="${documentDTO!=null}">
					<h3 id="mp_media">Merchant's Media</h3>
					<ul>
						<c:forEach var="docx" items="${documentDTO}">
							<li><a id="mp_media_link" href="../downloadDocument?dId=${docx.docId}&mId=${docx.merchantId}" target="_blank">${docx.documentTitle}</a></li>
						</c:forEach>
					</ul>

					<br>
				</c:if>
				<c:if test="${embedsDTOs!=null && fn:length(embedsDTOs) gt 0}">
					<h3 id="mp_media">Merchant's Embeds</h3>
					<ul>
						<c:forEach var="embedsDTO" items="${embedsDTOs}">
							<c:if test="${embedsDTO.showOnPage=='Yes'}">
								<script>
										var val = createSocialMediaUrl('${embedsDTO.embedContent}');
										document.write('<li id="mp_embeds_link"><iframe width="146" height="180" src="'+val+'"></iframe></li>');
									</script>
							</c:if>
						</c:forEach>
					</ul>

					<br>
				</c:if>
			</div>
			<c:if test="${connectionDTO.facebookFanPage!=null && connectionDTO.facebookFanPagechk==1}">
				<div class="moduletable">
					<h3>Latest Facebook Page Wall Posts</h3>
					<ul>
						<c:forEach var="fb" items="${facebooks}">
							<li id="mp_fb" style="overflow: hidden;">${fb}<!-- <a href="http://t.co/YkULVXq2l6" target="_blank">http://t.co/YkULVXq2l6</a> Stories via <a href="http://www.twitter.com/optimizeyourweb"
								target="_blank">@optimizeyourweb</a> --></li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			<c:if test="${tweets!=null}">
				<div class="moduletable">
					<h3>Latest Tweets</h3>
					<ul>
						<c:forEach var="tweet" items="${tweets}">
							<li id="mp_tweets" style="overflow: hidden;">${tweet}<!-- <a href="http://t.co/YkULVXq2l6" target="_blank">http://t.co/YkULVXq2l6</a> Stories via <a href="http://www.twitter.com/optimizeyourweb"
								target="_blank">@optimizeyourweb</a> --></li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			<c:if test="${connectionDTO.pinterestAccount!=null && connectionDTO.pinterestAccountchk==1}">
				<div class="moduletable">
					<h3>Latest Pins</h3>
					<div>
						<ul>
							<li id="gcdPinFeeds"></li>
						</ul>
					</div>
					<br>
				</div>
				<script type="text/javascript">
				/*Start Pinterest Builder  */
				if ("${connectionDTO.pinterestAccount!=null}" == "true") {
					var pin = '<a data-pin-do="embedUser" href="${connectionDTO.pinterestAccount}" data-pin-scale-width="60" data-pin-scale-height="400" data-pin-board-width="300"></a>';
					$("#gcdPinFeeds").html(pin);
				}
				/*End Pinterest Builder  */
				</script>
			</c:if>
			<c:if test="${connectionDTO.yelpAccount!=null && connectionDTO.yelpAccountchk==1}">
				<div class="moduletable">
					<h3>Latest Yelp Review</h3>
					<div>
						<ul>
							<li id="yelpwidget"></li>
						</ul>
					</div>
					<br>
				</div>
				<script type="text/javascript">
				/*Start Yelp Builder  */
				if ("${connectionDTO.yelpAccount!=null}" == "true") {
					var yelpIdIndex = "${connectionDTO.yelpAccount}".lastIndexOf("/");
					yelpIdIndex = "${connectionDTO.yelpAccount}".substring(yelpIdIndex + 1, "${connectionDTO.yelpAccount}".length);
					//alert(yelpIdIndex);
					(function() {
						var s = document.createElement("script");
						s.async = true;
						s.onload = s.onreadystatechange = function() {
							getYelpWidget(yelpIdIndex, "150", "RED", "y", "y", "3");
						};
						s.src = 'http://chrisawren.com/widgets/yelp/yelpv2.js';
						var x = document.getElementsByTagName('script')[0];
						x.parentNode.insertBefore(s, x);
					})();		
				}
				/*End Yelp Builder  */
				</script>
			</c:if>
			<c:if test="${connectionDTO.flickerAccount!=null && connectionDTO.flickerAccountchk==1}">
				<div class="moduletable">
					<h3>Latest Flickr</h3>
					<div>
						<ul>
							<span id="flickrImages"></span>
						</ul>
					</div>
					<br>
				</div>
				<script type="text/javascript">
				if ("${connectionDTO.flickerAccount!=null}" == "true") {
					var isFlickerVisible = false;
					var counterFlk = 0;
					$.getJSON("http://api.flickr.com/services/feeds/photos_public.gne?names=${connectionDTO.flickerAccount}&format=json&jsoncallback=?", function(data) {
						var listItems = '';
						$.each(data.items, function(i, item) {
							if(counterFlk<3){
								listItems += '<li>' + '<a href="'+item.media.m+'"><p class="artisan-name">' + item.title + '</p>'
								+ '<img src="'+item.media.m+'" width="149"/></a>' + '</li>';
							}
							counterFlk++;
						});
						isFlickerVisible = true;
						$('#flickrImages').append(listItems);
					});
				}
				</script>
			</c:if>

			<c:if test="${connectionDTO.gPlusAccount!=null && connectionDTO.gPlusAccountchk==1}">
				<div class="moduletable">
					<h3>Latest G+ Review</h3>
					<div>
						<style scoped>
@import
"<c:url value='/resources/css/jquery.kyco.googleplusfeed2.css'/>"
</style>
						<span class="gplus"></span>
					</div>
					<br>
				</div>
				<script type="text/javascript">
				//g+ Integration Start
				if ("${connectionDTO.gPlusAccount!=null}" == "true") {
					var gPls = "${connectionDTO.gPlusAccount}".lastIndexOf("/");
					gPls = "${connectionDTO.gPlusAccount}".substring(gPls + 1, "${connectionDTO.gPlusAccount}".length);
					$('.gplus').kycoGooglePlusFeed2(gPls);
				}
				//g+ Integration end
				</script>
			</c:if>

			<c:if test="${connectionDTO.tumblrAccount!=null && connectionDTO.tumblrAccountchk==1}">
				<div class="moduletable">
					<h3>Latest tumblr</h3>
					<div>
						<ul>
							<span id="tumblr"></span>
						</ul>
					</div>
					<br>
				</div>
				<script type="text/javascript">
				if ("${connectionDTO.tumblrAccount!=null}" == "true") {
					$.getJSON('${connectionDTO.tumblrAccount}/api/read/json?callback=?',
						function(response) {
						var arr = response.posts;
						html='';
						for(var i=0;i<arr.length;i++){
							if(i<6){
								html += '<li><a href="'+arr[i].url+'">'+arr[i]["regular-title"]+'</a></li>';
							}						
						}
						$("#tumblr").html(html);
					});
			}
				</script>
			</c:if>
			<c:if test="${connectionDTO.fourSquareAccount!=null && connectionDTO.fourSquareAccountchk==1}">
				<div class="moduletable">
					<h3>Latest 4SQ Review</h3>
					<div>
						<ul>
							<span id="foursquareId"></span>
						</ul>
					</div>
					<br>
				</div>
				<script type="text/javascript">
				//4SQ Integration Start
				if ("${connectionDTO.fourSquareAccount!=null}" == "true") {
					var fourSqvar = "${connectionDTO.fourSquareAccount}".lastIndexOf("/");
					fourSqvar = "${connectionDTO.fourSquareAccount}".substring(fourSqvar + 1, "${connectionDTO.fourSquareAccount}".length);
					html = '';
					try {
						var foursquareVar = $.ajax({
							url : "https://api.foursquare.com/v2/venues/" + fourSqvar + "?oauth_token=3I32EWC0JXMO4KAMJFR4PPE0GPX1MQ4XHGAPIAHYKCS2KZBW&v=20140927",
							type : "GET",
							global : false,
							data : {},
							dataType : "json",
							async : false
						}).responseText;
		
						foursquareVar = jQuery.parseJSON(foursquareVar);
						if (foursquareVar != null) {
							$("#foursqDiv").show();
							fsqTips = foursquareVar.response.venue.tips.groups[0].items;
							if(fsqTips.length==0)
								fsqTips = foursquareVar.response.venue.tips.groups[1].items;
							for ( var i = 0; i < fsqTips.length; i++) {
								html += '<li><a href="'+fsqTips[i].canonicalUrl+'">' + fsqTips[i].text + '</a></li>'
							}
						}
					} catch (e) {
						html = '<li>No Review Found</li>';
					}
					$("#foursquareId").html(html);
				}
				//4SQ Integration end
				</script>
			</c:if>
			<c:if test="${connectionDTO.instagramAccount!=null && connectionDTO.instagramAccountchk==1}">
				<div class="moduletable">
					<h3>Latest Instafeed</h3>
					<div>
						<ul>
							<li><div id="instafeed"></div></li>
						</ul>
					</div>
					<script type="text/javascript">
						    var userFeed = new Instafeed({
						        get: 'user',
						        userId: ${instagram},
						        accessToken: '594140682.48dd8e1.7bcf83e859a3489cad2352df105305b8'
						    });
						    userFeed.run();
						</script>
					<br>
				</div>
			</c:if>
		</div>
		<!-- Main text div end here -->

		<%@include file="../common/bottom.jsp"%>
	</div>
	<!-- wrapper end here -->
</body>
<script type="text/javascript">
		$(function() {
			//alert('${locationDTO1.locationId}'.length);
			if ($.trim('${locationDTO1.address1} ${locationDTO1.address2} ${locationDTO1.address3}').length == 0) {
				$("#otherLocations").hide();
				$("#otherLocationHeader").hide();
			}		
			
	
			if ('<c:out value="${locationDTO1.locationHours}"/>'.length > 0) {
				var html = '';
				var str = '${locationDTO1.locationHours}'.split(',');
				for ( var i = 0; i < str.length; i++) {
					html += str[i] + '<br/>';
				}
				$("#lbHour1").html(html);
			}
	
			if ('${locationDTO2.locationHours}'.length > 0) {
				var html = '';
				var str = '${locationDTO2.locationHours}'.split(',');
				for ( var i = 0; i < str.length; i++) {
					html += str[i] + '<br/>';
				}
				$("#lbHour2").html(html);
			}
	
			if ('${locationDTO3.locationHours}'.length > 0) {
				var html = '';
				var str = '${locationDTO3.locationHours}'.split(',');
				for ( var i = 0; i < str.length; i++) {
					html += str[i] + '<br/>';
				}
				$("#lbHour3").html(html);
			}
	
			(function(i, s, o, g, r, a, m) {
				i['GoogleAnalyticsObject'] = r;
				i[r] = i[r] || function() {
					(i[r].q = i[r].q || []).push(arguments)
				}, i[r].l = 1 * new Date();
				a = s.createElement(o), m = s.getElementsByTagName(o)[0];
				a.async = 1;
				a.src = g;
				m.parentNode.insertBefore(a, m)
			})(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
	
			ga('create', 'UA-36507206-1', 'auto');
			ga('send', 'pageview');
			  
		  <c:if test='${merchantDTO.googleAnalyticsId!=null}'>
		  	ga('create', '${merchantDTO.googleAnalyticsId}', 'auto', {'name': 'newTracker'});
		  	ga('newTracker.send', 'pageview');
		  </c:if>
			
			/* if ('<c:out value="${SESSION_ATTR_USER_INFO.userIndex}"/>'.length > 0)
				window.location.href = "merchantHome"; */
			//openPage('loadAllDealz?upcoming=0');
		});
	
		function rateDealz(rate, dealzId) {
			var retVal = $.ajax({
				url : "../rateDealz",
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
					$("#error" + dealzId).html('Thank You For Rating.');
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
		
		function PrintDiv(divToPrint) {
			//alert(divToPrint);
			var divToPrint = document.getElementById(divToPrint);
			var popupWin = window.open('', '_blank', 'width=300,height=300');
			popupWin.document.open();
			popupWin.document.write('<html>' + document.getElementsByTagName('head')[0].innerHTML + '<body onload="window.print()">' + divToPrint.innerHTML
					+ '</html>');
			popupWin.document.close();
		}
			    
	</script>
</html>
