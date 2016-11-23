<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta property="og:title" content="${dealzDTO.title}" />
<meta property="og:description" content="${dealzDTO.description}" />
<meta property="og:image" content="http://getcitydealz.com/displayImage?image=${dealzDTO.imagePath}" />
<meta property="og:image:width" content="400" />
<meta property="og:image:height" content="300" />
<meta property="og:url" content="../../${dealzDTO.urlMerchantName}/deal/${dealzDTO.urlTitle}--${dealzDTO.dealId}" />

<title>${dealzDTO.title}</title>
<description style="display:none;">${dealzDTO.description}</description>

<script type="text/javascript" src="<c:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/rating.css'/>">
<link rel="shortcut icon" href="<c:url value='/resources/images/icon.png'/>" />
<link href="<c:url value='/resources/css/media.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/resources/js/CommonFunction.js'/>"></script>
<link href="<c:url value='/resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='/resources/js/js-image-slider.js'/>"></script>

<style>
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
<script src='http://assets.pinterest.com/js/pinit.js' type='text/javascript' />
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

</head>
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
	<input type="hidden" style="display: none;" id="latitude" name="latitude" value="${dealzDTO.latitude}" />
	<input type="hidden" style="display: none;" id="longitude" name="longitude" value="${dealzDTO.longitude}" />
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
			<form action="../../searchQuery">
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
				<div id="deal_content">
					<div class="image">
						<span itemprop="image"><a id="deal_image" href="../../displayImage?image=${dealzDTO.imagePath}" target="_blank"><img src="../../displayImage?image=${dealzDTO.imagePath}" width="156px" class="border"></a></span>
					</div>
					<div itemprop="offers" itemscopeitemtype="http://schema.org/Offer">
						<metaitemprop ="priceCurrency" content="USD" />
						<div class="deal-content">
							<table width="100%" border="0" cellpadding="0" cellspacing="0">
								<tbody>
									<tr>
										<td colspan="3"><span itemprop="seller"><strong><a class="merchant" id="merchant_name_link" style="color: #28708D;" href="../../merchant/${dealzDTO.urlMerchantName}"><c:out value="${dealzDTO.merchantName}" /></a></strong></span></td>
									</tr>
									<tr>
										<c:set var="merchantName" value="${dealzDTO.merchantName}" />
										<c:set var="merchantName1" value="${fn:split(merchantName, ' ')}" />
										<c:set var="merchantName2" value="${fn:join(merchantName1, '-')}" />
										<td colspan="3"><span itemprop="itemOffered"><a id="deal_title_link" href="../../${dealzDTO.urlMerchantName}/deal/${dealzDTO.urlTitle}--${dealzDTO.dealId}"><c:out value="${dealzDTO.title}" /></a></span></td>
									</tr>
									<tr>
										<td><strong>Deal Start :</strong> <span itemprop="validFrom"><c:out value="${dealzDTO.startDate}" /></span></td>
										<td><strong>Deal End :</strong> <span itemprop="validThrough"><c:out value="${dealzDTO.endDate}" /></span></td>
										<c:if test="${dealzDTO.amountSaved!=null}">
											<td><strong>How Much Saved :</strong> <c:out value="${dealzDTO.amountSaved}" /></td>
										</c:if>
									</tr>
									<tr>
										<td><c:if test="${dealzDTO.dealCode!=null}">
												<strong>Deal Code :</strong>
												<c:out value="${dealzDTO.dealCode}" />
											</c:if></td>
										<td colspan="2"><c:if test="${dealzDTO.restriction!=null}">
												<strong>Restrictions :</strong>
												<c:out value="${dealzDTO.restriction}" />
											</c:if></td>
									</tr>
									<tr>
										<td colspan="3"><strong>Description :</strong> <span itemprop="description"><c:out value="${dealzDTO.description}" /></span></td>
									</tr>
									<tr>
										<td class="blue-font">Share This Deal</td>
										<td class="blue-font">Rate This Deal</td>
										<td class="blue-font">Subscribe To Merchant</td>
									</tr>
									<tr>
										<c:set var="description" value="${dealzDTO.description}" />
										<c:set var="description1" value="${fn:split(description, \"'\")}" />
										<c:set var="description2" value="${fn:join(description1, '-')}" />
										<!--  Title -->
										<c:set var="title_a" value="${dealzDTO.title}" />
										<c:set var="title_b" value="${fn:split(title_a, \"'\")}" />
										<c:set var="title_c" value="${fn:join(title_b, '-')}" />
										<td>
											<%-- <a id="share_deal_fb_${dealzDTO.merchantId}"
										onclick="shareOnFB('${dealzDTO.urlMerchantName}/deal/${dealzDTO.urlTitle}-${dealzDTO.dealId}','<c:out value="${dealzDTO.imagePath}" />','<c:out value="${title_c}" />','<c:out value="${description2}" />','redirect');"
										target="_blank"><img src="<c:url value='/resources/images/facebook-share-this-deal-ic1.png'/>" width="80px" height="30px"></a> --%>
											<li><a id="stm_email" href="../../subscribe/${dealzDTO.urlMerchantName}-${dealzDTO.merchantId}"><img src="<c:url value='/resources/images/email-16x16.png'/>" title="Email"></a></li>
											<li><a id="stm_prnt" href="JavaScript:void(0)" onclick="PrintDiv('deal_content_${dealzDTO.dealId}');" target="_blank"><img src="<c:url value='/resources/images/printer-16x16.jpg'/>" title="Print this deal"></a></li>
										</td>
										<td>
											<div id="current-rating">
												<div itemprop="aggregateRating" itemscopeitemtype="http://schema.org/AggregateRating">
													<span itemprop="ratingValue"><label id="currentRating${dealzDTO.dealId}"></label></span>/5
												</div>
											</div>
											<div class="rating">
												<div class="cancel">
													<a style="cursor: pointer;" title="Cancel Rating">Cancel Rating</a>
												</div>
												<div class="star" id="ratingStart1<c:out value="${dealzDTO.dealId}"/>">
													<a style="cursor: pointer;" title="Give it 1/1" style="width: 100%;" onclick="rateDealz(1,${dealzDTO.dealId});">1</a>
												</div>
												<div class="star" id="ratingStart2<c:out value="${dealzDTO.dealId}"/>">
													<a style="cursor: pointer;" title="Give it 2/2" style="width: 100%;" onclick="rateDealz(2,${dealzDTO.dealId});">2</a>
												</div>
												<div class="star" id="ratingStart3<c:out value="${dealzDTO.dealId}"/>">
													<a style="cursor: pointer;" title="Give it 3/3" style="width: 100%;" onclick="rateDealz(3,${dealzDTO.dealId});">3</a>
												</div>
												<div class="star" id="ratingStart4<c:out value="${dealzDTO.dealId}"/>">
													<a style="cursor: pointer;" title="Give it 4/4" style="width: 100%;" onclick="rateDealz(4,${dealzDTO.dealId});">4</a>
												</div>
												<div class="star" id="ratingStart5<c:out value="${dealzDTO.dealId}"/>">
													<a style="cursor: pointer;" title="Give it 5/5" style="width: 100%;" onclick="rateDealz(5,${dealzDTO.dealId});">5</a>
												</div>
											</div> <script type="text/javascript">
															$(function(){
																rate(${dealzDTO.currentRating},${dealzDTO.dealId});
															})
															</script>
										</td>
										<td>
											<ul>

												<c:if test="${dealzDTO.socialConnectionsDTO.twitterAccount!=null && dealzDTO.socialConnectionsDTO.twitterAccountchk==1}">
													<li><a id="stm_twitter" href="${dealzDTO.socialConnectionsDTO.twitterAccount}"><img src="<c:url value='/resources/images/twitter-16x16.png'/>" title="Twitter"></a></li>
												</c:if>
												<c:if test="${dealzDTO.socialConnectionsDTO.facebookFanPage!=null && dealzDTO.socialConnectionsDTO.facebookFanPagechk==1}">
													<li><a id="stm_fb" href="${dealzDTO.socialConnectionsDTO.facebookFanPage}" target="_blank"><img src="<c:url value='/resources/images/facebook-16x16.png'/>" title="Facebook"></a></li>
												</c:if>

											</ul>
										</td>
									</tr>
									<tr>
										<td colspan="3">
											<!-- Facebook share button Start --> <iframe src='http://www.facebook.com/plugins/like.php?href=${dealzDTO.fbSortUrl}&amp;width&amp;layout=button_count&amp;action=like&amp;show_faces=true&amp;share=true&amp;height=21&amp;appId=1499701620271988' scrolling="no" frameborder="0"
												style="border: none; overflow: hidden; height: 21px; width: 123px;" allowTransparency="true"></iframe> <!-- FB End  --> <!--Twitter Start  --> <a href="https://twitter.com/share" class="twitter-share-button" data-text="${dealzDTO.title}" data-url="${dealzDTO.twitSortUrl}"
											data-via="getcitydealz">Tweet</a> <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>
											<!--Twitter End  --> <!-- Pinterest button Start by BloggerSentral.com -->
											<div style="margin: -26px 0 0 208px">
												<c:set var="img" value="${fn:replace(dealzDTO.imagePath,'.', '_do_custom_separator_')}" />
												<a href='http://www.pinterest.com/pin/create/button/
												       ?url=${dealzDTO.pinSortUrl}
												       &media=http://getcitydealz.com/displayImage1/${img}
												       &description=${description2}' data-pin-do="buttonPin" data-pin-config="beside"> <img
													src="//assets.pinterest.com/images/pidgets/pin_it_button.png" />
												</a>
											</div> <!-- Pinterest button End --> <!--  -->
											<div class="inLinkgcd" style="margin: -26px 0 0 271px">
												<script src="//platform.linkedin.com/in.js" type="text/javascript">
											  lang: en_US
											</script>
												<script type="IN/Share" data-counter="right" data-image="http://getcitydealz.com/displayImage1/${img}" data-url="${dealzDTO.linkSortUrl}"></script>
											</div>
											<div style="margin: -26px 0 0 373px;">
												<div class="g-plusone" data-size="medium" data-href='${dealzDTO.gPSortUrl}'></div>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
							<label class="error" id="error${dealzDTO.dealId}"></label>
						</div>
					</div>
					<div style="clear: both;"></div>
					<div align="center" style="margin-top: 5px;">
						<img src="<c:url value='/resources/images/shadow.png'/>">
					</div>
				</div>
				<div id="deal_page_map">
					<div id="map" class="google-map" style="width: 250px; height: 250px; position: relative; overflow: hidden; -webkit-transform: translateZ(0px); background-color: rgb(229, 227, 223);"></div>
				</div>
				<script src="https://maps.googleapis.com/maps/api/js"></script>
				<script>
				
var locations = [["${dealzDTO.merchantDTOs.merchantName}<br/>${dealzDTO.merchantDTOs.address1} ${dealzDTO.merchantDTOs.address2} ${dealzDTO.merchantDTOs.address3},${dealzDTO.merchantDTOs.cityText},${dealzDTO.merchantDTOs.state}<br/>${dealzDTO.merchantDTOs.contactPhone}&nbsp;&nbsp;&nbsp;<a id='dealpg_map_email_link' href='mailto:${dealzDTO.merchantDTOs.emailId}'>${dealzDTO.merchantDTOs.emailId}</a><br/><a  id='dealpg_map_deal_link' href='${dealzDTO.merchantDTOs.websiteUrl}' target='_blank'>${dealzDTO.merchantDTOs.websiteUrl}</a>",${dealzDTO.latitude}, ${dealzDTO.longitude}, 1] ];
var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 10,
    center: new google.maps.LatLng(${dealzDTO.latitude}, ${dealzDTO.longitude}),
    mapTypeId: google.maps.MapTypeId.ROADMAP
  });

  var infowindow = new google.maps.InfoWindow();

  var marker, i;

  for (i = 0; i < locations.length; i++) {  
    marker = new google.maps.Marker({
      position: new google.maps.LatLng(locations[i][1], locations[i][2]),
      map: map
    });
		
    google.maps.event.addListener(marker, 'click', (function(marker, i) {
      return function() {
        infowindow.setContent(locations[i][0]);
        infowindow.open(map, marker);
      }
    })(marker, i));
  }
</script>
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
<script type="text/javascript">
function rateDealz(rate, dealzId) {
	var retVal = $.ajax({
		url : "../../rateDealz",
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
			$("#error"+dealzId).html('<li>Thank You For Rating.</li>');
			$("#currentRating"+dealzId).html(obj.currentRating+"");
		} else {
			//alert(obj.jsonMessage);
			$(".error").html('');
			$("#error"+dealzId).html('<li>' + obj.jsonMessage + '</li>');
		}
	}
}

function becomeAmerchant() {
	window.open("../become-a-merchant");
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

function shareOnFB(link, picture, name, desc, redirect) {
	window.open('https://www.facebook.com/dialog/feed?app_id=174025642805043&' + 'link=${pageContext.request.scheme}://${pageContext.request.serverName}/'+link + '&picture=http://getcitydealz.com/displayImage?image='
			+ picture + '&name=' + name + '&description=' + desc
			+ '&redirect_uri=${pageContext.request.scheme}://${pageContext.request.serverName}${requestScope["javax.servlet.forward.request_uri"]}');
}

function PrintDiv(divToPrint) {
	//alert(divToPrint);
   var divToPrint = document.getElementById(divToPrint);
   var popupWin = window.open('', '_blank', 'width=300,height=300');
   popupWin.document.open();
   popupWin.document.write('<html>'+document.getElementsByTagName('head')[0].innerHTML+'<body onload="window.print()">' + divToPrint.innerHTML + '</html>');
    popupWin.document.close();
 }
 
function loginFacebook() {
    FB.login(function(response) {
        if (response.authResponse) {
            // connected
        testAPI();
        } else {
            // cancelled
        }
    }, { scope: 'email' });
    }

function testAPI() {

    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
        console.log('Good to see you, ' + response.name + '.' + ' Email: ' + response.email + ' Facebook ID: ' + response.id);
        var strName = (response.name).split(" ");
        var fName = strName[0];
        var lName;
        if(strName.length>1)
        	lName = strName[1];
        doSubscribeViaChannel(fName,lName,response.email);
        $("#facebookLoginBtn").remove();
		$("#googleSignInBtn").remove();
    });
}

function validate(){
	if($(".searchfield").val()=='')
		return false;
	event.preventDefault();
}

function doSubscribeViaChannel(fName,lName,emailId){
	$.alert.open('confirm', 'Thanks for signing in!  Would you like to subscribe to local deal alerts now?', function(button) {
		if (button == 'yes') {
			window.location.href="http://neworleans.getcitydealz.com/subscribe?fName="+fName+"&lName="+lName+"&email="+emailId;
		}
		if (button == 'no') {
			var retVal = $.ajax({
				url : "../../socialDetailsConsumer",
				global : false,
				type : "POST",
				data : {
					fName : fName,
					lName : lName,
					emailId:emailId
				},
				dataType : "json",
				async : false
			}).responseText;
		}
	});
}
</script>
</html>
