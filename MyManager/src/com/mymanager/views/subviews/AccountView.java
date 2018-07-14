package com.mymanager.views.subviews;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mymanager.controllers.AdminController;
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

	/**
	 * Create the dialog.
	 */
	public AccountView(UserController userController) {
		this.userController = userController;
		this.user = userController.getUser();

		initComponents();
		setAccountUserDetails();
	}

	private void initComponents() {
		setTitle("My Account");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				AccountView.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-admin-2.png")));
		setBounds(100, 100, 980, 700);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel userDetails = new JPanel();
		userDetails.setBounds(0, 0, 964, 167);
		contentPanel.add(userDetails);
		userDetails.setLayout(null);

		JLabel label = new JLabel("User ID :");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 11, 60, 14);
		userDetails.add(label);

		JLabel label_1 = new JLabel("First name :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(333, 10, 75, 19);
		userDetails.add(label_1);

		JLabel label_2 = new JLabel("Last name :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(656, 9, 75, 19);
		userDetails.add(label_2);

		JLabel label_3 = new JLabel("Gender :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(10, 47, 75, 19);
		userDetails.add(label_3);

		JLabel label_4 = new JLabel("Birthplace :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(333, 47, 75, 19);
		userDetails.add(label_4);

		JLabel label_5 = new JLabel("Birthday  :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(656, 47, 75, 19);
		userDetails.add(label_5);

		JLabel label_6 = new JLabel("User type  :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(10, 85, 66, 19);
		userDetails.add(label_6);

		JLabel label_7 = new JLabel("Rights  :");
		label_7.setBounds(0, 294, 75, 19);
		userDetails.add(label_7);

		id = new JTextField();
		id.setBounds(71, 11, 218, 20);
		userDetails.add(id);
		id.setColumns(10);

		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(407, 11, 218, 20);
		userDetails.add(firstname);

		lastname = new JTextField();
		lastname.setColumns(10);
		lastname.setBounds(731, 8, 218, 20);
		userDetails.add(lastname);

		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(71, 48, 218, 20);
		userDetails.add(gender);

		birthplace = new JTextField();
		birthplace.setColumns(10);
		birthplace.setBounds(407, 48, 218, 20);
		userDetails.add(birthplace);

		birthday = new JTextField();
		birthday.setColumns(10);
		birthday.setBounds(731, 46, 218, 20);
		userDetails.add(birthday);

		usertype = new JTextField();
		usertype.setColumns(10);
		usertype.setBounds(81, 88, 218, 20);
		userDetails.add(usertype);

		JLabel lblRights = new JLabel("Rights  :");
		lblRights.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRights.setBounds(333, 88, 66, 19);
		userDetails.add(lblRights);

		rights = new JTextField();
		rights.setText((String) null);
		rights.setColumns(10);
		rights.setBounds(407, 88, 218, 20);
		userDetails.add(rights);

	}

	private void setAccountUserDetails() {
		AdminController admin = (AdminController) userController;
		user = admin.getUser(user.getUserId());
		id.setText(user.getUserId());
		firstname.setText(user.getFirstName());
		lastname.setText(user.getLastName());
		gender.setText(user.getGender().name());
		birthplace.setText(user.getBirthplace());
		birthday.setText(user.getBirthday().toString());
		usertype.setText(user.getUserType().name());
		rights.setText(user.getRights());

	}

}
