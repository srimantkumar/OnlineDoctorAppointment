<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient List</title>
</head>
<body style="background-image: url('AdminHome.jpg');">
	<header>
		<h1 style="text-align: center;color: blue;">Online patient Appointment</h1>
		<br>
		<nav style="border: 1px solid DeepskyBlue">
			<a href="AdminHome.jsp" style="color:SlateBlue">Home</a> &emsp;
			<a href="ViewDoctorsList" style="color:SlateBlue">View Doctors</a> &emsp;
			<a href="ViewBookingRequestList" style="color:SlateBlue">Patient Requests</a> &emsp;
			<a href="ViewCheckUpHistoryList" style="color:SlateBlue">Check Up History</a> &emsp;
			<a href="LogoutServlet" style="color:SlateBlue">Log Out</a>
		</nav>
	</header>
		
		<footer>
			<h1 style="text-align: center;color: red;">View Patients</h1>
		</footer>
	<div align="center">
		<table border="1">
				<tr>
					<th>Patient Name</th>
					<th>Email Id</th>
					<th>Gender</th>
					<th>Mobile No</th>
					<th>Location</th>
					<th>Date Of Birth</th>
					<th>Age</th>
				</tr>
				<c:forEach var="patient" items="${patientList}">
				<tr>
					<td><c:out value="${patient.patientName}"></c:out></td>
					<td><c:out value="${patient.patientEmail}"></c:out></td>
					<td><c:out value="${patient.patientGender}"></c:out></td>
					<td><c:out value="${patient.patientMobileNo}"></c:out></td>
					<td><c:out value="${patient.patientAddress}"></c:out></td>
					<td><c:out value="${patient.patientDOB}"></c:out></td>
					<td><c:out value="${patient.age}"></c:out></td>					
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>