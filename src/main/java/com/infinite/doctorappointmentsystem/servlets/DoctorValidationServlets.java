package com.infinite.doctorappointmentsystem.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infinite.doctorappointmentsystem.beans.Doctor;
import com.infinite.doctorappointmentsystem.beans.DoctorCredentials;
import com.infinite.doctorappointmentsystem.service.DoctorService;
import com.infinite.doctorappointmentsystem.service.DoctorServiceImpls;

/**
 * Servlet implementation class DoctorValidationServlets
 */
public class DoctorValidationServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DoctorService ds = new DoctorServiceImpls();
		
		String username = request.getParameter("user");
		String password = request.getParameter("pass");

		String validate = ds.validateDoctor(username, password);
		int id = ds.getCredentialId(username);
		Doctor doctorDetails = ds.getDoctorUser(id);
		DoctorCredentials doctorCredentials = ds.getDoctorCredentialsUser(username);

		HttpSession httpSession = request.getSession();

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("DoctorHome.jsp");
		if ("success".equals(validate)) {
			httpSession.setAttribute("doctorDetails", doctorDetails);
			httpSession.setAttribute("doctorCredentialDetails", doctorCredentials);
			httpSession.setMaxInactiveInterval(180);
			requestDispatcher.forward(request, response);
		} else {
			requestDispatcher = request.getRequestDispatcher("DoctorLoginPage.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
