<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!-- c:out ; c:forEach etc. --> 
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

	<h1>Edit Expense</h1>
	<a href="/">Go back</a>
	
	<form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense" >
			
			<input type="hidden" name="_method" value="put">
			<div class="form-group">
				<form:label path="name">Expense Name:</form:label>
				<form:errors path="name"/>
				<form:input path="name" type="text"/>
			</div>
			
			
			
			<div>
				<form:label path="vendor">Vendor:</form:label>
				<form:errors path="vendor"/>
				<form:input path="vendor" type="text"/>
			</div>
			
			<div>
				<form:label path="price">Amount:</form:label>
				<form:errors path="price"/>
				<form:input path="price" type="number" step="0.01"/>
			</div>
			
			
			<div>
				<form:label path="description">Description:</form:label>
				<form:errors path="description"/>
				<form:input path="description" type="text"/>
			</div>
			
			<input type="submit" value="Submit"/>
		
		</form:form>


	

</body>
</html>