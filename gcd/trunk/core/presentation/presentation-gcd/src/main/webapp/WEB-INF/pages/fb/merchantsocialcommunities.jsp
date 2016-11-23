<%@include file="../common/taglibs.jsp"%>
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
<link href="<c:url value='/resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='/resources/js/js-image-slider.js'/>"></script>
</head>

<body>
	<%@include file="../common/telliumTags.jsp"%>
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
							<li><a id="gcd_sm_pinterest" href="http://www.pinterest.com/getcitydealz" target="_blank"> <img src="<c:url value='/resources/images/pintrest.png'/>" border="0" alt="pintrest" title="pintrest">
							</a></li>
							<li><a id="gcd_sm_g+" href="https://plus.google.com/113127686225602648376" target="_blank"> <img src="<c:url value='/resources/images/gplush.png'/>" border="0" alt="Google Plus" title="Google Plus"></a></li>
							<li><a id="gcd_sm_youtube" href="http://www.youtube.com/user/GetCityDealz" target="_blank"> <img src="<c:url value='/resources/images/youtube.png'/>" border="0" alt="youtube" title="youtube">
							</a></li>
							<div class="clr"></div>
						</ul>
						<div class="clr"></div>

					</div>

					<div class="logo">
						<a id="header_home_link" href="../index"><img src="<c:url value='/resources/images/logo1.png'/>" /></a>
						<div class="clr"></div>
					</div>
					<div id="sliderFrame">
						<div id="ribbon">
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
							<div id="title">${SESSION_ATTR_USER_INFO.cityText}:${merchantDto.merchantName}'SManageSocial ConnectionN</div>
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
										</h3>
										<div class="profile">
											<table cellspacing="0" cellpadding="0" style="width: 50%;">
												<tbody>
													<tr>
														<td><select name="selectTag" id="selectTag"></select></td>
														<td><input type="button" value="Continue" onclick="clickOnContinue();" /></td>
													</tr>
												</tbody>
											</table>
										</div>
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
</body>
<script type="text/javascript">
$(function () {
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
			sliderImage +='<a href="merchant/${merchantName2}-'+bannerArr[i].merchantId+'"><img src="displayImage?image='+bannerArr[i].imagePath+'" id="wrap'+(i+1)+'" style="visibility: hidden;"/></a>';
		}
		//sliderImage +='<div class="clr"></div>';
		$("#slider").append(sliderImage);
	}
	try{
		var a = '<optgroup label="Personal Profile"><option value="">${facebook.name}</option></optgroup>';
		<c:forEach var="val" items="${acc}">
		a +='<optgroup label="Facebook Pages"><option value="">${val.name}</option></optgroup>';
		</c:forEach>		
		$("#selectTag").append(a);
	}catch (e) {
		alert(e);
	}
});

	function clickOnContinue() {
		window.location.href = "clickOnContinue";
	}
</script>
</html>
