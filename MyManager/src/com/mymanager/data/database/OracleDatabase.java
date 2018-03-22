package com.mymanager.data.database;

/**
 * 
 * @author gentjan_kolicaj
 *
 */
public class OracleDatabase extends Database {

	private static final String driverName = "oracle.jdbc.driver.OracleDriver";
	private static final String api = "jdbc";
	private static final String databaseType = "oracle:thin";
	private static final String server = "localhost";
	private static final int port = 1521;

	private static final String user = "toor8";
	private static final String password = "root8";
	private static final String schema = "mymanager";

	public OracleDatabase(String driverName, String api, String databaseType, String server, int port, String user,
			String password, String schema) {
		super(driverName, api, databaseType, server, port, user, password, schema);
		// TODO Auto-generated constructor stub
	}

	public OracleDatabase() {
		super(driverName, api, databaseType, server, port, user, password, schema);
		// TODO Auto-generated constructor stub
	}

}
