package com.mymanager.views.subviews;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mymanager.controllers.UserController;
import com.mymanager.data.models.User;

public class UserView extends JPanel {

	private User user;
	private UserController userController;

	/**
	 * Create the panel.
	 */
	public UserView(JFrame jframe) {

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
