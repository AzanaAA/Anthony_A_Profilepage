<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2><a href="/welcome">Welcome</a></h2>

<h1>Project Details</h1>
<table>
    <tbody>
    	<tr>
            <td>Listing: <c:out value="${listing.address}"></c:out></td>
        </tr>
        
        <tr>
            <td>Price: <c:out value="${listing.price}"></c:out></td>
        </tr>
        
        </tbody>
</table>
<c:if test = "${listing.user.id==userId}">
    <h2><a href="/listings/delete/${listing.id}">Delete Listing</a></h2>
</c:if>
	

</body>
</html>