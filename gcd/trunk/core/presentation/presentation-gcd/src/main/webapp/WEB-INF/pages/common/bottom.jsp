<%@page import="com.app.common.dto.GcdMetaDTO"%>
<div class="bottom">
	<div class="main-menu">
		<div class="moduletable">

			<ul class="menu" id="gcd_footer">
				<!-- <li class="item-121"><a href="http://gcddev.com/index">Home</a></li>
				<li class="item-132"><a href="http://gcddev.com/privacy-policy">Privacy Policy</a></li>
				<li class="item-134"><a href="http://gcddev.com/contactus">Contact Us</a></li> -->
				<%
					if (dto3 != null && !CollectionUtils.isEmpty(dto3.getGcdMetaDTOs())) {
						for (GcdMetaDTO g : dto3.getGcdMetaDTOs()) {
							if (g.getShowOnPage().equals("Yes")) {
				%>
				<li class="item-121"><a href="<%=g.getUrl()%>"><%=g.getImageAlt()%></a></li>
				<%
					}
						}
					}
				%>
			</ul>
		</div>
	</div>

	<div class="copy">
		<div class="moduletable">
			<div class="custom">
				<p style="margin: -3px 0 0 0px;">Copyright &copy; 2012-2015 Getcitydealz<p>
				<p><a href="http://alexaglobalsofttech.com" style="color: white;">Site Technology Developed by AlexaGlobalSoft</a><p>				
			</div>
		</div>
	</div>
</div>