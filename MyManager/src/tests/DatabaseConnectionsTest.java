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
