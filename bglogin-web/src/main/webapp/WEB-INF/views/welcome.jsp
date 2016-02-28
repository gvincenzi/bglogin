<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<h1>${welcomeMessage}</h1>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Connected username : ${pageContext.request.userPrincipal.name}
		</h2>
		<h3>
			<a href="<c:url value="/logout" />"> Logout</a>
		</h3>
	</c:if>
	
</body>
</html>