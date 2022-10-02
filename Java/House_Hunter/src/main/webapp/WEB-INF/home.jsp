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
<title>Home</title>
</head>
<body>
	 <h1>Welcome, ${user.userName} </h1>
	 
	 <table>
    <thead> 
    	<tr>
    		<th>Address</th>
    		<th>Listed On</th>
    		<th>Added By</th>
    		<th>Price</th>
    	</tr>
    </thead>
    <tbody>
    	<c:forEach var="listing" items="${unassignedProjects}">
		<tr>
			<c:if test = "${project.lead.id!=user.id}">
			<td><a href="/projects/${project.id}">${project.title}</a></td>
			<td><c:out value="${project.lead.firstName}"></c:out></td>
			<td><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
		    <td><a href="/dashboard/join/${project.id}">Join Team</a></td>
		    </c:if>
		</tr>	
		</c:forEach>
    </tbody>
	</table>

</body>
</html>