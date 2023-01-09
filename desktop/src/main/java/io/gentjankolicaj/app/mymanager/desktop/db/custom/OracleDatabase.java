package io.gentjankolicaj.app.mymanager.desktop.db.custom;

/**
 * @author gentjan kolicaj
 */
public class OracleDatabase extends Database {

	private static final String driverName = "oracle.jdbc.driver.OracleDriver";
	private static final String api = "jdbc";
	private static final boolean ssl = false;
	private static final String databaseType = "oracle:thin";
	private static final String server = "localhost";
	private static final int port = 1521;

	private static final String user = "root";
	private static final String password = "toor8";
	private static final String schema = "mymanager";

	public OracleDatabase(String driverName, String api, boolean ssl, String databaseType, String server, int port,
			String user, String password, String schema) throws Exception {
		super(driverName, api, ssl, databaseType, server, port, user, password, schema);
		// TODO Auto-generated constructor stub
	}

	public OracleDatabase() throws Exception {
		super(driverName, api, ssl, databaseType, server, port, user, password, schema);
		// TODO Auto-generated constructor stub
	}

}
