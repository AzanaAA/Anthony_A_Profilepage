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
<title>Add Book</title>
</head>
<body>

	<h1>Add a Book to Your Shelf!</h1>
	<div>
		<form:form action="/books" modelAttribute="book" method="post">
		
		    <div>
			 	<form:errors path="title"/>
				<form:label for="title" path="title">Title</form:label>
				<form:input type="text" path="title"/>
			</div>
			
			
			<div>
				<form:errors path="author"/>
				<form:label for="author" path="author">Author</form:label>
				<form:input type="text" path="author"/>
			</div>
			
			
			<div>
				<form:errors path="thoughts"/>
				<form:label for="thoughts" path="thoughts">My thoughts</form:label>
				<form:textarea path="thoughts"/>
			</div>
			
			<div>
				<form:errors path="user"/>
				<form:input type="hidden" path="user" value="${user.id}"/>
			</div>
			
			<div>
				<input type="submit" value="Submit"/>
			</div>
			
			</form:form>
			
	
	
	</div>
	
</body>
</html>