package com.mymanager.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import com.mymanager.config.AppIcon;
import com.mymanager.config.Config;

public class MyFrame extends JFrame {

	public int tempWidth;
	public int tempHeight;
	private JMenu menuFile;
	private JMenu menuView;
	private JMenu menuWindow;
	private JMenu menuAbout;
	private JMenuItem mntmExit;
	private JMenuItem mntmMetal;
	private JMenuItem mntmNimbus;
	private JMenuItem mntmClassic;
	private JMenuItem mntmSize850;
	private JMenuItem mntmSize950;
	private JMenuItem mntmSize1050;
	private JMenuBar menuBar;
	private final ButtonGroup buttonGroupSize = new ButtonGroup();

	List<JMenuItem> menuItemSizeList = new ArrayList<>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
					frame.initFrame();
					frame.initMenu();
					frame.displayFrame();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFrame() {

		initFrame();
		initMenu();
		displayFrame();

	}

	public void initFrame() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setIconImage(AppIcon.getImage(AppIcon.appIcon));
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

		menuView = new JMenu("View");
		menuBar.add(menuView);

		mntmMetal = new JMenuItem("Metal");
		menuView.add(mntmMetal);

		mntmNimbus = new JMenuItem("Nimbus");
		menuView.add(mntmNimbus);

		mntmClassic = new JMenuItem("Classic");
		menuView.add(mntmClassic);

		menuWindow = new JMenu("Window");
		menuWindow.setIcon(null);
		menuBar.add(menuWindow);

		mntmSize850 = new JMenuItem("Size : 900x650");
		buttonGroupSize.add(mntmSize850);
		menuWindow.add(mntmSize850);

		mntmSize950 = new JMenuItem("Size : 990x690");
		buttonGroupSize.add(mntmSize950);
		menuWindow.add(mntmSize950);

		mntmSize1050 = new JMenuItem("Size : 1100x720");
		buttonGroupSize.add(mntmSize1050);
		menuWindow.add(mntmSize1050);

		// adding them to list
		menuItemSizeList.add(mntmSize850);
		menuItemSizeList.add(mntmSize950);
		menuItemSizeList.add(mntmSize1050);

		menuAbout = new JMenu("About");
		menuBar.add(menuAbout);
	}

	public void initMenuEvents() {

	}

	public void initEvents() {

	}

	public void initMenuItemEvents() {
		mntmSize850.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				unSelectAllPrevious();
				mntmSize850.setSelected(true);
				mntmSize850.setBackground(UIManager.getColor("MenuItem.selectionBackground"));
				mntmSize850.setForeground(UIManager.getColor("MenuItem.selectionForeground"));
				tempWidth = 900;
				tempHeight = 650;
				setBounds(e.getXOnScreen() - 100, e.getYOnScreen() - 66, 900, 650);

			}
		});

		mntmSize950.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				unSelectAllPrevious();
				mntmSize950.setSelected(true);
				mntmSize950.setBackground(UIManager.getColor("MenuItem.selectionBackground"));
				mntmSize950.setForeground(UIManager.getColor("MenuItem.selectionForeground"));
				tempWidth = 990;
				tempHeight = 690;
				setBounds(e.getXOnScreen() - 100, e.getYOnScreen() - 77, 990, 690);
			}
		});

		mntmSize1050.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				unSelectAllPrevious();
				mntmSize1050.setSelected(true);
				mntmSize1050.setBackground(UIManager.getColor("MenuItem.selectionBackground"));
				mntmSize1050.setForeground(UIManager.getColor("MenuItem.selectionForeground"));
				tempWidth = 1100;
				tempHeight = 720;
				setBounds(e.getXOnScreen() - 100, e.getYOnScreen() - 95, 1100, 720);
			}
		});
	}

	public void unSelectAllPrevious() {
		for (JMenuItem item : menuItemSizeList) {
			if (item.isSelected())
				item.setSelected(false);
			item.setBackground(UIManager.getColor("MenuItem.background"));
			item.setForeground(UIManager.getColor("MenuItem.foreground"));
		}
	}

}
