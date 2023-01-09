package io.gentjankolicaj.app.mymanager.desktop.util;

import io.gentjankolicaj.app.mymanager.desktop.enums.PrintType;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author gentjan kolicaj
 */
public class PropertyFilesUtils {

	private static Properties getProperties(String filePath) {
		Properties prop = new Properties();
		try {
			prop.load(PropertyFilesUtils.class.getClassLoader().getResourceAsStream(filePath));

		} catch (IOException io) {
			PrintUtils.print(io, PrintType.FILE_IO);
		}

		return prop;
	}

	public static Map<String, String> getValues(String filePath) {
		Map<String, String> temp = new HashMap<>();
		Properties prop = getProperties(filePath);
		Enumeration<?> enu = prop.propertyNames();
		while (enu.hasMoreElements()) {
			String key = (String) enu.nextElement();
			String value = prop.getProperty(key);
			temp.put(key, value);

		}
		PrintUtils.print(temp, PrintType.FILE_IO);

		return temp;
	}
}
