<%@include file="common/taglibs.jsp"%>
<html>
<head>
<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<script src="<c:url value='resources/js/main.js'/>"></script>
<script type="text/javascript" src="<c:url value='resources/js/CommonFunction.js'/>"></script>

<link href="<c:url value='resources/css/main.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='resources/css/media.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='resources/css/screens.css'/>" rel="stylesheet" type="text/css" />
</head>
<body>

</body>
<script type="text/javascript">
	$(function() {
		if ('<c:out value="${SESSION_ATTR_USER_INFO.userIndex}"/>'.length > 0)
			window.location.href = "merchantHome";
		if ('<c:out value="${SESSION_ATTR_USER_INFO.userIndex}"/>'.length == 0)
			window.location.href = "dev";
	})
</script>
</html>