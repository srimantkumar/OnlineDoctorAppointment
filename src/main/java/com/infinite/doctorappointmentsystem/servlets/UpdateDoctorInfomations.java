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

import com.infinite.doctorappointmentsystem.beans.Doctor;
import com.infinite.doctorappointmentsystem.beans.DoctorCredentials;
import com.infinite.doctorappointmentsystem.service.DoctorService;
import com.infinite.doctorappointmentsystem.service.DoctorServiceImpls;

/**
 * Servlet implementation class UpdateDoctorInfomations
 */
public class UpdateDoctorInfomations extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DoctorService service = new DoctorServiceImpls();

		String doctorName = request.getParameter("doctorName");
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String location = request.getParameter("location");
		String gender = request.getParameter("gender");
		String mail_id = request.getParameter("mailId");
		String category = request.getParameter("catagory");
		String from_time = request.getParameter("fromTime");
		String to_time = request.getParameter("toTime");
		int fees = Integer.parseInt(request.getParameter("fees"));
		String mobile_no = request.getParameter("mobileNum");
		int experience = Integer.parseInt(request.getParameter("experience"));
		Date doctorDOB = null;
		try {
			doctorDOB = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("dob"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Doctor doctor = new Doctor();
		DoctorCredentials dc = new DoctorCredentials();

		doctor.setDoctorName(doctorName);
		dc.setUserName(uname);
		dc.setPassword(password);
		doctor.setMail_id(mail_id);
		doctor.setCatagory(category);
		doctor.setExperience(experience);
		doctor.setLocation(location);
		doctor.setFees(fees);
		doctor.setFrom_time(from_time);
		doctor.setTo_time(to_time);
		doctor.setGender(gender);
		doctor.setMobile_no(mobile_no);
		doctor.setDate(doctorDOB);

		String result1 = service.updateDoctorCred(dc);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("DoctorHome.jsp");
		if ("success".equals(result1)) {
			String result = service.updateDoctor(doctor);
			if ("success".equals(result)) {
				requestDispatcher.forward(request, response);
			}
		} else {
			requestDispatcher = request.getRequestDispatcher("UpdateDoctorForm.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
