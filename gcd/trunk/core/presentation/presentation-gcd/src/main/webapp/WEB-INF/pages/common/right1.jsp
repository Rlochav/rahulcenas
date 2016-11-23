<%@page import="com.app.common.dto.GcdMetaDTO"%>
<%@page import="org.springframework.util.CollectionUtils"%>
<div class="right">
	<%
		GcdMetaDTO gcdMetaDTO = getCityDealz.getListOfRightHandRails();
		if (!CollectionUtils.isEmpty(gcdMetaDTO.getGcdMetaDTOs())) {
			for (GcdMetaDTO gmd : gcdMetaDTO.getGcdMetaDTOs()) {
				if (gmd.getShowOnPage().equals("Yes")) {
	%>
	<div class="moduletable-deli">
		<h3><%=gmd.getPageTitle()%></h3>


		<div class="custom-deli">
			<%=gmd.getPageText()%>
		</div>
	</div>
	<%
		}
			}
		}
	%>
	<%-- <div class="moduletable-drive">
		<h3>Drive Foot Traffic</h3>


		<div class="custom-drive">
			<p style="text-align: center;">
				<a id="round_bam" href="../become-a-merchant" title="Become a Merchant"><img src="<c:url value='/resources/images/become-a-merchant.png'/>" border="0" width="160" style="border: 0; vertical-align: middle;"></a>
			</p>
			<p style="text-align: center;">
				<strong>&bull;&nbsp;</strong><strong>Bring in the Locals&nbsp;</strong><strong>&bull;</strong>
			</p>
			<p style="text-align: center;">
				<strong>&bull;&nbsp;</strong><strong>Draw in the Tourists&nbsp;</strong><strong>&bull;</strong>
			</p>
			<p style="text-align: center;">
				<strong>&bull;&nbsp;</strong><strong>Control Your Marketing&nbsp;</strong><strong>&bull;</strong>
			</p>
			<p style="text-align: center;">
				<strong>&bull;&nbsp;</strong><strong>Connect With Fans&nbsp;</strong><strong>&bull;</strong>
			</p>
			<p style="text-align: center;">
				<strong>&bull;&nbsp;</strong><strong>All On Your Schedule!&nbsp;</strong><strong>&bull;</strong>
			</p>
			<p style="text-align: center;">
				<a id="rectangle_bam" href="../become-a-merchant" target="_blank" title="Become a Merchant"><img src="<c:url value='/resources/images/start-dealz-now.png'/>" border="0" alt="Start Your Dealz Today!"
					title="Start Your Dealz Today!" width="163" height="32" style="border: 0;"></a>
			</p>
		</div>
	</div>
	<div class="moduletable-deli">
		<h3>Deals Delivered Free!</h3>


		<div class="custom-deli">
			<p style="text-align: center;">
				<a id="dd_email" href="../getdeals-city?q=email"><img src="<c:url value='/resources/images/email-24x24.png'/>" border="0" alt="Delivered By Email" title="Delivered By Email"
					style="border-style: initial; border-color: initial;"></a>&nbsp; &nbsp;&nbsp;<a id="dd_fb" href="http://www.facebook.com/GetCityDealz" target="_blank"><img
					src="<c:url value='/resources/images/facebook-24x24.png'/>" border="0" alt="Delivered on Facebook" title="Delivered on Facebook" style="border-style: initial; border-color: initial;"></a>&nbsp; &nbsp; <a
					id="dd_twitter" href="http://www.twitter.com/GetCityDealz" target="_blank"><img src="<c:url value='/resources/images/twitter-24x24.png'/>" border="0" alt="Delivered on Twitter"
					title="Delivered on Twitter" style="border-style: initial; border-color: initial;"></a>
			</p>
		</div>
	</div>
	<div class="moduletable-deli">
		<h3>Like Us on Facebook</h3>


		<div class="custom-deli">
			<p style="text-align: center;">
				<a id="lu_fb_button" href="http://www.facebook.com/GetCityDealz" target="_blank"><img src="<c:url value='/resources/images/fb-like-button.png'/>" border="0" alt="Like Get City Dealz on Facebook" width="75" height="75"
					style="border: 0; vertical-align: text-top;"></a>
			</p>
			<p style="text-align: center;">
				<a id="lu_fb_link" href="http://www.facebook.com/GetCityDealz" target="_blank">Like Us on&nbsp;Facebook&nbsp;&amp;&nbsp;Get Our Deals in Your News Feed</a>
			</p>
			<h3 id="accomplishments">
				<strong>Accomplishments</strong>
			</h3>
			<p>
				<span style="line-height: 1.3em;">&nbsp;</span><strong><img src="<c:url value='/resources/images/SNCR-excellence-winner.gif'/>" border="0" alt="Get City Dealz SNCR Excellence Winner"
					width="120" height="120" style="display: block; margin-left: auto; margin-right: auto;"></strong>
			</p>
			<p>
				<strong style="color: #135cae; font-family: Helvetica, Arial, sans-serif; font-size: 13px; line-height: 1.3em;">&nbsp;</strong><strong><img
					src="<c:url value='/resources/images/US-Search-Winner-Small.jpg'/>" border="0" alt="Get City Dealz US Search Awards Winner" width="150"
					style="border: 0px; display: block; margin-left: auto; margin-right: auto;"></strong>
			</p>
			<h3>
				<strong>Member</strong>
			</h3>
			<p style="text-align: -webkit-auto;">
				<em><img src="<c:url value='/resources/images/nola-chamber.png'/>" border="0" alt="Member of New Orleans Chamber of Commerce" width="150" height="119"
					style="vertical-align: middle; border-style: initial; border-color: initial; border-image: initial; display: block; margin-left: auto; margin-right: auto; border-width: 0px;"></em>
			</p>
			<p style="text-align: center;">
				&nbsp;<img src="<c:url value='/resources/images/nola-cvb.png'/>" border="0" width="150" height="76" style="vertical-align: middle; border: 0;">
			</p>
			<p style="text-align: center;">
				&nbsp;<img src="<c:url value='/resources/images/jefferson-parish-chamber.png'/>" border="0" alt="Jefferson Parish Chamber Member" width="150" style="border: 0;">
			</p>
		</div>
	</div>
	<div class="moduletable-deli">
		<h3>Testimonials</h3>


		<div class="custom-deli">
			<p style="text-align: left;">
				<em>"...this is definitely a unique way to reach current&nbsp;and potential pet owners." </em>&nbsp;-Anthony M.
			</p>
			<p>
				".<em>..GCD is an&nbsp;easy-touse,&nbsp;cost-effective alternative marketing method.</em>" -Scott V.
			</p>
			<p>
				"...<em>we like the ability to have control over and input our own&nbsp;offers and specials that GCD gives us!</em>" - Nannette G.
			</p>
			<p>
				"<em>I like the concept of putting out our own offers and announcements at any time, any day, any week- all&nbsp;year long. &nbsp; This is so much better than having plain directory listings,
					whether in print or on the Internet. &nbsp;The price is right too- the cost of a 1/3 page ad in our local magazine allows us to use your&nbsp;marketing program all year long.</em>" &nbsp;-Adam O
			</p>
		</div>
	</div> --%>
</div>