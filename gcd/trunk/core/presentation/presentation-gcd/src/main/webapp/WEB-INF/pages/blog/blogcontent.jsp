<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="common.html.000001"></spring:message></title>

<script type="text/javascript" src="<c:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/rating.css'/>">
<link rel="shortcut icon" href="/resources/images/icon.png" />
<link href="<c:url value='/resources/css/media.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/resources/js/CommonFunction.js'/>"></script>
<link href="<c:url value='/resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='/resources/js/js-image-slider.js'/>"></script>
</head>

<body>
	<%@include file="../common/telliumTags.jsp"%>
	<script type="text/javascript">
(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

	ga('create', 'UA-36507206-1', 'auto');
	ga('send', 'pageview');
	  
	<c:if test='${merchantDTO.googleAnalyticsId!=null}'>
		ga('create', '${merchantDTO.googleAnalyticsId}', 'auto', {'name': 'newTracker'});
		ga('newTracker.send', 'pageview');
	</c:if>
</script>
	<div id="wrapper">
		<%@include file="../common/header2.jsp"%>
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
		<%@include file="../common/left3.jsp"%>
		<!-- Menu section end here -->
		<div class="cent center-both no-right">
			<div class="main-content">
				<div id="system-message-container"></div>
				<div id="title"></div>
				<%-- <a href="../../merchant/${merchantDTO.urlMerchant}-${merchantDTO.merchantId}"> <img src="../../displayImage?image=${merchantDTO.logoImagePath}" height="150px" width="156px" class="border" alt="DaLi Social" title="DaLi Social"> <strong>${merchantDTO.merchantName}</strong>
				</a> --%>
				<table id="merchant_profile" class="items_list" cellspacing="1" cellpadding="1">
					<tbody>
						<tr>
							<td rowspan="2"><span itemprop="logo"><img id="mp_logo" src="../../displayImage?image=${merchantDTO.logoImagePath}" height="150px" width="156px" class="border" alt="${merchantDTO.merchantName}" title="${merchantDTO.merchantName}" /></span></td>
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
									&nbsp;<a id="mp_sub_deals_email" href="../../subscribe/${merchantDTO.urlMerchant}-${merchantDTO.merchantId}"><img src="<c:url value='/resources/images/email-16x16.png'/>" title="Email"></a>
								</div>
							</td>
							<td><div id="mp_follow">
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
											<a href="${connectionDTO.linkedinProfile}" target="_blank"><img src="<c:url value='/resources/images//linkedin-16x16.png'/>" /></a>&nbsp;
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
								<div id="mp_follow">
									<strong>Merchant Features</strong>
									<div id="mAccessibility" style="width: 111px;">
										<c:forEach var="icon" items="${icons}">
											<c:set var="img" value="${fn:replace(icon.imagePath,'.', '_do_custom_separator_')}" />
											<a href="../../displayImage1/${img}?docType=11" target="_blank"><img alt="${icon.iconName}" title="${icon.iconName}" src="<c:url value='../../displayImage1/${img}?docType=11'/>" width="20" height="20" /></a>
												&nbsp;
											</c:forEach>
									</div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<h3 class="msg">
					<em> ${postDTO.title} </em>
				</h3>
				<div class="media-mng" style="padding: 0px 15px 15px 15px;">
					<p>
						<span style="color: #444444; font-family: Arial; font-size: 13px; line-height: 1.5em;">${postDTO.post}</span>
					</p>
				</div>

			</div>
		</div>

		<!-- Slideshow section end here -->
		<!--show right div only if user not logged in -->
		<%@include file="../common/right2.jsp"%>
		<!-- Main text div end here -->
		<%@include file="../common/bottom.jsp"%>
	</div>
	<!-- wrapper end here -->
</body>
</html>
