package com.mymanager.utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class AppUtil {
	public static int x, y;

	public static void setBoundsAccordingToPanel(JFrame jframe, JPanel jpanel, int x, int y) {
		int width = jpanel.getWidth();
		int height = jpanel.getHeight();
		jframe.setBounds(x, y, width, height);
	}

	public static void makePanelMove(JFrame jframe, JPanel jpanel) {

		jpanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}

		});
		jpanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xx = e.getXOnScreen();
				int yy = e.getYOnScreen();
				jframe.setLocation(xx - x, yy - y);
			}
		});

	}

	public static void changePanel(JFrame jframe, JPanel jpanel) {
		jframe.setContentPane(jpanel);
		jframe.invalidate();
		jframe.validate();
	}
}
