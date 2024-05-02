<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search result page</title>
</head>
<body>

	<header>
		<nav style="border: 1px solid DeepSkyBlue">
			<a href="PatientHomePage.jsp" style="color: #000080;">Home</a>&emsp;&emsp;&emsp;&emsp;
			<a href="SearchPage.jsp" style="color: #000080;">View Booking</a>
			&emsp;&emsp;&emsp;&emsp; <a href="ViewStatusPatient.jsp"
				style="color: #000080;">View Status</a> &emsp;&emsp;&emsp;&emsp; <a
				href="PatientFeedbackSystem.jsp" style="color: #000080;">Feedback</a>&emsp;&emsp;
			&emsp;&emsp; <a href="LogoutServlet" style="color: #000080;">Logout</a>&emsp;&emsp;
			&emsp;&emsp;
		</nav>
	</header>

	<footer>
		<div align="center">
			<h1 style="text-align: center;">Results</h1>
			<table border="1">
				<tr>
					<th>Doctor Name</th>
					<th>Category</th>
					<th>Mobile No</th>
					<th>Fees</th>
					<th>From_Timing</th>
					<th>To_Timing</th>
					<th>Email</th>
					<th>Location</th>
					<th>Book</th>
				</tr>
				<c:forEach var="doc" items="${filterlist}">
					<tr>
						<td><c:out value="${doc.doctorName}"></c:out></td>
						<td><c:out value="${doc.catagory}"></c:out></td>
						<td><c:out value="${doc.mobile_no}"></c:out></td>
						<td><c:out value="${doc.fees}"></c:out></td>
						<td><c:out value="${doc.from_time}"></c:out></td>
						<td><c:out value="${doc.to_time}"></c:out></td>
						<td><c:out value="${doc.mail_id}"></c:out></td>
						<td><c:out value="${doc.location}"></c:out></td>
						<td><a href="HistoryRecordServlet?docid=${doc.id}">Book</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</footer>
</body>
</html>