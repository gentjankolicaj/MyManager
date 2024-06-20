package io.mymanager.desktop.db;

import static java.util.Objects.isNull;

import io.mymanager.commons.db.Database;
import io.mymanager.desktop.yaml.DatabaseConfigYaml;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gentjan kolicaj
 */
@Slf4j
public class DatabaseManager {

  private static Database db;

  private DatabaseManager() {
  }

  public static Database initDb(DatabaseConfigYaml databaseConfigYaml) throws Exception {
    if (isNull(db)) {
      HikariConnectionPoolManager.initPool(databaseConfigYaml);
      db = new GenericDatabase();
      db.migrate();
    }
    return db;
  }

  public static Database getDb() {
    return db;
  }

  public static void shutdown() {
    try {
      HikariConnectionPoolManager.closePool();
    } catch (Exception e) {
      log.error("Error on closing pool.", e);
    }
  }

}
