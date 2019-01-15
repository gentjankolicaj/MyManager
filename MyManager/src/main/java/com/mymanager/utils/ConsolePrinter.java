package com.mymanager.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mymanager.config.Config;
import com.mymanager.data.models.MyModel;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class ConsolePrinter {

	public static final PrintFormat FORMAT = Config.PRINT_FORMAT;
	
	private static final ObjectMapper mapper=new ObjectMapper();
	
	
	public static void printFormat(Object object) {
		if(FORMAT.equals(FORMAT.NORMAL)) {
			System.out.println(object.toString());
		}else if(FORMAT.equals(FORMAT.JSON)) {
			try {
				System.out.println(mapper.writeValueAsString(object));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	

	public static void print(String source) {
		System.out.println("-  " + source);

	}

	public static void print(Object object) {
		if (object != null) {
			if (object instanceof MyModel) {
				MyModel model = (MyModel) object;
				printFormat(model);
			} else {
				System.out.println("-  " + object.toString());
			}

		}
        System.out.println();
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
				print("[ " + key.toString() + " = " + value.toString() + " ]");

			}
		}
		
		System.out.println();

	}

	public static void print(List<?> list) {
		if (list != null && list.size() != 0) {
			int i = 0;
			for (Object object : list) {
				i++;
				if (object instanceof MyModel) {
					MyModel model = (MyModel) object;
					printFormat(model);
				} else
					print(i + "." + object.toString());
			}
		}
		System.out.println();
	}

}
