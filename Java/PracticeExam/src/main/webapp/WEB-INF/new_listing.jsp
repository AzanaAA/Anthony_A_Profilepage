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
	<h1>New Listing</h1>
	<h2><a href="/welcome">Welcome</a></h2>
	
	
		<form:form action="/listings/new" method="post" modelAttribute="listing">

	
	            <td>Address</td>
	            
	            <form:label path="address">address</form:label>
				<form:input path="address" />
				<form:errors path="address" />	            
	       
	    
	          <form:label path="price">price</form:label>
			<form:input path="price" />
			<form:errors path="price" />
	        
	    <button>List!</button>
	       
	   
		</form:form>

	
	
	

</body>
</html>