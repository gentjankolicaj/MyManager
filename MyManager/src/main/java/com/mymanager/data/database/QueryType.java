package com.mymanager.data.database;

public enum QueryType {

	NORMAL("NORMAL"), AUDIT("AUDIT");

	private String value;

	private QueryType(String value) {
		this.value = value;

	}

	public String toString() {
		return value;
	}
}
