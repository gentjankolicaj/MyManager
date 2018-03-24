package com.mymanager.data.database;

/**
 * 
 * @author gentjan_kolicaj
 *
 */
public class DatabaseManager {

	private DatabaseManager() {
	}

	public static Database getDatabase(RDBMSType type) {
		Database temp = null;
		switch (type) {
		case MySQL:
			temp = new MySQLDatabase();
			break;

		case ORACLE:
			temp = new OracleDatabase();
			break;
		case PostgreSQL:
			temp = new PostgresDatabase();
		default:
			temp = new MySQLDatabase();

		}
		openConnection(temp);
		DatabasePool.putReference(new Integer(1), temp);

		return temp;
	}

	public static Database getDatabase(InstanceData instanceData) {
		Database temp = null;

		switch (instanceData.getRdbmsType()) {
		case MySQL:
			temp = new MySQLDatabase(instanceData.getDriverName(), instanceData.getApi(),
					instanceData.getDatabaseType(), instanceData.getServer(), instanceData.getPort(),
					instanceData.getUser(), instanceData.getPassword(), instanceData.getSchema());
			break;

		case ORACLE:
			temp = new OracleDatabase(instanceData.getDriverName(), instanceData.getApi(),
					instanceData.getDatabaseType(), instanceData.getServer(), instanceData.getPort(),
					instanceData.getUser(), instanceData.getPassword(), instanceData.getSchema());
			break;
		case PostgreSQL:
			temp = new PostgresDatabase(instanceData.getDriverName(), instanceData.getApi(),
					instanceData.getDatabaseType(), instanceData.getServer(), instanceData.getPort(),
					instanceData.getUser(), instanceData.getPassword(), instanceData.getSchema());
		default:
			temp = new MySQLDatabase();

		}
		openConnection(temp);
		DatabasePool.putReference(new Integer(1), temp);

		return temp;
	}

	public static void openConnection(Database database) {
		database.open();
	}

	public static void closeConnection(Database database) {
		database.close();
	}

}
