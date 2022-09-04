<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
</head>
<body>
	
	<h1>New Ninja</h1>
	
	<form:form action="/ninjas" method="post" modelAttribute="ninja">
	
	
	<p>
        <form:label path="dojo">Dojo:</form:label>
        
        <form:select path="dojo">
        	<c:forEach var="eachDojo" items="${dojos}">
	        	<option value="${eachDojo.id}"><c:out value="${eachDojo.name}"/></option>
        	</c:forEach>
        </form:select>
    </p>

    <p>
        <form:label path="firstName">First Name:</form:label>
        <form:input path="firstName"/>
    </p>
    
    <p>
        <form:label path="lastName">Last Name:</form:label>
        <form:input path="lastName"/>
    </p>
    <p>
        <form:label path="age">Age:</form:label>
        <form:input path="age"/>
    </p>
    
   
    
    
    <input type="submit" value="Submit"/>
    
</form:form>  

</body>
</html>