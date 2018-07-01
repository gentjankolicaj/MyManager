package com.mymanager.config;

import com.mymanager.utils.PrintEnviroment;
import com.mymanager.utils.PrintFormat;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class Config {

	public static boolean PRINT_EXCEPTION = true;
	public static boolean PRINT_FILE_IO = true;
	public static boolean PRINT_DATABASE_QUERY = true;
	public static boolean PRINT_DATABASE_IO = true;
	public static boolean PRINT_LOG = true;
	public static boolean PRINT_OTHER = true;
	public static boolean PRINT_QUERY_RESULTS = true;

	public static PrintFormat PRINT_FORMAT = PrintFormat.NORMAL;
	public static PrintEnviroment PRINT_ENV = PrintEnviroment.CONSOLE;

	public static boolean MESSAGE_WINDOWS = true;
	public static int warningWindowTime = 4000;
	public static int errorWindowTime = 4000;
	public static int infoWindowTime = 4000;
	public static int questionWindowTime = 4000;

	public static boolean INPUT_WINDOWS = true;

	/*
	 * Config values are overriden by application.properties file is necesary
	 */
	static {

	}

}
