package com.mymanager.views;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIManager;

import com.mymanager.config.Config;
import com.mymanager.views.about.AboutDialog;

public class MyFrame extends JFrame {

	public int tempWidth;
	public int tempHeight;
	private JMenu menuFile;
	private JMenu menuView;
	private JMenu menuHelp;
	private JMenuItem mntmExit;
	private JMenuBar menuBar;
	private JMenu mnEdit;
	private JRadioButtonMenuItem rdbtnmntmNimbus;
	private JRadioButtonMenuItem rdbtnmntmMetal;
	private JRadioButtonMenuItem rdbtnmntmClassic;
	private JRadioButtonMenuItem rdbtnmntmWindows;
	private final ButtonGroup buttonGroupView = new ButtonGroup();
	private final ButtonGroup buttonGroupSize = new ButtonGroup();
	private JMenuItem mntmAbout;

	/**
	 * Create the frame.
	 */
	public MyFrame() {
		initMenu();
		initMenuItemEvents();
		initComponents();

		displayFrame();
	}

	public void initComponents() {
		getContentPane().setBackground(UIManager.getColor("Button.background"));
		setBackground(UIManager.getColor("Button.background"));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MyFrame.class.getResource("/com/mymanager/resources/icons/icons_45x45/icons8-admin-2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 150, Config.FRAME_WIDTH, Config.FRAME_HEIGHT);
		setResizable(false);

	}

	public void displayFrame() {
		setVisible(true);
	}

	public void initMenu() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuFile = new JMenu("File");
		menuBar.add(menuFile);

		mntmExit = new JMenuItem("Exit");
		menuFile.add(mntmExit);

		mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		menuView = new JMenu("View");
		menuBar.add(menuView);

		rdbtnmntmMetal = new JRadioButtonMenuItem("Metal");
		buttonGroupView.add(rdbtnmntmMetal);
		menuView.add(rdbtnmntmMetal);

		rdbtnmntmNimbus = new JRadioButtonMenuItem("Nimbus");
		buttonGroupView.add(rdbtnmntmNimbus);
		menuView.add(rdbtnmntmNimbus);

		rdbtnmntmClassic = new JRadioButtonMenuItem("Classic");
		buttonGroupView.add(rdbtnmntmClassic);
		menuView.add(rdbtnmntmClassic);

		rdbtnmntmWindows = new JRadioButtonMenuItem("Windows");
		buttonGroupView.add(rdbtnmntmWindows);
		menuView.add(rdbtnmntmWindows);

		menuHelp = new JMenu("Help");

		mntmAbout = new JMenuItem("About");
		menuHelp.add(mntmAbout);

		menuBar.add(menuHelp);

	}

	public void initMenuEvents() {

	}

	public void initEvents() {

	}

	public void initMenuItemEvents() {
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutDialog aboutDialog = new AboutDialog();
				aboutDialog.setModal(true);
				aboutDialog.setVisible(true);
			}
		});

	}

}
