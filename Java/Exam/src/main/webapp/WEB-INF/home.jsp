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
<title>Home</title>
</head>
<body>
	<h1>Welcome, ${user.userName}</h1>
	<p><a href="/logout">Log Out</a></p>
	<p><a href="/listings/new">Add Listing</a></p>
	<table>
    <thead> 
    	<tr>
    		<th>Address</th>
    		<th>Listed On</th>
    		<th>Added By</th>
    		<th>Price</th>
    	</tr>
    </thead>
    
	</table>
	
	

</body>
</html>