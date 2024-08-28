<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html>
<head>
	<title></title>
</head>
<body>
<f:view beforePhase="#{PremiaMenuToolbar.firstLevel}">
		<f:subview id="menu">
				<jsp:include page="/jsf/jsp/menu.jsp" />
		</f:subview>
</f:view>
</body>	
</html>  
