package com.mymanager.data.database;

/**
 * 
 * @author gentjan_kolicaj
 *
 */
public class ConnectionUrlBuilder {

	private String api;
	private String database;
	private String server;
	private int port;
	private String schema;

	/**
	 * 
	 */
	public ConnectionUrlBuilder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConnectionUrlBuilder setApi(String api) {
		this.api = api;
		return this;
	}

	public ConnectionUrlBuilder setDatabase(String database) {
		this.database = database;
		return this;
	}

	public ConnectionUrlBuilder setServer(String server) {
		this.server = server;
		return this;
	}

	public ConnectionUrlBuilder setPort(int port) {
		this.port = port;
		return this;
	}

	public ConnectionUrlBuilder setSchema(String schema) {
		this.schema = schema;
		return this;
	}

	public String build() {
		if (api == null) {
			api = "jdbc";
			if (database == null) {
				database = "mysql";
				if (server == null) {
					server = "localhost";
					if (port == 0) {
						port = 3306;
						schema = "";
					}
				}
			}
		}

		return new StringBuilder().append(api).append(":").append(database).append("://").append(server).append(":")
				.append(port).append("/").append(schema).toString();

	}

}
