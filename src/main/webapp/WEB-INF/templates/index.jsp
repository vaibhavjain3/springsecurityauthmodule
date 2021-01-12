<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" xmlns:th="https://www.thymeleaf.org">
	<head>
		<title>Welcome Page</title>
	</head>
	<body>
		<h1>Welcome to Spring Security Auth Module</h1>
		<a href="<c:url value="/confirmLogout" />">Logout</a>
	</body>
</html> 