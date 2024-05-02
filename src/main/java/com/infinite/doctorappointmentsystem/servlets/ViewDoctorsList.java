package com.infinite.doctorappointmentsystem.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infinite.doctorappointmentsystem.beans.Doctor;
import com.infinite.doctorappointmentsystem.service.AdminService;
import com.infinite.doctorappointmentsystem.service.AdminServiceImpls;

/**
 * Servlet implementation class ViewDoctorsList
 */
public class ViewDoctorsList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminService adminService = new AdminServiceImpls();
		List<Doctor> doctorList = adminService.viewAllDoctors();
		request.setAttribute("doctorList", doctorList);
		RequestDispatcher rd = request.getRequestDispatcher("ViewDoctor.jsp");
		rd.forward(request, response);
	}

}
