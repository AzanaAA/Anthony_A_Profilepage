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

<h3><a href="/home">Home</a></h3>
	
	<h1><c:out value="${team.teamName}"></c:out> </h1>
	
	<h3>Team Name: <c:out value="${team.teamName}"></c:out></h3>
	<h3>Skill Level: <c:out value="${team.skillLevel}"></c:out></h3>
	<h3>Game Day: <c:out value ="${team.gameDay}"></c:out></h3>
	
	<c:if test = "${team.user.id==userId }">
	<h3><a href="/teams/delete/${team.id}">Delete Team</a></h3>
	</c:if>
	
	
	
</body>
</html>