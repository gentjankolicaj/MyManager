package com.mymanager.utils;

import java.util.List;
import java.util.Map;

import com.mymanager.config.Config;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class PrintUtils {

	public static final PrintEnviroment ENV = Config.PRINT_ENV;

	private static void print(String source) {
		switch (ENV) {
		case CONSOLE:
			ConsolePrinter.print(source);
			break;
		case SWING:
			SwingPrinter.print(source);
			break;
		}

	}

	private static void print(Object object) {
		switch (ENV) {
		case CONSOLE:
			ConsolePrinter.print(object);
			break;
		case SWING:
			SwingPrinter.print(object);
			break;
		}
	}

	private static void print(Class<?> cls) {
		switch (ENV) {
		case CONSOLE:
			ConsolePrinter.print(cls);
			break;
		case SWING:
			SwingPrinter.print(cls);
			break;
		}

	}

	private static void print(Exception exception) {
		switch (ENV) {
		case CONSOLE:
			ConsolePrinter.print(exception);
			break;
		case SWING:
			SwingPrinter.print(exception);
			break;
		}

	}

	private static void print(Map<?, ?> map) {
		switch (ENV) {
		case CONSOLE:
			ConsolePrinter.print(map);
			break;
		case SWING:
			SwingPrinter.print(map);
			break;
		}

	}

	private static void print(List<?> list) {
		switch (ENV) {
		case CONSOLE:
			ConsolePrinter.print(list);
			break;
		case SWING:
			SwingPrinter.print(list);
			break;
		}

	}

	private static boolean printCheck(PrintType type) {
		if (type == PrintType.FILE_IO) {
			if (Config.PRINT_FILE_IO)
				return true;
			else
				return false;
		} else if (type == PrintType.DATABASE_IO) {
			if (Config.PRINT_DATABASE_IO)
				return true;
			else
				return false;
		} else if (type == PrintType.DATABASE_QUERY) {
			if (Config.PRINT_DATABASE_QUERY)
				return true;
			else
				return false;
		} else if (type == PrintType.EXCEPTION) {
			if (Config.PRINT_EXCEPTION)
				return true;
			else
				return false;

		} else if (type == PrintType.LOG) {
			if (Config.PRINT_LOG)
				return true;
			else
				return false;
		} else
			return false;

	}

	public static void print(List<?> list, PrintType type) {
		if (printCheck(type))
			print(list);
	}

	public static void print(Map<?, ?> map, PrintType type) {
		if (printCheck(type))
			print(map);
	}

	public static void print(Exception exception, PrintType type) {
		if (printCheck(type))
			print(exception);
	}

	public static void print(Class<?> cls, PrintType type) {
		if (printCheck(type))
			print(cls);
	}

	public static void print(Object object, PrintType type) {
		if (printCheck(type))
			print(object);
	}

	public static void print(String text, PrintType type) {
		if (printCheck(type))
			print(text);
	}

}
