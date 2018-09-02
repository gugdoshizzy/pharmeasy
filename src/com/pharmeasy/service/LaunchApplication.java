package com.pharmeasy.service;

import com.pharmeasy.model.impl.Doctor;
import com.pharmeasy.model.impl.Doctor.Speciality;
import com.pharmeasy.model.impl.Patient;
import com.pharmeasy.model.impl.Pharmasict;

/**
 * Basic user case added.
 * Step 1 - creates a patient.
 * Step 2 - creates a doctor.
 * Step 3 - patient gets a prescription by doctor.
 * Step 4 - creates a pharmasict
 * Step 5 - pharmasict asks for patient prescription (No data shown as he hasnt subscribed to patient)
 * Step 6 - pharmasict subscribes to patient1 (say patient approves)
 * Step 7-  pharmasict is able to view patient prescription.
 * 
 * @author arunima
 */
public class LaunchApplication {

	static final PatientObserverService pos = new PatientObserverService();
	static final PrescriptionUtilityService pus = new PrescriptionUtilityService(pos);
	
	public static void main(String args[]) {
		
		//Step 1 - Creating one patient.
		Patient patient1 = new Patient.PatientBuilder()
									 .addName("Patient 1")
									 .addContactNo(123456789l)
									 .build();
		
		//Step 2 - Creating one doctor
		Doctor doctor1 = new Doctor.DoctorBuilder(Speciality.DENTIST)
								   .addName("Dentist Doc")
								   .addPatient(patient1.getId())
								   
								   .build();
		
		//Step 3 - Doctor writing some prescription to patient1
		patient1 = new Patient.PatientBuilder(patient1)
									.addDoctorToPrescription(doctor1.getId(), "Prescripton written by doc1 to patient1")
									.build();
		
		
		//Step 4 - Creating one pharmasict.
		Pharmasict pharmasict1 = new Pharmasict.PharmasictBuilder()
									.addDegree("B.Pharama")
									.build();
		
		// Step 5
		System.out.println(pus.getPrescription(patient1, pharmasict1.getId()));
		
		
		//Step 6 Pharmasict subscribes to patient1 data.
		pos.addUsers(patient1, pharmasict1.getId());
		
		//Step 7
		System.out.println(pus.getPrescription(patient1, pharmasict1.getId()));
	}
}
