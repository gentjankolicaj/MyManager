package io.mymanager.commons.db;


/**
 * @author gentjan kolicaj
 */
public final class UrlBuilder {

  private String api;
  private String database;
  private String server;
  private int port;
  private String schema;
  private boolean SSL;


  public UrlBuilder setApi(String api) {
    this.api = api;
    return this;
  }

  public UrlBuilder setDatabase(String database) {
    this.database = database;
    return this;
  }

  public UrlBuilder setServer(String server) {
    this.server = server;
    return this;
  }

  public UrlBuilder setPort(int port) {
    this.port = port;
    return this;
  }

  public UrlBuilder setSchema(String schema) {
    this.schema = schema;
    return this;
  }

  public UrlBuilder setSSL(boolean sSL) {
    SSL = sSL;
    return this;
  }

  public String build() {
    String sslParam = "";

    if (api == null) {
      api = "jdbc";
    }

    if (database == null) {
      database = "mysql";
    }

    if (server == null) {
      server = "localhost";
    }

    if (port == 0) {
      port = 3306;
    }

    if (schema == null) {
      schema = "";
    }

    if (SSL) {
      sslParam = "?useSSL=true";
    } else {
      sslParam = "?useSSL=false";
    }

    return api + ":" + database + "://" + server + ":" + port + "/" + schema + sslParam;

  }

}
