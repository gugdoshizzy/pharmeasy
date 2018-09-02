package com.pharmeasy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.pharmeasy.model.impl.Patient;

public class PrescriptionUtilityService {

	PatientObserverService patientObsService;
	
	public PrescriptionUtilityService(PatientObserverService pos) {
		this.patientObsService = pos;
	}
	
	public List<String> getPrescription(Patient patient, String userId) {
		
		if (patient == null || userId == null) {
			return null;
		}
		
		boolean isAllowed = patientObsService.isUserAllowed(patient, userId);
		if (isAllowed) {
			List<String> prescriptionList = new ArrayList<>();
			for (Entry<String, String> entry : patient.getDoctorToPrescription().entrySet()) {
				prescriptionList.add(entry.getValue());
			}
			return prescriptionList;
		}
		//TODO  LOG
		return null;
	}	
}