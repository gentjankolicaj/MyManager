package io.mymanager.desktop.db.migration;

import java.sql.Connection;
import java.sql.SQLException;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

public class LiquibaseMigrator {

  private LiquibaseMigrator() {
  }

  public static void runMigrations(Connection connection) throws SQLException {
    try {
      Database database = DatabaseFactory.getInstance()
          .findCorrectDatabaseImplementation(new JdbcConnection(connection));
      Liquibase liquibase = new Liquibase("liquibase/master-changelog.xml",
          new ClassLoaderResourceAccessor(), database);
      liquibase.update(new Contexts(), new LabelExpression());
    } catch (Exception e) {
      e.printStackTrace();
      if (connection != null) {
        connection.rollback();
      }
    }
  }


}
