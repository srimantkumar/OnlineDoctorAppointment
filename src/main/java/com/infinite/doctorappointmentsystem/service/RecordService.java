package com.infinite.doctorappointmentsystem.service;

import java.util.Date;
import java.util.List;

import com.infinite.doctorappointmentsystem.beans.CheckUpRecord;

public interface RecordService {
	
	public String insertRecord(CheckUpRecord rec);
	
	public CheckUpRecord viewRecordByDoctor(int id);
	
	public List<String> doctorAvailabilityStatus(Date date , int docId);
	
}
