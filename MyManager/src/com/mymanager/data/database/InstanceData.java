package com.mymanager.data.database;

/**
 * 
 * @author gentjan_kolicaj
 *
 */
public class InstanceData {

	private RDBMSType rdbmsType;

	private String driverName;
	private String api;
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
	 * @param databaseType
	 * @param server
	 * @param port
	 * @param user
	 * @param password
	 * @param schema
	 */
	public InstanceData(RDBMSType rdbmsType, String driverName, String api, String databaseType, String server,
			int port, String user, String password, String schema) {
		super();
		this.rdbmsType = rdbmsType;
		this.driverName = driverName;
		this.api = api;
		this.databaseType = databaseType;
		this.server = server;
		this.port = port;
		this.user = user;
		this.password = password;
		this.schema = schema;
	}

	public RDBMSType getRdbmsType() {
		return rdbmsType;
	}

	public String getDriverName() {
		return driverName;
	}

	public String getApi() {
		return api;
	}

	public String getDatabaseType() {
		return databaseType;
	}

	public String getServer() {
		return server;
	}

	public int getPort() {
		return port;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public String getSchema() {
		return schema;
	}

}
