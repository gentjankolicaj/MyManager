package com.mymanager.views.subviews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class AccountView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3547202059282319569L;

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

	/**
	 * Create the dialog.
	 */
	public AccountView(UserController userController) {
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.userController = userController;
		this.user = userController.getUser();

		initComponents();
		initPanelEvent();
		initPasswordPanelEvent();

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

		JPanel userDetails = new JPanel();
		userDetails.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Personal details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		userDetails.setBounds(10, 11, 964, 123);
		contentPanel.add(userDetails);
		userDetails.setLayout(null);

		JLabel label = new JLabel("User ID :");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(23, 50, 60, 14);
		userDetails.add(label);

		JLabel label_1 = new JLabel("First name :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(333, 10, 75, 19);
		userDetails.add(label_1);

		JLabel label_2 = new JLabel("Last name :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(661, 11, 75, 19);
		userDetails.add(label_2);

		JLabel label_3 = new JLabel("Gender :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(23, 86, 75, 19);
		userDetails.add(label_3);

		JLabel label_4 = new JLabel("Birthplace :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(333, 47, 75, 19);
		userDetails.add(label_4);

		JLabel label_5 = new JLabel("Birthday  :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(661, 49, 75, 19);
		userDetails.add(label_5);

		JLabel label_6 = new JLabel("User type  :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(333, 87, 66, 19);
		userDetails.add(label_6);

		JLabel label_7 = new JLabel("Rights  :");
		label_7.setBounds(0, 294, 75, 19);
		userDetails.add(label_7);

		id = new JTextField();
		id.setBounds(84, 47, 218, 20);
		userDetails.add(id);
		id.setColumns(10);

		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(407, 11, 218, 20);
		userDetails.add(firstname);

		lastname = new JTextField();
		lastname.setColumns(10);
		lastname.setBounds(736, 11, 218, 20);
		userDetails.add(lastname);

		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(84, 87, 218, 20);
		userDetails.add(gender);

		birthplace = new JTextField();
		birthplace.setColumns(10);
		birthplace.setBounds(407, 48, 218, 20);
		userDetails.add(birthplace);

		birthday = new JTextField();
		birthday.setColumns(10);
		birthday.setBounds(736, 48, 218, 20);
		userDetails.add(birthday);

		usertype = new JTextField();
		usertype.setColumns(10);
		usertype.setBounds(404, 87, 221, 19);
		userDetails.add(usertype);

		JLabel lblRights = new JLabel("Rights  :");
		lblRights.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRights.setBounds(661, 89, 60, 19);
		userDetails.add(lblRights);

		rights = new JTextField();
		rights.setText((String) null);
		rights.setColumns(10);
		rights.setBounds(736, 86, 218, 20);
		userDetails.add(rights);

		passwordPanel = new JPanel();
		passwordPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Change password",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		passwordPanel.setBounds(10, 141, 961, 107);
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
		btnSavePassword.setBounds(81, 73, 89, 23);
		passwordPanel.add(btnSavePassword);

		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(404, 74, 271, 22);
		passwordPanel.add(lblNewLabel);

	}

	private void initPanelEvent() {
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblNewLabel.setText("");
			}
		});
	}

	private void initPasswordPanelEvent() {
		btnSavePassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				char[] oldPassArray = textFieldOldPassword.getPassword();
				char[] newPassArray = textFieldNewPassword.getPassword();
				char[] retypedNewPassArray = textFieldRetypePassword.getPassword();
				String oldPass = String.valueOf(oldPassArray);
				String newPass = String.valueOf(newPassArray);
				String retypedNewPass = String.valueOf(retypedNewPassArray);
				userController.changePassword(oldPass, newPass, retypedNewPass);
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

}
