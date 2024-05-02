<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page isELIgnored="false" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Booking page </title>
</head>
<body>
	<header>
		<h1 style="text-align: center;color: blue;">Online Doctor Appointment</h1>
		<br>
		<nav style="border: 1px solid DeepskyBlue">
			<a href = "PatientHomePage.jsp"style="color:#000080;">Home</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			<a href = "SearchPage.jsp"style="color:#000080;">search</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			<a href = "PatientFeedbackSystem.jsp"style="color:#000080;">Feedback</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			<a href = "PatientLoginPage.jsp"style="color:#000080;">Logout</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
		</nav>
	</header>
		<br>
		<img src="doctorappointment.jpg" width="450" height="250">
		<br>
		<footer>
			<h1 style="text-align: center;color: red;">View Booking Status</h1>
		</footer>
		<table border="1" align="center">
			<tr> <th>Patient Name<th>Doctor Name<th>Status</th></tr>
			<tr>
			<td> <c:out value="${patient.name}"></c:out></td>
			<td> <c:out value="${doctors.name}"></c:out></td>
			<td> <c:out value="${admin.sent}"></c:out></td>
			</tr>
		</table>

</body>
</html>