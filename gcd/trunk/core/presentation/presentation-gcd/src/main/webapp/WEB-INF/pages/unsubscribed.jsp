<%@include file="common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thank You</title>
<script type="text/javascript" src="<c:url value='../resources/js/jquery-2.0.3.js'/>"></script>
</head>
<body>
	<div align="center">
		<strong>Thank You.</strong> <br /> <span style="font-family: cursive">You have successfully unsubscribe you'll redirect to login page soon...</span>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		setTimeout(function(){window.location.href = "../index"},3000);
	});
</script>
</html>