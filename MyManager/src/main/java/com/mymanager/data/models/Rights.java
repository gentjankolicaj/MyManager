package com.mymanager.data.models;

/**
 * 
 * @author gentjan koli�aj
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
