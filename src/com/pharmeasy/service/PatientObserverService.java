package com.pharmeasy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.pharmeasy.model.impl.Patient;

public class PatientObserverService {

	/** Patient Id to allowed user Id's **/
	// Should be ids, but using complete obj for sample testing.
	Map<Patient, List<String>> patientToAllowedUsers;
	
	public PatientObserverService() {
		this.patientToAllowedUsers = new HashMap<>();
	}
	
	public void addUsers(Patient patient, String user) {
		
		if (patient == null || user == null) {
			return;
		}
		
		if (!this.patientToAllowedUsers.containsKey(patient)) {
			this.patientToAllowedUsers.put(patient, new ArrayList<>());
		}
		this.patientToAllowedUsers.get(patient).add(user);
	}
	
	
	public boolean removeUser(Patient patient, String user) {
		
		if (patient == null || user == null) {
			//TODO LOG
			return false;
		}
		
		if (!this.patientToAllowedUsers.containsKey(patient)) {
			//TODO LOG
			return false;
		}
		
		Iterator<String> personItr = this.patientToAllowedUsers.get(patient).iterator();
		while (personItr.hasNext()) {
			String person = personItr.next();
			if (person.equals(user)) {
				personItr.remove();
				return true;
			}
		}
		return false;
	}
	
	public boolean isUserAllowed(Patient patient, String userId) {
		
		if (this.patientToAllowedUsers.containsKey(patient)) {
			Iterator<String> personItr = this.patientToAllowedUsers.get(patient).iterator();
			while (personItr.hasNext()) {
				String personId = personItr.next();
				if (personId.equals(userId)) {
					return true;
				}
			}
		}
		return false;
	}
}