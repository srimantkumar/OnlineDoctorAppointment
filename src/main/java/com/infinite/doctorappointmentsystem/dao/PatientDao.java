package com.infinite.doctorappointmentsystem.dao;

import java.util.List;

import com.infinite.doctorappointmentsystem.beans.CheckUpRecord;
import com.infinite.doctorappointmentsystem.beans.Doctor;
import com.infinite.doctorappointmentsystem.beans.Patient;
import com.infinite.doctorappointmentsystem.beans.PatientCredentials;

public interface PatientDao {
	public String insertPatient(Patient pat);

	public String insertPatientCred(PatientCredentials pc);

	public String validatePatient(String username, String password);
	
	public int getCredentialId(String userName);

	public Patient getPatientUser(int id);

	public List<Doctor> searchDoctor(String catagory, String location);

	public String deletePatient(String patientName);

	public String updatePatient(Patient pat);

	public Patient getPatient(String patientId);

	public List<Patient> getAllPatients();

	public String insertRecord(CheckUpRecord rec);

}
