package com.mymanager.data.database;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class DatabaseManager {

	private static int instanceNumber = 0;

	private DatabaseManager() {
	}

	public static Database getDatabase(RDBMSType type) throws Exception {
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
			break;
		default:
			temp = new MySQLDatabase();

		}
		temp.connect();
		instanceNumber++;
		DatabasePool.putReference(new Integer(instanceNumber), temp);
		return temp;
	}

	public static Database getDatabase(RDBMSType type, boolean useSSL) throws Exception {
		Database temp = null;
		switch (type) {
		case MySQL:
			temp = new MySQLDatabase();
			temp.setSsl(useSSL);
			break;
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
		DatabasePool.putReference(new Integer(instanceNumber), temp);
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
		DatabasePool.putReference(new Integer(instanceNumber), temp);

		return temp;
	}

	public static int getRecentInstanceNumber() {
		return instanceNumber;
	}

}
