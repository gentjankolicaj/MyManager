package com.mymanager.config;

import com.mymanager.utils.PrintEnviroment;
import com.mymanager.utils.PrintFormat;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class Config {

	public static final boolean PRINT_EXCEPTION = true;
	public static final boolean PRINT_FILE_IO = true;
	public static final boolean PRINT_DATABASE_QUERY = true;
	public static final boolean PRINT_DATABASE_IO = true;
	public static final boolean PRINT_LOG = true;
	public static final boolean PRINT_OTHER = true;
	public static final boolean PRINT_QUERY_RESULTS = true;

	public static final PrintFormat PRINT_FORMAT = PrintFormat.NORMAL;
	public static final PrintEnviroment PRINT_ENV = PrintEnviroment.CONSOLE;

}
