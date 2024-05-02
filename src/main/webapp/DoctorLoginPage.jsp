<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Doctor Login</title>
</head>
<body style="background-image: url('doctorappointment.jpg')">

	<h1 align="center">Doctor Login Page</h1>

	<div align="center">
		<form action="DoctorValidationServlets" method="post">

			<table style="width : 35%;">
				<tr>
					<td>Doctor User Name</td>
					<td><input type="text" name="user" required="required" placeholder="User Name" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="pass" required="required" placeholder="Password"/></td>
				</tr>
			</table>
			<br><br>
			<marquee>
				<a href="DoctorRegistrationPage.jsp" style="color: orange;">New User? Register here!!!</a><br>
			</marquee>
			<input type="submit" value="Login" />
			<input type="reset" value="Reset">
			<br><br>
			<button onclick="window.location.href = 'http://localhost:8081/doctorappointmentsystem/index.jsp';">
								Home Page</button>
		</form>
	</div>


</body>
</html>