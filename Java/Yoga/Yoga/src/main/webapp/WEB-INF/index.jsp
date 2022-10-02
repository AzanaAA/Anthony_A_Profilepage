<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Welcome</h1>
		<form:form action="/register" method="POST" modelAttribute="newUser">
		<div>
	</div>
	<div>
		<h2>Register</h2>
	</div>
	<div>
		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<form:errors path="name" />
	</div>
	<div>
		<form:label path="email">Email</form:label>
		<form:input path="email" />
		<form:errors path="email" />
	</div>
	<div>
		<form:label path="password">Password</form:label>
		<form:input path="password" type="password" />
		<form:errors path="password" />
	</div>
	<div>
		<form:label path="confirm">Confirm Password</form:label>
		<form:input path="confirm" type="password" />
		<form:errors path="confirm" />
	</div>
	<button>Register!</button>
	</form:form>

	<div>
		<form:form action="/login" method="POST" modelAttribute="newLogin">
		<h1>LogIn</h1>
		<div>
			<form:label path="email">Email</form:label>
			<form:input path="email" />
			<form:errors path="email" />
		</div>
		<div>
			<form:label path="password">Password</form:label>
			<form:input path="password" type="password" />
			<form:errors path="password" />
		</div>
		<button>Log In</button>
	
		
		</form:form>
	</div>

</body>
</html>