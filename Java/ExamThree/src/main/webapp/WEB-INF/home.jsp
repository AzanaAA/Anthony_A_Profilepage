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
<h1>Hello!</h1>
<p><a href="/logout">Logout</a></p>
	<p><a href="/teams/new">New Team</a>
	
	<table>
		<thead>
			<tr>
				<th>Team Name</th>
				<th>Skill Level (1-5)</th>
				<th>Game Day</th>
			</tr>
		</thead>
	</table>
	
	<table>
		<thead>
			<tbody>
			<c:forEach var="team" items="${teams}">
				<tr>
				
					<td><a href="teams/${team.id}"> <c:out value="${team.teamName }" /></a></td>
					<td><c:out value="${team.skillLevel }"/></td>
					<td><c:out value="${team.gameDay}"/> </td>
					<c:if test = "${team.user.id==user.id }">
					<td><a href="/teams/edit/${team.id }">Edit team</a></td>
					</c:if>
				</tr>
				</c:forEach>
			</tbody>
	</table>

</body>
</html>