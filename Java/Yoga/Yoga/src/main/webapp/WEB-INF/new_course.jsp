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
<title>Edit</title>
</head>
<body>
	<h1>New Course</h1>
	<h3><a href="courses"></a>All Courses</h3>

	<form:form action="/courses/new" method="post" modelAttribute="course">
	
		
		<form:label path="courseName">Class Name</form:label>
		<form:input path="courseName"/>
		<form:errors path="courseName"/>
		
		<form:label path="weekDay">Day of Week</form:label>
		<form:input path="weekDay"/>
		<form:errors path="weekDay"/>
		
		<form:label path="price">Price </form:label>
		<form:input path="price"/>
		<form:errors path="price"/>
		
		<form:label path="description">Description</form:label>
		<form:input path="description"/>
		<form:errors path="description"/>
		
		<button>Submit</button>
	
	
	
	
	</form:form>
	
	
	
</body>
</html>