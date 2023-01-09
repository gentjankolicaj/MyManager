package io.gentjankolicaj.app.mymanager.desktop.db.custom;

/**
 * @author gentjan kolicaj
 */
public class ConnectionInstanceData {

	private String driverName;
	private String api;
	private boolean ssl;
	private String databaseType;
	private String server;
	private int port;
	private String user;
	private String password;
	private String schema;

	/**
	 * @param rdbmsType
	 * @param driverName
	 * @param api
	 * @param ssl
	 * @param databaseType
	 * @param server
	 * @param port
	 * @param user
	 * @param password
	 * @param schema
	 */
	public ConnectionInstanceData(String driverName, String api, boolean ssl, String databaseType, String server, int port,
			String user, String password, String schema) {
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
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public boolean isSsl() {
		return ssl;
	}

	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

	public String getDatabaseType() {
		return databaseType;
	}

	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

}
