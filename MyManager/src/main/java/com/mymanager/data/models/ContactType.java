package com.mymanager.data.models;

/**
 * 
 * @author gentjan koli�aj
 *
 */
public enum ContactType {

	USER_CONTACT("USER_CONTACT"), EMPLOYEE_CONTACT("EMPLOYEE_CONTACT");

	private String value;

	private ContactType(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}
}
