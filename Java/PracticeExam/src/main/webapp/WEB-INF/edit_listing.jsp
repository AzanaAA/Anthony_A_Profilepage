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
<c:if test="${!canEdit }">
<h1>Not Allowed To Edit Page</h1>
<p><a href="/welcome">Return To Welcome</a></p>
</c:if>
<c:if test = "${canEdit}">
	<h1>Edit</h1>
	
					
	
	
	
	<form:form action="/listings/edit/${listing.id}" method="post" modelAttribute="listing">

	    	
	    		 <form:label path="address">address</form:label>
				<form:input path="address" />
				<form:errors path="address" />	  
	    	
	    	
	            <form:label path="price">price</form:label>
			<form:input path="price" />
			<form:errors path="price" />
	        
	    <button>Edit Submit!</button>
</form:form>
		</c:if>
		

</body>
</html>