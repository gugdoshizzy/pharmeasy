package com.pharmeasy.model.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Patient
	extends Person {

	/**Map of Doctor Id to Prescription**/
	private Map<String, String> doctorToPrescription;
	private List<String> medicalRecords;
	
	private Patient(PatientBuilder patientBuilder) {
		super(patientBuilder);
		this.doctorToPrescription = patientBuilder.doctorToPrescription;
		this.medicalRecords = patientBuilder.medicalRecords;
	}
	
	public Map<String, String> getDoctorToPrescription() {
		if (this.doctorToPrescription.isEmpty()) {
			return null; 
		}
		Map<String, String> resultMap = new HashMap<>();
		for (Entry<String, String> entry : this.doctorToPrescription.entrySet()) {
			resultMap.put(entry.getKey(), entry.getValue());
		}
		return resultMap;
	}

	public List<String> getMedicalRecords() {
		if (this.medicalRecords.isEmpty()) {
			return null;
		}
		List<String> resultList = new ArrayList<>();
		for (String medicalRec : resultList) {
			resultList.add(medicalRec);
		}
		return resultList;
	}
	
	@Override
	public String toString() {
		return "Patient [doctorToPrescription=" + doctorToPrescription + ", medicalRecords=" + medicalRecords + ", id="
				+ id + ", name=" + name + ", contactNo=" + contactNo + ", address=" + address + "]";
	}

	public static class PatientBuilder 
		extends PersonBuilder<PatientBuilder> {

		//private Patient patient;
		private Map<String, String> doctorToPrescription;
		private List<String> medicalRecords;
		
		public PatientBuilder() {
			super();
			//this.patient = new Patient();
			this.doctorToPrescription = new HashMap<>();
			this.medicalRecords = new ArrayList<>();
		}

		public PatientBuilder(Patient patient) {
			super(patient);
			this.doctorToPrescription = patient.doctorToPrescription;
			this.medicalRecords = patient.medicalRecords;
		}

		public PatientBuilder addDoctorToPrescription 
			(String doctor, String prescription) {
			
			if (doctor != null) {
				this.doctorToPrescription.put(doctor, prescription);
			}
			return self();
    	}

        public PatientBuilder addMedicalRecord(String medicalRecord) {
        	if (medicalRecord != null && medicalRecord.isEmpty()) {
//				patient.medicalRecords.add(medicalRecord);
        		this.medicalRecords.add(medicalRecord);
        	}
            return self();
        }

        @SuppressWarnings("unchecked")
		protected PatientBuilder self() {
        	return this;
        }
        
        public Patient build() {
        	Patient p = new Patient(this);
        	return p;
        }
	}
}