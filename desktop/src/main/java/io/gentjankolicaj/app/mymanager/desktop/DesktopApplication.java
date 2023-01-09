package io.gentjankolicaj.app.mymanager.desktop;

import io.gentjankolicaj.app.mymanager.desktop.db.custom.DatabaseManager;
import io.gentjankolicaj.app.mymanager.desktop.db.custom.RDBMSType;
import io.gentjankolicaj.app.mymanager.desktop.view.LoginView;
import io.gentjankolicaj.app.mymanager.desktop.view.MyFrame;

import java.awt.*;

/**
 * @author gentjan kolicaj
 */
public class DesktopApplication {

	public static void main(String[] args) {
		try {
			DatabaseManager.getDatabase(RDBMSType.MySQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
					new LoginView(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
