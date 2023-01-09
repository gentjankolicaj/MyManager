package io.gentjankolicaj.app.mymanager.desktop;


import io.gentjankolicaj.app.mymanager.desktop.util.PropertyFilesUtils;
import org.junit.jupiter.api.Test;

/**
 * @author gentjan kolicaj
 */
public class PropertyFilesUtilsTest {

    @Test
    public final void testGetValues() {
        PropertyFilesUtils.getValues("application.properties");
        // relative
        // path
        // ok
    }
}
