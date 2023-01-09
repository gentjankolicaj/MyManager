package io.gentjankolicaj.app.mymanager.desktop.db.custom;

import io.gentjankolicaj.app.mymanager.desktop.enums.PrintType;
import io.gentjankolicaj.app.mymanager.desktop.util.PrintUtils;

import java.sql.*;
import java.util.List;

/**
 * 
 * @author gentjan_kolicaj
 *
 */
public class Database implements Connectable {

	private final String driverName;
	private final String api;
	private boolean ssl;
	private final String databaseType;
	private final String server;
	private final int port;
	private final String user;
	private final String password;
	private final String schema;
	private String url;

	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;

	/**
	 * @param driverName
	 * @param api
	 * @param databaseType
	 * @param server
	 * @param user
	 * @param password
	 * @param schema
	 * @throws Exception
	 */
	public Database(String driverName, String api, boolean ssl, String databaseType, String server, int port,
			String user, String password, String schema) throws Exception {
		super();
		this.driverName = driverName;
		this.api = api;
		this.ssl = ssl;
		this.databaseType = databaseType;
		this.server = server;
		this.port = port;
		this.user = user;
		this.password = password;
		this.schema = schema;

		initDriver();
	}

	@Override
	public void initDriver() throws Exception {
		Class.forName(driverName);

	}

	@Override
	public void connect() throws Exception {
		url = new ConnectionUrlBuilder().setApi(api).setDatabase(databaseType).setServer(server).setPort(port)
				.setSchema(schema).setSSL(ssl).build();
		connection = DriverManager.getConnection(url, user, password);
		PrintUtils.print("--> Connected : " + url, PrintType.DATABASE_IO);

	}

	@Override
	public void disconnect() throws Exception {
		if (connection != null) {
			connection.close();
			PrintUtils.print("--> Disconnected : " + url, PrintType.DATABASE_IO);

		}

	}

	public ResultSet selectStatement(String query) throws SQLException {
		ResultSet resultSet = null;
		statement = connection.createStatement();
		resultSet = statement.executeQuery(query);
		return resultSet;
	}

	public PreparedStatement updateStatement(String query) throws SQLException {
		preparedStatement = connection.prepareStatement(query);
		return preparedStatement;

	}

	public ResultSet selectStatement(String query, List<Object> objectList) throws SQLException {
		ResultSet resultSet = null;
		preparedStatement = connection.prepareStatement(query);
		for (int i = 1; i < objectList.size() + 1; i++) {
			preparedStatement.setObject(i, objectList.get(i));
		}
		resultSet = preparedStatement.executeQuery();
		return resultSet;
	}

	public boolean isSsl() {
		return ssl;
	}

	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

}
