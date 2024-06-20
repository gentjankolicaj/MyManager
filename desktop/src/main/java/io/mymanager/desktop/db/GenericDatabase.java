package io.mymanager.desktop.db;


import io.mymanager.commons.db.Database;
import io.mymanager.desktop.db.migration.LiquibaseMigrator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

@Slf4j
public class GenericDatabase extends Database {

  public GenericDatabase() throws Exception {
    super();
  }

  @Override
  public void connect() throws Exception {
    //Override methods to do nothing because connection is handled by HikariCP
  }

  @Override
  public void disconnect() throws Exception {
    //Override methods to do nothing because connection is handled by HikariCP
  }

  @Override
  public void initDriver() throws Exception {
    //Override methods to do nothing because connection is handled by HikariCP
  }

  @Override
  public boolean isConnected() {
    try {
      return !HikariConnectionPoolManager.getConnection().isClosed();
    } catch (Exception e) {
      log.error("Error ", e);
      return false;
    }
  }

  @Override
  public ResultSet selectStatement(String query) throws SQLException {
    return HikariConnectionPoolManager.getConnection().createStatement().executeQuery(query);
  }

  @Override
  public PreparedStatement updateStatement(String query) throws SQLException {
    return HikariConnectionPoolManager.getConnection().prepareStatement(query);
  }

  @Override
  public ResultSet selectStatement(String query, List<Object> list) throws SQLException {
    if (CollectionUtils.isEmpty(list)) {
      throw new SQLException("Error list of objects empty");
    }

    PreparedStatement preparedStatement = HikariConnectionPoolManager.getConnection()
        .prepareStatement(query);
    for (int i = 1, len = list.size(); i < len + 1; i++) {
      preparedStatement.setObject(i, list.get(i));
    }
    return preparedStatement.executeQuery();
  }

  @Override
  public void migrate() {
    try {
      LiquibaseMigrator.runMigrations(HikariConnectionPoolManager.getConnection());
      log.info("DB migrations finished.");
    } catch (Exception e) {
      log.error("DB migration error", e);
    }
  }


}
