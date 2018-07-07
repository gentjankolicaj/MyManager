package com.mymanager.views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

		JLabel lblUser = new JLabel(" User ");
		lblUser.setIcon(new ImageIcon(MainView.class.getResource("/com/mymanager/resources/icons/png/Male.png")));
		lblUser.setBounds(72, 9, 60, 24);
		accountPanel.add(lblUser);

		JLabel labelFirstname = new JLabel("default");
		labelFirstname.setBounds(72, 44, 153, 19);
		accountPanel.add(labelFirstname);

		JLabel firstname = new JLabel("First name :");
		firstname.setBounds(10, 46, 57, 14);
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

		JButton btnChangePassword = new JButton("Change");
		btnChangePassword
				.setIcon(new ImageIcon(MainView.class.getResource("/com/mymanager/resources/icons/png/Blue key.png")));
		btnChangePassword.setForeground(new Color(0, 191, 255));
		btnChangePassword.setBounds(42, 584, 134, 42);
		accountPanel.add(btnChangePassword);

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

		JPanel employeePanel = new JPanel();
		employeePanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Employees",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		employeePanel.setBackground(new Color(255, 255, 255));
		employeePanel.setBounds(15, 21, 168, 110);
		dataPanel.add(employeePanel);
		employeePanel.setLayout(null);

		JPanel userPanel = new JPanel();
		userPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Users", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		userPanel.setBackground(new Color(255, 255, 255));
		userPanel.setBounds(216, 21, 173, 110);
		dataPanel.add(userPanel);
		userPanel.setLayout(null);

		JPanel clientPanel = new JPanel();
		clientPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Clients", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		clientPanel.setBackground(new Color(255, 255, 255));
		clientPanel.setBounds(420, 21, 168, 110);
		dataPanel.add(clientPanel);
		clientPanel.setLayout(null);

		JPanel projectsPanel = new JPanel();
		projectsPanel.setLayout(null);
		projectsPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Projects",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		projectsPanel.setBackground(Color.WHITE);
		projectsPanel.setBounds(15, 142, 168, 110);
		dataPanel.add(projectsPanel);

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

		JPanel currenciesPanel = new JPanel();
		currenciesPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Currencies",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		currenciesPanel.setBackground(new Color(255, 255, 255));
		currenciesPanel.setBounds(146, 26, 87, 78);
		configPanel.add(currenciesPanel);
		currenciesPanel.setLayout(null);

		JPanel paymentTypePanel = new JPanel();
		paymentTypePanel.setBackground(new Color(255, 255, 255));
		paymentTypePanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Payment",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		paymentTypePanel.setBounds(257, 26, 87, 78);
		configPanel.add(paymentTypePanel);
		paymentTypePanel.setLayout(null);

		JPanel countryPanel = new JPanel();
		countryPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Country", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		countryPanel.setBackground(new Color(255, 255, 255));
		countryPanel.setBounds(371, 26, 87, 78);
		configPanel.add(countryPanel);
		countryPanel.setLayout(null);

		JPanel rightsPanel = new JPanel();
		rightsPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Rights", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		rightsPanel.setBackground(new Color(255, 255, 255));
		rightsPanel.setBounds(485, 26, 87, 78);
		configPanel.add(rightsPanel);
		rightsPanel.setLayout(null);

		JPanel fileTypePanel = new JPanel();
		fileTypePanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "File types",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		fileTypePanel.setBackground(new Color(255, 255, 255));
		fileTypePanel.setBounds(35, 134, 87, 78);
		configPanel.add(fileTypePanel);

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
