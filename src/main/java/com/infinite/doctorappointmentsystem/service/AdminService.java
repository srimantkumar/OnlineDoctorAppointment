package com.infinite.doctorappointmentsystem.service;

import java.util.List;

import com.infinite.doctorappointmentsystem.beans.CheckUpRecord;
import com.infinite.doctorappointmentsystem.beans.Doctor;
import com.infinite.doctorappointmentsystem.beans.Patient;

public interface AdminService {
	public List<Patient> viewAllPatients();

	public List<Doctor> viewAllDoctors();

	public List<CheckUpRecord> checkUpRecordHistory();

	public List<CheckUpRecord> bookingSummary();
}
