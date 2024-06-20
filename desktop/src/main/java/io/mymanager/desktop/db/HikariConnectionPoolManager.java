package io.mymanager.desktop.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.mymanager.desktop.yaml.DatabaseConfigYaml;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;

public final class HikariConnectionPoolManager {

  private static HikariDataSource HIKARI_DATA_SOURCE;

  private HikariConnectionPoolManager() {
  }

  private static HikariConfig getHikariConfig(DatabaseConfigYaml databaseConfigYaml) {
    HikariConfig hikariConfig = new HikariConfig();
    hikariConfig.setJdbcUrl(databaseConfigYaml.getJdbcUrl());
    hikariConfig.setDriverClassName(databaseConfigYaml.getDriverClassName());
    hikariConfig.setUsername(databaseConfigYaml.getUsername());
    hikariConfig.setPassword(databaseConfigYaml.getPassword());

    if (MapUtils.isNotEmpty(databaseConfigYaml.getDatasourceProperties())) {
      for (Map.Entry<String, String> entry : databaseConfigYaml.getDatasourceProperties()
          .entrySet()) {
        hikariConfig.addDataSourceProperty(entry.getKey(), entry.getValue());
      }
    }
    return hikariConfig;
  }

  public static Connection getConnection() throws SQLException {
    return HIKARI_DATA_SOURCE.getConnection();
  }

  public static void initPool(DatabaseConfigYaml databaseConfigYaml) {
    HikariConfig hikariConfig = getHikariConfig(databaseConfigYaml);
    HIKARI_DATA_SOURCE = new HikariDataSource(hikariConfig);
  }

  public static void closePool() {
    HIKARI_DATA_SOURCE.close();
  }
}
