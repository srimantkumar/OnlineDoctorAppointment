package com.infinite.doctorappointmentsystem.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infinite.doctorappointmentsystem.beans.CheckUpRecord;
import com.infinite.doctorappointmentsystem.service.AdminService;
import com.infinite.doctorappointmentsystem.service.AdminServiceImpls;

/**
 * Servlet implementation class ViewCheckUpHistoryList
 */
public class ViewCheckUpHistoryList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminService adminService = new AdminServiceImpls();
		List<CheckUpRecord> checkUpHistoryList = adminService.checkUpRecordHistory();
		request.setAttribute("checkUpHistoryList", checkUpHistoryList);
		RequestDispatcher rd = request.getRequestDispatcher("ViewPatient.jsp");
		rd.forward(request, response);
	}

}
