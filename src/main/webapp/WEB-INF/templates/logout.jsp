<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Logout</title>
</head>
<body>
	<form class="form-signin" method="post" action="<c:url value="/logout"/>">
		<h3>Are you sure you want to log out?</h3>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<button type="submit" value="Logout">Log Out</button>
	</form>
</body>
</html>