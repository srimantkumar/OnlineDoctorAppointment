<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Registration Form</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>

<!-- <script type="text/javascript" src="jquery.timepicker.js"></script>
<link rel="stylesheet" type="text/css" href="jquery-timepicker.css" /> -->

<script type="text/javascript" src="bootstrap-datepicker.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap-datepicker.css" /> 

<script type="text/javascript" src="site.js"></script>
<link rel="stylesheet" type="text/css" href="site.css" />

<script type="text/javascript" src="datepair.js"></script>
</head>
<body style="background-image: url('doctorappointment.jpg')">

	<div align="center">
		<form action="PatientRegistrationServlets" method="post">
			<h1 style="color: Green">Patient Registration Form</h1>

			<table style="width: 35%">
				<tr>
					<td>Patient Name</td>
					<td><input type="text" name="patientName" required="required"
						placeholder="Required *"></td>
				</tr>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="patientUserName"
						required="required" placeholder="Required *"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="patientPassword"
						required="required" placeholder="Required *"></td>
				</tr>
				<tr>
					<td>E_Mail</td>
					<td><input type="email" name="patientEmail"></td>
				</tr>
				<tr id="basicExample">
					<td>Date Of Birth</td>
					<td><input type="text" name="patientDOB" required="required"
						placeholder="Required *" class="date"></td>
				</tr>
				<tr>
					<td>Gender *</td>
					<td><input list="gender" type="text" name="patientGender" required="required"
						placeholder="Required *" ></td>
				</tr>
				<tr>
					<td>MobileNo</td>
					<td><input type="tel" name="patientMobileNo" pattern="[6-9]{1}[0-9]{9}"
						required="required" placeholder="Required *"></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="number" min=0 name="age" required="required"
						placeholder="Required *" oninput="this.value = Math.abs(this.value)"></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="patientAddress"
						required="required" placeholder="Required *"></td>
				</tr>
			</table>
			<br> <input type="submit" value="Register" /> 
				 <input	type="reset" value="Reset" /> <br>
			<br>
			<button
				onclick="window.location.href = 'http://localhost:8081/doctorappointmentsystem/PatientLoginPage.jsp';">
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
	
	<script>
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