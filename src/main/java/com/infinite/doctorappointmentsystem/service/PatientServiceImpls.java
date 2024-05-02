package com.infinite.doctorappointmentsystem.service;

import java.util.List;

import com.infinite.doctorappointmentsystem.beans.CheckUpRecord;
import com.infinite.doctorappointmentsystem.beans.Doctor;
import com.infinite.doctorappointmentsystem.beans.Patient;
import com.infinite.doctorappointmentsystem.beans.PatientCredentials;
import com.infinite.doctorappointmentsystem.dao.PatientDao;
import com.infinite.doctorappointmentsystem.dao.PatientDaoImpls;

public class PatientServiceImpls implements PatientService {

	private PatientDao patientDao = new PatientDaoImpls();

	public String insertPatient(Patient patient) {
		return patientDao.insertPatient(patient);
	}

	public String insertPatientCred(PatientCredentials pc) {
		return patientDao.insertPatientCred(pc);
	}

	public String validatePatient(String username, String password) {

		return patientDao.validatePatient(username, password);
	}

	public int getCredentialId(String userName) {

		return patientDao.getCredentialId(userName);
	}

	public Patient getPatientUser(int id) {
		return patientDao.getPatientUser(id);
	}

	public List<Doctor> searchDoctor(String catagory, String location) {
		return patientDao.searchDoctor(catagory, location);
	}

	public String insertRecord(CheckUpRecord rec) {
		return patientDao.insertRecord(rec);
	}

	public String updatePatient(Patient user) {

		return null;
	}

	public Patient getPatient(String userId) {

		return null;
	}

	public List<Patient> getAllPatients() {

		return null;
	}

	public String deletePatient(String patientName) {

		return null;
	}

}
