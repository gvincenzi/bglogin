<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="true"%>
<html>
<head>
	<title><spring:message code="login.page.title"/></title>
	<spring:url value="/resources/css/login.css" var="loginCss" />
	<link href="${loginCss}" rel="stylesheet" />
	
	<spring:url value="/resources/images/logo.png" var="logo" />
</head>

<body onload='document.loginForm.username.focus();'>
	<div id="divLogo"><img alt="Logo" src="${logo}"/> <h4><spring:message code="${welcomeMessage}"/></h4></div>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			${pageContext.request.userPrincipal.name}
		</h2>
		<h3>
			<a href="<c:url value="/logout" />"> <spring:message code="login.btn.logout"/></a>
		</h3>
	</c:if>
	
</body>
</html>