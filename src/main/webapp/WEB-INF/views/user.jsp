<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User page</title>
</head>
<body>
	<h2>User page</h2>

	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal" var="user" />
		
		<ul>
		    <li>Hi, ${user.fullName}!</li>
		</ul>
		

	</sec:authorize>
</body>
</html>