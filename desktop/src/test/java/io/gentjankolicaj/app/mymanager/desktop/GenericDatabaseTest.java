package io.gentjankolicaj.app.mymanager.desktop;


import io.gentjankolicaj.app.mymanager.commons.db.Database;
import io.gentjankolicaj.app.mymanager.desktop.db.DatabaseManager;
import io.gentjankolicaj.app.mymanager.desktop.yaml.ApplicationConfigYaml;
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
