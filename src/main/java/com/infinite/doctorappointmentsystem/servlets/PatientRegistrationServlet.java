package com.infinite.doctorappointmentsystem.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infinite.doctorappointmentsystem.beans.Patient;
import com.infinite.doctorappointmentsystem.beans.PatientCredentials;
import com.infinite.doctorappointmentsystem.service.PatientService;
import com.infinite.doctorappointmentsystem.service.PatientServiceImpls;

/**
 * Servlet implementation class PatientRegistrationServlet
 */
public class PatientRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PatientService service = new PatientServiceImpls();

		String patientName = request.getParameter("patientName");
		String patientUserName = request.getParameter("patientUserName");
		String patientPassword = request.getParameter("patientPassword");
		String patientEmail = request.getParameter("patientEmail");
		Date patientDOB=null;
		try {
			patientDOB = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("patientDOB"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String patientGender = request.getParameter("patientGender");
		String patientMobileNo = request.getParameter("patientMobileNo");
		int patientAge = Integer.parseInt(request.getParameter("age"));
		String patientAddress = request.getParameter("patientAddress");

		Patient patient = new Patient();
		PatientCredentials pc = new PatientCredentials();

		patient.setPatientName(patientName);
		pc.setPassword(patientPassword);
		pc.setUserName(patientUserName);
		patient.setPatientEmail(patientEmail);
		patient.setPatientDOB(patientDOB);
		patient.setPatientAddress(patientAddress);
		patient.setPatientGender(patientGender);
		patient.setPatientMobileNo(patientMobileNo);
		patient.setAge(patientAge);

		String result1 = service.insertPatientCred(pc);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("PatientLoginPage.jsp");
		if ("success".equals(result1)) {
			String result = service.insertPatient(patient);
			if ("success".equals(result)) {
				requestDispatcher.forward(request, response);
			}
		} else {
			requestDispatcher = request.getRequestDispatcher("PatientsRegistration.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
