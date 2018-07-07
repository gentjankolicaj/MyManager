package com.mymanager.main;

import java.awt.EventQueue;

import com.mymanager.data.database.Database;
import com.mymanager.data.database.MySQLDatabase;
import com.mymanager.views.MyFrame;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class Main {

	private static Database database;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
					frame.initFrame();
					frame.initMenu();
					frame.displayFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static boolean setUpDatabase() {
		database = new MySQLDatabase();
		return false;

	}

	public static boolean setUpGUI() {

		return false;
	}

}
