package io.gentjankolicaj.app.mymanager.desktop;

import io.gentjankolicaj.app.mymanager.desktop.db.custom.DatabaseManager;
import io.gentjankolicaj.app.mymanager.desktop.view.DesktopFrame;
import io.gentjankolicaj.app.mymanager.desktop.view.LoginView;
import io.gentjankolicaj.app.mymanager.desktop.yaml.ApplicationConfigYaml;
import io.gentjankolicaj.app.mymanager.desktop.yaml.YamlUtils;

import java.awt.*;
import java.io.IOException;

/**
 * @author gentjan kolicaj
 */
public class DesktopApplication {

	public static void main(String[] args) throws Exception {
		ApplicationConfigYaml applicationConfigYaml = getConfigurationYaml();
		DatabaseManager.initDb(applicationConfigYaml.getDatabase());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesktopFrame frame = new DesktopFrame();
					new LoginView(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	static ApplicationConfigYaml getConfigurationYaml() throws IOException {
		return YamlUtils.readFile("application.yml", ApplicationConfigYaml.class);
	}

}
