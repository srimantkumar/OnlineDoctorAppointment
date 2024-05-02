package com.infinite.doctorappointmentsystem.service;

import java.util.List;

import com.infinite.doctorappointmentsystem.dao.OtherPatientFunctionalities;
import com.infinite.doctorappointmentsystem.dao.OtherPatientFunctionalitiesImpls;

public class OtherPatientsServiceImpls implements OtherPatientsServices {

	private OtherPatientFunctionalities opf = new OtherPatientFunctionalitiesImpls();
	
	public List getCategoryFromDatabase() {
		
		return opf.getCategoryFromDatabase();
	}

	public List getLocationFromDatabase() {
		
		return opf.getLocationFromDatabase();
	}

}
