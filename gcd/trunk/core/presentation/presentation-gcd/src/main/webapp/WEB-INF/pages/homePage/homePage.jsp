<%@page import="com.app.mvc.util.UrlSortnerUtil"%>
<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><c:if test="${cityName!=null}">Best Daily Dealz in ${cityName} | Hot Bargains in NOLA</c:if> <c:if test="${cityName==null}">Find the Best Deals, Bargains, Events & Promos in Your City | Get City Dealz</c:if></title>

<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<script type="text/javascript" src="<c:url value='resources/js/jquery-ui.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/template.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/rating.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/jquery-ui.css'/>" />
<link rel="shortcut icon" href="resources/images/icon.png" />
<script type="text/javascript" src="<c:url value='/resources/js/CommonFunction.js'/>"></script>
<link href="<c:url value='resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='resources/js/js-image-slider.js'/>"></script>

<link href="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/css/alert.css'/>" rel="stylesheet" />
<link href="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/themes/light/theme.css'/>" rel="stylesheet" />
<script src="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/js/alert.js'/>"></script>

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
<script src='http://assets.pinterest.com/js/pinit.js' type='text/javascript'></script>
<script src="https://apis.google.com/js/client.js?onload=handleClientLoad" gapi_processed="true"></script>

<script src="<c:url value='resources/js/googleLogin.js'/>"></script>
<script src="<c:url value='resources/js/facebookLogin.js'/>"></script>
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
	<div id="wrapper">
		<%@include file="../common/header.jsp"%>
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
		<%@include file="../common/left.jsp"%>
		<!-- Menu section end here -->
		<div class="cent center-both no-right">
			<form action="searchQuery">
				<div style="height: 25px; width: 185px; background: rgb(37, 70, 87); border-radius: 6px;">
					<input name="query" class="searchfield" type="text" placeholder="Search" style="margin: 1px 0 0 4px;" />
				</div>
				<div style="margin: -25px 0px 0 186px;">
					<input type="submit" name="searchBtn" id="searchBtn" class="mediumBtn" value="Search" />
				</div>
			</form>
			<c:if test="${socialProfileDTO.emailId==null}">
				<div style="margin: -32px 0 0 454px;" id="facebookLoginBtn">
					<a href="javascript:void(0);" onclick="loginFacebook();"><img alt="facebook login" src="<c:url value='resources/images/fb-login.png'/>" width="100" height="35" /></a>
				</div>
				<div style="margin-top: -41px; float: right;" id="googleSignInBtn">
					<a href="javascript:void(0);" id="googlelogin"><img alt="facebook login" src="<c:url value='resources/images/gSignIn.png'/>" width="100" height="42" /></a>
				</div>
			</c:if>
			<div class="main-content">
				<div id="system-message-container"></div>
				<div id="title"></div>
				<h3 class="msg">
					<em><c:if test="${cityName!=null}">${cityName}</c:if> <c:if test="${cityName==null}">The Latest Deals</c:if></em>
				</h3>
				<c:forEach var="listVar" items="${dealzs}">
					<div itemprop="offers" itemscopeitemtype="http://schema.org/Offer">
						<metaitemprop ="priceCurrency" content="USD" />
						<div id="deal_content_${listVar.dealId}">
							<div class="image">
								<span itemprop="image"><a id="deal_image" href="http://${listVar.cityName}<spring:message code="common.city.domain"></spring:message>/displayImage?image=${listVar.imagePath}" target="_blank"><img src="displayImage?image=${listVar.imagePath}" width="156px" class="border"></a></span>
							</div>
							<div class="deal-content">
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tbody>
										<tr>
											<td colspan="3"><span itemprop="seller"><strong><a class="merchant" id="merchant_name_link" style="color: #28708D;" href="http://${listVar.cityName}<spring:message code="common.city.domain"></spring:message>/merchant/${listVar.urlMerchantName}"><c:out
																value="${listVar.merchantName}" /></a></strong></span></td>
										</tr>
										<tr>
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
											target="_blank"><img src="<c:url value='resources/images/facebook-share-this-deal-ic1.png'/>" width="80px" height="30px"></a> --%>
												<li><a id="stm_email" href="http://${listVar.cityName}<spring:message code="common.city.domain"></spring:message>/subscribe/${listVar.urlMerchantName}-${listVar.merchantId}"><img src="<c:url value='resources/images/email-16x16.png'/>" title="Email"></a></li>
												<li><a id="stm_prnt" href="JavaScript:void(0)" onclick="PrintDiv('deal_content_${listVar.dealId}');" target="_blank"><img src="<c:url value='resources/images/printer-16x16.jpg'/>" title="Print this deal"></a></li>
											</td>
											<td>
												<div id="current-rating">
													<div itemprop="aggregateRating" itemscopeitemtype="http://schema.org/AggregateRating">
														<span itemprop="ratingValue"><label id="currentRating${listVar.dealId}"></label></span>/5
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
													<c:if test="${listVar.socialConnectionsDTO.twitterAccount!=null && listVar.socialConnectionsDTO.twitterAccountchk==1}">
														<li><a id="stm_twitter" href="${listVar.socialConnectionsDTO.twitterAccount}"><img src="<c:url value='resources/images/twitter-16x16.png'/>" title="Twitter"></a></li>
													</c:if>
													<c:if test="${listVar.socialConnectionsDTO.facebookFanPage!=null && listVar.socialConnectionsDTO.facebookFanPagechk==1}">
														<li><a id="stm_fb" href="${listVar.socialConnectionsDTO.facebookFanPage}" target="_blank"><img src="<c:url value='resources/images/facebook-16x16.png'/>" title="Facebook"></a></li>
													</c:if>
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
													<script type="text/javascript" src="https://platform.linkedin.com/in.js">
												  //api_key: 788h09mgk0m2z2
												  authorize: true
												  lang:  es_US
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
								<img src="<c:url value='resources/images/shadow.png'/>">
							</div>
						</div>
					</div>
				</c:forEach>
				<!-- <div class="pagination">
					<p class="counter">Page 1 of 5</p>
					<ul>
						<li class="pagination-start"><span class="pagenav">Start</span></li>
						<li class="pagination-prev"><span class="pagenav">Prev</span></li>
						<li><span class="pagenav">1</span></li>
						<li><a title="2" href="/?start=15" class="pagenav">2</a></li>
						<li><a title="3" href="/?start=30" class="pagenav">3</a></li>
						<li><a title="4" href="/?start=45" class="pagenav">4</a></li>
						<li><a title="5" href="/?start=60" class="pagenav">5</a></li>
						<li class="pagination-next"><a title="Next" href="/?start=15" class="pagenav">Next</a></li>
						<li class="pagination-end"><a title="End" href="/?start=60" class="pagenav">End</a></li>
					</ul>
				</div> -->
				<div class="pagination" id="paginationDiv"></div>
			</div>
		</div>
		<!-- Slideshow section end here -->
		<!--show right div only if user not logged in -->
		<%@include file="../common/right.jsp"%>
		<!-- Main text div end here -->
		<%@include file="../common/bottom.jsp"%>
	</div>
	<!-- wrapper end here -->
</body>

<script type="text/javascript">
$(function() {
	// Search
	// Search End
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
	
	
	var paggerCount=10;
	var totalPage;
	var globalCount;
	var count = getIntValue('<c:out value="${count}"/>');
	globalCount = count;
	var tag="a";
	if((count - paggerCount)<=0)
		tag="span";
	if (count>paggerCount&&(count % paggerCount != 0)) {
		count = getIntValue((count % paggerCount)) + 1;
		totalPage = getIntValue((count / paggerCount)) + 1;
	}else if(count>=paggerCount){
		totalPage = getIntValue((count / paggerCount));
	}else{
		totalPage = count;
		totalPage = getIntValue((count / paggerCount));
	}	
	
	var prev = getIntValue('<c:out value="${start}"/>') == 0 ? 0 : getIntValue('<c:out value="${start}"/>') - paggerCount;
	var next = (count - paggerCount)>0 ? (count - paggerCount) : getIntValue('<c:out value="${start}"/>') + paggerCount;
	if(next>=globalCount)
		tag="span";
	if(globalCount>paggerCount){
	$("#paginationDiv").append(
			'<p class="counter">Page ${page} of ' + ${totalPage} + '</p>' + '<ul>'
					+ '<li class="pagination-start"><a href="index?start=0" class="pagenav">Start</a></li>'
					+ '<li class="pagination-prev"><a href="index?start=' + prev + '" class="pagenav">Prev</a></li>' + '<label id="pages"></label>'
					+ '<li class="pagination-next"><'+tag+' title="Next" href="index?start=' + next + '" class="pagenav">Next</'+tag+'></li>'
					+ '<li class="pagination-end"><'+tag+' title="End" href="index?start=' + ((getIntValue(${totalPage})*10)-10) + '" class="pagenav">End</'+tag+'></li>' + '&nbsp;&nbsp;&nbsp;Go To Page&nbsp;&nbsp;<input type"text" name"goto" id="goto" value="${page}" style="width:20px;"/>&nbsp;&nbsp;<input type="button" onClick="goto();" value="Go"/></ul>');

	
	$("#pages").html(pageing);
	}
});

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

</script>
<script type="text/javascript">
	$(function() {
		if ('<c:out value="${SESSION_ATTR_USER_INFO.userIndex}"/>'.length > 0 && '<c:out value="${SESSION_ATTR_USER_INFO.userType}"/>'.length==0)
			window.location.href = "merchantHome";
		if ('<c:out value="${SESSION_ATTR_USER_INFO.userIndex}"/>'.length > 0 &&'<c:out value="${SESSION_ATTR_USER_INFO.userType}"/>'.length!=0 && '<c:out value="${SESSION_ATTR_USER_INFO.userType}"/>'=='1002')
			window.location.href = "component/adminDashboard";		
	});

	function becomeAmerchant() {
		window.open("become-a-merchant");
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
				$("#error"+dealzId).html('Thank You For Rating.');
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
		
    function PrintDiv(divToPrint) {
    	//alert(divToPrint);
       var divToPrint = document.getElementById(divToPrint);
       var popupWin = window.open('', '_blank', 'width=300,height=300');
       popupWin.document.open();
       popupWin.document.write('<html>'+document.getElementsByTagName('head')[0].innerHTML+'<body onload="window.print()">' + divToPrint.innerHTML + '</html>');
        popupWin.document.close();
     }
    
    function goto(){
    	var end = getIntValue($("#goto").val())*10;
    	if(end>0){
    		var start;
        	if(end>10){
        		start = end-10;
        	}else{
        		start = 0;
        	}        	
        	window.location.href="index?start="+start;
    	}
    }
</script>
</html>
