package io.mymanager.desktop.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import java.io.File;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public final class JsonUtils {

  private static final ObjectMapper OBJECT_MAPPER = createObjectMapper();
  private static final ObjectMapper JSON_OBJECT_MAPPER = createObjectMapper();

  private JsonUtils() {
  }

  private static ObjectMapper createMapper() {
    return new ObjectMapper(new JsonFactory()).registerModules(new ParameterNamesModule(),
        new JavaTimeModule());
  }

  private static ObjectMapper createObjectMapper() {
    return new ObjectMapper(new JsonFactory()).registerModules(new JavaTimeModule(),
        new ParameterNamesModule());
  }

  public static <T> T read(String file, Class<T> clazz) throws IOException {
    return JSON_OBJECT_MAPPER.readValue(
        Thread.currentThread().getContextClassLoader().getResource(file), clazz);
  }

  public static void write(String file, Object obj) throws IOException {
    JSON_OBJECT_MAPPER.writeValue(new File(file), obj);
  }


  public static String writeValueAsString(Object obj) {
    try {
      return JSON_OBJECT_MAPPER.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      log.error("Error writing value as string : {}", e);
      return StringUtils.EMPTY;
    }
  }

  public static byte[] writeValueAsBytes(Object obj) throws JsonProcessingException {
    return JSON_OBJECT_MAPPER.writeValueAsBytes(obj);
  }

  public static <T> T readAsString(String content, Class<T> clazz) throws JsonProcessingException {
    return JSON_OBJECT_MAPPER.readValue(content, clazz);
  }

  public static <T> T readAsByte(byte[] src, Class<T> clazz) throws IOException {
    return JSON_OBJECT_MAPPER.readValue(src, clazz);
  }

}
