package com.infinite.doctorappointmentsystem.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infinite.doctorappointmentsystem.service.OtherPatientsServiceImpls;
import com.infinite.doctorappointmentsystem.service.OtherPatientsServices;

/**
 * Servlet implementation class SearchDoctorPageServlet
 */
public class SearchDoctorPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OtherPatientsServices ops = new OtherPatientsServiceImpls();
		List categoryList = ops.getCategoryFromDatabase();
		List locationList = ops.getLocationFromDatabase();
		
		request.setAttribute("listCategory", categoryList);
		request.setAttribute("listLocation", locationList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("SearchPage.jsp");
        dispatcher.forward(request, response);
	}

}
