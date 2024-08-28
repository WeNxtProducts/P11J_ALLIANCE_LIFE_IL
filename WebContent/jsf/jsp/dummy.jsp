<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<link href="resources/css/premia_life.css" rel="stylesheet"
	type="text/css">
</head>
<fmt:bundle basename="login">
<script type="text/javascript">
function fullscreen(){
	window.opener = self;
	window.open('jsf/jsp/login.jsf','','<fmt:message key="pel_window_property"/>'); 
	window.close();
}
</script>
</fmt:bundle>
<body onload='fullscreen()'>
</body>
</html>