package tests;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.mymanager.utils.PropertyFilesUtils;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class PropertyFilesUtilsTest {

	@Test
	public final void testGetValues() {
		PropertyFilesUtils.getValues("com/mymanager/config/application.properties");// relative
																					// path
																					// ok
	}

	@Test
	public final void testGetProperties() {
		Map<String, String> temp = new HashMap<>();
		temp.put("1", "jdbc");
		temp.put("2", "postgresSQL");
		temp.put("3", "5432");
		temp.put("4", "localhost");
		PropertyFilesUtils.updateValues("com/mymanager/config/update_application.properties", temp);// absolute
		// path
	}

	@Test
	public final void testWriteValues() {
		Map<String, String> temp = new HashMap<>();
		temp.put("1", "one");
		temp.put("2", "two");
		temp.put("3", "three");
		temp.put("4", "four");
		temp.put("5", "five");
		temp.put("6", "six");

		PropertyFilesUtils.writeValues("src//com//mymanager//config//new_application.properties", temp); // absolute
																											// path
																											// because
																											// relative
																											// not
																											// workin
	}

}
