package com.infinite.doctorappointmentsystem.service;

import java.util.List;

import com.infinite.doctorappointmentsystem.beans.CheckUpRecord;
import com.infinite.doctorappointmentsystem.beans.Doctor;
import com.infinite.doctorappointmentsystem.beans.Patient;
import com.infinite.doctorappointmentsystem.dao.AdminDao;
import com.infinite.doctorappointmentsystem.dao.AdminDaoImpls;

public class AdminServiceImpls implements AdminService {
	
	private AdminDao adminDao = new AdminDaoImpls();

	public List<Patient> viewAllPatients() {
		
		return adminDao.viewAllPatients();
	}

	public List<Doctor> viewAllDoctors() {
		
		return adminDao.viewAllDoctors();
	}

	public List<CheckUpRecord> checkUpRecordHistory() {
		
		return adminDao.checkUpRecordHistory();
	}

	public List<CheckUpRecord> bookingSummary() {
		
		return adminDao.bookingSummary();
	}

}
