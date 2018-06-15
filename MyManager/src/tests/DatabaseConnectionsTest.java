package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mymanager.data.database.Database;
import com.mymanager.data.database.MySQLDatabase;
import com.mymanager.data.database.OracleDatabase;
import com.mymanager.data.database.PostgresDatabase;

public class DatabaseConnectionsTest {

	Database temp;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMySQLConnect() {
		temp = new MySQLDatabase();
		temp.connect();
	}

	@Test
	public void testMySQLDisconnect() {
		temp = new MySQLDatabase();
		temp.disconnect();
	}

	@Test
	public void testPostgreSQLConnect() {
		temp = new PostgresDatabase();
		temp.connect();
	}

	@Test
	public void testPostgreSQLDisconnect() {
		temp = new PostgresDatabase();
		temp.disconnect();
	}

	@Test
	public void tesOracleConnect() {
		temp = new OracleDatabase();
		temp.connect();
	}

	@Test
	public void testOracleDisconnect() {
		temp = new OracleDatabase();
		temp.disconnect();
	}

}
