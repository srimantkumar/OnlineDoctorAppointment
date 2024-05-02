package com.infinite.doctorappointmentsystem.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infinite.doctorappointmentsystem.beans.Patient;
import com.infinite.doctorappointmentsystem.service.PatientService;
import com.infinite.doctorappointmentsystem.service.PatientServiceImpls;

/**
 * Servlet implementation class PatientValidationServlets
 */
public class PatientValidationServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PatientService ps=new PatientServiceImpls();
		
		String username=request.getParameter("user");
		String password=request.getParameter("pass");
		
		String validate=ps.validatePatient(username, password);
		int id = ps.getCredentialId(username);
		Patient patientDetails = ps.getPatientUser(id);
		
		HttpSession httpSession=request.getSession();
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("PatientHomePage.jsp");
		if ("success".equals(validate))
		{
			httpSession.setAttribute("patientDetails", patientDetails);
			httpSession.setMaxInactiveInterval(180);
			requestDispatcher.forward(request, response);
		}
		else 
		{
			requestDispatcher=request.getRequestDispatcher("PatientLoginPage.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
