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
<title>House Hunter</title>
</head>
<body>
	<h1>Welcome, House Hunter!</h1>
	<form:form action="/register" method="post" modelAttribute="newUser">
	<table>
		<thead>
	    	<tr>
	            <td><h3>Register</h3></td>
	        </tr>
	    </thead>
	    <thead>
	    	<tr>
	            <td>User Name:</td>
	            <td>
	            	<form:errors path="userName"/>
					<form:input type="input" path="userName"/>
	            </td>
	        </tr>
	        <tr>
	            <td>Email:</td>
	            <td>
	            	<form:errors path="email"/>
					<form:input type="input" path="email"/>
	            </td>
	        </tr>
	        <tr>
	            <td>Password:</td>
	            <td>
	            	<form:errors path="password"/>
					<form:input type="password" path="password"/>
	            </td>
	        </tr>
	        <tr>
	            <td>Confirm PW:</td>
	            <td>
	            	<form:errors path="confirm"/>
					<form:input type="password" path="confirm"/>
	            </td>
	        </tr>
	        <tr>
	        	<td><input type="submit" value="Submit"/></td>
	        </tr>
	    </thead>
	</table>
	</form:form>
	<div>
		<form:form action="/login" method="post" modelAttribute="newLogin">
		<table>
		<thead>
	    	<tr>
	            <td><h3>Log In</h3></td>
	        </tr>
	    </thead>
	    <thead>
	        <tr>
	            <td>Email:</td>
	            <td>
	            	<form:errors path="email"/>
					<form:input type="input" path="email"/>
	            </td>
	        </tr>
	        <tr>
	            <td>Password:</td>
	            <td>
	            	<form:errors path="password"/>
					<form:input type="password" path="password"/>
	            </td>
	        </tr>
	        <tr>
	        	<td><input type="submit" value="Submit"/></td>
	        </tr>
	    </thead>
		</table>
		</form:form>
	</div>

</body>
</html>