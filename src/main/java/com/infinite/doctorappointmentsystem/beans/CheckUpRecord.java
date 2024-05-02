package com.infinite.doctorappointmentsystem.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CheckUpRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String doctorName;
	@Column(nullable = false)
	private String patientName;
	@Column(nullable = false)
	private String location;
	@Column(nullable = false)
	private String specialization;
	@Column(nullable = false)
	private Date date;
	@Column(nullable = false)
	private String appointmentTime;
	@Column(nullable = false)
	private int fees;
	@Column
	private String checkUpStatus;
	@Column
	private String feedback;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getCheckUpStatus() {
		return checkUpStatus;
	}

	public void setCheckUpStatus(String checkUpStatus) {
		this.checkUpStatus = checkUpStatus;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	

	
}
