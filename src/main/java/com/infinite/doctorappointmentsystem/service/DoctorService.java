package com.infinite.doctorappointmentsystem.service;

import com.infinite.doctorappointmentsystem.beans.Doctor;
import com.infinite.doctorappointmentsystem.beans.DoctorCredentials;

public interface DoctorService {

	public String insertDoctor(Doctor doctor);

	public String insertDoctorCred(DoctorCredentials dc);

	public String validateDoctor(String patientName, String password);

	public int getCredentialId(String userName);
	
	public DoctorCredentials getDoctorCredentialsUser(String userName);

	public Doctor getDoctorUser(int id);
	
	public String updateDoctor(Doctor doctor);
	
	public String updateDoctorCred(DoctorCredentials dc);

}
