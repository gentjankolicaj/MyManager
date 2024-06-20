package io.mymanager.desktop;


import io.mymanager.commons.db.Database;
import io.mymanager.desktop.db.DatabaseManager;
import io.mymanager.desktop.yaml.ApplicationConfigYaml;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author gentjan_kolicaj
 */
class GenericDatabaseTest {


  @Test
  void testConnection() throws Exception {
    ApplicationConfigYaml applicationConfigYaml = DesktopApplication.getConfigurationYaml();
    Database database = DatabaseManager.initDb(applicationConfigYaml.getDatabase());
    Assertions.assertThat(database.isConnected()).isTrue();
    database.initDriver();
    DatabaseManager.shutdown();
  }


}
