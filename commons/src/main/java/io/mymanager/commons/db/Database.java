package io.mymanager.commons.db;

import io.mymanager.commons.yaml.AbstractDatabaseConfigYaml;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @author gentjan kolicaj
 */
@Slf4j
public abstract class Database implements Connectable {

  protected AbstractDatabaseConfigYaml abstractDatabaseConfigYaml;
  protected Connection connection;
  private String driverName;
  private String api;
  private boolean ssl;
  private String databaseType;
  private String server;
  private int port;
  private String user;
  private String password;
  private String schema;
  private String url;


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
  public Database(String driverName, String api, boolean ssl, String databaseType, String server,
      int port,
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

  public Database() {
  }

  public Database(AbstractDatabaseConfigYaml abstractDatabaseConfigYaml) {
    this.abstractDatabaseConfigYaml = abstractDatabaseConfigYaml;
  }

  @Override
  public void initDriver() throws Exception {
    Class.forName(driverName);
  }

  @Override
  public void connect() throws Exception {
    url = new UrlBuilder().setApi(api).setDatabase(databaseType).setServer(server).setPort(port)
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
    if (CollectionUtils.isEmpty(list)) {
      throw new SQLException("Error list of objects empty");
    }

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

  public abstract void migrate();


}
