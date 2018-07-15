package com.mymanager.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.mymanager.controllers.UserController;
import com.mymanager.data.models.User;
import com.mymanager.data.models.UserType;
import com.mymanager.utils.AppUtil;
import com.mymanager.utils.MessageType;
import com.mymanager.utils.UtilWindow;
import com.mymanager.views.subviews.AccountView;
import com.mymanager.views.subviews.CountryView;
import com.mymanager.views.subviews.CurrencyView;
import com.mymanager.views.subviews.CustomerView;
import com.mymanager.views.subviews.EmployeeView;
import com.mymanager.views.subviews.FileView;
import com.mymanager.views.subviews.PaymentTypeView;
import com.mymanager.views.subviews.ProjectView;
import com.mymanager.views.subviews.RightsView;
import com.mymanager.views.subviews.UserView;

public class MainView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7963323342444755630L;

	private JFrame jframe;

	private JPanel accountPanel;
	private JPanel usersPanel;
	private JPanel employeesPanel;
	private JPanel projectsPanel;

	private JLabel labelFirstname;
	private JLabel labelLastname;
	private JLabel labelGender;
	private JLabel labelBirthplace;
	private JLabel labelBirthday;
	private JLabel labelUsertype;
	private JLabel labelRights;
	private JLabel labelLastlogin;
	private JLabel labelDate;

	private JPanel customerPanel;
	private JPanel myAccountPanel;
	private JPanel currenciesPanel;
	private JPanel paymentTypePanel;
	private JPanel rightsPanel;
	private JPanel fileTypePanel;
	private JPanel countryPanel;

	private User user;
	private UserController userController;
	private JLabel labelUserId;

	// Views
	//
	private UserView usersView;
	private EmployeeView employeesView;
	private ProjectView projectsView;
	private CustomerView customersView;

	/**
	 * Create the panel.
	 */
	public MainView(JFrame jframe) {
		this.jframe = jframe;
		usersView = new UserView(jframe);
		employeesView = new EmployeeView(jframe);
		projectsView = new ProjectView(jframe);
		customersView = new CustomerView(jframe);

		initComponents();
		initAccountEvents();
		initConfigEvents();

	}

	public void initComponents() {
		setBorder(new LineBorder(new Color(0, 191, 255)));
		setForeground(new Color(0, 191, 255));
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		accountPanel = new JPanel();
		accountPanel.setBorder(new LineBorder(new Color(0, 191, 255)));
		accountPanel.setBackground(UIManager.getColor("Button.background"));
		accountPanel.setBounds(0, 0, 284, 650);
		add(accountPanel);
		accountPanel.setLayout(null);

		JLabel lblUser = new JLabel("");
		lblUser.setIcon(new ImageIcon(MainView.class
				.getResource("/com/mymanager/resources/icons/icons_45x45/icons8-administrator-male-2.png")));
		lblUser.setBounds(116, 0, 75, 56);
		accountPanel.add(lblUser);

		labelFirstname = new JLabel("default");
		labelFirstname.setBounds(95, 127, 162, 19);
		accountPanel.add(labelFirstname);

		JLabel firstname = new JLabel("First name :");
		firstname.setFont(new Font("Arial", Font.BOLD, 13));
		firstname.setBounds(10, 127, 75, 19);
		accountPanel.add(firstname);

		labelLastname = new JLabel("default");
		labelLastname.setBounds(95, 169, 162, 19);
		accountPanel.add(labelLastname);

		labelGender = new JLabel("default");
		labelGender.setBounds(95, 207, 162, 19);
		accountPanel.add(labelGender);

		labelBirthplace = new JLabel("default");
		labelBirthplace.setBounds(95, 247, 162, 19);
		accountPanel.add(labelBirthplace);

		labelBirthday = new JLabel("default");
		labelBirthday.setBounds(98, 288, 159, 19);
		accountPanel.add(labelBirthday);

		labelUsertype = new JLabel("default");
		labelUsertype.setBounds(98, 330, 140, 19);
		accountPanel.add(labelUsertype);

		labelRights = new JLabel("default");
		labelRights.setBounds(81, 375, 193, 19);
		accountPanel.add(labelRights);

		labelLastlogin = new JLabel("default");
		labelLastlogin.setBounds(95, 416, 162, 19);
		accountPanel.add(labelLastlogin);

		labelDate = new JLabel("default");
		labelDate.setBounds(95, 475, 162, 19);
		accountPanel.add(labelDate);

		JLabel lastname = new JLabel("Last name :");
		lastname.setFont(new Font("Arial", Font.BOLD, 13));
		lastname.setBounds(10, 169, 75, 19);
		accountPanel.add(lastname);

		JLabel gender = new JLabel("Gender :");
		gender.setFont(new Font("Arial", Font.BOLD, 13));
		gender.setBounds(10, 207, 75, 19);
		accountPanel.add(gender);

		JLabel birthplace = new JLabel("Birthplace :");
		birthplace.setFont(new Font("Arial", Font.BOLD, 13));
		birthplace.setBounds(10, 247, 75, 19);
		accountPanel.add(birthplace);

		JLabel birthday = new JLabel("Birthday  :");
		birthday.setFont(new Font("Arial", Font.BOLD, 13));
		birthday.setBounds(10, 288, 75, 19);
		accountPanel.add(birthday);

		JLabel userType = new JLabel("User type  :");
		userType.setFont(new Font("Arial", Font.BOLD, 13));
		userType.setBounds(10, 330, 75, 19);
		accountPanel.add(userType);

		JLabel rights = new JLabel("Rights  :");
		rights.setFont(new Font("Arial", Font.BOLD, 13));
		rights.setBounds(10, 375, 75, 19);
		accountPanel.add(rights);

		JLabel lastlogin = new JLabel("Last login :");
		lastlogin.setFont(new Font("Arial", Font.BOLD, 13));
		lastlogin.setBounds(10, 418, 75, 17);
		accountPanel.add(lastlogin);

		JLabel currentDate = new JLabel("Today date");
		currentDate.setFont(new Font("Arial", Font.BOLD, 13));
		currentDate.setBounds(10, 476, 75, 18);
		accountPanel.add(currentDate);

		JLabel userId = new JLabel("User ID :");
		userId.setFont(new Font("Arial", Font.BOLD, 13));
		userId.setBounds(10, 92, 60, 14);
		accountPanel.add(userId);

		labelUserId = new JLabel("default");
		labelUserId.setBounds(95, 92, 162, 19);
		accountPanel.add(labelUserId);

		JPanel menuPanel = new JPanel();
		menuPanel.setBorder(new LineBorder(new Color(0, 191, 255)));
		menuPanel.setForeground(new Color(0, 191, 255));
		menuPanel.setBackground(UIManager.getColor("Button.background"));
		menuPanel.setBounds(226, 0, 752, 650);
		add(menuPanel);
		menuPanel.setLayout(null);

		JPanel dataPanel = new JPanel();
		dataPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "My Data", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		dataPanel.setBackground(UIManager.getColor("Button.background"));
		dataPanel.setBounds(61, 11, 604, 388);
		menuPanel.add(dataPanel);
		dataPanel.setLayout(null);

		usersPanel = new JPanel();
		usersPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Users", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		usersPanel.setBackground(UIManager.getColor("Button.background"));
		usersPanel.setBounds(15, 21, 168, 110);
		dataPanel.add(usersPanel);
		usersPanel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(41, 11, 102, 88);
		usersPanel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(
				MainView.class.getResource("/com/mymanager/resources/icons/icons_80x80/icons8-user-menu-male.png")));

		employeesPanel = new JPanel();
		employeesPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Employees",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		employeesPanel.setBackground(UIManager.getColor("Button.background"));
		employeesPanel.setBounds(216, 21, 173, 110);
		dataPanel.add(employeesPanel);
		employeesPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(43, 11, 97, 88);
		employeesPanel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(
				MainView.class.getResource("/com/mymanager/resources/icons/icons_80x80/icons8-users-meeting-2.png")));

		customerPanel = new JPanel();
		customerPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Customers",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		customerPanel.setBackground(UIManager.getColor("Button.background"));
		customerPanel.setBounds(420, 21, 168, 110);
		dataPanel.add(customerPanel);
		customerPanel.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MainView.class
				.getResource("/com/mymanager/resources/icons/icons_80x80/icons8-conference-foreground-selected.png")));
		label_1.setBounds(37, 22, 98, 77);
		customerPanel.add(label_1);

		projectsPanel = new JPanel();

		projectsPanel.setLayout(null);
		projectsPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Projects",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		projectsPanel.setBackground(UIManager.getColor("Button.background"));
		projectsPanel.setBounds(15, 142, 168, 110);
		dataPanel.add(projectsPanel);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(
				MainView.class.getResource("/com/mymanager/resources/icons/icons_80x80/icons8-training-2.png")));
		lblNewLabel_2.setBounds(42, 11, 100, 88);
		projectsPanel.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 191, 255)));
		panel_1.setBackground(UIManager.getColor("Button.background"));
		panel_1.setBounds(216, 142, 168, 110);
		dataPanel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 191, 255)));
		panel_2.setBackground(UIManager.getColor("Button.background"));
		panel_2.setBounds(15, 263, 168, 110);
		dataPanel.add(panel_2);

		JPanel configPanel = new JPanel();
		configPanel.setBackground(UIManager.getColor("Button.background"));
		configPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Configuration",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		configPanel.setForeground(new Color(0, 0, 0));
		configPanel.setBounds(61, 404, 604, 235);
		menuPanel.add(configPanel);
		configPanel.setLayout(null);

		myAccountPanel = new JPanel();
		myAccountPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "My Account",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		myAccountPanel.setBackground(UIManager.getColor("Button.background"));
		myAccountPanel.setBounds(35, 26, 87, 78);
		configPanel.add(myAccountPanel);
		myAccountPanel.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				MainView.class.getResource("/com/mymanager/resources/icons/icons_45x45/icons8-edit-account-2.png")));
		label.setBounds(21, 11, 56, 56);
		myAccountPanel.add(label);

		currenciesPanel = new JPanel();
		currenciesPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Currencies",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		currenciesPanel.setBackground(UIManager.getColor("Button.background"));
		currenciesPanel.setBounds(146, 26, 87, 78);
		configPanel.add(currenciesPanel);
		currenciesPanel.setLayout(null);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(
				MainView.class.getResource("/com/mymanager/resources/icons/icons_45x45/icons8-save-money-2.png")));
		label_2.setBounds(21, 11, 56, 56);
		currenciesPanel.add(label_2);

		paymentTypePanel = new JPanel();
		paymentTypePanel.setBackground(UIManager.getColor("Button.background"));
		paymentTypePanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Payment",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		paymentTypePanel.setBounds(257, 26, 87, 78);
		configPanel.add(paymentTypePanel);
		paymentTypePanel.setLayout(null);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(
				MainView.class.getResource("/com/mymanager/resources/icons/icons_45x45/icons8-payment-history.png")));
		label_3.setBounds(21, 11, 56, 56);
		paymentTypePanel.add(label_3);

		countryPanel = new JPanel();
		countryPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Country", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		countryPanel.setBackground(UIManager.getColor("Button.background"));
		countryPanel.setBounds(371, 26, 87, 78);
		configPanel.add(countryPanel);
		countryPanel.setLayout(null);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(
				MainView.class.getResource("/com/mymanager/resources/icons/icons_45x45/icons8-country.png")));
		label_4.setBounds(21, 11, 56, 56);
		countryPanel.add(label_4);

		rightsPanel = new JPanel();
		rightsPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Rights", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		rightsPanel.setBackground(UIManager.getColor("Button.background"));
		rightsPanel.setBounds(485, 26, 87, 78);
		configPanel.add(rightsPanel);
		rightsPanel.setLayout(null);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(
				MainView.class.getResource("/com/mymanager/resources/icons/icons_45x45/icons8-user-rights.png")));
		label_5.setBounds(21, 11, 56, 56);
		rightsPanel.add(label_5);

		fileTypePanel = new JPanel();
		fileTypePanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "File types",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		fileTypePanel.setBackground(UIManager.getColor("Button.background"));
		fileTypePanel.setBounds(35, 134, 87, 78);
		configPanel.add(fileTypePanel);
		fileTypePanel.setLayout(null);

		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(
				MainView.class.getResource("/com/mymanager/resources/icons/icons_45x45/icons8-documents.png")));
		label_6.setBounds(21, 11, 56, 56);
		fileTypePanel.add(label_6);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(146, 134, 87, 78);
		configPanel.add(panel_7);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(257, 134, 87, 78);
		configPanel.add(panel_8);

		JPanel panel_9 = new JPanel();
		panel_9.setBounds(371, 134, 87, 78);
		configPanel.add(panel_9);

		JPanel panel_10 = new JPanel();
		panel_10.setBounds(485, 134, 87, 78);
		configPanel.add(panel_10);

	}

	public void initAccountEvents() {
		usersPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				usersView.setUserController(userController);
				AppUtil.changePanel(jframe, usersView);
			}
		});

		employeesPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				employeesView.setUserController(userController);
				AppUtil.changePanel(jframe, employeesView);
			}
		});

		customerPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				customersView.setUserController(userController);
				AppUtil.changePanel(jframe, customersView);
			}
		});

		projectsPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				projectsView.setUserController(userController);
				AppUtil.changePanel(jframe, projectsView);
			}
		});

	}

	public void initConfigEvents() {

		myAccountPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				AccountView accountView = new AccountView(userController);
				accountView.setModal(true);
				accountView.setVisible(true);
				updateMainViewUserDetails();
			}
		});

		currenciesPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (user.getUserType().equals(UserType.ADMIN.toString())) {
					CurrencyView currencyView = new CurrencyView(userController);
					currencyView.setModal(true);
					currencyView.setVisible(true);

				} else
					UtilWindow.showMessage(null, "Admin users only can access currency panel.",
							MessageType.INFORMATION);
			}
		});

		fileTypePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (user.getUserType().equals(UserType.ADMIN.toString())) {
					FileView fileView = new FileView(userController);
					fileView.setModal(true);
					fileView.setVisible(true);

				} else
					UtilWindow.showMessage(null, "Admin users only can access currency panel.",
							MessageType.INFORMATION);
			}
		});

		rightsPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (user.getUserType().equals(UserType.ADMIN.toString())) {
					RightsView rightsView = new RightsView(userController);
					rightsView.updateUserComboBox();
					rightsView.setModal(true);
					rightsView.setVisible(true);

					updateMainViewUserDetails();
				} else
					UtilWindow.showMessage(null, "Admin users only can access rights panel.", MessageType.INFORMATION);

			}
		});

		countryPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (user.getUserType().equals(UserType.ADMIN.toString())) {
					CountryView countryView = new CountryView(userController);
					countryView.setModal(true);
					countryView.setVisible(true);

				} else
					UtilWindow.showMessage(null, "Admin users only can access country panel.", MessageType.INFORMATION);
			}
		});

		paymentTypePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (user.getUserType().equals(UserType.ADMIN.toString())) {
					PaymentTypeView paymentTypeView = new PaymentTypeView(userController);
					paymentTypeView.setModal(true);
					paymentTypeView.setVisible(true);

				} else
					UtilWindow.showMessage(null, "Admin users only can access country panel.", MessageType.INFORMATION);
			}
		});
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
		this.user = userController.getUser();
		setMainViewUserDetails(user);
	}

	private void setMainViewUserDetails(User user) {
		labelUserId.setText(user.getUserId());
		labelFirstname.setText(user.getFirstName());
		labelLastname.setText(user.getLastName());
		labelGender.setText(user.getGender().name());
		labelBirthplace.setText(user.getBirthplace());
		labelBirthday.setText(user.getBirthday().toString());
		labelUsertype.setText(user.getUserType());
		labelRights.setText(user.getRights());
		labelDate.setText(LocalDateTime.now().toString());

	}

	public void updateMainViewUserDetails() {
		user = userController.getUser(user.getUserId());
		setMainViewUserDetails(user);
	}
}
