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
<title>Book</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.userName}"/></h1>
	
	<div>
		<h2>Books from everyone shelves:</h2>
		<a href="/logout">logout</a>
		<a href="/books/new">+ Add to my shelf</a>
		<a href="/home">Home</a>
	</div>
	
	<div>
		<span><c:out value="${book.user.userName}"/></span> read 
			<span><c:out value="${book.title}"/></span> by 
			<span><c:out value="${book.author}"/></span>
	</div>
	
	<div>
		<h4>Here are their thoughts:</h4>
		<p><c:out value="${book.thoughts}"/></p>
	</div>
	
	

</body>
</html>