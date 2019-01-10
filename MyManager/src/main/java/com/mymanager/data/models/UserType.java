package com.mymanager.data.models;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public enum UserType {

	HR("HR"), MANAGER("MANAGER"), ADMIN("ADMIN"), FINANCE("FINANCE");

	private String value;

	private UserType(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}
}
