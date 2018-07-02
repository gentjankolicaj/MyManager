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

	// Message Pain
	public static boolean MESSAGE_WINDOWS = true;

	public static boolean PLAIN_MESSAGE = true;
	public static int plainWindowTime = 4000;
	public static String plainWindowButton = "default";

	public static boolean WARNING_MESSAGE = true;
	public static int warningWindowTime = 4000;
	public static String warningWindowButton = "default";

	public static boolean ERROR_MESSAGE = true;
	public static int errorWindowTime = 4000;
	public static String errorWindowButton = "default";

	public static boolean INFO_MESSAGE = true;
	public static int infoWindowTime = 4000;
	public static String infoWindowButton = "default";

	public static boolean QUESTION_MESSAGE = true;
	public static int questionWindowTime = 4000;
	public static String questionWindowButton = "default";

	// OPTION Pane
	public static boolean OPTION_WINDOWS = true;

	public static boolean DEFAULT = true;
	public static int defaultWindowTime = 4000;
	public static String defaultWindowButton = "default";

	public static boolean YES_NO = true;
	public static int yes_no_WindowTime = 4000;
	public static String yes_no_WindowButton = "default";

	public static boolean YES_NO_CANCEL = true;
	public static int yes_no_cancel_WindowTime = 4000;
	public static String yes_no_cancel_WindowButton = "default";

	public static boolean OK_CANCEL = true;
	public static int ok_cancel_WindowTime = 4000;
	public static String ok_cancel_WindowButton = "default";

	// INPUT PANE
	public static boolean INPUT_WINDOWS = true;

	/*
	 * Config values are overriden by application.properties file is necesary
	 */
	static {

	}

}
