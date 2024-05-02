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

import com.infinite.doctorappointmentsystem.beans.Doctor;
import com.infinite.doctorappointmentsystem.beans.DoctorCredentials;
import com.infinite.doctorappointmentsystem.beans.Patient;
import com.infinite.doctorappointmentsystem.utils.HibernateUtils;

public class DoctorDaoImpls implements DoctorDao {

	private static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session session = null;
	Transaction transaction = null;
	Patient patient;
	Doctor doctor;
	DoctorCredentials doctorCredential;

	public String insertDoctor(Doctor doctor) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(doctor);
			transaction.commit();
			return "success";
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			return "fail";
		} finally {
			session.close();
		}
	}

	public String insertDoctorCred(DoctorCredentials dc) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(dc);
			transaction.commit();
			return "success";
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			return "fail";
		} finally {
			session.close();
		}
	}

	public String validateDoctor(String doctorName, String password) {
		int flag = 0;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<DoctorCredentials> query = builder.createQuery(DoctorCredentials.class);
			Root<DoctorCredentials> root = query.from(DoctorCredentials.class);
			query.select(root);
			Query<DoctorCredentials> q = session.createQuery(query);
			List<DoctorCredentials> doctors = q.getResultList();

			for (DoctorCredentials doctor : doctors) {
				if (doctor.getUserName().contentEquals(doctorName) && doctor.getPassword().contentEquals(password)) {
					flag = 1;
					break;
				}
			}
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		if (flag == 0)
			return "fail";
		else
			return "success";

	}

	public int getCredentialId(String userName) {
		int docid=0;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<DoctorCredentials> query = builder.createQuery(DoctorCredentials.class);
			Root<DoctorCredentials> root = query.from(DoctorCredentials.class);
			query.select(root);
			Query<DoctorCredentials> q = session.createQuery(query);
			List<DoctorCredentials> doccred = q.getResultList();

			for (DoctorCredentials dc : doccred) {
				if (dc.getUserName().contentEquals(userName)) {
					docid=dc.getId();
					break;
				}
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return docid;
		} finally {
			session.close();
		}
		return docid;
	}
	
	public DoctorCredentials getDoctorCredentialsUser(String userName) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<DoctorCredentials> query = builder.createQuery(DoctorCredentials.class);
			Root<DoctorCredentials> root = query.from(DoctorCredentials.class);
			query.select(root);
			Query<DoctorCredentials> q = session.createQuery(query);
			List<DoctorCredentials> doctorCredentials = q.getResultList();

			for (DoctorCredentials doc : doctorCredentials) {
				if (doc.getUserName().contentEquals(userName)) {
					doctorCredential=doc;
					break;
				}
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		} finally {
			session.close();
		}
		return doctorCredential;
	}

	public Doctor getDoctorUser(int docid) {
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Doctor> query = builder.createQuery(Doctor.class);
			Root<Doctor> root = query.from(Doctor.class);
			query.select(root);
			Query<Doctor> q = session.createQuery(query);
			List<Doctor> doctors = q.getResultList();

			for (Doctor doc : doctors) {
				if (doc.getId() == docid) {
					doctor=doc;
					break;
				}
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		} finally {
			session.close();
		}
		return doctor;
	}
	
	public String updateDoctor(Doctor doctor) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(doctor);
			transaction.commit();
			return "success";
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			return "fail";
		} finally {
			session.close();
		}
	}

	public String updateDoctorCred(DoctorCredentials dc) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(dc);
			transaction.commit();
			return "success";
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			return "fail";
		} finally {
			session.close();
		}
	}

}
