package com.mymanager.views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MainView extends JPanel {
	private JPanel accountPanel;

	/**
	 * Create the panel.
	 */
	public MainView() {
		setBorder(new LineBorder(new Color(0, 191, 255)));
		setForeground(new Color(0, 191, 255));
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		accountPanel = new JPanel();
		accountPanel.setBorder(new LineBorder(new Color(0, 191, 255)));
		accountPanel.setBackground(new Color(255, 255, 255));
		accountPanel.setBounds(0, 0, 235, 650);
		add(accountPanel);
		accountPanel.setLayout(null);

		JLabel lblUser = new JLabel("");
		lblUser.setIcon(new ImageIcon(MainView.class
				.getResource("/com/mymanager/resources/icons/icons_45x45/icons8-administrator-male-2.png")));
		lblUser.setBounds(116, 0, 75, 56);
		accountPanel.add(lblUser);

		JLabel labelFirstname = new JLabel("default");
		labelFirstname.setBounds(72, 53, 153, 19);
		accountPanel.add(labelFirstname);

		JLabel firstname = new JLabel("First name :");
		firstname.setBounds(10, 55, 57, 14);
		accountPanel.add(firstname);

		JLabel labelLastname = new JLabel("default");
		labelLastname.setBounds(72, 83, 153, 19);
		accountPanel.add(labelLastname);

		JLabel labelGender = new JLabel("default");
		labelGender.setBounds(72, 121, 153, 19);
		accountPanel.add(labelGender);

		JLabel labelBirthplace = new JLabel("default");
		labelBirthplace.setBounds(72, 161, 153, 19);
		accountPanel.add(labelBirthplace);

		JLabel labelBirthday = new JLabel("default");
		labelBirthday.setBounds(72, 202, 153, 19);
		accountPanel.add(labelBirthday);

		JLabel labelUsertype = new JLabel("default");
		labelUsertype.setBounds(72, 244, 153, 19);
		accountPanel.add(labelUsertype);

		JLabel labelRights = new JLabel("default");
		labelRights.setBounds(72, 289, 153, 19);
		accountPanel.add(labelRights);

		JLabel labelLastlogin = new JLabel("default");
		labelLastlogin.setBounds(72, 332, 153, 19);
		accountPanel.add(labelLastlogin);

		JLabel labelDate = new JLabel("default");
		labelDate.setBounds(72, 391, 134, 19);
		accountPanel.add(labelDate);

		JLabel lastname = new JLabel("Last name :");
		lastname.setBounds(10, 85, 57, 14);
		accountPanel.add(lastname);

		JLabel gender = new JLabel("Gender :");
		gender.setBounds(10, 123, 57, 14);
		accountPanel.add(gender);

		JLabel birthplace = new JLabel("Birthplace :");
		birthplace.setBounds(10, 163, 57, 14);
		accountPanel.add(birthplace);

		JLabel birthday = new JLabel("Birthday  :");
		birthday.setBounds(10, 204, 57, 14);
		accountPanel.add(birthday);

		JLabel userType = new JLabel("User type  :");
		userType.setBounds(10, 246, 57, 14);
		accountPanel.add(userType);

		JLabel rights = new JLabel("Rights  :");
		rights.setBounds(10, 291, 57, 14);
		accountPanel.add(rights);

		JLabel lastlogin = new JLabel("Last login :");
		lastlogin.setBounds(10, 334, 57, 14);
		accountPanel.add(lastlogin);

		JLabel currentDate = new JLabel("Today date");
		currentDate.setFont(new Font("Tahoma", Font.ITALIC, 11));
		currentDate.setBounds(10, 392, 60, 17);
		accountPanel.add(currentDate);

		JPanel menuPanel = new JPanel();
		menuPanel.setBorder(new LineBorder(new Color(0, 191, 255)));
		menuPanel.setForeground(new Color(0, 191, 255));
		menuPanel.setBackground(new Color(255, 255, 255));
		menuPanel.setBounds(226, 0, 624, 650);
		add(menuPanel);
		menuPanel.setLayout(null);

		JPanel dataPanel = new JPanel();
		dataPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "My Data", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		dataPanel.setBackground(new Color(255, 255, 255));
		dataPanel.setBounds(10, 11, 604, 388);
		menuPanel.add(dataPanel);
		dataPanel.setLayout(null);

		JPanel usersPanel = new JPanel();
		usersPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Users", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		usersPanel.setBackground(new Color(255, 255, 255));
		usersPanel.setBounds(15, 21, 168, 110);
		dataPanel.add(usersPanel);
		usersPanel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(41, 11, 102, 88);
		usersPanel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(
				MainView.class.getResource("/com/mymanager/resources/icons/icons_80x80/icons8-user-menu-male.png")));

		JPanel employeesPanel = new JPanel();
		employeesPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Employees",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		employeesPanel.setBackground(new Color(255, 255, 255));
		employeesPanel.setBounds(216, 21, 173, 110);
		dataPanel.add(employeesPanel);
		employeesPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(43, 11, 97, 88);
		employeesPanel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(
				MainView.class.getResource("/com/mymanager/resources/icons/icons_80x80/icons8-users-meeting-2.png")));

		JPanel clientPanel = new JPanel();
		clientPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Clients", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		clientPanel.setBackground(new Color(255, 255, 255));
		clientPanel.setBounds(420, 21, 168, 110);
		dataPanel.add(clientPanel);
		clientPanel.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MainView.class
				.getResource("/com/mymanager/resources/icons/icons_80x80/icons8-conference-foreground-selected.png")));
		label_1.setBounds(37, 22, 98, 77);
		clientPanel.add(label_1);

		JPanel projectsPanel = new JPanel();
		projectsPanel.setLayout(null);
		projectsPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Projects",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		projectsPanel.setBackground(Color.WHITE);
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
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(216, 142, 168, 110);
		dataPanel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 191, 255)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(15, 263, 168, 110);
		dataPanel.add(panel_2);

		JPanel configPanel = new JPanel();
		configPanel.setBackground(new Color(255, 255, 255));
		configPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Configuration",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		configPanel.setForeground(new Color(0, 0, 0));
		configPanel.setBounds(10, 404, 604, 235);
		menuPanel.add(configPanel);
		configPanel.setLayout(null);

		JPanel myAccountPanel = new JPanel();
		myAccountPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "My Account",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		myAccountPanel.setBackground(new Color(255, 255, 255));
		myAccountPanel.setBounds(35, 26, 87, 78);
		configPanel.add(myAccountPanel);
		myAccountPanel.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				MainView.class.getResource("/com/mymanager/resources/icons/icons_45x45/icons8-edit-account-2.png")));
		label.setBounds(21, 11, 56, 56);
		myAccountPanel.add(label);

		JPanel currenciesPanel = new JPanel();
		currenciesPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Currencies",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		currenciesPanel.setBackground(new Color(255, 255, 255));
		currenciesPanel.setBounds(146, 26, 87, 78);
		configPanel.add(currenciesPanel);
		currenciesPanel.setLayout(null);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(
				MainView.class.getResource("/com/mymanager/resources/icons/icons_45x45/icons8-save-money-2.png")));
		label_2.setBounds(21, 11, 56, 56);
		currenciesPanel.add(label_2);

		JPanel paymentTypePanel = new JPanel();
		paymentTypePanel.setBackground(new Color(255, 255, 255));
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

		JPanel countryPanel = new JPanel();
		countryPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Country", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		countryPanel.setBackground(new Color(255, 255, 255));
		countryPanel.setBounds(371, 26, 87, 78);
		configPanel.add(countryPanel);
		countryPanel.setLayout(null);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(
				MainView.class.getResource("/com/mymanager/resources/icons/icons_45x45/icons8-country.png")));
		label_4.setBounds(21, 11, 56, 56);
		countryPanel.add(label_4);

		JPanel rightsPanel = new JPanel();
		rightsPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Rights", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		rightsPanel.setBackground(new Color(255, 255, 255));
		rightsPanel.setBounds(485, 26, 87, 78);
		configPanel.add(rightsPanel);
		rightsPanel.setLayout(null);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(
				MainView.class.getResource("/com/mymanager/resources/icons/icons_45x45/icons8-user-rights.png")));
		label_5.setBounds(21, 11, 56, 56);
		rightsPanel.add(label_5);

		JPanel fileTypePanel = new JPanel();
		fileTypePanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "File types",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		fileTypePanel.setBackground(new Color(255, 255, 255));
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
}
