package io.gentjankolicaj.app.mymanager.desktop.yaml;

import io.gentjankolicaj.app.mymanager.commons.yaml.AbstractDatabaseConfigYaml;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseConfigYaml extends AbstractDatabaseConfigYaml {

    private Map<String, String> datasourceProperties;

}
