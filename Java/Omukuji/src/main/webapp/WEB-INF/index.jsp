<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert</title>
</head>
<body>




    <h1>Send an Omikuji!</h1>

    <form action="/form" method="post">
        <div>
            <label for="num">Pick any number from 5 to 25</label> <input
                type="number" name="number" />
        </div>
        <div>
            <label for="cityy">Enter the name of any city</label> <input
                type="text" name="city" />
        </div>
        <div>
            <label for="real">Enter the name of any real person</label> <input
                type="text" name="person" />
        </div>
        <div>
            <label for="hobby">Enter professional endeavor or hobby</label> <input
                type="text" name="professional" />
        </div>
        <div>
            <label for="thing">Enter any type of living thing</label> <input
                type="text" name="living" />
        </div>
        <div>
            <label for="nice">Say something nice to someone:</label>
            <textarea name="message" id="" cols="30" rows="10">
            </textarea>
        </div>

        <p>Send and show a friend!</p>

        <input type="submit" value="Send" />

    </form>

</body>
</html>
