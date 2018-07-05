<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>

	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.username" var="user"/>
		User: ${user}
		
		<form:form action="/logout" method="POST">
			<input type="submit" value="Logout">
		</form:form>
		
		<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
			<a href="/profile">Profile</a>
		</sec:authorize>
		
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<a href="/dashboard">Dashboard</a>
		</sec:authorize>
	</sec:authorize>

	<sec:authorize access="!isAuthenticated()">
		<h2>
			Show login: <a href="/login">Login</a>
		</h2>
	</sec:authorize>
</body>
</html>