package com.infinite.doctorappointmentsystem.dao;

import java.util.List;

import com.infinite.doctorappointmentsystem.beans.CheckUpRecord;
import com.infinite.doctorappointmentsystem.beans.Doctor;
import com.infinite.doctorappointmentsystem.beans.Patient;

public interface AdminDao {
	public List<Patient> viewAllPatients();

	public List<Doctor> viewAllDoctors();

	public List<CheckUpRecord> checkUpRecordHistory();

	public List<CheckUpRecord> bookingSummary();

}
