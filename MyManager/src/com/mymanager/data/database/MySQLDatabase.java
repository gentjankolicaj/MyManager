package com.mymanager.data.database;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class MySQLDatabase extends Database {

	private static final String driverName = "com.mysql.jdbc.Driver";
	private static final String api = "jdbc";
	private static final boolean ssl = false;
	private static final String databaseType = "mysql";
	private static final String server = "localhost";
	private static final int port = 3306;

	private static final String user = "root";
	private static final String password = "toor8";
	private static final String schema = "mymanager";

	public MySQLDatabase(String driverName, String api, boolean ssl, String databaseType, String server, int port,
			String user, String password, String schema) throws Exception {
		super(driverName, api, ssl, databaseType, server, port, user, password, schema);
		// TODO Auto-generated constructor stub
	}

	public MySQLDatabase() throws Exception {
		super(driverName, api, ssl, databaseType, server, port, user, password, schema);
	}

}
