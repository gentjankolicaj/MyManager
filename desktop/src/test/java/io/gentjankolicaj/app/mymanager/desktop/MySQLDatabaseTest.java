package io.gentjankolicaj.app.mymanager.desktop;


import io.gentjankolicaj.app.mymanager.desktop.db.custom.Database;
import io.gentjankolicaj.app.mymanager.desktop.db.custom.impl.MySQLDatabase;
import org.junit.jupiter.api.Test;

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
