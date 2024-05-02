package com.infinite.doctorappointmentsystem.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.infinite.doctorappointmentsystem.beans.CheckUpRecord;
import com.infinite.doctorappointmentsystem.beans.Doctor;
import com.infinite.doctorappointmentsystem.utils.HibernateUtils;

public class OtherPatientFunctionalitiesImpls implements OtherPatientFunctionalities {

	private static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session session = null;
	Transaction transaction = null;
	CheckUpRecord checkUpRecord;

	public List getCategoryFromDatabase() {
		List categoryList = new ArrayList();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Doctor> query = builder.createQuery(Doctor.class);
			Root<Doctor> root = query.from(Doctor.class);
			query.select(root);
			Query<Doctor> q = session.createQuery(query);
			List<Doctor> docs = q.getResultList();

			for (Doctor doc : docs) {
				categoryList.add(doc.getCatagory());
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return categoryList;
		} finally {
			session.close();
		}
		return categoryList;
	}

	public List getLocationFromDatabase() {
		List locationList = new ArrayList();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Doctor> query = builder.createQuery(Doctor.class);
			Root<Doctor> root = query.from(Doctor.class);
			query.select(root);
			Query<Doctor> q = session.createQuery(query);
			List<Doctor> docs = q.getResultList();

			for (Doctor doc : docs) {
				locationList.add(doc.getLocation());
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return locationList;
		} finally {
			session.close();
		}
		return locationList;
	}
	
	

}
