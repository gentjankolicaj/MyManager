package io.gentjankolicaj.app.mymanager.desktop.yaml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseConfigYaml {
    private String driverClassName;
    private String jdbcUrl;
    private String username;
    private String password;
    private Map<String, String> datasourceProperties;
}
