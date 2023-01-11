package io.gentjankolicaj.app.mymanager.desktop;

import io.gentjankolicaj.app.mymanager.desktop.db.DatabaseManager;
import io.gentjankolicaj.app.mymanager.desktop.util.YamlUtils;
import io.gentjankolicaj.app.mymanager.desktop.view.DesktopFrame;
import io.gentjankolicaj.app.mymanager.desktop.view.LoginView;
import io.gentjankolicaj.app.mymanager.desktop.yaml.ApplicationConfigYaml;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.io.IOException;

/**
 * @author gentjan kolicaj
 */
@Slf4j
public class DesktopApplication {

    public static void main(String[] args) throws Exception {
        try {
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
        } catch (Exception e) {
            log.error("Error ", e);
        }
    }

    static ApplicationConfigYaml getConfigurationYaml() throws IOException {
        return YamlUtils.readFile("application.yml", ApplicationConfigYaml.class);
    }
}
