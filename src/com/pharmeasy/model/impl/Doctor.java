package com.pharmeasy.model.impl;

import java.util.ArrayList;
import java.util.List;

public class Doctor
	extends Person {
	
	/** List of Patients Ids **/
	private List<String> patients;
	private Speciality speciality;
	
	protected Doctor(DoctorBuilder doctorBuilder) {
		super(doctorBuilder);
		this.patients = doctorBuilder.patients;
		this.speciality = doctorBuilder.speciality;
	}

	public List<String> getPatients() {
		if (patients == null || patients.isEmpty()) {
			return null;
		}
		
		List<String> patients = new ArrayList<>();
		patients.addAll(patients);
		return patients;
	}
	
	public Speciality getSpeciality() {
		return speciality;
	}
	
	@Override
	public String toString() {
		return "Doctor [patients=" + patients + ", speciality=" + speciality + ", id=" + id
				+ ", name=" + name + ", contactNo=" + contactNo + ", address=" + address + "]";
	}

	public static class DoctorBuilder 
		extends PersonBuilder<DoctorBuilder> {
		
		private List<String> patients;
		private Speciality speciality;
		
		public DoctorBuilder(Speciality speciality) {
			super();
			this.speciality = speciality;
			this.patients = new ArrayList<>();
		}

		public DoctorBuilder(Doctor doc) {
			super(doc);
			this.speciality = doc.speciality;
			this.patients = doc.patients;
		}

		public DoctorBuilder addPatient(String patientId) {

			if (patientId != null) {
				this.patients.add(patientId);
			}
			return self();
		}

	    public DoctorBuilder addSpeciality(Speciality speciality) {
	    	if (speciality != null) {
	    		this.speciality = speciality;
	    	}
	        return self();
	    }
	
	    @SuppressWarnings("unchecked")
		protected DoctorBuilder self() {
	    	return (DoctorBuilder) this;
	    }
	    
	    public Doctor build() {
	        Doctor doc = new Doctor(this);
	        return doc;
		}
	}
	
	public static enum Speciality {
		NEUROLOGY,
		PEDIATRICIAST,
		ENT,
		DENTIST
	}
}