package io.mymanager.commons.yaml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AbstractDatabaseConfigYaml {

  private String name;
  private String type;
  private String driverClassName;
  private String jdbcUrl;
  private String username;
  private String password;
  private boolean ssl;
}
