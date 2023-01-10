package io.gentjankolicaj.app.mymanager.desktop.db.custom;

import io.gentjankolicaj.app.mymanager.desktop.db.custom.impl.GenericDatabase;
import io.gentjankolicaj.app.mymanager.desktop.db.custom.impl.MySQLDatabase;
import io.gentjankolicaj.app.mymanager.desktop.db.custom.impl.OracleDatabase;
import io.gentjankolicaj.app.mymanager.desktop.db.custom.impl.PostgresDatabase;
import io.gentjankolicaj.app.mymanager.desktop.db.datasource.HikariCPManager;
import io.gentjankolicaj.app.mymanager.desktop.yaml.DatabaseConfigYaml;

import static java.util.Objects.isNull;

/**
 * @author gentjan kolicaj
 */
public class DatabaseManager {

	private static int instanceNumber = 0;
	private static Database db;

	private DatabaseManager() {
	}

	public static void initDb(DatabaseConfigYaml databaseConfigYaml) throws Exception {
		if (isNull(db)) {
			HikariCPManager.initPool(databaseConfigYaml);
			db = new GenericDatabase();
		}
	}

	public static Database getDb() {
		return db;
	}

	public static Database getDatabase(RDBMSType type) throws Exception {
		Database temp = null;
		switch (type) {
			case ORACLE:
				temp = new OracleDatabase();
				break;
			case PostgreSQL:
				temp = new PostgresDatabase();
				break;
		default:
			temp = new MySQLDatabase();
		}
		temp.connect();
		instanceNumber++;
		DatabasePool.putReference(Integer.valueOf(instanceNumber), temp);
		return temp;
	}

	public static Database getDatabase(RDBMSType type, boolean useSSL) throws Exception {
		Database temp = null;
		switch (type) {
			case ORACLE:
                temp = new OracleDatabase();
			temp.setSsl(useSSL);
			break;
		case PostgreSQL:
			temp = new PostgresDatabase();
			temp.setSsl(useSSL);
			break;
		default:
			temp = new MySQLDatabase();
			temp.setSsl(useSSL);

		}
		temp.connect();
		instanceNumber++;
		DatabasePool.putReference(Integer.valueOf(instanceNumber), temp);
		return temp;
	}

	public static Database getDatabase(ConnectionInstanceData instanceData) throws Exception {
		Database temp = null;

		if (instanceData.getDatabaseType().contains("mysql")) {
			temp = new MySQLDatabase(instanceData.getDriverName(), instanceData.getApi(), instanceData.isSsl(),
					instanceData.getDatabaseType(), instanceData.getServer(), instanceData.getPort(),
					instanceData.getUser(), instanceData.getPassword(), instanceData.getSchema());

		} else if (instanceData.getDatabaseType().contains("oracle")) {
			temp = new OracleDatabase(instanceData.getDriverName(), instanceData.getApi(), instanceData.isSsl(),
					instanceData.getDatabaseType(), instanceData.getServer(), instanceData.getPort(),
					instanceData.getUser(), instanceData.getPassword(), instanceData.getSchema());

		} else if (instanceData.getDatabaseType().contains("postgresql")) {
			temp = new PostgresDatabase(instanceData.getDriverName(), instanceData.getApi(), instanceData.isSsl(),
					instanceData.getDatabaseType(), instanceData.getServer(), instanceData.getPort(),
					instanceData.getUser(), instanceData.getPassword(), instanceData.getSchema());
		} else
			temp = new MySQLDatabase();

		temp.connect();
		instanceNumber++;
		DatabasePool.putReference(Integer.valueOf(instanceNumber), temp);

		return temp;
	}

	public static int getRecentInstanceNumber() {
		return instanceNumber;
	}

}
