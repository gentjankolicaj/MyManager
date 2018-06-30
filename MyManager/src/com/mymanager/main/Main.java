package com.mymanager.main;

import com.mymanager.data.database.Database;
import com.mymanager.data.database.MySQLDatabase;
import com.mymanager.views.MyWindow;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class Main {

	private static Database database;
	private static MyWindow myWindow;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean setUpDatabase() {
		database = new MySQLDatabase();
		return false;

	}

	public static boolean setUpGUI() {
		myWindow = new MyWindow();
		return false;
	}

}
