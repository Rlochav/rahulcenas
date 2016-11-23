<%@include file="../../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Best Daily Deals in New Orleans,LA | Hot Local Bargains in NOLA</title>

<script type="text/javascript" src="<c:url value='/resources/js/jquery-2.0.3.js'/>"></script>
<script src="<c:url value='/resources/js/main.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/screens.css'/>">
<link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="../resources/images/icon.png" />
<link href="<c:url value='/resources/css/media.css'/>" rel="stylesheet" type="text/css" />
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
						<ul class="social-icon">
							<li><a id="gcd_sm_fb" href="http://www.facebook.com/GetCityDealz" target="_blank"><img src="<c:url value='/resources/images/facebook.png'/>" width="auto" border="0" alt="facebook" title="facebook"></a></li>
							<li><a id="gcd_sm_twitter" href="http://www.twitter.com/GetCityDealz" target="_blank"><img src="<c:url value='/resources/images/twitter.png'/>" border="0" alt="twitter" title="twitter"></a></li>
							<li><a id="gcd_sm_pinterest" href="http://www.pinterest.com/getcitydealz" target="_blank"> <img src="<c:url value='/resources/images/pintrest.png'/>" border="0" alt="pintrest" title="pintrest"></a></li>
							<li><a id="gcd_sm_g+" href="https://plus.google.com/113127686225602648376" target="_blank"> <img src="<c:url value='/resources/images/gplush.png'/>" border="0" alt="Google Plus" title="Google Plus"></a></li>
							<li><a id="gcd_sm_youtube" href="http://www.youtube.com/user/GetCityDealz" target="_blank"> <img src="<c:url value='/resources/images/youtube.png'/>" border="0" alt="youtube" title="youtube"></a></li>
							<div class="clr"></div>
						</ul>
						<c:if test='${SESSION_ATTR_USER_INFO!=null}'>
							<div class="login" id="login">
								<a id="merchant_login_button" style="cursor: pointer;" href="../appLogOut"><img src="<c:url value='/resources/images/marchent-logout.png'/>" border="0"></a>
							</div>
						</c:if>
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
							<div id="title">${SESSION_ATTR_USER_INFO.cityText}: ${nName} ${title}</div>
							<div id="menu">
								<div class="menu-new">
									<div style="float: right; padding: 2px 35px;">
										<img src="<c:url value='/resources/images/blue-arrow.png'/>" style="width: 4px; height: 9px; padding: 0px 7px; margin: -1px;"> <a style="color: #046604; cursor: pointer;" href="adminDashboard"> Return to Main Dashboard </a><img src="<c:url value='/resources/images/blue-arrow.png'/>"
											style="width: 4px; height: 9px; padding: 0px 7px; margin: -1px;"> <a style="color: #046604; cursor: pointer;" href="merchantmgmt"> Return to ${SESSION_ATTR_USER_INFO.cityText} Dashboard </a><img src="<c:url value='/resources/images/blue-arrow.png'/>"
											style="width: 4px; height: 9px; padding: 0px 7px; margin: -1px;"> <a style="color: #046604; cursor: pointer;" href="neighborhoods"> Return to All New Orleans Neighborhoods </a>
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
									<c:if test='%{message}!=null'>
								%{message}
								</c:if>
								</h3> <br>
								<div id="form-field">
									<form:form method="post" name="addNeighborhoodForm" id="addNeighborhoodForm">
										<div class="profile">
											<table cellspacing="0" cellpadding="0" style="width: 100%;" class="tableStyle custom_td">
												<tbody>
													<tr>
														<td><label>Neighborhood Name<span class="star">&nbsp;*</span></label></td>
														<td><input type="text" name="neighborhoodName" id="neighborhoodName" value="${nName}" class="mInput" size="50"></td>
														<td class="button2"><input type="button" class="mediumBtn" value="${btnName}" onclick="saveNeighborhood('${nId}');" /></td>
													</tr>
												</tbody>
											</table>
										</div>
									</form:form>
								</div> <!--Content End -->
							</strong>
						</div>
					</div>
					<!-- mid end here -->

					<!-- footer start -->
					<div class="bottom">
						<div id="gcd_footer" class="footer-left">
							<ul>
								<li class="active"><a id="gcd_footer_home" href="../index">Home</a></li>
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
</body>
<script type="text/javascript">
$(function(){
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
});
	function saveNeighborhood(nId) {
		if (trimString($("#neighborhoodName").val()) == "") {
			appFocus($("#neighborhoodName"));
			$.alert.open('error', 'Neighborhood Name Missing.');
			return false;
		}

		var retVal = $.ajax({
			url : "saveNeighborhood",
			type : "POST",
			global : false,
			data : {
				neighborhoodId : nId,
				neighborhoodName : $("#neighborhoodName").val()
			},
			dataType : "json",
			async : false
		}).responseText;

		var obj = jQuery.parseJSON(retVal.length != 0 ? retVal : null);
		if (obj != null) {
			if (obj.jsonMessage == null || obj.jsonMessage == "") {
				$.alert.open('info', 'Neighborhood saved sucessfully.');
				window.location.href = "neighborhoods";
			} else {
				$.alert.open('error', obj.jsonMessage);
			}
		} else {
			$.alert.open('error', 'Error');
		}
		resetAll();
	}

	function resetAll() {
		$("#neighborhoodName").val("");
	}
</script>
</html>
