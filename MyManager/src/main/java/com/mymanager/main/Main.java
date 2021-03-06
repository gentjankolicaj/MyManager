package com.mymanager.main;

import java.awt.EventQueue;

import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.RDBMSType;
import com.mymanager.desktop.views.LoginView;
import com.mymanager.desktop.views.MyFrame;

/**
 * 
 * @author gentjan koli�aj
 *
 */
public class Main {

	private static MyFrame frame;
	private static LoginView loginView;

	public static void main(String[] args) {
		try {

			DatabaseManager.getDatabase(RDBMSType.MySQL);

		} catch (Exception e1) {

			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MyFrame();
					loginView = new LoginView(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
