package com.mymanager.data.database;

/**
 * 
 * @author gentjan koli�aj
 *
 */
public enum RDBMSType {
	MySQL("MySQL"), ORACLE("ORACLE"), PostgreSQL(" PostgreSQL");

	private String value;

	private RDBMSType(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}
}
