package io.mymanager.desktop;

import io.mymanager.desktop.db.DatabaseManager;
import io.mymanager.desktop.util.YamlUtils;
import io.mymanager.desktop.view.DesktopFrame;
import io.mymanager.desktop.view.LoginView;
import io.mymanager.desktop.yaml.ApplicationConfigYaml;
import java.awt.EventQueue;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

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
