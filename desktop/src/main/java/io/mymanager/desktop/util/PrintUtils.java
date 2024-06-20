package io.mymanager.desktop.util;

import io.mymanager.desktop.config.Config;
import io.mymanager.desktop.enums.PrintEnvironment;
import io.mymanager.desktop.enums.PrintType;
import java.util.List;
import java.util.Map;

/**
 * @author gentjan kolicaj
 */
public class PrintUtils {

  public static final PrintEnvironment ENV = Config.PRINT_ENV;

  private static void print(String source) {
    switch (ENV) {
      case LOG:
        LogPrinter.print(source);
        break;
      case SWING:
        SwingPrinter.print(source);
        break;
    }

  }

  private static void print(Object object) {
    switch (ENV) {
      case LOG:
        LogPrinter.print(object);
        break;
      case SWING:
        SwingPrinter.print(object);
        break;
    }
  }

  private static void print(Class<?> cls) {
    switch (ENV) {
      case LOG:
        LogPrinter.print(cls);
        break;
      case SWING:
        SwingPrinter.print(cls);
        break;
    }

  }

  private static void print(Exception exception) {
    switch (ENV) {
      case LOG:
        LogPrinter.print(exception);
        break;
      case SWING:
        SwingPrinter.print(exception);
        break;
    }

  }

  private static void print(Map<?, ?> map) {
    switch (ENV) {
      case LOG:
        LogPrinter.print(map);
        break;
      case SWING:
        SwingPrinter.print(map);
        break;
    }

  }

  private static void print(List<?> list) {
    switch (ENV) {
      case LOG:
        LogPrinter.print(list);
        break;
      case SWING:
        SwingPrinter.print(list);
        break;
    }

  }

  private static boolean printCheck(PrintType type) {
    if (type == PrintType.FILE_IO) {
      return Config.PRINT_FILE_IO;
    } else if (type == PrintType.DATABASE_IO) {
      return Config.PRINT_DATABASE_IO;
    } else if (type == PrintType.DATABASE_QUERY) {
      return Config.PRINT_DATABASE_QUERY;
    } else if (type == PrintType.EXCEPTION) {
      return Config.PRINT_EXCEPTION;
    } else if (type == PrintType.LOG) {
      return Config.PRINT_LOG;
    } else if (type == PrintType.OTHER) {
      return Config.PRINT_OTHER;
    } else if (type == PrintType.QUERY_RESULTS) {
      return Config.PRINT_QUERY_RESULTS;
    } else {
      return false;
    }
  }

  public static void print(List<?> list, PrintType type) {
    if (printCheck(type)) {
      print(list);
    }
  }

  public static void print(Map<?, ?> map, PrintType type) {
    if (printCheck(type)) {
      print(map);
    }
  }

  public static void print(Exception exception, PrintType type) {
    if (printCheck(type)) {
      print(exception);
    }
  }

  public static void print(Class<?> cls, PrintType type) {
    if (printCheck(type)) {
      print(cls);
    }
  }

  public static void print(Object object, PrintType type) {
    if (printCheck(type)) {
      print(object);
    }
  }

  public static void print(String text, PrintType type) {
    if (printCheck(type)) {
      print(text);
    }
  }

}
