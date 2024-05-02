<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Login Page</title>
</head>
<body style="background-image: url('doctorappointment.jpg')">
	<h1 align="center">Patient Login Page</h1>
	<div align="center">
		<form action="PatientValidationServlets" method="post">
			<table>
				<tr>
					<td>Patient User Name</td>
					<td><input type="text" name="user" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="pass" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Login"></td>
				</tr>
			</table>
			<marquee>
				<a href="PatientsRegistration.jsp" style="color: orange;">New user Register Here</a>
			</marquee>
			
				<a href="LogoutServlet">Logout</a>
			

		</form>
	</div>
</body>
</html>