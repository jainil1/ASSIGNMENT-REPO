<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>
<h1>EDIT PAGE </h1>
<form action="aftereditEmployee">
<c:out value="${emp.getId()} " > here</c:out><br>

<input type="hidden" id="id" value="${emp.getId()}" name="id" ><br>
ENTER NAME TO EDIT :<input type="text" name="name" ><br>
ENTER Email TO EDIT :<input type="text" name="email" ><br>
<p>
<input type="submit" value="yo edit">

</form> 
</body>
</html>