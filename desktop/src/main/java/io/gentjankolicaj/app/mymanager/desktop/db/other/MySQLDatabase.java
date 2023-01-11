package io.gentjankolicaj.app.mymanager.desktop.db.other;

import io.gentjankolicaj.app.mymanager.commons.db.Database;
import io.gentjankolicaj.app.mymanager.desktop.yaml.DatabaseConfigYaml;

import static java.util.Objects.nonNull;

/**
 * @author gentjan kolicaj
 */
public class MySQLDatabase extends Database {


    public MySQLDatabase(String driverName, String api, boolean ssl, String databaseType, String server, int port,
                         String user, String password, String schema) throws Exception {
        super(driverName, api, ssl, databaseType, server, port, user, password, schema);
    }

    public MySQLDatabase() throws Exception {
        super();
    }

    public MySQLDatabase(DatabaseConfigYaml databaseConfigYaml) {
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
