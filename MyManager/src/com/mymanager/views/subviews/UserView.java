package com.mymanager.views.subviews;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.mymanager.controllers.UserController;
import com.mymanager.data.models.User;

public class UserView extends JPanel {

	private User user;
	private UserController userController;
	private JLabel lblBack;

	/**
	 * Create the panel.
	 */
	public UserView(JFrame jframe) {
		setBackground(UIManager.getColor("Button.background"));
		setLayout(null);

		lblBack = new JLabel("");
		lblBack.setIcon(new ImageIcon(
				UserView.class.getResource("/com/mymanager/resources/icons/icons_45x45/icons8-back-arrow.png")));
		lblBack.setBounds(10, 11, 60, 45);
		add(lblBack);

	}

	public void initEvents() {

		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
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
	}
}
