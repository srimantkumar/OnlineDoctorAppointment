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
	<header>
		<h1 style="text-align:center; color:DeepPink">Online Doctor Appointment</h1>
		<nav style="border:1px solid Lime;">
			<a href="Home.jsp" style="color:SlateBlue">Home</a> &emsp;
			<a href="ViewDoctors.jsp" style="color:SlateBlue">View Doctor</a> &emsp;
			<a href="ViewPatients.jsp" style="color:SlateBlue">View Patient</a> &emsp;
			<a href="PatientRequest.jsp" style="color:SlateBlue">Patient Request</a> &emsp;
			<a href="DoctorRequest.jsp" style="color:SlateBlue">Doctor Request</a> &emsp;
			<a href="Login.jsp" style="color:SlateBlue">Log Out</a>
		</nav>
	</header>
		<img  src="AdminLogin.jpg" width="428" height="250" align="center">
		<footer>
			<h2 style="text-align:center; color:DeepPink">View Booking Request</h2>
			<table border="1" align="center">
			<tr> <th>Patient Name<th>Doctor Name<th>Location<th>Phone No.<th>Email-Id<th>Category<th>Reason<th>Send</th></tr>
			<tr>
			<td> <c:out value="${doctor.name}"></c:out></td>
			<td> <c:out value="${doctor.catagory}"></c:out></td>
			<td> <c:out value="${doctor.mobile_No}"></c:out></td>
			<td> <c:out value="${doctor.email_id}"></c:out></td>
			<td> <c:out value="${doctor.location}"></c:out></td>
			<td> <c:out value="${doctor.location}"></c:out></td>
			<td> <c:out value="${doctor.location}"></c:out></td>
			<td> <c:out value="${doctor.location}"></c:out></td>
			</tr>
			</table>
			
		</footer>
</body>
</html>
