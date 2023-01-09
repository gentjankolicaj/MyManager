package io.gentjankolicaj.app.mymanager.desktop.db.migration;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;
import java.sql.SQLException;

public class LiquibaseMigrator {
    private LiquibaseMigrator() {
    }

    public static void runMigrations() throws SQLException {
        Connection connection = getConnection(); //your openConnection logic
        try {
            Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));

            Liquibase liquibase = new Liquibase("path/to/changelog.sql", new ClassLoaderResourceAccessor(), database);

            liquibase.update(new Contexts(), new LabelExpression());
        } catch (Exception e) {
            e.printStackTrace();
            if (connection != null) {
                connection.rollback();
                connection.close();
            }
        }
    }

    private static Connection getConnection() {
        return null;
    }

}
