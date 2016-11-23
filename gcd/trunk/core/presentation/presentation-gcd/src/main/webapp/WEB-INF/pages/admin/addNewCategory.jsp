<%@include file="../common/taglibs.jsp"%>
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
<link href="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/css/alert.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/themes/light/theme.css'/>" rel="stylesheet" />
<script src="<c:url value='/resources/Stylish-jQuery-Notification-Alert-Plugin-Smart-Alert/alert/js/alert.js'/>"></script>
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
							<li><a href="http://www.facebook.com/GetCityDealz" target="_blank"><img src="<c:url value='/resources/images/facebook.png'/>" width="auto" border="0" alt="facebook" title="facebook"></a></li>
							<li><a href="http://www.twitter.com/GetCityDealz" target="_blank"><img src="<c:url value='/resources/images/twitter.png'/>" border="0" alt="twitter" title="twitter"></a></li>
							<li><a href="http://www.pinterest.com/getcitydealz" target="_blank"> <img src="<c:url value='/resources/images/pintrest.png'/>" border="0" alt="pintrest" title="pintrest"></a></li>
							<li><a href="https://plus.google.com/113127686225602648376" target="_blank"> <img src="<c:url value='/resources/images/gplush.png'/>" border="0" alt="Google Plus" title="Google Plus"></a></li>
							<li><a href="http://www.youtube.com/user/GetCityDealz" target="_blank"> <img src="<c:url value='/resources/images/youtube.png'/>" border="0" alt="youtube" title="youtube"></a></li>
							<div class="clr"></div>
						</ul>
						<div class="clr"></div>

					</div>

					<div class="logo">
						<a href="../index"><img src="<c:url value='/resources/images/logo1.png'/>" /></a>
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
				<div class="icon_menu">
					<ul>
						<li><a href="../dealsbymaincategory/dining"><img src="<c:url value='/resources/images/DINING.png'/>" /> </a></li>
						<li><a href="../dealsbymaincategory/night-life"><img src="<c:url value='/resources/images/NIGHTLIFE.png'/>" /></a></li>
						<li><a href="../dealsbymaincategory/shopping"><img src="<c:url value='/resources/images/SHOPPING.png'/>" /> </a></li>
						<li><a href="../dealsbymaincategory/attractions"><img src="<c:url value='/resources/images/ATTRACTIONS.png'/>" /></a></li>
						<li><a href="../dealsbymaincategory/services"><img src="<c:url value='/resources/images/SERVICES.png'/>" /></a></li>
						<li class="last"><a href="../dealsbymaincategory/recreation"><img src="<c:url value='/resources/images/RECREATION.png'/>" /></a></li>
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
							<div id="title">Get City Dealz Admin Dashboard</div>
							<div id="menu">
								<div class="menu-new">
									<div style="float: right; padding: 2px 35px;">
										<img src="<c:url value='/resources/images/blue-arrow.png'/>" style="width: 4px; height: 9px; padding: 0px 7px; margin: -1px;"> <a style="color: #046604; cursor: pointer;" href="adminDashboard"> Return to Main Dashboard </a><img src="<c:url value='/resources/images/blue-arrow.png'/>"
											style="width: 4px; height: 9px; padding: 0px 7px; margin: -1px;"> <a style="color: #046604; cursor: pointer;" href="categories"> Return to All Categories </a>
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
									<form:form method="post" name="categoryForm" action="saveCategoryDetails" modelAttribute="categoryForm">
										<div class="profile">
											<table cellspacing="0" cellpadding="0" style="width: 70%;" class="tableStyle custom_td">
												<tbody>
													<tr>
														<td><label>Category Name<span class="star">&nbsp;*</span></label></td>
														<td><input type="hidden" style="display: none;" name="categoryId" id="categoryId" /> <input type="text" name="categoryName" id="categoryName" value="" class="mInput" size="40"></td>
														<td class="button2"><input type="submit" class="mediumBtn" value="Add New" /></td>
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
						<div class="footer-left">
							<ul>
								<li class="active"><a id="gcd_footer_home" href="../index">Home</a></li>
								<li class=""><a id="gcd_footer_privacy_policy" href="http://gcddev.com/privacy-policy">Privacy Policy</a></li>
								<li class=""><a id="gcd_footer_contact" href="http://gcddev.com/contactus">Contact Us</a></li>
							</ul>
						</div>
						<div class="copyright">Copyright © 2012-2014 Getcitydealz</div>
					</div>
					<!-- footer end -->
				</div>
			</div>
			<div class="clr"></div>
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
	
		
		if ('<c:out value="${message}"/>'.length > 0) {
			$.alert.open('error', '<c:out value="${message}"/>');
		}
	});
</script>
</html>
