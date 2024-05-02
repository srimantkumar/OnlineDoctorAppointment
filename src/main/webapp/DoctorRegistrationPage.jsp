<%@page import="java.util.List"%>
<%@page import="com.infinite.doctorappointmentsystem.dao.OtherPatientFunctionalitiesImpls"%>
<%@page import="com.infinite.doctorappointmentsystem.dao.OtherPatientFunctionalities"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Registration Form</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>

<script type="text/javascript" src="jquery.timepicker.js"></script>
<link rel="stylesheet" type="text/css" href="jquery-timepicker.css" />

<script type="text/javascript" src="bootstrap-datepicker.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap-datepicker.css" />

<script type="text/javascript" src="site.js"></script>
<link rel="stylesheet" type="text/css" href="site.css" />

<script type="text/javascript" src="datepair.js"></script>
</head>

<body style="background-image: url('doctorappointment.jpg')">
	<h1 style="color: green;" align="center">Doctor Registration Form</h1>
	
	<div align="center">
		<form action="DoctorRegistrationServlets" method="post">
			<table style="width: 35%">

				<tr>
					<td>DoctorName *</td>
					<td><input type="text" name="doctorName" required="required"
						placeholder="Required *" /></td>
				</tr>
				
				<tr>
					<td>User Name *</td>
					<td><input type="text" name="uname" required="required"
						placeholder="Required *" /></td>
				</tr>
				
				<tr>
					<td>Password *</td>
					<td><input type="password" name="password" required="required"
						placeholder="Required *" /></td>
				</tr>
				
				<tr>
					<td>Location *</td>
					<td><input type="text" name="location" required="required"
						placeholder="Required *" /></td>
				</tr>
				
				<tr>
					<td>Gender *</td>
					<td><input list="gender" type="text" name="gender" required="required"
						placeholder="Required *" ></td>
				</tr>

				<tr>
					<td>Email Id</td>
					<td><input type="text" name="mailId" /></td>
				</tr>
				
				<tr>
					<td>Specialization *</td>
					<td><input type="text" name="catagory" required="required"
						placeholder="Required *" list="specialisation"/></td> 
				</tr>
				
				<tr id="basicExample">
					<td>From Time *</td>
					<td><input type="text" name="fromTime" required="required"
						placeholder="Required *" class="time start" /></td>
				</tr>
				
				<tr id="basicExample">
					<td>To Time *</td>
					<td><input type="text" name="toTime" required="required"
						placeholder="Required *" class="time end" /></td>
				</tr>

				<tr id="basicExample">
					<td>Date Of Birth *</td>
					<td><input type="text" name="dob" required="required"
						placeholder="Required *" class="date" /></td>
				</tr>

				<tr>
					<td>Fees *</td>
					<td><input type="number" name="fees" required="required"
						placeholder="Required *" oninput="this.value = Math.abs(this.value)"/></td>
				</tr>


				<tr>
					<td>Mobile Number *</td>
					<td><input type="tel" name="mobileNum" required="required" pattern="[6-9]{1}[0-9]{9}"
						placeholder="Required *" /></td>
				</tr>

				<tr>
					<td>Experience *</td>
					<td><input type="number" name="experience" required="required"
						placeholder="Required *" oninput="this.value = Math.abs(this.value)"/></td>
				</tr>
			</table>
			<br> <input type="submit" value="Register" /> <input
				type="reset" value="Reset" /> <br>
			<br>
			<button
				onclick="window.location.href = 'http://localhost:8081/doctorappointmentsystem/DoctorLoginPage.jsp';">
				LoginPage</button>
			<button
				onclick="window.location.href = 'http://localhost:8081/doctorappointmentsystem/index.jsp';">
				Home Page</button>
			<h3 style="color: red;">* Marked fields are mandatory
				fields.Please fill these fields to register yourself.</h3>

		</form>
	</div>
	
	<datalist id="gender">
		<option>Male</option>
		<option>Female</option>
		<option>Other</option>
	</datalist>
		
	<datalist id="specialisation">
		<c:forEach items="${categoryList}" var="category">
			<option value="${category}">${category}</option>
		</c:forEach>
		<option>Medicine</option>
		<option>Orthopedics</option>
		<option>ENT</option>
		<option>Cardiac</option>
	</datalist>
	
	<%-- <%
		OtherPatientFunctionalities ops = new OtherPatientFunctionalitiesImpls();
		List categoryList = ops.getCategoryFromDatabase();
	%> --%>
	
	<script>
		$('#basicExample .time').timepicker({
			'showDuration' : true,
			'timeFormat' : 'g:i:A'
		});

		$('#basicExample .date').datepicker({
			'format' : 'yyyy/mm/dd',
			'autoclose' : true
		});

		// initialize datepair
		var basicExampleEl = document.getElementById('basicExample');
		var datepair = new Datepair(basicExampleEl);
	</script>
</body>
</html>