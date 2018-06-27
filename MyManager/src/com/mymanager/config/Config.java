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

	/*
	 * Config values are overriden by application.properties file is necesary
	 */
	static {

	}

}
