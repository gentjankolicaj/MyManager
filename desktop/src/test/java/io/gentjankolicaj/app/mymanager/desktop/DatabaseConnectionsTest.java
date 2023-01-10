package io.gentjankolicaj.app.mymanager.desktop;


import io.gentjankolicaj.app.mymanager.desktop.db.custom.Database;
import io.gentjankolicaj.app.mymanager.desktop.db.custom.impl.MySQLDatabase;
import io.gentjankolicaj.app.mymanager.desktop.db.custom.impl.OracleDatabase;
import io.gentjankolicaj.app.mymanager.desktop.db.custom.impl.PostgresDatabase;
import org.junit.jupiter.api.Test;

/**
 * @author gentjan kolicaj
 */
public class DatabaseConnectionsTest {

	Database temp;

	@Test
	public void testMySQLConnect() throws Exception {
		temp = new MySQLDatabase();
		temp.connect();
		temp.disconnect();
	}

	@Test
	public void testPostgreSQLConnect() throws Exception {
		temp = new PostgresDatabase();
		temp.connect();
		temp.disconnect();
	}

	@Test
	public void tesOracleConnect() throws Exception {
		temp = new OracleDatabase();
		temp.connect();
		temp.disconnect();
	}

}
