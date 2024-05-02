package com.infinite.doctorappointmentsystem.service;

import java.util.Date;
import java.util.List;

import com.infinite.doctorappointmentsystem.beans.CheckUpRecord;
import com.infinite.doctorappointmentsystem.dao.RecordDao;
import com.infinite.doctorappointmentsystem.dao.RecordDaoImpls;

public class RecordServiceImpls implements RecordService{

	RecordDao recordDao=new RecordDaoImpls();
	
	public String insertRecord(CheckUpRecord rec) {
		return recordDao.insertRecord(rec);
	}

	public CheckUpRecord viewRecordByDoctor(int id) {
		
		return null;
	}

	public List<String> doctorAvailabilityStatus(Date date, int docId) {
		
		return recordDao.doctorAvailabilityStatus(date, docId);
	}

}
