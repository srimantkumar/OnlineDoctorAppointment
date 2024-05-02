package com.infinite.doctorappointmentsystem.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.infinite.doctorappointmentsystem.beans.CheckUpRecord;
import com.infinite.doctorappointmentsystem.beans.Doctor;
import com.infinite.doctorappointmentsystem.beans.Patient;
import com.infinite.doctorappointmentsystem.utils.HibernateUtils;

public class AdminDaoImpls implements AdminDao {
	
	private static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session session = null;
	Transaction transaction = null;
	Patient patient;
	Doctor doctor;

	public List<Patient> viewAllPatients() {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Patient> query = builder.createQuery(Patient.class);
			Root<Patient> root = query.from(Patient.class);
			query.select(root);
			Query<Patient> q = session.createQuery(query);
			List<Patient> patients = q.getResultList();
			transaction.commit();
			return patients;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		} finally {
			session.close();
		}
	}

	public List<Doctor> viewAllDoctors() {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Doctor> query = builder.createQuery(Doctor.class);
			Root<Doctor> root = query.from(Doctor.class);
			query.select(root);
			Query<Doctor> q = session.createQuery(query);
			List<Doctor> doctors = q.getResultList();
			transaction.commit();
			return doctors;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		
	}

	public List<CheckUpRecord> checkUpRecordHistory() {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<CheckUpRecord> query = builder.createQuery(CheckUpRecord.class);
			Root<CheckUpRecord> root = query.from(CheckUpRecord.class);
			query.select(root);
			Query<CheckUpRecord> q = session.createQuery(query);
			List<CheckUpRecord> checkUpRecords = q.getResultList();
			transaction.commit();
			return checkUpRecords;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	public List<CheckUpRecord> bookingSummary() {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<CheckUpRecord> query = builder.createQuery(CheckUpRecord.class);
			Root<CheckUpRecord> root = query.from(CheckUpRecord.class);
			query.select(root);
			Query<CheckUpRecord> q = session.createQuery(query);
			List<CheckUpRecord> bookingSummary = q.getResultList();
			transaction.commit();
			return bookingSummary;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

}
