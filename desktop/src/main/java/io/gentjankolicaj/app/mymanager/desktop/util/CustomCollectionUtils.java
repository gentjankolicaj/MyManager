package io.gentjankolicaj.app.mymanager.desktop.util;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Equator;

import java.util.ArrayList;

import static java.util.Objects.nonNull;

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
