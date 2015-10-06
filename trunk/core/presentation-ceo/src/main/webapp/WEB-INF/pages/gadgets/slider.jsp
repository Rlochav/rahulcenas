<%@include file="../common/taglibs.jsp"%>
<div class="slider">
	<ul class="bxslider">
		<li><img src="<c:url value='static/images/slide1.jpg'/>" title="Shopping" /></li>
		<li><img src="<c:url value='static/images/slide2.jpg'/>" title="News" /></li>
		<li><img src="<c:url value='static/images/slide3.jpg'/>" title="Jobs" /></li>
		<li><img src="<c:url value='static/images/slide4.jpg'/>" title="Freelance Jobs" /></li>
	</ul>

	<div id="bx-pager">
		<a data-slide-index="0" href=""><img src="<c:url value='static/images/thumb1.jpg'/>" /></a> <a
			data-slide-index="1" href=""><img src="<c:url value='static/images/thumb2.jpg'/>" /></a> <a
			data-slide-index="2" href=""><img src="<c:url value='static/images/thumb3.jpg'/>" /></a> <a
			data-slide-index="3" href=""><img src="<c:url value='static/images/thumb4.jpg'/>" /></a>
	</div>
</div>