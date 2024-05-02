package com.infinite.doctorappointmentsystem.dao;

import java.util.Date;
import java.util.List;

import com.infinite.doctorappointmentsystem.beans.CheckUpRecord;

public interface RecordDao {

	public String insertRecord(CheckUpRecord rec);
	
	public CheckUpRecord viewRecordByDoctor(int id);
	
	public List<String> doctorAvailabilityStatus(Date date , int docId);
}
