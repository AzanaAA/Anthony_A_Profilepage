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

	<h1>Book Club</h1>
	<div>
		<p>A place for fiends to share thoughts on books.</p>
	</div>
	
	<h2>Register</h2>
	<div>
		<form:form action="/register" modelAttribute="newUser">
			<div>
			 	<form:errors path="userName"/>
				<form:label for="userName" path="userName">Name</form:label>
				<form:input type="text" path="userName" />
			</div>
			
			<div>
				<form:errors path="email"/>
				<form:label for="email" path="email">Email:</form:label>
				<form:input type="text" path="email"/>
			</div>
			
			<div>
				<form:errors path="password"/>
				<form:label for="password" path="password">Password:</form:label>
				<form:input type="password" path="password"/>
			</div>
			
			<div>
				<form:errors path="confirm"/>
				<form:label for="confirm" path="confirm">Confirm PW:</form:label>
				<form:input type="password" path="confirm"/>
			</div>
			
			<div>
				<input type="submit" value="Submit"/>
			</div>
			
		</form:form>
	</div>
	
	<div>
		<form:form action="/login" modelAttribute="newLogin">
			<div>
				<form:errors path="email"/>
				<form:label for="email" path="email">Email:</form:label>
				<form:input type="text" path="email"/>
			</div>
			
			<div>
				<form:errors path="password"/>
				<form:label for="password" path="password">Password:</form:label>
				<form:input type="password" path="password"/>
			</div>
			
			<div>
				<input type="submit" value="Submit"/>
			</div>
		
		</form:form>
	</div>
	

</body>
</html>