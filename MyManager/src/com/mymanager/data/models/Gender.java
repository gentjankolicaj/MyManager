package com.mymanager.data.models;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public enum Gender {
	M("M"), F("F"), O("O");

	private String value;

	private Gender(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}

}
