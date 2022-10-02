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
<title>Insert title here</title>
</head>
<body>

	<h1><c:out value="${course.courseName}"></c:out> with <c:out value="${course.user.name}"></c:out></h1>
	
	<h3>Day:<c:out value="${course.weekDay}"></c:out></h3>
	<h3>Cost: $<c:out value="${course.price}"></c:out></h3>
	<h3><c:out value ="${course.description}"></c:out></h3>
	
	<c:if test = "${course.user.id==userId }">
	<h3><a href="/courses/delete/${course.id}">Delete Listing</a></h3>
	</c:if>

</body>
</html>