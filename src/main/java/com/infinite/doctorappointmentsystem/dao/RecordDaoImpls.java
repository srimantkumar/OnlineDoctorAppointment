package com.infinite.doctorappointmentsystem.dao;

import java.util.ArrayList;
import java.util.Date;
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
import com.infinite.doctorappointmentsystem.utils.HibernateUtils;

public class RecordDaoImpls implements RecordDao{

	private static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session session = null;
	Transaction transaction = null;
	CheckUpRecord record=null;
	Doctor doctor=null;
	
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
	
	public List<String> doctorAvailabilityStatus(Date date , int docId) {
		List<String> returnValues = new ArrayList<String>();
		
		int count=0;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<CheckUpRecord> query = builder.createQuery(CheckUpRecord.class);
			Root<CheckUpRecord> root = query.from(CheckUpRecord.class);
			query.select(root);
			Query<CheckUpRecord> q = session.createQuery(query);
			List<CheckUpRecord> record = q.getResultList();

			for (CheckUpRecord rec : record) {
				if (rec.getDate()==date && rec.getId()==docId) {
					count++;
				}
			}
			DoctorDao doctorDao = new DoctorDaoImpls();
			doctor = doctorDao.getDoctorUser(docId);
			String open_time=doctor.getFrom_time();
			String close_time = doctor.getTo_time();
			String[] open_time_split=open_time.split(":");
			String[] close_time_split=close_time.split(":");
			
			//Slot availability check from time slot
			int hour=0;
			int min=0;
			int calculate_slot=0;
			if(open_time_split[2].contentEquals(close_time_split[2])) {
				hour=Integer.parseInt(close_time_split[0]) - Integer.parseInt(open_time_split[0]);
				min=Integer.parseInt(close_time_split[1]) - Integer.parseInt(open_time_split[1]);
				calculate_slot=2*hour;
				if(min>0)
					calculate_slot++;
				else if(min<0)
					calculate_slot--;
			}
			else {
				hour= (12-Integer.parseInt(open_time_split[0]))+Integer.parseInt(close_time_split[0]);
				min=Integer.parseInt(close_time_split[1]) - Integer.parseInt(open_time_split[1]);
				calculate_slot=2*hour;
				if(min>0)
					calculate_slot++;
				else if(min<0)
					calculate_slot--;
			}
			
			if(calculate_slot > count) {
				returnValues.set(0, "available");
				
				//Appointment time allotment automatically.
				int intOfOpenHour = Integer.parseInt(open_time_split[0]);
				int intOfOpenMin  = Integer.parseInt(open_time_split[1]);
				String finalHourTime ;
				String finalMinTime ;
				String finalNotationTime ;
				
				if(intOfOpenMin == 0) {
					if(count%2 == 0) {
						finalHourTime = String.valueOf(intOfOpenHour + (count/2)); //if change from am to pm or vice-versa.
						finalMinTime  = String.valueOf(intOfOpenMin);
					}
					else {
						finalHourTime = String.valueOf(intOfOpenHour + (count/2));
						finalMinTime  = String.valueOf(intOfOpenMin + 30); 
					}
				}
				else {
					if(count%2 == 0) {
						finalHourTime = String.valueOf(intOfOpenHour + (count/2)); //if change from am to pm or vice-versa.
						finalMinTime  = String.valueOf(intOfOpenMin); 
					}
					else {
						finalHourTime = String.valueOf(intOfOpenHour + (count/2) + 1);
						finalMinTime  = String.valueOf(intOfOpenMin - 30);
					}
				}
			}
			else
				returnValues.set(0, "unavailable");
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			returnValues.set(0, "unavailable");
			return returnValues;
		} finally {
			session.close();
		}
		return returnValues;
	}

	public CheckUpRecord viewRecordByDoctor(int id) {
		
		return null;
	}
}
