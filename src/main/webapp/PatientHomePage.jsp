<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Home Page</title>
</head>
<body>

	<h1 style="text-align: center; color: blue;">Online Doctor Appointment</h1>
	<h3 style="text-align: center; color: Green;">Patient Home Page</h3>
	<nav>
		<a href="SearchDoctorPageServlet">Search Doctor</a> &nbsp;&nbsp;
		<a href="SearchResultsPage.jsp">View Booking Status</a> &nbsp;&nbsp;
		<a href="ViewStatusPatient.jsp">View Bookings</a> &nbsp;&nbsp;
		<a href="UpdatePatientInformations">Update Credentials</a> &nbsp;&nbsp;
		<a href="PatientFeedbackSystem.jsp">Give Feedback</a> &nbsp;&nbsp;
		<a href="LogoutServlet">LOGOUT</a> &nbsp;&nbsp;
		<a href="DeletePatient">De-register Yourself</a><br>
	</nav>
	<br>
	<br>
	<img src="doctorappointment.jpg" height="300" width="500">
	<br> Welcome : ${patientDetails.patientName}

</body>
</html>

<%-- <%String name=(String)request.getAttribute("user"); %>
			<%out.println("Welcome "+request.getAttribute("user")) ;
			<p hidden><value="${user}" name="pname">
			Welcome: ${user} --%>
			
<%-- <c:forEach var="pat" items="${patientDetails}">
		Welcome : <c:out value="${pat.patientName}"></c:out>
		</c:forEach> --%>