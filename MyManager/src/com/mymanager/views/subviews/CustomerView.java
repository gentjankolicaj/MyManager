package com.mymanager.views.subviews;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mymanager.controllers.UserController;
import com.mymanager.data.models.User;

public class CustomerView extends JPanel {

	private User user;
	private UserController userController;

	/**
	 * Create the panel.
	 */
	public CustomerView(JFrame jframe) {
		setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				CustomerView.class.getResource("/com/mymanager/resources/icons/icons_45x45/icons8-back-arrow.png")));
		label.setBounds(10, 11, 60, 45);
		add(label);

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
	}

}
