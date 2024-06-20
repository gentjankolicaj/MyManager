package io.mymanager.desktop.yaml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationConfigYaml {

  private String applicationName;
  private DatabaseConfigYaml database;

}
