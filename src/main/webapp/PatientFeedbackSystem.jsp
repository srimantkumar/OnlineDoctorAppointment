<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback</title>
</head>

<body>
	<center>Feedback<br>
	<br>
	<form action="FeedbackConfirmationPage.jsp" method="post">

		Select Doctor<select name="SelectDoctor">
			<option value="doctor1"></option>>
			<option value="doctor2"></option>
			<option value="doctor3"></option>
		</select> <br>
		<br> Doctor Id &nbsp;&nbsp;<input type="text" name="did"><br>
		<br> Patient Id &nbsp;&nbsp;<input type="text" name="pid"><br>
		<br> Feedback &nbsp;&nbsp;<input type="text" name="feedback"><br>
		<br> <input type="Submit" value="Submit"><br>
		<br>
	</form>
	</center>
</body>
</html>