<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.infinite.doctorappointmentsystem.beans.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Home Page</title>
</head>
<body>

	<header style="text-align: center;">
		      
		<h1 style="text-align: center; color: blue;">Online Doctor Appointment</h1>
		<h3 style="text-align: center; color: Green;">Doctor Home Page</h3>
		<nav>
			  <a href="DoctorHome.jsp" style="color: #000080;">Home</a>&emsp;&emsp;
			  <a href="Booking Request.jsp" style="color: #000080;">Booking Request</a>&emsp;&emsp;
			  <a href="ViewFeedbackDoctor.jsp" style="color: #000080;">View Feedback</a>&emsp;&emsp;
			  <a href="UpdateDoctorForm.jsp" style="color: #000080;">Update Information</a>&emsp;&emsp;
			  <a href="LogoutServlet" style="color: #000080;">Logout</a>
		</nav>
	</header>
	<br>

	<div style="text-align: center;">
		<img src="doctorappointment.jpg" height="300" width="500"> <br>
		
		Welcome : ${doctorDetails.doctorName}
		
	</div>

</body>
</html>		

<%-- 
		<%! String name; %>
		<% Doctor doctor = new Doctor();
			List<Doctor> docList = (List<Doctor>) request.getAttribute("userDetails");
			doctor = docList.get(0);
			out.println("Welcome " + doctor.getDoctorName());
			name=doctor.getDoctorName();
		%>
		
		<% out.println("Welcome Doctor " + name); %>
--%>