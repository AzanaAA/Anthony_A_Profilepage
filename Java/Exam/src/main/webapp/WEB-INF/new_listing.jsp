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
<title>New Listing</title>
</head>
<body>
<form:form action="/listings/new" method="post" modelAttribute="listing">

	<table>
	    <thead>
	    	<tr>
	            <td >Address:</td>
	            <td >
	            	<form:errors path="address"/>
					<form:input type="input" path="address"/>
	            </td>
	        </tr>
	        <tr>
	            <td>Price:</td>
	            <td>
	            	<form:errors path="price"/>
					<form:textarea type="input" path="price"/>
	            </td>
	        </tr>
	        
	        <tr>
	        	<td><input class="input" class="button" type="submit" value="Submit"/></td>
	        </tr>
	    </thead>
	</table>
</form:form>

</body>
</html>