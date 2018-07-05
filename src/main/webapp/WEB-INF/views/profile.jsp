<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="taglib.jsp" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Profile</h2>

	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal" var="user"/>
		${user}
		<c:forEach items="${user.authorities}" var="role">
			${role }
		</c:forEach>
		
	</sec:authorize>

</body>
</html>