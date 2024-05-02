package com.infinite.doctorappointmentsystem.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	@Column(nullable = false)
	private String patientName;
	@Column
	private String patientEmail;
	@Column(nullable = false)
	private Date patientDOB;
	@Column(nullable = false)
	private String patientGender;
	@Column(nullable = false)
	private String patientMobileNo;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false)
	private String patientAddress;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public Date getPatientDOB() {
		return patientDOB;
	}

	public void setPatientDOB(Date patientDOB) {
		this.patientDOB = patientDOB;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public String getPatientMobileNo() {
		return patientMobileNo;
	}

	public void setPatientMobileNo(String patientMobileNo) {
		this.patientMobileNo = patientMobileNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

}
