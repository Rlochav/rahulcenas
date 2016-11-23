<%@include file="../common/taglibs.jsp"%>
<html>
<head>
<link href="<c:url value='resources/css/screens.css'/>" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/main.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='resources/css/screens.css'/>">
<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<script type="text/javascript" src="<c:url value='resources/js/CommonFunction.js'/>"></script>
</head>
<body>
	<div id="toPopup">
		<div class="close"></div>
		<span class="ecs_tooltip">Press Esc to close <span class="arrow"></span></span>
		<div id="popup_content">
			<!--your content start-->
			<p>netus et malesuada fames ac turpis egestas.</p>
			<p align="center">
				<a href="#" class="livebox">Click Here Trigger</a>
			</p>
		</div>
		<!--your content end-->
	</div>
	<!--toPopup end-->
	<div class="loader"></div>
	<div id="backgroundPopup"></div>
</body>
</html>