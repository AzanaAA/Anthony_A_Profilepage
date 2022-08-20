<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruity Loops</title>
</head>
<body>

	

	
	<h1>Fruit Store</h1>
	<div>
	<p>Name</p>
	<p>Price</p>
	<c:forEach var="fruit" items="${fruits}">
	<p>${fruit.name}</p>
	<p>${fruit.price}</p>
	</c:forEach>
	</div>
</body>
</html>