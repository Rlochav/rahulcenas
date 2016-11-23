<%@page import="com.app.getcitydealz.dto.HotDealBannerDTO"%>
<%@page import="com.app.getcitydealz.merchant.service.MerchantService"%>
<%@page import="com.app.common.dto.GcdMetaDTO"%>
<%@page import="org.springframework.util.CollectionUtils"%>
<%@page import="com.app.getcitydealz.service.GetCityDealz"%>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%
	ApplicationContext ctx = RequestContextUtils.getWebApplicationContext(request);
	GetCityDealz getCityDealz = (GetCityDealz) ctx.getBean("getCityDealz");

	GcdMetaDTO dto1 = getCityDealz.getMetaByType(1);
	GcdMetaDTO dto2 = getCityDealz.getMetaByType(2);
	GcdMetaDTO dto3 = getCityDealz.getMetaByType(3);

	MerchantService merchantService = (MerchantService) ctx.getBean("merchantService");
	HotDealBannerDTO bannerDTO = merchantService.getHotDealDetails(null);
%>
<script src="<c:url value='resources/js/jssor.js'/>"></script>
<script src="<c:url value='resources/js/jssor.slider.js'/>"></script>
<script src="<c:url value='resources/js/gcdSlider.js'/>"></script>
<link href="<c:url value='resources/css/gcdSliderCss.css'/>" rel="stylesheet" type="text/css" />
<div class="header">
	<div class="main-menu"></div>
	<div class="slider" id="hot_dealz_banner">
		<div class="moduletable">
			<!--Slide section start here -->
			<div id="sliderFrame">
				<div id="slider2_container" style="position: relative; top: 0px; left: 0px; width: 600px; height: 300px; overflow: hidden;">

					<!-- Loading Screen -->
					<div u="loading" style="position: absolute; top: 0px; left: 0px;">
						<div style="filter: alpha(opacity =                        70); opacity: 0.7; position: absolute; display: block; background-color: #000000; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
						<div style="position: absolute; display: block; background: url(../resources/images/loading.gif) no-repeat center center; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
					</div>

					<!-- Slides Container -->
					<div u="slides" style="cursor: move; position: absolute; left: 0px; top: 0px; width: 600px; height: 200px; overflow: hidden;">
						<%
							if (bannerDTO != null && !CollectionUtils.isEmpty(bannerDTO.getBannerDTOs())) {
								for (HotDealBannerDTO bannerDto : bannerDTO.getBannerDTOs()) {
						%>
						<div>
							<a href="<%=bannerDto.getUrl()%>"><img u="image" src="displayImage?image=<%=bannerDto.getImagePath()%>" alt="<%=bannerDto.getImageAlt()%>" title="<%=bannerDto.getImageAlt()%>" /> <img u="thumb" src="displayImage?image=<%=bannerDto.getImagePath()%>" /></a>
						</div>
						<%
							}
							}
						%>
					</div>
					<!-- Arrow Navigator Skin Begin -->
					<!-- Arrow Left -->
					<span u="arrowleft" class="jssora02l" style="width: 55px; height: 55px; top: 75px; left: 8px; display: block;"> </span>
					<!-- Arrow Right -->
					<span u="arrowright" class="jssora02r" style="width: 55px; height: 55px; top: 75px; right: 8px; display: block;"> </span>
					<!-- Arrow Navigator Skin End -->

					<!-- ThumbnailNavigator Skin Begin -->
					<div u="thumbnavigator" class="jssort03" style="position: absolute; width: 600px; height: 60px; left: 0px; bottom: 0px; display: none;">
						<div style="background-color: #000; filter: alpha(opacity =                         30); opacity: .3; width: 100%; height: 100%;"></div>

						<!-- Thumbnail Item Skin Begin -->

						<div u="slides" style="cursor: move;">
							<div u="prototype" class="p" style="POSITION: absolute; WIDTH: 62px; HEIGHT: 32px; TOP: 0; LEFT: 0;">
								<div class=w>
									<div u="thumbnailtemplate" style="WIDTH: 100%; HEIGHT: 100%; border: none; position: absolute; TOP: 0; LEFT: 0;"></div>
								</div>
								<div class=c style="POSITION: absolute; BACKGROUND-COLOR: #000; TOP: 0; LEFT: 0"></div>
							</div>
						</div>
						<!-- Thumbnail Item Skin End -->
					</div>
					<!-- ThumbnailNavigator Skin End -->
					<!-- <a style="display: none" href="http://www.jssor.com">javascript</a> -->
				</div>
			</div>
			<!-- Slide section end here-->
		</div>
	</div>
	<div class="social">
		<div class="moduletable">
			<div class="custom">
				<div id="gcd_soc_media_buttons">
					<p>
						<%-- <a id="gcd_sm_fb" href="http://www.facebook.com/GetCityDealz" target="_blank"><img src="<c:url value='resources/images/facebook.png'/>" border="0" alt="facebook" title="facebook"></a> <a id="gcd_sm_twitter" href="http://www.twitter.com/GetCityDealz" target="_blank"><img
							src="<c:url value='resources/images/twitter.png'/>" border="0" alt="twitter" title="twitter"></a> <a id="gcd_sm_pinterest" href="http://www.pinterest.com/getcitydealz" target="_blank"><img src="<c:url value='resources/images/pintrest.png'/>" border="0" alt="pintrest" title="pintrest"></a>
						<a id="gcd_sm_gplus" href="http://google.com/+Getcitydealz1" target="_blank" rel="publisher"><img src="<c:url value='resources/images/gplush.png'/>" border="0" alt="Google Plus" title="Google Plus"></a> <a id="gcd_sm_youtube" href="http://www.youtube.com/user/GetCityDealz"
							target="_blank"><img src="<c:url value='resources/images/youtube.png'/>" border="0" alt="youtube" title="youtube"></a> --%>
						<%
							if (dto1 != null && !CollectionUtils.isEmpty(dto1.getGcdMetaDTOs())) {
								for (GcdMetaDTO g : dto1.getGcdMetaDTOs()) {
									String img = null;
									if (g.getImagePath() != null) {
										img = g.getImagePath().replace(".", "_do_custom_separator_");
									}
									if (g.getShowOnPage().equals("Yes")) {
						%>
						<a href="<%=g.getUrl()%>" target="_blank"><img src="displayImage1/<%=img%>?docType=12" border="0" alt="<%=g.getImageAlt()%>" title="<%=g.getImageAlt()%>" width="30" height="30" /></a>
						<%
							}
								}
							}
						%>
					</p>
				</div>
			</div>
		</div>
	</div>
	<a class="welcome-link" id="header_home_link" href="index">Home</a>
	<c:if test='${SESSION_ATTR_USER_INFO==null}'>
		<div class="mlogin">
			<div class="moduletable">
				<div id="merchant_login_button">
					<a href="merchant-login-city"><img src="<c:url value='resources/images/marchent-login.png'/>" border="0"></a>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test='${SESSION_ATTR_USER_INFO!=null}'>
		<div class="mlogin">
			<div class="moduletable">
				<div id="merchant_login_button">
					<a href="appLogOut"><img src="<c:url value='resources/images/marchent-logout.png'/>" border="0"></a>
				</div>
			</div>
		</div>
	</c:if>
	<div class="icon-menu">
		<div class="moduletable">


			<div class="custom">
				<div id="top_nav_buttons">
					<%-- <a id="tnb_dining" href="${subdomainUrl}/dealsbymaincategory/dining"><img src="<c:url value='resources/images/DINING.png'/>" border="0" alt="DINING" title="DINING"></a> <a id="tnb_nightlife" href="${subdomainUrl}/dealsbymaincategory/night-life"><img
						src="<c:url value='resources/images/NIGHTLIFE.png'/>" border="0" alt="NIGHTLIFE" title="NIGHTLIFE"> </a> <a id="tnb_shopping" href="${subdomainUrl}/dealsbymaincategory/shopping"> <img src="<c:url value='resources/images/SHOPPING.png'/>" border="0" alt="SHOPPING" title="SHOPPING"></a> <a
						id="tnb_attractions" href="${subdomainUrl}/dealsbymaincategory/attractions"> <img src="<c:url value='resources/images/ATTRACTIONS.png'/>" border="0" alt="ATTRACTIONS" title="ATTRACTIONS"></a> <a id="tnb_services" href="${subdomainUrl}/dealsbymaincategory/services"> <img
						src="<c:url value='resources/images/SERVICES.png'/>" border="0" alt="SERVICES" title="SERVICES"></a> <a id="tnb_recreation" href="${subdomainUrl}/dealsbymaincategory/recreation"> <img src="<c:url value='resources/images/RECREATION.png'/>" border="0" alt="RECREATION" title="RECREATION"></a> --%>
					<%
						if (dto2 != null && !CollectionUtils.isEmpty(dto2.getGcdMetaDTOs())) {
							for (GcdMetaDTO g : dto2.getGcdMetaDTOs()) {
								String img = null;
								if (g.getImagePath() != null) {
									img = g.getImagePath().replace(".", "_do_custom_separator_");
								}
								if (g.getShowOnPage().equals("Yes")) {
					%>
					<a id="<%=g.getElementId()%>" class="<%=g.getElementClass()%>" href="${subdomainUrl}/<%=g.getUrl()%>"><img src="displayImage1/<%=img%>?docType=12" border="0" alt="<%=g.getImageAlt()%>" title="<%=g.getImageAlt()%>"></a>
					<%
						}
							}
						}
					%>
				</div>
			</div>
		</div>
	</div>
	<br>
</div>