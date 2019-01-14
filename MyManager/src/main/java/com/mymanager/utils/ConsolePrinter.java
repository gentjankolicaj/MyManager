package com.mymanager.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mymanager.config.Config;
import com.mymanager.data.models.MyModel;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class ConsolePrinter {

	public static final PrintFormat FORMAT = Config.PRINT_FORMAT;

	public static void print(String source) {
		System.out.println("-  " + source);

	}

	public static void print(Object object) {
		if (object != null) {
			if (object instanceof MyModel) {
				MyModel model = (MyModel) object;
				System.out.println(model.toString());
			} else {
				System.out.println("-  " + object.toString());
			}

		}
	}

	public static void print(Class<?> cls) {
		if (cls != null) {
			System.out.println("-  " + cls.getName());
		}

	}

	public static void print(Exception exception) {
		if (exception != null) {

			System.out.println(" Exception : " + exception.getMessage());
		}
	}

	public static void print(Map<?, ?> map) {
		if (map != null) {
			Set<?> keySet = map.keySet();
			Iterator<?> iter = keySet.iterator();
			while (iter.hasNext()) {
				Object key = iter.next();
				Object value = map.get(key);
				print("{ " + key.toString() + " : " + value.toString() + " }");

			}
		}

	}

	public static void print(List<?> list) {
		if (list != null && list.size() != 0) {
			int i = 0;
			for (Object object : list) {
				i++;
				if (object instanceof MyModel) {
					MyModel model = (MyModel) object;
					System.out.println(model.toString());
				} else
					print(i + "." + object.toString());
			}
		}
	}

}
