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
		System.out.println("-  " + object.toString());

	}

	public static void print(Class<?> cls) {
		System.out.println("-  " + cls.getName());

	}

	public static void print(Exception exception) {
		System.out.println(" Exception : " + exception.getMessage());

	}

	public static void print(Map<?, ?> map) {
		Set<?> keySet = map.keySet();
		Iterator<?> iter = keySet.iterator();
		while (iter.hasNext()) {
			Object key = iter.next();
			Object value = map.get(key);
			print("{ " + key.toString() + " : " + value.toString() + " }");

		}

	}

	public static void print(List<?> list) {
		int i = 0;
		for (Object object : list) {
			i++;
			if (object instanceof MyModel) {
				MyModel model = (MyModel) object;
				print(i + "-|" + model.toNormal() + "|");
			} else
				print(i + "." + object.toString());
		}
	}

}
