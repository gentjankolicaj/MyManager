package tests;

import java.awt.Dimension;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mymanager.utils.MessageType;
import com.mymanager.utils.OptionType;
import com.mymanager.utils.UtilWindow;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class OptionPaneTesting {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testMessage() {
		JFrame frame = new JFrame();
		frame.setSize(new Dimension(600, 350));
		frame.setVisible(true);
		UtilWindow.showMessage(frame, "Info", MessageType.ERROR);
	}

	@Test
	public final void testOption() {
		JFrame frame = new JFrame();
		frame.setSize(new Dimension(600, 350));
		frame.setVisible(true);
		UtilWindow.showOption(frame, "OPtion testing", OptionType.DEFAULT);
		UtilWindow.showOption(frame, "OPtion testing", OptionType.OK_CANCEL);
		UtilWindow.showOption(frame, "OPtion testing", OptionType.YES_NO);
		UtilWindow.showOption(frame, "OPtion testing", OptionType.YES_NO_CANCEL);

	}

}
