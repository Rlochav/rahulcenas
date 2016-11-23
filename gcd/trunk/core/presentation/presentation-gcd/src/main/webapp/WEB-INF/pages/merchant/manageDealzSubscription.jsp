<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title>Best Daily Deals in New Orleans,LA | Hot Local Bargains in NOLA</title>

<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/main.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/media.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/screens.css'/>">
<link rel="shortcut icon" href="resources/images/icon.png">
<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<script type="text/javascript" src="<c:url value='resources/js/CommonFunction.js'/>"></script>
<script src="<c:url value='resources/js/main.js'/>"></script>
<link href="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/css/alert.css'/>" rel="stylesheet" />
<link href="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/themes/light/theme.css'/>" rel="stylesheet" />
<script src="<c:url value='resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/js/alert.js'/>"></script>
<link href="<c:url value='resources/css/jquery-image-slider.css'/>" rel="stylesheet" type="text/css" />
<script src="<c:url value='resources/js/js-image-slider.js'/>"></script>
</head>

<body style="margin: 0px;">
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
						<c:if test='${SESSION_ATTR_USER_INFO!=null}'>
							<div class="login" id="login">
								<a id="merchant_login_button" style="cursor: pointer;" href="appLogOut"><img src="<c:url value='resources/images/marchent-logout.png'/>" border="0"></a>
							</div>
						</c:if>
						<div class="clr"></div>
					</div>
					<div class="clr"></div>
				</div>

				<div class="mid-header">
					<div class="logo">
						<a id="header_home_link" href="/index"><img src="<c:url value='resources/images/logo1.png'/>" /></a>
						<div class="clr"></div>
					</div>
					<div id="sliderFrame">
						<div id="ribbon">
							<img id="prev87" class="prev-button" src="<c:url value='resources/images/prev.png'/>" alt="Previous"> <img id="next87" class="next-button" src="<c:url value='/resources/images/next.png'/>" alt="Next">

						</div>
						<div class="slider" id="slider"></div>
					</div>
					<div class="clr"></div>
				</div>
				<div class="icon_menu" id="top_nav_buttons">
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
							<img src="<c:url value='resources/images/toogle.png'/>">
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
					<div class="moduletable dash_heading">
						<h4>
							<a style="cursor: pointer;" href="merchantDashboard">Merchant Dashboard</a>
						</h4>
						<div class="clear"></div>
					</div>
					<div class="moduletable">
						<h4>
							Manage Merchant Information
							<div class="fflip" id="f3" onclick="fflip(this.id)">
								<img src="<c:url value='resources/images/toogle1.png'/>">
							</div>
						</h4>
						<ul>
							<li><a href="myProfile" style="cursor: pointer;">Basic Information</a></li>
							<li><a href="purchaseLevel" style="cursor: pointer;">Billing Information</a></li>
							<li><a href="manageLocation" style="cursor: pointer;">Manage Locations</a></li>
							<li><a href="manageMedia" style="cursor: pointer;">Manage Media</a></li>
							<li><a href="manageGcdSubscription" style="cursor: pointer;">Manage Your Get City Dealz Subscription</a></li>
							<li><a href="manageEmailPwd" style="cursor: pointer;">Manage Email & Password</a></li>
						</ul>
						<div class="ppanelf3">
							<a href="myProfile" style="cursor: pointer;">Basic Information</a> <a href="purchaseLevel" style="cursor: pointer;">Billing Information</a> <a href="manageLocation" style="cursor: pointer;">Manage Locations</a> <a href="manageMedia" style="cursor: pointer;">Manage Media</a> <a
								onclick="openPage('manageGcdSubscription')" style="cursor: pointer;">Manage Your Get City Dealz Subscription</a> <a href="manageEmailPwd" style="cursor: pointer;">Manage Email & Password</a>
							<div class="clear"></div>
						</div>
						<div class="clear"></div>
					</div>
					<div class="custom-drive">
						<div class="moduletable">
							<h4>
								Manage Merchant Deals
								<div class="fflip" id="f4" onclick="fflip(this.id)">
									<img src="<c:url value='resources/images/toogle1.png'/>">
								</div>
							</h4>
							<ul>
								<li><a href="allHotDealz?dealType=1" style="cursor: pointer;">All Deals</a></li>
								<li><a href="postDealz?dealType=1" style="cursor: pointer;">Create New Deal</a></li>
								<li><a href="allHotDealz?dealType=2" style="cursor: pointer;">All Hot Deals</a></li>
								<li><a href="postDealz?dealType=2" style="cursor: pointer;">Buy a Hot Deal</a></li>
							</ul>
							<div class="ppanelf4">
								<a href="allHotDealz?dealType=1" style="cursor: pointer;">All Deals</a> <a href="postDealz?dealType=1" style="cursor: pointer;">Create New Deal</a> <a href="allHotDealz?dealType=2" style="cursor: pointer;">All Hot Deals</a> <a href="postDealz?dealType=2" style="cursor: pointer;">Buy a
									Hot Deal</a>
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="custom-drive">
						<div class="moduletable">
							<h4>
								Manage Blog
								<div class="fflip" id="f5" onclick="fflip(this.id)">
									<img src="<c:url value='resources/images/toogle1.png'/>">
								</div>
							</h4>
							<ul>
								<li><a href="loadAllPost" style="cursor: pointer;">All Posts</a></li>
								<li><a href="createPost" style="cursor: pointer;">Create New Post</a></li>
							</ul>
							<div class="ppanelf5">
								<a href="loadAllPost" style="cursor: pointer;">All Posts</a> <a href="createPost" style="cursor: pointer;">Create New Post</a>
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="custom-drive">
						<div class="moduletable">
							<h4>
								Manage Social Connections
								<div class="fflip" id="f6" onclick="fflip(this.id)">
									<img src="<c:url value='resources/images/toogle1.png'/>">
								</div>
							</h4>
							<ul>
								<li><a href="socialConnections" style="cursor: pointer;">Social Connections</a></li>
							</ul>
							<div class="ppanelf6">
								<a href="socialConnections" style="cursor: pointer;">Social Connections</a>
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
						</div>
					</div>
				</div>
				<!-- left end here -->

				<!-- mid start here -->
				<div class="merchantDetail">
					<div class="main-content">
						<div id="midContentDiv">
							<form:form id="socialConnectionForm" name="socialConnectionForm" class="formStyle">

							</form:form>
						</div>
						<div class="clr"></div>
					</div>
					<div class="clr"></div>
				</div>
				<!-- mid end here -->
			</div>
			<!-- right end here -->
			<!-- footer start -->
			<div class="bottom">
				<div class="footer-left">
					<ul>
						<li class="active"><a href="/index">Home</a></li>
						<li class=""><a href="http://gcddev.com/privacy-policy">Privacy Policy</a></li>
						<li class=""><a href="http://gcddev.com/contactus">Contact Us</a></li>
					</ul>
				</div>
				<div class="copyright">Copyright &copy; 2012-2014 Getcitydealz</div>
			</div>
			<!-- footer end -->
			<div class="clr"></div>
		</div>
		<div class="clr"></div>
	</div>
	<div id="login-box" class="login-popup">
		<a href="javascript:void(0);" class="close" id="fbClose"><img src="<c:url value='resources/images/cancel.png'/>" class="btn_close" title="Close Window" alt="Close" onclick="proceed();"></a>
		<h2>Choose Your Destination</h2>
		<div class="icon">
			<a href="javascript:void(0);" onclick="authPopup1();" class="fbClose"><img src="<c:url value='resources/images/fb.png'/>"></a><img src="<c:url value='resources/images/twitter.png'/>"> <br> <br>
		</div>
	</div>

	<div id="login-box1" class="login-popup1">
		<a href="javascript:void(0);" class="close fbClose"><img src="<c:url value='resources/images/cancel.png'/>" class="btn_close" title="Close Window" alt="Close"></a>
		<h2>Choose Your Destination</h2>
		<table width="100%" border="0" cellspacing="0" cellpadding="6">
			<tbody>
				<tr>
					<td><img src="<c:url value='resources/images/fb.png'/>"></td>
					<td><a href="https://www.facebook.com/dialog/oauth?client_id=174025642805043&amp;redirect_uri=http://neworleans.gcddev.com/merchantsocialcommunities;state=9834e76ac9a4cfbfca2befc0e1c94698&amp;scope=publish_stream%2Coffline_access%2Cmanage_pages"><span class="tab-sh">Connect to
								facebook</span></a></td>
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
$(function(){
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
		$("#slider").append(sliderImage);
	}
});
</script>
</html>