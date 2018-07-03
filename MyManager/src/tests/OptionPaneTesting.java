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

	JFrame frame;

	@Before
	public void setUp() throws Exception {
		frame = new JFrame();
		frame.setSize(new Dimension(600, 350));
		frame.setVisible(true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testMessage() {
		UtilWindow.showMessage(frame, "Info", MessageType.ERROR);
		UtilWindow.showMessage(frame, "Info", MessageType.WARNING);
		UtilWindow.showMessage(frame, "Info", MessageType.INFORMATION);
		UtilWindow.showMessage(frame, "Info", MessageType.QUESTION);
		UtilWindow.showMessage(frame, "Info", MessageType.PLAIN);

	}

	@Test
	public final void testOption() {
		System.out.println(UtilWindow.showOption(frame, "OPtion testing", OptionType.DEFAULT));
		System.out.println(UtilWindow.showOption(frame, "OPtion testing", OptionType.OK_CANCEL));
		System.out.println(UtilWindow.showOption(frame, "OPtion testing", OptionType.YES_NO));
		System.out.println(UtilWindow.showOption(frame, "OPtion testing", OptionType.YES_NO_CANCEL));

	}

	@Test
	public final void testInput() {
		String[] choices = { "GENI", "JARI", "LYMI", "DIU", "HASANI" };
		System.out.println(UtilWindow.showInput(frame, "HI make a choice", choices, choices[0]));
		System.out.println(UtilWindow.showInput(frame, "HI make a choice", choices, choices[0]));
		System.out.println(UtilWindow.showInput(frame, "HI make a choice", choices, choices[0]));
		System.out.println(UtilWindow.showInput(frame, "HI make a choice", choices, choices[0]));

	}

}
