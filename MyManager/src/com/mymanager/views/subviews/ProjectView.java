package com.mymanager.views.subviews;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mymanager.controllers.UserController;
import com.mymanager.data.models.User;

public class ProjectView extends JPanel {
	private User user;
	private UserController userController;
	private JLabel label;

	/**
	 * Create the panel.
	 */
	public ProjectView(JFrame jframe) {
		setLayout(null);

		label = new JLabel("");
		label.setIcon(new ImageIcon(
				ProjectView.class.getResource("/com/mymanager/resources/icons/icons_45x45/icons8-back-arrow.png")));
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
