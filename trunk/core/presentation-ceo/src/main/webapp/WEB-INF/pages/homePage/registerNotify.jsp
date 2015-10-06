<%@include file="../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ceo Stocks</title>
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet" href="<c:url value="static/css/style.css" />" />
<script src="<c:url value="static/js/jquery-1.11.3.min.js" />"></script>
<script src="<c:url value="static/js/script.js" />"></script>


<script src="<c:url value="static/js/jssor.js" />"></script>
<script src="<c:url value="static/js/jssor.slider.js" />"></script>

<link rel="stylesheet" href="<c:url value="static/css/datepicker.css" />" />
<script src="<c:url value="static/js/bootstrap-datepicker.js" />"></script>
</head>
<body>
	<!--Logo and Menu-->
	<div class="sub_header_wrapper">
		<%-- <jsp:include page="../common/sub-header.jsp" /> --%>
	</div>
	<section id="main-section">
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<spring:message code="${message}" text="some thing went wrong. please go beck."></spring:message>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	</section>
	<footer class="footer">
	<div class="grid-container"></div>
	</footer>
</body>
</html>