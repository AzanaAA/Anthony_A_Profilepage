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


	<h1>Edit</h1>
	<h3><a href="/home">Home</a></h3>
	
	<form:form action="/teams/edit/${team.id}" method="post" modelAttribute="team">
	
	
	<form:label path="teamName">Team Name</form:label>
		<form:input path="teamName"/>
		<form:errors path="teamName"/>
		
		<form:label path="skillLevel">Skill Level</form:label>
		<form:input type="number"  path="skillLevel"/>
		<form:errors path="skillLevel"/>
		
		
		
		<form:label path="gameDay">Game Day</form:label>
		<form:input path="gameDay"/>
		<form:errors path="gameDay"/>
		
		<input class="input" class="button" type="submit" value="Submit">	
	</form:form>

</body>
</html>