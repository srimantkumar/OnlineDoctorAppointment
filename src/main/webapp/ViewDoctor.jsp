<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor List</title>
</head>
<body style="background-image: url('AdminHome.jpg');">
	<header>
		<h1 style="text-align: center;color: blue;">Online Doctor Appointment</h1>
		<nav style="border: 1px solid DeepskyBlue">
			<a href = "AdminHome.jsp"style="color:#000080;">Home</a>&emsp;&emsp;&emsp;&emsp;&emsp;
			<a href="ViewPatientsList" style="color:SlateBlue">View Patients</a> &emsp;
			<a href="ViewBookingRequestList" style="color:SlateBlue">Patient Requests</a> &emsp;
			<a href="ViewCheckUpHistoryList" style="color:SlateBlue">Check Up History</a> &emsp;
			<a href="LogoutServlet" style="color:SlateBlue">Log Out</a>
		</nav>
	</header>
		
		<footer>
			<h1 style="text-align: center;color: red;">View Doctors</h1>
		</footer>
	<div align="center">
		<table border="1">
				<tr>
					<th>Doctor Name</th>
					<th>Category</th>
					<th>Location</th>
					<th>Email Id</th>
					<th>Gender</th>
					<th>Mobile No</th>
					<th>Open Time</th>
					<th>Close Time</th>
					<th>Date Of Birth</th>
					<th>Fee</th>
					<th>Experience</th>
				</tr>
				<c:forEach var="doctor" items="${doctorList}">
				<tr>
					<td><c:out value="${doctor.doctorName}"></c:out></td>
					<td><c:out value="${doctor.catagory}"></c:out></td>
					<td><c:out value="${doctor.location}"></c:out></td>
					<td><c:out value="${doctor.mail_id}"></c:out></td>
					<td><c:out value="${doctor.gender}"></c:out></td>
					<td><c:out value="${doctor.mobile_no}"></c:out></td>
					<td><c:out value="${doctor.from_time}"></c:out></td>
					<td><c:out value="${doctor.to_time}"></c:out></td>					
					<td><c:out value="${doctor.date}"></c:out></td>
					<td><c:out value="${doctor.fees}"></c:out></td>
					<td><c:out value="${doctor.experience}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>