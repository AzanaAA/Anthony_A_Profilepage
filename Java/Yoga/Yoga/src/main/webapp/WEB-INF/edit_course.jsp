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
	<c:if test="${!canEdit }">
	<h1>Not Allowed To Edit Page</h1>
	<p><a href="/courses">Return To Courses</a></p>
	</c:if>
	<c:if test = "${canEdit}">
	<h1>Edit</h1>
	
	<form:form action="/courses/edit/${course.id}" method="post" modelAttribute="course">

	    	
	    		 <form:label path="courseName">Course Name</form:label>
				<form:input path="courseName" />
				<form:errors path="courseName" />	  
	    	
	    	
	            <form:label path="weekDay">Weekday</form:label>
			<form:input path="weekDay" />
			<form:errors path="weekDay" />
			
			<form:label path="price">Price</form:label>
			<form:input path="price"/>
			<form:errors path="price"/>
			
			<form:label path="description">Description</form:label>
			<form:input path="description"/>
			<form:errors path="description"/>
	        
	    <button>Edit Submit!</button>
</form:form>
		</c:if>

</body>
</html>