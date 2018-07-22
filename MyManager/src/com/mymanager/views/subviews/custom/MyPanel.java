package com.mymanager.views.subviews.custom;

import javax.swing.JPanel;

public class MyPanel extends JPanel {

	protected int width;
	protected int height;

	public MyPanel(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getMyHeight() {
		return height;
	}

	public int getMyWidth() {
		return width;
	}

}
