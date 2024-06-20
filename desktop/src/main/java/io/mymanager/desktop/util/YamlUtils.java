package io.mymanager.desktop.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import java.io.FileWriter;
import java.io.IOException;

public final class YamlUtils {

  private static final ObjectMapper OBJECT_MAPPER = create();

  private YamlUtils() {
  }

  private static ObjectMapper create() {
    return new ObjectMapper(new YAMLFactory()).registerModules(new JavaTimeModule(),
        new ParameterNamesModule());
  }

  public static <T> T readFile(String filename, Class<T> clazz) throws IOException {
    return OBJECT_MAPPER.readValue(
        Thread.currentThread().getContextClassLoader().getResource(filename), clazz);
  }

  public static <T> void writeFile(String filename, T t) throws IOException {
    OBJECT_MAPPER.writeValue(new FileWriter(filename), t);
  }
}
