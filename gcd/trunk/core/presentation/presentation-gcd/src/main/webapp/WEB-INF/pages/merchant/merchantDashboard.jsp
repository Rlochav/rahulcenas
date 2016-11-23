<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title><spring:message code="common.html.000001"></spring:message></title>

<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/template1.css'/>">
<link href="<c:url value='resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='resources/js/js-image-slider.js'/>"></script>
<link rel="shortcut icon" href="resources/images/icon.png" />
<script type="text/javascript" src="<c:url value='resources/js/CommonFunction.js'/>"></script>
<style type="text/css">

/* Styles for DJ Image Slider with module id 87 */
#djslider-loader87 {
	margin: 0 auto;
	position: relative;
}

#djslider87 {
	margin: 0 auto;
	position: relative;
	height: 216px;
	width: 658px;
	max-width: 658px;
}

#slider-container87 {
	position: absolute;
	overflow: hidden;
	left: 0;
	top: 0;
	height: 100%;
	width: 100%;
}

#djslider87 ul#slider87 {
	margin: 0 !important;
	padding: 0 !important;
	border: 0 !important;
}

#djslider87 ul#slider87 li {
	list-style: none outside !important;
	float: left;
	margin: 0 !important;
	border: 0 !important;
	padding: 0 0px 0px 0 !important;
	position: relative;
	height: 216px;
	width: 658px;
	background: none;
	overflow: hidden;
}

#slider87 li img {
	width: 100%;
	height: auto;
	border: 0 !important;
	margin: 0 !important;
}

#slider87 li a img,#slider87 li a:hover img {
	border: 0 !important;
}

/* Navigation buttons */
#navigation87 {
	position: relative;
	top: 13.8888888889%;
	margin: 0 5px;
	text-align: center !important;
}

#prev87 {
	cursor: pointer;
	display: block;
	position: absolute;
	left: 0;
}

#next87 {
	cursor: pointer;
	display: block;
	position: absolute;
	right: 0;
}

table {
	display: table;
	border-collapse: separate;
	border-spacing: 2px;
	border-color: gray;
}

table[Attributes Style] {
	border-spacing: 0px;
}

th {
	font-weight: bold;
}

td,th {
	display: table-cell;
	vertical-align: inherit;
}
</style>
</head>
<body>
	<%@include file="../common/telliumTags.jsp"%>
	<script>
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
		<%@include file="../common/header4.jsp"%>
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
		<%@include file="../common/merchantLeft.jsp"%>
		<!-- Menu section end here -->

		<div class="cent center-leftcenter-both no-right">
			<div class="main-content">
				<div id="system-message-container"></div>
				<div id="dashboard-area">
					<h3 class="msg">
						<em>Hi There ${SESSION_ATTR_USER_INFO.userName} Welcome to your GetCityDealz Dashboard</em>
					</h3>
					<br>
					<div class="items">
						<strong>${merchantDTO.merchantName} Profile URL</strong><span> <a href="merchant/${merchantDTO.urlMerchant}">http://neworleans.getcitydealz.com/merchant/${merchantDTO.urlMerchant}</a></span><br />
						<br />
						<%-- <h3>
							* You can post on facebook till ${latestDeal.accessTokenExpireDate} <br> Go to Social Connections to refresh your facebook settings before ${latestDeal.accessTokenExpireDate}
						</h3> --%>
						<table cellpadding="0" cellspacing="0" class="basic-details">
							<tbody>
								<tr>
									<th><a href="#">Your Latest Deals</a></th>
									<th>Highest Rated Deals</th>
								</tr>
								<tr>
									<td style="width: 150px;"><c:if test="${latestDeals!=null}">
											<c:forEach var="latestDeal" items="${latestDeals}">
												<li class="mReadOnlyLabel">
													<!-- <div class="cat-name"> --> <a href="postDealz?dealId=${latestDeal.dealId}&dealType=1">${latestDeal.title}: ${latestDeal.status}</a> <!-- </div> -->
												</li>
											</c:forEach>
										</c:if> <c:if test="${latestDeals==null}">
											<div class="cat-name">NO DEAL FOUND</div>
										</c:if></td>
									<td>
										<div class="cat-name">
											<c:set var="merchantName" value="${SESSION_ATTR_USER_INFO.userName}" />
											<c:set var="merchantName1" value="${fn:split(merchantName, ' ')}" />
											<c:set var="merchantName2" value="${fn:join(merchantName1, '-')}" />
											<c:if test="${heigestRatedDEalz!=null}">
												<c:forEach var="dto" items="${heigestRatedDEalz}">
													<li class="mReadOnlyLabel">
														<!-- <div class="cat-name"> --> <a href="${merchantName2}/deal/${dto.urlTitle}-${dto.dealId}">${dto.title}</a> <!-- </div> -->
													</li>
												</c:forEach>
											</c:if>
											<c:if test="${heigestRatedDEalz==null}">
												<div class="cat-name">NO DEAL FOUND</div>
											</c:if>
										</div>
									</td>
								</tr>
								<tr>
									<th colspan="2">Google Analytics</th>
								</tr>
								<tr>
									<td colspan="2"><jsp:include page="../common/ga.jsp"></jsp:include></td>
								</tr>
								<tr>
									<th><a href="manageMedia">Your Media</a></th>
									<th><a href="socialConnections">Your Social Connecions</a></th>
								</tr>
								<tr>
									<td>
										<ul>
											<c:forEach var="mediaList" items="${mediaList}">
												<li class="mReadOnlyLabel"><a href="manageMedia">${mediaList}</a></li>
											</c:forEach>

											<c:forEach var="embbed" items="${embbeds}">
												<li class="mReadOnlyLabel"><a href="manageEmbeds">${embbed.embedTitle}</a></li>
											</c:forEach>
										</ul>
									</td>
									<td><ul>
											<c:forEach var="conn" items="${socialConnection}">
												<li><a href="socialConnections">${conn}</a></li>
											</c:forEach>
										</ul></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- Slideshow section end here -->
		<!--show right div only if user not logged in -->
		<!-- Main text div end here -->
		<%@include file="../common/bottom.jsp"%>
	</div>
	<!-- wrapper end here -->
</body>
<script type="text/javascript">
$(function(){
	var retVal = $.ajax({
		url : "jsonGetHotDealz",
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
			sliderImage +='<a href="merchant/${merchantName2}-'+bannerArr[i].merchantId+'"><img src="displayImage?image='+bannerArr[i].imagePath+'" style="height:170px;" class="wrap" id="wrap'+(i+1)+'" style="display: none;"/></a>';
		}
		$("#slider").append(sliderImage);
	}
});

</script>
</html>