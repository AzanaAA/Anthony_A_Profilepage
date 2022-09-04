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
<title>Show Dojo</title>
</head>
<body>

	<h1><c:out value="${dojo.name}"/></h1>
	
	<c:forEach var="ninja" items="${dojo.ninjas}">
		<c:out value="${ninja.firstName}"/> <c:out value="${ninja.lastName}"/> <c:out value="${ninja.age}"/>
	</c:forEach>
	

</body>
</html>