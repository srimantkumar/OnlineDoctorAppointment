package com.infinite.doctorappointmentsystem.service;

import java.util.List;

import com.infinite.doctorappointmentsystem.beans.CheckUpRecord;
import com.infinite.doctorappointmentsystem.beans.Doctor;
import com.infinite.doctorappointmentsystem.beans.Patient;
import com.infinite.doctorappointmentsystem.beans.PatientCredentials;

public interface PatientService {
	public String insertPatient(Patient user);

	public String insertPatientCred(PatientCredentials pc);

	public String validatePatient(String username, String password);

	public int getCredentialId(String userName);

	public Patient getPatientUser(int id);

	public List<Doctor> searchDoctor(String catagory, String location);

	public String updatePatient(Patient user);

	public Patient getPatient(String userId);

	public String deletePatient(String patientName);

	public List<Patient> getAllPatients();

	public String insertRecord(CheckUpRecord rec);
}
