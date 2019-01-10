package com.mymanager.data.models;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public enum Rights {

	READ("READ"), WRITE("WRITE"), UPDATE("UPDATE"), DELETE("DELETE");

	private String value;

	private Rights(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}
}
