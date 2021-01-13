<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" xmlns:th="https://www.thymeleaf.org">
<head>
<title>Login</title>
</head>
<body>
	<c:url value="/login" var="loginUrl" />
	<form action="${loginUrl}" method="post">
		<c:if test="${param.error != null}">
			<p>Invalid Username or Password</p>
		</c:if>
		<c:if test="${param.logout != null}">
			<p>You have been logged out.</p>
		</c:if>
		<p>
			<label for="username">Username</label> 
			<input type="text" id="username" name="username" />
		</p>
		<p>
			<label for="password">Password</label> 
			<input type="password" id="password" name="password" />
		</p>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button type="submit" class="btn">Log in</button>
	</form>
</body>
</html>