<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login Page</title>
</head>
<body>
<header>
		<h1 style="text-align: center;color: blue;">Online Doctor Appointment</h1>
	</header>
	<br>
	<center><img src="doctorappointment.jpg" width="450" height="250"></center>
	<br>
		<footer>
			<h1 style="text-align: center;color: red;">Admin Login</h1>
		</footer>
	<form action="AdminServlet" method="post">
		<table style="width:30%"  align="center">
			<tr>
					<td>UserName</td>
					<td><input type="text" name="username" required
						placeholder="Required *" /></td>
			</tr>
			<tr>
					<td>Password</td>
					<td><input type="password" name="password" required
						placeholder="Required *"/></td>
			</tr>
			<tr>
					<td></td>
					<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>	

</body>
</html>