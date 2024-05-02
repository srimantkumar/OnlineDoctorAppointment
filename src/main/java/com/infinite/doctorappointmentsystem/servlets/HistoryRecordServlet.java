package com.infinite.doctorappointmentsystem.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.infinite.doctorappointmentsystem.beans.CheckUpRecord;
import com.infinite.doctorappointmentsystem.beans.Doctor;
import com.infinite.doctorappointmentsystem.beans.Patient;
import com.infinite.doctorappointmentsystem.service.DoctorService;
import com.infinite.doctorappointmentsystem.service.DoctorServiceImpls;
import com.infinite.doctorappointmentsystem.service.RecordService;
import com.infinite.doctorappointmentsystem.service.RecordServiceImpls;

/**
 * Servlet implementation class HistoryRecordServlet
 */
public class HistoryRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);

		int docId = Integer.parseInt(request.getParameter("docid"));
		Patient pat = (Patient) httpSession.getAttribute("patientDetails");
		Date date = (Date) httpSession.getAttribute("date");

		RecordService rs = new RecordServiceImpls();
		List<String> availabilityStatus = rs.doctorAvailabilityStatus(date, docId);
		//String appointmentTime = rs.ap

		if ("available".equals(availabilityStatus.get(0))) {
			CheckUpRecord rec = new CheckUpRecord();
			DoctorService ds = new DoctorServiceImpls();
			Doctor doc = new Doctor();
			doc = ds.getDoctorUser(docId);

			rec.setDoctorName(doc.getDoctorName());
			rec.setPatientName(pat.getPatientName());
			rec.setLocation(doc.getLocation());
			rec.setSpecialization(doc.getCatagory());
			rec.setDate(date);
			rec.setFees(doc.getFees());
			rec.setAppointmentTime("hi");
			rec.setCheckUpStatus("Not Checked");
			rec.setFeedback("Give Feedback");

			String result = rs.insertRecord(rec);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("BookingDetail.jsp");
			if ("success".equals(result)) {
				requestDispatcher.forward(request, response);
			} else {
				requestDispatcher = request.getRequestDispatcher("PatientsRegistration.jsp");
				requestDispatcher.forward(request, response);
			}
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("SearchPage.jsp");
			requestDispatcher.forward(request, response);
		}

	}

}
