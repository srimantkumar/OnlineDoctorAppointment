package com.infinite.doctorappointmentsystem.service;

import com.infinite.doctorappointmentsystem.beans.Doctor;
import com.infinite.doctorappointmentsystem.beans.DoctorCredentials;
import com.infinite.doctorappointmentsystem.dao.DoctorDao;
import com.infinite.doctorappointmentsystem.dao.DoctorDaoImpls;

public class DoctorServiceImpls implements DoctorService {

	private DoctorDao doctorDao = new DoctorDaoImpls();

	public String insertDoctor(Doctor doctor) {
		return doctorDao.insertDoctor(doctor);

	}

	public String insertDoctorCred(DoctorCredentials dc) {
		return doctorDao.insertDoctorCred(dc);

	}

	public String validateDoctor(String patientName, String password) {
		return doctorDao.validateDoctor(patientName, password);
	}

	public int getCredentialId(String userName) {
		return doctorDao.getCredentialId(userName);
	}
	
	public DoctorCredentials getDoctorCredentialsUser(String userName) {
		return doctorDao.getDoctorCredentialsUser(userName);
	}

	public Doctor getDoctorUser(int id) {
		return doctorDao.getDoctorUser(id);
	}

	public String updateDoctor(Doctor doctor) {
		
		return doctorDao.updateDoctor(doctor);
	}

	public String updateDoctorCred(DoctorCredentials dc) {
		
		return doctorDao.updateDoctorCred(dc);
	}

}
