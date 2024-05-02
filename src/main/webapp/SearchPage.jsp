<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search page</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>

<script type="text/javascript" src="bootstrap-datepicker.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap-datepicker.css" /> 

<script type="text/javascript" src="site.js"></script>
<link rel="stylesheet" type="text/css" href="site.css" />
</head>
<body>
	<h1 style="text-align: center;">Search</h1>
	<div align="center">
		<form action="PatientSearchesDoctor" method="post">
			<table border="1" style="width: 40%;">
				<tr>
					<td>Category *</td>
					<td>Date *</td>
					<td>Location *</td>
				</tr>
				<tr>
					<td><select name="category" required="required">
							<option disabled="disabled" hidden="hide">Specialization</option>
							<c:forEach items="${listCategory}" var="category">
								<option value="${category}">${category}</option>
							</c:forEach>
					</select></td>
					<td id="basicExample"><input type="date" name="date" placeholder="Date Of Birth" required="required" class="date"></td>
					<td><select name="location" required="required">
						<option disabled="disabled" hidden="hide">Location</option>
							<c:forEach items="${listLocation}" var="location">
								<option value="${location}">${location}</option>
							</c:forEach>
					</select></td>
				</tr>
			</table>
			<br> 
			<input type="submit" value="Search">
			<input type="reset" value="Reset">
		</form>
		<h3 style="color: red;">* Marked fields are mandatory
				fields.Please fill these fields to search for Doctors available.</h3>
	</div>
	
	
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