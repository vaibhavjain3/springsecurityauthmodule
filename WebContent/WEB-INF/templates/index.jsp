<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" xmlns:th="https://www.thymeleaf.org">
<head>
<title>Welcome Page</title>
</head>
<body>
	<h1>Welcome to Spring Security Auth Module</h1>
	<c:url value="/logout" var="logoutUrl" />
	<form onsubmit="return confirm('Are you sure you want to logout?')" method="post" action="${logoutUrl}">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button type="submit" value="Logout">Log Out</button>
	</form>
</body>
</html>