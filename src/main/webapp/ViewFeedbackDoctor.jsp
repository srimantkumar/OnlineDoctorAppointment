<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online doctor appointment</title>
</head>
<body>
		<form action="">
		<h1 align="center"> Online Doctor Appointment </h1><br><br><br><br><br><br>
		
		<div align="center">
			<a href="DoctorHome.jsp">HOME</a>
			&nbsp;&nbsp;<a  href="BookingRequest.jsp">BOOKING REQUEST</a>
			&nbsp;&nbsp;<a href="DoctorLoginPage.jsp">LOGOUT</a><br><br><br><br><br><br><br><br><br>
		</div>
		<div align="center">
			<table border="2">
			<tr> <th> Patient<th> Feedback</th> </tr>	
				<tr> <c:out value="${id}"></c:out></td>
				<td> <c:out value="${feedback}"></c:out></td></tr>
			</table>
		</div>
	</form>
</body>
</html>