package com.mymanager.views.subviews.user;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mymanager.controllers.UserController;
import com.mymanager.views.MainView;
import com.mymanager.views.subviews.custom.MyPanel;

public class UserDataView extends MyPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4100590738083935784L;

	private final ButtonGroup buttonGroup = new ButtonGroup();

	private UserView userView;
	private AdressView adressView;
	private ContactView contactView;

	// important for inside navigation
	private JPanel previousPanel;
	//

	private JFrame jframe;
	private UserController userController;
	private MyPanel selfReference;
	private MainView mainView;

	private JButton btnContacts;
	private JButton btnAdresses;
	private JButton btnUsers;

	/**
	 * Create the panel.
	 */
	public UserDataView(JFrame jframe, MainView mainView, UserController userController) {
		super(1335, 577);
		this.jframe = jframe;
		this.mainView = mainView;
		this.userController = userController;
		selfReference = this;
		initComponents();
		initEvents();
	}

	private void initComponents() {
		setLayout(null);

		userView = new UserView(jframe, mainView, userController);
		previousPanel = userView;
		userView.setBounds(134, 11, 1221, 650);
		add(userView);
		setSize(1500, 750);

		btnContacts = new JButton("Contacts");
		btnContacts.setBounds(10, 159, 120, 40);
		add(btnContacts);

		btnAdresses = new JButton("Adresses");
		btnAdresses.setBounds(10, 96, 120, 40);
		add(btnAdresses);

		btnUsers = new JButton("Users");
		btnUsers.setBounds(10, 36, 120, 40);
		add(btnUsers);

	}

	public void initEvents() {

		btnUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				selfReference.remove(previousPanel);
				userView = new UserView(jframe, mainView, userController);
				selfReference.setSize(selfReference.getWidth() + userView.getMyWidth(), userView.getMyHeight());
				userView.setBounds(134, 11, userView.getMyWidth(), userView.getMyHeight());
				selfReference.add(userView);
				selfReference.repaint();
				previousPanel = userView;

			}
		});
		btnAdresses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				selfReference.remove(previousPanel);
				adressView = new AdressView(jframe, mainView, userController);
				selfReference.setSize(selfReference.getWidth() + adressView.getMyWidth(), adressView.getMyHeight());
				adressView.setBounds(134, 11, adressView.getMyWidth(), adressView.getMyHeight());
				selfReference.add(adressView);
				selfReference.repaint();
				previousPanel = adressView;
			}
		});

		btnContacts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				selfReference.remove(previousPanel);
				contactView = new ContactView(jframe, mainView, userController);
				selfReference.setSize(selfReference.getWidth() + contactView.getMyWidth(), contactView.getMyHeight());
				contactView.setBounds(134, 11, contactView.getMyWidth(), contactView.getMyHeight());
				selfReference.add(contactView);
				selfReference.repaint();
				previousPanel = contactView;
			}
		});
	}
}
