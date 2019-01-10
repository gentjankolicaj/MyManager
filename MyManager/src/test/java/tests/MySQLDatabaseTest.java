package tests;

import org.junit.Test;

import com.mymanager.data.database.Database;
import com.mymanager.data.database.MySQLDatabase;

/**
 * 
 * @author gentjan_kolicaj
 *
 */
public class MySQLDatabaseTest {

	Database temp;

	@Test
	public final void testConnection() throws Exception {
		temp = new MySQLDatabase();
		temp.connect();
	}

	@Test
	public final void testDisConnection() throws Exception {
		temp = new MySQLDatabase();
		temp.disconnect();
	}

}
