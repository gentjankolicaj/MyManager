package com.mymanager.desktop.views.subviews.employee;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.mymanager.data.models.User;
import com.mymanager.desktop.views.MainView;
import com.mymanager.desktop.views.subviews.custom.MyPanel;
import com.mymanager.services.UserService;

public class EmployeeDataView extends MyPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4100590738083935784L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnUsers;
	private JButton btnAdresses;
	private JButton btnContacts;

	private EmployeeView employeeView;
	private AdressView adressView;
	private ContactView contactView;
	private JPanel menuPanel;

	// important for inside navigation
	private JPanel previousPanel;
	//

	private JFrame jframe;
	private MyPanel selfReference;
	private MainView mainView;
	
	//Service
	private UserService userService;
	private User user;

	/**
	 * Create the panel.
	 */
	public EmployeeDataView(JFrame jframe, MainView mainView, UserService userService,User user) {
		super(1500, 750);
		this.jframe = jframe;
		this.mainView = mainView;
		
		this.userService=userService;
		this.user=user;
		
		selfReference = this;
		initComponents();
		initEvents();
	}

	private void initComponents() {
		setLayout(null);

		menuPanel = new JPanel();
		menuPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuPanel.setBounds(13, 83, 242, 284);
		add(menuPanel);
		menuPanel.setLayout(null);

		btnUsers = new JButton("Users");
		buttonGroup.add(btnUsers);
		btnUsers.setBounds(12, 13, 220, 75);
		menuPanel.add(btnUsers);

		btnAdresses = new JButton("Adresses");
		buttonGroup.add(btnAdresses);
		btnAdresses.setBounds(12, 104, 220, 75);
		menuPanel.add(btnAdresses);

		btnContacts = new JButton("Contacts");
		buttonGroup.add(btnContacts);
		btnContacts.setBounds(12, 193, 220, 75);
		menuPanel.add(btnContacts);

		employeeView = new EmployeeView();
		previousPanel = employeeView;
		employeeView.setBounds(267, 13, 1221, 650);
		add(employeeView);
		setSize(1500, 750);

	}

	public void initEvents() {

		btnUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				selfReference.remove(previousPanel);
				employeeView = new EmployeeView();
				selfReference.setSize(menuPanel.getWidth() + employeeView.getMyWidth(), employeeView.getMyHeight());
				employeeView.setBounds(267, 13, employeeView.getMyWidth(), employeeView.getMyHeight());
				selfReference.add(employeeView);
				selfReference.repaint();
				previousPanel = employeeView;

			}
		});
		btnAdresses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				selfReference.remove(previousPanel);
				adressView = new AdressView();
				selfReference.setSize(menuPanel.getWidth() + adressView.getMyWidth(), adressView.getMyHeight());
				adressView.setBounds(267, 13, adressView.getMyWidth(), adressView.getMyHeight());
				selfReference.add(adressView);
				selfReference.repaint();
				previousPanel = adressView;
			}
		});

		btnContacts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				selfReference.remove(previousPanel);
				contactView = new ContactView();
				selfReference.setSize(menuPanel.getWidth() + contactView.getMyWidth(), contactView.getMyHeight());
				contactView.setBounds(267, 13, contactView.getMyWidth(), contactView.getMyHeight());
				selfReference.add(contactView);
				selfReference.repaint();
				previousPanel = contactView;
			}
		});

	}
}
