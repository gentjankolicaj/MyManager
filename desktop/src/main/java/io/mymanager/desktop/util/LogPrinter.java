package io.mymanager.desktop.util;

import io.mymanager.desktop.config.Config;
import io.mymanager.desktop.data.models.MyModel;
import io.mymanager.desktop.enums.PrintFormatType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gentjan kolicaj
 */
@Slf4j
public class LogPrinter {

  public static final PrintFormatType FORMAT = Config.PRINT_FORMAT;


  public static void printFormat(Object object) {
    if (FORMAT.equals(PrintFormatType.NORMAL)) {
      log.info("", object);
    } else if (FORMAT.equals(PrintFormatType.JSON)) {
      log.info("", JsonUtils.writeValueAsString(object));
    }
  }

  public static void print(String source) {
    log.info("-  " + source);

  }

  public static void print(Object object) {
    if (object != null) {
      if (object instanceof MyModel) {
        MyModel model = (MyModel) object;
        printFormat(model);
      } else {
        log.info("-  " + object);
      }

    }
    log.info("\n");
  }

  public static void print(Class<?> cls) {
    if (cls != null) {
      log.info("-  " + cls.getName());
    }

  }

  public static void print(Exception exception) {
    if (exception != null) {
      log.info("Exception ", exception);
    }
  }

  public static void print(Map<?, ?> map) {
    if (map != null) {
      Set<?> keySet = map.keySet();
      Iterator<?> iter = keySet.iterator();
      while (iter.hasNext()) {
        Object key = iter.next();
        Object value = map.get(key);
        print("[ " + key.toString() + " = " + value.toString() + " ]");

      }
    }
    log.info("\n");
  }

  public static void print(List<?> list) {
    if (list != null && list.size() != 0) {
      int i = 0;
      for (Object object : list) {
        i++;
        if (object instanceof MyModel) {
          MyModel model = (MyModel) object;
          printFormat(model);
        } else {
          print(i + "." + object.toString());
        }
      }
    }
    log.info("\n");
  }

}
