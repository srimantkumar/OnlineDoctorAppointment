<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home Page</title>
</head>
<body style="background-image: url('AdminHome.jpg');">
	<header>
		<h1 style="text-align:center; color:DeepPink">Online Doctor Appointment</h1>
		<nav style="border:5px solid Lime; align-items: flex-end;">
			<a href="AdminHome.jsp" style="color:SlateBlue">Home</a> &emsp;&emsp;
			<a href="ViewDoctorsList" style="color:SlateBlue">View Doctors</a> &emsp;&emsp;
			<a href="ViewPatientsList" style="color:SlateBlue">View Patients</a> &emsp;&emsp;
			<a href="ViewBookingRequestList" style="color:SlateBlue">Patient Requests</a> &emsp;&emsp;
			<a href="ViewCheckUpHistoryList" style="color:SlateBlue">Check Up History</a> &emsp;&emsp;
			<a href="ViewFeedbackToDoctors" style="color:SlateBlue">Feedback For Doctors</a> &emsp;&emsp;
			<a href="LogoutServlet" style="color:SlateBlue">Log Out</a> 
		</nav>
	</header>
	
		<footer>
			<h2 style="text-align:center; color:DeepPink">Welcome Admin</h2>
		</footer>
</body>
</html>
