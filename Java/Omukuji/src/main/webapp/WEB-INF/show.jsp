<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	
	<h1>Here's Your Omikuji</h1>
	
	<h2>
		<c:out value="${result}"/>
	</h2>
	
	<a href="/omikuji">Go Back</a>

</body>
</html>