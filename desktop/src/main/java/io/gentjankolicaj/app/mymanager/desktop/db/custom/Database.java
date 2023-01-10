package io.gentjankolicaj.app.mymanager.desktop.db.custom;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.sql.*;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
@Slf4j
public abstract class Database implements Connectable {

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
		log.info("Connected : " + url);
	}

	@Override
	public void disconnect() throws Exception {
		if (connection != null) {
			connection.close();
			log.info("Disconnected : " + url);
		}
	}

	public ResultSet selectStatement(String query) throws SQLException {
		return connection.createStatement().executeQuery(query);
	}

	public PreparedStatement updateStatement(String query) throws SQLException {
		return connection.prepareStatement(query);
	}

	public ResultSet selectStatement(String query, List<Object> list) throws SQLException {
		if (CollectionUtils.isEmpty(list))
			throw new SQLException("Error list of objects empty");

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		for (int i = 1, len = list.size(); i < len + 1; i++) {
			preparedStatement.setObject(i, list.get(i));
		}
		return preparedStatement.executeQuery();
	}

	public boolean isSsl() {
		return ssl;
	}

	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

}
