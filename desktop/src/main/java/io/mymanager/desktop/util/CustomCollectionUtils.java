package io.mymanager.desktop.util;

import static java.util.Objects.nonNull;

import java.util.ArrayList;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Equator;

/**
 * @author gentjan kolicaj
 */
public class CustomCollectionUtils {


  public static boolean areEquals(ArrayList<String> first, ArrayList<String> second) {
    return CollectionUtils.isEqualCollection(first, second, new Equator<>() {
      @Override
      public boolean equate(String s, String t1) {
        return nonNull(s) && s.equals(t1);
      }

      @Override
      public int hash(String s) {
        return 0;
      }
    });
  }

}
