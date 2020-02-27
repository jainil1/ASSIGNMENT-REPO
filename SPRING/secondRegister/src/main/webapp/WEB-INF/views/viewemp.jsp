<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>
<c:forEach var="employee" items="${emp}" >
<tr>
	        		
					<td>${employee.getName()}</td>
					<td>${employee.getEmail()}</td>
					<td>${employee.getId()}</td>
				
					<td><pre>
						<a href="editEmployee?id=${employee.getEmail()}">Edit</a>
						<a href="deleteEmployee?id=${employee.getEmail()}">Delete</a>
						</pre>
					</td>
	        	</tr>
	        	<br><br>
</c:forEach>
<h3>
FOR REGISTER: <a href="register">REGISTER HERE </a> 
</h3>
<br>.<br>
</body>
</html>