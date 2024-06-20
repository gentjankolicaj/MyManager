package io.mymanager.desktop.yaml;

import io.mymanager.commons.yaml.AbstractDatabaseConfigYaml;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseConfigYaml extends AbstractDatabaseConfigYaml {

  private Map<String, String> datasourceProperties;

}
