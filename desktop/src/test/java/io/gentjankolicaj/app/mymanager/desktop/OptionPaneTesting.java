package io.gentjankolicaj.app.mymanager.desktop;

import io.gentjankolicaj.app.mymanager.desktop.enums.MessageType;
import io.gentjankolicaj.app.mymanager.desktop.enums.OptionType;
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

	@Test
	public final void testOption() {
		System.out.println(WindowUtils.showOption(frame, "OPtion testing", OptionType.DEFAULT));
		System.out.println(WindowUtils.showOption(frame, "OPtion testing", OptionType.OK_CANCEL));
		System.out.println(WindowUtils.showOption(frame, "OPtion testing", OptionType.YES_NO));
		System.out.println(WindowUtils.showOption(frame, "OPtion testing", OptionType.YES_NO_CANCEL));

	}

	@Test
	public final void testInput() {
		String[] choices = {"GENI", "JARI", "LYMI", "DIU", "HASANI"};
		System.out.println(WindowUtils.showInput(frame, "HI make a choice", choices, choices[0]));
		System.out.println(WindowUtils.showInput(frame, "HI make a choice", choices, choices[0]));
		System.out.println(WindowUtils.showInput(frame, "HI make a choice", choices, choices[0]));
		System.out.println(WindowUtils.showInput(frame, "HI make a choice", choices, choices[0]));
		System.out.println(WindowUtils.showInput(frame, "Type some text"));

	}

}
