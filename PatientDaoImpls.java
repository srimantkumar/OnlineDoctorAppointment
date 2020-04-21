package com.infinite.doctorappointmentsystem.dao;

import java.util.ArrayList;
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
import com.infinite.doctorappointmentsystem.beans.PatientCredentials;
import com.infinite.doctorappointmentsystem.utils.HibernateUtils;

public class PatientDaoImpls implements PatientDao {

	private static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session session = null;
	Transaction transaction = null;
	Patient patient;
	Doctor doctor;

	public String insertPatient(Patient pat) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(pat);
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

	public String insertPatientCred(PatientCredentials pc) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(pc);
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

	public String validatePatient(String username, String password) {

		int flag = 0;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<PatientCredentials> query = builder.createQuery(PatientCredentials.class);
			Root<PatientCredentials> root = query.from(PatientCredentials.class);
			query.select(root);
			Query<PatientCredentials> q = session.createQuery(query);
			List<PatientCredentials> patients = q.getResultList();

			for (PatientCredentials patient : patients) {
				if (patient.getUserName().contentEquals(username) && patient.getPassword().contentEquals(password)) {
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
		int docid = 0;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<PatientCredentials> query = builder.createQuery(PatientCredentials.class);
			Root<PatientCredentials> root = query.from(PatientCredentials.class);
			query.select(root);
			Query<PatientCredentials> q = session.createQuery(query);
			List<PatientCredentials> patcred = q.getResultList();

			for (PatientCredentials pc : patcred) {
				if (pc.getUserName().contentEquals(userName)) {
					docid = pc.getId();
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

	public Patient getPatientUser(int id) {
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Patient> query = builder.createQuery(Patient.class);
			Root<Patient> root = query.from(Patient.class);
			query.select(root);
			Query<Patient> q = session.createQuery(query);
			List<Patient> patients = q.getResultList();

			for (Patient pat : patients) {
				if (pat.getPatientId() == id) {
					patient=pat;
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
		return patient;
	}

	public List<Doctor> searchDoctor(String catagory, String location) {
		List<Doctor> filterDoctor = new ArrayList<Doctor>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Doctor> query = builder.createQuery(Doctor.class);
			Root<Doctor> root = query.from(Doctor.class);
			query.select(root);
			Query<Doctor> q = session.createQuery(query);
			List<Doctor> doctors = q.getResultList();

			for (Doctor doctor : doctors) {
				if (doctor.getCatagory().contentEquals(catagory) && doctor.getLocation().contentEquals(location)) {
					filterDoctor.add(doctor);
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
		return filterDoctor;
	}

	public String insertRecord(CheckUpRecord rec) {
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(rec);
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

	public String deletePatient(String patientName) {
		return null;
	}

	public String updatePatient(Patient pat) {

		return null;
	}

	public Patient getPatient(String patientId) {

		return null;
	}

	public List<Patient> getAllPatients() {

		return null;
	}

}
