<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Update Form</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>

<script type="text/javascript" src="jquery.timepicker.js"></script>
<link rel="stylesheet" type="text/css" href="jquery-timepicker.css" />

<script type="text/javascript" src="bootstrap-datepicker.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap-datepicker.css" />

<script type="text/javascript" src="site.js"></script>
<link rel="stylesheet" type="text/css" href="site.css" />
 
<script type="text/javascript" src="datepair.js"></script>

<style type="text/css">
.header {
  padding: 10px 16px;
  background: aqua;
  color: #f1f1f1;
}

.content {
  padding: 16px;
}

.sticky {
  position: fixed;
  top: 0;
  width: 100%;
}

.sticky + .content {
  padding-top: 102px;
}
</style>
</head>

<body style="background-image: url('doctorappointment.jpg')">    
	<header class="header" id="myHeader">
		      
		<h1 style="text-align: center; color: blue;">Online Doctor Appointment</h1>
		<br>
		<nav>
			<a href="DoctorHome.jsp" style="color: #000080;">Home</a>&emsp;&emsp;&emsp;&emsp;&emsp;
			<a href="View Doctor.jsp" style="color: #000080;">View Doctor</a>&emsp;&emsp;&emsp;&emsp;&emsp;
			<a href="View Patient.jsp" style="color: #000080;">View Patient</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			<a href="Patient's.jsp" style="color: #000080;">Patient's Req</a>&emsp;&emsp;&emsp;&emsp;&emsp;
			<a href="Doctor's Req.jsp" style="color: #000080;">Doctor's Req</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			<a href="Logout.jsp" style="color: #000080;">Logout</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
		</nav>
	</header>

	
		<div align="center">
			<h3 style="text-align: center; color: red;">Doctor Update Form</h3>
			<form action="DoctorUpdateServlet" method="post">
			<table border="1">
				<tr>
					<td>DoctorName *</td>
					<td><input type="text" name="doctorName" required="required"
						value='${doctorDetails.doctorName}' /></td>
				</tr>

				<tr>
					<td>User Name *</td>
					<td><input type="text" name="uname" required="required" 
								value='${doctorCredentialDetails.userName}' /></td>
				</tr>

				<tr>
					<td>Password *</td>
					<td><input type="password" name="password" required="required" 
							value='${doctorCredentialDetails.password}' /></td>
				</tr>

				<tr>
					<td>Location *</td>
					<td><input type="text" name="location" required="required"
						value="${doctorDetails.location}" /></td>
				</tr>

				<tr>
					<td>Gender *</td>
					<td><input list="gender" type="text" name="gender"
						required="required" value="${doctorDetails.gender}" /></td>
				</tr>

				<tr>
					<td>Email Id</td>
					<td><input type="text" name="mailId"
						value="${doctorDetails.mail_id}" /></td>
				</tr>

				<tr>
					<td>Specialization *</td>
					<td><input type="text" name="catagory" required="required"
						list="specialisation" value="${doctorDetails.catagory}" /></td>
				</tr>

				<tr id="basicExample">
					<td>Open Time *</td>
					<td><input type="text" name="fromTime" required="required"
						class="time start" value="${doctorDetails.from_time}" /></td>
				</tr>

				<tr id="basicExample">
					<td>Close Time *</td>
					<td><input type="text" name="toTime" required="required"
						class="time end" value="${doctorDetails.to_time}" /></td>
				</tr>

				<tr id="basicExample">
					<td>Date Of Birth *</td>
					<td><input type="text" name="dob" required="required"
						class="date" value="${doctorDetails.date}" /></td>
				</tr>

				<tr>
					<td>Fees *</td>
					<td><input type="number" name="fees" required="required"
						oninput="this.value = Math.abs(this.value)"
						value="${doctorDetails.fees}" /></td>
				</tr>


				<tr>
					<td>Mobile Number *</td>
					<td><input type="tel" name="mobileNum" required="required"
						pattern="[6-9]{1}[0-9]{9}" value="${doctorDetails.mobile_no}" /></td>
				</tr>

				<tr>
					<td>Experience *</td>
					<td><input type="number" name="experience" required="required"
						oninput="this.value = Math.abs(this.value)"
						value="${doctorDetails.experience}" /></td>
				</tr>
			</table>
		
			<br> <input type="submit" value="Update" /> <input
				type="reset" value="Reset" /> <br>
			<br>
			</form>
			<h4 style="color: red;">* Marked fields are mandatory
				fields.Please fill these fields to register yourself.</h4>
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
		
		//TO scroll down stickey effect
		window.onscroll = function() {myFunction()};

		var header = document.getElementById("myHeader");
		var sticky = header.offsetTop;

		function myFunction() {
		  if (window.pageYOffset > sticky) {
		    header.classList.add("sticky");
		  } else {
		    header.classList.remove("sticky");
		  }
		}
	</script>
</body>
</html>