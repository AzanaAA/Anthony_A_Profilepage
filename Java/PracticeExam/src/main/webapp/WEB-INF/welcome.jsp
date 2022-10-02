<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h3>Welcome, <c:out value="${user.userName}"></c:out>!</h3>
	<p>Welcome, ${user.userName}</p>
	<p><a href="/logout">logout</a></p>
	<p><a href="/listings/new">New Listing</a></p>
	
	
	<table>
    <thead> 
    	<tr>
    		<th>Address</th>
    		<th>Price</th>
    		<th>Poster</th>
    		<th>Edit</th>
    	</tr>
    </thead>
</table>
	
	
	
	
	
	
	
	
		<table>
			<thead>
			<tbody>
					<c:forEach var="listing" items="${listings}">
				<tr>
				
				<td><a href="listings/${listing.id }"><c:out value="${listing.address }" /></a></td>
				<td><c:out value="${listing.price }" /></td>
				<td><c:out value="${listing.user.userName }" /></td>
				<c:if test = "${listing.user.id==user.id}">
				<td><a href="/listings/edit/${listing.id }">Edit Listing</a></td>
				</c:if>
			</tr>

								
			</c:forEach>
		</tbody>
	</table>
		
	

	
</body>
</html>