package com.mymanager.data.models;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public enum Status {

	SUCCESS("SUCCESS"), FAILURE("FAILURE");

	private String value;

	private Status(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}
}
