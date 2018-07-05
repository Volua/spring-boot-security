<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

	<h1>Login page</h1>
	<c:if test="${param.fail}">
		<p style="color: red;">
			Fail to authorize
		</p>
	</c:if>

	<form:form id ="login" modelAttribute="userModel">
		<label for="focusedInput">E-mail address</label>
		<form:input path="email" title="E-mail address" />
		<label for="focusedInput">Password</label>
		<form:password path="password" title="Password" />
		<input type="submit" id ="submit" value = "Press"/>
	</form:form>



<script>
	$("#submit").click(function(){
		console.log("inside");
		$.post('/login', $('#login').serialize());

	})
</script>

</body>
</html>
