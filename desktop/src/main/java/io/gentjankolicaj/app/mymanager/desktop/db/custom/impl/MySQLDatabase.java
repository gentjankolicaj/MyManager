package io.gentjankolicaj.app.mymanager.desktop.db.custom.impl;

import io.gentjankolicaj.app.mymanager.desktop.db.custom.Database;

/**
 * @author gentjan kolicaj
 */
public class MySQLDatabase extends Database {

	private static final String driverName = "com.mysql.cj.jdbc.Driver";
	private static final String api = "jdbc";
	private static final boolean ssl = false;
	private static final String databaseType = "mysql";
	private static final String server = "localhost";
	private static final int port = 3306;

	private static final String user = "root";
	private static final String password = "toor87654321";
	private static final String schema = "mymanager";

	public MySQLDatabase(String driverName, String api, boolean ssl, String databaseType, String server, int port,
			String user, String password, String schema) throws Exception {
		super(driverName, api, ssl, databaseType, server, port, user, password, schema);
	}

	public MySQLDatabase() throws Exception {
		super(driverName, api, ssl, databaseType, server, port, user, password, schema);
	}


}
