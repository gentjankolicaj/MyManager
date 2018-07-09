package com.mymanager.views;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import com.mymanager.config.Config;

public class MyFrame extends JFrame {

	public int tempWidth;
	public int tempHeight;
	private JMenu menuFile;
	private JMenu menuView;
	private JMenu menuWindow;
	private JMenu menuHelp;
	private JMenuItem mntmExit;
	private JMenuBar menuBar;
	private JMenu mnEdit;
	private JRadioButtonMenuItem rdbtnmntmNimbus;
	private JRadioButtonMenuItem rdbtnmntmMetal;
	private JRadioButtonMenuItem rdbtnmntmClassic;
	private JRadioButtonMenuItem rdbtnmntmWindows;
	private final ButtonGroup buttonGroupView = new ButtonGroup();
	private JRadioButtonMenuItem rdbtnmntmSizex;
	private JRadioButtonMenuItem rdbtnmntmSizex_1;
	private JRadioButtonMenuItem rdbtnmntmSizex_2;
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
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MyFrame.class.getResource("/com/mymanager/resources/icons/icons_45x45/icons8-admin-2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 150, Config.FRAME_WIDTH, Config.FRAME_HEIGHT);
		this.setResizable(false);

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

		menuWindow = new JMenu("Window");
		menuWindow.setIcon(null);
		menuBar.add(menuWindow);

		rdbtnmntmSizex = new JRadioButtonMenuItem("Size 910x690");
		buttonGroupSize.add(rdbtnmntmSizex);
		menuWindow.add(rdbtnmntmSizex);

		rdbtnmntmSizex_1 = new JRadioButtonMenuItem("Size 980x720");
		buttonGroupSize.add(rdbtnmntmSizex_1);
		menuWindow.add(rdbtnmntmSizex_1);

		rdbtnmntmSizex_2 = new JRadioButtonMenuItem("Size 1100x740");

		buttonGroupSize.add(rdbtnmntmSizex_2);
		menuWindow.add(rdbtnmntmSizex_2);

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

		rdbtnmntmSizex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				setBounds(e.getXOnScreen() - 100, e.getYOnScreen() - 66, 910, 690);
			}
		});

		rdbtnmntmSizex_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				setBounds(e.getXOnScreen() - 100, e.getYOnScreen() - 77, 980, 720);
			}
		});

		rdbtnmntmSizex_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				setBounds(e.getXOnScreen() - 100, e.getYOnScreen() - 95, 1100, 740);
			}
		});

	}

}
