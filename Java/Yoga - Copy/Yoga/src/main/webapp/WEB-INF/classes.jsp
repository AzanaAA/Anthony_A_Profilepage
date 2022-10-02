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
<title>Project Mananger Dashboard</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.name}"></c:out>!</h1>
	<p><a href="/logout">Logout</a></p>
	<p><a href="/classes/new">New Course</a>
	
	<table>
		<thead>
			<tr>
				<th>Class Name</th>
				<th>Instructor</th>
				<th>Weekday</th>
				<th>Price</th>
			</tr>
		</thead>
	</table>
	
	<table>
		<thead>
			<tbody>
			<c:forEach var="course" items="${courses}">
				<tr>
				
					<td><a href="courses/${course.id}"> <c:out value="${course.courseName }" /></a></td>
					<td><c:out value="${course.user.name }"/></td>
					<td><c:out value="${course.user.weekDay}"/> </td>
					<c:if test = "${course.user.id==user.id }">
					<td><a href="/courses/edit/${course.id }">Edit Course</a></td>
					</c:if>
				</tr>
				</c:forEach>
			</tbody>
	</table>
	
</body>
</html>