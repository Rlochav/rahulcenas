<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<c:url value='resources/js/jquery-2.0.3.js'/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="checkSupportBrowserForm" action="index" method="POST"></form>
</body>
<script type="text/javascript">
	$(function() {
		if ('<c:out value="${SESSION_ATTR_USER_INFO.userIndex}"/>'.length > 0 && '<c:out value="${SESSION_ATTR_USER_INFO.userType}"/>'.length == 0)
			window.location.href = "merchantHome";
		if ('<c:out value="${SESSION_ATTR_USER_INFO.userIndex}"/>'.length > 0 && '<c:out value="${SESSION_ATTR_USER_INFO.userType}"/>'.length != 0
				&& '<c:out value="${SESSION_ATTR_USER_INFO.userType}"/>' == '1002')
			window.location.href = "component/adminDashboard";
		if ('<c:out value="${SESSION_ATTR_USER_INFO.userIndex}"/>'.length == 0)
			window.location.href = "index";
	});
</script>
</html>