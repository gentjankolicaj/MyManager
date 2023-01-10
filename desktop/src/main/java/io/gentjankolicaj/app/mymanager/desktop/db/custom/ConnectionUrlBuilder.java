package io.gentjankolicaj.app.mymanager.desktop.db.custom;


/**
 * @author gentjan kolicaj
 */
public final class ConnectionUrlBuilder {

	private String api;
	private String database;
	private String server;
	private int port;
	private String schema;
	private boolean SSL;


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

	public ConnectionUrlBuilder setSSL(boolean sSL) {
		SSL = sSL;
		return this;
	}

	public String build() {
		String sslParam = "";

		if (api == null)
			api = "jdbc";

		if (database == null)
			database = "mysql";

		if (server == null)
			server = "localhost";

		if (port == 0)
			port = 3306;

		if (schema == null)
			schema = "";

		if (SSL)
			sslParam = "?useSSL=true";
		else 
			sslParam="?useSSL=false";

		return api + ":" + database + "://" + server + ":" + port + "/" + schema + sslParam;

	}

}
