package io.mymanager.desktop;

import io.mymanager.desktop.enums.MessageType;
import io.mymanager.desktop.util.WindowUtils;
import java.awt.Dimension;
import javax.swing.JFrame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
