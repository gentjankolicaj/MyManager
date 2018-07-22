package com.mymanager.views.subviews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.mymanager.controllers.UserController;
import com.mymanager.data.models.User;
import com.mymanager.utils.MessageType;
import com.mymanager.utils.UtilWindow;

public class AccountView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3547202059282319569L;

	private JDialog selfReference;
	private final JPanel contentPanel = new JPanel();

	private JTextField id;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField gender;
	private JTextField birthplace;
	private JTextField birthday;
	private JTextField usertype;
	private JTextField rights;

	private User user;
	private UserController userController;

	// Password panel
	private JPasswordField textFieldOldPassword;
	private JPasswordField textFieldNewPassword;
	private JPasswordField textFieldRetypePassword;
	private JButton btnSavePassword;
	private JPanel passwordPanel;
	private JLabel lblNewLabel;
	private JButton button;
	private JLabel label_8;
	private JPanel contactPanel;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel label_17;
	private JTextField textField_7;
	private JButton button_1;
	private JLabel label_18;
	private JPanel AdressPanel;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel label_21;
	private JLabel label_22;
	private JLabel label_23;
	private JLabel label_24;
	private JLabel label_25;
	private JLabel label_26;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JLabel label_27;
	private JTextField textField_15;
	private JButton button_2;
	private JLabel label_28;
	private JButton buttonBack1;
	private JButton buttonBack2;
	private JButton buttonBack3;
	private JButton buttonBack4;

	/**
	 * Create the dialog.
	 */
	public AccountView(UserController userController) {
		this.selfReference = this;
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.userController = userController;
		this.user = userController.getUser();

		initComponents();
		initPanelEvents();
		initUserDetailsPanelEvents();
		initPasswordPanelEvents();
		initContactDetailsPanelEvents();
		initAdressDetailsPanelEvents();

		refreshPersonalDetails();
	}

	private void initComponents() {
		setTitle("My Account");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				AccountView.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-admin-2.png")));
		setBounds(100, 100, 997, 700);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel userDetailsPanel = new JPanel();
		userDetailsPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Personal details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		userDetailsPanel.setBounds(10, 11, 964, 166);
		contentPanel.add(userDetailsPanel);
		userDetailsPanel.setLayout(null);

		JLabel label = new JLabel("User ID :");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(23, 50, 60, 14);
		userDetailsPanel.add(label);

		JLabel label_1 = new JLabel("First name :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(333, 10, 75, 19);
		userDetailsPanel.add(label_1);

		JLabel label_2 = new JLabel("Last name :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(661, 11, 75, 19);
		userDetailsPanel.add(label_2);

		JLabel label_3 = new JLabel("Gender :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(23, 86, 75, 19);
		userDetailsPanel.add(label_3);

		JLabel label_4 = new JLabel("Birthplace :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(333, 47, 75, 19);
		userDetailsPanel.add(label_4);

		JLabel label_5 = new JLabel("Birthday  :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(661, 49, 75, 19);
		userDetailsPanel.add(label_5);

		JLabel label_6 = new JLabel("User type  :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(333, 87, 66, 19);
		userDetailsPanel.add(label_6);

		JLabel label_7 = new JLabel("Rights  :");
		label_7.setBounds(0, 294, 75, 19);
		userDetailsPanel.add(label_7);

		id = new JTextField();
		id.setBounds(84, 47, 218, 20);
		userDetailsPanel.add(id);
		id.setColumns(10);

		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(407, 11, 218, 20);
		userDetailsPanel.add(firstname);

		lastname = new JTextField();
		lastname.setColumns(10);
		lastname.setBounds(736, 11, 218, 20);
		userDetailsPanel.add(lastname);

		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(84, 87, 218, 20);
		userDetailsPanel.add(gender);

		birthplace = new JTextField();
		birthplace.setColumns(10);
		birthplace.setBounds(407, 48, 218, 20);
		userDetailsPanel.add(birthplace);

		birthday = new JTextField();
		birthday.setColumns(10);
		birthday.setBounds(736, 48, 218, 20);
		userDetailsPanel.add(birthday);

		usertype = new JTextField();
		usertype.setColumns(10);
		usertype.setBounds(404, 87, 221, 19);
		userDetailsPanel.add(usertype);

		JLabel lblRights = new JLabel("Rights  :");
		lblRights.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRights.setBounds(661, 89, 60, 19);
		userDetailsPanel.add(lblRights);

		rights = new JTextField();
		rights.setText((String) null);
		rights.setColumns(10);
		rights.setBounds(736, 86, 218, 20);
		userDetailsPanel.add(rights);

		button = new JButton("Save");
		button.setBounds(31, 132, 89, 23);
		userDetailsPanel.add(button);

		label_8 = new JLabel("");
		label_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		label_8.setBounds(310, 133, 644, 22);
		userDetailsPanel.add(label_8);

		buttonBack1 = new JButton("Back");
		buttonBack1.setBounds(130, 132, 89, 23);
		userDetailsPanel.add(buttonBack1);

		passwordPanel = new JPanel();
		passwordPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Change password",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		passwordPanel.setBounds(10, 183, 961, 107);
		contentPanel.add(passwordPanel);
		passwordPanel.setLayout(null);

		JLabel lblOld = new JLabel("Actual  :");
		lblOld.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOld.setBounds(14, 22, 57, 29);
		passwordPanel.add(lblOld);

		textFieldOldPassword = new JPasswordField();
		textFieldOldPassword.setText((String) null);
		textFieldOldPassword.setColumns(10);
		textFieldOldPassword.setBounds(81, 26, 218, 20);
		passwordPanel.add(textFieldOldPassword);

		JLabel lblNew = new JLabel("New :");
		lblNew.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNew.setBounds(360, 27, 40, 19);
		passwordPanel.add(lblNew);

		textFieldNewPassword = new JPasswordField();
		textFieldNewPassword.setText((String) null);
		textFieldNewPassword.setColumns(10);
		textFieldNewPassword.setBounds(404, 27, 218, 20);
		passwordPanel.add(textFieldNewPassword);

		JLabel lblRetype = new JLabel("Re-type  :");
		lblRetype.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRetype.setBounds(666, 27, 65, 19);
		passwordPanel.add(lblRetype);

		textFieldRetypePassword = new JPasswordField();
		textFieldRetypePassword.setText((String) null);
		textFieldRetypePassword.setColumns(10);
		textFieldRetypePassword.setBounds(733, 27, 218, 20);
		passwordPanel.add(textFieldRetypePassword);

		btnSavePassword = new JButton("Save");
		btnSavePassword.setBounds(30, 73, 89, 23);
		passwordPanel.add(btnSavePassword);

		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(309, 74, 642, 22);
		passwordPanel.add(lblNewLabel);

		buttonBack2 = new JButton("Back");
		buttonBack2.setBounds(131, 73, 89, 23);
		passwordPanel.add(buttonBack2);

		contactPanel = new JPanel();
		contactPanel.setLayout(null);
		contactPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Contact details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contactPanel.setBounds(10, 301, 964, 166);
		contentPanel.add(contactPanel);

		label_9 = new JLabel("User ID :");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_9.setBounds(23, 50, 60, 14);
		contactPanel.add(label_9);

		label_10 = new JLabel("First name :");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_10.setBounds(333, 10, 75, 19);
		contactPanel.add(label_10);

		label_11 = new JLabel("Last name :");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_11.setBounds(661, 11, 75, 19);
		contactPanel.add(label_11);

		label_12 = new JLabel("Gender :");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_12.setBounds(23, 86, 75, 19);
		contactPanel.add(label_12);

		label_13 = new JLabel("Birthplace :");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_13.setBounds(333, 47, 75, 19);
		contactPanel.add(label_13);

		label_14 = new JLabel("Birthday  :");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_14.setBounds(661, 49, 75, 19);
		contactPanel.add(label_14);

		label_15 = new JLabel("User type  :");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_15.setBounds(333, 87, 66, 19);
		contactPanel.add(label_15);

		label_16 = new JLabel("Rights  :");
		label_16.setBounds(0, 294, 75, 19);
		contactPanel.add(label_16);

		textField = new JTextField();
		textField.setText((String) null);
		textField.setColumns(10);
		textField.setBounds(84, 47, 218, 20);
		contactPanel.add(textField);

		textField_1 = new JTextField();
		textField_1.setText((String) null);
		textField_1.setColumns(10);
		textField_1.setBounds(407, 11, 218, 20);
		contactPanel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setText((String) null);
		textField_2.setColumns(10);
		textField_2.setBounds(736, 11, 218, 20);
		contactPanel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setText((String) null);
		textField_3.setColumns(10);
		textField_3.setBounds(84, 87, 218, 20);
		contactPanel.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setText((String) null);
		textField_4.setColumns(10);
		textField_4.setBounds(407, 48, 218, 20);
		contactPanel.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setText((String) null);
		textField_5.setColumns(10);
		textField_5.setBounds(736, 48, 218, 20);
		contactPanel.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setText((String) null);
		textField_6.setColumns(10);
		textField_6.setBounds(404, 87, 221, 19);
		contactPanel.add(textField_6);

		label_17 = new JLabel("Rights  :");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_17.setBounds(661, 89, 60, 19);
		contactPanel.add(label_17);

		textField_7 = new JTextField();
		textField_7.setText((String) null);
		textField_7.setColumns(10);
		textField_7.setBounds(736, 86, 218, 20);
		contactPanel.add(textField_7);

		button_1 = new JButton("Save");
		button_1.setBounds(31, 132, 89, 23);
		contactPanel.add(button_1);

		label_18 = new JLabel("");
		label_18.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		label_18.setBounds(310, 133, 644, 22);
		contactPanel.add(label_18);

		buttonBack3 = new JButton("Back");
		buttonBack3.setBounds(130, 132, 89, 23);
		contactPanel.add(buttonBack3);

		AdressPanel = new JPanel();
		AdressPanel.setLayout(null);
		AdressPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Adress details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		AdressPanel.setBounds(10, 478, 964, 166);
		contentPanel.add(AdressPanel);

		label_19 = new JLabel("User ID :");
		label_19.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_19.setBounds(23, 50, 60, 14);
		AdressPanel.add(label_19);

		label_20 = new JLabel("First name :");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_20.setBounds(333, 10, 75, 19);
		AdressPanel.add(label_20);

		label_21 = new JLabel("Last name :");
		label_21.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_21.setBounds(661, 11, 75, 19);
		AdressPanel.add(label_21);

		label_22 = new JLabel("Gender :");
		label_22.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_22.setBounds(23, 86, 75, 19);
		AdressPanel.add(label_22);

		label_23 = new JLabel("Birthplace :");
		label_23.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_23.setBounds(333, 47, 75, 19);
		AdressPanel.add(label_23);

		label_24 = new JLabel("Birthday  :");
		label_24.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_24.setBounds(661, 49, 75, 19);
		AdressPanel.add(label_24);

		label_25 = new JLabel("User type  :");
		label_25.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_25.setBounds(333, 87, 66, 19);
		AdressPanel.add(label_25);

		label_26 = new JLabel("Rights  :");
		label_26.setBounds(0, 294, 75, 19);
		AdressPanel.add(label_26);

		textField_8 = new JTextField();
		textField_8.setText((String) null);
		textField_8.setColumns(10);
		textField_8.setBounds(84, 47, 218, 20);
		AdressPanel.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setText((String) null);
		textField_9.setColumns(10);
		textField_9.setBounds(407, 11, 218, 20);
		AdressPanel.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setText((String) null);
		textField_10.setColumns(10);
		textField_10.setBounds(736, 11, 218, 20);
		AdressPanel.add(textField_10);

		textField_11 = new JTextField();
		textField_11.setText((String) null);
		textField_11.setColumns(10);
		textField_11.setBounds(84, 87, 218, 20);
		AdressPanel.add(textField_11);

		textField_12 = new JTextField();
		textField_12.setText((String) null);
		textField_12.setColumns(10);
		textField_12.setBounds(407, 48, 218, 20);
		AdressPanel.add(textField_12);

		textField_13 = new JTextField();
		textField_13.setText((String) null);
		textField_13.setColumns(10);
		textField_13.setBounds(736, 48, 218, 20);
		AdressPanel.add(textField_13);

		textField_14 = new JTextField();
		textField_14.setText((String) null);
		textField_14.setColumns(10);
		textField_14.setBounds(404, 87, 221, 19);
		AdressPanel.add(textField_14);

		label_27 = new JLabel("Rights  :");
		label_27.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_27.setBounds(661, 89, 60, 19);
		AdressPanel.add(label_27);

		textField_15 = new JTextField();
		textField_15.setText((String) null);
		textField_15.setColumns(10);
		textField_15.setBounds(736, 86, 218, 20);
		AdressPanel.add(textField_15);

		button_2 = new JButton("Save");
		button_2.setBounds(31, 132, 89, 23);
		AdressPanel.add(button_2);

		label_28 = new JLabel("");
		label_28.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		label_28.setBounds(310, 133, 644, 22);
		AdressPanel.add(label_28);

		buttonBack4 = new JButton("Back");
		buttonBack4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		buttonBack4.setBounds(130, 132, 89, 23);
		AdressPanel.add(buttonBack4);

	}

	private void initPanelEvents() {
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblNewLabel.setText("");
			}
		});
	}

	private void initUserDetailsPanelEvents() {
		buttonBack1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				selfReference.dispose();
			}
		});
	}

	private void initPasswordPanelEvents() {
		btnSavePassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				changePassword();
			}
		});

		buttonBack2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				selfReference.dispose();
			}
		});
	}

	private void initContactDetailsPanelEvents() {

		buttonBack3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				selfReference.dispose();
			}
		});

	}

	private void initAdressDetailsPanelEvents() {
		buttonBack4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				selfReference.dispose();
			}
		});
	}

	private void refreshPersonalDetails() {
		user = userController.getUser(user.getUserId());
		id.setText(user.getUserId());
		firstname.setText(user.getFirstName());
		lastname.setText(user.getLastName());
		gender.setText(user.getGender().name());
		birthplace.setText(user.getBirthplace());
		birthday.setText(user.getBirthday().toString());
		usertype.setText(user.getUserType());
		rights.setText(user.getRights());

	}

	private void changePassword() {
		char[] oldPassArray = textFieldOldPassword.getPassword();
		char[] newPassArray = textFieldNewPassword.getPassword();
		char[] retypedNewPassArray = textFieldRetypePassword.getPassword();
		String oldPass = String.valueOf(oldPassArray);
		String newPass = String.valueOf(newPassArray);
		String retypedNewPass = String.valueOf(retypedNewPassArray);

		try {
			if (userController.verifyOldPassword(oldPass)) {
				if (userController.verifyNewPasswords(newPass, retypedNewPass)) {
					User newUser = new User(user.getUserId(), user.getUserType(), user.getFirstName(),
							user.getLastName(), null, user.getBirthday(), user.getBirthplace(), user.getGender(),
							user.getRights(), user.getCreatedBy(), user.getUserId(), user.getCreatedDate(),
							LocalDateTime.now());
					newUser.setPassword(newPass);
					userController.editUser(user, newUser);
					user = newUser;
					lblNewLabel.setText("Password changed");
				} else {
					lblNewLabel.setText("New password don't match");
				}

			} else {
				lblNewLabel.setText("Actual password you typed is not the same as actual password");
			}
		} catch (Exception e1) {
			UtilWindow.showMessage(null, e1.getMessage(), MessageType.WARNING);

		}

	}

}
