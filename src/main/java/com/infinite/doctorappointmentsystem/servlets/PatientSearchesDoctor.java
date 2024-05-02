package com.infinite.doctorappointmentsystem.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infinite.doctorappointmentsystem.beans.Doctor;
import com.infinite.doctorappointmentsystem.service.PatientService;
import com.infinite.doctorappointmentsystem.service.PatientServiceImpls;

/**
 * Servlet implementation class PatientSearchesDoctor
 */
public class PatientSearchesDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession httpSession = request.getSession(false);
	
		String category = request.getParameter("category");
		String date = request.getParameter("date");
		String location = request.getParameter("location");
		PatientService ps = new PatientServiceImpls();
		List<Doctor> list = ps.searchDoctor(category, location);
		request.setAttribute("filterlist", list);
		httpSession.setAttribute("date", date);
		RequestDispatcher rd = request.getRequestDispatcher("SearchResultsPage.jsp");
		rd.forward(request, response);
	}

}
