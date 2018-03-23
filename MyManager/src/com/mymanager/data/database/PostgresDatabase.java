package com.mymanager.data.database;

/**
 * 
 * @author gentjan_kolicaj
 *
 */
public class PostgresDatabase extends Database {

	private static final String driverName = "org.postgresql.Driver";
	private static final String api = "jdbc";
	private static final String databaseType = "postgresql";
	private static final String server = "localhost";
	private static final int port = 5432;

	private static final String user = "root";
	private static final String password = "toor8";
	private static final String schema = "mymanager";

	public PostgresDatabase(String driverName, String api, String databaseType, String server, int port, String user,
			String password, String schema) {
		super(driverName, api, databaseType, server, port, user, password, schema);
		// TODO Auto-generated constructor stub
	}

	public PostgresDatabase() {
		super(driverName, api, databaseType, server, port, user, password, schema);
		// TODO Auto-generated constructor stub
	}

}
