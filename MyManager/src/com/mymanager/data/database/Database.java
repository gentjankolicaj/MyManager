package com.mymanager.data.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

/**
 * 
 * @author gentjan_kolicaj
 *
 */
public class Database implements Connectable {

	private final String driverName;
	private String api;
	private String databaseType;
	private String server;
	private int port;
	private String user;
	private String password;
	private String schema;

	private Connection connection;

	/**
	 * @param driverName
	 * @param api
	 * @param databaseType
	 * @param server
	 * @param user
	 * @param password
	 * @param schema
	 */
	public Database(String driverName, String api, String databaseType, String server, int port, String user,
			String password, String schema) {
		super();
		this.driverName = driverName;
		this.api = api;
		this.databaseType = databaseType;
		this.server = server;
		this.port = port;
		this.user = user;
		this.password = password;
		this.schema = schema;
	}

	@Override
	public void initDriver() {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			PrintUtils.print(e, PrintType.EXCEPTION);
		}

	}

	@Override
	public void connect() {
		try {
			String url = new ConnectionUrlBuilder().setApi(api).setDatabase(databaseType).setServer(server)
					.setPort(port).setSchema(schema).build();
			PrintUtils.print(url, PrintType.LOG);
			connection = DriverManager.getConnection(url, user, password);

		} catch (SQLException sqle) {
			PrintUtils.print(sqle, PrintType.EXCEPTION);
		}

	}

	@Override
	public void disconnect() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException sqle) {
				PrintUtils.print(sqle, PrintType.EXCEPTION);

			}
		}

	}

	@Override
	public void start() {
		initDriver();
		connect();

	}

	@Override
	public void stop() {
		disconnect();

	}

}
