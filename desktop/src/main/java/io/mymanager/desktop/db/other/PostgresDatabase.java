package io.mymanager.desktop.db.other;

import static java.util.Objects.nonNull;

import io.mymanager.commons.db.Database;
import io.mymanager.desktop.yaml.DatabaseConfigYaml;

/**
 * @author gentjan kolicaj
 */
public class PostgresDatabase extends Database {


  public PostgresDatabase(String driverName, String api, boolean ssl, String databaseType,
      String server, int port,
      String user, String password, String schema) throws Exception {
    super(driverName, api, ssl, databaseType, server, port, user, password, schema);
  }


  public PostgresDatabase() throws Exception {
    super();
  }

  public PostgresDatabase(DatabaseConfigYaml databaseConfigYaml) {
    super(databaseConfigYaml);
  }


  @Override
  public void migrate() {

  }

  @Override
  public boolean isConnected() {
    return nonNull(connection);
  }
}
