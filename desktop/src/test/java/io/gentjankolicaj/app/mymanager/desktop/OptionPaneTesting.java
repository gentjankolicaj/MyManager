package io.gentjankolicaj.app.mymanager.desktop;

import io.gentjankolicaj.app.mymanager.desktop.enums.MessageType;
import io.gentjankolicaj.app.mymanager.desktop.util.WindowUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

/**
 * @author gentjan kolicaj
 */
public class OptionPaneTesting {

    JFrame frame;

    @BeforeEach
    public void setUp() throws Exception {
        frame = new JFrame();
        frame.setSize(new Dimension(600, 350));
        frame.setVisible(true);
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public final void testMessage() {
        WindowUtils.showMessage(frame, "Info", MessageType.ERROR);
        WindowUtils.showMessage(frame, "Info", MessageType.WARNING);
        WindowUtils.showMessage(frame, "Info", MessageType.INFORMATION);
        WindowUtils.showMessage(frame, "Info", MessageType.QUESTION);
        WindowUtils.showMessage(frame, "Info", MessageType.PLAIN);

    }

}
