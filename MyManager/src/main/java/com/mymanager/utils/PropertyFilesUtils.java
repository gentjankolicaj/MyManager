package com.mymanager.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class PropertyFilesUtils {

	private static Properties getProperties(String filePath) {
		Properties prop = new Properties();
		try {
			prop.load(PropertyFilesUtils.class.getClassLoader().getResourceAsStream(filePath));

		} catch (IOException io) {
			PrintUtil.print(io, PrintType.FILE_IO);
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
		PrintUtil.print(temp, PrintType.FILE_IO);

		return temp;
	}

	public static Map<String, String> writeValues(String filePath, Map<String, String> values) {
		Map<String, String> temp = new HashMap<>();
		Properties prop = new Properties();
		Set<?> keySet = values.keySet();
		Iterator<?> iter = keySet.iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			String value = (String) values.get(key);
			prop.setProperty(key, value);
			temp.put(key, value);

		}
		try {
			File file = new File(filePath);
			OutputStream outputStream = new FileOutputStream(file);
			prop.store(outputStream, LocalDateTime.now().toString());
			outputStream.close();

		} catch (IOException io) {
			PrintUtil.print(io, PrintType.EXCEPTION);
		}
		PrintUtil.print(temp, PrintType.FILE_IO);
		return temp;
	}

	public static Map<String, String> updateValues(String filePath, Map<String, String> updatedValues) {
		Map<String, String> temp = new HashMap<>();

		try {
			Properties prop = new Properties();

			InputStream inputStream = PropertyFilesUtils.class.getClassLoader().getResourceAsStream(filePath);
			prop.load(inputStream);
			inputStream.close();

			FileOutputStream fileOutputStream = new FileOutputStream(filePath);

			Set<?> keySet = updatedValues.keySet();
			Iterator<?> iter = keySet.iterator();

			while (iter.hasNext()) {

				String key = (String) iter.next();
				String value = (String) updatedValues.get(key);

				if (prop.containsKey(key)) {
					prop.setProperty(key, value);
					temp.put(key, value);
				}
			}
			prop.store(fileOutputStream, "Updated ->" + LocalDateTime.now().toString());
			fileOutputStream.close();

		} catch (IOException io) {
			PrintUtil.print(io, PrintType.EXCEPTION);
		}
		PrintUtil.print(temp, PrintType.FILE_IO);
		return temp;
	}
}
